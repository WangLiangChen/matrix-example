package com.sintrue.matrix.example.domain;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Liangchen.Wang 2022-09-05 21:16
 */
public class Settings implements Serializable {
    private String gender;
    private LocalDate birthdate;

    public Settings() {
    }

    public Settings(String gender, LocalDate birthdate) {
        this.gender = gender;
        this.birthdate = birthdate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }
}
