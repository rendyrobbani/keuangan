package com.rendyrobbani.keuangan.domain.entity.user;

import com.rendyrobbani.keuangan.common.marker.HasId;
import com.rendyrobbani.keuangan.common.vo.Pangkat;
import com.rendyrobbani.keuangan.common.vo.nip.Nip;

import java.time.LocalDateTime;

public interface DataUser extends BaseUser, HasId<String> {

	default void create(LocalDateTime createdAt,
	                    Nip createdBy,
	                    Nip nip,
	                    Pangkat pangkat,
	                    String name,
	                    String titlePrefix,
	                    String titleSuffix,
	                    String password) {
		this.create(createdAt, createdBy);

		this.setNip(nip);
		this.setPangkat(pangkat);
		this.setName(name);
		this.setTitlePrefix(titlePrefix);
		this.setTitleSuffix(titleSuffix);
		this.setPassword(password);

		this.setId(nip.getValue());
		this.setBirthDate(nip.getBirthDate());
		this.setStartDate(nip.getStartDate());
		this.setGender(nip.getGender());
		this.setNumber(nip.getNumber());

		this.setPNS(pangkat.isPNS());
		this.setP3K(pangkat.isP3K());
	}

}