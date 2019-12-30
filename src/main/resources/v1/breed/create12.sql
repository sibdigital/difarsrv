
--регистр «внешние предки»
--для указания предков животных, которые не регистрировались в системе
create table if not exists breed.reg_external_animal
(
    id              bigserial primary key,
    id_organization bigint not null,
    id_partner      bigint not null,
    id_kind_animal  bigint not null,
    id_breed        bigint not null,
    id_region       bigint not null,
    id_district     bigint not null,
    id_area         bigint not null,
    id_mother       bigint not null,
    id_father       bigint not null,
    date_birth      timestamp without time zone default '-infinity',
    date_retirement timestamp without time zone default 'infinity',
    sex             integer, -- 0 – мужской 1 – женский
    chip_ident      text,   --идентификатор чипа
    ident           jsonb, --идентификационные данные животного
    nick            text,  --кличка
    mother_path     ltree,
    father_path     ltree,
    constraint fk_id_organization   foreign key (id_organization)   references dict.cls_organization (id),
    constraint fk_id_partner        foreign key (id_partner)        references dict.cls_partner (id),
    constraint fk_id_kind_animal    foreign key (id_kind_animal)    references breed.cls_kind_animal (id),
    constraint fk_id_breed          foreign key (id_breed)          references breed.cls_breed (id),
    constraint fk_id_region         foreign key (id_region)         references dict.cls_region (id),
    constraint fk_id_district       foreign key (id_district)       references dict.cls_district (id),
    constraint fk_id_area           foreign key (id_area)           references dict.cls_area (id)
)
inherits (base.base_register)
;
--регистр «группа животного»
--к какой группе относится животное, делается, например, при запуске группы быков для покрытия.
create table if not exists breed.reg_animal_group
(
    id                      bigserial primary key,
    id_organization         bigint not null,
    id_ranch                bigint not null,
    id_animal               bigint not null,
    id_animal_group_kind    bigint not null,
    constraint fk_id_organization       foreign key (id_organization)       references dict.cls_organization (id),
    constraint fk_id_ranch              foreign key (id_ranch)              references org.cls_ranch (id),
    constraint fk_id_animal_group_kind  foreign key (id_animal_group_kind)  references breed.cls_animal_group_kind(id)
)
inherits (base.base_register)
;
--регистр «животные»
--животные – крупный рогатый скот на текущий момент
create table if not exists breed.reg_animal
(
    id                  bigserial primary key,
    id_organization     bigint not null,
    id_partner          bigint not null,
    id_kind_animal      bigint not null,
    id_breed            bigint not null,
    id_region           bigint not null,
    id_district         bigint not null,
    id_area             bigint not null,
    id_mother           bigint not null,
    id_father           bigint not null,
    id_group_mother     bigint not null,
    id_group_father     bigint not null,
    id_external_mother  bigint not null,
    id_external_father  bigint not null,
    date_birth      timestamp without time zone default '-infinity',
    date_retirement timestamp without time zone default 'infinity',
    sex             integer, -- 0 – мужской 1 – женский
    chip_ident      text,   --идентификатор чипа
    ident           jsonb, --идентификационные данные животного
    nick            text,  --кличка
    mother_path     ltree,
    father_path     ltree,
    constraint fk_id_organization   foreign key (id_organization)   references dict.cls_organization (id),
    constraint fk_id_partner        foreign key (id_partner)        references dict.cls_partner (id),
    constraint fk_id_kind_animal    foreign key (id_kind_animal)    references breed.cls_kind_animal (id),
    constraint fk_id_breed          foreign key (id_breed)          references breed.cls_breed (id),
    constraint fk_id_region         foreign key (id_region)         references dict.cls_region (id),
    constraint fk_id_district       foreign key (id_district)       references dict.cls_district (id),
    constraint fk_id_area           foreign key (id_area)           references dict.cls_area (id),
    constraint fk_id_group_mother   foreign key (id_group_mother)   references breed.reg_animal_group (id),
    constraint fk_id_group_father   foreign key (id_group_father)   references breed.reg_animal_group (id)
)
inherits (base.base_register)
;
alter table breed.reg_animal_group
   add constraint fk_id_animal foreign key (id_animal) references breed.reg_animal(id);
;
--регистр «локализация животного»
--на какой ферме и в какой период времени располагается животное.
create table if not exists breed.reg_animal_local
(
    id                      bigserial primary key,
    id_organization         bigint not null,
    id_ranch                bigint not null,
    id_animal               bigint not null,
    id_doc                  bigint not null, --документ, зарегистрировавший событие ограничения ссылочной целостности не накладываются
    constraint fk_id_organization   foreign key (id_organization)   references dict.cls_organization (id),
    constraint fk_id_ranch          foreign key (id_ranch)          references org.cls_ranch (id),
    constraint fk_id_animal         foreign key (id_animal)         references breed.reg_animal(id)
)
inherits (base.base_register)
;
--регистр «параметры животного»
create table if not exists breed.reg_animal_param
(
    id                      bigserial primary key,
    id_organization         bigint not null,
    id_ranch                bigint not null,
    id_animal               bigint not null,
    id_doc                  bigint not null, --документ, зарегистрировавший событие ограничения ссылочной целостности не накладываются
    id_unit_weight          bigint not null,
    weight                  decimal(10,5),
    constraint fk_id_organization   foreign key (id_organization)   references dict.cls_organization (id),
    constraint fk_id_ranch          foreign key (id_ranch)          references org.cls_ranch (id),
    constraint fk_id_unit_weight    foreign key (id_unit_weight)    references dict.cls_unit (id),
    constraint fk_id_animal         foreign key (id_animal)         references breed.reg_animal(id)
)
inherits (base.base_register)
;
--регистр «детальные параметры животного»
create table if not exists breed.reg_animal_param
(
    id                      bigserial primary key,
    id_organization         bigint not null,
    id_ranch                bigint not null,
    id_animal               bigint not null,
    id_doc                  bigint not null, --документ, зарегистрировавший событие ограничения ссылочной целостности не накладываются
    id_animal_param_kind    bigint not null, --вид параметра
    string_value            text,
    decimal_value           decimal(10,5),
    list_key                text, --ключ списка при этом значение списка заносится в строковое значение, а в данном поле указывается key
    type_animal_param_kind  integer, --тип вида параметра 0 – строка 1 – число 2 – список из cls_animal_param_kind
    constraint fk_id_organization   foreign key (id_organization)   references dict.cls_organization (id),
    constraint fk_id_ranch          foreign key (id_ranch)          references org.cls_ranch (id),
    constraint fk_id_animal_param_kind  foreign key (id_animal_param_kind)  references breed.cls_animal_param_kind (id),
    constraint fk_id_animal             foreign key (id_animal)             references breed.reg_animal(id)
)
inherits (base.base_register)
;
--регистр «состояние животного»
create table if not exists breed.reg_animal_state
(
    id                      bigserial primary key,
    id_organization         bigint not null,
    id_ranch                bigint not null,
    id_animal               bigint not null,
    id_doc                  bigint not null, --документ, зарегистрировавший событие ограничения ссылочной целостности не накладываются
    id_type_animal_event    bigint not null,
    weight                  decimal(10,5),
    constraint fk_id_organization   foreign key (id_organization)   references dict.cls_organization (id),
    constraint fk_id_ranch          foreign key (id_ranch)          references org.cls_ranch (id),
    constraint fk_id_type_animal_event  foreign key (id_type_animal_event)  references breed.cls_type_animal_event (id),
    constraint fk_id_animal             foreign key (id_animal)             references breed.reg_animal(id)
)
inherits (base.base_register)
;