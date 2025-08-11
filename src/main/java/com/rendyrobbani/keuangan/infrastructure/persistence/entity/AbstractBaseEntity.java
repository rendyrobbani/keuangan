package com.rendyrobbani.keuangan.infrastructure.persistence.entity;

import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.infrastructure.persistence.converter.NipConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = false, fluent = true)
@NoArgsConstructor
@MappedSuperclass
@SuppressWarnings("unchecked")
public abstract class AbstractBaseEntity<ID, DOMAIN, ENTITY extends DOMAIN> implements BaseEntity<ID, DOMAIN, ENTITY>,
                                                                                       Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Column(name = "created_at")
	protected LocalDateTime createdAt;

	@Convert(converter = NipConverter.class)
	@Column(name = "created_by")
	protected Nip createdBy;

	@Override
	public ENTITY create(LocalDateTime createdAt, Nip createdBy) {
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		return (ENTITY) this;
	}

}