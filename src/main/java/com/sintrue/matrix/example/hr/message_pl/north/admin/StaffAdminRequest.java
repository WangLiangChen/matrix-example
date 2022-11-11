package com.sintrue.matrix.example.hr.message_pl.north.admin;

import com.sintrue.matrix.example.hr.domain.staff.StaffSettings;

import javax.validation.constraints.NotBlank;

/**
 * @author Liangchen.Wang 2022-10-11 11:51
 */
public class StaffAdminRequest {
    @NotBlank(message = "{staffName.NotBlank.message}")
    private String staffName;
    private StaffSettings staffSettings;

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public StaffSettings getStaffSettings() {
        return staffSettings;
    }

    public void setStaffSettings(StaffSettings staffSettings) {
        this.staffSettings = staffSettings;
    }
}
