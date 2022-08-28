package com.sintrue.matrix.example.test.cache;

import org.junit.jupiter.api.Test;
import wang.liangchen.matrix.framework.commons.enumeration.Symbol;
import wang.liangchen.matrix.framework.commons.exception.MatrixErrorException;

/**
 * @author Liangchen.Wang 2022-08-27 19:18
 */
public class CommonTest {
    @Test
    public void testException() {
        try {
            handleException();
        } catch (Exception e) {
            String message = stackTraceToString(e, new StringBuilder());
            System.out.println(message);
        }
    }

    private void handleException() {
        boolean doIt = true;
        try {
            if (doIt) {
                throw new RuntimeException("I am RuntimeException");
            }
        } catch (Exception e) {
            throw new MatrixErrorException(e, "I am MatrixErrorException");
        }
    }

    private String stackTraceToString(Throwable throwable, StringBuilder messageContainer) {
        if (null == throwable) {
            return messageContainer.toString();
        }
        messageContainer.append(throwable).append(Symbol.LINE_SEPARATOR.getSymbol());
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        for (int i = 0; i < stackTrace.length; i++) {
            messageContainer.append("    ").append(stackTrace[i]).append(Symbol.LINE_SEPARATOR.getSymbol());
            if (i > 3) {
                break;
            }
        }
        return stackTraceToString(throwable.getCause(), messageContainer);
    }
}
