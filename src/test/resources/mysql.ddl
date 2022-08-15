CREATE TABLE staff (
    staff_id BIGINT NOT NULL,
    staff_text varchar(100) NOT NULL,
    create_datetime DATETIME(6) NOT NULL,
    create_date DATE NOT NULL,
    state varchar(20) not null,
    CONSTRAINT staff_pk PRIMARY KEY (staff_id)
)