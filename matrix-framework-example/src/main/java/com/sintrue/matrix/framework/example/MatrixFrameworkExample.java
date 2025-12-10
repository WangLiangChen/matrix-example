package com.sintrue.matrix.framework.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAsync
//@EnableScheduling
public class MatrixFrameworkExample {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(MatrixFrameworkExample.class);
        springApplication.run(args);
    }
}
