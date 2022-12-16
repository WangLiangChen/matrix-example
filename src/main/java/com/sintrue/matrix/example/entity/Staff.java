package com.sintrue.matrix.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import wang.liangchen.matrix.framework.commons.enumeration.ConstantEnum;
import wang.liangchen.matrix.framework.data.annotation.ColumnJson;
import wang.liangchen.matrix.framework.data.annotation.ColumnMarkDelete;
import wang.liangchen.matrix.framework.data.annotation.ColumnState;
import wang.liangchen.matrix.framework.data.annotation.IdStrategy;
import wang.liangchen.matrix.framework.data.dao.entity.JsonField;
import wang.liangchen.matrix.framework.data.dao.entity.RootEntity;
import wang.liangchen.matrix.framework.springboot.annotation.AutoFieldNames;

import java.time.LocalDateTime;

/**
 * @author Liangchen.Wang 2022-12-09 21:06
 */
@AutoFieldNames
@Entity(name = "staff")
public class Staff extends RootEntity {
    @Id
    @IdStrategy(IdStrategy.Strategy.MatrixFlake)
    private Long staffId;
    private String staffName;
    /**
     * 对象和JSON互转，支持JsonField和Pojo
     */
    @ColumnJson
    private JsonField staffSettings;
    /**
     * 乐观锁
     */
    @Version
    private Integer version;
    private String owner;
    private String creator;
    private LocalDateTime createDatetime;
    private String modifier;
    private LocalDateTime modify_datetime;
    private String summary;
    /**
     * 状态列
     * 可继承的常量枚举
     * 逻辑删除
     */
    @ColumnState
    @ColumnMarkDelete("DELETED")
    private ConstantEnum state;

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

    public JsonField getStaffSettings() {
        return staffSettings;
    }

    public void setStaffSettings(JsonField staffSettings) {
        this.staffSettings = staffSettings;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public LocalDateTime getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(LocalDateTime createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public LocalDateTime getModify_datetime() {
        return modify_datetime;
    }

    public void setModify_datetime(LocalDateTime modify_datetime) {
        this.modify_datetime = modify_datetime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public ConstantEnum getState() {
        return state;
    }

    public void setState(ConstantEnum state) {
        this.state = state;
    }
}
