start transaction
;
insert into accs.cls_user(name, date_create, number, password,
    id_employee,
    id_organization,
    id_user_creator
)
values (base.default_name(), '-infinity', base.default_number(), '',
    base.get_default_relation('org.cls_employee'),
    base.get_default_relation('dict.cls_organization'),
    1
)
;
insert into accs.cls_role(name, date_create, number, code, id_user_creator)
values (base.default_name(), '-infinity', base.default_number(), base.default_code(), base.get_default_relation('accs.cls_user'))
;
insert into accs.cls_resource(name, date_create, number, code, id_user_creator)
values (base.default_name(), '-infinity', base.default_number(), base.default_code(), base.get_default_relation('accs.cls_user'))
;
insert into accs.reg_cvitantion(
    id_user_creator,
    id_resource,
    id_role,
    operation
)
values (
    base.get_default_relation('accs.cls_user'),
    base.get_default_relation('accs.cls_resource'),
    base.get_default_relation('accs.cls_role'),
    ''
)
;
insert into accs.reg_user_role(
    id_user_creator,
    id_user,
    id_role
)
values (
    base.get_default_relation('accs.cls_user'),
    base.get_default_relation('accs.cls_user'),
    base.get_default_relation('accs.cls_role')
)
;
------------------------------------------------------------------------------------------------------------------------
insert into dict.cls_region(name, date_create, number, code,
    id_user_creator
)
values (base.default_name(), '-infinity', base.default_number(), base.default_code(),
    base.get_default_relation('accs.cls_user')
)
;
insert into dict.cls_district(name, date_create, number,
    id_user_creator,
    id_region
)
values (base.default_name(), '-infinity', base.default_number(),
    base.get_default_relation('accs.cls_user'),
    base.get_default_relation('dict.cls_region')
)
;
insert into dict.cls_area(name, date_create, number,
    id_user_creator,
    id_district
)
values (base.default_name(), '-infinity', base.default_number(),
    base.get_default_relation('accs.cls_user'),
    base.get_default_relation('dict.cls_district')
)
;
insert into dict.cls_standard_period(name, date_create, number,
    id_user_creator,
    period_type, date_begin, date_end
)
values (base.default_name(), '-infinity', base.default_number(),
    base.get_default_relation('accs.cls_user'),
    8, '-infinity', 'infinity'
)
;
insert into dict.cls_arbitrary_period(name, date_create, number,
    id_user_creator,
    id_standard_period,
    id_region,
    id_district,
    id_organization,
    date_begin, date_end
)
values (base.default_name(), '-infinity', base.default_number(),
    base.get_default_relation('accs.cls_user'),
    base.get_default_relation('dict.cls_standard_period'),
    base.get_default_relation('dict.cls_region'),
    base.get_default_relation('dict.cls_district'),
    base.get_default_relation('dict.cls_organization'),
    '-infinity', 'infinity'
)
;
insert into dict.cls_unit(name, date_create, number, code,
    id_user_creator, reduct
)
values (base.default_name(), '-infinity', base.default_number(), base.default_code(),
    base.get_default_relation('accs.cls_user'), base.default_name()
)
;
commit
;