package com.sintrue.matrix.example.dao.entity;

import liangchen.wang.matrix.framework.data.dao.entity.RootEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @author Liangchen.Wang 2021-10-19 16:38
 */
@Entity(name = "staff")
public class StaffEntity extends RootEntity {
    @Id
    private Long staff_id;
    private String staff_name;
    private LocalDateTime staff_birthday;

    public Long getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Long staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public LocalDateTime getStaff_birthday() {
        return staff_birthday;
    }

    public void setStaff_birthday(LocalDateTime staff_birthday) {
        this.staff_birthday = staff_birthday;
    }
}
