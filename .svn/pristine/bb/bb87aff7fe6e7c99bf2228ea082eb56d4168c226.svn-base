
/*==============================================================*/
/*                                                              */
/* CREATE TABLES                                                */
/*                                                              */
/*==============================================================*/

/* INVOICE -> SALE_INVOICE                                      */
/* INVOICE_ITEM -> SALE_INVOICE_ITEM                            */
/* EXEC_WORK -> SALE_SERV                                       */
/* EXEC_WORK_ITEM -> SALE_SERV_ITEM                             */
/* TAX_WAYBILL -> SALE_TAX_WAYBILL                              */
/* TAX_WAYBILL_ITEM -> SALE_TAX_WAYBILL_ITEM                    */

/* ADD PURCHASE_INVOICE                                         */
/* ADD PURCHASE_INVOICE_ITEM                                    */
/* ADD PURCHASE_SERV                                            */
/* ADD PURCHASE_SERV_ITEM                                       */
/* ADD PURCHASE_TAX_WAYBILL                                     */
/* ADD PURCHASE_TAX_WAYBILL_ITEM                                */

/* GOODS_REST -> INVENTORY_REST                                 */
/* GOODS_REST_ITEM -> INVENTORY_REST_ITEM                       */
/* GOODS_MOVE -> INVENTORY_MOVE (recreate)                      */
/* GOODS_MOVE_ITEM -> INVENTORY_MOVE_ITEM                       */
/* GOODS_WRITEOFF -> INVENTORY_WRITEOF (recreate)               */
/* GOODS_WRITEOFF_ITEM -> INVENTORY_WRITEOF_ITEM                */

/* ADD INVENTORY_INCOME (recreate)                              */
/* ADD INVENTORY_INCOME_ITEM                                    */
/* ADD INVENTORY_OUTCOME (recreate)                             */
/* ADD INVENTORY_OUTCOME_ITEM                                   */

/* ADD BRANCH                                                   */
/* ADD BRANCH_DOCUMENT_TYPE                                     */
/* ADD PARTNER_REPRESENTATIVE                                   */
/* ADD PARTNER_TYPE                                             */
/* ADD SYSTEM_USER_ORG                                          */

/*==============================================================*/
/* Table: SALE_INVOICE                                          */
/*==============================================================*/
create table SALE_INVOICE (
ID                   INTEGER                        not null,
PRICE_TYPE_ID        INTEGER,
DELIVERY             NUMERIC(15,2)                  not null,
TAX_DELIVERY         NUMERIC(15,2)                  not null,
DELIVERY_WITH_TAX    NUMERIC(15,2)                  not null,
CURRENCY_DELIVERY    NUMERIC(15,2)                  not null,
CURRENCY_TAX_DELIVERY NUMERIC(15,2)                  not null,
CURRENCY_DELIVERY_WITH_TAX NUMERIC(15,2)                  not null,
IS_PAID              CHAR(1)                        default 'N' not null,
CORRECT_PRICE_TYPE   CHAR(3),
DISCOUNT_PERCENT     NUMERIC(6,2)                   default 0 not null,
MARKUP_PERCENT       NUMERIC(6,2)                   default 0 not null,
constraint PK_SALE_INVOICE primary key (ID)
);

/*==============================================================*/
/* Table: SALE_INVOICE_ITEM                                     */
/*==============================================================*/
create table SALE_INVOICE_ITEM (
ID                   INTEGER                        not null,
SALE_INVOICE_ID      INTEGER                        not null,
TAX_ID               INTEGER,
PRODUCT_ID           INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
PRODUCT_FEATURE_NAME VARCHAR(100),
PRICE                NUMERIC(15,2)                  not null,
TAX_PRICE            NUMERIC(9,2)                   not null,
QUANTITY             NUMERIC(9,4)                   not null,
AMOUNT               NUMERIC(15,2)                  not null,
TAX_AMOUNT           NUMERIC(15,2)                  not null,
IS_TAX               CHAR(1)                        default 'N' not null,
CURRENCY_PRICE       NUMERIC(9,2)                   not null,
CURRENCY_TAX_PRICE   NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT      NUMERIC(15,2)                  not null,
CURRENCY_TAX_AMOUNT  NUMERIC(15,2)                  not null,
UNIT_RATE            NUMERIC(15,3)                  not null,
PRICE_WITH_TAX       NUMERIC(9,2)                   not null,
AMOUNT_WITH_TAX      NUMERIC(15,2)                  not null,
CURRENCY_PRICE_WITH_TAX NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT_WITH_TAX NUMERIC(15,2)                  not null,
TAX_PERCENT          NUMERIC(6,2)                   default 0 not null,
CORRECT_PRICE_TYPE   CHAR(3),
DISCOUNT_PERCENT     NUMERIC(6,2)                   default 0 not null,
MARKUP_PERCENT       NUMERIC(6,2)                   default 0 not null,
BASE_PRICE           NUMERIC(9,2)                   default 0 not null,
TAX_BASE_PRICE       NUMERIC(9,2)                   default 0 not null,
BASE_PRICE_WITH_TAX  NUMERIC(9,2)                   default 0 not null,
CURRENCY_BASE_PRICE  NUMERIC(9,2)                   default 0 not null,
CURRENCY_TAX_BASE_PRICE NUMERIC(9,2)                   default 0 not null,
CURRENCY_BASE_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
ACCOUNT_QUANTITY     NUMERIC(9,4)                   default 0 not null,
ACCOUNT_PRICE        NUMERIC(9,2)                   default 0 not null,
ACCOUNT_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
ACCOUNT_TAX_PRICE    NUMERIC(9,2)                   default 0 not null,
constraint PK_SALE_INVOICE_ITEM primary key (ID)
);

/*==============================================================*/
/* Table: SALE_SERV                                             */
/*==============================================================*/
create table SALE_SERV (
ID                   INTEGER                        not null,
constraint PK_SALE_SERV primary key (ID)
);

/*==============================================================*/
/* Table: SALE_SERV_ITEM                                        */
/*==============================================================*/
create table SALE_SERV_ITEM (
ID                   INTEGER                        not null,
SALE_SERV_ID         INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
TAX_ID               INTEGER,
PRODUCT_ID           INTEGER                        not null,
PRODUCT_FEATURE_NAME VARCHAR(100),
PRICE                NUMERIC(9,2)                   default 0 not null,
TAX_PRICE            NUMERIC(9,2)                   default 0 not null,
QUANTITY             NUMERIC(9,4)                   not null,
AMOUNT               NUMERIC(15,2)                  not null,
TAX_AMOUNT           NUMERIC(15,2)                  not null,
IS_TAX               CHAR(1)                        default 'N' not null,
CURRENCY_PRICE       NUMERIC(9,2)                   not null,
CURRENCY_TAX_PRICE   NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT      NUMERIC(15,2)                  default 0 not null,
CURRENCY_TAX_AMOUNT  NUMERIC(15,2)                  default 0 not null,
UNIT_RATE            NUMERIC(15,3)                  not null,
PRICE_WITH_TAX       NUMERIC(9,2)                   not null,
AMOUNT_WITH_TAX      NUMERIC(15,2)                  not null,
CURRENCY_PRICE_WITH_TAX NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT_WITH_TAX NUMERIC(15,2)                  not null,
TAX_PERCENT          NUMERIC(6,2)                   default 0 not null,
ACCOUNT_QUANTITY     NUMERIC(9,4)                   default 0 not null,
ACCOUNT_PRICE        NUMERIC(9,2)                   default 0 not null,
ACCOUNT_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
ACCOUNT_TAX_PRICE    NUMERIC(9,2)                   default 0 not null,
constraint PK_SALE_SERV_ITEM primary key (ID)
);

/*==============================================================*/
/* Table: SALE_TAX_WAYBILL                                      */
/*==============================================================*/
create table SALE_TAX_WAYBILL (
ID                   INTEGER                        not null,
constraint PK_SALE_TAX_WAYBILL primary key (ID)
);

/*==============================================================*/
/* Table: SALE_TAX_WAYBILL_ITEM                                 */
/*==============================================================*/
create table SALE_TAX_WAYBILL_ITEM (
ID                   INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
SALE_TAX_WAYBILL_ID  INTEGER                        not null,
TAX_ID               INTEGER,
PRODUCT_FEATURE_NAME VARCHAR(100),
PRICE                NUMERIC(9,2)                   default 0 not null,
TAX_PRICE            NUMERIC(9,2)                   default 0 not null,
QUANTITY             NUMERIC(9,4)                   not null,
AMOUNT               NUMERIC(15,2)                  not null,
TAX_AMOUNT           NUMERIC(15,2)                  not null,
IS_TAX               CHAR(1)                        default 'N' not null,
CURRENCY_PRICE       NUMERIC(9,2)                   not null,
CURRENCY_TAX_PRICE   NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT      NUMERIC(15,2)                  default 0 not null,
CURRENCY_TAX_AMOUNT  NUMERIC(15,2)                  default 0 not null,
UNIT_RATE            NUMERIC(15,3)                  not null,
PRICE_WITH_TAX       NUMERIC(9,2)                   not null,
AMOUNT_WITH_TAX      NUMERIC(15,2)                  not null,
CURRENCY_PRICE_WITH_TAX NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT_WITH_TAX NUMERIC(15,2)                  not null,
TAX_PERCENT          NUMERIC(6,2)                   default 0 not null,
ACCOUNT_QUANTITY     NUMERIC(9,4)                   default 0 not null,
ACCOUNT_PRICE        NUMERIC(9,2)                   default 0 not null,
ACCOUNT_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
ACCOUNT_TAX_PRICE    NUMERIC(9,2)                   default 0 not null,
constraint PK_SALE_TAX_WAYBILL_ITEM primary key (ID)
);


/*===================================================================*/

INSERT INTO SALE_INVOICE SELECT * FROM INVOICE;
DROP TABLE INVOICE;
 
INSERT INTO SALE_INVOICE_ITEM
 SELECT 
 ID, 
 INVOICE_ID AS SALE_INVOICE_ID,
 TAX_ID,
 PRODUCT_ID,
 UNIT_ID,
 PRODUCT_FEATURE_NAME,
 PRICE,
 TAX_PRICE,
 QUANTITY,
 AMOUNT,
 TAX_AMOUNT,
 IS_TAX,
 CURRENCY_PRICE,
 CURRENCY_TAX_PRICE,
 CURRENCY_AMOUNT,
 CURRENCY_TAX_AMOUNT,
 UNIT_RATE,
 PRICE_WITH_TAX,
 AMOUNT_WITH_TAX,
 CURRENCY_PRICE_WITH_TAX,
 CURRENCY_AMOUNT_WITH_TAX,
 TAX_PERCENT,
 CORRECT_PRICE_TYPE,
 DISCOUNT_PERCENT,
 MARKUP_PERCENT,
 BASE_PRICE,
 TAX_BASE_PRICE,
 BASE_PRICE_WITH_TAX,
 CURRENCY_BASE_PRICE,
 CURRENCY_TAX_BASE_PRICE,
 CURRENCY_BASE_PRICE_WITH_TAX,
 ACCOUNT_QUANTITY,
 ACCOUNT_PRICE,
 ACCOUNT_PRICE_WITH_TAX,
 ACCOUNT_TAX_PRICE
 FROM INVOICE_ITEM;

DROP TABLE INVOICE_ITEM;

/*===================================================================*/

INSERT INTO SALE_SERV SELECT * FROM EXEC_WORK;
DROP TABLE EXEC_WORK;

INSERT INTO SALE_SERV_ITEM 
 SELECT 
 ID,
 EXEC_WORK_ID AS SALE_SERV_ID,
 UNIT_ID,
 TAX_ID,
 PRODUCT_ID,
 PRODUCT_FEATURE_NAME,
 PRICE,
 TAX_PRICE,
 QUANTITY,
 AMOUNT,
 TAX_AMOUNT,
 IS_TAX,
 CURRENCY_PRICE,
 CURRENCY_TAX_PRICE,
 CURRENCY_AMOUNT,
 CURRENCY_TAX_AMOUNT,
 UNIT_RATE,
 PRICE_WITH_TAX,
 AMOUNT_WITH_TAX,
 CURRENCY_PRICE_WITH_TAX,
 CURRENCY_AMOUNT_WITH_TAX,
 TAX_PERCENT,
 ACCOUNT_QUANTITY,
 ACCOUNT_PRICE,
 ACCOUNT_PRICE_WITH_TAX,
 ACCOUNT_TAX_PRICE
 FROM EXEC_WORK_ITEM;

DROP TABLE EXEC_WORK_ITEM;


INSERT INTO SALE_TAX_WAYBILL SELECT ID FROM TAX_WAYBILL;
DROP TABLE TAX_WAYBILL;

INSERT INTO SALE_TAX_WAYBILL_ITEM 
 SELECT
 ID,
 UNIT_ID,
 PRODUCT_ID,
 TAX_WAYBILL_ID AS SALE_TAX_WAYBILL_ID,
 TAX_ID,
 PRODUCT_FEATURE_NAME,
 PRICE,
 TAX_PRICE,
 QUANTITY,
 AMOUNT,
 TAX_AMOUNT,
 IS_TAX,
 CURRENCY_PRICE,
 CURRENCY_TAX_PRICE,
 CURRENCY_AMOUNT,
 CURRENCY_TAX_AMOUNT,
 UNIT_RATE,
 PRICE_WITH_TAX,
 AMOUNT_WITH_TAX,
 CURRENCY_PRICE_WITH_TAX,
 CURRENCY_AMOUNT_WITH_TAX,
 TAX_PERCENT,
 ACCOUNT_QUANTITY,
 ACCOUNT_PRICE,
 ACCOUNT_PRICE_WITH_TAX,
 ACCOUNT_TAX_PRICE
 FROM TAX_WAYBILL_ITEM;

DROP TABLE TAX_WAYBILL_ITEM;








/*==============================================================*/
/* Table: PURCHASE_INVOICE                                      */
/*==============================================================*/
create table PURCHASE_INVOICE (
ID                   INTEGER                        not null,
PRICE_TYPE_ID        INTEGER,
DELIVERY             NUMERIC(15,2)                  default 0 not null,
TAX_DELIVERY         NUMERIC(15,2)                  default 0 not null,
DELIVERY_WITH_TAX    NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY    NUMERIC(15,2)                  default 0 not null,
CURRENCY_TAX_DELIVERY NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY_WITH_TAX NUMERIC(15,2)                  default 0 not null,
IS_PAID              CHAR(1)                        default 'N' not null,
CORRECT_PRICE_TYPE   CHAR(3),
DISCOUNT_PERCENT     NUMERIC(6,2)                   default 0 not null,
MARKUP_PERCENT       NUMERIC(6,2)                   default 0 not null,
constraint PK_PURCHASE_INVOICE primary key (ID)
);

/*==============================================================*/
/* Table: PURCHASE_INVOICE_ITEM                                 */
/*==============================================================*/
create table PURCHASE_INVOICE_ITEM (
ID                   INTEGER                        not null,
TAX_ID               INTEGER,
PURCHASE_INVOICE_ID  INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
PRODUCT_FEATURE_NAME VARCHAR(100),
PRICE                NUMERIC(9,2)                   default 0 not null,
TAX_PRICE            NUMERIC(9,2)                   default 0 not null,
QUANTITY             NUMERIC(9,4)                   default 0 not null,
AMOUNT               NUMERIC(15,2)                  not null,
TAX_AMOUNT           NUMERIC(15,2)                  not null,
IS_TAX               CHAR(1)                        not null,
CURRENCY_PRICE       NUMERIC(15,4)                  default 0 not null,
CURRENCY_TAX_PRICE   NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT      NUMERIC(15,2)                  not null,
CURRENCY_TAX_AMOUNT  NUMERIC(15,2)                  not null,
UNIT_RATE            NUMERIC(15,3)                  not null,
PRICE_WITH_TAX       NUMERIC(9,2)                   not null,
AMOUNT_WITH_TAX      NUMERIC(15,2)                  not null,
CURRENCY_PRICE_WITH_TAX NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT_WITH_TAX NUMERIC(15,2)                  not null,
TAX_PERCENT          NUMERIC(6,2)                   default 0 not null,
CORRECT_PRICE_TYPE   CHAR(3),
DISCOUNT_PERCENT     NUMERIC(6,2)                   default 0 not null,
MARKUP_PERCENT       NUMERIC(6,2)                   default 0 not null,
BASE_PRICE           NUMERIC(9,2)                   default 0 not null,
TAX_BASE_PRICE       NUMERIC(9,2)                   default 0 not null,
BASE_PRICE_WITH_TAX  NUMERIC(9,2)                   default 0 not null,
CURRENCY_BASE_PRICE  NUMERIC(9,2)                   default 0 not null,
CURRENCY_TAX_BASE_PRICE NUMERIC(9,2)                   default 0 not null,
CURRENCY_BASE_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
ACCOUNT_QUANTITY     NUMERIC(9,4)                   default 0 not null,
ACCOUNT_PRICE        NUMERIC(9,2)                   default 0 not null,
ACCOUNT_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
ACCOUNT_TAX_PRICE    NUMERIC(9,2)                   default 0 not null,
constraint PK_PURCHASE_INVOICE_ITEM primary key (ID)
);


/*==============================================================*/
/* Table: PURCHASE_SERV                                         */
/*==============================================================*/
create table PURCHASE_SERV (
ID                   INTEGER                        not null,
constraint PK_PURCHASE_SERV primary key (ID)
);

/*==============================================================*/
/* Table: PURCHASE_SERV_ITEM                                    */
/*==============================================================*/
create table PURCHASE_SERV_ITEM (
ID                   INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
TAX_ID               INTEGER,
PURCHASE_SERV_ID     INTEGER                        not null,
PRODUCT_FEATURE_NAME VARCHAR(100),
PRICE                NUMERIC(9,2)                   default 0 not null,
TAX_PRICE            NUMERIC(9,2)                   default 0 not null,
QUANTITY             NUMERIC(9,4)                   default 0 not null,
AMOUNT               NUMERIC(15,2)                  not null,
TAX_AMOUNT           NUMERIC(15,2)                  not null,
IS_TAX               CHAR(1)                        not null,
CURRENCY_PRICE       NUMERIC(15,4)                  default 0 not null,
CURRENCY_TAX_PRICE   NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT      NUMERIC(15,2)                  not null,
CURRENCY_TAX_AMOUNT  NUMERIC(15,2)                  not null,
UNIT_RATE            NUMERIC(15,3)                  not null,
PRICE_WITH_TAX       NUMERIC(9,2)                   not null,
AMOUNT_WITH_TAX      NUMERIC(15,2)                  not null,
CURRENCY_PRICE_WITH_TAX NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT_WITH_TAX NUMERIC(15,2)                  not null,
TAX_PERCENT          NUMERIC(6,2)                   default 0 not null,
ACCOUNT_QUANTITY     NUMERIC(9,4)                   default 0 not null,
ACCOUNT_PRICE        NUMERIC(9,2)                   default 0 not null,
ACCOUNT_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
ACCOUNT_TAX_PRICE    NUMERIC(9,2)                   default 0 not null,
constraint PK_PURCHASE_SERV_ITEM primary key (ID)
);

/*==============================================================*/
/* Table: PURCHASE_TAX_WAYBILL                                  */
/*==============================================================*/
create table PURCHASE_TAX_WAYBILL (
ID                   INTEGER                        not null,
constraint PK_PURCHASE_TAX_WAYBILL primary key (ID)
);

/*==============================================================*/
/* Table: PURCHASE_TAX_WAYBILL_ITEM                             */
/*==============================================================*/
create table PURCHASE_TAX_WAYBILL_ITEM (
ID                   INTEGER                        not null,
PURCHASE_TAX_WAYBILL_ID INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
TAX_ID               INTEGER,
UNIT_ID              INTEGER                        not null,
PRODUCT_FEATURE_NAME VARCHAR(100),
PRICE                NUMERIC(9,2)                   default 0 not null,
TAX_PRICE            NUMERIC(9,2)                   default 0 not null,
QUANTITY             NUMERIC(9,4)                   default 0 not null,
AMOUNT               NUMERIC(15,2)                  not null,
TAX_AMOUNT           NUMERIC(15,2)                  not null,
IS_TAX               CHAR(1)                        not null,
CURRENCY_PRICE       NUMERIC(15,4)                  default 0 not null,
CURRENCY_TAX_PRICE   NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT      NUMERIC(15,2)                  not null,
CURRENCY_TAX_AMOUNT  NUMERIC(15,2)                  not null,
UNIT_RATE            NUMERIC(15,3)                  not null,
PRICE_WITH_TAX       NUMERIC(9,2)                   not null,
AMOUNT_WITH_TAX      NUMERIC(15,2)                  not null,
CURRENCY_PRICE_WITH_TAX NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT_WITH_TAX NUMERIC(15,2)                  not null,
TAX_PERCENT          NUMERIC(6,2)                   default 0 not null,
ACCOUNT_QUANTITY     NUMERIC(9,4)                   default 0 not null,
ACCOUNT_PRICE        NUMERIC(9,2)                   default 0 not null,
ACCOUNT_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
ACCOUNT_TAX_PRICE    NUMERIC(9,2)                   default 0 not null,
constraint PK_PURCHASE_TAX_WAYBILL_ITEM primary key (ID)
);

/*==============================================================*/
/*                                                              */
/* TODO: Must update system_entity, document_type (new docs)    */
/*                                                              */
/*==============================================================*/


/*==============================================================*/
/*                                                              */
/* ADD COLUMNS                                                  */
/*                                                              */
/*==============================================================*/

ALTER TABLE BUSINESSABLE
 ADD ORGANIZATION_ID INTEGER;

ALTER TABLE BUSINESSABLE
 ADD BRANCH_ID INTEGER;

ALTER TABLE PARTNER
 ADD NEC VARCHAR(20);
/* SWIFT_CODE */

ALTER TABLE PARTNER
 ADD IDN VARCHAR(12);
/* TAX_CODE */

UPDATE PARTNER SET NEC = SWIFT_CODE;
UPDATE PARTNER SET IDN = TAX_CODE;

ALTER TABLE PARTNER
 DROP SWIFT_CODE;

ALTER TABLE PARTNER
 DROP TAX_CODE;



/* PERSON_CARD.TAX_CODE -> IDN */
ALTER TABLE PERSON_CARD
 ADD IDN VARCHAR(12);

UPDATE PERSON_CARD SET IDN = TAX_CODE;

ALTER TABLE PERSON_CARD
 DROP TAX_CODE;


/* BANK.BANK_SWIFT_CODE -> BIC */

ALTER TABLE BANK
 ADD BIC VARCHAR(12);

UPDATE BANK SET BIC = BANK_SWIFT_CODE;

ALTER TABLE BANK
 DROP BANK_SWIFT_CODE;

/*==============================================================*/
/* Table:                                                       */
/*==============================================================*/



/*==============================================================*/
/*                                                              */
/* DROP COLUMNS                                                 */
/*                                                              */
/*==============================================================*/



/*==============================================================*/
/*                                                              */ 
/* Date: 2008-07-03                                             */
/*                                                              */
/*==============================================================*/


ALTER TABLE SYSTEM_INFO
 ADD BRANCH_ID INTEGER;


ALTER TABLE DOCUMENT_TYPE
 ADD IS_DOCUMENT_CODE_READ_ONLY CHAR(1) default 'N' not null;

ALTER TABLE DOCUMENT_TYPE
 ADD IS_DOCUMENT_DATE_READ_ONLY CHAR(1) default 'N' not null;


/*==============================================================*/
/* Table: BRANCH                                                */
/*==============================================================*/
create table BRANCH (
ID                   INTEGER                        not null,
ORGANIZATION_ID      INTEGER                        not null,
NAME                 VARCHAR(50)                    not null,
constraint PK_BRANCH primary key (ID)
);


/*==============================================================*/
/* Table: BRANCH_DOCUMENT_TYPE                                  */
/*==============================================================*/
CREATE TABLE BRANCH_DOCUMENT_TYPE (
ID                   INTEGER                        not null,
DOCUMENT_TYPE_ID     INTEGER                        not null,
DOCUMENT_CODE_PREFIX VARCHAR(10),
DOCUMENT_CODE_SUFFIX VARCHAR(10),
LAST_DOCUMENT_NUMBER INTEGER,
constraint PK_BRANCH_DOCUMENT_TYPE primary key (ID)
);


/*==============================================================*/
/* Table: PARTNER_REPRESENTATIVE                                */
/*==============================================================*/
CREATE TABLE PARTNER_REPRESENTATIVE (
ID                   INTEGER                        not null,
PARTNER_ID           INTEGER                        not null,
CODE                 VARCHAR(20),
NAME                 VARCHAR(100)                   not null,
DOCUMENT             VARCHAR(20),
ADDRESS              VARCHAR(100),
PHONE                VARCHAR(20),
constraint PK_PARTNER_REPRESENTATIVE primary key (ID)
);

ALTER TABLE TASK
 ADD PERCENT_COMPLETE  NUMERIC(6,2) default 0 not null;
 
ALTER TABLE TASK
 ADD ACTUAL_END_DATE_TIME TIMESTAMP;
 
UPDATE TASK SET PERCENT_COMPLETE = DONE_PERCENT;
UPDATE TASK SET ACTUAL_END_DATE_TIME = COMPLETED_DATE_TIME;

ALTER TABLE TASK
 DROP DONE_PERCENT;

ALTER TABLE TASK
 DROP COMPLETED_DATE_TIME;


ALTER TABLE PROJECT
 ADD PERCENT_COMPLETE NUMERIC(6,2) default 0 not null;
 
 
ALTER TABLE GOODS
 ADD IS_INVENTORY CHAR(1) default 'N' not null;

/* 1 - GOODS, 3 - SET, 4 - PRODUCT */
UPDATE GOODS SET IS_INVENTORY = 'Y' WHERE GOODS_TYPE_ID = 1 OR GOODS_TYPE_ID = 3 OR GOODS_TYPE_ID = 4;





/*==============================================================*/
/* Table: INVENTORY_REST                                        */
/*==============================================================*/
create table INVENTORY_REST (
ID                   INTEGER                        not null,
RESPONSIBLE_ID       INTEGER,
WAREHOUSE_ID         INTEGER                        not null,
constraint PK_INVENTORY_REST primary key (ID)
);

/*==============================================================*/
/* Table: INVENTORY_REST_ITEM                                   */
/*==============================================================*/
create table INVENTORY_REST_ITEM (
ID                   INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
INVENTORY_REST_ID    INTEGER                        not null,
TAX_ID               INTEGER,
PRICE                NUMERIC(9,2)                   not null,
TAX_PRICE            NUMERIC(9,2)                   not null,
QUANTITY             NUMERIC(9,4)                   not null,
AMOUNT               NUMERIC(15,2)                  not null,
TAX_AMOUNT           NUMERIC(15,2)                  not null,
IS_TAX               CHAR(1)                        default 'N' not null,
CURRENCY_PRICE       NUMERIC(9,2)                   not null,
CURRENCY_TAX_PRICE   NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT      NUMERIC(15,2)                  not null,
CURRENCY_TAX_AMOUNT  NUMERIC(15,2)                  not null,
UNIT_RATE            NUMERIC(15,3)                  not null,
PRICE_WITH_TAX       NUMERIC(9,2)                   not null,
AMOUNT_WITH_TAX      NUMERIC(15,2)                  not null,
CURRENCY_PRICE_WITH_TAX NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT_WITH_TAX NUMERIC(15,2)                  not null,
TAX_PERCENT          NUMERIC(6,2)                   default 0 not null,
ACCOUNT_QUANTITY     NUMERIC(9,4)                   default 0 not null,
ACCOUNT_PRICE        NUMERIC(9,2)                   default 0 not null,
ACCOUNT_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
ACCOUNT_TAX_PRICE    NUMERIC(9,2)                   default 0 not null,
constraint PK_INVENTORY_REST_ITEM primary key (ID)
);



/*===================================================================*/

INSERT INTO INVENTORY_REST SELECT * FROM GOODS_REST;
DROP TABLE GOODS_REST;

INSERT INTO INVENTORY_REST_ITEM 
 SELECT 
 ID,
 PRODUCT_ID,
 UNIT_ID,
 GOODS_REST_ID AS INVENTORY_REST_ID,
 TAX_ID,
 PRICE,
 TAX_PRICE,
 QUANTITY,
 AMOUNT,
 TAX_AMOUNT,
 IS_TAX,
 CURRENCY_PRICE,
 CURRENCY_TAX_PRICE,
 CURRENCY_AMOUNT,
 CURRENCY_TAX_AMOUNT,
 UNIT_RATE,
 PRICE_WITH_TAX,
 AMOUNT_WITH_TAX,
 CURRENCY_PRICE_WITH_TAX,
 CURRENCY_AMOUNT_WITH_TAX,
 TAX_PERCENT,
 ACCOUNT_QUANTITY,
 ACCOUNT_PRICE,
 ACCOUNT_PRICE_WITH_TAX,
 ACCOUNT_TAX_PRICE
 FROM GOODS_REST_ITEM;

DROP TABLE GOODS_REST_ITEM;





drop table INVENTORY_MOVE;


/*==============================================================*/
/* Table: INVENTORY_MOVE                                        */
/*==============================================================*/
create table INVENTORY_MOVE (
ID                   INTEGER                        not null,
INCOME_WAREHOUSE_ID  INTEGER                        not null,
OUTCOME_WAREHOUSE_ID INTEGER                        not null,
INCOME_RESPONSIBLE_ID INTEGER,
OUTCOME_RESPONSIBLE_ID INTEGER,
constraint PK_INVENTORY_MOVE primary key (ID)
);

/*==============================================================*/
/* Table: INVENTORY_MOVE_ITEM                                   */
/*==============================================================*/
create table INVENTORY_MOVE_ITEM (
ID                   INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
INVENTORY_MOVE_ID    INTEGER                        not null,
TAX_ID               INTEGER,
PRODUCT_ID           INTEGER                        not null,
PRICE                NUMERIC(9,2)                   not null,
TAX_PRICE            NUMERIC(9,2)                   not null,
QUANTITY             NUMERIC(9,4)                   not null,
AMOUNT               NUMERIC(15,2)                  not null,
TAX_AMOUNT           NUMERIC(15,2)                  not null,
IS_TAX               CHAR(1)                        default 'N' not null,
CURRENCY_PRICE       NUMERIC(9,2)                   not null,
CURRENCY_TAX_PRICE   NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT      NUMERIC(15,2)                  not null,
CURRENCY_TAX_AMOUNT  NUMERIC(15,2)                  not null,
UNIT_RATE            NUMERIC(15,3)                  not null,
PRICE_WITH_TAX       NUMERIC(9,2)                   not null,
AMOUNT_WITH_TAX      NUMERIC(15,2)                  not null,
CURRENCY_PRICE_WITH_TAX NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT_WITH_TAX NUMERIC(15,2)                  not null,
TAX_PERCENT          NUMERIC(6,2)                   default 0 not null,
ACCOUNT_QUANTITY     NUMERIC(9,4)                   default 0 not null,
ACCOUNT_PRICE        NUMERIC(9,2)                   default 0 not null,
ACCOUNT_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
ACCOUNT_TAX_PRICE    NUMERIC(9,2)                   default 0 not null,
constraint PK_INVENTORY_MOVE_ITEM primary key (ID)
);


/*===================================================================*/

INSERT INTO INVENTORY_MOVE SELECT * FROM GOODS_MOVE;
DROP TABLE GOODS_MOVE;

INSERT INTO INVENTORY_MOVE_ITEM 
 SELECT 
 ID,
 UNIT_ID,
 GOODS_MOVE_ID AS INVENTORY_MOVE_ID,
 TAX_ID,
 PRODUCT_ID,
 PRICE,
 TAX_PRICE,
 QUANTITY,
 AMOUNT,
 TAX_AMOUNT,
 IS_TAX,
 CURRENCY_PRICE,
 CURRENCY_TAX_PRICE,
 CURRENCY_AMOUNT,
 CURRENCY_TAX_AMOUNT,
 UNIT_RATE,
 PRICE_WITH_TAX,
 AMOUNT_WITH_TAX,
 CURRENCY_PRICE_WITH_TAX,
 CURRENCY_AMOUNT_WITH_TAX,
 TAX_PERCENT,
 ACCOUNT_QUANTITY,
 ACCOUNT_PRICE,
 ACCOUNT_PRICE_WITH_TAX,
 ACCOUNT_TAX_PRICE
 FROM GOODS_MOVE_ITEM;

DROP TABLE GOODS_MOVE_ITEM;


drop table INVENTORY_WRITEOFF;

/*==============================================================*/
/* Table: INVENTORY_WRITEOFF                                    */
/*==============================================================*/
create table INVENTORY_WRITEOFF (
ID                   INTEGER                        not null,
WAREHOUSE_ID         INTEGER                        not null,
RESPONSIBLE_ID       INTEGER,
constraint PK_INVENTORY_WRITEOFF primary key (ID)
);

/*==============================================================*/
/* Table: INVENTORY_WRITEOFF_ITEM                               */
/*==============================================================*/
create table INVENTORY_WRITEOFF_ITEM (
ID                   INTEGER                        not null,
INVENTORY_WRITEOFF_ID INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
TAX_ID               INTEGER,
PRICE                NUMERIC(9,2)                   not null,
TAX_PRICE            NUMERIC(9,2)                   not null,
QUANTITY             NUMERIC(9,4)                   not null,
AMOUNT               NUMERIC(15,2)                  not null,
TAX_AMOUNT           NUMERIC(15,2)                  not null,
IS_TAX               CHAR(1)                        default 'N' not null,
CURRENCY_PRICE       NUMERIC(9,2)                   not null,
CURRENCY_TAX_PRICE   NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT      NUMERIC(15,2)                  not null,
CURRENCY_TAX_AMOUNT  NUMERIC(15,2)                  not null,
UNIT_RATE            NUMERIC(15,3)                  not null,
PRICE_WITH_TAX       NUMERIC(9,2)                   not null,
AMOUNT_WITH_TAX      NUMERIC(15,2)                  not null,
CURRENCY_PRICE_WITH_TAX NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT_WITH_TAX NUMERIC(15,2)                  not null,
TAX_PERCENT          NUMERIC(6,2)                   default 0 not null,
ACCOUNT_QUANTITY     NUMERIC(9,4)                   default 0 not null,
ACCOUNT_PRICE        NUMERIC(9,2)                   default 0 not null,
ACCOUNT_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
ACCOUNT_TAX_PRICE    NUMERIC(9,2)                   default 0 not null,
constraint PK_INVENTORY_WRITEOFF_ITEM primary key (ID)
);


/*==============================================================*/
INSERT INTO INVENTORY_WRITEOFF SELECT * FROM GOODS_WRITEOFF;
DROP TABLE GOODS_WRITEOFF;

INSERT INTO INVENTORY_WRITEOFF_ITEM 
 SELECT 
 ID,
 GOODS_WRITEOFF_ID AS INVENTORY_WRITEOFF_ID,
 UNIT_ID,
 PRODUCT_ID,
 TAX_ID,
 PRICE,
 TAX_PRICE,
 QUANTITY,
 AMOUNT,
 TAX_AMOUNT,
 IS_TAX,
 CURRENCY_PRICE,
 CURRENCY_TAX_PRICE,
 CURRENCY_AMOUNT,
 CURRENCY_TAX_AMOUNT,
 UNIT_RATE,
 PRICE_WITH_TAX,
 AMOUNT_WITH_TAX,
 CURRENCY_PRICE_WITH_TAX,
 CURRENCY_AMOUNT_WITH_TAX,
 TAX_PERCENT,
 ACCOUNT_QUANTITY,
 ACCOUNT_PRICE,
 ACCOUNT_PRICE_WITH_TAX,
 ACCOUNT_TAX_PRICE
FROM GOODS_WRITEOFF_ITEM;

DROP TABLE GOODS_WRITEOFF_ITEM;



drop table INVENTORY_INCOME;

/*==============================================================*/
/* Table: INVENTORY_INCOME                                      */
/*==============================================================*/
create table INVENTORY_INCOME (
ID                   INTEGER                        not null,
WAREHOUSE_ID         INTEGER                        not null,
RESPONSIBLE_ID       INTEGER,
DELIVERY             NUMERIC(15,2)                  default 0 not null,
TAX_DELIVERY         NUMERIC(15,2)                  default 0 not null,
DELIVERY_WITH_TAX    NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY    NUMERIC(15,2)                  default 0 not null,
CURRENCY_TAX_DELIVERY NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY_WITH_TAX NUMERIC(15,2)                  default 0 not null,
constraint PK_INVENTORY_INCOME primary key (ID)
);

/*==============================================================*/
/* Table: INVENTORY_INCOME_ITEM                                 */
/*==============================================================*/
create table INVENTORY_INCOME_ITEM (
ID                   INTEGER                        not null,
INVENTORY_INCOME_ID  INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
TAX_ID               INTEGER,
PRODUCT_FEATURE_NAME VARCHAR(100),
PRICE                NUMERIC(9,2)                   default 0 not null,
TAX_PRICE            NUMERIC(9,2)                   default 0 not null,
QUANTITY             NUMERIC(9,4)                   default 0 not null,
AMOUNT               NUMERIC(15,2)                  default 0 not null,
TAX_AMOUNT           NUMERIC(15,2)                  default 0 not null,
IS_TAX               CHAR(1)                        default 'N' not null,
CURRENCY_PRICE       NUMERIC(9,2)                   default 0 not null,
CURRENCY_TAX_PRICE   NUMERIC(9,2)                   default 0 not null,
CURRENCY_AMOUNT      NUMERIC(15,2)                  default 0 not null,
CURRENCY_TAX_AMOUNT  NUMERIC(15,2)                  default 0 not null,
UNIT_RATE            NUMERIC(15,3)                  not null,
PRICE_WITH_TAX       NUMERIC(9,2)                   default 0 not null,
AMOUNT_WITH_TAX      NUMERIC(15,2)                  default 0 not null,
CURRENCY_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
CURRENCY_AMOUNT_WITH_TAX NUMERIC(15,2)                  default 0 not null,
TAX_PERCENT          NUMERIC(6,2)                   default 0 not null,
ACCOUNT_QUANTITY     NUMERIC(9,4)                   default 0 not null,
ACCOUNT_PRICE        NUMERIC(9,2)                   default 0 not null,
ACCOUNT_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
ACCOUNT_TAX_PRICE    NUMERIC(9,2)                   default 0 not null,
constraint PK_INVENTORY_INCOME_ITEM primary key (ID)
);


drop table INVENTORY_OUTCOME;

/*==============================================================*/
/* Table: INVENTORY_OUTCOME                                     */
/*==============================================================*/
create table INVENTORY_OUTCOME (
ID                   INTEGER                        not null,
WAREHOUSE_ID         INTEGER                        not null,
RESPONSIBLE_ID       INTEGER,
DELIVERY             NUMERIC(15,2)                  default 0 not null,
TAX_DELIVERY         NUMERIC(15,2)                  default 0 not null,
DELIVERY_WITH_TAX    NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY    NUMERIC(15,2)                  default 0 not null,
CURRENCY_TAX_DELIVERY NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY_WITH_TAX NUMERIC(15,2)                  default 0 not null,
constraint PK_INVENTORY_OUTCOME primary key (ID)
);

/*==============================================================*/
/* Table: INVENTORY_OUTCOME_ITEM                                */
/*==============================================================*/
create table INVENTORY_OUTCOME_ITEM (
ID                   INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
TAX_ID               INTEGER,
PRODUCT_INSTANCE_ID  INTEGER,
PRODUCT_ID           INTEGER                        not null,
INVENTORY_OUTCOME_ID INTEGER                        not null,
PRODUCT_FEATURE_NAME VARCHAR(100),
PRICE                NUMERIC(9,2)                   default 0 not null,
TAX_PRICE            NUMERIC(9,2)                   default 0 not null,
QUANTITY             NUMERIC(9,4)                   default 0 not null,
AMOUNT               NUMERIC(15,2)                  default 0 not null,
TAX_AMOUNT           NUMERIC(15,2)                  default 0 not null,
IS_TAX               CHAR(1)                        default 'N' not null,
CURRENCY_PRICE       NUMERIC(9,2)                   default 0 not null,
CURRENCY_TAX_PRICE   NUMERIC(9,2)                   default 0 not null,
CURRENCY_AMOUNT      NUMERIC(15,2)                  default 0 not null,
CURRENCY_TAX_AMOUNT  NUMERIC(15,2)                  default 0 not null,
UNIT_RATE            NUMERIC(15,3)                  not null,
PRICE_WITH_TAX       NUMERIC(9,2)                   default 0 not null,
AMOUNT_WITH_TAX      NUMERIC(15,2)                  default 0 not null,
CURRENCY_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
CURRENCY_AMOUNT_WITH_TAX NUMERIC(15,2)                  default 0 not null,
TAX_PERCENT          NUMERIC(6,2)                   default 0 not null,
ACCOUNT_QUANTITY     NUMERIC(9,4)                   default 0 not null,
ACCOUNT_PRICE        NUMERIC(9,2)                   default 0 not null,
ACCOUNT_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
ACCOUNT_TAX_PRICE    NUMERIC(9,2)                   default 0 not null,
constraint PK_INVENTORY_OUTCOME_ITEM primary key (ID)
);


ALTER TABLE  SYSTEM_ROLE
 ADD DEFAULT_UI_ID CHAR(30);


ALTER TABLE  SYSTEM_USER
 ADD DEFAULT_UI_ID CHAR(30);


create table SYSTEM_ROLE_UI (
ID                   INTEGER                        not null,
ROLE_ID              INTEGER                        not null,
UI_ID                VARCHAR(30)                    not null,
constraint PK_SYSTEM_ROLE_UI primary key (ID)
);



ALTER TABLE SYSTEM_ENTITY
 ADD IS_CACHE CHAR(1) default 'N' not null;

ALTER TABLE SYSTEM_ENTITY
 ADD CACHE_EXPIRE_TIME INTEGER default 0 not null;


/* PRODUCT.LIST_PRICE */

ALTER TABLE PRODUCT
 ADD LIST_PRICE  NUMERIC(15,4) default 0 not null;

ALTER TABLE PRODUCT
 ADD CURRENCY_LIST_PRICE  NUMERIC(15,4) default 0 not null;

UPDATE PRODUCT SET LIST_PRICE = PRICE, CURRENCY_LIST_PRICE = CURRENCY_PRICE;


/* PRODUCT.AVAILABILITY_QUANTITY -> AVAILABLE_QUANTITY */
/* PRODUCT.RESERVE_QUANTITY -> RESERVED_QUANTITY */
/* PRODUCT.AWAIT_QUANTITY -> EXPECTED_QUANTITY */
    
ALTER TABLE PRODUCT
 ADD AVAILABLE_QUANTITY NUMERIC(15,4) default 0 not null;

ALTER TABLE PRODUCT
 ADD RESERVED_QUANTITY NUMERIC(15,4) default 0 not null;

ALTER TABLE PRODUCT
 ADD EXPECTED_QUANTITY NUMERIC(15,4) default 0 not null;


UPDATE PRODUCT SET AVAILABLE_QUANTITY = AVAILABILITY_QUANTITY;
UPDATE PRODUCT SET RESERVED_QUANTITY = RESERVE_QUANTITY;
UPDATE PRODUCT SET EXPECTED_QUANTITY = AWAIT_QUANTITY;



/*==============================================================*/
/* Table: PARTNER_TYPE                                          */
/*==============================================================*/
create table PARTNER_TYPE (
ID                   INTEGER                        not null,
NAME                 VARCHAR(30)                    not null,
constraint PK_PARTNER_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: SYSTEM_USER_ORG                                       */
/*==============================================================*/
create table SYSTEM_USER_ORG (
ID                   INTEGER                        not null,
ORGANIZATION_ID      INTEGER                        not null,
USER_ID              INTEGER                        not null,
constraint PK_SYSTEM_USER_ORG primary key (ID)
);





/*==============================================================*/
/* FIX                                                          */
/*==============================================================*/



ALTER TABLE BRIGADE
 ADD BRANCH_ID INTEGER;

ALTER TABLE BUSINESSABLE_REGISTER
 ADD BRANCH_ID INTEGER;

ALTER TABLE DEPARTMENT
 ADD BRANCH_ID INTEGER;

ALTER TABLE DOCUMENT
 ADD BRANCH_ID INTEGER;

ALTER TABLE DRUGSTORE
 ADD BRANCH_ID INTEGER;

ALTER TABLE EMPLOYEE
 ADD BRANCH_ID INTEGER;

ALTER TABLE EMPLOYEE_PAYROLL
 ADD BRANCH_ID INTEGER;

ALTER TABLE FACTORY
 ADD BRANCH_ID INTEGER;

/* It was removed to <lang>/update_data...*/
/*
ALTER TABLE PARTNER
 ADD PARTNER_TYPE_ID INTEGER DEFAULT 1 NOT NULL;
*/

ALTER TABLE PRODUCT
 DROP AVAILABILITY_QUANTITY;

ALTER TABLE PRODUCT
 DROP RESERVE_QUANTITY;

ALTER TABLE PRODUCT
 DROP AWAIT_QUANTITY;

ALTER TABLE PROJECT
 ADD BRANCH_ID INTEGER;

ALTER TABLE RESPONSIBLE
 ADD BRANCH_ID INTEGER;


ALTER TABLE SHOP
 ADD BRANCH_ID INTEGER;

ALTER TABLE STORE
 ADD BRANCH_ID INTEGER;

ALTER TABLE SYSTEM_INFO
 ADD IS_AUTO_CALCULATE_PROD_REST CHAR(1) DEFAULT 'Y' NOT NULL;

ALTER TABLE SYSTEM_ROLE
 DROP UI_ID;

ALTER TABLE SYSTEM_USER
 DROP UI_ID;

ALTER TABLE TASK
 ADD BRANCH_ID INTEGER;

ALTER TABLE WORKS
 ADD BRANCH_ID INTEGER;

ALTER TABLE WORKSHOP
 ADD BRANCH_ID INTEGER;