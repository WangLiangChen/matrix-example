package com.sintrue.matrix.example.authorization.domain;

import wang.liangchen.matrix.framework.data.dao.entity.RootEntity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Liangchen.Wang 2022-04-24 18:05
 */
@Entity(name = "group_account")
public class GroupAccount extends RootEntity {
    @Id
    private Long groupId;
    @Id
    private Long accountId;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
