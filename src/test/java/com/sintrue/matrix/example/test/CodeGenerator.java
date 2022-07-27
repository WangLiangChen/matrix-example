package com.sintrue.matrix.example.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.generator.DomainGenerator;

import javax.inject.Inject;

/**
 * @author Liangchen.Wang 2022-06-29 22:17
 */
//@SpringBootTest
public class CodeGenerator {
    // @Inject
    private DomainGenerator domainGenerator;

    @Test
    public void generate() {
        domainGenerator.build();
    }
}
