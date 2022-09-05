package com.sintrue.matrix.example.test.cache;

import com.sintrue.matrix.example.State;
import com.sintrue.matrix.example.domain.Staff;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;

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
        Staff staff = new Staff();
        staff.setStaffId(438292558515316842L);
        Staff select = standaloneDao.select(Criteria.of(staff)
                ._equals(Staff::getStaffId)
                ._contains(Staff::getStaffText, "staffx"));
        System.out.println();
    }
}
