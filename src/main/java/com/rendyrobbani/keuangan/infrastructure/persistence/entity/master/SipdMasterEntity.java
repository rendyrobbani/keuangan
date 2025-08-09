package com.rendyrobbani.keuangan.infrastructure.persistence.entity.master;

import com.rendyrobbani.keuangan.common.vo.nip.Nip;
import com.rendyrobbani.keuangan.infrastructure.persistence.converter.NipConverter;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
public abstract class SipdMasterEntity extends BaseEntity {

	@Column(name = "is_locked")
	protected boolean isLocked;

	@Column(name = "locked_at")
	protected LocalDateTime lockedAt;

	@Convert(converter = NipConverter.class)
	@Column(name = "locked_by")
	protected Nip lockedBy;

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