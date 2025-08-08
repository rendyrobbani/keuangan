package com.rendyrobbani.keuangan.infrastructure.entity.user;

import com.rendyrobbani.keuangan.common.vo.Gender;
import com.rendyrobbani.keuangan.common.vo.Pangkat;
import com.rendyrobbani.keuangan.common.vo.nip.Nip;
import com.rendyrobbani.keuangan.domain.entity.user.DataUser;
import com.rendyrobbani.keuangan.domain.entity.user.DataUserMutator;
import com.rendyrobbani.keuangan.infrastructure.converter.GenderConverter;
import com.rendyrobbani.keuangan.infrastructure.converter.NipConverter;
import com.rendyrobbani.keuangan.infrastructure.converter.PangkatConverter;
import com.rendyrobbani.keuangan.infrastructure.entity.BaseEntity;
import com.rendyrobbani.keuangan.schema.table.user.DataUserTable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = DataUserTable.NAME)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DataUserEntity extends BaseEntity implements DataUser, DataUserMutator {

	@Id
	@Column(name = "id")
	private String id;

	@Convert(converter = NipConverter.class)
	@Column(name = "id", insertable = false, updatable = false)
	private Nip nip;

	@Setter(AccessLevel.NONE)
	@Convert(converter = PangkatConverter.class)
	@Column(name = "pangkat")
	private Pangkat pangkat;

	@Column(name = "name")
	private String name;

	@Column(name = "title_prefix")
	private String titlePrefix;

	@Column(name = "title_suffix")
	private String titleSuffix;

	@Column(name = "password")
	private String password;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	@Column(name = "start_date")
	private LocalDate startDate;

	@Convert(converter = GenderConverter.class)
	@Column(name = "gender")
	private Gender gender;

	@Column(name = "number")
	private Integer number;

	@Column(name = "is_pns")
	private boolean isPNS;

	@Column(name = "is_p3k")
	private boolean isP3K;

	@Column(name = "is_locked")
	private boolean isLocked;

	@Column(name = "locked_at")
	private LocalDateTime lockedAt;

	@Convert(converter = NipConverter.class)
	@Column(name = "locked_by")
	private Nip lockedBy;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Convert(converter = NipConverter.class)
	@Column(name = "created_by")
	private Nip createdBy;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@Convert(converter = NipConverter.class)
	@Column(name = "updated_by")
	private Nip updatedBy;

	@Column(name = "is_deleted")
	private boolean isDeleted;

	@Column(name = "deleted_at")
	private LocalDateTime deletedAt;

	@Convert(converter = NipConverter.class)
	@Column(name = "deleted_by")
	private Nip deletedBy;

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

		this.id = nip.getValue();

		this.birthDate = nip.getBirthDate();
		this.startDate = nip.getStartDate();
		this.gender = nip.getGender();
		this.number = nip.getNumber();

		this.isLocked = false;
		this.isDeleted = false;
	}

}