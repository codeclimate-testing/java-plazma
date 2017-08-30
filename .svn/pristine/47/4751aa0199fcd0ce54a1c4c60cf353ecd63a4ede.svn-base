/*==============================================================*/
/* Database name:  Plazma                                       */
/* Created on:     18.06.2011 11:37:31                          */
/*==============================================================*/

/*==============================================================*/
/* Table: ACADEMIC_DEGREE                                       */
/*==============================================================*/
create table ACADEMIC_DEGREE (
ID                   INTEGER                        not null,
NAME                 VARCHAR(50),
constraint PK_ACADEMIC_DEGREE primary key (ID)
);

/*==============================================================*/
/* Table: ACTIVITY_TYPE                                         */
/*==============================================================*/
create table ACTIVITY_TYPE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(20),
NAME                 VARCHAR(50),
constraint PK_ACTIVITY_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: ADDRESS                                               */
/*==============================================================*/
create table ADDRESS (
ID                   INTEGER                        not null,
ADDRESS_TYPE_ID      INTEGER                        not null,
CONTACTABLE_ID       INTEGER                        not null,
APARTMENT_TYPE_ID    INTEGER,
CITY_ID              INTEGER,
LOCALITY_ID          INTEGER,
STREET_TYPE_ID       INTEGER,
ADDRESS_STRING       VARCHAR(100),
LOCALITY_ADDRESS_STRING VARCHAR(100),
FULL_ADDRESS_STRING  VARCHAR(100),
ZIP_CODE             VARCHAR(10),
STREET               VARCHAR(50),
HOUSE_NUM            VARCHAR(12),
CASE_NUM             VARCHAR(6),
APART_NUM            VARCHAR(6),
NOTE                 VARCHAR(255),
constraint PK_ADDRESS primary key (ID)
);

/*==============================================================*/
/* Table: ADDRESS_TYPE                                          */
/*==============================================================*/
create table ADDRESS_TYPE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(20),
NAME                 VARCHAR(30),
constraint PK_ADDRESS_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: APARTMENT_TYPE                                        */
/*==============================================================*/
create table APARTMENT_TYPE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(10),
FULL_NAME            VARCHAR(30),
constraint PK_APARTMENT_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: ASSET                                                 */
/*==============================================================*/
create table ASSET (
ID                   INTEGER                        not null,
ASSET_CLASS_ID       INTEGER,
constraint PK_ASSET primary key (ID)
);

/*==============================================================*/
/* Table: ASSET_AMORTIZATION                                    */
/*==============================================================*/
create table ASSET_AMORTIZATION (
ID                   INTEGER                        not null,
constraint PK_ASSET_AMORTIZATION primary key (ID)
);

/*==============================================================*/
/* Table: ASSET_AMORTIZATION_ITEM                               */
/*==============================================================*/
create table ASSET_AMORTIZATION_ITEM (
ID                   INTEGER                        not null,
constraint PK_ASSET_AMORTIZATION_ITEM primary key (ID)
);

/*==============================================================*/
/* Table: ASSET_CLASS                                           */
/*==============================================================*/
create table ASSET_CLASS (
ID                   INTEGER                        not null,
constraint PK_ASSET_CLASS primary key (ID)
);

/*==============================================================*/
/* Table: ASSET_CLASS_GROUP                                     */
/*==============================================================*/
create table ASSET_CLASS_GROUP (
ID                   INTEGER                        not null,
constraint PK_ASSET_CLASS_GROUP primary key (ID)
);

/*==============================================================*/
/* Table: ASSET_INCOME                                          */
/*==============================================================*/
create table ASSET_INCOME (
ID                   INTEGER                        not null,
constraint PK_ASSET_INCOME primary key (ID)
);

/*==============================================================*/
/* Table: ASSET_INCOME_ITEM                                     */
/*==============================================================*/
create table ASSET_INCOME_ITEM (
ID                   INTEGER                        not null,
constraint PK_ASSET_INCOME_ITEM primary key (ID)
);

/*==============================================================*/
/* Table: ASSET_MOVE                                            */
/*==============================================================*/
create table ASSET_MOVE (
ID                   INTEGER                        not null,
constraint PK_ASSET_MOVE primary key (ID)
);

/*==============================================================*/
/* Table: ASSET_MOVE_ITEM                                       */
/*==============================================================*/
create table ASSET_MOVE_ITEM (
ID                   INTEGER                        not null,
constraint PK_ASSET_MOVE_ITEM primary key (ID)
);

/*==============================================================*/
/* Table: ASSET_OUTCOME                                         */
/*==============================================================*/
create table ASSET_OUTCOME (
ID                   INTEGER                        not null,
constraint PK_ASSET_OUTCOME primary key (ID)
);

/*==============================================================*/
/* Table: ASSET_OUTCOME_ITEM                                    */
/*==============================================================*/
create table ASSET_OUTCOME_ITEM (
ID                   INTEGER                        not null,
constraint PK_ASSET_OUTCOME_ITEM primary key (ID)
);

/*==============================================================*/
/* Table: ASSET_REST                                            */
/*==============================================================*/
create table ASSET_REST (
ID                   INTEGER                        not null,
constraint PK_ASSET_REST primary key (ID)
);

/*==============================================================*/
/* Table: ASSET_REST_ITEM                                       */
/*==============================================================*/
create table ASSET_REST_ITEM (
ID                   INTEGER                        not null,
constraint PK_ASSET_REST_ITEM primary key (ID)
);

/*==============================================================*/
/* Table: ASSET_WRITEOFF                                        */
/*==============================================================*/
create table ASSET_WRITEOFF (
ID                   INTEGER                        not null,
constraint PK_ASSET_WRITEOFF primary key (ID)
);

/*==============================================================*/
/* Table: ASSET_WRITEOFF_ITEM                                   */
/*==============================================================*/
create table ASSET_WRITEOFF_ITEM (
ID                   INTEGER                        not null,
constraint PK_ASSET_WRITEOFF_ITEM primary key (ID)
);

/*==============================================================*/
/* Table: BANK                                                  */
/*==============================================================*/
create table BANK (
ID                   INTEGER                        not null,
BIC                  VARCHAR(10),
CORRESPONDENT_ACCOUNT VARCHAR(20),
STOPPED_PERCENT      NUMERIC(5,2)                   default 0 not null,
constraint PK_BANK primary key (ID)
);

/*==============================================================*/
/* Table: BANK_ACCOUNT                                          */
/*==============================================================*/
create table BANK_ACCOUNT (
ID                   INTEGER                        not null,
BANK_ID              INTEGER                        not null,
PARTNER_ID           INTEGER                        not null,
NAME                 VARCHAR(30),
ACCOUNT_NO           VARCHAR(20),
constraint PK_BANK_ACCOUNT primary key (ID)
);

/*==============================================================*/
/* Table: BANK_CONTEXT                                          */
/*==============================================================*/
create table BANK_CONTEXT (
ID                   INTEGER                        not null,
INCOME_PARTNER_ID    INTEGER,
PARTNER_ID           INTEGER,
TAXPRINT_TYPE_ID     INTEGER,
PAYMENT_TYPE_ID      INTEGER,
OUTCOME_PARTNER_ID   INTEGER,
constraint PK_BANK_CONTEXT primary key (ID)
);

/*==============================================================*/
/* Table: BUSINESSABLE                                          */
/*==============================================================*/
create table BUSINESSABLE (
ID                   INTEGER                        not null,
ENTITY_ID            CHAR(30)                       not null,
ORGANIZATION_ID      INTEGER,
OWNER_ID             INTEGER                        not null,
NAME                 VARCHAR(100),
constraint PK_BUSINESSABLE primary key (ID)
);

/*==============================================================*/
/* Table: BUSINESSABLE_ENTITY                                   */
/*==============================================================*/
create table BUSINESSABLE_ENTITY (
ID                   INTEGER                        not null,
ENTITY_ID            CHAR(30)                       not null,
constraint PK_BUSINESSABLE_ENTITY primary key (ID)
);

/*==============================================================*/
/* Table: BUSINESSABLE_REGISTER                                 */
/*==============================================================*/
create table BUSINESSABLE_REGISTER (
ID                   INTEGER                        not null,
BUSINESSABLE_ID      INTEGER,
ORGANIZATION_ID      INTEGER                        not null,
PERIOD_ID            INTEGER                        not null,
REGISTER_DATE        DATE,
QUANTITY             NUMERIC(9,4)                   not null,
DEBIT_AMOUNT         NUMERIC(15,2)                  not null,
CREDIT_AMOUNT        NUMERIC(15,2)                  not null,
constraint PK_BUSINESSABLE_REGISTER primary key (ID)
);

/*==============================================================*/
/* Table: CASH_DOCUMENT_LINK                                    */
/*==============================================================*/
create table CASH_DOCUMENT_LINK (
ID                   INTEGER                        not null,
REASON_DOCUMENT_ID   INTEGER                        not null,
CASH_DOCUMENT_ID     INTEGER                        not null,
constraint PK_CASH_DOCUMENT_LINK primary key (ID)
);

/*==============================================================*/
/* Table: CASH_INCOME                                           */
/*==============================================================*/
create table CASH_INCOME (
ID                   INTEGER                        not null,
CONTRACTOR_ID        INTEGER                        not null,
PAYMENT_DATE         DATE,
PAYMENT_MISSING      VARCHAR(128),
constraint PK_CASH_INCOME primary key (ID)
);

/*==============================================================*/
/* Table: CASH_OUTCOME                                          */
/*==============================================================*/
create table CASH_OUTCOME (
ID                   INTEGER                        not null,
CONTRACTOR_ID        INTEGER                        not null,
PAYMENT_DATE         DATE,
PAYMENT_MISSING      VARCHAR(128),
constraint PK_CASH_OUTCOME primary key (ID)
);

/*==============================================================*/
/* Table: CITY                                                  */
/*==============================================================*/
create table CITY (
ID                   INTEGER                        not null,
PHONE_CODE           VARCHAR(6),
constraint PK_CITY primary key (ID)
);

/*==============================================================*/
/* Table: CONTACT                                               */
/*==============================================================*/
create table CONTACT (
ID                   INTEGER                        not null,
CONTACT_TYPE_ID      INTEGER                        not null,
ORGANIZATION_ID      INTEGER                        not null,
POSITION_ID          INTEGER,
RESPONSIBLE_ID       INTEGER,
PARTNER_ID           INTEGER,
DEPARTMENT_ID        INTEGER,
CODE                 VARCHAR(20),
NAME                 VARCHAR(100)                   not null,
NAME_EN              VARCHAR(100),
TITLE_NAME           VARCHAR(30),
FIRST_NAME           VARCHAR(50),
MIDDLE_NAME          VARCHAR(50),
LAST_NAME            VARCHAR(50),
SUFFIX_NAME          VARCHAR(10),
GENDER               INTEGER                        default 1 not null,
BIRTH_DATE           DATE,
FULL_POSITION_NAME   VARCHAR(100),
FULL_POSITION_NAME_EN VARCHAR(100),
WORK_ON_BASIS        VARCHAR(100),
WORK_ON_BASIS_EN     VARCHAR(100),
IMAGE_FILE_NAME      VARCHAR(50),
NOTE                 VARCHAR(255),
IS_EMPLOYEE          CHAR(1)                        default 'N' not null,
IS_EMPLOYEE_LINK     CHAR(1)                        default 'N' not null,
IS_HARD_LINK         CHAR(1)                        default 'N' not null,
constraint PK_CONTACT primary key (ID)
);

/*==============================================================*/
/* Table: CONTACTABLE                                           */
/*==============================================================*/
create table CONTACTABLE (
ID                   INTEGER                        not null,
ENTITY_ID            CHAR(30)                       not null,
EMAIL_ID             INTEGER,
WEB_ID               INTEGER,
ADDRESS_ID           INTEGER,
PHONE_ID             INTEGER,
OWNER_ID             INTEGER                        not null,
ICQ                  VARCHAR(15),
SKYPE                VARCHAR(32),
MSN                  VARCHAR(64),
YAHOO                VARCHAR(32),
GTALK                VARCHAR(30),
constraint PK_CONTACTABLE primary key (ID)
);

/*==============================================================*/
/* Table: CONTACTABLE_ENTITY                                    */
/*==============================================================*/
create table CONTACTABLE_ENTITY (
ID                   INTEGER                        not null,
ENTITY_ID            CHAR(30)                       not null,
constraint PK_CONTACTABLE_ENTITY primary key (ID)
);

/*==============================================================*/
/* Table: CONTACT_CONTEXT                                       */
/*==============================================================*/
create table CONTACT_CONTEXT (
ID                   INTEGER                        not null,
CONTACT_TYPE_ID      INTEGER,
RESPONSIBLE_ID       INTEGER,
PHONE_TYPE_ID        INTEGER,
ADDRESS_TYPE_ID      INTEGER,
constraint PK_CONTACT_CONTEXT primary key (ID)
);

/*==============================================================*/
/* Table: CONTACT_TYPE                                          */
/*==============================================================*/
create table CONTACT_TYPE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(20),
NAME                 VARCHAR(50)                    not null,
NOTE                 VARCHAR(255),
constraint PK_CONTACT_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: CONTRACT                                              */
/*==============================================================*/
create table CONTRACT (
ID                   INTEGER                        not null,
ORGANIZATION_CONTACT_ID INTEGER,
PARTNER_BANK_ACCOUNT_ID INTEGER,
PARTNER_CONTACT_ID   INTEGER,
ORGANIZATION_BANK_ACCOUNT_ID INTEGER,
NAME                 VARCHAR(100),
FILE_NAME            VARCHAR(255),
END_DATE             DATE,
ORGANIZATION_PERSON  VARCHAR(100),
ORGANIZATION_PERSON_EN VARCHAR(100),
ORGANIZATION_PERSON_DETAIL VARCHAR(100),
ORGANIZATION_PERSON_DETAIL_EN VARCHAR(100),
ORGANIZATION_PERSON_ON_BAS VARCHAR(100),
ORGANIZATION_PERSON_ON_BAS_EN VARCHAR(100),
ORGANIZATION_ADDRESS VARCHAR(100),
ORGANIZATION_ADDRESS_EN VARCHAR(100),
ORGANIZATION_PHONE   VARCHAR(20),
ORGANIZATION_FAX     VARCHAR(20),
ORGANIZATION_BANK_NAME VARCHAR(100),
ORGANIZATION_BANK_NAME_EN VARCHAR(100),
PARTNER_PERSON       VARCHAR(100),
PARTNER_PERSON_EN    VARCHAR(100),
PARTNER_PERSON_DETAIL VARCHAR(100),
PARTNER_PERSON_DETAIL_EN VARCHAR(100),
PARTNER_PERSON_ON_BAS VARCHAR(100),
PARTNER_PERSON_ON_BAS_EN VARCHAR(100),
PARTNER_ADDRESS      VARCHAR(100),
PARTNER_ADDRESS_EN   VARCHAR(100),
PARTNER_PHONE        VARCHAR(20),
PARTNER_FAX          VARCHAR(20),
PARTNER_BANK_NAME    VARCHAR(100),
PARTNER_BANK_NAME_EN VARCHAR(100),
PREPAY_AMOUNT        NUMERIC(15,2)                  default 0 not null,
CURRENCY_PREPAY_AMOUNT NUMERIC(15,2)                  default 0 not null,
constraint PK_CONTRACT primary key (ID)
);

/*==============================================================*/
/* Table: CONTRACTOR                                            */
/*==============================================================*/
create table CONTRACTOR (
ID                   INTEGER                        not null,
constraint PK_CONTRACTOR primary key (ID)
);

/*==============================================================*/
/* Table: CONTRACTOR_MOVE                                       */
/*==============================================================*/
create table CONTRACTOR_MOVE (
ID                   INTEGER                        not null,
CONTRACTOR_ID        INTEGER                        not null,
OWNER_ID             INTEGER                        not null,
AMOUNT               NUMERIC(15,2),
AMOUNT_WITH_TAX      NUMERIC(15,2),
TAX_AMOUNT           NUMERIC(15,2),
constraint PK_CONTRACTOR_MOVE primary key (ID)
);

/*==============================================================*/
/* Table: COUNTRY                                               */
/*==============================================================*/
create table COUNTRY (
ID                   INTEGER                        not null,
CODE                 CHAR(2),
CODE3                CHAR(3),
NUMERIC_CODE         CHAR(3),
NAME                 VARCHAR(50)                    not null,
constraint PK_COUNTRY primary key (ID)
);

/*==============================================================*/
/* Table: CURRENCY                                              */
/*==============================================================*/
create table CURRENCY (
ID                   INTEGER                        not null,
CODE                 CHAR(3)                        not null,
NUMERIC_CODE         CHAR(3),
NAME                 VARCHAR(10)                    not null,
FULL_NAME            VARCHAR(20),
constraint PK_CURRENCY primary key (ID)
);

/*==============================================================*/
/* Table: CURRENCY_RATE                                         */
/*==============================================================*/
create table CURRENCY_RATE (
ID                   INTEGER                        not null,
BASE_CURRENCY_ID     INTEGER                        not null,
CURRENCY_ID          INTEGER                        not null,
CURRENCY_RATE        NUMERIC(10,4)                  not null,
CURRENCY_RATE_DATE   DATE                           not null,
constraint PK_CURRENCY_RATE primary key (ID)
);

/*==============================================================*/
/* Table: DEPARTMENT                                            */
/*==============================================================*/
create table DEPARTMENT (
ID                   INTEGER                        not null,
ORGANIZATION_ID      INTEGER                        not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(50)                    not null,
PARENT_ID            INTEGER,
constraint PK_DEPARTMENT primary key (ID)
);

/*==============================================================*/
/* Table: DISCHARGE_TYPE                                        */
/*==============================================================*/
create table DISCHARGE_TYPE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(100),
constraint PK_DISCHARGE_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: DISTRICT                                              */
/*==============================================================*/
create table DISTRICT (
ID                   INTEGER                        not null,
REGION_ID            INTEGER                        not null,
NAME                 VARCHAR(50)                    not null,
constraint PK_DISTRICT primary key (ID)
);

/*==============================================================*/
/* Table: DOCUMENT                                              */
/*==============================================================*/
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
CREATE_TIMESTAMP     DATETIME,
CREATE_USER_ID       INTEGER,
UPDATE_TIMESTAMP     DATETIME,
UPDATE_USER_ID       INTEGER,
DOCUMENT_NO          VARCHAR(20),
DOCUMENT_DATE        DATE,
REASON               VARCHAR(64),
NOTE                 VARCHAR(255),
IS_COMPLETE          CHAR(1)                        default 'N' not null,
constraint PK_DOCUMENT primary key (ID)
);

/*==============================================================*/
/* Table: DOCUMENT_FILE                                         */
/*==============================================================*/
create table DOCUMENT_FILE (
ID                   INTEGER                        not null,
DOCUMENT_ID          INTEGER                        not null,
FILE_TYPE_ID         INTEGER,
FILE_STORAGE_ID      INTEGER,
DOCUMENT_TYPE_ID     INTEGER                        not null,
OWNER_ID             INTEGER                        not null,
FILE_PATH            VARCHAR(255),
FILE_NAME            VARCHAR(50),
constraint PK_DOCUMENT_FILE primary key (ID)
);

/*==============================================================*/
/* Table: DOCUMENT_IMAGE                                        */
/*==============================================================*/
create table DOCUMENT_IMAGE (
ID                   INTEGER                        not null,
DOCUMENT_TYPE_ID     INTEGER                        not null,
FILE_TYPE_ID         INTEGER,
DOCUMENT_ID          INTEGER                        not null,
IMAGE_STORAGE_ID     INTEGER,
OWNER_ID             INTEGER                        not null,
FILE_PATH            VARCHAR(255),
FILE_NAME            VARCHAR(50),
constraint PK_DOCUMENT_IMAGE primary key (ID)
);

/*==============================================================*/
/* Table: DOCUMENT_RELATION                                     */
/*==============================================================*/
create table DOCUMENT_RELATION (
ID                   INTEGER                        not null,
CHILD_TYPE_ID        INTEGER                        not null,
PARENT_TYPE_ID       INTEGER                        not null,
CREATOR_TYPE         VARCHAR(50),
CREATOR_CLASS        VARCHAR(128),
constraint PK_DOCUMENT_RELATION primary key (ID)
);

/*==============================================================*/
/* Table: DOCUMENT_STATUS                                       */
/*==============================================================*/
create table DOCUMENT_STATUS (
ID                   INTEGER                        not null,
DOCUMENT_TYPE_ID     INTEGER                        not null,
CODE                 VARCHAR(20),
NAME                 VARCHAR(50)                    not null,
DESCRIPTION          VARCHAR(255),
IS_FINISH            CHAR(1)                        default 'N' not null,
IS_START             CHAR(1)                        default 'N' not null,
COLOR                CHAR(6),
IS_SYSTEM            CHAR(1)                        default 'N' not null,
constraint PK_DOCUMENT_STATUS primary key (ID)
);

/*==============================================================*/
/* Table: DOCUMENT_TYPE                                         */
/*==============================================================*/
create table DOCUMENT_TYPE (
ID                   INTEGER                        not null,
ENTITY_ID            CHAR(30)                       not null,
PARENT_ID            INTEGER,
DOCUMENT_SECTION     VARCHAR(20),
DOCUMENT_CATEGORY    VARCHAR(20),
DESCRIPTION          VARCHAR(255),
DOCUMENT_NO_PREFIX   VARCHAR(10),
DOCUMENT_NO_SUFFIX   VARCHAR(10),
LAST_DOCUMENT_NUMBER INTEGER,
IS_USE_NUMERATOR     CHAR(1)                        default 'N' not null,
IS_UNIQUE_DOCUMENT_NO CHAR(1)                        default 'N' not null,
NUMERATOR_CLASS      VARCHAR(128),
IS_DOCUMENT_NO_READ_ONLY CHAR(1)                        default 'N' not null,
IS_DOCUMENT_DATE_READ_ONLY CHAR(1)                        default 'N' not null,
constraint PK_DOCUMENT_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: EDUCATION_FORM                                        */
/*==============================================================*/
create table EDUCATION_FORM (
ID                   INTEGER                        not null,
NAME                 VARCHAR(50),
constraint PK_EDUCATION_FORM primary key (ID)
);

/*==============================================================*/
/* Table: EDUCATION_INSTITUTE                                   */
/*==============================================================*/
create table EDUCATION_INSTITUTE (
ID                   INTEGER                        not null,
NAME                 VARCHAR(50),
FULL_NAME            VARCHAR(50),
ADDRESS              VARCHAR(50),
constraint PK_EDUCATION_INSTITUTE primary key (ID)
);

/*==============================================================*/
/* Table: EDUCATION_TYPE                                        */
/*==============================================================*/
create table EDUCATION_TYPE (
ID                   INTEGER                        not null,
NAME                 VARCHAR(50),
constraint PK_EDUCATION_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: EMAIL                                                 */
/*==============================================================*/
create table EMAIL (
ID                   INTEGER                        not null,
CONTACTABLE_ID       INTEGER                        not null,
EMAIL_ADDRESS        VARCHAR(255),
NOTE                 VARCHAR(255),
constraint PK_EMAIL primary key (ID)
);

/*==============================================================*/
/* Table: EMPLOYEE                                              */
/*==============================================================*/
create table EMPLOYEE (
ID                   INTEGER                        not null,
ORGANIZATION_ID      INTEGER                        not null,
LEDGER_ACCOUNT_ID    INTEGER,
EMPLOYEE_RANK_ID     INTEGER,
POSITION_ID          INTEGER,
PERSON_ID            INTEGER                        not null,
EMPLOYEE_CATEGORY_ID INTEGER,
DEPARTMENT_ID        INTEGER,
PAYROLL_FORM_ID      INTEGER,
CODE                 VARCHAR(10),
IS_TAX               CHAR(1)                        default 'N' not null,
START_DATE           DATE,
END_DATE             DATE,
EMPLOYEE_ACCOUNT     VARCHAR(10),
TAX_PRIVILEGE        INTEGER                        default 0 not null,
SALARY               NUMERIC(15,2)                  default 0 not null,
TARIFF               NUMERIC(15,2)                  default 0 not null,
ADVANCE              NUMERIC(15,2)                  default 0 not null,
PREMIUM_PERCENT      NUMERIC(6,2)                   default 0 not null,
SICK_PERCENT         NUMERIC(6,2)                   default 0 not null,
TOTAL_SENIORITY_YEAR INTEGER                        default 0 not null,
TOTAL_SENIORITY_MONTH INTEGER                        default 0 not null,
TOTAL_SENIORITY_DAY  INTEGER                        default 0 not null,
UNBROKEN_SENIORITY_YEAR INTEGER                        default 0 not null,
UNBROKEN_SENIORITY_MONTH INTEGER                        default 0 not null,
UNBROKEN_SENIORITY_DAY INTEGER                        default 0 not null,
NOTE                 VARCHAR(255),
constraint PK_EMPLOYEE primary key (ID)
);

/*==============================================================*/
/* Table: EMPLOYEE_CATEGORY                                     */
/*==============================================================*/
create table EMPLOYEE_CATEGORY (
ID                   INTEGER                        not null,
NAME                 VARCHAR(50),
constraint PK_EMPLOYEE_CATEGORY primary key (ID)
);

/*==============================================================*/
/* Table: EMPLOYEE_DISCHARGE                                    */
/*==============================================================*/
create table EMPLOYEE_DISCHARGE (
ID                   INTEGER                        not null,
EMPLOYEE_ID          INTEGER                        not null,
DISCHARGE_TYPE_ID    INTEGER                        not null,
DISCHARGE_DATE       DATE                           not null,
COMPENSATION_DAY     INTEGER                        not null,
OUTPUT_DAY           INTEGER                        not null,
PENSION_AMOUNT       NUMERIC(15,2)                  not null,
constraint PK_EMPLOYEE_DISCHARGE primary key (ID)
);

/*==============================================================*/
/* Table: EMPLOYEE_MOVE                                         */
/*==============================================================*/
create table EMPLOYEE_MOVE (
ID                   INTEGER                        not null,
OWNER_ID             INTEGER                        not null,
EMPLOYEE_ID          INTEGER                        not null,
AMOUNT               NUMERIC(15,2),
AMOUNT_WITH_TAX      NUMERIC(15,2),
TAX_AMOUNT           NUMERIC(15,2),
constraint PK_EMPLOYEE_MOVE primary key (ID)
);

/*==============================================================*/
/* Table: EMPLOYEE_PAYROLL                                      */
/*==============================================================*/
create table EMPLOYEE_PAYROLL (
ID                   INTEGER                        not null,
ORGANIZATION_ID      INTEGER                        not null,
PERIOD_ID            INTEGER                        not null,
PAYROLL_ID           INTEGER                        not null,
EMPLOYEE_ID          INTEGER                        not null,
CREATE_TIMESTAMP     DATETIME,
CREATE_USER_ID       INTEGER,
UPDATE_TIMESTAMP     DATETIME,
UPDATE_USER_ID       INTEGER,
PAYROLL_DATE         DATE,
PAYROLL_DAY          INTEGER                        not null,
PAYROLL_HOUR         NUMERIC(9,2)                   not null,
PAYROLL_PERCENT      NUMERIC(6,2)                   not null,
AMOUNT               NUMERIC(15,2)                  not null,
OWNER_TYPE           VARCHAR(30),
OWNER_ID             INTEGER,
AMOUNT_INC           NUMERIC(15,2)                  not null,
AMOUNT_DEC           NUMERIC(15,2)                  not null,
OVERRIDE_MODE        INTEGER                        not null,
IS_BLOCK_CALCULATE   CHAR(1)                        default 'N' not null,
IS_BLOCK_WORK        CHAR(1)                        default 'N' not null,
constraint PK_EMPLOYEE_PAYROLL primary key (ID)
);

/*==============================================================*/
/* Table: EMPLOYEE_RANK                                         */
/*==============================================================*/
create table EMPLOYEE_RANK (
ID                   INTEGER                        not null,
NAME                 VARCHAR(50),
TARIFF               NUMERIC(15,2)                  not null,
constraint PK_EMPLOYEE_RANK primary key (ID)
);

/*==============================================================*/
/* Table: EMPLOYEE_RECEPTION                                    */
/*==============================================================*/
create table EMPLOYEE_RECEPTION (
ID                   INTEGER                        not null,
DEPARTMENT_ID        INTEGER,
PAYROLL_FORM_ID      INTEGER,
EMPLOYEE_CATEGORY_ID INTEGER,
PERSON_ID            INTEGER                        not null,
EMPLOYEE_RANK_ID     INTEGER,
EMPLOYEE_CODE        VARCHAR(10),
RECEPTION_DATE       DATE                           not null,
SALARY               NUMERIC(15,2)                  not null,
TARIFF               NUMERIC(15,2)                  not null,
PREMIUM_PERCENT      NUMERIC(6,2)                   not null,
SICK_PERCENT         NUMERIC(6,2)                   not null,
constraint PK_EMPLOYEE_RECEPTION primary key (ID)
);

/*==============================================================*/
/* Table: EMPLOYEE_SICKLIST                                     */
/*==============================================================*/
create table EMPLOYEE_SICKLIST (
ID                   INTEGER                        not null,
EMPLOYEE_ID          INTEGER                        not null,
SICKLIST_AVERANGE_TYPE_ID INTEGER                        not null,
SICKLIST_TYPE_ID     INTEGER,
SICK_TYPE_ID         INTEGER                        not null,
START_DATE           DATE,
END_DATE             DATE,
SICKLIST_PERCENT     NUMERIC(6,2)                   not null,
AVERANGE_AMOUNT      NUMERIC(15,2)                  not null,
SERIES               VARCHAR(10),
QUARTER_PREMIUM      NUMERIC(15,2)                  not null,
YEAR_PREMIUM         NUMERIC(15,2)                  not null,
SINGLE_PREMIUM       NUMERIC(15,2)                  not null,
constraint PK_EMPLOYEE_SICKLIST primary key (ID)
);

/*==============================================================*/
/* Table: EMPLOYEE_SICKLIST_AVERANGE                            */
/*==============================================================*/
create table EMPLOYEE_SICKLIST_AVERANGE (
ID                   INTEGER                        not null,
OWNER_ID             INTEGER                        not null,
SICKLIST_MONTH       INTEGER                        not null,
WORK_DAY             INTEGER                        not null,
AMOUNT               NUMERIC(15,2)                  not null,
constraint PK_EMPLOYEE_SICKLIST_AVERANGE primary key (ID)
);

/*==============================================================*/
/* Table: EMPLOYEE_TOTAL                                        */
/*==============================================================*/
create table EMPLOYEE_TOTAL (
ID                   INTEGER                        not null,
EMPLOYEE_ID          INTEGER                        not null,
PERIOD_ID            INTEGER                        not null,
WORK_DAY             INTEGER                        default 0 not null,
WORK_HOUR            NUMERIC(9,2)                   default 0 not null,
TOTAL_DAY            INTEGER                        default 0 not null,
TOTAL_HOUR           NUMERIC(9,2)                   default 0 not null,
START_BALANCE        NUMERIC(15,2)                  default 0 not null,
END_BALANCE          NUMERIC(15,2)                  default 0 not null,
INCREMENT_AMOUNT     NUMERIC(15,2)                  default 0 not null,
DECREMENT_AMOUNT     NUMERIC(15,2)                  default 0 not null,
PAYROLL_AMOUNT       NUMERIC(15,2)                  default 0 not null,
ACU_PENSION          NUMERIC(15,2)                  default 0 not null,
ACU_TAX              NUMERIC(15,2)                  default 0 not null,
ACU_VACATION         NUMERIC(15,2)                  default 0 not null,
ACU_SICK             NUMERIC(15,2)                  default 0 not null,
ACU_FUND_SALARY      NUMERIC(15,2)                  default 0 not null,
ACU_FUND_HELP        NUMERIC(15,2)                  default 0 not null,
ACU_FUND_INSURANCE   NUMERIC(15,2)                  default 0 not null,
ACU_FUND_WORK        NUMERIC(15,2)                  default 0 not null,
ACU_SALARY13         NUMERIC(15,2)                  default 0 not null,
ACU_SALARY12         NUMERIC(15,2)                  default 0 not null,
ACU_ADD_PAY          NUMERIC(15,2)                  default 0 not null,
OVERTIME_DAY         NUMERIC(15,2)                  default 0 not null,
OVERTIME_HOUR        NUMERIC(15,2)                  default 0 not null,
NIGHT_DAY            NUMERIC(15,2)                  default 0 not null,
NIGHT_HOUR           NUMERIC(15,2)                  default 0 not null,
HOLIDAY_DAY          NUMERIC(15,2)                  default 0 not null,
HOLIDAY_HOUR         NUMERIC(15,2)                  default 0 not null,
PREV_VACATION_AMOUNT NUMERIC(15,2)                  default 0 not null,
PREV_SICK_AMOUNT     NUMERIC(15,2)                  default 0 not null,
constraint PK_EMPLOYEE_TOTAL primary key (ID)
);

/*==============================================================*/
/* Table: EMPLOYEE_VACATION                                     */
/*==============================================================*/
create table EMPLOYEE_VACATION (
ID                   INTEGER                        not null,
EMPLOYEE_ID          INTEGER                        not null,
VACATION_CALCULATE_ID INTEGER                        not null,
VACATION_AVERANGE_TYPE_ID INTEGER                        not null,
ADD_VACATION_CALCULATE_ID INTEGER,
VACATION_TYPE_ID     INTEGER                        not null,
START_DATE           DATE,
END_DATE             DATE,
VACATION_DAY         INTEGER                        not null,
ADD_DAY              INTEGER                        not null,
WORK_START_DATE      DATE,
WORK_END_DATE        DATE,
AVERANGE_AMOUNT      NUMERIC(15,2)                  not null,
QUARTER_PREMIUM      NUMERIC(15,2)                  not null,
YEAR_PREMIUM         NUMERIC(15,2)                  not null,
SINGLE_PREMIUM       NUMERIC(15,2)                  not null,
constraint PK_EMPLOYEE_VACATION primary key (ID)
);

/*==============================================================*/
/* Table: EMPLOYEE_VACATION_AVERANGE                            */
/*==============================================================*/
create table EMPLOYEE_VACATION_AVERANGE (
ID                   INTEGER                        not null,
OWNER_ID             INTEGER                        not null,
VACATION_MONTH       INTEGER                        not null,
WORK_DAY             INTEGER                        not null,
VACATION_DAY         INTEGER                        not null,
ADD_VACATION_DAY     INTEGER                        not null,
AMOUNT               NUMERIC(15,2)                  not null,
constraint PK_EMPLOYEE_VACATION_AVERANGE primary key (ID)
);

/*==============================================================*/
/* Table: ENTERPRISE_CONTEXT                                    */
/*==============================================================*/
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

/*==============================================================*/
/* Table: ENTRY_ITEM                                            */
/*==============================================================*/
create table ENTRY_ITEM (
ID                   INTEGER                        not null,
DEBIT_LEDGER_ACCOUNT_ID INTEGER                        not null,
OWNER_ID             INTEGER                        not null,
CREDIT_LEDGER_ACCOUNT_ID INTEGER                        not null,
DEBIT_OBJECT_ID      INTEGER,
CREDIT_OBJECT_ID     INTEGER,
AMOUNT               NUMERIC(15,2)                  not null,
CONTENT              VARCHAR(64),
constraint PK_ENTRY_ITEM primary key (ID)
);

/*==============================================================*/
/* Table: FAMILIARITY                                           */
/*==============================================================*/
create table FAMILIARITY (
ID                   INTEGER                        not null,
NAME                 VARCHAR(50),
IS_CHILD             CHAR(1)                        default 'N' not null,
constraint PK_FAMILIARITY primary key (ID)
);

/*==============================================================*/
/* Table: FAMILY_STATUS                                         */
/*==============================================================*/
create table FAMILY_STATUS (
ID                   INTEGER                        not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(50),
constraint PK_FAMILY_STATUS primary key (ID)
);

/*==============================================================*/
/* Table: FINANCE_DOCUMENT                                      */
/*==============================================================*/
create table FINANCE_DOCUMENT (
ID                   INTEGER                        not null,
TAX_ID               INTEGER,
CURRENCY_ID          INTEGER                        not null,
AMOUNT               NUMERIC(15,2)                  not null,
AMOUNT_WITH_TAX      NUMERIC(15,2)                  not null,
TAX_AMOUNT           NUMERIC(15,2)                  not null,
TOTAL                NUMERIC(15,2)                  not null,
TOTAL_WITH_TAX       NUMERIC(15,2)                  not null,
TAX_TOTAL            NUMERIC(15,2)                  not null,
CURRENCY_AMOUNT      NUMERIC(15,2)                  not null,
CURRENCY_AMOUNT_WITH_TAX NUMERIC(15,2)                  not null,
CURRENCY_TAX_AMOUNT  NUMERIC(15,2)                  not null,
CURRENCY_TOTAL       NUMERIC(15,2)                  not null,
CURRENCY_TOTAL_WITH_TAX NUMERIC(15,2)                  not null,
CURRENCY_TAX_TOTAL   NUMERIC(15,2)                  not null,
CURRENCY_RATE        NUMERIC(10,4)                  not null,
CURRENCY_RATE_DATE   DATE,
IS_OPERATION         CHAR(1)                        default 'N' not null,
IS_ACCOUNT_ITEMS     CHAR(1)                        default 'N' not null,
IS_TAX               CHAR(1)                        default 'N' not null,
TAX_PERCENT          NUMERIC(6,2)                   default 0 not null,
constraint PK_FINANCE_DOCUMENT primary key (ID)
);

/*==============================================================*/
/* Table: FINANCE_DOCUMENT_TYPE                                 */
/*==============================================================*/
create table FINANCE_DOCUMENT_TYPE (
ID                   INTEGER                        not null,
DOCUMENT_TYPE_ID     INTEGER                        not null,
MOVE_TYPE            VARCHAR(20)                    not null,
IS_BOTH_TAX_AMOUNT   CHAR(1)                        default 'N' not null,
IS_INCLUDE_TAX_IN_AMOUNT CHAR(1)                        default 'N' not null,
constraint PK_FINANCE_DOCUMENT_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: FORM_PROPERTY                                         */
/*==============================================================*/
create table FORM_PROPERTY (
ID                   INTEGER                        not null,
NAME                 VARCHAR(20),
FULL_NAME            VARCHAR(50),
constraint PK_FORM_PROPERTY primary key (ID)
);

/*==============================================================*/
/* Table: GOODS                                                 */
/*==============================================================*/
create table GOODS (
ID                   INTEGER                        not null,
COUNTRY_ID           INTEGER,
GOODS_TYPE_ID        INTEGER                        not null,
IS_INVENTORY         CHAR(1)                        default 'N' not null,
constraint PK_GOODS primary key (ID)
);

/*==============================================================*/
/* Table: GOODS_INCOME                                          */
/*==============================================================*/
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

/*==============================================================*/
/* Table: GOODS_INCOME_ITEM                                     */
/*==============================================================*/
create table GOODS_INCOME_ITEM (
ID                   INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
TAX_ID               INTEGER,
UNIT_ID              INTEGER                        not null,
GOODS_INCOME_ID      INTEGER                        not null,
PRODUCT_FEATURE_NAME VARCHAR(100),
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
constraint PK_GOODS_INCOME_ITEM primary key (ID)
);

/*==============================================================*/
/* Table: GOODS_OUTCOME                                         */
/*==============================================================*/
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

/*==============================================================*/
/* Table: GOODS_OUTCOME_ITEM                                    */
/*==============================================================*/
create table GOODS_OUTCOME_ITEM (
ID                   INTEGER                        not null,
TAX_ID               INTEGER,
UNIT_ID              INTEGER                        not null,
GOODS_OUTCOME_ID     INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
PRODUCT_INSTANCE_ID  INTEGER,
PRODUCT_FEATURE_NAME VARCHAR(100),
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
constraint PK_GOODS_OUTCOME_ITEM primary key (ID)
);

/*==============================================================*/
/* Table: GOODS_TYPE                                            */
/*==============================================================*/
create table GOODS_TYPE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(20)                    not null,
NAME                 VARCHAR(50)                    not null,
constraint PK_GOODS_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: INDUSTRY                                              */
/*==============================================================*/
create table INDUSTRY (
ID                   INTEGER                        not null,
CODE                 VARCHAR(20),
NAME                 VARCHAR(50),
constraint PK_INDUSTRY primary key (ID)
);

/*==============================================================*/
/* Table: INTANGIBLE                                            */
/*==============================================================*/
create table INTANGIBLE (
ID                   INTEGER                        not null,
constraint PK_INTANGIBLE primary key (ID)
);

/*==============================================================*/
/* Table: INTANGIBLE_INCOME                                     */
/*==============================================================*/
create table INTANGIBLE_INCOME (
ID                   INTEGER                        not null,
constraint PK_INTANGIBLE_INCOME primary key (ID)
);

/*==============================================================*/
/* Table: INTANGIBLE_INCOME_ITEM                                */
/*==============================================================*/
create table INTANGIBLE_INCOME_ITEM (
ID                   INTEGER                        not null,
constraint PK_INTANGIBLE_INCOME_ITEM primary key (ID)
);

/*==============================================================*/
/* Table: INTANGIBLE_OUTCOME                                    */
/*==============================================================*/
create table INTANGIBLE_OUTCOME (
ID                   INTEGER                        not null,
constraint PK_INTANGIBLE_OUTCOME primary key (ID)
);

/*==============================================================*/
/* Table: INTANGIBLE_OUTCOME_ITEM                               */
/*==============================================================*/
create table INTANGIBLE_OUTCOME_ITEM (
ID                   INTEGER                        not null,
constraint PK_INTANGIBLE_OUTCOME_ITEM primary key (ID)
);

/*==============================================================*/
/* Table: INTANGIBLE_REST                                       */
/*==============================================================*/
create table INTANGIBLE_REST (
ID                   INTEGER                        not null,
constraint PK_INTANGIBLE_REST primary key (ID)
);

/*==============================================================*/
/* Table: INTANGIBLE_REST_ITEM                                  */
/*==============================================================*/
create table INTANGIBLE_REST_ITEM (
ID                   INTEGER                        not null,
constraint PK_INTANGIBLE_REST_ITEM primary key (ID)
);

/*==============================================================*/
/* Table: INTANGIBLE_WRITEOFF                                   */
/*==============================================================*/
create table INTANGIBLE_WRITEOFF (
ID                   INTEGER                        not null,
constraint PK_INTANGIBLE_WRITEOFF primary key (ID)
);

/*==============================================================*/
/* Table: INTANGIBLE_WRITEOFF_ITEM                              */
/*==============================================================*/
create table INTANGIBLE_WRITEOFF_ITEM (
ID                   INTEGER                        not null,
constraint PK_INTANGIBLE_WRITEOFF_ITEM primary key (ID)
);

/*==============================================================*/
/* Table: INVENTORY_INCOME                                      */
/*==============================================================*/
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

/*==============================================================*/
/* Table: INVENTORY_MOVE                                        */
/*==============================================================*/
create table INVENTORY_MOVE (
ID                   INTEGER                        not null,
INCOME_WAREHOUSE_ID  INTEGER                        not null,
OUTCOME_WAREHOUSE_ID INTEGER                        not null,
INCOME_MTRL_RESPONSIBLE_ID INTEGER,
OUTCOME_MTRL_RESPONSIBLE_ID INTEGER,
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

/*==============================================================*/
/* Table: INVENTORY_OUTCOME                                     */
/*==============================================================*/
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

/*==============================================================*/
/* Table: INVENTORY_REST                                        */
/*==============================================================*/
create table INVENTORY_REST (
ID                   INTEGER                        not null,
MTRL_RESPONSIBLE_ID  INTEGER,
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

/*==============================================================*/
/* Table: INVENTORY_WRITEOFF                                    */
/*==============================================================*/
create table INVENTORY_WRITEOFF (
ID                   INTEGER                        not null,
WAREHOUSE_ID         INTEGER                        not null,
MTRL_RESPONSIBLE_ID  INTEGER,
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
/* Table: JOB_POSITION                                          */
/*==============================================================*/
create table JOB_POSITION (
ID                   INTEGER                        not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(50)                    not null,
constraint PK_JOB_POSITION primary key (ID)
);

/*==============================================================*/
/* Table: LANGUAGE                                              */
/*==============================================================*/
create table LANGUAGE (
ID                   INTEGER                        not null,
CODE                 CHAR(2),
CODE3                CHAR(3),
NUMERIC_CODE         CHAR(3),
NAME                 VARCHAR(50),
constraint PK_LANGUAGE primary key (ID)
);

/*==============================================================*/
/* Table: LEDGER_ACCOUNT                                        */
/*==============================================================*/
create table LEDGER_ACCOUNT (
ID                   INTEGER                        not null,
LEDGER_ACCOUNT_TYPE_ID INTEGER                        not null,
CODE                 VARCHAR(10)                    not null,
NAME                 VARCHAR(100)                   not null,
PARENT_ID            INTEGER,
constraint PK_LEDGER_ACCOUNT primary key (ID)
);

/*==============================================================*/
/* Table: LEDGER_ACCOUNT_REGISTER                               */
/*==============================================================*/
create table LEDGER_ACCOUNT_REGISTER (
ID                   INTEGER                        not null,
PERIOD_ID            INTEGER                        not null,
ORGANIZATION_ID      INTEGER                        not null,
LEDGER_ACCOUNT_ID    INTEGER                        not null,
DEBIT_AMOUNT         NUMERIC(15,2)                  not null,
CREDIT_AMOUNT        NUMERIC(15,2)                  not null,
AMOUNT               NUMERIC(15,2)                  not null,
constraint PK_LEDGER_ACCOUNT_REGISTER primary key (ID)
);

/*==============================================================*/
/* Table: LEDGER_ACCOUNT_REST                                   */
/*==============================================================*/
create table LEDGER_ACCOUNT_REST (
ID                   INTEGER                        not null,
ORGANIZATION_ID      INTEGER                        not null,
CURRENCY_ID          INTEGER                        not null,
PERIOD_ID            INTEGER                        not null,
LEDGER_ACCOUNT_ID    INTEGER                        not null,
REST_DATE            DATE,
DEBIT_AMOUNT         NUMERIC(15,2)                  not null,
CREDIT_AMOUNT        NUMERIC(15,2)                  not null,
CURRENCY_DEBIT       NUMERIC(15,2)                  not null,
CURRENCY_CREDIT      NUMERIC(15,2)                  not null,
constraint PK_LEDGER_ACCOUNT_REST primary key (ID)
);

/*==============================================================*/
/* Table: LEDGER_ACCOUNT_TYPE                                   */
/*==============================================================*/
create table LEDGER_ACCOUNT_TYPE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(3)                     not null,
NAME                 VARCHAR(50)                    not null,
constraint PK_LEDGER_ACCOUNT_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: LOCALITY                                              */
/*==============================================================*/
create table LOCALITY (
ID                   INTEGER                        not null,
COUNTRY_ID           INTEGER                        not null,
LOCALITY_TYPE_ID     INTEGER                        not null,
REGION_ID            INTEGER,
DISTRICT_ID          INTEGER,
NAME                 VARCHAR(50)                    not null,
constraint PK_LOCALITY primary key (ID)
);

/*==============================================================*/
/* Table: LOCALITY_TYPE                                         */
/*==============================================================*/
create table LOCALITY_TYPE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(10)                    not null,
FULL_NAME            VARCHAR(30),
constraint PK_LOCALITY_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: MANUFACTURE_INCOME                                    */
/*==============================================================*/
create table MANUFACTURE_INCOME (
ID                   INTEGER                        not null,
constraint PK_MANUFACTURE_INCOME primary key (ID)
);

/*==============================================================*/
/* Table: MANUFACTURE_OUTCOME                                   */
/*==============================================================*/
create table MANUFACTURE_OUTCOME (
ID                   INTEGER                        not null,
constraint PK_MANUFACTURE_OUTCOME primary key (ID)
);

/*==============================================================*/
/* Table: MANUFACTURE_PLAN                                      */
/*==============================================================*/
create table MANUFACTURE_PLAN (
ID                   INTEGER                        not null,
constraint PK_MANUFACTURE_PLAN primary key (ID)
);

/*==============================================================*/
/* Table: MANUFACTURE_WRITEOFF                                  */
/*==============================================================*/
create table MANUFACTURE_WRITEOFF (
ID                   INTEGER                        not null,
constraint PK_MANUFACTURE_WRITEOFF primary key (ID)
);

/*==============================================================*/
/* Table: MILITARY_RANK                                         */
/*==============================================================*/
create table MILITARY_RANK (
ID                   INTEGER                        not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(150),
constraint PK_MILITARY_RANK primary key (ID)
);

/*==============================================================*/
/* Table: MILITARY_SPECIALITY                                   */
/*==============================================================*/
create table MILITARY_SPECIALITY (
ID                   INTEGER                        not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(50),
constraint PK_MILITARY_SPECIALITY primary key (ID)
);

/*==============================================================*/
/* Table: MILITARY_STATUS                                       */
/*==============================================================*/
create table MILITARY_STATUS (
ID                   INTEGER                        not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(50),
constraint PK_MILITARY_STATUS primary key (ID)
);

/*==============================================================*/
/* Table: MTRL_RESPONSIBLE                                      */
/*==============================================================*/
create table MTRL_RESPONSIBLE (
ID                   INTEGER                        not null,
CONTACT_ID           INTEGER                        not null,
WAREHOUSE_ID         INTEGER,
ORGANIZATION_ID      INTEGER                        not null,
constraint PK_MTRL_RESPONSIBLE primary key (ID)
);

/*==============================================================*/
/* Table: M_LEDGER_ACCOUNT_REGISTER                             */
/*==============================================================*/
create table M_LEDGER_ACCOUNT_REGISTER (
LEDGER_ACCOUNT_ID    INTEGER                        not null,
DEBIT_AMOUNT         NUMERIC(15,2)                  not null,
CREDIT_AMOUNT        NUMERIC(15,2)                  not null
);

/*==============================================================*/
/* Table: M_LEDGER_ACCOUNT_REGISTER_ID                          */
/*==============================================================*/
create table M_LEDGER_ACCOUNT_REGISTER_ID (
LEDGER_ACCOUNT_ID    INTEGER                        not null
);

/*==============================================================*/
/* Table: M_LEDGER_ACCOUNT_REGISTER_SUM                         */
/*==============================================================*/
create table M_LEDGER_ACCOUNT_REGISTER_SUM (
LEDGER_ACCOUNT_ID    INTEGER                        not null,
DEBIT_AMOUNT         NUMERIC(15,2)                  not null,
CREDIT_AMOUNT        NUMERIC(15,2)                  not null
);

/*==============================================================*/
/* Table: M_PARTNER_REGISTER                                    */
/*==============================================================*/
create table M_PARTNER_REGISTER (
PARTNER_ID           INTEGER                        not null,
DEBIT_AMOUNT         NUMERIC(15,2)                  not null,
CREDIT_AMOUNT        NUMERIC(15,2)                  not null
);

/*==============================================================*/
/* Table: M_PARTNER_REGISTER_ID                                 */
/*==============================================================*/
create table M_PARTNER_REGISTER_ID (
PARTNER_ID           INTEGER                        not null
);

/*==============================================================*/
/* Table: M_PARTNER_REGISTER_SUM                                */
/*==============================================================*/
create table M_PARTNER_REGISTER_SUM (
PARTNER_ID           INTEGER                        not null,
DEBIT_AMOUNT         NUMERIC(15,2)                  not null,
CREDIT_AMOUNT        NUMERIC(15,2)                  not null
);

/*==============================================================*/
/* Table: M_PRODUCT_DETAIL_REGISTER                             */
/*==============================================================*/
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
/* Table: M_PRODUCT_DETAIL_REGISTER_ID                          */
/*==============================================================*/
create table M_PRODUCT_DETAIL_REGISTER_ID (
PRODUCT_ID           INTEGER                        not null,
WAREHOUSE_ID         INTEGER                        not null,
MTRL_RESPONSIBLE_ID  INTEGER
);

/*==============================================================*/
/* Table: M_PRODUCT_DETAIL_REGISTER_SUM                         */
/*==============================================================*/
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
/* Table: M_PRODUCT_REGISTER                                    */
/*==============================================================*/
create table M_PRODUCT_REGISTER (
PRODUCT_ID           INTEGER                        not null,
DEBIT_QUANTITY       NUMERIC(9,4)                   not null,
CREDIT_QUANTITY      NUMERIC(9,4)                   not null,
DEBIT_AMOUNT         NUMERIC(15,2)                  not null,
CREDIT_AMOUNT        NUMERIC(15,2)                  not null
);

/*==============================================================*/
/* Table: M_PRODUCT_REGISTER_ID                                 */
/*==============================================================*/
create table M_PRODUCT_REGISTER_ID (
PRODUCT_ID           INTEGER                        not null
);

/*==============================================================*/
/* Table: M_PRODUCT_REGISTER_SUM                                */
/*==============================================================*/
create table M_PRODUCT_REGISTER_SUM (
PRODUCT_ID           INTEGER                        not null,
DEBIT_QUANTITY       NUMERIC(9,4)                   not null,
CREDIT_QUANTITY      NUMERIC(9,4)                   not null,
DEBIT_AMOUNT         NUMERIC(15,2)                  not null,
CREDIT_AMOUNT        NUMERIC(15,2)                  not null
);

/*==============================================================*/
/* Table: ORGANIZATION                                          */
/*==============================================================*/
create table ORGANIZATION (
ID                   INTEGER                        not null,
constraint PK_ORGANIZATION primary key (ID)
);

/*==============================================================*/
/* Table: PARTNER                                               */
/*==============================================================*/
create table PARTNER (
ID                   INTEGER                        not null,
CONTACT_ID           INTEGER,
LEDGER_ACCOUNT_ID    INTEGER,
FORM_PROPERTY_ID     INTEGER,
RESPONSIBLE_ID       INTEGER,
PARTNER_GROUP_ID     INTEGER,
BANK_ACCOUNT_ID      INTEGER,
INDUSTRY_ID          INTEGER,
PARTNER_TYPE_ID      INTEGER                        default 1 not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(50)                    not null,
NAME_EN              VARCHAR(50),
FULL_NAME            VARCHAR(100),
IDN                  VARCHAR(12),
YEAR_CREATE          INTEGER                        default 0 not null,
WORK_TIME            VARCHAR(50),
NOTE                 VARCHAR(255),
IS_TAX               CHAR(1)                        default 'N' not null,
NEC                  VARCHAR(20),
TAX_DOC_NO           VARCHAR(20),
DESCRIMINATOR        VARCHAR(30),
PARENT_ID            INTEGER,
IMAGE_FILE_NAME      VARCHAR(50),
IS_PERSON            CHAR(1)                        default 'N' not null,
constraint PK_PARTNER primary key (ID)
);

/*==============================================================*/
/* Table: PARTNER_ACTIVITY_TYPE_LINK                            */
/*==============================================================*/
create table PARTNER_ACTIVITY_TYPE_LINK (
ID                   INTEGER                        not null,
ACTIVITY_TYPE_ID     INTEGER                        not null,
PARTNER_ID           INTEGER                        not null,
constraint PK_PARTNER_ACTIVITY_TYPE_LINK primary key (ID)
);

/*==============================================================*/
/* Table: PARTNER_CATEGORY                                      */
/*==============================================================*/
create table PARTNER_CATEGORY (
ID                   INTEGER                        not null,
NAME                 VARCHAR(20),
constraint PK_PARTNER_CATEGORY primary key (ID)
);

/*==============================================================*/
/* Table: PARTNER_CATEGORY_LINK                                 */
/*==============================================================*/
create table PARTNER_CATEGORY_LINK (
ID                   INTEGER                        not null,
PARTNER_ID           INTEGER                        not null,
PARTNER_CATEGORY_ID  INTEGER                        not null,
constraint PK_PARTNER_CATEGORY_LINK primary key (ID)
);

/*==============================================================*/
/* Table: PARTNER_GROUP                                         */
/*==============================================================*/
create table PARTNER_GROUP (
ID                   INTEGER                        not null,
NAME                 VARCHAR(20),
constraint PK_PARTNER_GROUP primary key (ID)
);

/*==============================================================*/
/* Table: PARTNER_MOVE                                          */
/*==============================================================*/
create table PARTNER_MOVE (
ID                   INTEGER                        not null,
OWNER_ID             INTEGER                        not null,
PARTNER_ID           INTEGER                        not null,
AMOUNT               NUMERIC(15,2),
AMOUNT_WITH_TAX      NUMERIC(15,2),
TAX_AMOUNT           NUMERIC(15,2),
constraint PK_PARTNER_MOVE primary key (ID)
);

/*==============================================================*/
/* Table: PARTNER_REGISTER                                      */
/*==============================================================*/
create table PARTNER_REGISTER (
ID                   INTEGER                        not null,
PARTNER_ID           INTEGER                        not null,
PERIOD_ID            INTEGER                        not null,
ORGANIZATION_ID      INTEGER                        not null,
DEBIT_AMOUNT         NUMERIC(15,2)                  not null,
CREDIT_AMOUNT        NUMERIC(15,2)                  not null,
AMOUNT               NUMERIC(15,2)                  not null,
constraint PK_PARTNER_REGISTER primary key (ID)
);

/*==============================================================*/
/* Table: PARTNER_REST                                          */
/*==============================================================*/
create table PARTNER_REST (
ID                   INTEGER                        not null,
PERIOD_ID            INTEGER                        not null,
ORGANIZATION_ID      INTEGER                        not null,
PARTNER_ID           INTEGER                        not null,
CURRENCY_ID          INTEGER                        not null,
REST_DATE            DATE,
DEBIT_AMOUNT         NUMERIC(15,2)                  not null,
CREDIT_AMOUNT        NUMERIC(15,2)                  not null,
CURRENCY_DEBIT       NUMERIC(15,2)                  not null,
CURRENCY_CREDIT      NUMERIC(15,2)                  not null,
constraint PK_PARTNER_REST primary key (ID)
);

/*==============================================================*/
/* Table: PARTNER_TYPE                                          */
/*==============================================================*/
create table PARTNER_TYPE (
ID                   INTEGER                        not null,
NAME                 VARCHAR(30)                    not null,
constraint PK_PARTNER_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: PAYMENT_DOCUMENT_LINK                                 */
/*==============================================================*/
create table PAYMENT_DOCUMENT_LINK (
ID                   INTEGER                        not null,
PAYMENT_DOCUMENT_ID  INTEGER                        not null,
REASON_DOCUMENT_ID   INTEGER                        not null,
constraint PK_PAYMENT_DOCUMENT_LINK primary key (ID)
);

/*==============================================================*/
/* Table: PAYMENT_INCOME                                        */
/*==============================================================*/
create table PAYMENT_INCOME (
ID                   INTEGER                        not null,
ORGANIZATION_BANK_ACCOUNT_ID INTEGER                        not null,
PARTNER_BANK_ACCOUNT_ID INTEGER                        not null,
TAXPRINT_TYPE_ID     INTEGER                        not null,
PAYMENT_TYPE_ID      INTEGER                        not null,
PAYMENT_DATE         DATE                           not null,
SEND_DATE            DATE,
PAYMENT_MISSING      VARCHAR(128),
BANK_REFERENCE_CODE  VARCHAR(30),
constraint PK_PAYMENT_INCOME primary key (ID)
);

/*==============================================================*/
/* Table: PAYMENT_MISSING                                       */
/*==============================================================*/
create table PAYMENT_MISSING (
ID                   INTEGER                        not null,
MISSING              VARCHAR(100)                   not null
);

/*==============================================================*/
/* Table: PAYMENT_OUTCOME                                       */
/*==============================================================*/
create table PAYMENT_OUTCOME (
ID                   INTEGER                        not null,
PARTNER_BANK_ACCOUNT_ID INTEGER                        not null,
ORGANIZATION_BANK_ACCOUNT_ID INTEGER                        not null,
TAXPRINT_TYPE_ID     INTEGER                        not null,
PAYMENT_TYPE_ID      INTEGER                        not null,
PAYMENT_DATE         DATE,
PAYMENT_MISSING      VARCHAR(128),
BANK_REFERENCE_CODE  VARCHAR(30),
constraint PK_PAYMENT_OUTCOME primary key (ID)
);

/*==============================================================*/
/* Table: PAYMENT_OUTCOME_TEMPLATE                              */
/*==============================================================*/
create table PAYMENT_OUTCOME_TEMPLATE (
PARTNER_ID           INTEGER,
TAX_ID               INTEGER,
PARTNER_BANK_ACCOUNT_ID INTEGER                        not null,
PROJECT_ID           INTEGER,
PAYMENT_TYPE_ID      INTEGER                        not null,
ORGANIZATION_ID      INTEGER                        not null,
ORGANIZATION_BANK_ACCOUNT_ID INTEGER                        not null,
CURRENCY_ID          INTEGER                        not null,
DEPARTMENT_ID        INTEGER,
USER_ID              INTEGER,
TAXPRINT_TYPE_ID     INTEGER                        not null,
ID                   INTEGER                        not null,
DOCUMENT_NO          VARCHAR(20),
DOCUMENT_DATE        DATE,
REASON               VARCHAR(64),
AMOUNT               NUMERIC(15,2)                  not null,
AMOUNT_WITH_TAX      NUMERIC(15,2)                  not null,
TAX_AMOUNT           NUMERIC(15,2)                  not null,
TOTAL                NUMERIC(15,2)                  not null,
TOTAL_WITH_TAX       NUMERIC(15,2)                  not null,
TAX_TOTAL            NUMERIC(15,2)                  not null,
CURRENCY_AMOUNT      NUMERIC(15,2)                  not null,
CURRENCY_AMOUNT_WITH_TAX NUMERIC(15,2)                  not null,
CURRENCY_TAX_AMOUNT  NUMERIC(15,2)                  not null,
CURRENCY_TOTAL       NUMERIC(15,2)                  not null,
CURRENCY_TOTAL_WITH_TAX NUMERIC(15,2)                  not null,
CURRENCY_TAX_TOTAL   NUMERIC(15,2)                  not null,
CURRENCY_RATE        NUMERIC(10,4)                  not null,
CURRENCY_RATE_DATE   DATE,
IS_TAX               CHAR(1)                        not null,
TAX_PERCENT          NUMERIC(6,2)                   default 0 not null,
PAYMENT_DATE         DATE,
PAYMENT_MISSING      VARCHAR(128),
NOTE                 VARCHAR(255)
);

/*==============================================================*/
/* Table: PAYMENT_TYPE                                          */
/*==============================================================*/
create table PAYMENT_TYPE (
ID                   INTEGER                        not null,
NAME                 VARCHAR(30),
constraint PK_PAYMENT_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: PAYROLL                                               */
/*==============================================================*/
create table PAYROLL (
ID                   INTEGER                        not null,
PAYROLL_MODE_ID      INTEGER                        not null,
PAYROLL_ALGORITM_ID  INTEGER,
PAYROLL_ALGORITM_TYPE_ID INTEGER                        not null,
PAYROLL_GROUP_ID     INTEGER,
PAYROLL_TYPE_ID      INTEGER                        not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(100),
NOTE                 VARCHAR(255),
PRIORITY             INTEGER                        not null,
PAYROLL_PERCENT      NUMERIC(6,2)                   not null,
IS_TIME              CHAR(1)                        default 'N' not null,
IS_PENSION           CHAR(1)                        default 'N' not null,
IS_TAX               CHAR(1)                        default 'N' not null,
IS_VACATION          CHAR(1)                        default 'N' not null,
IS_SICK              CHAR(1)                        default 'N' not null,
IS_FUND_SALARY       CHAR(1)                        default 'N' not null,
IS_FUND_HELP         CHAR(1)                        default 'N' not null,
IS_FUND_INSURANCE    CHAR(1)                        default 'N' not null,
IS_FUND_WORK         CHAR(1)                        default 'N' not null,
IS_SALARY13          CHAR(1)                        default 'N' not null,
IS_SALARY12          CHAR(1)                        default 'N' not null,
IS_ADD_PAY           CHAR(1)                        default 'N' not null,
constraint PK_PAYROLL primary key (ID)
);

/*==============================================================*/
/* Table: PAYROLL_ALGORITM                                      */
/*==============================================================*/
create table PAYROLL_ALGORITM (
ID                   INTEGER                        not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(50),
ALGORITM_CLASS       VARCHAR(128),
constraint PK_PAYROLL_ALGORITM primary key (ID)
);

/*==============================================================*/
/* Table: PAYROLL_ALGORITM_TYPE                                 */
/*==============================================================*/
create table PAYROLL_ALGORITM_TYPE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(50),
constraint PK_PAYROLL_ALGORITM_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: PAYROLL_FORM                                          */
/*==============================================================*/
create table PAYROLL_FORM (
ID                   INTEGER                        not null,
NAME                 VARCHAR(30),
constraint PK_PAYROLL_FORM primary key (ID)
);

/*==============================================================*/
/* Table: PAYROLL_GROUP                                         */
/*==============================================================*/
create table PAYROLL_GROUP (
ID                   INTEGER                        not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(50),
constraint PK_PAYROLL_GROUP primary key (ID)
);

/*==============================================================*/
/* Table: PAYROLL_ITEM                                          */
/*==============================================================*/
create table PAYROLL_ITEM (
ID                   INTEGER                        not null,
OWNER_ID             INTEGER                        not null,
PAYROLL_ID           INTEGER                        not null,
PAYROLL_PERCENT      NUMERIC(6,2)                   not null,
constraint PK_PAYROLL_ITEM primary key (ID)
);

/*==============================================================*/
/* Table: PAYROLL_MODE                                          */
/*==============================================================*/
create table PAYROLL_MODE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(50),
constraint PK_PAYROLL_MODE primary key (ID)
);

/*==============================================================*/
/* Table: PAYROLL_TYPE                                          */
/*==============================================================*/
create table PAYROLL_TYPE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(50),
constraint PK_PAYROLL_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: PERIOD                                                */
/*==============================================================*/
create table PERIOD (
ID                   INTEGER                        not null,
PERIOD_TYPE_ID       INTEGER                        not null,
START_DATE           DATE                           not null,
END_DATE             DATE                           not null,
NAME                 VARCHAR(50),
PREV_PERIOD_ID       INTEGER,
constraint PK_PERIOD primary key (ID)
);

/*==============================================================*/
/* Table: PERIOD_TYPE                                           */
/*==============================================================*/
create table PERIOD_TYPE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(20),
NAME                 VARCHAR(30),
constraint PK_PERIOD_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: PERSON                                                */
/*==============================================================*/
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

/*==============================================================*/
/* Table: PERSON_DOCUMENT                                       */
/*==============================================================*/
create table PERSON_DOCUMENT (
ID                   INTEGER                        not null,
PERSON_ID            INTEGER                        not null,
PERSON_DOC_TYPE_ID   INTEGER                        not null,
SERIES               VARCHAR(10),
ORDER_NUMBER         VARCHAR(10),
DOCUMENT_DATE        DATE,
GIVEN                VARCHAR(100),
constraint PK_PERSON_DOCUMENT primary key (ID)
);

/*==============================================================*/
/* Table: PERSON_DOCUMENT_TYPE                                  */
/*==============================================================*/
create table PERSON_DOCUMENT_TYPE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(50)                    not null,
constraint PK_PERSON_DOCUMENT_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: PERSON_EDUCATION                                      */
/*==============================================================*/
create table PERSON_EDUCATION (
ID                   INTEGER                        not null,
EDUCATION_TYPE_ID    INTEGER                        not null,
ACADEMIC_DEGREE_ID   INTEGER,
EDUCATION_FORM_ID    INTEGER                        not null,
EDUCATION_INSTITUTE_ID INTEGER                        not null,
PERSON_ID            INTEGER                        not null,
DATE_END             DATE,
FACULTY              VARCHAR(30),
constraint PK_PERSON_EDUCATION primary key (ID)
);

/*==============================================================*/
/* Table: PERSON_FAMILY                                         */
/*==============================================================*/
create table PERSON_FAMILY (
ID                   INTEGER                        not null,
FAMILIARITY_ID       INTEGER                        not null,
PERSON_ID            INTEGER                        not null,
NAME                 VARCHAR(50),
BIRTH_DATE           DATE,
constraint PK_PERSON_FAMILY primary key (ID)
);

/*==============================================================*/
/* Table: PERSON_JOB                                            */
/*==============================================================*/
create table PERSON_JOB (
ID                   INTEGER                        not null,
PERSON_ID            INTEGER                        not null,
JOB_INDEX            INTEGER                        not null,
START_DATE           DATE,
END_DATE             DATE,
ORGANIZATION         VARCHAR(30),
JOB_POSITION         VARCHAR(30),
constraint PK_PERSON_JOB primary key (ID)
);

/*==============================================================*/
/* Table: PERSON_LANGUAGE                                       */
/*==============================================================*/
create table PERSON_LANGUAGE (
ID                   INTEGER                        not null,
PERSON_ID            INTEGER                        not null,
LANGUAGE_ID          INTEGER                        not null,
IS_NATIVE            CHAR(1)                        default 'N' not null,
constraint PK_PERSON_LANGUAGE primary key (ID)
);

/*==============================================================*/
/* Table: PERSON_MILITARY                                       */
/*==============================================================*/
create table PERSON_MILITARY (
ID                   INTEGER                        not null,
PERSON_ID            INTEGER                        not null,
MILITARY_SPECIALITY_ID INTEGER,
MILITARY_RANK_ID     INTEGER,
MILITARY_STATUS_ID   INTEGER,
VALID_STATUS         INTEGER                        not null,
MILITARY_REGISTRATION VARCHAR(30),
SPECIAL_RECORD       VARCHAR(30),
constraint PK_PERSON_MILITARY primary key (ID)
);

/*==============================================================*/
/* Table: PHONE                                                 */
/*==============================================================*/
create table PHONE (
ID                   INTEGER                        not null,
PHONE_TYPE_ID        INTEGER                        not null,
CONTACTABLE_ID       INTEGER                        not null,
PHONE_CODE           VARCHAR(6),
PHONE_NUMBER         VARCHAR(12),
PHONE_EXT            VARCHAR(6),
PHONE_STRING         VARCHAR(20),
PHONE_COMPILE        VARCHAR(20),
NOTE                 VARCHAR(255),
constraint PK_PHONE primary key (ID)
);

/*==============================================================*/
/* Table: PHONE_TYPE                                            */
/*==============================================================*/
create table PHONE_TYPE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(20),
NAME                 VARCHAR(30),
constraint PK_PHONE_TYPE primary key (ID)
);

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
START_DATE_TIME     DATETIME                           not null,
END_DATE_TIME     DATETIME,
REMINDER_DATE_TIME     DATETIME,
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
EVENT_DATE_TIME     DATETIME                           not null,
REMINDER_DATE_TIME     DATETIME,
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
NOTE_DATE_TIME     DATETIME                           not null,
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
EVENT_DATE_TIME     DATETIME,
REMINDER_DATE_TIME     DATETIME,
constraint PK_PIM_REMINDER primary key (ID)
);

/*==============================================================*/
/* Table: PRICE_TYPE                                            */
/*==============================================================*/
create table PRICE_TYPE (
ID                   INTEGER                        not null,
NAME                 VARCHAR(30),
PRICE_PERCENT        NUMERIC(6,2)                   not null,
NOTE                 VARCHAR(255),
constraint PK_PRICE_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: PRODUCT                                               */
/*==============================================================*/
create table PRODUCT (
ID                   INTEGER                        not null,
WARRANTY_PERIOD_UNIT_ID INTEGER,
LEDGER_ACCOUNT_ID    INTEGER,
SUPPLIER_ID          INTEGER,
PRODUCT_GROUP_ID     INTEGER,
CURRENCY_ID          INTEGER                        not null,
WEIGHT_UNIT_ID       INTEGER,
ORGANIZATION_ID      INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
RESPONSIBLE_ID       INTEGER,
MANUFACTURER_ID      INTEGER,
DIMENSION_UNIT_ID    INTEGER,
CODE                 VARCHAR(20),
NAME                 VARCHAR(100)                   not null,
NAME_EN              VARCHAR(100),
FULL_NAME            VARCHAR(100),
START_DATE           DATE,
END_DATE             DATE,
NOTE                 VARCHAR(255),
TAX_PERCENT          NUMERIC(5,2)                   not null,
ADDPRICE_PERCENT     NUMERIC(5,2)                   not null,
CURRENCY_RATE        NUMERIC(10,4)                  not null,
MIN_QUANTITY         NUMERIC(15,4)                  default 0 not null,
AVAILABLE_QUANTITY   NUMERIC(15,4)                  default 0 not null,
RESERVED_QUANTITY    NUMERIC(15,4)                  default 0 not null,
EXPECTED_QUANTITY    NUMERIC(15,4)                  default 0 not null,
PRICE                NUMERIC(15,4)                  default 0 not null,
LIST_PRICE           NUMERIC(15,4)                  default 0 not null,
WHOLESALE_PRICE      NUMERIC(15,4)                  default 0 not null,
SMALL_WHOLESALE_PRICE NUMERIC(15,4)                  default 0 not null,
RETAIL_PRICE         NUMERIC(15,4)                  default 0 not null,
CURRENCY_PRICE       NUMERIC(15,4)                  default 0 not null,
CURRENCY_LIST_PRICE  NUMERIC(15,4)                  default 0 not null,
CURRENCY_SMALL_WHOLESALE_PRICE NUMERIC(15,4)                  default 0 not null,
CURRENCY_WHOLESALE_PRICE NUMERIC(15,4)                  default 0 not null,
CURRENCY_RETAIL_PRICE NUMERIC(15,4)                  default 0 not null,
WARRANTY_PERIOD      INTEGER,
BAR_CODE             VARCHAR(30),
DIM_LENGTH           NUMERIC(12,3)                  default 0 not null,
DIM_WIDTH            NUMERIC(12,3)                  default 0 not null,
DIM_HEIGHT           NUMERIC(12,3)                  default 0 not null,
WEIGHT               NUMERIC(12,3)                  default 0 not null,
IMAGE_FILE_NAME      VARCHAR(50),
constraint PK_PRODUCT primary key (ID)
);

/*==============================================================*/
/* Table: PRODUCT_DETAIL_REGISTER                               */
/*==============================================================*/
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

/*==============================================================*/
/* Table: PRODUCT_GROUP                                         */
/*==============================================================*/
create table PRODUCT_GROUP (
ID                   INTEGER                        not null,
PRODUCT_SECTION_ID   INTEGER                        not null,
CODE                 VARCHAR(20)                    not null,
NAME                 VARCHAR(100)                   not null,
NAME_EN              VARCHAR(100),
PARENT_ID            INTEGER,
constraint PK_PRODUCT_GROUP primary key (ID)
);

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
/* Table: PRODUCT_MOVE                                          */
/*==============================================================*/
create table PRODUCT_MOVE (
ID                   INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
OWNER_ID             INTEGER                        not null,
PRODUCT_FEATURE_NAME VARCHAR(100),
UNIT_RATE            NUMERIC(15,3)                  not null,
PRICE                NUMERIC(9,2)                   not null,
PRICE_WITH_TAX       NUMERIC(9,2)                   not null,
TAX_PRICE            NUMERIC(9,2)                   not null,
QUANTITY             NUMERIC(9,4)                   not null,
AMOUNT               NUMERIC(15,2)                  not null,
AMOUNT_WITH_TAX      NUMERIC(15,2)                  not null,
TAX_AMOUNT           NUMERIC(15,2)                  not null,
ACCOUNT_QUANTITY     NUMERIC(9,4)                   default 0 not null,
ACCOUNT_PRICE        NUMERIC(9,2)                   default 0 not null,
ACCOUNT_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
ACCOUNT_TAX_PRICE    NUMERIC(9,2)                   default 0 not null,
constraint PK_PRODUCT_MOVE primary key (ID)
);

/*==============================================================*/
/* Table: PRODUCT_PRICE                                         */
/*==============================================================*/
create table PRODUCT_PRICE (
ID                   INTEGER                        not null,
PRICE_TYPE_ID        INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
CURRENCY_ID          INTEGER                        not null,
PRICE_PERCENT        NUMERIC(6,2)                   not null,
PRICE                NUMERIC(15,2)                  not null,
constraint PK_PRODUCT_PRICE primary key (ID)
);

/*==============================================================*/
/* Table: PRODUCT_REGISTER                                      */
/*==============================================================*/
create table PRODUCT_REGISTER (
ID                   INTEGER                        not null,
ORGANIZATION_ID      INTEGER                        not null,
PERIOD_ID            INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
DEBIT_QUANTITY       NUMERIC(9,4)                   not null,
CREDIT_QUANTITY      NUMERIC(9,4)                   not null,
DEBIT_AMOUNT         NUMERIC(15,2)                  not null,
CREDIT_AMOUNT        NUMERIC(15,2)                  not null,
QUANTITY             NUMERIC(9,4)                   default 0 not null,
PRICE                NUMERIC(9,2)                   default 0 not null,
AMOUNT               NUMERIC(15,2)                  default 0 not null,
constraint PK_PRODUCT_REGISTER primary key (ID)
);

/*==============================================================*/
/* Table: PRODUCT_SECTION                                       */
/*==============================================================*/
create table PRODUCT_SECTION (
ID                   INTEGER                        not null,
CODE                 VARCHAR(20)                    not null,
NAME                 VARCHAR(30)                    not null,
constraint PK_PRODUCT_SECTION primary key (ID)
);

/*==============================================================*/
/* Table: PRODUCT_UNIT                                          */
/*==============================================================*/
create table PRODUCT_UNIT (
ID                   INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
RATE                 NUMERIC(10)                    not null,
BAR_CODE             VARCHAR(30),
constraint PK_PRODUCT_UNIT primary key (ID)
);

/*==============================================================*/
/* Table: PROJECT                                               */
/*==============================================================*/
create table PROJECT (
ID                   INTEGER                        not null,
CONTRACT_ID          INTEGER,
ORGANIZATION_ID      INTEGER                        not null,
PARTNER_ID           INTEGER,
PROJECT_STAGE_ID     INTEGER,
PROJECT_TYPE_ID      INTEGER                        not null,
CURRENCY_ID          INTEGER                        not null,
PROJECT_STATUS_ID    INTEGER                        not null,
TAX_ID               INTEGER,
RESPONSIBLE_ID       INTEGER                        not null,
CREATE_TIMESTAMP     DATETIME,
CREATE_USER_ID       INTEGER,
UPDATE_TIMESTAMP     DATETIME,
UPDATE_USER_ID       INTEGER,
PROJECT_NO           VARCHAR(20),
NAME                 VARCHAR(50)                    not null,
DESCRIPTION          VARCHAR(255),
PROPABILITY          NUMERIC(6,2)                   default 0 not null,
START_DATE           DATE,
END_DATE             DATE,
ACTUAL_END_DATE      DATE,
PERCENT_COMPLETE     NUMERIC(6,2)                   default 0 not null,
DISCOUNT_PERCENT     NUMERIC(6,2)                   default 0 not null,
DISCOUNT_AMOUNT      NUMERIC(15,2)                  default 0 not null,
CURRENCY_DISCOUNT_AMOUNT NUMERIC(15,2)                  default 0 not null,
AMOUNT               NUMERIC(15,2)                  default 0 not null,
TAX_AMOUNT           NUMERIC(15,2)                  default 0 not null,
AMOUNT_WITH_TAX      NUMERIC(15,2)                  default 0 not null,
TOTAL                NUMERIC(15,2)                  default 0 not null,
TAX_TOTAL            NUMERIC(15,2)                  default 0 not null,
TOTAL_WITH_TAX       NUMERIC(15,2)                  default 0 not null,
CURRENCY_RATE        NUMERIC(10,4)                  default 0 not null,
CURRENCY_RATE_DATE   DATE,
CURRENCY_AMOUNT      NUMERIC(15,2)                  default 0 not null,
CURRENCY_TAX_AMOUNT  NUMERIC(15,2)                  default 0 not null,
CURRENCY_AMOUNT_WITH_TAX NUMERIC(15,2)                  default 0 not null,
CURRENCY_TOTAL       NUMERIC(15,2)                  default 0 not null,
CURRENCY_TAX_TOTAL   NUMERIC(15,2)                  default 0 not null,
CURRENCY_TOTAL_WITH_TAX NUMERIC(15,2)                  default 0 not null,
IS_TAX               CHAR(1)                        default 'N' not null,
TAX_PERCENT          NUMERIC(6,2)                   default 0 not null,
constraint PK_PROJECT primary key (ID)
);

/*==============================================================*/
/* Table: PROJECT_CONTACT_LINK                                  */
/*==============================================================*/
create table PROJECT_CONTACT_LINK (
ID                   INTEGER                        not null,
PROJECT_ROLE_ID      INTEGER                        not null,
CONTACT_ID           INTEGER                        not null,
PROJECT_ID           INTEGER                        not null,
DESCRIPTION          VARCHAR(255),
constraint PK_PROJECT_CONTACT_LINK primary key (ID)
);

/*==============================================================*/
/* Table: PROJECT_CONTEXT                                       */
/*==============================================================*/
create table PROJECT_CONTEXT (
ID                   INTEGER                        not null,
CURRENCY_ID          INTEGER,
PROJECT_TYPE_ID      INTEGER,
PROJECT_STAGE_ID     INTEGER,
PARTNER_ID           INTEGER,
RESPONSIBLE_ID       INTEGER,
PROJECT_STATUS_ID    INTEGER,
constraint PK_PROJECT_CONTEXT primary key (ID)
);

/*==============================================================*/
/* Table: PROJECT_ROLE                                          */
/*==============================================================*/
create table PROJECT_ROLE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(20),
NAME                 VARCHAR(50)                    not null,
DESCRIPTION          VARCHAR(255),
constraint PK_PROJECT_ROLE primary key (ID)
);

/*==============================================================*/
/* Table: PROJECT_STAGE                                         */
/*==============================================================*/
create table PROJECT_STAGE (
ID                   INTEGER                        not null,
PROJECT_TYPE_ID      INTEGER                        not null,
PROJECT_STAGE_GROUP_ID INTEGER                        not null,
CODE                 VARCHAR(20),
NAME                 VARCHAR(50)                    not null,
DESCRIPTION          VARCHAR(255),
ORDER_NUMBER         INTEGER                        default 0 not null,
AVERANGE_DURATION    INTEGER                        default 0 not null,
FROM_BEGIN           INTEGER                        default 0 not null,
constraint PK_PROJECT_STAGE primary key (ID)
);

/*==============================================================*/
/* Table: PROJECT_STAGE_GROUP                                   */
/*==============================================================*/
create table PROJECT_STAGE_GROUP (
ID                   INTEGER                        not null,
CODE                 VARCHAR(20),
NAME                 VARCHAR(50)                    not null,
DESCRIPTION          VARCHAR(255),
constraint PK_PROJECT_STAGE_GROUP primary key (ID)
);

/*==============================================================*/
/* Table: PROJECT_STAGE_LINK                                    */
/*==============================================================*/
create table PROJECT_STAGE_LINK (
ID                   INTEGER                        not null,
PROJECT_STAGE_ID     INTEGER                        not null,
PROJECT_ID           INTEGER                        not null,
PROJECT_STAGE_NAME   VARCHAR(50),
DESCRIPTION          VARCHAR(255),
START_DATE           DATE,
END_DATE             DATE,
ACTUAL_START_DATE    DATE,
ACTUAL_END_DATE      DATE,
constraint PK_PROJECT_STAGE_LINK primary key (ID)
);

/*==============================================================*/
/* Table: PROJECT_STATUS                                        */
/*==============================================================*/
create table PROJECT_STATUS (
ID                   INTEGER                        not null,
CODE                 VARCHAR(20),
NAME                 VARCHAR(50)                    not null,
DESCRIPTION          VARCHAR(255),
IS_START             CHAR(1)                        default 'N' not null,
IS_FINISH            CHAR(1)                        default 'N' not null,
COLOR                CHAR(6),
IS_SYSTEM            CHAR(1)                        default 'N' not null,
constraint PK_PROJECT_STATUS primary key (ID)
);

/*==============================================================*/
/* Table: PROJECT_TYPE                                          */
/*==============================================================*/
create table PROJECT_TYPE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(20),
NAME                 VARCHAR(50)                    not null,
DESCRIPTION          VARCHAR(255),
IS_SYSTEM            CHAR(1)                        default 'N' not null,
constraint PK_PROJECT_TYPE primary key (ID)
);

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
CORRECT_PRICE_TYPE   CHAR(3),
DISCOUNT_PERCENT     NUMERIC(6,2)                   default 0 not null,
MARKUP_PERCENT       NUMERIC(6,2)                   default 0 not null,
IS_PAID              CHAR(1)                        default 'N' not null,
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
/* Table: PURCHASE_ORDER                                        */
/*==============================================================*/
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

/*==============================================================*/
/* Table: PURCHASE_ORDER_ITEM                                   */
/*==============================================================*/
create table PURCHASE_ORDER_ITEM (
ID                   INTEGER                        not null,
PURCHASE_ORDER_ID    INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
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
constraint PK_PURCHASE_ORDER_ITEM primary key (ID)
);

/*==============================================================*/
/* Table: PURCHASE_PLAN                                         */
/*==============================================================*/
create table PURCHASE_PLAN (
ID                   INTEGER                        not null,
PRICE_TYPE_ID        INTEGER,
constraint PK_PURCHASE_PLAN primary key (ID)
);

/*==============================================================*/
/* Table: PURCHASE_PLAN_ITEM                                    */
/*==============================================================*/
create table PURCHASE_PLAN_ITEM (
ID                   INTEGER                        not null,
TAX_ID               INTEGER,
PRODUCT_ID           INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
PURCHASE_PLAN_ID     INTEGER                        not null,
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
constraint PK_PURCHASE_PLAN_ITEM primary key (ID)
);

/*==============================================================*/
/* Table: PURCHASE_SERV                                         */
/*==============================================================*/
create table PURCHASE_SERV (
ID                   INTEGER                        not null,
MTRL_RESPONSIBLE_ID  INTEGER,
WAREHOUSE_ID         INTEGER,
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
/* Table: REGION                                                */
/*==============================================================*/
create table REGION (
ID                   INTEGER                        not null,
COUNTRY_ID           INTEGER                        not null,
NAME                 VARCHAR(50)                    not null,
constraint PK_REGION primary key (ID)
);

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
CORRECT_PRICE_TYPE   CHAR(3),
DISCOUNT_PERCENT     NUMERIC(6,2)                   default 0 not null,
MARKUP_PERCENT       NUMERIC(6,2)                   default 0 not null,
IS_PAID              CHAR(1)                        default 'N' not null,
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
/* Table: SALE_ORDER                                            */
/*==============================================================*/
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

/*==============================================================*/
/* Table: SALE_ORDER_ITEM                                       */
/*==============================================================*/
create table SALE_ORDER_ITEM (
ID                   INTEGER                        not null,
TAX_ID               INTEGER,
SALE_ORDER_ID        INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
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
constraint PK_SALE_ORDER_ITEM primary key (ID)
);

/*==============================================================*/
/* Table: SALE_PLAN                                             */
/*==============================================================*/
create table SALE_PLAN (
ID                   INTEGER                        not null,
PRICE_TYPE_ID        INTEGER,
constraint PK_SALE_PLAN primary key (ID)
);

/*==============================================================*/
/* Table: SALE_PLAN_ITEM                                        */
/*==============================================================*/
create table SALE_PLAN_ITEM (
ID                   INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
TAX_ID               INTEGER,
SALE_PLAN_ID         INTEGER                        not null,
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
constraint PK_SALE_PLAN_ITEM primary key (ID)
);

/*==============================================================*/
/* Table: SALE_SERV                                             */
/*==============================================================*/
create table SALE_SERV (
ID                   INTEGER                        not null,
MTRL_RESPONSIBLE_ID  INTEGER,
WAREHOUSE_ID         INTEGER,
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

/*==============================================================*/
/* Table: SICKLIST_AVERANGE_TYPE                                */
/*==============================================================*/
create table SICKLIST_AVERANGE_TYPE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(50),
SICKLIST_MONTH       INTEGER                        not null,
constraint PK_SICKLIST_AVERANGE_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: SICKLIST_TYPE                                         */
/*==============================================================*/
create table SICKLIST_TYPE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(50),
constraint PK_SICKLIST_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: SICK_TYPE                                             */
/*==============================================================*/
create table SICK_TYPE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(50),
constraint PK_SICK_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: SPECIALITY                                            */
/*==============================================================*/
create table SPECIALITY (
ID                   INTEGER                        not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(150),
PARENT_ID            INTEGER,
constraint PK_SPECIALITY primary key (ID)
);

/*==============================================================*/
/* Table: STORE                                                 */
/*==============================================================*/
create table STORE (
ID                   INTEGER                        not null,
ORGANIZATION_ID      INTEGER                        not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(50),
ADDRESS_STRING       VARCHAR(100),
PARENT_ID            INTEGER,
constraint PK_STORE primary key (ID)
);

/*==============================================================*/
/* Table: STREET_TYPE                                           */
/*==============================================================*/
create table STREET_TYPE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(10),
FULL_NAME            VARCHAR(30),
constraint PK_STREET_TYPE primary key (ID)
);

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

/*==============================================================*/
/* Table: SYS_DAY                                               */
/*==============================================================*/
create table SYS_DAY (
ID                   INTEGER                        not null,
DAY_NUMBER           INTEGER                        not null,
constraint PK_SYS_DAY primary key (ID)
);

/*==============================================================*/
/* Table: SYS_ENTITY                                            */
/*==============================================================*/
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

/*==============================================================*/
/* Table: SYS_ENTITY_TYPE                                       */
/*==============================================================*/
create table SYS_ENTITY_TYPE (
ID                   CHAR(30)                       not null,
CODE                 VARCHAR(30)                    not null,
NAME                 VARCHAR(50)                    not null,
IS_CUSTOM            CHAR(1)                        default 'N' not null,
IS_CUSTOM_ATTRIBUTE  CHAR(1)                        default 'N' not null,
constraint PK_SYS_ENTITY_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: SYS_ENUMERATION                                       */
/*==============================================================*/
create table SYS_ENUMERATION (
ID                   INTEGER                        not null,
ENTITY_ID            CHAR(30)                       not null,
CODE                 VARCHAR(30),
NAME                 VARCHAR(50)                    not null,
DESCRIPTION          VARCHAR(255),
constraint PK_SYS_ENUMERATION primary key (ID)
);

/*==============================================================*/
/* Table: SYS_FILE                                              */
/*==============================================================*/
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

/*==============================================================*/
/* Table: SYS_FILE_STORAGE                                      */
/*==============================================================*/
create table SYS_FILE_STORAGE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(20),
NAME                 VARCHAR(50),
STORAGE_PATH         VARCHAR(255),
constraint PK_SYS_FILE_STORAGE primary key (ID)
);

/*==============================================================*/
/* Table: SYS_FILE_TYPE                                         */
/*==============================================================*/
create table SYS_FILE_TYPE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(20),
NAME                 VARCHAR(50),
FILE_EXT             VARCHAR(50),
constraint PK_SYS_FILE_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: SYS_IMAGE                                             */
/*==============================================================*/
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

/*==============================================================*/
/* Table: SYS_IMAGE_STORAGE                                     */
/*==============================================================*/
create table SYS_IMAGE_STORAGE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(20),
NAME                 VARCHAR(50),
STORAGE_PATH         VARCHAR(255),
constraint PK_SYS_IMAGE_STORAGE primary key (ID)
);

/*==============================================================*/
/* Table: SYS_INFO                                              */
/*==============================================================*/
create table SYS_INFO (
ID                   INTEGER                        not null,
ORGANIZATION_ID      INTEGER                        not null,
IS_INIT              CHAR(1)                        default 'N' not null,
APP_VERSION          VARCHAR(20)                    not null,
DB_VERSION           VARCHAR(20)                    not null,
APP_BUILD            VARCHAR(8)                     not null,
DB_BUILD             VARCHAR(8)                     not null,
constraint PK_SYS_INFO primary key (ID)
);

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

/*==============================================================*/
/* Table: SYS_MONTH                                             */
/*==============================================================*/
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

/*==============================================================*/
/* Table: SYS_PERMISSION                                        */
/*==============================================================*/
create table SYS_PERMISSION (
ID                   INTEGER                        not null,
SECURE_OBJECT_ID     INTEGER                        not null,
ROLE_ID              INTEGER                        not null,
IS_READ              CHAR(1)                        default 'N' not null,
IS_WRITE             CHAR(1)                        default 'N' not null,
IS_EXEC              CHAR(1)                        default 'N' not null,
IS_TYPE_READ         CHAR(1)                        default 'N' not null,
IS_TYPE_WRITE        CHAR(1)                        default 'N' not null,
constraint PK_SYS_PERMISSION primary key (ID)
);

/*==============================================================*/
/* Table: SYS_PREFERENCE                                        */
/*==============================================================*/
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

/*==============================================================*/
/* Table: SYS_PROPERTY                                          */
/*==============================================================*/
create table SYS_PROPERTY (
ID                   INTEGER                        not null,
PROPERTY_NAME        VARCHAR(50)                    not null,
PROPERTY_VALUE       VARCHAR(255),
constraint PK_SYS_PROPERTY primary key (ID)
);

/*==============================================================*/
/* Table: SYS_QUARTER                                           */
/*==============================================================*/
create table SYS_QUARTER (
ID                   INTEGER                        not null,
QUARTER_NUMBER       INTEGER                        not null,
NAME                 CHAR(3)                        not null,
constraint PK_SYS_QUARTER primary key (ID)
);

/*==============================================================*/
/* Table: SYS_ROLE                                              */
/*==============================================================*/
create table SYS_ROLE (
ID                   INTEGER                        not null,
NAME                 VARCHAR(50)                    not null,
NOTE                 VARCHAR(255),
DEF_INTERFACE_ID     CHAR(30),
constraint PK_SYS_ROLE primary key (ID)
);

/*==============================================================*/
/* Table: SYS_ROLE_INTERFACE                                    */
/*==============================================================*/
create table SYS_ROLE_INTERFACE (
ID                   INTEGER                        not null,
ROLE_ID              INTEGER                        not null,
INTERFACE_ID         VARCHAR(30)                    not null,
constraint PK_SYS_ROLE_INTERFACE primary key (ID)
);

/*==============================================================*/
/* Table: SYS_SECURE_OBJECT                                     */
/*==============================================================*/
create table SYS_SECURE_OBJECT (
ID                   INTEGER                        not null,
OBJECT_ID            VARCHAR(50)                    not null,
CODE                 VARCHAR(50),
NAME                 VARCHAR(50),
OBJECT_TYPE          VARCHAR(30)                    not null,
constraint PK_SYS_SECURE_OBJECT primary key (ID)
);

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

/*==============================================================*/
/* Table: SYS_USER                                              */
/*==============================================================*/
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

/*==============================================================*/
/* Table: SYS_USER_ORG                                          */
/*==============================================================*/
create table SYS_USER_ORG (
ID                   INTEGER                        not null,
ORGANIZATION_ID      INTEGER                        not null,
USER_ID              INTEGER                        not null,
constraint PK_SYS_USER_ORG primary key (ID)
);

/*==============================================================*/
/* Table: SYS_USER_ROLE                                         */
/*==============================================================*/
create table SYS_USER_ROLE (
ID                   INTEGER                        not null,
USER_ID              INTEGER                        not null,
ROLE_ID              INTEGER                        not null,
constraint PK_SYS_USER_ROLE primary key (ID)
);

/*==============================================================*/
/* Table: SYS_VARIABLE                                          */
/*==============================================================*/
create table SYS_VARIABLE (
ID                   INTEGER                        not null,
DATA_TYPE_ID         CHAR(30)                       not null,
VALUE_ENTITY_ID      CHAR(30),
CODE                 VARCHAR(50)                    not null,
NAME                 VARCHAR(100)                   not null,
DESCRIPTION          VARCHAR(255),
STRING_VALUE         VARCHAR(255),
INTEGER_VALUE        INTEGER,
FLOAT_VALUE          FLOAT,
DATE_VALUE           DATE,
IS_ENABLE            CHAR(1)                        default 'Y' not null,
IS_SYSTEM            CHAR(1)                        default 'N' not null,
constraint PK_SYS_VARIABLE primary key (ID)
);

/*==============================================================*/
/* Table: TASK                                                  */
/*==============================================================*/
create table TASK (
ID                   INTEGER                        not null,
PROJECT_STAGE_ID     INTEGER,
DOCUMENT_ID          INTEGER,
RESPONSIBLE_ID       INTEGER                        not null,
PROJECT_ID           INTEGER,
REPORTER_ID          INTEGER                        not null,
ORGANIZATION_ID      INTEGER                        not null,
PARTNER_ID           INTEGER,
TASK_PRIORITY_ID     INTEGER,
TASK_STATUS_ID       INTEGER                        not null,
TASK_TYPE_ID         INTEGER                        not null,
TASK_RESULT_ID       INTEGER,
CREATE_TIMESTAMP     DATETIME,
CREATE_USER_ID       INTEGER,
UPDATE_TIMESTAMP     DATETIME,
UPDATE_USER_ID       INTEGER,
TASK_NO              VARCHAR(20),
NAME                 VARCHAR(50),
START_DATE_TIME     DATETIME,
END_DATE_TIME     DATETIME,
ACTUAL_END_DATE_TIME     DATETIME,
PERCENT_COMPLETE     NUMERIC(6,2)                   default 0 not null,
REMINDER_DATE_TIME     DATETIME,
IS_APOINTMENT        CHAR(1)                        default 'N' not null,
RESULT_DETAILS       VARCHAR(50),
WORK_DAYS            INTEGER                        default 0 not null,
WORK_HOURS           INTEGER                        default 0 not null,
WORK_MINUTES         INTEGER                        default 0 not null,
ACTUAL_DAYS          INTEGER                        default 0 not null,
ACTUAL_HOURS         INTEGER                        default 0 not null,
ACTUAL_MINUTES       INTEGER                        default 0 not null,
WORK_COST            NUMERIC(12,2)                  default 0 not null,
DESCRIPTION          VARCHAR(255),
constraint PK_TASK primary key (ID)
);

/*==============================================================*/
/* Table: TASK_CONTACT_LINK                                     */
/*==============================================================*/
create table TASK_CONTACT_LINK (
ID                   INTEGER                        not null,
TASK_ID              INTEGER                        not null,
CONTACT_ID           INTEGER                        not null,
TASK_ROLE_ID         INTEGER                        not null,
DESCRIPTION          VARCHAR(255),
constraint PK_TASK_CONTACT_LINK primary key (ID)
);

/*==============================================================*/
/* Table: TASK_CONTEXT                                          */
/*==============================================================*/
create table TASK_CONTEXT (
ID                   INTEGER                        not null,
PROJECT_ID           INTEGER,
RESPONSIBLE_ID       INTEGER,
TASK_PRIORITY_ID     INTEGER,
TASK_TYPE_ID         INTEGER,
TASK_RESULT_ID       INTEGER,
TASK_STATUS_ID       INTEGER,
PARTNER_ID           INTEGER,
constraint PK_TASK_CONTEXT primary key (ID)
);

/*==============================================================*/
/* Table: TASK_PRIORITY                                         */
/*==============================================================*/
create table TASK_PRIORITY (
ID                   INTEGER                        not null,
CODE                 VARCHAR(20),
NAME                 VARCHAR(50)                    not null,
ORDER_NUMBER         INTEGER                        default 0 not null,
IS_SYSTEM            CHAR(1)                        default 'N' not null,
constraint PK_TASK_PRIORITY primary key (ID)
);

/*==============================================================*/
/* Table: TASK_RESULT                                           */
/*==============================================================*/
create table TASK_RESULT (
ID                   INTEGER                        not null,
TASK_TYPE_ID         INTEGER                        not null,
CODE                 VARCHAR(20),
NAME                 VARCHAR(50)                    not null,
DESCRIPTION          VARCHAR(255),
constraint PK_TASK_RESULT primary key (ID)
);

/*==============================================================*/
/* Table: TASK_ROLE                                             */
/*==============================================================*/
create table TASK_ROLE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(20),
NAME                 VARCHAR(50)                    not null,
DESCRIPTION          VARCHAR(255),
constraint PK_TASK_ROLE primary key (ID)
);

/*==============================================================*/
/* Table: TASK_STATUS                                           */
/*==============================================================*/
create table TASK_STATUS (
ID                   INTEGER                        not null,
CODE                 VARCHAR(20),
NAME                 VARCHAR(50)                    not null,
DESCRIPTION          VARCHAR(255),
IS_FINISH            CHAR(1)                        default 'N' not null,
IS_START             CHAR(1)                        default 'N' not null,
COLOR                CHAR(6),
IS_SYSTEM            CHAR(1)                        default 'N' not null,
constraint PK_TASK_STATUS primary key (ID)
);

/*==============================================================*/
/* Table: TASK_TYPE                                             */
/*==============================================================*/
create table TASK_TYPE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(20),
NAME                 VARCHAR(50),
DESCRIPTION          VARCHAR(255),
IS_SYSTEM            CHAR(1)                        default 'N' not null,
constraint PK_TASK_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: TASK_WORKER_LINK                                      */
/*==============================================================*/
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

/*==============================================================*/
/* Table: TAX                                                   */
/*==============================================================*/
create table TAX (
ID                   INTEGER                        not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(50),
TAX_PERCENT          NUMERIC(5,2),
AMOUNT               NUMERIC(10,2),
constraint PK_TAX primary key (ID)
);

/*==============================================================*/
/* Table: TAXPRINT_TYPE                                         */
/*==============================================================*/
create table TAXPRINT_TYPE (
ID                   INTEGER                        not null,
NAME                 VARCHAR(50),
constraint PK_TAXPRINT_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: TEMPLATE_ENTRY                                        */
/*==============================================================*/
create table TEMPLATE_ENTRY (
ID                   INTEGER                        not null,
FINANCE_DOCUMENT_TYPE_ID INTEGER                        not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(50),
NOTE                 VARCHAR(255),
ENTRY_CLASS          VARCHAR(128),
constraint PK_TEMPLATE_ENTRY primary key (ID)
);

/*==============================================================*/
/* Table: TEMPLATE_ENTRY_ITEM                                   */
/*==============================================================*/
create table TEMPLATE_ENTRY_ITEM (
ID                   INTEGER                        not null,
DEBIT_LEDACC_ID      INTEGER,
CREDIT_LEDACC_ID     INTEGER,
TEMPLATE_ENTRY_ID    INTEGER                        not null,
DEBIT_LEDACC_EXP     VARCHAR(64),
CREDIT_LEDACC_EXP    VARCHAR(64),
AMOUNT_EXP           VARCHAR(255),
DEBIT_OBJECT_EXP     VARCHAR(64),
CREDIT_OBJECT_EXP    VARCHAR(64),
CONTENT              VARCHAR(64),
ENTRY_ITEM_CLASS     VARCHAR(128),
constraint PK_TEMPLATE_ENTRY_ITEM primary key (ID)
);

/*==============================================================*/
/* Table: UNIT                                                  */
/*==============================================================*/
create table UNIT (
ID                   INTEGER                        not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(10)                    not null,
NAME_EN              VARCHAR(10),
FULL_NAME            VARCHAR(25),
constraint PK_UNIT primary key (ID)
);

/*==============================================================*/
/* Table: VACATION_AVERANGE_TYPE                                */
/*==============================================================*/
create table VACATION_AVERANGE_TYPE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(50),
VACATION_MONTH       INTEGER                        not null,
constraint PK_VACATION_AVERANGE_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: VACATION_CALCULATE                                    */
/*==============================================================*/
create table VACATION_CALCULATE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(50),
constraint PK_VACATION_CALCULATE primary key (ID)
);

/*==============================================================*/
/* Table: VACATION_TYPE                                         */
/*==============================================================*/
create table VACATION_TYPE (
ID                   INTEGER                        not null,
CODE                 VARCHAR(10),
NAME                 VARCHAR(50),
constraint PK_VACATION_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: WAREHOUSE                                             */
/*==============================================================*/
create table WAREHOUSE (
ID                   INTEGER                        not null,
constraint PK_WAREHOUSE primary key (ID)
);

/*==============================================================*/
/* Table: WAREHOUSE_ENTITY                                      */
/*==============================================================*/
create table WAREHOUSE_ENTITY (
ID                   INTEGER                        not null,
ENTITY_ID            CHAR(30)                       not null,
constraint PK_WAREHOUSE_ENTITY primary key (ID)
);

/*==============================================================*/
/* Table: WAREHOUSE_MOVE                                        */
/*==============================================================*/
create table WAREHOUSE_MOVE (
ID                   INTEGER                        not null,
MTRL_RESPONSIBLE_ID  INTEGER,
OWNER_ID             INTEGER                        not null,
WAREHOUSE_ID         INTEGER                        not null,
MOVE_TYPE            VARCHAR(20),
constraint PK_WAREHOUSE_MOVE primary key (ID)
);

/*==============================================================*/
/* Table: WEB                                                   */
/*==============================================================*/
create table WEB (
ID                   INTEGER                        not null,
CONTACTABLE_ID       INTEGER                        not null,
URL                  VARCHAR(255),
NOTE                 VARCHAR(255),
constraint PK_WEB primary key (ID)
);

