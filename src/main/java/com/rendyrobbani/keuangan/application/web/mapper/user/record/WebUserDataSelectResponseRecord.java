package com.rendyrobbani.keuangan.application.web.mapper.user.record;

import com.rendyrobbani.keuangan.domain.model.dto.web.user.data.WebUserDataSelectResponse;

public record WebUserDataSelectResponseRecord(String id,
                                              String simpleNip,
                                              String styledNip,
                                              String pangkatTitle,
                                              String onlyName,
                                              String fullName,
                                              boolean isLocked,
                                              boolean isDeleted) implements WebUserDataSelectResponse {

}