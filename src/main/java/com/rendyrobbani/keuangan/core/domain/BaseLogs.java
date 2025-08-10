package com.rendyrobbani.keuangan.core.domain;

import com.rendyrobbani.keuangan.core.common.marker.audit.HasCreateAccessor;
import com.rendyrobbani.keuangan.core.common.marker.audit.HasDeleteAccessor;
import com.rendyrobbani.keuangan.core.common.marker.audit.HasUpdateAccessor;

public interface BaseLogs<SUBJECTID, SUBJECT extends BaseData<SUBJECTID>> extends HasCreateAccessor,
                                                                                  HasUpdateAccessor,
                                                                                  HasDeleteAccessor {

	Long id();

	SUBJECTID subjectId();

	SUBJECT subject();

}