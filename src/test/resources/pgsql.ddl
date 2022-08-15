CREATE TABLE staff (
    staff_id int8 NOT NULL,
    staff_text varchar NOT NULL,
    create_datetime timestamp NOT NULL,
    create_date date NOT NULL,
    state varchar not null,
    CONSTRAINT staff_pk PRIMARY KEY (staff_id)
);