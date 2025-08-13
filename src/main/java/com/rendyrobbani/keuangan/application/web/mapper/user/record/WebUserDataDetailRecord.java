package com.rendyrobbani.keuangan.application.web.mapper.user.record;

import com.rendyrobbani.keuangan.domain.model.response.web.user.data.WebUserDataDetailResponse;
import com.rendyrobbani.keuangan.domain.model.vo.Gender;

import java.time.LocalDate;

public record WebUserDataDetailRecord(String id,
                                      String simpleNip,
                                      String styledNip,
                                      String pangkatValue,
                                      String pangkatTitle,
                                      String onlyName,
                                      String fullName,
                                      String titlePrefix,
                                      String titleSuffix,
                                      LocalDate dateOfBirth,
                                      LocalDate dateOfStart,
                                      Gender gender,
                                      Integer number,
                                      boolean isPNS,
                                      boolean isP3K,
                                      boolean isLocked,
                                      boolean isDeleted) implements WebUserDataDetailResponse {

}