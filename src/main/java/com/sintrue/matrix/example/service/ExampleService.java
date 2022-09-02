package com.sintrue.matrix.example.service;

import com.sintrue.matrix.example.State;
import com.sintrue.matrix.example.domain.ExampleManager;
import com.sintrue.matrix.example.domain.Staff;
import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.commons.object.ObjectUtil;
import wang.liangchen.matrix.framework.data.pagination.PaginationResult;
import wang.liangchen.matrix.framework.ddd.northbound_ohs.ApplicationService;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Liangchen.Wang 2022-09-02 14:48
 */
@Service
@ApplicationService
public class ExampleService {
    private final ExampleManager exampleManager;

    @Inject
    public ExampleService(ExampleManager exampleManager) {
        this.exampleManager = exampleManager;
    }

    public void add(StaffRequest staffRequest) {
        // 对象转换
        Staff staff = Staff.valueOf(staffRequest);
        // 其它赋值
        staff.setCreateDate(LocalDate.now());
        staff.setCreateDatetime(LocalDateTime.now());
        // Json
        State state = new State();
        state.setState_id(100L);
        staff.setState(state);
        exampleManager.add(staff);
    }

    public PaginationResult<StaffResponse> pagination(StaffRequest staffRequest) {
        PaginationResult<Staff> pagination = exampleManager.pagination(staffRequest);
        // 对象转换
        return pagination.to(StaffResponse.class);
    }

    public List<StaffResponse> list(StaffRequest staffRequest) {
        List<Staff> list = exampleManager.list(staffRequest);
        // 集合转换
        return ObjectUtil.INSTANCE.copyProperties(list, StaffResponse.class);
    }

    public StaffResponse find(Long staffId) {
        Staff staff = exampleManager.find(staffId);
        if (null == staff) {
            return null;
        }
        // 对象转换
        return staff.to(StaffResponse.class);
    }


}
