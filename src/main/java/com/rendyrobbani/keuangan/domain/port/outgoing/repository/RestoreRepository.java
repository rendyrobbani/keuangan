package com.rendyrobbani.keuangan.domain.port.outgoing.repository;

import com.rendyrobbani.keuangan.domain.model.entity.Data;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;

import java.time.LocalDateTime;

public interface RestoreRepository<DOMAIN extends Data<ID>, ID> {

	DOMAIN restore(DOMAIN domain, LocalDateTime restoredAt, Nip restoredBy);

}