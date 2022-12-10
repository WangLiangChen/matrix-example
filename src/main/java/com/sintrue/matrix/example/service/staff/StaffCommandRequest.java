package com.sintrue.matrix.example.service.staff;

import com.sintrue.matrix.example.entity.StaffSettings;

/**
 * @author Liangchen.Wang 2022-12-09 21:24
 */
public class StaffCommandRequest {
    private String staffName;
    private StaffSettings staffSettings;
    private String summary;

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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
