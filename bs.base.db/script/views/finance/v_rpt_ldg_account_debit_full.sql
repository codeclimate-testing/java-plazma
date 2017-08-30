
CREATE VIEW V_RPT_LDG_ACCOUNT_DEBIT_FULL (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_NO,
  DOCUMENT_DATE,
  LEDGER_ACCOUNT_ID,
  CORR_LEDGER_ACCOUNT_ID,
  AMOUNT
) AS
SELECT 
  FD.PERIOD_ID,
  FD.ORGANIZATION_ID,
  FD.DOCUMENT_NO,
  FD.DOCUMENT_DATE,
  I.CREDIT_LEDGER_ACCOUNT_ID,
  I.DEBIT_LEDGER_ACCOUNT_ID,
  I.AMOUNT
 FROM V_FINANCE_DOCUMENT FD
 INNER JOIN ENTRY_ITEM I ON I.OWNER_ID = FD.ID;

