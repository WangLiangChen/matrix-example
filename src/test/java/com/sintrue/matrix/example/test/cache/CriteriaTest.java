package com.sintrue.matrix.example.test.cache;

import com.sintrue.matrix.example.domain.Staff;
import org.junit.jupiter.api.Test;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.dao.criteria.CriteriaResolver;

/**
 * @author Liangchen.Wang 2022-09-04 9:49
 */
public class CriteriaTest {
    @Test
    public void testNew() {
        Staff staff = new Staff();
        Criteria<Staff> staffAbstractCriteria = Criteria.of(staff)
                ._equals(Staff::getStaffText)
                ._equals(Staff::getCreateDatetime, Staff::getCreateDate)
                ._equals(Staff::getStaffId, 100L)
                ._in(Staff::getStaffId, 1, 2, '3')
                ._between(Staff::getStaffId, Staff::getCreateDate, Staff::getCreateDatetime)
                ._between(Staff::getStaffId, 5, 6)
                ._isNull(Staff::getState)
                ._contains(Staff::getStaffText, "contains")
                ._startWith(Staff::getStaffText, "startWith")
                ._endWith(Staff::getStaffText, "endWith");

        CriteriaResolver.INSTANCE.resolve(staffAbstractCriteria);
        System.out.println();
    }
}
