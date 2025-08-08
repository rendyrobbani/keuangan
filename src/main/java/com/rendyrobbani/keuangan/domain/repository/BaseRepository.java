package com.rendyrobbani.keuangan.domain.repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<ID, DOMAIN> {

	List<DOMAIN> findAll();

	Optional<DOMAIN> findById(ID id);

	DOMAIN save(DOMAIN domain);

}