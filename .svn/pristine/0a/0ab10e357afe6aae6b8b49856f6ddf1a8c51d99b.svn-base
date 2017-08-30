/*==============================================================*/
/* Database name:  Plazma/CarService                            */
/* Created on:     23.11.2008 12:00:21                          */
/*==============================================================*/


/*==============================================================*/
/* Table: CAR                                                   */
/*==============================================================*/
create table CAR (
ID                   INTEGER                        not null,
CAR_MARK_ID          INTEGER,
CAR_MODEL_ID         INTEGER,
PARTNER_ID           INTEGER,
CAR_CLASS_ID         INTEGER,
REG_NUMBER           VARCHAR(20),
CHASSIS_NUMBER       VARCHAR(20),
ENGINE_VOLUME        NUMERIC(9,3)                   default 0 not null,
MANUFACTURE_YEAR     INTEGER                        default 0 not null,
constraint PK_CAR primary key (ID)
);

/*==============================================================*/
/* Table: CAR_AGE                                               */
/*==============================================================*/
create table CAR_AGE (
ID                   INTEGER                        not null,
NAME                 VARCHAR(50)                    not null,
SECTION              INTEGER                        default 0 not null,
AGE_FROM             INTEGER                        default 0 not null,
AGE_TO               INTEGER                        default 0 not null,
constraint PK_CAR_AGE primary key (ID)
);

/*==============================================================*/
/* Table: CAR_CLASS                                             */
/*==============================================================*/
create table CAR_CLASS (
ID                   INTEGER                        not null,
CODE                 VARCHAR(2),
NAME                 VARCHAR(50),
constraint PK_CAR_CLASS primary key (ID)
);

/*==============================================================*/
/* Table: CAR_DAMAGE_LEVEL                                      */
/*==============================================================*/
create table CAR_DAMAGE_LEVEL (
ID                   INTEGER                        not null,
NAME                 VARCHAR(50)                    not null,
constraint PK_CAR_DAMAGE_LEVEL primary key (ID)
);

/*==============================================================*/
/* Table: CAR_DETAIL                                            */
/*==============================================================*/
create table CAR_DETAIL (
ID                   INTEGER                        not null,
CAR_MARK_ID          INTEGER,
CAR_MODEL_ID         INTEGER,
constraint PK_CAR_DETAIL primary key (ID)
);

/*==============================================================*/
/* Table: CAR_DETAIL_VARIANT                                    */
/*==============================================================*/
create table CAR_DETAIL_VARIANT (
ID                   INTEGER                        not null,
CAR_DAMAGE_LEVEL_ID  INTEGER,
CAR_DETAIL_ID        INTEGER                        not null,
IS_PNT               CHAR(1)                        default 'N' not null,
IS_MAT               CHAR(1)                        default 'N' not null,
IS_POL               CHAR(1)                        default 'N' not null,
constraint PK_CAR_DETAIL_VARIANT primary key (ID)
);

/*==============================================================*/
/* Table: CAR_DETAIL_VARIANT_PAINT                              */
/*==============================================================*/
create table CAR_DETAIL_VARIANT_PAINT (
ID                   INTEGER                        not null,
CAR_PAINT_DETAIL_TYPE_ID INTEGER,
CAR_DETAIL_VARIANT_ID INTEGER                        not null,
CAR_PAINT_ID         INTEGER                        not null,
constraint PK_CAR_DETAIL_VARIANT_PAINT primary key (ID)
);

/*==============================================================*/
/* Table: CAR_DETAIL_VARIANT_PART                               */
/*==============================================================*/
create table CAR_DETAIL_VARIANT_PART (
ID                   INTEGER                        not null,
CAR_PART_ID          INTEGER                        not null,
CAR_DETAIL_VARIANT_ID INTEGER                        not null,
constraint PK_CAR_DETAIL_VARIANT_PART primary key (ID)
);

/*==============================================================*/
/* Table: CAR_DETAIL_VARIANT_SERV                               */
/*==============================================================*/
create table CAR_DETAIL_VARIANT_SERV (
ID                   INTEGER                        not null,
CAR_DETAIL_VARIANT_ID INTEGER                        not null,
CAR_CLASS_ID         INTEGER,
CAR_SERV_ID          INTEGER                        not null,
WORK_HOUR            NUMERIC(6,2)                   default 0 not null,
constraint PK_CAR_DETAIL_VARIANT_SERV primary key (ID)
);

/*==============================================================*/
/* Table: CAR_INSURER_CONSUMABLES_PRICE                         */
/*==============================================================*/
create table CAR_INSURER_CONSUMABLES_PRICE (
ID                   INTEGER                        not null,
CAR_CLASS_ID         INTEGER                        not null,
CAR_PAINT_DETAIL_TYPE_ID INTEGER                        not null,
CONTRACT_VARIANT_ID  INTEGER                        not null,
CAR_DAMAGE_LEVEL_ID  INTEGER,
PRICE                NUMERIC(9,2)                   default 0 not null,
PRICE_PERCENT        NUMERIC(9,2)                   default 0 not null,
VALUE_TYPE           INTEGER                        default 1 not null,
constraint PK_CAR_INSURER_CONSUMABLES_PRI primary key (ID)
);

/*==============================================================*/
/* Table: CAR_INSURER_CONTRACT_VARIANT                          */
/*==============================================================*/
create table CAR_INSURER_CONTRACT_VARIANT (
ID                   INTEGER                        not null,
ORGANIZATION_ID      INTEGER                        not null,
INSURER_ID           INTEGER                        not null,
CONTRACT_CODE        VARCHAR(20),
CONTRACT_DATE        DATE,
VARIANT_CODE         VARCHAR(20),
VARIANT_DATE         DATE,
constraint PK_CAR_INSURER_CONTRACT_VARIAN primary key (ID)
);

/*==============================================================*/
/* Table: CAR_INSURER_PAINT_BOX_PRICE                           */
/*==============================================================*/
create table CAR_INSURER_PAINT_BOX_PRICE (
ID                   INTEGER                        not null,
CAR_PAINT_DETAIL_TYPE_ID INTEGER                        not null,
CONTRACT_VARIANT_ID  INTEGER                        not null,
AGE_FROM             INTEGER                        default 0 not null,
AGE_TO               INTEGER                        default 0 not null,
PRICE                NUMERIC(9,2)                   default 0 not null,
constraint PK_CAR_INSURER_PAINT_BOX_PRICE primary key (ID)
);

/*==============================================================*/
/* Table: CAR_INSURER_PAINT_TYPE_PRICE                          */
/*==============================================================*/
create table CAR_INSURER_PAINT_TYPE_PRICE (
ID                   INTEGER                        not null,
PRICE                NUMERIC(9,2)                   default 0 not null,
CAR_PAINT_MARK_ID    INTEGER,
CONTRACT_VARIANT_ID  INTEGER                        not null,
CAR_PAINT_TYPE_ID    INTEGER                        not null,
constraint PK_CAR_INSURER_PAINT_TYPE_PRIC primary key (ID, PRICE)
);

/*==============================================================*/
/* Table: CAR_INSURER_PAINT_TYPE_VOLUME                         */
/*==============================================================*/
create table CAR_INSURER_PAINT_TYPE_VOLUME (
ID                   INTEGER                        not null,
CONTRACT_VARIANT_ID  INTEGER                        not null,
CAR_CLASS_ID         INTEGER                        not null,
CAR_PAINT_DETAIL_TYPE_ID INTEGER                        not null,
VOLUME               NUMERIC(9,3)                   default 0 not null,
VOLUME_TO            NUMERIC(9,3)                   default 0 not null,
PERCENT_OF_BASIC     NUMERIC(9,2)                   default 0 not null,
IS_RANGE             CHAR(1)                        default 'N' not null,
VALUE_TYPE           INTEGER                        default 1 not null,
constraint PK_CAR_INSURER_PAINT_TYPE_VOLU primary key (ID)
);

/*==============================================================*/
/* Table: CAR_INSURER_PART_PRICE                                */
/*==============================================================*/
create table CAR_INSURER_PART_PRICE (
ID                   INTEGER                        not null,
CONTRACT_VARIANT_ID  INTEGER                        not null,
AGE_FROM             INTEGER                        default 0 not null,
AGE_TO               INTEGER                        default 0 not null,
DISCOUNT_PERCENT     NUMERIC(9,2)                   default 0 not null,
constraint PK_CAR_INSURER_PART_PRICE primary key (ID)
);

/*==============================================================*/
/* Table: CAR_INSURER_PREPARE_HOUR                              */
/*==============================================================*/
create table CAR_INSURER_PREPARE_HOUR (
ID                   INTEGER                        not null,
CAR_DAMAGE_LEVEL_ID  INTEGER                        not null,
CONTRACT_VARIANT_ID  INTEGER                        not null,
CAR_PREPARE_TYPE_ID  INTEGER                        not null,
PREPARE_HOUR         NUMERIC(6,2)                   not null,
constraint PK_CAR_INSURER_PREPARE_HOUR primary key (ID)
);

/*==============================================================*/
/* Table: CAR_INSURER_SERV_PRICE                                */
/*==============================================================*/
create table CAR_INSURER_SERV_PRICE (
ID                   INTEGER                        not null,
CAR_SERV_TYPE_ID     INTEGER,
CONTRACT_VARIANT_ID  INTEGER                        not null,
CAR_AGE_ID           INTEGER                        not null,
PRICE                NUMERIC(9,2)                   default 0 not null,
constraint PK_CAR_INSURER_SERV_PRICE primary key (ID)
);

/*==============================================================*/
/* Table: CAR_MANUFACTURER                                      */
/*==============================================================*/
create table CAR_MANUFACTURER (
ID                   INTEGER                        not null,
NAME                 VARCHAR(50)                    not null,
constraint PK_CAR_MANUFACTURER primary key (ID)
);

/*==============================================================*/
/* Table: CAR_MARK                                              */
/*==============================================================*/
create table CAR_MARK (
ID                   INTEGER                        not null,
NAME                 VARCHAR(50)                    not null,
constraint PK_CAR_MARK primary key (ID)
);

/*==============================================================*/
/* Table: CAR_MODEL                                             */
/*==============================================================*/
create table CAR_MODEL (
ID                   INTEGER                        not null,
CAR_MARK_ID          INTEGER,
CAR_MANUFACTURER_ID  INTEGER,
NAME                 VARCHAR(50)                    not null,
constraint PK_CAR_MODEL primary key (ID)
);

/*==============================================================*/
/* Table: CAR_MTRL_FIND_REPORT                                  */
/*==============================================================*/
create table CAR_MTRL_FIND_REPORT (
ID                   INTEGER                        not null,
CAR_MTRL_FIND_REQUEST_ID INTEGER                        not null,
constraint PK_CAR_MTRL_FIND_REPORT primary key (ID)
);

/*==============================================================*/
/* Table: CAR_MTRL_FIND_REPORT_ITEM                             */
/*==============================================================*/
create table CAR_MTRL_FIND_REPORT_ITEM (
ID                   INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
CAR_MTRL_FIND_REPORT_ID INTEGER                        not null,
QUANTITY             NUMERIC(9,4),
PRICE                NUMERIC(9,2),
CURRENCY_PRICE       NUMERIC(9,2),
UNIT_RATE            NUMERIC(15,3)                  not null,
AMOUNT               NUMERIC(15,2)                  default 0 not null,
CURRENCY_AMOUNT      NUMERIC(15,2)                  default 0 not null,
constraint PK_CAR_MTRL_FIND_REPORT_ITEM primary key (ID)
);

/*==============================================================*/
/* Table: CAR_MTRL_FIND_REPORT_PRICE                            */
/*==============================================================*/
create table CAR_MTRL_FIND_REPORT_PRICE (
ID                   INTEGER                        not null,
ITEM_ID              INTEGER                        not null,
SUPPLIER_ID          INTEGER                        not null,
PRICE                NUMERIC(9,2)                   default 0 not null,
CURRENCY_PRICE       NUMERIC(9,2)                   default 0 not null,
DELIVERY_DATE        DATE,
constraint PK_CAR_MTRL_FIND_REPORT_PRICE primary key (ID)
);

/*==============================================================*/
/* Table: CAR_MTRL_FIND_REQUEST                                 */
/*==============================================================*/
create table CAR_MTRL_FIND_REQUEST (
ID                   INTEGER                        not null,
CAR_SERV_ORDER_ID    INTEGER                        not null,
EMPLOYEE_ID          INTEGER                        not null,
constraint PK_CAR_MTRL_FIND_REQUEST primary key (ID)
);

/*==============================================================*/
/* Table: CAR_MTRL_FIND_REQUEST_ITEM                            */
/*==============================================================*/
create table CAR_MTRL_FIND_REQUEST_ITEM (
ID                   INTEGER                        not null,
CAR_MTRL_FIND_REQUEST_ID INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
QUANTITY             NUMERIC(9,4)                   default 0 not null,
PRICE                NUMERIC(9,2)                   default 0 not null,
CURRENCY_PRICE       NUMERIC(9,2)                   default 0 not null,
UNIT_RATE            NUMERIC(15,3)                  not null,
AMOUNT               NUMERIC(15,2)                  default 0 not null,
CURRENCY_AMOUNT      NUMERIC(15,2)                  default 0 not null,
constraint PK_CAR_MTRL_FIND_REQUEST_ITEM primary key (ID)
);

/*==============================================================*/
/* Table: CAR_MTRL_PURCHASE_REPORT                              */
/*==============================================================*/
create table CAR_MTRL_PURCHASE_REPORT (
ID                   INTEGER                        not null,
CAR_MTRL_PURCHASE_REQUEST_ID INTEGER                        not null,
constraint PK_CAR_MTRL_PURCHASE_REPORT primary key (ID)
);

/*==============================================================*/
/* Table: CAR_MTRL_PURCHASE_REPORT_ITEM                         */
/*==============================================================*/
create table CAR_MTRL_PURCHASE_REPORT_ITEM (
ID                   INTEGER                        not null,
SUPPLIER_ID          INTEGER,
PRODUCT_ID           INTEGER                        not null,
CAR_MTRL_PURCHASE_REPORT_ID INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
QUANTITY             NUMERIC(9,4)                   default 0 not null,
PRICE                NUMERIC(9,2)                   default 0 not null,
CURRENCY_PRICE       NUMERIC(9,2)                   default 0 not null,
UNIT_RATE            NUMERIC(15,3)                  not null,
AMOUNT               NUMERIC(15,2)                  default 0 not null,
CURRENCY_AMOUNT      NUMERIC(15,2)                  default 0 not null,
DELIVERY_DATE        DATE,
constraint PK_CAR_MTRL_PURCHASE_REPORT_IT primary key (ID)
);

/*==============================================================*/
/* Table: CAR_MTRL_PURCHASE_REQUEST                             */
/*==============================================================*/
create table CAR_MTRL_PURCHASE_REQUEST (
ID                   INTEGER                        not null,
CAR_MTRL_FIND_REPORT_ID INTEGER                        not null,
constraint PK_CAR_MTRL_PURCHASE_REQUEST primary key (ID)
);

/*==============================================================*/
/* Table: CAR_MTRL_PURCHASE_REQUEST_ITEM                        */
/*==============================================================*/
create table CAR_MTRL_PURCHASE_REQUEST_ITEM (
ID                   INTEGER                        not null,
CAR_MTRL_PURCHASE_REQUEST_ID INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
SUPPLIER_ID          INTEGER,
QUANTITY             NUMERIC(9,4)                   default 0 not null,
PRICE                NUMERIC(9,2)                   default 0 not null,
CURRENCY_PRICE       NUMERIC(9,2)                   default 0 not null,
UNIT_RATE            NUMERIC(15,3)                  not null,
AMOUNT               NUMERIC(15,2)                  default 0 not null,
CURRENCY_AMOUNT      NUMERIC(15,2)                  default 0 not null,
DELIVERY_DATE        DATE,
constraint PK_CAR_MTRL_PURCHASE_REQUEST_I primary key (ID)
);

/*==============================================================*/
/* Table: CAR_PAINT                                             */
/*==============================================================*/
create table CAR_PAINT (
ID                   INTEGER                        not null,
CAR_PAINT_TYPE_ID    INTEGER,
CAR_PAINT_MARK_ID    INTEGER,
IS_CONSUMABLES       CHAR(1)                        default 'N',
constraint PK_CAR_PAINT primary key (ID)
);

/*==============================================================*/
/* Table: CAR_PAINT_DETAIL_TYPE                                 */
/*==============================================================*/
create table CAR_PAINT_DETAIL_TYPE (
ID                   INTEGER                        not null,
NAME                 VARCHAR(50)                    not null,
constraint PK_CAR_PAINT_DETAIL_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: CAR_PAINT_MARK                                        */
/*==============================================================*/
create table CAR_PAINT_MARK (
ID                   INTEGER                        not null,
NAME                 VARCHAR(50)                    not null,
constraint PK_CAR_PAINT_MARK primary key (ID)
);

/*==============================================================*/
/* Table: CAR_PAINT_TYPE                                        */
/*==============================================================*/
create table CAR_PAINT_TYPE (
ID                   INTEGER                        not null,
NAME                 VARCHAR(50)                    not null,
constraint PK_CAR_PAINT_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: CAR_PART                                              */
/*==============================================================*/
create table CAR_PART (
ID                   INTEGER                        not null,
CAR_MODEL_ID         INTEGER,
CAR_MARK_ID          INTEGER,
constraint PK_CAR_PART primary key (ID)
);

/*==============================================================*/
/* Table: CAR_PREPARE_TYPE                                      */
/*==============================================================*/
create table CAR_PREPARE_TYPE (
ID                   INTEGER                        not null,
NAME                 VARCHAR(50)                    not null,
constraint PK_CAR_PREPARE_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: CAR_SERV                                              */
/*==============================================================*/
create table CAR_SERV (
ID                   INTEGER                        not null,
CAR_SERV_TYPE_ID     INTEGER,
constraint PK_CAR_SERV primary key (ID)
);

/*==============================================================*/
/* Table: CAR_SERV_COMPLEXITY                                   */
/*==============================================================*/
create table CAR_SERV_COMPLEXITY (
ID                   INTEGER                        not null,
NAME                 VARCHAR(50),
constraint PK_CAR_SERV_COMPLEXITY primary key (ID)
);

/*==============================================================*/
/* Table: CAR_SERV_CONTEXT                                      */
/*==============================================================*/
create table CAR_SERV_CONTEXT (
ID                   INTEGER                        not null,
PAINT_BOX_SERV_ID    INTEGER,
constraint PK_CAR_SERV_CONTEXT primary key (ID)
);

/*==============================================================*/
/* Table: CAR_SERV_HOUR                                         */
/*==============================================================*/
create table CAR_SERV_HOUR (
ID                   INTEGER                        not null,
CAR_SERV_ID          INTEGER                        not null,
CAR_CLASS_ID         INTEGER                        not null,
CAR_SERV_COMLEXITY_ID INTEGER                        not null,
constraint PK_CAR_SERV_HOUR primary key (ID)
);

/*==============================================================*/
/* Table: CAR_SERV_LINK                                         */
/*==============================================================*/
create table CAR_SERV_LINK (
ID                   INTEGER                        not null,
CAR_SERV_LINK_ID     INTEGER                        not null,
CAR_SERV_ID          INTEGER                        not null,
constraint PK_CAR_SERV_LINK primary key (ID)
);

/*==============================================================*/
/* Table: CAR_SERV_ORDER                                        */
/*==============================================================*/
create table CAR_SERV_ORDER (
ID                   INTEGER                        not null,
WAREHOUSE_ID         INTEGER,
RESPONSIBLE_ID       INTEGER,
PRICE_TYPE_ID        INTEGER,
OUTCOME_REPRESENTATIVE_ID INTEGER,
INCOME_REPRESENTATIVE_ID INTEGER,
CAR_ID               INTEGER                        not null,
ADDITIONAL_REPAIR_ID INTEGER,
CORRECT_PRICE_TYPE   CHAR(3),
DISCOUNT_PERCENT     NUMERIC(6,2)                   default 0 not null,
MARKUP_PERCENT       NUMERIC(6,2)                   default 0 not null,
IS_PAID              CHAR(1)                        default 'N' not null,
CAR_INCOME_DATE      DATE,
CAR_OUTCOME_DATE     DATE,
constraint PK_CAR_SERV_ORDER primary key (ID)
);

/*==============================================================*/
/* Table: CAR_SERV_ORDER_DAMAGE                                 */
/*==============================================================*/
create table CAR_SERV_ORDER_DAMAGE (
ID                   INTEGER                        not null,
INSURER_ID           INTEGER,
BROKER_ID            INTEGER,
CAR_CLASS_ID         INTEGER,
CAR_SERV_ORDER_ID    INTEGER                        not null,
TOTAL_INVENTORY_ID   INTEGER,
DAMAGE_DATE          DATE,
DAMAGE_CODE          VARCHAR(20),
TOTAL_AMOUNT         NUMERIC(15,2)                  default 0 not null,
CURRENCY_TOTAL_AMOUNT NUMERIC(15,2)                  default 0 not null,
constraint PK_CAR_SERV_ORDER_DAMAGE primary key (ID)
);

/*==============================================================*/
/* Table: CAR_SERV_ORDER_IMAGE                                  */
/*==============================================================*/
create table CAR_SERV_ORDER_IMAGE (
ID                   INTEGER                        not null,
CAR_SERV_ORDER_ID    INTEGER                        not null,
NAME                 VARCHAR(50),
RECORD_TYPE          VARCHAR(10)                    not null,
IMAGE_SIZE           INTEGER                        default 0 not null,
constraint PK_CAR_SERV_ORDER_IMAGE primary key (ID)
);

/*==============================================================*/
/* Table: CAR_SERV_ORDER_INVENTORY                              */
/*==============================================================*/
create table CAR_SERV_ORDER_INVENTORY (
ID                   INTEGER                        not null,
CAR_SERV_ORDER_DAMAGE_ID INTEGER                        not null,
CAR_PAINT_TYPE_ID    INTEGER,
INVENTORY_DATE       DATE,
constraint PK_CAR_SERV_ORDER_INVENTORY primary key (ID)
);

/*==============================================================*/
/* Table: CAR_SERV_ORDER_ITEM                                   */
/*==============================================================*/
create table CAR_SERV_ORDER_ITEM (
ID                   INTEGER                        not null,
CAR_SERV_ORDER_INVENTORY_ID INTEGER,
PRODUCT_ID           INTEGER                        not null,
WAREHOUSE_ID         INTEGER,
TAX_ID               INTEGER,
CAR_SERV_COMPLEXITY_ID INTEGER,
UNIT_ID              INTEGER                        not null,
WORKER_ID            INTEGER,
CAR_DAMAGE_LEVEL_ID  INTEGER,
CAR_SERV_ORDER_ID    INTEGER                        not null,
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
WORK_HOUR            NUMERIC(6,2)                   default 0 not null,
ITEM_TYPE            VARCHAR(20),
IS_PNT               CHAR(1)                        default 'N' not null,
IS_MAT               CHAR(1)                        default 'N' not null,
IS_POL               CHAR(1)                        default 'N' not null,
NOTE                 VARCHAR(128),
constraint PK_CAR_SERV_ORDER_ITEM primary key (ID)
);

/*==============================================================*/
/* Table: CAR_SERV_ORDER_PAINT_TYPE                             */
/*==============================================================*/
create table CAR_SERV_ORDER_PAINT_TYPE (
ID                   INTEGER                        not null,
CAR_PAINT_TYPE_ID    INTEGER                        not null,
CAR_SERV_ORDER_INVENTORY_ID INTEGER,
CAR_SERV_ORDER_ID    INTEGER                        not null,
constraint PK_CAR_SERV_ORDER_PAINT_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: CAR_SERV_TYPE                                         */
/*==============================================================*/
create table CAR_SERV_TYPE (
ID                   INTEGER                        not null,
NAME                 VARCHAR(50),
constraint PK_CAR_SERV_TYPE primary key (ID)
);

alter table CAR
   add constraint FK_CAR_CAR_CARCL_CAR_CLAS foreign key (CAR_CLASS_ID)
      references CAR_CLASS (ID);

alter table CAR
   add constraint FK_CAR_CAR_CARMD_CAR_MODE foreign key (CAR_MODEL_ID)
      references CAR_MODEL (ID);

alter table CAR
   add constraint FK_CAR_CAR_CARMR_CAR_MARK foreign key (CAR_MARK_ID)
      references CAR_MARK (ID);

alter table CAR
   add constraint FK_CAR_CAR_PARTN_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table CAR_DETAIL
   add constraint FK_CAR_DETA_CAR_DTL_C_CAR_MARK foreign key (CAR_MARK_ID)
      references CAR_MARK (ID);

alter table CAR_DETAIL
   add constraint FK_CAR_DETA_CAR_DTL_C_CAR_MODE foreign key (CAR_MODEL_ID)
      references CAR_MODEL (ID);

alter table CAR_DETAIL_VARIANT
   add constraint FK_CAR_DETA_CDV_CD_CAR_DETA foreign key (CAR_DETAIL_ID)
      references CAR_DETAIL (ID);

alter table CAR_DETAIL_VARIANT
   add constraint FK_CAR_DETA_CDV_CDL_CAR_DAMA foreign key (CAR_DAMAGE_LEVEL_ID)
      references CAR_DAMAGE_LEVEL (ID);

alter table CAR_DETAIL_VARIANT_PAINT
   add constraint FK_CAR_DETA_CDVN_CDV_CAR_DETA foreign key (CAR_DETAIL_VARIANT_ID)
      references CAR_DETAIL_VARIANT (ID);

alter table CAR_DETAIL_VARIANT_PAINT
   add constraint FK_CAR_DETA_CDVN_CN_CAR_PAIN foreign key (CAR_PAINT_ID)
      references CAR_PAINT (ID);

alter table CAR_DETAIL_VARIANT_PAINT
   add constraint FK_CAR_DETA_CDVP_CPDT_CAR_PAIN foreign key (CAR_PAINT_DETAIL_TYPE_ID)
      references CAR_PAINT_DETAIL_TYPE (ID);

alter table CAR_DETAIL_VARIANT_PART
   add constraint FK_CAR_DETA_CDVP_CDV_CAR_DETA foreign key (CAR_DETAIL_VARIANT_ID)
      references CAR_DETAIL_VARIANT (ID);

alter table CAR_DETAIL_VARIANT_PART
   add constraint FK_CAR_DETA_CDVP_CP_CAR_PART foreign key (CAR_PART_ID)
      references CAR_PART (ID);

alter table CAR_DETAIL_VARIANT_SERV
   add constraint FK_CAR_DETA_CDVS_CC_CAR_CLAS foreign key (CAR_CLASS_ID)
      references CAR_CLASS (ID);

alter table CAR_DETAIL_VARIANT_SERV
   add constraint FK_CAR_DETA_CDVS_CDV_CAR_DETA foreign key (CAR_DETAIL_VARIANT_ID)
      references CAR_DETAIL_VARIANT (ID);

alter table CAR_DETAIL_VARIANT_SERV
   add constraint FK_CAR_DETA_CDVS_CS_CAR_SERV foreign key (CAR_SERV_ID)
      references CAR_SERV (ID);

alter table CAR_INSURER_CONSUMABLES_PRICE
   add constraint FK_CAR_INSU_CINSCP_CV_CAR_INSU foreign key (CONTRACT_VARIANT_ID)
      references CAR_INSURER_CONTRACT_VARIANT (ID);

alter table CAR_INSURER_CONSUMABLES_PRICE
   add constraint FK_CAR_INSU_CINSC_CL_CAR_CLAS foreign key (CAR_CLASS_ID)
      references CAR_CLASS (ID);

alter table CAR_INSURER_CONSUMABLES_PRICE
   add constraint FK_CAR_INSU_CINSC_DL_CAR_DAMA foreign key (CAR_DAMAGE_LEVEL_ID)
      references CAR_DAMAGE_LEVEL (ID);

alter table CAR_INSURER_CONSUMABLES_PRICE
   add constraint FK_CAR_INSU_CINSC_DT_CAR_PAIN foreign key (CAR_PAINT_DETAIL_TYPE_ID)
      references CAR_PAINT_DETAIL_TYPE (ID);

alter table CAR_INSURER_CONTRACT_VARIANT
   add constraint FK_CAR_INSU_CICV_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table CAR_INSURER_CONTRACT_VARIANT
   add constraint FK_CAR_INSU_INS_CVI_PARTNER foreign key (INSURER_ID)
      references PARTNER (ID);

alter table CAR_INSURER_PAINT_BOX_PRICE
   add constraint FK_CAR_INSU_CINSPBP_D_CAR_PAIN foreign key (CAR_PAINT_DETAIL_TYPE_ID)
      references CAR_PAINT_DETAIL_TYPE (ID);

alter table CAR_INSURER_PAINT_BOX_PRICE
   add constraint FK_CAR_INSU_CINSPB_CV_CAR_INSU foreign key (CONTRACT_VARIANT_ID)
      references CAR_INSURER_CONTRACT_VARIANT (ID);

alter table CAR_INSURER_PAINT_TYPE_PRICE
   add constraint FK_CAR_INSU_CINSPTP_C_CAR_INSU foreign key (CONTRACT_VARIANT_ID)
      references CAR_INSURER_CONTRACT_VARIANT (ID);

alter table CAR_INSURER_PAINT_TYPE_PRICE
   add constraint FK_CAR_INSU_CINSPT_PM_CAR_PAIN foreign key (CAR_PAINT_MARK_ID)
      references CAR_PAINT_MARK (ID);

alter table CAR_INSURER_PAINT_TYPE_PRICE
   add constraint FK_CAR_INSU_CINSP_PT_CAR_PAIN foreign key (CAR_PAINT_TYPE_ID)
      references CAR_PAINT_TYPE (ID);

alter table CAR_INSURER_PAINT_TYPE_VOLUME
   add constraint FK_CAR_INSU_CINSPTV_C_CAR_CLAS foreign key (CAR_CLASS_ID)
      references CAR_CLASS (ID);

alter table CAR_INSURER_PAINT_TYPE_VOLUME
   add constraint FK_CAR_INSU_CINSPTV_C_CAR_INSU foreign key (CONTRACT_VARIANT_ID)
      references CAR_INSURER_CONTRACT_VARIANT (ID);

alter table CAR_INSURER_PAINT_TYPE_VOLUME
   add constraint FK_CAR_INSU_CINSPTV_D_CAR_PAIN foreign key (CAR_PAINT_DETAIL_TYPE_ID)
      references CAR_PAINT_DETAIL_TYPE (ID);

alter table CAR_INSURER_PART_PRICE
   add constraint FK_CAR_INSU_CINSPP_CV_CAR_INSU foreign key (CONTRACT_VARIANT_ID)
      references CAR_INSURER_CONTRACT_VARIANT (ID);

alter table CAR_INSURER_PREPARE_HOUR
   add constraint FK_CAR_INSU_CINSPH_CV_CAR_INSU foreign key (CONTRACT_VARIANT_ID)
      references CAR_INSURER_CONTRACT_VARIANT (ID);

alter table CAR_INSURER_PREPARE_HOUR
   add constraint FK_CAR_INSU_CINSPH_DL_CAR_DAMA foreign key (CAR_DAMAGE_LEVEL_ID)
      references CAR_DAMAGE_LEVEL (ID);

alter table CAR_INSURER_PREPARE_HOUR
   add constraint FK_CAR_INSU_CINSPH_PT_CAR_PREP foreign key (CAR_PREPARE_TYPE_ID)
      references CAR_PREPARE_TYPE (ID);

alter table CAR_INSURER_SERV_PRICE
   add constraint FK_CAR_INSU_CINSSP_CA_CAR_AGE foreign key (CAR_AGE_ID)
      references CAR_AGE (ID);

alter table CAR_INSURER_SERV_PRICE
   add constraint FK_CAR_INSU_CINSSP_CV_CAR_INSU foreign key (CONTRACT_VARIANT_ID)
      references CAR_INSURER_CONTRACT_VARIANT (ID);

alter table CAR_INSURER_SERV_PRICE
   add constraint FK_CAR_INSU_CISP_CST_CAR_SERV foreign key (CAR_SERV_TYPE_ID)
      references CAR_SERV_TYPE (ID);

alter table CAR_MODEL
   add constraint FK_CAR_MODE_CARMD_MAR_CAR_MARK foreign key (CAR_MARK_ID)
      references CAR_MARK (ID);

alter table CAR_MODEL
   add constraint FK_CAR_MODE_CARMD_MNF_CAR_MANU foreign key (CAR_MANUFACTURER_ID)
      references CAR_MANUFACTURER (ID);

alter table CAR_MTRL_FIND_REPORT
   add constraint FK_CAR_MTRL_CMFR_RQ_CAR_MTRL foreign key (CAR_MTRL_FIND_REQUEST_ID)
      references CAR_MTRL_FIND_REQUEST (ID);

alter table CAR_MTRL_FIND_REPORT_ITEM
   add constraint FK_CAR_MTRL_CMFREI_P_CAR_MTRL foreign key (CAR_MTRL_FIND_REPORT_ID)
      references CAR_MTRL_FIND_REPORT (ID);

alter table CAR_MTRL_FIND_REPORT_ITEM
   add constraint FK_CAR_MTRL_CMFREI_R_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table CAR_MTRL_FIND_REPORT_ITEM
   add constraint FK_CAR_MTRL_CMFREI_U_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table CAR_MTRL_FIND_REPORT_PRICE
   add constraint FK_CAR_MTRL_CMFRPR_PI_CAR_MTRL foreign key (ITEM_ID)
      references CAR_MTRL_FIND_REPORT_ITEM (ID);

alter table CAR_MTRL_FIND_REPORT_PRICE
   add constraint FK_CAR_MTRL_CMFRSP_PR_PARTNER foreign key (SUPPLIER_ID)
      references PARTNER (ID);

alter table CAR_MTRL_FIND_REQUEST
   add constraint FK_CAR_MTRL_CARMFR_E_EMPLOYEE foreign key (EMPLOYEE_ID)
      references EMPLOYEE (ID);

alter table CAR_MTRL_FIND_REQUEST
   add constraint FK_CAR_MTRL_CARMFR_O_CAR_SERV foreign key (CAR_SERV_ORDER_ID)
      references CAR_SERV_ORDER (ID);

alter table CAR_MTRL_FIND_REQUEST_ITEM
   add constraint FK_CAR_MTRL_CMFRI_P_CAR_MTRL foreign key (CAR_MTRL_FIND_REQUEST_ID)
      references CAR_MTRL_FIND_REQUEST (ID);

alter table CAR_MTRL_FIND_REQUEST_ITEM
   add constraint FK_CAR_MTRL_CMFRI_R_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table CAR_MTRL_FIND_REQUEST_ITEM
   add constraint FK_CAR_MTRL_CMFRI_U_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table CAR_MTRL_PURCHASE_REPORT
   add constraint FK_CAR_MTRL_CMPRS_P_CAR_MTRL foreign key (CAR_MTRL_PURCHASE_REQUEST_ID)
      references CAR_MTRL_PURCHASE_REQUEST (ID);

alter table CAR_MTRL_PURCHASE_REPORT_ITEM
   add constraint FK_CAR_MTRL_CMPRSI_P_CAR_MTRL foreign key (CAR_MTRL_PURCHASE_REPORT_ID)
      references CAR_MTRL_PURCHASE_REPORT (ID);

alter table CAR_MTRL_PURCHASE_REPORT_ITEM
   add constraint FK_CAR_MTRL_CMPRTI_PR_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table CAR_MTRL_PURCHASE_REPORT_ITEM
   add constraint FK_CAR_MTRL_CMPRTI_SU_PARTNER foreign key (SUPPLIER_ID)
      references PARTNER (ID);

alter table CAR_MTRL_PURCHASE_REPORT_ITEM
   add constraint FK_CAR_MTRL_CMPRTI_U_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table CAR_MTRL_PURCHASE_REQUEST
   add constraint FK_CAR_MTRL_CMPR_P_CAR_MTRL foreign key (CAR_MTRL_FIND_REPORT_ID)
      references CAR_MTRL_FIND_REPORT (ID);

alter table CAR_MTRL_PURCHASE_REQUEST_ITEM
   add constraint FK_CAR_MTRL_CMPRI_P_CAR_MTRL foreign key (CAR_MTRL_PURCHASE_REQUEST_ID)
      references CAR_MTRL_PURCHASE_REQUEST (ID);

alter table CAR_MTRL_PURCHASE_REQUEST_ITEM
   add constraint FK_CAR_MTRL_CMPRSI_PR_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table CAR_MTRL_PURCHASE_REQUEST_ITEM
   add constraint FK_CAR_MTRL_CMPRSI_SU_PARTNER foreign key (SUPPLIER_ID)
      references PARTNER (ID);

alter table CAR_MTRL_PURCHASE_REQUEST_ITEM
   add constraint FK_CAR_MTRL_CMPRSI_U_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table CAR_PAINT
   add constraint FK_CAR_PAIN_CP_PM_CAR_PAIN foreign key (CAR_PAINT_MARK_ID)
      references CAR_PAINT_MARK (ID);

alter table CAR_PAINT
   add constraint FK_CAR_PAIN_CP_PT_CAR_PAIN foreign key (CAR_PAINT_TYPE_ID)
      references CAR_PAINT_TYPE (ID);

alter table CAR_PART
   add constraint FK_CAR_PART_CAR_PRT_M_CAR_MODE foreign key (CAR_MODEL_ID)
      references CAR_MODEL (ID);

alter table CAR_PART
   add constraint FK_CAR_PART_CAR_PRT_M_CAR_MARK foreign key (CAR_MARK_ID)
      references CAR_MARK (ID);

alter table CAR_SERV
   add constraint FK_CAR_SERV_CAR_SRV_S_CAR_SERV foreign key (CAR_SERV_TYPE_ID)
      references CAR_SERV_TYPE (ID);

alter table CAR_SERV_CONTEXT
   add constraint FK_CAR_SERV_CSCTX_PBS_CAR_SERV foreign key (PAINT_BOX_SERV_ID)
      references CAR_SERV (ID);

alter table CAR_SERV_HOUR
   add constraint FK_CAR_SERV_CAR_SERVH_CAR_SERV foreign key (CAR_SERV_COMLEXITY_ID)
      references CAR_SERV_COMPLEXITY (ID);

alter table CAR_SERV_HOUR
   add constraint FK_CAR_SERV_CAR_SRVH__CAR_CLAS foreign key (CAR_CLASS_ID)
      references CAR_CLASS (ID);

alter table CAR_SERV_HOUR
   add constraint FK_CAR_SERV_CAR_SRVH__CAR_SERV foreign key (CAR_SERV_ID)
      references CAR_SERV (ID);

alter table CAR_SERV_LINK
   add constraint FK_CAR_SERV_CAR_SRV_L_CAR_SERV foreign key (CAR_SERV_LINK_ID)
      references CAR_SERV (ID);

alter table CAR_SERV_LINK
   add constraint FK_CAR_SERV_CAR_SRV_O_CAR_SERV foreign key (CAR_SERV_ID)
      references CAR_SERV (ID);

alter table CAR_SERV_ORDER
   add constraint FK_CAR_SERV_CSO_ADD_R_CAR_SERV foreign key (ADDITIONAL_REPAIR_ID)
      references CAR_SERV_ORDER_DAMAGE (ID);

alter table CAR_SERV_ORDER
   add constraint FK_CAR_SERV_CSO_CAR_CAR foreign key (CAR_ID)
      references CAR (ID);

alter table CAR_SERV_ORDER
   add constraint FK_CAR_SERV_CSO_IR_PARTNER_ foreign key (INCOME_REPRESENTATIVE_ID)
      references PARTNER_REPRESENTATIVE (ID);

alter table CAR_SERV_ORDER
   add constraint FK_CAR_SERV_CSO_OR_PARTNER_ foreign key (OUTCOME_REPRESENTATIVE_ID)
      references PARTNER_REPRESENTATIVE (ID);

alter table CAR_SERV_ORDER
   add constraint FK_CAR_SERV_CSO_PT_PRICE_TY foreign key (PRICE_TYPE_ID)
      references PRICE_TYPE (ID);

alter table CAR_SERV_ORDER
   add constraint FK_CAR_SERV_CSO_RESP_RESPONSI foreign key (RESPONSIBLE_ID)
      references RESPONSIBLE (ID);

alter table CAR_SERV_ORDER
   add constraint FK_CAR_SERV_CSO_WRH_WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table CAR_SERV_ORDER_DAMAGE
   add constraint FK_CAR_SERV_CSOD_CCL_CAR_CLAS foreign key (CAR_CLASS_ID)
      references CAR_CLASS (ID);

alter table CAR_SERV_ORDER_DAMAGE
   add constraint FK_CAR_SERV_CSOD_CSO_CAR_SERV foreign key (CAR_SERV_ORDER_ID)
      references CAR_SERV_ORDER (ID);

alter table CAR_SERV_ORDER_DAMAGE
   add constraint FK_CAR_SERV_CSOD_PR_PARTNER foreign key (INSURER_ID)
      references PARTNER (ID);

alter table CAR_SERV_ORDER_DAMAGE
   add constraint FK_CAR_SERV_CSO_BRK_PARTNER foreign key (BROKER_ID)
      references PARTNER (ID);

alter table CAR_SERV_ORDER_DAMAGE
   add constraint FK_CAR_SERV_CSO_D_TI_CAR_SERV foreign key (TOTAL_INVENTORY_ID)
      references CAR_SERV_ORDER_INVENTORY (ID);

alter table CAR_SERV_ORDER_IMAGE
   add constraint FK_CAR_SERV_CSOIM_CSO_CAR_SERV foreign key (CAR_SERV_ORDER_ID)
      references CAR_SERV_ORDER (ID);

alter table CAR_SERV_ORDER_INVENTORY
   add constraint FK_CAR_SERV_CSOIN_CSO_CAR_SERV foreign key (CAR_SERV_ORDER_DAMAGE_ID)
      references CAR_SERV_ORDER_DAMAGE (ID);

alter table CAR_SERV_ORDER_INVENTORY
   add constraint FK_CAR_SERV_CSOI_CPT_CAR_PAIN foreign key (CAR_PAINT_TYPE_ID)
      references CAR_PAINT_TYPE (ID);

alter table CAR_SERV_ORDER_ITEM
   add constraint FK_CAR_SERV_CSOI_CDL_CAR_DAMA foreign key (CAR_DAMAGE_LEVEL_ID)
      references CAR_DAMAGE_LEVEL (ID);

alter table CAR_SERV_ORDER_ITEM
   add constraint FK_CAR_SERV_CSOI_CSO_CAR_SERV foreign key (CAR_SERV_ORDER_ID)
      references CAR_SERV_ORDER (ID);

alter table CAR_SERV_ORDER_ITEM
   add constraint FK_CAR_SERV_CSOI_CX_CAR_SERV foreign key (CAR_SERV_COMPLEXITY_ID)
      references CAR_SERV_COMPLEXITY (ID);

alter table CAR_SERV_ORDER_ITEM
   add constraint FK_CAR_SERV_CSOI_E_EMPLOYEE foreign key (WORKER_ID)
      references EMPLOYEE (ID);

alter table CAR_SERV_ORDER_ITEM
   add constraint FK_CAR_SERV_CSOI_INV_CAR_SERV foreign key (CAR_SERV_ORDER_INVENTORY_ID)
      references CAR_SERV_ORDER_INVENTORY (ID);

alter table CAR_SERV_ORDER_ITEM
   add constraint FK_CAR_SERV_CSOI_PRD_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table CAR_SERV_ORDER_ITEM
   add constraint FK_CAR_SERV_CSOI_TAX_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table CAR_SERV_ORDER_ITEM
   add constraint FK_CAR_SERV_CSOI_UNIT_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table CAR_SERV_ORDER_ITEM
   add constraint FK_CAR_SERV_CSOI_WRH_WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table CAR_SERV_ORDER_PAINT_TYPE
   add constraint FK_CAR_SERV_CSOPT_CPT_CAR_PAIN foreign key (CAR_PAINT_TYPE_ID)
      references CAR_PAINT_TYPE (ID);

alter table CAR_SERV_ORDER_PAINT_TYPE
   add constraint FK_CAR_SERV_CSOPT_CSO_CAR_SERV foreign key (CAR_SERV_ORDER_ID)
      references CAR_SERV_ORDER (ID);

alter table CAR_SERV_ORDER_PAINT_TYPE
   add constraint FK_CAR_SERV_CSOPT_OI_CAR_SERV foreign key (CAR_SERV_ORDER_INVENTORY_ID)
      references CAR_SERV_ORDER_INVENTORY (ID);

