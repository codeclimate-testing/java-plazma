
CREATE VIEW V_PAYMENT_INCOME (
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
    USER_ID,
    USER_NAME,
    CONTRACT_ID,
    REASON_DOCUMENT_ID,
    REASON,
    NOTE,
    CURRENCY_ID,
    AMOUNT_WITH_TAX,
    TAX_AMOUNT,
    AMOUNT,
    CURRENCY_AMOUNT_WITH_TAX,
    CURRENCY_TAX_AMOUNT,
    CURRENCY_AMOUNT,
    TOTAL,
    TOTAL_WITH_TAX,
    TAX_TOTAL,
    CURRENCY_TOTAL,
    CURRENCY_TOTAL_WITH_TAX,
    CURRENCY_TAX_TOTAL,
    DOCUMENT_AMOUNT,
    DOCUMENT_TOTAL,
    CURRENCY_DOCUMENT_AMOUNT,
    CURRENCY_DOCUMENT_TOTAL,
    PARTNER_BANK_ACCOUNT_ID,
    PARTNER_BANK_ACCOUNT_NO,
    PARTNER_BANK_BIC,
    PARTNER_BANK_NAME,
    PARTNER_BANK_CITY_NAME,
    ORGANIZATION_BANK_ACCOUNT_ID,
    ORGANIZATION_BANK_ACCOUNT_NO,
    ORGANIZATION_BANK_BIC,
    ORGANIZATION_BANK_NAME,
    ORGANIZATION_BANK_CITY_NAME,
    PARTNER_ID,
    PARTNER_NAME,
    PARTNER_CODE,
    PARTNER_NEC,
    PARTNER_IDN,
    PARTNER_TYPE_ID,
    RESPONSIBLE_ID,
    PAYMENT_MISSING,
    TAXPRINT_TYPE_ID
) AS
SELECT
  PAY.ID,
  FD.ORGANIZATION_ID,
  FD.ORGANIZATION_NAME,
  FD.ORGANIZATION_CODE,
  FD.ORGANIZATION_NEC,
  FD.ORGANIZATION_IDN,
  FD.ORGANIZATION_TYPE_ID,
  FD.DOCUMENT_TYPE_ID, 
  FD.DOCUMENT_TYPE_CODE,
  FD.DOCUMENT_TYPE_NAME,
  FD.PERIOD_ID,
  FD.DOCUMENT_NO, 
  FD.DOCUMENT_DATE,
  FD.USER_ID,
  FD.USER_NAME,
  FD.CONTRACT_ID,
  FD.REASON_DOCUMENT_ID,
  FD.REASON,
  FD.NOTE,
  FD.CURRENCY_ID,
  FD.AMOUNT_WITH_TAX,
  FD.TAX_AMOUNT, 
  FD.AMOUNT,
  FD.CURRENCY_AMOUNT_WITH_TAX,
  FD.CURRENCY_TAX_AMOUNT,
  FD.CURRENCY_AMOUNT,
  FD.TOTAL,
  FD.TOTAL_WITH_TAX,
  FD.TAX_TOTAL,
  FD.CURRENCY_TOTAL,
  FD.CURRENCY_TOTAL_WITH_TAX,
  FD.CURRENCY_TAX_TOTAL,
  FD.DOCUMENT_AMOUNT,
  FD.DOCUMENT_TOTAL,
  FD.CURRENCY_DOCUMENT_AMOUNT,
  FD.CURRENCY_DOCUMENT_TOTAL,
  PAY.PARTNER_BANK_ACCOUNT_ID,
  PRT_BA.ACCOUNT_NO AS PARTNER_BANK_ACCOUNT_NO,
  PRT_BK.BIC AS PARTNER_BANK_BIC,
  PRT_BK.NAME AS PARTNER_BANK_NAME,
  PRT_BK.CITY_NAME AS PARTNER_BANK_CITY_NAME,
  PAY.ORGANIZATION_BANK_ACCOUNT_ID,
  ORG_BA.ACCOUNT_NO AS ORGANIZATION_BANK_ACCOUNT_NO,
  ORG_BK.BIC AS ORGANIZATION_BANK_BIC,
  ORG_BK.NAME AS ORGANIZATION_BANK_NAME,
  ORG_BK.CITY_NAME AS ORGANIZATION_BANK_CITY_NAME,
  FD.PARTNER_ID,
  PRT.NAME AS PARTNER_NAME,
  PRT.CODE AS PARTNER_CODE,
  PRT.NEC AS PARTNER_NEC,
  PRT.IDN AS PARTNER_IDN,
  PRT.PARTNER_TYPE_ID AS PARTNER_TYPE_ID,
  FD.RESPONSIBLE_ID,
  PAY.PAYMENT_MISSING,
  PAY.TAXPRINT_TYPE_ID
 FROM PAYMENT_INCOME PAY
 INNER JOIN V_FINANCE_DOCUMENT FD ON FD.ID = PAY.ID
 INNER JOIN ORGANIZATION ORG ON ORG.ID= FD.ORGANIZATION_ID
 INNER JOIN BANK_ACCOUNT ORG_BA ON ORG_BA.ID = PAY.ORGANIZATION_BANK_ACCOUNT_ID
 INNER JOIN V_BANK ORG_BK ON ORG_BK.ID = ORG_BA.BANK_ID
 INNER JOIN BANK_ACCOUNT PRT_BA ON PRT_BA.ID = PAY.PARTNER_BANK_ACCOUNT_ID
 INNER JOIN V_BANK PRT_BK ON PRT_BK.ID = PRT_BA.BANK_ID
 INNER JOIN PARTNER PRT ON PRT.ID = FD.PARTNER_ID;
 