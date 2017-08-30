
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