package com.rendyrobbani.keuangan.infrastructure.persistence.repository.user;

import com.rendyrobbani.keuangan.domain.entity.user.DataUser;
import com.rendyrobbani.keuangan.domain.repository.user.DataUserRepository;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.user.DataUserEntity;
import com.rendyrobbani.keuangan.infrastructure.persistence.repository.BaseRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DataUserRepositoryImpl extends BaseRepositoryImpl<String, DataUser, DataUserEntity> implements DataUserRepository {

	private final DataUserJpaRepository repository;

	public DataUserRepositoryImpl(DataUserJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected JpaRepository<DataUserEntity, String> repository() {
		return repository;
	}

}