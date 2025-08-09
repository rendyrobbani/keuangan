package com.rendyrobbani.keuangan.infrastructure.persistence.entity.user;

import com.rendyrobbani.keuangan.common.vo.Pangkat;
import com.rendyrobbani.keuangan.common.vo.nip.Nip;
import com.rendyrobbani.keuangan.domain.entity.user.DataUser;
import com.rendyrobbani.keuangan.domain.entity.user.DataUserMutator;
import com.rendyrobbani.keuangan.infrastructure.persistence.converter.NipConverter;
import com.rendyrobbani.keuangan.schema.table.user.DataUserTable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = DataUserTable.NAME)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DataUserEntity extends BaseUserEntity implements DataUser, DataUserMutator {

	@Id
	@Column(name = "id")
	private String id;

	@Convert(converter = NipConverter.class)
	@Column(name = "id", insertable = false, updatable = false)
	private Nip nip;

	@Override
	public void setPangkat(Pangkat pangkat) {
		this.pangkat = pangkat;
		this.isPNS = pangkat.isPNS();
		this.isP3K = pangkat.isP3K();
	}

	public DataUserEntity(LocalDateTime createdAt, Nip createdBy, Nip nip) {
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.nip = nip;

		this.id = nip.value();

		this.birthDate = nip.birthDate();
		this.startDate = nip.startDate();
		this.gender = nip.gender();
		this.number = nip.number();

		this.isLocked = false;
		this.isDeleted = false;
	}

	public LogsUserEntity toLog(LocalDateTime loggedAt, Nip loggedBy) {
		return new LogsUserEntity(loggedAt, loggedBy, this);
	}

}