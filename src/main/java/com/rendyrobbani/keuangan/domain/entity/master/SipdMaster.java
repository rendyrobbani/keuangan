package com.rendyrobbani.keuangan.domain.entity.master;

import com.rendyrobbani.keuangan.common.marker.HasAuditMutator;
import com.rendyrobbani.keuangan.common.marker.HasLockMutator;

public interface SipdMaster<ID, DATAID, DATA> extends HasLockMutator, HasAuditMutator {

	ID getId();

	DATAID getDataId();

	void setDataId(DATAID dataId);

	DATA getData();

}