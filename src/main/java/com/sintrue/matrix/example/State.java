package com.sintrue.matrix.example;

import java.io.Serializable;

/**
 * @author Liangchen.Wang 2022-09-01 7:11
 */
public class State implements Serializable {
    private Long state_id;

    public Long getState_id() {
        return state_id;
    }

    public void setState_id(Long state_id) {
        this.state_id = state_id;
    }
}
