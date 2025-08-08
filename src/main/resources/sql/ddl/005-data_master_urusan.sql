drop table if exists data_master_urusan;

create or replace table data_master_urusan (
	id         char(1)      not null,
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
	constraint ck_data_master_urusan_01 check (id = replace(code, 'X', '0')),
	constraint fk_data_master_urusan_01 foreign key (locked_by) references data_user (id),
	constraint fk_data_master_urusan_02 foreign key (created_by) references data_user (id),
	constraint fk_data_master_urusan_03 foreign key (updated_by) references data_user (id),
	constraint fk_data_master_urusan_04 foreign key (deleted_by) references data_user (id),
	primary key (id)
) engine = innodb
  charset = utf8mb4
  collate = utf8mb4_unicode_ci;