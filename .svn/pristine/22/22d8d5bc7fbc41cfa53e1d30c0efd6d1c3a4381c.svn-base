
/*==============================================================*/
/* Firebird                                                     */
/* http://www.firebirdsql.org                                   */
/*==============================================================*/
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
CREATE_TIMESTAMP     TIMESTAMP,
CREATE_USER_ID       INTEGER,
UPDATE_TIMESTAMP     TIMESTAMP,
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
CREATE_TIMESTAMP     TIMESTAMP,
CREATE_USER_ID       INTEGER,
UPDATE_TIMESTAMP     TIMESTAMP,
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
START_DATE_TIME     TIMESTAMP                           not null,
END_DATE_TIME     TIMESTAMP,
REMINDER_DATE_TIME     TIMESTAMP,
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
EVENT_DATE_TIME     TIMESTAMP                           not null,
REMINDER_DATE_TIME     TIMESTAMP,
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
NOTE_DATE_TIME     TIMESTAMP                           not null,
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
EVENT_DATE_TIME     TIMESTAMP,
REMINDER_DATE_TIME     TIMESTAMP,
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
CREATE_TIMESTAMP     TIMESTAMP,
CREATE_USER_ID       INTEGER,
UPDATE_TIMESTAMP     TIMESTAMP,
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
CREATE_TIMESTAMP     TIMESTAMP,
CREATE_USER_ID       INTEGER,
UPDATE_TIMESTAMP     TIMESTAMP,
UPDATE_USER_ID       INTEGER,
TASK_NO              VARCHAR(20),
NAME                 VARCHAR(50),
START_DATE_TIME     TIMESTAMP,
END_DATE_TIME     TIMESTAMP,
ACTUAL_END_DATE_TIME     TIMESTAMP,
PERCENT_COMPLETE     NUMERIC(6,2)                   default 0 not null,
REMINDER_DATE_TIME     TIMESTAMP,
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

/*==============================================================*/
/* FIREBIRD                                                     */
/*==============================================================*/



/* CREATE SEQUENCES */ 

 CREATE GENERATOR BUSINESSABLE_SEQUENCE;
 SET GENERATOR  BUSINESSABLE_SEQUENCE TO 1111;

 CREATE GENERATOR REGISTER_SEQUENCE;
 SET GENERATOR  REGISTER_SEQUENCE TO 1;






alter table ADDRESS
   add constraint FK_ADDRESS_ADDRESS_A_ADDRESS_ foreign key (ADDRESS_TYPE_ID)
      references ADDRESS_TYPE (ID);

alter table ADDRESS
   add constraint FK_ADDRESS_ADDRESS_A_APARTMEN foreign key (APARTMENT_TYPE_ID)
      references APARTMENT_TYPE (ID);

alter table ADDRESS
   add constraint FK_ADDRESS_ADDRESS_C_CITY foreign key (CITY_ID)
      references CITY (ID);

alter table ADDRESS
   add constraint FK_ADDRESS_ADDRESS_C_CONTACTA foreign key (CONTACTABLE_ID)
      references CONTACTABLE (ID);

alter table ADDRESS
   add constraint FK_ADDRESS_ADDRESS_L_LOCALITY foreign key (LOCALITY_ID)
      references LOCALITY (ID);

alter table ADDRESS
   add constraint FK_ADDRESS_ADDRESS_S_STREET_T foreign key (STREET_TYPE_ID)
      references STREET_TYPE (ID);

alter table ASSET
   add constraint FK_ASSET_ASS_ASS_C_ASSET_CL foreign key (ASSET_CLASS_ID)
      references ASSET_CLASS (ID);

alter table BANK_ACCOUNT
   add constraint FK_BANK_ACC_BANKACC_B_BANK foreign key (BANK_ID)
      references BANK (ID);

alter table BANK_ACCOUNT
   add constraint FK_BANK_ACC_BANKACC_P_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table BANK_CONTEXT
   add constraint FK_BANK_CON_BNK_CTX_I_PARTNER foreign key (INCOME_PARTNER_ID)
      references PARTNER (ID);

alter table BANK_CONTEXT
   add constraint FK_BANK_CON_BNK_CTX_O_PARTNER foreign key (OUTCOME_PARTNER_ID)
      references PARTNER (ID);

alter table BANK_CONTEXT
   add constraint FK_BANK_CON_BNK_CTX_P_PAYMENT_ foreign key (PAYMENT_TYPE_ID)
      references PAYMENT_TYPE (ID);

alter table BANK_CONTEXT
   add constraint FK_BANK_CON_BNK_CTX_P_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table BANK_CONTEXT
   add constraint FK_BANK_CON_BNK_CTX_T_TAXPRINT foreign key (TAXPRINT_TYPE_ID)
      references TAXPRINT_TYPE (ID);

alter table BUSINESSABLE
   add constraint FK_BUSINESS_BSS_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table BUSINESSABLE
   add constraint FK_BUSINESS_BUSINESS__SYS_ENTI foreign key (ENTITY_ID)
      references SYS_ENTITY (ID);

alter table BUSINESSABLE_ENTITY
   add constraint FK_BUSINESS_BUS_ENTIT_SYS_ENTI foreign key (ENTITY_ID)
      references SYS_ENTITY (ID);

alter table BUSINESSABLE_REGISTER
   add constraint FK_BUSINESS_BSREG_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table BUSINESSABLE_REGISTER
   add constraint FK_BUSINESS_BSREG_PER_PERIOD foreign key (PERIOD_ID)
      references PERIOD (ID);

alter table BUSINESSABLE_REGISTER
   add constraint FK_BUSINESS_REGISTER__BUSINESS foreign key (BUSINESSABLE_ID)
      references BUSINESSABLE (ID);

alter table CASH_DOCUMENT_LINK
   add constraint FK_CASH_DOC_CCSH_DOC__DOCUMENT foreign key (CASH_DOCUMENT_ID)
      references DOCUMENT (ID);

alter table CASH_DOCUMENT_LINK
   add constraint FK_CASH_DOC_CRSN_DOC__DOCUMENT foreign key (REASON_DOCUMENT_ID)
      references DOCUMENT (ID);

alter table CASH_INCOME
   add constraint FK_CASH_INC_CASH_INC__CONTRACT foreign key (CONTRACTOR_ID)
      references CONTRACTOR (ID);

alter table CASH_OUTCOME
   add constraint FK_CASH_OUT_CASH_OUT__CONTRACT foreign key (CONTRACTOR_ID)
      references CONTRACTOR (ID);

alter table CONTACT
   add constraint FK_CONTACT_CONTACT_R_CONTACT foreign key (RESPONSIBLE_ID)
      references CONTACT (ID);

alter table CONTACT
   add constraint FK_CONTACT_DEPARTMEN_DEPARTME foreign key (DEPARTMENT_ID)
      references DEPARTMENT (ID);

alter table CONTACT
   add constraint FK_CONTACT_ORG_CONTA_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table CONTACT
   add constraint FK_CONTACT_POSITION__JOB_POSI foreign key (POSITION_ID)
      references JOB_POSITION (ID);

alter table CONTACT
   add constraint FK_CONTACT_PRT_CONTA_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table CONTACT
   add constraint FK_CONTACT_TYPE_CONT_CONTACT_ foreign key (CONTACT_TYPE_ID)
      references CONTACT_TYPE (ID);

alter table CONTACTABLE
   add constraint FK_CONTACTA_CONTACTAB_SYS_ENTI foreign key (ENTITY_ID)
      references SYS_ENTITY (ID);

alter table CONTACTABLE
   add constraint FK_CONTACTA_CONT_ADD_ADDRESS foreign key (ADDRESS_ID)
      references ADDRESS (ID);

alter table CONTACTABLE
   add constraint FK_CONTACTA_CONT_EML_EMAIL foreign key (EMAIL_ID)
      references EMAIL (ID);

alter table CONTACTABLE
   add constraint FK_CONTACTA_CONT_PHO_PHONE foreign key (PHONE_ID)
      references PHONE (ID);

alter table CONTACTABLE
   add constraint FK_CONTACTA_CONT_WEB_WEB foreign key (WEB_ID)
      references WEB (ID);

alter table CONTACTABLE_ENTITY
   add constraint FK_CONTACTA_CNT_ENTIT_SYS_ENTI foreign key (ENTITY_ID)
      references SYS_ENTITY (ID);

alter table CONTACT_CONTEXT
   add constraint FK_CONTACT__CNT_CTX_A_ADDRESS_ foreign key (ADDRESS_TYPE_ID)
      references ADDRESS_TYPE (ID);

alter table CONTACT_CONTEXT
   add constraint FK_CONTACT__CNT_CTX_C_CONTACT_ foreign key (CONTACT_TYPE_ID)
      references CONTACT_TYPE (ID);

alter table CONTACT_CONTEXT
   add constraint FK_CONTACT__CNT_CTX_P_PHONE_TY foreign key (PHONE_TYPE_ID)
      references PHONE_TYPE (ID);

alter table CONTACT_CONTEXT
   add constraint FK_CONTACT__CNT_CTX_R_EMPLOYEE foreign key (RESPONSIBLE_ID)
      references EMPLOYEE (ID);

alter table CONTRACT
   add constraint FK_CONTRACT_ORG_CR_BA_BANK_ACC foreign key (ORGANIZATION_BANK_ACCOUNT_ID)
      references BANK_ACCOUNT (ID);

alter table CONTRACT
   add constraint FK_CONTRACT_ORG_CR_CN_CONTACT foreign key (ORGANIZATION_CONTACT_ID)
      references CONTACT (ID);

alter table CONTRACT
   add constraint FK_CONTRACT_PRT_CR_BA_BANK_ACC foreign key (PARTNER_BANK_ACCOUNT_ID)
      references BANK_ACCOUNT (ID);

alter table CONTRACT
   add constraint FK_CONTRACT_PRT_CR_CN_CONTACT foreign key (PARTNER_CONTACT_ID)
      references CONTACT (ID);

alter table CONTRACTOR_MOVE
   add constraint FK_CONTRACT_CTR_MOVE__CONTRACT foreign key (CONTRACTOR_ID)
      references CONTRACTOR (ID);

alter table CONTRACTOR_MOVE
   add constraint FK_CONTRACT_CTR_MOVE__FINANCE_ foreign key (OWNER_ID)
      references FINANCE_DOCUMENT (ID);

alter table CURRENCY_RATE
   add constraint FK_CURRENCY_BCR_CUR_CURRENCY foreign key (BASE_CURRENCY_ID)
      references CURRENCY (ID);

alter table CURRENCY_RATE
   add constraint FK_CURRENCY_CR_CUR_CURRENCY foreign key (CURRENCY_ID)
      references CURRENCY (ID);

alter table DEPARTMENT
   add constraint FK_DEPARTME_DEP_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table DISTRICT
   add constraint FK_DISTRICT_DISTRICT__REGION foreign key (REGION_ID)
      references REGION (ID);

alter table DOCUMENT
   add constraint FK_DOCUMENT_DOC_CONTR_CONTRACT foreign key (CONTRACT_ID)
      references CONTRACT (ID);

alter table DOCUMENT
   add constraint FK_DOCUMENT_DOC_DEP_DEPARTME foreign key (DEPARTMENT_ID)
      references DEPARTMENT (ID);

alter table DOCUMENT
   add constraint FK_DOCUMENT_DOC_DOC_T_DOCUMENT foreign key (DOCUMENT_TYPE_ID)
      references DOCUMENT_TYPE (ID);

alter table DOCUMENT
   add constraint FK_DOCUMENT_DOC_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table DOCUMENT
   add constraint FK_DOCUMENT_DOC_PARTN_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table DOCUMENT
   add constraint FK_DOCUMENT_DOC_PERIO_PERIOD foreign key (PERIOD_ID)
      references PERIOD (ID);

alter table DOCUMENT
   add constraint FK_DOCUMENT_DOC_PRJ_PROJECT foreign key (PROJECT_ID)
      references PROJECT (ID);

alter table DOCUMENT
   add constraint FK_DOCUMENT_DOC_RESP_CONTACT foreign key (RESPONSIBLE_ID)
      references CONTACT (ID);

alter table DOCUMENT
   add constraint FK_DOCUMENT_DOC_STATU_DOCUMENT foreign key (DOCUMENT_STATUS_ID)
      references DOCUMENT_STATUS (ID);

alter table DOCUMENT
   add constraint FK_DOCUMENT_DOC_USR_SYS_USER foreign key (USER_ID)
      references SYS_USER (ID);

alter table DOCUMENT
   add constraint FK_DOCUMENT_REASON_DO_DOCUMENT foreign key (REASON_DOCUMENT_ID)
      references DOCUMENT (ID);

alter table DOCUMENT_FILE
   add constraint FK_DOCUMENT_DF_DOC_TY_DOCUMENT foreign key (DOCUMENT_TYPE_ID)
      references DOCUMENT_TYPE (ID);

alter table DOCUMENT_FILE
   add constraint FK_DOCUMENT_DF_SF_STO_SYS_FILE foreign key (FILE_STORAGE_ID)
      references SYS_FILE_STORAGE (ID);

alter table DOCUMENT_FILE
   add constraint FK_DOCUMENT_DF_SF_TYP_SYS_FILE foreign key (FILE_TYPE_ID)
      references SYS_FILE_TYPE (ID);

alter table DOCUMENT_FILE
   add constraint FK_DOCUMENT_DOC_FILE__DOCUMENT foreign key (DOCUMENT_ID)
      references DOCUMENT (ID);

alter table DOCUMENT_IMAGE
   add constraint FK_DOCUMENT_DI_DOC_TY_DOCUMENT foreign key (DOCUMENT_TYPE_ID)
      references DOCUMENT_TYPE (ID);

alter table DOCUMENT_IMAGE
   add constraint FK_DOCUMENT_DI_SF_TYP_SYS_FILE foreign key (FILE_TYPE_ID)
      references SYS_FILE_TYPE (ID);

alter table DOCUMENT_IMAGE
   add constraint FK_DOCUMENT_DI_SI_STO_SYS_IMAG foreign key (IMAGE_STORAGE_ID)
      references SYS_IMAGE_STORAGE (ID);

alter table DOCUMENT_IMAGE
   add constraint FK_DOCUMENT_DOC_IMAGE_DOCUMENT foreign key (DOCUMENT_ID)
      references DOCUMENT (ID);

alter table DOCUMENT_RELATION
   add constraint FK_DOCUMENT_DR_C_DOCUMENT foreign key (CHILD_TYPE_ID)
      references DOCUMENT_TYPE (ID);

alter table DOCUMENT_RELATION
   add constraint FK_DOCUMENT_DR_P_DOCUMENT foreign key (PARENT_TYPE_ID)
      references DOCUMENT_TYPE (ID);

alter table DOCUMENT_STATUS
   add constraint FK_DOCUMENT_DOC_STAT__DOCUMENT foreign key (DOCUMENT_TYPE_ID)
      references DOCUMENT_TYPE (ID);

alter table DOCUMENT_TYPE
   add constraint FK_DOCUMENT_DOCUMENT__SYS_ENTI foreign key (ENTITY_ID)
      references SYS_ENTITY (ID);

alter table EMAIL
   add constraint FK_EMAIL_EMAIL_CON_CONTACTA foreign key (CONTACTABLE_ID)
      references CONTACTABLE (ID);

alter table EMPLOYEE
   add constraint FK_EMPLOYEE_EMP_DEP_DEPARTME foreign key (DEPARTMENT_ID)
      references DEPARTMENT (ID);

alter table EMPLOYEE
   add constraint FK_EMPLOYEE_EMP_ECAT_EMPLOYEE foreign key (EMPLOYEE_CATEGORY_ID)
      references EMPLOYEE_CATEGORY (ID);

alter table EMPLOYEE
   add constraint FK_EMPLOYEE_EMP_LA_LEDGER_A foreign key (LEDGER_ACCOUNT_ID)
      references LEDGER_ACCOUNT (ID);

alter table EMPLOYEE
   add constraint FK_EMPLOYEE_EMP_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table EMPLOYEE
   add constraint FK_EMPLOYEE_EMP_PFORM_PAYROLL_ foreign key (PAYROLL_FORM_ID)
      references PAYROLL_FORM (ID);

alter table EMPLOYEE
   add constraint FK_EMPLOYEE_EMP_POS_JOB_POSI foreign key (POSITION_ID)
      references JOB_POSITION (ID);

alter table EMPLOYEE
   add constraint FK_EMPLOYEE_EMP_PRS_PERSON foreign key (PERSON_ID)
      references PERSON (ID);

alter table EMPLOYEE
   add constraint FK_EMPLOYEE_EMP_RANK_EMPLOYEE foreign key (EMPLOYEE_RANK_ID)
      references EMPLOYEE_RANK (ID);

alter table EMPLOYEE_DISCHARGE
   add constraint FK_EMPLOYEE_EMPDIS_DT_DISCHARG foreign key (DISCHARGE_TYPE_ID)
      references DISCHARGE_TYPE (ID);

alter table EMPLOYEE_DISCHARGE
   add constraint FK_EMPLOYEE_EMP_DIS_EMPLOYEE foreign key (EMPLOYEE_ID)
      references EMPLOYEE (ID);

alter table EMPLOYEE_MOVE
   add constraint FK_EMPLOYEE_EMP_MOVE__EMPLOYEE foreign key (EMPLOYEE_ID)
      references EMPLOYEE (ID);

alter table EMPLOYEE_MOVE
   add constraint FK_EMPLOYEE_EMP_MOVE__FINANCE_ foreign key (OWNER_ID)
      references FINANCE_DOCUMENT (ID);

alter table EMPLOYEE_PAYROLL
   add constraint FK_EMPLOYEE_EMPPAY_EM_EMPLOYEE foreign key (EMPLOYEE_ID)
      references EMPLOYEE (ID);

alter table EMPLOYEE_PAYROLL
   add constraint FK_EMPLOYEE_EMPPAY_OR_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table EMPLOYEE_PAYROLL
   add constraint FK_EMPLOYEE_EMPPAY_PA_PAYROLL foreign key (PAYROLL_ID)
      references PAYROLL (ID);

alter table EMPLOYEE_PAYROLL
   add constraint FK_EMPLOYEE_EMPPAY_PE_PERIOD foreign key (PERIOD_ID)
      references PERIOD (ID);

alter table EMPLOYEE_RECEPTION
   add constraint FK_EMPLOYEE_EMPREC_CA_EMPLOYEE foreign key (EMPLOYEE_CATEGORY_ID)
      references EMPLOYEE_CATEGORY (ID);

alter table EMPLOYEE_RECEPTION
   add constraint FK_EMPLOYEE_EMPREC_DE_DEPARTME foreign key (DEPARTMENT_ID)
      references DEPARTMENT (ID);

alter table EMPLOYEE_RECEPTION
   add constraint FK_EMPLOYEE_EMPREC_EM_EMPLOYEE foreign key (EMPLOYEE_RANK_ID)
      references EMPLOYEE_RANK (ID);

alter table EMPLOYEE_RECEPTION
   add constraint FK_EMPLOYEE_EMPREC_PF_PAYROLL_ foreign key (PAYROLL_FORM_ID)
      references PAYROLL_FORM (ID);

alter table EMPLOYEE_RECEPTION
   add constraint FK_EMPLOYEE_EMPREC_PR_PERSON foreign key (PERSON_ID)
      references PERSON (ID);

alter table EMPLOYEE_SICKLIST
   add constraint FK_EMPLOYEE_EMPSIC_EM_EMPLOYEE foreign key (EMPLOYEE_ID)
      references EMPLOYEE (ID);

alter table EMPLOYEE_SICKLIST
   add constraint FK_EMPLOYEE_ESC_SCAT_SICKLIST foreign key (SICKLIST_AVERANGE_TYPE_ID)
      references SICKLIST_AVERANGE_TYPE (ID);

alter table EMPLOYEE_SICKLIST
   add constraint FK_EMPLOYEE_ESC_SCLST_SICKLIST foreign key (SICKLIST_TYPE_ID)
      references SICKLIST_TYPE (ID);

alter table EMPLOYEE_SICKLIST
   add constraint FK_EMPLOYEE_ESC_SCTP_SICK_TYP foreign key (SICK_TYPE_ID)
      references SICK_TYPE (ID);

alter table EMPLOYEE_SICKLIST_AVERANGE
   add constraint FK_EMPLOYEE_EMPSICAVG_EMPLOYEE foreign key (OWNER_ID)
      references EMPLOYEE_SICKLIST (ID);

alter table EMPLOYEE_TOTAL
   add constraint FK_EMPLOYEE_EMPTOT_EM_EMPLOYEE foreign key (EMPLOYEE_ID)
      references EMPLOYEE (ID);

alter table EMPLOYEE_TOTAL
   add constraint FK_EMPLOYEE_EMPTOT_PE_PERIOD foreign key (PERIOD_ID)
      references PERIOD (ID);

alter table EMPLOYEE_VACATION
   add constraint FK_EMPLOYEE_EMPLEA_EM_EMPLOYEE foreign key (EMPLOYEE_ID)
      references EMPLOYEE (ID);

alter table EMPLOYEE_VACATION
   add constraint FK_EMPLOYEE_EV_ADDVCL_VACATION foreign key (ADD_VACATION_CALCULATE_ID)
      references VACATION_CALCULATE (ID);

alter table EMPLOYEE_VACATION
   add constraint FK_EMPLOYEE_EV_VAT_VACATION foreign key (VACATION_AVERANGE_TYPE_ID)
      references VACATION_AVERANGE_TYPE (ID);

alter table EMPLOYEE_VACATION
   add constraint FK_EMPLOYEE_EV_VCL_VACATION foreign key (VACATION_CALCULATE_ID)
      references VACATION_CALCULATE (ID);

alter table EMPLOYEE_VACATION
   add constraint FK_EMPLOYEE_EV_VTP_VACATION foreign key (VACATION_TYPE_ID)
      references VACATION_TYPE (ID);

alter table EMPLOYEE_VACATION_AVERANGE
   add constraint FK_EMPLOYEE_EMPVACAVR_EMPLOYEE foreign key (OWNER_ID)
      references EMPLOYEE_VACATION (ID);

alter table ENTERPRISE_CONTEXT
   add constraint FK_ENTERPRI_SI_CST_PARTNER foreign key (CUSTOMER_ID)
      references PARTNER (ID);

alter table ENTERPRISE_CONTEXT
   add constraint FK_ENTERPRI_SI_IWRH_WAREHOUS foreign key (INCOME_WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table ENTERPRISE_CONTEXT
   add constraint FK_ENTERPRI_SI_OWRH_WAREHOUS foreign key (OUTCOME_WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table ENTERPRISE_CONTEXT
   add constraint FK_ENTERPRI_SI_PRT_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table ENTERPRISE_CONTEXT
   add constraint FK_ENTERPRI_SI_RESP_CONTACT foreign key (RESPONSIBLE_ID)
      references CONTACT (ID);

alter table ENTERPRISE_CONTEXT
   add constraint FK_ENTERPRI_SI_RSP_MTRL_RES foreign key (MTRL_RESPONSIBLE_ID)
      references MTRL_RESPONSIBLE (ID);

alter table ENTERPRISE_CONTEXT
   add constraint FK_ENTERPRI_SI_SPP_PARTNER foreign key (SUPPLIER_ID)
      references PARTNER (ID);

alter table ENTERPRISE_CONTEXT
   add constraint FK_ENTERPRI_SI_WRH_WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table ENTERPRISE_CONTEXT
   add constraint FK_ENTERPRI_SYS_CURRE_CURRENCY foreign key (CURRENCY_ID)
      references CURRENCY (ID);

alter table ENTERPRISE_CONTEXT
   add constraint FK_ENTERPRI_SYS_PERIO_PERIOD foreign key (PERIOD_ID)
      references PERIOD (ID);

alter table ENTERPRISE_CONTEXT
   add constraint FK_ENTERPRI_SYS_TAX_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table ENTERPRISE_CONTEXT
   add constraint FK_ENTERPRI_SYS_UNIT_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table ENTRY_ITEM
   add constraint FK_ENTRY_IT_CDT_ENTRY_LEDGER_A foreign key (CREDIT_LEDGER_ACCOUNT_ID)
      references LEDGER_ACCOUNT (ID);

alter table ENTRY_ITEM
   add constraint FK_ENTRY_IT_CDT_EN_IT_BUSINESS foreign key (CREDIT_OBJECT_ID)
      references BUSINESSABLE (ID);

alter table ENTRY_ITEM
   add constraint FK_ENTRY_IT_DBT_ENTRY_LEDGER_A foreign key (DEBIT_LEDGER_ACCOUNT_ID)
      references LEDGER_ACCOUNT (ID);

alter table ENTRY_ITEM
   add constraint FK_ENTRY_IT_DBT_EN_IT_BUSINESS foreign key (DEBIT_OBJECT_ID)
      references BUSINESSABLE (ID);

alter table ENTRY_ITEM
   add constraint FK_ENTRY_IT_ENTRY_ITE_FINANCE_ foreign key (OWNER_ID)
      references FINANCE_DOCUMENT (ID);

alter table FINANCE_DOCUMENT
   add constraint FK_FINANCE__FINDOC_CU_CURRENCY foreign key (CURRENCY_ID)
      references CURRENCY (ID);

alter table FINANCE_DOCUMENT
   add constraint FK_FINANCE__FINDOC_TA_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table FINANCE_DOCUMENT_TYPE
   add constraint FK_FINANCE__FINDOC_TY_DOCUMENT foreign key (DOCUMENT_TYPE_ID)
      references DOCUMENT_TYPE (ID);

alter table GOODS
   add constraint FK_GOODS_GDS_COUNT_COUNTRY foreign key (COUNTRY_ID)
      references COUNTRY (ID);

alter table GOODS
   add constraint FK_GOODS_GDS_GDSTY_GOODS_TY foreign key (GOODS_TYPE_ID)
      references GOODS_TYPE (ID);

alter table GOODS_INCOME
   add constraint FK_GOODS_IN_GDS_IN_WR_WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table GOODS_INCOME
   add constraint FK_GOODS_IN_GINCOME_R_MTRL_RES foreign key (MTRL_RESPONSIBLE_ID)
      references MTRL_RESPONSIBLE (ID);

alter table GOODS_INCOME_ITEM
   add constraint FK_GOODS_IN_GINCOME_I_GOODS_IN foreign key (GOODS_INCOME_ID)
      references GOODS_INCOME (ID);

alter table GOODS_INCOME_ITEM
   add constraint FK_GOODS_IN_GINCOME_P_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table GOODS_INCOME_ITEM
   add constraint FK_GOODS_IN_GINCOME_T_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table GOODS_INCOME_ITEM
   add constraint FK_GOODS_IN_GINCOME_U_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table GOODS_OUTCOME
   add constraint FK_GOODS_OU_GDS_OUT_W_WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table GOODS_OUTCOME
   add constraint FK_GOODS_OU_GOUTCOME__MTRL_RES foreign key (MTRL_RESPONSIBLE_ID)
      references MTRL_RESPONSIBLE (ID);

alter table GOODS_OUTCOME_ITEM
   add constraint FK_GOODS_OU_GOUTCOME__GOODS_OU foreign key (GOODS_OUTCOME_ID)
      references GOODS_OUTCOME (ID);

alter table GOODS_OUTCOME_ITEM
   add constraint FK_GOODS_OU_GOUTCOME__TAX foreign key (TAX_ID)
      references TAX (ID);

alter table GOODS_OUTCOME_ITEM
   add constraint FK_GOODS_OU_GOUTCOME__UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table GOODS_OUTCOME_ITEM
   add constraint FK_GOODS_OU_GOUTCONE__PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table GOODS_OUTCOME_ITEM
   add constraint FK_GOODS_OU_PR_INS_PRODUCT_ foreign key (PRODUCT_INSTANCE_ID)
      references PRODUCT_INSTANCE (ID);

alter table INVENTORY_INCOME
   add constraint FK_INVENTOR_INVI_RES_MTRL_RES foreign key (MTRL_RESPONSIBLE_ID)
      references MTRL_RESPONSIBLE (ID);

alter table INVENTORY_INCOME
   add constraint FK_INVENTOR_INVI_WRH_WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table INVENTORY_INCOME_ITEM
   add constraint FK_INVENTOR_INVINCI_I_INVENTOR foreign key (INVENTORY_INCOME_ID)
      references INVENTORY_INCOME (ID);

alter table INVENTORY_INCOME_ITEM
   add constraint FK_INVENTOR_INVINCI_P_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table INVENTORY_INCOME_ITEM
   add constraint FK_INVENTOR_INVINCI_T_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table INVENTORY_INCOME_ITEM
   add constraint FK_INVENTOR_INVINCI_U_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table INVENTORY_MOVE
   add constraint FK_INVENTOR_INVM_INCO_MTRL_RES foreign key (INCOME_MTRL_RESPONSIBLE_ID)
      references MTRL_RESPONSIBLE (ID);

alter table INVENTORY_MOVE
   add constraint FK_INVENTOR_INVM_IN_W_WAREHOUS foreign key (INCOME_WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table INVENTORY_MOVE
   add constraint FK_INVENTOR_INVM_OUTC_MTRL_RES foreign key (OUTCOME_MTRL_RESPONSIBLE_ID)
      references MTRL_RESPONSIBLE (ID);

alter table INVENTORY_MOVE
   add constraint FK_INVENTOR_INVM_OUT__WAREHOUS foreign key (OUTCOME_WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table INVENTORY_MOVE_ITEM
   add constraint FK_INVENTOR_INVMI_PRO_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table INVENTORY_MOVE_ITEM
   add constraint FK_INVENTOR_INVMI_TAX_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table INVENTORY_MOVE_ITEM
   add constraint FK_INVENTOR_INVMI_UN_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table INVENTORY_MOVE_ITEM
   add constraint FK_INVENTOR_INVM_ITEM_INVENTOR foreign key (INVENTORY_MOVE_ID)
      references INVENTORY_MOVE (ID);

alter table INVENTORY_OUTCOME
   add constraint FK_INVENTOR_INVO_RES_MTRL_RES foreign key (MTRL_RESPONSIBLE_ID)
      references MTRL_RESPONSIBLE (ID);

alter table INVENTORY_OUTCOME
   add constraint FK_INVENTOR_INVO_WRH_WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table INVENTORY_OUTCOME_ITEM
   add constraint FK_INVENTOR_INVOUTI_I_INVENTOR foreign key (INVENTORY_OUTCOME_ID)
      references INVENTORY_OUTCOME (ID);

alter table INVENTORY_OUTCOME_ITEM
   add constraint FK_INVENTOR_INVOUTI_P_PRODUCT_ foreign key (PRODUCT_INSTANCE_ID)
      references PRODUCT_INSTANCE (ID);

alter table INVENTORY_OUTCOME_ITEM
   add constraint FK_INVENTOR_INVOUTI_T_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table INVENTORY_OUTCOME_ITEM
   add constraint FK_INVENTOR_INVOUTI_U_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table INVENTORY_OUTCOME_ITEM
   add constraint FK_INVENTOR_INVOUTO_P_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table INVENTORY_REST
   add constraint FK_INVENTOR_INVR_RE_MTRL_RES foreign key (MTRL_RESPONSIBLE_ID)
      references MTRL_RESPONSIBLE (ID);

alter table INVENTORY_REST
   add constraint FK_INVENTOR_INVR_WRH_WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table INVENTORY_REST_ITEM
   add constraint FK_INVENTOR_INVRI_TAX_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table INVENTORY_REST_ITEM
   add constraint FK_INVENTOR_INVRI_UN_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table INVENTORY_REST_ITEM
   add constraint FK_INVENTOR_INVR_ITEM_INVENTOR foreign key (INVENTORY_REST_ID)
      references INVENTORY_REST (ID);

alter table INVENTORY_REST_ITEM
   add constraint FK_INVENTOR_INVR_PROD_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table INVENTORY_WRITEOFF
   add constraint FK_INVENTOR_INVW_RE_MTRL_RES foreign key (MTRL_RESPONSIBLE_ID)
      references MTRL_RESPONSIBLE (ID);

alter table INVENTORY_WRITEOFF
   add constraint FK_INVENTOR_INVW_WRH_WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table INVENTORY_WRITEOFF_ITEM
   add constraint FK_INVENTOR_INVWI_TAX_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table INVENTORY_WRITEOFF_ITEM
   add constraint FK_INVENTOR_INVWI_UN_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table INVENTORY_WRITEOFF_ITEM
   add constraint FK_INVENTOR_INVW_ITEM_INVENTOR foreign key (INVENTORY_WRITEOFF_ID)
      references INVENTORY_WRITEOFF (ID);

alter table INVENTORY_WRITEOFF_ITEM
   add constraint FK_INVENTOR_INVW_PROD_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table LEDGER_ACCOUNT
   add constraint FK_LEDGER_A_LA_LA_TYP_LEDGER_A foreign key (LEDGER_ACCOUNT_TYPE_ID)
      references LEDGER_ACCOUNT_TYPE (ID);

alter table LEDGER_ACCOUNT_REGISTER
   add constraint FK_LEDGER_A_LA_REG_LA_LEDGER_A foreign key (LEDGER_ACCOUNT_ID)
      references LEDGER_ACCOUNT (ID);

alter table LEDGER_ACCOUNT_REGISTER
   add constraint FK_LEDGER_A_LA_REG_OR_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table LEDGER_ACCOUNT_REGISTER
   add constraint FK_LEDGER_A_LA_REG_PE_PERIOD foreign key (PERIOD_ID)
      references PERIOD (ID);

alter table LEDGER_ACCOUNT_REST
   add constraint FK_LEDGER_A_LA_REST_L_LEDGER_A foreign key (LEDGER_ACCOUNT_ID)
      references LEDGER_ACCOUNT (ID);

alter table LEDGER_ACCOUNT_REST
   add constraint FK_LEDGER_A_LA_REST_O_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table LEDGER_ACCOUNT_REST
   add constraint FK_LEDGER_A_LA_RES_CU_CURRENCY foreign key (CURRENCY_ID)
      references CURRENCY (ID);

alter table LEDGER_ACCOUNT_REST
   add constraint FK_LEDGER_A_LA_RES_PE_PERIOD foreign key (PERIOD_ID)
      references PERIOD (ID);

alter table LOCALITY
   add constraint FK_LOCALITY_LOCALITY__COUNTRY foreign key (COUNTRY_ID)
      references COUNTRY (ID);

alter table LOCALITY
   add constraint FK_LOCALITY_LOCALITY__DISTRICT foreign key (DISTRICT_ID)
      references DISTRICT (ID);

alter table LOCALITY
   add constraint FK_LOCALITY_LOCALITY__LOCALITY foreign key (LOCALITY_TYPE_ID)
      references LOCALITY_TYPE (ID);

alter table LOCALITY
   add constraint FK_LOCALITY_LOCALITY__REGION foreign key (REGION_ID)
      references REGION (ID);

alter table MTRL_RESPONSIBLE
   add constraint FK_MTRL_RES_RESPONSIB_CONTACT foreign key (CONTACT_ID)
      references CONTACT (ID);

alter table MTRL_RESPONSIBLE
   add constraint FK_MTRL_RES_RESPONSIB_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table MTRL_RESPONSIBLE
   add constraint FK_MTRL_RES_RESPONSIB_WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table PARTNER
   add constraint FK_PARTNER_PARTNER_C_CONTACT foreign key (CONTACT_ID)
      references CONTACT (ID);

alter table PARTNER
   add constraint FK_PARTNER_PARTNER_R_CONTACT foreign key (RESPONSIBLE_ID)
      references CONTACT (ID);

alter table PARTNER
   add constraint FK_PARTNER_PRT_BNK_A_BANK_ACC foreign key (BANK_ACCOUNT_ID)
      references BANK_ACCOUNT (ID);

alter table PARTNER
   add constraint FK_PARTNER_PRT_FP_FORM_PRO foreign key (FORM_PROPERTY_ID)
      references FORM_PROPERTY (ID);

alter table PARTNER
   add constraint FK_PARTNER_PRT_INDS_INDUSTRY foreign key (INDUSTRY_ID)
      references INDUSTRY (ID);

alter table PARTNER
   add constraint FK_PARTNER_PRT_LA_LEDGER_A foreign key (LEDGER_ACCOUNT_ID)
      references LEDGER_ACCOUNT (ID);

alter table PARTNER
   add constraint FK_PARTNER_PRT_PRTG_PARTNER_ foreign key (PARTNER_GROUP_ID)
      references PARTNER_GROUP (ID);

alter table PARTNER_ACTIVITY_TYPE_LINK
   add constraint FK_PARTNER__PRT_ATL_A_ACTIVITY foreign key (ACTIVITY_TYPE_ID)
      references ACTIVITY_TYPE (ID);

alter table PARTNER_ACTIVITY_TYPE_LINK
   add constraint FK_PARTNER__PRT_ATL_P_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table PARTNER_CATEGORY_LINK
   add constraint FK_PARTNER__PCL_PRT_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table PARTNER_CATEGORY_LINK
   add constraint FK_PARTNER__PCL_PRTC_PARTNER_ foreign key (PARTNER_CATEGORY_ID)
      references PARTNER_CATEGORY (ID);

alter table PARTNER_MOVE
   add constraint FK_PARTNER__PRT_MOVE__FINANCE_ foreign key (OWNER_ID)
      references FINANCE_DOCUMENT (ID);

alter table PARTNER_MOVE
   add constraint FK_PARTNER__PRT_MOVE__PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table PARTNER_REGISTER
   add constraint FK_PARTNER__PARTNER_R_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table PARTNER_REGISTER
   add constraint FK_PARTNER__PARTNER_R_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table PARTNER_REGISTER
   add constraint FK_PARTNER__PARTNER_R_PERIOD foreign key (PERIOD_ID)
      references PERIOD (ID);

alter table PARTNER_REST
   add constraint FK_PARTNER__PRTR_CURR_CURRENCY foreign key (CURRENCY_ID)
      references CURRENCY (ID);

alter table PARTNER_REST
   add constraint FK_PARTNER__PRTR_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table PARTNER_REST
   add constraint FK_PARTNER__PRTR_PERI_PERIOD foreign key (PERIOD_ID)
      references PERIOD (ID);

alter table PARTNER_REST
   add constraint FK_PARTNER__PRTR_PRT_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table PAYMENT_DOCUMENT_LINK
   add constraint FK_PAYMENT__PPAY_DOC__DOCUMENT foreign key (PAYMENT_DOCUMENT_ID)
      references DOCUMENT (ID);

alter table PAYMENT_DOCUMENT_LINK
   add constraint FK_PAYMENT__PRSN_DOC__DOCUMENT foreign key (REASON_DOCUMENT_ID)
      references DOCUMENT (ID);

alter table PAYMENT_INCOME
   add constraint FK_PAYMENT__PINCOME_O_BANK_ACC foreign key (ORGANIZATION_BANK_ACCOUNT_ID)
      references BANK_ACCOUNT (ID);

alter table PAYMENT_INCOME
   add constraint FK_PAYMENT__PINCOME_P_BANK_ACC foreign key (PARTNER_BANK_ACCOUNT_ID)
      references BANK_ACCOUNT (ID);

alter table PAYMENT_INCOME
   add constraint FK_PAYMENT__PINCOME_P_PAYMENT_ foreign key (PAYMENT_TYPE_ID)
      references PAYMENT_TYPE (ID);

alter table PAYMENT_INCOME
   add constraint FK_PAYMENT__PINCOME_T_TAXPRINT foreign key (TAXPRINT_TYPE_ID)
      references TAXPRINT_TYPE (ID);

alter table PAYMENT_OUTCOME
   add constraint FK_PAYMENT__PO_ORG_BA_BANK_ACC foreign key (ORGANIZATION_BANK_ACCOUNT_ID)
      references BANK_ACCOUNT (ID);

alter table PAYMENT_OUTCOME
   add constraint FK_PAYMENT__PO_PRT_BA_BANK_ACC foreign key (PARTNER_BANK_ACCOUNT_ID)
      references BANK_ACCOUNT (ID);

alter table PAYMENT_OUTCOME
   add constraint FK_PAYMENT__PO_PTYPE_PAYMENT_ foreign key (PAYMENT_TYPE_ID)
      references PAYMENT_TYPE (ID);

alter table PAYMENT_OUTCOME
   add constraint FK_PAYMENT__PO_TAXPRN_TAXPRINT foreign key (TAXPRINT_TYPE_ID)
      references TAXPRINT_TYPE (ID);

alter table PAYMENT_OUTCOME_TEMPLATE
   add constraint FK_PAYMENT__POT_CRC_CURRENCY foreign key (CURRENCY_ID)
      references CURRENCY (ID);

alter table PAYMENT_OUTCOME_TEMPLATE
   add constraint FK_PAYMENT__POT_DEPAR_DEPARTME foreign key (DEPARTMENT_ID)
      references DEPARTMENT (ID);

alter table PAYMENT_OUTCOME_TEMPLATE
   add constraint FK_PAYMENT__POT_OBA_BANK_ACC foreign key (ORGANIZATION_BANK_ACCOUNT_ID)
      references BANK_ACCOUNT (ID);

alter table PAYMENT_OUTCOME_TEMPLATE
   add constraint FK_PAYMENT__POT_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table PAYMENT_OUTCOME_TEMPLATE
   add constraint FK_PAYMENT__POT_PARTN_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table PAYMENT_OUTCOME_TEMPLATE
   add constraint FK_PAYMENT__POT_PBA_BANK_ACC foreign key (PARTNER_BANK_ACCOUNT_ID)
      references BANK_ACCOUNT (ID);

alter table PAYMENT_OUTCOME_TEMPLATE
   add constraint FK_PAYMENT__POT_PRJ_PROJECT foreign key (PROJECT_ID)
      references PROJECT (ID);

alter table PAYMENT_OUTCOME_TEMPLATE
   add constraint FK_PAYMENT__POT_PT_PAYMENT_ foreign key (PAYMENT_TYPE_ID)
      references PAYMENT_TYPE (ID);

alter table PAYMENT_OUTCOME_TEMPLATE
   add constraint FK_PAYMENT__POT_TAX_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table PAYMENT_OUTCOME_TEMPLATE
   add constraint FK_PAYMENT__POT_TPT_TAXPRINT foreign key (TAXPRINT_TYPE_ID)
      references TAXPRINT_TYPE (ID);

alter table PAYMENT_OUTCOME_TEMPLATE
   add constraint FK_PAYMENT__POT_USER_SYS_USER foreign key (USER_ID)
      references SYS_USER (ID);

alter table PAYROLL
   add constraint FK_PAYROLL_PAY_ALGOR_PAYROLL_ foreign key (PAYROLL_ALGORITM_ID)
      references PAYROLL_ALGORITM (ID);

alter table PAYROLL
   add constraint FK_PAYROLL_PAY_PALGT_PAYROLL_ foreign key (PAYROLL_ALGORITM_TYPE_ID)
      references PAYROLL_ALGORITM_TYPE (ID);

alter table PAYROLL
   add constraint FK_PAYROLL_PAY_PAYGR_PAYROLL_ foreign key (PAYROLL_GROUP_ID)
      references PAYROLL_GROUP (ID);

alter table PAYROLL
   add constraint FK_PAYROLL_PAY_PAYMO_PAYROLL_ foreign key (PAYROLL_MODE_ID)
      references PAYROLL_MODE (ID);

alter table PAYROLL
   add constraint FK_PAYROLL_PAY_PAYTY_PAYROLL_ foreign key (PAYROLL_TYPE_ID)
      references PAYROLL_TYPE (ID);

alter table PAYROLL_ITEM
   add constraint FK_PAYROLL__PAYITEM_O_PAYROLL foreign key (OWNER_ID)
      references PAYROLL (ID);

alter table PAYROLL_ITEM
   add constraint FK_PAYROLL__PAYITEM_P_PAYROLL foreign key (PAYROLL_ID)
      references PAYROLL (ID);

alter table PERIOD
   add constraint FK_PERIOD_PERIOD_PT_PERIOD_T foreign key (PERIOD_TYPE_ID)
      references PERIOD_TYPE (ID);

alter table PERSON
   add constraint FK_PERSON_PC_CRES_COUNTRY foreign key (COUNTRY_RESIDENCE_ID)
      references COUNTRY (ID);

alter table PERSON
   add constraint FK_PERSON_PC_DPSPEC_SPECIALI foreign key (DIPLOMA_SPECIALITY_ID)
      references SPECIALITY (ID);

alter table PERSON
   add constraint FK_PERSON_PC_DT_PERSON_D foreign key (DOCUMENT_TYPE_ID)
      references PERSON_DOCUMENT_TYPE (ID);

alter table PERSON
   add constraint FK_PERSON_PC_FS_FAMILY_S foreign key (FAMILY_STATUS_ID)
      references FAMILY_STATUS (ID);

alter table PERSON
   add constraint FK_PERSON_PC_LAN_LANGUAGE foreign key (LANGUAGE_ID)
      references LANGUAGE (ID);

alter table PERSON
   add constraint FK_PERSON_PC_NTL_COUNTRY foreign key (NATIONALITY_ID)
      references COUNTRY (ID);

alter table PERSON_DOCUMENT
   add constraint FK_PERSON_D_PERSON_DO_PERSON foreign key (PERSON_ID)
      references PERSON (ID);

alter table PERSON_DOCUMENT
   add constraint FK_PERSON_D_PRSDOC_PR_PERSON_D foreign key (PERSON_DOC_TYPE_ID)
      references PERSON_DOCUMENT_TYPE (ID);

alter table PERSON_EDUCATION
   add constraint FK_PERSON_E_PRSEDU_AD_ACADEMIC foreign key (ACADEMIC_DEGREE_ID)
      references ACADEMIC_DEGREE (ID);

alter table PERSON_EDUCATION
   add constraint FK_PERSON_E_PRSEDU_EF_EDUCATIO foreign key (EDUCATION_FORM_ID)
      references EDUCATION_FORM (ID);

alter table PERSON_EDUCATION
   add constraint FK_PERSON_E_PRSEDU_EI_EDUCATIO foreign key (EDUCATION_INSTITUTE_ID)
      references EDUCATION_INSTITUTE (ID);

alter table PERSON_EDUCATION
   add constraint FK_PERSON_E_PRSEDU_ET_EDUCATIO foreign key (EDUCATION_TYPE_ID)
      references EDUCATION_TYPE (ID);

alter table PERSON_EDUCATION
   add constraint FK_PERSON_E_PRSEDU_PR_PERSON foreign key (PERSON_ID)
      references PERSON (ID);

alter table PERSON_FAMILY
   add constraint FK_PERSON_F_PF_PRS_PERSON foreign key (PERSON_ID)
      references PERSON (ID);

alter table PERSON_FAMILY
   add constraint FK_PERSON_F_PRSFAM_FA_FAMILIAR foreign key (FAMILIARITY_ID)
      references FAMILIARITY (ID);

alter table PERSON_JOB
   add constraint FK_PERSON_J_PRSJOB_PR_PERSON foreign key (PERSON_ID)
      references PERSON (ID);

alter table PERSON_LANGUAGE
   add constraint FK_PERSON_L_PRSLAN_LA_LANGUAGE foreign key (LANGUAGE_ID)
      references LANGUAGE (ID);

alter table PERSON_LANGUAGE
   add constraint FK_PERSON_L_PRSLAN_PR_PERSON foreign key (PERSON_ID)
      references PERSON (ID);

alter table PERSON_MILITARY
   add constraint FK_PERSON_M_PERSON_MI_PERSON foreign key (PERSON_ID)
      references PERSON (ID);

alter table PERSON_MILITARY
   add constraint FK_PERSON_M_PM_MR_MILITARY foreign key (MILITARY_RANK_ID)
      references MILITARY_RANK (ID);

alter table PERSON_MILITARY
   add constraint FK_PERSON_M_PM_MS_MILITARY foreign key (MILITARY_STATUS_ID)
      references MILITARY_STATUS (ID);

alter table PERSON_MILITARY
   add constraint FK_PERSON_M_PM_MSPEC_MILITARY foreign key (MILITARY_SPECIALITY_ID)
      references MILITARY_SPECIALITY (ID);

alter table PHONE
   add constraint FK_PHONE_PHONE_CON_CONTACTA foreign key (CONTACTABLE_ID)
      references CONTACTABLE (ID);

alter table PHONE
   add constraint FK_PHONE_PHONE_PHO_PHONE_TY foreign key (PHONE_TYPE_ID)
      references PHONE_TYPE (ID);

alter table PIM_APPOINTMENT
   add constraint FK_PIM_APPO_APPT_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table PIM_APPOINTMENT
   add constraint FK_PIM_APPO_APPT_PR_PIM_APPO foreign key (APPOINTMENT_PRIORITY_ID)
      references PIM_APPOINTMENT_PRIORITY (ID);

alter table PIM_APPOINTMENT
   add constraint FK_PIM_APPO_APPT_PRJ_PROJECT foreign key (PROJECT_ID)
      references PROJECT (ID);

alter table PIM_APPOINTMENT
   add constraint FK_PIM_APPO_APPT_RESP_CONTACT foreign key (RESPONSIBLE_ID)
      references CONTACT (ID);

alter table PIM_APPOINTMENT
   add constraint FK_PIM_APPO_APPT_TYPE_PIM_APPO foreign key (APPOINTMENT_TYPE_ID)
      references PIM_APPOINTMENT_TYPE (ID);

alter table PIM_APPOINTMENT_CONTACT
   add constraint FK_PIM_APPO_APPTC_APP_PIM_APPO foreign key (APPOINTMENT_ID)
      references PIM_APPOINTMENT (ID);

alter table PIM_APPOINTMENT_CONTACT
   add constraint FK_PIM_APPO_APPTC_CNT_CONTACT foreign key (CONTACT_ID)
      references CONTACT (ID);

alter table PIM_EVENT
   add constraint FK_PIM_EVEN_EVN_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table PIM_EVENT
   add constraint FK_PIM_EVEN_EVN_RESP_CONTACT foreign key (RESPONSIBLE_ID)
      references CONTACT (ID);

alter table PIM_NOTE
   add constraint FK_PIM_NOTE_NOTE_USR_SYS_USER foreign key (USER_ID)
      references SYS_USER (ID);

alter table PIM_REMINDER
   add constraint FK_PIM_REMI_RMD_USR_SYS_USER foreign key (USER_ID)
      references SYS_USER (ID);

alter table PRODUCT
   add constraint FK_PRODUCT_DIM_UNT_UNIT foreign key (DIMENSION_UNIT_ID)
      references UNIT (ID);

alter table PRODUCT
   add constraint FK_PRODUCT_PROD_CUR_CURRENCY foreign key (CURRENCY_ID)
      references CURRENCY (ID);

alter table PRODUCT
   add constraint FK_PRODUCT_PROD_LA_LEDGER_A foreign key (LEDGER_ACCOUNT_ID)
      references LEDGER_ACCOUNT (ID);

alter table PRODUCT
   add constraint FK_PRODUCT_PROD_MANU_PARTNER foreign key (MANUFACTURER_ID)
      references PARTNER (ID);

alter table PRODUCT
   add constraint FK_PRODUCT_PROD_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table PRODUCT
   add constraint FK_PRODUCT_PROD_PGRO_PRODUCT_ foreign key (PRODUCT_GROUP_ID)
      references PRODUCT_GROUP (ID);

alter table PRODUCT
   add constraint FK_PRODUCT_PROD_RES_CONTACT foreign key (RESPONSIBLE_ID)
      references CONTACT (ID);

alter table PRODUCT
   add constraint FK_PRODUCT_PROD_SUPP_PARTNER foreign key (SUPPLIER_ID)
      references PARTNER (ID);

alter table PRODUCT
   add constraint FK_PRODUCT_PROD_UNIT_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table PRODUCT
   add constraint FK_PRODUCT_WAR_PRD_U_UNIT foreign key (WARRANTY_PERIOD_UNIT_ID)
      references UNIT (ID);

alter table PRODUCT
   add constraint FK_PRODUCT_WG_UNT_UNIT foreign key (WEIGHT_UNIT_ID)
      references UNIT (ID);

alter table PRODUCT_DETAIL_REGISTER
   add constraint FK_PRODUCT__PDR_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table PRODUCT_DETAIL_REGISTER
   add constraint FK_PRODUCT__PDR_PERIO_PERIOD foreign key (PERIOD_ID)
      references PERIOD (ID);

alter table PRODUCT_DETAIL_REGISTER
   add constraint FK_PRODUCT__PDR_PROD_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table PRODUCT_DETAIL_REGISTER
   add constraint FK_PRODUCT__PDR_RESPO_MTRL_RES foreign key (MTRL_RESPONSIBLE_ID)
      references MTRL_RESPONSIBLE (ID);

alter table PRODUCT_DETAIL_REGISTER
   add constraint FK_PRODUCT__PDR_WAREH_WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table PRODUCT_GROUP
   add constraint FK_PRODUCT__PGROUP_PS_PRODUCT_ foreign key (PRODUCT_SECTION_ID)
      references PRODUCT_SECTION (ID);

alter table PRODUCT_INSTANCE
   add constraint FK_PRODUCT__PRD_INS_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table PRODUCT_MOVE
   add constraint FK_PRODUCT__PROD_MOVE_FINANCE_ foreign key (OWNER_ID)
      references FINANCE_DOCUMENT (ID);

alter table PRODUCT_MOVE
   add constraint FK_PRODUCT__PROD_MOVE_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table PRODUCT_MOVE
   add constraint FK_PRODUCT__PROD_MOVE_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table PRODUCT_PRICE
   add constraint FK_PRODUCT__PPRICE_CU_CURRENCY foreign key (CURRENCY_ID)
      references CURRENCY (ID);

alter table PRODUCT_PRICE
   add constraint FK_PRODUCT__PPRICE_PR_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table PRODUCT_PRICE
   add constraint FK_PRODUCT__PPRICE_PT_PRICE_TY foreign key (PRICE_TYPE_ID)
      references PRICE_TYPE (ID);

alter table PRODUCT_PRICE
   add constraint FK_PRODUCT__PPRICE_UN_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table PRODUCT_REGISTER
   add constraint FK_PRODUCT__GR_PERIOD_PERIOD foreign key (PERIOD_ID)
      references PERIOD (ID);

alter table PRODUCT_REGISTER
   add constraint FK_PRODUCT__PR_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table PRODUCT_REGISTER
   add constraint FK_PRODUCT__PR_PROD_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table PRODUCT_UNIT
   add constraint FK_PRODUCT__PUNIT_PRO_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table PRODUCT_UNIT
   add constraint FK_PRODUCT__PUNIT_UNI_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table PROJECT
   add constraint FK_PROJECT_CURRENCY__CURRENCY foreign key (CURRENCY_ID)
      references CURRENCY (ID);

alter table PROJECT
   add constraint FK_PROJECT_ORG_PROJE_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table PROJECT
   add constraint FK_PROJECT_PRJ_CONTR_CONTRACT foreign key (CONTRACT_ID)
      references CONTRACT (ID);

alter table PROJECT
   add constraint FK_PROJECT_PRJ_TAX_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table PROJECT
   add constraint FK_PROJECT_PRJ_TYPE__PROJECT_ foreign key (PROJECT_TYPE_ID)
      references PROJECT_TYPE (ID);

alter table PROJECT
   add constraint FK_PROJECT_PROJECT_R_CONTACT foreign key (RESPONSIBLE_ID)
      references CONTACT (ID);

alter table PROJECT
   add constraint FK_PROJECT_PRT_PROJE_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table PROJECT
   add constraint FK_PROJECT_STAGE_PRO_PROJECT_ foreign key (PROJECT_STAGE_ID)
      references PROJECT_STAGE (ID);

alter table PROJECT
   add constraint FK_PROJECT_STATUS_PR_PROJECT_ foreign key (PROJECT_STATUS_ID)
      references PROJECT_STATUS (ID);

alter table PROJECT_CONTACT_LINK
   add constraint FK_PROJECT__PRJ_CNT_C_CONTACT foreign key (CONTACT_ID)
      references CONTACT (ID);

alter table PROJECT_CONTACT_LINK
   add constraint FK_PROJECT__PRJ_PRJ_C_PROJECT foreign key (PROJECT_ID)
      references PROJECT (ID);

alter table PROJECT_CONTACT_LINK
   add constraint FK_PROJECT__PRJ_ROLE_PROJECT_ foreign key (PROJECT_ROLE_ID)
      references PROJECT_ROLE (ID);

alter table PROJECT_CONTEXT
   add constraint FK_PROJECT__PCX_PSTG_PROJECT_ foreign key (PROJECT_STAGE_ID)
      references PROJECT_STAGE (ID);

alter table PROJECT_CONTEXT
   add constraint FK_PROJECT__PCX_PSTT_PROJECT_ foreign key (PROJECT_STATUS_ID)
      references PROJECT_STATUS (ID);

alter table PROJECT_CONTEXT
   add constraint FK_PROJECT__PCX_PTP_PROJECT_ foreign key (PROJECT_TYPE_ID)
      references PROJECT_TYPE (ID);

alter table PROJECT_CONTEXT
   add constraint FK_PROJECT__PRJ_CTX_C_CURRENCY foreign key (CURRENCY_ID)
      references CURRENCY (ID);

alter table PROJECT_CONTEXT
   add constraint FK_PROJECT__PRJ_CTX_P_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table PROJECT_CONTEXT
   add constraint FK_PROJECT__PRJ_CTX_R_CONTACT foreign key (RESPONSIBLE_ID)
      references CONTACT (ID);

alter table PROJECT_STAGE
   add constraint FK_PROJECT__PRJ_STAGE_PROJECT_ foreign key (PROJECT_STAGE_GROUP_ID)
      references PROJECT_STAGE_GROUP (ID);

alter table PROJECT_STAGE
   add constraint FK_PROJECT__PRJ_TYPE__PROJECT_ foreign key (PROJECT_TYPE_ID)
      references PROJECT_TYPE (ID);

alter table PROJECT_STAGE_LINK
   add constraint FK_PROJECT__PRG_PRG_S_PROJECT foreign key (PROJECT_ID)
      references PROJECT (ID);

alter table PROJECT_STAGE_LINK
   add constraint FK_PROJECT__PRG_STAGE_PROJECT_ foreign key (PROJECT_STAGE_ID)
      references PROJECT_STAGE (ID);

alter table PURCHASE_INVOICE
   add constraint FK_PURCHASE_PCH_INV_P_PRICE_TY foreign key (PRICE_TYPE_ID)
      references PRICE_TYPE (ID);

alter table PURCHASE_INVOICE_ITEM
   add constraint FK_PURCHASE_PINVI_PRO_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table PURCHASE_INVOICE_ITEM
   add constraint FK_PURCHASE_PINVI_UNI_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table PURCHASE_INVOICE_ITEM
   add constraint FK_PURCHASE_PINV_ITEM_PURCHASE foreign key (PURCHASE_INVOICE_ID)
      references PURCHASE_INVOICE (ID);

alter table PURCHASE_INVOICE_ITEM
   add constraint FK_PURCHASE_PINV_TAX_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table PURCHASE_ORDER
   add constraint FK_PURCHASE_PCHORD_RE_MTRL_RES foreign key (MTRL_RESPONSIBLE_ID)
      references MTRL_RESPONSIBLE (ID);

alter table PURCHASE_ORDER
   add constraint FK_PURCHASE_PCHORD_WR_WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table PURCHASE_ORDER
   add constraint FK_PURCHASE_PO_PT_PRICE_TY foreign key (PRICE_TYPE_ID)
      references PRICE_TYPE (ID);

alter table PURCHASE_ORDER_ITEM
   add constraint FK_PURCHASE_PCHORD_IT_PURCHASE foreign key (PURCHASE_ORDER_ID)
      references PURCHASE_ORDER (ID);

alter table PURCHASE_ORDER_ITEM
   add constraint FK_PURCHASE_PCHORD_IT_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table PURCHASE_ORDER_ITEM
   add constraint FK_PURCHASE_PCHORD_IT_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table PURCHASE_ORDER_ITEM
   add constraint FK_PURCHASE_PURCHASEO_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table PURCHASE_PLAN
   add constraint FK_PURCHASE_PURCHASE__PRICE_TY foreign key (PRICE_TYPE_ID)
      references PRICE_TYPE (ID);

alter table PURCHASE_PLAN_ITEM
   add constraint FK_PURCHASE_PURCHASEP_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table PURCHASE_PLAN_ITEM
   add constraint FK_PURCHASE_PURCHASE__PURCHASE foreign key (PURCHASE_PLAN_ID)
      references PURCHASE_PLAN (ID);

alter table PURCHASE_PLAN_ITEM
   add constraint FK_PURCHASE_PURCHASE__TAX foreign key (TAX_ID)
      references TAX (ID);

alter table PURCHASE_PLAN_ITEM
   add constraint FK_PURCHASE_PURCHASE__UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table PURCHASE_SERV
   add constraint FK_PURCHASE_PSERV_RSP_MTRL_RES foreign key (MTRL_RESPONSIBLE_ID)
      references MTRL_RESPONSIBLE (ID);

alter table PURCHASE_SERV
   add constraint FK_PURCHASE_PSERV_WRH_WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table PURCHASE_SERV_ITEM
   add constraint FK_PURCHASE_PSERVI_PR_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table PURCHASE_SERV_ITEM
   add constraint FK_PURCHASE_PSERVI_PS_PURCHASE foreign key (PURCHASE_SERV_ID)
      references PURCHASE_SERV (ID);

alter table PURCHASE_SERV_ITEM
   add constraint FK_PURCHASE_PSERVI_TA_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table PURCHASE_SERV_ITEM
   add constraint FK_PURCHASE_PSERVI_UN_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table PURCHASE_TAX_WAYBILL_ITEM
   add constraint FK_PURCHASE_PTWI_PROD_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table PURCHASE_TAX_WAYBILL_ITEM
   add constraint FK_PURCHASE_PTWI_PTW_PURCHASE foreign key (PURCHASE_TAX_WAYBILL_ID)
      references PURCHASE_TAX_WAYBILL (ID);

alter table PURCHASE_TAX_WAYBILL_ITEM
   add constraint FK_PURCHASE_PTWI_TAX_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table PURCHASE_TAX_WAYBILL_ITEM
   add constraint FK_PURCHASE_PTWI_UNIT_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table REGION
   add constraint FK_REGION_REGION_CO_COUNTRY foreign key (COUNTRY_ID)
      references COUNTRY (ID);

alter table SALE_INVOICE
   add constraint FK_SALE_INV_SLE_INV_P_PRICE_TY foreign key (PRICE_TYPE_ID)
      references PRICE_TYPE (ID);

alter table SALE_INVOICE_ITEM
   add constraint FK_SALE_INV_SINVI_PRO_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table SALE_INVOICE_ITEM
   add constraint FK_SALE_INV_SINVI_UNI_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table SALE_INVOICE_ITEM
   add constraint FK_SALE_INV_SINV_ITEM_SALE_INV foreign key (SALE_INVOICE_ID)
      references SALE_INVOICE (ID);

alter table SALE_INVOICE_ITEM
   add constraint FK_SALE_INV_SINV_TAX_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table SALE_ORDER
   add constraint FK_SALE_ORD_SALORD_RE_MTRL_RES foreign key (MTRL_RESPONSIBLE_ID)
      references MTRL_RESPONSIBLE (ID);

alter table SALE_ORDER
   add constraint FK_SALE_ORD_SALORD_WR_WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table SALE_ORDER
   add constraint FK_SALE_ORD_SO_ADR_ADDRESS foreign key (DELIVERY_ADDRESS_ID)
      references ADDRESS (ID);

alter table SALE_ORDER
   add constraint FK_SALE_ORD_SO_PT_PRICE_TY foreign key (PRICE_TYPE_ID)
      references PRICE_TYPE (ID);

alter table SALE_ORDER_ITEM
   add constraint FK_SALE_ORD_SALEORD_I_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table SALE_ORDER_ITEM
   add constraint FK_SALE_ORD_SALEORD_P_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table SALE_ORDER_ITEM
   add constraint FK_SALE_ORD_SALORD_IT_SALE_ORD foreign key (SALE_ORDER_ID)
      references SALE_ORDER (ID);

alter table SALE_ORDER_ITEM
   add constraint FK_SALE_ORD_SALORD_IT_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table SALE_PLAN
   add constraint FK_SALE_PLA_SALE_PLAN_PRICE_TY foreign key (PRICE_TYPE_ID)
      references PRICE_TYPE (ID);

alter table SALE_PLAN_ITEM
   add constraint FK_SALE_PLA_SALEPLAN__PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table SALE_PLAN_ITEM
   add constraint FK_SALE_PLA_SALE_PLAN_SALE_PLA foreign key (SALE_PLAN_ID)
      references SALE_PLAN (ID);

alter table SALE_PLAN_ITEM
   add constraint FK_SALE_PLA_SPI_TAX_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table SALE_PLAN_ITEM
   add constraint FK_SALE_PLA_SPI_UNIT_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table SALE_SERV
   add constraint FK_SALE_SER_SSERV_RSP_MTRL_RES foreign key (MTRL_RESPONSIBLE_ID)
      references MTRL_RESPONSIBLE (ID);

alter table SALE_SERV
   add constraint FK_SALE_SER_SSERV_WRH_WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table SALE_SERV_ITEM
   add constraint FK_SALE_SER_SSERVI_SS_SALE_SER foreign key (SALE_SERV_ID)
      references SALE_SERV (ID);

alter table SALE_SERV_ITEM
   add constraint FK_SALE_SER_SSERVI_TA_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table SALE_SERV_ITEM
   add constraint FK_SALE_SER_SSERVI_UN_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table SALE_SERV_ITEM
   add constraint FK_SALE_SER_SSERV_PRO_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table SALE_TAX_WAYBILL_ITEM
   add constraint FK_SALE_TAX_STWI_PROD_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table SALE_TAX_WAYBILL_ITEM
   add constraint FK_SALE_TAX_STWI_STW_SALE_TAX foreign key (SALE_TAX_WAYBILL_ID)
      references SALE_TAX_WAYBILL (ID);

alter table SALE_TAX_WAYBILL_ITEM
   add constraint FK_SALE_TAX_STWI_TAX_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table SALE_TAX_WAYBILL_ITEM
   add constraint FK_SALE_TAX_STWI_UNIT_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table STORE
   add constraint FK_STORE_STORE_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table SYS_ENTITY
   add constraint FK_SYS_ENTI_ENTITY_EN_SYS_ENTI foreign key (ENTITY_TYPE_ID)
      references SYS_ENTITY_TYPE (ID);

alter table SYS_ENTITY_ATTR
   add constraint FK_SYS_ENTI_SA_DAT_TY_SYS_DATA foreign key (DATA_TYPE_ID)
      references SYS_DATA_TYPE (ID);

alter table SYS_ENTITY_ATTR
   add constraint FK_SYS_ENTI_SA_SAG_SYS_ENTI foreign key (ATTR_GROUP_ID)
      references SYS_ENTITY_ATTR_GROUP (ID);

alter table SYS_ENTITY_ATTR
   add constraint FK_SYS_ENTI_SA_SE_SYS_ENTI foreign key (ENTITY_ID)
      references SYS_ENTITY (ID);

alter table SYS_ENTITY_ATTR
   add constraint FK_SYS_ENTI_SA_VE_SYS_ENTI foreign key (VALUE_ENTITY_ID)
      references SYS_ENTITY (ID);

alter table SYS_ENTITY_ATTR_GROUP
   add constraint FK_SYS_ENTI_SAG_SE_SYS_ENTI foreign key (ENTITY_ID)
      references SYS_ENTITY (ID);

alter table SYS_ENTITY_ATTR_VALUE
   add constraint FK_SYS_ENTI_SAV_SA_SYS_ENTI foreign key (ATTR_ID)
      references SYS_ENTITY_ATTR (ID);

alter table SYS_ENTITY_ATTR_VALUE
   add constraint FK_SYS_ENTI_SAV_SE_SYS_ENTI foreign key (ENTITY_ID)
      references SYS_ENTITY (ID);

alter table SYS_ENUMERATION
   add constraint FK_SYS_ENUM_ENUM_ENTI_SYS_ENTI foreign key (ENTITY_ID)
      references SYS_ENTITY (ID);

alter table SYS_FILE
   add constraint FK_SYS_FILE_SF_SF_STO_SYS_FILE foreign key (FILE_STORAGE_ID)
      references SYS_FILE_STORAGE (ID);

alter table SYS_FILE
   add constraint FK_SYS_FILE_SF_SF_TYP_SYS_FILE foreign key (FILE_TYPE_ID)
      references SYS_FILE_TYPE (ID);

alter table SYS_FILE
   add constraint FK_SYS_FILE_SF_SYS_E_SYS_ENTI foreign key (ENTITY_ID)
      references SYS_ENTITY (ID);

alter table SYS_IMAGE
   add constraint FK_SYS_IMAG_SI_SF_TYP_SYS_FILE foreign key (FILE_TYPE_ID)
      references SYS_FILE_TYPE (ID);

alter table SYS_IMAGE
   add constraint FK_SYS_IMAG_SI_SI_STO_SYS_IMAG foreign key (IMAGE_STORAGE_ID)
      references SYS_IMAGE_STORAGE (ID);

alter table SYS_IMAGE
   add constraint FK_SYS_IMAG_SI_SYS_E_SYS_ENTI foreign key (ENTITY_ID)
      references SYS_ENTITY (ID);

alter table SYS_INFO
   add constraint FK_SYS_INFO_SYS_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table SYS_LOOKUP
   add constraint FK_SYS_LOOK_REF_ENTIT_SYS_ENTI foreign key (ENTITY_ID)
      references SYS_ENTITY (ID);

alter table SYS_MONTH
   add constraint FK_SYS_MONT_MONTH_QUA_SYS_QUAR foreign key (QUARTER_ID)
      references SYS_QUARTER (ID);

alter table SYS_PERMISSION
   add constraint FK_SYS_PERM_PERMISSIO_SYS_SECU foreign key (SECURE_OBJECT_ID)
      references SYS_SECURE_OBJECT (ID);

alter table SYS_PERMISSION
   add constraint FK_SYS_PERM_PERMISSIO_SYS_ROLE foreign key (ROLE_ID)
      references SYS_ROLE (ID);

alter table SYS_ROLE_INTERFACE
   add constraint FK_SYS_ROLE_SRU_SR_SYS_ROLE foreign key (ROLE_ID)
      references SYS_ROLE (ID);

alter table SYS_TRANSFER_SOURCE_ATTR
   add constraint FK_SYS_TRAN_TSA_SYS_TRAN foreign key (SOURCE_ID)
      references SYS_TRANSFER_SOURCE (ID);

alter table SYS_USER
   add constraint FK_SYS_USER_USER_CONT_CONTACT foreign key (CONTACT_ID)
      references CONTACT (ID);

alter table SYS_USER
   add constraint FK_SYS_USER_USER_ENTI_SYS_ENTI foreign key (ENTITY_ID)
      references SYS_ENTITY (ID);

alter table SYS_USER_ORG
   add constraint FK_SYS_USER_SUO_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table SYS_USER_ORG
   add constraint FK_SYS_USER_SUO_U_SYS_USER foreign key (USER_ID)
      references SYS_USER (ID);

alter table SYS_USER_ROLE
   add constraint FK_SYS_USER_UR_ROLE_SYS_ROLE foreign key (ROLE_ID)
      references SYS_ROLE (ID);

alter table SYS_USER_ROLE
   add constraint FK_SYS_USER_UR_USER_SYS_USER foreign key (USER_ID)
      references SYS_USER (ID);

alter table SYS_VARIABLE
   add constraint FK_SYS_VARI_SYSVAR_DA_SYS_DATA foreign key (DATA_TYPE_ID)
      references SYS_DATA_TYPE (ID);

alter table SYS_VARIABLE
   add constraint FK_SYS_VARI_SYSVAR_SY_SYS_ENTI foreign key (VALUE_ENTITY_ID)
      references SYS_ENTITY (ID);

alter table TASK
   add constraint FK_TASK_DOC_TASK_DOCUMENT foreign key (DOCUMENT_ID)
      references DOCUMENT (ID);

alter table TASK
   add constraint FK_TASK_ORG_TASK_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table TASK
   add constraint FK_TASK_PRJ_TASK_PROJECT foreign key (PROJECT_ID)
      references PROJECT (ID);

alter table TASK
   add constraint FK_TASK_PRT_TASK_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table TASK
   add constraint FK_TASK_RESULT_TA_TASK_RES foreign key (TASK_RESULT_ID)
      references TASK_RESULT (ID);

alter table TASK
   add constraint FK_TASK_TASK_PRIO_TASK_PRI foreign key (TASK_PRIORITY_ID)
      references TASK_PRIORITY (ID);

alter table TASK
   add constraint FK_TASK_TASK_REPO_CONTACT foreign key (REPORTER_ID)
      references CONTACT (ID);

alter table TASK
   add constraint FK_TASK_TASK_RESP_CONTACT foreign key (RESPONSIBLE_ID)
      references CONTACT (ID);

alter table TASK
   add constraint FK_TASK_TASK_STAT_TASK_STA foreign key (TASK_STATUS_ID)
      references TASK_STATUS (ID);

alter table TASK
   add constraint FK_TASK_TSK_PRJST_PROJECT_ foreign key (PROJECT_STAGE_ID)
      references PROJECT_STAGE (ID);

alter table TASK
   add constraint FK_TASK_TYPE_TASK_TASK_TYP foreign key (TASK_TYPE_ID)
      references TASK_TYPE (ID);

alter table TASK_CONTACT_LINK
   add constraint FK_TASK_CON_TASK_CNT__CONTACT foreign key (CONTACT_ID)
      references CONTACT (ID);

alter table TASK_CONTACT_LINK
   add constraint FK_TASK_CON_TASK_ROLE_TASK_ROL foreign key (TASK_ROLE_ID)
      references TASK_ROLE (ID);

alter table TASK_CONTACT_LINK
   add constraint FK_TASK_CON_TASK_TSK__TASK foreign key (TASK_ID)
      references TASK (ID);

alter table TASK_CONTEXT
   add constraint FK_TASK_CON_TSK_CTX_P_PROJECT foreign key (PROJECT_ID)
      references PROJECT (ID);

alter table TASK_CONTEXT
   add constraint FK_TASK_CON_TSK_CTX_P_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table TASK_CONTEXT
   add constraint FK_TASK_CON_TSK_CTX_R_CONTACT foreign key (RESPONSIBLE_ID)
      references CONTACT (ID);

alter table TASK_CONTEXT
   add constraint FK_TASK_CON_TSK_CTX_T_TASK_PRI foreign key (TASK_PRIORITY_ID)
      references TASK_PRIORITY (ID);

alter table TASK_CONTEXT
   add constraint FK_TASK_CON_TSK_CTX_T_TASK_RES foreign key (TASK_RESULT_ID)
      references TASK_RESULT (ID);

alter table TASK_CONTEXT
   add constraint FK_TASK_CON_TSK_CTX_T_TASK_STA foreign key (TASK_STATUS_ID)
      references TASK_STATUS (ID);

alter table TASK_CONTEXT
   add constraint FK_TASK_CON_TSK_CTX_T_TASK_TYP foreign key (TASK_TYPE_ID)
      references TASK_TYPE (ID);

alter table TASK_RESULT
   add constraint FK_TASK_RES_TYPE_TASK_TASK_TYP foreign key (TASK_TYPE_ID)
      references TASK_TYPE (ID);

alter table TASK_WORKER_LINK
   add constraint FK_TASK_WOR_TSK_EMP_T_TASK foreign key (TASK_ID)
      references TASK (ID);

alter table TASK_WORKER_LINK
   add constraint FK_TASK_WOR_TSK_WORKE_CONTACT foreign key (WORKER_ID)
      references CONTACT (ID);

alter table TEMPLATE_ENTRY
   add constraint FK_TEMPLATE_TEMPL_ENT_FINANCE_ foreign key (FINANCE_DOCUMENT_TYPE_ID)
      references FINANCE_DOCUMENT_TYPE (ID);

alter table TEMPLATE_ENTRY_ITEM
   add constraint FK_TEMPLATE_CTEI_LA_LEDGER_A foreign key (CREDIT_LEDACC_ID)
      references LEDGER_ACCOUNT (ID);

alter table TEMPLATE_ENTRY_ITEM
   add constraint FK_TEMPLATE_DTEI_LA_LEDGER_A foreign key (DEBIT_LEDACC_ID)
      references LEDGER_ACCOUNT (ID);

alter table TEMPLATE_ENTRY_ITEM
   add constraint FK_TEMPLATE_TEMPL_ENT_TEMPLATE foreign key (TEMPLATE_ENTRY_ID)
      references TEMPLATE_ENTRY (ID);

alter table WAREHOUSE_ENTITY
   add constraint FK_WAREHOUS_WRH_ENTIT_SYS_ENTI foreign key (ENTITY_ID)
      references SYS_ENTITY (ID);

alter table WAREHOUSE_MOVE
   add constraint FK_WAREHOUS_WRH_MOVE__FINANCE_ foreign key (OWNER_ID)
      references FINANCE_DOCUMENT (ID);

alter table WAREHOUSE_MOVE
   add constraint FK_WAREHOUS_WRH_MOVE__MTRL_RES foreign key (MTRL_RESPONSIBLE_ID)
      references MTRL_RESPONSIBLE (ID);

alter table WAREHOUSE_MOVE
   add constraint FK_WAREHOUS_WRH_MOVE__WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table WEB
   add constraint FK_WEB_WEB_CONTA_CONTACTA foreign key (CONTACTABLE_ID)
      references CONTACTABLE (ID);




/* CREATE CUST CONSTRAINTS */ 


CREATE UNIQUE INDEX BUSINESSABLE_OWNER ON BUSINESSABLE (OWNER_ID);
CREATE UNIQUE INDEX CONTACTABLE_OWNER ON CONTACTABLE (OWNER_ID);

CREATE INDEX BUSINESSABLE_ENTITY_ID ON BUSINESSABLE (ENTITY_ID);
CREATE INDEX SYS_ENTITY_CODE ON SYS_ENTITY (CODE);

CREATE UNIQUE INDEX USER_ROLE_UNIQUE ON SYS_USER_ROLE (USER_ID, ROLE_ID);
CREATE UNIQUE INDEX ROLE_INTERFACE_UNIQUE ON SYS_ROLE_INTERFACE (ROLE_ID, INTERFACE_ID);
CREATE UNIQUE INDEX USER_ORG_UNIQUE ON SYS_USER_ORG (USER_ID, ORGANIZATION_ID);

CREATE INDEX DOC_TYPE_SECTION ON DOCUMENT_TYPE (DOCUMENT_SECTION);
CREATE INDEX DOC_TYPE_CATEGORY ON DOCUMENT_TYPE (DOCUMENT_CATEGORY);
CREATE INDEX FIN_DOC_TYPE_MOVE ON FINANCE_DOCUMENT_TYPE (MOVE_TYPE);

/* ERROR BY UPDATE */
/* CREATE UNIQUE INDEX PARTNER_MOVE_OWNER ON PARTNER_MOVE (OWNER_ID, PARTNER_ID); */


ALTER TABLE GOODS ADD CONSTRAINT FK_GOODS_PRODUCT FOREIGN KEY (ID) REFERENCES PRODUCT (ID);

ALTER TABLE FINANCE_DOCUMENT ADD CONSTRAINT FK_DOCUMENT_FIN_DOCUMENT FOREIGN KEY (ID) REFERENCES DOCUMENT (ID);
ALTER TABLE CONTRACT ADD CONSTRAINT FK_CONTRACT_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);

ALTER TABLE INVENTORY_REST ADD CONSTRAINT FK_INVENTORY_REST_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE INVENTORY_MOVE ADD CONSTRAINT FK_INVENTORY_MOVE_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE INVENTORY_WRITEOFF ADD CONSTRAINT FK_INVENTORY_WRITEOFF_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE INVENTORY_INCOME ADD CONSTRAINT FK_INVENTORY_INCOME_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE INVENTORY_OUTCOME ADD CONSTRAINT FK_INVENTORY_OUTCOME_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);


ALTER TABLE GOODS_INCOME ADD CONSTRAINT FK_GOODS_INCOME_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE GOODS_OUTCOME ADD CONSTRAINT FK_GOODS_OUTCOME_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);

ALTER TABLE PAYMENT_INCOME ADD CONSTRAINT FK_PAYMENT_INCOME_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE PAYMENT_OUTCOME ADD CONSTRAINT FK_PAYMENT_OUTCOME_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);

ALTER TABLE SALE_INVOICE ADD CONSTRAINT FK_SALE_INV_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE SALE_ORDER ADD CONSTRAINT FK_SALE_ORDER_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE SALE_PLAN ADD CONSTRAINT FK_SALE_PLAN_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE SALE_SERV ADD CONSTRAINT FK_SALE_SERV_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE SALE_TAX_WAYBILL ADD CONSTRAINT FK_SALE_TXWB_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);

ALTER TABLE PURCHASE_INVOICE ADD CONSTRAINT FK_PURCHASE_INV_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE PURCHASE_ORDER ADD CONSTRAINT FK_PURCHASE_ORDER_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE PURCHASE_PLAN ADD CONSTRAINT FK_PURCHASE_PLAN_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE PURCHASE_SERV ADD CONSTRAINT FK_PURCHASE_SERV_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE PURCHASE_TAX_WAYBILL ADD CONSTRAINT FK_PURCHASE_TXWB_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);

ALTER TABLE CASH_INCOME ADD CONSTRAINT FK_CASH_INCOME_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE CASH_OUTCOME ADD CONSTRAINT FK_CASH_OUTCOME_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);


ALTER TABLE EMPLOYEE_RECEPTION ADD CONSTRAINT FK_EMPLOYEE_RECEPTION_DOC FOREIGN KEY (ID) REFERENCES DOCUMENT (ID);
ALTER TABLE EMPLOYEE_DISCHARGE ADD CONSTRAINT FK_EMPLOYEE_DISCHARGE_DOC FOREIGN KEY (ID) REFERENCES DOCUMENT (ID);
ALTER TABLE EMPLOYEE_VACATION ADD CONSTRAINT FK_EMPLOYEE_VACATION_DOC FOREIGN KEY (ID) REFERENCES DOCUMENT (ID);
ALTER TABLE EMPLOYEE_SICKLIST ADD CONSTRAINT FK_EMPLOYEE_SICKLIST_DOC FOREIGN KEY (ID) REFERENCES DOCUMENT (ID);


/* ALTER TABLE DOCUMENT ADD COLUMN PARTNER_ID INTEGER; */
/* ALTER TABLE DOCUMENT ADD CONSTRAINT FK_DOCUMENT_PARTNER FOREIGN KEY (PARTNER_ID) REFERENCES PARTNER (ID); */


ALTER TABLE PARTNER ADD CONSTRAINT FK_PARTNER_PARTNER_TYPE FOREIGN KEY (PARTNER_TYPE_ID) REFERENCES PARTNER_TYPE (ID);




/*==============================================================*/
/* Firebird                                                     */
/* http://www.firebirdsql.org                                   */
/*==============================================================*/

CREATE VIEW V_ORGANIZATION (
  ID,
  ORGANIZATION_NAME,
  ORGANIZATION_CODE,
  ORGANIZATION_NEC,
  ORGANIZATION_IDN,
  ORGANIZATION_TYPE_ID
) AS
SELECT
  O.ID,
  P.NAME,
  P.CODE,
  P.NEC,
  P.IDN,
  P.PARTNER_TYPE_ID
 FROM ORGANIZATION O 
 INNER JOIN PARTNER P ON P.ID = O.ID;

CREATE VIEW V_SYS_USER (
 ID,
 USRER_NAME,
 USRER_PASSWORD,
 OWNER_ID,
 ENTITY_ID,
 NAME,
 REG_DATE, 
 ORGANIZATION_ID,
 ORGANIZATION_NAME
) AS
SELECT U.ID, U.USER_NAME, U.USER_PASSWORD, U.OWNER_ID, U.ENTITY_ID,
 C.LAST_NAME || ' ' || C.FIRST_NAME || ' ' || C.MIDDLE_NAME AS NAME,
 U.REG_DATE, O.ID AS ORGANIZATION_ID, O.ORGANIZATION_NAME
 FROM SYS_USER U
 INNER JOIN SYS_ENTITY E ON E.ID = U.ENTITY_ID
 INNER JOIN EMPLOYEE EE ON EE.ID = U.OWNER_ID
 INNER JOIN PERSON P ON P.ID = EE.PERSON_ID
 INNER JOIN CONTACT C ON P.ID = C.ID
 INNER JOIN V_ORGANIZATION O ON O.ID = EE.ORGANIZATION_ID
 WHERE E.CODE = 'EMPLOYEE';



CREATE VIEW V_SYS_PERMISSION (
 ID,
 SECURE_OBJECT_ID,
 PERMISSION_ID,
 OBJECT_ID,
 CODE,
 NAME,
 OBJECT_TYPE,
 ROLE_ID,
 IS_READ,
 IS_WRITE,
 IS_EXEC
) AS
SELECT
 O.ID AS ID,
 P.SECURE_OBJECT_ID,
 P.ID AS PERMISSION_ID,
 O.OBJECT_ID,
 O.CODE,
 O.NAME,
 O.OBJECT_TYPE,
 P.ROLE_ID,
 P.IS_READ,
 P.IS_WRITE,
 P.IS_EXEC
FROM SYS_SECURE_OBJECT O
LEFT JOIN SYS_PERMISSION P ON O.ID = P.SECURE_OBJECT_ID;


CREATE VIEW V_EMPLOYEE (
    ID,
    ORGANIZATION_ID,
    PERSON_ID,
    FIRST_NAME,
    LAST_NAME,
    MIDDLE_NAME,
    NAME
) AS
SELECT 
 E.ID,
 E.ORGANIZATION_ID,
 E.PERSON_ID,
 C.FIRST_NAME,
 C.LAST_NAME,
 C.MIDDLE_NAME,
 C.NAME
 FROM EMPLOYEE E
 INNER JOIN PERSON P ON P.ID = E.PERSON_ID
 INNER JOIN CONTACT C ON P.ID = C.ID;
 


CREATE VIEW V_WAREHOUSE (
  ID,
  OWNER_ID,
  ENTITY_ID,
  NAME
) AS
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, B.NAME
 FROM BUSINESSABLE B
 INNER JOIN WAREHOUSE S ON S.ID = B.OWNER_ID;

 




CREATE VIEW V_WAREHOUSE_UNION (
  ID, 
  OWNER_ID, 
  ENTITY_ID, 
  ENTITY_CODE, 
  ENTITY_NAME, 
  ORGANIZATION_ID, 
  PARENT_ID, 
  NAME
) AS 
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, O.ORGANIZATION_ID, O.PARENT_ID, O.NAME
 FROM BUSINESSABLE B
 INNER JOIN STORE O ON O.ID = B.OWNER_ID
 INNER JOIN SYS_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'STORE';




CREATE VIEW V_MTRL_RESPONSIBLE (
 ID,
 ORGANIZATION_ID,
 WAREHOUSE_ID,
 PERSON_ID,
 MTRL_RESPONSIBLE_NAME,
 WAREHOUSE_NAME
) AS
SELECT 
 RE.ID, 
 RE.ORGANIZATION_ID, 
 RE.WAREHOUSE_ID,
 C.ID AS PERSON_ID,
 C.NAME,
 S.NAME
 FROM MTRL_RESPONSIBLE RE 
 INNER JOIN CONTACT C ON RE.CONTACT_ID = C.ID
 LEFT JOIN V_WAREHOUSE S ON S.ID = RE.WAREHOUSE_ID;


CREATE VIEW V_WAREHOUSE_MOVE (
  ID,
  DOCUMENT_ID,
  WAREHOUSE_ID,
  WAREHOUSE_NAME,
  MOVE_TYPE
) AS
SELECT 
  M.ID,
  M.OWNER_ID AS DOCUMENT_ID,
  M.WAREHOUSE_ID,
  S.NAME AS WAREHOUSE_NAME,
  M.MOVE_TYPE
 FROM WAREHOUSE_MOVE M
 INNER JOIN V_WAREHOUSE S ON S.ID = M.WAREHOUSE_ID;

CREATE VIEW V_PRODUCT (
 ID,
 PRODUCT_CODE,
 PRODUCT_NAME,
 PRODUCT_GROUP_ID,
 BAR_CODE,
 ORGANIZATION_ID,
 CURRENCY_ID,
 CURRENCY_RATE,
 LEDGER_ACCOUNT_ID,
 MANUFACTURER_ID,
 SUPPLIER_ID,
 START_DATE,
 END_DATE,
 UNIT_ID,
 PRICE,
 COST_PRICE, 
 LIST_PRICE,
 WHOLESALE_PRICE,
 SMALL_WHOLESALE_PRICE,
 RETAIL_PRICE,
 CURRENCY_PRICE,
 CURRENCY_SMALL_WHOLESALE_PRICE,
 CURRENCY_WHOLESALE_PRICE,
 CURRENCY_RETAIL_PRICE,
 TAX_PERCENT,
 ADDPRICE_PERCENT,
 MIN_QUANTITY,
 AVAILABLE_QUANTITY,
 RESERVED_QUANTITY,
 EXPECTED_QUANTITY,
 WARRANTY_PERIOD_UNIT_ID,
 WARRANTY_PERIOD,
 DIMENSION_UNIT_ID,
 DIM_LENGTH,
 DIM_WIDTH,
 DIM_HEIGHT,
 WEIGHT_UNIT_ID,
 WEIGHT,
 IMAGE_FILE_NAME,
 NOTE
) AS
SELECT 
 P.ID,    
 P.CODE,
 P.NAME,
 P.PRODUCT_GROUP_ID,
 P.BAR_CODE,
 P.ORGANIZATION_ID,
 P.CURRENCY_ID,
 P.CURRENCY_RATE,
 P.LEDGER_ACCOUNT_ID,
 P.MANUFACTURER_ID,
 P.SUPPLIER_ID,
 P.START_DATE,
 P.END_DATE,
 P.UNIT_ID,
 P.PRICE,
 P.PRICE,
 P.LIST_PRICE,
 P.WHOLESALE_PRICE,
 P.SMALL_WHOLESALE_PRICE,
 P.RETAIL_PRICE,
 P.CURRENCY_PRICE,
 P.CURRENCY_SMALL_WHOLESALE_PRICE,
 P.CURRENCY_WHOLESALE_PRICE,
 P.CURRENCY_RETAIL_PRICE,
 P.TAX_PERCENT,
 P.ADDPRICE_PERCENT,
 P.MIN_QUANTITY,
 P.AVAILABLE_QUANTITY,
 P.RESERVED_QUANTITY,
 P.EXPECTED_QUANTITY,
 P.WARRANTY_PERIOD_UNIT_ID,
 P.WARRANTY_PERIOD,
 P.DIMENSION_UNIT_ID,
 P.DIM_LENGTH,
 P.DIM_WIDTH,
 P.DIM_HEIGHT,
 P.WEIGHT_UNIT_ID,
 P.WEIGHT,
 P.IMAGE_FILE_NAME,
 P.NOTE
FROM PRODUCT P;





CREATE VIEW V_PRODUCT_MOVE (
  ID,
  DOCUMENT_ID,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  UNIT_ID,
  ITEM_UNIT_ID,
  UNIT_RATE,
  UNIT_NAME,
  PRODUCT_PRICE,
  PRICE,
  PRICE_WITH_TAX,
  TAX_PRICE,
  QUANTITY,
  AMOUNT,
  AMOUNT_WITH_TAX,
  TAX_AMOUNT,
  ITEM_PRICE,
  ITEM_ACCOUNT_PRICE,
  ITEM_AMOUNT,
  ACCOUNT_QUANTITY,
  ACCOUNT_PRICE,
  ACCOUNT_PRICE_WITH_TAX
) AS
SELECT 
  I.ID,
  I.OWNER_ID,
  I.PRODUCT_ID,
  P.PRODUCT_CODE,
  P.PRODUCT_NAME,
  P.UNIT_ID,
  I.UNIT_ID,
  I.UNIT_RATE,
  U.NAME,
  P.PRICE,
  I.PRICE,
  I.PRICE_WITH_TAX,
  I.TAX_PRICE,
  I.QUANTITY,
  I.AMOUNT,
  I.AMOUNT_WITH_TAX,
  I.TAX_AMOUNT,
  I.PRICE_WITH_TAX,
  I.ACCOUNT_PRICE_WITH_TAX,
  I.AMOUNT_WITH_TAX,
  I.ACCOUNT_QUANTITY,
  I.ACCOUNT_PRICE,
  I.ACCOUNT_PRICE_WITH_TAX
 FROM PRODUCT_MOVE I
 INNER JOIN V_PRODUCT P ON P.ID = I.PRODUCT_ID
 INNER JOIN UNIT U ON U.ID = I.UNIT_ID;
 
CREATE VIEW V_GOODS (
 ID,
 PRODUCT_CODE,
 PRODUCT_NAME,
 PRODUCT_GROUP_ID,
 CURRENCY_ID,
 ORGANIZATION_ID,
 UNIT_ID,
 PRICE,
 START_DATE,
 END_DATE,
 TAX_PERCENT,
 ADDPRICE_PERCENT,
 MIN_QUANTITY,
 CURRENCY_RATE,
 COUNTRY_ID,
 GOODS_TYPE_ID,
 GOODS_TYPE_NAME
) AS
SELECT 
 P.ID,    
 P.PRODUCT_CODE,
 P.PRODUCT_NAME,
 P.PRODUCT_GROUP_ID,
 P.CURRENCY_ID,
 P.ORGANIZATION_ID,
 P.UNIT_ID,
 P.PRICE,
 P.START_DATE,
 P.END_DATE,
 P.TAX_PERCENT,
 P.ADDPRICE_PERCENT,
 P.MIN_QUANTITY,
 P.CURRENCY_RATE,
 G.COUNTRY_ID,
 G.GOODS_TYPE_ID,
 T.NAME
 FROM GOODS G
 INNER JOIN V_PRODUCT P ON P.ID = G.ID
 INNER JOIN GOODS_TYPE T ON T.ID = G.GOODS_TYPE_ID;






CREATE VIEW V_ASSET (
 ID,	
 PRODUCT_CODE,
 PRODUCT_NAME,
 PRODUCT_GROUP_ID,
 CURRENCY_ID,
 ORGANIZATION_ID,
 UNIT_ID,
 PRICE,
 START_DATE,
 END_DATE,
 TAX_PERCENT,
 ADDPRICE_PERCENT,
 MIN_QUANTITY,
 CURRENCY_RATE
) AS
SELECT 
 P.ID,	
 P.PRODUCT_CODE,
 P.PRODUCT_NAME,
 P.PRODUCT_GROUP_ID,
 P.CURRENCY_ID,
 P.ORGANIZATION_ID,
 P.UNIT_ID,
 P.PRICE,
 P.START_DATE,
 P.END_DATE,
 P.TAX_PERCENT,
 P.ADDPRICE_PERCENT,
 P.MIN_QUANTITY,
 P.CURRENCY_RATE
 FROM ASSET A
 INNER JOIN V_PRODUCT P ON P.ID = A.ID;


CREATE VIEW V_INTANGIBLE (
 ID,	
 PRODUCT_CODE,
 PRODUCT_NAME,
 PRODUCT_GROUP_ID,
 CURRENCY_ID,
 ORGANIZATION_ID,
 UNIT_ID,
 PRICE,
 START_DATE,
 END_DATE,
 TAX_PERCENT,
 ADDPRICE_PERCENT,
 MIN_QUANTITY,
 CURRENCY_RATE
) AS
SELECT 
 P.ID,	
 P.PRODUCT_CODE,
 P.PRODUCT_NAME,
 P.PRODUCT_GROUP_ID,
 P.CURRENCY_ID,
 P.ORGANIZATION_ID,
 P.UNIT_ID,
 P.PRICE,
 P.START_DATE,
 P.END_DATE,
 P.TAX_PERCENT,
 P.ADDPRICE_PERCENT,
 P.MIN_QUANTITY,
 P.CURRENCY_RATE
 FROM INTANGIBLE I
 INNER JOIN V_PRODUCT P ON P.ID = I.ID;


/*                                                        */
/*   Firebird implementation                              */
/*                                                        */
/*   Use function EXTRACT():                              */
/*                                                        */
/*   EXTRACT (YEAR FROM DOCUMENT_DATE)                    */
/*   EXTRACT (MONTH FROM DOCUMENT_DATE)                   */
/*                                                        */
/*   Firebird doesn't have functions YEAR() and MONTH()    */
/*                                                        */


CREATE VIEW V_DOCUMENT (
  ID,
  ORGANIZATION_ID,
  ORGANIZATION_NAME,
  ORGANIZATION_CODE,
  ORGANIZATION_NEC,
  ORGANIZATION_IDN,
  ORGANIZATION_TYPE_ID,
  DOCUMENT_TYPE_ID,
  DOCUMENT_TYPE_CODE,
  DOCUMENT_TYPE_NAME,
  PERIOD_ID,
  DOCUMENT_NO,
  DOCUMENT_DATE,
  DOCUMENT_YEAR,
  DOCUMENT_MONTH,
  PARTNER_ID,
  RESPONSIBLE_ID,
  USER_ID,
  CONTRACT_ID,
  REASON_DOCUMENT_ID,
  REASON,
  NOTE,
  USER_NAME
) AS
SELECT
  D.ID,
  D.ORGANIZATION_ID,
  O.ORGANIZATION_NAME,
  O.ORGANIZATION_CODE,
  O.ORGANIZATION_NEC,
  O.ORGANIZATION_IDN,
  O.ORGANIZATION_TYPE_ID,
  D.DOCUMENT_TYPE_ID,
  E.CODE AS DOCUMENT_TYPE_CODE,
  E.NAME AS DOCUMENT_TYPE_NAME,
  D.PERIOD_ID,
  D.DOCUMENT_NO,
  D.DOCUMENT_DATE,
  EXTRACT (YEAR FROM D.DOCUMENT_DATE),
  EXTRACT (MONTH FROM D.DOCUMENT_DATE),
  D.PARTNER_ID,
  D.RESPONSIBLE_ID,
  D.USER_ID,
  D.CONTRACT_ID,
  D.REASON_DOCUMENT_ID,
  D.REASON,
  D.NOTE,
  U.USER_NAME
 FROM DOCUMENT D
 INNER JOIN V_ORGANIZATION O ON O.ID = D.ORGANIZATION_ID
 INNER JOIN DOCUMENT_TYPE DT ON DT.ID = D.DOCUMENT_TYPE_ID
 INNER JOIN SYS_ENTITY E ON E.ID = DT.ENTITY_ID
 LEFT JOIN SYS_USER U ON U.ID = D.USER_ID;




CREATE VIEW V_FINANCE_DOCUMENT (
  ID, 
  ORGANIZATION_ID,
  ORGANIZATION_NAME,
  ORGANIZATION_CODE,
  ORGANIZATION_NEC,
  ORGANIZATION_IDN,
  ORGANIZATION_TYPE_ID,
  DOCUMENT_TYPE_ID, 
  DOCUMENT_TYPE_CODE,
  DOCUMENT_TYPE_NAME,
  PERIOD_ID,
  DOCUMENT_NO, 
  DOCUMENT_DATE,
  DOCUMENT_YEAR,
  DOCUMENT_MONTH,
  PARTNER_ID,
  RESPONSIBLE_ID,
  USER_ID,
  CONTRACT_ID,
  REASON_DOCUMENT_ID,
  REASON,
  NOTE,
  USER_NAME,
  CURRENCY_ID, 
  CURRENCY_RATE,
  CURRENCY_RATE_DATE,
  CURRENCY_CODE,
  CURRENCY_NUMERIC_CODE,
  CURRENCY_NAME,
  AMOUNT,
  AMOUNT_WITH_TAX,
  TAX_AMOUNT,
  CURRENCY_AMOUNT,
  CURRENCY_AMOUNT_WITH_TAX,
  CURRENCY_TAX_AMOUNT,
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
  IS_OPERATION,
  IS_ACCOUNT_ITEMS
) AS
SELECT 
  D.ID, 
  D.ORGANIZATION_ID,
  D.ORGANIZATION_NAME,
  D.ORGANIZATION_CODE,
  D.ORGANIZATION_NEC,
  D.ORGANIZATION_IDN,
  D.ORGANIZATION_TYPE_ID,
  D.DOCUMENT_TYPE_ID, 
  D.DOCUMENT_TYPE_CODE,
  D.DOCUMENT_TYPE_NAME,
  D.PERIOD_ID,
  D.DOCUMENT_NO, 
  D.DOCUMENT_DATE,
  D.DOCUMENT_YEAR,
  D.DOCUMENT_MONTH,
  D.PARTNER_ID,  
  D.RESPONSIBLE_ID,
  D.USER_ID,
  D.CONTRACT_ID,
  D.REASON_DOCUMENT_ID,
  D.REASON,
  D.NOTE,
  D.USER_NAME,
  FD.CURRENCY_ID, 
  FD.CURRENCY_RATE,
  FD.CURRENCY_RATE_DATE,
  CR.CODE AS CURRENCY_CODE,
  CR.NUMERIC_CODE AS CURRENCY_NUMERIC_CODE,
  CR.NAME AS CURRENCY_NAME,
  FD.AMOUNT,
  FD.AMOUNT_WITH_TAX,
  FD.TAX_AMOUNT,
  FD.CURRENCY_AMOUNT,
  FD.CURRENCY_AMOUNT_WITH_TAX,
  FD.CURRENCY_TAX_AMOUNT,
  FD.TOTAL,
  FD.TOTAL_WITH_TAX,
  FD.TAX_TOTAL,
  FD.CURRENCY_TOTAL,
  FD.CURRENCY_TOTAL_WITH_TAX,
  FD.CURRENCY_TAX_TOTAL,
  FD.AMOUNT_WITH_TAX AS DOCUMENT_AMOUNT,
  FD.TOTAL_WITH_TAX AS DOCUMENT_TOTAL,
  FD.CURRENCY_AMOUNT_WITH_TAX AS CURRENCY_DOCUMENT_AMOUNT,
  FD.CURRENCY_TOTAL_WITH_TAX AS CURRENCY_DOCUMENT_TOTAL,
  FD.IS_OPERATION,
  FD.IS_ACCOUNT_ITEMS
 FROM FINANCE_DOCUMENT FD
 INNER JOIN V_DOCUMENT D ON FD.ID = D.ID
 LEFT JOIN CURRENCY CR ON CR.ID = FD.CURRENCY_ID;



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
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, B.NAME
 FROM BUSINESSABLE B WHERE B.ENTITY_ID = 'PARTNER' OR B.ENTITY_ID = 'EMPLOYEE';

CREATE VIEW V_CONTRACTOR_UNION (
    ID,
    OWNER_ID,
    ENTITY_ID,
    ENTITY_CODE,
    ENTITY_NAME,
    ORGANIZATION_ID,
    NAME)
AS
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, -1, CAST(O.NAME AS VARCHAR(100))
 FROM BUSINESSABLE B
 INNER JOIN PARTNER O ON O.ID = B.OWNER_ID
 INNER JOIN SYS_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'PARTNER'
UNION ALL
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, O.ORGANIZATION_ID, CAST(C.NAME AS VARCHAR(100))
 FROM BUSINESSABLE B
 INNER JOIN EMPLOYEE O ON O.ID = B.OWNER_ID
 INNER JOIN PERSON P ON P.ID = O.PERSON_ID
 INNER JOIN CONTACT C ON P.ID = C.ID
 INNER JOIN SYS_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'EMPLOYEE';
CREATE VIEW V_CITY (
  ID,
  COUNTRY_ID,
  LOCALITY_TYPE_ID,
  REGION_ID,
  DISTRICT_ID,
  NAME
) AS
SELECT
  C.ID,
  L.COUNTRY_ID,
  L.LOCALITY_TYPE_ID,
  L.REGION_ID,
  L.DISTRICT_ID,
  L.NAME
 FROM CITY C
 INNER JOIN LOCALITY L ON L.ID = C.ID;

CREATE VIEW V_ADDRESS_CITY (
  ID,
  CONTACTABLE_ID,
  COUNTRY_ID,
  LOCALITY_TYPE_ID,
  REGION_ID,
  DISTRICT_ID,
  NAME
) AS
SELECT 
  A.ID,
  A.CONTACTABLE_ID,
  C.COUNTRY_ID,
  C.LOCALITY_TYPE_ID,
  C.REGION_ID,
  C.DISTRICT_ID,
  C.NAME
FROM ADDRESS A
INNER JOIN V_CITY C ON C.ID = A.CITY_ID;

CREATE VIEW V_ADDRESS (
 ID,
 ADDRESS_TYPE_ID,
 CONTACTABLE_ID,
 CITY_ID,
 CITY_NAME,
 LOCALITY_ID,
 LOCALITY_TYPE_NAME,
 LOCALITY_NAME,
 STREET_TYPE_ID,
 ADDRESS_STRING,
 LOCALITY_ADDRESS_STRING, 
 FULL_ADDRESS_STRING,
 ZIP_CODE,
 STREET,
 HOUSE_NUM,
 CASE_NUM,
 APART_NUM,
 NOTE
) AS
SELECT 
 A.ID,
 A.ADDRESS_TYPE_ID,
 A.CONTACTABLE_ID,
 A.CITY_ID,
 C.NAME,
 A.LOCALITY_ID,
 LT.NAME,
 L.NAME,
 A.STREET_TYPE_ID,
 A.ADDRESS_STRING,
 A.LOCALITY_ADDRESS_STRING,
 A.FULL_ADDRESS_STRING,
 A.ZIP_CODE,
 A.STREET,
 A.HOUSE_NUM,
 A.CASE_NUM,
 A.APART_NUM,
 A.NOTE
 FROM ADDRESS A
 LEFT JOIN V_CITY C ON C.ID = A.CITY_ID
 LEFT JOIN LOCALITY L ON L.ID = A.LOCALITY_ID
 LEFT JOIN LOCALITY_TYPE LT ON LT.ID = L.LOCALITY_TYPE_ID;

CREATE VIEW V_CONTACTABLE_ADDRESS (
 CONTACTABLE_ID,
 ADDRESS_ID,
 ADDRESS_TYPE_ID,
 CITY_ID,
 CITY_NAME,
 LOCALITY_ID,
 LOCALITY_TYPE_NAME,
 LOCALITY_NAME,
 STREET_TYPE_ID,
 ADDRESS_STRING,
 FULL_ADDRESS_STRING,
 ZIP_CODE,
 STREET,
 HOUSE_NUM,
 CASE_NUM,
 APART_NUM,
 NOTE,
 OWNER_ID,
 ENTITY_ID
) AS
SELECT 
 C.ID AS CONTACTABLE_ID,
 A.ID AS ADDRESS_ID,
 A.ADDRESS_TYPE_ID,
 A.CITY_ID,
 A.CITY_NAME,
 A.LOCALITY_ID,
 A.LOCALITY_TYPE_NAME,
 A.LOCALITY_NAME,
 A.STREET_TYPE_ID,
 A.ADDRESS_STRING,
 A.FULL_ADDRESS_STRING,
 A.ZIP_CODE,
 A.STREET,
 A.HOUSE_NUM,
 A.CASE_NUM,
 A.APART_NUM,
 A.NOTE,
 C.OWNER_ID,
 C.ENTITY_ID
 FROM CONTACTABLE C 
 INNER JOIN V_ADDRESS A ON A.CONTACTABLE_ID = C.ID;

CREATE VIEW V_DEF_CONTACTABLE_ADDRESS (
 CONTACTABLE_ID,
 ADDRESS_ID,
 ADDRESS_TYPE_ID,
 CITY_ID,
 CITY_NAME,
 LOCALITY_ID,
 LOCALITY_TYPE_NAME,
 LOCALITY_NAME,
 STREET_TYPE_ID,
 ADDRESS_STRING,
 LOCALITY_ADDRESS_STRING,
 FULL_ADDRESS_STRING,
 ZIP_CODE,
 STREET,
 HOUSE_NUM,
 CASE_NUM,
 APART_NUM,
 NOTE,
 OWNER_ID,
 ENTITY_ID
) AS
SELECT 
 C.ID AS CONTACTABLE_ID,
 A.ID AS ADDRESS_ID,
 A.ADDRESS_TYPE_ID,
 A.CITY_ID,
 A.CITY_NAME,
 A.LOCALITY_ID,
 A.LOCALITY_TYPE_NAME,
 A.LOCALITY_NAME,
 A.STREET_TYPE_ID,
 A.ADDRESS_STRING,
 A.LOCALITY_ADDRESS_STRING,
 A.FULL_ADDRESS_STRING,
 A.ZIP_CODE,
 A.STREET,
 A.HOUSE_NUM,
 A.CASE_NUM,
 A.APART_NUM,
 A.NOTE,
 C.OWNER_ID,
 C.ENTITY_ID
 FROM CONTACTABLE C 
 LEFT JOIN V_ADDRESS A ON A.ID = C.ADDRESS_ID;

CREATE VIEW V_DEF_PARTNER_ADDRESS (
 PARTNER_ID,
 CONTACTABLE_ID,
 ADDRESS_ID,
 ADDRESS_TYPE_ID,
 CITY_ID,
 CITY_NAME,
 LOCALITY_ID,
 LOCALITY_TYPE_NAME,
 LOCALITY_NAME,
 STREET_TYPE_ID,
 ADDRESS_STRING,
 LOCALITY_ADDRESS_STRING,
 FULL_ADDRESS_STRING,
 ZIP_CODE,
 STREET,
 HOUSE_NUM,
 CASE_NUM,
 APART_NUM,
 NOTE,
 ENTITY_ID
) AS
SELECT 
 P.ID,
 A.CONTACTABLE_ID,
 A.ADDRESS_ID,
 A.ADDRESS_TYPE_ID,
 A.CITY_ID,
 A.CITY_NAME,
 A.LOCALITY_ID,
 A.LOCALITY_TYPE_NAME,
 A.LOCALITY_NAME,
 A.STREET_TYPE_ID,
 A.ADDRESS_STRING,
 A.LOCALITY_ADDRESS_STRING,
 A.FULL_ADDRESS_STRING,
 A.ZIP_CODE,
 A.STREET,
 A.HOUSE_NUM,
 A.CASE_NUM,
 A.APART_NUM,
 A.NOTE,
 A.ENTITY_ID
 FROM  PARTNER P
 LEFT JOIN V_DEF_CONTACTABLE_ADDRESS A ON A.OWNER_ID = P.ID;

CREATE VIEW V_PHONE (
 ID,
 PHONE_TYPE_ID,
 CONTACTABLE_ID,
 PHONE_CODE,
 PHONE_NUMBER,
 PHONE_STRING,
 PHONE_COMPILE,
 NOTE
) AS
SELECT 
 P.ID,
 P.PHONE_TYPE_ID,
 P.CONTACTABLE_ID,
 P.PHONE_CODE,
 P.PHONE_NUMBER,
 P.PHONE_STRING,
 P.PHONE_COMPILE,
 P.NOTE
 FROM PHONE P;

CREATE VIEW V_CONTACTABLE_PHONE (
 CONTACTABLE_ID,
 PHONE_ID,
 PHONE_TYPE_ID,
 PHONE_CODE,
 PHONE_NUMBER,
 PHONE_STRING,
 PHONE_COMPILE,
 NOTE,
 OWNER_ID,
 ENTITY_ID
) AS
SELECT 
 C.ID AS CONTACTABLE_ID,
 P.ID AS PHONE_ID,
 P.PHONE_TYPE_ID,
 P.PHONE_CODE,
 P.PHONE_NUMBER,
 P.PHONE_STRING,
 P.PHONE_COMPILE,
 P.NOTE,
 C.OWNER_ID,
 C.ENTITY_ID
 FROM CONTACTABLE C 
 INNER JOIN V_PHONE P ON P.CONTACTABLE_ID = C.ID;

CREATE VIEW V_DEF_CONTACTABLE_PHONE (
 CONTACTABLE_ID,
 PHONE_ID,
 PHONE_TYPE_ID,
 PHONE_CODE,
 PHONE_NUMBER,
 PHONE_STRING,
 PHONE_COMPILE,
 NOTE,
 OWNER_ID,
 ENTITY_ID
) AS
SELECT 
 C.ID AS CONTACTABLE_ID,
 P.ID AS PHONE_ID,
 P.PHONE_TYPE_ID,
 P.PHONE_CODE,
 P.PHONE_NUMBER,
 P.PHONE_STRING,
 P.PHONE_COMPILE,
 P.NOTE,
 C.OWNER_ID,
 C.ENTITY_ID
 FROM CONTACTABLE C 
 LEFT JOIN V_PHONE P ON P.ID = C.PHONE_ID;

CREATE VIEW V_DEF_PARTNER_PHONE (
 PARTNER_ID,
 CONTACTABLE_ID,
 PHONE_ID,
 PHONE_TYPE_ID,
 PHONE_CODE,
 PHONE_NUMBER,
 PHONE_STRING,
 PHONE_COMPILE,
 NOTE,
 ENTITY_ID
) AS
SELECT 
 P.ID,
 PH.CONTACTABLE_ID,
 PH.PHONE_ID,
 PH.PHONE_TYPE_ID,
 PH.PHONE_CODE,
 PH.PHONE_NUMBER,
 PH.PHONE_STRING,
 PH.PHONE_COMPILE,
 PH.NOTE,
 PH.ENTITY_ID
 FROM  PARTNER P
 LEFT JOIN V_DEF_CONTACTABLE_PHONE PH ON PH.OWNER_ID = P.ID;
CREATE VIEW V_BANK (
  ID,
  CODE,
  NAME,
  FULL_NAME,
  IDN,
  YEAR_CREATE,
  WORK_TIME,
  NOTE,
  IS_TAX,
  NEC,
  TAX_DOC_NO,
  FORM_PROPERTY_ID,
  PARTNER_GROUP_ID,
  BIC,
  CORRESPONDENT_ACCOUNT,
  STOPPED_PERCENT,
  ADDRESS_ID,
  ADDRESS_TYPE_ID,
  CITY_ID,
  CITY_NAME,
  LOCALITY_ID,
  STREET_TYPE_ID,
  ADDRESS_STRING,
  ZIP_CODE,
  STREET,
  HOUSE_NUM,
  CASE_NUM,
  APART_NUM,
  ADDRESS_NOTE,
  PHONE_ID,
  PHONE_TYPE_ID,
  PHONE_CODE,
  PHONE_NUMBER,
  PHONE_STRING,
  PHONE_NOTE
) AS
SELECT 
  B.ID,
  P.CODE,
  P.NAME,
  P.FULL_NAME,
  P.IDN,
  P.YEAR_CREATE,
  P.WORK_TIME,
  P.NOTE,
  P.IS_TAX,
  P.NEC,
  P.TAX_DOC_NO,
  P.FORM_PROPERTY_ID,
  P.PARTNER_GROUP_ID,
  B.BIC,
  B.CORRESPONDENT_ACCOUNT,
  B.STOPPED_PERCENT,
  DA.ADDRESS_ID,
  DA.ADDRESS_TYPE_ID,
  DA.CITY_ID,
  C.NAME AS CITY_NAME,
  DA.LOCALITY_ID,
  DA.STREET_TYPE_ID,
  DA.ADDRESS_STRING,
  DA.ZIP_CODE,
  DA.STREET,
  DA.HOUSE_NUM,
  DA.CASE_NUM,
  DA.APART_NUM,
  DA.NOTE AS ADDRESS_NOTE,
  DP.PHONE_ID,
  DP.PHONE_TYPE_ID,
  DP.PHONE_CODE,
  DP.PHONE_NUMBER,
  DP.PHONE_STRING,
  DP.NOTE AS PHONE_NOTE
 FROM BANK B
 INNER JOIN PARTNER P ON P.ID = B.ID
 INNER JOIN V_DEF_PARTNER_ADDRESS DA ON DA.PARTNER_ID = P.ID
 INNER JOIN V_DEF_PARTNER_PHONE DP ON DP.PARTNER_ID = P.ID
 LEFT JOIN V_CITY C ON C.ID = DA.CITY_ID;

CREATE VIEW V_PARTNER_BANK_ACCOUNT (
  ID,
  BANK_ID,
  PARTNER_ID,
  NAME,
  ACCOUNT_NO
) AS
SELECT 
  BA.ID,
  BA.BANK_ID,
  BA.PARTNER_ID,
  BA.NAME,
  BA.ACCOUNT_NO
FROM BANK_ACCOUNT BA;

CREATE VIEW V_PAYMENT_INCOME (
    ID,
    ORGANIZATION_ID,
    ORGANIZATION_NAME,
    ORGANIZATION_CODE,
    ORGANIZATION_NEC,
    ORGANIZATION_IDN,
    ORGANIZATION_TYPE_ID,
    DOCUMENT_TYPE_ID,
    DOCUMENT_TYPE_CODE,
    DOCUMENT_TYPE_NAME,
    PERIOD_ID,
    DOCUMENT_NO,
    DOCUMENT_DATE,
    USER_ID,
    USER_NAME,
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
    PARTNER_BANK_BIC,
    PARTNER_BANK_NAME,
    PARTNER_BANK_CITY_NAME,
    ORGANIZATION_BANK_ACCOUNT_ID,
    ORGANIZATION_BANK_ACCOUNT_NO,
    ORGANIZATION_BANK_BIC,
    ORGANIZATION_BANK_NAME,
    ORGANIZATION_BANK_CITY_NAME,
    PARTNER_ID,
    PARTNER_NAME,
    PARTNER_CODE,
    PARTNER_NEC,
    PARTNER_IDN,
    PARTNER_TYPE_ID,
    RESPONSIBLE_ID,
    PAYMENT_MISSING,
    TAXPRINT_TYPE_ID
) AS
SELECT
  PAY.ID,
  FD.ORGANIZATION_ID,
  FD.ORGANIZATION_NAME,
  FD.ORGANIZATION_CODE,
  FD.ORGANIZATION_NEC,
  FD.ORGANIZATION_IDN,
  FD.ORGANIZATION_TYPE_ID,
  FD.DOCUMENT_TYPE_ID, 
  FD.DOCUMENT_TYPE_CODE,
  FD.DOCUMENT_TYPE_NAME,
  FD.PERIOD_ID,
  FD.DOCUMENT_NO, 
  FD.DOCUMENT_DATE,
  FD.USER_ID,
  FD.USER_NAME,
  FD.CONTRACT_ID,
  FD.REASON_DOCUMENT_ID,
  FD.REASON,
  FD.NOTE,
  FD.CURRENCY_ID,
  FD.AMOUNT_WITH_TAX,
  FD.TAX_AMOUNT, 
  FD.AMOUNT,
  FD.CURRENCY_AMOUNT_WITH_TAX,
  FD.CURRENCY_TAX_AMOUNT,
  FD.CURRENCY_AMOUNT,
  FD.TOTAL,
  FD.TOTAL_WITH_TAX,
  FD.TAX_TOTAL,
  FD.CURRENCY_TOTAL,
  FD.CURRENCY_TOTAL_WITH_TAX,
  FD.CURRENCY_TAX_TOTAL,
  FD.DOCUMENT_AMOUNT,
  FD.DOCUMENT_TOTAL,
  FD.CURRENCY_DOCUMENT_AMOUNT,
  FD.CURRENCY_DOCUMENT_TOTAL,
  PAY.PARTNER_BANK_ACCOUNT_ID,
  PRT_BA.ACCOUNT_NO AS PARTNER_BANK_ACCOUNT_NO,
  PRT_BK.BIC AS PARTNER_BANK_BIC,
  PRT_BK.NAME AS PARTNER_BANK_NAME,
  PRT_BK.CITY_NAME AS PARTNER_BANK_CITY_NAME,
  PAY.ORGANIZATION_BANK_ACCOUNT_ID,
  ORG_BA.ACCOUNT_NO AS ORGANIZATION_BANK_ACCOUNT_NO,
  ORG_BK.BIC AS ORGANIZATION_BANK_BIC,
  ORG_BK.NAME AS ORGANIZATION_BANK_NAME,
  ORG_BK.CITY_NAME AS ORGANIZATION_BANK_CITY_NAME,
  FD.PARTNER_ID,
  PRT.NAME AS PARTNER_NAME,
  PRT.CODE AS PARTNER_CODE,
  PRT.NEC AS PARTNER_NEC,
  PRT.IDN AS PARTNER_IDN,
  PRT.PARTNER_TYPE_ID AS PARTNER_TYPE_ID,
  FD.RESPONSIBLE_ID,
  PAY.PAYMENT_MISSING,
  PAY.TAXPRINT_TYPE_ID
 FROM PAYMENT_INCOME PAY
 INNER JOIN V_FINANCE_DOCUMENT FD ON FD.ID = PAY.ID
 INNER JOIN ORGANIZATION ORG ON ORG.ID= FD.ORGANIZATION_ID
 INNER JOIN BANK_ACCOUNT ORG_BA ON ORG_BA.ID = PAY.ORGANIZATION_BANK_ACCOUNT_ID
 INNER JOIN V_BANK ORG_BK ON ORG_BK.ID = ORG_BA.BANK_ID
 INNER JOIN BANK_ACCOUNT PRT_BA ON PRT_BA.ID = PAY.PARTNER_BANK_ACCOUNT_ID
 INNER JOIN V_BANK PRT_BK ON PRT_BK.ID = PRT_BA.BANK_ID
 INNER JOIN PARTNER PRT ON PRT.ID = FD.PARTNER_ID;
 
CREATE VIEW V_PAYMENT_OUTCOME (
    ID,
    ORGANIZATION_ID,
    ORGANIZATION_NAME,
    ORGANIZATION_CODE,
    ORGANIZATION_NEC,
    ORGANIZATION_IDN,
    ORGANIZATION_TYPE_ID,
    DOCUMENT_TYPE_ID,
    DOCUMENT_TYPE_CODE,
    DOCUMENT_TYPE_NAME,
    PERIOD_ID,
    DOCUMENT_NO,
    DOCUMENT_DATE,
    USER_ID,
    USER_NAME,
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
    PARTNER_BANK_BIC,
    PARTNER_BANK_NAME,
    PARTNER_BANK_CITY_NAME,
    ORGANIZATION_BANK_ACCOUNT_ID,
    ORGANIZATION_BANK_ACCOUNT_NO,
    ORGANIZATION_BANK_BIC,
    ORGANIZATION_BANK_NAME,
    ORGANIZATION_BANK_CITY_NAME,
    PARTNER_ID,
    PARTNER_NAME,
    PARTNER_CODE,
    PARTNER_NEC,
    PARTNER_IDN,
    PARTNER_TYPE_ID,
    RESPONSIBLE_ID,
    PAYMENT_MISSING,
    TAXPRINT_TYPE_ID
) AS
SELECT
  PAY.ID,
  FD.ORGANIZATION_ID,
  FD.ORGANIZATION_NAME,
  FD.ORGANIZATION_CODE,
  FD.ORGANIZATION_NEC,
  FD.ORGANIZATION_IDN,
  FD.ORGANIZATION_TYPE_ID,
  FD.DOCUMENT_TYPE_ID, 
  FD.DOCUMENT_TYPE_CODE,
  FD.DOCUMENT_TYPE_NAME,
  FD.PERIOD_ID,
  FD.DOCUMENT_NO, 
  FD.DOCUMENT_DATE,
  FD.USER_ID,
  FD.USER_NAME,
  FD.CONTRACT_ID,
  FD.REASON_DOCUMENT_ID,
  FD.REASON,
  FD.NOTE,
  FD.CURRENCY_ID,
  FD.AMOUNT_WITH_TAX,
  FD.TAX_AMOUNT, 
  FD.AMOUNT,
  FD.CURRENCY_AMOUNT_WITH_TAX,
  FD.CURRENCY_TAX_AMOUNT,
  FD.CURRENCY_AMOUNT,
  FD.TOTAL,
  FD.TOTAL_WITH_TAX,
  FD.TAX_TOTAL,
  FD.CURRENCY_TOTAL,
  FD.CURRENCY_TOTAL_WITH_TAX,
  FD.CURRENCY_TAX_TOTAL,
  FD.DOCUMENT_AMOUNT,
  FD.DOCUMENT_TOTAL,
  FD.CURRENCY_DOCUMENT_AMOUNT,
  FD.CURRENCY_DOCUMENT_TOTAL,
  PAY.PARTNER_BANK_ACCOUNT_ID,
  PRT_BA.ACCOUNT_NO AS PARTNER_BANK_ACCOUNT_NO,
  PRT_BK.BIC AS PARTNER_BANK_BIC,
  PRT_BK.NAME AS PARTNER_BANK_NAME,
  PRT_BK.CITY_NAME AS PARTNER_BANK_CITY_NAME,
  PAY.ORGANIZATION_BANK_ACCOUNT_ID,
  ORG_BA.ACCOUNT_NO AS ORGANIZATION_BANK_ACCOUNT_NO,
  ORG_BK.BIC AS ORGANIZATION_BANK_BIC,
  ORG_BK.NAME AS ORGANIZATION_BANK_NAME,
  ORG_BK.CITY_NAME AS ORGANIZATION_BANK_CITY_NAME,
  FD.PARTNER_ID,
  PRT.NAME AS PARTNER_NAME,
  PRT.CODE AS PARTNER_CODE,
  PRT.NEC AS PARTNER_NEC,
  PRT.IDN AS PARTNER_IDN,
  PRT.PARTNER_TYPE_ID AS PARTNER_TYPE_ID,
  FD.RESPONSIBLE_ID,
  PAY.PAYMENT_MISSING,
  PAY.TAXPRINT_TYPE_ID
 FROM PAYMENT_OUTCOME PAY
 INNER JOIN V_FINANCE_DOCUMENT FD ON FD.ID = PAY.ID
 INNER JOIN ORGANIZATION ORG ON ORG.ID= FD.ORGANIZATION_ID
 INNER JOIN BANK_ACCOUNT ORG_BA ON ORG_BA.ID = PAY.ORGANIZATION_BANK_ACCOUNT_ID
 INNER JOIN V_BANK ORG_BK ON ORG_BK.ID = ORG_BA.BANK_ID
 INNER JOIN BANK_ACCOUNT PRT_BA ON PRT_BA.ID = PAY.PARTNER_BANK_ACCOUNT_ID
 INNER JOIN V_BANK PRT_BK ON PRT_BK.ID = PRT_BA.BANK_ID
 INNER JOIN PARTNER PRT ON PRT.ID = FD.PARTNER_ID;
 
 

CREATE VIEW V_PAYMENT (
    ID,
    ORGANIZATION_ID,
    DEBIT_PARTNER_ID,
    DEBIT_PARTNER_NAME,
    DEBIT_PARTNER_CODE,
    DEBIT_PARTNER_NEC,
    DEBIT_PARTNER_IDN,
    DEBIT_PARTNER_TYPE_ID,
    CREDIT_PARTNER_ID,
    CREDIT_PARTNER_NAME,
    CREDIT_PARTNER_CODE,
    CREDIT_PARTNER_NEC,
    CREDIT_PARTNER_IDN,
    CREDIT_PARTNER_TYPE_ID,
    DOCUMENT_TYPE_ID,
    DOCUMENT_TYPE_CODE,
    DOCUMENT_TYPE_NAME,
    PERIOD_ID,
    DOCUMENT_NO,
    DOCUMENT_DATE,
    RESPONSIBLE_ID,
    USER_ID,
    USER_NAME,
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
    DEBIT_PARTNER_BANK_BIC,
    DEBIT_PARTNER_BANK_NAME,
    DEBIT_PARTNER_BANK_CITY_NAME,
    CREDIT_PARTNER_BANK_ACCOUNT_NO,
    CREDIT_PARTNER_BANK_BIC,
    CREDIT_PARTNER_BANK_NAME,
    CREDIT_PARTNER_BANK_CITY_NAME,
    PAYMENT_MISSING,
    TAXPRINT_TYPE_ID
) AS
SELECT
  P.ID,
  P.ORGANIZATION_ID,
  P.ORGANIZATION_ID,
  P.ORGANIZATION_NAME,
  P.ORGANIZATION_CODE,
  P.ORGANIZATION_NEC,
  P.ORGANIZATION_IDN,
  P.ORGANIZATION_TYPE_ID,
  P.PARTNER_ID,
  P.PARTNER_NAME,
  P.PARTNER_CODE,
  P.PARTNER_NEC,
  P.PARTNER_IDN,
  P.PARTNER_TYPE_ID,
  P.DOCUMENT_TYPE_ID,
  P.DOCUMENT_TYPE_CODE,
  P.DOCUMENT_TYPE_NAME,
  P.PERIOD_ID,
  P.DOCUMENT_NO,
  P.DOCUMENT_DATE,
  P.RESPONSIBLE_ID,
  P.USER_ID,
  P.USER_NAME,
  P.CONTRACT_ID,
  P.REASON_DOCUMENT_ID,
  P.REASON,
  P.NOTE,
  P.CURRENCY_ID,
  P.AMOUNT_WITH_TAX,
  P.TAX_AMOUNT,
  P.AMOUNT,
  P.CURRENCY_AMOUNT_WITH_TAX,
  P.CURRENCY_TAX_AMOUNT,
  P.CURRENCY_AMOUNT,
  P.TOTAL,
  P.TOTAL_WITH_TAX,
  P.TAX_TOTAL,
  P.CURRENCY_TOTAL,
  P.CURRENCY_TOTAL_WITH_TAX,
  P.CURRENCY_TAX_TOTAL,
  P.DOCUMENT_AMOUNT,
  P.DOCUMENT_TOTAL,
  P.CURRENCY_DOCUMENT_AMOUNT,
  P.CURRENCY_DOCUMENT_TOTAL,
  P.ORGANIZATION_BANK_ACCOUNT_NO,
  P.ORGANIZATION_BANK_BIC,
  P.ORGANIZATION_BANK_NAME,
  P.ORGANIZATION_BANK_CITY_NAME,
  P.PARTNER_BANK_ACCOUNT_NO,
  P.PARTNER_BANK_BIC,
  P.PARTNER_BANK_NAME,
  P.PARTNER_BANK_CITY_NAME,
  P.PAYMENT_MISSING,
  P.TAXPRINT_TYPE_ID
 FROM V_PAYMENT_OUTCOME P
 UNION ALL
SELECT
  P.ID,
  P.ORGANIZATION_ID,
  P.PARTNER_ID,
  P.PARTNER_NAME,
  P.PARTNER_CODE,
  P.PARTNER_NEC,
  P.PARTNER_IDN,
  P.PARTNER_TYPE_ID,
  P.ORGANIZATION_ID,
  P.ORGANIZATION_NAME,
  P.ORGANIZATION_CODE,
  P.ORGANIZATION_NEC,
  P.ORGANIZATION_IDN,
  P.ORGANIZATION_TYPE_ID,
  P.DOCUMENT_TYPE_ID,
  P.DOCUMENT_TYPE_CODE,
  P.DOCUMENT_TYPE_NAME,
  P.PERIOD_ID,
  P.DOCUMENT_NO,
  P.DOCUMENT_DATE,
  P.RESPONSIBLE_ID,
  P.USER_ID,
  P.USER_NAME,
  P.CONTRACT_ID,
  P.REASON_DOCUMENT_ID,
  P.REASON,
  P.NOTE,
  P.CURRENCY_ID,
  P.AMOUNT_WITH_TAX,
  P.TAX_AMOUNT,
  P.AMOUNT,
  P.CURRENCY_AMOUNT_WITH_TAX,
  P.CURRENCY_TAX_AMOUNT,
  P.CURRENCY_AMOUNT,
  P.TOTAL,
  P.TOTAL_WITH_TAX,
  P.TAX_TOTAL,
  P.CURRENCY_TOTAL,
  P.CURRENCY_TOTAL_WITH_TAX,
  P.CURRENCY_TAX_TOTAL,
  P.DOCUMENT_AMOUNT,
  P.DOCUMENT_TOTAL,
  P.CURRENCY_DOCUMENT_AMOUNT,
  P.CURRENCY_DOCUMENT_TOTAL,
  P.PARTNER_BANK_ACCOUNT_NO,
  P.PARTNER_BANK_BIC,
  P.PARTNER_BANK_NAME,
  P.PARTNER_BANK_CITY_NAME,
  P.ORGANIZATION_BANK_ACCOUNT_NO,
  P.ORGANIZATION_BANK_BIC,
  P.ORGANIZATION_BANK_NAME,
  P.ORGANIZATION_BANK_CITY_NAME,
  P.PAYMENT_MISSING,
  P.TAXPRINT_TYPE_ID
 FROM V_PAYMENT_INCOME P;
 
 
CREATE VIEW V_PAYMENT_ROTATE (
    ID,
    ORGANIZATION_ID,
    PARTNER_ID,
    PARTNER_NAME,
    PARTNER_CODE,
    PARTNER_NEC,
    PARTNER_IDN,
    DOCUMENT_TYPE_ID,
    DOCUMENT_TYPE_CODE,
    DOCUMENT_TYPE_NAME,
    PERIOD_ID,
    DOCUMENT_NO,
    DOCUMENT_DATE,
    RESPONSIBLE_ID,
    USER_ID,
    USER_NAME,
    CONTRACT_ID,
    REASON_DOCUMENT_ID,
    REASON,
    NOTE,
    CURRENCY_ID,
    DEBIT_AMOUNT,
    CREDIT_AMOUNT,
    PARTNER_BANK_ACCOUNT_ID,
    PARTNER_BANK_ACCOUNT_NO,
    PARTNER_BANK_BIC,
    PARTNER_BANK_NAME,
    PARTNER_BANK_CITY_NAME,
    ORGANIZATION_BANK_ACCOUNT_ID,
    ORGANIZATION_BANK_ACCOUNT_NO,
    ORGANIZATION_BANK_BIC,
    ORGANIZATION_BANK_NAME,
    ORGANIZATION_BANK_CITY_NAME,
    PAYMENT_MISSING
) AS
SELECT
  P.ID,
  P.ORGANIZATION_ID,
  P.PARTNER_ID,
  P.PARTNER_NAME,
  P.PARTNER_CODE,
  P.PARTNER_NEC,
  P.PARTNER_IDN,
  P.DOCUMENT_TYPE_ID,
  P.DOCUMENT_TYPE_CODE,
  P.DOCUMENT_TYPE_NAME,
  P.PERIOD_ID,
  P.DOCUMENT_NO,
  P.DOCUMENT_DATE,
  P.RESPONSIBLE_ID,
  P.USER_ID,
  P.USER_NAME,
  P.CONTRACT_ID,
  P.REASON_DOCUMENT_ID,
  P.REASON,
  P.NOTE,
  P.CURRENCY_ID,
  P.DOCUMENT_TOTAL AS DEBIT_AMOUNT,
  0.0 AS CREDIT_AMOUNT,
  P.PARTNER_BANK_ACCOUNT_ID,
  P.PARTNER_BANK_ACCOUNT_NO,
  P.PARTNER_BANK_BIC,
  P.PARTNER_BANK_NAME,
  P.PARTNER_BANK_CITY_NAME,
  P.ORGANIZATION_BANK_ACCOUNT_ID,
  P.ORGANIZATION_BANK_ACCOUNT_NO,
  P.ORGANIZATION_BANK_BIC,
  P.ORGANIZATION_BANK_NAME,
  P.ORGANIZATION_BANK_CITY_NAME,
  P.PAYMENT_MISSING
 FROM V_PAYMENT_OUTCOME P
 UNION ALL
SELECT
  P.ID,
  P.ORGANIZATION_ID,
  P.PARTNER_ID,
  P.PARTNER_NAME,
  P.PARTNER_CODE,
  P.PARTNER_NEC,
  P.PARTNER_IDN,
  P.DOCUMENT_TYPE_ID,
  P.DOCUMENT_TYPE_CODE,
  P.DOCUMENT_TYPE_NAME,
  P.PERIOD_ID,
  P.DOCUMENT_NO,
  P.DOCUMENT_DATE,
  P.RESPONSIBLE_ID,
  P.USER_ID,
  P.USER_NAME,
  P.CONTRACT_ID,
  P.REASON_DOCUMENT_ID,
  P.REASON,
  P.NOTE,
  P.CURRENCY_ID,
  0.0 AS DEBIT_AMOUNT,
  P.DOCUMENT_TOTAL AS CREDIT_AMOUNT,
  P.PARTNER_BANK_ACCOUNT_ID,
  P.PARTNER_BANK_ACCOUNT_NO,
  P.PARTNER_BANK_BIC,
  P.PARTNER_BANK_NAME,
  P.PARTNER_BANK_CITY_NAME,
  P.ORGANIZATION_BANK_ACCOUNT_ID,
  P.ORGANIZATION_BANK_ACCOUNT_NO,
  P.ORGANIZATION_BANK_BIC,
  P.ORGANIZATION_BANK_NAME,
  P.ORGANIZATION_BANK_CITY_NAME,
  P.PAYMENT_MISSING
 FROM V_PAYMENT_INCOME P;


CREATE VIEW V_BUSINESSABLE (
  ID, 
  OWNER_ID, 
  ENTITY_ID, 
  ENTITY_CODE, 
  ENTITY_NAME, 
  NAME
) AS 
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, CAST(O.NAME AS VARCHAR(100))
 FROM BUSINESSABLE B
 INNER JOIN DEPARTMENT O ON O.ID = B.OWNER_ID
 INNER JOIN SYS_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'DEPARTMENT'
UNION ALL
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, CAST(O.NAME AS VARCHAR(100))
 FROM BUSINESSABLE B
 INNER JOIN STORE O ON O.ID = B.OWNER_ID
 INNER JOIN SYS_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'STORE'
UNION ALL
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, CAST(O.MTRL_RESPONSIBLE_NAME AS VARCHAR(100))
 FROM BUSINESSABLE B
 INNER JOIN V_MTRL_RESPONSIBLE O ON O.ID = B.OWNER_ID
 INNER JOIN SYS_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'MTRL_RESPONSIBLE'
UNION ALL
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, CAST(O.NAME AS VARCHAR(100))
 FROM BUSINESSABLE B
 INNER JOIN PARTNER O ON O.ID = B.OWNER_ID
 INNER JOIN SYS_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'PARTNER'
UNION ALL
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, CAST(O.NAME AS VARCHAR(100))
 FROM BUSINESSABLE B
 INNER JOIN V_BANK O ON O.ID = B.OWNER_ID
 INNER JOIN SYS_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'BANK'
UNION ALL
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, CAST(O.PRODUCT_NAME AS VARCHAR(100))
 FROM BUSINESSABLE B
 INNER JOIN V_GOODS O ON O.ID = B.OWNER_ID
 INNER JOIN SYS_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'GOODS'
UNION ALL
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, CAST(O.PRODUCT_NAME AS VARCHAR(100))
 FROM BUSINESSABLE B
 INNER JOIN V_ASSET O ON O.ID = B.OWNER_ID
 INNER JOIN SYS_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'ASSET'
UNION ALL
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, CAST(O.NAME AS VARCHAR(100))
 FROM BUSINESSABLE B
 INNER JOIN V_EMPLOYEE O ON O.ID = B.OWNER_ID
 INNER JOIN SYS_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'EMPLOYEE';

CREATE VIEW V_PARTNER_REGISTER (
 ID,
 ORGANIZATION_ID,
 PERIOD_ID,
 PARTNER_ID,
 DEBIT_AMOUNT,
 CREDIT_AMOUNT
) AS 
SELECT 
 R.ID,
 R.ORGANIZATION_ID,
 R.PERIOD_ID,
 R.PARTNER_ID,
 R.DEBIT_AMOUNT,
 R.CREDIT_AMOUNT
 FROM PARTNER_REGISTER R;


CREATE VIEW V_PARTNER_MOVE (
  ID,
  DOCUMENT_ID,
  PARTNER_ID,
  PARTNER_NAME,
  AMOUNT,
  AMOUNT_WITH_TAX,
  TAX_AMOUNT
) AS
SELECT 
  M.ID,
  M.OWNER_ID AS DOCUMENT_ID,
  M.PARTNER_ID,
  P.NAME AS PARTNER_NAME,
  M.AMOUNT,
  M.AMOUNT_WITH_TAX,
  M.TAX_AMOUNT
 FROM PARTNER_MOVE M
 INNER JOIN PARTNER P ON P.ID = M.PARTNER_ID;

CREATE VIEW V_GOODS_REGISTER (
 ID,
 ORGANIZATION_ID,
 PERIOD_ID,
 GOODS_ID,
 QUANTITY,
 PRICE,
 AMOUNT
) AS
SELECT 
 R.ID,
 R.ORGANIZATION_ID,
 R.PERIOD_ID,
 R.PRODUCT_ID AS GOODS_ID,
 R.QUANTITY,
 R.PRICE,
 R.AMOUNT
FROM PRODUCT_REGISTER R
INNER JOIN GOODS G ON G.ID = R.PRODUCT_ID;


CREATE VIEW V_GOODS_DETAIL_REGISTER (
 ID,
 ORGANIZATION_ID,
 PERIOD_ID,
 GOODS_ID,
 WAREHOUSE_ID,
 MTRL_RESPONSIBLE_ID,
 QUANTITY,
 AMOUNT
) AS
SELECT 
 R.ID,
 R.ORGANIZATION_ID,
 R.PERIOD_ID,
 R.PRODUCT_ID AS GOODS_ID,
 R.WAREHOUSE_ID,
 R.MTRL_RESPONSIBLE_ID,
 R.QUANTITY,
 R.AMOUNT
FROM PRODUCT_DETAIL_REGISTER R
INNER JOIN GOODS G ON G.ID = R.PRODUCT_ID;



CREATE VIEW V_GOODS_SALE (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_ID,
  DOCUMENT_NO,
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
  QUANTITY,
  AMOUNT,
  DOCUMENT_AMOUNT
) AS
SELECT 
  FD.PERIOD_ID,
  FD.ORGANIZATION_ID,
  FD.ID AS DOCUMENT_ID,
  FD.DOCUMENT_NO,
  FD.DOCUMENT_DATE,
  FD.DOCUMENT_YEAR,
  FD.DOCUMENT_MONTH,
  I.PRODUCT_ID,
  I.PRODUCT_CODE,
  I.PRODUCT_NAME,
  I.ITEM_UNIT_ID,
  I.UNIT_ID,
  I.UNIT_NAME,
  I.PRODUCT_PRICE,
  I.ITEM_ACCOUNT_PRICE AS PRICE,
  I.ITEM_PRICE AS ITEM_PRICE,
  I.ACCOUNT_QUANTITY AS QUANTITY,
  I.ITEM_AMOUNT AS AMOUNT,
  FD.DOCUMENT_AMOUNT
 FROM V_PRODUCT_MOVE I
 INNER JOIN V_FINANCE_DOCUMENT FD ON FD.ID = I.DOCUMENT_ID
 INNER JOIN DOCUMENT_TYPE T ON T.ID = FD.DOCUMENT_TYPE_ID 
 AND T.DOCUMENT_SECTION = 'GOODS' AND T.DOCUMENT_CATEGORY = 'SALE';

/* USE IS_COMPLETE */


CREATE VIEW V_GOODS_PURCHASE (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_ID,
  DOCUMENT_NO,
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
  QUANTITY,
  AMOUNT,
  DOCUMENT_AMOUNT,
  WAREHOUSE_ID,
  WAREHOUSE_NAME,
  PARTNER_ID,
  PARTNER_NAME
) AS
SELECT 
  FD.PERIOD_ID,
  FD.ORGANIZATION_ID,
  FD.ID AS DOCUMENT_ID,
  FD.DOCUMENT_NO,
  FD.DOCUMENT_DATE,
  FD.DOCUMENT_YEAR,
  FD.DOCUMENT_MONTH,
  I.PRODUCT_ID,
  I.PRODUCT_CODE,
  I.PRODUCT_NAME,
  I.ITEM_UNIT_ID,
  I.UNIT_ID,
  I.UNIT_NAME,
  I.PRODUCT_PRICE,
  I.ITEM_ACCOUNT_PRICE AS PRICE,
  I.ITEM_PRICE AS ITEM_PRICE,
  I.ACCOUNT_QUANTITY AS QUANTITY,
  I.ITEM_AMOUNT AS AMOUNT,
  FD.DOCUMENT_AMOUNT,
  STO.WAREHOUSE_ID,
  STO.WAREHOUSE_NAME,
  PRT.PARTNER_ID,
  PRT.PARTNER_NAME
 FROM V_PRODUCT_MOVE I
 INNER JOIN V_FINANCE_DOCUMENT FD ON FD.ID = I.DOCUMENT_ID
 INNER JOIN V_WAREHOUSE_MOVE STO ON STO.DOCUMENT_ID = FD.ID
 INNER JOIN V_PARTNER_MOVE PRT ON PRT.DOCUMENT_ID = FD.ID
 INNER JOIN DOCUMENT_TYPE T ON T.ID = FD.DOCUMENT_TYPE_ID 
 AND T.DOCUMENT_SECTION = 'GOODS' AND T.DOCUMENT_CATEGORY = 'PURCHASE';

/* USE IS_COMPLETE */


CREATE VIEW V_RPT_GOODS_INCOME (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_ID,
  DOCUMENT_NO,
  DOCUMENT_DATE,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRICE,
  QUANTITY,
  AMOUNT,
  DOCUMENT_AMOUNT,
  WAREHOUSE_ID,
  WAREHOUSE_NAME,
  PARTNER_ID,
  PARTNER_NAME
) AS
SELECT
  FD.PERIOD_ID,
  FD.ORGANIZATION_ID,
  I.GOODS_INCOME_ID,
  FD.DOCUMENT_NO,
  FD.DOCUMENT_DATE,
  I.PRODUCT_ID,
  P.PRODUCT_CODE,
  P.PRODUCT_NAME,
  I.UNIT_ID,
  I.UNIT_ID,
  U.NAME,
  I.PRICE,
  I.QUANTITY,
  I.AMOUNT,
  FD.DOCUMENT_AMOUNT,
  D.WAREHOUSE_ID,
  STO.NAME,
  FD.PARTNER_ID,
  PRT.NAME
 FROM GOODS_INCOME_ITEM I
 INNER JOIN GOODS_INCOME D ON D.ID = I.GOODS_INCOME_ID
 INNER JOIN V_FINANCE_DOCUMENT FD ON FD.ID = D.ID
 INNER JOIN V_PRODUCT P ON P.ID = I.PRODUCT_ID
 INNER JOIN UNIT U ON U.ID = I.UNIT_ID
 INNER JOIN V_WAREHOUSE STO ON STO.ID = D.WAREHOUSE_ID
 INNER JOIN PARTNER PRT ON PRT.ID = FD.PARTNER_ID;
 

CREATE VIEW V_RPT_GOODS_OUTCOME (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_ID,
  DOCUMENT_NO,
  DOCUMENT_DATE,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRICE,
  QUANTITY,
  AMOUNT,
  DOCUMENT_AMOUNT,
  WAREHOUSE_ID,
  WAREHOUSE_NAME,
  PARTNER_ID,
  PARTNER_NAME
) AS
SELECT 
  FD.PERIOD_ID,
  FD.ORGANIZATION_ID,
  I.GOODS_OUTCOME_ID,
  FD.DOCUMENT_NO,
  FD.DOCUMENT_DATE,
  I.PRODUCT_ID,
  P.PRODUCT_CODE,
  P.PRODUCT_NAME,
  I.UNIT_ID,
  I.UNIT_ID,
  U.NAME,
  I.PRICE,
  I.QUANTITY,
  I.AMOUNT,
  FD.DOCUMENT_AMOUNT,
  D.WAREHOUSE_ID,
  STO.NAME,
  FD.PARTNER_ID,
  PRT.NAME
 FROM GOODS_OUTCOME_ITEM I
 INNER JOIN GOODS_OUTCOME D ON D.ID = I.GOODS_OUTCOME_ID
 INNER JOIN V_FINANCE_DOCUMENT FD ON FD.ID = D.ID
 INNER JOIN V_PRODUCT P ON P.ID = I.PRODUCT_ID
 INNER JOIN UNIT U ON U.ID = I.UNIT_ID
 INNER JOIN V_WAREHOUSE STO ON STO.ID = D.WAREHOUSE_ID
 INNER JOIN PARTNER PRT ON PRT.ID = FD.PARTNER_ID;


CREATE VIEW V_RPT_GOODS_REST (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_ID,
  DOCUMENT_NO,
  DOCUMENT_DATE,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRODUCT_PRICE,
  QUANTITY,
  PRICE,
  AMOUNT,
  WAREHOUSE_ID
) AS
SELECT 
  FD.PERIOD_ID,
  FD.ORGANIZATION_ID,
  I.INVENTORY_REST_ID,
  FD.DOCUMENT_NO,
  FD.DOCUMENT_DATE,
  I.PRODUCT_ID,
  P.PRODUCT_CODE,
  P.PRODUCT_NAME,
  I.UNIT_ID,
  P.UNIT_ID,
  U.NAME,
  P.PRICE AS PRODUCT_PRICE,
  I.ACCOUNT_QUANTITY AS QUANTITY,
  I.ACCOUNT_PRICE AS PRICE,
  I.AMOUNT,
  D.WAREHOUSE_ID
 FROM INVENTORY_REST_ITEM I
 INNER JOIN INVENTORY_REST D ON D.ID = I.INVENTORY_REST_ID
 INNER JOIN V_FINANCE_DOCUMENT FD ON FD.ID = D.ID
 INNER JOIN V_PRODUCT P ON P.ID = I.PRODUCT_ID
 INNER JOIN UNIT U ON U.ID = P.UNIT_ID;

CREATE VIEW V_RPT_INVOICE (
  PERIOD_ID,
  ORGANIZATION_ID,
  INVOICE_ID,
  DOCUMENT_NO,
  DOCUMENT_DATE,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRICE,
  QUANTITY,
  AMOUNT,
  DOCUMENT_AMOUNT,
  PARTNER_ID,
  PARTNER_NAME
) AS
SELECT 
  FD.PERIOD_ID,
  FD.ORGANIZATION_ID,
  I.SALE_INVOICE_ID,
  FD.DOCUMENT_NO,
  FD.DOCUMENT_DATE,
  I.PRODUCT_ID,
  P.PRODUCT_CODE,
  P.PRODUCT_NAME,
  I.UNIT_ID,
  I.UNIT_ID,
  U.NAME,
  I.PRICE,
  I.QUANTITY,
  I.AMOUNT,
  FD.DOCUMENT_AMOUNT,
  FD.PARTNER_ID,
  PRT.NAME
 FROM SALE_INVOICE_ITEM I
 INNER JOIN SALE_INVOICE D ON D.ID = I.SALE_INVOICE_ID
 INNER JOIN V_FINANCE_DOCUMENT FD ON FD.ID = D.ID 
 INNER JOIN V_PRODUCT P ON P.ID = I.PRODUCT_ID
 INNER JOIN UNIT U ON U.ID = I.UNIT_ID
 INNER JOIN PARTNER PRT ON PRT.ID = FD.PARTNER_ID;

CREATE VIEW V_RPT_GOODS_REGISTER (
  PERIOD_ID,
  ORGANIZATION_ID,
  GOODS_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  UNIT_ID,
  UNIT_NAME,
  PRODUCT_PRICE,
  PRICE,
  QUANTITY,
  AMOUNT
) AS
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.GOODS_ID,
  P.PRODUCT_CODE,
  P.PRODUCT_NAME,
  P.UNIT_ID,
  U.NAME,
  P.PRICE AS PRODUCT_PRICE,
  R.PRICE,
  R.QUANTITY,
  R.AMOUNT
 FROM V_GOODS_REGISTER R
 INNER JOIN GOODS G ON G.ID = R.GOODS_ID
 INNER JOIN V_PRODUCT P ON P.ID = G.ID
 INNER JOIN UNIT U ON U.ID = P.UNIT_ID;

CREATE VIEW V_RPT_GOODS_SALE (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_ID,
  DOCUMENT_NO,
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
  QUANTITY,
  AMOUNT,
  DOCUMENT_AMOUNT,
  WAREHOUSE_ID,
  WAREHOUSE_NAME,
  PARTNER_ID,
  PARTNER_NAME
) AS
SELECT
  S.PERIOD_ID,
  S.ORGANIZATION_ID,
  S.DOCUMENT_ID,
  S.DOCUMENT_NO,
  S.DOCUMENT_DATE,
  S.DOCUMENT_YEAR,
  S.DOCUMENT_MONTH,
  S.PRODUCT_ID,
  S.PRODUCT_CODE,
  S.PRODUCT_NAME,
  S.ITEM_UNIT_ID,
  S.UNIT_ID,
  S.UNIT_NAME,
  S.PRODUCT_PRICE,
  S.PRICE,
  S.ITEM_PRICE,
  S.QUANTITY,
  S.AMOUNT,
  S.DOCUMENT_AMOUNT,
  WRH.WAREHOUSE_ID,
  WRH.WAREHOUSE_NAME,
  PRT.PARTNER_ID,
  PRT.PARTNER_NAME
 FROM V_GOODS_SALE S
 INNER JOIN V_WAREHOUSE_MOVE WRH ON WRH.DOCUMENT_ID = S.DOCUMENT_ID
 INNER JOIN V_PARTNER_MOVE PRT ON PRT.DOCUMENT_ID = S.DOCUMENT_ID;


/* 
   FIREBIRD IMPLEMENTATION 
 
   USE PROCEDURES. EMULATE VIEWS.

*/


/* CREATE PROCEDURES (VIEW EMULATION) BY MONTH (TEST/DEMO) */

SET TERM !! ;

/* 01 MONTH JAN */
CREATE PROCEDURE V_RPT_GOODS_SALE_MONTH_01
RETURNS
(

  PERIOD_ID INTEGER,
  ORGANIZATION_ID INTEGER,
  DOCUMENT_DATE DATE,
  DOCUMENT_YEAR INTEGER,
  DOCUMENT_MONTH INTEGER,
  PRODUCT_ID INTEGER,
  PRODUCT_CODE VARCHAR(20),
  PRODUCT_NAME VARCHAR(100),
  ITEM_UNIT_ID INTEGER,
  UNIT_ID INTEGER,
  UNIT_NAME VARCHAR(10),
  PRODUCT_PRICE NUMERIC(15,4),
  PRICE NUMERIC(15,4),
  ITEM_PRICE NUMERIC(15,4),
  Q01 NUMERIC(15,4),
  Q02 NUMERIC(15,4),
  Q03 NUMERIC(15,4),
  Q04 NUMERIC(15,4),
  Q05 NUMERIC(15,4),
  Q06 NUMERIC(15,4),
  Q07 NUMERIC(15,4),
  Q08 NUMERIC(15,4),
  Q09 NUMERIC(15,4),
  Q10 NUMERIC(15,4),
  Q11 NUMERIC(15,4),
  Q12 NUMERIC(15,4),

  S01 NUMERIC(15,4),
  S02 NUMERIC(15,4),
  S03 NUMERIC(15,4),
  S04 NUMERIC(15,4),
  S05 NUMERIC(15,4),
  S06 NUMERIC(15,4),
  S07 NUMERIC(15,4),
  S08 NUMERIC(15,4),
  S09 NUMERIC(15,4),
  S10 NUMERIC(15,4),
  S11 NUMERIC(15,4),
  S12 NUMERIC(15,4)

) AS
BEGIN
FOR SELECT
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  R.QUANTITY Q01, 0.0 Q02, 0.0 Q03, 0.0 Q04, 0.0 Q05, 0.0 Q06, 0.0 Q07, 0.0 Q08, 0.0 Q09, 0.0 Q10, 0.0 Q11, 0.0 Q12, 
  R.AMOUNT S01,   0.0 S02, 0.0 S03, 0.0 S04, 0.0 S05, 0.0 S06, 0.0 S07, 0.0 S08, 0.0 S09, 0.0 S10, 0.0 S11, 0.0 S12 
 FROM V_GOODS_SALE R
 WHERE R.DOCUMENT_MONTH = 1
 INTO
  :PERIOD_ID,
  :ORGANIZATION_ID,
  :DOCUMENT_DATE,
  :DOCUMENT_YEAR,
  :DOCUMENT_MONTH,
  :PRODUCT_ID,
  :PRODUCT_CODE,
  :PRODUCT_NAME,
  :ITEM_UNIT_ID,
  :UNIT_ID,
  :UNIT_NAME,
  :PRODUCT_PRICE,
  :PRICE,
  :ITEM_PRICE,
  :Q01,  :Q02,  :Q03,  :Q04,  :Q05,  :Q06,  :Q07,  :Q08,  :Q09,  :Q10,  :Q11,  :Q12,
  :S01,  :S02,  :S03,  :S04,  :S05,  :S06,  :S07,  :S08,  :S09,  :S10,  :S11,  :S12 DO
 SUSPEND;

END !!

/* 02 MONTH FEB */
CREATE PROCEDURE V_RPT_GOODS_SALE_MONTH_02
RETURNS
(

  PERIOD_ID INTEGER,
  ORGANIZATION_ID INTEGER,
  DOCUMENT_DATE DATE,
  DOCUMENT_YEAR INTEGER,
  DOCUMENT_MONTH INTEGER,
  PRODUCT_ID INTEGER,
  PRODUCT_CODE VARCHAR(20),
  PRODUCT_NAME VARCHAR(100),
  ITEM_UNIT_ID INTEGER,
  UNIT_ID INTEGER,
  UNIT_NAME VARCHAR(10),
  PRODUCT_PRICE NUMERIC(15,4),
  PRICE NUMERIC(15,4),
  ITEM_PRICE NUMERIC(15,4),
  Q01 NUMERIC(15,4),
  Q02 NUMERIC(15,4),
  Q03 NUMERIC(15,4),
  Q04 NUMERIC(15,4),
  Q05 NUMERIC(15,4),
  Q06 NUMERIC(15,4),
  Q07 NUMERIC(15,4),
  Q08 NUMERIC(15,4),
  Q09 NUMERIC(15,4),
  Q10 NUMERIC(15,4),
  Q11 NUMERIC(15,4),
  Q12 NUMERIC(15,4),

  S01 NUMERIC(15,4),
  S02 NUMERIC(15,4),
  S03 NUMERIC(15,4),
  S04 NUMERIC(15,4),
  S05 NUMERIC(15,4),
  S06 NUMERIC(15,4),
  S07 NUMERIC(15,4),
  S08 NUMERIC(15,4),
  S09 NUMERIC(15,4),
  S10 NUMERIC(15,4),
  S11 NUMERIC(15,4),
  S12 NUMERIC(15,4)

) AS
BEGIN
FOR SELECT
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  0.0 Q01, R.QUANTITY Q02, 0.0 Q03, 0.0 Q04, 0.0 Q05, 0.0 Q06, 0.0 Q07, 0.0 Q08, 0.0 Q09, 0.0 Q10, 0.0 Q11, 0.0 Q12, 
  0.0 S01, R.AMOUNT   S02, 0.0 S03, 0.0 S04, 0.0 S05, 0.0 S06, 0.0 S07, 0.0 S08, 0.0 S09, 0.0 S10, 0.0 S11, 0.0 S12 
 FROM V_GOODS_SALE R
 WHERE R.DOCUMENT_MONTH = 2
 INTO
  :PERIOD_ID,
  :ORGANIZATION_ID,
  :DOCUMENT_DATE,
  :DOCUMENT_YEAR,
  :DOCUMENT_MONTH,
  :PRODUCT_ID,
  :PRODUCT_CODE,
  :PRODUCT_NAME,
  :ITEM_UNIT_ID,
  :UNIT_ID,
  :UNIT_NAME,
  :PRODUCT_PRICE,
  :PRICE,
  :ITEM_PRICE,
  :Q01,  :Q02,  :Q03,  :Q04,  :Q05,  :Q06,  :Q07,  :Q08,  :Q09,  :Q10,  :Q11,  :Q12,
  :S01,  :S02,  :S03,  :S04,  :S05,  :S06,  :S07,  :S08,  :S09,  :S10,  :S11,  :S12 DO
 SUSPEND;

END !!

/* 03 MONTH MAR */
CREATE PROCEDURE V_RPT_GOODS_SALE_MONTH_03
RETURNS
(

  PERIOD_ID INTEGER,
  ORGANIZATION_ID INTEGER,
  DOCUMENT_DATE DATE,
  DOCUMENT_YEAR INTEGER,
  DOCUMENT_MONTH INTEGER,
  PRODUCT_ID INTEGER,
  PRODUCT_CODE VARCHAR(20),
  PRODUCT_NAME VARCHAR(100),
  ITEM_UNIT_ID INTEGER,
  UNIT_ID INTEGER,
  UNIT_NAME VARCHAR(10),
  PRODUCT_PRICE NUMERIC(15,4),
  PRICE NUMERIC(15,4),
  ITEM_PRICE NUMERIC(15,4),
  Q01 NUMERIC(15,4),
  Q02 NUMERIC(15,4),
  Q03 NUMERIC(15,4),
  Q04 NUMERIC(15,4),
  Q05 NUMERIC(15,4),
  Q06 NUMERIC(15,4),
  Q07 NUMERIC(15,4),
  Q08 NUMERIC(15,4),
  Q09 NUMERIC(15,4),
  Q10 NUMERIC(15,4),
  Q11 NUMERIC(15,4),
  Q12 NUMERIC(15,4),

  S01 NUMERIC(15,4),
  S02 NUMERIC(15,4),
  S03 NUMERIC(15,4),
  S04 NUMERIC(15,4),
  S05 NUMERIC(15,4),
  S06 NUMERIC(15,4),
  S07 NUMERIC(15,4),
  S08 NUMERIC(15,4),
  S09 NUMERIC(15,4),
  S10 NUMERIC(15,4),
  S11 NUMERIC(15,4),
  S12 NUMERIC(15,4)

) AS

BEGIN
FOR SELECT
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  0.0 Q01, 0.0 Q02, R.QUANTITY Q03, 0.0 Q04, 0.0 Q05, 0.0 Q06, 0.0 Q07, 0.0 Q08, 0.0 Q09, 0.0 Q10, 0.0 Q11, 0.0 Q12, 
  0.0 S01, 0.0 S02, R.AMOUNT   S03, 0.0 S04, 0.0 S05, 0.0 S06, 0.0 S07, 0.0 S08, 0.0 S09, 0.0 S10, 0.0 S11, 0.0 S12 
 FROM V_GOODS_SALE R
 WHERE R.DOCUMENT_MONTH = 3
 INTO
  :PERIOD_ID,
  :ORGANIZATION_ID,
  :DOCUMENT_DATE,
  :DOCUMENT_YEAR,
  :DOCUMENT_MONTH,
  :PRODUCT_ID,
  :PRODUCT_CODE,
  :PRODUCT_NAME,
  :ITEM_UNIT_ID,
  :UNIT_ID,
  :UNIT_NAME,
  :PRODUCT_PRICE,
  :PRICE,
  :ITEM_PRICE,
  :Q01,  :Q02,  :Q03,  :Q04,  :Q05,  :Q06,  :Q07,  :Q08,  :Q09,  :Q10,  :Q11,  :Q12,
  :S01,  :S02,  :S03,  :S04,  :S05,  :S06,  :S07,  :S08,  :S09,  :S10,  :S11,  :S12 DO
 SUSPEND;

END !!

/* 04 MONTH APR */
CREATE PROCEDURE V_RPT_GOODS_SALE_MONTH_04
RETURNS
(

  PERIOD_ID INTEGER,
  ORGANIZATION_ID INTEGER,
  DOCUMENT_DATE DATE,
  DOCUMENT_YEAR INTEGER,
  DOCUMENT_MONTH INTEGER,
  PRODUCT_ID INTEGER,
  PRODUCT_CODE VARCHAR(20),
  PRODUCT_NAME VARCHAR(100),
  ITEM_UNIT_ID INTEGER,
  UNIT_ID INTEGER,
  UNIT_NAME VARCHAR(10),
  PRODUCT_PRICE NUMERIC(15,4),
  PRICE NUMERIC(15,4),
  ITEM_PRICE NUMERIC(15,4),
  Q01 NUMERIC(15,4),
  Q02 NUMERIC(15,4),
  Q03 NUMERIC(15,4),
  Q04 NUMERIC(15,4),
  Q05 NUMERIC(15,4),
  Q06 NUMERIC(15,4),
  Q07 NUMERIC(15,4),
  Q08 NUMERIC(15,4),
  Q09 NUMERIC(15,4),
  Q10 NUMERIC(15,4),
  Q11 NUMERIC(15,4),
  Q12 NUMERIC(15,4),

  S01 NUMERIC(15,4),
  S02 NUMERIC(15,4),
  S03 NUMERIC(15,4),
  S04 NUMERIC(15,4),
  S05 NUMERIC(15,4),
  S06 NUMERIC(15,4),
  S07 NUMERIC(15,4),
  S08 NUMERIC(15,4),
  S09 NUMERIC(15,4),
  S10 NUMERIC(15,4),
  S11 NUMERIC(15,4),
  S12 NUMERIC(15,4)

) AS
BEGIN
FOR SELECT
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  0.0 Q01, 0.0 Q02, 0.0 Q03, R.QUANTITY Q04, 0.0 Q05, 0.0 Q06, 0.0 Q07, 0.0 Q08, 0.0 Q09, 0.0 Q10, 0.0 Q11, 0.0 Q12, 
  0.0 S01, 0.0 S02, 0.0 S03, R.AMOUNT   S04, 0.0 S05, 0.0 S06, 0.0 S07, 0.0 S08, 0.0 S09, 0.0 S10, 0.0 S11, 0.0 S12 
 FROM V_GOODS_SALE R
 WHERE R.DOCUMENT_MONTH = 4
 INTO
  :PERIOD_ID,
  :ORGANIZATION_ID,
  :DOCUMENT_DATE,
  :DOCUMENT_YEAR,
  :DOCUMENT_MONTH,
  :PRODUCT_ID,
  :PRODUCT_CODE,
  :PRODUCT_NAME,
  :ITEM_UNIT_ID,
  :UNIT_ID,
  :UNIT_NAME,
  :PRODUCT_PRICE,
  :PRICE,
  :ITEM_PRICE,
  :Q01,  :Q02,  :Q03,  :Q04,  :Q05,  :Q06,  :Q07,  :Q08,  :Q09,  :Q10,  :Q11,  :Q12,
  :S01,  :S02,  :S03,  :S04,  :S05,  :S06,  :S07,  :S08,  :S09,  :S10,  :S11,  :S12 DO
 SUSPEND;

END !!

/* 05 MONTH MAY */
CREATE PROCEDURE V_RPT_GOODS_SALE_MONTH_05
RETURNS
(

  PERIOD_ID INTEGER,
  ORGANIZATION_ID INTEGER,
  DOCUMENT_DATE DATE,
  DOCUMENT_YEAR INTEGER,
  DOCUMENT_MONTH INTEGER,
  PRODUCT_ID INTEGER,
  PRODUCT_CODE VARCHAR(20),
  PRODUCT_NAME VARCHAR(100),
  ITEM_UNIT_ID INTEGER,
  UNIT_ID INTEGER,
  UNIT_NAME VARCHAR(10),
  PRODUCT_PRICE NUMERIC(15,4),
  PRICE NUMERIC(15,4),
  ITEM_PRICE NUMERIC(15,4),
  Q01 NUMERIC(15,4),
  Q02 NUMERIC(15,4),
  Q03 NUMERIC(15,4),
  Q04 NUMERIC(15,4),
  Q05 NUMERIC(15,4),
  Q06 NUMERIC(15,4),
  Q07 NUMERIC(15,4),
  Q08 NUMERIC(15,4),
  Q09 NUMERIC(15,4),
  Q10 NUMERIC(15,4),
  Q11 NUMERIC(15,4),
  Q12 NUMERIC(15,4),

  S01 NUMERIC(15,4),
  S02 NUMERIC(15,4),
  S03 NUMERIC(15,4),
  S04 NUMERIC(15,4),
  S05 NUMERIC(15,4),
  S06 NUMERIC(15,4),
  S07 NUMERIC(15,4),
  S08 NUMERIC(15,4),
  S09 NUMERIC(15,4),
  S10 NUMERIC(15,4),
  S11 NUMERIC(15,4),
  S12 NUMERIC(15,4)

) AS
BEGIN
FOR SELECT
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  0.0 Q01, 0.0 Q02, 0.0 Q03, 0.0 Q04, R.QUANTITY Q05, 0.0 Q06, 0.0 Q07, 0.0 Q08, 0.0 Q09, 0.0 Q10, 0.0 Q11, 0.0 Q12, 
  0.0 S01, 0.0 S02, 0.0 S03, 0.0 S04, R.AMOUNT   S05, 0.0 S06, 0.0 S07, 0.0 S08, 0.0 S09, 0.0 S10, 0.0 S11, 0.0 S12 
 FROM V_GOODS_SALE R
 WHERE R.DOCUMENT_MONTH = 5
 INTO
  :PERIOD_ID,
  :ORGANIZATION_ID,
  :DOCUMENT_DATE,
  :DOCUMENT_YEAR,
  :DOCUMENT_MONTH,
  :PRODUCT_ID,
  :PRODUCT_CODE,
  :PRODUCT_NAME,
  :ITEM_UNIT_ID,
  :UNIT_ID,
  :UNIT_NAME,
  :PRODUCT_PRICE,
  :PRICE,
  :ITEM_PRICE,
  :Q01,  :Q02,  :Q03,  :Q04,  :Q05,  :Q06,  :Q07,  :Q08,  :Q09,  :Q10,  :Q11,  :Q12,
  :S01,  :S02,  :S03,  :S04,  :S05,  :S06,  :S07,  :S08,  :S09,  :S10,  :S11,  :S12 DO
 SUSPEND;

END !!

/* 06 MONTH JUN */
CREATE PROCEDURE V_RPT_GOODS_SALE_MONTH_06
RETURNS
(

  PERIOD_ID INTEGER,
  ORGANIZATION_ID INTEGER,
  DOCUMENT_DATE DATE,
  DOCUMENT_YEAR INTEGER,
  DOCUMENT_MONTH INTEGER,
  PRODUCT_ID INTEGER,
  PRODUCT_CODE VARCHAR(20),
  PRODUCT_NAME VARCHAR(100),
  ITEM_UNIT_ID INTEGER,
  UNIT_ID INTEGER,
  UNIT_NAME VARCHAR(10),
  PRODUCT_PRICE NUMERIC(15,4),
  PRICE NUMERIC(15,4),
  ITEM_PRICE NUMERIC(15,4),
  Q01 NUMERIC(15,4),
  Q02 NUMERIC(15,4),
  Q03 NUMERIC(15,4),
  Q04 NUMERIC(15,4),
  Q05 NUMERIC(15,4),
  Q06 NUMERIC(15,4),
  Q07 NUMERIC(15,4),
  Q08 NUMERIC(15,4),
  Q09 NUMERIC(15,4),
  Q10 NUMERIC(15,4),
  Q11 NUMERIC(15,4),
  Q12 NUMERIC(15,4),

  S01 NUMERIC(15,4),
  S02 NUMERIC(15,4),
  S03 NUMERIC(15,4),
  S04 NUMERIC(15,4),
  S05 NUMERIC(15,4),
  S06 NUMERIC(15,4),
  S07 NUMERIC(15,4),
  S08 NUMERIC(15,4),
  S09 NUMERIC(15,4),
  S10 NUMERIC(15,4),
  S11 NUMERIC(15,4),
  S12 NUMERIC(15,4)

) AS
BEGIN
FOR SELECT
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  0.0 Q01, 0.0 Q02, 0.0 Q03, 0.0 Q04, 0.0 Q05, R.QUANTITY Q06, 0.0 Q07, 0.0 Q08, 0.0 Q09, 0.0 Q10, 0.0 Q11, 0.0 Q12, 
  0.0 S01, 0.0 S02, 0.0 S03, 0.0 S04, 0.0 S05, R.AMOUNT   S06, 0.0 S07, 0.0 S08, 0.0 S09, 0.0 S10, 0.0 S11, 0.0 S12 
 FROM V_GOODS_SALE R
 WHERE R.DOCUMENT_MONTH = 6
 INTO
  :PERIOD_ID,
  :ORGANIZATION_ID,
  :DOCUMENT_DATE,
  :DOCUMENT_YEAR,
  :DOCUMENT_MONTH,
  :PRODUCT_ID,
  :PRODUCT_CODE,
  :PRODUCT_NAME,
  :ITEM_UNIT_ID,
  :UNIT_ID,
  :UNIT_NAME,
  :PRODUCT_PRICE,
  :PRICE,
  :ITEM_PRICE,
  :Q01,  :Q02,  :Q03,  :Q04,  :Q05,  :Q06,  :Q07,  :Q08,  :Q09,  :Q10,  :Q11,  :Q12,
  :S01,  :S02,  :S03,  :S04,  :S05,  :S06,  :S07,  :S08,  :S09,  :S10,  :S11,  :S12 DO
 SUSPEND;

END !!

/* 07 MONTH JUL */
CREATE PROCEDURE V_RPT_GOODS_SALE_MONTH_07
RETURNS
(

  PERIOD_ID INTEGER,
  ORGANIZATION_ID INTEGER,
  DOCUMENT_DATE DATE,
  DOCUMENT_YEAR INTEGER,
  DOCUMENT_MONTH INTEGER,
  PRODUCT_ID INTEGER,
  PRODUCT_CODE VARCHAR(20),
  PRODUCT_NAME VARCHAR(100),
  ITEM_UNIT_ID INTEGER,
  UNIT_ID INTEGER,
  UNIT_NAME VARCHAR(10),
  PRODUCT_PRICE NUMERIC(15,4),
  PRICE NUMERIC(15,4),
  ITEM_PRICE NUMERIC(15,4),
  Q01 NUMERIC(15,4),
  Q02 NUMERIC(15,4),
  Q03 NUMERIC(15,4),
  Q04 NUMERIC(15,4),
  Q05 NUMERIC(15,4),
  Q06 NUMERIC(15,4),
  Q07 NUMERIC(15,4),
  Q08 NUMERIC(15,4),
  Q09 NUMERIC(15,4),
  Q10 NUMERIC(15,4),
  Q11 NUMERIC(15,4),
  Q12 NUMERIC(15,4),

  S01 NUMERIC(15,4),
  S02 NUMERIC(15,4),
  S03 NUMERIC(15,4),
  S04 NUMERIC(15,4),
  S05 NUMERIC(15,4),
  S06 NUMERIC(15,4),
  S07 NUMERIC(15,4),
  S08 NUMERIC(15,4),
  S09 NUMERIC(15,4),
  S10 NUMERIC(15,4),
  S11 NUMERIC(15,4),
  S12 NUMERIC(15,4)

) AS
BEGIN
FOR SELECT
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  0.0 Q01, 0.0 Q02, 0.0 Q03, 0.0 Q04, 0.0 Q05, 0.0 Q06, R.QUANTITY Q07, 0.0 Q08, 0.0 Q09, 0.0 Q10, 0.0 Q11, 0.0 Q12, 
  0.0 S01, 0.0 S02, 0.0 S03, 0.0 S04, 0.0 S05, 0.0 S06, R.AMOUNT   S07, 0.0 S08, 0.0 S09, 0.0 S10, 0.0 S11, 0.0 S12 
 FROM V_GOODS_SALE R
 WHERE R.DOCUMENT_MONTH = 7
 INTO
  :PERIOD_ID,
  :ORGANIZATION_ID,
  :DOCUMENT_DATE,
  :DOCUMENT_YEAR,
  :DOCUMENT_MONTH,
  :PRODUCT_ID,
  :PRODUCT_CODE,
  :PRODUCT_NAME,
  :ITEM_UNIT_ID,
  :UNIT_ID,
  :UNIT_NAME,
  :PRODUCT_PRICE,
  :PRICE,
  :ITEM_PRICE,
  :Q01,  :Q02,  :Q03,  :Q04,  :Q05,  :Q06,  :Q07,  :Q08,  :Q09,  :Q10,  :Q11,  :Q12,
  :S01,  :S02,  :S03,  :S04,  :S05,  :S06,  :S07,  :S08,  :S09,  :S10,  :S11,  :S12 DO
 SUSPEND;

END !!

/* 08 MONTH AUG */
CREATE PROCEDURE V_RPT_GOODS_SALE_MONTH_08
RETURNS
(

  PERIOD_ID INTEGER,
  ORGANIZATION_ID INTEGER,
  DOCUMENT_DATE DATE,
  DOCUMENT_YEAR INTEGER,
  DOCUMENT_MONTH INTEGER,
  PRODUCT_ID INTEGER,
  PRODUCT_CODE VARCHAR(20),
  PRODUCT_NAME VARCHAR(100),
  ITEM_UNIT_ID INTEGER,
  UNIT_ID INTEGER,
  UNIT_NAME VARCHAR(10),
  PRODUCT_PRICE NUMERIC(15,4),
  PRICE NUMERIC(15,4),
  ITEM_PRICE NUMERIC(15,4),
  Q01 NUMERIC(15,4),
  Q02 NUMERIC(15,4),
  Q03 NUMERIC(15,4),
  Q04 NUMERIC(15,4),
  Q05 NUMERIC(15,4),
  Q06 NUMERIC(15,4),
  Q07 NUMERIC(15,4),
  Q08 NUMERIC(15,4),
  Q09 NUMERIC(15,4),
  Q10 NUMERIC(15,4),
  Q11 NUMERIC(15,4),
  Q12 NUMERIC(15,4),

  S01 NUMERIC(15,4),
  S02 NUMERIC(15,4),
  S03 NUMERIC(15,4),
  S04 NUMERIC(15,4),
  S05 NUMERIC(15,4),
  S06 NUMERIC(15,4),
  S07 NUMERIC(15,4),
  S08 NUMERIC(15,4),
  S09 NUMERIC(15,4),
  S10 NUMERIC(15,4),
  S11 NUMERIC(15,4),
  S12 NUMERIC(15,4)

) AS
BEGIN
FOR SELECT
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  0.0 Q01, 0.0 Q02, 0.0 Q03, 0.0 Q04, 0.0 Q05, 0.0 Q06, 0.0 Q07, R.QUANTITY Q08, 0.0 Q09, 0.0 Q10, 0.0 Q11, 0.0 Q12, 
  0.0 S01, 0.0 S02, 0.0 S03, 0.0 S04, 0.0 S05, 0.0 S06, 0.0 S07, R.AMOUNT   S08, 0.0 S09, 0.0 S10, 0.0 S11, 0.0 S12 
 FROM V_GOODS_SALE R
 WHERE R.DOCUMENT_MONTH = 8
 INTO
  :PERIOD_ID,
  :ORGANIZATION_ID,
  :DOCUMENT_DATE,
  :DOCUMENT_YEAR,
  :DOCUMENT_MONTH,
  :PRODUCT_ID,
  :PRODUCT_CODE,
  :PRODUCT_NAME,
  :ITEM_UNIT_ID,
  :UNIT_ID,
  :UNIT_NAME,
  :PRODUCT_PRICE,
  :PRICE,
  :ITEM_PRICE,
  :Q01,  :Q02,  :Q03,  :Q04,  :Q05,  :Q06,  :Q07,  :Q08,  :Q09,  :Q10,  :Q11,  :Q12,
  :S01,  :S02,  :S03,  :S04,  :S05,  :S06,  :S07,  :S08,  :S09,  :S10,  :S11,  :S12 DO
 SUSPEND;

END !!

/* 09 MONTH SEP */
CREATE PROCEDURE V_RPT_GOODS_SALE_MONTH_09
RETURNS
(

  PERIOD_ID INTEGER,
  ORGANIZATION_ID INTEGER,
  DOCUMENT_DATE DATE,
  DOCUMENT_YEAR INTEGER,
  DOCUMENT_MONTH INTEGER,
  PRODUCT_ID INTEGER,
  PRODUCT_CODE VARCHAR(20),
  PRODUCT_NAME VARCHAR(100),
  ITEM_UNIT_ID INTEGER,
  UNIT_ID INTEGER,
  UNIT_NAME VARCHAR(10),
  PRODUCT_PRICE NUMERIC(15,4),
  PRICE NUMERIC(15,4),
  ITEM_PRICE NUMERIC(15,4),
  Q01 NUMERIC(15,4),
  Q02 NUMERIC(15,4),
  Q03 NUMERIC(15,4),
  Q04 NUMERIC(15,4),
  Q05 NUMERIC(15,4),
  Q06 NUMERIC(15,4),
  Q07 NUMERIC(15,4),
  Q08 NUMERIC(15,4),
  Q09 NUMERIC(15,4),
  Q10 NUMERIC(15,4),
  Q11 NUMERIC(15,4),
  Q12 NUMERIC(15,4),

  S01 NUMERIC(15,4),
  S02 NUMERIC(15,4),
  S03 NUMERIC(15,4),
  S04 NUMERIC(15,4),
  S05 NUMERIC(15,4),
  S06 NUMERIC(15,4),
  S07 NUMERIC(15,4),
  S08 NUMERIC(15,4),
  S09 NUMERIC(15,4),
  S10 NUMERIC(15,4),
  S11 NUMERIC(15,4),
  S12 NUMERIC(15,4)

) AS
BEGIN
FOR SELECT
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  0.0 Q01, 0.0 Q02, 0.0 Q03, 0.0 Q04, 0.0 Q05, 0.0 Q06, 0.0 Q07, 0.0 Q08, R.QUANTITY Q09, 0.0 Q10, 0.0 Q11, 0.0 Q12, 
  0.0 S01, 0.0 S02, 0.0 S03, 0.0 S04, 0.0 S05, 0.0 S06, 0.0 S07, 0.0 S08, R.AMOUNT   S09, 0.0 S10, 0.0 S11, 0.0 S12 
 FROM V_GOODS_SALE R
 WHERE R.DOCUMENT_MONTH = 9
 INTO
  :PERIOD_ID,
  :ORGANIZATION_ID,
  :DOCUMENT_DATE,
  :DOCUMENT_YEAR,
  :DOCUMENT_MONTH,
  :PRODUCT_ID,
  :PRODUCT_CODE,
  :PRODUCT_NAME,
  :ITEM_UNIT_ID,
  :UNIT_ID,
  :UNIT_NAME,
  :PRODUCT_PRICE,
  :PRICE,
  :ITEM_PRICE,
  :Q01,  :Q02,  :Q03,  :Q04,  :Q05,  :Q06,  :Q07,  :Q08,  :Q09,  :Q10,  :Q11,  :Q12,
  :S01,  :S02,  :S03,  :S04,  :S05,  :S06,  :S07,  :S08,  :S09,  :S10,  :S11,  :S12 DO
 SUSPEND;

END !!

/* 10 MONTH OCT */
CREATE PROCEDURE V_RPT_GOODS_SALE_MONTH_10
RETURNS
(

  PERIOD_ID INTEGER,
  ORGANIZATION_ID INTEGER,
  DOCUMENT_DATE DATE,
  DOCUMENT_YEAR INTEGER,
  DOCUMENT_MONTH INTEGER,
  PRODUCT_ID INTEGER,
  PRODUCT_CODE VARCHAR(20),
  PRODUCT_NAME VARCHAR(100),
  ITEM_UNIT_ID INTEGER,
  UNIT_ID INTEGER,
  UNIT_NAME VARCHAR(10),
  PRODUCT_PRICE NUMERIC(15,4),
  PRICE NUMERIC(15,4),
  ITEM_PRICE NUMERIC(15,4),
  Q01 NUMERIC(15,4),
  Q02 NUMERIC(15,4),
  Q03 NUMERIC(15,4),
  Q04 NUMERIC(15,4),
  Q05 NUMERIC(15,4),
  Q06 NUMERIC(15,4),
  Q07 NUMERIC(15,4),
  Q08 NUMERIC(15,4),
  Q09 NUMERIC(15,4),
  Q10 NUMERIC(15,4),
  Q11 NUMERIC(15,4),
  Q12 NUMERIC(15,4),

  S01 NUMERIC(15,4),
  S02 NUMERIC(15,4),
  S03 NUMERIC(15,4),
  S04 NUMERIC(15,4),
  S05 NUMERIC(15,4),
  S06 NUMERIC(15,4),
  S07 NUMERIC(15,4),
  S08 NUMERIC(15,4),
  S09 NUMERIC(15,4),
  S10 NUMERIC(15,4),
  S11 NUMERIC(15,4),
  S12 NUMERIC(15,4)

) AS
BEGIN
FOR SELECT
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  0.0 Q01, 0.0 Q02, 0.0 Q03, 0.0 Q04, 0.0 Q05, 0.0 Q06, 0.0 Q07, 0.0 Q08, 0.0 Q09, R.QUANTITY Q10, 0.0 Q11, 0.0 Q12, 
  0.0 S01, 0.0 S02, 0.0 S03, 0.0 S04, 0.0 S05, 0.0 S06, 0.0 S07, 0.0 S08, 0.0 S09, R.AMOUNT   S10, 0.0 S11, 0.0 S12 
 FROM V_GOODS_SALE R
 WHERE R.DOCUMENT_MONTH = 10
 INTO
  :PERIOD_ID,
  :ORGANIZATION_ID,
  :DOCUMENT_DATE,
  :DOCUMENT_YEAR,
  :DOCUMENT_MONTH,
  :PRODUCT_ID,
  :PRODUCT_CODE,
  :PRODUCT_NAME,
  :ITEM_UNIT_ID,
  :UNIT_ID,
  :UNIT_NAME,
  :PRODUCT_PRICE,
  :PRICE,
  :ITEM_PRICE,
  :Q01,  :Q02,  :Q03,  :Q04,  :Q05,  :Q06,  :Q07,  :Q08,  :Q09,  :Q10,  :Q11,  :Q12,
  :S01,  :S02,  :S03,  :S04,  :S05,  :S06,  :S07,  :S08,  :S09,  :S10,  :S11,  :S12 DO
 SUSPEND;

END !!

/* 11 MONTH NOV */
CREATE PROCEDURE V_RPT_GOODS_SALE_MONTH_11
RETURNS
(

  PERIOD_ID INTEGER,
  ORGANIZATION_ID INTEGER,
  DOCUMENT_DATE DATE,
  DOCUMENT_YEAR INTEGER,
  DOCUMENT_MONTH INTEGER,
  PRODUCT_ID INTEGER,
  PRODUCT_CODE VARCHAR(20),
  PRODUCT_NAME VARCHAR(100),
  ITEM_UNIT_ID INTEGER,
  UNIT_ID INTEGER,
  UNIT_NAME VARCHAR(10),
  PRODUCT_PRICE NUMERIC(15,4),
  PRICE NUMERIC(15,4),
  ITEM_PRICE NUMERIC(15,4),
  Q01 NUMERIC(15,4),
  Q02 NUMERIC(15,4),
  Q03 NUMERIC(15,4),
  Q04 NUMERIC(15,4),
  Q05 NUMERIC(15,4),
  Q06 NUMERIC(15,4),
  Q07 NUMERIC(15,4),
  Q08 NUMERIC(15,4),
  Q09 NUMERIC(15,4),
  Q10 NUMERIC(15,4),
  Q11 NUMERIC(15,4),
  Q12 NUMERIC(15,4),

  S01 NUMERIC(15,4),
  S02 NUMERIC(15,4),
  S03 NUMERIC(15,4),
  S04 NUMERIC(15,4),
  S05 NUMERIC(15,4),
  S06 NUMERIC(15,4),
  S07 NUMERIC(15,4),
  S08 NUMERIC(15,4),
  S09 NUMERIC(15,4),
  S10 NUMERIC(15,4),
  S11 NUMERIC(15,4),
  S12 NUMERIC(15,4)

) AS
BEGIN
FOR SELECT
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  0.0 Q01, 0.0 Q02, 0.0 Q03, 0.0 Q04, 0.0 Q05, 0.0 Q06, 0.0 Q07, 0.0 Q08, 0.0 Q09, 0.0 Q10, R.QUANTITY Q11, 0.0 Q12, 
  0.0 S01, 0.0 S02, 0.0 S03, 0.0 S04, 0.0 S05, 0.0 S06, 0.0 S07, 0.0 S08, 0.0 S09, 0.0 S10, R.AMOUNT   S11, 0.0 S12 
 FROM V_GOODS_SALE R
 WHERE R.DOCUMENT_MONTH = 11
 INTO
  :PERIOD_ID,
  :ORGANIZATION_ID,
  :DOCUMENT_DATE,
  :DOCUMENT_YEAR,
  :DOCUMENT_MONTH,
  :PRODUCT_ID,
  :PRODUCT_CODE,
  :PRODUCT_NAME,
  :ITEM_UNIT_ID,
  :UNIT_ID,
  :UNIT_NAME,
  :PRODUCT_PRICE,
  :PRICE,
  :ITEM_PRICE,
  :Q01,  :Q02,  :Q03,  :Q04,  :Q05,  :Q06,  :Q07,  :Q08,  :Q09,  :Q10,  :Q11,  :Q12,
  :S01,  :S02,  :S03,  :S04,  :S05,  :S06,  :S07,  :S08,  :S09,  :S10,  :S11,  :S12 DO
 SUSPEND;

END !!

/* 12 MONTH DEC */
CREATE PROCEDURE V_RPT_GOODS_SALE_MONTH_12
RETURNS
(

  PERIOD_ID INTEGER,
  ORGANIZATION_ID INTEGER,
  DOCUMENT_DATE DATE,
  DOCUMENT_YEAR INTEGER,
  DOCUMENT_MONTH INTEGER,
  PRODUCT_ID INTEGER,
  PRODUCT_CODE VARCHAR(20),
  PRODUCT_NAME VARCHAR(100),
  ITEM_UNIT_ID INTEGER,
  UNIT_ID INTEGER,
  UNIT_NAME VARCHAR(10),
  PRODUCT_PRICE NUMERIC(15,4),
  PRICE NUMERIC(15,4),
  ITEM_PRICE NUMERIC(15,4),
  Q01 NUMERIC(15,4),
  Q02 NUMERIC(15,4),
  Q03 NUMERIC(15,4),
  Q04 NUMERIC(15,4),
  Q05 NUMERIC(15,4),
  Q06 NUMERIC(15,4),
  Q07 NUMERIC(15,4),
  Q08 NUMERIC(15,4),
  Q09 NUMERIC(15,4),
  Q10 NUMERIC(15,4),
  Q11 NUMERIC(15,4),
  Q12 NUMERIC(15,4),

  S01 NUMERIC(15,4),
  S02 NUMERIC(15,4),
  S03 NUMERIC(15,4),
  S04 NUMERIC(15,4),
  S05 NUMERIC(15,4),
  S06 NUMERIC(15,4),
  S07 NUMERIC(15,4),
  S08 NUMERIC(15,4),
  S09 NUMERIC(15,4),
  S10 NUMERIC(15,4),
  S11 NUMERIC(15,4),
  S12 NUMERIC(15,4)

) AS
BEGIN
FOR SELECT
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  0.0 Q01, 0.0 Q02, 0.0 Q03, 0.0 Q04, 0.0 Q05, 0.0 Q06, 0.0 Q07, 0.0 Q08, 0.0 Q09, 0.0 Q10, 0.0 Q11, R.QUANTITY Q12, 
  0.0 S01, 0.0 S02, 0.0 S03, 0.0 S04, 0.0 S05, 0.0 S06, 0.0 S07, 0.0 S08, 0.0 S09, 0.0 S10, 0.0 S11, R.AMOUNT   S12 
 FROM V_GOODS_SALE R
 WHERE R.DOCUMENT_MONTH = 12
 INTO
  :PERIOD_ID,
  :ORGANIZATION_ID,
  :DOCUMENT_DATE,
  :DOCUMENT_YEAR,
  :DOCUMENT_MONTH,
  :PRODUCT_ID,
  :PRODUCT_CODE,
  :PRODUCT_NAME,
  :ITEM_UNIT_ID,
  :UNIT_ID,
  :UNIT_NAME,
  :PRODUCT_PRICE,
  :PRICE,
  :ITEM_PRICE,
  :Q01,  :Q02,  :Q03,  :Q04,  :Q05,  :Q06,  :Q07,  :Q08,  :Q09,  :Q10,  :Q11,  :Q12,
  :S01,  :S02,  :S03,  :S04,  :S05,  :S06,  :S07,  :S08,  :S09,  :S10,  :S11,  :S12 DO
 SUSPEND;

END !!





/* CREATE PROCEDURE (VIEW EMULATION) SALES BY MONTHES */


CREATE PROCEDURE V_RPT_GOODS_SALE_YEAR_PRODUCT
RETURNS
(

  PERIOD_ID INTEGER,
  ORGANIZATION_ID INTEGER,
  DOCUMENT_DATE DATE,
  DOCUMENT_YEAR INTEGER,
  DOCUMENT_MONTH INTEGER,
  PRODUCT_ID INTEGER,
  PRODUCT_CODE VARCHAR(20),
  PRODUCT_NAME VARCHAR(100),
  ITEM_UNIT_ID INTEGER,
  UNIT_ID INTEGER,
  UNIT_NAME VARCHAR(10),
  PRODUCT_PRICE NUMERIC(15,4),
  PRICE NUMERIC(15,4),
  ITEM_PRICE NUMERIC(15,4),
  Q01 NUMERIC(15,4),
  Q02 NUMERIC(15,4),
  Q03 NUMERIC(15,4),
  Q04 NUMERIC(15,4),
  Q05 NUMERIC(15,4),
  Q06 NUMERIC(15,4),
  Q07 NUMERIC(15,4),
  Q08 NUMERIC(15,4),
  Q09 NUMERIC(15,4),
  Q10 NUMERIC(15,4),
  Q11 NUMERIC(15,4),
  Q12 NUMERIC(15,4),

  S01 NUMERIC(15,4),
  S02 NUMERIC(15,4),
  S03 NUMERIC(15,4),
  S04 NUMERIC(15,4),
  S05 NUMERIC(15,4),
  S06 NUMERIC(15,4),
  S07 NUMERIC(15,4),
  S08 NUMERIC(15,4),
  S09 NUMERIC(15,4),
  S10 NUMERIC(15,4),
  S11 NUMERIC(15,4),
  S12 NUMERIC(15,4)

) AS
BEGIN
FOR SELECT
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  Q01, Q02, Q03, Q04, Q05, Q06, Q07, Q08, Q09, Q10, Q11, Q12,
  S01, S02, S03, S04, S05, S06, S07, S08, S09, S10, S11, S12
 FROM V_RPT_GOODS_SALE_MONTH_01 R
 INTO
  :PERIOD_ID,
  :ORGANIZATION_ID,
  :DOCUMENT_DATE,
  :DOCUMENT_YEAR,
  :DOCUMENT_MONTH,
  :PRODUCT_ID,
  :PRODUCT_CODE,
  :PRODUCT_NAME,
  :ITEM_UNIT_ID,
  :UNIT_ID,
  :UNIT_NAME,
  :PRODUCT_PRICE,
  :PRICE,
  :ITEM_PRICE,
  :Q01,  :Q02,  :Q03,  :Q04,  :Q05,  :Q06,  :Q07,  :Q08,  :Q09,  :Q10,  :Q11,  :Q12,
  :S01,  :S02,  :S03,  :S04,  :S05,  :S06,  :S07,  :S08,  :S09,  :S10,  :S11,  :S12 DO
 SUSPEND;


FOR SELECT
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  Q01, Q02, Q03, Q04, Q05, Q06, Q07, Q08, Q09, Q10, Q11, Q12,
  S01, S02, S03, S04, S05, S06, S07, S08, S09, S10, S11, S12
 FROM V_RPT_GOODS_SALE_MONTH_02 R
 INTO
  :PERIOD_ID,
  :ORGANIZATION_ID,
  :DOCUMENT_DATE,
  :DOCUMENT_YEAR,
  :DOCUMENT_MONTH,
  :PRODUCT_ID,
  :PRODUCT_CODE,
  :PRODUCT_NAME,
  :ITEM_UNIT_ID,
  :UNIT_ID,
  :UNIT_NAME,
  :PRODUCT_PRICE,
  :PRICE,
  :ITEM_PRICE,
  :Q01,  :Q02,  :Q03,  :Q04,  :Q05,  :Q06,  :Q07,  :Q08,  :Q09,  :Q10,  :Q11,  :Q12,
  :S01,  :S02,  :S03,  :S04,  :S05,  :S06,  :S07,  :S08,  :S09,  :S10,  :S11,  :S12 DO
 SUSPEND;


FOR SELECT
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  Q01, Q02, Q03, Q04, Q05, Q06, Q07, Q08, Q09, Q10, Q11, Q12,
  S01, S02, S03, S04, S05, S06, S07, S08, S09, S10, S11, S12
 FROM V_RPT_GOODS_SALE_MONTH_03 R
 INTO
  :PERIOD_ID,
  :ORGANIZATION_ID,
  :DOCUMENT_DATE,
  :DOCUMENT_YEAR,
  :DOCUMENT_MONTH,
  :PRODUCT_ID,
  :PRODUCT_CODE,
  :PRODUCT_NAME,
  :ITEM_UNIT_ID,
  :UNIT_ID,
  :UNIT_NAME,
  :PRODUCT_PRICE,
  :PRICE,
  :ITEM_PRICE,
  :Q01,  :Q02,  :Q03,  :Q04,  :Q05,  :Q06,  :Q07,  :Q08,  :Q09,  :Q10,  :Q11,  :Q12,
  :S01,  :S02,  :S03,  :S04,  :S05,  :S06,  :S07,  :S08,  :S09,  :S10,  :S11,  :S12 DO
 SUSPEND;

FOR SELECT
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  Q01, Q02, Q03, Q04, Q05, Q06, Q07, Q08, Q09, Q10, Q11, Q12,
  S01, S02, S03, S04, S05, S06, S07, S08, S09, S10, S11, S12
 FROM V_RPT_GOODS_SALE_MONTH_04 R
 INTO
  :PERIOD_ID,
  :ORGANIZATION_ID,
  :DOCUMENT_DATE,
  :DOCUMENT_YEAR,
  :DOCUMENT_MONTH,
  :PRODUCT_ID,
  :PRODUCT_CODE,
  :PRODUCT_NAME,
  :ITEM_UNIT_ID,
  :UNIT_ID,
  :UNIT_NAME,
  :PRODUCT_PRICE,
  :PRICE,
  :ITEM_PRICE,
  :Q01,  :Q02,  :Q03,  :Q04,  :Q05,  :Q06,  :Q07,  :Q08,  :Q09,  :Q10,  :Q11,  :Q12,
  :S01,  :S02,  :S03,  :S04,  :S05,  :S06,  :S07,  :S08,  :S09,  :S10,  :S11,  :S12 DO
 SUSPEND;

FOR SELECT
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  Q01, Q02, Q03, Q04, Q05, Q06, Q07, Q08, Q09, Q10, Q11, Q12,
  S01, S02, S03, S04, S05, S06, S07, S08, S09, S10, S11, S12
 FROM V_RPT_GOODS_SALE_MONTH_05 R
 INTO
  :PERIOD_ID,
  :ORGANIZATION_ID,
  :DOCUMENT_DATE,
  :DOCUMENT_YEAR,
  :DOCUMENT_MONTH,
  :PRODUCT_ID,
  :PRODUCT_CODE,
  :PRODUCT_NAME,
  :ITEM_UNIT_ID,
  :UNIT_ID,
  :UNIT_NAME,
  :PRODUCT_PRICE,
  :PRICE,
  :ITEM_PRICE,
  :Q01,  :Q02,  :Q03,  :Q04,  :Q05,  :Q06,  :Q07,  :Q08,  :Q09,  :Q10,  :Q11,  :Q12,
  :S01,  :S02,  :S03,  :S04,  :S05,  :S06,  :S07,  :S08,  :S09,  :S10,  :S11,  :S12 DO
 SUSPEND;

FOR SELECT
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  Q01, Q02, Q03, Q04, Q05, Q06, Q07, Q08, Q09, Q10, Q11, Q12,
  S01, S02, S03, S04, S05, S06, S07, S08, S09, S10, S11, S12
 FROM V_RPT_GOODS_SALE_MONTH_06 R
 INTO
  :PERIOD_ID,
  :ORGANIZATION_ID,
  :DOCUMENT_DATE,
  :DOCUMENT_YEAR,
  :DOCUMENT_MONTH,
  :PRODUCT_ID,
  :PRODUCT_CODE,
  :PRODUCT_NAME,
  :ITEM_UNIT_ID,
  :UNIT_ID,
  :UNIT_NAME,
  :PRODUCT_PRICE,
  :PRICE,
  :ITEM_PRICE,
  :Q01,  :Q02,  :Q03,  :Q04,  :Q05,  :Q06,  :Q07,  :Q08,  :Q09,  :Q10,  :Q11,  :Q12,
  :S01,  :S02,  :S03,  :S04,  :S05,  :S06,  :S07,  :S08,  :S09,  :S10,  :S11,  :S12 DO
 SUSPEND;

FOR SELECT
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  Q01, Q02, Q03, Q04, Q05, Q06, Q07, Q08, Q09, Q10, Q11, Q12,
  S01, S02, S03, S04, S05, S06, S07, S08, S09, S10, S11, S12
 FROM V_RPT_GOODS_SALE_MONTH_07 R
 INTO
  :PERIOD_ID,
  :ORGANIZATION_ID,
  :DOCUMENT_DATE,
  :DOCUMENT_YEAR,
  :DOCUMENT_MONTH,
  :PRODUCT_ID,
  :PRODUCT_CODE,
  :PRODUCT_NAME,
  :ITEM_UNIT_ID,
  :UNIT_ID,
  :UNIT_NAME,
  :PRODUCT_PRICE,
  :PRICE,
  :ITEM_PRICE,
  :Q01,  :Q02,  :Q03,  :Q04,  :Q05,  :Q06,  :Q07,  :Q08,  :Q09,  :Q10,  :Q11,  :Q12,
  :S01,  :S02,  :S03,  :S04,  :S05,  :S06,  :S07,  :S08,  :S09,  :S10,  :S11,  :S12 DO
 SUSPEND;

FOR SELECT
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  Q01, Q02, Q03, Q04, Q05, Q06, Q07, Q08, Q09, Q10, Q11, Q12,
  S01, S02, S03, S04, S05, S06, S07, S08, S09, S10, S11, S12
 FROM V_RPT_GOODS_SALE_MONTH_08 R
 INTO
  :PERIOD_ID,
  :ORGANIZATION_ID,
  :DOCUMENT_DATE,
  :DOCUMENT_YEAR,
  :DOCUMENT_MONTH,
  :PRODUCT_ID,
  :PRODUCT_CODE,
  :PRODUCT_NAME,
  :ITEM_UNIT_ID,
  :UNIT_ID,
  :UNIT_NAME,
  :PRODUCT_PRICE,
  :PRICE,
  :ITEM_PRICE,
  :Q01,  :Q02,  :Q03,  :Q04,  :Q05,  :Q06,  :Q07,  :Q08,  :Q09,  :Q10,  :Q11,  :Q12,
  :S01,  :S02,  :S03,  :S04,  :S05,  :S06,  :S07,  :S08,  :S09,  :S10,  :S11,  :S12 DO
 SUSPEND;

FOR SELECT
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  Q01, Q02, Q03, Q04, Q05, Q06, Q07, Q08, Q09, Q10, Q11, Q12,
  S01, S02, S03, S04, S05, S06, S07, S08, S09, S10, S11, S12
 FROM V_RPT_GOODS_SALE_MONTH_09 R
 INTO
  :PERIOD_ID,
  :ORGANIZATION_ID,
  :DOCUMENT_DATE,
  :DOCUMENT_YEAR,
  :DOCUMENT_MONTH,
  :PRODUCT_ID,
  :PRODUCT_CODE,
  :PRODUCT_NAME,
  :ITEM_UNIT_ID,
  :UNIT_ID,
  :UNIT_NAME,
  :PRODUCT_PRICE,
  :PRICE,
  :ITEM_PRICE,
  :Q01,  :Q02,  :Q03,  :Q04,  :Q05,  :Q06,  :Q07,  :Q08,  :Q09,  :Q10,  :Q11,  :Q12,
  :S01,  :S02,  :S03,  :S04,  :S05,  :S06,  :S07,  :S08,  :S09,  :S10,  :S11,  :S12 DO
 SUSPEND;

FOR SELECT
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  Q01, Q02, Q03, Q04, Q05, Q06, Q07, Q08, Q09, Q10, Q11, Q12,
  S01, S02, S03, S04, S05, S06, S07, S08, S09, S10, S11, S12
 FROM V_RPT_GOODS_SALE_MONTH_10 R
 INTO
  :PERIOD_ID,
  :ORGANIZATION_ID,
  :DOCUMENT_DATE,
  :DOCUMENT_YEAR,
  :DOCUMENT_MONTH,
  :PRODUCT_ID,
  :PRODUCT_CODE,
  :PRODUCT_NAME,
  :ITEM_UNIT_ID,
  :UNIT_ID,
  :UNIT_NAME,
  :PRODUCT_PRICE,
  :PRICE,
  :ITEM_PRICE,
  :Q01,  :Q02,  :Q03,  :Q04,  :Q05,  :Q06,  :Q07,  :Q08,  :Q09,  :Q10,  :Q11,  :Q12,
  :S01,  :S02,  :S03,  :S04,  :S05,  :S06,  :S07,  :S08,  :S09,  :S10,  :S11,  :S12 DO
 SUSPEND;

FOR SELECT
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  Q01, Q02, Q03, Q04, Q05, Q06, Q07, Q08, Q09, Q10, Q11, Q12,
  S01, S02, S03, S04, S05, S06, S07, S08, S09, S10, S11, S12
 FROM V_RPT_GOODS_SALE_MONTH_11 R
 INTO
  :PERIOD_ID,
  :ORGANIZATION_ID,
  :DOCUMENT_DATE,
  :DOCUMENT_YEAR,
  :DOCUMENT_MONTH,
  :PRODUCT_ID,
  :PRODUCT_CODE,
  :PRODUCT_NAME,
  :ITEM_UNIT_ID,
  :UNIT_ID,
  :UNIT_NAME,
  :PRODUCT_PRICE,
  :PRICE,
  :ITEM_PRICE,
  :Q01,  :Q02,  :Q03,  :Q04,  :Q05,  :Q06,  :Q07,  :Q08,  :Q09,  :Q10,  :Q11,  :Q12,
  :S01,  :S02,  :S03,  :S04,  :S05,  :S06,  :S07,  :S08,  :S09,  :S10,  :S11,  :S12 DO
 SUSPEND;


FOR SELECT
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  Q01, Q02, Q03, Q04, Q05, Q06, Q07, Q08, Q09, Q10, Q11, Q12,
  S01, S02, S03, S04, S05, S06, S07, S08, S09, S10, S11, S12
 FROM V_RPT_GOODS_SALE_MONTH_12 R
 INTO
  :PERIOD_ID,
  :ORGANIZATION_ID,
  :DOCUMENT_DATE,
  :DOCUMENT_YEAR,
  :DOCUMENT_MONTH,
  :PRODUCT_ID,
  :PRODUCT_CODE,
  :PRODUCT_NAME,
  :ITEM_UNIT_ID,
  :UNIT_ID,
  :UNIT_NAME,
  :PRODUCT_PRICE,
  :PRICE,
  :ITEM_PRICE,
  :Q01,  :Q02,  :Q03,  :Q04,  :Q05,  :Q06,  :Q07,  :Q08,  :Q09,  :Q10,  :Q11,  :Q12,
  :S01,  :S02,  :S03,  :S04,  :S05,  :S06,  :S07,  :S08,  :S09,  :S10,  :S11,  :S12 DO
 SUSPEND;

END !!

SET TERM ; !!
/* SALES BY MONTHES (JAN - DEC) */

SET TERM !! ;

CREATE PROCEDURE V_RPT_GOODS_SALE_YEAR
RETURNS
(

  PERIOD_ID INTEGER,
  ORGANIZATION_ID INTEGER,
  DOCUMENT_DATE DATE,
  DOCUMENT_YEAR INTEGER,
  DOCUMENT_MONTH INTEGER,
  S01 NUMERIC(15,2),
  S02 NUMERIC(15,2),
  S03 NUMERIC(15,2),
  S04 NUMERIC(15,2),
  S05 NUMERIC(15,2),
  S06 NUMERIC(15,2),
  S07 NUMERIC(15,2),
  S08 NUMERIC(15,2),
  S09 NUMERIC(15,2),
  S10 NUMERIC(15,2),
  S11 NUMERIC(15,2),
  S12 NUMERIC(15,2)

) AS
BEGIN
FOR SELECT
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_DATE,
  DOCUMENT_YEAR,
  DOCUMENT_MONTH,
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
  S12 
FROM V_RPT_GOODS_SALE_YEAR_PRODUCT
 INTO
  :PERIOD_ID,
  :ORGANIZATION_ID,
  :DOCUMENT_DATE,
  :DOCUMENT_YEAR,
  :DOCUMENT_MONTH,
  :S01,  :S02,  :S03,  :S04,  :S05,  :S06,  :S07,  :S08,  :S09,  :S10,  :S11,  :S12 DO
 SUSPEND;

END !!

SET TERM ; !!
CREATE VIEW V_RPT_WRH_GOODS_REGISTER (
  PERIOD_ID,
  ORGANIZATION_ID,
  GOODS_ID,
  WAREHOUSE_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  UNIT_ID,
  UNIT_NAME,
  PRODUCT_PRICE,
  QUANTITY,
  AMOUNT
) AS
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.GOODS_ID,
  R.WAREHOUSE_ID,
  P.PRODUCT_CODE,
  P.PRODUCT_NAME,
  P.UNIT_ID,
  U.NAME AS UNIT_NAME,
  P.PRICE,
  R.QUANTITY,
  R.AMOUNT
 FROM V_GOODS_DETAIL_REGISTER R
 INNER JOIN GOODS G ON G.ID = R.GOODS_ID
 INNER JOIN V_PRODUCT P ON P.ID = G.ID
 INNER JOIN UNIT U ON U.ID = P.UNIT_ID;



CREATE VIEW V_GOODS_CREDIT_FULL (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_NO,
  DOCUMENT_DATE,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRODUCT_PRICE,
  QUANTITY,
  AMOUNT
) AS
SELECT 
  FD.PERIOD_ID,
  FD.ORGANIZATION_ID,
  FD.DOCUMENT_NO,
  FD.DOCUMENT_DATE,
  I.PRODUCT_ID,
  I.PRODUCT_CODE,
  I.PRODUCT_NAME,
  I.ITEM_UNIT_ID,
  I.UNIT_ID,
  I.UNIT_NAME,
  I.ITEM_PRICE AS ITEM_PRICE,
  I.ACCOUNT_QUANTITY AS QUANTITY,
  I.ITEM_AMOUNT AS AMOUNT
 FROM V_PRODUCT_MOVE I
 INNER JOIN V_FINANCE_DOCUMENT FD ON FD.ID = I.DOCUMENT_ID
 INNER JOIN WAREHOUSE_MOVE STO ON STO.OWNER_ID = FD.ID
 INNER JOIN DOCUMENT_TYPE T ON T.ID = FD.DOCUMENT_TYPE_ID  AND (T.DOCUMENT_SECTION = 'GOODS' OR T.DOCUMENT_SECTION = 'INVENTORY')
 INNER JOIN FINANCE_DOCUMENT_TYPE FT ON T.ID = FT.DOCUMENT_TYPE_ID 
  AND (FT.MOVE_TYPE = 'INPUT' OR (FT.MOVE_TYPE = 'ROTATE' AND STO.MOVE_TYPE = 'INPUT'));
 



CREATE VIEW V_GOODS_DEBIT_FULL (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_NO,
  DOCUMENT_DATE,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRODUCT_PRICE,
  QUANTITY,
  AMOUNT
) AS
SELECT 
  FD.PERIOD_ID,
  FD.ORGANIZATION_ID,
  FD.DOCUMENT_NO,
  FD.DOCUMENT_DATE,
  I.PRODUCT_ID,
  I.PRODUCT_CODE,
  I.PRODUCT_NAME,
  I.ITEM_UNIT_ID,
  I.UNIT_ID,
  I.UNIT_NAME,
  I.ITEM_PRICE AS ITEM_PRICE,
  I.ACCOUNT_QUANTITY AS QUANTITY,
  I.ITEM_AMOUNT AS AMOUNT
 FROM V_PRODUCT_MOVE I
 INNER JOIN V_FINANCE_DOCUMENT FD ON FD.ID = I.DOCUMENT_ID
 INNER JOIN WAREHOUSE_MOVE STO ON STO.OWNER_ID = FD.ID
 INNER JOIN DOCUMENT_TYPE T ON T.ID = FD.DOCUMENT_TYPE_ID  AND (T.DOCUMENT_SECTION = 'GOODS' OR T.DOCUMENT_SECTION = 'INVENTORY')
 INNER JOIN FINANCE_DOCUMENT_TYPE FT ON T.ID = FT.DOCUMENT_TYPE_ID 
  AND (FT.MOVE_TYPE = 'OUTPUT' OR (FT.MOVE_TYPE = 'ROTATE' AND STO.MOVE_TYPE = 'OUTPUT'));
 



CREATE VIEW V_RPT_GOODS_REST_START (
  PERIOD_ID,
  ORGANIZATION_ID,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  UNIT_ID,
  UNIT_NAME,
  QUANTITY,
  AMOUNT
) AS
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.GOODS_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.QUANTITY,
  R.AMOUNT
 FROM V_RPT_GOODS_REGISTER R
UNION ALL
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.QUANTITY,
  R.AMOUNT
 FROM V_RPT_GOODS_REST R;


CREATE VIEW V_RPT_WRH_GOODS_REST_START (
  PERIOD_ID,
  ORGANIZATION_ID,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  UNIT_ID,
  UNIT_NAME,
  QUANTITY,
  AMOUNT,
  WAREHOUSE_ID
) AS
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.GOODS_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.QUANTITY,
  R.AMOUNT,
  R.WAREHOUSE_ID
 FROM V_RPT_WRH_GOODS_REGISTER R
UNION ALL
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.QUANTITY,
  R.AMOUNT,
  R.WAREHOUSE_ID
 FROM V_RPT_GOODS_REST R;



CREATE VIEW V_RPT_GOODS_CREDIT_FULL (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_NO,
  DOCUMENT_DATE,
  WAREHOUSE_ID,
  PARTNER_ID,
  MTRL_RESPONSIBLE_ID,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRODUCT_PRICE,
  QUANTITY,
  AMOUNT
) AS
SELECT 
  FD.PERIOD_ID,
  FD.ORGANIZATION_ID,
  FD.DOCUMENT_NO,
  FD.DOCUMENT_DATE,
  STO.WAREHOUSE_ID,
  PRT.PARTNER_ID,
  NULL AS MTRL_RESPONSIBLE_ID,
  I.PRODUCT_ID,
  I.PRODUCT_CODE,
  I.PRODUCT_NAME,
  I.ITEM_UNIT_ID,
  I.UNIT_ID,
  I.UNIT_NAME,
  I.ITEM_PRICE AS ITEM_PRICE,
  I.ACCOUNT_QUANTITY AS QUANTITY,
  I.ITEM_AMOUNT AS AMOUNT
 FROM V_PRODUCT_MOVE I
 INNER JOIN V_FINANCE_DOCUMENT FD ON FD.ID = I.DOCUMENT_ID
 INNER JOIN WAREHOUSE_MOVE STO ON STO.OWNER_ID = FD.ID
 LEFT JOIN PARTNER_MOVE PRT ON PRT.OWNER_ID = FD.ID
 INNER JOIN DOCUMENT_TYPE T ON T.ID = FD.DOCUMENT_TYPE_ID  AND (T.DOCUMENT_SECTION = 'GOODS' OR T.DOCUMENT_SECTION = 'INVENTORY')
 INNER JOIN FINANCE_DOCUMENT_TYPE FT ON T.ID = FT.DOCUMENT_TYPE_ID 
  AND (FT.MOVE_TYPE = 'INPUT' OR (FT.MOVE_TYPE = 'ROTATE' AND STO.MOVE_TYPE = 'INPUT'));
 



CREATE VIEW V_RPT_GOODS_DEBIT_FULL (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_NO,
  DOCUMENT_DATE,
  WAREHOUSE_ID,
  PARTNER_ID,
  MTRL_RESPONSIBLE_ID,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRODUCT_PRICE,
  QUANTITY,
  AMOUNT
) AS
SELECT 
  FD.PERIOD_ID,
  FD.ORGANIZATION_ID,
  FD.DOCUMENT_NO,
  FD.DOCUMENT_DATE,
  STO.WAREHOUSE_ID,
  PRT.PARTNER_ID,
  NULL AS MTRL_RESPONSIBLE_ID,
  I.PRODUCT_ID,
  I.PRODUCT_CODE,
  I.PRODUCT_NAME,
  I.ITEM_UNIT_ID,
  I.UNIT_ID,
  I.UNIT_NAME,
  I.ITEM_PRICE AS ITEM_PRICE,
  I.ACCOUNT_QUANTITY AS QUANTITY,
  I.ITEM_AMOUNT AS AMOUNT
 FROM V_PRODUCT_MOVE I
 INNER JOIN V_FINANCE_DOCUMENT FD ON FD.ID = I.DOCUMENT_ID
 INNER JOIN WAREHOUSE_MOVE STO ON STO.OWNER_ID = FD.ID
 LEFT JOIN PARTNER_MOVE PRT ON PRT.OWNER_ID = FD.ID
 INNER JOIN DOCUMENT_TYPE T ON T.ID = FD.DOCUMENT_TYPE_ID  AND (T.DOCUMENT_SECTION = 'GOODS' OR T.DOCUMENT_SECTION = 'INVENTORY')
 INNER JOIN FINANCE_DOCUMENT_TYPE FT ON T.ID = FT.DOCUMENT_TYPE_ID 
  AND (FT.MOVE_TYPE = 'OUTPUT' OR (FT.MOVE_TYPE = 'ROTATE' AND STO.MOVE_TYPE = 'OUTPUT'));
 



CREATE VIEW V_RPT_GOODS_ROTATE (
 ORGANIZATION_ID,
 PERIOD_ID, 
 PRODUCT_ID, 
 REST_QUANTITY,
 REST_AMOUNT, 
 CREDIT_QUANTITY,
 CREDIT_AMOUNT,
 DEBIT_QUANTITY,
 DEBIT_AMOUNT
) AS
SELECT R.ORGANIZATION_ID, R.PERIOD_ID, 
 R.PRODUCT_ID,
 CAST(R.QUANTITY AS NUMERIC(9, 4)) AS REST_QUANTITY, CAST(R.AMOUNT AS NUMERIC(9,2)) AS REST_AMOUNT,
 CAST(0.0 AS NUMERIC(9, 4)) AS CREDIT_QUANTITY, CAST(0.0 AS NUMERIC(9, 2)) AS CREDIT_AMOUNT,
 CAST(0.0 AS NUMERIC(9, 4)) AS DEBIT_QUANTITY, CAST(0.0 AS NUMERIC(9, 2)) AS DEBIT_AMOUNT
 FROM V_RPT_GOODS_REST_START R
UNION ALL 
SELECT D.ORGANIZATION_ID, D.PERIOD_ID, 
 D.PRODUCT_ID, CAST(0.0 AS NUMERIC(9, 4)) AS REST_QUANTITY, CAST(0.0 AS NUMERIC(9, 2)) AS REST_AMOUNT,
 CAST(D.QUANTITY AS NUMERIC(9, 4)) AS CREDIT_QUANTITY, CAST(D.AMOUNT AS NUMERIC(9,2)) AS CREDIT_AMOUNT,
 CAST(0.0 AS NUMERIC(9, 4)) AS DEBIT_QUANTITY, CAST(0.0 AS NUMERIC(9, 2)) AS DEBIT_AMOUNT
 FROM V_GOODS_CREDIT_FULL D
UNION ALL 
SELECT C.ORGANIZATION_ID, C.PERIOD_ID, 
 C.PRODUCT_ID, CAST(0.0 AS NUMERIC(9, 4)) AS REST_QUANTITY, CAST(0.0 AS NUMERIC(9, 2)) AS REST_AMOUNT,
 CAST(0.0 AS NUMERIC(9, 4)) AS CREDIT_QUANTITY, CAST(0.0 AS NUMERIC(9, 2)) AS CREDIT_AMOUNT,
 CAST(C.QUANTITY AS NUMERIC(9, 4)) AS DEBIT_QUANTITY, CAST(C.AMOUNT AS NUMERIC(9,2)) AS DEBIT_AMOUNT
 FROM V_GOODS_DEBIT_FULL C;

CREATE VIEW V_PARTNER_REST (
 ID,
 PERIOD_ID,
 ORGANIZATION_ID,
 PARTNER_ID,
 DEBIT_AMOUNT,
 CREDIT_AMOUNT
) AS
SELECT
 ID,
 PERIOD_ID,
 ORGANIZATION_ID,
 PARTNER_ID,
 DEBIT_AMOUNT,
 CREDIT_AMOUNT
FROM
 PARTNER_REST;

CREATE VIEW V_RPT_PARTNER_REGISTER (
  PERIOD_ID,
  ORGANIZATION_ID,
  PARTNER_ID,
  PARTNER_NAME,
  DEBIT_AMOUNT,
  CREDIT_AMOUNT
) AS
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.PARTNER_ID,
  P.NAME AS PARTNER_NAME,
  R.DEBIT_AMOUNT,
  R.CREDIT_AMOUNT
 FROM V_PARTNER_REGISTER R
 INNER JOIN PARTNER P ON P.ID = R.PARTNER_ID;

CREATE VIEW V_RPT_PARTNER_REST (
  PERIOD_ID,
  ORGANIZATION_ID,
  PARTNER_ID,
  PARTNER_NAME,
  DEBIT_AMOUNT,
  CREDIT_AMOUNT
) AS
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.PARTNER_ID,
  P.NAME AS PARTNER_NAME,
  R.DEBIT_AMOUNT,
  R.CREDIT_AMOUNT
 FROM V_PARTNER_REST R
 INNER JOIN PARTNER P ON P.ID = R.PARTNER_ID;

CREATE VIEW V_RPT_PARTNER_REST_START (
  PERIOD_ID,
  ORGANIZATION_ID,
  PARTNER_ID,
  PARTNER_NAME,
  CREDIT_AMOUNT,
  DEBIT_AMOUNT
) AS
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.PARTNER_ID,
  R.PARTNER_NAME,
  R.CREDIT_AMOUNT,
  R.DEBIT_AMOUNT
 FROM V_RPT_PARTNER_REGISTER R
UNION ALL
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.PARTNER_ID,
  R.PARTNER_NAME,
  R.CREDIT_AMOUNT,
  R.DEBIT_AMOUNT
 FROM V_RPT_PARTNER_REST R;

CREATE VIEW V_RPT_PARTNER_CREDIT_FULL (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_NO,
  DOCUMENT_DATE,
  PARTNER_ID,
  AMOUNT
) AS
SELECT 
  FD.PERIOD_ID,
  FD.ORGANIZATION_ID,
  FD.DOCUMENT_NO,
  FD.DOCUMENT_DATE,
  P.PARTNER_ID,
  FD.DOCUMENT_TOTAL
 FROM V_FINANCE_DOCUMENT FD
 INNER JOIN V_PARTNER_MOVE P ON FD.ID = P.DOCUMENT_ID
 INNER JOIN DOCUMENT_TYPE T ON T.ID = FD.DOCUMENT_TYPE_ID
 INNER JOIN FINANCE_DOCUMENT_TYPE FT ON T.ID = FT.DOCUMENT_TYPE_ID 
 WHERE T.DOCUMENT_SECTION = 'PAYMENT' AND FT.MOVE_TYPE = 'INPUT';


CREATE VIEW V_RPT_PARTNER_DEBIT_FULL (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_NO,
  DOCUMENT_DATE,
  PARTNER_ID,
  AMOUNT
) AS
SELECT 
  FD.PERIOD_ID,
  FD.ORGANIZATION_ID,
  FD.DOCUMENT_NO,
  FD.DOCUMENT_DATE,
  P.PARTNER_ID,
  FD.DOCUMENT_TOTAL
 FROM V_FINANCE_DOCUMENT FD
 INNER JOIN V_PARTNER_MOVE P ON FD.ID = P.DOCUMENT_ID
 INNER JOIN DOCUMENT_TYPE T ON T.ID = FD.DOCUMENT_TYPE_ID
 INNER JOIN FINANCE_DOCUMENT_TYPE FT ON T.ID = FT.DOCUMENT_TYPE_ID 
 WHERE T.DOCUMENT_SECTION = 'PAYMENT' AND FT.MOVE_TYPE = 'OUTPUT';


CREATE VIEW V_RPT_PARTNER_ROTATE (
 ORGANIZATION_ID,
 PERIOD_ID, 
 PARTNER_ID,
 REST_CREDIT_AMOUNT, 
 REST_DEBIT_AMOUNT, 
 CREDIT_AMOUNT,
 DEBIT_AMOUNT
) AS
SELECT 
 R.ORGANIZATION_ID,
 R.PERIOD_ID, 
 R.PARTNER_ID,
 CAST(R.CREDIT_AMOUNT AS NUMERIC(9, 2)) AS REST_CREDIT_AMOUNT, 
 CAST(R.DEBIT_AMOUNT AS NUMERIC(9, 2)) AS REST_DEBIT_AMOUNT, 
 CAST(0.0 AS NUMERIC(9, 2)) AS CREDIT_AMOUNT,
 CAST(0.0 AS NUMERIC(9, 2)) AS DEBIT_AMOUNT
FROM V_RPT_PARTNER_REST_START R
UNION ALL 
SELECT 
 C.ORGANIZATION_ID,
 C.PERIOD_ID, 
 C.PARTNER_ID,
 CAST(0.0 AS NUMERIC(9, 2)) AS REST_CREDIT_AMOUNT, 
 CAST(0.0 AS NUMERIC(9, 2)) AS REST_DEBIT_AMOUNT, 
 CAST(C.AMOUNT AS NUMERIC(9, 2)) AS CREDIT_AMOUNT,
 CAST(0.0 AS NUMERIC(9, 2)) AS DEBIT_AMOUNT
FROM V_RPT_PARTNER_CREDIT_FULL C
UNION ALL 
SELECT 
 D.ORGANIZATION_ID,
 D.PERIOD_ID, 
 D.PARTNER_ID,
 CAST(0.0 AS NUMERIC(9, 2)) AS REST_CREDIT_AMOUNT, 
 CAST(0.0 AS NUMERIC(9, 2)) AS REST_DEBIT_AMOUNT, 
 CAST(0.0 AS NUMERIC(9, 2)) AS CREDIT_AMOUNT,
 CAST(D.AMOUNT AS NUMERIC(9, 2)) AS DEBIT_AMOUNT
 FROM V_RPT_PARTNER_DEBIT_FULL D;

CREATE VIEW V_EMPLOYEE_RESULT (
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
 PAYROLL_AMOUNT,
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
SELECT 
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
 T.PAYROLL_AMOUNT,
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
FROM EMPLOYEE E LEFT JOIN EMPLOYEE_TOTAL T ON T.EMPLOYEE_ID = E.ID;

CREATE VIEW V_LEDGER_ACCOUNT_REST (
 ID,
 PERIOD_ID,
 ORGANIZATION_ID,
 LEDGER_ACCOUNT_ID,
 DEBIT_AMOUNT,
 CREDIT_AMOUNT
) AS
SELECT
 ID,
 PERIOD_ID,
 ORGANIZATION_ID,
 LEDGER_ACCOUNT_ID,
 DEBIT_AMOUNT,
 CREDIT_AMOUNT
FROM
 LEDGER_ACCOUNT_REST;

CREATE VIEW V_LEDGER_ACCOUNT_REGISTER (
 ID,
 ORGANIZATION_ID,
 PERIOD_ID,
 LEDGER_ACCOUNT_ID,
 DEBIT_AMOUNT,
 CREDIT_AMOUNT
) AS 
SELECT 
 R.ID,
 R.ORGANIZATION_ID,
 R.PERIOD_ID,
 R.LEDGER_ACCOUNT_ID,
 R.DEBIT_AMOUNT,
 R.CREDIT_AMOUNT
 FROM LEDGER_ACCOUNT_REGISTER R;


CREATE VIEW V_RPT_LDG_ACCOUNT_REST (
  PERIOD_ID,
  ORGANIZATION_ID,
  LEDGER_ACCOUNT_ID,
  LEDGER_ACCOUNT_CODE,
  LEDGER_ACCOUNT_NAME,
  DEBIT_AMOUNT,
  CREDIT_AMOUNT
) AS
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.LEDGER_ACCOUNT_ID,
  A.CODE AS LEDGER_ACCOUNT_CODE,
  A.NAME AS LEDGER_ACCOUNT_NAME,
  R.DEBIT_AMOUNT,
  R.CREDIT_AMOUNT
 FROM V_LEDGER_ACCOUNT_REST R
 INNER JOIN LEDGER_ACCOUNT A ON A.ID = R.LEDGER_ACCOUNT_ID;

CREATE VIEW V_RPT_LDG_ACCOUNT_REGISTER (
  PERIOD_ID,
  ORGANIZATION_ID,
  LEDGER_ACCOUNT_ID,
LEDGER_ACCOUNT_CODE,
  LEDGER_ACCOUNT_NAME,
  DEBIT_AMOUNT,
  CREDIT_AMOUNT
) AS
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.LEDGER_ACCOUNT_ID,
  A.CODE AS LEDGER_ACCOUNT_CODE,
  A.NAME AS LEDGER_ACCOUNT_NAME,
  R.DEBIT_AMOUNT,
  R.CREDIT_AMOUNT
 FROM V_LEDGER_ACCOUNT_REGISTER R
 INNER JOIN LEDGER_ACCOUNT A ON A.ID = R.LEDGER_ACCOUNT_ID;

CREATE VIEW V_RPT_LDG_ACCOUNT_REST_START (
  PERIOD_ID,
  ORGANIZATION_ID,
  LEDGER_ACCOUNT_ID,
  LEDGER_ACCOUNT_CODE,
  LEDGER_ACCOUNT_NAME,
  CREDIT_AMOUNT,
  DEBIT_AMOUNT
) AS
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.LEDGER_ACCOUNT_ID,
  R.LEDGER_ACCOUNT_CODE,
  R.LEDGER_ACCOUNT_NAME,
  R.CREDIT_AMOUNT,
  R.DEBIT_AMOUNT
 FROM V_RPT_LDG_ACCOUNT_REGISTER R
UNION ALL
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.LEDGER_ACCOUNT_ID,
  R.LEDGER_ACCOUNT_CODE,
  R.LEDGER_ACCOUNT_NAME,
  R.CREDIT_AMOUNT,
  R.DEBIT_AMOUNT
 FROM V_RPT_LDG_ACCOUNT_REST R;

CREATE VIEW V_RPT_LDG_ACCOUNT_CREDIT_FULL (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_NO,
  DOCUMENT_DATE,
  LEDGER_ACCOUNT_ID,
  CORR_LEDGER_ACCOUNT_ID,
  AMOUNT
) AS
SELECT 
  FD.PERIOD_ID,
  FD.ORGANIZATION_ID,
  FD.DOCUMENT_NO,
  FD.DOCUMENT_DATE,
  I.DEBIT_LEDGER_ACCOUNT_ID,
  I.CREDIT_LEDGER_ACCOUNT_ID,
  I.AMOUNT
 FROM V_FINANCE_DOCUMENT FD
 INNER JOIN ENTRY_ITEM I ON I.OWNER_ID = FD.ID;


CREATE VIEW V_RPT_LDG_ACCOUNT_DEBIT_FULL (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_NO,
  DOCUMENT_DATE,
  LEDGER_ACCOUNT_ID,
  CORR_LEDGER_ACCOUNT_ID,
  AMOUNT
) AS
SELECT 
  FD.PERIOD_ID,
  FD.ORGANIZATION_ID,
  FD.DOCUMENT_NO,
  FD.DOCUMENT_DATE,
  I.CREDIT_LEDGER_ACCOUNT_ID,
  I.DEBIT_LEDGER_ACCOUNT_ID,
  I.AMOUNT
 FROM V_FINANCE_DOCUMENT FD
 INNER JOIN ENTRY_ITEM I ON I.OWNER_ID = FD.ID;


CREATE VIEW V_RPT_LDG_ACCOUNT_ROTATE (
 ORGANIZATION_ID,
 PERIOD_ID, 
 LEDGER_ACCOUNT_ID,
 REST_CREDIT_AMOUNT, 
 REST_DEBIT_AMOUNT, 
 CREDIT_AMOUNT,
 DEBIT_AMOUNT
) AS
SELECT 
 R.ORGANIZATION_ID,
 R.PERIOD_ID, 
 R.LEDGER_ACCOUNT_ID,
 CAST(R.CREDIT_AMOUNT AS NUMERIC(9, 2)) AS REST_CREDIT_AMOUNT, 
 CAST(R.DEBIT_AMOUNT AS NUMERIC(9, 2)) AS REST_DEBIT_AMOUNT, 
 CAST(0.0 AS NUMERIC(9, 2)) AS CREDIT_AMOUNT,
 CAST(0.0 AS NUMERIC(9, 2)) AS DEBIT_AMOUNT
FROM V_RPT_LDG_ACCOUNT_REST_START R
UNION ALL 
SELECT 
 C.ORGANIZATION_ID,
 C.PERIOD_ID, 
 C.LEDGER_ACCOUNT_ID,
 CAST(0.0 AS NUMERIC(9, 2)) AS REST_CREDIT_AMOUNT, 
 CAST(0.0 AS NUMERIC(9, 2)) AS REST_DEBIT_AMOUNT, 
 CAST(C.AMOUNT AS NUMERIC(9, 2)) AS CREDIT_AMOUNT,
 CAST(0.0 AS NUMERIC(9, 2)) AS DEBIT_AMOUNT
FROM V_RPT_LDG_ACCOUNT_CREDIT_FULL C
UNION ALL 
SELECT 
 D.ORGANIZATION_ID,
 D.PERIOD_ID, 
 D.LEDGER_ACCOUNT_ID,
 CAST(0.0 AS NUMERIC(9, 2)) AS REST_CREDIT_AMOUNT, 
 CAST(0.0 AS NUMERIC(9, 2)) AS REST_DEBIT_AMOUNT, 
 CAST(0.0 AS NUMERIC(9, 2)) AS CREDIT_AMOUNT,
 CAST(D.AMOUNT AS NUMERIC(9, 2)) AS DEBIT_AMOUNT
 FROM V_RPT_LDG_ACCOUNT_DEBIT_FULL D;

CREATE VIEW V_RPT_LDG_ACCOUNT_ALL (
 ORGANIZATION_ID,
 PERIOD_ID, 
 LEDGER_ACCOUNT_ID
) AS
SELECT 
 R.ORGANIZATION_ID,
 R.PERIOD_ID, 
 R.LEDGER_ACCOUNT_ID
FROM V_RPT_LDG_ACCOUNT_REST_START R
UNION 
SELECT 
 C.ORGANIZATION_ID,
 C.PERIOD_ID, 
 C.LEDGER_ACCOUNT_ID
FROM V_RPT_LDG_ACCOUNT_CREDIT_FULL C
UNION 
SELECT 
 D.ORGANIZATION_ID,
 D.PERIOD_ID, 
 D.LEDGER_ACCOUNT_ID
 FROM V_RPT_LDG_ACCOUNT_DEBIT_FULL D;

CREATE VIEW V_RPT_LDG_ACCOUNT_CORR (
 ORGANIZATION_ID,
 PERIOD_ID, 
 OPERATION_TYPE,
 LEDGER_ACCOUNT_ID,
 CORR_LEDGER_ACCOUNT_ID,
 AMOUNT,
 BALANCE_AMOUNT
) AS
SELECT 
 C.ORGANIZATION_ID,
 C.PERIOD_ID, 
 1 AS OPERATION_TYPE,
 C.LEDGER_ACCOUNT_ID,
 C.CORR_LEDGER_ACCOUNT_ID,
 C.AMOUNT,
 C.AMOUNT
FROM V_RPT_LDG_ACCOUNT_CREDIT_FULL C
UNION ALL 
SELECT 
 D.ORGANIZATION_ID,
 D.PERIOD_ID, 
 2 AS OPERATION_TYPE,
 D.LEDGER_ACCOUNT_ID,
 D.CORR_LEDGER_ACCOUNT_ID,
 D.AMOUNT,
 D.AMOUNT * -1
 FROM V_RPT_LDG_ACCOUNT_DEBIT_FULL D;

/*                                                        */
/*   FIREBIRD IMPLEMENTATION                              */
/*                                                        */
/*   USE FUNCTION EXTRACT():                              */
/*                                                        */
/*   EXTRACT (YEAR FROM DATE)                             */
/*   EXTRACT (MONTH FROM DATE)                            */
/*                                                        */
/*   FIREBIRD DOESN'T HAVE FUNCTIONS YEAR() AND MONTH()   */
/*                                                        */


CREATE VIEW V_PROJECT_DATE (
  ID,
  ORGANIZATION_ID,
  START_DATE,
  END_DATE,
  ACTUAL_END_DATE,
  START_YEAR,
  END_YEAR,
  ACTUAL_END_YEAR,
  START_MONTH,
  END_MONTH,
  ACTUAL_END_MONTH,
  START_DAY,
  END_DAY,
  ACTUAL_END_DAY
) AS
SELECT
  P.ID,
  P.ORGANIZATION_ID,
  P.START_DATE,
  P.END_DATE,
  P.ACTUAL_END_DATE,
  EXTRACT (YEAR FROM P.START_DATE),
  EXTRACT (YEAR FROM P.END_DATE),
  EXTRACT (YEAR FROM P.ACTUAL_END_DATE),
  EXTRACT (MONTH FROM P.START_DATE),
  EXTRACT (MONTH FROM P.END_DATE),
  EXTRACT (MONTH FROM P.ACTUAL_END_DATE),
  EXTRACT (DAY FROM P.START_DATE),
  EXTRACT (DAY FROM P.END_DATE),
  EXTRACT (DAY FROM P.ACTUAL_END_DATE)
FROM PROJECT P;


CREATE VIEW V_PROJECT_DATE_EXT (
  ID,
  ORGANIZATION_ID,
  START_DATE,
  END_DATE,
  ACTUAL_END_DATE,
  START_YEAR,
  END_YEAR,
  ACTUAL_END_YEAR,
  START_MONTH,
  END_MONTH,
  ACTUAL_END_MONTH,
  START_DAY,
  END_DAY,
  ACTUAL_END_DAY,
  START_DAY_POS,
  END_DAY_POS,
  ACTUAL_END_DAY_POS
) AS
SELECT
  P.ID,
  P.ORGANIZATION_ID,
  P.START_DATE,
  P.END_DATE,
  P.ACTUAL_END_DATE,
  P.START_YEAR,
  P.END_YEAR,
  P.ACTUAL_END_YEAR,
  P.START_MONTH,
  P.END_MONTH,
  P.ACTUAL_END_MONTH,
  P.START_DAY,
  P.END_DAY,
  P.ACTUAL_END_DAY,
  P.START_YEAR * 10000 + P.START_MONTH * 100 + P.START_DAY,
  P.END_YEAR * 10000 + P.END_MONTH * 100 + P.END_DAY,
  P.ACTUAL_END_YEAR * 10000 + P.ACTUAL_END_MONTH * 100 + P.ACTUAL_END_DAY
FROM V_PROJECT_DATE P;


CREATE VIEW V_PROJECT_YEAR_UNIQUE (
  ORGANIZATION_ID,
  PROJECT_YEAR
) AS
SELECT
  ORGANIZATION_ID,
  START_YEAR
FROM V_PROJECT_DATE WHERE START_YEAR IS NOT NULL
UNION 
SELECT
  ORGANIZATION_ID,
  END_YEAR
FROM V_PROJECT_DATE  WHERE END_YEAR IS NOT NULL
UNION 
SELECT
  ORGANIZATION_ID,
  ACTUAL_END_YEAR
FROM V_PROJECT_DATE  WHERE ACTUAL_END_YEAR IS NOT NULL;




CREATE VIEW V_PROJECT_YEAR_UNIQUE_INF (
  ORGANIZATION_ID,
  PROJECT_YEAR,
  FLAG_YEAR
) AS
SELECT
  ORGANIZATION_ID,
  PROJECT_YEAR,
  0
FROM V_PROJECT_YEAR_UNIQUE WHERE (PROJECT_YEAR/4.00 - PROJECT_YEAR/4) <> 0
UNION ALL
SELECT
  ORGANIZATION_ID,
  PROJECT_YEAR,
  1
FROM V_PROJECT_YEAR_UNIQUE WHERE (PROJECT_YEAR/4.00 - PROJECT_YEAR/4) = 0;








CREATE VIEW V_PROJECT_PERIOD_DAY (
 ORGANIZATION_ID,
 YEAR_NUMBER,
 MONTH_NUMBER,
 MONTH_NAME,
 DAY_NUMBER,
 DAY_POS
) AS
SELECT
 PY.ORGANIZATION_ID,
 PY.PROJECT_YEAR AS YEAR_NUMBER,
 SM.MONTH_NUMBER,
 SM.NAME AS MONTH_NAME,
 SD.DAY_NUMBER,
 PY.PROJECT_YEAR * 10000 + SM.MONTH_NUMBER * 100 + SD.DAY_NUMBER
FROM V_PROJECT_YEAR_UNIQUE_INF PY, SYS_MONTH SM, SYS_DAY SD
 WHERE (SD.DAY_NUMBER <= (SM.DAY_COUNT + PY.FLAG_YEAR));







/*==============================================================*/
/* Firebird                                                     */
/* http://www.firebirdsql.org                                   */
/*==============================================================*/

INSERT INTO SYS_QUARTER (ID, QUARTER_NUMBER, NAME) VALUES (1, 1, 'I  ');
INSERT INTO SYS_QUARTER (ID, QUARTER_NUMBER, NAME) VALUES (2, 2, 'II ');
INSERT INTO SYS_QUARTER (ID, QUARTER_NUMBER, NAME) VALUES (3, 3, 'III');
INSERT INTO SYS_QUARTER (ID, QUARTER_NUMBER, NAME) VALUES (4, 4, 'IV ');

INSERT INTO SYS_MONTH (ID, QUARTER_ID, MONTH_NUMBER, NAME, SHORT_NAME, MOVE_NAME, DAY_COUNT) VALUES (1, 1, 1, 'Январь', 'ЯНВ', 'Января', 31);
INSERT INTO SYS_MONTH (ID, QUARTER_ID, MONTH_NUMBER, NAME, SHORT_NAME, MOVE_NAME, DAY_COUNT) VALUES (2, 1, 2, 'Февраль', 'ФЕВ', 'Февраля', 28);
INSERT INTO SYS_MONTH (ID, QUARTER_ID, MONTH_NUMBER, NAME, SHORT_NAME, MOVE_NAME, DAY_COUNT) VALUES (3, 1, 3, 'Март', 'МАР', 'Марта', 31);
INSERT INTO SYS_MONTH (ID, QUARTER_ID, MONTH_NUMBER, NAME, SHORT_NAME, MOVE_NAME, DAY_COUNT) VALUES (4, 2, 4, 'Апрель', 'АПР', 'Апреля', 30);
INSERT INTO SYS_MONTH (ID, QUARTER_ID, MONTH_NUMBER, NAME, SHORT_NAME, MOVE_NAME, DAY_COUNT) VALUES (5, 2, 5, 'Май', 'МАЙ', 'Мая', 31);
INSERT INTO SYS_MONTH (ID, QUARTER_ID, MONTH_NUMBER, NAME, SHORT_NAME, MOVE_NAME, DAY_COUNT) VALUES (6, 2, 6, 'Июнь', 'ИЮН', 'Июня', 30);
INSERT INTO SYS_MONTH (ID, QUARTER_ID, MONTH_NUMBER, NAME, SHORT_NAME, MOVE_NAME, DAY_COUNT) VALUES (7, 3, 7, 'Июль', 'ИЮЛ', 'Июля', 31);
INSERT INTO SYS_MONTH (ID, QUARTER_ID, MONTH_NUMBER, NAME, SHORT_NAME, MOVE_NAME, DAY_COUNT) VALUES (8, 3, 8, 'Август', 'АВГ', 'Августа', 31);
INSERT INTO SYS_MONTH (ID, QUARTER_ID, MONTH_NUMBER, NAME, SHORT_NAME, MOVE_NAME, DAY_COUNT) VALUES (9, 3, 9, 'Сентябрь', 'СЕН', 'Сентября', 30);
INSERT INTO SYS_MONTH (ID, QUARTER_ID, MONTH_NUMBER, NAME, SHORT_NAME, MOVE_NAME, DAY_COUNT) VALUES (10, 4, 10, 'Октябрь', 'ОКТ', 'Октября', 31);
INSERT INTO SYS_MONTH (ID, QUARTER_ID, MONTH_NUMBER, NAME, SHORT_NAME, MOVE_NAME, DAY_COUNT) VALUES (11, 4, 11, 'Ноябрь', 'НОЯ', 'Ноября', 30);
INSERT INTO SYS_MONTH (ID, QUARTER_ID, MONTH_NUMBER, NAME, SHORT_NAME, MOVE_NAME, DAY_COUNT) VALUES (12, 4, 12, 'Декабрь', 'ДЕК', 'Декабря', 31);

INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (1, 1);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (2, 2);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (3, 3);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (4, 4);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (5, 5);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (6, 6);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (7, 7);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (8, 8);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (9, 9);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (10, 10);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (11, 11);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (12, 12);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (13, 13);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (14, 14);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (15, 15);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (16, 16);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (17, 17);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (18, 18);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (19, 19);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (20, 20);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (21, 21);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (22, 22);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (23, 23);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (24, 24);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (25, 25);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (26, 26);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (27, 27);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (28, 28);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (29, 29);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (30, 30);
INSERT INTO SYS_DAY (ID, DAY_NUMBER) VALUES (31, 31);

INSERT INTO SYS_DATA_TYPE (ID, CODE, NAME, IS_ENABLE)  VALUES ('STRING','String','Строка', 'Y');
INSERT INTO SYS_DATA_TYPE (ID, CODE, NAME, IS_ENABLE)  VALUES ('INTEGER','Integer','Целое число', 'Y');
INSERT INTO SYS_DATA_TYPE (ID, CODE, NAME, IS_ENABLE)  VALUES ('FLOAT','Float','Дробное число', 'Y');
INSERT INTO SYS_DATA_TYPE (ID, CODE, NAME, IS_ENABLE)  VALUES ('DATE','Date','Дата', 'Y');
INSERT INTO SYS_DATA_TYPE (ID, CODE, NAME, IS_ENABLE)  VALUES ('DATETIME','DateTime','Дата/Время', 'N');
INSERT INTO SYS_DATA_TYPE (ID, CODE, NAME, IS_ENABLE)  VALUES ('BOOLEAN','Boolean','Булевое', 'Y');
INSERT INTO SYS_DATA_TYPE (ID, CODE, NAME, IS_ENABLE)  VALUES ('REFERENCE','Reference','Ссылка', 'Y');

INSERT INTO SYS_ENTITY_TYPE (ID, CODE, NAME, IS_CUSTOM, IS_CUSTOM_ATTRIBUTE) VALUES ('DICTIONARY', 'DICTIONARY', 'Справочник', 'N', 'N');
INSERT INTO SYS_ENTITY_TYPE (ID, CODE, NAME, IS_CUSTOM, IS_CUSTOM_ATTRIBUTE) VALUES ('DOCUMENT', 'DOCUMENT', 'Документ', 'N', 'N');
INSERT INTO SYS_ENTITY_TYPE (ID, CODE, NAME, IS_CUSTOM, IS_CUSTOM_ATTRIBUTE) VALUES ('ENTITY', 'ENTITY', 'Сущность', 'N', 'N');
INSERT INTO SYS_ENTITY_TYPE (ID, CODE, NAME, IS_CUSTOM, IS_CUSTOM_ATTRIBUTE) VALUES ('ENUMERATION', 'ENUMERATION', 'Перечисление', 'Y', 'N');
INSERT INTO SYS_ENTITY_TYPE (ID, CODE, NAME, IS_CUSTOM, IS_CUSTOM_ATTRIBUTE) VALUES ('LOOKUP', 'LOOKUP', 'Список', 'Y', 'Y');


INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('ACADEMIC_DEGREE','ACADEMIC_DEGREE','Учёная степень','DICTIONARY','PERSONALITY','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('ACTIVITY_TYPE','ACTIVITY_TYPE','Тип активности компаний','DICTIONARY','PARTNER','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('ADDRESS','ADDRESS','Адрес','DICTIONARY','CONTACT','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('ADDRESS_TYPE','ADDRESS_TYPE','Тип адреса','DICTIONARY','CONTACT','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('APARTMENT_TYPE','APARTMENT_TYPE','Тип апартаментов','DICTIONARY','CONTACT','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('ASSET','ASSET','Основное средство','DICTIONARY','-','N','Y','Y','N','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('BANK','BANK','Банк','DICTIONARY','BANK','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('BANK_ACCOUNT','BANK_ACCOUNT','Банковский счет','DICTIONARY','BANK','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('BANK_CONTEXT','BANK_CONTEXT','Контекст модуля <Банк>','DICTIONARY','BANK','Y','Y','N','N','N','Y');

INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('BUSINESSABLE','BUSINESSABLE','Бизнес-объект','ENTITY','BASE','Y','Y','N','N','N','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('BUSINESSABLE_ENTITY','BUSINESSABLE_ENTITY','Бизнес-сущность','ENTITY','-','N','Y','N','N','N','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('BUSINESSABLE_REGISTER','BUSINESSABLE_REGISTER','Регистр бизнес объектов','ENTITY','FINANCE','Y','Y','N','N','N','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('CASH_INCOME','CASH_INCOME','Приходный кассовый ордер','DOCUMENT','CASH','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('CASH_OUTCOME','CASH_OUTCOME','Расходный кассовый ордер','DOCUMENT','CASH','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('CITY','CITY','Город','DICTIONARY','CONTACT','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('CONTACT','CONTACT','Контакт','ENTITY','ORGANIZATION','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('CONTACTABLE','CONTACTABLE','Контакт-объект','ENTITY','CONTACT','Y','Y','N','N','N','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('CONTACTABLE_ENTITY','CONTACTABLE_ENTITY','Контакт-сущность','ENTITY','-','N','Y','N','N','N','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('CONTACT_CONTEXT','CONTACT_CONTEXT','Контекст модуля <Контакты>','DICTIONARY','CONTACT','Y','Y','N','N','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('CONTACT_TYPE','CONTACT_TYPE','Тип контактов','DICTIONARY','CONTACT','Y','Y','Y','Y','N','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('CONTRACT','CONTRACT','Договор','DOCUMENT','DOCUMENT','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('CONTRACTOR','CONTRACTOR','Контрактник','DICTIONARY','FINANCE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('CONTRACTOR_MOVE','CONTRACTOR_MOVE','Движение по контрактнику','DICTIONARY','FINANCE','Y','Y','N','N','N','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('COUNTRY','COUNTRY','Страна','DICTIONARY','BASE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('CURRENCY','CURRENCY','Валюта','DICTIONARY','BASE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SYS_DATA_TYPE','SYS_DATA_TYPE','Тип данных','ENTITY','BASE','Y','Y','N','N','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('DEPARTMENT','DEPARTMENT','Подразделение','DICTIONARY','ORGANIZATION','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('DISCHARGE_TYPE','DISCHARGE_TYPE','Тип увольнения','DICTIONARY','EMPLOYEE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('DISTRICT','DISTRICT','Район','DICTIONARY','CONTACT','Y','Y','Y','Y','N','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('DOCUMENT','DOCUMENT','Документ','DOCUMENT','DOCUMENT','Y','Y','Y','N','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('DOCUMENT_TYPE','DOCUMENT_TYPE','Тип документа','DICTIONARY','DOCUMENT','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('DOCUMENT_STATUS','DOCUMENT_STATUS','Статус документа','DICTIONARY','DOCUMENT','Y','Y','Y','Y','Y','N');

INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('EDUCATION_FORM','EDUCATION_FORM','Форма образования','DICTIONARY','PERSONALITY','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('EDUCATION_INSTITUTE','EDUCATION_INSTITUTE','Учебное заведение','DICTIONARY','PERSONALITY','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('EDUCATION_TYPE','EDUCATION_TYPE','Тип образования','DICTIONARY','PERSONALITY','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('EMAIL','EMAIL','E-mail','DICTIONARY','CONTACT','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('EMPLOYEE','EMPLOYEE','Служащий','DICTIONARY','EMPLOYEE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('EMPLOYEE_CATEGORY','EMPLOYEE_CATEGORY','Категория служащих','DICTIONARY','EMPLOYEE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('EMPLOYEE_DISCHARGE','EMPLOYEE_DISCHARGE','Приказ об увольнении','DOCUMENT','EMPLOYEE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('EMPLOYEE_VACATION','EMPLOYEE_VACATION','Отпускные','DOCUMENT','PAYROLL','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('EMPLOYEE_VACATION_AVERANGE','EMPLOYEE_VACATION_AVERANGE','Средние по отпускным','DOCUMENT','PAYROLL','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('EMPLOYEE_MOVE','EMPLOYEE_MOVE','Движения по служащим','ENTITY','EMPLOYEE','Y','N','N','Y','N','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('EMPLOYEE_PAYROLL','EMPLOYEE_PAYROLL','Зарплата служащего','ENTITY','PAYROLL','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('EMPLOYEE_RANK','EMPLOYEE_RANK','Ранг служащего','DICTIONARY','EMPLOYEE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('EMPLOYEE_RECEPTION','EMPLOYEE_RECEPTION','Приказ о приёме на работу','DOCUMENT','EMPLOYEE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('EMPLOYEE_SICKLIST','EMPLOYEE_SICKLIST','Больничные','DOCUMENT','PAYROLL','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('EMPLOYEE_SICKLIST_AVERANGE','EMPLOYEE_SICKLIST_AVERANGE','Средние по больничным','DOCUMENT','PAYROLL','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('EMPLOYEE_TOTAL','EMPLOYEE_TOTAL','Итог по служащему','ENTITY','PAYROLL','Y','N','Y','N','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('ENTRY_ITEM','ENTRY_ITEM','Проводки по документу','ENTITY','FINANCE','Y','N','Y','N','Y','N');

INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('FAMILIARITY','FAMILIARITY','Родственные связи','DICTIONARY','PERSONALITY','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('FAMILY_STATUS','FAMILY_STATUS','Семейное положение','DICTIONARY','PERSONALITY','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('FINANCE_DOCUMENT','FINANCE_DOCUMENT','Финансовый документ','DOCUMENT','FINANCE','Y','N','Y','N','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('FINANCE_DOCUMENT_TYPE','FINANCE_DOCUMENT_TYPE','Тип финансового документа','DICTIONARY','FINANCE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('FORM_PROPERTY','FORM_PROPERTY','Форма собственности','DICTIONARY','PARTNER','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('GOODS','GOODS','Номенклатура','DICTIONARY','GOODS','Y','Y','Y','Y','Y','N');

INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('GOODS_INCOME','GOODS_INCOME','Накладная на закупку','DOCUMENT','GOODS','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('GOODS_INCOME_ITEM','GOODS_INCOME_ITEM','Строчки накладной на закупку','DOCUMENT','GOODS','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('GOODS_OUTCOME','GOODS_OUTCOME','Накладная на реализацию','DOCUMENT','GOODS','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('GOODS_OUTCOME_ITEM','GOODS_OUTCOME_ITEM','Строчки накладной на реализацию','DOCUMENT','GOODS','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('GOODS_TYPE','GOODS_TYPE','Тип товара','DICTIONARY','GOODS','Y','Y','Y','Y','Y','N');

INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('INVENTORY_MOVE','INVENTORY_MOVE','Накладная на внутренне перемещение','DOCUMENT','INVENTORY','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('INVENTORY_MOVE_ITEM','INVENTORY_MOVE_ITEM','Строчки накладной на внутренне перемещение','DOCUMENT','INVENTORY','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('INVENTORY_REST','INVENTORY_REST','Остатки по товару','DOCUMENT','INVENTORY','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('INVENTORY_REST_ITEM','INVENTORY_REST_ITEM','Строчки остатков по товару','DOCUMENT','INVENTORY','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('INVENTORY_WRITEOFF','INVENTORY_WRITEOFF','Акт на списание','DOCUMENT','INVENTORY','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('INVENTORY_WRITEOFF_ITEM','INVENTORY_WRITEOFF_ITEM','Строчки акта на списание','DOCUMENT','INVENTORY','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('INVENTORY_INCOME','INVENTORY_INCOME','Приходная накладная','DOCUMENT','INVENTORY','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('INVENTORY_INCOME_ITEM','INVENTORY_INCOME_ITEM','Строчки приходной накладной','DOCUMENT','INVENTORY','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('INVENTORY_OUTCOME','INVENTORY_OUTCOME','Расходная накладная','DOCUMENT','INVENTORY','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('INVENTORY_OUTCOME_ITEM','INVENTORY_OUTCOME_ITEM','Строчки расходной накладной','DOCUMENT','INVENTORY','Y','N','Y','Y','Y','N');


INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('INDUSTRY','INDUSTRY','Индустрия','DICTIONARY','PARTNER','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('INTANGIBLE','INTANGIBLE','Нематериальные активы','DICTIONARY','-','N','Y','N','N','N','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('LANGUAGE','LANGUAGE','Язык','DICTIONARY','BASE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('VACATION_AVERANGE_TYPE','VACATION_AVERANGE_TYPE','Тип средних по отпуску','DICTIONARY','PAYROLL','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('VACATION_CALCULATE','VACATION_CALCULATE','Тип расчёта по отпуску','DICTIONARY','PAYROLL','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('VACATION_TYPE','VACATION_TYPE','Тип отпуска','DICTIONARY','PAYROLL','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('LEDGER_ACCOUNT','LEDGER_ACCOUNT','Бухгалтерский счёт','DICTIONARY','FINANCE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('LEDGER_ACCOUNT_REGISTER','LEDGER_ACCOUNT_REGISTER','Регистр по бухгалтерскому счёту','ENTITY','FINANCE','Y','Y','N','N','N','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('LEDGER_ACCOUNT_REST','LEDGER_ACCOUNT_REST','Остатки по бухгалтерскому счёту','ENTITY','FINANCE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('LEDGER_ACCOUNT_TYPE','LEDGER_ACCOUNT_TYPE','Тип бухгалтерского счёта','DICTIONARY','FINANCE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('LOCALITY','LOCALITY','Населённый пункт','DICTIONARY','CONTACT','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('LOCALITY_TYPE','LOCALITY_TYPE','Тип населённого пункта','DICTIONARY','CONTACT','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('MILITARY_RANK','MILITARY_RANK','Воинское звание','DICTIONARY','PERSONALITY','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('MILITARY_SPECIALITY','MILITARY_SPECIALITY','Воинская специальность','DICTIONARY','PERSONALITY','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('MILITARY_STATUS','MILITARY_STATUS','Воинский статус','DICTIONARY','PERSONALITY','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('M_LEDGER_ACCOUNT_REGISTER','M_LEDGER_ACCOUNT_REGISTER','-','ENTITY','-','Y','Y','N','N','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('M_LEDGER_ACCOUNT_REGISTER_ID','M_LEDGER_ACCOUNT_REGISTER_ID','-','ENTITY','-','Y','Y','N','N','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('M_LEDGER_ACCOUNT_REGISTER_SUM','M_LEDGER_ACCOUNT_REGISTER_SUM','-','ENTITY','-','Y','Y','N','N','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('M_PARTNER_REGISTER','M_PARTNER_REGISTER','-','ENTITY','-','Y','Y','N','N','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('M_PARTNER_REGISTER_ID','M_PARTNER_REGISTER_ID','-','ENTITY','-','Y','Y','N','N','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('M_PARTNER_REGISTER_SUM','M_PARTNER_REGISTER_SUM','-','ENTITY','-','Y','Y','N','N','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('M_PRODUCT_DETAIL_REGISTER','M_PRODUCT_DETAIL_REGISTER','-','ENTITY','-','Y','Y','N','N','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('M_PRODUCT_DETAIL_REGISTER_ID','M_PRODUCT_DETAIL_REGISTER_ID','-','ENTITY','-','Y','Y','N','N','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('M_PRODUCT_DETAIL_REGISTER_SUM','M_PRODUCT_DETAIL_REGISTER_SUM','-','ENTITY','-','Y','Y','N','N','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('M_PRODUCT_REGISTER','M_PRODUCT_REGISTER','-','ENTITY','-','Y','Y','N','N','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('M_PRODUCT_REGISTER_ID','M_PRODUCT_REGISTER_ID','-','ENTITY','-','Y','Y','N','N','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('M_PRODUCT_REGISTER_SUM','M_PRODUCT_REGISTER_SUM','-','ENTITY','-','Y','Y','N','N','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('ORGANIZATION','ORGANIZATION','Организация','DICTIONARY','ORGANIZATION','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PARTNER','PARTNER','Контрагент','DICTIONARY','PARTNER','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PARTNER_ACTIVITY_TYPE_LINK','PARTNER_ACTIVITY_TYPE_LINK','Деятельность по контрагенту','DICTIONARY','PARTNER','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PARTNER_CATEGORY','PARTNER_CATEGORY','Категория контрагентов','DICTIONARY','PARTNER','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PARTNER_CATEGORY_LINK','PARTNER_CATEGORY_LINK','Категории по контрагенту','DICTIONARY','PARTNER','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PARTNER_GROUP','PARTNER_GROUP','Группа контрагентов','DICTIONARY','PARTNER','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PARTNER_MOVE','PARTNER_MOVE','Движение по контрагенту','ENTITY','FINANCE','Y','N','Y','N','N','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PARTNER_REGISTER','PARTNER_REGISTER','Регистр по контрагенту','ENTITY','FINANCE','Y','Y','N','N','N','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PARTNER_REST','PARTNER_REST','Остатки по контрагенту','ENTITY','FINANCE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PAYMENT_DOCUMENT_LINK','PAYMENT_DOCUMENT_LINK','Документы для оплаты','DICTIONARY','BANK','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PAYMENT_INCOME','PAYMENT_INCOME','Платёжное требование','DOCUMENT','BANK','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PAYMENT_MISSING','PAYMENT_MISSING','Назначение платежа','DICTIONARY','BANK','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PAYMENT_OUTCOME','PAYMENT_OUTCOME','Платежное поручение','DOCUMENT','BANK','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PAYMENT_OUTCOME_TEMPLATE','PAYMENT_OUTCOME_TEMPLATE','Шаблон платежного поручения','DICTIONARY','BANK','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PAYMENT_TYPE','PAYMENT_TYPE','Тип оплаты','DICTIONARY','BANK','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PAYROLL','PAYROLL','Начисления/Удержания','DICTIONARY','PAYROLL','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PAYROLL_ALGORITM','PAYROLL_ALGORITM','Алгоритм начислений/удержаний','DICTIONARY','PAYROLL','Y','Y','Y','N','N','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PAYROLL_ALGORITM_TYPE','PAYROLL_ALGORITM_TYPE','Тип алгоритма начислений/удержаний','DICTIONARY','PAYROLL','Y','Y','Y','N','N','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PAYROLL_FORM','PAYROLL_FORM','Форма оплаты труда','DICTIONARY','PAYROLL','Y','Y','Y','N','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PAYROLL_GROUP','PAYROLL_GROUP','Группа начислений/удержаний','DICTIONARY','PAYROLL','Y','Y','Y','N','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PAYROLL_ITEM','PAYROLL_ITEM','Подчинённые начисления/удержания','DICTIONARY','PAYROLL','N','N','Y','N','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PAYROLL_MODE','PAYROLL_MODE','Режим начислений/удержаний','DICTIONARY','PAYROLL','Y','Y','Y','N','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PAYROLL_TYPE','PAYROLL_TYPE','Тип начислений/удержаний','DICTIONARY','PAYROLL','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PERIOD','PERIOD','Период','ENTITY','BASE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PERIOD_TYPE','PERIOD_TYPE','Тип периода','DICTIONARY','BASE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PERSON','PERSON','Физическое лицо','DICTIONARY','PERSONALITY','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PERSON_DOCUMENT','PERSON_DOCUMENT','Документ физического лица','DICTIONARY','PERSONALITY','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PERSON_DOCUMENT_TYPE','PERSON_DOCUMENT_TYPE','Тип документа физического лица','DICTIONARY','PERSONALITY','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PERSON_EDUCATION','PERSON_EDUCATION','Образование физического лица','DICTIONARY','PERSONALITY','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PERSON_FAMILY','PERSON_FAMILY','Семья физического лица','DICTIONARY','PERSONALITY','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PERSON_JOB','PERSON_JOB','Работа физического лица','DICTIONARY','PERSONALITY','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PERSON_LANGUAGE','PERSON_LANGUAGE','Язык общения физического лица','DICTIONARY','PERSONALITY','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PERSON_MILITARY','PERSON_MILITARY','Воинская информация по физическому лицу','DICTIONARY','PERSONALITY','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PHONE','PHONE','Телефон','DICTIONARY','CONTACT','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PHONE_TYPE','PHONE_TYPE','Тип телефона','DICTIONARY','CONTACT','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('JOB_POSITION','JOB_POSITION','Должность','DICTIONARY','EMPLOYEE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PRICE_TYPE','PRICE_TYPE','Тип цены','DICTIONARY','PRODUCT','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PRODUCT','PRODUCT','Карточка продукта','DICTIONARY','PRODUCT','Y','N','Y','N','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PRODUCT_DETAIL_REGISTER','PRODUCT_DETAIL_REGISTER','Детализация регистра по товару','ENTITY','-','Y','Y','N','N','N','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PRODUCT_GROUP','PRODUCT_GROUP','Группа карточки продукта','DICTIONARY','PRODUCT','Y','Y','Y','Y','N','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PRODUCT_INSTANCE','PRODUCT_INSTANCE','Экземпляр продукта','DICTIONARY','PRODUCT','Y','Y','Y','N','N','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PRODUCT_MOVE','PRODUCT_MOVE','Движение по карточке продукта','DICTIONARY','FINANCE','Y','N','N','N','N','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PRODUCT_PRICE','PRODUCT_PRICE','Цена по карточке продукта','DICTIONARY','PRODUCT','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PRODUCT_REGISTER','PRODUCT_REGISTER','Регистр товара','ENTITY','PRODUCT','Y','Y','N','N','N','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PRODUCT_SECTION','PRODUCT_SECTION','Секция карточки продукта','DICTIONARY','PRODUCT','Y','Y','Y','N','N','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PRODUCT_UNIT','PRODUCT_UNIT','Единица измерения по карточке продукта','DICTIONARY','PRODUCT','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PROJECT','PROJECT','Проект','ENTITY','PROJECT','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PROJECT_CONTACT_LINK','PROJECT_CONTACT_LINK','Контакты по проекту','ENTITY','PROJECT','N','N','Y','N','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PROJECT_CONTEXT','PROJECT_CONTEXT','Контекст модуля <Проекты>','DICTIONARY','PROJECT','Y','N','N','N','N','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PROJECT_EMPLOYEE_LINK','PROJECT_EMPLOYEE_LINK','Сотрудники по проекту','ENTITY','PROJECT','N','N','Y','N','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PROJECT_ROLE','PROJECT_ROLE','Роли по проекту','DICTIONARY','PROJECT','Y','Y','Y','Y','N','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PROJECT_STAGE','PROJECT_STAGE','Стадия проекта','DICTIONARY','PROJECT','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PROJECT_STAGE_GROUP','PROJECT_STAGE_GROUP','Группа стадий проекта','DICTIONARY','PROJECT','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PROJECT_STAGE_LINK','PROJECT_STAGE_LINK','Стадии по проекту','DICTIONARY','PROJECT','Y','N','Y','N','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PROJECT_STATUS','PROJECT_STATUS','Состояние проекта','DICTIONARY','PROJECT','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PROJECT_TYPE','PROJECT_TYPE','Тип  проекта','DICTIONARY','PROJECT','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PURCHASE_INVOICE','PURCHASE_INVOICE','Счёт-фактура на покупку','DOCUMENT','PURCHASE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PURCHASE_INVOICE_ITEM','PURCHASE_INVOICE_ITEM','Строчки счёта-фактуры на покупку','DOCUMENT','PURCHASE','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PURCHASE_ORDER','PURCHASE_ORDER','Заказ на покупку','DOCUMENT','PURCHASE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PURCHASE_ORDER_ITEM','PURCHASE_ORDER_ITEM','Строчки заказа на покупку','DOCUMENT','PURCHASE','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PURCHASE_PLAN','PURCHASE_PLAN','План на покупку','DOCUMENT','PURCHASE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PURCHASE_PLAN_ITEM','PURCHASE_PLAN_ITEM','Строчки плана на покупку','DOCUMENT','PURCHASE','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PURCHASE_SERV','PURCHASE_SERV','Акт выполненных работ (вход.)','DOCUMENT','PURCHASE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PURCHASE_SERV_ITEM','PURCHASE_SERV_ITEM','Строчки по акту выполненных работ (вход.)','DOCUMENT','PURCHASE','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PURCHASE_TAX_WAYBILL','PURCHASE_TAX_WAYBILL','Налоговая накладная (вход.)','DOCUMENT','PURCHASE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PURCHASE_TAX_WAYBILL_ITEM','PURCHASE_TAX_WAYBILL_ITEM','Строчки налоговой накладной (вход.)','DOCUMENT','PURCHASE','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('REGION','REGION','Регион','DICTIONARY','CONTACT','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('MTRL_RESPONSIBLE','MTRL_RESPONSIBLE','Материально-ответственный','DICTIONARY','ORGANIZATION','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SALE_INVOICE','SALE_INVOICE','Счёт-фактура на продажу','DOCUMENT','SALE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SALE_INVOICE_ITEM','SALE_INVOICE_ITEM','Строчки счёта-фактуры на продажу','DOCUMENT','SALE','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SALE_ORDER','SALE_ORDER','Заказ на продажу','DOCUMENT','SALE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SALE_ORDER_ITEM','SALE_ORDER_ITEM','Строчки заказа на продажу','DOCUMENT','SALE','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SALE_PLAN','SALE_PLAN','План на продажу','DOCUMENT','SALE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SALE_PLAN_ITEM','SALE_PLAN_ITEM','Строчки плана на продажу','DOCUMENT','SALE','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SALE_SERV','SALE_SERV','Акт выполненных работ','DOCUMENT','SALE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SALE_SERV_ITEM','SALE_SERV_ITEM','Строчки по акту выполненных работ','DOCUMENT','SALE','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SALE_TAX_WAYBILL','SALE_TAX_WAYBILL','Налоговая накладная','DOCUMENT','SALE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SALE_TAX_WAYBILL_ITEM','SALE_TAX_WAYBILL_ITEM','Строчки налоговой накладной','DOCUMENT','SALE','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SECURE_OBJECT','SECURE_OBJECT','Объекты на которые устанавливается права доступа','ENTITY','-','Y','Y','N','N','N','Y');

INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SICKLIST_AVERANGE_TYPE','SICKLIST_AVERANGE_TYPE','Тип средних для больничных','DICTIONARY','PAYROLL','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SICKLIST_TYPE','SICKLIST_TYPE','Тип больничного листа','DICTIONARY','PAYROLL','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SICK_TYPE','SICK_TYPE','Тип болезни','DICTIONARY','PAYROLL','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SPECIALITY','SPECIALITY','Специальность','DICTIONARY','PERSONALITY','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('WAREHOUSE','WAREHOUSE','Места хранения','DICTIONARY','ORGANIZATION','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('WAREHOUSE_ENTITY','WAREHOUSE_ENTITY','Сущности относящиеся к местам хранения','ENTITY','ORGANIZATION','Y','Y','N','N','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('WAREHOUSE_MOVE','WAREHOUSE_MOVE','Движение по местам хранения','ENTITY','FINANCE','Y','N','N','N','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('STORE','STORE','Склад','DICTIONARY','ORGANIZATION','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('STREET_TYPE','STREET_TYPE','Тип улицы','DICTIONARY','CONTACT','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SYS_ENTITY_ATTR_VALUE','SYS_ENTITY_ATTR_VALUE','Значения атрибута (custom)','ENTITY','-','Y','Y','N','N','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SYS_ENTITY_ATTR','SYS_ENTITY_ATTR','Атрибут (custom)','ENTITY','-','Y','Y','N','N','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SYS_ENTITY_ATTR_GROUP','SYS_ENTITY_ATTR_GROUP','Группа атрибута (custom)','ENTITY','-','Y','Y','N','N','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SYS_DAY','SYS_DAY','Системный день','DICTIONARY','-','Y','Y','N','N','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SYS_ENTITY','SYS_ENTITY','Системная сущность','ENTITY','-','Y','Y','N','N','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SYS_ENTITY_TYPE','SYS_ENTITY_TYPE','Тип системных сущностей','DICTIONARY','-','Y','Y','N','N','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SYS_ENUMERATION','SYS_ENUMERATION','Перечисление (custom)','ENTITY','-','Y','Y','N','N','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SYS_INFO','SYS_INFO','Системная информация','DICTIONARY','BASE','Y','Y','N','N','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SYS_MONTH','SYS_MONTH','Системный месяц','DICTIONARY','-','Y','Y','N','N','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SYS_PERMISSION','SYS_PERMISSION','Права доступа','DICTIONARY','SECURITY','Y','N','Y','N','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SYS_PREFERENCE','SYS_PREFERENCE','Системные настройки','DICTIONARY','-','Y','Y','N','N','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SYS_QUARTER','SYS_QUARTER','Системный квартал','DICTIONARY','-','Y','Y','N','Y','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SYS_LOOKUP','SYS_LOOKUP','Справочник (custom)','ENTITY','-','Y','Y','N','N','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SYS_ROLE','SYS_ROLE','Роль','DICTIONARY','SECURITY','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SYS_USER','SYS_USER','Пользователь','DICTIONARY','SECURITY','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SYS_USER_ROLE','SYS_USER_ROLE','Роль пользователя','DICTIONARY','SECURITY','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('SYS_VARIABLE','SYS_VARIABLE','Системные переменные','DICTIONARY','BASE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('TASK','TASK','Задача','ENTITY','PROJECT','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('TASK_CONTACT_LINK','TASK_CONTACT_LINK','Контакты по задаче','DICTIONARY','PROJECT','N','N','Y','N','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('TASK_CONTEXT','TASK_CONTEXT','Контекст модуля <Задачи>','ENTITY','PROJECT','Y','Y','N','N','N','Y');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('TASK_EMPLOYEE_LINK','TASK_EMPLOYEE_LINK','Сотрудники по задаче','ENTITY','PROJECT','N','N','Y','N','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('TASK_PRIORITY','TASK_PRIORITY','Приоритет задачи','DICTIONARY','PROJECT','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('TASK_RESULT','TASK_RESULT','Результат задачи','DICTIONARY','PROJECT','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('TASK_ROLE','TASK_ROLE','Роль в задаче','DICTIONARY','PROJECT','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('TASK_STATUS','TASK_STATUS','Состояние задачи','DICTIONARY','PROJECT','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('TASK_TYPE','TASK_TYPE','Тип задачи','DICTIONARY','PROJECT','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('TAX','TAX','Налог','DICTIONARY','BASE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('TAXPRINT_TYPE','TAXPRINT_TYPE','Форма печати налога','DICTIONARY','BANK','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('TEMPLATE_ENTRY','TEMPLATE_ENTRY','Шаблон проводки','DICTIONARY','FINANCE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('TEMPLATE_ENTRY_ITEM','TEMPLATE_ENTRY_ITEM','Строчки шаблона проводки','DICTIONARY','FINANCE','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('UNIT','UNIT','Единица измерения','DICTIONARY','BASE','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('WEB','WEB','WEB ресурс','DICTIONARY','CONTACT','Y','N','Y','Y','Y','N');

INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PIM_APPOINTMENT_PRIORITY','PIM_APPOINTMENT_PRIORITY','Приоритет мероприятия','DICTIONARY','PIM','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PIM_APPOINTMENT_TYPE','PIM_APPOINTMENT_TYPE','Тип мероприятия','DICTIONARY','PIM','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PIM_APPOINTMENT','PIM_APPOINTMENT','Мероприятие','DICTIONARY','PIM','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PIM_APPOINTMENT_CONTACT','PIM_APPOINTMENT_CONTACT','Контакты по мероприятию','DICTIONARY','PIM','Y','N','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PIM_EVENT','PIM_EVENT','Событие','DICTIONARY','PIM','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PIM_NOTE','PIM_NOTE','Заметка','DICTIONARY','PIM','Y','Y','Y','Y','Y','N');
INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('PIM_REMINDER','PIM_REMINDER','Напоминание','DICTIONARY','PIM','Y','Y','Y','Y','Y','N');


INSERT INTO SYS_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID, ENTITY_PACKAGE, IS_ENABLE, IS_MASTER, IS_BEAN, IS_FORM, IS_SECURE, IS_SYSTEM) VALUES ('<SYS_ROW>','<SYS_ROW>','<SYS_ROW>','ENTITY','-','N','N','N','N','N','Y');


UPDATE SYS_ENTITY SET ENTITY_CLASS = 'JournalDocument' WHERE CODE = 'DOCUMENT';
UPDATE SYS_ENTITY SET ENTITY_CLASS = 'Position' WHERE CODE = 'POSITIONS';
UPDATE SYS_ENTITY SET ENTITY_CLASS = 'TaxPrintType' WHERE CODE = 'TAXPRINT_TYPE';
UPDATE SYS_ENTITY SET ENTITY_CLASS = 'Role' WHERE CODE = 'SYS_ROLE';
UPDATE SYS_ENTITY SET ENTITY_CLASS = 'User' WHERE CODE = 'SYS_USER';

UPDATE SYS_ENTITY SET IS_CUSTOM_ATTRIBUTE = 'Y' WHERE CODE = 'BANK';
UPDATE SYS_ENTITY SET IS_CUSTOM_ATTRIBUTE = 'Y' WHERE CODE = 'CONTACT';
UPDATE SYS_ENTITY SET IS_CUSTOM_ATTRIBUTE = 'Y' WHERE CODE = 'EMPLOYEE';
UPDATE SYS_ENTITY SET IS_CUSTOM_ATTRIBUTE = 'Y' WHERE CODE = 'PARTNER';
UPDATE SYS_ENTITY SET IS_CUSTOM_ATTRIBUTE = 'Y' WHERE CODE = 'PERSON';
UPDATE SYS_ENTITY SET IS_CUSTOM_ATTRIBUTE = 'Y' WHERE CODE = 'GOODS';
UPDATE SYS_ENTITY SET IS_CUSTOM_ATTRIBUTE = 'Y' WHERE CODE = 'PROJECT';
UPDATE SYS_ENTITY SET IS_CUSTOM_ATTRIBUTE = 'Y' WHERE CODE = 'TASK';

UPDATE SYS_ENTITY SET IS_CUSTOM_ATTRIBUTE = 'Y' WHERE ENTITY_TYPE_ID = 'DOCUMENT' AND IS_MASTER = 'Y';
 
 INSERT INTO SYS_VARIABLE (ID, CODE, NAME, DATA_TYPE_ID) VALUES (1, 'PERSON_NAME', 'Физ. лицо (ФИО)' , 'STRING');
 INSERT INTO SYS_VARIABLE (ID, CODE, NAME, DATA_TYPE_ID) VALUES (2, 'PERSON_NAME_R', 'Физ. лицо (ФИО в род. падеже)' , 'STRING');
 INSERT INTO SYS_VARIABLE (ID, CODE, NAME, DATA_TYPE_ID) VALUES (3, 'DIRECTOR_NAME', 'Директор (ФИО)' , 'STRING');
 INSERT INTO SYS_VARIABLE (ID, CODE, NAME, DATA_TYPE_ID) VALUES (4, 'GENERAL_ACCOUNTANT_NAME', 'Главный бухгалтер (ФИО)' , 'STRING');
 INSERT INTO SYS_VARIABLE (ID, CODE, NAME, DATA_TYPE_ID) VALUES (5, 'ORGANIZATION_ACTIVITY', 'Вид деятельности' , 'STRING');
 INSERT INTO SYS_VARIABLE (ID, CODE, NAME, DATA_TYPE_ID) VALUES (6, 'ORGANIZATION_ACTIVITY_Y_<Г>', 'Вид деятельности в <Г> году' , 'STRING');
 INSERT INTO SYS_VARIABLE (ID, CODE, NAME, DATA_TYPE_ID) VALUES (7, 'ORGANIZATION_ACTIVITY_YQ_<Г>_<К>', 'Вид деятельности в <Г> году, <К> квартале' , 'STRING');
 INSERT INTO SYS_VARIABLE (ID, CODE, NAME, DATA_TYPE_ID) VALUES (8, 'ORGANIZATION_TAX_TYPE', 'Тип налога' , 'STRING');
 INSERT INTO SYS_VARIABLE (ID, CODE, NAME, DATA_TYPE_ID) VALUES (9, 'EMPLOYEE_COUNT', 'Количество работников' , 'INTEGER');
 INSERT INTO SYS_VARIABLE (ID, CODE, NAME, DATA_TYPE_ID) VALUES (10, 'EMPLOYEE_COUNT_Y_<Г>', 'Количество работников за <Г> год' , 'INTEGER');
 INSERT INTO SYS_VARIABLE (ID, CODE, NAME, DATA_TYPE_ID) VALUES (11, 'EMPLOYEE_COUNT_YM_<Г>_<М>', 'Количество работников за <Г> год, <М> месяц' , 'INTEGER');
 INSERT INTO SYS_VARIABLE (ID, CODE, NAME, DATA_TYPE_ID) VALUES (12, 'GOV_TAX_ORGANIZATION_NAME', 'Налоговая служба' , 'STRING');
 INSERT INTO SYS_VARIABLE (ID, CODE, NAME, DATA_TYPE_ID) VALUES (13, 'GOV_PENSION_ORGANIZATION_NAME', 'Пенсионный фонд' , 'STRING');
 INSERT INTO SYS_VARIABLE (ID, CODE, NAME, DATA_TYPE_ID) VALUES (14, 'GOV_TAX_AMOUNT', 'Ставка единого налога' , 'FLOAT');
 INSERT INTO SYS_VARIABLE (ID, CODE, NAME, DATA_TYPE_ID) VALUES (15, 'GOV_PENSION_PERCENT_TAX', '% отчислений в пенсионный фонд от единого налога' , 'FLOAT');
 INSERT INTO SYS_VARIABLE (ID, CODE, NAME, DATA_TYPE_ID) VALUES (16, 'GOV_PENSION_PERCENT', '% отчислений в пенсионный фонд от заработной платы' , 'FLOAT');
 INSERT INTO SYS_VARIABLE (ID, CODE, NAME, DATA_TYPE_ID) VALUES (17, 'ORGANIZATION_PENSION_REG_CODE', 'Код регистрации в пенсионном фонде' , 'STRING');
 INSERT INTO SYS_VARIABLE (ID, CODE, NAME, DATA_TYPE_ID) VALUES (18, 'ORGANIZATION_PENSION_REG_DATE', 'Дата регистрации в пенсионном фонде' , 'DATE');
 INSERT INTO SYS_VARIABLE (ID, CODE, NAME, DATA_TYPE_ID) VALUES (19, 'GOV_TAX_DOCUMENT_MARKER', 'Маркер документа для уплаты налога' , 'STRING');
 INSERT INTO SYS_VARIABLE (ID, CODE, NAME, DATA_TYPE_ID, VALUE_ENTITY_ID) VALUES (20, 'GOV_TAX_BANK_ACCOUNT_ID', 'Банковский счёт для уплаты налога' , 'REFERENCE' , 'BANK_ACCOUNT');
 INSERT INTO SYS_VARIABLE (ID, CODE, NAME, DATA_TYPE_ID, VALUE_ENTITY_ID) VALUES (21, 'GOV_TAX_BANK_ACCOUNT_ID_<N>', 'Банковский счёт <N> для уплаты налога' , 'REFERENCE' , 'BANK_ACCOUNT');
 INSERT INTO SYS_VARIABLE (ID, CODE, NAME, DATA_TYPE_ID) VALUES (22, 'GOV_PENSION_DOCUMENT_MARKER', 'Маркер документа для уплаты в пенс. фонд' , 'STRING');
 INSERT INTO SYS_VARIABLE (ID, CODE, NAME, DATA_TYPE_ID, VALUE_ENTITY_ID) VALUES (23, 'GOV_PENSION_BANK_ACCOUNT_ID', 'Банковский счёт для уплаты в пенс. фонд' , 'REFERENCE' , 'BANK_ACCOUNT');
 INSERT INTO SYS_VARIABLE (ID, CODE, NAME, DATA_TYPE_ID, VALUE_ENTITY_ID) VALUES (24, 'GOV_PENSION_BANK_ACCOUNT_ID_<N>', 'Банковский счёт <N> для уплаты в пенс. фонд' , 'REFERENCE' , 'BANK_ACCOUNT');
 
 

INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (1, 'aa', 'aar', '068', 'Афарский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (2, 'ab', 'abk', '010', 'Абхазский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (3, 'ae', 'ave', '016', 'Авестийский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (4, 'af', 'afr', '070', 'Африкаанс');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (5, 'ak', 'aka', '027', 'Акан');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (6, 'am', 'amh', '040', 'Амхарский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (7, 'ar', 'ara', '050', 'Арабский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (8, 'as', 'asm', '060', 'Ассамский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (9, 'av', 'ava', '014', 'Аварский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (10, 'ay', 'aym', '026', 'Аймара');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (11, 'az', 'aze', '025', 'Азербайджанский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (12, 'ba', 'bak', '086', 'Башкирский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (13, 'be', 'bel', '090', 'Белорусский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (14, 'bg', 'bul', '115', 'Болгарский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (15, 'bi', 'bis', '107', 'Бислама');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (16, 'bn', 'ben', '100', 'Бенгальский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (17, 'bo', 'bod', '680', 'Тибетский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (18, 'br', 'bre', '120', 'Бретонский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (19, 'bs', 'bos', '-', 'Боснийский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (20, 'ca', 'cat', '290', 'Каталанский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (21, 'ce', 'che', '785', 'Чеченский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (22, 'ch', 'cha', '782', 'Чаморро');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (23, 'co', 'cos', '334', 'Корсиканский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (24, 'cs', 'ces', '790', 'Чешский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (25, 'cu', 'chu', '777', 'Церковнославянский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (26, 'cv', 'chv', '795', 'Чувашский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (27, 'cy', 'cym', '130', 'Валлийский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (28, 'da', 'dan', '178', 'Датский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (29, 'de', 'deu', '481', 'Немецкий');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (30, 'dv', 'div', '180', 'Дивехи (Мальдивский)');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (31, 'dz', 'dzo', '183', 'Дзонг-кэ');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (32, 'ee', 'ewe', '820', 'Эве');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (33, 'el', 'ell', '157', 'Греческий (новогреческий)');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (34, 'en', 'eng', '045', 'Английский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (35, 'eo', 'epo', '845', 'Эсперанто');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (36, 'es', 'spa', '230', 'Испанский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (37, 'et', 'est', '850', 'Эстонский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (38, 'eu', 'eus', '085', 'Баскский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (39, 'fa', 'fas', '535', 'Персидский язык');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (40, 'ff', 'ful', '752', 'Фулах');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (41, 'fi', 'fin', '740', 'Финский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (42, 'fj', 'fij', '737', 'Фиджи');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (43, 'fo', 'fao', '735', 'Фарерский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (44, 'fr', 'fra', '745', 'Французский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (45, 'fy', 'fry', '750', 'Фризский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (46, 'ga', 'gle', '220', 'Ирландский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (47, 'gd', 'gla', '170', 'Гаэльский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (48, 'gl', 'glg', '147', 'Галисийский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (49, 'gu', 'guj', '165', 'Гуджарати');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (50, 'ha', 'hau', '761', 'Хауса');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (51, 'he', 'heb', '198', 'Иврит');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (52, 'hi', 'hin', '770', 'Хинди');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (53, 'ho', 'hmo', '772', 'Хиримоту');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (54, 'hr', 'hrv', '-', 'Хорватский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (55, 'ht', 'hat', '-', 'Гаитянский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (56, 'hu', 'hun', '133', 'Венгерский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (57, 'hy', 'hye', '055', 'Армянский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (58, 'hz', 'her', '149', 'Гереро');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (59, 'ia', 'ina', '215', 'Интерлингва');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (60, 'id', 'ind', '210', 'Индонезийский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (61, 'ie', 'ile', '216', 'Интерлингве');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (62, 'ig', 'ibo', '199', 'Игбо');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (63, 'ik', 'ipk', '218', 'Инупиак');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (64, 'is', 'isl', '225', 'Исландский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (65, 'it', 'ita', '235', 'Итальянский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (66, 'iu', 'iku', '217', 'Инуктитут');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (67, 'ja', 'jpn', '870', 'Японский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (68, 'jv', 'jav', '860', 'Яванский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (69, 'ka', 'kat', '158', 'Грузинский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (70, 'kg', 'kon', '326', 'Конго');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (71, 'ki', 'kik', '302', 'Кикуйю');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (72, 'kj', 'kua', '303', 'Киньяма');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (73, 'kk', 'kaz', '255', 'Казахский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (74, 'kl', 'kal', '843', 'Гренландский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (75, 'km', 'khm', '360', 'Кхмерский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (76, 'kn', 'kan', '265', 'Каннада');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (77, 'ko', 'kor', '330', 'Корейский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (78, 'kr', 'kau', '267', 'Канури');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (79, 'ks', 'kas', '294', 'Кашмири');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (80, 'ku', 'kur', '350', 'Курдский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (81, 'kv', 'kom', '320', 'Коми');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (82, 'kw', 'cor', '332', 'Корнский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (83, 'ky', 'kir', '-', 'Киргизский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (84, 'la', 'lat', '380', 'Латинский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (85, 'lb', 'ltz', '409', 'Люксембургский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (86, 'lg', 'lug', '148', 'Ганда');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (87, 'ln', 'lin', '395', 'Лингала');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (88, 'lo', 'lao', '375', 'Лаосский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (89, 'lt', 'lit', '400', 'Литовский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (90, 'lu', 'lub', '404', 'Луба-катанга');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (91, 'lv', 'lav', '385', 'Латышский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (92, 'mg', 'mlg', '418', 'Малагасийский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (93, 'mh', 'mah', '446', 'Маршалльский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (94, 'mi', 'mri', '437', 'Маори');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (95, 'mn', 'mon', '463', 'Монгольский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (96, 'mo', 'mol', '460', 'Молдавский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (97, 'mr', 'mar', '440', 'Маратхи');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (98, 'ms', 'msa', '420', 'Малайский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (99, 'mt', 'mlt', '430', 'Мальтийский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (100, 'my', 'mya', '105', 'Бирманский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (101, 'na', 'nau', '472', 'Науру');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (102, 'nd', 'nde', '473', 'Ндебеле северный');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (103, 'ne', 'nep', '485', 'Непальский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (104, 'ng', 'ndo', '475', 'Ндунга');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (105, 'nl', 'nld', '495', 'Нидерландский (Голландский)');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (106, 'nn', 'nno', '513', 'Нюнорск (новонорвежский)');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (107, 'no', 'nor', '506', 'Норвежский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (108, 'nr', 'nbl', '474', 'Ндебеле южный');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (109, 'nv', 'nav', '470', 'Навахо');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (110, 'ny', 'nya', '510', 'Ньянджа');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (111, 'oc', 'oci', '517', 'Окситанский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (112, 'oj', 'oji', '515', 'Оджибве');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (113, 'om', 'orm', '522', 'Оромо');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (114, 'os', 'oss', '524', 'Осетинский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (115, 'pa', 'pan', '530', 'Пенджабский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (116, 'pi', 'pli', '527', 'Пали');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (117, 'pl', 'pol', '540', 'Польский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (118, 'ps', 'pus', '550', 'Пушту');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (119, 'pt', 'por', '545', 'Португальский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (120, 'qu', 'que', '300', 'Кечуа');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (121, 'rm', 'roh', '560', 'Ретороманский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (122, 'rn', 'run', '567', 'Рунди');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (123, 'ro', 'ron', '565', 'Румынский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (124, 'ru', 'rus', '570', 'Русский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (125, 'rw', 'kin', '304', 'Руанда');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (126, 'sa', 'san', '581', 'Санскрит');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (127, 'sc', 'srd', '583', 'Сардинский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (128, 'sd', 'snd', '600', 'Синдхи');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (129, 'sg', 'sag', '579', 'Санго');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (130, 'si', 'sin', '599', 'Сингальский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (131, 'sk', 'slk', '605', 'Словацкий');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (132, 'sl', 'slv', '610', 'Словенский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (133, 'sm', 'smo', '578', 'Самоанский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (134, 'sn', 'sna', '807', 'Шона');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (135, 'so', 'som', '615', 'Сомали');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (136, 'sq', 'sqi', '030', 'Албанский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (137, 'sr', 'srp', '-', 'Сербский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (138, 'ss', 'ssw', '584', 'Свази');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (139, 'st', 'sot', '618', 'Сото южный');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (140, 'su', 'sun', '633', 'Сунданский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (141, 'sv', 'swe', '805', 'Шведский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (142, 'sw', 'swa', '631', 'Суахили');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (143, 'ta', 'tam', '655', 'Тамильский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (144, 'te', 'tel', '675', 'Телугу');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (145, 'tg', 'tgk', '640', 'Таджикский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (146, 'th', 'tha', '645', 'Тайский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (147, 'ti', 'tir', '683', 'Тигринья');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (148, 'tk', 'tuk', '695', 'Туркменский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (149, 'tl', 'tgl', '636', 'Тагальский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (150, 'tn', 'tsn', '688', 'Тсвана');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (151, 'to', 'ton', '686', 'Тонга (тонга-исландский)');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (152, 'tr', 'tur', '693', 'Турецкий');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (153, 'ts', 'tso', '689', 'Тсонга');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (154, 'tt', 'tat', '660', 'Татарский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (155, 'tw', 'twi', '670', 'Тви');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (156, 'ty', 'tah', '647', 'Таитянский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (157, 'ug', 'uig', '715', 'Уйгурский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (158, 'uk', 'ukr', '720', 'Украинский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (159, 'ur', 'urd', '730', 'Урду');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (160, 'uz', 'uzb', '710', 'Узбекский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (161, 've', 'ven', '134', 'Венда');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (162, 'vi', 'vie', '140', 'Вьетнамский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (163, 'vo', 'vol', '137', 'Волапюк');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (164, 'wo', 'wol', '138', 'Волоф');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (165, 'xh', 'xho', '340', 'Коса');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (166, 'yi', 'yid', '202', 'Идиш');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (167, 'yo', 'yor', '245', 'Йоруба');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (168, 'za', 'zha', '791', 'Чжуанский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (169, 'zh', 'zho', '315', 'Китайский');
INSERT INTO LANGUAGE (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (170, 'zu', 'zul', '195', 'Зулу');


INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (1, 'AD', 'AND', '020', 'Андорра');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (2, 'AE', 'ARE', '784', 'Арабские Эмираты (ОАЭ)');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (3, 'AF', 'AFG', '004', 'Афганистан');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (4, 'AG', 'ATG', '028', 'Антигуа и Барбуда');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (5, 'AI', 'AIA', '660', 'Ангилья');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (6, 'AL', 'ALB', '008', 'Албания');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (7, 'AM', 'ARM', '051', 'Армения');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (8, 'AO', 'AGO', '024', 'Ангола');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (9, 'AQ', 'ATA', '010', 'Антарктида');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (10, 'AR', 'ARG', '032', 'Аргентина');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (11, 'AS', 'ASM', '016', 'Американское Самоа');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (12, 'AT', 'AUT', '040', 'Австрия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (13, 'AU', 'AUS', '036', 'Австралия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (14, 'AW', 'ABW', '533', 'Аруба');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (15, 'AX', 'ALA', '248', 'Аландские острова');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (16, 'AZ', 'AZE', '031', 'Азербайджан');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (17, 'BA', 'BIH', '070', 'Босния и Герцеговина');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (18, 'BB', 'BRB', '052', 'Барбадос');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (19, 'BD', 'BGD', '050', 'Бангладеш');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (20, 'BE', 'BEL', '056', 'Бельгия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (21, 'BF', 'BFA', '854', 'Буркина Фасо');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (22, 'BG', 'BGR', '100', 'Болгария');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (23, 'BH', 'BHR', '048', 'Бахрейн');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (24, 'BI', 'BDI', '108', 'Бурунди');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (25, 'BJ', 'BEN', '204', 'Бенин');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (26, 'BL', 'BLM', '652', 'Сен-Бартельми');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (27, 'BM', 'BMU', '060', 'Бермудские острова');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (28, 'BN', 'BRN', '096', 'Бруней');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (29, 'BO', 'BOL', '068', 'Боливия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (30, 'BQ', 'BES', '535', 'Бонайре');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (31, 'BR', 'BRA', '076', 'Бразилия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (32, 'BS', 'BHS', '044', 'Багамские Острова');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (33, 'BT', 'BTN', '064', 'Бутан');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (34, 'BV', 'BVT', '074', 'Остров Буве');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (35, 'BW', 'BWA', '072', 'Ботсвана');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (36, 'BY', 'BLR', '112', 'Белоруссия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (37, 'BZ', 'BLZ', '084', 'Белиз');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (38, 'CA', 'CAN', '124', 'Канада');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (39, 'CC', 'CCK', '166', 'Кокосовые острова');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (40, 'CD', 'COD', '180', 'Конго');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (41, 'CF', 'CAF', '140', 'Центральноафриканская Республика (ЦАР)');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (42, 'CG', 'COG', '178', 'Конго (республика)');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (43, 'CH', 'CHE', '756', 'Швейцария');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (44, 'CI', 'CIV', '384', 'Кот-д`Ивуар');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (45, 'CK', 'COK', '184', 'Острова Кука');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (46, 'CL', 'CHL', '152', 'Чили');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (47, 'CM', 'CMR', '120', 'Камерун');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (48, 'CN', 'CHN', '156', 'Китайская Народная Республика (КНР)');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (49, 'CO', 'COL', '170', 'Колумбия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (50, 'CR', 'CRI', '188', 'Коста-Рика');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (51, 'CU', 'CUB', '192', 'Куба');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (52, 'CV', 'CPV', '132', 'Кабо-Верде');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (53, 'CW', 'CUW', '531', 'Кюрасао');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (54, 'CX', 'CXR', '162', 'Остров Рождества (Австралия)');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (55, 'CY', 'CYP', '196', 'Кипр');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (56, 'CZ', 'CZE', '203', 'Чехия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (57, 'DE', 'DEU', '276', 'Германия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (58, 'DJ', 'DJI', '262', 'Джибути');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (59, 'DK', 'DNK', '208', 'Дания');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (60, 'DM', 'DMA', '212', 'Доминика');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (61, 'DO', 'DOM', '214', 'Доминиканская Республика');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (62, 'DZ', 'DZA', '012', 'Алжир');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (63, 'EC', 'ECU', '218', 'Эквадор');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (64, 'EE', 'EST', '233', 'Эстония');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (65, 'EG', 'EGY', '818', 'Египет');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (66, 'EH', 'ESH', '732', 'Западная Сахара');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (67, 'ER', 'ERI', '232', 'Эритрея');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (68, 'ES', 'ESP', '724', 'Испания');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (69, 'ET', 'ETH', '231', 'Эфиопия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (70, 'FI', 'FIN', '246', 'Финляндия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (71, 'FJ', 'FJI', '242', 'Фиджи');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (72, 'FK', 'FLK', '238', 'Фолклендские острова');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (73, 'FM', 'FSM', '583', 'Микронезия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (74, 'FO', 'FRO', '234', 'Фарерские острова');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (75, 'FR', 'FRA', '250', 'Франция');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (76, 'GA', 'GAB', '266', 'Габон');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (77, 'GB', 'GBR', '826', 'Великобритания');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (78, 'GD', 'GRD', '308', 'Гренада');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (79, 'GE', 'GEO', '268', 'Грузия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (80, 'GF', 'GUF', '254', 'Французская Гвиана (фр.)');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (81, 'GG', 'GGY', '831', 'Гернси');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (82, 'GH', 'GHA', '288', 'Гана');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (83, 'GI', 'GIB', '292', 'Гибралтар');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (84, 'GL', 'GRL', '304', 'Гренландия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (85, 'GM', 'GMB', '270', 'Гамбия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (86, 'GN', 'GIN', '324', 'Гвинея');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (87, 'GP', 'GLP', '312', 'Гваделупа');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (88, 'GQ', 'GNQ', '226', 'Гвинея');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (89, 'GR', 'GRC', '300', 'Греция');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (90, 'GS', 'SGS', '239', 'Южная Георгия и Южные Сандвичевы острова');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (91, 'GT', 'GTM', '320', 'Гватемала');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (92, 'GU', 'GUM', '316', 'Гуам');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (93, 'GW', 'GNB', '624', 'Гвинея-Бисау');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (94, 'GY', 'GUY', '328', 'Гайана');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (95, 'HK', 'HKG', '344', 'Гонконг');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (96, 'HM', 'HMD', '334', 'Херд и Макдональд');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (97, 'HN', 'HND', '340', 'Гондурас');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (98, 'HR', 'HRV', '191', 'Хорватия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (99, 'HT', 'HTI', '332', 'Гаити');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (100, 'HU', 'HUN', '348', 'Венгрия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (101, 'ID', 'IDN', '360', 'Индонезия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (102, 'IE', 'IRL', '372', 'Ирландия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (103, 'IL', 'ISR', '376', 'Израиль');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (104, 'IM', 'IMN', '833', 'Остров Мэн');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (105, 'IN', 'IND', '356', 'Индия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (106, 'IO', 'IOT', '086', 'Британская территория в Индийском океане');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (107, 'IQ', 'IRQ', '368', 'Ирак');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (108, 'IR', 'IRN', '364', 'Иран');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (109, 'IS', 'ISL', '352', 'Исландия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (110, 'IT', 'ITA', '380', 'Италия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (111, 'JE', 'JEY', '832', 'Джерси');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (112, 'JM', 'JAM', '388', 'Ямайка');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (113, 'JO', 'JOR', '400', 'Иордания');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (114, 'JP', 'JPN', '392', 'Япония');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (115, 'KE', 'KEN', '404', 'Кения');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (116, 'KG', 'KGZ', '417', 'Киргизия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (117, 'KH', 'KHM', '116', 'Камбоджа');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (118, 'KI', 'KIR', '296', 'Кирибати');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (119, 'KM', 'COM', '174', 'Коморы');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (120, 'KN', 'KNA', '659', 'Сент-Китс и Невис');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (121, 'KP', 'PRK', '408', 'Корея (КНДР)');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (122, 'KR', 'KOR', '410', 'Корея');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (123, 'KW', 'KWT', '414', 'Кувейт');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (124, 'KY', 'CYM', '136', 'Каймановы острова');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (125, 'KZ', 'KAZ', '398', 'Казахстан');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (126, 'LA', 'LAO', '418', 'Лаос');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (127, 'LB', 'LBN', '422', 'Ливан');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (128, 'LC', 'LCA', '662', 'Сент-Люсия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (129, 'LI', 'LIE', '438', 'Лихтенштейн');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (130, 'LK', 'LKA', '144', 'Шри-Ланка');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (131, 'LR', 'LBR', '430', 'Либерия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (132, 'LS', 'LSO', '426', 'Лесото');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (133, 'LT', 'LTU', '440', 'Литва');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (134, 'LU', 'LUX', '442', 'Люксембург');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (135, 'LV', 'LVA', '428', 'Латвия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (136, 'LY', 'LBY', '434', 'Ливия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (137, 'MA', 'MAR', '504', 'Марокко');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (138, 'MC', 'MCO', '492', 'Монако');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (139, 'MD', 'MDA', '498', 'Молдавия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (140, 'ME', 'MNE', '499', 'Черногория');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (141, 'MF', 'MAF', '663', 'Сен-Мартен');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (142, 'MG', 'MDG', '450', 'Мадагаскар');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (143, 'MH', 'MHL', '584', 'Маршалловы Острова');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (144, 'MK', 'MKD', '807', 'Македония');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (145, 'ML', 'MLI', '466', 'Мали');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (146, 'MM', 'MMR', '104', 'Мьянма');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (147, 'MN', 'MNG', '496', 'Монголия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (148, 'MO', 'MAC', '446', 'Макао');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (149, 'MP', 'MNP', '580', 'Северные Марианские острова');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (150, 'MQ', 'MTQ', '474', 'Мартиника');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (151, 'MR', 'MRT', '478', 'Мавритания');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (152, 'MS', 'MSR', '500', 'Монтсеррат');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (153, 'MT', 'MLT', '470', 'Мальта');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (154, 'MU', 'MUS', '480', 'Маврикий');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (155, 'MV', 'MDV', '462', 'Мальдивы');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (156, 'MW', 'MWI', '454', 'Малави');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (157, 'MX', 'MEX', '484', 'Мексика');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (158, 'MY', 'MYS', '458', 'Малайзия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (159, 'MZ', 'MOZ', '508', 'Мозамбик');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (160, 'NA', 'NAM', '516', 'Намибия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (161, 'NC', 'NCL', '540', 'Новая Каледония');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (162, 'NE', 'NER', '562', 'Нигер');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (163, 'NF', 'NFK', '574', 'Остров Норфолк');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (164, 'NG', 'NGA', '566', 'Нигерия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (165, 'NI', 'NIC', '558', 'Никарагуа');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (166, 'NL', 'NLD', '528', 'Нидерланды');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (167, 'NO', 'NOR', '578', 'Норвегия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (168, 'NP', 'NPL', '524', 'Непал');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (169, 'NR', 'NRU', '520', 'Науру');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (170, 'NU', 'NIU', '570', 'Ниуэ');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (171, 'NZ', 'NZL', '554', 'Новая Зеландия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (172, 'OM', 'OMN', '512', 'Оман');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (173, 'PA', 'PAN', '591', 'Панама');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (174, 'PE', 'PER', '604', 'Перу');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (175, 'PF', 'PYF', '258', 'Французская Полинезия (фр.)');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (176, 'PG', 'PNG', '598', 'Папуа — Новая Гвинея');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (177, 'PH', 'PHL', '608', 'Филиппины');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (178, 'PK', 'PAK', '586', 'Пакистан');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (179, 'PL', 'POL', '616', 'Польша');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (180, 'PM', 'SPM', '666', 'Сен-Пьер и Микелон');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (181, 'PN', 'PCN', '612', 'Острова Питкэрн');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (182, 'PR', 'PRI', '630', 'Пуэрто-Рико');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (183, 'PS', 'PSE', '275', 'Палестина');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (184, 'PT', 'PRT', '620', 'Португалия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (185, 'PW', 'PLW', '585', 'Палау');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (186, 'PY', 'PRY', '600', 'Парагвай');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (187, 'QA', 'QAT', '634', 'Катар');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (188, 'RE', 'REU', '638', 'Реюньон');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (189, 'RO', 'ROU', '642', 'Румыния');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (190, 'RS', 'SRB', '688', 'Сербия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (191, 'RU', 'RUS', '643', 'Россия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (192, 'RW', 'RWA', '646', 'Руанда');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (193, 'SA', 'SAU', '682', 'Саудовская Аравия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (194, 'SB', 'SLB', '090', 'Соломоновы Острова');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (195, 'SC', 'SYC', '690', 'Сейшельские Острова');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (196, 'SD', 'SDN', '736', 'Судан');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (197, 'SE', 'SWE', '752', 'Швеция');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (198, 'SG', 'SGP', '702', 'Сингапур');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (199, 'SH', 'SHN', '654', 'Остров Святой Елены');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (200, 'SI', 'SVN', '705', 'Словения');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (201, 'SJ', 'SJM', '744', 'Шпицберген и Ян-Майен');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (202, 'SK', 'SVK', '703', 'Словакия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (203, 'SL', 'SLE', '694', 'Сьерра-Леоне');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (204, 'SM', 'SMR', '674', 'Сан-Марино');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (205, 'SN', 'SEN', '686', 'Сенегал');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (206, 'SO', 'SOM', '706', 'Сомали');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (207, 'SR', 'SUR', '740', 'Суринам');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (208, 'ST', 'STP', '678', 'Сан-Томе и Принсипи');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (209, 'SV', 'SLV', '222', 'Сальвадор');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (210, 'SX', 'SXM', '534', 'Синт-Мартен');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (211, 'SY', 'SYR', '760', 'Сирия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (212, 'SZ', 'SWZ', '748', 'Свазиленд');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (213, 'TC', 'TCA', '796', 'Тёркс и Кайкос');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (214, 'TD', 'TCD', '148', 'Чад');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (215, 'TF', 'ATF', '260', 'Южные и Антарктические Территории (фр.)');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (216, 'TG', 'TGO', '768', 'Того');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (217, 'TH', 'THA', '764', 'Таиланд');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (218, 'TJ', 'TJK', '762', 'Таджикистан');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (219, 'TK', 'TKL', '772', 'Токелау');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (220, 'TL', 'TLS', '626', 'Восточный Тимор');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (221, 'TM', 'TKM', '795', 'Туркмения');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (222, 'TN', 'TUN', '788', 'Тунис');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (223, 'TO', 'TON', '776', 'Тонга');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (224, 'TR', 'TUR', '792', 'Турция');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (225, 'TT', 'TTO', '780', 'Тринидад и Тобаго');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (226, 'TV', 'TUV', '798', 'Тувалу');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (227, 'TW', 'TWN', '158', 'Китайская Республика');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (228, 'TZ', 'TZA', '834', 'Танзания');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (229, 'UA', 'UKR', '804', 'Украина');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (230, 'UG', 'UGA', '800', 'Уганда');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (231, 'UM', 'UMI', '581', 'Внешние малые острова (США)');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (232, 'US', 'USA', '840', 'Соединённые Штаты Америки (США)');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (233, 'UY', 'URY', '858', 'Уругвай');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (234, 'UZ', 'UZB', '860', 'Узбекистан');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (235, 'VA', 'VAT', '336', 'Ватикан');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (236, 'VC', 'VCT', '670', 'Сент-Винсент и Гренадины');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (237, 'VE', 'VEN', '862', 'Венесуэла');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (238, 'VG', 'VGB', '092', 'Британские Виргинские острова');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (239, 'VI', 'VIR', '850', 'Американские Виргинские острова');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (240, 'VN', 'VNM', '704', 'Вьетнам');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (241, 'VU', 'VUT', '548', 'Вануату');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (242, 'WF', 'WLF', '876', 'Уоллис и Футуна');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (243, 'WS', 'WSM', '882', 'Самоа');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (244, 'YE', 'YEM', '887', 'Йемен');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (245, 'YT', 'MYT', '175', 'Майотта');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (246, 'ZA', 'ZAF', '710', 'Южно-Африканская Республика (ЮАР)');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (247, 'ZM', 'ZMB', '894', 'Замбия');
INSERT INTO COUNTRY (ID, CODE, CODE3, NUMERIC_CODE, NAME) VALUES (248, 'ZW', 'ZWE', '716', 'Зимбабве');


INSERT INTO CURRENCY (ID, NUMERIC_CODE, NAME, FULL_NAME, CODE) VALUES (1, '840', 'USD', 'доллар','USD');
INSERT INTO CURRENCY (ID, NUMERIC_CODE, NAME, FULL_NAME, CODE) VALUES (2, '978', 'EUR', 'евро','EUR');
INSERT INTO CURRENCY (ID, NUMERIC_CODE, NAME, FULL_NAME, CODE) VALUES (3, '643', 'руб', 'рубль','RUB');
INSERT INTO CURRENCY (ID, NUMERIC_CODE, NAME, FULL_NAME, CODE) VALUES (4, '980', 'грн', 'гривня','UAN');

INSERT INTO SYS_TRANSFER_SOURCE (ID, CODE, NAME, IMPORTER_CLASS, EXPORTER_CLASS) VALUES (1, 'BANK', 'Банки', 'org.plazmaforge.bsolution.bank.server.services.BankImporter', NULL);
INSERT INTO SYS_TRANSFER_SOURCE (ID, CODE, NAME, IMPORTER_CLASS, EXPORTER_CLASS) VALUES (2, 'GOODS', 'Номенклатура', 'org.plazmaforge.bsolution.goods.server.services.GoodsImporter', NULL);
INSERT INTO SYS_TRANSFER_SOURCE (ID, CODE, NAME, IMPORTER_CLASS, EXPORTER_CLASS) VALUES (3, 'GOODS_GROUP', 'Группы номенклатуры', 'org.plazmaforge.bsolution.goods.server.services.GoodsGroupImporter', NULL);



INSERT INTO SYS_TRANSFER_SOURCE_ATTR (ID, SOURCE_ID, CODE, NAME, SQL_TYPE, TYPE_SIZE, DECIMAL_DIGITS) VALUES (2, 1, 'BIC', 'МФО', 'VARCHAR', 20, 0);
INSERT INTO SYS_TRANSFER_SOURCE_ATTR (ID, SOURCE_ID, CODE, NAME, SQL_TYPE, TYPE_SIZE, DECIMAL_DIGITS) VALUES (3, 1, 'NAME', 'Название', 'VARCHAR', 50, 0);
INSERT INTO SYS_TRANSFER_SOURCE_ATTR (ID, SOURCE_ID, CODE, NAME, SQL_TYPE, TYPE_SIZE, DECIMAL_DIGITS) VALUES (4, 2, 'CODE', 'Код', 'VARCHAR', 20, 0);
INSERT INTO SYS_TRANSFER_SOURCE_ATTR (ID, SOURCE_ID, CODE, NAME, SQL_TYPE, TYPE_SIZE, DECIMAL_DIGITS) VALUES (5, 2, 'NAME', 'Название', 'VARCHAR', 100, 0);
INSERT INTO SYS_TRANSFER_SOURCE_ATTR (ID, SOURCE_ID, CODE, NAME, SQL_TYPE, TYPE_SIZE, DECIMAL_DIGITS) VALUES (6, 2, 'PRODUCT_GROUP_CODE', 'Код Группы', 'VARCHAR', 20, 0);
INSERT INTO SYS_TRANSFER_SOURCE_ATTR (ID, SOURCE_ID, CODE, NAME, SQL_TYPE, TYPE_SIZE, DECIMAL_DIGITS) VALUES (7, 2, 'PRODUCT_GROUP_NAME', 'Группа', 'VARCHAR', 50, 0);
INSERT INTO SYS_TRANSFER_SOURCE_ATTR (ID, SOURCE_ID, CODE, NAME, SQL_TYPE, TYPE_SIZE, DECIMAL_DIGITS) VALUES (8, 2, 'UNIT_NAME', 'Ед. измерения', 'VARCHAR', 20, 0);
INSERT INTO SYS_TRANSFER_SOURCE_ATTR (ID, SOURCE_ID, CODE, NAME, SQL_TYPE, TYPE_SIZE, DECIMAL_DIGITS) VALUES (9, 2, 'CURRENCY_CODE', 'Код валюты', 'VARCHAR', 3, 0);
INSERT INTO SYS_TRANSFER_SOURCE_ATTR (ID, SOURCE_ID, CODE, NAME, SQL_TYPE, TYPE_SIZE, DECIMAL_DIGITS) VALUES (10, 2, 'CURRENCY_PRICE', 'Цена', 'NUMERIC', 0, 0);
INSERT INTO SYS_TRANSFER_SOURCE_ATTR (ID, SOURCE_ID, CODE, NAME, SQL_TYPE, TYPE_SIZE, DECIMAL_DIGITS) VALUES (11, 3, 'CODE', 'Код', 'VARCHAR', 20, 0);
INSERT INTO SYS_TRANSFER_SOURCE_ATTR (ID, SOURCE_ID, CODE, NAME, SQL_TYPE, TYPE_SIZE, DECIMAL_DIGITS) VALUES (12, 3, 'NAME', 'Название', 'VARCHAR', 50, 0);


INSERT INTO ADDRESS_TYPE (ID, CODE, NAME) VALUES (1, 'BUSINESS', 'Рабочий');
INSERT INTO ADDRESS_TYPE (ID, CODE, NAME) VALUES (2, 'HOME', 'Домашний');
INSERT INTO ADDRESS_TYPE (ID, CODE, NAME) VALUES (3, 'OTHER', 'Другой');
INSERT INTO ADDRESS_TYPE (ID, CODE, NAME) VALUES (4, 'PRIMARY', 'Основной');
INSERT INTO ADDRESS_TYPE (ID, CODE, NAME) VALUES (5, 'REAL', 'Физический');
INSERT INTO ADDRESS_TYPE (ID, CODE, NAME) VALUES (6, 'POSTAL', 'Почтовый');

INSERT INTO APARTMENT_TYPE (ID, NAME, FULL_NAME) VALUES (1,'кв','квартира');
INSERT INTO APARTMENT_TYPE (ID, NAME, FULL_NAME) VALUES (2,'офис','офис');

INSERT INTO CONTACT_TYPE (ID, CODE, NAME) VALUES (1, 'CONTACT_PERSON', 'Контактное лицо');
INSERT INTO CONTACT_TYPE (ID, CODE, NAME) VALUES (2, 'EMPLOYEE', 'Сотрудник');
INSERT INTO CONTACT_TYPE (ID, CODE, NAME) VALUES (3, 'EXECUTIVE', 'Исполнитель');
INSERT INTO CONTACT_TYPE (ID, CODE, NAME) VALUES (4, 'PERSONAL_CONTACT', 'Личный контакт');

INSERT INTO LOCALITY_TYPE (ID, NAME, FULL_NAME) VALUES (1, 'г', 'город');
INSERT INTO LOCALITY_TYPE (ID, NAME, FULL_NAME) VALUES (2, 'пгт', 'посёлок');
INSERT INTO LOCALITY_TYPE (ID, NAME, FULL_NAME) VALUES (3, 'с', 'село');

INSERT INTO PHONE_TYPE (ID, CODE, NAME) VALUES (1, 'ASSISTANT', 'Помощник');
INSERT INTO PHONE_TYPE (ID, CODE, NAME) VALUES (2, 'BUSINESS', 'Рабочий');
INSERT INTO PHONE_TYPE (ID, CODE, NAME) VALUES (3, 'BUSINESS2', 'Рабочий 2');
INSERT INTO PHONE_TYPE (ID, CODE, NAME) VALUES (4, 'BUSINESS_FAX', 'Факс рабочий');
INSERT INTO PHONE_TYPE (ID, CODE, NAME) VALUES (5, 'CALLBACK', 'Ответ на звонок');
INSERT INTO PHONE_TYPE (ID, CODE, NAME) VALUES (6, 'CAR', 'Автомоб.');
INSERT INTO PHONE_TYPE (ID, CODE, NAME) VALUES (7, 'COMPANY', 'Организация');
INSERT INTO PHONE_TYPE (ID, CODE, NAME) VALUES (8, 'HOME', 'Домашний');
INSERT INTO PHONE_TYPE (ID, CODE, NAME) VALUES (9, 'HOME2', 'Домашний 2');
INSERT INTO PHONE_TYPE (ID, CODE, NAME) VALUES (10, 'HOME_FAX', 'Факс дом.');
INSERT INTO PHONE_TYPE (ID, CODE, NAME) VALUES (11, 'ISDN', 'Сеть ISDN');
INSERT INTO PHONE_TYPE (ID, CODE, NAME) VALUES (12, 'MOBILE', 'Мобильный');
INSERT INTO PHONE_TYPE (ID, CODE, NAME) VALUES (13, 'OTHER', 'Другой');
INSERT INTO PHONE_TYPE (ID, CODE, NAME) VALUES (14, 'OTHER_FAX', 'Факс дополн.');
INSERT INTO PHONE_TYPE (ID, CODE, NAME) VALUES (15, 'PAGER', 'Пейджер');
INSERT INTO PHONE_TYPE (ID, CODE, NAME) VALUES (16, 'PRIMARY', 'Основной');
INSERT INTO PHONE_TYPE (ID, CODE, NAME) VALUES (17, 'RADIO', 'Радио');
INSERT INTO PHONE_TYPE (ID, CODE, NAME) VALUES (18, 'TELEX', 'Телекс');
INSERT INTO PHONE_TYPE (ID, CODE, NAME) VALUES (19, 'TTY_TDD', 'TTY/TDD');



INSERT INTO STREET_TYPE (ID, NAME, FULL_NAME) VALUES (1,'ул','улица');
INSERT INTO STREET_TYPE (ID, NAME, FULL_NAME) VALUES (2,'пер','переулок');
INSERT INTO STREET_TYPE (ID, NAME, FULL_NAME) VALUES (3,'бульв','бульвар');
INSERT INTO STREET_TYPE (ID, NAME, FULL_NAME) VALUES (4,'пл','площадь');

/* ------------------------------------------------------------------------------------------------------------ */
/* GENERAL INITIALIZATION                                                                                       */
/* ------------------------------------------------------------------------------------------------------------ */

INSERT INTO SYS_ROLE (ID, NAME) VALUES (1, 'SUPERVISOR');
INSERT INTO SYS_USER (ID, USER_NAME, USER_PASSWORD, NAME, REG_DATE) VALUES (1, 'admin', '098f6bcd4621d373cade4e832627b4f6', 'Администратор', '2011-01-01');
INSERT INTO SYS_USER_ROLE (ID, USER_ID, ROLE_ID) VALUES (1, 1, 1);


INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (1,'ACADEMIC_DEGREE','ACADEMIC_DEGREE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (2,'ACTIVITY_TYPE','ACTIVITY_TYPE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (3,'ADDRESS_TYPE','ADDRESS_TYPE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (4,'APARTMENT_TYPE','APARTMENT_TYPE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (5,'BANK','BANK','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (6,'CASH_INCOME','CASH_INCOME','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (7,'CASH_OUTCOME','CASH_OUTCOME','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (8,'CITY','CITY','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (9,'CONTACT','CONTACT','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (10,'CONTACT_TYPE','CONTACT_TYPE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (11,'CONTRACT','CONTRACT','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (12,'CONTRACTOR','CONTRACTOR','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (13,'COUNTRY','COUNTRY','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (14,'CURRENCY','CURRENCY','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (15,'DEPARTMENT','DEPARTMENT','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (16,'DISCHARGE_TYPE','DISCHARGE_TYPE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (17,'DISTRICT','DISTRICT','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (18,'DOCUMENT_TYPE','DOCUMENT_TYPE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (19,'EDUCATION_FORM','EDUCATION_FORM','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (20,'EDUCATION_INSTITUTE','EDUCATION_INSTITUTE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (21,'EDUCATION_TYPE','EDUCATION_TYPE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (22,'EMPLOYEE','EMPLOYEE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (23,'EMPLOYEE_CATEGORY','EMPLOYEE_CATEGORY','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (24,'EMPLOYEE_DISCHARGE','EMPLOYEE_DISCHARGE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (25,'EMPLOYEE_VACATION','EMPLOYEE_VACATION','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (26,'EMPLOYEE_RANK','EMPLOYEE_RANK','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (27,'EMPLOYEE_RECEPTION','EMPLOYEE_RECEPTION','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (28,'EMPLOYEE_SICKLIST','EMPLOYEE_SICKLIST','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (29,'SALE_SERV','SALE_SERV','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (30,'FAMILIARITY','FAMILIARITY','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (31,'FAMILY_STATUS','FAMILY_STATUS','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (32,'FINANCE_DOCUMENT_TYPE','FINANCE_DOCUMENT_TYPE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (33,'FORM_PROPERTY','FORM_PROPERTY','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (34,'GOODS','GOODS','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (35,'GOODS_INCOME','GOODS_INCOME','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (36,'INVENTORY_MOVE','INVENTORY_MOVE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (37,'GOODS_OUTCOME','GOODS_OUTCOME','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (38,'INVENTORY_REST','INVENTORY_REST','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (39,'GOODS_TYPE','GOODS_TYPE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (40,'INVENTORY_WRITEOFF','INVENTORY_WRITEOFF','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (41,'INDUSTRY','INDUSTRY','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (42,'SALE_INVOICE','SALE_INVOICE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (43,'LANGUAGE','LANGUAGE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (44,'VACATION_AVERANGE_TYPE','VACATION_AVERANGE_TYPE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (45,'VACATION_CALCULATE','VACATION_CALCULATE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (46,'VACATION_TYPE','VACATION_TYPE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (47,'LEDGER_ACCOUNT','LEDGER_ACCOUNT','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (48,'LEDGER_ACCOUNT_REST','LEDGER_ACCOUNT_REST','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (49,'LEDGER_ACCOUNT_TYPE','LEDGER_ACCOUNT_TYPE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (50,'LOCALITY','LOCALITY','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (51,'LOCALITY_TYPE','LOCALITY_TYPE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (52,'MILITARY_RANK','MILITARY_RANK','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (53,'MILITARY_SPECIALITY','MILITARY_SPECIALITY','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (54,'MILITARY_STATUS','MILITARY_STATUS','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (55,'ORGANIZATION','ORGANIZATION','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (56,'PARTNER','PARTNER','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (57,'PARTNER_CATEGORY','PARTNER_CATEGORY','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (58,'PARTNER_GROUP','PARTNER_GROUP','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (59,'PARTNER_REST','PARTNER_REST','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (60,'PAYMENT_INCOME','PAYMENT_INCOME','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (61,'PAYMENT_OUTCOME','PAYMENT_OUTCOME','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (62,'PAYMENT_TYPE','PAYMENT_TYPE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (63,'PAYROLL','PAYROLL','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (64,'PAYROLL_ALGORITM','PAYROLL_ALGORITM','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (65,'PAYROLL_ALGORITM_TYPE','PAYROLL_ALGORITM_TYPE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (66,'PAYROLL_FORM','PAYROLL_FORM','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (67,'PAYROLL_GROUP','PAYROLL_GROUP','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (68,'PAYROLL_MODE','PAYROLL_MODE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (69,'PAYROLL_TYPE','PAYROLL_TYPE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (70,'PERIOD','PERIOD','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (71,'PERIOD_TYPE','PERIOD_TYPE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (72,'PERSON','PERSON','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (73,'PERSON_DOCUMENT_TYPE','PERSON_DOCUMENT_TYPE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (74,'PHONE_TYPE','PHONE_TYPE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (75,'JOB_POSITION','JOB_POSITION','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (76,'PRICE_TYPE','PRICE_TYPE','ENTITY');

INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (80,'PRODUCT_GROUP','PRODUCT_GROUP','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (81,'PRODUCT_SECTION','PRODUCT_SECTION','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (82,'PROJECT','PROJECT','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (83,'PROJECT_ROLE','PROJECT_ROLE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (84,'PROJECT_STAGE','PROJECT_STAGE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (85,'PROJECT_STAGE_GROUP','PROJECT_STAGE_GROUP','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (86,'PROJECT_STATUS','PROJECT_STATUS','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (87,'PROJECT_TYPE','PROJECT_TYPE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (88,'PURCHASE_ORDER','PURCHASE_ORDER','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (89,'PURCHASE_PLAN','PURCHASE_PLAN','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (90,'REGION','REGION','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (91,'RESPONSIBLE','RESPONSIBLE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (92,'SALE_ORDER','SALE_ORDER','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (93,'SALE_PLAN','SALE_PLAN','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (94,'SICKLIST_AVERANGE_TYPE','SICKLIST_AVERANGE_TYPE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (95,'SICKLIST_TYPE','SICKLIST_TYPE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (96,'SICK_TYPE','SICK_TYPE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (97,'SPECIALITY','SPECIALITY','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (98,'WAREHOUSE','WAREHOUSE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (99,'STORE','STORE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (100,'STREET_TYPE','STREET_TYPE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (101,'SYS_ROLE','SYS_ROLE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (102,'SYS_USER','SYS_USER','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (103,'SYS_VARIABLE','SYS_VARIABLE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (104,'TASK','TASK','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (105,'TASK_PRIORITY','TASK_PRIORITY','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (106,'TASK_RESULT','TASK_RESULT','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (107,'TASK_ROLE','TASK_ROLE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (108,'TASK_STATUS','TASK_STATUS','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (109,'TASK_TYPE','TASK_TYPE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (110,'TAX','TAX','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (111,'TAXPRINT_TYPE','TAXPRINT_TYPE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (112,'SALE_TAX_WAYBILL','SALE_TAX_WAYBILL','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (113,'TEMPLATE_ENTRY','TEMPLATE_ENTRY','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (114,'UNIT','UNIT','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (115,'DOCUMENT','DOCUMENT','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (116,'PURCHASE_INVOICE','PURCHASE_INVOICE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (117,'PURCHASE_SERV','PURCHASE_SERV','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (118,'PURCHASE_TAX_WAYBILL','PURCHASE_TAX_WAYBILL','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (119,'INVENTORY_INCOME','INVENTORY_INCOME','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (120,'INVENTORY_OUTCOME','INVENTORY_OUTCOME','ENTITY');

INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (121,'DOCUMENT_STATUS','DOCUMENT_STATUS','ENTITY');

INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (130,'PIM_APPOINTMENT_PRIORITY','PIM_APPOINTMENT_PRIORITY','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (131,'PIM_APPOINTMENT_TYPE','PIM_APPOINTMENT_TYPE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (132,'PIM_APPOINTMENT','PIM_APPOINTMENT','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (133,'PIM_EVENT','PIM_EVENT','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (134,'PIM_NOTE','PIM_NOTE','ENTITY');
INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, OBJECT_TYPE) VALUES (135,'PIM_REMINDER','PIM_REMINDER','ENTITY');



INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (1,1,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (2,2,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (3,3,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (4,4,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (5,5,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (6,6,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (7,7,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (8,8,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (9,9,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (10,10,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (11,11,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (12,12,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (13,13,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (14,14,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (15,15,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (16,16,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (17,17,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (18,18,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (19,19,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (20,20,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (21,21,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (22,22,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (23,23,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (24,24,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (25,25,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (26,26,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (27,27,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (28,28,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (29,29,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (30,30,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (31,31,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (32,32,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (33,33,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (34,34,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (35,35,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (36,36,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (37,37,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (38,38,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (39,39,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (40,40,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (41,41,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (42,42,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (43,43,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (44,44,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (45,45,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (46,46,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (47,47,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (48,48,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (49,49,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (50,50,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (51,51,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (52,52,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (53,53,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (54,54,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (55,55,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (56,56,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (57,57,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (58,58,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (59,59,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (60,60,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (61,61,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (62,62,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (63,63,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (64,64,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (65,65,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (66,66,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (67,67,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (68,68,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (69,69,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (70,70,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (71,71,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (72,72,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (73,73,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (74,74,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (75,75,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (76,76,1,'Y','Y','N','N','N');

INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (80,80,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (81,81,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (82,82,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (83,83,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (84,84,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (85,85,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (86,86,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (87,87,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (88,88,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (89,89,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (90,90,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (91,91,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (92,92,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (93,93,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (94,94,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (95,95,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (96,96,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (97,97,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (98,98,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (99,99,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (100,100,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (101,101,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (102,102,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (103,103,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (104,104,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (105,105,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (106,106,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (107,107,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (108,108,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (109,109,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (110,110,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (111,111,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (112,112,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (113,113,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (114,114,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (115,115,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (116,116,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (117,117,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (118,118,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (119,119,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (120,120,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (121,121,1,'Y','Y','N','N','N');

INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (130,130,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (131,131,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (132,132,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (133,133,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (134,134,1,'Y','Y','N','N','N');
INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE, IS_EXEC, IS_TYPE_READ, IS_TYPE_WRITE) VALUES (135,135,1,'Y','Y','N','N','N');


/* BUSINESSABLE ENTITITES:      */
/* -----------------------------*/
/* DEPARTMENT                   */ 
/* STORE                        */
/* RESPONSIBLE                  */
/* PARTNER                      */
/* BANK                         */
/* GOODS                        */ 
/* EMPLOYEE                     */
/* PERSON                       */

INSERT INTO BUSINESSABLE_ENTITY (ID, ENTITY_ID) VALUES (1, 'DEPARTMENT');
INSERT INTO BUSINESSABLE_ENTITY (ID, ENTITY_ID) VALUES (2, 'STORE');
INSERT INTO BUSINESSABLE_ENTITY (ID, ENTITY_ID) VALUES (9, 'MTRL_RESPONSIBLE');
INSERT INTO BUSINESSABLE_ENTITY (ID, ENTITY_ID) VALUES (10, 'PARTNER');
INSERT INTO BUSINESSABLE_ENTITY (ID, ENTITY_ID) VALUES (11, 'BANK');
INSERT INTO BUSINESSABLE_ENTITY (ID, ENTITY_ID) VALUES (12, 'GOODS');
INSERT INTO BUSINESSABLE_ENTITY (ID, ENTITY_ID) VALUES (13, 'EMPLOYEE');
INSERT INTO BUSINESSABLE_ENTITY (ID, ENTITY_ID) VALUES (14, 'PERSON');



/* STORE                */

INSERT INTO WAREHOUSE_ENTITY (ID, ENTITY_ID) VALUES (1, 'STORE');




/* PARTNER              */
/* PERSON               */
/* EMPLOYEE             */
/* BANK                 */

INSERT INTO CONTACTABLE_ENTITY (ID, ENTITY_ID) VALUES (1, 'PARTNER');
INSERT INTO CONTACTABLE_ENTITY (ID, ENTITY_ID) VALUES (2, 'PERSON');
INSERT INTO CONTACTABLE_ENTITY (ID, ENTITY_ID) VALUES (3, 'EMPLOYEE');
INSERT INTO CONTACTABLE_ENTITY (ID, ENTITY_ID) VALUES (4, 'BANK');



/* ------------------------------------------------------------------------------------------------------------ */
/* DICTIONARY INITIALIZATION                                                                                    */
/* ------------------------------------------------------------------------------------------------------------ */

/*
'GOODS_REST'
'GOODS_INCOME'
'GOODS_OUTCOME'
'GOODS_MOVE'
'GOODS_WRITEOFF'
'PAYMENT_INCOME'
'PAYMENT_OUTCOME'
'EMPLOYEE_RECEPTION'
'EMPLOYEE_DISCHARGE'
'EMPLOYEE_VACATION'
'EMPLOYEE_SICKLIST'
'SALE_INVOICE'
'CONTRACT'
*/


INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (1, 'INVENTORY_REST','INVENTORY', NULL);
INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (2, 'GOODS_INCOME','GOODS', 'PURCHASE');
INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (3, 'GOODS_OUTCOME','GOODS', 'SALE');
INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (4, 'INVENTORY_MOVE','INVENTORY', NULL);
INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (5, 'INVENTORY_WRITEOFF','INVENTORY', NULL);
INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (6, 'PAYMENT_INCOME','PAYMENT', NULL);
INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (7, 'PAYMENT_OUTCOME','PAYMENT', 'PAYMENT');
INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (8, 'EMPLOYEE_RECEPTION','HR', NULL);
INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (9, 'EMPLOYEE_DISCHARGE','HR', NULL);
INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (10, 'EMPLOYEE_VACATION','HR', NULL);
INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (11, 'EMPLOYEE_SICKLIST','HR', NULL);
INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (12, 'SALE_INVOICE','GOODS', NULL);
INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (13, 'CONTRACT','DOCUMENT', NULL);
INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (14, 'SALE_ORDER','GOODS', NULL);
INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (15, 'PURCHASE_ORDER','GOODS', NULL);
INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (16, 'SALE_TAX_WAYBILL','GOODS', NULL);
INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (17, 'SALE_PLAN','GOODS', NULL);
INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (18, 'PURCHASE_PLAN','GOODS', NULL);
INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (19, 'SALE_SERV','GOODS', NULL);
INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (20, 'CASH_INCOME','CASH', NULL);
INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (21, 'CASH_OUTCOME','CASH', NULL);
INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (22, 'PURCHASE_INVOICE','GOODS', NULL);
INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (23, 'PURCHASE_SERV','GOODS', NULL);
INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (24, 'PURCHASE_TAX_WAYBILL','GOODS', NULL);
INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (25, 'INVENTORY_INCOME','INVENTORY', 'PURCHASE');
INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (26, 'INVENTORY_OUTCOME','INVENTORY', 'SALE');


INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (1000, '<SYS_ROW>','<SYS_ROW>', NULL);


INSERT INTO FINANCE_DOCUMENT_TYPE (ID, DOCUMENT_TYPE_ID, MOVE_TYPE, IS_INCLUDE_TAX_IN_AMOUNT) VALUES (1, 1, 'REST', 'N');
INSERT INTO FINANCE_DOCUMENT_TYPE (ID, DOCUMENT_TYPE_ID, MOVE_TYPE, IS_INCLUDE_TAX_IN_AMOUNT) VALUES (2, 2, 'INPUT', 'N');
INSERT INTO FINANCE_DOCUMENT_TYPE (ID, DOCUMENT_TYPE_ID, MOVE_TYPE, IS_INCLUDE_TAX_IN_AMOUNT) VALUES (3, 3, 'OUTPUT', 'N');
INSERT INTO FINANCE_DOCUMENT_TYPE (ID, DOCUMENT_TYPE_ID, MOVE_TYPE, IS_INCLUDE_TAX_IN_AMOUNT) VALUES (4, 4, 'ROTATE', 'N');
INSERT INTO FINANCE_DOCUMENT_TYPE (ID, DOCUMENT_TYPE_ID, MOVE_TYPE, IS_INCLUDE_TAX_IN_AMOUNT) VALUES (5, 5, 'OUTPUT', 'N');
INSERT INTO FINANCE_DOCUMENT_TYPE (ID, DOCUMENT_TYPE_ID, MOVE_TYPE, IS_INCLUDE_TAX_IN_AMOUNT) VALUES (6, 6, 'INPUT', 'Y');
INSERT INTO FINANCE_DOCUMENT_TYPE (ID, DOCUMENT_TYPE_ID, MOVE_TYPE, IS_INCLUDE_TAX_IN_AMOUNT) VALUES (7, 7, 'OUTPUT', 'Y');
INSERT INTO FINANCE_DOCUMENT_TYPE (ID, DOCUMENT_TYPE_ID, MOVE_TYPE, IS_INCLUDE_TAX_IN_AMOUNT) VALUES (8, 12, 'NONE', 'Y');
INSERT INTO FINANCE_DOCUMENT_TYPE (ID, DOCUMENT_TYPE_ID, MOVE_TYPE, IS_INCLUDE_TAX_IN_AMOUNT) VALUES (9, 13, 'NONE', 'Y');
INSERT INTO FINANCE_DOCUMENT_TYPE (ID, DOCUMENT_TYPE_ID, MOVE_TYPE, IS_INCLUDE_TAX_IN_AMOUNT) VALUES (10, 14, 'ORDER_OUTPUT', 'Y');
INSERT INTO FINANCE_DOCUMENT_TYPE (ID, DOCUMENT_TYPE_ID, MOVE_TYPE, IS_INCLUDE_TAX_IN_AMOUNT) VALUES (11, 15, 'ORDER_INPUT', 'Y');
INSERT INTO FINANCE_DOCUMENT_TYPE (ID, DOCUMENT_TYPE_ID, MOVE_TYPE, IS_INCLUDE_TAX_IN_AMOUNT) VALUES (12, 16, 'NONE', 'Y');
INSERT INTO FINANCE_DOCUMENT_TYPE (ID, DOCUMENT_TYPE_ID, MOVE_TYPE, IS_INCLUDE_TAX_IN_AMOUNT) VALUES (13, 17, 'NONE', 'Y');
INSERT INTO FINANCE_DOCUMENT_TYPE (ID, DOCUMENT_TYPE_ID, MOVE_TYPE, IS_INCLUDE_TAX_IN_AMOUNT) VALUES (14, 18, 'NONE', 'Y');
INSERT INTO FINANCE_DOCUMENT_TYPE (ID, DOCUMENT_TYPE_ID, MOVE_TYPE, IS_INCLUDE_TAX_IN_AMOUNT) VALUES (15, 19, 'OUTPUT', 'Y');
INSERT INTO FINANCE_DOCUMENT_TYPE (ID, DOCUMENT_TYPE_ID, MOVE_TYPE, IS_INCLUDE_TAX_IN_AMOUNT) VALUES (16, 20, 'INPUT', 'Y');
INSERT INTO FINANCE_DOCUMENT_TYPE (ID, DOCUMENT_TYPE_ID, MOVE_TYPE, IS_INCLUDE_TAX_IN_AMOUNT) VALUES (17, 21, 'OUTPUT', 'Y');
INSERT INTO FINANCE_DOCUMENT_TYPE (ID, DOCUMENT_TYPE_ID, MOVE_TYPE, IS_INCLUDE_TAX_IN_AMOUNT) VALUES (18, 22, 'NONE', 'Y');
INSERT INTO FINANCE_DOCUMENT_TYPE (ID, DOCUMENT_TYPE_ID, MOVE_TYPE, IS_INCLUDE_TAX_IN_AMOUNT) VALUES (19, 23, 'OUTPUT', 'Y');
INSERT INTO FINANCE_DOCUMENT_TYPE (ID, DOCUMENT_TYPE_ID, MOVE_TYPE, IS_INCLUDE_TAX_IN_AMOUNT) VALUES (20, 24, 'NONE', 'Y');
INSERT INTO FINANCE_DOCUMENT_TYPE (ID, DOCUMENT_TYPE_ID, MOVE_TYPE, IS_INCLUDE_TAX_IN_AMOUNT) VALUES (21, 25, 'INPUT', 'N');
INSERT INTO FINANCE_DOCUMENT_TYPE (ID, DOCUMENT_TYPE_ID, MOVE_TYPE, IS_INCLUDE_TAX_IN_AMOUNT) VALUES (22, 26, 'OUTPUT', 'N');


INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (101, 1, 'CREATED', 'Создан', 'Y', 'N', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (201, 2, 'CREATED', 'Создан', 'Y', 'N', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (301, 3, 'CREATED', 'Создан', 'Y', 'N', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (401, 4, 'CREATED', 'Создан', 'Y', 'N', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (501, 5, 'CREATED', 'Создан', 'Y', 'N', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (601, 6, 'CREATED', 'Создан', 'Y', 'N', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (701, 7, 'CREATED', 'Создан', 'Y', 'N', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (801, 8, 'CREATED', 'Создан', 'Y', 'N', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (901, 9, 'CREATED', 'Создан', 'Y', 'N', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (1001, 10, 'CREATED', 'Создан', 'Y', 'N', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (1101, 11, 'CREATED', 'Создан', 'Y', 'N', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (1201, 12, 'CREATED', 'Создан', 'Y', 'N', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (1301, 13, 'CREATED', 'Создан', 'Y', 'N', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (1401, 14, 'CREATED', 'Создан', 'Y', 'N', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (1501, 15, 'CREATED', 'Создан', 'Y', 'N', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (1601, 16, 'CREATED', 'Создан', 'Y', 'N', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (1701, 17, 'CREATED', 'Создан', 'Y', 'N', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (1801, 18, 'CREATED', 'Создан', 'Y', 'N', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (1901, 19, 'CREATED', 'Создан', 'Y', 'N', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (2001, 20, 'CREATED', 'Создан', 'Y', 'N', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (2101, 21, 'CREATED', 'Создан', 'Y', 'N', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (2201, 22, 'CREATED', 'Создан', 'Y', 'N', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (2301, 23, 'CREATED', 'Создан', 'Y', 'N', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (2401, 24, 'CREATED', 'Создан', 'Y', 'N', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (2501, 25, 'CREATED', 'Создан', 'Y', 'N', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (2601, 26, 'CREATED', 'Создан', 'Y', 'N', 'Y');


INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (1202, 12, 'PAID', 'Оплачен', 'N', 'N', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (1402, 14, 'PAID', 'Оплачен', 'N', 'N', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (1502, 15, 'PAID', 'Оплачен', 'N', 'N', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (2202, 22, 'PAID', 'Оплачен', 'N', 'N', 'Y');

INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (1203, 12, 'CALCELED', 'Отменён', 'N', 'Y', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (1403, 14, 'CALCELED', 'Отменён', 'N', 'Y', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (1503, 15, 'CALCELED', 'Отменён', 'N', 'Y', 'Y');
INSERT INTO DOCUMENT_STATUS (ID, DOCUMENT_TYPE_ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (2203, 22, 'CALCELED', 'Отменён', 'N', 'Y', 'Y');



/* SALE_ORDER */
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (1, 14, 12,'org.plazmaforge.bsolution.product.common.ProductDocumentCreator');
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (2, 14, 6, 'org.plazmaforge.bsolution.bank.common.PaymentDocumentCreator');	
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (3, 14, 3, 'org.plazmaforge.bsolution.product.common.WarehouseProductDocumentCreator');
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (4, 14, 16,'org.plazmaforge.bsolution.product.common.ProductDocumentCreator');	
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (5, 14, 13,'org.plazmaforge.bsolution.finance.common.FinanceDocumentCreator');	
	
/* SALE_INVOICE */
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (10, 12, 3, 'org.plazmaforge.bsolution.product.common.OutcomeWarehouseProductDocumentCreator');
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (11, 12, 16,'org.plazmaforge.bsolution.product.common.ProductDocumentCreator');
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (12, 12, 6, 'org.plazmaforge.bsolution.bank.common.PaymentDocumentCreator');
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (13, 12, 13,'org.plazmaforge.bsolution.finance.common.FinanceDocumentCreator');	
	
/* PURCHASE_ORDER */
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (20, 15, 22,'org.plazmaforge.bsolution.product.common.ProductDocumentCreator');
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (21, 15, 7, 'org.plazmaforge.bsolution.bank.common.PaymentDocumentCreator');	
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (22, 15, 2, 'org.plazmaforge.bsolution.product.common.WarehouseProductDocumentCreator');
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (23, 15, 24,'org.plazmaforge.bsolution.product.common.ProductDocumentCreator');	
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (24, 15, 13,'org.plazmaforge.bsolution.finance.common.FinanceDocumentCreator');	
	
/* PURCHASE_INVOICE */
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (30, 22, 2, 'org.plazmaforge.bsolution.product.common.IncomeWarehouseProductDocumentCreator');
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (31, 22, 24,'org.plazmaforge.bsolution.product.common.ProductDocumentCreator');
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (32, 22, 7, 'org.plazmaforge.bsolution.bank.common.PaymentDocumentCreator');
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (33, 22, 13,'org.plazmaforge.bsolution.finance.common.FinanceDocumentCreator');	

/* CONTRACT */
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (40, 13, 14, 'org.plazmaforge.bsolution.finance.common.FinanceDocumentCreator');	
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (41, 13, 12, 'org.plazmaforge.bsolution.finance.common.FinanceDocumentCreator');	
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (42, 13, 15, 'org.plazmaforge.bsolution.finance.common.FinanceDocumentCreator');	
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (43, 13, 22, 'org.plazmaforge.bsolution.finance.common.FinanceDocumentCreator');	


INSERT INTO PERIOD_TYPE (ID, CODE, NAME) VALUES (1, 'MONTH', 'Месяц');
INSERT INTO PERIOD_TYPE (ID, CODE, NAME) VALUES (2, 'QUARTER', 'Квартал');
INSERT INTO PERIOD_TYPE (ID, CODE, NAME) VALUES (3, 'YEAR', 'Год');
INSERT INTO PERIOD_TYPE (ID, CODE, NAME) VALUES (100, 'CUSTOM', 'Произвольный');



INSERT INTO UNIT (ID, CODE, NAME, FULL_NAME) VALUES (1, '001', 'шт', 'штука');
INSERT INTO UNIT (ID, CODE, NAME, FULL_NAME) VALUES (2, '002', 'кг', 'килограмм');
INSERT INTO UNIT (ID, CODE, NAME, FULL_NAME) VALUES (3, '003', 'м', 'метр');
INSERT INTO UNIT (ID, CODE, NAME, FULL_NAME) VALUES (4, '004', 'м2', 'метр квадратный');







/* ------------------------------------------------------------------------------------------------------------ */
/* CONTACT INITIALIZATION                                                                                       */
/* ------------------------------------------------------------------------------------------------------------ */



/* ------------------------------------------------------------------------------------------------------------ */
/* PRODUCT INITIALIZATION                                                                                       */
/* ------------------------------------------------------------------------------------------------------------ */


INSERT INTO PRODUCT_SECTION (ID, CODE, NAME) VALUES (1,'GOODS','Номенклатура');
INSERT INTO PRODUCT_SECTION (ID, CODE, NAME) VALUES (2,'ASSET','Основные средства');
INSERT INTO PRODUCT_SECTION (ID, CODE, NAME) VALUES (3,'INTANGIBLE','Нематериальные активы');


INSERT INTO GOODS_TYPE (ID, CODE, NAME) VALUES (1, 'GOODS', 'Товар');
INSERT INTO GOODS_TYPE (ID, CODE, NAME) VALUES (2, 'SERVICE', 'Услуга');
INSERT INTO GOODS_TYPE (ID, CODE, NAME) VALUES (3, 'SET', 'Набор');
INSERT INTO GOODS_TYPE (ID, CODE, NAME) VALUES (4, 'PRODUCT', 'Продукция');
INSERT INTO GOODS_TYPE (ID, CODE, NAME) VALUES (5, 'WORK', 'Работа');

INSERT INTO FORM_PROPERTY (ID, NAME) VALUES (1,'ООО');
INSERT INTO FORM_PROPERTY (ID, NAME) VALUES (2,'ЗАО');
INSERT INTO FORM_PROPERTY (ID, NAME) VALUES (3,'АО');

INSERT INTO PRICE_TYPE (ID, NAME, PRICE_PERCENT) VALUES (1,'Базовая', 0);
INSERT INTO PRICE_TYPE (ID, NAME, PRICE_PERCENT) VALUES (2,'Оптовая', 0);
INSERT INTO PRICE_TYPE (ID, NAME, PRICE_PERCENT) VALUES (3,'Розничная', 0);
INSERT INTO PRICE_TYPE (ID, NAME, PRICE_PERCENT) VALUES (4,'Закупочная', 0);

INSERT INTO TAX (ID, CODE, NAME, TAX_PERCENT, AMOUNT) VALUES (1, 'НДС', 'НДС', 20.0, 0.0);

INSERT INTO LEDGER_ACCOUNT_TYPE (ID, CODE, NAME) VALUES (1, 'А', 'Активный');
INSERT INTO LEDGER_ACCOUNT_TYPE (ID, CODE, NAME) VALUES (2, 'П', 'Пассивный');
INSERT INTO LEDGER_ACCOUNT_TYPE (ID, CODE, NAME) VALUES (3, 'АП', 'Активно-пассивный');

INSERT INTO PARTNER_TYPE (ID, NAME) VALUES (1, 'Юридическое лицо');
INSERT INTO PARTNER_TYPE (ID, NAME) VALUES (2, 'Физическое лицо');

/* ------------------------------------------------------------------------------------------------------------ */
/* CONTEXT INITIALIZATION                                                                                       */
/* ------------------------------------------------------------------------------------------------------------ */


/* BSS = 1 */
INSERT INTO PARTNER (ID, CODE, NAME) VALUES (1, '111', 'Моя компания');
INSERT INTO BUSINESSABLE (ID, OWNER_ID, ENTITY_ID) VALUES (1, 1, 'PARTNER');
INSERT INTO CONTACTABLE (ID, OWNER_ID, ENTITY_ID) VALUES (1, 1, 'PARTNER');

INSERT INTO CONTRACTOR (ID) VALUES (1);

INSERT INTO ORGANIZATION (ID) VALUES (1);

INSERT INTO PERIOD (ID, PERIOD_TYPE_ID, START_DATE, END_DATE, NAME) VALUES (1, 1, '2011-01-01', '2011-03-31', '01 января 2011 - 31 марта 2011');

INSERT INTO SYS_INFO (ID, ORGANIZATION_ID, IS_INIT, APP_VERSION, DB_VERSION, APP_BUILD, DB_BUILD) VALUES (1, 1, 'N', '1.0.2', '1.0.2', '20120717', '20120717');
INSERT INTO SYS_PREFERENCE (ID) VALUES (1);
INSERT INTO ENTERPRISE_CONTEXT (ID, CURRENCY_ID, PERIOD_ID, UNIT_ID) VALUES (1, 1, 1, 1);


/* BSS = 2 FIRST CONTACT */

INSERT INTO CONTACT (ID, ORGANIZATION_ID, CONTACT_TYPE_ID, LAST_NAME, FIRST_NAME, MIDDLE_NAME, NAME, GENDER) VALUES (2, 1, 1, 'Администратор', NULL, NULL, 'Администратор', 1);
INSERT INTO CONTACTABLE (ID, OWNER_ID, ENTITY_ID) VALUES (2, 2, 'CONTACT');
UPDATE SYS_USER SET CONTACT_ID = 2;



INSERT INTO CONTACT_CONTEXT (ID, RESPONSIBLE_ID, CONTACT_TYPE_ID, ADDRESS_TYPE_ID, PHONE_TYPE_ID) VALUES (1, NULL, 1, 4, 16);
INSERT INTO BANK_CONTEXT (ID) VALUES (1);
INSERT INTO PROJECT_CONTEXT (ID) VALUES (1);
INSERT INTO TASK_CONTEXT (ID) VALUES (1);

INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (1, '1', 'Директор');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (2, '2', 'Главный бухгалтер');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (3, '3', 'Нач.отдела кадров');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (4, '4', 'Расчетчик');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (5, '5', 'Инспектор по кадрам');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (6, '6', 'Инженер');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (7, '7', 'Ведущий эксперт');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (8, '8', 'Ведущий инженер');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (9, '9', 'Кассир');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (10, '10', 'Водитель');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (11, '11', 'Бухгалтер');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (12, '12', 'Главный инженер');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (13, '13', 'Зам.директора по кадрам');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (14, '14', 'Директор администратор');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (15, '15', 'Секретарь');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (16, '16', 'Зам.Главного бухгалтера');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (17, '17', 'Инженер-конструктор');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (18, '18', 'Повар');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (19, '19', 'Охранник');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (20, '20', 'Финансовый директор');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (21, '21', 'Токарь');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (22, '22', 'Слесарь');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (23, '23', 'Медсестра');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (24, '24', 'Экономист');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (25, '25', 'Техник');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (26, '26', 'Инженер-программист');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (27, '27', 'Редактор');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (28, '28', 'Эксперт');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (29, '29', 'Технический директор');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (30, '30', 'Фельдшер');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (31, '31', 'Испытатель');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (32, '32', 'Слесарь');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (33, '33', 'Комплектовщица');
INSERT INTO JOB_POSITION (ID, CODE, NAME) VALUES (34, '34', 'Продавец');

INSERT INTO DISCHARGE_TYPE (ID, CODE, NAME) VALUES (1, NULL, 'Перевод, ст. 29 КЗОТ, п.5');
INSERT INTO DISCHARGE_TYPE (ID, CODE, NAME) VALUES (2, NULL, 'По собственному желанию, ст. 31 КЗОТ');
INSERT INTO DISCHARGE_TYPE (ID, CODE, NAME) VALUES (3, NULL, 'По сокращению штатов, ст. 33 КЗОТ, п.1');
INSERT INTO DISCHARGE_TYPE (ID, CODE, NAME) VALUES (4, NULL, 'Уход на пенсию, ст. 31 КЗОТ');
INSERT INTO DISCHARGE_TYPE (ID, CODE, NAME) VALUES (5, NULL, 'Учеба на дневном отделении, ст. 31 КЗОТ');
INSERT INTO DISCHARGE_TYPE (ID, CODE, NAME) VALUES (6, NULL, 'Уход на службу в армию, ст. 29 КЗОТ, п.3');
INSERT INTO DISCHARGE_TYPE (ID, CODE, NAME) VALUES (7, NULL, 'Уход на инвалидность, ст. 32 КЗОТ');
INSERT INTO DISCHARGE_TYPE (ID, CODE, NAME) VALUES (8, NULL, 'По уходу за детьми до 14 лет, ст. 32 КЗОТ');
INSERT INTO DISCHARGE_TYPE (ID, CODE, NAME) VALUES (9, NULL, 'По уходу за инвалидом, ст. 32 КЗОТ');
INSERT INTO DISCHARGE_TYPE (ID, CODE, NAME) VALUES (10, NULL, 'Несоответствие работника занимаемой должности, ст. 33 КЗОТ, п.2');
INSERT INTO DISCHARGE_TYPE (ID, CODE, NAME) VALUES (11, NULL, 'Систематическое неисполнение работником служебных обязанностей, ст.33 КЗОТ, п.3');
INSERT INTO DISCHARGE_TYPE (ID, CODE, NAME) VALUES (12, NULL, 'За прогулы, ст. 33 КЗОТ, п.4');
INSERT INTO DISCHARGE_TYPE (ID, CODE, NAME) VALUES (13, NULL, 'Появление на работе в нетрезвом состоянии, ст. 33 КЗОТ, п.7');
INSERT INTO DISCHARGE_TYPE (ID, CODE, NAME) VALUES (14, NULL, 'Совершение по месту работы хищения, ст. 33 КЗОТ, п.8');
INSERT INTO DISCHARGE_TYPE (ID, CODE, NAME) VALUES (15, NULL, 'По требованию профсоюзного органа, ст. 37 КЗОТ');
INSERT INTO DISCHARGE_TYPE (ID, CODE, NAME) VALUES (16, NULL, 'Окончание срока работ, ст. 29 КЗОТ, п.2');
INSERT INTO DISCHARGE_TYPE (ID, CODE, NAME) VALUES (17, NULL, 'В связи со смертью');
INSERT INTO DISCHARGE_TYPE (ID, CODE, NAME) VALUES (18, NULL, 'Неудовлетворительный результат по истечении испытательного срока, ст. 23 КЗОТ');
INSERT INTO DISCHARGE_TYPE (ID, CODE, NAME) VALUES (19, NULL, 'Прекращение трудового договора (контракта) по соглашению сторон, ст. 29 КЗОТ, п.1');
INSERT INTO DISCHARGE_TYPE (ID, CODE, NAME) VALUES (20, NULL, 'Для исчисляемых стажей');

INSERT INTO EMPLOYEE_CATEGORY (ID, NAME) VALUES (1, 'Руководящий состав');
INSERT INTO EMPLOYEE_CATEGORY (ID, NAME) VALUES (2, 'Сотрудники управления');
INSERT INTO EMPLOYEE_CATEGORY (ID, NAME) VALUES (3, 'Служащие');
INSERT INTO EMPLOYEE_CATEGORY (ID, NAME) VALUES (4, 'Рабочие');
INSERT INTO EMPLOYEE_CATEGORY (ID, NAME) VALUES (5, 'Всп.рабочие');

INSERT INTO EMPLOYEE_RANK (ID, NAME, TARIFF) VALUES (1, '1 разряд', 0);
INSERT INTO EMPLOYEE_RANK (ID, NAME, TARIFF) VALUES (2, '2 разряд', 0);
INSERT INTO EMPLOYEE_RANK (ID, NAME, TARIFF) VALUES (3, '3 разряд', 0);
INSERT INTO EMPLOYEE_RANK (ID, NAME, TARIFF) VALUES (4, '4 разряд', 0);
INSERT INTO EMPLOYEE_RANK (ID, NAME, TARIFF) VALUES (5, '5 разряд', 0);

INSERT INTO EDUCATION_FORM (ID, NAME) VALUES (1,'Очная');
INSERT INTO EDUCATION_FORM (ID, NAME) VALUES (2,'Очно-заочная (вечерняя)');
INSERT INTO EDUCATION_FORM (ID, NAME) VALUES (3,'Заочная');
INSERT INTO EDUCATION_FORM (ID, NAME) VALUES (4,'Экстернат');

INSERT INTO EDUCATION_TYPE (ID, NAME) VALUES (1,'Без образования');
INSERT INTO EDUCATION_TYPE (ID, NAME) VALUES (2,'Дошкольное');
INSERT INTO EDUCATION_TYPE (ID, NAME) VALUES (3,'Начальное общее');
INSERT INTO EDUCATION_TYPE (ID, NAME) VALUES (4,'Основное общее');
INSERT INTO EDUCATION_TYPE (ID, NAME) VALUES (5,'Среднее общее');
INSERT INTO EDUCATION_TYPE (ID, NAME) VALUES (6,'Среднее профессиональное');
INSERT INTO EDUCATION_TYPE (ID, NAME) VALUES (7,'Начальное профессиональное');
INSERT INTO EDUCATION_TYPE (ID, NAME) VALUES (8,'Высшее профессиональное');
INSERT INTO EDUCATION_TYPE (ID, NAME) VALUES (9,'Послевузовское профессиональное');
INSERT INTO EDUCATION_TYPE (ID, NAME) VALUES (10,'Повышение квалификации');
INSERT INTO EDUCATION_TYPE (ID, NAME) VALUES (11,'Вторая специальность');
INSERT INTO EDUCATION_TYPE (ID, NAME) VALUES (12,'Магистр');
INSERT INTO EDUCATION_TYPE (ID, NAME) VALUES (13,'Бакалавр');

INSERT INTO FAMILIARITY (ID, NAME, IS_CHILD) VALUES (1,'Муж', 0);
INSERT INTO FAMILIARITY (ID, NAME, IS_CHILD) VALUES (2,'Жена', 0);
INSERT INTO FAMILIARITY (ID, NAME, IS_CHILD) VALUES (3,'Отец', 0);
INSERT INTO FAMILIARITY (ID, NAME, IS_CHILD) VALUES (4,'Мать', 0);
INSERT INTO FAMILIARITY (ID, NAME, IS_CHILD) VALUES (5,'Сын', 1);
INSERT INTO FAMILIARITY (ID, NAME, IS_CHILD) VALUES (6,'Дочь', 1);
INSERT INTO FAMILIARITY (ID, NAME, IS_CHILD) VALUES (7,'Дедушка', 0);
INSERT INTO FAMILIARITY (ID, NAME, IS_CHILD) VALUES (8,'Бабушка', 0);
INSERT INTO FAMILIARITY (ID, NAME, IS_CHILD) VALUES (9,'Внук', 0);
INSERT INTO FAMILIARITY (ID, NAME, IS_CHILD) VALUES (10,'Внучка', 0);
INSERT INTO FAMILIARITY (ID, NAME, IS_CHILD) VALUES (11,'Брат', 0);
INSERT INTO FAMILIARITY (ID, NAME, IS_CHILD) VALUES (12,'Сестра', 0);
INSERT INTO FAMILIARITY (ID, NAME, IS_CHILD) VALUES (13,'Отчим', 0);
INSERT INTO FAMILIARITY (ID, NAME, IS_CHILD) VALUES (14,'Мачеха', 0);
INSERT INTO FAMILIARITY (ID, NAME, IS_CHILD) VALUES (15,'Пасынок', 0);
INSERT INTO FAMILIARITY (ID, NAME, IS_CHILD) VALUES (16,'Падчерица', 0);
INSERT INTO FAMILIARITY (ID, NAME, IS_CHILD) VALUES (17,'Тесть', 0);
INSERT INTO FAMILIARITY (ID, NAME, IS_CHILD) VALUES (18,'Теща', 0);
INSERT INTO FAMILIARITY (ID, NAME, IS_CHILD) VALUES (19,'Свекор', 0);
INSERT INTO FAMILIARITY (ID, NAME, IS_CHILD) VALUES (20,'Свекровь', 0);
INSERT INTO FAMILIARITY (ID, NAME, IS_CHILD) VALUES (21,'Зять', 0);
INSERT INTO FAMILIARITY (ID, NAME, IS_CHILD) VALUES (22,'Невестка', 0);
INSERT INTO FAMILIARITY (ID, NAME, IS_CHILD) VALUES (23,'Другое', 0);

INSERT INTO FAMILY_STATUS (ID, CODE, NAME) VALUES (1, NULL, 'Холост');
INSERT INTO FAMILY_STATUS (ID, CODE, NAME) VALUES (2, NULL, 'Не замужем');
INSERT INTO FAMILY_STATUS (ID, CODE, NAME) VALUES (3, NULL, 'Женат');
INSERT INTO FAMILY_STATUS (ID, CODE, NAME) VALUES (4, NULL, 'Замужем');
INSERT INTO FAMILY_STATUS (ID, CODE, NAME) VALUES (5, NULL, 'Разведён');
INSERT INTO FAMILY_STATUS (ID, CODE, NAME) VALUES (6, NULL, 'Разведена');
INSERT INTO FAMILY_STATUS (ID, CODE, NAME) VALUES (7, NULL, 'Вдовец');
INSERT INTO FAMILY_STATUS (ID, CODE, NAME) VALUES (8, NULL, 'Вдова');
INSERT INTO FAMILY_STATUS (ID, CODE, NAME) VALUES (9, NULL, 'Брак не зарегистрирован');

INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (1, '1', 'Рядовой (матрос)');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (2, '19', 'Генерал армии (адмирал флота, маршал рода войск) и им соотв.');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (3, '17', 'Генерал-лейтенант (вице-адмирал) и им соответствующие');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (4, '16', 'Генерал-майор (контр-адмирал) и им соответствующие');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (5, '18', 'Генерал-полковник (адмирал) и им соответствующие');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (6, '21', 'Главный маршал рода войск');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (7, '32', 'Государственный советник таможенной службы I ранга');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (8, '33', 'Государственный советник таможенной службы II ранга');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (9, '34', 'Государственный советник таможенной службы III ранга');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (10, '31', 'Действительный государственный советник таможенной службы');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (11, '2', 'Ефрейтор (старший матрос)');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (12, '38', 'Инспектор таможенной службы I ранга');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (13, '39', 'Инспектор таможенной службы II ранга');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (14, '40', 'Инспектор таможенной службы III ранга');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (15, '12', 'Капитан (капитан-лейтенант) и им равные');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (16, '10', 'Лейтенант и ему равные');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (17, '13', 'Майор (капитан 3-го ранга) и им равные');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (18, '23', 'Маршал Советского Союза (Адмирал Флота Советского Союза)');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (19, '9', 'Младший лейтенант и ему равные');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (20, '3', 'Младший сержант (старшина 2-й статьи)');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (21, '14', 'Подполковник (капитан 2-го ранга) и им равные');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (22, '15', 'Полковник (капитан 1-го ранга) и им равные');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (23, '7', 'Прапорщик (мичман)');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (24, '4', 'Сержант (старшина 1-й статьи)');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (25, '35', 'Советник таможенной службы I ранга');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (26, '36', 'Советник таможенной службы II ранга');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (27, '37', 'Советник таможенной службы III ранга');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (28, '11', 'Старший лейтенант и ему равные');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (29, '8', 'Старший прапорщик (старший мичман)');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (30, '5', 'Старший сержант (главный старшина)');
INSERT INTO MILITARY_RANK (ID, CODE, NAME) VALUES (31, '6', 'Старшина (главный корабельный старшина)');

INSERT INTO MILITARY_STATUS (ID, CODE, NAME) VALUES (1,NULL,'Военнообязанный');
INSERT INTO MILITARY_STATUS (ID, CODE, NAME) VALUES (2,NULL,'Не военнообязанный');
INSERT INTO MILITARY_STATUS (ID, CODE, NAME) VALUES (3,NULL,'Военнослужащий');
INSERT INTO MILITARY_STATUS (ID, CODE, NAME) VALUES (4,NULL,'Призывник');
INSERT INTO MILITARY_STATUS (ID, CODE, NAME) VALUES (5,NULL,'Таможенник');

INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (1, '0000001', 'СПЕЦИАЛЬНОСТИ СРЕДНЕГО ПРОФЕССИНАЛЬНОГО ОБРАЗОВАНИЯ', NULL);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (2, '1200001', 'Машиностроение и материалообработка', 1);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (3, '1208001', 'Абразивные и алмазные инструменты', 2);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (4, '0000002', 'СПЕЦИАЛЬНОСТИ ВЫСШЕГО ОБРАЗОВАНИЯ', NULL);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (5, '1300003', 'Авиационная и ракетно-космическая техника', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (6, '1315003', 'Авиационная и ракетно-космическая теплотехника', 5);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (7, '1302003', 'Авиационные двигатели и энергетические установки', 5);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (8, '1900003', 'Приборостроение', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (9, '1903003', 'Авиационные приборы и измерительно-вычислительные комплексы', 8);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (10, '1900001', 'Приборостроение', 1);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (11, '1903001', 'Авиационные приборы и комплексы', 10);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (12, '2100001', 'Автоматика и управление', 1);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (13, '2101001', 'Автоматизация технологических процессов и производств', 12);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (14, '2100003', 'Автоматика и управление', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (15, '2102003', 'Автоматизация технологических процессов и производств', 14);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (16, '1700003', 'Технологические машины и оборудование', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (17, '1712003', 'Автоматизированное производство химических предприятий', 16);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (18, '2200003', 'Информатика и вычислительная техника', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (19, '2202003', 'Автоматизированные системы обработки информации и управления', 18);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (20, '2200001', 'Информатика и вычислительная техника', 1);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (21, '2202001', 'Автоматизированные системы обработки информации и управления (по отраслям)', 20);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (22, '1317003', 'Автоматизированные системы управления боевыми авиационными комплексами', 5);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (23, '2107003', 'Автоматика, телемеханика и связь на железнодорожном транспорте', 14);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (24, '2103001', 'Автоматика, телемеханика и управление на транспорте', 12);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (25, '2104001', 'Автоматические системы управления', 12);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (26, '1400003', 'Морская техника', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (27, '1409003', 'Автоматические системы управления морской техникой', 26);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (28, '2102001', 'Автоматическое управление электроэнергетическими системами', 12);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (29, '2104003', 'Автоматическое управление электроэнергетическими системами', 14);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (30, '1205001', 'Автомобиле- и тракторостроение', 2);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (31, '1500003', 'Наземные транспортные средства', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (32, '1501003', 'Автомобиле- и тракторостроение', 31);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (33, '1502003', 'Автомобили и автомобильное хозяйство', 31);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (34, '2900003', 'Строительство и архитектура', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (35, '2910003', 'Автомобильные дороги и аэродромы', 34);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (36, '3100001', 'Сельское и рыбное хозяйство', 1);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (37, '3102001', 'Агрономия', 36);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (38, '3100003', 'Сельское и рыбное хозяйство', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (39, '3102003', 'Агрономия', 38);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (40, '3101003', 'Агрохимия и агропочвоведение', 38);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (41, '3200003', 'Экология и природопользование', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (42, '3204003', 'Агроэкология', 41);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (43, '0500001', 'Культура и искусство', 1);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (44, '0507001', 'Актерское искусство', 43);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (45, '0500003', 'Культура и искусство', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (46, '0501003', 'Актерское искусство', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (47, '1904001', 'Акустические приборы и системы', 10);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (48, '1904003', 'Акустические приборы и системы', 8);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (49, '0400001', 'Здравоохранение', 1);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (50, '0402001', 'Акушерское дело', 49);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (51, '2500001', 'Химическая технология', 1);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (52, '2514001', 'Аналитический контроль качества химических соединений', 51);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (53, '0300003', 'Образование', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (54, '0314003', 'Андрагогика', 53);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (55, '0100003', 'Естественнонаучные специальности', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (56, '0117003', 'Антропология', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (57, '2900001', 'Строительство и архитектура', 1);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (58, '2901001', 'Архитектура', 57);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (59, '2901003', 'Архитектура', 34);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (60, '0109003', 'Астрономия', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (61, '3000003', 'Геодезия и картография', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (62, '3002003', 'Астрономогеодезия', 61);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (63, '1000001', 'Энергетика', 1);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (64, '1007001', 'Атомные и ядерные энергетические установки', 63);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (65, '1000003', 'Энергетика и энергомашиностроение', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (66, '1010003', 'Атомные электрические станции и установки', 65);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (67, '2000001', 'Электронная техника, радиотехника и связь', 1);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (68, '2013001', 'Аудиовизуальная техника', 67);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (69, '2000003', 'Электронная техника, радиотехника и связь', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (70, '2014003', 'Аудиовизуальная техника', 69);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (71, '3000001', 'Геодезия и картография', 1);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (72, '3002001', 'Аэрофотогеодезия', 71);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (73, '3003003', 'Аэрофотогеодезия', 61);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (74, '3004001', 'Аэрофотограмметрия', 71);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (75, '3005001', 'Аэрофотосъемка', 71);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (76, '0700003', 'Междисциплинарные естественно-технические специальности', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (77, '0703003', 'Баллистика', 76);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (78, '0600001', 'Экономика и управление', 1);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (79, '0604001', 'Банковское дело', 78);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (80, '3300003', 'Безопасность жизнедеятельности', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (81, '3301003', 'Безопасность жизнедеятельности', 80);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (82, '3305003', 'Безопасность технологических процессов и производств (по отраслям)', 80);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (83, '0527003', 'Библиотековедение и библиография', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (84, '0517001', 'Библиотечное дело', 43);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (85, '0116003', 'Биология', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (86, '1905001', 'Биотехнические и медицинские аппараты и системы', 10);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (87, '1905003', 'Биотехнические и медицинские аппараты и системы', 8);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (88, '0701003', 'Биотехнология', 76);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (89, '0122003', 'Биофизика', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (90, '2509001', 'Биохимическое производство', 51);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (91, '0123003', 'Биохимия', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (92, '3202003', 'Биоэкология', 41);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (93, '0610001', 'Биржевая деятельность', 78);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (94, '1308003', 'Большие авиационные и ракетно-космические комплексы', 5);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (95, '0119003', 'Ботаника', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (96, '0900001', 'Разработка полезных ископаемых', 1);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (97, '0907001', 'Бурение нефтяных и газовых скважин', 96);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (98, '0900003', 'Разработка полезных ископаемых', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (99, '0908003', 'Бурение нефтяных и газовых скважин', 98);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (100, '0600003', 'Экономика и управление', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (101, '0605003', 'Бухгалтерский учет и аудит', 100);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (102, '2015003', 'Бытовая радиоэлектронная аппаратура', 69);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (103, '1508003', 'Вагоны', 31);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (104, '1015003', 'Вакуумная и компрессорная техника физических установок', 65);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (105, '2800001', 'Технология товаров широкого потребления', 1);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (106, '2805001', 'Валяльно-войлочное и фетровое производство', 105);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (107, '3104001', 'Ветеринария', 36);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (108, '3108003', 'Ветеринария', 38);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (109, '1800003', 'Электротехника', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (110, '1813003', 'Внутризаводское электрооборудование', 109);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (111, '3117003', 'Водные биоресурсы и аквакультура', 38);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (112, '2912001', 'Водоснабжение и водоотведение', 57);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (113, '2908003', 'Водоснабжение и водоотведение', 34);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (114, '1503003', 'Военные гусеничные и колесные машины', 31);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (115, '0510003', 'Вокальное искусство', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (116, '2600001', 'Воспроизводство и переработка лесных ресурсов', 1);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (117, '2600003', 'Воспроизводство и переработка лесных ресурсов', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (118, '2201001', 'Вычислительные машины, комплексы, системы и сети', 20);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (119, '2201003', 'Вычислительные машины, комплексы, системы и сети', 18);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (120, '1714003', 'Газодинамические импульсные устройства', 16);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (121, '0121003', 'Генетика', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (122, '0300001', 'Образование', 1);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (123, '0305001', 'География', 122);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (124, '0125003', 'География', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (125, '0800001', 'Геология и разведка полезных ископаемых', 1);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (126, '0801001', 'Геологическая съемка и поиски месторождений полезных ископаемых', 125);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (127, '0800003', 'Геология и разведка полезных ископаемых', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (128, '0801003', 'Геологическая съемка и поиски месторождений полезных ископаемых', 127);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (129, '0111003', 'Геология', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (130, '0115003', 'Геология и геохимия горючих ископаемых', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (131, '0802003', 'Геология и разведка месторождений полезных ископаемых', 127);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (132, '0806001', 'Геология и разведка нефтяных и газовых месторождений', 125);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (133, '0805003', 'Геология нефти и газа', 127);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (134, '0112003', 'Геофизика', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (135, '0802001', 'Геофизические методы поисков и разведки месторождений полезных ископаемых', 125);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (136, '0804003', 'Геофизические методы поисков и разведки месторождений полезных ископаемых', 127);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (137, '0113003', 'Геохимия', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (138, '3203003', 'Геоэкология', 41);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (139, '1200003', 'Машиностроение и материалообработка', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (140, '1211003', 'Гидравлические машины, гидроприводы и гидропневмоавтоматика', 139);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (141, '0713003', 'Гидроаэродинамика', 76);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (142, '0803001', 'Гидрогеология и инженерная геология', 125);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (143, '0114003', 'Гидрогеология и инженерная геология', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (144, '0129003', 'Гидрография', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (145, '0100001', 'Естественнонаучные специальности', 1);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (146, '0101001', 'Гидрология', 145);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (147, '0127003', 'Гидрология', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (148, '2906001', 'Гидротехническое строительство', 57);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (149, '2904003', 'Гидротехническое строительство', 34);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (150, '1003003', 'Гидроэлектроэнергетика', 65);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (151, '1003001', 'Гидроэлектроэнергетические установки', 63);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (152, '1909001', 'Гироскопические приборы', 10);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (153, '1812003', 'Гироскопические приборы и системы ориентации, навигации, стабилизации', 109);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (154, '1701003', 'Горные машины и оборудование', 16);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (155, '2905003', 'Городское строительство и хозяйство', 34);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (156, '3111003', 'Городской кадастр', 38);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (157, '0610003', 'Государственное и муниципальное управление', 100);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (158, '0519003', 'Графика', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (159, '0200001', 'Гуманитарно-социальные специальности', 1);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (160, '0200003', 'Гуманитарно-социальные специальности', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (161, '1012003', 'Двигатели внутреннего сгорания', 65);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (162, '0515001', 'Декоративно-прикладное искусство и народные промыслы', 43);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (163, '0523003', 'Декоративно-прикладное искусство и народные промыслы', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (164, '0611001', 'Делопроизводство и архивоведение', 78);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (165, '0514001', 'Дизайн', 43);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (166, '0524003', 'Дизайн', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (167, '2902003', 'Дизайн архитектурной среды', 34);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (168, '0711003', 'Динамика и прочность машин', 76);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (169, '1314003', 'Динамика полета и управление движением', 5);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (170, '0511003', 'Дирижирование', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (171, '3400001', 'Метрология, стандартизация и контроль качества', 1);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (172, '3406001', 'Дозиметрия и защита от излучений', 171);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (173, '0613003', 'Документоведение и документационное обеспечение управления', 100);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (174, '0315001', 'Домашнее образование', 122);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (175, '2300001', 'Сервис', 1);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (176, '2306001', 'Домоведение', 175);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (177, '2300003', 'Сервис', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (178, '2306003', 'Домоведение', 177);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (179, '0304003', 'Допризывная и физическая подготовка', 53);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (180, '0309003', 'Дошкольная педагогика и психология', 53);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (181, '0313001', 'Дошкольное образование', 122);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (182, '0302003', 'Естествознание', 53);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (183, '0512001', 'Живопись', 43);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (184, '0518003', 'Живопись', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (185, '0214003', 'Журналистика', 160);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (186, '3104003', 'Защита растений', 38);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (187, '0515003', 'Звукорежиссура', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (188, '0400003', 'Здравоохранение', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (189, '3110003', 'Земельный кадастр', 38);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (190, '3101001', 'Землеустройство', 36);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (191, '3109003', 'Землеустройство', 38);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (192, '0118003', 'Зоология', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (193, '3103001', 'Зоотехния', 36);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (194, '3107003', 'Зоотехния', 38);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (195, '2910001', 'Изготовление металлических конструкций', 57);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (196, '0206001', 'Издательское дело', 159);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (197, '0215003', 'Издательское дело и редактирование', 160);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (198, '0311001', 'Изобразительное искусство и черчение', 122);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (199, '0308003', 'Изобразительное искусство и черчение', 53);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (200, '1713003', 'Импульсные тепловые машины', 16);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (201, '1715003', 'Импульсные устройства и автоматические роторные линии', 16);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (202, '3302003', 'Инженерная защита окружающей среды (по отраслям)', 80);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (203, '1906003', 'Инженерное дело в медико-биологической практике', 8);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (204, '3116003', 'Инженерные системы сельскохозяйственного водоснабжения, обводнения и водоотведения', 38);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (205, '0303001', 'Иностранный язык', 122);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (206, '0501001', 'Инструментальное исполнительство', 43);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (207, '0509003', 'Инструментальное исполнительство', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (208, '0525003', 'Интерьеры и оборудование', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (209, '0301003', 'Информатика', 53);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (210, '1909003', 'Информационно-измерительная техника и технологии', 8);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (211, '0719003', 'Информационные системы (по областям применения)', 76);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (212, '0511001', 'Искусство эстрады', 43);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (213, '0513003', 'Искусство эстрады', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (214, '0209003', 'Искусствоведение', 160);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (215, '1309003', 'Испытание летательных аппаратов', 5);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (216, '0805001', 'Испытание скважин на нефть и газ', 125);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (217, '0808003', 'Исследование природных ресурсов аэрокосмическими средствами', 127);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (218, '0208003', 'Историко-архивоведение', 160);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (219, '0304001', 'История', 122);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (220, '0207003', 'История', 160);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (221, '0521003', 'История и теория изобразительного искусства', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (222, '0508003', 'История и теория хореографического искусства', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (223, '3109001', 'Ихтиология и рыбоводство', 36);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (224, '3003001', 'Картография', 71);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (225, '3004003', 'Картография', 61);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (226, '0516003', 'Киноведение', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (227, '0517003', 'Кинооператорство', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (228, '0216003', 'Книговедение', 160);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (229, '2504001', 'Коксохимическое производство', 51);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (230, '2807001', 'Колорирование и художественное оформление изделий легкой промышленности', 105);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (231, '0614003', 'Коммерция', 100);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (232, '0608001', 'Коммерция (по отраслям)', 78);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (233, '3206003', 'Комплексное использование и охрана водных ресурсов', 41);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (234, '1100001', 'Металлургия', 1);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (235, '1106001', 'Композиционные и порошковые материалы, покрытия', 234);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (236, '1100003', 'Металлургия', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (237, '1108003', 'Композиционные и порошковые материалы, покрытия', 236);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (238, '0512003', 'Композиция', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (239, '1210003', 'Конструирование и производство изделий из композиционных материалов', 139);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (240, '2205003', 'Конструирование и технология электронно-вычислительных средств', 18);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (241, '2800003', 'Технология товаров широкого потребления', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (242, '2812003', 'Конструирование изделий из кожи', 241);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (243, '2809003', 'Конструирование швейных изделий', 241);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (244, '3405001', 'Контроль качества металлов и сварных соединений', 171);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (245, '1411003', 'Корабельные автоматизированные комплексы и информационно-управляющие системы', 26);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (246, '2106003', 'Корабельные системы управления', 14);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (247, '1401003', 'Кораблестроение', 26);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (248, '0320003', 'Коррекционная педагогика и специальная психология (дошкольная)', 53);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (249, '3005003', 'Космическая геодезия', 61);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (250, '1307003', 'Космические летательные аппараты и разгонные блоки', 5);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (251, '1013003', 'Котло- и реакторостроение', 65);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (252, '0204001', 'Криминалистическая экспертиза', 159);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (253, '0206003', 'Культурология', 160);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (254, '0407001', 'Лабораторная диагностика', 49);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (255, '1312003', 'Лазерные системы', 5);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (256, '2604001', 'Лесное и лесопарковое хозяйство', 116);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (257, '2604003', 'Лесное и лесопарковое хозяйство', 117);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (258, '2601003', 'Лесоинженерное дело', 117);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (259, '2400001', 'Эксплуатация транспорта', 1);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (260, '2403001', 'Летная эксплуатация летательных аппаратов', 259);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (261, '0401001', 'Лечебное дело', 49);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (262, '0401003', 'Лечебное дело', 188);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (263, '0218003', 'Лингвистика', 160);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (264, '1103001', 'Литейное производство черных и цветных металлов', 234);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (265, '1104003', 'Литейное производство черных и цветных металлов', 236);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (266, '0526003', 'Литературное творчество', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (267, '0219003', 'Литературоведение', 160);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (268, '0318003', 'Логопедия', 53);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (269, '1507003', 'Локомотивы', 31);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (270, '0615003', 'Маркетинг', 100);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (271, '0607001', 'Маркетинг (по отраслям)', 78);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (272, '0901001', 'Маркшейдерское дело', 96);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (273, '0901003', 'Маркшейдерское дело', 98);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (274, '0301001', 'Математика', 122);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (275, '0101003', 'Математика', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (276, '0618003', 'Математические методы и исследование операций в экономике', 100);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (277, '1208003', 'Материаловедение в машиностроении', 139);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (278, '0710003', 'Материаловедение и технология новых материалов', 76);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (279, '2001003', 'Материалы и компоненты твердотельной электроники', 69);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (280, '1706003', 'Машины и аппараты пищевых производств', 16);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (281, '1707003', 'Машины и аппараты текстильной и легкой промышленности', 16);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (282, '1705003', 'Машины и аппараты химических производств и предприятий строительных материалов', 16);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (283, '1704003', 'Машины и оборудование лесного комплекса', 16);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (284, '1702003', 'Машины и оборудование нефтяных и газовых промыслов', 16);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (285, '1711003', 'Машины и оборудование природообустройства и защиты окружающей среды', 16);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (286, '1207003', 'Машины и технология высокоэффективных процессов обработки', 139);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (287, '1203003', 'Машины и технология литейного производства', 139);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (288, '1204003', 'Машины и технология обработки металлов давлением', 139);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (289, '1504003', 'Машины инженерного вооружения', 31);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (290, '0403001', 'Медико-профилактическое дело', 49);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (291, '0403003', 'Медико-профилактическое дело', 188);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (292, '0409001', 'Медицинская оптика', 49);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (293, '0212003', 'Международные отношения', 160);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (294, '3200001', 'Окружающая среда и обеспечение жизнедеятельности', 1);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (295, '3202001', 'Мелиорация и охрана земель', 294);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (296, '3205003', 'Мелиорация, рекультивация и охрана земель', 41);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (297, '0611003', 'Менеджмент', 100);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (298, '0602001', 'Менеджмент (по отраслям)', 78);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (299, '0612003', 'Менеджмент в социальной сфере', 100);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (300, '1104001', 'Металловедение и термическая обработка металлов', 234);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (301, '1105003', 'Металловедение и термическая обработка металлов', 236);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (302, '1202003', 'Металлорежущие станки и инструменты', 139);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (303, '1703003', 'Металлургические машины и оборудование', 16);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (304, '1107003', 'Металлургия сварочного производства', 236);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (305, '1102001', 'Металлургия цветных металлов', 234);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (306, '1102003', 'Металлургия цветных металлов', 236);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (307, '1101001', 'Металлургия черных металлов', 234);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (308, '1101003', 'Металлургия черных металлов', 236);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (309, '0102001', 'Метеорология', 145);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (310, '0126003', 'Метеорология', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (311, '1908003', 'Метрология и метрологическое обеспечение', 8);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (312, '2913003', 'Механизация и автоматизация строительства', 34);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (313, '1509003', 'Механизация перегрузочных работ', 31);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (314, '3115003', 'Механизация переработки сельскохозяйственной продукции', 38);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (315, '3106001', 'Механизация сельского хозяйства', 36);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (316, '3113003', 'Механизация сельского хозяйства', 38);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (317, '0105003', 'Механика', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (318, '3403001', 'Механические измерения', 171);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (319, '0718003', 'Мехатроника', 76);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (320, '0124003', 'Микробиология', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (321, '2001001', 'Микроэлектроника и полупроводниковые приборы', 67);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (322, '2002003', 'Микроэлектроника и полупроводниковые приборы', 69);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (323, '0606003', 'Мировая экономика', 100);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (324, '2005001', 'Многоканальные телекоммуникационные системы', 67);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (325, '2010003', 'Многоканальные телекоммуникационные системы', 69);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (326, '2808001', 'Моделирование и конструирование изделий народного потребления', 105);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (327, '2914001', 'Монтаж и эксплуатация внутренних сантехнических устройств и вентиляции', 57);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (328, '2915001', 'Монтаж и эксплуатация оборудования и систем газоснабжения', 57);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (329, '1002001', 'Монтаж линий электропередачи', 63);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (330, '2911001', 'Монтаж промышленного оборудования', 57);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (331, '2913001', 'Монтаж, наладка и эксплуатация электрооборудования предприятий и гражданских зданий', 57);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (332, '1700001', 'Технологические машины и оборудование', 1);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (333, '1711001', 'Монтаж, техническое обслуживание и ремонт холодильно-компрессорных машин и установок', 332);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (334, '0522003', 'Монументально-декоративное искусство', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (335, '1407003', 'Морская акустика и гидрофизика', 26);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (336, '1406003', 'Морская системотехника', 26);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (337, '1410003', 'Морские информационные системы и оборудование', 26);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (338, '0909003', 'Морские нефтегазовые сооружения', 98);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (339, '2405001', 'Морское судовождение', 259);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (340, '2911003', 'Мосты и транспортные тоннели', 34);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (341, '0528003', 'Музейное дело и охрана памятников', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (342, '0210003', 'Музеология', 160);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (343, '0505001', 'Музыкальное искусство эстрады', 43);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (344, '0310001', 'Музыкальное образование', 122);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (345, '0307003', 'Музыкальное образование', 53);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (346, '0514003', 'Музыковедение', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (347, '0530003', 'Народное художественное творчество', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (348, '0607003', 'Национальная экономика', 100);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (349, '1009003', 'Нетрадиционные и возобновляемые источники энергии', 65);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (350, '0904001', 'Обогащение полезных ископаемых', 96);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (351, '0903003', 'Обогащение полезных ископаемых', 98);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (352, '1206003', 'Оборудование и технология повышения износостойкости и восстановление деталей машин и аппаратов', 139);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (353, '1205003', 'Оборудование и технология сварочного производства', 139);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (354, '1105001', 'Обработка металлов давлением', 234);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (355, '1106003', 'Обработка металлов давлением', 236);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (356, '2404001', 'Обслуживание летательных аппаратов горюче-смазочными материалами', 259);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (357, '0128003', 'Океанология', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (358, '1412003', 'Океанотехника', 26);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (359, '0317003', 'Олигофренопедагогика', 53);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (360, '1907003', 'Оптико-электронные приборы и системы', 8);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (361, '1908001', 'Оптические и оптико-электронные приборы и системы', 10);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (362, '2301001', 'Организация бытового обслуживания населения', 175);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (363, '2400003', 'Эксплуатация транспорта', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (364, '2404003', 'Организация дорожного движения', 363);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (365, '2206003', 'Организация и технология защиты информации', 18);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (366, '3112001', 'Организация крестьянского (фермерского) хозяйства', 36);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (367, '2302001', 'Организация обслуживания в гостиницах и туристических комплексах', 175);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (368, '2401001', 'Организация перевозок и управление движением на транспорте (по отраслям)', 259);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (369, '2401003', 'Организация перевозок и управление на транспорте', 363);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (370, '0316001', 'Организация социально-реабилитационной работы с глухими', 122);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (371, '2500003', 'Химическая технология', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (372, '2518003', 'Основные процессы химических производств и химическая кибернетика', 371);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (373, '0902001', 'Открытая разработка месторождений полезных ископаемых', 96);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (374, '0905003', 'Открытые горные работы', 98);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (375, '3111001', 'Охотоведение и звероводство', 36);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (376, '3201001', 'Охрана окружающей среды и рациональное использование природных ресурсов', 294);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (377, '3207003', 'Охрана окружающей среды и рациональное использование природных ресурсов', 41);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (378, '2304001', 'Парикмахерское искусство и декоративная косметика', 175);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (379, '0311003', 'Педагогика и методика дошкольного образования', 53);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (380, '0312003', 'Педагогика и методика начального образования', 53);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (381, '0310003', 'Педагогика и психология', 53);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (382, '0507003', 'Педагогика хореографии', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (383, '0402003', 'Педиатрия', 188);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (384, '0502001', 'Пение', 43);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (385, '2801001', 'Первичная обработка волокнистых материалов', 105);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (386, '2510001', 'Переработка вторичного сырья', 51);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (387, '2505001', 'Переработка нефти и газа', 51);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (388, '1011003', 'Плазменные энергетические установки', 65);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (389, '3103003', 'Плодоовощеводство и виноградарство', 38);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (390, '1408003', 'Подводная техника', 26);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (391, '0903001', 'Подземная разработка месторождений полезных ископаемых', 96);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (392, '0902003', 'Подземная разработка месторождений полезных ископаемых', 98);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (393, '1709003', 'Подъемно-транспортные, строительные, дорожные машины и оборудование', 16);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (394, '3203001', 'Пожарная безопасность', 294);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (395, '3304003', 'Пожарная безопасность', 80);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (396, '0803003', 'Поиски и разведка подземных вод и инженерно-геологические изыскания', 127);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (397, '1708003', 'Полиграфические машины и автоматизированные комплексы', 16);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (398, '2814001', 'Полиграфическое производство', 105);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (399, '0202003', 'Политология', 160);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (400, '0130003', 'Почвоведение', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (401, '2015001', 'Почтовая связь', 67);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (402, '0202001', 'Право и организация социального обеспечения', 159);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (403, '0201001', 'Правоведение', 159);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (404, '0203001', 'Правоохранительная деятельность', 159);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (405, '0312001', 'Преподавание в начальных классах', 122);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (406, '1901001', 'Приборостроение', 10);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (407, '1901003', 'Приборостроение', 8);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (408, '1902003', 'Приборы и методы контроля качества и диагностики', 8);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (409, '1902001', 'Приборы контроля качества и диагностики', 10);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (410, '3001001', 'Прикладная геодезия', 71);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (411, '3001003', 'Прикладная геодезия', 61);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (412, '0806003', 'Прикладная геохимия, петрология, минералогия', 127);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (413, '0102003', 'Прикладная математика', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (414, '0103003', 'Прикладные математика и физика', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (415, '3208003', 'Природоохранное обустройство территорий', 41);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (416, '3201003', 'Природопользование', 41);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (417, '1316003', 'Прицельно-навигационные системы летательных аппаратов', 5);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (418, '2203001', 'Программное обеспечение вычислительной техники и автоматизированных систем', 20);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (419, '2204003', 'Программное обеспечение вычислительной техники и автоматизированных систем', 18);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (420, '2303003', 'Проектирование и сервис бытовых машин и приборов', 177);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (421, '2304003', 'Проектирование и технология изделий сферы быта и услуг', 177);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (422, '2008003', 'Проектирование и технология радиоэлектронных средств', 69);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (423, '1209003', 'Проектирование технологических комплексов', 139);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (424, '0907003', 'Проектирование, сооружение и эксплуатация газонефтепроводов и газонефтехранилищ', 98);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (425, '1203001', 'Производство авиационных двигателей', 2);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (426, '2816001', 'Производство игрушки', 105);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (427, '2506001', 'Производство изделий и покрытий из полимерных материалов', 51);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (428, '2813001', 'Производство изделий из бумаги и картона', 105);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (429, '2811001', 'Производство изделий из кожи', 105);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (430, '1210001', 'Производство изделий на автоматических роторных и роторно-конвейерных линиях', 2);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (431, '1202001', 'Производство летательных аппаратов', 2);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (432, '2812001', 'Производство меховых и овчинно-шубных изделий', 105);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (433, '2815001', 'Производство музыкальных инструментов', 105);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (434, '1206001', 'Производство подвижного состава железных дорог', 2);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (435, '2909001', 'Производство строительных изделий и конструкций', 57);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (436, '2906003', 'Производство строительных материалов, изделий и конструкций', 34);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (437, '2508001', 'Производство тугоплавких неметаллических и силикатных материалов и изделий', 51);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (438, '1007003', 'Промышленная теплоэнергетика', 65);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (439, '2004003', 'Промышленная электроника', 69);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (440, '2903003', 'Промышленное и гражданское строительство', 34);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (441, '3110001', 'Промышленное рыболовство', 36);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (442, '3118003', 'Промышленное рыболовство', 38);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (443, '1906001', 'Протезное производство', 10);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (444, '0308001', 'Профессиональное обучение', 122);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (445, '0305003', 'Профессиональное обучение', 53);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (446, '2802001', 'Прядильное производство', 105);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (447, '0306001', 'Психология', 122);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (448, '0204003', 'Психология', 160);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (449, '3105001', 'Пчеловодство', 36);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (450, '3303003', 'Радиационная безопасность человека и окружающей среды', 80);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (451, '2003001', 'Радиоаппаратостроение', 67);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (452, '2006001', 'Радиосвязь, радиовещание и телевидение', 67);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (453, '2011003', 'Радиосвязь, радиовещание и телевидение', 69);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (454, '2007003', 'Радиотехника', 69);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (455, '3401001', 'Радиотехнические измерения', 171);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (456, '0715003', 'Радиофизика и электроника', 76);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (457, '2108003', 'Радиоэлектронные и электромеханические приборные устройства', 14);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (458, '1910001', 'Радиоэлектронные приборные устройства', 10);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (459, '2016003', 'Радиоэлектронные системы', 69);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (460, '0906003', 'Разработка и эксплуатация нефтяных и газовых месторождений', 98);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (461, '1304003', 'Ракетные двигатели', 5);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (462, '1306003', 'Ракетостроение', 5);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (463, '1907001', 'Реабилитационная техника', 10);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (464, '0213003', 'Регионоведение', 160);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (465, '0502003', 'Режиссура', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (466, '0506003', 'Режиссура хореографии', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (467, '0529003', 'Реклама', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (468, '0222003', 'Религиоведение', 160);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (469, '0721003', 'Реновация средств материального производства (по отраслям)', 76);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (470, '2912003', 'Реставрация и реконструкция архитектурного наследия', 34);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (471, '0516001', 'Реставрация, консервация и хранение произведений искусства', 43);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (472, '1319003', 'Робототехнические системы авиационного вооружения', 5);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (473, '2103003', 'Роботы и робототехнические системы', 14);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (474, '0302001', 'Русский язык и литература', 122);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (475, '2605001', 'Садово-парковое и ландшафтное строительство', 116);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (476, '2605003', 'Садово-парковое и ландшафтное строительство', 117);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (477, '1301003', 'Самолето- и вертолетостроение', 5);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (478, '1207001', 'Сварочное производство', 2);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (479, '0509001', 'Светорежиссура', 43);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (480, '1800001', 'Электротехника', 1);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (481, '1803001', 'Светотехника и источники света', 480);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (482, '1806003', 'Светотехника и источники света', 109);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (483, '0220003', 'Связи с общественностью', 160);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (484, '3106003', 'Селекция и генетика сельскохозяйственных культур', 38);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (485, '1710003', 'Сельскохозяйственные машины и оборудование', 16);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (486, '2302003', 'Сервис бытовой радиоэлектронной аппаратуры', 177);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (487, '2301003', 'Сервис и техническая эксплуатация транспортных и технологических машин и оборудования (по отраслям)', 177);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (488, '0408001', 'Сестринское дело', 49);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (489, '0406003', 'Сестринское дело', 188);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (490, '2004001', 'Сети связи и системы коммутации', 67);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (491, '2009003', 'Сети связи и системы коммутации', 69);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (492, '2203003', 'Системы автоматизированного проектирования', 18);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (493, '2105003', 'Системы автоматического управления летательных аппаратов', 14);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (494, '1311003', 'Системы жизнеобеспечения и защиты летательных аппаратов', 5);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (495, '1318003', 'Системы приводов летательных аппаратов', 5);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (496, '1404003', 'Системы электроэнергетики и автоматизации судов', 26);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (497, '0513001', 'Скульптура', 43);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (498, '0520003', 'Скульптура', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (499, '0905001', 'Сооружение и эксплуатация газонефтепроводов и газонефтехранилищ', 96);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (500, '0205003', 'Социальная антропология', 160);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (501, '0314001', 'Социальная педагогика', 122);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (502, '0313003', 'Социальная педагогика', 53);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (503, '0205001', 'Социальная работа', 159);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (504, '0221003', 'Социальная работа', 160);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (505, '0518001', 'Социально-культурная деятельность', 43);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (506, '0531003', 'Социально-культурная деятельность', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (507, '2305003', 'Социально-культурный сервис и туризм', 177);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (508, '0203003', 'Социология', 160);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (509, '0319003', 'Специальная психология', 53);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (510, '1209001', 'Специальные машины и устройства', 2);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (511, '1506003', 'Средства аэродромно-технического обеспечения полетов авиации', 31);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (512, '2017003', 'Средства радиоэлектронной борьбы', 69);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (513, '2009001', 'Средства связи с подвижными объектами', 67);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (514, '2012003', 'Средства связи с подвижными объектами', 69);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (515, '3404001', 'Стандартизация и контроль качества продукции (по отраслям)', 171);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (516, '0720003', 'Стандартизация и сертификация (по отраслям)', 76);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (517, '1313003', 'Стартовые и технические комплексы ракет и космических аппаратов', 5);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (518, '0605001', 'Статистика', 78);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (519, '0617003', 'Статистика', 100);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (520, '0404001', 'Стоматология', 49);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (521, '0404003', 'Стоматология', 188);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (522, '0405001', 'Стоматология ортопедическая', 49);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (523, '0606001', 'Страховое дело (по отраслям)', 78);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (524, '2909003', 'Строительство железных дорог, путь и путевое хозяйство', 34);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (525, '2904001', 'Строительство и техническое обслуживание железнодорожного пути', 57);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (526, '2905001', 'Строительство и эксплуатация автомобильных дорог и аэродромов', 57);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (527, '2903001', 'Строительство и эксплуатация городских путей сообщения', 57);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (528, '2902001', 'Строительство и эксплуатация зданий и сооружений', 57);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (529, '2908001', 'Строительство мостов и других искусственных сооружений', 57);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (530, '2907001', 'Строительство подземных сооружений и шахт', 57);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (531, '0224003', 'Судебная экспертиза', 160);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (532, '1403003', 'Судовое энергетическое оборудование', 26);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (533, '2402003', 'Судовождение', 363);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (534, '2406001', 'Судовождение и эксплуатация технического флота', 259);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (535, '2407001', 'Судовождение на внутренних водных путях и в прибрежном плавании', 259);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (536, '1402003', 'Судовые энергетические установки', 26);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (537, '1204001', 'Судостроение', 2);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (538, '0316003', 'Сурдопедагогика', 53);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (539, '0510001', 'Театрально-декорационное искусство', 43);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (540, '0503003', 'Театрально-декорационное искусство', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (541, '0504003', 'Театроведение', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (542, '0601003', 'Теоретическая экономика', 100);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (543, '0504001', 'Теория музыки', 43);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (544, '1005003', 'Тепловые электрические станции', 65);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (545, '2907003', 'Теплогазоснабжение и вентиляция', 34);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (546, '1006001', 'Теплоснабжение и теплотехническое оборудование', 63);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (547, '0707003', 'Теплофизика', 76);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (548, '1103003', 'Теплофизика, автоматизация и экология промышленных печей', 236);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (549, '1005001', 'Теплоэнергетические установки', 63);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (550, '0716003', 'Техника и физика высоких напряжений', 76);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (551, '0702003', 'Техника и физика низких температур', 76);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (552, '1310003', 'Техническая эксплуатация авиационных электросистем и пилотажно-навигационных комплексов', 5);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (553, '1703001', 'Техническая эксплуатация летательных аппаратов и двигателей', 332);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (554, '1303003', 'Техническая эксплуатация летательных аппаратов и двигателей', 5);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (555, '1405003', 'Техническая эксплуатация судов и судового оборудования', 26);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (556, '2013003', 'Техническая эксплуатация транспортного радиооборудования', 69);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (557, '2010001', 'Техническая эксплуатация транспортного радиоэлектронного оборудования', 67);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (558, '2007001', 'Техническая эксплуатация электрифицированных и пилотажно-навигационных комплексов', 67);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (559, '1707001', 'Техническая эксплуатация, обслуживание и ремонт подвижного состава железных дорог', 332);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (560, '1712001', 'Техническая эксплуатация, обслуживание и ремонт средств механизации и автоматизации (по отраслям)', 332);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (561, '1806001', 'Техническая эксплуатация, обслуживание и ремонт электрического и электромеханического оборудования', 480);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (562, '1714001', 'Техническое обслуживание газодинамических импульсных устройств', 332);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (563, '1705001', 'Техническое обслуживание и ремонт автомобильного транспорта', 332);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (564, '1709001', 'Техническое обслуживание и ремонт геологоразведочного оборудования', 332);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (565, '1713001', 'Техническое обслуживание и ремонт гидравлических машин, гидроприводов и гидропневмоавтоматики', 332);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (566, '1708001', 'Техническое обслуживание и ремонт оборудования для производства электронной техники', 332);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (567, '1702001', 'Техническое обслуживание и ремонт оборудования предприятий машиностроения', 332);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (568, '1701001', 'Техническое обслуживание и ремонт промышленного оборудования', 332);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (569, '2014001', 'Техническое обслуживание и ремонт радиоэлектронной техники', 67);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (570, '1704001', 'Техническое обслуживание судовых машин и механизмов', 332);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (571, '2700001', 'Технология продовольственных продуктов', 1);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (572, '2704001', 'Технология бродильных производств и виноделие', 571);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (573, '2700003', 'Технология продовольственных продуктов', 4);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (574, '2705003', 'Технология бродильных производств и виноделие', 573);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (575, '1006003', 'Технология воды и топлива на тепловых электрических станциях', 65);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (576, '1008001', 'Технология воды, топлива и смазочных материалов на электрических станциях', 63);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (577, '2511001', 'Технология высокомолекулярных и высокоэффективных соединений и устройств', 51);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (578, '2602001', 'Технология деревообработки', 116);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (579, '2602003', 'Технология деревообработки', 117);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (580, '2707003', 'Технология жиров', 573);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (581, '2706001', 'Технология жиров и жирозаменителей', 571);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (582, '2801003', 'Технология и оборудование производства натуральных волокон', 241);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (583, '2802003', 'Технология и оборудование производства химических волокон и композиционных материалов на их основе', 241);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (584, '0306003', 'Технология и предпринимательство', 53);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (585, '0804001', 'Технология и техника разведки месторождений полезных ископаемых', 125);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (586, '0807003', 'Технология и техника разведки месторождений полезных ископаемых', 127);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (587, '2811003', 'Технология изделий из кожи', 241);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (588, '2507001', 'Технология кинофотоматериалов и магнитных носителей', 51);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (589, '2507003', 'Технология кинофотоматериалов и магнитных носителей', 371);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (590, '2810001', 'Технология кожи и меха', 105);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (591, '2810003', 'Технология кожи и меха', 241);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (592, '2707001', 'Технология консервов и пищеконцентратов', 571);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (593, '2708003', 'Технология консервов и пищеконцентратов', 573);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (594, '2601001', 'Технология лесозаготовок', 116);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (595, '1201001', 'Технология машиностроения', 2);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (596, '1201003', 'Технология машиностроения', 139);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (597, '2710001', 'Технология молока и молочных продуктов', 571);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (598, '2711003', 'Технология молока и молочных продуктов', 573);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (599, '2708001', 'Технология мяса и мясных продуктов', 571);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (600, '2709003', 'Технология мяса и мясных продуктов', 573);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (601, '2804001', 'Технология нетканых текстильных материалов', 105);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (602, '2806003', 'Технология нетканых текстильных материалов', 241);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (603, '2603001', 'Технология переработки древесины', 116);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (604, '2506003', 'Технология переработки пластических масс и эластомеров', 371);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (605, '2512001', 'Технология пиротехнических составов и изделий', 51);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (606, '2514003', 'Технология пиротехнических средств', 371);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (607, '2814003', 'Технология полиграфического производства', 241);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (608, '2711001', 'Технология продуктов общественного питания', 571);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (609, '2712003', 'Технология продуктов общественного питания', 573);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (610, '2803003', 'Технология прядения', 241);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (611, '2513001', 'Технология разделения изотопов и вакуумная техника', 51);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (612, '2709001', 'Технология рыбы и рыбных продуктов', 571);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (613, '2710003', 'Технология рыбы и рыбных продуктов', 573);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (614, '2703001', 'Технология сахаристых продуктов', 571);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (615, '2704003', 'Технология сахаристых продуктов', 573);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (616, '3112003', 'Технология сельскохозяйственного производства', 38);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (617, '2516003', 'Технология средств химической защиты', 371);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (618, '2705001', 'Технология субтропических и пищевкусовых продуктов', 571);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (619, '2706003', 'Технология субтропических и пищевкусовых продуктов', 573);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (620, '2803001', 'Технология ткани и трикотажа', 105);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (621, '2804003', 'Технология ткачества', 241);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (622, '2805003', 'Технология трикотажного производства', 241);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (623, '2603003', 'Технология химической переработки древесины', 117);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (624, '2703003', 'Технология хлеба, мучных кондитерских и макаронных изделий', 573);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (625, '2701001', 'Технология хранения и переработки зерна', 571);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (626, '2701003', 'Технология хранения и переработки зерна', 573);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (627, '2702003', 'Технология хранения и переработки растениеводческой продукции', 573);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (628, '1212003', 'Технология художественной обработки материалов', 139);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (629, '2808003', 'Технология швейных изделий', 241);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (630, '2503003', 'Технология электрохимических производств', 371);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (631, '2513003', 'Технология энергонасыщенных материалов и изделий', 371);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (632, '0315003', 'Тифлопедагогика', 53);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (633, '0616003', 'Товароведение и коммерческая экспертиза качества потребительских товаров', 100);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (634, '1804001', 'Транспортное электрооборудование', 480);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (635, '1505003', 'Транспортные комплексы ракетной техники', 31);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (636, '0712003', 'Триботехника', 76);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (637, '0309001', 'Труд', 122);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (638, '1014003', 'Турбостроение', 65);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (639, '2402001', 'Управление движением воздушного транспорта', 259);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (640, '2101003', 'Управление и информатика в технических системах', 14);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (641, '1810003', 'Управляющие, пилотажно-навигационные и электро-энергетические комплексы летательных аппаратов', 109);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (642, '2012001', 'Устройства идентификации и генерации радиосигналов', 67);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (643, '0406001', 'Фармация', 49);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (644, '0405003', 'Фармация', 188);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (645, '0104003', 'Физика', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (646, '0717003', 'Физика и техника оптической связи', 76);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (647, '0108003', 'Физика кинетических явлений', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (648, '0709003', 'Физика металлов', 76);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (649, '0704003', 'Физика пучков заряженных частиц и ускорительная техника', 76);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (650, '0106003', 'Физика твердого тела', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (651, '0708003', 'Физико-химические методы исследования процессов и материалов', 76);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (652, '0120003', 'Физиология', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (653, '0307001', 'Физическая культура', 122);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (654, '0223003', 'Физическая культура и спорт', 160);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (655, '0714003', 'Физическая электроника', 76);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (656, '0706003', 'Физические процессы горного и нефтегазового производства', 76);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (657, '0217003', 'Филология', 160);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (658, '0201003', 'Философия', 160);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (659, '0603001', 'Финансы (по отраслям)', 78);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (660, '0604003', 'Финансы и кредит', 100);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (661, '2305001', 'Фотодело', 175);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (662, '2505003', 'Химическая технология высокомолекулярных соединений', 371);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (663, '2807003', 'Химическая технология и оборудование отделочного производства', 241);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (664, '2510003', 'Химическая технология материалов и изделий электронной техники', 371);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (665, '2509003', 'Химическая технология материалов современной энергетики', 371);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (666, '2502001', 'Химическая технология неорганических веществ', 51);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (667, '2502003', 'Химическая технология неорганических веществ', 371);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (668, '2501003', 'Химическая технология органических веществ', 371);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (669, '2501001', 'Химическая технология органических веществ и высокомолекулярных соединений', 51);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (670, '2511003', 'Химическая технология органических соединений азота', 371);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (671, '2806001', 'Химическая технология отделочного производства', 105);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (672, '2512003', 'Химическая технология полимерных композиций, порохов и твердых ракетных топлив', 371);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (673, '2504003', 'Химическая технология природных энергоносителей и углеродных материалов', 371);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (674, '2517003', 'Химическая технология редких элементов и материалов на их основе', 371);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (675, '2515003', 'Химическая технология синтетических биологически активных веществ', 371);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (676, '2508003', 'Химическая технология тугоплавких неметаллических и силикатных материалов', 371);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (677, '2303001', 'Химическая чистка и крашение изделий', 175);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (678, '0110003', 'Химия', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (679, '2702001', 'Хлебопекарное, макаронное и кондитерское производство', 571);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (680, '0506001', 'Хореографическое искусство', 43);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (681, '0505003', 'Хореографическое искусство', 45);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (682, '0503001', 'Хоровое дирижирование', 43);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (683, '3108001', 'Хранение и переработка растениеводческой продукции', 36);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (684, '2813003', 'Художественное проектирование изделий текстильной и легкой промышленности', 241);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (685, '0508001', 'Цирковое искусство', 43);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (686, '0904003', 'Шахтное и подземное строительство', 98);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (687, '2809001', 'Швейное производство', 105);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (688, '3105003', 'Шелководство', 38);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (689, '0131003', 'Экология', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (690, '0303003', 'Экономика', 53);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (691, '0602003', 'Экономика и социология труда', 100);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (692, '0609003', 'Экономика и управление аграрным производством', 100);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (693, '0608003', 'Экономика и управление на предприятии (по отраслям)', 100);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (694, '0603003', 'Экономика природопользования', 100);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (695, '0601001', 'Экономика, бухгалтерский учет и контроль (по отраслям)', 78);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (696, '0609001', 'Экспертиза качества потребительских товаров', 78);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (697, '2408001', 'Эксплуатация внутренних водных путей', 259);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (698, '2403003', 'Эксплуатация воздушного транспорта и управление воздушным движением', 363);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (699, '1710001', 'Эксплуатация и ремонт оборудования предприятий торговли и общественного питания', 332);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (700, '1706001', 'Эксплуатация и ремонт подъемно-транспортных, строительных, дорожных машин и оборудования', 332);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (701, '2008001', 'Эксплуатация метеорологических радиотехнических систем', 67);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (702, '0906001', 'Эксплуатация нефтяных и газовых месторождений', 96);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (703, '2011001', 'Эксплуатация оборудования радиосвязи и электрорадионавигация судов', 67);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (704, '2409001', 'Эксплуатация судовых энергетических установок', 259);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (705, '2405003', 'Эксплуатация судовых энергетических установок', 363);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (706, '1807001', 'Эксплуатация электрооборудования и автоматики судов', 480);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (707, '3107001', 'Электрификация и автоматизация сельского хозяйства', 36);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (708, '3114003', 'Электрификация и автоматизация сельского хозяйства', 38);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (709, '1802003', 'Электрические и электронные аппараты', 109);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (710, '1801001', 'Электрические машины и аппараты', 480);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (711, '1001003', 'Электрические станции', 65);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (712, '1807003', 'Электрический транспорт', 109);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (713, '1802001', 'Электроизоляционная, кабельная и конденсаторная техника', 480);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (714, '1803003', 'Электроизоляционная, кабельная и конденсаторная техника', 109);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (715, '1801003', 'Электромеханика (по отраслям)', 109);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (716, '1911001', 'Электромеханические приборные устройства', 10);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (717, '2006003', 'Электроника и автоматика физических установок', 69);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (718, '2005003', 'Электронное машиностроение', 69);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (719, '2002001', 'Электронные приборы и устройства', 67);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (720, '2003003', 'Электронные приборы и устройства', 69);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (721, '1808003', 'Электрооборудование автомобилей и тракторов', 109);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (722, '1809003', 'Электрооборудование и автоматика судов', 109);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (723, '1811003', 'Электрооборудование летательных аппаратов', 109);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (724, '1001001', 'Электрооборудование электрических станций и подстанций', 63);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (725, '1804003', 'Электропривод и автоматика промышленных установок и технологических комплексов', 109);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (726, '1305003', 'Электроракетные двигатели и энергетические установки', 5);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (727, '1004001', 'Электроснабжение (по отраслям)', 63);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (728, '1004003', 'Электроснабжение (по отраслям)', 65);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (729, '3402001', 'Электротеплотехнические измерения', 171);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (730, '1805001', 'Электротехнические устройства', 480);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (731, '1805003', 'Электротехнологические установки и системы', 109);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (732, '2503001', 'Электрохимическое производство', 51);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (733, '1002003', 'Электроэнергетические системы и сети', 65);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (734, '1008003', 'Энергетика теплотехнологий', 65);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (735, '0211003', 'Юриспруденция', 160);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (736, '0107003', 'Ядерная физика', 55);
INSERT INTO SPECIALITY (ID, CODE, NAME, PARENT_ID) VALUES (737, '0705003', 'Ядерные реакторы и энергетические установки', 76);

INSERT INTO VACATION_AVERANGE_TYPE (ID, NAME, VACATION_MONTH) VALUES (1,'3 месяца', 3);
INSERT INTO VACATION_AVERANGE_TYPE (ID, NAME, VACATION_MONTH) VALUES (2,'12 месяцев', 12);


INSERT INTO VACATION_CALCULATE (ID, NAME) VALUES (1,'По шестидневке');
INSERT INTO VACATION_CALCULATE (ID, NAME) VALUES (2,'По календарным дням');


INSERT INTO VACATION_TYPE (ID, NAME) VALUES (1,'Отпуск очередной');
INSERT INTO VACATION_TYPE (ID, NAME) VALUES (2,'Отпуск за свой счёт');
INSERT INTO VACATION_TYPE (ID, NAME) VALUES (3,'Отпуск по уходу за ребёнком');
INSERT INTO VACATION_TYPE (ID, NAME) VALUES (4,'Отпуск учебный');


INSERT INTO PAYROLL_ALGORITM_TYPE (ID, NAME) VALUES (1,'сумма');
INSERT INTO PAYROLL_ALGORITM_TYPE (ID, NAME) VALUES (2,'%');
INSERT INTO PAYROLL_ALGORITM_TYPE (ID, NAME) VALUES (3,'авто');


INSERT INTO PAYROLL_FORM (ID, NAME) VALUES (1,'По днях');
INSERT INTO PAYROLL_FORM (ID, NAME) VALUES (2,'По часах');
INSERT INTO PAYROLL_FORM (ID, NAME) VALUES (3,'Сдельно');

INSERT INTO PAYROLL_MODE (ID, NAME) VALUES (1,'Не постоянный');
INSERT INTO PAYROLL_MODE (ID, NAME) VALUES (2,'Постоянный для одного');
INSERT INTO PAYROLL_MODE (ID, NAME) VALUES (3,'Постоянный для всех');

INSERT INTO PAYROLL_TYPE (ID, NAME) VALUES (1,'Начисление');
INSERT INTO PAYROLL_TYPE (ID, NAME) VALUES (2,'Удержание');
INSERT INTO PAYROLL_TYPE (ID, NAME) VALUES (3,'Другое');

INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 1,'1','Повременная - оклад',1,0,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 2,'2','Повременная - тариф',1,1,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 3,'3','Сдельная',1,1,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 4,'23','Ночные',1,2,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 5,'5','Праздничные',1,3,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 6,'4','Сверхурочные',1,4,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 7,'66','Больничные за счет предприятия',1,15,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 8,'9','Отпусткные текущего периода',1,5,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 9,'18','Отпусткные будущего периода',1,6,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 10,'42','Материальная помощь',1,1,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 11,'163','Подоходный налог',2,17,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 12,'202','Профсоюзные взносы',2,20,1,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 13,'103','Пенсионный фонд',2,19,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 14,'160','Фонд занятости',2,21,0.5,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 15,'161','Алименты',2,18,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 16,'101','Аванс',3,1,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 17,'105','Зарплата за 2 половину месяца',3,1,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 18,'17','Перерасчет подоходного налога (доначислено)',1,11,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 19,'162','Перерасчет подоходного налога (доудержано)',2,11,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 20,'6','Пособие по уходу в армию',1,1,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 21,'41','Премия 25%',1,7,25,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 23,'16','Больничные предыдущего периода',1,16,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 27,'106','Долг',2,11,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 28,'107','Кредит',2,11,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 30,'151','Удержание по перерасчету',2,11,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 31,'7','Доплата',1,1,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 33,'152','Выплаченные больничные',3,1,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 34,'153','Выплаченные отпускные',3,1,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 35,'21','Доплата за руководство бригадой',1,8,10,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 38,'25','Доплата за работы не связанные с основной деятельностью',1,9,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 39,'19','Материальная помощь облагаемая',1,1,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 43,'10','Компенсация за неиспользованный отпуск',1,1,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 44,'30','Подарки к торжеству',1,1,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 45,'130','Подарки выданные',3,1,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 46,'22','Больничные с прибыли',1,1,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 47,'154','Материальная выплаченная',3,1,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 48,'11','Повышенный тариф',1,11,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 49,'40','Премия из ФМП',1,1,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 50,'33','По трудовому соглашению',1,1,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 51,'174','Удержание за  брак',2,11,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 52,'108','Ссуда',2,12,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 53,'77','Совмещение должностей',1,10,0,1,1);
INSERT INTO PAYROLL (ID, CODE, NAME, PAYROLL_TYPE_ID, PRIORITY, PAYROLL_PERCENT, PAYROLL_MODE_ID, PAYROLL_ALGORITM_TYPE_ID) VALUES ( 54,'176','Вознаграждение по итогам года',1,13,0,1,1);


INSERT INTO SICK_TYPE (ID, NAME) VALUES (1,'Общее заболевание');
INSERT INTO SICK_TYPE (ID, NAME) VALUES (2,'Травма на производстве');
INSERT INTO SICK_TYPE (ID, NAME) VALUES (3,'По уходу до 3-х лет');
INSERT INTO SICK_TYPE (ID, NAME) VALUES (4,'По уходу до 7-ми лет');
INSERT INTO SICK_TYPE (ID, NAME) VALUES (5,'По уходу до 15-ти лет');
INSERT INTO SICK_TYPE (ID, NAME) VALUES (6,'По беременности и родам');
INSERT INTO SICK_TYPE (ID, NAME) VALUES (7,'Травма в быту');


INSERT INTO SICKLIST_AVERANGE_TYPE (ID, NAME, SICKLIST_MONTH) VALUES (1,'Расчитывать по текущему месяцу', 0);
INSERT INTO SICKLIST_AVERANGE_TYPE (ID, NAME, SICKLIST_MONTH) VALUES (2,'Расчитывать по 2-м предыдущим месяцам', 2);


INSERT INTO PROJECT_TYPE (ID, CODE, NAME, DESCRIPTION, IS_SYSTEM) VALUES (1, 'STANDARD', 'Стандартный проект', 'Стандартный проект', 'Y');
INSERT INTO PROJECT_TYPE (ID, CODE, NAME, DESCRIPTION, IS_SYSTEM) VALUES (2, 'SALE', 'Продажа', 'Обычная продажа', 'N');
INSERT INTO PROJECT_TYPE (ID, CODE, NAME, DESCRIPTION, IS_SYSTEM) VALUES (3, 'WORK', 'Работа с клиентом', 'Вербовка клиента', 'N');

INSERT INTO PROJECT_STATUS (ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (1, 'NOTSTARTED', 'Не начат', 'Y', 'N', 'Y');
INSERT INTO PROJECT_STATUS (ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (2, 'INPROGRESS', 'В процесе', 'N', 'N', 'Y');
INSERT INTO PROJECT_STATUS (ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (3, 'PLANE', 'В планах', 'N', 'N', 'Y');
INSERT INTO PROJECT_STATUS (ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (4, 'CANCELED', 'Отменён', 'N', 'Y', 'Y');
INSERT INTO PROJECT_STATUS (ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (5, 'COMPLETED', 'Выполнен', 'N', 'Y', 'Y');

INSERT INTO PROJECT_ROLE (ID, CODE, NAME) VALUES (1,'1','Клиент');
INSERT INTO PROJECT_ROLE (ID, CODE, NAME) VALUES (2,'2','Консультант');
INSERT INTO PROJECT_ROLE (ID, CODE, NAME) VALUES (3,'3','Исполнитель');

INSERT INTO PROJECT_STAGE_GROUP (ID, CODE, NAME, DESCRIPTION) VALUES (1,'1','Продажа','Продажа');
INSERT INTO PROJECT_STAGE_GROUP (ID, CODE, NAME, DESCRIPTION) VALUES (2,'2','Работа с клиентом','Работа с клиентом');

INSERT INTO PROJECT_STAGE (ID, PROJECT_TYPE_ID, PROJECT_STAGE_GROUP_ID, CODE, NAME, DESCRIPTION, ORDER_NUMBER, AVERANGE_DURATION, FROM_BEGIN) VALUES (1,1,1,'1','Оплата','Оплата',2,3,6);
INSERT INTO PROJECT_STAGE (ID, PROJECT_TYPE_ID, PROJECT_STAGE_GROUP_ID, CODE, NAME, DESCRIPTION, ORDER_NUMBER, AVERANGE_DURATION, FROM_BEGIN) VALUES (2,2,2,'2','Встреча','Встреча с клиенттом',1,1,1);

INSERT INTO TASK_TYPE (ID, CODE, NAME, IS_SYSTEM) VALUES (1,  'STANDARD', 'Стандартная задача', 'Y');
INSERT INTO TASK_TYPE (ID, CODE, NAME, IS_SYSTEM) VALUES (2,  'APPOINTMENT', 'Встреча', 'Y');
INSERT INTO TASK_TYPE (ID, CODE, NAME, IS_SYSTEM) VALUES (3,  'CALL', 'Звонок', 'Y');
INSERT INTO TASK_TYPE (ID, CODE, NAME, IS_SYSTEM) VALUES (4,  'INVESTIGATION', 'Исследовательская работа', 'Y');
INSERT INTO TASK_TYPE (ID, CODE, NAME, IS_SYSTEM) VALUES (5,  'CONSULTATION', 'Консультация', 'Y');
INSERT INTO TASK_TYPE (ID, CODE, NAME, IS_SYSTEM) VALUES (6,  'CONFERENCE','Переговоры', 'Y');
INSERT INTO TASK_TYPE (ID, CODE, NAME, IS_SYSTEM) VALUES (7,  'CONTRACT', 'Подготовка договора', 'Y');
INSERT INTO TASK_TYPE (ID, CODE, NAME, IS_SYSTEM) VALUES (8,  'DOCUMENTS', 'Подготовка документов', 'Y');
INSERT INTO TASK_TYPE (ID, CODE, NAME, IS_SYSTEM) VALUES (9,  'PRESENTATION', 'Презентация', 'Y');
INSERT INTO TASK_TYPE (ID, CODE, NAME, IS_SYSTEM) VALUES (10, 'TESTING', 'Тестирование', 'Y');

INSERT INTO TASK_STATUS (ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (1, 'NOTSTARTED', 'Не начата', 'Y', 'N', 'Y');
INSERT INTO TASK_STATUS (ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (2, 'INPROGRESS', 'В процессе', 'N', 'N', 'Y');
INSERT INTO TASK_STATUS (ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (3, 'CANCELED', 'Отменена', 'N', 'Y', 'Y');
INSERT INTO TASK_STATUS (ID, CODE, NAME, IS_START, IS_FINISH, IS_SYSTEM) VALUES (4, 'COMPLETED', 'Выполнена', 'N', 'Y', 'Y');

INSERT INTO TASK_ROLE (ID, CODE, NAME) VALUES (1,'1','Клиент');
INSERT INTO TASK_ROLE (ID, CODE, NAME) VALUES (2,'2','Консультант');
INSERT INTO TASK_ROLE (ID, CODE, NAME) VALUES (3,'3','Исполнитель');

INSERT INTO TASK_RESULT (ID, TASK_TYPE_ID, CODE, NAME) VALUES (1,1,'101','Перезвонить');
INSERT INTO TASK_RESULT (ID, TASK_TYPE_ID, CODE, NAME) VALUES (2,1,'102','Письмо-резюме');
INSERT INTO TASK_RESULT (ID, TASK_TYPE_ID, CODE, NAME) VALUES (3,1,'103','Повторная встреча');
INSERT INTO TASK_RESULT (ID, TASK_TYPE_ID, CODE, NAME) VALUES (4,2,'201','Интерес отсутствует');
INSERT INTO TASK_RESULT (ID, TASK_TYPE_ID, CODE, NAME) VALUES (5,2,'202','Коммерческое предложение');
INSERT INTO TASK_RESULT (ID, TASK_TYPE_ID, CODE, NAME) VALUES (6,2,'203','Ожидать встречный звонок');
INSERT INTO TASK_RESULT (ID, TASK_TYPE_ID, CODE, NAME) VALUES (7,2,'204','Переслать материалы');

INSERT INTO TASK_PRIORITY (ID, CODE, NAME, ORDER_NUMBER, IS_SYSTEM) VALUES (1, 'LOW', 'Низкий', 1, 'Y');
INSERT INTO TASK_PRIORITY (ID, CODE, NAME, ORDER_NUMBER, IS_SYSTEM) VALUES (2, 'NORMAL', 'Нормальный', 2, 'Y');
INSERT INTO TASK_PRIORITY (ID, CODE, NAME, ORDER_NUMBER, IS_SYSTEM) VALUES (3, 'HIGH', 'Высокий', 3, 'Y');

INSERT INTO PIM_APPOINTMENT_TYPE (ID, CODE, NAME, IS_SYSTEM) VALUES (1,  'APPOINTMENT', 'Встреча', 'Y');
INSERT INTO PIM_APPOINTMENT_TYPE (ID, CODE, NAME, IS_SYSTEM) VALUES (2,  'MEETING', 'Совещание', 'Y');


INSERT INTO PIM_APPOINTMENT_PRIORITY (ID, CODE, NAME, IS_SYSTEM) VALUES (1, 'LOW', 'Низкий', 'Y');
INSERT INTO PIM_APPOINTMENT_PRIORITY (ID, CODE, NAME, IS_SYSTEM) VALUES (2, 'NORMAL', 'Нормальный', 'Y');
INSERT INTO PIM_APPOINTMENT_PRIORITY (ID, CODE, NAME, IS_SYSTEM) VALUES (3, 'HIGH', 'Высокий', 'Y');

INSERT INTO INDUSTRY (ID, NAME) VALUES (1, 'Интернет-провайдеры');
INSERT INTO INDUSTRY (ID, NAME) VALUES (2, 'Строительство и проектирование');
INSERT INTO INDUSTRY (ID, NAME) VALUES (3, 'Инвестиции');
INSERT INTO INDUSTRY (ID, NAME) VALUES (4, 'Аграрная промышленность');
INSERT INTO INDUSTRY (ID, NAME) VALUES (5, 'Рекламное агенство');
INSERT INTO INDUSTRY (ID, NAME) VALUES (6, 'Аудиторские услуги');
INSERT INTO INDUSTRY (ID, NAME) VALUES (7, 'ИТ');
INSERT INTO INDUSTRY (ID, NAME) VALUES (8, 'Легкая промышленность');
INSERT INTO INDUSTRY (ID, NAME) VALUES (9, 'Образование');
INSERT INTO INDUSTRY (ID, NAME) VALUES (10, 'Тяжелая промышленность');


INSERT INTO PARTNER_GROUP (ID, NAME) VALUES (1,'Поставщики');
INSERT INTO PARTNER_GROUP (ID, NAME) VALUES (2,'Покупатели');
INSERT INTO PARTNER_GROUP (ID, NAME) VALUES (3,'Конкуренты');


INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (1,'0','Забалансовые счета',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (2,'00','Вспомогательный счет',3, 1);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (3,'02','Активы на ответственном хранении',1, 1);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (4,'021','Оборудование, принятое для монтажа',1, 3);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (5,'022','Материалы, принятые для переработки',1, 3);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (6,'0221','Материалы на складе',1, 5);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (7,'0222','Материалы, переданные в производство',1, 5);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (8,'023','Материальные ценности на ответственном хранении',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (9,'024','Товары, принятые на комиссию',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (10,'0241','Товары на складе',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (11,'0242','Товары, переданные на комиссию',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (12,'025','Имущество в доверительном управлении',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (13,'04','Непредвиденные активы и обязательства',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (14,'07','Списанные активы',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (15,'1','Необоротные активы',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (16,'10','Основные средства',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (17,'101','Земельные участки',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (18,'102','Капитальные затраты по улучшению земель',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (19,'103','Дома и сооружения',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (20,'104','Машины и оборудование',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (21,'105','Транспортные средства',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (22,'106','Инструменты приборы и инвентарь',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (23,'107','Рабочий и продуктивный скот',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (24,'108','Многолетние насаждения',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (25,'109','Другие основные средства',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (26,'1091','Основные средства предназначенные для продажи',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (27,'11','Другие необоротные материальные активы',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (28,'111','Библиотечные фонды',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (29,'112','Малоценные необоротные материальные активы',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (30,'113','Временные (нетитульные) сооружения',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (31,'114','Природные ресурсы',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (32,'115','Инвентарная тара',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (33,'116','Предметы проката',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (34,'117','Другие необоротные материальные активы',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (35,'12','Нематериальные активы',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (36,'121','Права на использование природных ресурсов',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (37,'122','Права на использование имущества',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (38,'123','Права на знаки для товаров и услуг',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (39,'124','Права на объекты промышленной собственности',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (40,'125','Авторские и смежные с ними права',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (41,'127','Другие нематериальные активы',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (42,'13','Износ (амортизация) необоротных активов',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (43,'131','Износ основных средств',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (44,'132','Износ других необоротных материальных активов',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (45,'133','Накопленная амортизация нематериальных активов',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (46,'14','Долгосрочные финансовые инвестиции',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (47,'141','Инвестиции связанным сторонам по методу учета участия в капитале',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (48,'142','Другие инвестиции связанным сторонам',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (49,'143','Инвестиции несвязанным сторонам',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (50,'15','Капитальные инвестиции',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (51,'151','Капитальное строительство',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (52,'152','Приобретение (изготовление) основных средств',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (53,'1521','Приобретение основных средств',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (54,'1522','Изготовление основных средств',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (55,'153','Приобретение (изготовление) других необоротных материальных активов',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (56,'1531','Приобретение других необоротных материальных активов',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (57,'1532','Изготовление других необоротных материальных активов',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (58,'154','Приобретение (изготовление) нематериальных активов',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (59,'155','Формирование основного стада',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (60,'16','Долгосрочная дебиторская задолженность',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (61,'161','Задолженность за имущество, переданное в финансовую аренду',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (62,'162','Долгосрочные векселя полученные',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (63,'163','Другая дебиторская задолженность',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (64,'17','Отсроченные налоговые активы',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (65,'18','Прочие необоротные активы',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (66,'19','Гудвил при приобретении',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (67,'191','Гудвил',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (68,'192','Негативный гудвил',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (69,'2','Запасы',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (70,'20','Производственные запасы',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (71,'201','Сырье и материалы',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (72,'202','Покупные полуфабрикаты и комплектующие изделия',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (73,'203','Топливо',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (74,'204','Тара и тарные материалы',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (75,'205','Строительные материалы',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (76,'206','Материалы, переданные в переработку',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (77,'207','Запасные части',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (78,'208','Материалы сельскохозяйственного назначения',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (79,'209','Другие материалы',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (80,'21','Животные на выращивании и откорме',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (81,'22','Малоценные и быстроизнашивающиеся предметы',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (82,'23','Производство',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (83,'231','Основное производство',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (84,'232','Вспомогательные производства',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (85,'233','Обслуживающие производства',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (86,'234','Давальческое производство',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (87,'24','Брак в производстве',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (88,'25','Полуфабрикаты',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (89,'26','Готовая продукция',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (90,'27','Продукция сельскохозяйственного производства',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (91,'28','Товары',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (92,'281','Товары на складе',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (93,'282','Товары в торговле',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (94,'283','Товары на комиссии',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (95,'284','Тара под товарами',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (96,'285','Торговая наценка',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (97,'3','Денежные средства, расчеты и другие активы',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (98,'30','Касса',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (99,'301','Касса в национальной валюте',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (100,'302','Касса в иностранной валюте',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (101,'309','Прочие денежные средства в кассе',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (102,'3091','Разменная монета в кассах ККМ',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (103,'31','Счета в банках',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (104,'311','Текущие счета в национальной валюте',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (105,'312','Текущие счета в иностранной валюте',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (106,'313','Другие счета в банке в национальной валюте',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (107,'314','Другие счета в банке в иностранной валюте',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (108,'33','Прочие денежные средства',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (109,'331','Денежные документы в национальной валюте',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (110,'332','Денежные документы в иностранной валюте',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (111,'333','Денежные средства в пути в национальной валюте',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (112,'334','Денежные средства в пути в иностранной валюте',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (113,'34','Краткосрочные векселя полученные',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (114,'341','Краткосрочные векселя, полученные в национальной валюте',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (115,'342','Краткосрочные векселя, полученные в иностранной валюте',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (116,'35','Текущие финансовые инвестиции',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (117,'351','Эквиваленты денежных средств',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (118,'3511','Эквиваленты денежных средств (в национальной валюте)',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (119,'3512','Эквиваленты денежных средств (в иностранной валюте)',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (120,'352','Прочие текущие финансовые инвестиции',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (121,'36','Расчеты с покупателями и заказчиками',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (122,'361','Расчеты с отечественными покупателями',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (123,'362','Расчеты с иностранными покупателями',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (124,'363','Расчеты с участниками ПФГ',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (125,'37','Расчеты с разными дебиторами',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (126,'371','Расчеты по выданным авансам',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (127,'3711','Расчеты по выданным авансам (в национальной валюте)',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (128,'3712','Расчеты по выданным авансам (в иностранной валюте)',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (129,'372','Расчеты с подотчетными лицами',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (130,'3721','Расчеты с подотчетными лицами в национальной валюте',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (131,'3722','Расчеты с подотчетными лицами в иностранной валюте',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (132,'373','Расчеты по начисленным доходам',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (133,'374','Расчеты по претензиям',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (134,'375','Расчеты по возмещению причиненного ущерба',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (135,'376','Расчеты по ссудам членам кредитных союзов',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (136,'377','Расчеты с другими дебиторами',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (137,'3771','Расчеты с другими дебиторами (в национальной валюте)',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (138,'3772','Расчеты с другими дебиторами (в иностранной валюте)',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (139,'3773','Расчеты с рабочими и служащими по другим операциям',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (140,'38','Резерв сомнительных долгов',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (141,'381','По задолженности за товары, услуги, работы',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (142,'382','По задолженности за расчеты с бюджетом',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (143,'383','По задолженности за расчеты по выданным авансам',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (144,'384','По задолженности за расчеты по начисленным доходам',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (145,'385','По задолженности за внутренние расчеты',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (146,'386','По прочей дебиторской задолженности',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (147,'39','Затраты будущих периодов',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (148,'4','Собственный капитал и обеспечение обязательств',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (149,'40','Уставный капитал',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (150,'41','Паевой капитал',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (151,'42','Дополнительный капитал',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (152,'421','Эмиссионный доход',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (153,'422','Другой вложенный капитал',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (154,'423','Дооценка активов',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (155,'424','Безвозмездно полученные НА',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (156,'425','Другой дополнительный капитал',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (157,'43','Резервный капитал',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (158,'44','Нераспределенная прибыль (непокрытые убытки)',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (159,'441','Нераспределенная прибыль',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (160,'442','Непокрытый убыток',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (161,'443','Прибыль, использованная в отчетном периоде',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (162,'45','Изъятый капитал',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (163,'451','Изъятые акции',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (164,'452','Изъятые вклады и паи',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (165,'453','Другой изъятый капитал',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (166,'46','Неоплаченный капитал',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (167,'47','Обеспечение будущих затрат и платежей',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (168,'471','Обеспечение выплат отпусков',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (169,'472','Дополнительное пенсионное обеспечение',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (170,'473','Обеспечение гарантийных обязательств',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (171,'474','Обеспечение прочих затрат и платежей',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (172,'48','Целевое финансирование и целевые поступления',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (173,'49','Страховые резервы',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (174,'5','Долгосрочные обязательства',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (175,'50','Долгосрочные займы',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (176,'501','Долгосрочные кредиты банков в национальной валюте',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (177,'502','Долгосрочные кредиты банков в иностранной валюте',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (178,'503','Отсроченные долгосрочные кредиты банков в национальной валюте',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (179,'504','Отсроченные долгосрочные кредиты банков в иностранной валюте',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (180,'505','Прочие долгосрочные займы в национальной валюте',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (181,'506','Прочие долгосрочные займы в иностранной валюте',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (182,'51','Долгосрочные векселя выданные',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (183,'511','Долгосрочные векселя, выданные в национальной валюте',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (184,'512','Долгосрочные векселя, выданные в иностранной валюте',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (185,'52','Долгосрочные обязательства по облигациям',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (186,'521','Обязательства по облигациям',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (187,'522','Премия по выпущенным облигациям',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (188,'523','Дисконт по выпущенным облигациям',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (189,'53','Долгосрочные обязательства по аренде',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (190,'531','Обязательства по финансовой аренде',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (191,'532','Обязательства по аренде целостных имущественных комплексов',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (192,'54','Отсроченные налоговые обязательства',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (193,'55','Прочие долгосрочные обязательства',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (194,'6','Текущие обязательства',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (195,'60','Краткосрочные займы',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (196,'601','Краткосрочные кредиты банков в национальной валюте',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (197,'602','Краткосрочные кредиты банков в иностранной валюте',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (198,'603','Отсроченные краткосрочные кредиты банков в национальной валюте',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (199,'604','Отсроченные краткосрочные кредиты банков в иностранной валюте',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (200,'605','Просроченные займы в национальной валюте',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (201,'606','Просроченные займы в иностранной валюте',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (202,'61','Текущая задолженность по долгосрочным обязательствам',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (203,'611','Текущая задолженность по долгосрочным обязательствам в национальной валюте',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (204,'612','Текущая задолженность по долгосрочным обязательствам в иностранной валюте',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (205,'62','Краткосрочные векселя выданные',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (206,'621','Краткосрочные векселя, выданные в национальной валюте',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (207,'622','Краткосрочные векселя, выданные в иностранной валюте',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (208,'63','Расчеты с поставщиками и подрядчиками',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (209,'631','Расчеты с отечественными поставщиками',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (210,'632','Расчеты с иностранными поставщиками',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (211,'633','Расчеты с участниками ПФГ',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (212,'64','Расчеты по налогам и платежам',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (213,'641','Расчеты по налогам',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (214,'6411','Расчеты по НДФЛ',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (215,'6412','Расчеты по НДС',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (216,'6413','Расчеты по налогу на прибыль',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (217,'6414','Расчеты по единому налогу',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (218,'6415','Расчеты по другим налогам',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (219,'6416','Расчеты по акцизу',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (220,'642','Расчеты по обязательным платежам',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (221,'643','Налоговые обязательства',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (222,'6431','Налоговые обязательства',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (223,'6432','Налоговые обязательства неподтвержденные',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (224,'6433','Корректировки налоговых обязательств',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (225,'644','Налоговый кредит',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (226,'6441','Налоговый кредит',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (227,'6442','Налоговый кредит неподтвержденный',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (228,'6443','Корректировки налогового кредита',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (229,'65','Расчеты по страхованию',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (230,'651','Расчеты по пенсионному обеспечению',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (231,'652','Расчеты по социальному страхованию',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (232,'653','Расчеты по страхованию на случай безработицы',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (233,'654','Расчеты по индивидуальному страхованию',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (234,'655','Расчеты по страхованию имущества',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (235,'656','Расчеты по страхованию от несчастных случаев',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (236,'66','Расчеты по оплате труда',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (237,'661','Расчеты по заработной плате',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (238,'662','Расчеты по депонентам',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (239,'67','Расчеты с участниками',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (240,'671','Расчеты по начисленным дивидендам',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (241,'672','Расчеты по другим выплатам участникам',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (242,'68','Расчеты по другим операциям',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (243,'681','Расчеты по авансам полученным',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (244,'6811','Расчеты по авансам полученным (в национальной валюте)',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (245,'6812','Расчеты по авансам полученным (в иностранной валюте)',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (246,'682','Внутренние расчеты',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (247,'683','Внутрихозяйственные расчеты',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (248,'684','Расчеты по начисленным процентам',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (249,'685','Расчеты с другими кредиторами',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (250,'6851','Расчеты с другими кредиторами (в национальной валюте)',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (251,'6852','Расчеты с другими кредиторами (в иностранной валюте)',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (252,'6853','Расчеты по исполнительным документам',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (253,'69','Доходы будущих периодов',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (254,'7','Доходы и результаты деятельности',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (255,'70','Доходы от реализации',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (256,'701','Доход от реализации готовой продукции',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (257,'702','Доход от реализации товаров',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (258,'703','Доход от реализации работ и услуг',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (259,'704','Вычеты из дохода',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (260,'705','Перестрахование',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (261,'709','Доход от розничных продаж',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (262,'71','Другой операционный доход',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (263,'711','Доход от реализации иностранной валюты',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (264,'712','Доход от реализации других оборотных активов',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (265,'713','Доход от операционной аренды активов',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (266,'714','Доход от операционной курсовой разницы',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (267,'715','Полученные штрафы пени неустойки',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (268,'716','Возмещение ранее списанных активов',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (269,'717','Доход от списания кредиторской задолженности',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (270,'718','Доход от безвозмездно полученных оборотных активов',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (271,'719','Другие доходы от операционной деятельности',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (272,'72','Доход от участия в капитале',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (273,'721','Доход от инвестиций в ассоциированные предприятия',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (274,'722','Доход от совместной деятельности',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (275,'723','Доход от инвестиций в дочерние предприятия',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (276,'73','Прочие финансовые доходы',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (277,'731','Дивиденды полученные',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (278,'732','Проценты полученные',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (279,'733','Прочие доходы от финансовых операций',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (280,'74','Другие доходы',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (281,'741','Доход от реализации финансовых инвестиций',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (282,'742','Доход от реализации необоротных активов',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (283,'743','Доход от реализации имущественных комплексов',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (284,'744','Доход от неоперационной курсовой разницы',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (285,'745','Доход от безплатно полученных активов',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (286,'746','Другие доходы от обычной деятельности',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (287,'75','Чрезвычайные доходы',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (288,'751','Возмещение ущерба от чрезвычайных событий',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (289,'752','Прочие чрезвычайные доходы',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (290,'76','Страховые платежи',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (291,'79','Финансовые результаты',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (292,'791','Результат операционной деятельности',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (293,'792','Результат финансовых операций',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (294,'793','Результат другой обычной деятельности',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (295,'794','Результат чрезвычайных событий',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (296,'8','Затраты по элементам',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (297,'80','Материальные затраты',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (298,'801','Затраты сырья и материалов',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (299,'802','Затраты покупных полуфабрикатов и комплектующих изделий',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (300,'803','Затраты топлива и энергии',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (301,'804','Затраты тары и тарных материалов',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (302,'805','Затраты строительных материалов',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (303,'806','Затраты запасных частей',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (304,'807','Затраты материалов сельскохозяйственного назначения',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (305,'808','Затраты товаров',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (306,'809','Другие материальные затраты',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (307,'81','Затраты на оплату труда',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (308,'811','Выплаты по окладам и тарифам',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (309,'812','Премии и поощрения',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (310,'813','Компенсационные выплаты',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (311,'814','Оплата отпусков',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (312,'815','Оплата другого неотработанного времени',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (313,'816','Другие затраты на оплату труда',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (314,'82','Отчисления на социальные мероприятия',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (315,'821','Отчисления на пенсионное обеспечение',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (316,'822','Отчисления на социальное страхование',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (317,'823','Страхование на случай безработицы',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (318,'824','Отчисления на индивидуальное страхование',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (319,'83','Амортизация',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (320,'831','Амортизация основных средств',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (321,'832','Амортизация других необоротных материальных активов',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (322,'833','Амортизация нематериальных активов',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (323,'84','Другие операционные затраты',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (324,'85','Другие затраты',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (325,'851','Другие затраты по элементам, налог на прибыль',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (326,'852','Другие затраты по элементам, чрезвычайные затраты',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (327,'9','Затраты деятельности',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (328,'90','Себестоимость реализации',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (329,'901','Себестоимость реализованной готовой продукции',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (330,'902','Себестоимость реализованных товаров',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (331,'903','Себестоимость реализованных работ и услуг',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (332,'904','Страховые выплаты',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (333,'91','Общепроизводственные затраты',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (334,'92','Административные затраты',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (335,'93','Затраты на сбыт',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (336,'94','Другие затраты операционной деятельности',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (337,'941','Затраты на исследования и разработки',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (338,'942','Себестоимость реализованной иностранной валюты',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (339,'943','Себестоимость реализованных производственных запасов',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (340,'944','Сомнительные и безнадежные долги',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (341,'945','Затраты от операционной курсовой разницы',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (342,'946','Затраты от обесценивания запасов',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (343,'947','Недостачи и потери от порчи ценностей',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (344,'948','Признанные штрафы, пени, неустойки',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (345,'949','Другие затраты операционной деятельности',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (346,'95','Финансовые затраты',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (347,'951','Проценты за кредит',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (348,'952','Другие финансовые затраты',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (349,'96','Потери от участия в капитале',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (350,'961','Потери от инвестиций в ассоциированные предприятия',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (351,'962','Потери от совместной деятельности',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (352,'963','Потери от инвестиций в дочерние предприятия',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (353,'97','Другие затраты',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (354,'971','Себестоимость реализованных финансовых инвестиций',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (355,'972','Себестоимость реализованных необоротных активов',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (356,'973','Себестоимость реализованных имущественных комплексов',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (357,'974','Потери от неоперационных курсовых разниц',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (358,'975','Уценка необоротных активов и финансовых инвестиций',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (359,'976','Списание необоротных активов',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (360,'977','Другие затраты обычной деятельности',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (361,'98','Налог на прибыль',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (362,'981','Налог на прибыль от обычной деятельности',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (363,'982','Налог на прибыль от чрезвычайных событий',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (364,'99','Чрезвычайные затраты',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (365,'991','Потери от стихийного бедствия',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (366,'992','Потери от техногенных катастроф и аварий',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (367,'993','Другие чрезвычайные затраты',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (368,'01','Арендованные необоротные активы',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (369,'03','Контрактные обязательства',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (370,'041','Непредвиденные активы',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (371,'042','Непредвиденные обязательства',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (372,'05','Гарантии и обеспечение предоставленные',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (373,'06','Гарантии и обеспечение полученные',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (374,'071','Списанная дебиторская задолженность',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (375,'072','Невозмещенные недостачи и потери от порчи ценностей',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (376,'08','Бланки строгого учета',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (377,'09','Амортизационные отчисления',3, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (378,'РВК','Временные разницы по взаиморасчетам с покупателями',2, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (379,'РВП','Временные разницы по взаиморасчетам с поставщиками',1, NULL);
INSERT INTO LEDGER_ACCOUNT (ID, CODE, NAME, LEDGER_ACCOUNT_TYPE_ID, PARENT_ID) VALUES (380,'РВ','Временные разницы',3, NULL);


INSERT INTO TEMPLATE_ENTRY (ID, FINANCE_DOCUMENT_TYPE_ID, CODE, NAME) VALUES (1, 2, '001', 'Приход товара');
INSERT INTO TEMPLATE_ENTRY (ID, FINANCE_DOCUMENT_TYPE_ID, CODE, NAME) VALUES (2, 3, '002', 'Расход товара');



INSERT INTO TEMPLATE_ENTRY_ITEM (ID, DEBIT_LEDACC_ID, CREDIT_LEDACC_ID, TEMPLATE_ENTRY_ID, DEBIT_LEDACC_EXP, CREDIT_LEDACC_EXP, AMOUNT_EXP, DEBIT_OBJECT_EXP, CREDIT_OBJECT_EXP, CONTENT) VALUES (1, 92, 209, 1, '281', '631', 'Doc.Amount', 'Doc.Warehouse', 'Doc.Partner', 'Оприходование ТМЦ');
INSERT INTO TEMPLATE_ENTRY_ITEM (ID, DEBIT_LEDACC_ID, CREDIT_LEDACC_ID, TEMPLATE_ENTRY_ID, DEBIT_LEDACC_EXP, CREDIT_LEDACC_EXP, AMOUNT_EXP, DEBIT_OBJECT_EXP, CREDIT_OBJECT_EXP, CONTENT) VALUES (2, 225, 209, 1, '644', '631', 'Doc.TaxAmount', 'Doc.Partner', 'Doc.Partner', 'Отражение расчётов по налоговому кредиту (НДС)');
INSERT INTO TEMPLATE_ENTRY_ITEM (ID, DEBIT_LEDACC_ID, CREDIT_LEDACC_ID, TEMPLATE_ENTRY_ID, DEBIT_LEDACC_EXP, CREDIT_LEDACC_EXP, AMOUNT_EXP, DEBIT_OBJECT_EXP, CREDIT_OBJECT_EXP, CONTENT) VALUES (3, 122, 257, 2, '361', '702', 'Doc.AmountWithTax', 'Doc.Partner', '', 'Отгрузка товара покупателю');
INSERT INTO TEMPLATE_ENTRY_ITEM (ID, DEBIT_LEDACC_ID, CREDIT_LEDACC_ID, TEMPLATE_ENTRY_ID, DEBIT_LEDACC_EXP, CREDIT_LEDACC_EXP, AMOUNT_EXP, DEBIT_OBJECT_EXP, CREDIT_OBJECT_EXP, CONTENT) VALUES (4, 257, 221, 2, '702', '643', 'Doc.TaxAmount', '', 'Doc.Partner', 'Отражение расчётов по налоговым обязательствам (НДС)');
INSERT INTO TEMPLATE_ENTRY_ITEM (ID, DEBIT_LEDACC_ID, CREDIT_LEDACC_ID, TEMPLATE_ENTRY_ID, DEBIT_LEDACC_EXP, CREDIT_LEDACC_EXP, AMOUNT_EXP, DEBIT_OBJECT_EXP, CREDIT_OBJECT_EXP, CONTENT) VALUES (5, 330, 92, 2, '902', '281', 'Doc.Amount', '', 'Doc.Warehouse', 'Списание себестоимости реализованых товаров');




/*==============================================================*/
/* Firebird                                                     */
/* http://www.firebirdsql.org                                   */
/*==============================================================*/

INSERT INTO REGION (ID, COUNTRY_ID, NAME) VALUES (1, 191, 'Московская');
INSERT INTO REGION (ID, COUNTRY_ID, NAME) VALUES (2, 229, 'Киевская');
INSERT INTO REGION (ID, COUNTRY_ID, NAME) VALUES (3, 229, 'Харьковская');
INSERT INTO REGION (ID, COUNTRY_ID, NAME) VALUES (4, 36, 'Минская');



INSERT INTO LOCALITY (ID, NAME, LOCALITY_TYPE_ID, COUNTRY_ID) VALUES (1, 'Москва', 1, 191);
INSERT INTO LOCALITY (ID, NAME, LOCALITY_TYPE_ID, COUNTRY_ID) VALUES (2, 'Санкт-Петербург', 1, 191);
INSERT INTO LOCALITY (ID, NAME, LOCALITY_TYPE_ID, COUNTRY_ID) VALUES (3, 'Самара', 1, 191);
INSERT INTO LOCALITY (ID, NAME, LOCALITY_TYPE_ID, COUNTRY_ID) VALUES (4, 'Тюмень', 1, 191);
INSERT INTO LOCALITY (ID, NAME, LOCALITY_TYPE_ID, COUNTRY_ID) VALUES (5, 'Киев', 1, 229);
INSERT INTO LOCALITY (ID, NAME, LOCALITY_TYPE_ID, COUNTRY_ID) VALUES (6, 'Харьков', 1, 229);
INSERT INTO LOCALITY (ID, NAME, LOCALITY_TYPE_ID, COUNTRY_ID) VALUES (7, 'Днепропетровск', 1, 229);
INSERT INTO LOCALITY (ID, NAME, LOCALITY_TYPE_ID, COUNTRY_ID) VALUES (8, 'Минск', 1, 36);

INSERT INTO CITY (ID) VALUES (1);
INSERT INTO CITY (ID) VALUES (2);
INSERT INTO CITY (ID) VALUES (3);
INSERT INTO CITY (ID) VALUES (4);
INSERT INTO CITY (ID) VALUES (5);
INSERT INTO CITY (ID) VALUES (6);
INSERT INTO CITY (ID) VALUES (7);
INSERT INTO CITY (ID) VALUES (8);


INSERT INTO PRODUCT_GROUP (ID, PRODUCT_SECTION_ID, PARENT_ID, CODE, NAME) VALUES (1, 1, NULL, '1000', 'Товар');
INSERT INTO PRODUCT_GROUP (ID, PRODUCT_SECTION_ID, PARENT_ID, CODE, NAME) VALUES (2, 1, NULL, '2000', 'Услуги');



INSERT INTO PAYMENT_TYPE (ID, NAME) VALUES (1,'Электронно');
INSERT INTO PAYMENT_TYPE (ID, NAME) VALUES (2,'Почтой');
INSERT INTO PAYMENT_TYPE (ID, NAME) VALUES (3,'Телеграфом');

INSERT INTO TAXPRINT_TYPE (ID, NAME) VALUES (1,'Указывать в тексте сумму и НДС');
INSERT INTO TAXPRINT_TYPE (ID, NAME) VALUES (2,'Указывать в тексте только НДС');
INSERT INTO TAXPRINT_TYPE (ID, NAME) VALUES (3,'Указывать в тексте только сумму');
INSERT INTO TAXPRINT_TYPE (ID, NAME) VALUES (4,'не указывать в тексте сумму и НДС');

