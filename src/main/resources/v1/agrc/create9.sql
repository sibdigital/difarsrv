--регистр «исполнение работы технологической карты»
create table if not exists agrc.reg_exec_routing_work
(
    id               bigserial primary key,
    id_routing       bigint not null,
    id_routing_work  bigint not null,
    id_maker         bigint not null, --тот, кто ввел  - таблица cls_employee
    id_employee      bigint not null, --исполнитель
    number           character varying(15) not null,
    begin_work       timestamp without time zone default current_timestamp,
    end_work         timestamp without time zone default 'infinity',
    constraint fk_id_routing        foreign key (id_routing)        references agrc.doc_routing (id),
    constraint fk_id_routing_work   foreign key (id_routing_work)   references agrc.tp_routing_work (id),
    constraint fk_id_maker          foreign key (id_maker)          references org.cls_employee (id),
    constraint fk_id_employee       foreign key (id_employee)       references org.cls_employee (id)
)
inherits (base.base_register)
;
--регистр «использование техники работы технологической карты»
create table if not exists agrc.reg_exec_routing_equipment
(
    id               bigserial primary key,
    id_routing       bigint not null,
    id_routing_work  bigint not null,
    id_maker         bigint not null, --тот, кто ввел  - таблица cls_employee
    id_employee      bigint not null, --исполнитель
    id_organization_equipment  bigint not null,
    id_routing_equipment       bigint not null,
    id_exec_routing_work       bigint not null,
    id_unit                    bigint not null,
    fuel_consum                decimal(10,5),      --расход гсм фактический
    number                     character varying(15) not null,
    constraint fk_id_routing        foreign key (id_routing)        references agrc.doc_routing (id),
    constraint fk_id_routing_work   foreign key (id_routing_work)   references agrc.tp_routing_work (id),
    constraint fk_id_maker          foreign key (id_maker)          references org.cls_employee (id),
    constraint fk_id_employee       foreign key (id_employee)       references org.cls_employee (id),
    constraint fk_id_organization_equipment foreign key (id_organization_equipment) references org.reg_organization_equipment (id),
    constraint fk_id_routing_equipment      foreign key (id_routing_equipment)      references org.reg_organization_equipment (id),
    constraint fk_id_exec_routing_work      foreign key (id_exec_routing_work)      references agrc.reg_exec_routing_work (id),
    constraint fk_id_unit                   foreign key (id_unit)                   references dict.cls_unit (id)
)
inherits (base.base_register)
;
--регистр «использование удобрения работы технологической карты»
create table if not exists agrc.reg_exec_routing_fertilizer
(
    id               bigserial primary key,
    id_routing       bigint not null,
    id_routing_work  bigint not null,
    id_maker         bigint not null, --тот, кто ввел  - таблица cls_employee
    id_employee      bigint not null, --исполнитель
    id_organization_fertilizer bigint not null,
    id_routing_fertilizer      bigint not null,
    id_exec_routing_work       bigint not null,
    id_fertilizer_unit         bigint not null,
    fertilizer_consum          decimal(10,5),      --расход фактический
    number                     character varying(15) not null,
    constraint fk_id_routing        foreign key (id_routing)        references agrc.doc_routing (id),
    constraint fk_id_routing_work   foreign key (id_routing_work)   references agrc.tp_routing_work (id),
    constraint fk_id_maker          foreign key (id_maker)          references org.cls_employee (id),
    constraint fk_id_employee       foreign key (id_employee)       references org.cls_employee (id),
    constraint fk_id_organization_fertilizer    foreign key (id_organization_fertilizer)    references agrc.reg_organization_fertilizer(id),
    constraint fk_id_routing_fertilizer         foreign key (id_routing_fertilizer)         references agrc.reg_organization_fertilizer(id),
    constraint fk_id_exec_routing_work          foreign key (id_exec_routing_work)          references agrc.reg_exec_routing_work (id),
    constraint fk_id_fertilizer_unit            foreign key (id_fertilizer_unit)            references dict.cls_unit (id)
)
inherits (base.base_register)
;
--регистр «использование средства защиты работы технологической карты»
create table if not exists agrc.reg_exec_routing_protection_equipment
(
    id               bigserial primary key,
    id_routing       bigint not null,
    id_routing_work  bigint not null,
    id_maker         bigint not null, --тот, кто ввел  - таблица cls_employee
    id_employee      bigint not null, --исполнитель
    id_organization_protection_equipment bigint not null,
    id_routing_protection_equipment      bigint not null,
    id_exec_routing_work                 bigint not null,
    id_protection_equipment_unit         bigint not null,
    protection_equipment_consum          decimal(10,5),      --расход фактический
    number                               character varying(15) not null,
    constraint fk_id_routing        foreign key (id_routing)        references agrc.doc_routing (id),
    constraint fk_id_routing_work   foreign key (id_routing_work)   references agrc.tp_routing_work (id),
    constraint fk_id_maker          foreign key (id_maker)          references org.cls_employee (id),
    constraint fk_id_employee       foreign key (id_employee)       references org.cls_employee (id),
    constraint fk_id_organization_protection_equipment  foreign key (id_organization_protection_equipment)  references agrc.reg_organization_protection_equipment(id),
    constraint fk_id_routing_protection_equipment       foreign key (id_routing_protection_equipment)       references agrc.reg_organization_protection_equipment(id),
    constraint fk_id_exec_routing_work                  foreign key (id_exec_routing_work)                  references agrc.reg_exec_routing_work (id),
    constraint fk_id_protection_equipment_unit          foreign key (id_protection_equipment_unit)          references dict.cls_unit (id)
)
inherits (base.base_register)
;
--регистр «использование расходного материала работы технологической карты»
create table if not exists agrc.reg_exec_routing_consum
(
    id               bigserial primary key,
    id_routing       bigint not null,
    id_routing_work  bigint not null,
    id_maker         bigint not null, --тот, кто ввел  - таблица cls_employee
    id_employee      bigint not null, --исполнитель
    id_organization_consum bigint not null,
    id_routing_consum      bigint not null,
    id_exec_routing_work   bigint not null,
    id_consum_unit         bigint not null,
    consum_consum          decimal(10,5),      --расход фактический
    number                 character varying(15) not null,
    constraint fk_id_routing        foreign key (id_routing)        references agrc.doc_routing (id),
    constraint fk_id_routing_work   foreign key (id_routing_work)   references agrc.tp_routing_work (id),
    constraint fk_id_maker          foreign key (id_maker)          references org.cls_employee (id),
    constraint fk_id_employee       foreign key (id_employee)       references org.cls_employee (id),
    constraint fk_id_organization_consum    foreign key (id_organization_consum)    references org.reg_organization_consumable(id),
    constraint fk_id_routing_consum         foreign key (id_routing_consum)         references org.reg_organization_consumable(id),
    constraint fk_id_exec_routing_work      foreign key (id_exec_routing_work)      references agrc.reg_exec_routing_work (id),
    constraint fk_id_consum_unit            foreign key (id_consum_unit)            references dict.cls_unit (id)
)
inherits (base.base_register)
;
--документ «регистрация урожая»
create table if not exists agrc.doc_actual_yield
(
    id                          bigserial primary key,
    id_organization             bigint not null,
    id_routing                  bigint not null,
    id_crop                     bigint not null,
    id_field                    bigint not null,
    id_unit                     bigint not null, --единица измерения урожая
    id_actual_prolificness_unit bigint not null,
    yield                       decimal(10,5), --фактический урожай
    actual_prolificness         decimal(10,5), --фактическая урожайность
    constraint fk_id_organization   foreign key (id_organization)   references dict.cls_organization (id),
    constraint fk_id_routing        foreign key (id_routing)        references agrc.doc_routing (id),
    constraint fk_id_crop           foreign key (id_crop)           references agrc.cls_crop (id),
    constraint fk_id_field          foreign key (id_field)          references agrc.cls_field (id),
    constraint fk_id_unit           foreign key (id_unit)           references dict.cls_unit (id),
    constraint fk_id_actual_prolificness_unit foreign key (id_actual_prolificness_unit) references dict.cls_unit (id)
)
inherits (base.base_document)
;