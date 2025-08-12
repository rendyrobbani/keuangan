package com.rendyrobbani.keuangan.infrastructure.persistence.repository.adapter.user;

import com.rendyrobbani.keuangan.domain.model.entity.user.DataUser;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.DataUserRepository;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.adapter.user.DataUserEntity;
import com.rendyrobbani.keuangan.infrastructure.persistence.mapper.BaseMapper;
import com.rendyrobbani.keuangan.infrastructure.persistence.mapper.user.DataUserEntityMapper;
import com.rendyrobbani.keuangan.infrastructure.persistence.repository.operation.CreateRepositoryOperation;
import com.rendyrobbani.keuangan.infrastructure.persistence.repository.operation.SelectRepositoryOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DataUserRepositoryImpl implements DataUserRepository,
                                               SelectRepositoryOperation<String, DataUser, DataUserEntity>,
                                               CreateRepositoryOperation<String, DataUser, DataUserEntity> {

	private final DataUserJpaRepository repository;

	public DataUserRepositoryImpl(DataUserJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	public JpaRepository<DataUserEntity, String> repository() {
		return repository;
	}

	@Override
	public BaseMapper<DataUser, DataUserEntity> mapper() {
		return DataUserEntityMapper.getInstance();
	}

}