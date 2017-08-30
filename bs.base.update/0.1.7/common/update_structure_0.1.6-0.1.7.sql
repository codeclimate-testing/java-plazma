
/*==============================================================*/
/*                                                              */
/* CREATE TABLES                                                */
/*                                                              */
/*==============================================================*/

/*==============================================================*/
/* Table: PRODUCT_INSTANCE                                      */
/*==============================================================*/

create table PRODUCT_INSTANCE (
ID                   INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
SERIAL_NUMBER        VARCHAR(30),
NAME                 VARCHAR(50),
constraint PK_PRODUCT_INSTANCE primary key (ID)
);


/*==============================================================*/
/*                                                              */
/* ADD COLUMNS                                                  */
/*                                                              */
/*==============================================================*/

/*==============================================================*/
/* Table: CONTACT                                               */
/*==============================================================*/

ALTER TABLE CONTACT
 ADD NAME_EN VARCHAR(50);

ALTER TABLE CONTACT
 ADD FULL_POSITION_NAME_EN VARCHAR(100);

ALTER TABLE CONTACT
 ADD WORK_ON_BASIS VARCHAR(100);

ALTER TABLE CONTACT
 ADD WORK_ON_BASIS_EN VARCHAR(100);


/*==============================================================*/
/* Table: CONTRACT                                              */
/*==============================================================*/

ALTER TABLE CONTRACT
  ADD ORGANIZATION_CONTACT_ID INTEGER;
  
ALTER TABLE CONTRACT
  ADD ORGANIZATION_BANK_ACCOUNT_ID INTEGER;

ALTER TABLE CONTRACT
  ADD PARTNER_CONTACT_ID   INTEGER;
  
ALTER TABLE CONTRACT
  ADD PARTNER_BANK_ACCOUNT_ID INTEGER;


ALTER TABLE CONTRACT
  ADD END_DATE DATE;
  
  
ALTER TABLE CONTRACT
  ADD ORGANIZATION_PERSON  VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD ORGANIZATION_PERSON_EN VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD ORGANIZATION_PERSON_DETAIL VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD ORGANIZATION_PERSON_DETAIL_EN VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD ORGANIZATION_PERSON_ON_BASIS VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD ORGANIZATION_PERSON_ON_BASIS_EN VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD ORGANIZATION_ADDRESS VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD ORGANIZATION_ADDRESS_EN VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD ORGANIZATION_PHONE VARCHAR(20);
  
ALTER TABLE CONTRACT
  ADD ORGANIZATION_FAX VARCHAR(20);
  
ALTER TABLE CONTRACT
  ADD ORGANIZATION_BANK_NAME VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD ORGANIZATION_BANK_NAME_EN VARCHAR(100);
  
  
ALTER TABLE CONTRACT
  ADD PARTNER_PERSON VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD PARTNER_PERSON_EN VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD PARTNER_PERSON_DETAIL VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD PARTNER_PERSON_DETAIL_EN VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD PARTNER_PERSON_ON_BASIS VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD PARTNER_PERSON_ON_BASIS_EN VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD PARTNER_ADDRESS VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD PARTNER_ADDRESS_EN VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD PARTNER_PHONE VARCHAR(20);
  
ALTER TABLE CONTRACT
  ADD PARTNER_FAX  VARCHAR(20);
  
ALTER TABLE CONTRACT
  ADD PARTNER_BANK_NAME VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD PARTNER_BANK_NAME_EN VARCHAR(100);
  

ALTER TABLE CONTRACT
  ADD PREPAY_AMOUNT NUMERIC(15,2) default 0 not null;
  
ALTER TABLE CONTRACT
  ADD CURRENCY_PREPAY_AMOUNT NUMERIC(15,2) default 0 not null;



/*==============================================================*/
/* Table: PRODUCT                                               */
/*==============================================================*/

ALTER TABLE PRODUCT
  ADD SMALL_WHOLESALE_PRICE NUMERIC(15,4) default 0 not null;

ALTER TABLE PRODUCT
  ADD CURRENCY_PRICE NUMERIC(15,4)	default 0 not null;
  
ALTER TABLE PRODUCT
  ADD CURRENCY_WHOLESALE_PRICE NUMERIC(15,4) default 0 not null;
  
ALTER TABLE PRODUCT
  ADD CURRENCY_SMALL_WHOLESALE_PRICE NUMERIC(15,4) default 0 not null;
  
ALTER TABLE PRODUCT
  ADD CURRENCY_RETAIL_PRICE NUMERIC(15,4) default 0 not null;
  

ALTER TABLE PRODUCT
  ADD WARRANTY_PERIOD INTEGER;
  
ALTER TABLE PRODUCT
  ADD BAR_CODE VARCHAR(30);


ALTER TABLE PRODUCT
  ADD DIM_LENGTH NUMERIC(12,3) default 0 not null;

ALTER TABLE PRODUCT
  ADD DIM_WIDTH NUMERIC(12,3) default 0 not null;

ALTER TABLE PRODUCT
  ADD DIM_HEIGHT NUMERIC(12,3) default 0 not null;
  
ALTER TABLE PRODUCT
  ADD WEIGHT NUMERIC(12,3) default 0 not null;
  
ALTER TABLE PRODUCT
  ADD PRODUCT_IMAGE VARCHAR(50);


ALTER TABLE PRODUCT
  ADD WARRANTY_PERIOD_UNIT_ID INTEGER;
  
ALTER TABLE PRODUCT
  ADD WEIGHT_UNIT_ID INTEGER;
  
ALTER TABLE PRODUCT
  ADD DIMENSION_UNIT_ID INTEGER;



/* Fix currency rate */
UPDATE PRODUCT SET CURRENCY_RATE = 1.0 WHERE CURRENCY_RATE IS NULL OR CURRENCY_RATE = 0;

/* Set currency prices */ 
UPDATE PRODUCT SET CURRENCY_PRICE = PRICE / CURRENCY_RATE;
UPDATE PRODUCT SET CURRENCY_WHOLESALE_PRICE  = WHOLESALE_PRICE / CURRENCY_RATE;
UPDATE PRODUCT SET CURRENCY_RETAIL_PRICE = RETAIL_PRICE / CURRENCY_RATE;


/*==============================================================*/
/* Table: PRODUCT_CLASS                                         */
/*==============================================================*/

ALTER TABLE PRODUCT_CLASS
 ADD NAME_EN VARCHAR(100);


/*==============================================================*/
/* Table: PRODUCT_GROUP                                         */
/*==============================================================*/

ALTER TABLE PRODUCT_GROUP
 ADD NAME_EN VARCHAR(30);
 

/*==============================================================*/
/* Table: UNIT                                                  */
/*==============================================================*/
 
ALTER TABLE UNIT 
 ADD NAME_EN VARCHAR(10);


/*==============================================================*/
/* Table: PARTNER                                               */
/*==============================================================*/

ALTER TABLE PARTNER
  ADD NAME_EN VARCHAR(50);
  
ALTER TABLE PARTNER  
  ADD PARTNER_IMAGE VARCHAR(50);
  
ALTER TABLE PARTNER    
  ADD IS_PERSON CHAR(1) default 'N' not null;


/*==============================================================*/
/* Table: PERSON                                                */
/*==============================================================*/

ALTER TABLE PERSON
  ADD PERSON_PHOTO VARCHAR(50);


/*==============================================================*/
/* Table: GOODS_OUTCOME_ITEM                                    */
/*==============================================================*/

ALTER TABLE GOODS_OUTCOME_ITEM
  ADD PRODUCT_INSTANCE_ID INTEGER;


/*==============================================================*/
/* Table: SYSTEM_INFO                                           */
/*==============================================================*/

ALTER TABLE SYSTEM_INFO
 ADD IS_MULTI_CURRENCIES  CHAR(1) default 'Y' not null;
 
ALTER TABLE SYSTEM_INFO
 ADD IS_INTERNATIONAL_ATTRIBUTES CHAR(1) default 'N' not null;
 
ALTER TABLE SYSTEM_INFO
 ADD IS_PROJECT_IN_DOCUMENT CHAR(1) default 'N' not null;


/*==============================================================*/
/* Table: SYSTEM_FILE                                           */
/*==============================================================*/
ALTER TABLE SYSTEM_FILE
 DROP FILE_PATH;



/* Change length of FILE_NAME: VARCHAR(50) -> VARCHAR(255) */

ALTER TABLE SYSTEM_FILE
 ADD FILE_NAME_2 VARCHAR(50);

UPDATE SYSTEM_FILE SET FILE_NAME_2 = FILE_NAME;

ALTER TABLE SYSTEM_FILE
 DROP FILE_NAME;

ALTER TABLE SYSTEM_FILE
 ADD FILE_NAME  VARCHAR(255);

UPDATE SYSTEM_FILE SET FILE_NAME = FILE_NAME_2;

ALTER TABLE SYSTEM_FILE
 DROP FILE_NAME_2;



ALTER TABLE SYSTEM_FILE
 ADD NAME VARCHAR(50);

ALTER TABLE SYSTEM_FILE
 ADD DESCRIPTION VARCHAR(255);


/*==============================================================*/
/*                                                              */
/* DROP COLUMNS                                                 */
/*                                                              */
/*==============================================================*/

ALTER TABLE GOODS
  DROP BAR_CODE;
