package com.rendyrobbani.keuangan.infrastructure.persistence.entity;

import com.rendyrobbani.keuangan.domain.model.entity.Data;

public interface DataEntity<ID, DOMAIN> extends BaseEntity<ID, DOMAIN>,
                                                Data<ID> {

}