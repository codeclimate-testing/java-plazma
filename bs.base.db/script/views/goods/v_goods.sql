
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





