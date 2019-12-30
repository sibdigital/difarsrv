create schema if not exists org
  --authorization postgres;
;
--справочник «подразделение»
create table if not exists org.cls_depart
(
    id bigserial            primary key,
    id_legal_entity bigint  not null,
    id_organization bigint  not null,
    is_separate             boolean default false,
    constraint fk_id_legal_entity foreign key (id_legal_entity) references dict.cls_legal_entity (id),
    constraint fk_id_organization foreign key (id_organization) references dict.cls_organization (id)
)
inherits (base.base_classifier)
;
--справочник «сотрудник»
create table if not exists org.cls_employee
(
    id bigserial        primary key,
    surname             text, --фамилия
    firstname           text,
    patronymic          text,
    id_depart bigint    not null,
    id_organization     bigint not null,
    constraint fk_id_depart foreign key (id_depart) references org.cls_depart (id),
    constraint fk_id_organization foreign key (id_organization) references dict.cls_organization (id)
)
inherits (base.base_classifier)
;