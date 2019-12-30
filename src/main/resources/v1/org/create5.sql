--Справочник «Должность»
create table if not exists org.cls_position
(
    id              bigserial primary key,
    id_organization bigint not null,
    is_predefined   boolean default false,
    constraint fk_id_organization foreign key (id_organization) references dict.cls_organization (id)
)
inherits (base.base_classifier)
;
--Справочник «Ферма»
create table if not exists org.cls_ranch
(
    id              bigserial primary key,
    id_organization bigint not null,
    id_depart       bigint not null,
    id_district     bigint not null,
    coord           geography,
    constraint fk_id_organization   foreign key (id_organization)   references dict.cls_organization (id),
    constraint fk_id_depart         foreign key (id_depart)         references org.cls_depart (id),
    constraint fk_id_district       foreign key (id_district)       references dict.cls_district (id)
)
inherits (base.base_classifier)
;
--Справочник «Базы техники»
create table if not exists org.cls_equipment_base
(
    id              bigserial primary key,
    id_organization bigint not null,
    id_depart       bigint not null,
    id_district     bigint not null,
    id_ranch        bigint not null,
    constraint fk_id_organization   foreign key (id_organization)   references dict.cls_organization (id),
    constraint fk_id_depart         foreign key (id_depart)         references org.cls_depart (id),
    constraint fk_id_district       foreign key (id_district)       references dict.cls_district (id),
    constraint fk_id_ranch          foreign key (id_ranch)          references org.cls_ranch (id)
)
inherits (base.base_classifier)
;
--Регистр «Техника организации»
create table if not exists org.reg_organization_equipment
(
    id                  bigserial primary key,
    id_organization     bigint not null,
    id_equipment_kind   bigint not null,
    number              character varying(15),
    name                text,
    affiliation integer, -- 0 – собственность 1 - аренда
    constraint fk_id_organization   foreign key (id_organization)   references dict.cls_organization (id),
    constraint fk_id_equipment_kind foreign key (id_equipment_kind) references dict.cls_equipment_kind (id)
)
inherits (base.base_register)
;
--Регистр «Локализация техники»
create table if not exists org.reg_equipment_base_local
(
    id                          bigserial primary key,
    id_organization             bigint not null,
    id_organization_equipment   bigint not null,
    id_ranch                    bigint not null,
    constraint fk_id_organization           foreign key (id_organization)           references dict.cls_organization (id),
    constraint fk_id_organization_equipment foreign key (id_organization_equipment) references org.reg_organization_equipment (id),
    constraint fk_id_ranch                  foreign key (id_ranch)                  references org.cls_ranch (id)
)
inherits (base.base_register)
;
--Регистр «Расходные материалы организации»
create table if not exists org.reg_organization_consumable
(
    id              bigserial primary key,
    id_organization bigint not null,
    id_consumable   bigint not null,
    number          character varying(15),
    name            text,
    affiliation     integer, -- 0 – собственность 1 - аренда
    constraint fk_id_organization   foreign key (id_organization)   references dict.cls_organization (id),
    constraint fk_id_consumable     foreign key (id_consumable)     references dict.cls_consumable (id)
)
inherits (base.base_register)
;