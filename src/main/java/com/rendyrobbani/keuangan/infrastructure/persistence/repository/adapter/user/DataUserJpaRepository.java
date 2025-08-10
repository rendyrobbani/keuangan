package com.rendyrobbani.keuangan.infrastructure.persistence.repository.adapter.user;

import com.rendyrobbani.keuangan.infrastructure.persistence.entity.adapter.user.DataUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataUserJpaRepository extends JpaRepository<DataUserEntity, String> {

}