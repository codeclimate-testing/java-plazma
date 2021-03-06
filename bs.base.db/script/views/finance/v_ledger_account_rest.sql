
CREATE VIEW V_LEDGER_ACCOUNT_REST (
 ID,
 PERIOD_ID,
 ORGANIZATION_ID,
 LEDGER_ACCOUNT_ID,
 DEBIT_AMOUNT,
 CREDIT_AMOUNT
) AS
SELECT
 ID,
 PERIOD_ID,
 ORGANIZATION_ID,
 LEDGER_ACCOUNT_ID,
 DEBIT_AMOUNT,
 CREDIT_AMOUNT
FROM
 LEDGER_ACCOUNT_REST;
