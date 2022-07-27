package com.sintrue.matrix.example.test.cache;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.boot.test.context.SpringBootTest;
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

    @Test
    public void testInit() throws InterruptedException {
        cacheableClass.findCacheObject("zhangsan");
        TimeUnit.SECONDS.sleep(60);
        cacheableClass.findCacheObject("lisi");
    }
}
