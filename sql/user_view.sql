-- auto-generated definition
create table role_view
(
    role_id varchar(10) null,
    view_id int         null,
    constraint role_view_view_id_fk
        foreign key (view_id) references view (id)
);

