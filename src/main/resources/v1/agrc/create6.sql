create schema if not exists agrc
  --authorization postgres;
;
--Справочник «Сельскохозяйственная культура»
create table if not exists agrc.cls_crop
(
    id bigserial primary key
)
inherits (base.base_coded_classifier)
;
--Справочник «Вегетационный период»
create table if not exists agrc.cls_veget_period
(
    id bigserial primary key
)
inherits (base.base_coded_classifier)
;
--Справочник «Орган растения»
create table if not exists agrc.cls_plant_organ
(
    id bigserial primary key
)
inherits (base.base_coded_classifier)
;
--Справочник «Тип проявления болезни»
create table if not exists agrc.cls_disease_feature
(
    id bigserial primary key
)
inherits (base.base_coded_classifier)
;
--Справочник «Сорт сельскохозяйственной культуры»
create table if not exists agrc.cls_crop_variety
(
    id bigserial    primary key,
    id_crop         bigint not null,
    constraint fk_id_crop foreign key (id_crop) references agrc.cls_crop (id)
)
inherits (base.base_classifier)
;
--Справочник «Удобрение»
create table if not exists agrc.cls_fertilizer
(
    id          bigserial primary key,
    id_unit     bigint not null,
    max_consum  decimal(10,5),
    min_consum  decimal(10,5),
    constraint fk_id_unit foreign key (id_unit) references dict.cls_unit (id)
)
inherits (base.base_coded_classifier)
;
--Справочник «Средство защиты растений»
create table if not exists agrc.cls_protection_equipment
(
    id          bigserial primary key,
    id_unit     bigint not null,
    max_consum  decimal(10,5),
    min_consum  decimal(10,5),
    constraint fk_id_unit foreign key (id_unit) references dict.cls_unit (id)
)
inherits (base.base_coded_classifier)
;
