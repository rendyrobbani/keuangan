package com.rendyrobbani.keuangan.domain.repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<DOMAIN, DOMAINID> {

	List<DOMAIN> findAll();

	Optional<DOMAIN> findById(DOMAINID id);

	DOMAIN save(DOMAIN domain);

}