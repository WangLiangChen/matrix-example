package com.sintrue.matrix.example.test.cache;

import com.sintrue.matrix.example.manager.StaffManager;
import com.sintrue.matrix.example.manager.domain.StaffDomain;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;

import javax.inject.Inject;

@SpringBootTest
public class CacheTest {
    @Inject
    private StaffManager staffManager;

    @Test
    public void findStaff(){
        staffManager.find(0L);
        staffManager.find(0L);
        System.out.println();
    }
}
