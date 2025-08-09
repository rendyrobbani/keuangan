package com.rendyrobbani.keuangan.infrastructure.persistence.entities.user;

import com.rendyrobbani.keuangan.common.util.name.NameUtil;
import com.rendyrobbani.keuangan.common.vo.Gender;
import com.rendyrobbani.keuangan.common.vo.Pangkat;
import com.rendyrobbani.keuangan.common.vo.nip.Nip;
import com.rendyrobbani.keuangan.domain.entities.user.DataUser;
import com.rendyrobbani.keuangan.infrastructure.persistence.converter.GenderConverter;
import com.rendyrobbani.keuangan.infrastructure.persistence.converter.NipConverter;
import com.rendyrobbani.keuangan.infrastructure.persistence.converter.PangkatConverter;
import com.rendyrobbani.keuangan.infrastructure.persistence.marker.*;
import com.rendyrobbani.keuangan.schema.table.user.DataUserTable;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Accessors(fluent = true)
@Table(name = DataUserTable.NAME)
public class DataUserEntity implements DataUser,
                                       HasLockAccessor,
                                       HasLockMutator<DataUserEntity>,
                                       HasCreateAccessor,
                                       HasCreateMutator<DataUserEntity>,
                                       HasUpdateAccessor,
                                       HasUpdateMutator<DataUserEntity>,
                                       HasDeleteAccessor,
                                       HasDeleteMutator<DataUserEntity>,
                                       Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private String id;

	@Convert(converter = NipConverter.class)
	@Column(name = "id", insertable = false, updatable = false)
	private Nip nip;

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
	public String onlyName(boolean toUpperCase) {
		return NameUtil.onlyName(name, toUpperCase);
	}

	@Override
	public String fullName(boolean toUpperCase) {
		return NameUtil.fullName(name, toUpperCase, titlePrefix, titleSuffix);
	}

	@Override
	public void create(Nip nip,
	                   Pangkat pangkat,
	                   String name,
	                   String titlePrefix,
	                   String titleSuffix,
	                   String password,
	                   LocalDate startDate,
	                   LocalDateTime createdAt,
	                   Nip createdBy) {
		if (id != null) return;

		id(nip.value());
		nip(nip);
		pangkat(pangkat);
		name(name);
		titlePrefix(titlePrefix);
		titleSuffix(titleSuffix);
		password(password);
		birthDate(nip.birthDate());
		startDate(nip.startDate());
		gender(nip.gender());
		number(nip.number());
		isPNS(pangkat.isPNS());
		isP3K(pangkat.isP3K());
		isLocked(false);
		createdAt(createdAt);
		createdBy(createdBy);
		isDeleted(false);
	}

	@Override
	public void update(Pangkat pangkat,
	                   String name,
	                   String titlePrefix,
	                   String titleSuffix,
	                   String password,
	                   LocalDate startDate,
	                   LocalDateTime updatedAt,
	                   Nip updatedBy) {
		if (id == null) return;

		pangkat(pangkat);
		name(name);
		titlePrefix(titlePrefix);
		titleSuffix(titleSuffix);
		password(password);
		startDate(startDate);
		isPNS(pangkat.isPNS());
		isP3K(pangkat.isP3K());
		updatedAt(updatedAt);
		updatedBy(updatedBy);
	}

}