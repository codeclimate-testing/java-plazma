
CREATE VIEW V_RPT_LDG_ACCOUNT_REST_START (
  PERIOD_ID,
  ORGANIZATION_ID,
  LEDGER_ACCOUNT_ID,
  LEDGER_ACCOUNT_CODE,
  LEDGER_ACCOUNT_NAME,
  CREDIT_AMOUNT,
  DEBIT_AMOUNT
) AS
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.LEDGER_ACCOUNT_ID,
  R.LEDGER_ACCOUNT_CODE,
  R.LEDGER_ACCOUNT_NAME,
  R.CREDIT_AMOUNT,
  R.DEBIT_AMOUNT
 FROM V_RPT_LDG_ACCOUNT_REGISTER R
UNION ALL
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.LEDGER_ACCOUNT_ID,
  R.LEDGER_ACCOUNT_CODE,
  R.LEDGER_ACCOUNT_NAME,
  R.CREDIT_AMOUNT,
  R.DEBIT_AMOUNT
 FROM V_RPT_LDG_ACCOUNT_REST R;
