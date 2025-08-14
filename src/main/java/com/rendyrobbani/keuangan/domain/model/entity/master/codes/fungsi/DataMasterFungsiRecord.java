package com.rendyrobbani.keuangan.domain.model.entity.master.codes.fungsi;

public record DataMasterFungsiRecord(String id,
                                     String code,
                                     String name,
                                     boolean isLocked,
                                     boolean isDeleted) implements DataMasterFungsi {

}