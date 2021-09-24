
drop table IF exists employees cascade;
drop sequence IF exists hibernate_sequence cascade;

-- create tables

create table employees
(
    id            bigint       not null
        constraint employees_pkey
            primary key,
    email_address varchar(255) not null,
    first_name    varchar(255) not null,
    last_name     varchar(255) not null
);

create sequence hibernate_sequence;

create index employee_id_index ON employees (id);
