CREATE TABLE commodity
(
    commodity_id    bigint       NOT NULL COMMENT 'Primarykey',
    commodity_name  varchar(100) NOT NULL COMMENT '商品名称',
    commodity_price int          NOT NULL COMMENT '商品价格(分)',
    commodity_stock int          NOT NULL COMMENT '商品库存',
    create_datetime datetime(6) NOT NULL COMMENT '创建时间',
    state           varchar(20)  NOT NULL COMMENT '状态',
    CONSTRAINT commodity_pk PRIMARY KEY (commodity_id)
);
