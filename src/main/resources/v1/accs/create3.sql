create schema if not exists accs
  --authorization postgres;
;
--Справочник «Пользователь»
create table if not exists accs.cls_user
(
    id bigserial    primary key,
    password text   not null,
    id_organization bigint not null,
    id_employee     bigint not null,
    constraint fk_id_organization   foreign key (id_organization)   references dict.cls_organization (id),
    constraint fk_id_employee       foreign key (id_employee)       references org.cls_employee (id)
)
inherits (base.base_classifier)
;
--Справочник «Роли»
create table if not exists accs.cls_role
(
    id bigserial primary key
)
inherits (base.base_coded_classifier)
;
--Справочник «Ресурсы»
--В качестве ресурсов выступают отчеты, формы и подпрограммы
create table if not exists accs.cls_resource
(
    id bigserial primary key
)
inherits (base.base_coded_classifier)
;
--Регистр «Квитанции»
--Описывает наборы операций с ресурсами.
create table if not exists accs.reg_cvitantion
(
    id bigserial    primary key,
    id_resource     bigint not null,
    id_role         bigint not null,
    operation       character varying(15) not null, --создание – c, чтение – r, обновление – u, удаление – d, выполнение - e
    constraint fk_id_resource   foreign key (id_resource)   references accs.cls_resource (id),
    constraint fk_id_role       foreign key (id_role)       references accs.cls_role (id)
)
inherits (base.base_register)
;
--Регистр «Роли пользователей»
create table if not exists accs.reg_user_role
(
    id bigserial    primary key,
    id_user         bigint not null,
    id_role         bigint not null,
    constraint fk_id_user   foreign key (id_user) references accs.cls_user (id),
    constraint fk_id_role   foreign key (id_role) references accs.cls_role (id)
)
inherits (base.base_register)
;