package com.sintrue.matrix.example.test;

import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.generator.ddd.DDDStyleGenerator;

/**
 * @author Liangchen.Wang 2022-12-28 19:19
 */
@SpringBootTest
public class DDDStyleGeneratorTest {
    @Inject
    private DDDStyleGenerator dddStyleGenerator;

    @Test
    public void testGenerate() {
        dddStyleGenerator.generate();
    }
}
