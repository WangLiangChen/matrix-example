package com.sintrue.matrix.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author Liangchen.Wang
 */
@SpringBootApplication
public class ExampleInitializer {
    public static void main(String[] args) throws IOException, URISyntaxException {
        SpringApplication springApplication = new SpringApplication(ExampleInitializer.class);
        springApplication.run(args);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath*:/**/*.class");
        for (Resource resource : resources) {
            System.out.println(resource.getURI());
        }
    }
}
