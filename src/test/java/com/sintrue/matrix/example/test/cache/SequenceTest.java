package com.sintrue.matrix.example.test.cache;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.data.dao.ISequenceDao;

import javax.inject.Inject;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CountDownLatch;

/**
 * @author Liangchen.Wang 2022-08-20 18:37
 */
@SpringBootTest
public class SequenceTest {
    @Inject
    private ISequenceDao sequenceDao;

    @Test
    public void testThread() throws InterruptedException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                Long number = sequenceDao.sequenceNumber("wanglc", 0);
                System.out.println(number);
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
    }
}
