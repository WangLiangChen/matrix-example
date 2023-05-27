CREATE TABLE if not exists staff
(
    staff_id        int8          NOT NULL,
    staff_name      varchar(36)   NOT NULL,
    staff_settings  varchar(1000) NOT NULL,
    version         int4          NOT NULL DEFAULT 0,
    owner           varchar(60)   NOT NULL DEFAULT '',
    creator         varchar(60)   NOT NULL DEFAULT '',
    create_datetime timestamp     NOT NULL,
    modifier        varchar(60)   NOT NULL DEFAULT '',
    modify_datetime timestamp     NOT NULL,
    summary         varchar(200)  NOT NULL DEFAULT '',
    state           varchar(36)   NOT NULL,
    CONSTRAINT pk_staff PRIMARY KEY (staff_id)
);
CREATE TABLE if not exists staff_role
(
    staff_id int8 NOT NULL,
    role_id  int8 NOT NULL,
    CONSTRAINT staff_role_pk PRIMARY KEY (staff_id, role_id)
);