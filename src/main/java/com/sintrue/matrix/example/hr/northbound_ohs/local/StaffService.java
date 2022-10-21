package com.sintrue.matrix.example.hr.northbound_ohs.local;

import com.sintrue.matrix.example.hr.domain.staff.Staff;
import com.sintrue.matrix.example.hr.domain.staff.StaffManager;
import com.sintrue.matrix.example.hr.message_pl.north.StaffRequest;
import com.sintrue.matrix.example.hr.message_pl.north.StaffResponse;
import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.commons.runtime.ReturnWrapper;
import wang.liangchen.matrix.framework.commons.validation.ValidationUtil;
import wang.liangchen.matrix.framework.ddd.northbound_ohs.ApplicationService;
import wang.liangchen.matrix.framework.web.response.FormattedResponse;

import javax.inject.Inject;
import java.text.Normalizer;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Liangchen.Wang 2022-10-11 11:27
 */
@Service
@ApplicationService
public class StaffService {
    private final StaffManager staffManager;

    @Inject
    public StaffService(StaffManager staffManager) {
        this.staffManager = staffManager;
    }

    public Staff byKey(Long staffId) {
        // 校验参数，支持国际化
        ValidationUtil.INSTANCE.notNull(staffId, "{staffId.NotBlank.message}");
        return this.staffManager.byKey(staffId);
    }

    public void add(StaffRequest staffRequest) {
        // 使用Validator校验参数,支持国际化
        ValidationUtil.INSTANCE.validate(staffRequest);
        // 对象转换
        Staff entity = Staff.valueOf(staffRequest);
        this.staffManager.add(entity);
    }
}
