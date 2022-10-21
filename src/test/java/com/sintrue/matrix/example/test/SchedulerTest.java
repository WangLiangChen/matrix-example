package com.sintrue.matrix.example.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;
import wang.liangchen.matrix.framework.commons.thread.ThreadUtil;
import wang.liangchen.matrix.framework.data.annotation.EnableJdbc;
import wang.liangchen.matrix.framework.lock.annotation.EnableLock;

import java.util.concurrent.TimeUnit;

/**
 * @author Liangchen.Wang 2022-08-27 22:32
 */
@SpringBootTest
@EnableScheduling
@EnableLock(proxyMode = EnableLock.ProxyMode.METHOD)
@EnableJdbc
public class SchedulerTest {
    @Test
    public void testScheduler() {
        ThreadUtil.INSTANCE.sleep(TimeUnit.MINUTES, 1);
    }
}
