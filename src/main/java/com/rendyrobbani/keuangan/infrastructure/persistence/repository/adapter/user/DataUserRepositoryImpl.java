package com.rendyrobbani.keuangan.infrastructure.persistence.repository.adapter.user;

import com.rendyrobbani.keuangan.domain.model.entity.user.DataUser;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.DataUserRepository;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.adapter.user.DataUserEntity;
import com.rendyrobbani.keuangan.infrastructure.persistence.repository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class DataUserRepositoryImpl extends AbstractRepository<String, DataUser, DataUserEntity> implements DataUserRepository {

	private final DataUserJpaRepository repository;

	public DataUserRepositoryImpl(DataUserJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected JpaRepository<DataUserEntity, String> repository() {
		return repository;
	}

	@Override
	protected DataUserEntity sync(DataUserEntity entity, DataUser domain, LocalDateTime saveAt, Nip saveBy) {
		if (entity == null) {
			entity = new DataUserEntity();
			entity.isLocked(false);
			entity.isDeleted(false);
			entity.createdAt(saveAt);
			entity.createdBy(saveBy);
		} else {
			entity.updatedAt(saveAt);
			entity.updatedBy(saveBy);
		}
		entity.id(domain.id());
		entity.nip(domain.nip());
		entity.pangkat(domain.pangkat());
		entity.name(domain.name());
		entity.titlePrefix(domain.titlePrefix());
		entity.titleSuffix(domain.titleSuffix());
		entity.password(domain.password());
		entity.dateOfBirth(domain.dateOfBirth());
		entity.dateOfStart(domain.dateOfStart());
		entity.gender(domain.gender());
		entity.number(domain.number());
		entity.isPNS(domain.isPNS());
		entity.isP3K(domain.isP3K());
		return entity;
	}

}