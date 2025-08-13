package com.rendyrobbani.keuangan.domain.auth;

import com.rendyrobbani.keuangan.domain.model.entity.user.DataUser;

public interface WebJwtPayload {

	Integer tahun();

	DataUser user();

}