package com.sintrue.matrix.example.service;

import com.sintrue.matrix.example.State;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Liangchen.Wang 2022-09-02 14:49
 */
public class StaffResponse {
    private Long staffId;
    private String staffText;
    private LocalDateTime createDatetime;
    private LocalDate createDate;
    private State state;

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getStaffText() {
        return staffText;
    }

    public void setStaffText(String staffText) {
        this.staffText = staffText;
    }

    public LocalDateTime getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(LocalDateTime createDatetime) {
        this.createDatetime = createDatetime;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
