----------------------+документ «событие животного»+----------------------------
--документ «событие животного»
--при записи документа осуществляется дополнительная запись в reg_animal_state – регистр «состояние животного».
create table if not exists breed.doc_animal_event
(
    id                      bigserial primary key,
    id_organization         bigint not null,
    id_type_animal_event    bigint not null,
    list_values             jsonb, --идентификационные данные животного
    is_pair                 boolean,  --это парное событие если в событии должны участвовать два животных или две группы животных.
    multiplicity            integer, --0 – животное заполняется tp_animal_event_animal
                                     --1 – группа животных  заполняется tp_animal_event_animal_group
    constraint fk_id_organization       foreign key (id_organization)       references dict.cls_organization (id),
    constraint fk_id_type_animal_event  foreign key (id_type_animal_event)  references breed.cls_type_animal_event (id)
)
inherits (base.base_document)
;
--табличная часть «животное» документа «событие животного»
create table if not exists breed.tp_animal_event_animal
(
    id                  bigserial primary key,
    id_animal_event     bigint not null,
    id_animal1          bigint not null,
    id_animal2          bigint not null,
    list_values1        jsonb,   --значения параметров события животное 1 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    list_values2        jsonb,   --значения параметров события животное 2 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    constraint fk_id_animal_event   foreign key (id_animal_event)   references breed.doc_animal_event (id),
    constraint fk_id_animal1        foreign key (id_animal1)        references breed.reg_animal(id),
    constraint fk_id_animal2        foreign key (id_animal2)        references breed.reg_animal(id)
)
inherits (base.base_tab_part)
;
--табличная часть «группа животных» документа «событие животного»
create table if not exists breed.tp_animal_event_animal_group
(
    id                  bigserial primary key,
    id_animal_event     bigint not null,
    id_animal_group1    bigint not null,
    id_animal_group2    bigint not null,
    list_values1        jsonb,   --значения параметров события животное 1 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    list_values2        jsonb,   --значения параметров события животное 2 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    constraint fk_id_animal_event   foreign key (id_animal_event)   references breed.doc_animal_event (id),
    constraint fk_id_animal_group1  foreign key (id_animal_group1)  references breed.reg_animal_group(id),
    constraint fk_id_animal_group2  foreign key (id_animal_group2)  references breed.reg_animal_group(id)
)
inherits (base.base_tab_part)
;
------------------------документ «событие животного»----------------------------

----------------------+документ «перемещениео»+----------------------------
--документ «перемещение»
--при записи документа осуществляется дополнительная запись в reg_animal_state – регистр «состояние животного».
--при записи документа осуществляется дополнительная запись в reg_animal_local – регистр «локализация животного».
create table if not exists breed.doc_animal_transfer
(
    id                      bigserial primary key,
    id_organization         bigint not null,
    id_type_animal_event    bigint not null,
    id_ranch                bigint not null, --ферма, куда животные будут перемещены
    id_ranch_current        bigint not null, --ферма где животные находятся на текущий момент
    multiplicity            integer, --0 – животное заполняется tp_animal_event_animal
                                     --1 – группа животных  заполняется tp_animal_event_animal_group
    constraint fk_id_organization       foreign key (id_organization)       references dict.cls_organization (id),
    constraint fk_id_type_animal_event  foreign key (id_type_animal_event)  references breed.cls_type_animal_event (id),
    constraint fk_id_ranch              foreign key (id_ranch)              references org.cls_ranch (id),
    constraint fk_id_ranch_current      foreign key (id_ranch_current)      references org.cls_ranch (id)
)
inherits (base.base_document)
;
--табличная часть «животное» документа «перемещение»
create table if not exists breed.tp_animal_transfer_animal
(
    id                  bigserial primary key,
    id_animal_transfer  bigint not null,
    id_animal           bigint not null,
    list_values         jsonb,   --значения параметров события животное 1 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    constraint fk_id_animal_transfer    foreign key (id_animal_transfer)    references breed.doc_animal_transfer (id),
    constraint fk_id_animal             foreign key (id_animal)             references breed.reg_animal(id)
)
inherits (base.base_tab_part)
;
--табличная часть «группа животных» документа «перемещение»
create table if not exists breed.tp_animal_transfer_animal_group
(
    id                  bigserial primary key,
    id_animal_transfer  bigint not null,
    id_animal_group     bigint not null,
    list_values         jsonb,   --значения параметров события животное 1 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    constraint fk_id_animal_transfer    foreign key (id_animal_transfer)    references breed.doc_animal_transfer (id),
    constraint fk_id_animal_group       foreign key (id_animal_group)       references breed.reg_animal_group(id)
)
inherits (base.base_tab_part)
;
------------------------документ «перемещение»----------------------------

----------------------+документ «продажа»+----------------------------
--документ «документ «продажа»»
--при записи документа осуществляется дополнительная запись в reg_animal_state – регистр «состояние животного».
--операции по продаже должны фиксироваться с помощью распределенного реестра (блокчейн).
--предлагается использовать hyperledger https://www.hyperledger.org/community/coding
create table if not exists breed.doc_animal_sale
(
    id                      bigserial primary key,
    id_organization         bigint not null,
    id_type_animal_event    bigint not null,
    id_partner              bigint not null,
    multiplicity            integer, --0 – животное заполняется tp_animal_event_animal
                                     --1 – группа животных  заполняется tp_animal_event_animal_group
    constraint fk_id_type_animal_event  foreign key (id_type_animal_event)  references breed.cls_type_animal_event (id),
    constraint fk_id_partner            foreign key (id_partner)            references dict.cls_partner (id)
)
inherits (base.base_document)
;
--табличная часть «животное» документа «продажа»
create table if not exists breed.tp_animal_sale_animal
(
    id                  bigserial primary key,
    id_animal_sale      bigint not null,
    id_animal           bigint not null,
    list_values         jsonb,   --значения параметров события животное 1 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    constraint fk_id_animal_sale    foreign key (id_animal_sale)    references breed.doc_animal_sale (id),
    constraint fk_id_animal         foreign key (id_animal)         references breed.reg_animal(id)
)
inherits (base.base_tab_part)
;
--табличная часть «группа животных» документа «продажа»
create table if not exists breed.tp_animal_sale_animal_group
(
    id                  bigserial primary key,
    id_animal_sale      bigint not null,
    id_animal_group     bigint not null,
    list_values         jsonb,   --значения параметров события животное 1 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    constraint fk_id_animal_sale    foreign key (id_animal_sale)    references breed.doc_animal_sale (id),
    constraint fk_id_animal_group   foreign key (id_animal_group)   references breed.reg_animal_group(id)
)
inherits (base.base_tab_part)
;
------------------------документ «продажа»----------------------------

----------------------+документ «бонитировка»+----------------------------
--документ «бонитировка»
--при записи документа осуществляется дополнительная запись в reg_animal_state – регистр «состояние животного».
--при записи документа осуществляется дополнительная запись в reg_animal_param – регистр «параметры животного».
--при записи документа осуществляется дополнительная запись в reg_animal_param_detail – регистр «детальные параметры животного».
create table if not exists breed.doc_animal_appraisal
(
    id                      bigserial primary key,
    id_organization         bigint not null,
    id_type_animal_event    bigint not null,
    multiplicity            integer, --0 – животное заполняется tp_animal_event_animal
                                     --1 – группа животных  заполняется tp_animal_event_animal_group
    constraint fk_id_organization       foreign key (id_organization)       references dict.cls_organization (id),
    constraint fk_id_type_animal_event  foreign key (id_type_animal_event)  references breed.cls_type_animal_event (id)
)
inherits (base.base_document)
;
--табличная часть «животное» документа «бонитировка»
create table if not exists breed.tp_animal_appraisal_animal
(
    id                  bigserial primary key,
    id_animal_appraisal bigint not null,
    id_animal           bigint not null,
    list_values         jsonb,   --значения параметров события животное 1 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    constraint fk_id_animal_appraisal   foreign key (id_animal_appraisal)   references breed.doc_animal_appraisal (id),
    constraint fk_id_animal             foreign key (id_animal)             references breed.reg_animal(id)
)
inherits (base.base_tab_part)
;
--табличная часть «группа животных» документа «бонитировка»
create table if not exists breed.tp_animal_appraisal_animal_group
(
    id                  bigserial primary key,
    id_animal_appraisal bigint not null,
    id_animal_group     bigint not null,
    list_values         jsonb,   --значения параметров события животное 1 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    constraint fk_id_animal_appraisal   foreign key (id_animal_appraisal)   references breed.doc_animal_appraisal (id),
    constraint fk_id_animal_group       foreign key (id_animal_group)       references breed.reg_animal_group(id)
)
inherits (base.base_tab_part)
;
------------------------документ «бонитировка»----------------------------

----------------------+документ «рождение/отел»+----------------------------
--документ «рождение/отел»
--при записи документа осуществляется дополнительная запись в reg_animal_state – регистр «состояние животного».
--при записи документа осуществляется дополнительная запись в reg_animal – регистр «животные».
--при записи документа осуществляется дополнительная запись в reg_animal_param – регистр «параметры животного».
--при записи документа осуществляется дополнительная запись в reg_animal_param_detail – регистр «детальные параметры животного».
create table if not exists breed.doc_animal_calving
(
    id                      bigserial primary key,
    id_organization         bigint not null,
    id_type_animal_event    bigint not null,
    multiplicity            integer, --0 – животное заполняется tp_animal_event_animal
                                     --1 – группа животных  заполняется tp_animal_event_animal_group
    constraint fk_id_organization       foreign key (id_organization)       references dict.cls_organization (id),
    constraint fk_id_type_animal_event  foreign key (id_type_animal_event)  references breed.cls_type_animal_event (id)
)
inherits (base.base_document)
;
--табличная часть «животное» документа «рождение/отел»
create table if not exists breed.tp_animal_calving_animal
(
    id                  bigserial primary key,
    id_animal_calving   bigint not null,
    id_animal_mother    bigint not null,
    id_animal_father    bigint not null,
    id_animal_child     bigint not null,
    list_values_mother  jsonb,   --значения параметров события животное 1 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    list_values_father  jsonb,   --значения параметров события животное 1 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    list_values_child   jsonb,   --значения параметров события животное 1 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    date_birth          timestamp without time zone default current_timestamp,
    constraint fk_id_animal_calving     foreign key (id_animal_calving)     references breed.doc_animal_calving (id),
    constraint fk_id_animal_mother      foreign key (id_animal_mother)      references breed.reg_animal(id),
    constraint fk_id_animal_father      foreign key (id_animal_father)      references breed.reg_animal(id),
    constraint fk_id_animal_child       foreign key (id_animal_child)       references breed.reg_animal(id)
)
inherits (base.base_tab_part)
;
--табличная часть «группа животных» документа «рождение/отел»
create table if not exists breed.tp_animal_calving_animal_group
(
    id                        bigserial primary key,
    id_animal_calving         bigint not null,
    id_animal_mother_group    bigint not null,
    id_animal_father_group    bigint not null,
    id_animal_child           bigint not null,
    list_values_mother_group  jsonb,   --значения параметров события животное 1 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    list_values_father_group  jsonb,   --значения параметров события животное 1 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    list_values_child         jsonb,   --значения параметров события животное 1 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    date_birth                timestamp without time zone default current_timestamp,
    constraint fk_id_animal_calving         foreign key (id_animal_calving)         references breed.doc_animal_calving (id),
    constraint fk_id_animal_mother_group    foreign key (id_animal_mother_group)    references breed.reg_animal_group(id),
    constraint fk_id_animal_father_group    foreign key (id_animal_father_group)    references breed.reg_animal_group(id),
    constraint fk_id_animal_child           foreign key (id_animal_child)           references breed.reg_animal(id)
)
inherits (base.base_tab_part)
;
------------------------документ «рождение/отел»----------------------------

----------------------+документ «отбивка»+----------------------------
--документ «отбивка»
--при записи документа осуществляется дополнительная запись в reg_animal_state – регистр «состояние животного».
--при записи документа осуществляется дополнительная запись в reg_animal_param – регистр «параметры животного».
--при записи документа осуществляется дополнительная запись в reg_animal_param_detail – регистр «детальные параметры животного».
create table if not exists breed.doc_animal_beating
(
    id                      bigserial primary key,
    id_organization         bigint not null,
    id_type_animal_event    bigint not null,
    multiplicity            integer, --0 – животное заполняется tp_animal_event_animal
                                     --1 – группа животных  заполняется tp_animal_event_animal_group
    constraint fk_id_organization       foreign key (id_organization)       references dict.cls_organization (id),
    constraint fk_id_type_animal_event  foreign key (id_type_animal_event)  references breed.cls_type_animal_event (id)
)
inherits (base.base_document)
;
--табличная часть «животное» документа «отбивка»
create table if not exists breed.tp_animal_beating_animal
(
    id                  bigserial primary key,
    id_animal_beating   bigint not null,
    id_animal_mother    bigint not null,
    id_animal_child     bigint not null,
    list_values_mother  jsonb,   --значения параметров события животное 1 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    list_values_child   jsonb,   --значения параметров события животное 1 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    date_beating        timestamp without time zone default current_timestamp,
    constraint fk_id_animal_beating     foreign key (id_animal_beating)     references breed.doc_animal_beating (id),
    constraint fk_id_animal_mother      foreign key (id_animal_mother)      references breed.reg_animal(id),
    constraint fk_id_animal_child       foreign key (id_animal_child)       references breed.reg_animal(id)
)
inherits (base.base_tab_part)
;
--табличная часть «группа животных» документа «отбивка»
create table if not exists breed.tp_animal_beating_animal_group
(
    id                          bigserial primary key,
    id_animal_beating           bigint not null,
    id_animal_mother_group      bigint not null,
    id_animal_child             bigint not null,
    list_values_mother_group    jsonb,   --значения параметров события животное 1 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    list_values_child           jsonb,   --значения параметров события животное 1 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    date_beating                timestamp without time zone default current_timestamp,
    constraint fk_id_animal_beating         foreign key (id_animal_beating)         references breed.doc_animal_beating (id),
    constraint fk_id_animal_mother_group    foreign key (id_animal_mother_group)    references breed.reg_animal_group(id),
    constraint fk_id_animal_child           foreign key (id_animal_child)           references breed.reg_animal(id)
)
inherits (base.base_tab_part)
;
--табличная часть «группа животных отбивка группы» документа «отбивка»
create table if not exists breed.tp_animal_beating_animal_group
(
    id                          bigserial primary key,
    id_animal_beating           bigint not null,
    id_animal_mother_group      bigint not null,
    id_animal_child_group       bigint not null,
    list_values_mother_group    jsonb,   --значения параметров события животное 1 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    list_values_child           jsonb,   --значения параметров события животное 1 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    date_beating                timestamp without time zone default current_timestamp,
    constraint fk_id_animal_beating         foreign key (id_animal_beating)         references breed.doc_animal_beating (id),
    constraint fk_id_animal_mother_group    foreign key (id_animal_mother_group)    references breed.reg_animal_group(id),
    constraint fk_id_animal_child_group     foreign key (id_animal_child_group)     references breed.reg_animal_group(id)
)
inherits (base.base_tab_part)
;
------------------------документ «отбивка»----------------------------

----------------------+документ «выбытие»+----------------------------
--документ «выбытие»
--при записи документа осуществляется дополнительная запись в reg_animal_state – регистр «состояние животного».
-- при записи документа осуществляется дополнительная запись в reg_animal_param – регистр «параметры животного».
-- при записи документа осуществляется дополнительная запись в reg_animal_param_detail – регистр «детальные параметры животного».
-- при записи документа осуществляется дополнительная запись в reg_animal_local – регистр «локализация животного». последняя запись должна быть закрыта.
-- при записи документа осуществляется дополнительная запись в reg_animal – регистр «животные». запись должна быть закрыта
create table if not exists breed.doc_animal_retirement
(
    id                      bigserial primary key,
    id_organization         bigint not null,
    id_type_animal_event    bigint not null,
    multiplicity            integer, --0 – животное заполняется tp_animal_event_animal
                                     --1 – группа животных  заполняется tp_animal_event_animal_group
    constraint fk_id_organization       foreign key (id_organization)       references dict.cls_organization (id),
    constraint fk_id_type_animal_event  foreign key (id_type_animal_event)  references breed.cls_type_animal_event (id)
)
inherits (base.base_document)
;
--табличная часть «животное» документа «выбытие»
create table if not exists breed.tp_animal_retirement_animal
(
    id                          bigserial primary key,
    id_animal_retirement        bigint not null,
    id_animal                   bigint not null,
    id_animal_retirement_cause   bigint not null,
    list_values                 jsonb,   --значения параметров события животное 1 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    constraint fk_id_animal_retirement      foreign key (id_animal_retirement)      references breed.doc_animal_retirement (id),
    constraint fk_id_animal                 foreign key (id_animal)                 references breed.reg_animal(id),
    constraint fk_id_animal_retirement_cause foreign key (id_animal_retirement_cause) references breed.cls_animal_retirement_cause(id)
)
inherits (base.base_tab_part)
;
--табличная часть «группа животных» документа «выбытие»
create table if not exists breed.tp_animal_retirement_animal_group
(
    id                          bigserial primary key,
    id_animal_retirement        bigint not null,
    id_animal_group             bigint not null,
    id_animal_retirement_cause   bigint not null,
    list_values                 jsonb,   --значения параметров события животное 1 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    constraint fk_id_animal_retirement      foreign key (id_animal_retirement)      references breed.doc_animal_retirement (id),
    constraint fk_id_animal_group           foreign key (id_animal_group)           references breed.reg_animal_group(id),
    constraint fk_id_animal_retirement_cause foreign key (id_animal_retirement_cause) references breed.cls_animal_retirement_cause(id)
)
inherits (base.base_tab_part)
;
------------------------документ «выбытие»----------------------------

----------------------+документ «осеменение/вольная случка»+----------------------------
--документ «осеменение/вольная случка»
--при записи документа осуществляется дополнительная запись в reg_animal_state – регистр «состояние животного».
create table if not exists breed.doc_animal_copulation
(
    id                      bigserial primary key,
    id_organization         bigint not null,
    id_type_animal_event    bigint not null,
    multiplicity            integer, --0 – животное заполняется tp_animal_event_animal
                                     --1 – группа животных  заполняется tp_animal_event_animal_group
    insemination            integer, --0 – осеменение 1 – вольная случка
    constraint fk_id_organization       foreign key (id_organization)       references dict.cls_organization (id),
    constraint fk_id_type_animal_event  foreign key (id_type_animal_event)  references breed.cls_type_animal_event (id)
)
inherits (base.base_document)
;
--табличная часть «животное» документа «осеменение/вольная случка»
create table if not exists breed.tp_animal_copulation_animal
(
    id                      bigserial primary key,
    id_animal_copulation    bigint not null,
    id_animal_female        bigint not null,
    id_animal_male          bigint not null,
    list_values_female      jsonb,   --значения параметров события животное 1 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    list_values_male        jsonb,   --значения параметров события животное 1 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    constraint fk_id_animal_copulation  foreign key (id_animal_copulation)  references breed.doc_animal_copulation (id),
    constraint fk_id_animal_female      foreign key (id_animal_female)      references breed.reg_animal(id),
    constraint fk_id_animal_male        foreign key (id_animal_male)        references breed.reg_animal(id)
)
inherits (base.base_tab_part)
;
--табличная часть «группа животных» документа «осеменение/вольная случка»
create table if not exists breed.tp_animal_copulation_animal_group
(
    id                            bigserial primary key,
    id_animal_copulation          bigint not null,
    id_animal_female_group        bigint not null,
    id_animal_male_group          bigint not null,
    list_values_female_group      jsonb,   --значения параметров события животное 1 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    list_values_male_group        jsonb,   --значения параметров события животное 1 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    constraint fk_id_animal_copulation      foreign key (id_animal_copulation)      references breed.doc_animal_copulation (id),
    constraint fk_id_animal_female_group    foreign key (id_animal_female_group)    references breed.reg_animal_group(id),
    constraint fk_id_animal_male_group      foreign key (id_animal_male_group)      references breed.reg_animal_group(id)
)
inherits (base.base_tab_part)
;
--табличная часть «группа животных женского пола» документа «осеменение/вольная случка»
--если один бык на группу коров, например.
create table if not exists breed.tp_animal_copulation_animal_group_female
(
    id                            bigserial primary key,
    id_animal_copulation          bigint not null,
    id_animal_female_group        bigint not null,
    id_animal_male                bigint not null,
    list_values_female_group      jsonb,   --значения параметров события животное 1 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    list_values_male              jsonb,   --значения параметров события животное 1 заполняется по структуре list_params_tab_part_animal из cls_type_animal_event
    constraint fk_id_animal_copulation      foreign key (id_animal_copulation)      references breed.doc_animal_copulation (id),
    constraint fk_id_animal_female_group    foreign key (id_animal_female_group)    references breed.reg_animal_group(id),
    constraint fk_id_animal_male            foreign key (id_animal_male)            references breed.reg_animal_group(id)
)
inherits (base.base_tab_part)
;
------------------------документ «осеменение/вольная случка»----------------------------