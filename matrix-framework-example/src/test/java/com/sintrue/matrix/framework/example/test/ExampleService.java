package com.sintrue.matrix.framework.example.test;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {
    @Async
    public void async() {
        System.out.println(Thread.currentThread().getName() + "-" + UserContext.getUser());
    }

    //@Scheduled(fixedRate = 500)
    public void scheduled() {
        System.out.println("scheduled-" + Thread.currentThread().getName() + "-" + UserContext.getUser());

    }
}
