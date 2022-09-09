package com.sintrue.matrix.example.test.cache;

import org.junit.jupiter.api.Test;
import wang.liangchen.matrix.framework.commons.string.StringUtil;

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
}
