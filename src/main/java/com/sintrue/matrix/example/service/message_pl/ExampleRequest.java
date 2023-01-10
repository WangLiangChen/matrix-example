package com.sintrue.matrix.example.service.message_pl;

import com.sintrue.matrix.example.dao.entity.ExampleSettings;
import wang.liangchen.matrix.framework.commons.type.ClassUtil;
import wang.liangchen.matrix.framework.commons.validation.InsertGroup;
import wang.liangchen.matrix.framework.commons.validation.UpdateGroup;
import wang.liangchen.matrix.framework.data.pagination.Pagination;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author 2023-01-06 14:20:03
 */
public class ExampleRequest extends Pagination {

    /**
     * Primarykey
     */
    @NotNull(groups = UpdateGroup.class)
    private Long staffId;
    /**
     * 名称
     */
    @NotBlank(message = "{staffName.NotBlank}", groups = InsertGroup.class)
    private String staffName;
    /**
     * Json格式配置信息
     */
    @NotNull(groups = InsertGroup.class)
    private ExampleSettings staffSettings;
    /**
     * 简述说明
     */
    private String summary;


    public static ExampleRequest newInstance() {
        return ClassUtil.INSTANCE.instantiate(ExampleRequest.class);
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("StaffRequest{");
        builder.append("staffId = ").append(staffId).append(", ");
        builder.append("staffName = ").append(staffName).append(", ");
        builder.append("staffSettings = ").append(staffSettings).append(", ");
        builder.append("summary = ").append(summary).append(", ");
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");
        return builder.toString();
    }
}