--liquibase formatted sql

--changeset asoldatov:student1
create sequence if not exists hibernate_sequence
    increment 1
    minvalue 1
    maxvalue 9223372036854775807
    start 1
    cache 1;
--rollback drop sequence hibernate_sequence;
--comment: Добавлен hibernate_sequence

--changeset asoldatov:student2
create table if not exists student
(
    id          int8 default nextval('hibernate_sequence'::regclass) not null primary key unique,
    name        varchar(64)                                          not null,
    email       varchar(64)                                          not null unique,
    card_number varchar(64)                                          not null,
    group_name  varchar(64)                                          not null,
    subgroup    varchar(64)                                          not null
);
--rollback drop table student;
--comment: Создана таблица student

--changeset asoldatov:movie1
create table if not exists movie
(
    id     int8 default nextval('hibernate_sequence'::regclass) not null primary key unique,
    name   varchar(64)                                          not null unique,
    author varchar(64)                                          not null
);
--rollback drop table movie;
--comment: Создана таблица movie

--changeset akorzh:hotel1
create table if not exists hotel
(
    id            int8 default nextval('hibernate_sequence'::regclass) not null primary key unique,
    name          varchar(64)                                          not null unique,
    count_visitor bigint                                               not null,
    director_name varchar(64)                                          not null,
    address       varchar(64)                                          not null
);
--rollback drop table hotel;
--comment: Создана таблица hotel

--changeset akorzh:users1
create table if not exists users
(
    id       int8 default nextval('hibernate_sequence'::regclass) not null primary key unique,
    login    varchar(64)                                          not null unique,
    password varchar(256)                                         not null
);
--rollback drop table users;
--comment: Создана таблица users

--changeset akorzh:roles1
create table if not exists roles
(
    id   int8 default nextval('hibernate_sequence'::regclass) not null primary key unique,
    name varchar(64)                                          not null unique
);
--rollback drop table roles;
--comment: Создана таблица roles

--changeset akorzh:user_roles1
create table if not exists user_roles
(
    user_id int8 not null
        constraint fk_users references users (id),
    role_id int8 not null
        constraint fk_roles references roles (id)
);
--rollback drop table user_roles;
--comment: Создана таблица user_roles
