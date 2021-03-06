
/* SALES BY MONTHES (JAN - DEC) */

CREATE VIEW V_RPT_GOODS_SALE_YEAR (
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
) AS
SELECT
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
FROM V_RPT_GOODS_SALE_YEAR_PRODUCT;

