package com.rendyrobbani.keuangan.domain.port.outgoing.repository.master.codes;

import com.rendyrobbani.keuangan.domain.model.entity.master.codes.DataMasterCodes;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.master.DataMasterRepository;

public interface DataMasterCodesRepository<DOMAIN extends DataMasterCodes> extends DataMasterRepository<DOMAIN, String> {

}