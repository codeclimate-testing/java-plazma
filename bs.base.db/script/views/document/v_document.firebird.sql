
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



