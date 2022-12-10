package com.sintrue.matrix.example.test.commons;

import org.junit.jupiter.api.Test;
import wang.liangchen.matrix.framework.commons.encryption.LuhnUtil;
import wang.liangchen.matrix.framework.commons.random.RandomUtil;

/**
 * @author Liangchen.Wang 2022-12-10 16:24
 */
public class SignAndCipherTest {
    @Test
    public void testLuhn() {
        // 随机数字 + 3位校验位
        for (int i = 0; i < 100; i++) {
            int random = RandomUtil.INSTANCE.random(100000000, 999999999);
            System.out.println("random: " + random);
            String luhn = LuhnUtil.INSTANCE.generate(String.valueOf(random), 3);
            System.out.println("luhn: " + luhn);
            boolean validate = LuhnUtil.INSTANCE.validate(luhn, 3);
            System.out.println("validate: " + validate);
        }
    }
}
