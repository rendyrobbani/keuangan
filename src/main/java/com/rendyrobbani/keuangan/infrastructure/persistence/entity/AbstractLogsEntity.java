package com.rendyrobbani.keuangan.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = false, fluent = true)
@NoArgsConstructor
@MappedSuperclass
public abstract class AbstractLogsEntity<DOMAIN, SUBJECTID> extends AbstractBaseEntity<DOMAIN, Long> implements LogsEntity<DOMAIN, SUBJECTID> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;



}