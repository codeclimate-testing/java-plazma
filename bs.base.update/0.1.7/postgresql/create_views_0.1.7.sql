
/*==============================================================*/
/* PostgreSQL                                                   */
/* http://www.postgresql.org                                    */
/*==============================================================*/

CREATE VIEW v_organization (
  id,
  organization_name,
  organization_code,
  organization_swift_code
) AS
SELECT
  o.id,
  p.name,
  p.code,
  p.swift_code
 FROM organization o 
 INNER JOIN partner p ON p.id = o.id;

CREATE VIEW v_system_info (
 period_id,
 organization_id,
 currency_id,
 unit_id,
 period_name,
 period_start_date,
 period_end_date,
 organization_name,
 currency_name,
 unit_name
) AS
SELECT 
 i.period_id,
 i.organization_id,
 i.currency_id,
 i.unit_id,
 p.name,
 p.start_date,
 p.end_date,
 o.organization_name,
 c.name,
 u.name
FROM system_info i
 INNER JOIN period p ON p.id = i.period_id
 INNER JOIN v_organization o ON o.id = i.organization_id
 INNER JOIN currency c ON c.id = i.currency_id
 INNER JOIN unit u ON u.id = i.unit_id;

CREATE VIEW v_system_user (
 id,
 usrname,
 passwd,
 owner_id,
 entity_id,
 name,
 organization_id,
 registration_date,
 organization_name
) AS
SELECT u.id, u.usrname, u.passwd, u.owner_id, u.entity_id,
 p.last_name || ' ' || p.first_name || ' ' || p.middle_name as name,
 o.id as organization_id, u.registration_date, o.organization_name
 FROM system_user u
 INNER JOIN system_entity e ON e.id = u.entity_id
 INNER JOIN employee ee ON ee.id = u.owner_id
 INNER JOIN person p ON p.id = ee.person_id
 INNER JOIN v_organization o ON o.id = ee.organization_id
 WHERE e.code = 'EMPLOYEE';



CREATE VIEW V_SYSTEM_PERMISSION (
 ID,
 SECURE_ENTITY_ID,
 SYSTEM_PERMISSION_ID,
 ENTITY_ID,
 CODE,
 NAME,
 OBJECT_TYPE,
 ROLE_ID,
 IS_READ,
 IS_WRITE,
 IS_EXEC
) AS
SELECT
 o.id as id,
 p.secure_entity_id,
 p.id as system_permission_id,
 o.entity_id,
 o.code,
 o.name,
 o.object_type,
 p.role_id,
 p.is_read,
 p.is_write,
 p.is_exec
FROM secure_object o
LEFT JOIN system_permission p ON o.id = p.secure_entity_id;


CREATE VIEW V_EMPLOYEE (
    id,
    organization_id,
    person_id,
    first_name,
    last_name,
    middle_name,
    name
) AS
SELECT 
 e.id,
 e.organization_id,
 e.person_id,
 p.first_name,
 p.last_name,
 p.middle_name,
 p.name
 FROM employee e
 INNER JOIN person p ON p.id = e.person_id;
 


CREATE VIEW v_warehouse (
  id,
  owner_id,
  entity_id,
  name
) AS
SELECT b.id, b.owner_id, b.entity_id, b.name
 FROM businessable b
 INNER JOIN warehouse s ON s.id = b.owner_id;

 




CREATE VIEW v_warehouse_union (
  id, 
  owner_id, 
  entity_id, 
  entity_code, 
  entity_name, 
  organization_id, 
  parent_id, 
  name
) AS 
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, o.organization_id, o.parent_id, o.name
 FROM businessable b
 INNER JOIN store o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'STORE'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, o.organization_id, o.parent_id, o.name
 FROM businessable b
 INNER JOIN drugstore o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'DRUGSTORE'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, o.organization_id, o.parent_id, o.name
 FROM businessable b
 INNER JOIN shop o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'SHOP'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, o.organization_id, o.parent_id, o.name
 FROM businessable b
 INNER JOIN factory o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'FACTORY'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, o.organization_id, o.parent_id, o.name
 FROM businessable b
 INNER JOIN works o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'WORKS';



CREATE VIEW v_responsible (
 id,
 organization_id,
 employee_id,
 warehouse_id,
 person_id,
 responsible_name,
 warehouse_name
) AS
SELECT 
 re.id, 
 re.organization_id, 
 re.employee_id,
 re.warehouse_id,
 p.id as person_id,
 p.name,
 s.name
 FROM responsible re 
 INNER JOIN employee e ON e.id = re.employee_id
 INNER JOIN person p ON p.id = e.person_id
 LEFT JOIN v_warehouse s ON s.id = re.warehouse_id;


CREATE VIEW v_warehouse_move (
  id,
  document_id,
  warehouse_id,
  warehouse_name,
  move_type
) AS
SELECT 
  m.id,
  m.owner_id as document_id,
  m.warehouse_id,
  s.name as warehouse_name,
  m.move_type
 FROM warehouse_move m
 INNER JOIN v_warehouse s ON s.id = m.warehouse_id;

CREATE VIEW v_product (
 id,
 product_code,
 product_name,
 product_class_id,
 product_class_code,
 product_group_id,
 bar_code,
 organization_id,
 currency_id,
 currency_rate,
 ledger_account_id,
 manufacturer_id,
 supplier_id,
 start_date,
 end_date,
 unit_id,
 price,
 wholesale_price,
 small_wholesale_price,
 retail_price,
 currency_price,
 currency_small_wholesale_price,
 currency_wholesale_price,
 currency_retail_price,
 tax_percent,
 addprice_percent,
 min_quantity,
 availability_quantity,
 reserve_quantity,
 await_quantity,
 warranty_period_unit_id,
 warranty_period,
 dimension_unit_id,
 dim_length,
 dim_width,
 dim_height,
 weight_unit_id,
 weight,
 product_image,
 note

) AS
SELECT 
 p.id,    
 p.code,
 c.name,
 p.product_class_id,
 c.code,
 p.product_group_id,
 p.bar_code,
 p.organization_id,
 p.currency_id,
 p.currency_rate,
 p.ledger_account_id,
 p.manufacturer_id,
 p.supplier_id,
 p.start_date,
 p.end_date,
 p.unit_id,
 p.price,
 p.wholesale_price,
 p.small_wholesale_price,
 p.retail_price,
 p.currency_price,
 p.currency_small_wholesale_price,
 p.currency_wholesale_price,
 p.currency_retail_price,
 p.tax_percent,
 p.addprice_percent,
 p.min_quantity,
 p.availability_quantity,
 p.reserve_quantity,
 p.await_quantity,
 p.warranty_period_unit_id,
 p.warranty_period,
 p.dimension_unit_id,
 p.dim_length,
 p.dim_width,
 p.dim_height,
 p.weight_unit_id,
 p.weight,
 p.product_image,
 p.note

FROM product p
INNER JOIN product_class c ON c.id = p.product_class_id;



CREATE VIEW v_product_move (
  id,
  document_id,
  product_id,
  product_code,
  product_name,
  unit_id,
  item_unit_id,
  unit_rate,
  unit_name,
  product_price,
  price,
  price_with_tax,
  tax_price,
  quantity,
  amount,
  amount_with_tax,
  tax_amount,
  item_price,
  item_account_price,
  item_amount,
  account_quantity,
  account_price,
  account_price_with_tax
) AS
SELECT 
  i.id,
  i.owner_id,
  i.product_id,
  p.product_code,
  p.product_name,
  p.unit_id,
  i.unit_id,
  i.unit_rate,
  u.name,
  p.price,
  i.price,
  i.price_with_tax,
  i.tax_price,
  i.quantity,
  i.amount,
  i.amount_with_tax,
  i.tax_amount,
  i.price_with_tax,
  i.account_price_with_tax,
  i.amount_with_tax,
  i.account_quantity,
  i.account_price,
  i.account_price_with_tax
 FROM product_move i
 INNER JOIN v_product p ON p.id = i.product_id
 INNER JOIN unit u ON u.id = i.unit_id;
CREATE VIEW v_goods (
 id,
 product_code,
 product_name,
 product_class_id,
 product_group_id,
 currency_id,
 organization_id,
 unit_id,
 price,
 start_date,
 end_date,
 tax_percent,
 addprice_percent,
 min_quantity,
 currency_rate,
 country_id,
 goods_type_id,
 goods_type_name,
 product_class_code
) AS
SELECT 
 p.id,    
 p.product_code,
 p.product_name,
 p.product_class_id,
 p.product_group_id,
 p.currency_id,
 p.organization_id,
 p.unit_id,
 p.price,
 p.start_date,
 p.end_date,
 p.tax_percent,
 p.addprice_percent,
 p.min_quantity,
 p.currency_rate,
 g.country_id,
 g.goods_type_id,
 t.name,
 p.product_class_code
 FROM goods g
 INNER JOIN v_product p ON p.id = g.id
 INNER JOIN goods_type t ON t.id = g.goods_type_id;






CREATE VIEW v_asset (
 id,	
 product_code,
 product_name,
 product_class_id,
 product_group_id,
 currency_id,
 organization_id,
 unit_id,
 price,
 start_date,
 end_date,
 tax_percent,
 addprice_percent,
 min_quantity,
 currency_rate
) AS
SELECT 
 p.id,	
 p.product_code,
 p.product_name,
 p.product_class_id,
 p.product_group_id,
 p.currency_id,
 p.organization_id,
 p.unit_id,
 p.price,
 p.start_date,
 p.end_date,
 p.tax_percent,
 p.addprice_percent,
 p.min_quantity,
 p.currency_rate
 FROM asset a
 INNER JOIN v_product p ON p.id = a.id;


CREATE VIEW v_intangible (
 id,	
 product_code,
 product_name,
 product_class_id,
 product_group_id,
 currency_id,
 organization_id,
 unit_id,
 price,
 start_date,
 end_date,
 tax_percent,
 addprice_percent,
 min_quantity,
 currency_rate
) AS
SELECT 
 p.id,	
 p.product_code,
 p.product_name,
 p.product_class_id,
 p.product_group_id,
 p.currency_id,
 p.organization_id,
 p.unit_id,
 p.price,
 p.start_date,
 p.end_date,
 p.tax_percent,
 p.addprice_percent,
 p.min_quantity,
 p.currency_rate
 FROM intangible i
 INNER JOIN v_product p ON p.id = i.id;


/*                                                       */
/*   PostgreSQL implementation                           */
/*                                                       */
/*   Use functions:                                      */
/*                                                       */
/*   TO_NUMBER(TO_CHAR(document_date, 'YYYY'), '9999')   */
/*   TO_NUMBER(TO_CHAR(document_date, 'MM'), '99' )      */
/*                                                       */


CREATE VIEW v_document (
  id,
  organization_id,
  organization_name,
  organization_code,
  organization_swift_code,
  document_type_id,
  document_type_code,
  document_type_name,
  period_id,
  document_code,
  document_date,
  document_year,
  document_month,
  partner_id,
  user_id,
  contract_id,
  reason_document_id,
  reason,
  note,
  usrname
) AS
SELECT
  d.id,
  d.organization_id,
  o.organization_name,
  o.organization_code,
  o.organization_swift_code,
  d.document_type_id,
  e.code as document_type_code,
  e.name as document_type_name,
  d.period_id,
  d.code,
  d.document_date,
  TO_NUMBER(TO_CHAR(d.document_date,'YYYY'), '9999'),
  TO_NUMBER(TO_CHAR(d.document_date,'MM'), '99'),
  d.partner_id,
  d.user_id,
  d.contract_id,
  d.reason_document_id,
  d.reason,
  d.note,
  u.usrname
 FROM document d
 INNER JOIN v_organization o ON o.id = d.organization_id
 INNER JOIN document_type dt ON dt.id = d.document_type_id
 INNER JOIN system_entity e ON e.id = dt.entity_id
 LEFT JOIN system_user u ON u.id = d.user_id;




CREATE VIEW v_finance_document (
  id, 
  organization_id,
  organization_name,
  organization_code,
  organization_swift_code,
  document_type_id, 
  document_type_code,
  document_type_name,
  period_id,
  document_code, 
  document_date,
  document_year,
  document_month,
  partner_id,
  user_id,
  contract_id,
  reason_document_id,
  reason,
  note,
  usrname,
  currency_id, 
  currency_rate,
  currency_rate_date,
  currency_code,
  currency_char_code,
  currency_name,
  amount,
  amount_with_tax,
  tax_amount,
  currency_amount,
  currency_amount_with_tax,
  currency_tax_amount,
  total,
  total_with_tax,
  tax_total,
  currency_total,
  currency_total_with_tax,
  currency_tax_total,
  document_amount,
  document_total,
  currency_document_amount,
  currency_document_total,
  is_operation,
  is_account_items
) AS
SELECT 
  d.id, 
  d.organization_id,
  d.organization_name,
  d.organization_code,
  d.organization_swift_code,
  d.document_type_id, 
  d.document_type_code,
  d.document_type_name,
  d.period_id,
  d.document_code, 
  d.document_date,
  d.document_year,
  d.document_month,
  d.partner_id,  
  d.user_id,
  d.contract_id,
  d.reason_document_id,
  d.reason,
  d.note,
  d.usrname,
  fd.currency_id, 
  fd.currency_rate,
  fd.currency_rate_date,
  cr.code as currency_code,
  cr.char_code as currency_char_code,
  cr.name as currency_name,
  fd.amount,
  fd.amount_with_tax,
  fd.tax_amount,
  fd.currency_amount,
  fd.currency_amount_with_tax,
  fd.currency_tax_amount,
  fd.total,
  fd.total_with_tax,
  fd.tax_total,
  fd.currency_total,
  fd.currency_total_with_tax,
  fd.currency_tax_total,
  fd.amount_with_tax as document_amount,
  fd.total_with_tax as document_total,
  fd.currency_amount_with_tax as currency_document_amount,
  fd.currency_total_with_tax as currency_document_total,
  fd.is_operation,
  fd.is_account_items
 FROM finance_document fd
 INNER JOIN v_document d ON fd.id = d.id
 LEFT JOIN currency cr ON cr.id = fd.currency_id;



CREATE VIEW V_ENTRY_ITEM (
    ID,
    OWNER_ID,
    DEBIT_LEDGER_ACCOUNT_ID,
    DEBIT_OBJECT_ID,
    DEBIT_OBJECT_NAME,
    CREDIT_LEDGER_ACCOUNT_ID,
    CREDIT_OBJECT_ID,
    CREDIT_OBJECT_NAME,
    AMOUNT,
    CONTENT)
AS
SELECT 
    I.ID,
    I.OWNER_ID,
    I.DEBIT_LEDGER_ACCOUNT_ID,
    I.DEBIT_OBJECT_ID,
    D.NAME AS DEBIT_OBJECT_NAME,
    I.CREDIT_LEDGER_ACCOUNT_ID,
    I.CREDIT_OBJECT_ID,
    C.NAME AS CREDIT_OBJECT_NAME,
    I.AMOUNT,
    I.CONTENT
FROM ENTRY_ITEM I
 LEFT JOIN BUSINESSABLE D ON D.ID = I.DEBIT_OBJECT_ID
 LEFT JOIN BUSINESSABLE C ON C.ID = I.CREDIT_OBJECT_ID;


CREATE VIEW V_CONTRACTOR (
 ID,
 OWNER_ID,
 ENTITY_ID,
 NAME
) AS
SELECT b.id, b.owner_id, b.entity_id, b.name
 FROM businessable b WHERE b.entity_id = 'PARTNER' or b.entity_id = 'EMPLOYEE';

CREATE VIEW V_CONTRACTOR_UNION (
    ID,
    OWNER_ID,
    ENTITY_ID,
    ENTITY_CODE,
    ENTITY_NAME,
    ORGANIZATION_ID,
    NAME)
AS
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, -1, CAST(o.name as VARCHAR(100))
 FROM businessable b
 INNER JOIN partner o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'PARTNER'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, o.organization_id, CAST(p.name as VARCHAR(100))
 FROM businessable b
 INNER JOIN employee o ON o.id = b.owner_id
 INNER JOIN person p ON p.id = o.person_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'EMPLOYEE';
CREATE VIEW v_city (
  id,
  country_id,
  locality_type_id,
  region_id,
  district_id,
  name
) AS
SELECT
  c.id,
  l.country_id,
  l.locality_type_id,
  l.region_id,
  l.district_id,
  l.name
 FROM city c
 INNER JOIN locality l ON l.id = c.id;

CREATE VIEW v_address_city (
  id,
  contactable_id,
  country_id,
  locality_type_id,
  region_id,
  district_id,
  name
) AS
SELECT 
  a.id,
  a.contactable_id,
  c.country_id,
  c.locality_type_id,
  c.region_id,
  c.district_id,
  c.name
FROM address a
INNER JOIN v_city c ON c.id = a.city_id;

CREATE VIEW v_address (
 id,
 address_type_id,
 contactable_id,
 city_id,
 city_name,
 locality_id,
 locality_type_name,
 locality_name,
 street_type_id,
 address_string,
 full_address_string,
 zip_code,
 street,
 house_num,
 case_num,
 appart_num,
 note
) AS
SELECT 
 a.id,
 a.address_type_id,
 a.contactable_id,
 a.city_id,
 c.name,
 a.locality_id,
 lt.name,
 l.name,
 a.street_type_id,
 a.address_string,
 a.full_address_string,
 a.zip_code,
 a.street,
 a.house_num,
 a.case_num,
 a.appart_num,
 a.note
 FROM address a
 LEFT JOIN v_city c ON c.id = a.city_id
 LEFT JOIN locality l ON l.id = a.locality_id
 LEFT JOIN locality_type lt ON lt.id = l.locality_type_id;

CREATE VIEW v_contactable_address (
 contactable_id,
 address_id,
 address_type_id,
 city_id,
 city_name,
 locality_id,
 locality_type_name,
 locality_name,
 street_type_id,
 address_string,
 full_address_string,
 zip_code,
 street,
 house_num,
 case_num,
 appart_num,
 note,
 owner_id,
 entity_id
) AS
SELECT 
 c.id as contactable_id,
 a.id as address_id,
 a.address_type_id,
 a.city_id,
 a.city_name,
 a.locality_id,
 a.locality_type_name,
 a.locality_name,
 a.street_type_id,
 a.address_string,
 a.full_address_string,
 a.zip_code,
 a.street,
 a.house_num,
 a.case_num,
 a.appart_num,
 a.note,
 c.owner_id,
 c.entity_id
 FROM contactable c 
 INNER JOIN v_address a ON a.contactable_id = c.id;

CREATE VIEW v_def_contactable_address (
 contactable_id,
 address_id,
 address_type_id,
 city_id,
 city_name,
 locality_id,
 locality_type_name,
 locality_name,
 street_type_id,
 address_string,
 full_address_string,
 zip_code,
 street,
 house_num,
 case_num,
 appart_num,
 note,
 owner_id,
 entity_id
) AS
SELECT 
 c.id as contactable_id,
 a.id as address_id,
 a.address_type_id,
 a.city_id,
 a.city_name,
 a.locality_id,
 a.locality_type_name,
 a.locality_name,
 a.street_type_id,
 a.address_string,
 a.full_address_string,
 a.zip_code,
 a.street,
 a.house_num,
 a.case_num,
 a.appart_num,
 a.note,
 c.owner_id,
 c.entity_id
 FROM contactable c 
 LEFT JOIN v_address a ON a.id = c.address_id;

CREATE VIEW v_def_partner_address (
 partner_id,
 contactable_id,
 address_id,
 address_type_id,
 city_id,
 city_name,
 locality_id,
 locality_type_name,
 locality_name,
 street_type_id,
 address_string,
 full_address_string,
 zip_code,
 street,
 house_num,
 case_num,
 appart_num,
 note,
 entity_id
) AS
SELECT 
 p.id,
 a.contactable_id,
 a.address_id,
 a.address_type_id,
 a.city_id,
 a.city_name,
 a.locality_id,
 a.locality_type_name,
 a.locality_name,
 a.street_type_id,
 a.address_string,
 a.full_address_string,
 a.zip_code,
 a.street,
 a.house_num,
 a.case_num,
 a.appart_num,
 a.note,
 a.entity_id
 FROM  partner p
 LEFT JOIN v_def_contactable_address a ON a.owner_id = p.id;

CREATE VIEW v_phone (
 id,
 phone_type_id,
 contactable_id,
 phone_code,
 phone_number,
 phone_string,
 note
) AS
SELECT 
 p.id,
 p.phone_type_id,
 p.contactable_id,
 p.phone_code,
 p.phone_number,
 p.phone_string,
 p.note
 FROM phone p;

CREATE VIEW v_contactable_phone (
 contactable_id,
 phone_id,
 phone_type_id,
 phone_code,
 phone_number,
 phone_string,
 note,
 owner_id,
 entity_id
) AS
SELECT 
 c.id as contactable_id,
 p.id as phone_id,
 p.phone_type_id,
 p.phone_code,
 p.phone_number,
 p.phone_string,
 p.note,
 c.owner_id,
 c.entity_id
 FROM contactable c 
 INNER JOIN v_phone p ON p.contactable_id = c.id;

CREATE VIEW v_def_contactable_phone (
 contactable_id,
 phone_id,
 phone_type_id,
 phone_code,
 phone_number,
 phone_string,
 note,
 owner_id,
 entity_id
) AS
SELECT 
 c.id as contactable_id,
 p.id as phone_id,
 p.phone_type_id,
 p.phone_code,
 p.phone_number,
 p.phone_string,
 p.note,
 c.owner_id,
 c.entity_id
 FROM contactable c 
 LEFT JOIN v_phone p ON p.id = c.phone_id;

CREATE VIEW v_def_partner_phone (
 partner_id,
 contactable_id,
 phone_id,
 phone_type_id,
 phone_code,
 phone_number,
 phone_string,
 note,
 entity_id
) AS
SELECT 
 p.id,
 ph.contactable_id,
 ph.phone_id,
 ph.phone_type_id,
 ph.phone_code,
 ph.phone_number,
 ph.phone_string,
 ph.note,
 ph.entity_id
 FROM  partner p
 LEFT JOIN v_def_contactable_phone ph ON ph.owner_id = p.id;

CREATE VIEW v_bank (
  id,
  code,
  name,
  full_name,
  tax_code,
  year_create,
  work_time,
  note,
  is_tax,
  swift_code,
  tax_doc_code,
  form_property_id,
  partner_group_id,
  bank_swift_code,
  correspondent_account,
  stopped_percent,
  address_id,
  address_type_id,
  city_id,
  city_name,
  locality_id,
  street_type_id,
  address_string,
  zip_code,
  street,
  house_num,
  case_num,
  appart_num,
  address_note,
  phone_id,
  phone_type_id,
  phone_code,
  phone_number,
  phone_string,
  phone_note
) AS
SELECT 
  b.id,
  p.code,
  p.name,
  p.full_name,
  p.tax_code,
  p.year_create,
  p.work_time,
  p.note,
  p.is_tax,
  p.swift_code,
  p.tax_doc_code,
  p.form_property_id,
  p.partner_group_id,
  b.bank_swift_code,
  b.correspondent_account,
  b.stopped_percent,
  da.address_id,
  da.address_type_id,
  da.city_id,
  c.name as city_name,
  da.locality_id,
  da.street_type_id,
  da.address_string,
  da.zip_code,
  da.street,
  da.house_num,
  da.case_num,
  da.appart_num,
  da.note as address_note,
  dp.phone_id,
  dp.phone_type_id,
  dp.phone_code,
  dp.phone_number,
  dp.phone_string,
  dp.note as phone_note
 FROM bank b
 INNER JOIN partner p ON p.id = b.id
 INNER JOIN v_def_partner_address da ON da.partner_id = p.id
 INNER JOIN v_def_partner_phone dp ON dp.partner_id = p.id
 LEFT JOIN v_city c ON c.id = da.city_id;

CREATE VIEW v_partner_bank_account (
  id,
  bank_id,
  partner_id,
  name,
  account_no
) AS
SELECT 
  ba.id,
  ba.bank_id,
  ba.partner_id,
  ba.name,
  ba.account_no
FROM bank_account ba;

CREATE VIEW V_PAYMENT_INCOME (
    ID,
    ORGANIZATION_ID,
    ORGANIZATION_NAME,
    ORGANIZATION_CODE,
    ORGANIZATION_SWIFT_CODE,
    DOCUMENT_TYPE_ID,
    DOCUMENT_TYPE_CODE,
    DOCUMENT_TYPE_NAME,
    PERIOD_ID,
    DOCUMENT_CODE,
    DOCUMENT_DATE,
    USER_ID,
    USRNAME,
    CONTRACT_ID,
    REASON_DOCUMENT_ID,
    REASON,
    NOTE,
    CURRENCY_ID,
    AMOUNT_WITH_TAX,
    TAX_AMOUNT,
    AMOUNT,
    CURRENCY_AMOUNT_WITH_TAX,
    CURRENCY_TAX_AMOUNT,
    CURRENCY_AMOUNT,
    TOTAL,
    TOTAL_WITH_TAX,
    TAX_TOTAL,
    CURRENCY_TOTAL,
    CURRENCY_TOTAL_WITH_TAX,
    CURRENCY_TAX_TOTAL,
    DOCUMENT_AMOUNT,
    DOCUMENT_TOTAL,
    CURRENCY_DOCUMENT_AMOUNT,
    CURRENCY_DOCUMENT_TOTAL,
    PARTNER_BANK_ACCOUNT_ID,
    PARTNER_BANK_ACCOUNT_NO,
    PARTNER_BANK_SWIFT_CODE,
    PARTNER_BANK_NAME,
    PARTNER_BANK_CITY_NAME,
    ORGANIZATION_BANK_ACCOUNT_ID,
    ORGANIZATION_BANK_ACCOUNT_NO,
    ORGANIZATION_BANK_SWIFT_CODE,
    ORGANIZATION_BANK_NAME,
    ORGANIZATION_BANK_CITY_NAME,
    PARTNER_ID,
    PARTNER_NAME,
    PARTNER_CODE,
    PARTNER_SWIFT_CODE,
    PAYMENT_MISSING
) AS
SELECT
  pay.id,
  fd.organization_id,
  fd.organization_name,
  fd.organization_code,
  fd.organization_swift_code,
  fd.document_type_id, 
  fd.document_type_code,
  fd.document_type_name,
  fd.period_id,
  fd.document_code, 
  fd.document_date,
  fd.user_id,
  fd.usrname,
  fd.contract_id,
  fd.reason_document_id,
  fd.reason,
  fd.note,
  fd.currency_id,
  fd.amount_with_tax,
  fd.tax_amount, 
  fd.amount,
  fd.currency_amount_with_tax,
  fd.currency_tax_amount,
  fd.currency_amount,
  fd.total,
  fd.total_with_tax,
  fd.tax_total,
  fd.currency_total,
  fd.currency_total_with_tax,
  fd.currency_tax_total,
  fd.document_amount,
  fd.document_total,
  fd.currency_document_amount,
  fd.currency_document_total,
  pay.partner_bank_account_id,
  prt_ba.account_no as partner_bank_account_no,
  prt_bk.bank_swift_code as partner_bank_swift_code,
  prt_bk.name as partner_bank_name,
  prt_bk.city_name as partner_bank_city_name,
  pay.organization_bank_account_id,
  org_ba.account_no as organization_bank_account_no,
  org_bk.bank_swift_code as organization_bank_swift_code,
  org_bk.name as organization_bank_name,
  org_bk.city_name as organization_bank_city_name,
  fd.partner_id,
  prt.name as partner_name,
  prt.code as partner_code,
  prt.swift_code as partner_swift_code,
  pay.payment_missing
 FROM payment_income pay
 INNER JOIN v_finance_document fd ON fd.id = pay.id
 INNER JOIN organization org ON org.id= fd.organization_id
 INNER JOIN bank_account org_ba ON org_ba.id = pay.organization_bank_account_id
 INNER JOIN v_bank org_bk ON org_bk.id = org_ba.bank_id
 INNER JOIN bank_account prt_ba ON prt_ba.id = pay.partner_bank_account_id
 INNER JOIN v_bank prt_bk ON prt_bk.id = prt_ba.bank_id
 INNER JOIN partner prt ON prt.id = fd.partner_id;
 
CREATE VIEW V_PAYMENT_OUTCOME (
    ID,
    ORGANIZATION_ID,
    ORGANIZATION_NAME,
    ORGANIZATION_CODE,
    ORGANIZATION_SWIFT_CODE,
    DOCUMENT_TYPE_ID,
    DOCUMENT_TYPE_CODE,
    DOCUMENT_TYPE_NAME,
    PERIOD_ID,
    DOCUMENT_CODE,
    DOCUMENT_DATE,
    USER_ID,
    USRNAME,
    CONTRACT_ID,
    REASON_DOCUMENT_ID,
    REASON,
    NOTE,
    CURRENCY_ID,
    AMOUNT_WITH_TAX,
    TAX_AMOUNT,
    AMOUNT,
    CURRENCY_AMOUNT_WITH_TAX,
    CURRENCY_TAX_AMOUNT,
    CURRENCY_AMOUNT,
    TOTAL,
    TOTAL_WITH_TAX,
    TAX_TOTAL,
    CURRENCY_TOTAL,
    CURRENCY_TOTAL_WITH_TAX,
    CURRENCY_TAX_TOTAL,
    DOCUMENT_AMOUNT,
    DOCUMENT_TOTAL,
    CURRENCY_DOCUMENT_AMOUNT,
    CURRENCY_DOCUMENT_TOTAL,
    PARTNER_BANK_ACCOUNT_ID,
    PARTNER_BANK_ACCOUNT_NO,
    PARTNER_BANK_SWIFT_CODE,
    PARTNER_BANK_NAME,
    PARTNER_BANK_CITY_NAME,
    ORGANIZATION_BANK_ACCOUNT_ID,
    ORGANIZATION_BANK_ACCOUNT_NO,
    ORGANIZATION_BANK_SWIFT_CODE,
    ORGANIZATION_BANK_NAME,
    ORGANIZATION_BANK_CITY_NAME,
    PARTNER_ID,
    PARTNER_NAME,
    PARTNER_CODE,
    PARTNER_SWIFT_CODE,
    PAYMENT_MISSING
) AS
SELECT
  pay.id,
  fd.organization_id,
  fd.organization_name,
  fd.organization_code,
  fd.organization_swift_code,
  fd.document_type_id, 
  fd.document_type_code,
  fd.document_type_name,
  fd.period_id,
  fd.document_code, 
  fd.document_date,
  fd.user_id,
  fd.usrname,
  fd.contract_id,
  fd.reason_document_id,
  fd.reason,
  fd.note,
  fd.currency_id,
  fd.amount_with_tax,
  fd.tax_amount, 
  fd.amount,
  fd.currency_amount_with_tax,
  fd.currency_tax_amount,
  fd.currency_amount,
  fd.total,
  fd.total_with_tax,
  fd.tax_total,
  fd.currency_total,
  fd.currency_total_with_tax,
  fd.currency_tax_total,
  fd.document_amount,
  fd.document_total,
  fd.currency_document_amount,
  fd.currency_document_total,
  pay.partner_bank_account_id,
  prt_ba.account_no as partner_bank_account_no,
  prt_bk.bank_swift_code as partner_bank_swift_code,
  prt_bk.name as partner_bank_name,
  prt_bk.city_name as partner_bank_city_name,
  pay.organization_bank_account_id,
  org_ba.account_no as organization_bank_account_no,
  org_bk.bank_swift_code as organization_bank_swift_code,
  org_bk.name as organization_bank_name,
  org_bk.city_name as organization_bank_city_name,
  fd.partner_id,
  prt.name as partner_name,
  prt.code as partner_code,
  prt.swift_code as partner_swift_code,
  pay.payment_missing
 FROM payment_outcome pay
 INNER JOIN v_finance_document fd ON fd.id = pay.id
 INNER JOIN organization org ON org.id= fd.organization_id
 INNER JOIN bank_account org_ba ON org_ba.id = pay.organization_bank_account_id
 INNER JOIN v_bank org_bk ON org_bk.id = org_ba.bank_id
 INNER JOIN bank_account prt_ba ON prt_ba.id = pay.partner_bank_account_id
 INNER JOIN v_bank prt_bk ON prt_bk.id = prt_ba.bank_id
 INNER JOIN partner prt ON prt.id = fd.partner_id;
 
 

CREATE VIEW V_PAYMENT (
    ID,
    ORGANIZATION_ID,
    DEBIT_PARTNER_ID,
    DEBIT_PARTNER_NAME,
    DEBIT_PARTNER_CODE,
    DEBIT_PARTNER_SWIFT_CODE,
    CREDIT_PARTNER_ID,
    CREDIT_PARTNER_NAME,
    CREDIT_PARTNER_CODE,
    CREDIT_PARTNER_SWIFT_CODE,
    DOCUMENT_TYPE_ID,
    DOCUMENT_TYPE_CODE,
    DOCUMENT_TYPE_NAME,
    PERIOD_ID,
    DOCUMENT_CODE,
    DOCUMENT_DATE,
    USER_ID,
    USRNAME,
    CONTRACT_ID,
    REASON_DOCUMENT_ID,
    REASON,
    NOTE,
    CURRENCY_ID,
    AMOUNT_WITH_TAX,
    TAX_AMOUNT,
    AMOUNT,
    CURRENCY_AMOUNT_WITH_TAX,
    CURRENCY_TAX_AMOUNT,
    CURRENCY_AMOUNT,
    TOTAL,
    TOTAL_WITH_TAX,
    TAX_TOTAL,
    CURRENCY_TOTAL,
    CURRENCY_TOTAL_WITH_TAX,
    CURRENCY_TAX_TOTAL,
    DOCUMENT_AMOUNT,
    DOCUMENT_TOTAL,
    CURRENCY_DOCUMENT_AMOUNT,
    CURRENCY_DOCUMENT_TOTAL,
    DEBIT_PARTNER_BANK_ACCOUNT_NO,
    DEBIT_PARTNER_BANK_SWIFT_CODE,
    DEBIT_PARTNER_BANK_NAME,
    DEBIT_PARTNER_BANK_CITY_NAME,
    CREDIT_PARTNER_BANK_ACCOUNT_NO,
    CREDIT_PARTNER_BANK_SWIFT_CODE,
    CREDIT_PARTNER_BANK_NAME,
    CREDIT_PARTNER_BANK_CITY_NAME,
    PAYMENT_MISSING
) AS
SELECT
  p.id,
  p.organization_id,
  p.organization_id,
  p.organization_name,
  p.organization_code,
  p.organization_swift_code,
  p.partner_id,
  p.partner_name,
  p.partner_code,
  p.partner_swift_code,
  p.document_type_id,
  p.document_type_code,
  p.document_type_name,
  p.period_id,
  p.document_code,
  p.document_date,
  p.user_id,
  p.usrname,
  p.contract_id,
  p.reason_document_id,
  p.reason,
  p.note,
  p.currency_id,
  p.amount_with_tax,
  p.tax_amount,
  p.amount,
  p.currency_amount_with_tax,
  p.currency_tax_amount,
  p.currency_amount,
  p.total,
  p.total_with_tax,
  p.tax_total,
  p.currency_total,
  p.currency_total_with_tax,
  p.currency_tax_total,
  p.document_amount,
  p.document_total,
  p.currency_document_amount,
  p.currency_document_total,
  p.organization_bank_account_no,
  p.organization_bank_swift_code,
  p.organization_bank_name,
  p.organization_bank_city_name,
  p.partner_bank_account_no,
  p.partner_bank_swift_code,
  p.partner_bank_name,
  p.partner_bank_city_name,
  p.payment_missing
 FROM v_payment_outcome p
 UNION ALL
SELECT
  p.id,
  p.organization_id,
  p.partner_id,
  p.partner_name,
  p.partner_code,
  p.partner_swift_code,
  p.organization_id,
  p.organization_name,
  p.organization_code,
  p.organization_swift_code,
  p.document_type_id,
  p.document_type_code,
  p.document_type_name,
  p.period_id,
  p.document_code,
  p.document_date,
  p.user_id,
  p.usrname,
  p.contract_id,
  p.reason_document_id,
  p.reason,
  p.note,
  p.currency_id,
  p.amount_with_tax,
  p.tax_amount,
  p.amount,
  p.currency_amount_with_tax,
  p.currency_tax_amount,
  p.currency_amount,
  p.total,
  p.total_with_tax,
  p.tax_total,
  p.currency_total,
  p.currency_total_with_tax,
  p.currency_tax_total,
  p.document_amount,
  p.document_total,
  p.currency_document_amount,
  p.currency_document_total,
  p.partner_bank_account_no,
  p.partner_bank_swift_code,
  p.partner_bank_name,
  p.partner_bank_city_name,
  p.organization_bank_account_no,
  p.organization_bank_swift_code,
  p.organization_bank_name,
  p.organization_bank_city_name,
  p.payment_missing
 FROM v_payment_income p;
 
 
CREATE VIEW V_PAYMENT_ROTATE (
    ID,
    ORGANIZATION_ID,
    PARTNER_ID,
    PARTNER_NAME,
    PARTNER_CODE,
    PARTNER_SWIFT_CODE,
    DOCUMENT_TYPE_ID,
    DOCUMENT_TYPE_CODE,
    DOCUMENT_TYPE_NAME,
    PERIOD_ID,
    DOCUMENT_CODE,
    DOCUMENT_DATE,
    USER_ID,
    USRNAME,
    CONTRACT_ID,
    REASON_DOCUMENT_ID,
    REASON,
    NOTE,
    CURRENCY_ID,
    DEBIT_AMOUNT,
    CREDIT_AMOUNT,
    PARTNER_BANK_ACCOUNT_ID,
    PARTNER_BANK_ACCOUNT_NO,
    PARTNER_BANK_SWIFT_CODE,
    PARTNER_BANK_NAME,
    PARTNER_BANK_CITY_NAME,
    ORGANIZATION_BANK_ACCOUNT_ID,
    ORGANIZATION_BANK_ACCOUNT_NO,
    ORGANIZATION_BANK_SWIFT_CODE,
    ORGANIZATION_BANK_NAME,
    ORGANIZATION_BANK_CITY_NAME,
    PAYMENT_MISSING
) AS
SELECT
  p.id,
  p.organization_id,
  p.partner_id,
  p.partner_name,
  p.partner_code,
  p.partner_swift_code,
  p.document_type_id,
  p.document_type_code,
  p.document_type_name,
  p.period_id,
  p.document_code,
  p.document_date,
  p.user_id,
  p.usrname,
  p.contract_id,
  p.reason_document_id,
  p.reason,
  p.note,
  p.currency_id,
  p.document_total as debit_amount,
  0.0 as credit_amount,
  p.partner_bank_account_id,
  p.partner_bank_account_no,
  p.partner_bank_swift_code,
  p.partner_bank_name,
  p.partner_bank_city_name,
  p.organization_bank_account_id,
  p.organization_bank_account_no,
  p.organization_bank_swift_code,
  p.organization_bank_name,
  p.organization_bank_city_name,
  p.payment_missing
 FROM v_payment_outcome p
 UNION ALL
SELECT
  p.id,
  p.organization_id,
  p.partner_id,
  p.partner_name,
  p.partner_code,
  p.partner_swift_code,
  p.document_type_id,
  p.document_type_code,
  p.document_type_name,
  p.period_id,
  p.document_code,
  p.document_date,
  p.user_id,
  p.usrname,
  p.contract_id,
  p.reason_document_id,
  p.reason,
  p.note,
  p.currency_id,
  0.0 as debit_amount,
  p.document_total as credit_amount,
  p.partner_bank_account_id,
  p.partner_bank_account_no,
  p.partner_bank_swift_code,
  p.partner_bank_name,
  p.partner_bank_city_name,
  p.organization_bank_account_id,
  p.organization_bank_account_no,
  p.organization_bank_swift_code,
  p.organization_bank_name,
  p.organization_bank_city_name,
  p.payment_missing
 FROM v_payment_income p;


CREATE VIEW v_businessable (
  id, 
  owner_id, 
  entity_id, 
  entity_code, 
  entity_name, 
  name
) AS 
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, CAST(o.name AS VARCHAR(100))
 FROM businessable b
 INNER JOIN department o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'DEPARTMENT'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, CAST(o.name AS VARCHAR(100))
 FROM businessable b
 INNER JOIN store o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'STORE'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, CAST(o.name AS VARCHAR(100))
 FROM businessable b
 INNER JOIN drugstore o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'DRUGSTORE'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, CAST(o.name AS VARCHAR(100))
 FROM businessable b
 INNER JOIN shop o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'SHOP'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, CAST(o.name AS VARCHAR(100))
 FROM businessable b
 INNER JOIN brigade o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'BRIGADE'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, CAST(o.name AS VARCHAR(100))
 FROM businessable b
 INNER JOIN workshop o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'WORKSHOP'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, CAST(o.name AS VARCHAR(100))
 FROM businessable b
 INNER JOIN factory o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'FACTORY'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, CAST(o.name AS VARCHAR(100))
 FROM businessable b
 INNER JOIN works o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'WORKS'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, CAST(o.responsible_name AS VARCHAR(100))
 FROM businessable b
 INNER JOIN v_responsible o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'RESPONSIBLE'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, CAST(o.name AS VARCHAR(100))
 FROM businessable b
 INNER JOIN partner o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'PARTNER'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, CAST(o.name AS VARCHAR(100))
 FROM businessable b
 INNER JOIN v_bank o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'BANK'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, CAST(o.product_name AS VARCHAR(100))
 FROM businessable b
 INNER JOIN v_goods o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'GOODS'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, CAST(o.product_name AS VARCHAR(100))
 FROM businessable b
 INNER JOIN v_asset o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'ASSET'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, CAST(o.name AS VARCHAR(100))
 FROM businessable b
 INNER JOIN v_employee o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'EMPLOYEE';

CREATE VIEW v_partner_register (
 id,
 organization_id,
 period_id,
 partner_id,
 debit_amount,
 credit_amount
) AS 
SELECT 
 r.id,
 r.organization_id,
 r.period_id,
 r.partner_id,
 r.debit_amount,
 r.credit_amount
 FROM partner_register r;


CREATE VIEW v_partner_move (
  id,
  document_id,
  partner_id,
  partner_name,
  amount,
  amount_with_tax,
  tax_amount
) AS
SELECT 
  m.id,
  m.owner_id as document_id,
  m.partner_id,
  p.name as partner_name,
  m.amount,
  m.amount_with_tax,
  m.tax_amount
 FROM partner_move m
 INNER JOIN partner p ON p.id = m.partner_id;

CREATE VIEW v_goods_register (
 id,
 organization_id,
 period_id,
 goods_id,
 quantity,
 price,
 amount
) AS
SELECT 
 r.id,
 r.organization_id,
 r.period_id,
 r.product_id as goods_id,
 r.quantity,
 r.price,
 r.amount
FROM product_register r
INNER JOIN goods g ON g.id = r.product_id;


CREATE VIEW v_goods_detail_register (
 id,
 organization_id,
 period_id,
 goods_id,
 warehouse_id,
 responsible_id,
 quantity,
 amount
) AS
SELECT 
 r.id,
 r.organization_id,
 r.period_id,
 r.product_id as goods_id,
 r.warehouse_id,
 r.responsible_id,
 r.quantity,
 r.amount
FROM product_detail_register r
INNER JOIN goods g ON g.id = r.product_id;



CREATE VIEW v_goods_sale (
  period_id,
  organization_id,
  document_id,
  document_code,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  quantity,
  amount,
  document_amount
) AS
SELECT 
  fd.period_id,
  fd.organization_id,
  fd.id as document_id,
  fd.document_code,
  fd.document_date,
  fd.document_year,
  fd.document_month,
  i.product_id,
  i.product_code,
  i.product_name,
  i.item_unit_id,
  i.unit_id,
  i.unit_name,
  i.product_price,
  i.item_account_price as price,
  i.item_price as item_price,
  i.account_quantity as quantity,
  i.item_amount as amount,
  fd.document_amount
 FROM v_product_move i
 INNER JOIN v_finance_document fd ON fd.id = i.document_id
 INNER JOIN document_type t ON t.id = fd.document_type_id 
 AND t.document_section = 'GOODS' AND t.document_category = 'SALE';

/* USE IS_COMPLETE */


CREATE VIEW v_goods_purchase (
  period_id,
  organization_id,
  document_id,
  document_code,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  quantity,
  amount,
  document_amount,
  warehouse_id,
  warehouse_name,
  partner_id,
  partner_name
) AS
SELECT 
  fd.period_id,
  fd.organization_id,
  fd.id as document_id,
  fd.document_code,
  fd.document_date,
  fd.document_year,
  fd.document_month,
  i.product_id,
  i.product_code,
  i.product_name,
  i.item_unit_id,
  i.unit_id,
  i.unit_name,
  i.product_price,
  i.item_account_price as price,
  i.item_price as item_price,
  i.account_quantity as quantity,
  i.item_amount as amount,
  fd.document_amount,
  sto.warehouse_id,
  sto.warehouse_name,
  prt.partner_id,
  prt.partner_name
 FROM v_product_move i
 INNER JOIN v_finance_document fd ON fd.id = i.document_id
 INNER JOIN v_warehouse_move sto ON sto.document_id = fd.id
 INNER JOIN v_partner_move prt ON prt.document_id = fd.id
 INNER JOIN document_type t ON t.id = fd.document_type_id 
 AND t.document_section = 'GOODS' AND t.document_category = 'PURCHASE';

/* USE IS_COMPLETE */


CREATE VIEW v_rpt_goods_income (
  period_id,
  organization_id,
  document_id,
  document_code,
  document_date,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  price,
  quantity,
  amount,
  document_amount,
  warehouse_id,
  warehouse_name,
  partner_id,
  partner_name
) AS
SELECT
  fd.period_id,
  fd.organization_id,
  i.goods_income_id,
  fd.document_code,
  fd.document_date,
  i.product_id,
  p.product_code,
  p.product_name,
  i.unit_id,
  i.unit_id,
  u.name,
  i.price,
  i.quantity,
  i.amount,
  fd.document_amount,
  d.warehouse_id,
  sto.name,
  fd.partner_id,
  prt.name
 FROM goods_income_item i
 INNER JOIN goods_income d ON d.id = i.goods_income_id
 INNER JOIN v_finance_document fd ON fd.id = d.id
 INNER JOIN v_product p ON p.id = i.product_id
 INNER JOIN unit u ON u.id = i.unit_id
 INNER JOIN v_warehouse sto ON sto.id = d.warehouse_id
 INNER JOIN partner prt ON prt.id = fd.partner_id;
 

CREATE VIEW v_rpt_goods_outcome (
  period_id,
  organization_id,
  document_id,
  document_code,
  document_date,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  price,
  quantity,
  amount,
  document_amount,
  warehouse_id,
  warehouse_name,
  partner_id,
  partner_name
) AS
SELECT 
  fd.period_id,
  fd.organization_id,
  i.goods_outcome_id,
  fd.document_code,
  fd.document_date,
  i.product_id,
  p.product_code,
  p.product_name,
  i.unit_id,
  i.unit_id,
  u.name,
  i.price,
  i.quantity,
  i.amount,
  fd.document_amount,
  d.warehouse_id,
  sto.name,
  fd.partner_id,
  prt.name
 FROM goods_outcome_item i
 INNER JOIN goods_outcome d ON d.id = i.goods_outcome_id
 INNER JOIN v_finance_document fd ON fd.id = d.id
 INNER JOIN v_product p ON p.id = i.product_id
 INNER JOIN unit u ON u.id = i.unit_id
 INNER JOIN v_warehouse sto ON sto.id = d.warehouse_id
 INNER JOIN partner prt ON prt.id = fd.partner_id;


CREATE VIEW v_rpt_goods_rest (
  period_id,
  organization_id,
  document_id,
  document_code,
  document_date,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  quantity,
  price,
  amount,
  warehouse_id
) AS
SELECT 
  fd.period_id,
  fd.organization_id,
  i.goods_rest_id,
  fd.document_code,
  fd.document_date,
  i.product_id,
  p.product_code,
  p.product_name,
  i.unit_id,
  p.unit_id,
  u.name,
  p.price as product_price,
  i.account_quantity as quantity,
  i.account_price as price,
  i.amount,
  d.warehouse_id
 FROM goods_rest_item i
 INNER JOIN goods_rest d ON d.id = i.goods_rest_id
 INNER JOIN v_finance_document fd ON fd.id = d.id
 INNER JOIN v_product p ON p.id = i.product_id
 INNER JOIN unit u ON u.id = p.unit_id;

CREATE VIEW v_rpt_invoice (
  period_id,
  organization_id,
  invoice_id,
  document_code,
  document_date,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  price,
  quantity,
  amount,
  document_amount,
  partner_id,
  partner_name
) AS
SELECT 
  fd.period_id,
  fd.organization_id,
  i.invoice_id,
  fd.document_code,
  fd.document_date,
  i.product_id,
  p.product_code,
  p.product_name,
  i.unit_id,
  i.unit_id,
  u.name,
  i.price,
  i.quantity,
  i.amount,
  fd.document_amount,
  fd.partner_id,
  prt.name
 FROM invoice_item i
 INNER JOIN invoice d ON d.id = i.invoice_id
 INNER JOIN v_finance_document fd ON fd.id = d.id 
 INNER JOIN v_product p ON p.id = i.product_id
 INNER JOIN unit u ON u.id = i.unit_id
 INNER JOIN partner prt ON prt.id = fd.partner_id;

CREATE VIEW v_rpt_goods_register (
  period_id,
  organization_id,
  goods_id,
  product_code,
  product_name,
  unit_id,
  unit_name,
  product_price,
  price,
  quantity,
  amount
) AS
SELECT 
  r.period_id,
  r.organization_id,
  r.goods_id,
  p.product_code,
  p.product_name,
  p.unit_id,
  u.name,
  p.price as product_price,
  r.price,
  r.quantity,
  r.amount
 FROM v_goods_register r
 INNER JOIN goods g ON g.id = r.goods_id
 INNER JOIN v_product p ON p.id = g.id
 INNER JOIN unit u ON u.id = p.unit_id;

CREATE VIEW v_rpt_goods_sale (
  period_id,
  organization_id,
  document_id,
  document_code,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  quantity,
  amount,
  document_amount,
  warehouse_id,
  warehouse_name,
  partner_id,
  partner_name
) AS
SELECT
  s.period_id,
  s.organization_id,
  s.document_id,
  s.document_code,
  s.document_date,
  s.document_year,
  s.document_month,
  s.product_id,
  s.product_code,
  s.product_name,
  s.item_unit_id,
  s.unit_id,
  s.unit_name,
  s.product_price,
  s.price,
  s.item_price,
  s.quantity,
  s.amount,
  s.document_amount,
  wrh.warehouse_id,
  wrh.warehouse_name,
  prt.partner_id,
  prt.partner_name
 FROM v_goods_sale s
 INNER JOIN v_warehouse_move wrh ON wrh.document_id = s.document_id
 INNER JOIN v_partner_move prt ON prt.document_id = s.document_id;

/* 
   HSQL implementation 
 
   Use Views
*/

/* Create Views by month (TEST/DEMO) */

/* 01 Month Jan */
CREATE VIEW V_RPT_GOODS_SALE_MONTH_01 (
    PERIOD_ID,
    ORGANIZATION_ID,
    DOCUMENT_DATE,
    DOCUMENT_YEAR,
    DOCUMENT_MONTH,
    PRODUCT_ID,
    PRODUCT_CODE,
    PRODUCT_NAME,
    ITEM_UNIT_ID,
    UNIT_ID,
    UNIT_NAME,
    PRODUCT_PRICE,
    PRICE,
    ITEM_PRICE,
    Q01,
    Q02,
    Q03,
    Q04,
    Q05,
    Q06,
    Q07,
    Q08,
    Q09,
    Q10,
    Q11,
    Q12,
    S01,
    S02,
    S03,
    S04,
    S05,
    S06,
    S07,
    S08,
    S09,
    S10,
    S11,
    S12)
AS
SELECT 
  r.period_id,
  r.organization_id,
  r.document_date,
  r.document_year,
  r.document_month,
  r.product_id,
  r.product_code,
  r.product_name,
  r.item_unit_id,
  r.unit_id,
  r.unit_name,
  r.product_price,
  r.price,
  r.item_price,
  r.quantity as q01, 0.0 as q02, 0.0 as q03, 0.0 as q04, 0.0 as q05, 0.0 as q06, 0.0 as q07, 0.0 as q08, 0.0 as q09, 0.0 as q10, 0.0 as q11, 0.0 as q12, 
  r.amount as s01,   0.0 as s02, 0.0 as s03, 0.0 as s04, 0.0 as s05, 0.0 as s06, 0.0 as s07, 0.0 as s08, 0.0 as s09, 0.0 as s10, 0.0 as s11, 0.0 as s12 
 FROM v_goods_sale r
 WHERE r.document_month = 1;


/* 02 Month Feb */
CREATE VIEW V_RPT_GOODS_SALE_MONTH_02 (
    PERIOD_ID,
    ORGANIZATION_ID,
    DOCUMENT_DATE,
    DOCUMENT_YEAR,
    DOCUMENT_MONTH,
    PRODUCT_ID,
    PRODUCT_CODE,
    PRODUCT_NAME,
    ITEM_UNIT_ID,
    UNIT_ID,
    UNIT_NAME,
    PRODUCT_PRICE,
    PRICE,
    ITEM_PRICE,
    Q01,
    Q02,
    Q03,
    Q04,
    Q05,
    Q06,
    Q07,
    Q08,
    Q09,
    Q10,
    Q11,
    Q12,
    S01,
    S02,
    S03,
    S04,
    S05,
    S06,
    S07,
    S08,
    S09,
    S10,
    S11,
    S12)
AS
SELECT
  r.period_id,
  r.organization_id,
  r.document_date,
  r.document_year,
  r.document_month,
  r.product_id,
  r.product_code,
  r.product_name,
  r.item_unit_id,
  r.unit_id,
  r.unit_name,
  r.product_price,
  r.price,
  r.item_price,
  0.0 as q01, r.quantity as q02, 0.0 as q03, 0.0 as q04, 0.0 as q05, 0.0 as q06, 0.0 as q07, 0.0 as q08, 0.0 as q09, 0.0 as q10, 0.0 as q11, 0.0 as q12, 
  0.0 as s01, r.amount as s02, 0.0 as s03, 0.0 as s04, 0.0 as s05, 0.0 as s06, 0.0 as s07, 0.0 as s08, 0.0 as s09, 0.0 as s10, 0.0 as s11, 0.0 as s12 
 FROM v_goods_sale r
 WHERE r.document_month = 2;

/* 03 Month Mar */
CREATE VIEW V_RPT_GOODS_SALE_MONTH_03 (
    PERIOD_ID,
    ORGANIZATION_ID,
    DOCUMENT_DATE,
    DOCUMENT_YEAR,
    DOCUMENT_MONTH,
    PRODUCT_ID,
    PRODUCT_CODE,
    PRODUCT_NAME,
    ITEM_UNIT_ID,
    UNIT_ID,
    UNIT_NAME,
    PRODUCT_PRICE,
    PRICE,
    ITEM_PRICE,
    Q01,
    Q02,
    Q03,
    Q04,
    Q05,
    Q06,
    Q07,
    Q08,
    Q09,
    Q10,
    Q11,
    Q12,
    S01,
    S02,
    S03,
    S04,
    S05,
    S06,
    S07,
    S08,
    S09,
    S10,
    S11,
    S12)
AS


SELECT 
  r.period_id,
  r.organization_id,
  r.document_date,
  r.document_year,
  r.document_month,
  r.product_id,
  r.product_code,
  r.product_name,
  r.item_unit_id,
  r.unit_id,
  r.unit_name,
  r.product_price,
  r.price,
  r.item_price,
  0.0 as q01, 0.0 as q02, r.quantity as q03, 0.0 as q04, 0.0 as q05, 0.0 as q06, 0.0 as q07, 0.0 as q08, 0.0 as q09, 0.0 as q10, 0.0 as q11, 0.0 as q12, 
  0.0 as s01, 0.0 as s02, r.amount as s03, 0.0 as s04, 0.0 as s05, 0.0 as s06, 0.0 as s07, 0.0 as s08, 0.0 as s09, 0.0 as s10, 0.0 as s11, 0.0 as s12 
 FROM v_goods_sale r
 WHERE r.document_month = 3;

/* 04 Month Apr */
CREATE VIEW V_RPT_GOODS_SALE_MONTH_04 (
    PERIOD_ID,
    ORGANIZATION_ID,
    DOCUMENT_DATE,
    DOCUMENT_YEAR,
    DOCUMENT_MONTH,
    PRODUCT_ID,
    PRODUCT_CODE,
    PRODUCT_NAME,
    ITEM_UNIT_ID,
    UNIT_ID,
    UNIT_NAME,
    PRODUCT_PRICE,
    PRICE,
    ITEM_PRICE,
    Q01,
    Q02,
    Q03,
    Q04,
    Q05,
    Q06,
    Q07,
    Q08,
    Q09,
    Q10,
    Q11,
    Q12,
    S01,
    S02,
    S03,
    S04,
    S05,
    S06,
    S07,
    S08,
    S09,
    S10,
    S11,
    S12)
AS


SELECT 
  r.period_id,
  r.organization_id,
  r.document_date,
  r.document_year,
  r.document_month,
  r.product_id,
  r.product_code,
  r.product_name,
  r.item_unit_id,
  r.unit_id,
  r.unit_name,
  r.product_price,
  r.price,
  r.item_price,
  0.0 as q01, 0.0 as q02, 0.0 as q03, r.quantity as q04, 0.0 as q05, 0.0 as q06, 0.0 as q07, 0.0 as q08, 0.0 as q09, 0.0 as q10, 0.0 as q11, 0.0 as q12, 
  0.0 as s01, 0.0 as s02, 0.0 as s03, r.amount as s04, 0.0 as s05, 0.0 as s06, 0.0 as s07, 0.0 as s08, 0.0 as s09, 0.0 as s10, 0.0 as s11, 0.0 as s12 
 FROM v_goods_sale r
 WHERE r.document_month = 4;

/* 05 Month May */
CREATE VIEW V_RPT_GOODS_SALE_MONTH_05 (
    PERIOD_ID,
    ORGANIZATION_ID,
    DOCUMENT_DATE,
    DOCUMENT_YEAR,
    DOCUMENT_MONTH,
    PRODUCT_ID,
    PRODUCT_CODE,
    PRODUCT_NAME,
    ITEM_UNIT_ID,
    UNIT_ID,
    UNIT_NAME,
    PRODUCT_PRICE,
    PRICE,
    ITEM_PRICE,
    Q01,
    Q02,
    Q03,
    Q04,
    Q05,
    Q06,
    Q07,
    Q08,
    Q09,
    Q10,
    Q11,
    Q12,
    S01,
    S02,
    S03,
    S04,
    S05,
    S06,
    S07,
    S08,
    S09,
    S10,
    S11,
    S12)
AS


SELECT 
  r.period_id,
  r.organization_id,
  r.document_date,
  r.document_year,
  r.document_month,
  r.product_id,
  r.product_code,
  r.product_name,
  r.item_unit_id,
  r.unit_id,
  r.unit_name,
  r.product_price,
  r.price,
  r.item_price,
  0.0 as q01, 0.0 as q02, 0.0 as q03, 0.0 as q04, r.quantity as q05, 0.0 as q06, 0.0 as q07, 0.0 as q08, 0.0 as q09, 0.0 as q10, 0.0 as q11, 0.0 as q12, 
  0.0 as s01, 0.0 as s02, 0.0 as s03, 0.0 as s04, r.amount as s05, 0.0 as s06, 0.0 as s07, 0.0 as s08, 0.0 as s09, 0.0 as s10, 0.0 as s11, 0.0 as s12 
 FROM v_goods_sale r
 WHERE r.document_month = 5;

/* 06 Month Jun */
CREATE VIEW V_RPT_GOODS_SALE_MONTH_06 (
    PERIOD_ID,
    ORGANIZATION_ID,
    DOCUMENT_DATE,
    DOCUMENT_YEAR,
    DOCUMENT_MONTH,
    PRODUCT_ID,
    PRODUCT_CODE,
    PRODUCT_NAME,
    ITEM_UNIT_ID,
    UNIT_ID,
    UNIT_NAME,
    PRODUCT_PRICE,
    PRICE,
    ITEM_PRICE,
    Q01,
    Q02,
    Q03,
    Q04,
    Q05,
    Q06,
    Q07,
    Q08,
    Q09,
    Q10,
    Q11,
    Q12,
    S01,
    S02,
    S03,
    S04,
    S05,
    S06,
    S07,
    S08,
    S09,
    S10,
    S11,
    S12)
AS


SELECT 
  r.period_id,
  r.organization_id,
  r.document_date,
  r.document_year,
  r.document_month,
  r.product_id,
  r.product_code,
  r.product_name,
  r.item_unit_id,
  r.unit_id,
  r.unit_name,
  r.product_price,
  r.price,
  r.item_price,
  0.0 as q01, 0.0 as q02, 0.0 as q03, 0.0 as q04, 0.0 as q05, r.quantity as q06, 0.0 as q07, 0.0 as q08, 0.0 as q09, 0.0 as q10, 0.0 as q11, 0.0 as q12, 
  0.0 as s01, 0.0 as s02, 0.0 as s03, 0.0 as s04, 0.0 as s05, r.amount as s06, 0.0 as s07, 0.0 as s08, 0.0 as s09, 0.0 as s10, 0.0 as s11, 0.0 as s12 
 FROM v_goods_sale r
 WHERE r.document_month = 6;

/* 07 Month Jul */
CREATE VIEW V_RPT_GOODS_SALE_MONTH_07 (
    PERIOD_ID,
    ORGANIZATION_ID,
    DOCUMENT_DATE,
    DOCUMENT_YEAR,
    DOCUMENT_MONTH,
    PRODUCT_ID,
    PRODUCT_CODE,
    PRODUCT_NAME,
    ITEM_UNIT_ID,
    UNIT_ID,
    UNIT_NAME,
    PRODUCT_PRICE,
    PRICE,
    ITEM_PRICE,
    Q01,
    Q02,
    Q03,
    Q04,
    Q05,
    Q06,
    Q07,
    Q08,
    Q09,
    Q10,
    Q11,
    Q12,
    S01,
    S02,
    S03,
    S04,
    S05,
    S06,
    S07,
    S08,
    S09,
    S10,
    S11,
    S12)
AS


SELECT 
  r.period_id,
  r.organization_id,
  r.document_date,
  r.document_year,
  r.document_month,
  r.product_id,
  r.product_code,
  r.product_name,
  r.item_unit_id,
  r.unit_id,
  r.unit_name,
  r.product_price,
  r.price,
  r.item_price,
  0.0 as q01, 0.0 as q02, 0.0 as q03, 0.0 as q04, 0.0 as q05, 0.0 as q06, r.quantity as q07, 0.0 as q08, 0.0 as q09, 0.0 as q10, 0.0 as q11, 0.0 as q12, 
  0.0 as s01, 0.0 as s02, 0.0 as s03, 0.0 as s04, 0.0 as s05, 0.0 as s06, r.amount as s07, 0.0 as s08, 0.0 as s09, 0.0 as s10, 0.0 as s11, 0.0 as s12 
 FROM v_goods_sale r
 WHERE r.document_month = 7;

/* 08 Month Aug */
CREATE VIEW V_RPT_GOODS_SALE_MONTH_08 (
    PERIOD_ID,
    ORGANIZATION_ID,
    DOCUMENT_DATE,
    DOCUMENT_YEAR,
    DOCUMENT_MONTH,
    PRODUCT_ID,
    PRODUCT_CODE,
    PRODUCT_NAME,
    ITEM_UNIT_ID,
    UNIT_ID,
    UNIT_NAME,
    PRODUCT_PRICE,
    PRICE,
    ITEM_PRICE,
    Q01,
    Q02,
    Q03,
    Q04,
    Q05,
    Q06,
    Q07,
    Q08,
    Q09,
    Q10,
    Q11,
    Q12,
    S01,
    S02,
    S03,
    S04,
    S05,
    S06,
    S07,
    S08,
    S09,
    S10,
    S11,
    S12)
AS


SELECT 
  r.period_id,
  r.organization_id,
  r.document_date,
  r.document_year,
  r.document_month,
  r.product_id,
  r.product_code,
  r.product_name,
  r.item_unit_id,
  r.unit_id,
  r.unit_name,
  r.product_price,
  r.price,
  r.item_price,
  0.0 as q01, 0.0 as q02, 0.0 as q03, 0.0 as q04, 0.0 as q05, 0.0 as q06, 0.0 as q07, r.quantity as q08, 0.0 as q09, 0.0 as q10, 0.0 as q11, 0.0 as q12, 
  0.0 as s01, 0.0 as s02, 0.0 as s03, 0.0 as s04, 0.0 as s05, 0.0 as s06, 0.0 as s07, r.amount as s08, 0.0 as s09, 0.0 as s10, 0.0 as s11, 0.0 as s12 
 FROM v_goods_sale r
 WHERE r.document_month = 8;

/* 09 Month Sep */
CREATE VIEW V_RPT_GOODS_SALE_MONTH_09 (
    PERIOD_ID,
    ORGANIZATION_ID,
    DOCUMENT_DATE,
    DOCUMENT_YEAR,
    DOCUMENT_MONTH,
    PRODUCT_ID,
    PRODUCT_CODE,
    PRODUCT_NAME,
    ITEM_UNIT_ID,
    UNIT_ID,
    UNIT_NAME,
    PRODUCT_PRICE,
    PRICE,
    ITEM_PRICE,
    Q01,
    Q02,
    Q03,
    Q04,
    Q05,
    Q06,
    Q07,
    Q08,
    Q09,
    Q10,
    Q11,
    Q12,
    S01,
    S02,
    S03,
    S04,
    S05,
    S06,
    S07,
    S08,
    S09,
    S10,
    S11,
    S12)
AS


SELECT 
  r.period_id,
  r.organization_id,
  r.document_date,
  r.document_year,
  r.document_month,
  r.product_id,
  r.product_code,
  r.product_name,
  r.item_unit_id,
  r.unit_id,
  r.unit_name,
  r.product_price,
  r.price,
  r.item_price,
  0.0 as q01, 0.0 as q02, 0.0 as q03, 0.0 as q04, 0.0 as q05, 0.0 as q06, 0.0 as q07, 0.0 as q08, r.quantity as q09, 0.0 as q10, 0.0 as q11, 0.0 as q12, 
  0.0 as s01, 0.0 as s02, 0.0 as s03, 0.0 as s04, 0.0 as s05, 0.0 as s06, 0.0 as s07, 0.0 as s08, r.amount as s09, 0.0 as s10, 0.0 as s11, 0.0 as s12 
 FROM v_goods_sale r
 WHERE r.document_month = 9;

/* 10 Month Oct */
CREATE VIEW V_RPT_GOODS_SALE_MONTH_10 (
    PERIOD_ID,
    ORGANIZATION_ID,
    DOCUMENT_DATE,
    DOCUMENT_YEAR,
    DOCUMENT_MONTH,
    PRODUCT_ID,
    PRODUCT_CODE,
    PRODUCT_NAME,
    ITEM_UNIT_ID,
    UNIT_ID,
    UNIT_NAME,
    PRODUCT_PRICE,
    PRICE,
    ITEM_PRICE,
    Q01,
    Q02,
    Q03,
    Q04,
    Q05,
    Q06,
    Q07,
    Q08,
    Q09,
    Q10,
    Q11,
    Q12,
    S01,
    S02,
    S03,
    S04,
    S05,
    S06,
    S07,
    S08,
    S09,
    S10,
    S11,
    S12)
AS


SELECT 
  r.period_id,
  r.organization_id,
  r.document_date,
  r.document_year,
  r.document_month,
  r.product_id,
  r.product_code,
  r.product_name,
  r.item_unit_id,
  r.unit_id,
  r.unit_name,
  r.product_price,
  r.price,
  r.item_price,
  0.0 as q01, 0.0 as q02, 0.0 as q03, 0.0 as q04, 0.0 as q05, 0.0 as q06, 0.0 as q07, 0.0 as q08, 0.0 as q09, r.quantity as q10, 0.0 as q11, 0.0 as q12, 
  0.0 as s01, 0.0 as s02, 0.0 as s03, 0.0 as s04, 0.0 as s05, 0.0 as s06, 0.0 as s07, 0.0 as s08, 0.0 as s09, r.amount as s10, 0.0 as s11, 0.0 as s12 
 FROM v_goods_sale r
 WHERE r.document_month = 10;

/* 11 Month Nov */
CREATE VIEW V_RPT_GOODS_SALE_MONTH_11 (
    PERIOD_ID,
    ORGANIZATION_ID,
    DOCUMENT_DATE,
    DOCUMENT_YEAR,
    DOCUMENT_MONTH,
    PRODUCT_ID,
    PRODUCT_CODE,
    PRODUCT_NAME,
    ITEM_UNIT_ID,
    UNIT_ID,
    UNIT_NAME,
    PRODUCT_PRICE,
    PRICE,
    ITEM_PRICE,
    Q01,
    Q02,
    Q03,
    Q04,
    Q05,
    Q06,
    Q07,
    Q08,
    Q09,
    Q10,
    Q11,
    Q12,
    S01,
    S02,
    S03,
    S04,
    S05,
    S06,
    S07,
    S08,
    S09,
    S10,
    S11,
    S12)
AS


SELECT 
  r.period_id,
  r.organization_id,
  r.document_date,
  r.document_year,
  r.document_month,
  r.product_id,
  r.product_code,
  r.product_name,
  r.item_unit_id,
  r.unit_id,
  r.unit_name,
  r.product_price,
  r.price,
  r.item_price,
  0.0 as q01, 0.0 as q02, 0.0 as q03, 0.0 as q04, 0.0 as q05, 0.0 as q06, 0.0 as q07, 0.0 as q08, 0.0 as q09, 0.0 as q10, r.quantity as q11, 0.0 as q12, 
  0.0 as s01, 0.0 as s02, 0.0 as s03, 0.0 as s04, 0.0 as s05, 0.0 as s06, 0.0 as s07, 0.0 as s08, 0.0 as s09, 0.0 as s10, r.amount as s11, 0.0 as s12 
 FROM v_goods_sale r
 WHERE r.document_month = 11;

/* 12 Month Dec */
CREATE VIEW V_RPT_GOODS_SALE_MONTH_12 (
    PERIOD_ID,
    ORGANIZATION_ID,
    DOCUMENT_DATE,
    DOCUMENT_YEAR,
    DOCUMENT_MONTH,
    PRODUCT_ID,
    PRODUCT_CODE,
    PRODUCT_NAME,
    ITEM_UNIT_ID,
    UNIT_ID,
    UNIT_NAME,
    PRODUCT_PRICE,
    PRICE,
    ITEM_PRICE,
    Q01,
    Q02,
    Q03,
    Q04,
    Q05,
    Q06,
    Q07,
    Q08,
    Q09,
    Q10,
    Q11,
    Q12,
    S01,
    S02,
    S03,
    S04,
    S05,
    S06,
    S07,
    S08,
    S09,
    S10,
    S11,
    S12)
AS


SELECT 
  r.period_id,
  r.organization_id,
  r.document_date,
  r.document_year,
  r.document_month,
  r.product_id,
  r.product_code,
  r.product_name,
  r.item_unit_id,
  r.unit_id,
  r.unit_name,
  r.product_price,
  r.price,
  r.item_price,
  0.0 as q01, 0.0 as q02, 0.0 as q03, 0.0 as q04, 0.0 as q05, 0.0 as q06, 0.0 as q07, 0.0 as q08, 0.0 as q09, 0.0 as q10, 0.0 as q11, r.quantity as q12, 
  0.0 as s01, 0.0 as s02, 0.0 as s03, 0.0 as s04, 0.0 as s05, 0.0 as s06, 0.0 as s07, 0.0 as s08, 0.0 as s09, 0.0 as s10, 0.0 as s11, r.amount as s12 
 FROM v_goods_sale r
 WHERE r.document_month = 12;




/* Create View Sales by monthes */

CREATE VIEW V_RPT_GOODS_SALE_YEAR_PRODUCT (
    PERIOD_ID,
    ORGANIZATION_ID,
    DOCUMENT_DATE,
    DOCUMENT_YEAR,
    DOCUMENT_MONTH,
    PRODUCT_ID,
    PRODUCT_CODE,
    PRODUCT_NAME,
    ITEM_UNIT_ID,
    UNIT_ID,
    UNIT_NAME,
    PRODUCT_PRICE,
    PRICE,
    ITEM_PRICE,
    Q01,
    Q02,
    Q03,
    Q04,
    Q05,
    Q06,
    Q07,
    Q08,
    Q09,
    Q10,
    Q11,
    Q12,
    S01,
    S02,
    S03,
    S04,
    S05,
    S06,
    S07,
    S08,
    S09,
    S10,
    S11,
    S12)
AS
SELECT 
  period_id,
  organization_id,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  q01, q02, q03, q04, q05, q06, q07, q08, q09, q10, q11, q12,
  s01, s02, s03, s04, s05, s06, s07, s08, s09, s10, s11, s12
 FROM v_rpt_goods_sale_month_01 r

UNION ALL

SELECT 
  period_id,
  organization_id,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  q01, q02, q03, q04, q05, q06, q07, q08, q09, q10, q11, q12,
  s01, s02, s03, s04, s05, s06, s07, s08, s09, s10, s11, s12
 FROM v_rpt_goods_sale_month_02 r

UNION ALL

SELECT 
  period_id,
  organization_id,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  q01, q02, q03, q04, q05, q06, q07, q08, q09, q10, q11, q12,
  s01, s02, s03, s04, s05, s06, s07, s08, s09, s10, s11, s12
 FROM v_rpt_goods_sale_month_03 r

UNION ALL

SELECT 
  period_id,
  organization_id,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  q01, q02, q03, q04, q05, q06, q07, q08, q09, q10, q11, q12,
  s01, s02, s03, s04, s05, s06, s07, s08, s09, s10, s11, s12
 FROM v_rpt_goods_sale_month_04 r

UNION ALL

SELECT 
  period_id,
  organization_id,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  q01, q02, q03, q04, q05, q06, q07, q08, q09, q10, q11, q12,
  s01, s02, s03, s04, s05, s06, s07, s08, s09, s10, s11, s12
 FROM v_rpt_goods_sale_month_05 r

UNION ALL

SELECT 
  period_id,
  organization_id,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  q01, q02, q03, q04, q05, q06, q07, q08, q09, q10, q11, q12,
  s01, s02, s03, s04, s05, s06, s07, s08, s09, s10, s11, s12
 FROM v_rpt_goods_sale_month_06 r

UNION ALL

SELECT 
  period_id,
  organization_id,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  q01, q02, q03, q04, q05, q06, q07, q08, q09, q10, q11, q12,
  s01, s02, s03, s04, s05, s06, s07, s08, s09, s10, s11, s12
 FROM v_rpt_goods_sale_month_07 r

UNION ALL

SELECT 
  period_id,
  organization_id,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  q01, q02, q03, q04, q05, q06, q07, q08, q09, q10, q11, q12,
  s01, s02, s03, s04, s05, s06, s07, s08, s09, s10, s11, s12
 FROM v_rpt_goods_sale_month_08 r

UNION ALL

SELECT 
  period_id,
  organization_id,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  q01, q02, q03, q04, q05, q06, q07, q08, q09, q10, q11, q12,
  s01, s02, s03, s04, s05, s06, s07, s08, s09, s10, s11, s12
 FROM v_rpt_goods_sale_month_09 r

UNION ALL

SELECT 
  period_id,
  organization_id,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  q01, q02, q03, q04, q05, q06, q07, q08, q09, q10, q11, q12,
  s01, s02, s03, s04, s05, s06, s07, s08, s09, s10, s11, s12
 FROM v_rpt_goods_sale_month_10 r

UNION ALL

SELECT 
  period_id,
  organization_id,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  q01, q02, q03, q04, q05, q06, q07, q08, q09, q10, q11, q12,
  s01, s02, s03, s04, s05, s06, s07, s08, s09, s10, s11, s12
 FROM v_rpt_goods_sale_month_11 r

UNION ALL

SELECT 
  period_id,
  organization_id,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  q01, q02, q03, q04, q05, q06, q07, q08, q09, q10, q11, q12,
  s01, s02, s03, s04, s05, s06, s07, s08, s09, s10, s11, s12
 FROM v_rpt_goods_sale_month_12 r;






/* Sales by monthes (Jan - Dec) */

CREATE VIEW v_rpt_goods_sale_year (
  period_id,
  organization_id,
  document_date,
  document_year,
  document_month,
  s01,
  s02,
  s03,
  s04,
  s05,
  s06,
  s07,
  s08,
  s09,
  s10,
  s11,
  s12 
) AS
SELECT
  period_id,
  organization_id,
  document_date,
  document_year,
  document_month,
  s01,
  s02,
  s03,
  s04,
  s05,
  s06,
  s07,
  s08,
  s09,
  s10,
  s11,
  s12 
FROM v_rpt_goods_sale_year_product;


CREATE VIEW v_rpt_wrh_goods_register (
  period_id,
  organization_id,
  goods_id,
  warehouse_id,
  product_code,
  product_name,
  unit_id,
  unit_name,
  product_price,
  quantity,
  amount
) AS
SELECT 
  r.period_id,
  r.organization_id,
  r.goods_id,
  r.warehouse_id,
  p.product_code,
  p.product_name,
  p.unit_id,
  u.name as unit_name,
  p.price,
  r.quantity,
  r.amount
 FROM v_goods_detail_register r
 INNER JOIN goods g ON g.id = r.goods_id
 INNER JOIN v_product p ON p.id = g.id
 INNER JOIN unit u ON u.id = p.unit_id;



CREATE VIEW v_goods_credit_full (
  period_id,
  organization_id,
  document_code,
  document_date,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  quantity,
  amount
) AS
SELECT 
  fd.period_id,
  fd.organization_id,
  fd.document_code,
  fd.document_date,
  i.product_id,
  i.product_code,
  i.product_name,
  i.item_unit_id,
  i.unit_id,
  i.unit_name,
  i.item_price as item_price,
  i.account_quantity as quantity,
  i.item_amount as amount
 FROM v_product_move i
 INNER JOIN v_finance_document fd ON fd.id = i.document_id
 INNER JOIN warehouse_move sto ON sto.owner_id = fd.id
 INNER JOIN document_type t ON t.id = fd.document_type_id  AND t.document_section = 'GOODS'
 INNER JOIN finance_document_type ft ON t.id = ft.document_type_id 
  AND (ft.move_type = 'INPUT' OR (ft.move_type = 'ROTATE' AND sto.move_type = 'INPUT'));
 



CREATE VIEW v_goods_debit_full (
  period_id,
  organization_id,
  document_code,
  document_date,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  quantity,
  amount
) AS
SELECT 
  fd.period_id,
  fd.organization_id,
  fd.document_code,
  fd.document_date,
  i.product_id,
  i.product_code,
  i.product_name,
  i.item_unit_id,
  i.unit_id,
  i.unit_name,
  i.item_price as item_price,
  i.account_quantity as quantity,
  i.item_amount as amount
 FROM v_product_move i
 INNER JOIN v_finance_document fd ON fd.id = i.document_id
 INNER JOIN warehouse_move sto ON sto.owner_id = fd.id
 INNER JOIN document_type t ON t.id = fd.document_type_id  AND t.document_section = 'GOODS'
 INNER JOIN finance_document_type ft ON t.id = ft.document_type_id 
  AND (ft.move_type = 'OUTPUT' OR (ft.move_type = 'ROTATE' AND sto.move_type = 'OUTPUT'));
 



CREATE VIEW v_rpt_goods_rest_start (
  period_id,
  organization_id,
  product_id,
  product_code,
  product_name,
  unit_id,
  unit_name,
  quantity,
  amount
) AS
SELECT 
  r.period_id,
  r.organization_id,
  r.goods_id,
  r.product_code,
  r.product_name,
  r.unit_id,
  r.unit_name,
  r.quantity,
  r.amount
 FROM v_rpt_goods_register r
UNION ALL
SELECT 
  r.period_id,
  r.organization_id,
  r.product_id,
  r.product_code,
  r.product_name,
  r.unit_id,
  r.unit_name,
  r.quantity,
  r.amount
 FROM v_rpt_goods_rest r;


CREATE VIEW v_rpt_wrh_goods_rest_start (
  period_id,
  organization_id,
  product_id,
  product_code,
  product_name,
  unit_id,
  unit_name,
  quantity,
  amount,
  warehouse_id
) AS
SELECT 
  r.period_id,
  r.organization_id,
  r.goods_id,
  r.product_code,
  r.product_name,
  r.unit_id,
  r.unit_name,
  r.quantity,
  r.amount,
  r.warehouse_id
 FROM v_rpt_wrh_goods_register r
UNION ALL
SELECT 
  r.period_id,
  r.organization_id,
  r.product_id,
  r.product_code,
  r.product_name,
  r.unit_id,
  r.unit_name,
  r.quantity,
  r.amount,
  r.warehouse_id
 FROM v_rpt_goods_rest r;



CREATE VIEW v_rpt_goods_credit_full (
  period_id,
  organization_id,
  document_code,
  document_date,
  warehouse_id,
  partner_id,
  responsible_id,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  quantity,
  amount
) AS
SELECT 
  fd.period_id,
  fd.organization_id,
  fd.document_code,
  fd.document_date,
  sto.warehouse_id,
  prt.partner_id,
  NULL as responsible_id,
  i.product_id,
  i.product_code,
  i.product_name,
  i.item_unit_id,
  i.unit_id,
  i.unit_name,
  i.item_price as item_price,
  i.account_quantity as quantity,
  i.item_amount as amount
 FROM v_product_move i
 INNER JOIN v_finance_document fd ON fd.id = i.document_id
 INNER JOIN warehouse_move sto ON sto.owner_id = fd.id
 LEFT JOIN partner_move prt ON prt.owner_id = fd.id
 INNER JOIN document_type t ON t.id = fd.document_type_id  AND t.document_section = 'GOODS'
 INNER JOIN finance_document_type ft ON t.id = ft.document_type_id 
  AND (ft.move_type = 'INPUT' OR (ft.move_type = 'ROTATE' AND sto.move_type = 'INPUT'));
 



CREATE VIEW v_rpt_goods_debit_full (
  period_id,
  organization_id,
  document_code,
  document_date,
  warehouse_id,
  partner_id,
  responsible_id,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  quantity,
  amount
) AS
SELECT 
  fd.period_id,
  fd.organization_id,
  fd.document_code,
  fd.document_date,
  sto.warehouse_id,
  prt.partner_id,
  NULL as responsible_id,
  i.product_id,
  i.product_code,
  i.product_name,
  i.item_unit_id,
  i.unit_id,
  i.unit_name,
  i.item_price as item_price,
  i.account_quantity as quantity,
  i.item_amount as amount
 FROM v_product_move i
 INNER JOIN v_finance_document fd ON fd.id = i.document_id
 INNER JOIN warehouse_move sto ON sto.owner_id = fd.id
 LEFT JOIN partner_move prt ON prt.owner_id = fd.id
 INNER JOIN document_type t ON t.id = fd.document_type_id  AND t.document_section = 'GOODS'
 INNER JOIN finance_document_type ft ON t.id = ft.document_type_id 
  AND (ft.move_type = 'OUTPUT' OR (ft.move_type = 'ROTATE' AND sto.move_type = 'OUTPUT'));
 



CREATE VIEW v_rpt_goods_rotate (
 organization_id,
 period_id, 
 product_id, 
 rest_quantity,
 rest_amount, 
 credit_quantity,
 credit_amount,
 debit_quantity,
 debit_amount
) AS
SELECT r.organization_id, r.period_id, 
 r.product_id, r.quantity as rest_quantity, r.amount as rest_amount, 
 0.0 as credit_quantity, 0.0 as credit_amount,
 0.0 as debit_quantity, 0.0 as debit_amount 
 FROM v_rpt_goods_rest_start r
UNION ALL 
SELECT d.organization_id, d.period_id, 
 d.product_id, 0.0 as rest_quantity, 0.0 as rest_amount, 
 d.quantity as credit_quantity, d.amount as credit_amount,
 0.0 as debit_quantity, 0.0 as debit_amount
 FROM v_goods_credit_full d
UNION ALL 
SELECT c.organization_id, c.period_id, 
 c.product_id, 0.0 as rest_quantity, 0.0 as rest_amount, 
 0.0 as credit_quantity, 0.0 as credit_amount,
 c.quantity as debit_quantity, c.amount as debit_amount
 FROM v_goods_debit_full c;

CREATE VIEW v_partner_rest (
 id,
 period_id,
 organization_id,
 partner_id,
 debit_amount,
 credit_amount
) AS
SELECT
 id,
 period_id,
 organization_id,
 partner_id,
 debit_amount,
 credit_amount
FROM
 partner_rest;

CREATE VIEW v_rpt_partner_register (
  period_id,
  organization_id,
  partner_id,
  partner_name,
  debit_amount,
  credit_amount
) AS
SELECT 
  r.period_id,
  r.organization_id,
  r.partner_id,
  p.name as partner_name,
  r.debit_amount,
  r.credit_amount
 FROM v_partner_register r
 INNER JOIN partner p ON p.id = r.partner_id;

CREATE VIEW v_rpt_partner_rest (
  period_id,
  organization_id,
  partner_id,
  partner_name,
  debit_amount,
  credit_amount
) AS
SELECT 
  r.period_id,
  r.organization_id,
  r.partner_id,
  p.name as partner_name,
  r.debit_amount,
  r.credit_amount
 FROM v_partner_rest r
 INNER JOIN partner p ON p.id = r.partner_id;

CREATE VIEW v_rpt_partner_rest_start (
  period_id,
  organization_id,
  partner_id,
  partner_name,
  credit_amount,
  debit_amount
) AS
SELECT 
  r.period_id,
  r.organization_id,
  r.partner_id,
  r.partner_name,
  r.credit_amount,
  r.debit_amount
 FROM v_rpt_partner_register r
UNION ALL
SELECT 
  r.period_id,
  r.organization_id,
  r.partner_id,
  r.partner_name,
  r.credit_amount,
  r.debit_amount
 FROM v_rpt_partner_rest r;

CREATE VIEW v_rpt_partner_credit_full (
  period_id,
  organization_id,
  document_code,
  document_date,
  partner_id,
  amount
) AS
SELECT 
  fd.period_id,
  fd.organization_id,
  fd.document_code,
  fd.document_date,
  p.partner_id,
  fd.document_total
 FROM v_finance_document fd
 INNER JOIN v_partner_move p ON fd.id = p.document_id
 INNER JOIN document_type t ON t.id = fd.document_type_id
 INNER JOIN finance_document_type ft ON t.id = ft.document_type_id 
 WHERE t.document_section = 'PAYMENT' AND ft.move_type = 'INPUT';


CREATE VIEW v_rpt_partner_debit_full (
  period_id,
  organization_id,
  document_code,
  document_date,
  partner_id,
  amount
) AS
SELECT 
  fd.period_id,
  fd.organization_id,
  fd.document_code,
  fd.document_date,
  p.partner_id,
  fd.document_total
 FROM v_finance_document fd
 INNER JOIN v_partner_move p ON fd.id = p.document_id
 INNER JOIN document_type t ON t.id = fd.document_type_id
 INNER JOIN finance_document_type ft ON t.id = ft.document_type_id 
 WHERE t.document_section = 'PAYMENT' AND ft.move_type = 'OUTPUT';


CREATE VIEW v_rpt_partner_rotate (
 organization_id,
 period_id, 
 partner_id,
 rest_credit_amount, 
 rest_debit_amount, 
 credit_amount,
 debit_amount
) AS
SELECT 
 r.organization_id,
 r.period_id, 
 r.partner_id,
 r.credit_amount as rest_credit_amount, 
 r.debit_amount as rest_debit_amount, 
 0.0 as credit_amount,
 0.0 as debit_amount
FROM v_rpt_partner_rest_start r
UNION ALL 
SELECT 
 c.organization_id,
 c.period_id, 
 c.partner_id,
 0.0 as rest_credit_amount, 
 0.0 as rest_debit_amount, 
 c.amount as credit_amount,
 0.0 as debit_amount
FROM v_rpt_partner_credit_full c
UNION ALL 
SELECT 
 d.organization_id,
 d.period_id, 
 d.partner_id,
 0.0 as rest_credit_amount, 
 0.0 as rest_debit_amount, 
 0.0 as credit_amount,
 d.amount as debit_amount
 FROM v_rpt_partner_debit_full d;

create view V_EMPLOYEE_RESULT (
 ID,
 EMPLOYEE_ID,
 EMPLOYEE_TOTAL_ID,
 ORGANIZATION_ID,
 PERIOD_ID,
 WORK_DAY,
 WORK_HOUR,
 TOTAL_DAY,
 TOTAL_HOUR,
 START_BALANCE,
 END_BALANCE,
 INCREMENT_AMOUNT,
 DECREMENT_AMOUNT,
 payroll_AMOUNT,
 ACU_PENSION,
 ACU_TAX,
 ACU_VACATION,
 ACU_SICK,
 ACU_FUND_SALARY,
 ACU_FUND_HELP,
 ACU_FUND_INSURANCE,
 ACU_FUND_WORK,
 ACU_SALARY13,
 ACU_SALARY12,
 ACU_ADD_PAY,
 OVERTIME_DAY,
 OVERTIME_HOUR,
 NIGHT_DAY,
 NIGHT_HOUR,
 HOLIDAY_DAY,
 HOLIDAY_HOUR,
 PREV_VACATION_AMOUNT,
 PREV_SICK_AMOUNT
) AS
select 
 E.ID,
 E.ID AS EMPLOYEE_ID,
 T.ID AS EMPLOYEE_TOTAL_ID,
 E.ORGANIZATION_ID,
 T.PERIOD_ID,
 T.WORK_DAY,
 T.WORK_HOUR,
 T.TOTAL_DAY,
 T.TOTAL_HOUR,
 T.START_BALANCE,
 T.END_BALANCE,
 T.INCREMENT_AMOUNT,
 T.DECREMENT_AMOUNT,
 T.payroll_AMOUNT,
 T.ACU_PENSION,
 T.ACU_TAX,
 T.ACU_VACATION,
 T.ACU_SICK,
 T.ACU_FUND_SALARY,
 T.ACU_FUND_HELP,
 T.ACU_FUND_INSURANCE,
 T.ACU_FUND_WORK,
 T.ACU_SALARY13,
 T.ACU_SALARY12,
 T.ACU_ADD_PAY,
 T.OVERTIME_DAY,
 T.OVERTIME_HOUR,
 T.NIGHT_DAY,
 T.NIGHT_HOUR,
 T.HOLIDAY_DAY,
 T.HOLIDAY_HOUR,
 T.PREV_VACATION_AMOUNT,
 T.PREV_SICK_AMOUNT
from EMPLOYEE E left join EMPLOYEE_TOTAL T ON T.EMPLOYEE_ID = E.ID;

CREATE VIEW v_ledger_account_rest (
 id,
 period_id,
 organization_id,
 ledger_account_id,
 debit_amount,
 credit_amount
) AS
SELECT
 id,
 period_id,
 organization_id,
 ledger_account_id,
 debit_amount,
 credit_amount
FROM
 ledger_account_rest;

CREATE VIEW v_ledger_account_register (
 id,
 organization_id,
 period_id,
 ledger_account_id,
 debit_amount,
 credit_amount
) AS 
SELECT 
 r.id,
 r.organization_id,
 r.period_id,
 r.ledger_account_id,
 r.debit_amount,
 r.credit_amount
 FROM ledger_account_register r;


CREATE VIEW v_rpt_ldg_account_rest (
  period_id,
  organization_id,
  ledger_account_id,
  ledger_account_code,
  ledger_account_name,
  debit_amount,
  credit_amount
) AS
SELECT 
  r.period_id,
  r.organization_id,
  r.ledger_account_id,
  a.code as ledger_account_code,
  a.name as ledger_account_name,
  r.debit_amount,
  r.credit_amount
 FROM v_ledger_account_rest r
 INNER JOIN ledger_account a ON a.id = r.ledger_account_id;

CREATE VIEW v_rpt_ldg_account_register (
  period_id,
  organization_id,
  ledger_account_id,
ledger_account_code,
  ledger_account_name,
  debit_amount,
  credit_amount
) AS
SELECT 
  r.period_id,
  r.organization_id,
  r.ledger_account_id,
  a.code as ledger_account_code,
  a.name as ledger_account_name,
  r.debit_amount,
  r.credit_amount
 FROM v_ledger_account_register r
 INNER JOIN ledger_account a ON a.id = r.ledger_account_id;

CREATE VIEW v_rpt_ldg_account_rest_start (
  period_id,
  organization_id,
  ledger_account_id,
  ledger_account_code,
  ledger_account_name,
  credit_amount,
  debit_amount
) AS
SELECT 
  r.period_id,
  r.organization_id,
  r.ledger_account_id,
  r.ledger_account_code,
  r.ledger_account_name,
  r.credit_amount,
  r.debit_amount
 FROM v_rpt_ldg_account_register r
UNION ALL
SELECT 
  r.period_id,
  r.organization_id,
  r.ledger_account_id,
  r.ledger_account_code,
  r.ledger_account_name,
  r.credit_amount,
  r.debit_amount
 FROM v_rpt_ldg_account_rest r;

CREATE VIEW v_rpt_ldg_account_credit_full (
  period_id,
  organization_id,
  document_code,
  document_date,
  ledger_account_id,
  corr_ledger_account_id,
  amount
) AS
SELECT 
  fd.period_id,
  fd.organization_id,
  fd.document_code,
  fd.document_date,
  i.debit_ledger_account_id,
  i.credit_ledger_account_id,
  i.amount
 FROM v_finance_document fd
 INNER JOIN entry_item i ON i.owner_id = fd.id;


CREATE VIEW v_rpt_ldg_account_debit_full (
  period_id,
  organization_id,
  document_code,
  document_date,
  ledger_account_id,
  corr_ledger_account_id,
  amount
) AS
SELECT 
  fd.period_id,
  fd.organization_id,
  fd.document_code,
  fd.document_date,
  i.credit_ledger_account_id,
  i.debit_ledger_account_id,
  i.amount
 FROM v_finance_document fd
 INNER JOIN entry_item i ON i.owner_id = fd.id;


CREATE VIEW v_rpt_ldg_account_rotate (
 organization_id,
 period_id, 
 ledger_account_id,
 rest_credit_amount, 
 rest_debit_amount, 
 credit_amount,
 debit_amount
) AS
SELECT 
 r.organization_id,
 r.period_id, 
 r.ledger_account_id,
 r.credit_amount as rest_credit_amount, 
 r.debit_amount as rest_debit_amount, 
 0.0 as credit_amount,
 0.0 as debit_amount
FROM v_rpt_ldg_account_rest_start r
UNION ALL 
SELECT 
 c.organization_id,
 c.period_id, 
 c.ledger_account_id,
 0.0 as rest_credit_amount, 
 0.0 as rest_debit_amount, 
 c.amount as credit_amount,
 0.0 as debit_amount
FROM v_rpt_ldg_account_credit_full c
UNION ALL 
SELECT 
 d.organization_id,
 d.period_id, 
 d.ledger_account_id,
 0.0 as rest_credit_amount, 
 0.0 as rest_debit_amount, 
 0.0 as credit_amount,
 d.amount as debit_amount
 FROM v_rpt_ldg_account_debit_full d;

CREATE VIEW v_rpt_ldg_account_all (
 organization_id,
 period_id, 
 ledger_account_id
) AS
SELECT 
 r.organization_id,
 r.period_id, 
 r.ledger_account_id
FROM v_rpt_ldg_account_rest_start r
UNION 
SELECT 
 c.organization_id,
 c.period_id, 
 c.ledger_account_id
FROM v_rpt_ldg_account_credit_full c
UNION 
SELECT 
 d.organization_id,
 d.period_id, 
 d.ledger_account_id
 FROM v_rpt_ldg_account_debit_full d;

CREATE VIEW v_rpt_ldg_account_corr (
 organization_id,
 period_id, 
 operation_type,
 ledger_account_id,
 corr_ledger_account_id,
 amount,
 balance_amount
) AS
SELECT 
 c.organization_id,
 c.period_id, 
 1 as operation_type,
 c.ledger_account_id,
 c.corr_ledger_account_id,
 c.amount,
 c.amount
FROM v_rpt_ldg_account_credit_full c
UNION ALL 
SELECT 
 d.organization_id,
 d.period_id, 
 2 as operation_type,
 d.ledger_account_id,
 d.corr_ledger_account_id,
 d.amount,
 d.amount * -1
 FROM v_rpt_ldg_account_debit_full d;

/*                                                       */
/*   PostgreSQL implementation                           */
/*                                                       */
/*   Use functions:                                      */
/*                                                       */
/*   TO_NUMBER(TO_CHAR(document_date, 'YYYY'), '9999')   */
/*   TO_NUMBER(TO_CHAR(document_date, 'MM'), '99')       */
/*                                                       */


CREATE VIEW v_project_date (
  id,
  organization_id,
  start_date,
  end_date,
  actual_end_date,
  start_year,
  end_year,
  actual_end_year,
  start_month,
  end_month,
  actual_end_month,
  start_day,
  end_day,
  actual_end_day
) AS
SELECT
  p.id,
  p.organization_id,
  p.start_date,
  p.end_date,
  p.actual_end_date,
  TO_NUMBER(TO_CHAR(p.start_date, 'YYYY'), '9999'),
  TO_NUMBER(TO_CHAR(p.end_date, 'YYYY'), '9999'),
  TO_NUMBER(TO_CHAR(p.actual_end_date, 'YYYY'), '9999'),
  TO_NUMBER(TO_CHAR(p.start_date, 'MM'), '99'),
  TO_NUMBER(TO_CHAR(p.end_date, 'MM'), '99'),
  TO_NUMBER(TO_CHAR(p.actual_end_date, 'MM'), '99'),
  TO_NUMBER(TO_CHAR(p.start_date, 'DD'), '99'),
  TO_NUMBER(TO_CHAR(p.end_date, 'DD'), '99'),
  TO_NUMBER(TO_CHAR(p.actual_end_date, 'DD'), '99')
FROM project p;


CREATE VIEW v_project_date_ext (
  id,
  organization_id,
  start_date,
  end_date,
  actual_end_date,
  start_year,
  end_year,
  actual_end_year,
  start_month,
  end_month,
  actual_end_month,
  start_day,
  end_day,
  actual_end_day,
  start_day_pos,
  end_day_pos,
  actual_end_day_pos
) AS
SELECT
  p.id,
  p.organization_id,
  p.start_date,
  p.end_date,
  p.actual_end_date,
  p.start_year,
  p.end_year,
  p.actual_end_year,
  p.start_month,
  p.end_month,
  p.actual_end_month,
  p.start_day,
  p.end_day,
  p.actual_end_day,
  p.start_year * 10000 + p.start_month * 100 + p.start_day,
  p.end_year * 10000 + p.end_month * 100 + p.end_day,
  p.actual_end_year * 10000 + p.actual_end_month * 100 + p.actual_end_day
FROM v_project_date p;


CREATE VIEW v_project_year_unique (
  organization_id,
  project_year
) AS
SELECT
  organization_id,
  start_year
FROM v_project_date WHERE start_year IS NOT NULL
UNION 
SELECT
  organization_id,
  end_year
FROM v_project_date  WHERE end_year IS NOT NULL
UNION 
SELECT
  organization_id,
  actual_end_year
FROM v_project_date  WHERE actual_end_year IS NOT NULL;




CREATE VIEW v_project_year_unique_inf (
  organization_id,
  project_year,
  flag_year
) AS
SELECT
  organization_id,
  project_year,
  0
FROM v_project_year_unique WHERE (project_year/4.00 - project_year/4) <> 0
UNION ALL
SELECT
  organization_id,
  project_year,
  1
FROM v_project_year_unique WHERE (project_year/4.00 - project_year/4) = 0;








CREATE VIEW v_project_period_day (
 organization_id,
 year_number,
 month_number,
 month_name,
 day_number,
 day_pos
) AS
SELECT
 py.organization_id,
 py.project_year as year_number,
 sm.month_number,
 sm.name as month_name,
 sd.day_number,
 py.project_year * 10000 + sm.month_number * 100 + sd.day_number
FROM v_project_year_unique_inf py, system_month sm, system_day sd
 WHERE (sd.day_number <= (sm.day_count + py.flag_year));






