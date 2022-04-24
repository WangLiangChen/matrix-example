package com.sintrue.matrix.example.group.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Liangchen.Wang 2022-04-24 18:02
 */
@Entity(name="group")
public class Group {
    @Id
    private Long roleId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
