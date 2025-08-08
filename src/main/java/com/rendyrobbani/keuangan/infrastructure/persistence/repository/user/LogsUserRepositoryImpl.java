package com.rendyrobbani.keuangan.infrastructure.persistence.repository.user;

import com.rendyrobbani.keuangan.domain.entity.user.LogsUser;
import com.rendyrobbani.keuangan.domain.repository.user.LogsUserRepository;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.user.LogsUserEntity;
import com.rendyrobbani.keuangan.infrastructure.persistence.repository.BaseRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class LogsUserRepositoryImpl extends BaseRepositoryImpl<Long, LogsUser, LogsUserEntity> implements LogsUserRepository {

	private final LogsUserJpaRepository repository;

	public LogsUserRepositoryImpl(LogsUserJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected JpaRepository<LogsUserEntity, Long> repository() {
		return repository;
	}

}