-- auto-generated definition
create table devices
(
    client_id   varchar(15)                null comment '价签序列号',
    nlast       int        default 0       null,
    name        varchar(20)                null comment '自定义名称',
    last_time   datetime                   null comment '最近一次标签获取时间',
    update_time datetime                   null comment '修改时间',
    update_user int                        null comment '修改用户',
    status      tinyint(1) default 1       null comment '状态',
    create_user int                        null comment '创建用户',
    create_time datetime   default (now()) null comment '创建时间',
    constraint devices_pk
        unique (client_id),
    constraint devices_user_uid_fk
        foreign key (create_user) references user (uid),
    constraint devices_user_uid_fk_2
        foreign key (update_user) references user (uid)
);

