package com.sintrue.matrix.example.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Liangchen.Wang 2022-12-09 21:07
 */
public class StaffSettings implements Serializable {
    private String gender;
    private LocalDateTime birthday;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }
}
