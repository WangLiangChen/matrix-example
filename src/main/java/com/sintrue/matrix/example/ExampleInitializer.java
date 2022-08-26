package com.sintrue.matrix.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import wang.liangchen.matrix.framework.web.annotation.EnableWeb;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Liangchen.Wang
 */
@SpringBootApplication
@EnableWeb
//@EnableJdbc
public class ExampleInitializer {
    public static void main(String[] args) throws IOException, URISyntaxException {
        SpringApplication springApplication = new SpringApplication(ExampleInitializer.class);
        springApplication.run(args);
    }
}
