package com.sintrue.example.generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import wang.liangchen.matrix.framework.data.annotation.EnableJdbc;

/**
 * @author Liangchen.Wang 2023-05-06 16:35
 */
@SpringBootApplication
@EnableJdbc
public class MatrixGeneratorConfiguration {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication();
        springApplication.run(args);
    }
}
