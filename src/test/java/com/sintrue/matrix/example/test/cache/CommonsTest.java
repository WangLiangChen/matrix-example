package com.sintrue.matrix.example.test.cache;

import com.sintrue.matrix.example.domain.StaffState;
import com.sintrue.matrix.example.message_pl.StaffRequest;
import org.junit.jupiter.api.Test;
import wang.liangchen.matrix.framework.commons.enumeration.CommonEnum;
import wang.liangchen.matrix.framework.commons.string.StringUtil;
import wang.liangchen.matrix.framework.commons.validation.ValidationUtil;

import java.util.Locale;

/**
 * @author Liangchen.Wang 2022-09-09 9:32
 */
public class CommonsTest {
    @Test
    public void testcamelCase() {
        String string = "StaffNameId";
        System.out.println(StringUtil.INSTANCE.camelCase2underline(string));
        string = "staff_name_id";
        System.out.println(StringUtil.INSTANCE.underline2UpperCamelCase(string));
        System.out.println(StringUtil.INSTANCE.underline2lowerCamelCase(string));
    }

    @Test
    public void testValidator() {
        StaffRequest staff = new StaffRequest();
        ValidationUtil.INSTANCE.setLocale(Locale.ENGLISH);
        try {
            ValidationUtil.INSTANCE.validate(staff);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ValidationUtil.INSTANCE.setLocale(Locale.CHINA);
        try {
            ValidationUtil.INSTANCE.validate(staff);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ValidationUtil.INSTANCE.setLocale(Locale.JAPAN);
        try {
            ValidationUtil.INSTANCE.validate(staff);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testStateEnum(){

        stateEnum(StaffState.NONE);
    }
    private void stateEnum(CommonEnum commonEnum){
        System.out.println(commonEnum.getClass());
        System.out.println(commonEnum.name());
        System.out.println(commonEnum.value());
        System.out.println(CommonEnum.valueOf("NONE"));

    }


}
