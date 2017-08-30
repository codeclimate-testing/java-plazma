
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