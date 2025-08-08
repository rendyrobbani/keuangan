package com.rendyrobbani.keuangan.common.classification.urusan;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@SuppressWarnings("ClassCanBeRecord")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
class UrusanClassificationImpl implements UrusanClassification {

	private final String urusanCode;

}