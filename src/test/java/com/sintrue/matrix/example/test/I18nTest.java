package com.sintrue.matrix.example.test;

import com.sintrue.matrix.example.hr.message_pl.north.admin.StaffAdminRequest;
import org.junit.jupiter.api.Test;
import wang.liangchen.matrix.framework.commons.validation.ValidationUtil;

/**
 * @author Liangchen.Wang 2022-10-12 8:36
 */
//@SpringBootTest
public class I18nTest {
    @Test
    public void testValidator() {
        StaffAdminRequest staffAdminRequest = new StaffAdminRequest();
        //ValidationUtil.INSTANCE.setLocale(Locale.CHINA);
        ValidationUtil.INSTANCE.validate(staffAdminRequest);
    }
    @Test
    public void testValidateCondition() {
        // ValidationUtil.INSTANCE.setLocale(Locale.ENGLISH);
        ValidationUtil.INSTANCE.isFalse(true,"{staffId.NotBlank.message}");
    }
    @Test
    public void testDefaultMessage(){
        // ValidationUtil.INSTANCE.setLocale(Locale.ENGLISH);
        ValidationUtil.INSTANCE.isFalse(true,"{ParameterNotBlank}");
    }
}
