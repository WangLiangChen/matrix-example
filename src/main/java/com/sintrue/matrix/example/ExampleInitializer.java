package com.sintrue.matrix.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import wang.liangchen.matrix.framework.data.annotation.EnableJdbc;

/**
 * @author Liangchen.Wang
 */
@SpringBootApplication
@EnableJdbc
public class ExampleInitializer {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ExampleInitializer.class);
        springApplication.run(args);
    }
}
