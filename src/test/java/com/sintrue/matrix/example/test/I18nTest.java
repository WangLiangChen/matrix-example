package com.sintrue.matrix.example.test;

import com.sintrue.matrix.example.hr.message_pl.north.StaffRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.LocaleResolver;
import wang.liangchen.matrix.framework.commons.validation.ValidationUtil;

import javax.inject.Inject;
import java.util.Locale;

/**
 * @author Liangchen.Wang 2022-10-12 8:36
 */
//@SpringBootTest
public class I18nTest {
    @Test
    public void testValidator() {
        StaffRequest staffRequest = new StaffRequest();
        //ValidationUtil.INSTANCE.setLocale(Locale.CHINA);
        ValidationUtil.INSTANCE.validate(staffRequest);
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
