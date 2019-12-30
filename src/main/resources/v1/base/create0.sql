--create database "digagri"
--  with owner = postgres
--       encoding = 'utf8'
--       tablespace = pg_default
--       lc_collate = 'russian_russia.1251'
--       lc_ctype = 'russian_russia.1251'
--       connection limit = -1
--;
comment on database "digagri"
  is 'база данных - цифровизация сельского хярзйства'
;
create schema if not exists base
  --authorization postgres;
;
--базовая таблица
create table if not exists base.base_table(
   id_user_creator bigint not null --идентификатор пользователя из cls_user, если документ создан системой, то вводится значение по умолчанию
)
;
--базовый справочник
create table if not exists base.base_classifier(
   name         text,
   date_create  timestamp without time zone default current_timestamp, --системная временная создания (date_create, по умолчанию текущая дата и время);
   is_deleted   boolean default false,
   number       character varying(15) not null
)
inherits (base.base_table)
;
--базовый справочник с кодом
create table if not exists base.base_coded_classifier(
   code character varying(64) not null
)
inherits (base.base_classifier)
;
----базовый регистр
create table if not exists base.base_register(
   date_create  timestamp without time zone default current_timestamp, --системная временная создания (date_create, по умолчанию текущая дата и время);
   date_begin   timestamp without time zone default current_timestamp, --временная метка начала действия записи (date_begin, по умолчанию текущая дата и время);
   date_end     timestamp without time zone default 'infinity' --временная метка завершения действия записи (date_end, по умолчанию максимальная дата, например для postgresql infinity
)
inherits (base.base_table)
;
-- базовый документ
create table if not exists base.base_document(
   date_create  timestamp without time zone default current_timestamp, --системная временная создания (date_create, по умолчанию текущая дата и время);
   date_reg     timestamp without time zone default current_timestamp, --временная метка создания (date_reg, по умолчанию текущая дата и время, может изменяться пользователем);
   is_deleted   boolean default false,
   number       character varying(15) not null
)
inherits (base.base_table)
;
-- базовая табличная часть
create table if not exists base.base_tab_part(
   is_deleted   boolean default false,
   number       bigint  not null --табличные части по умолчанию должны иметь поле номер: number integer.
                              --поле должно автоматически заполняться порядковым номером в соответствии с порядком добавления в табличную часть
                              --элемента в пределах таблицы, которой подчинена табличная часть
)
inherits (base.base_table)
;
-- ввести везде пользователей создателей