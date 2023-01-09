package com.sintrue.matrix.example.dao.entity;

import wang.liangchen.matrix.framework.commons.enumeration.ConstantEnum;
import wang.liangchen.matrix.framework.data.enumeration.StateEnum;

public class ExampleState extends ConstantEnum {
    public final static ConstantEnum CURRENT = new StateEnum("CURRENT", "在职");
    public final static ConstantEnum FORMER = new StateEnum("FORMER", "离职");
    public static final ConstantEnum DELETED = new StateEnum("DELETED", "删除");

    public ExampleState(String key, String value) {
        super(key, value);
    }
}
