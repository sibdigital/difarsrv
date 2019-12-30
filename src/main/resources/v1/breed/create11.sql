create schema if not exists breed
  --authorization postgres;
;
--справочник «виды животных»
create table if not exists breed.cls_kind_animal
(
    id  bigserial primary key
)
inherits (base.base_coded_classifier)
;
--справочник «породы»
create table if not exists breed.cls_breed
(
    id                  bigserial primary key,
    id_kind_animal      bigint not null,
    constraint fk_id_kind_animal foreign key (id_kind_animal) references breed.cls_kind_animal (id)
)
inherits (base.base_classifier)
;
--справочник «причины выбытия»
--	забой
--	продажа
--	вынужденный забой
--	падеж
create table if not exists breed.cls_animal_retirement_cause
(
    id                  bigserial primary key,
    id_parent           bigint not null,
    parent_path         ltree
)
inherits (base.base_coded_classifier)
;
--справочник «виды групп животных»
create table if not exists breed.cls_animal_group_kind
(
    id  bigserial primary key
)
inherits (base.base_coded_classifier)
;
--справочник «виды параметров животных»
create table if not exists breed.cls_animal_param_kind
(
    id          bigserial primary key,
    type        integer, -- 0 – строка 1 – число 2 - список
    list_values jsonb --значения параметра для список
)
inherits (base.base_classifier)
;
--справочник «типы событий животных»
create table if not exists breed.cls_type_animal_event
(
    id                                  bigserial primary key,
    list_params                         jsonb, -- параметры события
    list_params_tab_part_animal         jsonb, --параметры табличной части «животные» события
    list_params_tab_part_animal_group  jsonb -- параметры табличной части «группы животных» события:
                                              -- json, содержащий структур, которая должна заполняться для doc_animal_event
)
inherits (base.base_classifier)
;
--справочник «половозрастные группы»
create table if not exists breed.cls_age_sex_group
(
    id          bigserial primary key,
    sex         integer, -- 0 – мужской 1 – женский
    begin_age   integer, --начальный возраст в днях
    end_age     integer --конечный  возраст в днях
)
inherits (base.base_coded_classifier)
;