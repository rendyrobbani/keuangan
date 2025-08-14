package com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.codes;

import com.rendyrobbani.keuangan.domain.model.entity.master.codes.DataMasterCodes;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.DataMasterEntity;

public interface DataMasterCodesEntity<DOMAIN> extends DataMasterCodes,
                                                       DataMasterEntity<DOMAIN, String> {

}