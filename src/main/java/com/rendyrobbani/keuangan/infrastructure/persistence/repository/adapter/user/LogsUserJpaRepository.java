package com.rendyrobbani.keuangan.infrastructure.persistence.repository.adapter.user;

import com.rendyrobbani.keuangan.infrastructure.persistence.entity.adapter.user.LogsUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogsUserJpaRepository extends JpaRepository<LogsUserEntity, Long> {

}