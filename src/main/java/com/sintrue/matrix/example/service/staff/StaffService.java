package com.sintrue.matrix.example.service.staff;

import com.sintrue.matrix.example.entity.Staff;
import com.sintrue.matrix.example.entity.StaffState;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.commons.exception.MatrixInfoException;
import wang.liangchen.matrix.framework.commons.object.ObjectUtil;
import wang.liangchen.matrix.framework.commons.validation.ValidationUtil;
import wang.liangchen.matrix.framework.data.annotation.DataSourceAssign;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.dao.criteria.DeleteCriteria;
import wang.liangchen.matrix.framework.data.dao.criteria.UpdateCriteria;
import wang.liangchen.matrix.framework.data.pagination.OrderByDirection;
import wang.liangchen.matrix.framework.data.pagination.PaginationResult;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

/**
 * @author Liangchen.Wang 2022-12-09 21:19
 */
@Service
public class StaffService {
    private final StandaloneDao standaloneDao;

    @Inject
    public StaffService(StandaloneDao standaloneDao) {
        // 校验后赋值
        this.standaloneDao = ValidationUtil.INSTANCE.notNull(standaloneDao);
    }

    // 动态切换数据源-支持嵌套
    @DataSourceAssign("primary")
    public StaffResponse insert(StaffCommandRequest staffCommandRequest) {
        // 校验工具-多语言支持-校验类和属性
        ValidationUtil.INSTANCE.validate(staffCommandRequest);
        // 对象转换 toEntity
        Staff staff = Staff.valueOf(staffCommandRequest, Staff.class);
        staff.setState(StaffState.NORMAL);

        // 初始化未赋值的属性
        staff.initializeFields();
        this.standaloneDao.insert(staff);
        // 对象转换
        return staff.to(StaffResponse.class);
    }

    public int insertBulk(Collection<StaffCommandRequest> staffCommandRequests) {
        // 集合对象转换+函数式过程处理
        List<Staff> staffs = ObjectUtil.INSTANCE.copyProperties(staffCommandRequests, Staff.class, (S, T) -> {
            T.initializeFields();
        });
        return this.standaloneDao.insert(staffs);
    }

    public int delete(Long staffId) {
        // 逻辑删除
        DeleteCriteria<Staff> criteria = DeleteCriteria.of(Staff.class)
                .markDelete(Staff::getState, null)
                ._equals(Staff::getStaffId, staffId);
        return this.standaloneDao.delete(criteria);
    }

    public StaffResponse anyOne() {
        Criteria<Staff> criteria = Criteria.of(Staff.class)
                // 指定返回的列 .resultColumns("staff_id","staff_name","staff_settings")
                .resultFields(Staff::getStaffId, Staff::getStaffName, Staff::getStaffSettings, Staff::getCreator, Staff::getCreateDatetime, Staff::getState);
        List<Staff> staffList = standaloneDao.list(criteria);
        Optional<Staff> any = staffList.stream().findAny();
        Staff staff = any.orElseThrow();
        // 类型转换
        return staff.to(StaffResponse.class);
    }

    public List<StaffResponse> list() {
        Staff staff = new Staff();
        staff.setStaffId(0L);
        Criteria<Staff> criteria = Criteria.of(staff)
                // 指定返回的列 .resultColumns("staff_id","staff_name","staff_settings")
                .resultFields(Staff::getStaffId, Staff::getStaffName, Staff::getStaffSettings, Staff::getCreator, Staff::getCreateDatetime, Staff::getState)
                // 特殊场景
                // .distinct().forUpdate().disableCache()
                // 构造查询条件
                ._startWith(Staff::getStaffName, "wanglc")
                ._lessThan(Staff::getCreateDatetime, LocalDateTime.MAX)
                ._equals(Staff::getStaffId)
                .orderBy(Staff::getCreateDatetime, OrderByDirection.asc)
                .pageSize(5);
        List<Staff> staffs = this.standaloneDao.list(criteria);
        // 集合对象转换
        return ObjectUtil.INSTANCE.copyProperties(staffs, StaffResponse.class);
    }

    public PaginationResult<StaffResponse> pagination() {
        Criteria<Staff> criteria = Criteria.of(Staff.class)
                // 指定返回的列 .resultColumns("staff_id","staff_name","staff_settings")
                .resultFields(Staff::getStaffId, Staff::getStaffName, Staff::getStaffSettings, Staff::getCreator, Staff::getCreateDatetime, Staff::getState)
                // 特殊场景
                // .distinct().forUpdate().disableCache()
                // 构造查询条件
                ._startWith(Staff::getStaffName, "wanglc")
                ._lessThan(Staff::getCreateDatetime, LocalDateTime.MAX)
                .pageSize(2).pageNumber(1);
        PaginationResult<Staff> pagination = this.standaloneDao.pagination(criteria);
        // 对象转换
        return pagination.to(StaffResponse.class);
    }


    public int updateById(Long staffId, StaffCommandRequest staffCommandRequest) {
        // 对象转换
        Staff staff = Staff.valueOf(staffCommandRequest, Staff.class);
        staff.setStaffId(staffId);
        // 默认有值更新
        // 增加强制更新列，比如更新成null
        staff.addForceUpdateField(Staff::getSummary, null);
        // staff.addForceUpdateColumn("summary",null);

        // 乐观锁
        staff.setVersion(10);
        return this.standaloneDao.update(staff);
    }

    public int update(StaffCommandRequest staffCommandRequest) {
        // 对象转换
        Staff staff = Staff.valueOf(staffCommandRequest, Staff.class);
        UpdateCriteria<Staff> criteria = UpdateCriteria.of(staff)
                // 强制更新列
                .forceUpdate(Staff::getSummary, null)
                ._equals(Staff::getCreator, "creator");
        return this.standaloneDao.update(criteria);
    }


}
