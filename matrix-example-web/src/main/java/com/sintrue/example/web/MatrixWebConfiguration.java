package com.sintrue.example.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import wang.liangchen.matrix.framework.web.annotation.EnableWeb;

/**
 * @author Liangchen.Wang 2023-05-04 11:34
 */
@SpringBootApplication
@EnableWeb
public class MatrixWebConfiguration {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(MatrixWebConfiguration.class);
        springApplication.run(args);
    }
}
