package com.sintrue.matrix.example.test;

import org.junit.jupiter.api.Test;
import wang.liangchen.matrix.framework.commons.logging.MatrixLogger;
import wang.liangchen.matrix.framework.commons.logging.MatrixLoggerFactory;

/**
 * @author Liangchen.Wang 2022-06-20 12:04
 */
public class MatrixLoggerTest {
    MatrixLogger matrixLogger = MatrixLoggerFactory.getLogger(this.getClass());

    @Test
    public void testInit() {
        matrixLogger.error("hello i am a error");
    }
}
