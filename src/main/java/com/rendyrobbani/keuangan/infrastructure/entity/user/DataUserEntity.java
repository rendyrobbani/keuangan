package com.rendyrobbani.keuangan.infrastructure.entity.user;

import com.rendyrobbani.keuangan.common.vo.nip.Nip;
import com.rendyrobbani.keuangan.domain.entity.user.DataUser;
import com.rendyrobbani.keuangan.infrastructure.converter.NipConverter;
import com.rendyrobbani.keuangan.schema.table.user.DataUserTable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = DataUserTable.NAME)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DataUserEntity extends BaseUserEntity implements DataUser {

	@Id
	@Column(name = "id")
	private String id;

	@Convert(converter = NipConverter.class)
	@Column(name = "id", insertable = false, updatable = false)
	private Nip nip;

}