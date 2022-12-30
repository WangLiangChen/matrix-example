package com.sintrue.matrix.example.test;

import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.generator.ddd.DDDStyleGenerator;
import wang.liangchen.matrix.framework.generator.tier3.Tier3Generator;

/**
 * @author Liangchen.Wang 2022-12-28 19:19
 */
@SpringBootTest
public class GeneratorTest {
    @Inject
    private DDDStyleGenerator dddStyleGenerator;
    @Inject
    private Tier3Generator tier3Generator;

    @Test
    public void testDDDGenerate() {
        dddStyleGenerator.generate();
    }

    @Test
    public void testTier3Generate() {
        tier3Generator.generate();
    }
}
