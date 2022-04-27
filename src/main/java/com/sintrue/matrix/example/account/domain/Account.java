package com.sintrue.matrix.example.account.domain;

import wang.liangchen.matrix.framework.data.annotation.ColumnMarkDelete;
import wang.liangchen.matrix.framework.data.dao.entity.RootEntity;
import wang.liangchen.matrix.framework.ddd.domain.AggregateRoot;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Liangchen.Wang 2022-04-17 14:26
 * 使用@Entity或者@Table设置表名
 */
@Entity(name = "account")
@Table(name = "account")
@AggregateRoot
public class Account extends RootEntity {
    /**
     * 使用@Id设置主键，支持联合主键
     */
    @Id
    private Long account_id;
    /**
     * 自动将驼峰转换为下划线account_name
     */
    private String accountName;
    /**
     * 使用@Column指定列名
     */
    @Column(name = "account_gender")
    private String account_sex;

    private LocalDate account_birthday;
    /**
     * 使用@ColumnDelete指定用于逻辑删除的列和值
     */
    @ColumnMarkDelete("deleted")
    private String state;
    /**
     * 用于乐观锁的数据版本
     */
    @Version
    private Long version;

    /**
     * 使用@Transient或transient标识不会被解析为数据列
     */
    @Transient
    private transient List<Address> addresses;

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccount_sex() {
        return account_sex;
    }

    public void setAccount_sex(String account_sex) {
        this.account_sex = account_sex;
    }

    public LocalDate getAccount_birthday() {
        return account_birthday;
    }

    public void setAccount_birthday(LocalDate account_birthday) {
        this.account_birthday = account_birthday;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public void addAddress(Address address) {
        if (null == addresses) {
            addresses = new ArrayList<>();
        }
        addresses.add(address);
    }
}
