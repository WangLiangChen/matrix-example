package com.sintrue.matrix.example.test;

import com.sintrue.matrix.example.dao.entity.StaffEntity;
import com.sintrue.matrix.example.manager.StaffManager;
import liangchen.wang.matrix.framework.data.annotation.EnableJdbc;
import liangchen.wang.matrix.framework.data.dao.StandaloneCommandDao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author Liangchen.Wang 2021-10-19 16:57
 */
@SpringBootTest
@EnableJdbc
public class StaffTest {
    @Resource
    private StaffManager manager;

    @Test
    public void testInsert() {
        StaffEntity entity = new StaffEntity();
        entity.setStaff_id(1000L);
        entity.setStaff_name("1000_name");
        entity.setStaff_birthday(LocalDateTime.now());
        manager.insert(entity);
    }

    @Test
    public void testInsertBatch() {
        List<StaffEntity> entities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            StaffEntity entity = new StaffEntity();
            entity.setStaff_id((long) i);
            entity.setStaff_name(i + "_name");
            entity.setStaff_birthday(LocalDateTime.now());
            entities.add(entity);
        }
        manager.insertBatch(entities);
    }

    @Test
    public void testDelete() {
        StaffEntity entity = new StaffEntity();
        entity.setStaff_id(1000L);
        manager.delete(entity);
    }
}
