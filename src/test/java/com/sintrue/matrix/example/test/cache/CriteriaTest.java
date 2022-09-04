package com.sintrue.matrix.example.test.cache;

import com.sintrue.matrix.example.domain.Staff;
import org.junit.jupiter.api.Test;
import wang.liangchen.matrix.framework.data.criteria.AbstractCriteria;
import wang.liangchen.matrix.framework.data.criteria.Criteria;
import wang.liangchen.matrix.framework.data.criteria.CriteriaResolver;

/**
 * @author Liangchen.Wang 2022-09-04 9:49
 */
public class CriteriaTest {
    @Test
    public void testNew() {
        Staff staff = new Staff();
        AbstractCriteria<Staff> staffAbstractCriteria = Criteria.of(staff)
                ._equals(Staff::getStaffId, 110L)
                ._equals(Staff::getStaffId, "fdsafdf")
                ._equals(Staff::getStaffId, Staff::getCreateDate)
                ._isNull(Staff::getStaffId)
                ._startWith(Staff::getStaffId, "startWith");
        CriteriaResolver.INSTANCE.resolve(staffAbstractCriteria);
        System.out.println();
    }
}
