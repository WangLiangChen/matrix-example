package com.sintrue.matrix.example.domain;

import wang.liangchen.matrix.framework.data.enumeration.StateEnum;

/**
 * @author Liangchen.Wang 2022-09-16 17:50
 */
public class StaffState extends StateEnum {
    public final static StateEnum ACTIVE = new StateEnum("ACTIVE", "正常");
    public StaffState(String name, String value) {
        super(name, value);
    }
}
