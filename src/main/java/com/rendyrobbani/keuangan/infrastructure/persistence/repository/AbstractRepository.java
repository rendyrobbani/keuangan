package com.rendyrobbani.keuangan.infrastructure.persistence.repository;

import com.rendyrobbani.keuangan.domain.model.entity.Data;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public abstract class AbstractRepository<ID, DOMAIN extends Data<ID>, ENTITY extends DOMAIN> implements Repository<ID, DOMAIN> {

	protected abstract JpaRepository<ENTITY, ID> repository();

	protected abstract ENTITY sync(ENTITY entity, DOMAIN domain, LocalDateTime saveAt, Nip saveBy);

	private DOMAIN toDomain(ENTITY entity) {
		return entity;
	}

	@Override
	public List<DOMAIN> findAll() {
		return this.repository().findAll().stream().map(this::toDomain).toList();
	}

	@Override
	public Optional<DOMAIN> findById(ID id) {
		return this.repository().findById(id).map(this::toDomain);
	}

	@Override
	public DOMAIN save(DOMAIN domain, LocalDateTime saveAt, Nip saveBy) {
		ENTITY entity = this.sync(this.repository().findById(domain.id()).orElse(null), domain, saveAt, saveBy);
		return this.repository().save(entity);
	}

}