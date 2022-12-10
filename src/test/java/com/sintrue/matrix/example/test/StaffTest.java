package com.sintrue.matrix.example.test;

import com.sintrue.matrix.example.entity.StaffSettings;
import com.sintrue.matrix.example.service.staff.StaffCommandRequest;
import com.sintrue.matrix.example.service.staff.StaffResponse;
import com.sintrue.matrix.example.service.staff.StaffService;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.commons.random.RandomUtil;
import wang.liangchen.matrix.framework.data.pagination.PaginationResult;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Liangchen.Wang 2022-12-09 21:41
 */
@SpringBootTest
public class StaffTest {
    @Inject
    private StaffService staffService;

    @Test
    public void insert() {
        StaffCommandRequest staffCommandRequest = new StaffCommandRequest();
        staffCommandRequest.setStaffName("wanglc_" + RandomUtil.INSTANCE.random(1, 100));
        staffCommandRequest.setSummary("insert test");

        StaffSettings staffSettings = new StaffSettings();
        staffSettings.setGender("MALE");
        staffSettings.setBirthday(LocalDateTime.now());
        staffCommandRequest.setStaffSettings(staffSettings);
        StaffResponse staffResponse = staffService.insert(staffCommandRequest);
        System.out.println();
    }

    @Test
    public void list() {
        List<StaffResponse> list = staffService.list();
        System.out.println();
    }

    @Test
    public void pagination() {
        PaginationResult<StaffResponse> pagination = staffService.pagination();
        System.out.println();
    }

    @Test
    public void delete() {
        Long staffId = 452539965260169475L;
        staffService.delete(staffId);
    }

    @Test
    public void updateById() {
        StaffCommandRequest staffCommandRequest = new StaffCommandRequest();
        staffCommandRequest.setStaffName("new name");
        staffService.updateById(0L, staffCommandRequest);
    }
}
