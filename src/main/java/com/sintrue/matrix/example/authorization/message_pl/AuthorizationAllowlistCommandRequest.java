package com.sintrue.matrix.example.authorization.message_pl;

import wang.liangchen.matrix.framework.commons.type.ClassUtil;

/**
 * @author Liangchen.Wang 2022-06-15 8:23
 */
public class AuthorizationAllowlistCommandRequest {
    private String tenantCode;
    private String appCode;
    private String permissionUri;
    private String owner;
    private String creator;
    private String summary;

    public static AuthorizationAllowlistCommandRequest newInstance() {
        return ClassUtil.INSTANCE.instantiate(AuthorizationAllowlistCommandRequest.class);
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getPermissionUri() {
        return permissionUri;
    }

    public void setPermissionUri(String permissionUri) {
        this.permissionUri = permissionUri;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
