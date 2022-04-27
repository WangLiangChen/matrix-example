package com.sintrue.matrix.example.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.generator.DomainGenerator;

import javax.inject.Inject;

/**
 * @author Liangchen.Wang 2022-04-26 8:53
 */
@SpringBootTest
public class DomainGeneratorTests {
    @Inject
    DomainGenerator domainGenerator;


    @Test
    public void testMeta() throws Exception {
        domainGenerator.build();
    }


}
