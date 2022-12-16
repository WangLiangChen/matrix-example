package com.sintrue.matrix.example.service.staff;

import wang.liangchen.matrix.framework.commons.enumeration.ConstantEnum;
import wang.liangchen.matrix.framework.data.dao.entity.JsonField;
import wang.liangchen.matrix.framework.springboot.annotation.AutoFieldNames;

import java.time.LocalDateTime;

/**
 * @author Liangchen.Wang 2022-12-09 21:27
 */

@AutoFieldNames
public class StaffResponse {
    private Long staffId;
    private String staffName;
    private JsonField staffSettings;
    private String creator;
    private LocalDateTime createDatetime;
    private ConstantEnum state;

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public LocalDateTime getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(LocalDateTime createDatetime) {
        this.createDatetime = createDatetime;
    }

    public ConstantEnum getState() {
        return state;
    }

    public void setState(ConstantEnum state) {
        this.state = state;
    }
}
