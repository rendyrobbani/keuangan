package com.rendyrobbani.keuangan.common.vo.nip;

import com.rendyrobbani.keuangan.common.vo.Gender;

import java.time.LocalDate;

record NipImpl(String value,
               String formatted,
               LocalDate birthDate,
               LocalDate startDate,
               Gender gender,
               Integer number
) implements Nip {
}