package com.sintrue.matrix.example.dao.query;

import liangchen.wang.matrix.framework.data.annotation.Query;
import liangchen.wang.matrix.framework.data.query.Operator;
import liangchen.wang.matrix.framework.data.query.RootQuery;

import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author Liangchen.Wang 2021-10-20 11:26
 */
@Table(name = "staff")
public class StaffQuery extends RootQuery {
    @Query(operator = Operator.EQUALS)
    private Long staff_id;
    @Query(operator = Operator.EQUALS)
    private String staffName;
    @Query(operator = Operator.EQUALS, column = "staff_gender")
    private String staffSex;
    private LocalDateTime staff_birthday;

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

    public String getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(String staffSex) {
        this.staffSex = staffSex;
    }

    public LocalDateTime getStaff_birthday() {
        return staff_birthday;
    }

    public void setStaff_birthday(LocalDateTime staff_birthday) {
        this.staff_birthday = staff_birthday;
    }
}
