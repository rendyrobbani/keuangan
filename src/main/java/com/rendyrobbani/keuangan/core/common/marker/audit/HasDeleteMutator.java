package com.rendyrobbani.keuangan.core.common.marker.audit;

import com.rendyrobbani.keuangan.core.common.vo.Nip;

import java.time.LocalDateTime;

public interface HasDeleteMutator {

	void delete(LocalDateTime deletedAt,
	            Nip deletedBy);

	void restore(LocalDateTime restoredAt,
	             Nip restoredBy);

}