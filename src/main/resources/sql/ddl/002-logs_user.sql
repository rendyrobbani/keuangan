drop table if exists logs_user;

create or replace table logs_user (
	id            bigint(20)   not null auto_increment,
	pangkat       char(2)      null,
	name          varchar(255) null,
	title_prefix  varchar(255) null,
	title_suffix  varchar(255) null,
	password      varchar(255) null,
	date_of_birth date         null,
	date_of_start date         null,
	gender        tinyint(4)   null,
	number        smallint(6)  null,
	is_pns        bit(1)       null,
	is_p3k        bit(1)       null,
	is_locked     bit(1)       null,
	locked_by     char(18)     null,
	created_by    char(18)     null,
	updated_by    char(18)     null,
	is_deleted    bit(1)       null,
	deleted_by    char(18)     null,
	logged_at     datetime     null,
	logged_by     char(18)     null,
	subject_id    char(18)     null,
	constraint fk_logs_user_01 foreign key (locked_by) references data_user (id),
	constraint fk_logs_user_02 foreign key (created_by) references data_user (id),
	constraint fk_logs_user_03 foreign key (updated_by) references data_user (id),
	constraint fk_logs_user_04 foreign key (deleted_by) references data_user (id),
	constraint fk_logs_user_05 foreign key (subject_id) references data_user (id),
	primary key (id)
) engine = innodb
  charset = utf8mb4
  collate = utf8mb4_unicode_ci;