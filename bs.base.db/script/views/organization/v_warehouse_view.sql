


CREATE VIEW V_WAREHOUSE_VIEW (
  ID,
  OWNER_ID,
  ENTITY_ID,
  ENTITY_CODE,
  ENTITY_NAME,
  NAME
) AS

SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, B.NAME
 FROM BUSINESSABLE B
 INNER JOIN WAREHOUSE S ON S.ID = B.OWNER_ID
 /* INNER JOIN SYS_ENTITY E ON E.ID = B.ENTITY_ID
 INNER JOIN WAREHOUSE_ENTITY SE ON SE.ENTITY_ID = B.ENTITY_ID*/



