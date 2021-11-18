package com.sintrue.matrix.example.test.cache;

import com.sintrue.matrix.example.manager.StaffManager;
import com.sintrue.matrix.example.manager.domain.StaffDomain;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.Async;
import wang.liangchen.matrix.framework.springboot.context.BeanLoader;

import javax.inject.Inject;
import java.util.Map;
import java.util.concurrent.Executor;

@SpringBootTest
public class CacheTest {
    @Inject
    private StaffManager staffManager;

    @Test
    public void findStaff(){
        staffManager.find(0L);
        staffManager.find(0L);
        staffManager.find(0L);
        staffManager.find(0L);
        staffManager.find(0L);
        System.out.println();
        Map<String, Executor> beansOfType = BeanLoader.INSTANCE.getBeansOfType(Executor.class);
        System.out.println();
    }
}
