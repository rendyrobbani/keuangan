package com.rendyrobbani.keuangan.data.entity.user;

import com.rendyrobbani.keuangan.core.common.vo.Nip;
import com.rendyrobbani.keuangan.core.common.vo.Pangkat;
import com.rendyrobbani.keuangan.core.domain.user.User;
import com.rendyrobbani.keuangan.data.converter.NipConverter;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = false, fluent = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "data_user")
public class DataUserEntity extends AbstractUserEntity {

	@Id
	@Column(name = "id")
	protected String id;

	@Convert(converter = NipConverter.class)
	@Column(name = "id", insertable = false, updatable = false)
	protected Nip nip;

	public static DataUserEntity create(Nip nip,
	                                    Pangkat pangkat,
	                                    String name,
	                                    String titlePrefix,
	                                    String titleSuffix,
	                                    String password,
	                                    LocalDate dateOfStart,
	                                    LocalDateTime createdAt,
	                                    Nip createdBy) {
		var entity = new DataUserEntity();
		entity.nip(nip);
		entity.pangkat(pangkat);
		entity.name(name);
		entity.titlePrefix(titlePrefix);
		entity.titleSuffix(titleSuffix);
		entity.password(password);
		entity.createdAt(createdAt);
		entity.createdBy(createdBy);
		entity.id(nip.simple());
		entity.dateOfBirth(nip.dateOfBirth());
		entity.dateOfStart(pangkat.isPNS() ? nip.dateOfStart() : dateOfStart);
		entity.gender(nip.gender());
		entity.number(nip.number());
		entity.type(pangkat.type());
		entity.isLocked(false);
		entity.isDeleted(false);
		return entity;
	}

}