package com.sintrue.matrix.example.test;

import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import wang.liangchen.matrix.framework.generator.DDDGenerator;

import java.io.IOException;

/**
 * @author Liangchen.Wang 2022-12-24 12:50
 */
@SpringBootTest
public class DDDGeneratorTest {
    @Inject
    private DDDGenerator dddGenerator;
    private final static ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();


    @Test
    public void generate() throws IOException {
        Resource[] resources = resourcePatternResolver.getResources("classpath:");
        dddGenerator.generate();
    }
}
