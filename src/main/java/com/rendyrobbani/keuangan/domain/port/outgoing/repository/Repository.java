package com.rendyrobbani.keuangan.domain.port.outgoing.repository;

import com.rendyrobbani.keuangan.domain.model.vo.Nip;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface Repository<ID, DOMAIN> {

	List<DOMAIN> findAll();

	Optional<DOMAIN> findById(ID id);

	DOMAIN save(DOMAIN domain, LocalDateTime saveAt, Nip saveBy);

}