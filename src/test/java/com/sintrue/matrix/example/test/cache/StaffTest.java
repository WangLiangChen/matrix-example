package com.sintrue.matrix.example.test.cache;

import com.sintrue.matrix.example.Staff;
import com.sintrue.matrix.example.State;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.dao.criteria.SqlValue;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Liangchen.Wang 2022-08-31 22:55
 */
@SpringBootTest
public class StaffTest {
    @Inject
    private StandaloneDao standaloneDao;

    @Test
    public void testInsert() {
        Staff staff = new Staff();
        staff.setStaffId(16L);
        staff.setStaffText("staff15");
        staff.setCreateDatetime(LocalDateTime.now());
        staff.setCreateDate(LocalDate.now());
        State state = new State();
        state.setState_id(200L);
        staff.setState(state);
        standaloneDao.insert(staff);
    }

    @Test
    public void testSelect() {
        Staff select = standaloneDao.select(Criteria.of(Staff.class)._equals(Staff::getStaffId, SqlValue.of(15L)));
        System.out.println(select.getStaffId());
    }
}
