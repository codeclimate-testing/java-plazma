
/*                                     */
/*   HSQL IMPLEMENTATION               */
/*                                     */
/*   USE FUNCTIONS YEAR() AND MONTH(): */
/*                                     */
/*   YEAR(DOCUMENT_DATE),              */
/*   MONTH(DOCUMENT_DATE)              */
/*                                     */


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
  YEAR(P.START_DATE),
  YEAR(P.END_DATE),
  YEAR(P.ACTUAL_END_DATE),
  MONTH(P.START_DATE),
  MONTH(P.END_DATE),
  MONTH(P.ACTUAL_END_DATE),
  DAY(P.START_DATE),
  DAY(P.END_DATE),
  DAY(P.ACTUAL_END_DATE)
FROM PROJECT P;
