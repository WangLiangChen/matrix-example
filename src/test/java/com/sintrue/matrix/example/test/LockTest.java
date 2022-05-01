package com.sintrue.matrix.example.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.commons.random.RandomUtil;
import wang.liangchen.matrix.framework.commons.thread.ThreadUtil;
import wang.liangchen.matrix.framework.data.dao.IDBLock;
import wang.liangchen.matrix.framework.data.dao.ISequenceDao;

import javax.inject.Inject;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class LockTest {
    @Inject
    private ISequenceDao sequenceDao;

    @Test
    public void testUpdate() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                Long number = sequenceDao.sequenceNumber("wanglc", 10L);
                System.out.println("==========" + number);
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
    }

}
