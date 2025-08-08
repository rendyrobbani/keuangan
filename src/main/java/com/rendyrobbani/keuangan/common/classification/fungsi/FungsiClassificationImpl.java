package com.rendyrobbani.keuangan.common.classification.fungsi;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@SuppressWarnings("ClassCanBeRecord")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
class FungsiClassificationImpl implements FungsiClassification {

	private final String fungsiCode;

}