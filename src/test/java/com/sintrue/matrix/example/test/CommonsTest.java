package com.sintrue.matrix.example.test;

import org.junit.jupiter.api.Test;
import wang.liangchen.matrix.framework.commons.exception.Assert;
import wang.liangchen.matrix.framework.commons.network.NetUtil;
import wang.liangchen.matrix.framework.commons.random.RandomUtil;
import wang.liangchen.matrix.framework.commons.thread.ThreadUtil;
import wang.liangchen.matrix.framework.commons.uid.NumbericUid;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @author Liangchen.Wang 2022-05-06 9:11
 */
public class CommonsTest {
    @Test
    public void testPrivateAddress() {
        String ip = NetUtil.INSTANCE.getLocalHostAddress();
        System.out.println(ip);
        boolean iPv4Private = NetUtil.INSTANCE.isIPv4Private(ip);
        System.out.println(iPv4Private);
    }


    @Test
    public void testNumberIdThreads() throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            int count = numberIdThreads();
            Assert.INSTANCE.isTrue(count == 100000, "===============" + count);
        }
    }

    private int numberIdThreads() throws InterruptedException {
        // 必须使用线程安全的容器
        Map<Long, String> ids = new ConcurrentHashMap<>();
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    ThreadUtil.INSTANCE.sleep(RandomUtil.INSTANCE.random(1, 15));
                    long number = NumbericUid.INSTANCE.nextId();
                    ids.put(number, String.valueOf(number));
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        return ids.size();
    }
}
