package com.rendyrobbani.keuangan.common.marker;

import com.rendyrobbani.keuangan.common.vo.nip.Nip;

import java.time.LocalDateTime;

public interface HasLogMutator {

	void setLoggedAt(LocalDateTime loggedAt);

	void setLoggedBy(Nip loggedBy);

	default void log(LocalDateTime loggedAt, Nip loggedBy) {
		this.setLoggedAt(loggedAt);
		this.setLoggedBy(loggedBy);
	}

}