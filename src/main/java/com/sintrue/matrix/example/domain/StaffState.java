package com.sintrue.matrix.example.domain;

import wang.liangchen.matrix.framework.commons.enumeration.ConstantEnum;

/**
 * @author Liangchen.Wang 2022-09-16 17:50
 */
public class StaffState extends ConstantEnum {
    public final static StaffState STAFF_ONLY = new StaffState("StaffOnly", "仅测试");

    public StaffState(String name, String value) {
        super(name, value);
    }
}
