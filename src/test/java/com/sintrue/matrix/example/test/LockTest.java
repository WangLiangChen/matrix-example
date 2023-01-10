package com.sintrue.matrix.example.test;

import com.sintrue.matrix.example.component.LockService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.commons.thread.ThreadUtil;

import javax.inject.Inject;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author Liangchen.Wang 2022-12-10 11:20
 */
@SpringBootTest
public class LockTest {
    @Inject
    private LockService service;


    @Test
    public void testLock() {
        int threads = 10;
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            new Thread(() -> {
                String lock = service.lock();
                System.out.println("=======>" + lock);
                countDownLatch.countDown();
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testScheduledLock() {
        ThreadUtil.INSTANCE.sleep(TimeUnit.MINUTES, 2);
    }
}
