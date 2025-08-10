package com.rendyrobbani.keuangan.core.domain;

import com.rendyrobbani.keuangan.core.common.marker.audit.*;

public interface BaseData<ID> extends HasCreateAccessor,
                                      HasCreateMutator,
                                      HasUpdateAccessor,
                                      HasUpdateMutator,
                                      HasDeleteAccessor,
                                      HasDeleteMutator {

	ID id();

}