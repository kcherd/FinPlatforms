create table if not exists STUDENT
(
    ID BIGINT auto_increment not null primary key,
    NAME VARCHAR(100) not null,
    SURNAME VARCHAR(100) not null,
    PATRONYMIC VARCHAR(100) not null,
    BIRTHDAY DATE,
    GROUP_NAME VARCHAR(100) not null
);