package com.sintrue.matrix.example.role.domain;

import wang.liangchen.matrix.framework.data.dao.entity.RootEntity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Liangchen.Wang 2022-04-24 18:02
 */
@Entity(name="role")
public class Role extends RootEntity {
    @Id
    private Long roleId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
