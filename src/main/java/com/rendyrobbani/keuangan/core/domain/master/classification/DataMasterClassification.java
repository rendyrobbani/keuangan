package com.rendyrobbani.keuangan.core.domain.master.classification;

import com.rendyrobbani.keuangan.core.common.marker.HasName;
import com.rendyrobbani.keuangan.core.common.marker.audit.HasLockAccessor;
import com.rendyrobbani.keuangan.core.common.marker.audit.HasLockMutator;
import com.rendyrobbani.keuangan.core.domain.master.DataMaster;

public interface DataMasterClassification extends DataMaster<String>,
                                                  HasName,
                                                  HasLockAccessor,
                                                  HasLockMutator {

	String code();

	@Override
	String name();

}