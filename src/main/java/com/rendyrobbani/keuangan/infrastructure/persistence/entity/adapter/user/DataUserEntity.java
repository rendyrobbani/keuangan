package com.rendyrobbani.keuangan.infrastructure.persistence.entity.adapter.user;

import com.rendyrobbani.keuangan.domain.model.entity.user.DataUser;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
public class DataUserEntity extends AbstractDataUserEntity {

	@Override
	public DataUser toDomain() {
		return this;
	}

}