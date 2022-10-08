package com.sintrue.matrix.example.company.domain.staff;

import wang.liangchen.matrix.framework.commons.object.ObjectUtil;
import wang.liangchen.matrix.framework.commons.type.ClassUtil;
import wang.liangchen.matrix.framework.data.annotation.IdStrategy;
import wang.liangchen.matrix.framework.data.annotation.ColumnMarkDelete;
import wang.liangchen.matrix.framework.data.annotation.ColumnJson;
import wang.liangchen.matrix.framework.data.dao.entity.RootEntity;
import wang.liangchen.matrix.framework.ddd.domain.AggregateRoot;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Liangchen.Wang
 */
@AggregateRoot
@Entity(name = "staff")
public class Staff extends RootEntity {
    @Id
    @IdStrategy(IdStrategy.Strategy.MatrixFlake)
    @Column(name = "staff_id")
    private Long staffId;
    @Column(name = "staff_name")
    private String staffName;
    /**
     * 对象和JSON格式互转列
     */
    @ColumnJson
    @Column(name = "staff_settings")
    private String staffSettings;
    @Version
    @Column(name = "version")
    private Integer version;
    @Column(name = "owner")
    private String owner;
    @Column(name = "creator")
    private String creator;
    @Column(name = "create_datetime")
    private LocalDateTime createDatetime;
    @Column(name = "modifier")
    private String modifier;
    @Column(name = "modify_datetime")
    private LocalDateTime modifyDatetime;
    @Column(name = "summary")
    private String summary;
    /**
     * 逻辑删除的列和逻辑值
     */
    @ColumnMarkDelete("DELETED")
    @Column(name = "state")
    private String state;

    public static Staff valueOf(Object source) {
        return ObjectUtil.INSTANCE.copyProperties(source, Staff.class);
    }

    public static Staff newInstance() {
        return ClassUtil.INSTANCE.instantiate(Staff.class);
    }
    public static Staff newInstance(boolean initializeFields) {
        Staff entity = ClassUtil.INSTANCE.instantiate(Staff.class);
        if(initializeFields) {
            entity.initializeFields();
        }
        return entity;
    }

    public Long getStaffId() {
        return this.staffId;
    }
    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }
    public String getStaffName() {
        return this.staffName;
    }
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
    public String getStaffSettings() {
        return this.staffSettings;
    }
    public void setStaffSettings(String staffSettings) {
        this.staffSettings = staffSettings;
    }
    public Integer getVersion() {
        return this.version;
    }
    public void setVersion(Integer version) {
        this.version = version;
    }
    public String getOwner() {
        return this.owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getCreator() {
        return this.creator;
    }
    public void setCreator(String creator) {
        this.creator = creator;
    }
    public LocalDateTime getCreateDatetime() {
        return this.createDatetime;
    }
    public void setCreateDatetime(LocalDateTime createDatetime) {
        this.createDatetime = createDatetime;
    }
    public String getModifier() {
        return this.modifier;
    }
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }
    public LocalDateTime getModifyDatetime() {
        return this.modifyDatetime;
    }
    public void setModifyDatetime(LocalDateTime modifyDatetime) {
        this.modifyDatetime = modifyDatetime;
    }
    public String getSummary() {
        return this.summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getState() {
        return this.state;
    }
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Staff{");
        builder.append("staffId = ").append(staffId).append(", ");
        builder.append("staffName = ").append(staffName).append(", ");
        builder.append("staffSettings = ").append(staffSettings).append(", ");
        builder.append("version = ").append(version).append(", ");
        builder.append("owner = ").append(owner).append(", ");
        builder.append("creator = ").append(creator).append(", ");
        builder.append("createDatetime = ").append(createDatetime).append(", ");
        builder.append("modifier = ").append(modifier).append(", ");
        builder.append("modifyDatetime = ").append(modifyDatetime).append(", ");
        builder.append("summary = ").append(summary).append(", ");
        builder.append("state = ").append(state).append(", ");
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");
        return builder.toString();
    }
}