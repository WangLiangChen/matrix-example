package com.sintrue.matrix.example.test.cache;

import com.sintrue.matrix.example.domain.Staff;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.dao.criteria.SqlValue;

import javax.inject.Inject;

/**
 * @author Liangchen.Wang 2022-04-17 14:29
 */
@SpringBootTest
public class ExampleTests {
    @Inject
    private StandaloneDao standaloneDao;
    @Test
    public void testCount(){
        Criteria<Staff> criteria = Criteria.of(Staff.class).equals(Staff::getStaffName, SqlValue.of("name_2"));
        int count = standaloneDao.count(criteria);
        System.out.println(count);
    }
}
