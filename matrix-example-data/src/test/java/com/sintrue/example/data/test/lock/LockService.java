package com.sintrue.example.data.test.lock;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import wang.liangchen.matrix.framework.lock.annotation.MatrixLock;

/**
 * @author Liangchen.Wang 2023-05-05 18:22
 */
@Component
public class LockService {


    // 注意:返回值不能为void或基本类型
    @MatrixLock(lockGroup = "matrix", lockKey = "matrix", lockAtLeast = "1m", lockAtMost = "5m")
    public String executeInLock() {
        return "do something in lock";
    }

    // 返回值必须为void
    //@Scheduled(fixedDelay = 2000)
    //@MatrixLock(lockGroup = "matrix", lockKey = "matrix", lockAtLeast = "1m", lockAtMost = "5m")
    public void executeInLockScheduled() {
        System.out.println("do something scheduled!");
    }
}
