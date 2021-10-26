package com.sintrue.matrix.example.test;

import com.sintrue.matrix.example.dao.entity.StaffEntity;
import com.sintrue.matrix.example.dao.query.StaffQuery;
import com.sintrue.matrix.example.manager.StaffManager;
import liangchen.wang.matrix.framework.commons.object.NullValue;
import liangchen.wang.matrix.framework.data.annotation.EnableJdbc;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
        entity.setStaff_id(2000L);
        entity.setStaffName("2000_name");
        entity.setStaffSex("male");
        entity.setStaff_birthday(LocalDateTime.now());
        manager.insert(entity);
    }

    @Test
    public void testInsertBatch() {
        List<StaffEntity> entities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            StaffEntity entity = new StaffEntity();
            entity.setStaff_id((long) i);
            entity.setStaffName(i + "_name");
            entity.setStaffSex("male");
            if (i % 3 == 0) {
                entity.setStaffSex("female");
            }
            entity.setStaff_birthday(LocalDateTime.now());
            entities.add(entity);
        }
        manager.insertBatch(entities);
    }

    @Test
    public void update() {
        StaffEntity entity = new StaffEntity();
        entity.setStaff_id(0L);
        entity.setStaffName("0_name_0");
        // 自定义列更新
        entity.put("staff_birthday", LocalDateTime.now());
        // 置为null
        entity.put("staff_gender", NullValue.INSTANCE);
        manager.update(entity);
    }

    @Test
    public void updateByQuery() {
        StaffEntity entity = new StaffEntity();
        entity.setStaffName("0_name_1");
        StaffQuery query = new StaffQuery();
        query.setStaff_id(0L);
        query.setStaffName("name");
        query.setStaffSex("female");
        manager.update(entity, query);
    }
    @Test
    public void delete(){
        StaffEntity entity = new StaffEntity();
        entity.setStaff_id(0L);
        entity.setStaffName("xxxx");
        manager.delete(entity);;
    }

    @Test
    public void deleteByQuery(){
        StaffQuery query = new StaffQuery();
        query.setStaff_id(0L);
        query.setStaffName("xxxx");
        manager.deleteByQuery(query);;
    }

}
