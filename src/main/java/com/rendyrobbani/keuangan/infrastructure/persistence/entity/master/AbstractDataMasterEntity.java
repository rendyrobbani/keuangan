package com.rendyrobbani.keuangan.infrastructure.persistence.entity.master;

import com.rendyrobbani.keuangan.infrastructure.persistence.entity.AbstractLockEntity;
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
public abstract class AbstractDataMasterEntity<DOMAIN, ID> extends AbstractLockEntity<DOMAIN, ID> implements DataMasterEntity<DOMAIN, ID> {

}