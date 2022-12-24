package com.sintrue.matrix.example.test.commons;

import com.sintrue.matrix.example.entity.Staff;
import com.sintrue.matrix.example.service.staff.StaffResponse;
import org.junit.jupiter.api.Test;
import wang.liangchen.matrix.framework.commons.object.ObjectUtil;
import wang.liangchen.matrix.framework.commons.type.ClassUtil;

/**
 * @author Liangchen.Wang 2022-12-21 16:09
 */
public class CommonTest {
    @Test
    public void copyProperties() {
        Staff staff = Staff.newInstance(Staff.class,true);
        staff.setStaffName("abc");
        StaffResponse staffResponse = ObjectUtil.INSTANCE.copyProperties(staff, StaffResponse.class);
        System.out.println();
    }
}
