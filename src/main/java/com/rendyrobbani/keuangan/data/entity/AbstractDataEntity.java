package com.rendyrobbani.keuangan.data.entity;

import com.rendyrobbani.keuangan.core.common.vo.Nip;
import com.rendyrobbani.keuangan.core.domain.BaseData;
import com.rendyrobbani.keuangan.data.converter.NipConverter;
import com.rendyrobbani.keuangan.data.support.HasCreateSupport;
import com.rendyrobbani.keuangan.data.support.HasDeleteSupport;
import com.rendyrobbani.keuangan.data.support.HasUpdateSupport;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter(AccessLevel.PROTECTED)
@Accessors(chain = false, fluent = true)
@NoArgsConstructor
@MappedSuperclass
public abstract class AbstractDataEntity<ID> implements BaseData<ID>,
                                                        HasCreateSupport,
                                                        HasUpdateSupport,
                                                        HasDeleteSupport,
                                                        Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Column(name = "created_at")
	protected LocalDateTime createdAt;

	@Convert(converter = NipConverter.class)
	@Column(name = "created_by")
	protected Nip createdBy;

	@Column(name = "updated_at")
	protected LocalDateTime updatedAt;

	@Convert(converter = NipConverter.class)
	@Column(name = "updated_by")
	protected Nip updatedBy;

	@Column(name = "is_deleted")
	protected boolean isDeleted;

	@Column(name = "deleted_at")
	protected LocalDateTime deletedAt;

	@Convert(converter = NipConverter.class)
	@Column(name = "deleted_by")
	protected Nip deletedBy;

}