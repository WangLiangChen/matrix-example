package com.sintrue.matrix.example.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;
import wang.liangchen.matrix.framework.commons.thread.ThreadUtil;
import wang.liangchen.matrix.framework.data.annotation.EnableJdbc;
import wang.liangchen.matrix.framework.lock.annotation.EnableLock;

import javax.inject.Inject;
import java.util.concurrent.TimeUnit;

/**
 * @author Liangchen.Wang 2022-08-27 22:32
 */
@SpringBootTest
@EnableScheduling
@EnableLock
@EnableJdbc
public class SchedulerTest {
    @Inject
    Task task;

    @Test
    public void testJobScheduler() {
        ThreadUtil.INSTANCE.sleep(TimeUnit.MINUTES, 1);
    }

    @Test
    public void testJob() {
        new Thread(() -> task.doJob()).start();
        new Thread(() -> task.doJob()).start();
        ThreadUtil.INSTANCE.sleep(TimeUnit.SECONDS, 6);
    }
}
