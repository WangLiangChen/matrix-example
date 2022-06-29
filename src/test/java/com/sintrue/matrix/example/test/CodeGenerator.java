package com.sintrue.matrix.example.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.data.annotation.EnableJdbc;
import wang.liangchen.matrix.framework.generator.DomainGenerator;

import javax.inject.Inject;

/**
 * @author Liangchen.Wang 2022-05-06 9:11
 */
@SpringBootTest
@EnableJdbc
public class CodeGenerator {
    @Inject
    private DomainGenerator domainGenerator;
    @Test
    public void buildDomain() {
       domainGenerator.build();
    }
}
