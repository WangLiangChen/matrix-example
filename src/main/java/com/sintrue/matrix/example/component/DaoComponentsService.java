package com.sintrue.matrix.example.component;

import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.data.dao.SequenceKey;
import wang.liangchen.matrix.framework.data.util.SequenceUtil;

import java.util.concurrent.CountDownLatch;

/**
 * @author Liangchen.Wang 2022-12-10 11:16
 */
@Service
public class DaoComponentsService {
    public void sequence(SequenceKey sequenceKey) {
        int threads = 5;
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            new Thread(() -> {
                Long number = SequenceUtil.INSTANCE.sequenceNumber(sequenceKey);
                System.out.println("====>" + sequenceKey + ": " + number);
                countDownLatch.countDown();
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
