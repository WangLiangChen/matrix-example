package com.sintrue.matrix.example.test.cache;

import com.sintrue.matrix.example.domain.Staff;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.dao.criteria.SqlValue;
import wang.liangchen.matrix.framework.data.dao.criteria.SubCriteria;
import wang.liangchen.matrix.framework.data.dao.criteria.UpdateCriteria;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Liangchen.Wang 2022-04-17 14:29
 */
@SpringBootTest
public class ExampleTests {
    @Inject
    private StandaloneDao standaloneDao;

    @Test
    public void testInsert() {
        Staff staff = new Staff();
        staff.setStaff_id(123L);
        staff.setStaffName("name123");
        staff.setStaff_sex("male");
        staff.setStaff_birthday(LocalDate.now());
        int count = standaloneDao.insert(staff);
        System.out.println(count);
    }

    @Test
    public void testInsertBatch() {
        List<Staff> entities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Staff staff = new Staff();
            staff.setStaff_id((long) i);
            staff.setStaffName("name" + i);
            staff.setStaff_sex("male" + i);
            staff.setStaff_birthday(LocalDate.now().minusDays(i));
            entities.add(staff);
        }
        int count = standaloneDao.insert(entities);
        System.out.println(count);
    }

    @Test
    public void testUpdate() {
        Staff staff = new Staff();
        UpdateCriteria.of(staff).equals(Staff::getStaff_id, SqlValue.of("abc"));
    }

    @Test
    public void testCount() {
        Criteria<Staff> criteria = Criteria.of(Staff.class).equals(Staff::getStaffName, SqlValue.of("name_2"));
        int count = standaloneDao.count(criteria);
        System.out.println(count);
    }

    @Test
    public void testList() {
        Criteria<Staff> criteria = Criteria.of(Staff.class).
                equals(Staff::getStaffName, SqlValue.of("name_2"))
                .equals(Staff::getStaff_id, SqlValue.of(123L))
                .OR(SubCriteria.of(Staff.class).equals(Staff::getStaff_id,SqlValue.of("fff")))
                ;


        List<Staff> list = standaloneDao.list(criteria);
        list.forEach(System.out::println);

    }
}
