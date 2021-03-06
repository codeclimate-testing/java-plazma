
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
