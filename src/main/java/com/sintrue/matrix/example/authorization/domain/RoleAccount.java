package com.sintrue.matrix.example.authorization.domain;

import wang.liangchen.matrix.framework.data.dao.entity.RootEntity;
import wang.liangchen.matrix.framework.data.dao.entity.RootId;

import javax.persistence.Table;

/**
 * @author Liangchen.Wang 2022-04-24 18:05
 */
@Table(name = "role_account")
public class RoleAccount extends RootEntity {

    private RoleAccountId roleAccountId;

    class RoleAccountId extends RootId<RoleAccount> {
        private Long roleId;
        private Long accountId;

        public Long getRoleId() {
            return roleId;
        }

        public void setRoleId(Long roleId) {
            this.roleId = roleId;
        }

        public Long getAccountId() {
            return accountId;
        }

        public void setAccountId(Long accountId) {
            this.accountId = accountId;
        }
    }
}

