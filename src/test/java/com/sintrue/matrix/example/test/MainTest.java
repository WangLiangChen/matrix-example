package com.sintrue.matrix.example.test;

import com.sintrue.matrix.example.dao.entity.StaffEntity;
import liangchen.wang.matrix.framework.commons.object.ClassUtil;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Liangchen.Wang 2021-10-22 13:34
 */
public class MainTest {
    @Test
    public void testFields() {
        Set<Field> fields = ClassUtil.INSTANCE.fields(StaffEntity.class);
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }

    @Test
    public void testAllFields() {
        Set<Field> fields = ClassUtil.INSTANCE.fields(StaffEntity.class, true, field -> {
            if (Modifier.isTransient(field.getModifiers())) {
                return false;
            }
            return true;
        });
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }
}
