package com.rendyrobbani.keuangan.application.web.mapper.user.record;

import com.rendyrobbani.keuangan.domain.model.response.web.user.data.WebUserDataSelectResponse;

public record WebUserDataSelectRecord(String id,
                                      String simpleNip,
                                      String styledNip,
                                      String pangkatTitle,
                                      String onlyName,
                                      String fullName,
                                      boolean isLocked,
                                      boolean isDeleted) implements WebUserDataSelectResponse {

}