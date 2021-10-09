package com.sintrue.matrix.example;

import liangchen.wang.matrix.framework.web.annotation.EnableWeb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Liangchen.Wang
 */
@SpringBootApplication
@EnableWeb
public class ExampleInitializer {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ExampleInitializer.class);
        springApplication.run(args);
    }
}
