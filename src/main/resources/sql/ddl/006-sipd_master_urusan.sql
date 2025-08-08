drop table if exists sipd_master_urusan;

create or replace table sipd_master_urusan (
	id         bigint(20)   not null,
	code       char(1)      not null,
	name       varchar(255) not null,
	is_locked  bit(1)       not null,
	locked_at  datetime     null,
	locked_by  char(18)     null,
	created_at datetime     not null,
	created_by char(18)     not null,
	updated_at datetime     null,
	updated_by char(18)     null,
	is_deleted bit(1)       not null,
	deleted_at datetime     null,
	deleted_by char(18)     null,
	urusan_id  char(1)      not null,
	constraint fk_sipd_master_urusan_01 foreign key (locked_by) references data_user (id),
	constraint fk_sipd_master_urusan_02 foreign key (created_by) references data_user (id),
	constraint fk_sipd_master_urusan_03 foreign key (updated_by) references data_user (id),
	constraint fk_sipd_master_urusan_04 foreign key (deleted_by) references data_user (id),
	constraint fk_sipd_master_urusan_05 foreign key (urusan_id) references data_master_urusan (id),
	primary key (id)
) engine = innodb
  charset = utf8mb4
  collate = utf8mb4_unicode_ci;