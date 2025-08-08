drop table if exists logs_user;

create or replace table logs_user (
	id           bigint(20)   not null auto_increment,
	pangkat      char(2)      not null,
	name         varchar(255) not null,
	title_prefix varchar(255) not null,
	title_suffix varchar(255) not null,
	password     varchar(255) not null,
	birth_date   date         not null,
	start_date   date         null,
	gender       tinyint(4)   not null,
	number       tinyint(4)   not null,
	is_locked    bit(1)       not null,
	locked_at    datetime     null,
	locked_by    char(18)     null,
	created_at   datetime     not null,
	created_by   char(18)     not null,
	updated_at   datetime     null,
	updated_by   char(18)     null,
	is_deleted   bit(1)       not null,
	deleted_at   datetime     null,
	deleted_by   char(18)     null,
	logged_at    datetime     null,
	logged_by    char(18)     null,
	subject_id   char(18)     not null,
	constraint ck_logs_user_01 check (pangkat regexp '[1-4][A-D]|4E|0[1-9]|1[0-7]'),
	constraint ck_logs_user_02 check (gender in (1, 2)),
	constraint ck_logs_user_03 check (number between 1 and 999),
	constraint fk_logs_user_01 foreign key (locked_by) references data_user (id),
	constraint fk_logs_user_02 foreign key (created_by) references data_user (id),
	constraint fk_logs_user_03 foreign key (updated_by) references data_user (id),
	constraint fk_logs_user_04 foreign key (deleted_by) references data_user (id),
	constraint fk_logs_user_05 foreign key (subject_id) references data_user (id),
	constraint fk_logs_user_06 foreign key (logged_by) references data_user (id),
	primary key (id)
) engine = innodb
  charset = utf8mb4
  collate = utf8mb4_unicode_ci;