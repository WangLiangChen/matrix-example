package com.sintrue.matrix.example.service.staff;

import com.sintrue.matrix.example.entity.Staff;
import com.sintrue.matrix.example.entity.StaffState;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.commons.object.ObjectUtil;
import wang.liangchen.matrix.framework.commons.validation.ValidationUtil;
import wang.liangchen.matrix.framework.data.annotation.DataSourceAssign;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.dao.criteria.DeleteCriteria;
import wang.liangchen.matrix.framework.data.dao.criteria.UpdateCriteria;
import wang.liangchen.matrix.framework.data.pagination.PaginationResult;

import java.time.LocalDateTime;
import java.util.List;

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
        // 校验工具-多语言支持
        ValidationUtil.INSTANCE.notNull(staffCommandRequest);
        // 对象转换
        Staff staff = Staff.valueOf(staffCommandRequest, Staff.class);
        // 状态枚举
        staff.setState(StaffState.NORMAL);
        // 初始化未赋值的属性
        staff.initializeFields();
        this.standaloneDao.insert(staff);
        // 对象转换
        return staff.to(StaffResponse.class);
    }

    public int insertBulk(List<Staff> staffs) {
        return this.standaloneDao.insert(staffs);
    }

    public List<StaffResponse> list() {
        Criteria<Staff> criteria = Criteria.of(Staff.class)
                // 指定返回的列 .resultColumns("staff_id","staff_name","staff_settings")
                .resultFields(Staff::getStaffId, Staff::getStaffName, Staff::getStaffSettings)
                // 特殊场景
                // .distinct().forUpdate()
                // 构造查询条件
                ._startWith(Staff::getStaffName, "wanglc")
                ._lessThan(Staff::getCreateDatetime, LocalDateTime.MAX)
                .pageSize(5);
        List<Staff> staffs = this.standaloneDao.list(criteria);
        // 集合对象转换
        return ObjectUtil.INSTANCE.copyProperties(staffs, StaffResponse.class);
    }

    public PaginationResult<StaffResponse> pagination() {
        Criteria<Staff> criteria = Criteria.of(Staff.class)
                // 指定返回的列 .resultColumns("staff_id","staff_name","staff_settings")
                .resultFields(Staff::getStaffId, Staff::getStaffName, Staff::getStaffSettings)
                // 特殊场景
                // .distinct().forUpdate()
                // 构造查询条件
                ._startWith(Staff::getStaffName, "wanglc")
                ._lessThan(Staff::getCreateDatetime, LocalDateTime.MAX)
                .pageSize(5).pageNumber(1);
        PaginationResult<Staff> pagination = this.standaloneDao.pagination(criteria);
        // 对象转换
        return pagination.to(StaffResponse.class);
    }

    public int delete(Long staffId) {
        DeleteCriteria<Staff> criteria = DeleteCriteria.of(Staff.class)._equals(Staff::getStaffId, staffId);
        return this.standaloneDao.delete(criteria);
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
