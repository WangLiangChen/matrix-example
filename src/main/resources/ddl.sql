/**
  MySQL
 */
create table commodity
(
    commodity_id    bigint       not null comment 'primarykey',
    commodity_name  varchar(100) not null comment '商品名称',
    commodity_price int          not null comment '商品价格(分)',
    commodity_stock int          not null comment '商品库存',
    create_datetime datetime(6) not null comment '创建时间',
    state           varchar(20)  not null comment '状态',
    constraint commodity_pk primary key (commodity_id)
);
/**
  PostgreSQL
 */
create table commodity
(
    commodity_id    int8       not null,
    commodity_name  varchar(100) not null ,
    commodity_price int4          not null,
    commodity_stock int4          not null,
    create_datetime timestamp not null,
    state           varchar(20)  not null,
    constraint commodity_pk primary key (commodity_id)
);
