package com.sintrue.matrix.example.test;

import com.sintrue.matrix.example.entity.Staff;
import com.sintrue.matrix.example.entity.StaffState;
import com.sintrue.matrix.example.service.staff.StaffCommandRequest;
import com.sintrue.matrix.example.service.staff.StaffResponse;
import com.sintrue.matrix.example.service.staff.StaffService;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import wang.liangchen.matrix.framework.commons.exception.MatrixErrorException;
import wang.liangchen.matrix.framework.commons.object.ObjectUtil;
import wang.liangchen.matrix.framework.commons.random.RandomUtil;
import wang.liangchen.matrix.framework.commons.type.ClassUtil;
import wang.liangchen.matrix.framework.commons.validation.ValidationUtil;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.data.dao.entity.JsonField;
import wang.liangchen.matrix.framework.data.enumeration.StateEnum;
import wang.liangchen.matrix.framework.data.pagination.PaginationResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/**
 * @author Liangchen.Wang 2022-12-09 21:41
 */
@SpringBootTest
public class StaffTest {
    @Inject
    private StaffService staffService;
    @Inject
    private StandaloneDao standaloneDao;
    @Inject
    private Map<String, Executor> executorMap;
    @Inject
    private ApplicationContext applicationContext;

    @Test
    public void testException() {
        try{
            ValidationUtil.INSTANCE.throwException(NullPointerException.class,"{staffId.NotBlank.message}");
        }catch (Exception e){

            System.out.println();
        }
    }

    @Test
    public void insert() {
        StaffCommandRequest staffCommandRequest = new StaffCommandRequest();
        staffCommandRequest.setStaffName("wanglc_" + RandomUtil.INSTANCE.random(1, 100));
        staffCommandRequest.setSummary("insert test");
        // Json Settings
        JsonField staffSettings = JsonField.newInstance().fluentPut("gender", "male");
        staffCommandRequest.setStaffSettings(staffSettings);

        StaffResponse staffResponse = staffService.insert(staffCommandRequest);
        System.out.println();
    }

    @Test
    public void insertBulk() {
        List<StaffCommandRequest> staffCommandRequests = new ArrayList<StaffCommandRequest>() {{
            // first element
            StaffCommandRequest staffCommandRequest = new StaffCommandRequest();
            staffCommandRequest.setStaffName("wanglc_" + RandomUtil.INSTANCE.random(1, 100));
            staffCommandRequest.setSummary("insert first");
            // Json Settings
            JsonField staffSettings = JsonField.newInstance().fluentPut("gender", "male");
            staffCommandRequest.setStaffSettings(staffSettings);
            // State
            add(staffCommandRequest);
            // second element
            staffCommandRequest = new StaffCommandRequest();
            staffCommandRequest.setStaffName("wanglc_" + RandomUtil.INSTANCE.random(1, 100));
            staffCommandRequest.setSummary("insert second");
            // Json Settings
            staffSettings = JsonField.newInstance().fluentPut("gender", "female");
            staffCommandRequest.setStaffSettings(staffSettings);
            // State
            add(staffCommandRequest);
        }};
        staffService.insertBulk(staffCommandRequests);
    }

    @Test
    public void list() {
        List<StaffResponse> list = staffService.list(StaffState.NORMAL, StaffState.DELETED);
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
