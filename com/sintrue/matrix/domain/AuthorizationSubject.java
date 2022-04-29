package com.sintrue.matrix.authorization.domain;

import wang.liangchen.matrix.framework.data.annotation.ColumnMarkDelete;
import wang.liangchen.matrix.framework.data.dao.entity.RootEntity;

import javax.persistence.*;


@Entity(name = "matrix_authorization_subject")
@Table(name = "matrix_authorization_subject")
public class AuthorizationSubject extends RootEntity {
    @Id
    @Column(name = "subject_id")
    private Long subjectId
    @Column(name = "tenant_code")
    private String tenantCode
    @Column(name = "app_code")
    private String appCode
    @Column(name = "subject_origin")
    private String subjectOrigin
    @Column(name = "subject_code")
    private String subjectCode
    @Column(name = "data_mode")
    private Byte dataMode
    @Version
    @Column(name = "version")
    private Integer version
    @Column(name = "sort")
    private Integer sort
    @Column(name = "owner")
    private String owner
    @Column(name = "creator")
    private String creator
    @Column(name = "create_datetime")
    private java.time.LocalDateTime createDatetime
    @Column(name = "modifier")
    private String modifier
    @Column(name = "modify_datetime")
    private java.time.LocalDateTime modifyDatetime
    @Column(name = "summary")
    private String summary
    @ColumnMarkDelete("deleted")
    @Column(name = "state")
    private String state

    public Long getSubjectId() { return this.subjectId; }
    public void setSubjectId(Long subjectId) { this.subjectId = subjectId; }
    public String getTenantCode() { return this.tenantCode; }
    public void setTenantCode(String tenantCode) { this.tenantCode = tenantCode; }
    public String getAppCode() { return this.appCode; }
    public void setAppCode(String appCode) { this.appCode = appCode; }
    public String getSubjectOrigin() { return this.subjectOrigin; }
    public void setSubjectOrigin(String subjectOrigin) { this.subjectOrigin = subjectOrigin; }
    public String getSubjectCode() { return this.subjectCode; }
    public void setSubjectCode(String subjectCode) { this.subjectCode = subjectCode; }
    public Byte getDataMode() { return this.dataMode; }
    public void setDataMode(Byte dataMode) { this.dataMode = dataMode; }
    public Integer getVersion() { return this.version; }
    public void setVersion(Integer version) { this.version = version; }
    public Integer getSort() { return this.sort; }
    public void setSort(Integer sort) { this.sort = sort; }
    public String getOwner() { return this.owner; }
    public void setOwner(String owner) { this.owner = owner; }
    public String getCreator() { return this.creator; }
    public void setCreator(String creator) { this.creator = creator; }
    public java.time.LocalDateTime getCreateDatetime() { return this.createDatetime; }
    public void setCreateDatetime(java.time.LocalDateTime createDatetime) { this.createDatetime = createDatetime; }
    public String getModifier() { return this.modifier; }
    public void setModifier(String modifier) { this.modifier = modifier; }
    public java.time.LocalDateTime getModifyDatetime() { return this.modifyDatetime; }
    public void setModifyDatetime(java.time.LocalDateTime modifyDatetime) { this.modifyDatetime = modifyDatetime; }
    public String getSummary() { return this.summary; }
    public void setSummary(String summary) { this.summary = summary; }
    public String getState() { return this.state; }
    public void setState(String state) { this.state = state; }
}