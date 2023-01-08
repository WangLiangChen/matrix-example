package com.sintrue.matrix.example.dao.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class ExampleSettings implements Serializable {
    private String gender;
    private LocalDate birthday;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
