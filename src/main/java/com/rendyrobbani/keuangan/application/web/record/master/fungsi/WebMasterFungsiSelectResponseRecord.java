package com.rendyrobbani.keuangan.application.web.record.master.fungsi;

import com.rendyrobbani.keuangan.domain.model.dto.web.master.fungsi.WebMasterFungsiSelectResponse;

public record WebMasterFungsiSelectResponseRecord(String id,
                                                  String code,
                                                  String name,
                                                  boolean isLocked,
                                                  boolean isDeleted) implements WebMasterFungsiSelectResponse {

}