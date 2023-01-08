package com.sintrue.matrix.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import wang.liangchen.matrix.cache.sdk.cache.CacheLevel;
import wang.liangchen.matrix.cache.sdk.override.EnableMatrixCaching;
import wang.liangchen.matrix.framework.data.annotation.EnableJdbc;
import wang.liangchen.matrix.framework.lock.annotation.EnableLock;
import wang.liangchen.matrix.framework.web.annotation.EnableWeb;

/**
 * @author Liangchen.Wang
 */
@SpringBootApplication
@EnableWeb
@EnableJdbc
@EnableLock
@EnableScheduling
@EnableMatrixCaching(cacheLevel = CacheLevel.LOCAL)
public class ExampleInitializer {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ExampleInitializer.class);
        springApplication.run(args);
    }
}
