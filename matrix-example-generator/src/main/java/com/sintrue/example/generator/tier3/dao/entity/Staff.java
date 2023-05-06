package com.sintrue.example.generator.tier3.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import wang.liangchen.matrix.framework.commons.object.ObjectUtil;
import wang.liangchen.matrix.framework.commons.type.ClassUtil;
import wang.liangchen.matrix.framework.data.annotation.ColumnJson;
import wang.liangchen.matrix.framework.data.annotation.ColumnMarkDelete;
import wang.liangchen.matrix.framework.data.annotation.ColumnState;
import wang.liangchen.matrix.framework.data.annotation.IdStrategy;
import wang.liangchen.matrix.framework.data.dao.entity.RootEntity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.function.BiConsumer;

/**
 * 员工实体示例
 * @author  2023-05-06 16:40:45
 */
@Entity(name = "staff")
public class Staff extends RootEntity {
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
    private String staffSettings;
    /**
     * 版本号,可用于乐观锁
     * 版本列
     * 更新和删除时,非空则启用乐观锁
     */
    @Version
    private Integer version;
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
     * 简述说明
     */
    private String summary;
    /**
     * 状态
     * 逻辑删除列和值
     * 状态列
     */
    @ColumnMarkDelete("DELETED")
    @ColumnState
    private String state;

    public static Staff valueOf(Object source) {
        return ObjectUtil.INSTANCE.copyProperties(source, Staff.class);
    }

    public static <S> Collection<Staff> valuesOf(Collection<S> sources) {
        return ObjectUtil.INSTANCE.copyProperties(sources, Staff.class);
    }

    public static <S> Collection<Staff> valuesOf(Collection<S> sources, BiConsumer<S, Staff> biConsumer) {
        return ObjectUtil.INSTANCE.copyProperties(sources, Staff.class, biConsumer);
    }

    public static Staff newInstance() {
        return ClassUtil.INSTANCE.instantiate(Staff.class);
    }

    public static Staff newInstance(boolean initializeFields) {
        Staff entity = ClassUtil.INSTANCE.instantiate(Staff.class);
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
    public String getStaffSettings() {
        return this.staffSettings;
    }
    public void setStaffSettings(String staffSettings) {
        this.staffSettings = staffSettings;
    }
    public Integer getVersion() {
        return this.version;
    }
    public void setVersion(Integer version) {
        this.version = version;
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
    public String getSummary() {
        return this.summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getState() {
        return this.state;
    }
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Staff{");
        builder.append("staffId = ").append(staffId).append(", ");
        builder.append("staffName = ").append(staffName).append(", ");
        builder.append("staffSettings = ").append(staffSettings).append(", ");
        builder.append("version = ").append(version).append(", ");
        builder.append("owner = ").append(owner).append(", ");
        builder.append("creator = ").append(creator).append(", ");
        builder.append("createDatetime = ").append(createDatetime).append(", ");
        builder.append("modifier = ").append(modifier).append(", ");
        builder.append("modifyDatetime = ").append(modifyDatetime).append(", ");
        builder.append("summary = ").append(summary).append(", ");
        builder.append("state = ").append(state).append(", ");
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");
        return builder.toString();
    }
}