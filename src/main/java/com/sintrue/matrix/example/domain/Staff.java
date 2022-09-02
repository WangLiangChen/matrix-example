package com.sintrue.matrix.example.domain;

import com.sintrue.matrix.example.State;
import wang.liangchen.matrix.framework.commons.object.ObjectUtil;
import wang.liangchen.matrix.framework.commons.type.ClassUtil;
import wang.liangchen.matrix.framework.data.annotation.ColumnJson;
import wang.liangchen.matrix.framework.data.annotation.IdStrategy;
import wang.liangchen.matrix.framework.data.dao.entity.RootEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Liangchen.Wang 2022-08-31 22:52
 */
@Entity(name = "staff")
@Table(name = "staff")
public class Staff extends RootEntity {
    @Id
    @IdStrategy(IdStrategy.Strategy.MatrixFlake)
    private Long staffId;
    private String staffText;
    private LocalDateTime createDatetime;
    private LocalDate createDate;
    @ColumnJson
    private State state;

    public static Staff valueOf(Object source) {
        return ObjectUtil.INSTANCE.copyProperties(source, Staff.class);
    }

    public static Staff newInstance() {
        return ClassUtil.INSTANCE.instantiate(Staff.class);
    }

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
