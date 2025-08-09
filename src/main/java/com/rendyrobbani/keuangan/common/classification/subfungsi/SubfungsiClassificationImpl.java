package com.rendyrobbani.keuangan.common.classification.subfungsi;

import com.rendyrobbani.keuangan.common.classification.fungsi.FungsiClassification;

record SubfungsiClassificationImpl(String fungsiCode,
                                   String subfungsiCode) implements FungsiClassification, SubfungsiClassification {

}