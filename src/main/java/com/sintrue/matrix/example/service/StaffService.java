package com.sintrue.matrix.example.service;


import com.sintrue.matrix.example.domain.Staff;
import com.sintrue.matrix.example.domain.StateEnum;
import com.sintrue.matrix.example.message_pl.StaffRequest;
import com.sintrue.matrix.example.message_pl.StaffResponse;
import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.commons.exception.Assert;
import wang.liangchen.matrix.framework.commons.object.ObjectUtil;
import wang.liangchen.matrix.framework.commons.validation.ValidationUtil;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.dao.criteria.UpdateCriteria;
import wang.liangchen.matrix.framework.ddd.northbound_ohs.ApplicationService;

import javax.inject.Inject;
import java.util.Collection;
import java.util.List;

/**
 * @author Liangchen.Wang 2022-09-02 14:48
 */
@Service
@ApplicationService
public class StaffService {
    private final StandaloneDao standaloneDao;

    @Inject
    public StaffService(StandaloneDao standaloneDao) {
        this.standaloneDao = standaloneDao;
    }

    public int insert(StaffRequest staffRequest) {
        // 对象和属性校验
        ValidationUtil.INSTANCE.validate(staffRequest);
        // 对象转换
        Staff entity = Staff.valueOf(staffRequest);
        return standaloneDao.insert(entity);
    }

    public int insertBulk(Collection<StaffRequest> staffRequests) {
        // 对象校验
        Assert.INSTANCE.notEmpty(staffRequests);
        // 对象集合转换
        List<Staff> entities = ObjectUtil.INSTANCE.copyProperties(staffRequests, Staff.class);
        return standaloneDao.insert(entities);
    }

    public StaffResponse select(Long staffId) {
        Staff entity = standaloneDao.select(Criteria.of(Staff.class)._equals(Staff::getStaffId, staffId));
        if (null == entity) {
            return null;
        }
        // 对象转换
        return entity.to(StaffResponse.class);
    }

    /**
     * 状态迁移
     * 状态只能从一个或多个状态迁移到一个状态
     * 不能直接修改状态
     *
     * @param staffId pk
     * @param to      post
     * @param from    pre
     */
    public void stateTransition(String staffId, StateEnum to, StateEnum... from) {
        Staff entity = new Staff();
        entity.setState(to);

        UpdateCriteria<Staff> updateCriteria = UpdateCriteria.of(entity)
                ._equals(Staff::getStaffId, staffId)
                ._in(Staff::getState, from);
        standaloneDao.update(updateCriteria);
    }

}
