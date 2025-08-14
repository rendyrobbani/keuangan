package com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.codes.fungsi;

import com.rendyrobbani.keuangan.domain.model.entity.master.codes.fungsi.DataMasterFungsi;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.codes.AbstractDataMasterCodesEntity;
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
public abstract class AbstractDataMasterFungsiEntity extends AbstractDataMasterCodesEntity<DataMasterFungsi> implements DataMasterFungsi {

	@Override
	public void sync(DataMasterFungsi domain) {
		this.id(domain.id());
		this.code(domain.code());
		this.name(domain.name());
	}

}