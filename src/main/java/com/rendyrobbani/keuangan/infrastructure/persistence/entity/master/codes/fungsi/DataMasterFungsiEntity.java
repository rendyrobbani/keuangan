package com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.codes.fungsi;

import com.rendyrobbani.keuangan.domain.model.entity.master.codes.fungsi.DataMasterFungsi;
import com.rendyrobbani.keuangan.schema.master.codes.fungsi.DataMasterFungsiTable;
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
@Table(name = DataMasterFungsiTable.NAME)
public class DataMasterFungsiEntity extends AbstractDataMasterFungsiEntity {

	@Override
	public DataMasterFungsi toDomain() {
		return this;
	}

}