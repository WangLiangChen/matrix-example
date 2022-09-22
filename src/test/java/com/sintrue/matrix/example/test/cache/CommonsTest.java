package com.sintrue.matrix.example.test.cache;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sintrue.matrix.example.domain.Staff;
import com.sintrue.matrix.example.domain.StaffState;
import com.sintrue.matrix.example.message_pl.StaffRequest;
import org.junit.jupiter.api.Test;
import wang.liangchen.matrix.framework.commons.enumeration.ConstantEnum;
import wang.liangchen.matrix.framework.commons.string.StringUtil;
import wang.liangchen.matrix.framework.commons.uid.NanoIdUtil;
import wang.liangchen.matrix.framework.commons.validation.ValidationUtil;

import java.util.ArrayList;
import java.util.List;
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
    public void testStateEnum() {

        stateEnum(StaffState.STAFF_ONLY);
    }

    private void stateEnum(ConstantEnum constantEnum) {
        System.out.println(constantEnum.getClass());
        System.out.println(constantEnum.name());
        System.out.println(constantEnum.value());
        System.out.println(ConstantEnum.valueOf("NONE"));

    }

    @Test
    public void testNanoId() {
        System.out.println(NanoIdUtil.INSTANCE.randomNanoId());
    }

    @Test
    public void testClassForName() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.sintrue.matrix.example.test.cache.ITest", true, ClassLoader.getSystemClassLoader());
        System.out.println();
    }

    @Test
    public void testJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> list = new ArrayList<String>() {{
            add("a");
            add("b");
        }};
        System.out.println(objectMapper.writeValueAsString(list));
    }

    @Test
    public void testMethodAccess() {
        //1 创建一个初始化属性的实例
        Staff staff = Staff.newInstance(Staff.class, true);

        //2 创建实例后初始化属性
        staff = new Staff();
        staff.initializeFields();
        System.out.println();
    }
}
