package com.rendyrobbani.keuangan.domain.port.outgoing.repository.master;

import com.rendyrobbani.keuangan.domain.model.entity.master.DataMaster;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.*;

public interface DataMasterRepository<DOMAIN extends DataMaster<ID>, ID> extends SelectRepository<DOMAIN, ID>,
                                                                                 CreateRepository<DOMAIN, ID>,
                                                                                 UpdateRepository<DOMAIN, ID>,
                                                                                 DeleteRepository<DOMAIN, ID>,
                                                                                 LockedRepository<DOMAIN, ID> {

}