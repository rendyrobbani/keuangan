package com.rendyrobbani.keuangan.domain.marker;

import com.rendyrobbani.keuangan.common.vo.nip.Nip;

import java.time.LocalDateTime;

public interface HasDelete {

	void delete(LocalDateTime deletedAt, Nip deletedBy);

	void restore(LocalDateTime restoreAt, Nip restoredBy);

}