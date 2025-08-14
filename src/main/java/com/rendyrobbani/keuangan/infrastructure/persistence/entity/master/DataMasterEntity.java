package com.rendyrobbani.keuangan.infrastructure.persistence.entity.master;

import com.rendyrobbani.keuangan.domain.model.entity.master.DataMaster;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.LockEntity;

public interface DataMasterEntity<DOMAIN, ID> extends DataMaster<ID>,
                                                      LockEntity<DOMAIN, ID> {

}