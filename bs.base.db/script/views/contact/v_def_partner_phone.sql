
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