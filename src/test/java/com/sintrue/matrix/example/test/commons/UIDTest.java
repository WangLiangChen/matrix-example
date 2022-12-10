package com.sintrue.matrix.example.test.commons;

import org.junit.jupiter.api.Test;
import wang.liangchen.matrix.framework.commons.uid.NanoIdUtil;
import wang.liangchen.matrix.framework.commons.uid.NumbericUid;

/**
 * @author Liangchen.Wang 2022-12-10 16:19
 */
public class UIDTest {
    @Test
    public void testNanoId() {
        String uid = NanoIdUtil.INSTANCE.randomNanoId();
        System.out.println("nanoid: " + uid);
    }

    @Test
    public void testNodepSnowFlake() {
        Long uid = NumbericUid.INSTANCE.nextId();
        System.out.println("snowflake: " + uid);
    }
}
