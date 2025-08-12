package com.rendyrobbani.keuangan.infrastructure.persistence.mapper.user;

import com.rendyrobbani.keuangan.domain.model.entity.user.DataUser;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.adapter.user.DataUserEntity;
import com.rendyrobbani.keuangan.infrastructure.persistence.mapper.DataMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DataUserEntityMapper implements DataMapper<DataUser, DataUserEntity> {

	private static DataUserEntityMapper instance;

	public static DataUserEntityMapper getInstance() {
		if (instance == null) instance = new DataUserEntityMapper();
		return instance;
	}

	@Override
	public DataUserEntity create(DataUser domain, LocalDateTime createdAt, Nip createdBy) {
		var entity = new DataUserEntity();
		entity.sync(domain);
		entity.create(createdAt, createdBy);
		return entity;
	}

	@Override
	public DataUserEntity update(DataUser domain, LocalDateTime updatedAt, Nip updatedBy, DataUserEntity entity) {
		entity.sync(domain);
		entity.update(updatedAt, updatedBy);
		return entity;
	}

}