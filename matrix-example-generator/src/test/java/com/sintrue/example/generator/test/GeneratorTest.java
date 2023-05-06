package com.sintrue.example.generator.test;

import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.generator.ddd.DDDGenerator;
import wang.liangchen.matrix.framework.generator.tier3.Tier3Generator;

/**
 * @author Liangchen.Wang 2023-05-06 16:32
 */
@SpringBootTest
public class GeneratorTest {
    @Inject
    private DDDGenerator dddGenerator;
    @Inject
    private Tier3Generator tier3Generator;

    @Test
    public void generateDDD() {
        dddGenerator.generate();
    }

    @Test
    public void generateTier3() {
        tier3Generator.generate();
    }
}
