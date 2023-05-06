package com.sintrue.example.generator.ddd.hr.domain.staff;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import wang.liangchen.matrix.framework.commons.object.ObjectUtil;
import wang.liangchen.matrix.framework.commons.type.ClassUtil;
import wang.liangchen.matrix.framework.data.annotation.IdStrategy;
import wang.liangchen.matrix.framework.data.dao.entity.RootEntity;
import wang.liangchen.matrix.framework.ddd.domain.IEntity;

/**
 * 
 * @author  2023-05-06 16:39:10
 */
@Entity(name = "staff_role")
public class StaffRole extends RootEntity implements IEntity {
    /**
     * 
     */
    @Id
    @IdStrategy(IdStrategy.Strategy.MatrixFlake)
    private Long staffId;
    /**
     * 
     */
    @Id
    @IdStrategy(IdStrategy.Strategy.MatrixFlake)
    private Long roleId;

    public static StaffRole valueOf(Object source) {
        return ObjectUtil.INSTANCE.copyProperties(source, StaffRole.class);
    }

    public static StaffRole newInstance() {
        return ClassUtil.INSTANCE.instantiate(StaffRole.class);
    }
    public static StaffRole newInstance(boolean initializeFields) {
        StaffRole entity = ClassUtil.INSTANCE.instantiate(StaffRole.class);
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
    public Long getRoleId() {
        return this.roleId;
    }
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("StaffRole{");
        builder.append("staffId = ").append(staffId).append(", ");
        builder.append("roleId = ").append(roleId).append(", ");
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");
        return builder.toString();
    }
}