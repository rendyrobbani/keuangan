package com.rendyrobbani.keuangan.infrastructure.persistence.entity;

import com.rendyrobbani.keuangan.domain.model.entity.Data;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.infrastructure.persistence.converter.NipConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = false, fluent = true)
@NoArgsConstructor
@MappedSuperclass
public abstract class AbstractDataEntity<ID, DOMAIN> extends AbstractBaseEntity<ID, DOMAIN> implements Data<ID> {

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

	@Override
	public void update(LocalDateTime updatedAt, Nip updatedBy) {
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
	}

	@Override
	public void delete(LocalDateTime deletedAt, Nip deletedBy) {
		this.isDeleted = true;
		this.deletedAt = deletedAt;
		this.deletedBy = deletedBy;
	}

	@Override
	public void restore(LocalDateTime restoreAt, Nip restoreBy) {
		this.isDeleted = false;
		this.deletedAt = null;
		this.deletedBy = null;
		this.updatedAt = restoreAt;
		this.updatedBy = restoreBy;
	}

}