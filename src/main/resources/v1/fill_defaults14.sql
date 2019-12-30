-- имя элемента справочника по умолчанию
create or replace function base.default_name()
returns text as
$$
begin
    return 'По умолчанию';
end
$$
language 'plpgsql' immutable
;
-- идентификатор по умолчанию
create or replace function base.default_id()
returns bigint as
$$
begin
    return 1;
end
$$
language 'plpgsql' immutable
;
-- номер по умолчанию
create or replace function base.default_number()
returns character varying(15) as
$$
begin
    return '000000000000000';
end
$$
language 'plpgsql' immutable
;
-- возвращает идентификатор по умолчанию для таблицы исходя из имени по умолчанию
create or replace function base.get_default_relation(ptable_name text)
   returns bigint as
$$
DECLARE def text;
	    result bigint;
begin
    def := base.default_name();
    EXECUTE format(
        'SELECT id FROM %s '
        'WHERE name = $1'
        'limit 1', ptable_name
    )
    into result
    using def;
    return result;
end
$$ language 'plpgsql' immutable;
;
-- код по умолчанию
create or replace function base.default_code()
returns character varying(15) as
$$
begin
    return 'DEFAULT';
end
$$
language 'plpgsql' immutable
;
-----------------------------------------------------------------------------------------------------------------------
insert into dict.cls_legal_entity(name, date_create, number, inn, description, id_user_creator)
values (base.default_name(), '-infinity', base.default_number(), '', '{}'::json, 1)
;
insert into dict.cls_organization(name, date_create, number, inn,
    id_legal_entity,
    id_user_creator
)
values (base.default_name(), '-infinity', base.default_number(), '',
    base.get_default_relation('dict.cls_legal_entity'),
    1
)
;
insert into org.cls_depart(name, date_create, number,
    id_legal_entity,
    id_organization,
    id_user_creator
)
values (base.default_name(), '-infinity', base.default_number(),
    base.get_default_relation('dict.cls_legal_entity'),
    base.get_default_relation('dict.cls_organization'),
    1
)
;
insert into org.cls_employee(name, date_create, number,
    id_depart,
    id_organization,
    id_user_creator
)
values (base.default_name(), '-infinity', base.default_number(),
    base.get_default_relation('org.cls_depart'),
    base.get_default_relation('dict.cls_organization'),
    1
)
;