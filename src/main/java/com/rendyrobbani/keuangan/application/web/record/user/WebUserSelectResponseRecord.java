package com.rendyrobbani.keuangan.application.web.record.user;

import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserSelectResponse;

public record WebUserSelectResponseRecord(String id,
                                          String simpleNip,
                                          String styledNip,
                                          String pangkatTitle,
                                          String onlyName,
                                          String fullName,
                                          boolean isLocked,
                                          boolean isDeleted) implements WebUserSelectResponse {

}