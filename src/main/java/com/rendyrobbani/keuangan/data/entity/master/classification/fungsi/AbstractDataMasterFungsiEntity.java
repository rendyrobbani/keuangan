package com.rendyrobbani.keuangan.data.entity.master.classification.fungsi;

import com.rendyrobbani.keuangan.core.domain.master.classification.fungsi.DataMasterFungsi;
import com.rendyrobbani.keuangan.data.entity.master.classification.AbstractDataMasterClassificationEntity;
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
public abstract class AbstractDataMasterFungsiEntity extends AbstractDataMasterClassificationEntity implements DataMasterFungsi {

}