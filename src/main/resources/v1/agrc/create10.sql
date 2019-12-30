--справочник «метеостанция»
create table if not exists agrc.cls_weather_station
(
    id                  bigserial primary key,
    id_organization     bigint not null,
    description         jsonb,
    point               geometry,
    constraint fk_id_organization foreign key (id_organization) references dict.cls_organization (id)
)
inherits (base.base_classifier)
;
--регистр «показание метеостанции»
create table if not exists agrc.reg_weather_station_reading
(
    id                      bigserial primary key,
    id_weather_station      bigint not null,
    id_organization         bigint not null,
    date_reg         timestamp without time zone default current_timestamp,
    composition      jsonb,
    temperature      decimal(10,5),
    humidity         decimal(10,5),
    constraint fk_id_weather_station    foreign key (id_weather_station)    references agrc.cls_weather_station (id),
    constraint fk_id_organization       foreign key (id_organization)       references dict.cls_organization (id)
)
inherits (base.base_register)
;
--справочник «gps-модуль»
create table if not exists agrc.cls_gps_module
(
    id                  bigserial primary key,
    id_organization     bigint not null,
    description         jsonb,
    point               geometry,
    constraint fk_id_organization foreign key (id_organization) references dict.cls_organization (id)
)
inherits (base.base_classifier)
;
--регистр «показание gps-модуля»
create table if not exists agrc.reg_gps_module_reading
(
    id                      bigserial primary key,
    id_gps_module           bigint not null,
    id_organization         bigint not null,
    date_reg                timestamp without time zone default current_timestamp,
    composition             jsonb,
    constraint id_gps_module        foreign key (id_gps_module)     references agrc.cls_gps_module (id),
    constraint fk_id_organization   foreign key (id_organization)   references dict.cls_organization (id)
)
inherits (base.base_register)
;
--регистр «gps-модуль техники организации»
create table if not exists agrc.reg_gps_module_organization_equipment
(
    id                         bigserial primary key,
    id_gps_module              bigint not null,
    id_organization            bigint not null,
    id_organization_equipment  bigint not null,
    constraint id_gps_module        foreign key (id_gps_module)     references agrc.cls_gps_module (id),
    constraint fk_id_organization   foreign key (id_organization)   references dict.cls_organization (id)
)
inherits (base.base_register)
;
