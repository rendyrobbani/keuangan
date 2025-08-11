package com.rendyrobbani.keuangan.infrastructure.persistence.entity.adapter.user;

import com.rendyrobbani.keuangan.domain.model.entity.user.DataUser;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.infrastructure.persistence.converter.NipConverter;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = false, fluent = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "data_user")
public class DataUserEntity extends AbstractUserEntity<String, DataUser> implements DataUser {

	@Id
	@Column(name = "id")
	private String id;

	@Convert(converter = NipConverter.class)
	@Column(name = "id", insertable = false, updatable = false)
	private Nip nip;

	@Override
	public DataUser toDomain() {
		return this;
	}



}