package com.sintrue.matrix.example.test.cache;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.commons.thread.ThreadUtil;
import wang.liangchen.matrix.framework.lock.core.LockConfiguration;
import wang.liangchen.matrix.framework.lock.core.LockManager;
import wang.liangchen.matrix.framework.lock.core.TaskResult;
import wang.liangchen.matrix.framework.lock.rdbms.RdbmsLockManager;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author Liangchen.Wang 2022-08-24 20:46
 */
@SpringBootTest
public class LockTest {
    @Inject
    private DataSource dataSource;

    @Test
    public void testFailFast() throws InterruptedException {
        LockManager lockManager = new RdbmsLockManager(dataSource);
        LockConfiguration lockConfiguration = new LockConfiguration("matrix", Instant.now(), Duration.ofMinutes(1), Duration.ofMinutes(5));
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                TaskResult<String> taskResult = lockManager.executeInLock(lockConfiguration, () -> {
                    ThreadUtil.INSTANCE.sleep(TimeUnit.SECONDS, 5);
                    String name = Thread.currentThread().getName();
                    System.out.println("-----" + name);
                    return name;
                });
                System.out.println(taskResult.isSkipped());
                System.out.println(taskResult.getObject());
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
    }
}
