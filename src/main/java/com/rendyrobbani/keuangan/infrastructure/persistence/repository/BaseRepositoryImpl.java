package com.rendyrobbani.keuangan.infrastructure.persistence.repository;

import com.rendyrobbani.keuangan.domain.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("unchecked")
public abstract class BaseRepositoryImpl<ID, DOMAIN, ENTITY> implements BaseRepository<ID, DOMAIN> {

	abstract protected JpaRepository<ENTITY, ID> repository();

	@Override
	public List<DOMAIN> findAll() {
		var domains = new ArrayList<DOMAIN>();
		for (var entity : repository().findAll()) domains.add((DOMAIN) entity);
		return domains;
	}

	@Override
	public Optional<DOMAIN> findById(ID id) {
		var entity = repository().findById(id).orElse(null);
		return Optional.ofNullable((DOMAIN) entity);
	}

	@Override
	public DOMAIN save(DOMAIN domain) {
		return (DOMAIN) repository().save((ENTITY) domain);
	}

}