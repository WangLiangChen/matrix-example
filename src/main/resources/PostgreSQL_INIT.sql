create table if not exists staff
(
    staff_id        INT8          not null,
    staff_name      VARCHAR(36)   not null,
    staff_settings  VARCHAR(1000) not null,
    version         INT4          not null default 0,
    owner           VARCHAR(60)   not null default '',
    creator         VARCHAR(60)   not null default '',
    create_datetime timestamp     not null,
    modifier        VARCHAR(60)   not null default '',
    modify_datetime timestamp     not null,
    summary         VARCHAR(200)  not null default '',
    state           VARCHAR(36)   not null,
    constraint PK_staff primary key (staff_id)
);

comment
    on table staff is
    '员工实体示例';

comment
    on column staff.staff_id is
    'Primarykey';

comment
    on column staff.staff_name is
    '名称';

comment
    on column staff.staff_settings is
    'Json格式配置信息';

comment
    on column staff.version is
    '版本号,可用于乐观锁';

comment
    on column staff.owner is
    '属主标识';

comment
    on column staff.creator is
    '创建者标识';

comment
    on column staff.create_datetime is
    '创建时间,长度6';

comment
    on column staff.modifier is
    '最后修改者标识';

comment
    on column staff.modify_datetime is
    '最后修改时间,长度6';

comment
    on column staff.summary is
    '简述说明';

comment
    on column staff.state is
    '状态';

/*==============================================================*/
/* Index: staff_PK                             */
/*==============================================================*/
create unique index if not exists staff_PK on staff (
    staff_id
);