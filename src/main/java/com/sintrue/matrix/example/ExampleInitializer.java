package com.sintrue.matrix.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import wang.liangchen.matrix.framework.data.annotation.EnableJdbc;
import wang.liangchen.matrix.framework.web.annotation.EnableWeb;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Liangchen.Wang
 */
@SpringBootApplication
@EnableJdbc
@EnableWeb(webType = EnableWeb.WebType.WEBMVC)
public class ExampleInitializer {
    public static void main(String[] args) throws IOException, URISyntaxException {
        SpringApplication springApplication = new SpringApplication(ExampleInitializer.class);
        springApplication.run(args);
    }
}
