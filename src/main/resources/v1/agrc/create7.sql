--Регистр «Средства защиты организации»
create table if not exists agrc.reg_organization_protection_equipment
(
    id                      bigserial primary key,
    id_organization         bigint not null,
    id_protection_equipment bigint not null,
    number                  character varying(15),
    name                    text,
    description             jsonb,
    constraint fk_id_organization           foreign key (id_organization)           references dict.cls_organization (id),
    constraint fk_id_protection_equipment   foreign key (id_protection_equipment)   references agrc.cls_protection_equipment (id)
)
inherits (base.base_register)
;
--Регистр «Средства защиты организации»
create table if not exists agrc.reg_organization_fertilizer
(
    id              bigserial primary key,
    id_organization bigint not null,
    id_fertilizer   bigint not null,
    number          character varying(15),
    name            text,
    description     jsonb,
    constraint fk_id_organization   foreign key (id_organization)   references dict.cls_organization (id),
    constraint fk_id_fertilizer     foreign key (id_fertilizer)     references agrc.cls_fertilizer (id)
)
inherits (base.base_register)
;
---------------------------+cls_plant_disease+---------------------------------
--Справочник «Болезнь растения»
--condition:
-- {
-- Description: string,
-- Min_Air_humidity: number, - минимальная влажность
-- Max_Air_humidity: number, максимальная влажность
-- Min_Opt_disease_temp: number, - минимальная оптимальная температура развития
-- Max_Opt_disease_temp: number, - максимальная оптимальная температура развития
-- Min_Max_disease_temp: number, - минимальная максимальная температура развития
-- Max_ Max _disease_temp: number, - максимальная максимальная температура развития
-- Min_Min_disease_temp: number, - минимальная минимальная температура развития
-- Max_Min_disease_temp: number, - максимальная минимальная температура развития
-- }
create table if not exists agrc.cls_plant_disease
(
    id          bigserial primary key,
    id_unit     bigint not null,
    symptom     jsonb,
    cause       jsonb,
    harmfulness jsonb,
    photos      jsonb,
    additional_names    jsonb,
    condition           jsonb,
    min_incub_period    integer,
    max_incub_period    integer,
    constraint fk_id_unit foreign key (id_unit) references dict.cls_unit (id)
)
inherits (base.base_coded_classifier)
;
----табличная часть «поражаемая культура» справочника «болезнь растения»
create table if not exists agrc.tp_plant_disease_affected_crop
(
    id                      bigserial primary key,
    id_crop                 bigint not null,
    id_plant_disease        bigint not null,
    id_veget_period         bigint not null,
    id_protection_equipment bigint not null,
    min_app_rate            decimal(10,5),
    max_app_rate            decimal(10,5),
    wait_period             decimal(10,5),
    operation_multiplicity  decimal(10,5),
    period_handwork         decimal(10,5),
    period_mechwork         decimal(10,5),
    constraint fk_id_crop                   foreign key (id_crop)                   references agrc.cls_crop (id),
    constraint fk_id_plant_disease          foreign key (id_plant_disease)          references agrc.cls_plant_disease (id),
    constraint fk_id_veget_period           foreign key (id_veget_period)           references agrc.cls_veget_period (id),
    constraint fk_id_protection_equipment   foreign key (id_protection_equipment)   references agrc.cls_protection_equipment (id)
)
inherits (base.base_tab_part)
;
----табличная часть «проявления болезни» справочника «болезнь растения»
create table if not exists agrc.tp_plant_disease_disease_feature
(
    id                  bigserial primary key,
    id_crop             bigint not null,
    id_plant_disease    bigint not null,
    id_disease_feature  bigint not null,
    description jsonb,
    constraint fk_id_crop               foreign key (id_crop)               references agrc.cls_crop (id),
    constraint fk_id_plant_disease      foreign key (id_plant_disease)      references agrc.cls_plant_disease (id),
    constraint fk_id_disease_feature    foreign key (id_disease_feature)    references agrc.cls_disease_feature (id)
)
inherits (base.base_tab_part)
;
----табличная часть «поражаемые органы» справочника «болезнь растения»
create table if not exists agrc.tp_plant_disease_plant_organ
(
    id                  bigserial primary key,
    id_crop             bigint not null,
    id_plant_disease    bigint not null,
    id_plant_organ      bigint not null,
    description         jsonb,
    constraint fk_id_crop           foreign key (id_crop)           references agrc.cls_crop (id),
    constraint fk_id_plant_disease  foreign key (id_plant_disease)  references agrc.cls_plant_disease (id),
    constraint fk_id_plant_organ    foreign key (id_plant_organ)    references agrc.cls_plant_organ (id)
)
inherits (base.base_tab_part)
;
----табличная часть «период поражения» справочника « болезнь растения»
create table if not exists agrc.tp_plant_disease_period
(
    id                  bigserial primary key,
    id_crop             bigint not null,
    id_plant_disease    bigint not null,
    id_veget_period     bigint not null,
    description jsonb,
    constraint fk_id_crop           foreign key (id_crop)           references agrc.cls_crop (id),
    constraint fk_id_plant_disease  foreign key (id_plant_disease)  references agrc.cls_plant_disease (id),
    constraint fk_id_veget_period   foreign key (id_veget_period)   references agrc.cls_veget_period (id)
)
inherits (base.base_tab_part)
;
----табличная часть «регион распространения» справочника «болезнь растения»
create table if not exists agrc.tp_plant_disease_typical_area
(
    id                  bigserial primary key,
    id_crop             bigint not null,
    id_plant_disease    bigint not null,
    id_region       bigint not null,
    id_district     bigint not null,
    id_area         bigint not null,
    constraint fk_id_crop           foreign key (id_crop)           references agrc.cls_crop (id),
    constraint fk_id_plant_disease  foreign key (id_plant_disease)  references agrc.cls_plant_disease (id),
    constraint fk_id_region         foreign key (id_region)         references dict.cls_region (id),
    constraint fk_id_district       foreign key (id_district)       references dict.cls_district (id),
    constraint fk_id_area           foreign key (id_area)           references dict.cls_area (id)
)
inherits (base.base_tab_part)
;
-----------------------------cls_plant_disease----------------------------------
-------------------------------+cls_plant_pest+---------------------------------
--Справочник «Вредитель растения»
--condition
-- {
-- Description: string,
-- Summary_temp:number – накопленная температура
-- Min_Air_humidity: number, - минимальная влажность
-- Max_Air_humidity: number, максимальная влажность
-- Min_Opt_disease_temp: number, - минимальная оптимальная температура развития
-- Max_Opt_disease_temp: number, - максимальная оптимальная температура развития
-- Min_Min_disease_temp: number, - минимальная минимальная температура развития
-- Max_Min_disease_temp: number, - максимальная минимальная температура развития
-- }
-- Description:
-- {threat: string, - Угроза
-- wimtering : string  - Зимующая стадия }
create table if not exists agrc.cls_plant_pest
(
    id bigserial primary key,
    id_unit     bigint not null,
    photos      jsonb,
    additional_names    jsonb,
    condition           jsonb,
    description         jsonb,
    min_incub_period    integer,
    max_incub_period    integer,
    constraint fk_id_unit foreign key (id_unit) references dict.cls_unit (id)
)
inherits (base.base_coded_classifier)
;
----табличная часть «поражаемая культура» справочника «вредитель растения»
create table if not exists agrc.tp_plant_pest_affected_crop
(
    id bigserial            primary key,
    id_crop                 bigint not null,
    id_plant_pest           bigint not null,
    id_veget_period         bigint not null,
    id_protection_equipment bigint not null,
    min_app_rate            decimal(10,5),
    max_app_rate            decimal(10,5),
    wait_period             decimal(10,5),
    operation_multiplicity  decimal(10,5),
    period_handwork         decimal(10,5),
    period_mechwork         decimal(10,5),
    constraint fk_id_crop                   foreign key (id_crop)                   references agrc.cls_crop (id),
    constraint fk_id_plant_pest             foreign key (id_plant_pest)             references agrc.cls_plant_pest (id),
    constraint fk_id_veget_period           foreign key (id_veget_period)           references agrc.cls_veget_period (id),
    constraint fk_id_protection_equipment   foreign key (id_protection_equipment)   references agrc.cls_protection_equipment (id)
)
inherits (base.base_tab_part)
;
----табличная часть «поражаемые органы» справочника «вредитель растения»
create table if not exists agrc.tp_plant_pest_plant_organ
(
    id              bigserial primary key,
    id_crop         bigint not null,
    id_plant_pest   bigint not null,
    id_plant_organ  bigint not null,
    description     jsonb,
    constraint fk_id_crop           foreign key (id_crop)           references agrc.cls_crop (id),
    constraint fk_id_plant_pest     foreign key (id_plant_pest)     references agrc.cls_plant_pest (id),
    constraint fk_id_plant_organ    foreign key (id_plant_organ)    references agrc.cls_plant_organ (id)
)
inherits (base.base_tab_part)
;
----табличная часть «период поражения» справочника «вредитель растения»
create table if not exists agrc.tp_plant_pest_period
(
    id              bigserial primary key,
    id_crop         bigint not null,
    id_plant_pest   bigint not null,
    id_veget_period bigint not null,
    description     jsonb,
    constraint fk_id_crop           foreign key (id_crop)           references agrc.cls_crop (id),
    constraint fk_id_plant_pest     foreign key (id_plant_pest)     references agrc.cls_plant_pest (id),
    constraint fk_id_veget_period   foreign key (id_veget_period)   references agrc.cls_veget_period (id)
)
inherits (base.base_tab_part)
;
--табличная часть «регион распространения» справочника «вредитель растения»
create table if not exists agrc.tp_plant_pest_typical_area
(
    id              bigserial primary key,
    id_crop         bigint not null,
    id_plant_pest   bigint not null,
    id_region       bigint not null,
    id_district     bigint not null,
    id_area         bigint not null,
    constraint fk_id_crop       foreign key (id_crop)       references agrc.cls_crop (id),
    constraint fk_id_plant_pest foreign key (id_plant_pest) references agrc.cls_plant_pest (id),
    constraint fk_id_region     foreign key (id_region)     references dict.cls_region (id),
    constraint fk_id_district   foreign key (id_district)   references dict.cls_district (id),
    constraint fk_id_area       foreign key (id_area)       references dict.cls_area (id)
)
inherits (base.base_tab_part)
;
--------------------------------cls_plant_pest----------------------------------
--Справочник «Поле»
create table if not exists agrc.cls_field
(
    id              bigserial primary key,
    id_organization bigint not null,
    constraint fk_id_organization foreign key (id_organization) references dict.cls_organization (id)
)
inherits (base.base_classifier)
;
--Регистр «Локализация поля»
create table if not exists agrc.reg_field_local
(
    id              bigserial primary key,
    id_field        bigint not null,
    id_region       bigint not null,
    id_district     bigint not null,
    id_area         bigint not null,
    id_depart       bigint not null,
    bound           polygon,
    area            decimal(10,5),
    constraint fk_id_field  foreign key (id_field)  references agrc.cls_field (id),
    constraint fk_id_region foreign key (id_region) references dict.cls_region (id),
    constraint fk_id_district   foreign key (id_district)   references dict.cls_district (id),
    constraint fk_id_area       foreign key (id_area)       references dict.cls_area (id),
    constraint fk_id_depart     foreign key (id_depart)     references org.cls_depart (id)
)
inherits (base.base_register)
;