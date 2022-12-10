package com.sintrue.matrix.example.service.staff;

import com.sintrue.matrix.example.entity.StaffSettings;

import java.time.LocalDateTime;

/**
 * @author Liangchen.Wang 2022-12-09 21:27
 */
public class StaffResponse {
    private Long staffId;
    private String staffName;
    private StaffSettings staffSettings;
    private String owner;
    private String creator;
    private LocalDateTime createDatetime;
    private String modifier;
    private LocalDateTime modify_datetime;

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

    public StaffSettings getStaffSettings() {
        return staffSettings;
    }

    public void setStaffSettings(StaffSettings staffSettings) {
        this.staffSettings = staffSettings;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public LocalDateTime getModify_datetime() {
        return modify_datetime;
    }

    public void setModify_datetime(LocalDateTime modify_datetime) {
        this.modify_datetime = modify_datetime;
    }
}
