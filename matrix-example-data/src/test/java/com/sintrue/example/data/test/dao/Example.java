package com.sintrue.example.data.test.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import wang.liangchen.matrix.framework.commons.object.ObjectUtil;
import wang.liangchen.matrix.framework.commons.type.ClassUtil;
import wang.liangchen.matrix.framework.data.annotation.ColumnJson;
import wang.liangchen.matrix.framework.data.annotation.ColumnMarkDelete;
import wang.liangchen.matrix.framework.data.annotation.IdStrategy;
import wang.liangchen.matrix.framework.data.dao.entity.CommonEntity;
import wang.liangchen.matrix.framework.data.dao.entity.JsonField;
import wang.liangchen.matrix.framework.data.enumeration.StateEnum;

/**
 * 员工实体示例
 *
 * @author 2023-04-28 11:21:21
 */
@Entity(name = "staff")
public class Example extends CommonEntity {
    /**
     * Primarykey
     */
    @Id
    @IdStrategy(IdStrategy.Strategy.MatrixFlake)
    private Long staffId;
    /**
     * 名称
     */
    private String staffName;
    /**
     * Json格式配置信息
     * 对象和JSON格式自动互转列
     * 非基本类型需实现Serializable接口以避免代码错误提示
     */
    @ColumnJson
    private JsonField staffSettings;

    @ColumnMarkDelete("0")
    private StateEnum state;

    @Version
    private Integer version;

    public static Example valueOf(Object source) {
        return ObjectUtil.INSTANCE.copyProperties(source, Example.class);
    }

    public static Example newInstance() {
        return ClassUtil.INSTANCE.instantiate(Example.class);
    }

    public static Example newInstance(boolean initializeFields) {
        Example entity = ClassUtil.INSTANCE.instantiate(Example.class);
        if (initializeFields) {
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

    public JsonField getStaffSettings() {
        return staffSettings;
    }

    public void setStaffSettings(JsonField staffSettings) {
        this.staffSettings = staffSettings;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Staff{");
        builder.append("staffId = ").append(staffId).append(", ");
        builder.append("staffName = ").append(staffName).append(", ");
        builder.append("staffSettings = ").append(staffSettings).append(", ");
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");
        return builder.toString();
    }
}