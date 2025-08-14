package com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.codes;

import com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.AbstractDataMasterEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = false, fluent = true)
@NoArgsConstructor
@MappedSuperclass
public abstract class AbstractDataMasterCodesEntity<DOMAIN> extends AbstractDataMasterEntity<DOMAIN, String> implements DataMasterCodesEntity<DOMAIN> {

	@Id
	@Column(name = "id")
	protected String id;

	@Column(name = "code")
	protected String code;

	@Column(name = "name")
	protected String name;

}