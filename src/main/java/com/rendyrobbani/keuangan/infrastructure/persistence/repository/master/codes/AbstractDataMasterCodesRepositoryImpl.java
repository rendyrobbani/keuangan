package com.rendyrobbani.keuangan.infrastructure.persistence.repository.master.codes;

import com.rendyrobbani.keuangan.domain.model.entity.master.codes.DataMasterCodes;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.codes.DataMasterCodesEntity;
import com.rendyrobbani.keuangan.infrastructure.persistence.repository.master.AbstractDataMasterRepositoryImpl;

public abstract class AbstractDataMasterCodesRepositoryImpl<ENTITY extends DataMasterCodesEntity<DOMAIN>, DOMAIN extends DataMasterCodes> extends AbstractDataMasterRepositoryImpl<ENTITY, DOMAIN, String> {

}