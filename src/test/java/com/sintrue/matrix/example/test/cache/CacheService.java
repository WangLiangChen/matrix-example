package com.sintrue.matrix.example.test.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import wang.liangchen.matrix.cache.sdk.annotation.CacheExpire;

import java.util.concurrent.TimeUnit;

/**
 * @author Liangchen.Wang 2022-09-09 10:39
 */
@Component
public class CacheService {
    @Cacheable(cacheNames = "mycache")
    @CacheExpire(ttl = 1, timeUnit = TimeUnit.MINUTES)
    public String getName(String name) {
        System.out.println("execute getName");
        return "hello," + name;
    }
}
