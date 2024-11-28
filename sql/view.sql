-- auto-generated definition
create table view
(
    id        int auto_increment
        primary key,
    name      varchar(20) null comment '名称',
    path      varchar(20) null,
    component varchar(50) null,
    icon      varchar(30) null,
    sort      int         null
);
