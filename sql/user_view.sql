-- auto-generated definition
create table user_view
(
    user_id int not null comment '用户id',
    view_id int not null comment '页面id',
    constraint user_view_user_uid_fk
        foreign key (user_id) references user (uid),
    constraint user_view_view_id_fk
        foreign key (view_id) references view (id)
);

