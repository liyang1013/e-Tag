-- auto-generated definition
create table deviceinfo
(
    name      varchar(15) null,
    clientid  varchar(20) not null
        primary key,
    model     varchar(12) null,
    version   varchar(10) null,
    freeSpace int         null,
    storage   int         null,
    ip        varchar(15) null,
    remarks   varchar(25) null comment '备注'
);

