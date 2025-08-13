package com.rendyrobbani.keuangan.infrastructure.persistence.entity;

import com.rendyrobbani.keuangan.domain.model.entity.Logs;

public interface LogsEntity<DOMAIN, SUBJECTID> extends BaseEntity<DOMAIN, Long>,
                                                       Logs<SUBJECTID> {

}