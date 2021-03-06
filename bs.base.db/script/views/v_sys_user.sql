
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

