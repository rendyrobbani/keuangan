package com.rendyrobbani.keuangan.infrastructure.entity.user;

import com.rendyrobbani.keuangan.common.vo.nip.Nip;
import com.rendyrobbani.keuangan.domain.entity.user.DataUser;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DataUserFactory {

	public static DataUser create(LocalDateTime createdAt, Nip createdBy, Nip nip) {
		return new DataUserEntity(createdAt, createdBy, nip);
	}

}