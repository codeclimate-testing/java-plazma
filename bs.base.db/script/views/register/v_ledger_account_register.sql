
CREATE VIEW V_LEDGER_ACCOUNT_REGISTER (
 ID,
 ORGANIZATION_ID,
 PERIOD_ID,
 LEDGER_ACCOUNT_ID,
 DEBIT_AMOUNT,
 CREDIT_AMOUNT
) AS 
SELECT 
 R.ID,
 R.ORGANIZATION_ID,
 R.PERIOD_ID,
 R.LEDGER_ACCOUNT_ID,
 R.DEBIT_AMOUNT,
 R.CREDIT_AMOUNT
 FROM LEDGER_ACCOUNT_REGISTER R;
