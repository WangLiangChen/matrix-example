package com.sintrue.example.data.test.dao;

import wang.liangchen.matrix.framework.data.enumeration.StateEnum;

/**
 * @author Liangchen.Wang 2023-04-30 23:03
 */
public class ExampleResponse {
    private String staffName;
    private StateEnum state;

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }
}
