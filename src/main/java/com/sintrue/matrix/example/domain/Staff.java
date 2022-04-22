package com.sintrue.matrix.example.domain;

import wang.liangchen.matrix.framework.data.annotation.ColumnDelete;
import wang.liangchen.matrix.framework.data.annotation.ColumnState;
import wang.liangchen.matrix.framework.data.dao.entity.RootEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * @author Liangchen.Wang 2022-04-17 14:26
 * 使用@Entity或者@Table设置表名
 */
@Entity(name = "staff")
@Table(name = "staff")
public class Staff extends RootEntity {
    // 使用@Id设置主键，支持联合主键
    @Id
    private Long staff_id;
    private String staffName;
// 使用@Column指定列名，不指定自动将驼峰转换为下划线
    @Column(name = "staff_gender")
    private String staff_sex;
    private LocalDate staff_birthday;

    // 使用@ColumnDelete指定用于逻辑删除的列和值
    @ColumnDelete("deleted")
    @ColumnState
    private String state;

    public Long getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Long staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaff_sex() {
        return staff_sex;
    }

    public void setStaff_sex(String staff_sex) {
        this.staff_sex = staff_sex;
    }

    public LocalDate getStaff_birthday() {
        return staff_birthday;
    }

    public void setStaff_birthday(LocalDate staff_birthday) {
        this.staff_birthday = staff_birthday;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staff_id=" + staff_id +
                ", staffName='" + staffName + '\'' +
                ", staff_sex='" + staff_sex + '\'' +
                ", staff_birthday=" + staff_birthday +
                '}';
    }
}
