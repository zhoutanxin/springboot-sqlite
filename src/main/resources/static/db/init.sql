drop table if exists sys_login_account;

CREATE TABLE sys_login_account (
    id           INT (11)      NOT NULL,
    account      VARCHAR (50),
    password     VARCHAR (50),
    ori_password VARCHAR (50),
    email        VARCHAR (100),
    phone        VARCHAR (20),
    login_type   INT,
    status       INT,
    created      TEXT,
    modified     TEXT,
    PRIMARY KEY (
        id
    )
);


drop table if exists sys_dbconnection;

/*==============================================================*/
/* Table: sys_dbconnection                                      */
/*==============================================================*/
create table sys_dbconnection
(
   id                   int(11),
   ali_name            varchar(500),-- comment '数据库别名',
   ip               varchar(50),-- comment 'IP地址',
   port                varchar(10),-- comment '端口号',
   username                varchar(255),-- comment '用户名',
   passwd                 varchar(255),-- comment '密码',
   dbname               varchar(255),-- comment '数据库',
   create_time              text,-- comment '创建时间'
   primary key(id)
);



drop table if exists sys_field_note;

/*==============================================================*/
/* Table: sys_field_note                                        */
/*==============================================================*/
create table sys_field_note
(
   id                   int(11) not null,
   dbconnect_id         int(11),
   field_name           varchar(255),
   field_type           varchar(255),
   field_lenght         int(11),
   decimal_point        int(11),
   default_val          varchar(255),
   oprate_type          int,
   state                int,
   creat_time           datetime,
   primary key (id)
);


drop table if exists sys_execute_log;

/*==============================================================*/
/* Table: sys_execute_log                                       */
/*==============================================================*/
create table sys_execute_log
(
   id                   int(11) not null,
   title                varchar(500),
   call_method          varchar(1000),
   call_param           varchar(1000),
   operator             varchar(50),
   create_time          datetime,
   is_exception         tinyint,
   response_time        int,
   primary key (id)
);
