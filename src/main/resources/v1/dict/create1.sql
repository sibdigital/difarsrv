create schema if not exists dict
  --authorization postgres;
;
--справочник «юридическое лицо»
--организация, зарегистрированная в системе
create table if not exists dict.cls_legal_entity
(
    id bigserial    primary key,
    inn             character varying(10),
    description     jsonb
)
inherits (base.base_classifier)
;
--справочник «организация»
create table if not exists dict.cls_organization
(
    id bigserial    primary key,
    inn             character varying(10),
    id_legal_entity bigint not null,
    constraint fk_id_legal_entity foreign key (id_legal_entity) references dict.cls_legal_entity (id)
)
inherits (base.base_classifier)
;