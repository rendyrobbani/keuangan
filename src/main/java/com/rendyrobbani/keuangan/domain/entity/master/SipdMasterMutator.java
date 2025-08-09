package com.rendyrobbani.keuangan.domain.entity.master;

import com.rendyrobbani.keuangan.common.marker.HasAuditMutatorSupport;
import com.rendyrobbani.keuangan.common.marker.HasLockMutatorSupport;
import com.rendyrobbani.keuangan.common.vo.nip.Nip;

import java.time.LocalDateTime;

public interface SipdMasterMutator<ID, DATAID, DATA> extends SipdMaster<ID, DATAID, DATA>, HasLockMutatorSupport, HasAuditMutatorSupport {

	@Override
	default void delete(LocalDateTime deletedAt, Nip deletedBy) {
		HasLockMutatorSupport.super.lock(deletedAt, deletedBy);
		HasAuditMutatorSupport.super.delete(deletedAt, deletedBy);
	}

}