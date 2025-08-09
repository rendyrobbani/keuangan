package com.rendyrobbani.keuangan.domain.entity.master;

import com.rendyrobbani.keuangan.common.marker.HasAuditMutator;
import com.rendyrobbani.keuangan.common.marker.HasLockMutator;

public interface DataMaster<ID> extends HasLockMutator, HasAuditMutator {

	ID getId();

}