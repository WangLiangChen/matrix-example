package com.sintrue.matrix.example.test.cache;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import wang.liangchen.matrix.cache.sdk.override.EnableMatrixCaching;

import javax.inject.Inject;
import java.util.concurrent.TimeUnit;

/**
 * @author Liangchen.Wang 2022-09-09 10:31
 */
@SpringBootTest
@EnableMatrixCaching
public class CacheTest {
    @Inject
    private CacheService cacheService;

    @Test
    public void testMethod() throws InterruptedException {
        String wanglc = cacheService.getName("wanglc");
        System.out.println(wanglc);
        TimeUnit.SECONDS.sleep(10);
    }
}
