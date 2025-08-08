package com.rendyrobbani.keuangan.common.marker;

public interface HasClassification extends HasName, HasLockMutator, HasAuditMutator {

	String getCode();

}