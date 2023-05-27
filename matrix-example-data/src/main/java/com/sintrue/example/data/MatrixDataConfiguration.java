package com.sintrue.example.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import wang.liangchen.matrix.framework.data.annotation.EnableJdbc;
import wang.liangchen.matrix.framework.lock.annotation.EnableLock;

/**
 * @author Liangchen.Wang 2023-05-04 11:11
 */
@SpringBootApplication
@EnableJdbc
@EnableLock
@EnableScheduling
public class MatrixDataConfiguration {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(MatrixDataConfiguration.class);
        springApplication.run(args);
    }
}