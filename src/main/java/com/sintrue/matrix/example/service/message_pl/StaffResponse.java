package com.sintrue.matrix.example.service.message_pl;

import wang.liangchen.matrix.framework.commons.type.ClassUtil;

import java.time.LocalDateTime;

/**
* @author  2023-01-06 14:20:03
*/
public class StaffResponse {

    /**
     * Primarykey
     */
    private Long staffId;
    /**
     * 名称
     */
    private String staffName;
    /**
     * Json格式配置信息
     */
    private String staffSettings;
    /**
     * 版本号,可用于乐观锁
     */
    private Integer version;
    /**
     * 属主标识
     */
    private String owner;
    /**
     * 创建者标识
     */
    private String creator;
    /**
     * 创建时间,长度6
     */
    private LocalDateTime createDatetime;
    /**
     * 最后修改者标识
     */
    private String modifier;
    /**
     * 最后修改时间,长度6
     */
    private LocalDateTime modifyDatetime;
    /**
     * 简述说明
     */
    private String summary;
    /**
     * 状态
     */
    private String state;

    public static StaffResponse newInstance() {
        return ClassUtil.INSTANCE.instantiate(StaffResponse.class);
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
        builder.append("StaffResponse{");
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