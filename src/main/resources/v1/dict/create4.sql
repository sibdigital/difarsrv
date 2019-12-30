--Справочник «Регион»
create table if not exists dict.cls_region
(
    id bigserial primary key
)
inherits (base.base_coded_classifier)
;
--Справочник «Район»
create table if not exists dict.cls_district
(
    id bigserial primary key,
    id_region    bigint not null,
    constraint fk_id_region foreign key (id_region) references dict.cls_region (id)
)
inherits (base.base_classifier)
;
--Справочник «Местность»
--Уточнение местности внутри района
create table if not exists dict.cls_area
(
    id bigserial    primary key,
    id_district     bigint not null,
    constraint fk_id_district foreign key (id_district) references dict.cls_district (id)
)
inherits (base.base_classifier)
;
--Справочник «Стандартный Период»
--Стандартные периоды: от года до дня за ближайшие несколько лет, а также произвольные периоды
create table if not exists dict.cls_standard_period
(
    id bigserial    primary key,
    period_type     int, --0 – день 1 – неделя 2 – декада 3 – месяц 4 – квартал 5 – полугодие 6 – 9 месяцев 7 – год 8 – произвольный
    date_begin      timestamp without time zone,
    date_end        timestamp without time zone
)
inherits (base.base_classifier)
;
--Справочник «Произвольный период»
--Произвольный период, принятый для региона, района или организации. На основе стандартного периода.
create table if not exists dict.cls_arbitrary_period
(
    id bigserial        primary key,
    id_standard_period  bigint not null,
    id_region           bigint not null,
    id_district         bigint not null,
    id_organization     bigint not null,
    date_begin          timestamp without time zone,
    date_end            timestamp without time zone,
    constraint fk_id_region             foreign key (id_region)             references dict.cls_region (id),
    constraint fk_id_district           foreign key (id_district)           references dict.cls_district (id),
    constraint fk_id_organization       foreign key (id_organization)       references dict.cls_organization (id),
    constraint fk_id_standard_period    foreign key (id_standard_period)    references dict.cls_standard_period (id)
)
inherits (base.base_classifier)
;
--Справочник «Единица измерения»
create table if not exists dict.cls_unit
(
    id bigserial primary key,
    reduct text
)
inherits (base.base_coded_classifier)
;
--Справочник «Отношение единиц измерения»
--Таблица для описания пропорциональности единиц измерения. Например:
-- (Id_unit_from= метр, Id_unit_to= километр, ratio=1000)
-- (Id_unit_from= метр в секунду, Id_unit_to= километр в час, ratio=3,6)
create table if not exists dict.cls_unit_ratio
(
    id bigserial    primary key,
    id_unit_from    bigint not null,
    id_unit_to      bigint not null,
    ratio           decimal(10,6),
    constraint fk_id_unit_from  foreign key (id_unit_from)  references dict.cls_unit (id),
    constraint fk_id_unit_to    foreign key (id_unit_to)    references dict.cls_unit (id)
)
inherits (base.base_classifier)
;
create table if not exists dict.cls_work_type
(
    id bigserial    primary key,
    id_parent       bigint not null,
    parent_path     ltree not null
)
inherits (base.base_classifier)
;
--Справочник «Вид расходного материала»
create table if not exists dict.cls_consumable_kind
(
    id bigserial primary key
)
inherits (base.base_coded_classifier)
;
--Справочник «Расходные материалы»
create table if not exists dict.cls_consumable
(
    id                  bigserial primary key,
    id_consumable_kind  bigint not null,
    id_unit             bigint not null,
    max_consum          decimal(10,6),
    min_consum          decimal(10,6),
    constraint fk_id_consumable_kind    foreign key (id_consumable_kind)    references dict.cls_consumable_kind (id),
    constraint fk_id_unit               foreign key (id_unit)               references dict.cls_unit (id)
)
inherits (base.base_classifier)
;
--Справочник «Типы техники»
--Трактор, автомобиль, любой другой агрегат
create table if not exists dict.cls_equipment_type
(
    id bigserial primary key
)
inherits (base.base_coded_classifier)
;
--Справочник «Виды техники»
--Конкретизированный тип: автомобиль-грузовик, например
create table if not exists dict.cls_equipment_kind
(
    id                  bigserial primary key,
    id_equipment_type   bigint not null,
    constraint fk_id_equipment_type foreign key (id_equipment_type) references dict.cls_equipment_type (id)
)
inherits (base.base_classifier)
;
--Справочник «Контрагент»
create table if not exists dict.cls_partner
(
    id              bigserial primary key,
    inn             character varying(10),
    id_legal_entity bigint not null,
    constraint fk_id_legal_entity foreign key (id_legal_entity) references dict.cls_legal_entity (id)
)
inherits (base.base_classifier)
;
--Регистр «Контрагент организации»
--Для разделения контрагентов между организациями, т.е. видны только «свои» контрагенты.
create table if not exists dict.reg_organization_partner
(
    id              bigserial primary key,
    id_organization bigint not null,
    id_partner      bigint not null,
    constraint fk_id_organization   foreign key (id_organization)   references dict.cls_organization (id),
    constraint fk_id_partner        foreign key (id_partner)        references dict.cls_partner (id)
)
inherits (base.base_register)
;
