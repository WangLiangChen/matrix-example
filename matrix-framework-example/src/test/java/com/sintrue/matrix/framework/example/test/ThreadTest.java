package com.sintrue.matrix.framework.example.test;

import com.alibaba.ttl.TransmittableThreadLocal;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import wang.liangchen.matrix.framework.commons.thread.ThreadUtil;
import wang.liangchen.matrix.framework.commons.validation.ValidationUtil;

import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

//@SpringBootTest
public class ThreadTest {
    @Inject
    private ThreadPoolTaskExecutor executor;
    @Inject
    private ThreadPoolTaskScheduler scheduler;
    @Inject
    private ExampleService service;

    @Test
    public void testTransmittableThreadLocal() throws InterruptedException, ExecutionException {

        ThreadUtil.INSTANCE.sleep(Duration.ofSeconds(5));
    }

    @Test
    public void testValidation() {
        String result = ValidationUtil.INSTANCE.resolveMessage("{jakarta.validation.constraints.NotNull.message.default}");
        System.out.println(result);
    }



    @Test
    public void testForkJoin() throws ExecutionException, InterruptedException {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.threadFactory", "wang.liangchen.matrix.framework.commons.thread.MatrixForkJoinWorkerThreadFactory");
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "5");
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        System.out.println(forkJoinPool.getParallelism());
        TransmittableThreadLocal<String> threadLocal = new TransmittableThreadLocal<>();
        threadLocal.set("hello");

        try {
            for (int i = 0; i < 10; i++) {
                forkJoinPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
                });
            }
            threadLocal.set("baby");
            for (int i = 0; i < 10; i++) {
                forkJoinPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
                });
            }

        } finally {
            // 优雅关闭
            forkJoinPool.shutdown();
            forkJoinPool.awaitTermination(2, TimeUnit.SECONDS);
        }

    }

}

