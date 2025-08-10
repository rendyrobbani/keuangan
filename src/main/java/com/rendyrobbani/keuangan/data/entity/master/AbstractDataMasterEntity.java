package com.rendyrobbani.keuangan.data.entity.master;

import com.rendyrobbani.keuangan.core.domain.master.DataMaster;
import com.rendyrobbani.keuangan.data.entity.AbstractDataEntity;
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
public abstract class AbstractDataMasterEntity<ID> extends AbstractDataEntity<ID> implements DataMaster<ID> {

}