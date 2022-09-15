package com.sintrue.matrix.example.message_pl;

import javax.validation.constraints.NotBlank;

/**
 * @author Liangchen.Wang 2022-09-08 11:22
 */
public class StaffRequest {
    @NotBlank(message = "{javax.validation.constraints.NotBlank.message}")
    private String staffDesc;

    public String getStaffDesc() {
        return staffDesc;
    }

    public void setStaffDesc(String staffDesc) {
        this.staffDesc = staffDesc;
    }
}
