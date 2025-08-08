set @now = now();
set @nip = '199510172019031003';

insert into keuangan_dev.data_master_subfungsi (id, code, name, is_locked, locked_at, locked_by, created_at, created_by, updated_at, updated_by, is_deleted, deleted_at, deleted_by, fungsi_id)
select *
from (
    select kode                                    as id
         , kode                                    as code
         , if(kode like '00%', 'Non Fungsi', nama) as name
         , kode like '00%'                         as is_locked
         , if(kode like '00%', @now, null)         as locked_at
         , if(kode like '00%', @nip, null)         as locked_by
         , @now                                    as created_at
         , @nip                                    as created_by
         , null                                    as updated_at
         , null                                    as updated_by
         , kode like '00%'                         as is_deleted
         , if(kode like '00%', @now, null)         as deleted_at
         , if(kode like '00%', @nip, null)         as deleted_by
         , kode_fungsi                             as fungsi_id
    from espresso_2025_preproduction.data_master_subfungsi
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
                      , fungsi_id  = t.fungsi_id