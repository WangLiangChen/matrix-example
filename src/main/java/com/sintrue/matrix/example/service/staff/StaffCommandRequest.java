package com.sintrue.matrix.example.service.staff;

import javax.validation.constraints.NotBlank;
import wang.liangchen.matrix.framework.commons.enumeration.ConstantEnum;
import wang.liangchen.matrix.framework.data.dao.entity.JsonField;

/**
 * @author Liangchen.Wang 2022-12-09 21:24
 */
public class StaffCommandRequest {
    @NotBlank
    private String staffName;
    private JsonField staffSettings;
    @NotBlank
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
