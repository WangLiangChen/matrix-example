package com.sintrue.matrix.example.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.generator.DDDGenerator;

import javax.annotation.Resource;

/**
 * @author Liangchen.Wang 2022-08-15 20:49
 */
@SpringBootTest
public class CodeGenerator {
    @Resource
    private DDDGenerator dddGenerator;

    @Test
    public void generate() {
        dddGenerator.generate();
    }
}
