package com.rendyrobbani.keuangan.common.classification.bidang;

import com.rendyrobbani.keuangan.common.classification.urusan.UrusanClassification;

record BidangClassificationImpl(String urusanCode,
                                String bidangCode) implements UrusanClassification, BidangClassification {

}