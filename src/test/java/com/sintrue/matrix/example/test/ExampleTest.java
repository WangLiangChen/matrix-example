package com.sintrue.matrix.example.test;

import com.sintrue.matrix.example.seckill.domain.Commodity;
import org.junit.jupiter.api.Test;
import wang.liangchen.matrix.framework.commons.object.EnhancedObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liangchen.Wang 2022-06-30 9:18
 */
public class ExampleTest {
    @Test
    public void testSuperClasses() {
        List<Class<?>> container = populateSuperClasses(Commodity.class);
        System.out.println(container);
    }

    private List<Class<?>> populateSuperClasses(final Class<?> clazz) {
        List<Class<?>> container = new ArrayList<>();
        Class<?> currentClass = clazz;
        while (Object.class != currentClass) {
            container.add(currentClass);
            currentClass = currentClass.getSuperclass();
        }
        return container;
    }
}
