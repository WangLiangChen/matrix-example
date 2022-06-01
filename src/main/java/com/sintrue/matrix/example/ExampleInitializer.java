package com.sintrue.matrix.example;

import org.apache.commons.configuration2.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import wang.liangchen.matrix.framework.commons.classloader.LoadedScanner;
import wang.liangchen.matrix.framework.springboot.context.ConfigurationContext;

import java.net.URI;

/**
 * @author Liangchen.Wang
 */
@SpringBootApplication
public class ExampleInitializer {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ExampleInitializer.class);
        springApplication.run(args);

        Configuration configuration = ConfigurationContext.INSTANCE.resolve("jdbc.properties");
        String string = configuration.getString("primary.dialect");
        LoadedScanner.INSTANCE.getJars().forEach(System.out::println);
        LoadedScanner.INSTANCE.getClasses().forEach(System.out::println);
        System.out.println(string);
    }
}
