package com.rendyrobbani.keuangan.domain.port.outgoing.repository;

import java.util.List;
import java.util.Optional;

public interface SelectRepository<ID, DOMAIN> {

	List<DOMAIN> selectAll();

	Optional<DOMAIN> selectById(ID id);

}