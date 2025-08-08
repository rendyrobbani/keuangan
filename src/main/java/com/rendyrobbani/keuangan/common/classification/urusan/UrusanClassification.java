package com.rendyrobbani.keuangan.common.classification.urusan;

public interface UrusanClassification {

	String REGEX = "^(?!0)(X|\\d)$";

	String getUrusanCode();

}