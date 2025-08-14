package com.rendyrobbani.keuangan.infrastructure.persistence.repository.master;

import com.rendyrobbani.keuangan.domain.model.entity.master.DataMaster;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.master.DataMasterRepository;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.DataMasterEntity;
import com.rendyrobbani.keuangan.infrastructure.persistence.repository.*;

public abstract class AbstractDataMasterRepositoryImpl<ENTITY extends DataMasterEntity<DOMAIN, ID>, DOMAIN extends DataMaster<ID>, ID> implements DataMasterRepository<DOMAIN, ID>,
                                                                                                                                                  SelectRepositoryOperation<ENTITY, DOMAIN, ID>,
                                                                                                                                                  CreateRepositoryOperation<ENTITY, DOMAIN, ID>,
                                                                                                                                                  UpdateRepositoryOperation<ENTITY, DOMAIN, ID>,
                                                                                                                                                  DeleteRepositoryOperation<ENTITY, DOMAIN, ID>,
                                                                                                                                                  LockedRepositoryOperation<ENTITY, DOMAIN, ID> {

}