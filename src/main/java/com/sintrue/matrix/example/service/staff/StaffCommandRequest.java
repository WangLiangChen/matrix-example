package com.sintrue.matrix.example.service.staff;

import wang.liangchen.matrix.framework.commons.enumeration.ConstantEnum;
import wang.liangchen.matrix.framework.data.dao.entity.JsonField;

/**
 * @author Liangchen.Wang 2022-12-09 21:24
 */
public class StaffCommandRequest {
    private String staffName;
    private JsonField staffSettings;

    private ConstantEnum state;
    private String summary;

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public JsonField getStaffSettings() {
        return staffSettings;
    }

    public void setStaffSettings(JsonField staffSettings) {
        this.staffSettings = staffSettings;
    }

    public ConstantEnum getState() {
        return state;
    }

    public void setState(ConstantEnum state) {
        this.state = state;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
