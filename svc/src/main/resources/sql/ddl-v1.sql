create table if not exists doc
(
    id            bigint unsigned auto_increment comment '主键'
    primary key,
    name          varchar(128)                          null comment '文档名称',
    type          int unsigned                          not null comment '文档类型',
    configuration json                                  null comment '配置,样式等',
    deleted       tinyint(1)  default 0                 not null comment '0-未删除',
    creator_id    bigint unsigned                       null comment '创建者ID',
    creator       varchar(16) default ''                null comment '创建者',
    modifier_id   bigint unsigned                       null comment '修改者ID',
    create_time   datetime    default CURRENT_TIMESTAMP null comment '创建时间',
    update_time   datetime    default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '修改时间'
    )
    comment '文档';

create table if not exists paragraph
(
    id            bigint unsigned auto_increment comment '主键'
    primary key,
    doc_id        bigint unsigned                      not null comment '所属文档',
    title_id      bigint unsigned                      not null comment '所属标题',
    content       text                                 not null comment '段落内容',
    configuration json                                 not null comment '配置,样式等',
    follow_id     bigint unsigned                      not null comment '前序段落ID',
    deleted       tinyint(1) default 0                 not null comment '0-未删除',
    create_time   datetime   default CURRENT_TIMESTAMP null comment '创建时间',
    update_time   datetime   default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '修改时间'
    )
    comment '段落';

create table if not exists title
(
    id            bigint unsigned auto_increment comment '主键'
    primary key,
    doc_id        bigint unsigned                      not null comment '文档ID',
    content       varchar(128)                         not null comment '标题内容',
    configuration json                                 not null comment '配置,样式等',
    follow_id     bigint unsigned                      not null comment '前序标题ID',
    deleted       tinyint(1) default 0                 not null comment '0-未删除',
    create_time   datetime   default CURRENT_TIMESTAMP null comment '创建时间',
    update_time   datetime   default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '修改时间'
    )
    comment '文档标题';

