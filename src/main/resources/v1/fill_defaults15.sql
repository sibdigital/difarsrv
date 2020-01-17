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
        '-infinity', 'infinity')
;
insert into dict.cls_unit(name, date_create, number, code,
                          id_user_creator, reduct)
values (base.default_name(), '-infinity', base.default_number(), base.default_code(),
        base.get_default_relation('accs.cls_user'), base.default_name())
;
insert into breed.cls_age_sex_group(id_user_creator, name, date_create, number, code, sex, begin_age, end_age)
values (base.get_default_relation('accs.cls_user'), base.default_name(), '-infinity',
        base.default_number(), base.default_code(), 0, 0, 0);

insert into breed.cls_animal_group_kind(id_user_creator, name, date_create, number, code)
values (base.get_default_relation('accs.cls_user'), base.default_name(),
        '-infinity', base.default_number(), base.default_code());

insert into breed.cls_animal_param_kind(id_user_creator, name, date_create, number, type, list_values)
values (base.get_default_relation('accs.cls_user'), base.default_name(), '-infinity',
        base.default_number(), 0, '{
    "value": "default"
  }');

insert into dict.cls_consumable_kind(id_user_creator, name, date_create, number, code)
values (base.get_default_relation('accs.cls_user'), base.default_name(),
        '-infinity', base.default_number(), base.default_code());

insert into dict.cls_consumable(id_user_creator, name, date_create, number, id_consumable_kind, id_unit, max_consum,
                                min_consum)
values (base.get_default_relation('accs.cls_user'), base.default_name(), '-infinity',
        base.default_number(), base.get_default_relation('dict.cls_consumable_kind'),
        base.get_default_relation('dict.cls_unit'), 0, 0);

insert into agrc.cls_crop(id_user_creator, name, date_create, number, code)
values (base.get_default_relation('accs.cls_user'), base.default_name(),
        '-infinity', base.default_number(), base.default_code());

insert into agrc.cls_crop_variety(id_user_creator, name, date_create, number, id_crop)
values (base.get_default_relation('accs.cls_user'), base.default_name(), '-infinity',
        base.default_number(), base.get_default_relation('agrc.cls_crop'));

insert into agrc.cls_disease_feature(id_user_creator, name, date_create, number, code)
values (base.get_default_relation('accs.cls_user'), base.default_name(),
        '-infinity', base.default_name(), base.default_code());

insert into dict.cls_equipment_type(id_user_creator, name, date_create, number, code)
values (base.get_default_relation('accs.cls_user'), base.default_name(),
        '-infinity', base.default_number(), base.default_code());

insert into dict.cls_equipment_kind(id_user_creator, name, date_create, number, id_equipment_type)
values (base.get_default_relation('accs.cls_user'), base.default_name(), '-infinity',
        base.default_number(), base.get_default_relation('dict.cls_equipment_type'));

insert into agrc.cls_field(id_user_creator, name, date_create, number, id_organization)
values (base.get_default_relation('accs.cls_user'), base.default_name(), '-infinity',
        base.default_number(), base.get_default_relation('dict.cls_organization'));

insert into breed.cls_kind_animal(id_user_creator, name, date_create, number, code)
values (base.get_default_relation('accs.cls_user'), base.default_name(),
        '-infinity', base.default_number(), base.default_code());

insert into breed.cls_breed(id_user_creator, name, date_create, number, id_kind_animal)
values (base.get_default_relation('accs.cls_user'), base.default_name(), '-infinity',
        base.default_number(), base.get_default_relation('breed.cls_kind_animal'));

insert into dict.cls_partner(id_user_creator, name, date_create, number, inn, id_legal_entity)
values (base.get_default_relation('accs.cls_user'), base.default_name(), '-infinity',
        base.default_number(), '0', base.get_default_relation('dict.cls_legal_entity'));

insert into agrc.cls_plant_disease(id_user_creator, name, date_create, number, code, id_unit, symptom, cause,
                                   harmfulness, photos, additional_names, condition, min_incub_period, max_incub_period)
values (base.get_default_relation('accs.cls_user'), base.default_name(),
        '-infinity', base.default_number(), base.default_code(),
        base.get_default_relation('dict.cls_unit'),
        '{
          "value": "default"
        }', '{
    "value": "default"
  }', '{
    "value": "default"
  }',
        '{
          "value": "default"
        }', '{
    "value": "default"
  }', '{
    "value": "default"
  }',
        0, 0);

insert into agrc.cls_plant_organ(id_user_creator, name, date_create, number, code)
values (base.get_default_relation('accs.cls_user'), base.default_name(),
        '-infinity', base.default_number(), base.default_code());

insert into agrc.cls_plant_pest(id_user_creator, name, number, code, id_unit, photos, additional_names, condition,
                                description, min_incub_period, max_incub_period)
values (base.get_default_relation('accs.cls_user'), base.default_name(),
        base.default_number(), base.default_code(), base.get_default_relation('dict.cls_unit'),
        '{
          "value": "default"
        }', '{
    "value": "default"
  }', '{
    "value": "default"
  }',
        '{
          "value": "default"
        }', 0, 0);

insert into org.cls_position(id_user_creator, name, date_create, number, id_organization)
values (base.get_default_relation('accs.cls_user'), base.default_name(),
        '-infinity', base.default_number(),
        base.get_default_relation('dict.cls_organization'));

insert into agrc.cls_protection_equipment(id_user_creator, name, date_create, number, code, id_unit, max_consum,
                                          min_consum)
values (base.get_default_relation('accs.cls_user'), base.default_name(),
        '-infinity', base.default_number(), base.default_code(), base.get_default_relation('dict.cls_unit'),
        0, 0);

insert into breed.cls_type_animal_event(id_user_creator, name, date_create, number, list_params,
                                        list_params_tab_part_animal, list_params_tab_part_animal_group)
values (base.get_default_relation('accs.cls_user'), base.default_name(),
        '-infinity', base.default_number(), '{
    "value": "default"
  }', '{
    "value": "default"
  }', '{
    "value": "default"
  }');

insert into dict.cls_unit(id_user_creator, name, date_create, number, code, reduct)
values (base.get_default_relation('accs.cls_user'), base.default_name(),
        '-infinity', base.default_number(), base.default_code(), '');

insert into dict.cls_unit_ratio(id_user_creator, name, date_create, number, id_unit_from, id_unit_to, ratio)
values (base.get_default_relation('accs.cls_user'), base.default_name(),
        '-infinity', base.default_number(), base.get_default_relation('dict.cls_unit'),
        base.get_default_relation('dict.cls_unit'), 0);

insert into agrc.cls_veget_period(id_user_creator, name, date_create, number, code)
values (base.get_default_relation('accs.cls_user'), base.default_name(),
        '-infinity', base.default_number(), base.default_code());

commit
;