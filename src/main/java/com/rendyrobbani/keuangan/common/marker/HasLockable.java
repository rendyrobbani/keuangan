package com.rendyrobbani.keuangan.common.marker;

import com.rendyrobbani.keuangan.common.vo.nip.Nip;

import java.time.LocalDateTime;

public interface HasLockable {

	boolean isLocked();

	LocalDateTime getLockedAt();

	Nip getLockedBy();

}