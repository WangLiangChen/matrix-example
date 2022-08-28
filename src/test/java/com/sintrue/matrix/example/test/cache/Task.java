package com.sintrue.matrix.example.test.cache;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import wang.liangchen.matrix.framework.lock.annotation.MatrixLock;
import wang.liangchen.matrix.framework.lock.core.LockManager;
import wang.liangchen.matrix.framework.lock.rdbms.RdbmsLockManager;

import javax.sql.DataSource;

/**
 * @author Liangchen.Wang 2022-08-27 22:33
 */
@Component
public class Task {
    @Bean
    public LockManager lockManager(DataSource dataSource) {
        return new RdbmsLockManager(dataSource);
    }

    @Scheduled(fixedDelay = 2000)
    @MatrixLock(lockKey = "matrix", lockAtLeast = "1m", lockAtMost = "5m")
    public void doJob() {
        System.out.println("doJob-----------" + Thread.currentThread());
    }
}
