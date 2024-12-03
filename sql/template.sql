-- auto-generated definition
create table template
(
    uuid      varchar(36)          not null comment '唯一主键'
        primary key,
    x         int                  null,
    y         int                  null,
    width     int                  null,
    height    int                  null,
    name      varchar(100)         null,
    md5       varchar(32)          null,
    type      varchar(10)          null,
    client_id varchar(15)          null
);

