package com.rendyrobbani.keuangan.infrastructure.security.jwt;

import com.rendyrobbani.keuangan.domain.auth.WebJwtPayload;
import com.rendyrobbani.keuangan.domain.model.entity.user.DataUser;

public record WebJwtPayloadRecord(Integer tahun,
                                  DataUser user) implements WebJwtPayload {

}