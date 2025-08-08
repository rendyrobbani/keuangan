set @now = now();
set @nip = '199510172019031003';

insert into keuangan_dev.sipd_master_urusan (id, code, name, is_locked, locked_at, locked_by, created_at, created_by, updated_at, updated_by, is_deleted, deleted_at, deleted_by, urusan_id)
select *
from (
    select a.id                                       as id
         , a.kode                                     as code
         , if(a.kode like 'X%', 'Non Urusan', b.nama) as name
         , a.kode like 'X%'                           as is_locked
         , if(a.kode like 'X%', @now, null)           as locked_at
         , if(a.kode like 'X%', @nip, null)           as locked_by
         , @now                                       as created_at
         , @nip                                       as created_by
         , null                                       as updated_at
         , null                                       as updated_by
         , a.kode like 'X%'                           as is_deleted
         , if(a.kode like 'X%', @now, null)           as deleted_at
         , if(a.kode like 'X%', @nip, null)           as deleted_by
         , replace(a.kode, 'X', '0')                  as urusan_id
    from espresso_2025_preproduction.sipd_master_urusan a
    left join espresso_2025_preproduction.data_master_urusan b on a.kode = b.kode
    order by replace(a.kode, 'X', '0')
) t
on duplicate key update code       = t.code
                      , name       = t.name
                      , is_locked  = t.is_locked
                      , locked_at  = t.locked_at
                      , locked_by  = t.locked_by
                      , created_at = t.created_at
                      , created_by = t.created_by
                      , updated_at = t.updated_at
                      , updated_by = t.updated_by
                      , is_deleted = t.is_deleted
                      , deleted_at = t.deleted_at
                      , deleted_by = t.deleted_by