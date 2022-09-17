package com.sintrue.matrix.example.domain;

import wang.liangchen.matrix.framework.commons.object.ObjectUtil;
import wang.liangchen.matrix.framework.commons.type.ClassUtil;
import wang.liangchen.matrix.framework.data.annotation.ColumnJson;
import wang.liangchen.matrix.framework.data.annotation.ColumnMarkDelete;
import wang.liangchen.matrix.framework.data.annotation.IdStrategy;
import wang.liangchen.matrix.framework.data.dao.entity.RootEntity;
import wang.liangchen.matrix.framework.data.enumeration.StateEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Liangchen.Wang 2022-08-31 22:52
 */
@Entity(name = "staff")
public class Staff extends RootEntity {
    /**
     * 指定主键和主键生成策略
     */
    @Id
    @IdStrategy(IdStrategy.Strategy.MatrixFlake)
    private Long staffId;
    /**
     * 指定属性对应的列名
     */
    @Column(name = "staff_text")
    private String staffDesc;
    private LocalDateTime createDatetime;
    private LocalDate createDate;
    /**
     * 指定逻辑删除的列和值
     */
    @ColumnMarkDelete("DELETED")
    private StateEnum state;
    /**
     * 自动转换属性和Json
     */
    @ColumnJson
    private Settings settings;

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

    public String getStaffDesc() {
        return staffDesc;
    }

    public void setStaffDesc(String staffDesc) {
        this.staffDesc = staffDesc;
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

    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }
}
