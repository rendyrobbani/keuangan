package com.rendyrobbani.keuangan.common.marker;

import com.rendyrobbani.keuangan.common.vo.nip.Nip;

import java.time.LocalDateTime;

public interface HasLoggable<SUBJECT> {

	Long getId();

	LocalDateTime getLoggedAt();

	Nip getLoggedBy();

	SUBJECT getSubject();

}