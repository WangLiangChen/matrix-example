package com.sintrue.matrix.example.test.cache;

import org.springframework.stereotype.Component;
import wang.liangchen.matrix.cache.sdk.annotation.Cacheable;

import java.util.Random;

/**
 * @author Liangchen.Wang 2022-07-27 20:56
 */
@Component
@Cacheable(value = "CacheObject", ttlMs = 1000 * 60 * 5)
public class CacheableClass {
    public CacheObject findCacheObject(String name) {
        System.out.println("--------------unhit--------------------------");
        CacheObject cacheObject = new CacheObject();
        cacheObject.setObjectId(new Random().nextLong());
        cacheObject.setObjectName("name_" + cacheObject.getObjectId());
        return cacheObject;
    }
}
