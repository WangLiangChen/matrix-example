package com.sintrue.matrix.example.seckill.domain;

import wang.liangchen.matrix.framework.commons.object.ObjectUtil;
import wang.liangchen.matrix.framework.commons.type.ClassUtil;
import wang.liangchen.matrix.framework.data.annotation.ColumnMarkDelete;
import wang.liangchen.matrix.framework.data.dao.entity.RootEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Liangchen.Wang
 */
@Entity(name = "commodity")
@Table(name = "commodity")
public class Commodity extends RootEntity {
    @Id
    @Column(name = "commodity_id")
    private Long commodityId;
    @Column(name = "commodity_name")
    private String commodityName;
    @Column(name = "commodity_price")
    private Integer commodityPrice;
    @Column(name = "commodity_stock")
    private Integer commodityStock;
    @Column(name = "create_datetime")
    private LocalDateTime createDatetime;
    @ColumnMarkDelete("deleted")
    @Column(name = "state")
    private String state;

    public static Commodity valueOf(Object source) {
        return ObjectUtil.INSTANCE.copyProperties(source, Commodity.class);
    }

    public static Commodity newInstance() {
        return ClassUtil.INSTANCE.instantiate(Commodity.class);
    }

    public Long getCommodityId() {
        return this.commodityId;
    }
    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }
    public String getCommodityName() {
        return this.commodityName;
    }
    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }
    public Integer getCommodityPrice() {
        return this.commodityPrice;
    }
    public void setCommodityPrice(Integer commodityPrice) {
        this.commodityPrice = commodityPrice;
    }
    public Integer getCommodityStock() {
        return this.commodityStock;
    }
    public void setCommodityStock(Integer commodityStock) {
        this.commodityStock = commodityStock;
    }
    public LocalDateTime getCreateDatetime() {
        return this.createDatetime;
    }
    public void setCreateDatetime(LocalDateTime createDatetime) {
        this.createDatetime = createDatetime;
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
        builder.append("Commodity{");
        builder.append("commodityId = ").append(commodityId).append(", ");
        builder.append("commodityName = ").append(commodityName).append(", ");
        builder.append("commodityPrice = ").append(commodityPrice).append(", ");
        builder.append("commodityStock = ").append(commodityStock).append(", ");
        builder.append("createDatetime = ").append(createDatetime).append(", ");
        builder.append("state = ").append(state).append(", ");
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");
        return builder.toString();
    }
}