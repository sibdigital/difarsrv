---------------------------+doc_routing+---------------------------------
--документ «технологическая карта»
--с помощью документа технологическая карта определяется севооборот.
create table if not exists agrc.doc_routing
(
    id                  bigserial primary key,
    id_organization     bigint not null,
    id_standard_period  bigint not null,
    id_crop             bigint not null,
    id_field            bigint not null,
    id_unit             bigint not null,
    prolificness        decimal(10,5),
    constraint fk_id_organization       foreign key (id_organization)       references dict.cls_organization (id),
    constraint fk_id_standard_period    foreign key (id_standard_period)    references dict.cls_standard_period (id),
    constraint fk_id_crop   foreign key (id_crop)   references agrc.cls_crop (id),
    constraint fk_id_field  foreign key (id_field)  references agrc.cls_field (id),
    constraint fk_id_unit   foreign key (id_unit)   references dict.cls_unit (id)
)
inherits (base.base_document)
;
--табличная часть «этапы работ» документа «технологическая карта»
create table if not exists agrc.tp_routing_stage
(
    id           bigserial primary key,
    id_routing   bigint not null,
    name text,
    constraint fk_id_routing foreign key (id_routing) references agrc.doc_routing (id)
)
inherits (base.base_tab_part)
;
--табличная часть «работы» документа «технологическая карта»
create table if not exists agrc.tp_routing_work
(
    id               bigserial primary key,
    id_routing       bigint not null,
    id_routing_stage bigint not null,
    exec_time        interval,
    constraint fk_id_routing        foreign key (id_routing)        references agrc.doc_routing (id),
    constraint fk_id_routing_stage  foreign key (id_routing_stage)  references agrc.tp_routing_stage (id)
)
inherits (base.base_tab_part)
;
--табличная часть «техника» документа «технологическая карта»
create table if not exists agrc.tp_routing_equipment
(
    id                         bigserial primary key,
    id_routing                 bigint not null,
    id_routing_work            bigint not null,
    id_organization_equipment  bigint not null,
    id_fuel_unit               bigint not null,
    fuel_consum                decimal(10,5),
    constraint fk_id_routing        foreign key (id_routing)        references agrc.doc_routing (id),
    constraint fk_id_routing_work   foreign key (id_routing_work)   references agrc.tp_routing_work (id),
    constraint fk_id_organization_equipment foreign key (id_organization_equipment) references org.reg_organization_equipment (id),
    constraint fk_id_fuel_unit              foreign key (id_fuel_unit)              references dict.cls_unit (id)
)
inherits (base.base_tab_part)
;
--табличная часть «удобрения» документа «технологическая карта»
create table if not exists agrc.tp_routing_fertilizer
(
    id                          bigserial primary key,
    id_routing                  bigint not null,
    id_routing_work             bigint not null,
    id_organization_fertilizer  bigint not null,
    id_fertilizer_unit          bigint not null,
    fertilizer_consum           decimal(10,5),
    constraint fk_id_routing        foreign key (id_routing)        references agrc.doc_routing (id),
    constraint fk_id_routing_work   foreign key (id_routing_work)   references agrc.tp_routing_work (id),
    constraint fk_id_organization_fertilizer    foreign key (id_organization_fertilizer)    references agrc.reg_organization_fertilizer (id),
    constraint fk_id_fertilizer_unit            foreign key (id_fertilizer_unit)            references dict.cls_unit (id)
)
inherits (base.base_tab_part)
;
--табличная часть «средства защиты» документа «технологическая карта»
create table if not exists agrc.tp_routing_protection_equipment
(
    id                                      bigserial primary key,
    id_routing                              bigint not null,
    id_routing_work                         bigint not null,
    id_organization_protection_equipment    bigint not null,
    id_protection_equipment_unit               bigint not null,
    protection_equipment_consum             decimal(10,5),
    constraint fk_id_routing        foreign key (id_routing) references agrc.doc_routing (id),
    constraint fk_id_routing_work   foreign key (id_routing_work) references agrc.tp_routing_work (id),
    constraint fk_id_organization_protection_equipment foreign key (id_organization_protection_equipment)   references agrc.reg_organization_protection_equipment(id),
    constraint fk_id_protection_equipment_unit         foreign key (id_protection_equipment_unit)           references dict.cls_unit (id)
)
inherits (base.base_tab_part)
;
--табличная часть «расходные материалы» документа «технологическая карта»
create table if not exists agrc.tp_routing_consum
(
    id                                      bigserial primary key,
    id_routing                              bigint not null,
    id_routing_work                         bigint not null,
    id_organization_consumable              bigint not null,
    id_consumable_unit                      bigint not null,
    consumable_consum                       decimal(10,5),
    constraint fk_id_routing        foreign key (id_routing)        references agrc.doc_routing (id),
    constraint fk_id_routing_work   foreign key (id_routing_work)   references agrc.tp_routing_work (id),
    constraint fk_id_organization_consumable    foreign key (id_organization_consumable)    references org.reg_organization_consumable(id),
    constraint fk_id_consumable_unit            foreign key (id_consumable_unit)            references dict.cls_unit (id)
)
inherits (base.base_tab_part)
;
----------------------------doc_routing----------------------------------