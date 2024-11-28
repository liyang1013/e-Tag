-- auto-generated definition
create table user
(
    uid             int auto_increment
        primary key,
    license_time    datetime             null comment '有效期',
    username        varchar(20)          null comment '用户名',
    password        varchar(64)          null comment '密码',
    last_login_time datetime             null comment '上次登入时间',
    ip_address      varchar(15)          null comment '登入地址',
    appid           varchar(32)          null comment '用户许可',
    app_secret      varchar(32)          null,
    status          tinyint(1) default 1 null comment '状态',
    role            varchar(10)          null comment '角色',
    city            varchar(50)          null
);
