package com.sintrue.matrix.example.service;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.commons.thread.ThreadUtil;
import wang.liangchen.matrix.framework.lock.annotation.MatrixLock;
import wang.liangchen.matrix.framework.lock.core.LockManager;
import wang.liangchen.matrix.framework.lock.rdbms.RdbmsLockManager;

import javax.sql.DataSource;
import java.util.concurrent.TimeUnit;

/**
 * @author Liangchen.Wang 2022-12-10 11:24
 */
@Service
public class LockService {

    @Bean
    public LockManager lockManager(DataSource dataSource) {
        return new RdbmsLockManager(dataSource);
    }

    @MatrixLock(lockGroup = "group", lockKey = "key", lockAtLeast = "1m", lockAtMost = "5m")
    public String lock() {
        return "lock is acquired";
    }

    @Scheduled(fixedDelay = 20)
    @MatrixLock(lockGroup = "group", lockKey = "key_1", lockAtLeast = "1m", lockAtMost = "5m")
    public void executeInLock() {
        ThreadUtil.INSTANCE.sleep(TimeUnit.SECONDS, 40);
        System.out.println("=======> executeInLock");
    }
}
