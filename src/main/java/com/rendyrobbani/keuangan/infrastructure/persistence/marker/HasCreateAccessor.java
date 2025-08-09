package com.rendyrobbani.keuangan.infrastructure.persistence.marker;

import com.rendyrobbani.keuangan.common.vo.nip.Nip;

import java.time.LocalDateTime;

public interface HasCreateAccessor {

	LocalDateTime createdAt();

	Nip createdBy();

}