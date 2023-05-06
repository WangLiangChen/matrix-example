package com.sintrue.example.data.test.lock;

import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Liangchen.Wang 2023-05-05 18:21
 */
@SpringBootTest
public class LockTest {
    @Inject
    private LockService lockService;

    @Test
    public void testLockService() {
        String result = lockService.executeInLock();
        System.out.println(result);
    }
}
