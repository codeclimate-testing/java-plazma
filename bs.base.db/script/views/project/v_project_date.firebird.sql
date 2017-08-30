
/*                                                        */
/*   FIREBIRD IMPLEMENTATION                              */
/*                                                        */
/*   USE FUNCTION EXTRACT():                              */
/*                                                        */
/*   EXTRACT (YEAR FROM DATE)                             */
/*   EXTRACT (MONTH FROM DATE)                            */
/*                                                        */
/*   FIREBIRD DOESN'T HAVE FUNCTIONS YEAR() AND MONTH()   */
/*                                                        */


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
  EXTRACT (YEAR FROM P.START_DATE),
  EXTRACT (YEAR FROM P.END_DATE),
  EXTRACT (YEAR FROM P.ACTUAL_END_DATE),
  EXTRACT (MONTH FROM P.START_DATE),
  EXTRACT (MONTH FROM P.END_DATE),
  EXTRACT (MONTH FROM P.ACTUAL_END_DATE),
  EXTRACT (DAY FROM P.START_DATE),
  EXTRACT (DAY FROM P.END_DATE),
  EXTRACT (DAY FROM P.ACTUAL_END_DATE)
FROM PROJECT P;
