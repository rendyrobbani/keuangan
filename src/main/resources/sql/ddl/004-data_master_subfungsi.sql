drop table if exists data_master_subfungsi;

create or replace table data_master_subfungsi (
	id         char(5)      not null,
	code       char(5)      not null,
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
	fungsi_id  char(5)      not null,
	constraint ck_data_master_subfungsi_01 check (id = code),
	constraint ck_data_master_subfungsi_02 check (fungsi_id is null or (left(id, length(fungsi_id)) = fungsi_id)),
	constraint fk_data_master_subfungsi_01 foreign key (locked_by) references data_user (id),
	constraint fk_data_master_subfungsi_02 foreign key (created_by) references data_user (id),
	constraint fk_data_master_subfungsi_03 foreign key (updated_by) references data_user (id),
	constraint fk_data_master_subfungsi_04 foreign key (deleted_by) references data_user (id),
	constraint fk_data_master_subfungsi_05 foreign key (fungsi_id) references data_master_fungsi (id),
	constraint uk_data_master_subfungsi_01 Unique key (fungsi_id, id),
	primary key (id)
) engine = innodb
  charset = utf8mb4
  collate = utf8mb4_unicode_ci;