package com.rendyrobbani.keuangan.common.classification.bidang;

import com.rendyrobbani.keuangan.common.classification.urusan.UrusanClassification;

public interface BidangClassification extends UrusanClassification {

	String REGEX = "^(?!0.*|.\\.0{2}.*|X\\.\\d{2}.*|\\d\\.X{2}.*)(X|\\d)\\.(XX|\\d{2})$";

	String bidangCode();

}