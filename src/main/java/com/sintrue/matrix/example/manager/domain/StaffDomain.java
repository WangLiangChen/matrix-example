package com.sintrue.matrix.example.manager.domain;

import java.time.LocalDateTime;

public class StaffDomain {
    private Long staffId;
    private String staffName;
    private LocalDateTime staffBirthday;

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

    public LocalDateTime getStaffBirthday() {
        return staffBirthday;
    }

    public void setStaffBirthday(LocalDateTime staffBirthday) {
        this.staffBirthday = staffBirthday;
    }
}
