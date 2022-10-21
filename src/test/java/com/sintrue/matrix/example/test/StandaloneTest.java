package com.sintrue.matrix.example.test;

import com.sintrue.matrix.example.hr.domain.staff.Staff;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;

import javax.inject.Inject;

/**
 * @author Liangchen.Wang 2022-10-14 9:13
 */
@SpringBootTest
public class StandaloneTest {
    @Inject
    private StandaloneDao standaloneDao;

    @Test
    public void testUpdate() {
        Staff entity = Staff.newInstance();
        // 设置主键
        entity.setStaffId(100L);
        // 设置版本, 启用乐观锁
        //entity.setVersion(10);
        entity.setCreator("creator");
        // 设置强制更新
        entity.addForceUpdateField(Staff::getCreator, "newCreator");
        int rows = standaloneDao.update(entity);
    }

    @Test
    public void testDelete() {
        Staff entity = Staff.newInstance();
        // 设置主键
        entity.setStaffId(100L);
        // 设置版本，启用乐观锁
        //entity.setVersion(10);
        standaloneDao.delete(entity);
    }
}
