package com.sintrue.matrix.example.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.generator.ddd.DDDGenerator;
import wang.liangchen.matrix.framework.generator.tier3.Tier3Generator;

import javax.inject.Inject;

/**
 * @author Liangchen.Wang 2022-12-28 19:19
 */
@SpringBootTest
public class GeneratorTest {
    @Inject
    private DDDGenerator dddGenerator;
    @Inject
    private Tier3Generator tier3Generator;

    @Test
    public void testDDDGenerate() {
        dddGenerator.generate();
    }

    @Test
    public void testTier3Generate() {
        tier3Generator.generate();
    }
}
