package com.sintrue.matrix.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import wang.liangchen.matrix.framework.data.annotation.EnableJdbc;
import wang.liangchen.matrix.framework.web.annotation.EnableWeb;

/**
 * @author Liangchen.Wang
 */
@SpringBootApplication
@EnableWeb
@EnableJdbc
// @EnableMatrixCaching
public class ExampleInitializer {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ExampleInitializer.class);
        springApplication.run(args);
    }
}
