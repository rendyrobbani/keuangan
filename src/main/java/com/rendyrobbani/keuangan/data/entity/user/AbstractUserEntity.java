package com.rendyrobbani.keuangan.data.entity.user;

import com.rendyrobbani.keuangan.core.common.vo.Gender;
import com.rendyrobbani.keuangan.core.common.vo.Nip;
import com.rendyrobbani.keuangan.core.common.vo.Pangkat;
import com.rendyrobbani.keuangan.core.common.vo.TypeOfASN;
import com.rendyrobbani.keuangan.core.domain.user.User;
import com.rendyrobbani.keuangan.data.converter.GenderConverter;
import com.rendyrobbani.keuangan.data.converter.NipConverter;
import com.rendyrobbani.keuangan.data.converter.PangkatConverter;
import com.rendyrobbani.keuangan.data.converter.TypeOfASNConverter;
import com.rendyrobbani.keuangan.data.entity.AbstractEntity;
import com.rendyrobbani.keuangan.data.support.HasCreateSupport;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter(AccessLevel.PROTECTED)
@Accessors(chain = false, fluent = true)
@NoArgsConstructor
@MappedSuperclass
public abstract class AbstractUserEntity extends AbstractEntity implements User {

	@Convert(converter = PangkatConverter.class)
	@Column(name = "pangkat")
	protected Pangkat pangkat;

	@Column(name = "name")
	protected String name;

	@Column(name = "title_prefix")
	protected String titlePrefix;

	@Column(name = "title_suffix")
	protected String titleSuffix;

	@Column(name = "password")
	protected String password;

	@Column(name = "date_of_birth")
	protected LocalDate dateOfBirth;

	@Column(name = "date_of_start")
	protected LocalDate dateOfStart;

	@Convert(converter = GenderConverter.class)
	@Column(name = "gender")
	protected Gender gender;

	@Column(name = "number")
	protected Integer number;

	@Convert(converter = TypeOfASNConverter.class)
	@Column(name = "type")
	protected TypeOfASN type;

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