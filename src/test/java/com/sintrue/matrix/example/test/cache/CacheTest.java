package com.sintrue.matrix.example.test.cache;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
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
    private CacheServiceImpl cacheServiceImpl;
    @Inject
    private CacheManager cacheManager;

    @Test
    public void testMethod() throws InterruptedException {
        for (int i = 0; i < 7; i++) {
            String wanglc = cacheServiceImpl.findName("wanglc");
            System.out.println(wanglc + i);
            TimeUnit.SECONDS.sleep(10);
        }
        // 编程式获取和操作缓存
        Cache cache = cacheManager.getCache("mycache");
        cache.evict("name");
        cache.clear();
    }
}
