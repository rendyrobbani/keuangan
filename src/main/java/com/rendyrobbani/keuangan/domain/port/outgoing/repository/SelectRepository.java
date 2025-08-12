package com.rendyrobbani.keuangan.domain.port.outgoing.repository;

import com.rendyrobbani.keuangan.domain.model.entity.Base;

import java.util.List;
import java.util.Optional;

public interface SelectRepository<ID, DOMAIN extends Base<ID>> {

	List<DOMAIN> selectAll();

	Optional<DOMAIN> selectById(ID id);

}