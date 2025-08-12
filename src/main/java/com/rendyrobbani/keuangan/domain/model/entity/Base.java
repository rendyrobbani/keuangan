package com.rendyrobbani.keuangan.domain.model.entity;

import com.rendyrobbani.keuangan.domain.model.vo.Nip;

import java.time.LocalDateTime;

public interface Base<ID> {

	ID id();

	void create(LocalDateTime createdAt, Nip createdBy);

}