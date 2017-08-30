
alter table CONTRACT
  drop PARTNER_ID;

 
/*==============================================================*/
/* 2009-05-07                                                   */
/* Rename image columns,                                        */ 
/* add locality address string to address table,                */
/* add currency rate table,                                     */
/* rename SYSTEM tables (SYSTEM_ -> SYS_ ),                     */
/* rename percent columns (PERCENT - > <CONCRETE>_PERCENT)      */
/*==============================================================*/

alter table PRODUCT
  add IMAGE_FILE_NAME  VARCHAR(50);
  
update PRODUCT set IMAGE_FILE_NAME = PRODUCT_IMAGE;
 
alter table PRODUCT
  drop PRODUCT_IMAGE;
  
  
alter table PARTNER
  add IMAGE_FILE_NAME  VARCHAR(50);
  
update PARTNER set IMAGE_FILE_NAME = PARTNER_IMAGE;

alter table PARTNER
  drop PARTNER_IMAGE;

 
 
alter table PERSON
  add IMAGE_FILE_NAME  VARCHAR(50);
  
update PERSON set IMAGE_FILE_NAME = PERSON_PHOTO;
 
alter table PERSON
  drop PERSON_PHOTO;
  
  
  
alter table ADDRESS
  add LOCALITY_ADDRESS_STRING VARCHAR(100);
 
 
  
create table CURRENCY_RATE (
  ID                   INTEGER                        not null,
  BASE_CURRENCY_ID     INTEGER                        not null,
  CURRENCY_ID          INTEGER                        not null,
  CURRENCY_RATE        NUMERIC(10,4)                  not null,
  CURRENCY_RATE_DATE   DATE                           not null,
  constraint PK_CURRENCY_RATE primary key (ID)
);



/* 0.1.8 version */
create table SYS_ATTR (
  ID                   INTEGER                        not null,
  ATTR_TYPE_ID         INTEGER                        not null,
  ENTITY_ID            CHAR(30)                       not null,
  OWNER_ID             INTEGER                        not null,
  STRING_VALUE         VARCHAR(255),
  INTEGER_VALUE        INTEGER,
  FLOAT_VALUE          FLOAT,
  DATE_VALUE           DATE,
  constraint PK_SYS_ATTR primary key (ID)
);

insert into SYS_ATTR  SELECT * FROM SYSTEM_ATTR;
drop table SYSTEM_ATTR;


/* 0.1.8 version */
create table SYS_ATTR_TYPE (
  ID                   INTEGER                        not null,
  ATTR_TYPE_GROUP_ID   INTEGER,
  ENTITY_ID            CHAR(30)                       not null,
  DATA_TYPE_ID         CHAR(30)                       not null,
  CODE                 VARCHAR(20),
  NAME                 VARCHAR(50),
  constraint PK_SYS_ATTR_TYPE primary key (ID)
);

insert into SYS_ATTR_TYPE  SELECT * FROM SYSTEM_ATTR_TYPE;
drop table SYSTEM_ATTR_TYPE;


/* 0.1.8 version */
create table SYS_ATTR_TYPE_GROUP (
  ID                   INTEGER                        not null,
  ENTITY_ID            CHAR(30)                       not null,
  CODE                 VARCHAR(20),
  NAME                 VARCHAR(50),
  constraint PK_SYS_ATTR_TYPE_GROUP primary key (ID)
);


insert into SYS_ATTR_TYPE_GROUP  SELECT * FROM SYSTEM_ATTR_TYPE_GROUP;
drop table SYSTEM_ATTR_TYPE_GROUP;



create table SYS_DAY (
  ID                   INTEGER                        not null,
  DAY_NUMBER           INTEGER                        not null,
  constraint PK_SYS_DAY primary key (ID)
);

insert into SYS_DAY  SELECT * FROM SYSTEM_DAY;
drop table SYSTEM_DAY;



create table SYS_ENTITY (
  ID                   CHAR(30)                       not null,
  ENTITY_TYPE_ID       CHAR(30)                       not null,
  CODE                 VARCHAR(30)                    not null,
  NAME                 VARCHAR(50)                    not null,
  ENTITY_CLASS         CHAR(30),
  ENTITY_PACKAGE       CHAR(30),
  IS_ENABLE            CHAR(1)                        default 'N' not null,
  IS_BASE              CHAR(1)                        default 'N' not null,
  IS_BEAN              CHAR(1)                        default 'N' not null,
  IS_FORM              CHAR(1)                        default 'N' not null,
  IS_PERMISSION        CHAR(1)                        default 'N' not null,
  IS_SYSTEM            CHAR(1)                        default 'N' not null,
  IS_CUSTOM            CHAR(1)                        default 'N' not null,
  IS_CUSTOM_ATTRIBUTE  CHAR(1)                        default 'N' not null,
  IS_CACHE             CHAR(1)                        default 'N' not null,
  CACHE_EXPIRE_TIME    INTEGER                        default 0 not null,
  constraint PK_SYS_ENTITY primary key (ID)
);

insert into SYS_ENTITY  SELECT * FROM SYSTEM_ENTITY;
drop table SYSTEM_ENTITY;



create table SYS_ENTITY_TYPE (
  ID                   CHAR(30)                       not null,
  CODE                 VARCHAR(30)                    not null,
  NAME                 VARCHAR(50)                    not null,
  IS_CUSTOM            CHAR(1)                        default 'N' not null,
  IS_CUSTOM_ATTRIBUTE  CHAR(1)                        default 'N' not null,
  constraint PK_SYS_ENTITY_TYPE primary key (ID)
);

insert into SYS_ENTITY_TYPE  SELECT * FROM SYSTEM_ENTITY_TYPE;
drop table SYSTEM_ENTITY_TYPE;



create table SYS_ENUMERATION (
  ID                   INTEGER                        not null,
  ENTITY_ID            CHAR(30)                       not null,
  CODE                 VARCHAR(30),
  NAME                 VARCHAR(50)                    not null,
  DESCRIPTION          VARCHAR(255),
  constraint PK_SYS_ENUMERATION primary key (ID)
);

insert into SYS_ENUMERATION  SELECT * FROM SYSTEM_ENUMERATION;
drop table SYSTEM_ENUMERATION;


create table SYS_FILE (
  ID                   INTEGER                        not null,
  FILE_STORAGE_ID      INTEGER,
  ENTITY_ID            CHAR(30)                       not null,
  FILE_TYPE_ID         INTEGER,
  OWNER_ID             INTEGER                        not null,
  FILE_NAME            VARCHAR(255),
  NAME                 VARCHAR(50),
  DESCRIPTION          VARCHAR(255),
  constraint PK_SYS_FILE primary key (ID)
);

insert into SYS_FILE  SELECT * FROM SYSTEM_FILE;
drop table SYSTEM_FILE;


create table SYS_FILE_STORAGE (
  ID                   INTEGER                        not null,
  CODE                 VARCHAR(20),
  NAME                 VARCHAR(50),
  STORAGE_PATH         VARCHAR(255),
  constraint PK_SYS_FILE_STORAGE primary key (ID)
);

insert into SYS_FILE_STORAGE  SELECT * FROM SYSTEM_FILE_STORAGE;
drop table SYSTEM_FILE_STORAGE;


create table SYS_FILE_TYPE (
  ID                   INTEGER                        not null,
  CODE                 VARCHAR(20),
  NAME                 VARCHAR(50),
  FILE_EXT             VARCHAR(50),
  constraint PK_SYS_FILE_TYPE primary key (ID)
);

insert into SYS_FILE_TYPE  SELECT * FROM SYSTEM_FILE_TYPE;
drop table SYSTEM_FILE_TYPE;


create table SYS_IMAGE (
  ID                   INTEGER                        not null,
  ENTITY_ID            CHAR(30)                       not null,
  FILE_TYPE_ID         INTEGER,
  IMAGE_STORAGE_ID     INTEGER,
  OWNER_ID             INTEGER                        not null,
  FILE_PATH            VARCHAR(255),
  FILE_NAME            VARCHAR(50),
  constraint PK_SYS_IMAGE primary key (ID)
);

insert into SYS_IMAGE  SELECT * FROM SYSTEM_IMAGE;
drop table SYSTEM_IMAGE;


create table SYS_IMAGE_STORAGE (
  ID                   INTEGER                        not null,
  CODE                 VARCHAR(20),
  NAME                 VARCHAR(50),
  STORAGE_PATH         VARCHAR(255),
  constraint PK_SYS_IMAGE_STORAGE primary key (ID)
);

insert into SYS_IMAGE_STORAGE  SELECT * FROM SYSTEM_IMAGE_STORAGE;
drop table SYSTEM_IMAGE_STORAGE;


create table SYS_INFO (
  ID                   INTEGER                        not null,
  BRANCH_ID            INTEGER,
  SUPPLIER_ID          INTEGER,
  WAREHOUSE_ID         INTEGER,
  MATERIAL_RESPONSIBLE_ID INTEGER,
  INCOME_WAREHOUSE_ID  INTEGER,
  CURRENCY_ID          INTEGER                        not null,
  ORGANIZATION_ID      INTEGER                        not null,
  TAX_ID               INTEGER,
  PERIOD_ID            INTEGER                        not null,
  PARTNER_ID           INTEGER,
  OUTCOME_WAREHOUSE_ID INTEGER,
  CUSTOMER_ID          INTEGER,
  RESPONSIBLE_ID       INTEGER,
  UNIT_ID              INTEGER                        not null,
  IS_INIT              CHAR(1)                        default 'N' not null,
  APP_VERSION          VARCHAR(20)                    not null,
  DB_VERSION           VARCHAR(20)                    not null,
  IS_CALCULATE_ACCOUNTING CHAR(1)                        default 'N' not null,
  IS_MULTI_CURRENCIES  CHAR(1)                        default 'Y' not null,
  IS_INTERNATIONAL_ATTRIBUTES CHAR(1)                        default 'N' not null,
  IS_PROJECT_IN_DOCUMENT CHAR(1)                        default 'N' not null,
  IS_AUTO_CALCULATE_PROD_REST CHAR(1)                        default 'Y' not null,
  constraint PK_SYS_INFO primary key (ID)
);

insert into SYS_INFO  SELECT * FROM SYSTEM_INFO;
drop table SYSTEM_INFO;


create table SYS_MONTH (
  ID                   INTEGER                        not null,
  QUARTER_ID           INTEGER                        not null,
  MONTH_NUMBER         INTEGER                        not null,
  NAME                 VARCHAR(20),
  SHORT_NAME           VARCHAR(20),
  MOVE_NAME            VARCHAR(20),
  DAY_COUNT            INTEGER                        not null,
  constraint PK_SYS_MONTH primary key (ID)
);

insert into SYS_MONTH  SELECT * FROM SYSTEM_MONTH;
drop table SYSTEM_MONTH;



create table SYS_PERMISSION (
  ID                   INTEGER                        not null,
  SECURE_ENTITY_ID     INTEGER                        not null,
  ROLE_ID              INTEGER                        not null,
  IS_READ              CHAR(1)                        default 'N' not null,
  IS_WRITE             CHAR(1)                        default 'N' not null,
  IS_EXEC              CHAR(1)                        default 'N' not null,
  IS_TYPE_READ         CHAR(1)                        default 'N' not null,
  IS_TYPE_WRITE        CHAR(1)                        default 'N' not null,
  constraint PK_SYS_PERMISSION primary key (ID)
);

insert into SYS_PERMISSION  SELECT * FROM SYSTEM_PERMISSION;
drop table SYSTEM_PERMISSION;


create table SYS_PREFERENCE (
  ID                   INTEGER                        not null,
  DATE_FORMAT          VARCHAR(20),
  TIME_FORMAT          VARCHAR(20),
  NUMBER_FORMAT        VARCHAR(20),
  INTEGER_FORMAT       VARCHAR(20),
  CURRENCY_FORMAT      VARCHAR(20),
  PERCENT_FORMAT       VARCHAR(20),
  QUANTITY_FORMAT      VARCHAR(20),
  COEFFICIENT_FORMAT   VARCHAR(20),
  IS_CALC_TOTAL_IN_FORM CHAR(1)                        default 'N' not null,
  constraint PK_SYS_PREFERENCE primary key (ID)
);

insert into SYS_PREFERENCE  SELECT * FROM SYSTEM_PREFERENCE;
drop table SYSTEM_PREFERENCE;


create table SYS_QUARTER (
  ID                   INTEGER                        not null,
  QUARTER_NUMBER       INTEGER                        not null,
  NAME                 CHAR(3)                        not null,
  constraint PK_SYS_QUARTER primary key (ID)
);

insert into SYS_QUARTER  SELECT * FROM SYSTEM_QUARTER;
drop table SYSTEM_QUARTER;


create table SYS_REFERENCE (
  ID                   INTEGER                        not null,
  ENTITY_ID            CHAR(30)                       not null,
  CODE                 VARCHAR(30),
  NAME                 VARCHAR(50)                    not null,
  DESCRIPTION          VARCHAR(255),
  constraint PK_SYS_REFERENCE primary key (ID)
);

insert into SYS_REFERENCE  SELECT * FROM SYSTEM_REFERENCE;
drop table SYSTEM_REFERENCE;


create table SYS_ROLE (
  ID                   INTEGER                        not null,
  NAME                 VARCHAR(50)                    not null,
  NOTE                 VARCHAR(255),
  DEFAULT_UI_ID        CHAR(30),
  constraint PK_SYS_ROLE primary key (ID)
);

insert into SYS_ROLE  SELECT * FROM SYSTEM_ROLE;
drop table SYSTEM_ROLE;


create table SYS_ROLE_UI (
  ID                   INTEGER                        not null,
  ROLE_ID              INTEGER                        not null,
  UI_ID                VARCHAR(30)                    not null,
  constraint PK_SYS_ROLE_UI primary key (ID)
);

insert into SYS_ROLE_UI  SELECT * FROM SYSTEM_ROLE_UI;
drop table SYSTEM_ROLE_UI;


create table SYS_USER (
  ID                   INTEGER                        not null,
  ENTITY_ID            CHAR(30),
  USRNAME              VARCHAR(64)                    not null,
  PASSWD               VARCHAR(64)                    not null,
  OWNER_ID             INTEGER,
  REGISTRATION_DATE    DATE                           not null,
  NAME                 VARCHAR(50),
  DEFAULT_UI_ID        CHAR(30),
  constraint PK_SYS_USER primary key (ID)
);

insert into SYS_USER  SELECT * FROM SYSTEM_USER;
drop table SYSTEM_USER;


create table SYS_USER_ORG (
  ID                   INTEGER                        not null,
  ORGANIZATION_ID      INTEGER                        not null,
  USER_ID              INTEGER                        not null,
  constraint PK_SYS_USER_ORG primary key (ID)
);

insert into SYS_USER_ORG  SELECT * FROM SYSTEM_USER_ORG;
drop table SYSTEM_USER_ORG;


create table SYS_USER_ROLE (
  ID                   INTEGER                        not null,
  USER_ID              INTEGER                        not null,
  ROLE_ID              INTEGER                        not null,
  constraint PK_SYS_USER_ROLE primary key (ID)
);

insert into SYS_USER_ROLE  SELECT * FROM SYSTEM_USER_ROLE;
drop table SYSTEM_USER_ROLE;


create table SYS_VARIABLE (
  ID                   INTEGER                        not null,
  DATA_TYPE_ID         CHAR(30)                       not null,
  ENTITY_ID            CHAR(30),
  CODE                 VARCHAR(20)                    not null,
  NAME                 VARCHAR(50)                    not null,
  STRING_VALUE         VARCHAR(255),
  INTEGER_VALUE        INTEGER,
  FLOAT_VALUE          FLOAT,
  DATE_VALUE           DATE,
  IS_ENABLE            CHAR(1)                        default 'N' not null,
  IS_SYSTEM            CHAR(1)                        default 'N' not null,
  constraint PK_SYS_VARIABLE primary key (ID)
);

insert into SYS_VARIABLE  SELECT * FROM SYSTEM_VARIABLE;
drop table SYSTEM_VARIABLE;


alter table PRICE_TYPE
 add PRICE_PERCENT NUMERIC(6,2);
 
update PRICE_TYPE set PRICE_PERCENT = PERCENT;

alter table PRICE_TYPE
 drop PERCENT;

 
 
alter table PRODUCT_PRICE
 add PRICE_PERCENT NUMERIC(6,2);
 
update PRODUCT_PRICE set PRICE_PERCENT = PERCENT;

alter table PRODUCT_PRICE
 drop PERCENT;


 
alter table PAYROLL
 add PAYROLL_PERCENT NUMERIC(6,2);
 
update PAYROLL set PAYROLL_PERCENT = PERCENT;

alter table PAYROLL
 drop PERCENT;


 
alter table PAYROLL_ITEM
 add PAYROLL_PERCENT NUMERIC(6,2);
 
update PAYROLL_ITEM set PAYROLL_PERCENT = PERCENT;

alter table PAYROLL_ITEM
 drop PERCENT;


 
alter table EMPLOYEE_PAYROLL
 add PAYROLL_PERCENT NUMERIC(6,2);
 
update EMPLOYEE_PAYROLL set PAYROLL_PERCENT = PERCENT;

alter table EMPLOYEE_PAYROLL
 drop PERCENT;

 
 
alter table EMPLOYEE_SICKLIST
 add SICKLIST_PERCENT NUMERIC(6,2);
 
update EMPLOYEE_SICKLIST set SICKLIST_PERCENT = PERCENT;

alter table EMPLOYEE_SICKLIST
 drop PERCENT;
 
 
 
alter table TAX
 add TAX_PERCENT NUMERIC(5,2); /* NUMERIC(6,2) */
 
update TAX set TAX_PERCENT = PERCENT;

alter table TAX
 drop PERCENT;
 
 

/* CAR_INSURER_CONSUMABLES_PRICE: PERCENT -> PRICE_PERCENT */

/* VIEWS */
/* ======================================================= */


/* V_SYSTEM_INFO -> V_SYS_INFO */
/* V_SYSTEM_USER -> V_SYS_USER */
/* V_SYSTEM_PERMISSION -> V_SYS_PERMISSION */


/* DROP INDEX */
/* ======================================================= */
/* SYSTEM_ENTITY_CODE */



/*==============================================================*/
/* 2009-05-12                                                   */
/* Special for ORACLE (long column names)                       */
/*==============================================================*/

alter table CONTRACT
  add ORGANIZATION_PERSON_ON_BAS VARCHAR(100);

update CONTRACT set ORGANIZATION_PERSON_ON_BAS = ORGANIZATION_PERSON_ON_BASIS;

alter table CONTRACT
  drop ORGANIZATION_PERSON_ON_BASIS;



alter table CONTRACT
  add ORGANIZATION_PERSON_ON_BAS_EN VARCHAR(100);

update CONTRACT set ORGANIZATION_PERSON_ON_BAS_EN = ORGANIZATION_PERSON_ON_BASIS_EN;

alter table CONTRACT
  drop ORGANIZATION_PERSON_ON_BASIS_EN;



alter table CONTRACT
  add PARTNER_PERSON_ON_BAS VARCHAR(100);

update CONTRACT set PARTNER_PERSON_ON_BAS = PARTNER_PERSON_ON_BASIS;

alter table CONTRACT
  drop PARTNER_PERSON_ON_BASIS;



alter table CONTRACT
  add PARTNER_PERSON_ON_BAS_EN VARCHAR(100);

update CONTRACT set PARTNER_PERSON_ON_BAS_EN = PARTNER_PERSON_ON_BASIS_EN;

alter table CONTRACT
  drop PARTNER_PERSON_ON_BASIS_EN;




/*==============================================================*/
/* 2009-05-14                                                   */
/* Modify PERMISSION and SECURE_OBJECT tables                   */
/*==============================================================*/

  
/* SYS_PERMISSION: SECURE_ENTITY_ID -> SECURE_OBJECT_ID */

/* V_SYS_PERMISSION: SECURE_ENTITY_ID - > SECURE_OBJECT_ID */
/* V_SYS_PERMISSION: ENTITY_ID -> OBJECT_ID */

alter table SYS_PERMISSION
  add SECURE_OBJECT_ID INTEGER; /* not null */
  
update SYS_PERMISSION set SECURE_OBJECT_ID = SECURE_ENTITY_ID;
  


/* SECURE_OBJECT: ENTITY_ID -> OBJECT_ID */
/* SECURE_OBJECT - > SYS_SECURE_OBJECT */

/* alter table SECURE_OBJECT   */
/*  add OBJECT_ID VARCHAR(50); */ /* not null */
/* update SECURE_OBJECT set OBJECT_ID = ENTITY_ID; */


create table SYS_SECURE_OBJECT (
  ID                   INTEGER                        not null,
  OBJECT_ID            VARCHAR(50)                    not null,
  CODE                 VARCHAR(50),
  NAME                 VARCHAR(50),
  OBJECT_TYPE          VARCHAR(30)                    not null,
  constraint PK_SYS_SECURE_OBJECT primary key (ID)
);

insert into SYS_SECURE_OBJECT  SELECT * FROM SECURE_OBJECT;
  drop table SECURE_OBJECT;



/*==============================================================*/
/* 2009-05-15                                                   */
/* Modify System and Document Attribute tables                  */
/*==============================================================*/


/* SYS_ATTR: ATTR_TYPE_ID -> ATTR_ID */
/* SYS_ATTR_TYPE: ATTR_TYPE_GROUP_ID -> ATTR_GROUP_ID */

/* SYS_ATTR -> SYS_ATTR_VALUE */
/* SYS_ATTR_TYPE - > SYS_ATTR */  
/* SYS_ATTR_TYPE_GROUP -> SYS_ATTR_GROUP */


create table SYS_ATTR_VALUE (
  ID                   INTEGER                        not null,
  ATTR_ID              INTEGER                        not null,
  ENTITY_ID            CHAR(30)                       not null,
  OWNER_ID             INTEGER                        not null,
  STRING_VALUE         VARCHAR(255),
  INTEGER_VALUE        INTEGER,
  FLOAT_VALUE          FLOAT,
  DATE_VALUE           DATE,
  constraint PK_SYS_ATTR_VALUE primary key (ID)
);

insert into SYS_ATTR_VALUE  SELECT * FROM SYS_ATTR;
  drop table SYS_ATTR;

  
create table SYS_ATTR (
  ID                   INTEGER                        not null,
  ATTR_GROUP_ID        INTEGER,
  ENTITY_ID            CHAR(30)                       not null,
  DATA_TYPE_ID         CHAR(30)                       not null,
  CODE                 VARCHAR(20),
  NAME                 VARCHAR(50),
  constraint PK_SYS_ATTR primary key (ID)
);

insert into SYS_ATTR  SELECT * FROM SYS_ATTR_TYPE;
  drop table SYS_ATTR_TYPE;



create table SYS_ATTR_GROUP (
  ID                   INTEGER                        not null,
  ENTITY_ID            CHAR(30)                       not null,
  CODE                 VARCHAR(20),
  NAME                 VARCHAR(50),
  constraint PK_SYS_ATTR_GROUP primary key (ID)
);

insert into SYS_ATTR_GROUP  SELECT * FROM SYS_ATTR_TYPE_GROUP;
  drop table SYS_ATTR_TYPE_GROUP;


/* DOCUMENT_ATTR: ATTR_TYPE_ID -> ATTR_ID */
/* DOCUMENT_ATTR_TYPE: ATTR_TYPE_GROUP_ID -> ATTR_GROUP_ID */

/* DOCUMENT_ATTR -> DOCUMENT_ATTR_VALUE */
/* DOCUMENT_ATTR_TYPE - > DOCUMENT_ATTR */  
/* DOCUMENT_ATTR_TYPE_GROUP -> DOCUMENT_ATTR_GROUP */


create table DOCUMENT_ATTR_VALUE (
  ID                   INTEGER                        not null,
  DOCUMENT_TYPE_ID     INTEGER                        not null,
  ATTR_ID              INTEGER                        not null,
  DOCUMENT_ID          INTEGER                        not null,
  OWNER_ID             INTEGER                        not null,
  STRING_VALUE         VARCHAR(255),
  INTEGER_VALUE        INTEGER,
  FLOAT_VALUE          FLOAT,
  DATE_VALUE           DATE,
  constraint PK_DOCUMENT_ATTR_VALUE primary key (ID)
);

insert into DOCUMENT_ATTR_VALUE  SELECT * FROM DOCUMENT_ATTR;
  drop table DOCUMENT_ATTR;



create table DOCUMENT_ATTR (
  ID                   INTEGER                        not null,
  DOCUMENT_TYPE_ID     INTEGER                        not null,
  DATA_TYPE_ID         CHAR(30)                       not null,
  ATTR_GROUP_ID        INTEGER,
  CODE                 VARCHAR(20),
  NAME                 VARCHAR(50),
  constraint PK_DOCUMENT_ATTR primary key (ID)
);

insert into DOCUMENT_ATTR  SELECT * FROM DOCUMENT_ATTR_TYPE;
  drop table DOCUMENT_ATTR_TYPE;


  
create table DOCUMENT_ATTR_GROUP (
  ID                   INTEGER                        not null,
  DOCUMENT_TYPE_ID     INTEGER                        not null,
  CODE                 VARCHAR(20),
  NAME                 VARCHAR(50),
  constraint PK_DOCUMENT_ATTR_GROUP primary key (ID)
);

insert into DOCUMENT_ATTR_GROUP  SELECT * FROM DOCUMENT_ATTR_TYPE_GROUP;
  drop table DOCUMENT_ATTR_TYPE_GROUP;



/*==============================================================*/
/* 2009-05-20                                                   */
/*                                                              */
/*==============================================================*/

/* SYS_SECURE_OBJECT: OBJECT_ID VARCHAR(30) -> VARCHAR(50) */  /* CHANGED 2009-05-15 */
/* SYS_SECURE_OBJECT: CODE VARCHAR(30) -> VARCHAR(50) */       /* CHANGED 2009-05-15 */

alter table SYS_INFO
  add IS_AUTO_SET_CURRENCY_RATE CHAR(1) default 'Y' not null;



/*==============================================================*/
/* 2010-04-14                                                   */
/*                                                              */
/*==============================================================*/

/*
1. alter table DOCUMENT_TYPE

 DOCUMENT_CODE_PREFIX -> DOCUMENT_NO_PREFIX
 DOCUMENT_CODE_SUFFIX -> DOCUMENT_NO_SUFFIX
 IS_UNIQUE_DOCUMENT_CODE -> IS_UNIQUE_DOCUMENT_NO
 IS_DOCUMENT_CODE_READ_ONLY -> IS_DOCUMENT_NO_READ_ONLY
 NUMERATOR_CLASS     CHAR(128) -> VARCHAR(128),
*/
  
alter table DOCUMENT_TYPE
  add DOCUMENT_NO_PREFIX VARCHAR(10);
  
update DOCUMENT_TYPE set DOCUMENT_NO_PREFIX = DOCUMENT_CODE_PREFIX;

alter table DOCUMENT_TYPE
  drop DOCUMENT_CODE_PREFIX;

  

alter table DOCUMENT_TYPE
  add DOCUMENT_NO_SUFFIX VARCHAR(10);

update DOCUMENT_TYPE set DOCUMENT_NO_SUFFIX = DOCUMENT_CODE_SUFFIX;

alter table DOCUMENT_TYPE
  drop DOCUMENT_CODE_SUFFIX;



alter table DOCUMENT_TYPE
  add IS_UNIQUE_DOCUMENT_NO CHAR(1) default 'N' not null;

update DOCUMENT_TYPE set IS_UNIQUE_DOCUMENT_NO = IS_UNIQUE_DOCUMENT_CODE;

alter table DOCUMENT_TYPE
  drop IS_UNIQUE_DOCUMENT_CODE;
  
  

alter table DOCUMENT_TYPE
  add IS_DOCUMENT_NO_READ_ONLY CHAR(1) default 'N' not null;

update DOCUMENT_TYPE set IS_DOCUMENT_NO_READ_ONLY = IS_DOCUMENT_CODE_READ_ONLY;

alter table DOCUMENT_TYPE
  drop IS_DOCUMENT_CODE_READ_ONLY;

  
  
alter table DOCUMENT_TYPE
 add NUMERATOR_CLASS_2 VARCHAR(128);
 
update DOCUMENT_TYPE set NUMERATOR_CLASS_2 = NUMERATOR_CLASS;

alter table DOCUMENT_TYPE
 drop NUMERATOR_CLASS;
 
alter table DOCUMENT_TYPE
 add NUMERATOR_CLASS VARCHAR(128);
 
update DOCUMENT_TYPE set NUMERATOR_CLASS = NUMERATOR_CLASS_2;

alter table DOCUMENT_TYPE
 drop NUMERATOR_CLASS_2;

 

 
/*
 2. alter table BRANCH_DOCUMENT_TYPE
 DOCUMENT_CODE_PREFIX -> DOCUMENT_NO_PREFIX
 DOCUMENT_CODE_SUFFIX -> DOCUMENT_NO_SUFFIX
*/

alter table BRANCH_DOCUMENT_TYPE
  add DOCUMENT_NO_PREFIX VARCHAR(10);
  
update BRANCH_DOCUMENT_TYPE set DOCUMENT_NO_PREFIX = DOCUMENT_CODE_PREFIX;

alter table BRANCH_DOCUMENT_TYPE
  drop DOCUMENT_CODE_PREFIX;

  

alter table BRANCH_DOCUMENT_TYPE
  add DOCUMENT_NO_SUFFIX VARCHAR(10);

update BRANCH_DOCUMENT_TYPE set DOCUMENT_NO_SUFFIX = DOCUMENT_CODE_SUFFIX;

alter table BRANCH_DOCUMENT_TYPE
  drop DOCUMENT_CODE_SUFFIX;

  
  
/*
 3. alter table DOCUMENT
 CODE -> DOCUMENT_NO
 drop DOCUMENT_NUMBER


4. alter table PERSON_CARD
 DOCUMENT_NUMBER -> DOCUMENT_NO


5. alter table PROJECT
 drop CONTRACT_NO
 add CONTRACT_ID INTEGER
*/
  
alter table DOCUMENT
  add DOCUMENT_NO VARCHAR(20);
  
update DOCUMENT set DOCUMENT_NO = CODE;

alter table DOCUMENT
  drop CODE;

alter table DOCUMENT
  drop DOCUMENT_NUMBER;


  
alter table PERSON_CARD
  add DOCUMENT_NO VARCHAR(10);
  
update PERSON_CARD set DOCUMENT_NO = DOCUMENT_NUMBER;

alter table PERSON_CARD
  drop DOCUMENT_NUMBER;
  
  
alter table PERSON_CARD
  add DIPLOMA_NO VARCHAR(10);
  
update PERSON_CARD set DIPLOMA_NO = DIPLOMA_NUMBER;

alter table PERSON_CARD
  drop DIPLOMA_NUMBER;  
  
  
  
alter table PROJECT
  add CONTRACT_ID  INTEGER;

alter table PROJECT
  drop CONTRACT_NO; /* !!! LOST DATA !!! */
  
  

/*
 6. alter table SYS_ENTITY

 ENTITY_CODE_PREFIX VARCHAR(10),
 ENTITY_CODE_SUFFIX VARCHAR(10),
 LAST_ENTITY_NUMBER INTEGER,
 IS_USE_NUMERATOR     CHAR(1)     default 'N' not null,
 IS_UNIQUE_ENTITY_CODE CHAR(1)    default 'N' not null,
 NUMERATOR_CLASS      VARCHAR(128), 
 IS_ENTITY_CODE_READ_ONLY CHAR(1) default 'N' not null
 IS_ENTITY_DATE_READ_ONLY CHAR(1) default 'N' not null,
*/
  
alter table SYS_ENTITY
  add ENTITY_CODE_PREFIX VARCHAR(10);

alter table SYS_ENTITY
  add ENTITY_CODE_SUFFIX VARCHAR(10);
  
alter table SYS_ENTITY
  add LAST_ENTITY_NUMBER INTEGER;

alter table SYS_ENTITY
  add IS_USE_NUMERATOR CHAR(1) default 'N' not null;

alter table SYS_ENTITY
  add IS_UNIQUE_ENTITY_CODE CHAR(1) default 'N' not null;
  
alter table SYS_ENTITY
  add NUMERATOR_CLASS VARCHAR(128);

alter table SYS_ENTITY
  add IS_ENTITY_CODE_READ_ONLY CHAR(1) default 'N' not null;
  
alter table SYS_ENTITY
  add IS_ENTITY_DATE_READ_ONLY CHAR(1) default 'N' not null;

  
/*
 7. alter table SYS_INFO

  add APP_BUILD VARCHAR(8) default '' not null (format yyyymmdd)
  add DB_BUILD VARCHAR(8) default '' not null (format yyyymmdd)
*/  

alter table SYS_INFO
  add APP_BUILD VARCHAR(8) default '' not null;

alter table SYS_INFO
  add DB_BUILD VARCHAR(8) default '' not null;

  

/*==============================================================*/
/* 2010-04-15                                                   */
/*                                                              */
/*==============================================================*/

  
alter table PAYMENT_DOCUMENT_LINK
 add PAYMENT_DOCUMENT_ID INTEGER;
 
update PAYMENT_DOCUMENT_LINK set PAYMENT_DOCUMENT_ID = PAYMENT_ID;

alter table PAYMENT_DOCUMENT_LINK
  drop PAYMENT_ID;


  
alter table PAYMENT_DOCUMENT_LINK
 add REASON_DOCUMENT_ID INTEGER;
 
update PAYMENT_DOCUMENT_LINK set REASON_DOCUMENT_ID = DOCUMENT_ID;

alter table PAYMENT_DOCUMENT_LINK
  drop DOCUMENT_ID;

  
  
create table CASH_DOCUMENT_LINK (
  ID                  INTEGER                        not null,
  CASH_DOCUMENT_ID    INTEGER                        not null,
  REASON_DOCUMENT_ID  INTEGER                        not null,
  constraint PK_CASH_DOCUMENT_LINK primary key (ID)
);



alter table SALE_ORDER
 add IS_PAID CHAR(1)  default 'N' not null;

 
alter table PURCHASE_ORDER
 add IS_PAID CHAR(1)  default 'N' not null;
 
 
 
alter table PROJECT
  add PROJECT_NO VARCHAR(20);
 
update PROJECT set PROJECT_NO = CODE;

alter table PROJECT
  drop CODE;

 
 
alter table TASK
  add TASK_NO VARCHAR(20);
  
update TASK set TASK_NO = CODE;  
 
alter table TASK
  drop CODE;

  

/*==============================================================*/
/* 2010-04-18                                                   */
/*                                                              */
/*==============================================================*/
 


alter table PROJECT
  add TOTAL NUMERIC(15,2) default 0 not null;
  
alter table PROJECT  
 add TAX_TOTAL NUMERIC(15,2)  default 0 not null;
 
alter table PROJECT 
 add TOTAL_WITH_TAX NUMERIC(15,2) default 0 not null;

alter table PROJECT 
 add CURRENCY_TOTAL NUMERIC(15,2) default 0 not null;
 
alter table PROJECT 
 add CURRENCY_TAX_TOTAL NUMERIC(15,2) default 0 not null;
 
alter table PROJECT 
 add CURRENCY_TOTAL_WITH_TAX NUMERIC(15,2) default 0 not null;
  


/*==============================================================*/
/* 2010-04-24                                                   */
/*                                                              */
/*==============================================================*/


create table SYS_PROPERTY (
  ID                   INTEGER                        not null,
  NAME                 VARCHAR(50)                    not null,
  VALUE                VARCHAR(255)                   not null,
  constraint PK_SYS_PROPERTY primary key (ID)
);


/*==============================================================*/
/* 2010-04-27                                                   */
/*                                                              */
/*==============================================================*/

/* CHANGED 2010-04-14 */
/*
alter table PERSON_CARD
 DIPLOMA_NUMBER -> DIPLOMA_NO
*/