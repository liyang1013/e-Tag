-- auto-generated definition
create table device_template
(
    client_id   varchar(15) not null comment '设备id',
    template_id varchar(36) not null comment '模板id',
    constraint device_template_devices_client_id_fk
        foreign key (client_id) references devices (client_id)
)
    comment '设备模板表';

