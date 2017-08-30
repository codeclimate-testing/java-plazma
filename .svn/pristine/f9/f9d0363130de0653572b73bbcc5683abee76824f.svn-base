

/*==============================================================*/
/* 2010-06-12                                                   */
/*==============================================================*/


create table SYS_USER (
 ID                   INTEGER                        not null,
 ENTITY_ID            CHAR(30),
 USER_NAME            VARCHAR(64)                    not null,
 USER_PASSWORD        VARCHAR(64)                    not null,
 OWNER_ID             INTEGER,
 REGISTRATION_DATE    DATE                           not null,
 NAME                 VARCHAR(50),
 DEFAULT_UI_ID        CHAR(30),
 IS_ENABLE            CHAR(1)                        default 'Y' not null,
 constraint PK_SYS_USER primary key (ID)
);



create table SYS_PROPERTY (
 ID                   INTEGER                        not null,
 PROPERTY_NAME        VARCHAR(50)                    not null,
 PROPERTY_VALUE       VARCHAR(255),
 constraint PK_SYS_PROPERTY primary key (ID)
);


/* CODE column */

create table FAMILY_STATUS (
 ID                   INTEGER                        not null,
 CODE                 VARCHAR(10),
 NAME                 VARCHAR(50),
 constraint PK_FAMILY_STATUS primary key (ID)
);


create table LEDGER_ACCOUNT_TYPE (
 ID                   INTEGER                        not null,
 CODE                 VARCHAR(3)                     not null,
 NAME                 VARCHAR(50)                    not null,
 constraint PK_LEDGER_ACCOUNT_TYPE primary key (ID)
);

create table MILITARY_RANK (
 ID                   INTEGER                        not null,
 CODE                 VARCHAR(10),
 NAME                 VARCHAR(150),
 constraint PK_MILITARY_RANK primary key (ID)
);

create table MILITARY_SPECIALITY (
 ID                   INTEGER                        not null,
 CODE                 VARCHAR(10),
 NAME                 VARCHAR(50),
 constraint PK_MILITARY_SPECIALITY primary key (ID)
);

create table MILITARY_STATUS (
 ID                   INTEGER                        not null,
 CODE                 VARCHAR(10),
 NAME                 VARCHAR(50),
 constraint PK_MILITARY_STATUS primary key (ID)
);


create table SPECIALITY (
 ID                   INTEGER                        not null,
 CODE                 VARCHAR(10),
 NAME                 VARCHAR(150),
 PARENT_ID            INTEGER,
 constraint PK_SPECIALITY primary key (ID)
);


/*==============================================================*/
/* 2010-06-20                                                   */
/*==============================================================*/

/* SYS_VARIABLE.ENTITY_ID -> VALUE_ENTITY_ID */

alter table SYS_ATTR
 add VALUE_ENTITY_ID VARCHAR(30);


/*
SYS_VARIABLE.CODE VARCHAR(20) -> VARCHAR(30)

SYS_ATTR.CODE VARCHAR(20) -> VARCHAR(30)

SYS_ATTR_GROUP.CODE VARCHAR(20) -> VARCHAR(30)
*/


drop table DOCUMENT_ATTR_VALUE;

drop table DOCUMENT_ATTR;

drop table DOCUMENT_ATTR_GROUP;



UPDATE SYS_ENTITY SET IS_CUSTOM_ATTRIBUTE = 'Y' WHERE ENTITY_TYPE_ID = 'DOCUMENT';


UPDATE SYS_ENTITY SET IS_BASE = 'Y' WHERE ID = 'BANK_ACCOUNT';


/*==============================================================*/
/* 2010-12-16 (NEW*)                                             */
/*==============================================================*/

UPDATE SYS_ENTITY SET ENTITY_PACKAGE = 'CONTACT' WHERE ID = 'CONTACT';


/*==============================================================*/
/* 2010-12-18                                                   */
/*==============================================================*/

/* CONTACT */

ALTER TABLE CONTACT
 ADD TITLE_NAME VARCHAR(30);

UPDATE CONTACT SET TITLE_NAME = DEAR;

ALTER TABLE CONTACT
 DROP DEAR;



ALTER TABLE CONTACT
 ADD TMP_NAME VARCHAR(100);

UPDATE CONTACT SET TMP_NAME = NAME;

ALTER TABLE CONTACT
 DROP NAME;

ALTER TABLE CONTACT
 ADD NAME VARCHAR(100);

UPDATE CONTACT SET NAME = TMP_NAME;

ALTER TABLE CONTACT
 DROP TMP_NAME;



ALTER TABLE CONTACT
 ADD TMP_NAME_EN VARCHAR(100);

UPDATE CONTACT SET TMP_NAME_EN = NAME_EN;

ALTER TABLE CONTACT
 DROP NAME_EN;

ALTER TABLE CONTACT
 ADD NAME_EN VARCHAR(100);

UPDATE CONTACT SET NAME_EN = TMP_NAME_EN;

ALTER TABLE CONTACT
 DROP TMP_NAME_EN;



ALTER TABLE CONTACT
 ADD GENDER INTEGER default 1 not null;

UPDATE CONTACT SET GENDER = SEX;

ALTER TABLE CONTACT
 DROP SEX;



ALTER TABLE CONTACT
 ADD FIRST_NAME VARCHAR(50);

ALTER TABLE CONTACT
 ADD MIDDLE_NAME VARCHAR(50);

ALTER TABLE CONTACT
 ADD LAST_NAME VARCHAR(50);

ALTER TABLE CONTACT
 ADD SUFFIX_NAME VARCHAR(10);

ALTER TABLE CONTACT
 ADD BIRTH_DATE DATE;



/* PERSON_CARD */

ALTER TABLE PERSON_CARD
 ADD GENDER INTEGER default 1 not null;

UPDATE PERSON_CARD SET GENDER = SEX;

ALTER TABLE PERSON_CARD
 DROP SEX;



/* PHONE */

ALTER TABLE PHONE
 ADD PHONE_EXT VARCHAR(6);



/* PHONE_TYPE */

ALTER TABLE PHONE_TYPE
 ADD TMP_CODE VARCHAR(20);

UPDATE PHONE_TYPE SET TMP_CODE = CODE;

ALTER TABLE PHONE_TYPE
 DROP CODE;

ALTER TABLE PHONE_TYPE
 ADD CODE VARCHAR(20);

UPDATE PHONE_TYPE SET CODE = TMP_CODE;

ALTER TABLE PHONE_TYPE
 DROP TMP_CODE;



/* ADDRESS_TYPE */

ALTER TABLE ADDRESS_TYPE
 ADD TMP_CODE VARCHAR(20);

UPDATE ADDRESS_TYPE SET TMP_CODE = CODE;

ALTER TABLE ADDRESS_TYPE
 DROP CODE;

ALTER TABLE ADDRESS_TYPE
 ADD CODE VARCHAR(20);

UPDATE ADDRESS_TYPE SET CODE = TMP_CODE;

ALTER TABLE ADDRESS_TYPE
 DROP TMP_CODE;


/*==============================================================*/
/* 2010-12-20                                                   */
/*==============================================================*/


DROP TABLE DRUGSTORE;

DROP TABLE SHOP;

DROP TABLE BRIGADE;

DROP TABLE WORKSHOP;

DROP TABLE FACTORY;

DROP TABLE WORKS;



ALTER TABLE BUSINESSABLE
 DROP BRANCH_ID;

ALTER TABLE BUSINESSABLE_REGISTER
 DROP BRANCH_ID;

ALTER TABLE DEPARTMENT
 DROP BRANCH_ID;

ALTER TABLE DOCUMENT
 DROP BRANCH_ID;

ALTER TABLE EMPLOYEE
 DROP BRANCH_ID;

ALTER TABLE EMPLOYEE_PAYROLL
 DROP BRANCH_ID;

ALTER TABLE PROJECT
 DROP BRANCH_ID;

ALTER TABLE RESPONSIBLE
 DROP BRANCH_ID;

ALTER TABLE STORE
 DROP BRANCH_ID;

ALTER TABLE SYS_INFO
 DROP BRANCH_ID;

ALTER TABLE TASK
 DROP BRANCH_ID;



DROP TABLE BRANCH;

DROP TABLE BRANCH_DOCUMENT_TYPE;

DROP TABLE PARTNER_REPRESENTATIVE;



DELETE FROM BUSINESSABLE_ENTITY WHERE ENTITY_ID IN ('BRIGADE', 'DRUGSTORE', 'FACTORY', 'SHOP', 'WORKS', 'WORKSHOP');

DELETE FROM WAREHOUSE_ENTITY WHERE ENTITY_ID IN ('BRIGADE', 'DRUGSTORE', 'FACTORY', 'SHOP', 'WORKS', 'WORKSHOP');

DELETE FROM SYS_ENTITY WHERE ID IN ('BRIGADE', 'DRUGSTORE', 'FACTORY', 'SHOP', 'WORKS', 'WORKSHOP');


/*==============================================================*/
/* 2011-01-12 (MyPlazma)                                        */
/*==============================================================*/

/* 
SYS_VARIABLE.CODE VARCHAR(50) -> VARCHAR(50)
SYS_VARIABLE.NAME VARCHAR(50) -> VARCHAR(100)
SYS_VARIABLE Add DESCRIPTION     VARCHAR(255)
*/


create table TMP_SYS_VARIABLE (
ID                   INTEGER                        not null,
DATA_TYPE_ID         CHAR(30)                       not null,
VALUE_ENTITY_ID      CHAR(30),
CODE                 VARCHAR(30)                    not null,
NAME                 VARCHAR(50)                    not null,
STRING_VALUE         VARCHAR(255),
INTEGER_VALUE        INTEGER,
FLOAT_VALUE          FLOAT,
DATE_VALUE           DATE,
IS_ENABLE            CHAR(1)                        default 'Y' not null,
IS_SYSTEM            CHAR(1)                        default 'N' not null
);

INSERT INTO TMP_SYS_VARIABLE (ID, DATA_TYPE_ID, VALUE_ENTITY_ID, CODE, NAME, STRING_VALUE, INTEGER_VALUE, FLOAT_VALUE, DATE_VALUE, IS_ENABLE, IS_SYSTEM) 
 SELECT ID, DATA_TYPE_ID, VALUE_ENTITY_ID, CODE, NAME, STRING_VALUE, INTEGER_VALUE, FLOAT_VALUE, DATE_VALUE, IS_ENABLE, IS_SYSTEM FROM SYS_VARIABLE;

DROP TABLE SYS_VARIABLE;

create table SYS_VARIABLE (
ID                   INTEGER                        not null,
DATA_TYPE_ID         CHAR(30)                       not null,
VALUE_ENTITY_ID      CHAR(30),
CODE                 VARCHAR(50)                    not null,
NAME                 VARCHAR(100)                    not null,
DESCRIPTION          VARCHAR(255),
STRING_VALUE         VARCHAR(255),
INTEGER_VALUE        INTEGER,
FLOAT_VALUE          FLOAT,
DATE_VALUE           DATE,
IS_ENABLE            CHAR(1)                        default 'Y' not null,
IS_SYSTEM            CHAR(1)                        default 'N' not null,
constraint PK_SYS_VARIABLE primary key (ID)
);

INSERT INTO SYS_VARIABLE (ID, DATA_TYPE_ID, VALUE_ENTITY_ID, CODE, NAME, STRING_VALUE, INTEGER_VALUE, FLOAT_VALUE, DATE_VALUE, IS_ENABLE, IS_SYSTEM) 
 SELECT ID, DATA_TYPE_ID, VALUE_ENTITY_ID, CODE, NAME, STRING_VALUE, INTEGER_VALUE, FLOAT_VALUE, DATE_VALUE, IS_ENABLE, IS_SYSTEM FROM TMP_SYS_VARIABLE;

DROP TABLE TMP_SYS_VARIABLE;




/*==============================================================*/
/* 2011-01-22                                                   */
/*==============================================================*/

ALTER TABLE CONTACT 
 ADD IMAGE_FILE_NAME VARCHAR(50);
 
/* 
def_contact_type_id = 1
def_organization_id = 1
def_responsible_id = 1113 (EMPLOYEE)
*/

INSERT INTO CONTACT (ID, CONTACT_TYPE_ID, ORGANIZATION_ID, RESPONSIBLE_ID, NAME, FIRST_NAME, MIDDLE_NAME, LAST_NAME, IMAGE_FILE_NAME, GENDER, BIRTH_DATE)

SELECT P.ID, {def_contact_type_id}, {def_organization_id}, {def_responsible_id}, P.NAME, P.FIRST_NAME, P.MIDDLE_NAME, P.LAST_NAME, P.IMAGE_FILE_NAME, C.GENDER, C.BIRTH_DATE
 FROM PERSON P
 INNER JOIN PERSON_CARD C ON P.ID = C.PERSON_ID
 
ALTER TABLE PERSON
 DROP NAME;

ALTER TABLE PERSON
 DROP FIRST_NAME;
 
ALTER TABLE PERSON
 DROP MIDDLE_NAME;
 
ALTER TABLE PERSON
 DROP LAST_NAME;
 
ALTER TABLE PERSON
 DROP IMAGE_FILE_NAME;
 


ALTER TABLE PERSON_CARD
 DROP GENDER;

ALTER TABLE PERSON_CARD
 DROP BIRTH_DATE;


/* Must copy datastorage/person/image*.* to datastorage/contact  */

/* Only for Manual mode                                          */
/*
alter table CONTACT
   drop constraint FK_CONTACT_RESPONSIB_EMPLOYEE;


alter table CONTACT
 add TMP_RESPONSIBLE_ID INTEGER;
 
UPDATE CONTACT SET TMP_RESPONSIBLE_ID = RESPONSIBLE_ID;

alter table CONTACT
 drop RESPONSIBLE_ID;
 
alter table CONTACT
 add RESPONSIBLE_ID INTEGER; 
 
UPDATE CONTACT SET RESPONSIBLE_ID = TMP_RESPONSIBLE_ID; 
 
alter table CONTACT
   add constraint FK_CONTACT_RESPONSIB_EMPLOYEE foreign key (RESPONSIBLE_ID)
      references CONTACT (ID);
*/


/*
 TODO: SET CONTACT.RESPONSIBLE_ID = CONTACT.RESPONSIBLE_ID (EMPLOYEE) -> PERSON_ID
 Solution 1: Recreate CONTACT: RESPONSIBLE_ID NULL VALUE, RESPONSIBLE_ID = EMPLOYEE.PERSON_ID 
*/



ALTER TABLE SYS_USER
 ADD CONTACT_ID INTEGER; /* FK */



ALTER TABLE PARTNER
 ADD RESPONSIBLE_ID INTEGER; /* FK */

ALTER TABLE PARTNER
 ADD CONTACT_ID INTEGER; /* FK */



/* PROJECT.RESPONSIBLE_ID - Recreate constraint */

/* PROJECT_CONTEXT.RESPONSIBLE_ID - Recreate constraint */

/* TASK_CONTEXT.RESPONSIBLE_ID - Recreate constraint */

/* SYS_INFO.RESPONSIBLE_ID - Recreate constraint */




ALTER TABLE TASK 
 DROP REAL_WORK;


ALTER TABLE TASK 
 ADD WORK_DAYS INTEGER default 0 not null;

ALTER TABLE TASK 
 ADD WORK_HOURS INTEGER default 0 not null;

ALTER TABLE TASK 
 ADD WORK_MINUTES INTEGER default 0 not null;


ALTER TABLE TASK 
 ADD ACTUAL_DAYS INTEGER default 0 not null;

ALTER TABLE TASK 
 ADD ACTUAL_HOURS INTEGER default 0 not null;

ALTER TABLE TASK 
 ADD ACTUAL_MINUTES INTEGER default 0 not null;

ALTER TABLE TASK 
 ADD WORK_COST NUMERIC(15,2) default 0 not null;



ALTER TABLE TASK 
 ADD PROJECT_STAGE_ID INTEGER; /* FK */


DROP TABLE PROJECT_EMPLOYEE_LINK;

create table TASK_WORKER_LINK (
ID                   INTEGER                        not null,
TASK_ID              INTEGER                        not null,
WORKER_ID            INTEGER                        not null,
WORK_DAYS            INTEGER                        default 0 not null,
WORK_HOURS           INTEGER                        default 0 not null,
WORK_MINUTES         INTEGER                        default 0 not null,
ACTUAL_DAYS          INTEGER                        default 0 not null,
ACTUAL_HOURS         INTEGER                        default 0 not null,
ACTUAL_MINUTES       INTEGER                        default 0 not null,
WORK_COST            NUMERIC(15,2)                  default 0 not null,
DESCRIPTION          VARCHAR(255),
constraint PK_TASK_WORKER_LINK primary key (ID)
);

INSERT INTO TASK_WORKER_LINK (ID, TASK_ID, WORKER_ID, DESCRIPTION) SELECT T.ID, T.TASK_ID, P.ID, T.DESCRIPTION FROM TASK_EMPLOYEE_LINK T INNER JOIN PERSON P ON P.ID = T.EMPLOYEE_ID;

DROP TABLE TASK_EMPLOYEE_LINK;

ALTER TABLE CONTACT
 ADD IS_EMPLOYEE CHAR(1) default 'N';

ALTER TABLE CONTACT
 ADD IS_EMPLOYEE_LINK CHAR(1) default 'N';

ALTER TABLE CONTACT
 ADD IS_HARD_LINK CHAR(1) default 'N';



ALTER TABLE RESPONSIBLE
 ADD CONTACT_ID INTEGER; /* FK */


/*
 TODO: SET RESPONSIBLE.CONTACT_ID = RESPONSIBLE.EMPLOYEE.PERSON_ID
*/

ALTER TABLE RESPONSIBLE
 DROP EMPLOYEE_ID;


/*==============================================================*/
/* 2011-02-06                                                   */
/*==============================================================*/

ALTER TABLE PROJECT_STATUS
 DROP COLOR;

ALTER TABLE PROJECT_STATUS
 ADD COLOR CHAR(6);



ALTER TABLE TASK_STATUS
 DROP COLOR;

ALTER TABLE TASK_STATUS
 ADD COLOR CHAR(6);




ALTER TABLE PROJECT
 ADD TMP_START_DATE DATE;

UPDATE TMP_START_DATE = START_DATE;

ALTER TABLE PROJECT
 DROP START_DATE;

ALTER TABLE PROJECT
 ADD START_DATE DATE;

UPDATE START_DATE = TMP_START_DATE;

ALTER TABLE PROJECT
 DROP TMP_START_DATE;



ALTER TABLE TASK
 ADD TMP_START_DATE_TIME DATE;

UPDATE TMP_START_DATE_TIME = START_DATE_TIME;

ALTER TABLE TASK
 DROP START_DATE_TIME;

ALTER TABLE TASK
 ADD START_DATE_TIME DATE;

UPDATE START_DATE_TIME = TMP_START_DATE_TIME;

ALTER TABLE TASK
 DROP TMP_START_DATE_TIME;



ALTER TABLE PROJECT_TYPE
 ADD IS_SYSTEM CHAR(1) default 'N' NOT NULL;

ALTER TABLE TASK_TYPE
 ADD IS_SYSTEM CHAR(1) default 'N' NOT NULL;

ALTER TABLE PROJECT_STATUS
 ADD IS_SYSTEM CHAR(1) default 'N' NOT NULL;

ALTER TABLE TASK_STATUS
 ADD IS_SYSTEM CHAR(1) default 'N' NOT NULL;

ALTER TABLE DOCUMENT_STATUS
 ADD IS_SYSTEM CHAR(1) default 'N' NOT NULL;

ALTER TABLE TASK_PRIORITY
 ADD IS_SYSTEM CHAR(1) default 'N' NOT NULL;



ALTER TABLE TASK
 ADD REPORTER_ID INTEGER NOT NULL;

UPDATE TASK SET REPORTER_ID = RESPONSIBLE_ID;


ALTER TABLE PRODUCT
 ADD RESPONSIBLE_ID INTEGER;


/*==============================================================*/
/* 2011-03-26                                                   */
/*==============================================================*/

DROP TABLE DOCUMENT_TYPE_ITEM;

create table DOCUMENT_RELATION (
ID                   INTEGER                        not null,
CHILD_TYPE_ID        INTEGER                        not null,
PARENT_TYPE_ID       INTEGER                        not null,
CREATOR_TYPE         VARCHAR(50),
CREATOR_CLASS        VARCHAR(128),
constraint PK_DOCUMENT_RELATION primary key (ID)
);


/* SALE_ORDER */
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (1, 14, 12,'org.plazmaforge.bsolution.product.common.DefaultProductDocumentCreator');
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (2, 14, 6, 'org.plazmaforge.bsolution.bank.common.DefaultPaymentDocumentCreator');	
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (3, 14, 3, 'org.plazmaforge.bsolution.product.common.DefaultWarehouseProductDocumentCreator');
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (4, 14, 16,'org.plazmaforge.bsolution.product.common.DefaultProductDocumentCreator');	
	
/* SALE_INVOICE */
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (10, 12, 3, 'org.plazmaforge.bsolution.product.common.OutcomeWarehouseProductDocumentCreator');
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (11, 12, 16,'org.plazmaforge.bsolution.product.common.DefaultProductDocumentCreator');
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (12, 12, 6, 'org.plazmaforge.bsolution.bank.common.DefaultPaymentDocumentCreator');
	
/* PURCHASE_ORDER */
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (20, 15, 22,'org.plazmaforge.bsolution.product.common.DefaultProductDocumentCreator');
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (21, 15, 7, 'org.plazmaforge.bsolution.bank.common.DefaultPaymentDocumentCreator');	
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (22, 15, 2, 'org.plazmaforge.bsolution.product.common.DefaultWarehouseProductDocumentCreator');
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (23, 15, 24,'org.plazmaforge.bsolution.product.common.DefaultProductDocumentCreator');	
	
/* PURCHASE_INVOICE */
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (30, 22, 2, 'org.plazmaforge.bsolution.product.common.IncomeWarehouseProductDocumentCreator');
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (31, 22, 24,'org.plazmaforge.bsolution.product.common.DefaultProductDocumentCreator');
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (32, 22, 7, 'org.plazmaforge.bsolution.bank.common.DefaultPaymentDocumentCreator');

/*==============================================================*/
/* 2011-05-01                                                   */
/*==============================================================*/

/* BANK.STOPPED_PERCENT */
ALTER TABLE BANK
 ADD TMP_STOPPED_PERCENT NUMERIC(5,2) NOT NULL;
 
UPDATE BANK SET TMP_STOPPED_PERCENT = STOPPED_PERCENT;

ALTER TABLE BANK
 DROP STOPPED_PERCENT;

ALTER TABLE BANK
 ADD STOPPED_PERCENT NUMERIC(5,2) default 0 NOT NULL;
 
UPDATE BANK SET  STOPPED_PERCENT = TMP_STOPPED_PERCENT;

ALTER TABLE BANK
 DROP TMP_STOPPED_PERCENT;


/* PRODUCT_GROUP.NAME, NAME_EN */
ALTER TABLE PRODUCT_GROUP
 ADD TMP_NAME VARCHAR(30); 
ALTER TABLE PRODUCT_GROUP
 ADD TMP_NAME_EN VARCHAR(30); 
 
UPDATE PRODUCT_GROUP SET TMP_NAME = NAME;
UPDATE PRODUCT_GROUP SET TMP_NAME_EN = NAME_EN;

ALTER TABLE PRODUCT_GROUP
 DROP NAME; 
ALTER TABLE PRODUCT_GROUP
 DROP NAME_EN; 

ALTER TABLE PRODUCT_GROUP
 ADD NAME VARCHAR(100) NOT NULL; 
ALTER TABLE PRODUCT_GROUP
 ADD NAME_EN VARCHAR(100);
 
UPDATE PRODUCT_GROUP SET NAME = TMP_NAME;
UPDATE PRODUCT_GROUP SET NAME_EN = TMP_NAME_EN; 

ALTER TABLE PRODUCT_GROUP
 DROP TMP_NAME; 
ALTER TABLE PRODUCT_GROUP
 DROP TMP_NAME_EN; 
 
 
 
/*==============================================================*/
/* Table: SYS_TRANSFER_SOURCE                                   */
/*==============================================================*/
 
create table SYS_TRANSFER_SOURCE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(30)                    not null,
NAME                 VARCHAR(50),
IMPORTER_CLASS       VARCHAR(128),
EXPORTER_CLASS       VARCHAR(128),
CHAR_TABLE_FROM      VARCHAR(20),
CHAR_TABLE_TO        VARCHAR(20),
constraint PK_SYS_TRANSFER_SOURCE primary key (ID)
);

/*==============================================================*/
/* Table: SYS_TRANSFER_SOURCE_ATTR                              */
/*==============================================================*/
create table SYS_TRANSFER_SOURCE_ATTR (
ID                   INTEGER                        not null,
SOURCE_ID            INTEGER                        not null,
CODE                 VARCHAR(30)                    not null,
NAME                 VARCHAR(50),
SQL_TYPE             VARCHAR(30)                    not null,
TYPE_SIZE            INTEGER                        default 0 not null,
DECIMAL_DIGITS       INTEGER                        default 0 not null,
ORDER_NUMBER         INTEGER                        default 0 not null,
IS_PRIMARY_KEY       CHAR(1)                        default 'N' not null,
IS_UNIQUE_KEY        CHAR(1)                        default 'N' not null,
constraint PK_SYS_TRANSFER_SOURCE_ATTR primary key (ID)
);


INSERT INTO SYS_TRANSFER_SOURCE (ID, CODE, NAME, IMPORTER_CLASS, EXPORTER_CLASS) VALUES (1, 'BANK', 'Banks', 'org.plazmaforge.bsolution.bank.server.services.BankImporter', NULL);
INSERT INTO SYS_TRANSFER_SOURCE (ID, CODE, NAME, IMPORTER_CLASS, EXPORTER_CLASS) VALUES (2, 'GOODS', 'Goods', 'org.plazmaforge.bsolution.goods.server.services.GoodsImporter', NULL);
INSERT INTO SYS_TRANSFER_SOURCE (ID, CODE, NAME, IMPORTER_CLASS, EXPORTER_CLASS) VALUES (3, 'GOODS_GROUP', 'Goods groups', 'org.plazmaforge.bsolution.goods.server.services.GoodsGroupImporter', NULL);


INSERT INTO SYS_TRANSFER_SOURCE_ATTR (ID, SOURCE_ID, CODE, NAME, SQL_TYPE, TYPE_SIZE, DECIMAL_DIGITS) VALUES (2, 1, 'BIC', 'BIC', 'VARCHAR', 20, 0);
INSERT INTO SYS_TRANSFER_SOURCE_ATTR (ID, SOURCE_ID, CODE, NAME, SQL_TYPE, TYPE_SIZE, DECIMAL_DIGITS) VALUES (3, 1, 'NAME', 'Name', 'VARCHAR', 50, 0);
INSERT INTO SYS_TRANSFER_SOURCE_ATTR (ID, SOURCE_ID, CODE, NAME, SQL_TYPE, TYPE_SIZE, DECIMAL_DIGITS) VALUES (4, 2, 'CODE', 'Code', 'VARCHAR', 20, 0);
INSERT INTO SYS_TRANSFER_SOURCE_ATTR (ID, SOURCE_ID, CODE, NAME, SQL_TYPE, TYPE_SIZE, DECIMAL_DIGITS) VALUES (5, 2, 'NAME', 'Name', 'VARCHAR', 100, 0);
INSERT INTO SYS_TRANSFER_SOURCE_ATTR (ID, SOURCE_ID, CODE, NAME, SQL_TYPE, TYPE_SIZE, DECIMAL_DIGITS) VALUES (6, 2, 'PRODUCT_GROUP_CODE', 'Group Code', 'VARCHAR', 20, 0);
INSERT INTO SYS_TRANSFER_SOURCE_ATTR (ID, SOURCE_ID, CODE, NAME, SQL_TYPE, TYPE_SIZE, DECIMAL_DIGITS) VALUES (7, 2, 'PRODUCT_GROUP_NAME', 'Group', 'VARCHAR', 50, 0);
INSERT INTO SYS_TRANSFER_SOURCE_ATTR (ID, SOURCE_ID, CODE, NAME, SQL_TYPE, TYPE_SIZE, DECIMAL_DIGITS) VALUES (8, 2, 'UNIT_NAME', 'Unit', 'VARCHAR', 20, 0);
INSERT INTO SYS_TRANSFER_SOURCE_ATTR (ID, SOURCE_ID, CODE, NAME, SQL_TYPE, TYPE_SIZE, DECIMAL_DIGITS) VALUES (9, 2, 'CURRENCY_CODE', 'Currency Code', 'VARCHAR', 3, 0);
INSERT INTO SYS_TRANSFER_SOURCE_ATTR (ID, SOURCE_ID, CODE, NAME, SQL_TYPE, TYPE_SIZE, DECIMAL_DIGITS) VALUES (10, 2, 'CURRENCY_PRICE', 'Price', 'NUMERIC', 0, 0);
INSERT INTO SYS_TRANSFER_SOURCE_ATTR (ID, SOURCE_ID, CODE, NAME, SQL_TYPE, TYPE_SIZE, DECIMAL_DIGITS) VALUES (11, 3, 'CODE', 'Code', 'VARCHAR', 20, 0);
INSERT INTO SYS_TRANSFER_SOURCE_ATTR (ID, SOURCE_ID, CODE, NAME, SQL_TYPE, TYPE_SIZE, DECIMAL_DIGITS) VALUES (12, 3, 'NAME', 'Name', 'VARCHAR', 50, 0);



/*==============================================================*/
/* Table: ENTERPRISE_CONTEXT                                    */
/*==============================================================*/
create table ENTERPRISE_CONTEXT (
ID                   INTEGER                        not null,
SUPPLIER_ID          INTEGER,
WAREHOUSE_ID         INTEGER,
MATERIAL_RESPONSIBLE_ID INTEGER,
INCOME_WAREHOUSE_ID  INTEGER,
CURRENCY_ID          INTEGER                        not null,
TAX_ID               INTEGER,
PERIOD_ID            INTEGER                        not null,
PARTNER_ID           INTEGER,
OUTCOME_WAREHOUSE_ID INTEGER,
CUSTOMER_ID          INTEGER,
RESPONSIBLE_ID       INTEGER,
UNIT_ID              INTEGER                        not null,
IS_CALCULATE_ACCOUNTING CHAR(1)                        default 'N' not null,
IS_MULTI_CURRENCIES  CHAR(1)                        default 'Y' not null,
IS_AUTO_SET_CURRENCY_RATE CHAR(1)                        default 'Y' not null,
IS_INTERNATIONAL_ATTRIBUTES CHAR(1)                        default 'N' not null,
IS_PROJECT_IN_DOCUMENT CHAR(1)                        default 'N' not null,
IS_AUTO_CALCULATE_PROD_REST CHAR(1)                        default 'Y' not null,
constraint PK_ENTERPRISE_CONTEXT primary key (ID)
);

INSERT INTO ENTERPRISE_CONTEXT (
ID,
SUPPLIER_ID,
WAREHOUSE_ID,
MATERIAL_RESPONSIBLE_ID,
INCOME_WAREHOUSE_ID,
CURRENCY_ID,
TAX_ID,
PERIOD_ID,
PARTNER_ID,
OUTCOME_WAREHOUSE_ID,
CUSTOMER_ID,
RESPONSIBLE_ID,
UNIT_ID,
IS_CALCULATE_ACCOUNTING,
IS_MULTI_CURRENCIES,
IS_AUTO_SET_CURRENCY_RATE,
IS_INTERNATIONAL_ATTRIBUTES,
IS_PROJECT_IN_DOCUMENT,
IS_AUTO_CALCULATE_PROD_REST)

SELECT 

ID,
SUPPLIER_ID,
WAREHOUSE_ID,
MATERIAL_RESPONSIBLE_ID,
INCOME_WAREHOUSE_ID,
CURRENCY_ID,
TAX_ID,
PERIOD_ID,
PARTNER_ID,
OUTCOME_WAREHOUSE_ID,
CUSTOMER_ID,
RESPONSIBLE_ID,
UNIT_ID,
IS_CALCULATE_ACCOUNTING,
IS_MULTI_CURRENCIES,
IS_AUTO_SET_CURRENCY_RATE,
IS_INTERNATIONAL_ATTRIBUTES,
IS_PROJECT_IN_DOCUMENT,
IS_AUTO_CALCULATE_PROD_REST

FROM SYS_INFO;

ALTER TABLE SYS_INFO
 DROP SUPPLIER_ID;
ALTER TABLE SYS_INFO
 DROP WAREHOUSE_ID;
ALTER TABLE SYS_INFO
 DROP MATERIAL_RESPONSIBLE_ID;
ALTER TABLE SYS_INFO
 DROP INCOME_WAREHOUSE_ID;
ALTER TABLE SYS_INFO
 DROP CURRENCY_ID;
ALTER TABLE SYS_INFO
 DROP TAX_ID;
ALTER TABLE SYS_INFO
 DROP PERIOD_ID;
ALTER TABLE SYS_INFO
 DROP PARTNER_ID;
ALTER TABLE SYS_INFO
 DROP OUTCOME_WAREHOUSE_ID;
ALTER TABLE SYS_INFO
 DROP CUSTOMER_ID;
ALTER TABLE SYS_INFO
 DROP RESPONSIBLE_ID;
ALTER TABLE SYS_INFO
 DROP UNIT_ID;
ALTER TABLE SYS_INFO
 DROP IS_CALCULATE_ACCOUNTING;
ALTER TABLE SYS_INFO
 DROP IS_MULTI_CURRENCIES;
ALTER TABLE SYS_INFO
 DROP IS_AUTO_SET_CURRENCY_RATE;
ALTER TABLE SYS_INFO
 DROP IS_INTERNATIONAL_ATTRIBUTES;
ALTER TABLE SYS_INFO
 DROP IS_PROJECT_IN_DOCUMENT;
ALTER TABLE SYS_INFO
 DROP IS_AUTO_CALCULATE_PROD_REST;
 
 
 
 
/*==============================================================*/
/* Table: SYS_ROLE_INTERFACE                                    */
/*==============================================================*/
create table SYS_ROLE_INTERFACE (
ID                   INTEGER                        not null,
ROLE_ID              INTEGER                        not null,
INTERFACE_ID         VARCHAR(30)                    not null,
constraint PK_SYS_ROLE_INTERFACE primary key (ID)
);

INSERT INTO SYS_ROLE_INTERFACE (ID, ROLE_ID, INTERFACE_ID) SELECT ID, ROLE_ID, UI_ID FROM SYS_ROLE_UI;

DROP TABLE SYS_ROLE_UI;



ALTER TABLE SYS_ROLE
 ADD DEF_INTERFACE_ID CHAR(30);
 
UPDATE SYS_ROLE SET DEF_INTERFACE_ID = DEFAULT_UI_ID;

ALTER TABLE SYS_ROLE
 DROP DEFAULT_UI_ID;





CREATE TABLE TMP_SYS_USER (
    ID                 INTEGER NOT NULL,
    ENTITY_ID          CHAR(30),
    USER_NAME          VARCHAR(64) NOT NULL,
    USER_PASSWORD      VARCHAR(64) NOT NULL,
    OWNER_ID           INTEGER,
    REGISTRATION_DATE  DATE NOT NULL,
    NAME               VARCHAR(50),
    DEFAULT_UI_ID      CHAR(30),
    IS_ENABLE          CHAR(1) default 'Y' NOT NULL,
    CONTACT_ID         INTEGER
);
  

INSERT INTO TMP_SYS_USER (
 ID,
 ENTITY_ID,
 USER_NAME,
 USER_PASSWORD,
 OWNER_ID,
 REGISTRATION_DATE,
 NAME,
 DEFAULT_UI_ID,
 IS_ENABLE,
 CONTACT_ID
)

SELECT 

 ID,
 ENTITY_ID,
 USER_NAME,
 USER_PASSWORD,
 OWNER_ID,
 REGISTRATION_DATE,
 NAME,
 DEFAULT_UI_ID,
 IS_ENABLE,
 CONTACT_ID
FROM SYS_USER;

DROP TABLE SYS_USER;

create table SYS_USER (
ID                   INTEGER                        not null,
ENTITY_ID            CHAR(30),
CONTACT_ID           INTEGER,
USER_NAME            VARCHAR(64)                    not null,
USER_PASSWORD        VARCHAR(64)                    not null,
OWNER_ID             INTEGER,
REG_DATE             DATE                           not null,
NAME                 VARCHAR(50),
DEF_INTERFACE_ID     CHAR(30),
IS_ENABLE            CHAR(1)                        default 'Y' not null,
constraint PK_SYS_USER primary key (ID)
);


INSERT INTO SYS_USER (
ID,
ENTITY_ID,
CONTACT_ID,
USER_NAME,
USER_PASSWORD,
OWNER_ID,
REG_DATE,
NAME,
DEF_INTERFACE_ID,
IS_ENABLE  
)

SELECT 
ID,
ENTITY_ID,
CONTACT_ID,
USER_NAME,
USER_PASSWORD,
OWNER_ID,
REGISTRATION_DATE,
NAME,
DEFAULT_UI_ID,
IS_ENABLE  
FROM TMP_SYS_USER;

DROP TABLE TMP_SYS_USER;




/*==============================================================*/
/* Table: SYS_LOOKUP                                            */
/*==============================================================*/
create table SYS_LOOKUP (
ID                   INTEGER                        not null,
ENTITY_ID            CHAR(30)                       not null,
CODE                 VARCHAR(30),
NAME                 VARCHAR(50)                    not null,
DESCRIPTION          VARCHAR(255),
constraint PK_SYS_LOOKUP primary key (ID)
);


INSERT INTO SYS_LOOKUP (
 ID,
 ENTITY_ID,
 CODE,
 NAME,
 DESCRIPTION
)
SELECT 
 ID,
 ENTITY_ID,
 CODE,
 NAME,
 DESCRIPTION
FROM SYS_REFERENCE;

DROP TABLE SYS_REFERENCE;








CREATE TABLE TMP_SYS_ENTITY (
    ID                        CHAR(30) NOT NULL,
    ENTITY_TYPE_ID            CHAR(30) NOT NULL,
    CODE                      VARCHAR(30) NOT NULL,
    NAME                      VARCHAR(50) NOT NULL,
    ENTITY_CLASS              CHAR(30),
    ENTITY_PACKAGE            CHAR(30),
    IS_ENABLE                 CHAR(1) default 'N' NOT NULL,
    IS_BASE                   CHAR(1) default 'N' NOT NULL,
    IS_BEAN                   CHAR(1) default 'N' NOT NULL,
    IS_FORM                   CHAR(1) default 'N' NOT NULL,
    IS_PERMISSION             CHAR(1) default 'N' NOT NULL,
    IS_SYSTEM                 CHAR(1) default 'N' NOT NULL,
    IS_CUSTOM                 CHAR(1) default 'N' NOT NULL,
    IS_CUSTOM_ATTRIBUTE       CHAR(1) default 'N' NOT NULL,
    IS_CACHE                  CHAR(1) default 'N' NOT NULL,
    CACHE_EXPIRE_TIME         INTEGER default 0 NOT NULL,
    ENTITY_CODE_PREFIX        VARCHAR(10),
    ENTITY_CODE_SUFFIX        VARCHAR(10),
    LAST_ENTITY_NUMBER        INTEGER,
    IS_USE_NUMERATOR          CHAR(1) default 'N' NOT NULL,
    IS_UNIQUE_ENTITY_CODE     CHAR(1) default 'N' NOT NULL,
    NUMERATOR_CLASS           VARCHAR(128),
    IS_ENTITY_CODE_READ_ONLY  CHAR(1) default 'N' NOT NULL,
    IS_ENTITY_DATE_READ_ONLY  CHAR(1) default 'N' NOT NULL
);

INSERT INTO TMP_SYS_ENTITY (
 ID,
 ENTITY_TYPE_ID,
 CODE,
 NAME,
 ENTITY_CLASS,
 ENTITY_PACKAGE,
 IS_ENABLE,
 IS_BASE,
 IS_BEAN,
 IS_FORM,
 IS_PERMISSION,
 IS_SYSTEM,
 IS_CUSTOM,
 IS_CUSTOM_ATTRIBUTE,
 IS_CACHE,
 CACHE_EXPIRE_TIME,
 ENTITY_CODE_PREFIX,
 ENTITY_CODE_SUFFIX,
 LAST_ENTITY_NUMBER,
 IS_USE_NUMERATOR,
 IS_UNIQUE_ENTITY_CODE,
 NUMERATOR_CLASS,
 IS_ENTITY_CODE_READ_ONLY,
 IS_ENTITY_DATE_READ_ONLY
)
SELECT 
 ID,
 ENTITY_TYPE_ID,
 CODE,
 NAME,
 ENTITY_CLASS,
 ENTITY_PACKAGE,
 IS_ENABLE,
 IS_BASE,
 IS_BEAN,
 IS_FORM,
 IS_PERMISSION,
 IS_SYSTEM,
 IS_CUSTOM,
 IS_CUSTOM_ATTRIBUTE,
 IS_CACHE,
 CACHE_EXPIRE_TIME,
 ENTITY_CODE_PREFIX,
 ENTITY_CODE_SUFFIX,
 LAST_ENTITY_NUMBER,
 IS_USE_NUMERATOR,
 IS_UNIQUE_ENTITY_CODE,
 NUMERATOR_CLASS,
 IS_ENTITY_CODE_READ_ONLY,
 IS_ENTITY_DATE_READ_ONLY
FROM SYS_ENTITY;

DROP TABLE SYS_ENTITY;


create table SYS_ENTITY (
ID                   CHAR(30)                       not null,
ENTITY_TYPE_ID       CHAR(30)                       not null,
CODE                 VARCHAR(30)                    not null,
NAME                 VARCHAR(50)                    not null,
ENTITY_CLASS         CHAR(30),
ENTITY_PACKAGE       CHAR(30),
IS_ENABLE            CHAR(1)                        default 'N' not null,
IS_MASTER            CHAR(1)                        default 'N' not null,
IS_BEAN              CHAR(1)                        default 'N' not null,
IS_FORM              CHAR(1)                        default 'N' not null,
IS_SECURE            CHAR(1)                        default 'N' not null,
IS_SYSTEM            CHAR(1)                        default 'N' not null,
IS_CUSTOM            CHAR(1)                        default 'N' not null,
IS_CUSTOM_ATTRIBUTE  CHAR(1)                        default 'N' not null,
IS_CACHE             CHAR(1)                        default 'N' not null,
CACHE_EXPIRE_TIME    INTEGER                        default 0 not null,
ENTITY_NUMBER_PREFIX VARCHAR(10),
ENTITY_NUMBER_SUFFIX VARCHAR(10),
LAST_ENTITY_NUMBER   INTEGER,
IS_USE_NUMERATOR     CHAR(1)                        default 'N' not null,
IS_UNIQUE_ENTITY_NUMBER CHAR(1)                        default 'N' not null,
NUMERATOR_CLASS      VARCHAR(128),
IS_ENTITY_NUMBER_READ_ONLY CHAR(1)                        default 'N' not null,
IS_ENTITY_DATE_READ_ONLY CHAR(1)                        default 'N' not null,
constraint PK_SYS_ENTITY primary key (ID)
);


INSERT INTO SYS_ENTITY (
 ID,
 ENTITY_TYPE_ID,
 CODE,
 NAME,
 ENTITY_CLASS,
 ENTITY_PACKAGE,
 IS_ENABLE,
 IS_MASTER,
 IS_BEAN,
 IS_FORM,
 IS_SECURE,
 IS_SYSTEM,
 IS_CUSTOM,
 IS_CUSTOM_ATTRIBUTE,
 IS_CACHE,
 CACHE_EXPIRE_TIME,
 ENTITY_NUMBER_PREFIX,
 ENTITY_NUMBER_SUFFIX,
 LAST_ENTITY_NUMBER,
 IS_USE_NUMERATOR,
 IS_UNIQUE_ENTITY_NUMBER,
 NUMERATOR_CLASS,
 IS_ENTITY_NUMBER_READ_ONLY,
 IS_ENTITY_DATE_READ_ONLY
 ) 
 SELECT 
 ID,
 ENTITY_TYPE_ID,
 CODE,
 NAME,
 ENTITY_CLASS,
 ENTITY_PACKAGE,
 IS_ENABLE,
 IS_BASE,
 IS_BEAN,
 IS_FORM,
 IS_PERMISSION,
 IS_SYSTEM,
 IS_CUSTOM,
 IS_CUSTOM_ATTRIBUTE,
 IS_CACHE,
 CACHE_EXPIRE_TIME,
 ENTITY_CODE_PREFIX,
 ENTITY_CODE_SUFFIX,
 LAST_ENTITY_NUMBER,
 IS_USE_NUMERATOR,
 IS_UNIQUE_ENTITY_CODE,
 NUMERATOR_CLASS,
 IS_ENTITY_CODE_READ_ONLY,
 IS_ENTITY_DATE_READ_ONLY
FROM TMP_SYS_ENTITY;
 
DROP TABLE TMP_SYS_ENTITY;




/*==============================================================*/
/* Table: SYS_ENTITY_ATTR                                       */
/*==============================================================*/
create table SYS_ENTITY_ATTR (
ID                   INTEGER                        not null,
VALUE_ENTITY_ID      CHAR(30),
ATTR_GROUP_ID        INTEGER,
ENTITY_ID            CHAR(30)                       not null,
DATA_TYPE_ID         CHAR(30)                       not null,
CODE                 VARCHAR(30),
NAME                 VARCHAR(50),
constraint PK_SYS_ENTITY_ATTR primary key (ID)
);

INSERT INTO SYS_ENTITY_ATTR (
 ID,
 VALUE_ENTITY_ID,
 ATTR_GROUP_ID,
 ENTITY_ID,
 DATA_TYPE_ID,
 CODE,
 NAME
)
SELECT
 ID,
 VALUE_ENTITY_ID,
 ATTR_GROUP_ID,
 ENTITY_ID,
 DATA_TYPE_ID,
 CODE,
 NAME
FROM SYS_ATTR;

DROP TABLE SYS_ATTR;



/*==============================================================*/
/* Table: SYS_ENTITY_GROUP                                      */
/*==============================================================*/
create table SYS_ENTITY_GROUP (
ID                   INTEGER                        not null,
ENTITY_ID            CHAR(30)                       not null,
CODE                 VARCHAR(30),
NAME                 VARCHAR(50),
constraint PK_SYS_ENTITY_GROUP primary key (ID)
);

/* TODO: FIX: SYS_ENTITY_GROUP -> SYS_ENTITY_ATTR_GROUP */

INSERT INTO SYS_ENTITY_GROUP (
 ID,
 ENTITY_ID,
 CODE,
 NAME
)
SELECT
 ID,
 ENTITY_ID,
 CODE,
 NAME
FROM SYS_ATTR_GROUP;

DROP TABLE SYS_ATTR_GROUP;



/*==============================================================*/
/* Table: SYS_ENTITY_ATTR_VALUE                                 */
/*==============================================================*/
create table SYS_ENTITY_ATTR_VALUE (
ID                   INTEGER                        not null,
ATTR_ID              INTEGER                        not null,
ENTITY_ID            CHAR(30)                       not null,
OWNER_ID             INTEGER                        not null,
STRING_VALUE         VARCHAR(255),
INTEGER_VALUE        INTEGER,
FLOAT_VALUE          FLOAT,
DATE_VALUE           DATE,
constraint PK_SYS_ENTITY_ATTR_VALUE primary key (ID)
);

INSERT INTO SYS_ENTITY_ATTR_VALUE (
 ID,
 ATTR_ID,
 ENTITY_ID,
 OWNER_ID,
 STRING_VALUE,
 INTEGER_VALUE,
 FLOAT_VALUE,
 DATE_VALUE
)
SELECT
 ID,
 ATTR_ID,
 ENTITY_ID,
 OWNER_ID,
 STRING_VALUE,
 INTEGER_VALUE,
 FLOAT_VALUE,
 DATE_VALUE
FROM SYS_ATTR_VALUE;

DROP TABLE SYS_ATTR_VALUE;



/*==============================================================*/
/* Table: SYS_DATA_TYPE                                         */
/*==============================================================*/
create table SYS_DATA_TYPE (
ID                   CHAR(30)                       not null,
CODE                 VARCHAR(30),
NAME                 VARCHAR(50),
IS_ENABLE            CHAR(1)                        default 'N' not null,
constraint PK_SYS_DATA_TYPE primary key (ID)
);

INSERT INTO SYS_DATA_TYPE (
 ID,
 CODE,
 NAME,
 IS_ENABLE
)
SELECT
 ID,
 CODE,
 NAME,
 IS_ENABLE
FROM DATA_TYPE;

DROP TABLE DATA_TYPE;


INSERT INTO SYS_DATA_TYPE (ID, CODE, NAME, IS_ENABLE) VALUES ('REFERENCE',  'Reference',  'Reference', 'Y');
UPDATE SYS_ENTITY_ATTR SET DATA_TYPE_ID = 'REFERENCE' WHERE DATA_TYPE_ID = 'DICTIONARY';
UPDATE SYS_VARIABLE SET DATA_TYPE_ID = 'REFERENCE' WHERE DATA_TYPE_ID = 'DICTIONARY';
DELETE FROM SYS_DATA_TYPE WHERE ID = 'DICTIONARY';

UPDATE SYS_ENTITY_TYPE SET ID = 'LOOKUP', CODE = 'LOOKUP' WHERE ID = 'REFERENCE';







/*==============================================================*/
/* Table: PIM_APPOINTMENT                                       */
/*==============================================================*/
create table PIM_APPOINTMENT (
ID                   INTEGER                        not null,
APPOINTMENT_TYPE_ID  INTEGER                        not null,
RESPONSIBLE_ID       INTEGER                        not null,
PROJECT_ID           INTEGER,
APPOINTMENT_PRIORITY_ID INTEGER                        not null,
ORGANIZATION_ID      INTEGER                        not null,
SUBJECT              VARCHAR(50)                    not null,
DESCRIPTION          VARCHAR(255),
APPOINTMENT_LOCATION VARCHAR(50),
START_DATE_TIME      DATE                           not null,
END_DATE_TIME        DATE,
REMINDER_DATE_TIME   DATE,
IS_REMINDER          CHAR(1)                        default 'N' not null,
RECURRENCE_EXPRESSION VARCHAR(100),
constraint PK_PIM_APPOINTMENT primary key (ID)
);

/*==============================================================*/
/* Table: PIM_APPOINTMENT_CONTACT                               */
/*==============================================================*/
create table PIM_APPOINTMENT_CONTACT (
ID                   INTEGER                        not null,
APPOINTMENT_ID       INTEGER                        not null,
CONTACT_ID           INTEGER                        not null,
constraint PK_PIM_APPOINTMENT_CONTACT primary key (ID)
);

/*==============================================================*/
/* Table: PIM_APPOINTMENT_PRIORITY                              */
/*==============================================================*/
create table PIM_APPOINTMENT_PRIORITY (
ID                   INTEGER                        not null,
CODE                 VARCHAR(20)                    not null,
NAME                 VARCHAR(50)                    not null,
IS_SYSTEM            CHAR(1)                        default 'N' not null,
constraint PK_PIM_APPOINTMENT_PRIORITY primary key (ID)
);

/*==============================================================*/
/* Table: PIM_APPOINTMENT_TYPE                                  */
/*==============================================================*/
create table PIM_APPOINTMENT_TYPE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(20)                    not null,
NAME                 VARCHAR(50)                    not null,
DESCRIPTION          VARCHAR(255),
IS_SYSTEM            CHAR(1)                        default 'N' not null,
constraint PK_PIM_APPOINTMENT_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: PIM_EVENT                                             */
/*==============================================================*/
create table PIM_EVENT (
ID                   INTEGER                        not null,
ORGANIZATION_ID      INTEGER                        not null,
RESPONSIBLE_ID       INTEGER                        not null,
NAME                 VARCHAR(50)                    not null,
DESCRIPTION          VARCHAR(255),
EVENT_DATE_TIME      DATE                           not null,
REMINDER_DATE_TIME   DATE,
IS_REMINDER          CHAR(1)                        default 'N' not null,
RECURRENCE_EXPRESSION VARCHAR(100),
constraint PK_PIM_EVENT primary key (ID)
);

/*==============================================================*/
/* Table: PIM_NOTE                                              */
/*==============================================================*/
create table PIM_NOTE (
ID                   INTEGER                        not null,
USER_ID              INTEGER                        not null,
NOTE_DATE_TIME       DATE                           not null,
NOTE_TEXT            VARCHAR(255),
constraint PK_PIM_NOTE primary key (ID)
);

/*==============================================================*/
/* Table: PIM_REMINDER                                          */
/*==============================================================*/
create table PIM_REMINDER (
ID                   INTEGER                        not null,
USER_ID              INTEGER                        not null,
NAME                 VARCHAR(50)                    not null,
DESCRIPTION          VARCHAR(255),
EVENT_DATE_TIME      DATE,
REMINDER_DATE_TIME   DATE,
constraint PK_PIM_REMINDER primary key (ID)
);



INSERT INTO PIM_APPOINTMENT_PRIORITY (ID, CODE, NAME, IS_SYSTEM) VALUES (1, 'LOW', 'Low', 'Y');
INSERT INTO PIM_APPOINTMENT_PRIORITY (ID, CODE, NAME, IS_SYSTEM) VALUES (2, 'NORMAL', 'Normal', 'Y');
INSERT INTO PIM_APPOINTMENT_PRIORITY (ID, CODE, NAME, IS_SYSTEM) VALUES (3, 'HIGH', 'High', 'Y');


INSERT INTO PIM_APPOINTMENT_TYPE (ID, CODE, NAME, IS_SYSTEM) VALUES (1,  'APPOINTMENT', 'Appointment', 'Y');
INSERT INTO PIM_APPOINTMENT_TYPE (ID, CODE, NAME, IS_SYSTEM) VALUES (2,  'MEETING', 'Meeting', 'Y');





/*==============================================================*/
/* 2011-05-12                                                   */
/*==============================================================*/



/*==============================================================*/
/* Table: JOB_POSITION                                          */
/*==============================================================*/
create table JOB_POSITION (
ID                   INTEGER                        not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(50)                    not null,
constraint PK_JOB_POSITION primary key (ID)
);

INSERT INTO JOB_POSITION (ID, CODE, NAME) SELECT ID, CODE, NAME FROM POSITIONS;

DROP TABLE POSITIONS;





/*==============================================================*/
/* Table: SYS_ENTITY_ATTR_GROUP                                 */
/*==============================================================*/
create table SYS_ENTITY_ATTR_GROUP (
ID                   INTEGER                        not null,
ENTITY_ID            CHAR(30)                       not null,
CODE                 VARCHAR(30),
NAME                 VARCHAR(50),
constraint PK_SYS_ENTITY_ATTR_GROUP primary key (ID)
);


INSERT INTO SYS_ENTITY_ATTR_GROUP (ID, ENTITY_ID, CODE, NAME) SELECT ID, ENTITY_ID, CODE, NAME FROM SYS_ENTITY_GROUP;

DROP TABLE SYS_ENTITY_GROUP;



create table TMP_ENTERPRISE_CONTEXT (
ID                   INTEGER                        not null,
SUPPLIER_ID          INTEGER,
WAREHOUSE_ID         INTEGER,
MATERIAL_RESPONSIBLE_ID  INTEGER,
INCOME_WAREHOUSE_ID  INTEGER,
CURRENCY_ID          INTEGER                        not null,
TAX_ID               INTEGER,
PERIOD_ID            INTEGER                        not null,
PARTNER_ID           INTEGER,
OUTCOME_WAREHOUSE_ID INTEGER,
CUSTOMER_ID          INTEGER,
RESPONSIBLE_ID       INTEGER,
UNIT_ID              INTEGER                        not null,
IS_CALCULATE_ACCOUNTING CHAR(1)                        default 'N' not null,
IS_MULTI_CURRENCIES  CHAR(1)                        default 'Y' not null,
IS_AUTO_SET_CURRENCY_RATE CHAR(1)                        default 'Y' not null,
IS_INTERNATIONAL_ATTRIBUTES CHAR(1)                        default 'N' not null,
IS_PROJECT_IN_DOCUMENT CHAR(1)                        default 'N' not null,
IS_AUTO_CALCULATE_PROD_REST CHAR(1)                        default 'Y' not null
);

INSERT INTO TMP_ENTERPRISE_CONTEXT (
 ID,
 SUPPLIER_ID,
 WAREHOUSE_ID,
 MATERIAL_RESPONSIBLE_ID,
 INCOME_WAREHOUSE_ID,
 CURRENCY_ID,
 TAX_ID,
 PERIOD_ID,
 PARTNER_ID,
 OUTCOME_WAREHOUSE_ID,
 CUSTOMER_ID,
 RESPONSIBLE_ID,
 UNIT_ID,
 IS_CALCULATE_ACCOUNTING,
 IS_MULTI_CURRENCIES,
 IS_AUTO_SET_CURRENCY_RATE,
 IS_INTERNATIONAL_ATTRIBUTES,
 IS_PROJECT_IN_DOCUMENT,
 IS_AUTO_CALCULATE_PROD_REST
) SELECT 
 ID,
 SUPPLIER_ID,
 WAREHOUSE_ID,
 MATERIAL_RESPONSIBLE_ID,
 INCOME_WAREHOUSE_ID,
 CURRENCY_ID,
 TAX_ID,
 PERIOD_ID,
 PARTNER_ID,
 OUTCOME_WAREHOUSE_ID,
 CUSTOMER_ID,
 RESPONSIBLE_ID,
 UNIT_ID,
 IS_CALCULATE_ACCOUNTING,
 IS_MULTI_CURRENCIES,
 IS_AUTO_SET_CURRENCY_RATE,
 IS_INTERNATIONAL_ATTRIBUTES,
 IS_PROJECT_IN_DOCUMENT,
 IS_AUTO_CALCULATE_PROD_REST
FROM ENTERPRISE_CONTEXT;

DROP TABLE ENTERPRISE_CONTEXT;


create table ENTERPRISE_CONTEXT (
ID                   INTEGER                        not null,
SUPPLIER_ID          INTEGER,
WAREHOUSE_ID         INTEGER,
MTRL_RESPONSIBLE_ID  INTEGER,
INCOME_WAREHOUSE_ID  INTEGER,
CURRENCY_ID          INTEGER                        not null,
TAX_ID               INTEGER,
PERIOD_ID            INTEGER                        not null,
PARTNER_ID           INTEGER,
OUTCOME_WAREHOUSE_ID INTEGER,
CUSTOMER_ID          INTEGER,
RESPONSIBLE_ID       INTEGER,
UNIT_ID              INTEGER                        not null,
IS_CALCULATE_ACCOUNTING CHAR(1)                        default 'N' not null,
IS_MULTI_CURRENCIES  CHAR(1)                        default 'Y' not null,
IS_AUTO_SET_CURRENCY_RATE CHAR(1)                        default 'Y' not null,
IS_INTERNATIONAL_ATTRIBUTES CHAR(1)                        default 'N' not null,
IS_PROJECT_IN_DOCUMENT CHAR(1)                        default 'N' not null,
IS_AUTO_CALCULATE_PROD_REST CHAR(1)                        default 'Y' not null,
constraint PK_ENTERPRISE_CONTEXT primary key (ID)
);


INSERT INTO ENTERPRISE_CONTEXT (
 ID,
 SUPPLIER_ID,
 WAREHOUSE_ID,
 MTRL_RESPONSIBLE_ID,
 INCOME_WAREHOUSE_ID,
 CURRENCY_ID,
 TAX_ID,
 PERIOD_ID,
 PARTNER_ID,
 OUTCOME_WAREHOUSE_ID,
 CUSTOMER_ID,
 RESPONSIBLE_ID,
 UNIT_ID,
 IS_CALCULATE_ACCOUNTING,
 IS_MULTI_CURRENCIES,
 IS_AUTO_SET_CURRENCY_RATE,
 IS_INTERNATIONAL_ATTRIBUTES,
 IS_PROJECT_IN_DOCUMENT,
 IS_AUTO_CALCULATE_PROD_REST
) SELECT 
 ID,
 SUPPLIER_ID,
 WAREHOUSE_ID,
 MATERIAL_RESPONSIBLE_ID,
 INCOME_WAREHOUSE_ID,
 CURRENCY_ID,
 TAX_ID,
 PERIOD_ID,
 PARTNER_ID,
 OUTCOME_WAREHOUSE_ID,
 CUSTOMER_ID,
 RESPONSIBLE_ID,
 UNIT_ID,
 IS_CALCULATE_ACCOUNTING,
 IS_MULTI_CURRENCIES,
 IS_AUTO_SET_CURRENCY_RATE,
 IS_INTERNATIONAL_ATTRIBUTES,
 IS_PROJECT_IN_DOCUMENT,
 IS_AUTO_CALCULATE_PROD_REST
FROM TMP_ENTERPRISE_CONTEXT;

DROP TABLE TMP_ENTERPRISE_CONTEXT;





CREATE TABLE TMP_PERSON (
    ID    INTEGER NOT NULL,
    CODE  VARCHAR(10)
);

INSERT INTO TMP_PERSON (ID, CODE) SELECT ID, CODE FROM PERSON;

DROP TABLE PERSON;



create table PERSON (
ID                   INTEGER                        not null,
COUNTRY_RESIDENCE_ID INTEGER,
DIPLOMA_SPECIALITY_ID INTEGER,
LANGUAGE_ID          INTEGER,
FAMILY_STATUS_ID     INTEGER,
NATIONALITY_ID       INTEGER,
DOCUMENT_TYPE_ID     INTEGER,
CODE                 VARCHAR(10),
IDN                  VARCHAR(10),
DOCUMENT_SERIES      VARCHAR(10),
DOCUMENT_NO          VARCHAR(10),
DOCUMENT_DATE        DATE,
DOCUMENT_GIVEN       VARCHAR(100),
DIPLOMA_TYPE         INTEGER                        default 1 not null,
DIPLOMA_SERIES       VARCHAR(10),
DIPLOMA_NO           VARCHAR(10),
DIPLOMA_DATE         DATE,
DIPLOMA_QUALIFICATION VARCHAR(30),
NOTE                 VARCHAR(255),
constraint PK_PERSON primary key (ID)
);


INSERT INTO PERSON (
 ID,
 COUNTRY_RESIDENCE_ID,
 DIPLOMA_SPECIALITY_ID,
 LANGUAGE_ID,
 FAMILY_STATUS_ID,
 NATIONALITY_ID,
 DOCUMENT_TYPE_ID,
 CODE,
 IDN,
 DOCUMENT_SERIES,
 DOCUMENT_NO,
 DOCUMENT_DATE,
 DOCUMENT_GIVEN,
 DIPLOMA_TYPE,
 DIPLOMA_SERIES,
 DIPLOMA_NO,
 DIPLOMA_DATE,
 DIPLOMA_QUALIFICATION,
 NOTE)
SELECT
 P.ID,
 C.COUNTRY_RESIDENCE_ID,
 C.DIPLOMA_SPECIALITY_ID,
 C.LANGUAGE_ID,
 C.FAMILY_STATUS_ID,
 C.NATIONALITY_ID,
 C.DOCUMENT_TYPE_ID,
 P.CODE,
 C.IDN,
 C.DOCUMENT_SERIES,
 C.DOCUMENT_NO,
 C.DOCUMENT_DATE,
 C.DOCUMENT_GIVEN,
 C.DIPLOMA_TYPE,
 C.DIPLOMA_SERIES,
 C.DIPLOMA_NO,
 C.DIPLOMA_DATE,
 C.DIPLOMA_QUALIFICATION,
 C.NOTE
FROM TMP_PERSON P
LEFT JOIN PERSON_CARD C ON P.ID = C.PERSON_ID


DROP TABLE PERSON_CARD;





/*

UPDATE SYS_ENTITY SET ID = 'SYS_DATA_TYPE', CODE = 'SYS_DATA_TYPE' WHERE ID = 'DATA_TYPE';

UPDATE SYS_ENTITY SET ID = 'SYS_ENTITY_ATTR_VALUE', CODE = 'SYS_ENTITY_ATTR_VALUE' WHERE ID = 'SYS_ATTR';

UPDATE SYS_ENTITY SET ID = 'SYS_ENTITY_ATTR', CODE = 'SYS_ENTITY_ATTR' WHERE ID = 'SYS_ATTR_TYPE';

UPDATE SYS_ENTITY SET ID = 'SYS_ENTITY_ATTR_GROUP', CODE = 'SYS_ENTITY_ATTR_GROUP' WHERE ID = 'SYS_ATTR_TYPE_GROUP';

UPDATE SYS_ENTITY SET ID = 'SYS_LOOKUP', CODE = 'SYS_LOOKUP' WHERE ID = 'SYS_REFERENCE';

UPDATE SYS_ENTITY SET ID = 'JOB_POSITION', CODE = 'JOB_POSITION' WHERE ID = 'POSITIONS';

*/





/*==============================================================*/
/* 2011-05-17                                                   */
/*==============================================================*/


create table TMP_GOODS_INCOME (
ID                   INTEGER                        not null,
WAREHOUSE_ID         INTEGER                        not null,
RESPONSIBLE_ID  INTEGER,
DELIVERY             NUMERIC(15,2)                  not null,
TAX_DELIVERY         NUMERIC(15,2)                  not null,
DELIVERY_WITH_TAX    NUMERIC(15,2)                  not null,
CURRENCY_DELIVERY    NUMERIC(15,2)                  not null,
CURRENCY_TAX_DELIVERY NUMERIC(15,2)                  not null,
CURRENCY_DELIVERY_WITH_TAX NUMERIC(15,2)                  not null
);

INSERT INTO TMP_GOODS_INCOME (
 ID,
 WAREHOUSE_ID,
 RESPONSIBLE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX
) 
SELECT
 ID,
 WAREHOUSE_ID,
 RESPONSIBLE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX
FROM GOODS_INCOME;

DROP TABLE GOODS_INCOME;

create table GOODS_INCOME (
ID                   INTEGER                        not null,
WAREHOUSE_ID         INTEGER                        not null,
MTRL_RESPONSIBLE_ID  INTEGER,
DELIVERY             NUMERIC(15,2)                  not null,
TAX_DELIVERY         NUMERIC(15,2)                  not null,
DELIVERY_WITH_TAX    NUMERIC(15,2)                  not null,
CURRENCY_DELIVERY    NUMERIC(15,2)                  not null,
CURRENCY_TAX_DELIVERY NUMERIC(15,2)                  not null,
CURRENCY_DELIVERY_WITH_TAX NUMERIC(15,2)                  not null,
constraint PK_GOODS_INCOME primary key (ID)
);

INSERT INTO GOODS_INCOME (
 ID,
 WAREHOUSE_ID,
 MTRL_RESPONSIBLE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX
) 
SELECT
 ID,
 WAREHOUSE_ID,
 RESPONSIBLE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX
FROM TMP_GOODS_INCOME;


DROP TABLE TMP_GOODS_INCOME;


/*==============================================================*/

create table TMP_GOODS_OUTCOME (
ID                   INTEGER                        not null,
RESPONSIBLE_ID  INTEGER,
WAREHOUSE_ID         INTEGER                        not null,
DELIVERY             NUMERIC(15,2)                  not null,
TAX_DELIVERY         NUMERIC(15,2)                  not null,
DELIVERY_WITH_TAX    NUMERIC(15,2)                  not null,
CURRENCY_DELIVERY    NUMERIC(15,2)                  not null,
CURRENCY_TAX_DELIVERY NUMERIC(15,2)                  not null,
CURRENCY_DELIVERY_WITH_TAX NUMERIC(15,2)                  not null
);

INSERT INTO TMP_GOODS_OUTCOME (
 ID,
 RESPONSIBLE_ID,
 WAREHOUSE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX
)
SELECT
 ID,
 RESPONSIBLE_ID,
 WAREHOUSE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX
FROM GOODS_OUTCOME;

DROP TABLE GOODS_OUTCOME;

create table GOODS_OUTCOME (
ID                   INTEGER                        not null,
MTRL_RESPONSIBLE_ID  INTEGER,
WAREHOUSE_ID         INTEGER                        not null,
DELIVERY             NUMERIC(15,2)                  not null,
TAX_DELIVERY         NUMERIC(15,2)                  not null,
DELIVERY_WITH_TAX    NUMERIC(15,2)                  not null,
CURRENCY_DELIVERY    NUMERIC(15,2)                  not null,
CURRENCY_TAX_DELIVERY NUMERIC(15,2)                  not null,
CURRENCY_DELIVERY_WITH_TAX NUMERIC(15,2)                  not null,
constraint PK_GOODS_OUTCOME primary key (ID)
);


INSERT INTO GOODS_OUTCOME (
 ID,
 MTRL_RESPONSIBLE_ID,
 WAREHOUSE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX
)
SELECT
 ID,
 RESPONSIBLE_ID,
 WAREHOUSE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX
FROM TMP_GOODS_OUTCOME;

DROP TABLE TMP_GOODS_OUTCOME;


/*==============================================================*/

create table TMP_INVENTORY_INCOME (
ID                   INTEGER                        not null,
WAREHOUSE_ID         INTEGER                        not null,
RESPONSIBLE_ID  INTEGER,
DELIVERY             NUMERIC(15,2)                  default 0 not null,
TAX_DELIVERY         NUMERIC(15,2)                  default 0 not null,
DELIVERY_WITH_TAX    NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY    NUMERIC(15,2)                  default 0 not null,
CURRENCY_TAX_DELIVERY NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY_WITH_TAX NUMERIC(15,2)                  default 0 not null
);

INSERT INTO TMP_INVENTORY_INCOME (
 ID,
 WAREHOUSE_ID,
 RESPONSIBLE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX
)
SELECT 
 ID,
 WAREHOUSE_ID,
 RESPONSIBLE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX
FROM INVENTORY_INCOME;

DROP TABLE INVENTORY_INCOME;

create table INVENTORY_INCOME (
ID                   INTEGER                        not null,
WAREHOUSE_ID         INTEGER                        not null,
MTRL_RESPONSIBLE_ID  INTEGER,
DELIVERY             NUMERIC(15,2)                  default 0 not null,
TAX_DELIVERY         NUMERIC(15,2)                  default 0 not null,
DELIVERY_WITH_TAX    NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY    NUMERIC(15,2)                  default 0 not null,
CURRENCY_TAX_DELIVERY NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY_WITH_TAX NUMERIC(15,2)                  default 0 not null,
constraint PK_INVENTORY_INCOME primary key (ID)
);


INSERT INTO INVENTORY_INCOME (
 ID,
 WAREHOUSE_ID,
 MTRL_RESPONSIBLE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX
)
SELECT 
 ID,
 WAREHOUSE_ID,
 RESPONSIBLE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX
FROM TMP_INVENTORY_INCOME;

DROP TABLE TMP_INVENTORY_INCOME;


/*==============================================================*/


create table TMP_INVENTORY_OUTCOME (
ID                   INTEGER                        not null,
WAREHOUSE_ID         INTEGER                        not null,
RESPONSIBLE_ID  INTEGER,
DELIVERY             NUMERIC(15,2)                  default 0 not null,
TAX_DELIVERY         NUMERIC(15,2)                  default 0 not null,
DELIVERY_WITH_TAX    NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY    NUMERIC(15,2)                  default 0 not null,
CURRENCY_TAX_DELIVERY NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY_WITH_TAX NUMERIC(15,2)                  default 0 not null
);

INSERT INTO TMP_INVENTORY_OUTCOME (
 ID,
 WAREHOUSE_ID,
 RESPONSIBLE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX
)
SELECT 
 ID,
 WAREHOUSE_ID,
 RESPONSIBLE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX
FROM INVENTORY_OUTCOME;

DROP TABLE INVENTORY_OUTCOME;

create table INVENTORY_OUTCOME (
ID                   INTEGER                        not null,
WAREHOUSE_ID         INTEGER                        not null,
MTRL_RESPONSIBLE_ID  INTEGER,
DELIVERY             NUMERIC(15,2)                  default 0 not null,
TAX_DELIVERY         NUMERIC(15,2)                  default 0 not null,
DELIVERY_WITH_TAX    NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY    NUMERIC(15,2)                  default 0 not null,
CURRENCY_TAX_DELIVERY NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY_WITH_TAX NUMERIC(15,2)                  default 0 not null,
constraint PK_INVENTORY_OUTCOME primary key (ID)
);

INSERT INTO INVENTORY_OUTCOME (
 ID,
 WAREHOUSE_ID,
 MTRL_RESPONSIBLE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX
)
SELECT 
 ID,
 WAREHOUSE_ID,
 RESPONSIBLE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX
FROM TMP_INVENTORY_OUTCOME;


DROP TABLE TMP_INVENTORY_OUTCOME;



/*==============================================================*/


create table TMP_INVENTORY_MOVE (
ID                   INTEGER                        not null,
INCOME_WAREHOUSE_ID  INTEGER                        not null,
OUTCOME_WAREHOUSE_ID INTEGER                        not null,
INCOME_RESPONSIBLE_ID INTEGER,
OUTCOME_RESPONSIBLE_ID INTEGER
);

INSERT INTO TMP_INVENTORY_MOVE (
 ID,
 INCOME_WAREHOUSE_ID,
 OUTCOME_WAREHOUSE_ID,
 INCOME_RESPONSIBLE_ID,
 OUTCOME_RESPONSIBLE_ID
)
SELECT 
 ID,
 INCOME_WAREHOUSE_ID,
 OUTCOME_WAREHOUSE_ID,
 INCOME_RESPONSIBLE_ID,
 OUTCOME_RESPONSIBLE_ID
FROM INVENTORY_MOVE;

DROP TABLE INVENTORY_MOVE;

create table INVENTORY_MOVE (
ID                   INTEGER                        not null,
INCOME_WAREHOUSE_ID  INTEGER                        not null,
OUTCOME_WAREHOUSE_ID INTEGER                        not null,
INCOME_MTRL_RESPONSIBLE_ID INTEGER,
OUTCOME_MTRL_RESPONSIBLE_ID INTEGER,
constraint PK_INVENTORY_MOVE primary key (ID)
);

INSERT INTO INVENTORY_MOVE (
 ID,
 INCOME_WAREHOUSE_ID,
 OUTCOME_WAREHOUSE_ID,
 INCOME_MTRL_RESPONSIBLE_ID,
 OUTCOME_MTRL_RESPONSIBLE_ID
)
SELECT 
 ID,
 INCOME_WAREHOUSE_ID,
 OUTCOME_WAREHOUSE_ID,
 INCOME_RESPONSIBLE_ID,
 OUTCOME_RESPONSIBLE_ID
FROM TMP_INVENTORY_MOVE;

DROP TABLE TMP_INVENTORY_MOVE;

/*==============================================================*/

create table TMP_INVENTORY_REST (
ID                   INTEGER                        not null,
RESPONSIBLE_ID  INTEGER,
WAREHOUSE_ID         INTEGER                        not null
);

INSERT INTO TMP_INVENTORY_REST (
 ID,
 RESPONSIBLE_ID,
 WAREHOUSE_ID
)
SELECT
 ID,
 RESPONSIBLE_ID,
 WAREHOUSE_ID
FROM INVENTORY_REST;

DROP TABLE INVENTORY_REST;

create table INVENTORY_REST (
ID                   INTEGER                        not null,
MTRL_RESPONSIBLE_ID  INTEGER,
WAREHOUSE_ID         INTEGER                        not null,
constraint PK_INVENTORY_REST primary key (ID)
);

INSERT INTO INVENTORY_REST (
 ID,
 MTRL_RESPONSIBLE_ID,
 WAREHOUSE_ID
)
SELECT
 ID,
 RESPONSIBLE_ID,
 WAREHOUSE_ID
FROM TMP_INVENTORY_REST;

DROP TABLE TMP_INVENTORY_REST;



/*==============================================================*/

create table TMP_INVENTORY_WRITEOFF (
ID                   INTEGER                        not null,
WAREHOUSE_ID         INTEGER                        not null,
RESPONSIBLE_ID  INTEGER
);

INSERT INTO TMP_INVENTORY_WRITEOFF (
 ID,
 WAREHOUSE_ID,
 RESPONSIBLE_ID
)
SELECT 
 ID,
 WAREHOUSE_ID,
 RESPONSIBLE_ID
FROM INVENTORY_WRITEOFF;

DROP TABLE INVENTORY_WRITEOFF;

create table INVENTORY_WRITEOFF (
ID                   INTEGER                        not null,
WAREHOUSE_ID         INTEGER                        not null,
MTRL_RESPONSIBLE_ID  INTEGER,
constraint PK_INVENTORY_WRITEOFF primary key (ID)
);

INSERT INTO INVENTORY_WRITEOFF (
 ID,
 WAREHOUSE_ID,
 MTRL_RESPONSIBLE_ID
)
SELECT 
 ID,
 WAREHOUSE_ID,
 RESPONSIBLE_ID
FROM TMP_INVENTORY_WRITEOFF;

DROP TABLE TMP_INVENTORY_WRITEOFF;


/*==============================================================*/


create table TMP_PURCHASE_ORDER (
ID                   INTEGER                        not null,
PRICE_TYPE_ID        INTEGER,
WAREHOUSE_ID         INTEGER                        not null,
RESPONSIBLE_ID  INTEGER,
DELIVERY             NUMERIC(15,2)                  default 0 not null,
TAX_DELIVERY         NUMERIC(15,2)                  default 0 not null,
DELIVERY_WITH_TAX    NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY    NUMERIC(15,2)                  default 0 not null,
CURRENCY_TAX_DELIVERY NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY_WITH_TAX NUMERIC(15,2)                  default 0 not null,
CORRECT_PRICE_TYPE   CHAR(3),
DISCOUNT_PERCENT     NUMERIC(6,2)                   default 0 not null,
MARKUP_PERCENT       NUMERIC(6,2)                   default 0 not null,
IS_PAID              CHAR(1)                        default 'N' not null
);

INSERT INTO TMP_PURCHASE_ORDER (
 ID,
 PRICE_TYPE_ID,
 WAREHOUSE_ID,
 RESPONSIBLE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX,
 CORRECT_PRICE_TYPE,
 DISCOUNT_PERCENT,
 MARKUP_PERCENT,
 IS_PAID
)
SELECT 
 ID,
 PRICE_TYPE_ID,
 WAREHOUSE_ID,
 RESPONSIBLE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX,
 CORRECT_PRICE_TYPE,
 DISCOUNT_PERCENT,
 MARKUP_PERCENT,
 IS_PAID
FROM PURCHASE_ORDER;

DROP TABLE PURCHASE_ORDER;

create table PURCHASE_ORDER (
ID                   INTEGER                        not null,
PRICE_TYPE_ID        INTEGER,
WAREHOUSE_ID         INTEGER                        not null,
MTRL_RESPONSIBLE_ID  INTEGER,
DELIVERY             NUMERIC(15,2)                  default 0 not null,
TAX_DELIVERY         NUMERIC(15,2)                  default 0 not null,
DELIVERY_WITH_TAX    NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY    NUMERIC(15,2)                  default 0 not null,
CURRENCY_TAX_DELIVERY NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY_WITH_TAX NUMERIC(15,2)                  default 0 not null,
CORRECT_PRICE_TYPE   CHAR(3),
DISCOUNT_PERCENT     NUMERIC(6,2)                   default 0 not null,
MARKUP_PERCENT       NUMERIC(6,2)                   default 0 not null,
IS_PAID              CHAR(1)                        default 'N' not null,
constraint PK_PURCHASE_ORDER primary key (ID)
);


INSERT INTO PURCHASE_ORDER (
 ID,
 PRICE_TYPE_ID,
 WAREHOUSE_ID,
 MTRL_RESPONSIBLE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX,
 CORRECT_PRICE_TYPE,
 DISCOUNT_PERCENT,
 MARKUP_PERCENT,
 IS_PAID
)
SELECT 
 ID,
 PRICE_TYPE_ID,
 WAREHOUSE_ID,
 RESPONSIBLE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX,
 CORRECT_PRICE_TYPE,
 DISCOUNT_PERCENT,
 MARKUP_PERCENT,
 IS_PAID
FROM TMP_PURCHASE_ORDER;

DROP TABLE TMP_PURCHASE_ORDER;


/*==============================================================*/

create table TMP_PURCHASE_PLAN (
ID                   INTEGER                        not null,
PRICE_TYPE_ID        INTEGER,
RESPONSIBLE_ID  INTEGER
);

INSERT INTO TMP_PURCHASE_PLAN (
 ID,
 PRICE_TYPE_ID,
 RESPONSIBLE_ID
 )
SELECT 
 ID,
 PRICE_TYPE_ID,
 RESPONSIBLE_ID
FROM PURCHASE_PLAN;

DROP TABLE PURCHASE_PLAN;
 
create table PURCHASE_PLAN (
ID                   INTEGER                        not null,
PRICE_TYPE_ID        INTEGER,
MTRL_RESPONSIBLE_ID  INTEGER,
constraint PK_PURCHASE_PLAN primary key (ID)
);

INSERT INTO PURCHASE_PLAN (
 ID,
 PRICE_TYPE_ID,
 MTRL_RESPONSIBLE_ID
 )
SELECT 
 ID,
 PRICE_TYPE_ID,
 RESPONSIBLE_ID
FROM TMP_PURCHASE_PLAN;

DROP TABLE TMP_PURCHASE_PLAN;



/*==============================================================*/

create table TMP_SALE_ORDER (
ID                   INTEGER                        not null,
WAREHOUSE_ID         INTEGER                        not null,
PRICE_TYPE_ID        INTEGER,
DELIVERY_ADDRESS_ID  INTEGER,
RESPONSIBLE_ID  INTEGER,
DELIVERY             NUMERIC(15,2)                  default 0 not null,
TAX_DELIVERY         NUMERIC(15,2)                  default 0 not null,
DELIVERY_WITH_TAX    NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY    NUMERIC(15,2)                  default 0 not null,
CURRENCY_TAX_DELIVERY NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY_WITH_TAX NUMERIC(15,2)                  default 0 not null,
CORRECT_PRICE_TYPE   CHAR(3),
DISCOUNT_PERCENT     NUMERIC(6,2)                   default 0 not null,
MARKUP_PERCENT       NUMERIC(6,2)                   default 0 not null,
IS_PAID              CHAR(1)                        default 'N' not null
);

INSERT INTO TMP_SALE_ORDER (
 ID,
 WAREHOUSE_ID,
 PRICE_TYPE_ID,
 DELIVERY_ADDRESS_ID,
 RESPONSIBLE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX,
 CORRECT_PRICE_TYPE,
 DISCOUNT_PERCENT,
 MARKUP_PERCENT,
 IS_PAID
)
SELECT
 ID,
 WAREHOUSE_ID,
 PRICE_TYPE_ID,
 DELIVERY_ADDRESS_ID,
 RESPONSIBLE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX,
 CORRECT_PRICE_TYPE,
 DISCOUNT_PERCENT,
 MARKUP_PERCENT,
 IS_PAID
FROM SALE_ORDER;

DROP TABLE SALE_ORDER;

create table SALE_ORDER (
ID                   INTEGER                        not null,
WAREHOUSE_ID         INTEGER                        not null,
PRICE_TYPE_ID        INTEGER,
DELIVERY_ADDRESS_ID  INTEGER,
MTRL_RESPONSIBLE_ID  INTEGER,
DELIVERY             NUMERIC(15,2)                  default 0 not null,
TAX_DELIVERY         NUMERIC(15,2)                  default 0 not null,
DELIVERY_WITH_TAX    NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY    NUMERIC(15,2)                  default 0 not null,
CURRENCY_TAX_DELIVERY NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY_WITH_TAX NUMERIC(15,2)                  default 0 not null,
CORRECT_PRICE_TYPE   CHAR(3),
DISCOUNT_PERCENT     NUMERIC(6,2)                   default 0 not null,
MARKUP_PERCENT       NUMERIC(6,2)                   default 0 not null,
IS_PAID              CHAR(1)                        default 'N' not null,
constraint PK_SALE_ORDER primary key (ID)
);


INSERT INTO SALE_ORDER (
 ID,
 WAREHOUSE_ID,
 PRICE_TYPE_ID,
 DELIVERY_ADDRESS_ID,
 MTRL_RESPONSIBLE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX,
 CORRECT_PRICE_TYPE,
 DISCOUNT_PERCENT,
 MARKUP_PERCENT,
 IS_PAID
)
SELECT
 ID,
 WAREHOUSE_ID,
 PRICE_TYPE_ID,
 DELIVERY_ADDRESS_ID,
 RESPONSIBLE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX,
 CORRECT_PRICE_TYPE,
 DISCOUNT_PERCENT,
 MARKUP_PERCENT,
 IS_PAID
FROM TMP_SALE_ORDER;

DROP TABLE TMP_SALE_ORDER;




/*==============================================================*/


create table TMP_SALE_PLAN (
ID                   INTEGER                        not null,
PRICE_TYPE_ID        INTEGER,
RESPONSIBLE_ID  INTEGER
);

INSERT INTO TMP_SALE_PLAN (
 ID,
 PRICE_TYPE_ID,
 RESPONSIBLE_ID
)
SELECT  
 ID,
 PRICE_TYPE_ID,
 RESPONSIBLE_ID
FROM SALE_PLAN;

DROP TABLE SALE_PLAN;

create table SALE_PLAN (
ID                   INTEGER                        not null,
PRICE_TYPE_ID        INTEGER,
MTRL_RESPONSIBLE_ID  INTEGER,
constraint PK_SALE_PLAN primary key (ID)
);

INSERT INTO SALE_PLAN (
 ID,
 PRICE_TYPE_ID,
 MTRL_RESPONSIBLE_ID
)
SELECT  
 ID,
 PRICE_TYPE_ID,
 RESPONSIBLE_ID
FROM TMP_SALE_PLAN;

DROP TABLE TMP_SALE_PLAN;



/*==============================================================*/

create table TMP_WAREHOUSE_MOVE (
ID                   INTEGER                        not null,
RESPONSIBLE_ID  INTEGER,
OWNER_ID             INTEGER                        not null,
WAREHOUSE_ID         INTEGER                        not null,
MOVE_TYPE            VARCHAR(20)
);

INSERT INTO TMP_WAREHOUSE_MOVE (
 ID,
 RESPONSIBLE_ID,
 OWNER_ID,
 WAREHOUSE_ID,
 MOVE_TYPE
)
SELECT
 ID,
 RESPONSIBLE_ID,
 OWNER_ID,
 WAREHOUSE_ID,
 MOVE_TYPE
FROM WAREHOUSE_MOVE;

DROP TABLE WAREHOUSE_MOVE;

create table WAREHOUSE_MOVE (
ID                   INTEGER                        not null,
MTRL_RESPONSIBLE_ID  INTEGER,
OWNER_ID             INTEGER                        not null,
WAREHOUSE_ID         INTEGER                        not null,
MOVE_TYPE            VARCHAR(20),
constraint PK_WAREHOUSE_MOVE primary key (ID)
);

INSERT INTO WAREHOUSE_MOVE (
 ID,
 MTRL_RESPONSIBLE_ID,
 OWNER_ID,
 WAREHOUSE_ID,
 MOVE_TYPE
)
SELECT
 ID,
 RESPONSIBLE_ID,
 OWNER_ID,
 WAREHOUSE_ID,
 MOVE_TYPE
FROM TMP_WAREHOUSE_MOVE;

DROP TABLE TMP_WAREHOUSE_MOVE;


/*==============================================================*/

create table MTRL_RESPONSIBLE (
ID                   INTEGER                        not null,
CONTACT_ID           INTEGER                        not null,
WAREHOUSE_ID         INTEGER,
ORGANIZATION_ID      INTEGER                        not null,
constraint PK_MTRL_RESPONSIBLE primary key (ID)
);

INSERT INTO MTRL_RESPONSIBLE (
 ID,
 CONTACT_ID,
 WAREHOUSE_ID,
 ORGANIZATION_ID
)
SELECT 
 ID,
 CONTACT_ID,
 WAREHOUSE_ID,
 ORGANIZATION_ID
FROM RESPONSIBLE;

DROP TABLE RESPONSIBLE;


/*==============================================================*/

DROP TABLE M_PRODUCT_DETAIL_REGISTER;

create table M_PRODUCT_DETAIL_REGISTER (
PRODUCT_ID           INTEGER                        not null,
WAREHOUSE_ID         INTEGER                        not null,
MTRL_RESPONSIBLE_ID  INTEGER,
DEBIT_QUANTITY       NUMERIC(9,4)                   not null,
CREDIT_QUANTITY      NUMERIC(9,4)                   not null,
DEBIT_AMOUNT         NUMERIC(15,2)                  not null,
CREDIT_AMOUNT        NUMERIC(15,2)                  not null
);


/*==============================================================*/

DROP TABLE M_PRODUCT_DETAIL_REGISTER_ID;

create table M_PRODUCT_DETAIL_REGISTER_ID (
PRODUCT_ID           INTEGER                        not null,
WAREHOUSE_ID         INTEGER                        not null,
MTRL_RESPONSIBLE_ID  INTEGER
);

/*==============================================================*/

DROP TABLE M_PRODUCT_DETAIL_REGISTER_SUM;

create table M_PRODUCT_DETAIL_REGISTER_SUM (
PRODUCT_ID           INTEGER                        not null,
WAREHOUSE_ID         INTEGER                        not null,
MTRL_RESPONSIBLE_ID  INTEGER,
DEBIT_QUANTITY       NUMERIC(9,4)                   not null,
CREDIT_QUANTITY      NUMERIC(9,4)                   not null,
DEBIT_AMOUNT         NUMERIC(15,2)                  not null,
CREDIT_AMOUNT        NUMERIC(15,2)                  not null
);


/*==============================================================*/

create table TMP_PRODUCT_DETAIL_REGISTER (
ID                   INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
ORGANIZATION_ID      INTEGER                        not null,
WAREHOUSE_ID         INTEGER                        not null,
RESPONSIBLE_ID  INTEGER,
PERIOD_ID            INTEGER                        not null,
DEBIT_QUANTITY       NUMERIC(9,4)                   not null,
CREDIT_QUANTITY      NUMERIC(9,4)                   not null,
DEBIT_AMOUNT         NUMERIC(15,2)                  not null,
CREDIT_AMOUNT        NUMERIC(15,2)                  not null,
QUANTITY             NUMERIC(9,4)                   default 0 not null,
PRICE                NUMERIC(9,2)                   default 0 not null,
AMOUNT               NUMERIC(15,2)                  default 0 not null
);

INSERT INTO TMP_PRODUCT_DETAIL_REGISTER (
 ID,
 PRODUCT_ID,
 ORGANIZATION_ID,
 WAREHOUSE_ID,
 RESPONSIBLE_ID,
 PERIOD_ID,
 DEBIT_QUANTITY,
 CREDIT_QUANTITY,
 DEBIT_AMOUNT,
 CREDIT_AMOUNT,
 QUANTITY,
 PRICE,
 AMOUNT
)
SELECT
 ID,
 PRODUCT_ID,
 ORGANIZATION_ID,
 WAREHOUSE_ID,
 RESPONSIBLE_ID,
 PERIOD_ID,
 DEBIT_QUANTITY,
 CREDIT_QUANTITY,
 DEBIT_AMOUNT,
 CREDIT_AMOUNT,
 QUANTITY,
 PRICE,
 AMOUNT
FROM PRODUCT_DETAIL_REGISTER;

DROP TABLE PRODUCT_DETAIL_REGISTER;


create table PRODUCT_DETAIL_REGISTER (
ID                   INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
ORGANIZATION_ID      INTEGER                        not null,
WAREHOUSE_ID         INTEGER                        not null,
MTRL_RESPONSIBLE_ID  INTEGER,
PERIOD_ID            INTEGER                        not null,
DEBIT_QUANTITY       NUMERIC(9,4)                   not null,
CREDIT_QUANTITY      NUMERIC(9,4)                   not null,
DEBIT_AMOUNT         NUMERIC(15,2)                  not null,
CREDIT_AMOUNT        NUMERIC(15,2)                  not null,
QUANTITY             NUMERIC(9,4)                   default 0 not null,
PRICE                NUMERIC(9,2)                   default 0 not null,
AMOUNT               NUMERIC(15,2)                  default 0 not null,
constraint PK_PRODUCT_DETAIL_REGISTER primary key (ID)
);


INSERT INTO PRODUCT_DETAIL_REGISTER (
 ID,
 PRODUCT_ID,
 ORGANIZATION_ID,
 WAREHOUSE_ID,
 MTRL_RESPONSIBLE_ID,
 PERIOD_ID,
 DEBIT_QUANTITY,
 CREDIT_QUANTITY,
 DEBIT_AMOUNT,
 CREDIT_AMOUNT,
 QUANTITY,
 PRICE,
 AMOUNT
)
SELECT
 ID,
 PRODUCT_ID,
 ORGANIZATION_ID,
 WAREHOUSE_ID,
 RESPONSIBLE_ID,
 PERIOD_ID,
 DEBIT_QUANTITY,
 CREDIT_QUANTITY,
 DEBIT_AMOUNT,
 CREDIT_AMOUNT,
 QUANTITY,
 PRICE,
 AMOUNT
FROM TMP_PRODUCT_DETAIL_REGISTER;

DROP TABLE TMP_PRODUCT_DETAIL_REGISTER;



/*==============================================================*/

/*==============================================================*/


create table TMP_DOCUMENT (
ID                   INTEGER                        not null,
PARTNER_ID           INTEGER,
ORGANIZATION_ID      INTEGER                        not null,
DEPARTMENT_ID        INTEGER,
DOCUMENT_TYPE_ID     INTEGER                        not null,
DOCUMENT_STATUS_ID   INTEGER,
PERIOD_ID            INTEGER                        not null,
USER_ID              INTEGER,
REASON_DOCUMENT_ID   INTEGER,
CONTRACT_ID          INTEGER,
PROJECT_ID           INTEGER,
CREATE_TIMESTAMP     DATE,
CREATE_USER_ID       INTEGER,
UPDATE_TIMESTAMP     DATE,
UPDATE_USER_ID       INTEGER,
DOCUMENT_NO          VARCHAR(20),
DOCUMENT_DATE        DATE,
REASON               VARCHAR(64),
NOTE                 VARCHAR(255),
IS_COMPLETE          CHAR(1)                        default 'N' not null
);

INSERT INTO TMP_DOCUMENT (
 ID,
 PARTNER_ID,
 ORGANIZATION_ID,
 DEPARTMENT_ID,
 DOCUMENT_TYPE_ID,
 DOCUMENT_STATUS_ID,
 PERIOD_ID,
 USER_ID,
 REASON_DOCUMENT_ID,
 CONTRACT_ID,
 PROJECT_ID,
 CREATE_TIMESTAMP,
 CREATE_USER_ID,
 UPDATE_TIMESTAMP,
 UPDATE_USER_ID,
 DOCUMENT_NO,
 DOCUMENT_DATE,
 REASON,
 NOTE,
 IS_COMPLETE  
)
SELECT
 ID,
 PARTNER_ID,
 ORGANIZATION_ID,
 DEPARTMENT_ID,
 DOCUMENT_TYPE_ID,
 DOCUMENT_STATUS_ID,
 PERIOD_ID,
 USER_ID,
 REASON_DOCUMENT_ID,
 CONTRACT_ID,
 PROJECT_ID,
 CREATE_TIMESTAMP,
 CREATE_USER_ID,
 UPDATE_TIMESTAMP,
 UPDATE_USER_ID,
 DOCUMENT_NO,
 DOCUMENT_DATE,
 REASON,
 NOTE,
 IS_COMPLETE  
FROM DOCUMENT;

DROP TABLE DOCUMENT;

create table DOCUMENT (
ID                   INTEGER                        not null,
PARTNER_ID           INTEGER,
ORGANIZATION_ID      INTEGER                        not null,
DEPARTMENT_ID        INTEGER,
DOCUMENT_TYPE_ID     INTEGER                        not null,
DOCUMENT_STATUS_ID   INTEGER,
PERIOD_ID            INTEGER                        not null,
RESPONSIBLE_ID       INTEGER,
USER_ID              INTEGER,
REASON_DOCUMENT_ID   INTEGER,
CONTRACT_ID          INTEGER,
PROJECT_ID           INTEGER,
CREATE_TIMESTAMP     DATE,
CREATE_USER_ID       INTEGER,
UPDATE_TIMESTAMP     DATE,
UPDATE_USER_ID       INTEGER,
DOCUMENT_NO          VARCHAR(20),
DOCUMENT_DATE        DATE,
REASON               VARCHAR(64),
NOTE                 VARCHAR(255),
IS_COMPLETE          CHAR(1)                        default 'N' not null,
constraint PK_DOCUMENT primary key (ID)
);



INSERT INTO DOCUMENT (
 ID,
 PARTNER_ID,
 ORGANIZATION_ID,
 DEPARTMENT_ID,
 DOCUMENT_TYPE_ID,
 DOCUMENT_STATUS_ID,
 PERIOD_ID,
 RESPONSIBLE_ID,
 USER_ID,
 REASON_DOCUMENT_ID,
 CONTRACT_ID,
 PROJECT_ID,
 CREATE_TIMESTAMP,
 CREATE_USER_ID,
 UPDATE_TIMESTAMP,
 UPDATE_USER_ID,
 DOCUMENT_NO,
 DOCUMENT_DATE,
 REASON,
 NOTE,
 IS_COMPLETE  
)
SELECT
 ID,
 PARTNER_ID,
 ORGANIZATION_ID,
 DEPARTMENT_ID,
 DOCUMENT_TYPE_ID,
 DOCUMENT_STATUS_ID,
 PERIOD_ID,
 NULL,
 USER_ID,
 REASON_DOCUMENT_ID,
 CONTRACT_ID,
 PROJECT_ID,
 CREATE_TIMESTAMP,
 CREATE_USER_ID,
 UPDATE_TIMESTAMP,
 UPDATE_USER_ID,
 DOCUMENT_NO,
 DOCUMENT_DATE,
 REASON,
 NOTE,
 IS_COMPLETE  
FROM TMP_DOCUMENT;

DROP TABLE TMP_DOCUMENT;


/*==============================================================*/
/* 2011-06-03                                                   */
/*==============================================================*/

ALTER TABLE SALE_PLAN
 DROP MTRL_RESPONSIBLE_ID;
 
ALTER TABLE PURCHASE_PLAN
 DROP MTRL_RESPONSIBLE_ID;

/*==============================================================*/ 
 
 
create table TMP_SALE_ORDER (
ID                   INTEGER                        not null,
WAREHOUSE_ID         INTEGER,
PRICE_TYPE_ID        INTEGER,
DELIVERY_ADDRESS_ID  INTEGER,
MTRL_RESPONSIBLE_ID  INTEGER,
DELIVERY             NUMERIC(15,2)                  default 0 not null,
TAX_DELIVERY         NUMERIC(15,2)                  default 0 not null,
DELIVERY_WITH_TAX    NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY    NUMERIC(15,2)                  default 0 not null,
CURRENCY_TAX_DELIVERY NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY_WITH_TAX NUMERIC(15,2)                  default 0 not null,
CORRECT_PRICE_TYPE   CHAR(3),
DISCOUNT_PERCENT     NUMERIC(6,2)                   default 0 not null,
MARKUP_PERCENT       NUMERIC(6,2)                   default 0 not null,
IS_PAID              CHAR(1)                        default 'N' not null
);

INSERT INTO TMP_SALE_ORDER (
 ID,
 WAREHOUSE_ID,
 PRICE_TYPE_ID,
 DELIVERY_ADDRESS_ID,
 MTRL_RESPONSIBLE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX,
 CORRECT_PRICE_TYPE,
 DISCOUNT_PERCENT,
 MARKUP_PERCENT,
 IS_PAID 
)
SELECT
 ID,
 WAREHOUSE_ID,
 PRICE_TYPE_ID,
 DELIVERY_ADDRESS_ID,
 MTRL_RESPONSIBLE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX,
 CORRECT_PRICE_TYPE,
 DISCOUNT_PERCENT,
 MARKUP_PERCENT,
 IS_PAID 
FROM SALE_ORDER;

DROP TABLE SALE_ORDER;


create table SALE_ORDER (
ID                   INTEGER                        not null,
WAREHOUSE_ID         INTEGER,
PRICE_TYPE_ID        INTEGER,
DELIVERY_ADDRESS_ID  INTEGER,
MTRL_RESPONSIBLE_ID  INTEGER,
DELIVERY             NUMERIC(15,2)                  default 0 not null,
TAX_DELIVERY         NUMERIC(15,2)                  default 0 not null,
DELIVERY_WITH_TAX    NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY    NUMERIC(15,2)                  default 0 not null,
CURRENCY_TAX_DELIVERY NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY_WITH_TAX NUMERIC(15,2)                  default 0 not null,
CORRECT_PRICE_TYPE   CHAR(3),
DISCOUNT_PERCENT     NUMERIC(6,2)                   default 0 not null,
MARKUP_PERCENT       NUMERIC(6,2)                   default 0 not null,
IS_PAID              CHAR(1)                        default 'N' not null,
constraint PK_SALE_ORDER primary key (ID)
);
 
 

INSERT INTO SALE_ORDER (
 ID,
 WAREHOUSE_ID,
 PRICE_TYPE_ID,
 DELIVERY_ADDRESS_ID,
 MTRL_RESPONSIBLE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX,
 CORRECT_PRICE_TYPE,
 DISCOUNT_PERCENT,
 MARKUP_PERCENT,
 IS_PAID 
)
SELECT
 ID,
 WAREHOUSE_ID,
 PRICE_TYPE_ID,
 DELIVERY_ADDRESS_ID,
 MTRL_RESPONSIBLE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX,
 CORRECT_PRICE_TYPE,
 DISCOUNT_PERCENT,
 MARKUP_PERCENT,
 IS_PAID 
FROM TMP_SALE_ORDER;

DROP TABLE TMP_SALE_ORDER; 

/*==============================================================*/

create table TMP_PURCHASE_ORDER (
ID                   INTEGER                        not null,
PRICE_TYPE_ID        INTEGER,
WAREHOUSE_ID         INTEGER,
MTRL_RESPONSIBLE_ID  INTEGER,
DELIVERY             NUMERIC(15,2)                  default 0 not null,
TAX_DELIVERY         NUMERIC(15,2)                  default 0 not null,
DELIVERY_WITH_TAX    NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY    NUMERIC(15,2)                  default 0 not null,
CURRENCY_TAX_DELIVERY NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY_WITH_TAX NUMERIC(15,2)                  default 0 not null,
CORRECT_PRICE_TYPE   CHAR(3),
DISCOUNT_PERCENT     NUMERIC(6,2)                   default 0 not null,
MARKUP_PERCENT       NUMERIC(6,2)                   default 0 not null,
IS_PAID              CHAR(1)                        default 'N' not null
);

INSERT INTO TMP_PURCHASE_ORDER (
 ID,
 PRICE_TYPE_ID,
 WAREHOUSE_ID,
 MTRL_RESPONSIBLE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX,
 CORRECT_PRICE_TYPE,
 DISCOUNT_PERCENT,
 MARKUP_PERCENT,
 IS_PAID
)
SELECT
 ID,
 PRICE_TYPE_ID,
 WAREHOUSE_ID,
 MTRL_RESPONSIBLE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX,
 CORRECT_PRICE_TYPE,
 DISCOUNT_PERCENT,
 MARKUP_PERCENT,
 IS_PAID
FROM PURCHASE_ORDER;

DROP TABLE PURCHASE_ORDER;

create table PURCHASE_ORDER (
ID                   INTEGER                        not null,
PRICE_TYPE_ID        INTEGER,
WAREHOUSE_ID         INTEGER,
MTRL_RESPONSIBLE_ID  INTEGER,
DELIVERY             NUMERIC(15,2)                  default 0 not null,
TAX_DELIVERY         NUMERIC(15,2)                  default 0 not null,
DELIVERY_WITH_TAX    NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY    NUMERIC(15,2)                  default 0 not null,
CURRENCY_TAX_DELIVERY NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY_WITH_TAX NUMERIC(15,2)                  default 0 not null,
CORRECT_PRICE_TYPE   CHAR(3),
DISCOUNT_PERCENT     NUMERIC(6,2)                   default 0 not null,
MARKUP_PERCENT       NUMERIC(6,2)                   default 0 not null,
IS_PAID              CHAR(1)                        default 'N' not null,
constraint PK_PURCHASE_ORDER primary key (ID)
);


INSERT INTO PURCHASE_ORDER (
 ID,
 PRICE_TYPE_ID,
 WAREHOUSE_ID,
 MTRL_RESPONSIBLE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX,
 CORRECT_PRICE_TYPE,
 DISCOUNT_PERCENT,
 MARKUP_PERCENT,
 IS_PAID
)
SELECT
 ID,
 PRICE_TYPE_ID,
 WAREHOUSE_ID,
 MTRL_RESPONSIBLE_ID,
 DELIVERY,
 TAX_DELIVERY,
 DELIVERY_WITH_TAX,
 CURRENCY_DELIVERY,
 CURRENCY_TAX_DELIVERY,
 CURRENCY_DELIVERY_WITH_TAX,
 CORRECT_PRICE_TYPE,
 DISCOUNT_PERCENT,
 MARKUP_PERCENT,
 IS_PAID
FROM TMP_PURCHASE_ORDER;

DROP TABLE TMP_PURCHASE_ORDER;

/*==============================================================*/

create table TMP_SALE_SERV (
ID                   INTEGER                        not null
);

INSERT INTO TMP_SALE_SERV (
 ID
)
SELECT
 ID
FROM SALE_SERV;

DROP TABLE SALE_SERV;

create table SALE_SERV (
ID                   INTEGER                        not null,
MTRL_RESPONSIBLE_ID  INTEGER,
WAREHOUSE_ID         INTEGER,
constraint PK_SALE_SERV primary key (ID)
);

INSERT INTO SALE_SERV (
 ID
)
SELECT
 ID
FROM TMP_SALE_SERV;

DROP TABLE TMP_SALE_SERV;

/*==============================================================*/

create table TMP_PURCHASE_SERV (
ID                   INTEGER                        not null
);

INSERT INTO TMP_PURCHASE_SERV (
 ID
)
SELECT
 ID
FROM PURCHASE_SERV;

DROP TABLE PURCHASE_SERV;

create table PURCHASE_SERV (
ID                   INTEGER                        not null,
MTRL_RESPONSIBLE_ID  INTEGER,
WAREHOUSE_ID         INTEGER,
constraint PK_PURCHASE_SERV primary key (ID)
);

INSERT INTO PURCHASE_SERV (
 ID
)
SELECT
 ID
FROM TMP_PURCHASE_SERV;

DROP TABLE TMP_PURCHASE_SERV;



/*==============================================================*/
/* 2011-07-07                                                   */
/*==============================================================*/



/*==============================================================*/
/* Table: DOCUMENT                                              */
/*==============================================================*/
/*
CREATE_TIMESTAMP     DATETIME,
UPDATE_TIMESTAMP     DATETIME,
*/


/*==============================================================*/
/* Table: EMPLOYEE_PAYROLL                                      */
/*==============================================================*/
/*
CREATE_TIMESTAMP     DATETIME,
UPDATE_TIMESTAMP     DATETIME,
*/


/*==============================================================*/
/* Table: PIM_APPOINTMENT                                       */
/*==============================================================*/
/*
START_DATE_TIME      DATETIME                           not null,
END_DATE_TIME        DATETIME,
REMINDER_DATE_TIME   DATETIME,
*/



/*==============================================================*/
/* Table: PIM_EVENT                                             */
/*==============================================================*/
/*
EVENT_DATE_IME      DATETIME                           not null,
REMINDER_DATE_TIME   DATETIME,
*/



/*==============================================================*/
/* Table: PIM_NOTE                                              */
/*==============================================================*/
/*
NOTE_DATE_TIME       DATETIME                           not null,
*/


/*==============================================================*/
/* Table: PIM_REMINDER                                          */
/*==============================================================*/
/*
EVENT_DATE_TIME      DATETIME,
REMINDER_DATE_TIME   DATETIME,
*/



/*==============================================================*/
/* Table: PROJECT                                               */
/*==============================================================*/
/*
CREATE_TIMESTAMP     DATETIME,
UPDATE_TIMESTAMP     DATETIME,
*/


/*==============================================================*/
/* Table: TASK                                                  */
/*==============================================================*/

/*
ALARM_DATE_TIME -> REMINDER_DATE_TIME

CREATE_TIMESTAMP     DATETIME,
UPDATE_TIMESTAMP     DATETIME,
START_DATE_TIME      DATETIME,
END_DATE_TIME        DATETIME,
ACTUAL_END_DATE_TIME DATETIME,
ALARM_DATE_TIME      DATETIME,
*/


