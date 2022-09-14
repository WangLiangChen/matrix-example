package com.sintrue.matrix.example.test.cache;

import com.sintrue.matrix.example.domain.Staff;
import com.sintrue.matrix.example.message_pl.StaffRequest;
import org.junit.jupiter.api.Test;
import wang.liangchen.matrix.framework.commons.string.StringUtil;
import wang.liangchen.matrix.framework.commons.validation.ValidationUtil;

/**
 * @author Liangchen.Wang 2022-09-09 9:32
 */
public class CommonsTest {
    @Test
    public void testcamelCase(){
        String string="StaffNameId";
        System.out.println(StringUtil.INSTANCE.camelCase2underline(string));
        string="staff_name_id";
        System.out.println(StringUtil.INSTANCE.underline2UpperCamelCase(string));
        System.out.println(StringUtil.INSTANCE.underline2lowerCamelCase(string));
    }
    @Test
    public void testValidator(){
        StaffRequest staff = new StaffRequest();
        ValidationUtil.INSTANCE.validate(staff);
    }
}
