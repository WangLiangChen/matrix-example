package com.sintrue.matrix.example.test.cache;

import com.sintrue.matrix.example.domain.Settings;
import com.sintrue.matrix.example.domain.Staff;
import com.sintrue.matrix.example.domain.StateEnum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.pagination.OrderByDirection;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Liangchen.Wang 2022-08-31 22:55
 */
@SpringBootTest
public class StaffDaoTest {
    @Inject
    private StandaloneDao standaloneDao;

    @Test
    public void testInsert() {
        Staff staff = new Staff();
        staff.setStaffText("staff15");
        staff.setCreateDatetime(LocalDateTime.now());
        staff.setCreateDate(LocalDate.now());
        staff.setState(StateEnum.NORMAL);
        staff.setSettings(new Settings("male", LocalDate.of(2000, 1, 1)));
        standaloneDao.insert(staff);
    }

    @Test
    public void testSelectWithClass() {
        Staff staff = standaloneDao.select(Criteria.of(Staff.class)
                ._equals(Staff::getStaffId, Staff::getStaffId)
                ._equals(Staff::getStaffId, 438764791394248808L)
                ._startWith(Staff::getStaffText, "staff")
                ._contains(Staff::getStaffText, "staff")
                ._between(Staff::getCreateDate, LocalDate.MIN, LocalDate.MAX)
                ._in(Staff::getState, StateEnum.NORMAL, StateEnum.DELETED)
                ._isNotNull(Staff::getCreateDatetime)
                ._greaterThan(Staff::getCreateDatetime, LocalDateTime.MIN)
        );
        System.out.println();
    }

    @Test
    public void testSelectWithObject() {
        Staff param = new Staff();
        param.setStaffId(438764791394248808L);

        Staff staff = standaloneDao.select(Criteria.of(param)
                // * 取对象的属性值比较
                ._equals(Staff::getStaffId)
                // * 两个列比较
                ._equals(Staff::getStaffId, Staff::getStaffId)
                ._startWith(Staff::getStaffText, "staff")
                ._contains(Staff::getStaffText, "staff")
                ._between(Staff::getCreateDate, LocalDate.MIN, LocalDate.MAX)
                ._in(Staff::getState, StateEnum.NORMAL, StateEnum.DELETED)
                ._isNotNull(Staff::getCreateDatetime)
                ._greaterThan(Staff::getCreateDatetime, LocalDateTime.MIN)
                // * 指定返回的列
                .resultFields(Staff::getStaffId, Staff::getStaffText, Staff::getSettings)
        );
        System.out.println();
    }

    @Test
    public void testPagination() {
        standaloneDao.pagination(Criteria.of(Staff.class)
                ._startWith(Staff::getStaffText, "staff")
                // 分页
                .pageNumber(1).pageSize(5)
                // 排序
                .orderBy(Staff::getCreateDatetime, OrderByDirection.asc)
                .orderBy(Staff::getCreateDate, OrderByDirection.desc)
        );
    }

}
