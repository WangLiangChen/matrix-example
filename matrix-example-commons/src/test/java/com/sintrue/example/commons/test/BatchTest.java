package com.sintrue.example.commons.test;

import org.junit.jupiter.api.Test;
import wang.liangchen.matrix.framework.commons.batch.BatchProcessor;

import java.util.concurrent.TimeUnit;

/**
 * @author Liangchen.Wang 2023-05-06 17:36
 */
public class BatchTest {

    @Test
    public void testBatch() throws InterruptedException {
        // 设置每批大小和最后不够一批的等待时间
        BatchProcessor<String> batchProcessor = BatchProcessor.newInstance(8, 5, TimeUnit.SECONDS);
        // 每个批action
        batchProcessor.onConsume(System.out::println);
        // 结束后action
        batchProcessor.onFinish(() -> {
            System.out.println("finished");
        });
        // 往里放数据,凑齐一批后执行action
        for (int i = 0; i < 50; i++) {
            batchProcessor.put(String.valueOf(i));
        }
        TimeUnit.SECONDS.sleep(10);
    }
}
