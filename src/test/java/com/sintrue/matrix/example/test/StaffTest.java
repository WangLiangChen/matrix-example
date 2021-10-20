package com.sintrue.matrix.example.test;

import com.sintrue.matrix.example.dao.entity.StaffEntity;
import com.sintrue.matrix.example.manager.StaffManager;
import liangchen.wang.matrix.framework.data.annotation.EnableJdbc;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author Liangchen.Wang 2021-10-19 16:57
 */
@SpringBootTest
@EnableJdbc
public class StaffTest {
    @Resource
    private StaffManager manager;

    @Test
    public void insert() {
        StaffEntity staff = new StaffEntity();
        staff.setStaff_id(0L);
        staff.setStaff_name("0_name");
        staff.setStaff_birthday(LocalDateTime.now());
        manager.insert(staff);
    }

    @Test
    public void find() {
        StaffEntity staff = manager.find(0L);
    }
}
