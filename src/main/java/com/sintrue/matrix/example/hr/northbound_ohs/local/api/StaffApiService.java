package com.sintrue.matrix.example.hr.northbound_ohs.local.api;

import com.sintrue.matrix.example.hr.domain.staff.Staff;
import com.sintrue.matrix.example.hr.domain.staff.StaffManager;
import com.sintrue.matrix.example.hr.message_pl.north.admin.StaffAdminRequest;
import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.commons.validation.ValidationUtil;
import wang.liangchen.matrix.framework.ddd.northbound_ohs.ApplicationService;

import javax.inject.Inject;

/**
 * @author Liangchen.Wang 2022-10-11 11:27
 */
@Service
@ApplicationService
public class StaffApiService {
    private final StaffManager staffManager;

    @Inject
    public StaffApiService(StaffManager staffManager) {
        this.staffManager = staffManager;
    }

    public Staff byKey(Long staffId) {
        // 校验参数，支持国际化
        ValidationUtil.INSTANCE.notNull(staffId, "{staffId.NotBlank.message}");
        return this.staffManager.byKey(staffId);
    }

    public void add(StaffAdminRequest staffAdminRequest) {
        // 使用Validator校验参数,支持国际化
        ValidationUtil.INSTANCE.validate(staffAdminRequest);
        // 对象转换
        Staff entity = Staff.valueOf(staffAdminRequest);
        this.staffManager.add(entity);
    }
}
