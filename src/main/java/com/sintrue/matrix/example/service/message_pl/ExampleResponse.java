package com.sintrue.matrix.example.service.message_pl;

import com.sintrue.matrix.example.dao.entity.ExampleSettings;
import wang.liangchen.matrix.framework.commons.enumeration.ConstantEnum;
import wang.liangchen.matrix.framework.commons.type.ClassUtil;

import java.time.LocalDateTime;

/**
* @author  2023-01-06 14:20:03
*/
public class ExampleResponse {

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
    private ExampleSettings staffSettings;
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
     * 状态,可继承的枚举
     */
    private ConstantEnum state;

    public static ExampleResponse newInstance() {
        return ClassUtil.INSTANCE.instantiate(ExampleResponse.class);
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

    public ExampleSettings getStaffSettings() {
        return staffSettings;
    }

    public void setStaffSettings(ExampleSettings staffSettings) {
        this.staffSettings = staffSettings;
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

    public ConstantEnum getState() {
        return state;
    }

    public void setState(ConstantEnum state) {
        this.state = state;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("StaffResponse{");
        builder.append("staffId = ").append(staffId).append(", ");
        builder.append("staffName = ").append(staffName).append(", ");
        builder.append("staffSettings = ").append(staffSettings).append(", ");
        builder.append("owner = ").append(owner).append(", ");
        builder.append("creator = ").append(creator).append(", ");
        builder.append("createDatetime = ").append(createDatetime).append(", ");
        builder.append("modifier = ").append(modifier).append(", ");
        builder.append("modifyDatetime = ").append(modifyDatetime).append(", ");
        builder.append("state = ").append(state).append(", ");
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");
        return builder.toString();
    }
}