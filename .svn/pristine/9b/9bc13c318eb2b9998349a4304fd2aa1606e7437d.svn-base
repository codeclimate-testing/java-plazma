
/*                                                       */
/*   POSTGRESQL IMPLEMENTATION                           */
/*                                                       */
/*   USE FUNCTIONS:                                      */
/*                                                       */
/*   TO_NUMBER(TO_CHAR(DOCUMENT_DATE, 'YYYY'), '9999')   */
/*   TO_NUMBER(TO_CHAR(DOCUMENT_DATE, 'MM'), '99')       */
/*                                                       */


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
  TO_NUMBER(TO_CHAR(P.START_DATE, 'YYYY'), '9999'),
  TO_NUMBER(TO_CHAR(P.END_DATE, 'YYYY'), '9999'),
  TO_NUMBER(TO_CHAR(P.ACTUAL_END_DATE, 'YYYY'), '9999'),
  TO_NUMBER(TO_CHAR(P.START_DATE, 'MM'), '99'),
  TO_NUMBER(TO_CHAR(P.END_DATE, 'MM'), '99'),
  TO_NUMBER(TO_CHAR(P.ACTUAL_END_DATE, 'MM'), '99'),
  TO_NUMBER(TO_CHAR(P.START_DATE, 'DD'), '99'),
  TO_NUMBER(TO_CHAR(P.END_DATE, 'DD'), '99'),
  TO_NUMBER(TO_CHAR(P.ACTUAL_END_DATE, 'DD'), '99')
FROM PROJECT P;
