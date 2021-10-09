package com.sintrue.matrix.example.domain;

import java.time.LocalDateTime;

/**
 * @author Liangchen.Wang 2021-10-09 15:45
 */
public class Staff {
    private Long staffId;
    private String staffName;
    private LocalDateTime birthday;

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

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }
}
