package com.sintrue.matrix.example.test.cache;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import wang.liangchen.matrix.cache.sdk.cache.mlc.MultilevelCacheManager;
import wang.liangchen.matrix.cache.sdk.override.EnableMatrixCaching;

import javax.inject.Inject;
import java.util.concurrent.TimeUnit;

/**
 * @author Liangchen.Wang 2022-06-30 9:18
 */
@SpringBootTest
@EnableMatrixCaching
public class CacheTest {
    @Inject
    private CacheableClass cacheableClass;
    @Inject
    private MultilevelCacheManager multilevelCacheManager;

    @Test
    public void testSync() throws InterruptedException {
        Cache syncCache = multilevelCacheManager.getCache("SyncCache");
        for (int i = 0; i < 50; i++) {
            syncCache.evict("evict_" + i);
            TimeUnit.SECONDS.sleep(i);
        }
        TimeUnit.MINUTES.sleep(2);
    }

    @Test
    public void testInit() throws InterruptedException {
        cacheableClass.findCacheObject();
    }
}
