package com.rendyrobbani.keuangan.data.entity.master.classification.fungsi;

import com.rendyrobbani.keuangan.core.domain.master.classification.fungsi.DataMasterFungsi;
import com.rendyrobbani.keuangan.data.entity.master.classification.AbstractDataMasterClassificationEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = false, fluent = true)
@NoArgsConstructor
@Entity
@Table(name = "data_master_fungsi")
public class DataMasterFungsiEntity extends AbstractDataMasterClassificationEntity implements DataMasterFungsi {

}