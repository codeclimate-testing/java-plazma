drop view V_PROJECT_PERIOD_DAY;
drop view V_PROJECT_YEAR_UNIQUE_INF;
drop view V_PROJECT_YEAR_UNIQUE;
drop view V_PROJECT_DATE_EXT;
drop view V_PROJECT_DATE;
drop view V_RPT_LDG_ACCOUNT_CORR;
drop view V_RPT_LDG_ACCOUNT_ALL;
drop view V_RPT_LDG_ACCOUNT_ROTATE;
drop view V_RPT_LDG_ACCOUNT_DEBIT_FULL;
drop view V_RPT_LDG_ACCOUNT_CREDIT_FULL;
drop view V_RPT_LDG_ACCOUNT_REST_START;
drop view V_RPT_LDG_ACCOUNT_REGISTER;
drop view V_RPT_LDG_ACCOUNT_REST;
drop view V_LEDGER_ACCOUNT_REGISTER;
drop view V_LEDGER_ACCOUNT_REST;
drop view V_EMPLOYEE_RESULT;
drop view V_RPT_PARTNER_ROTATE;
drop view V_RPT_PARTNER_DEBIT_FULL;
drop view V_RPT_PARTNER_CREDIT_FULL;
drop view V_RPT_PARTNER_REST_START;
drop view V_RPT_PARTNER_REST;
drop view V_RPT_PARTNER_REGISTER;
drop view V_PARTNER_REST;
drop view V_RPT_GOODS_ROTATE;
drop view V_RPT_GOODS_DEBIT_FULL;
drop view V_RPT_GOODS_CREDIT_FULL;
drop view V_RPT_WRH_GOODS_REST_START;
drop view V_RPT_GOODS_REST_START;
drop view V_GOODS_DEBIT_FULL;
drop view V_GOODS_CREDIT_FULL;
drop view V_RPT_WRH_GOODS_REGISTER;


/*
drop view v_rpt_goods_sale_year;
drop view v_rpt_goods_sale_year_product;
*/

/* ============================================================= */
/*
 Drop Firebird procedures
*/

drop procedure v_rpt_goods_sale_year;
drop procedure v_rpt_goods_sale_year_product;

drop procedure v_rpt_goods_sale_month_01;
drop procedure v_rpt_goods_sale_month_02;
drop procedure v_rpt_goods_sale_month_03;
drop procedure v_rpt_goods_sale_month_04;
drop procedure v_rpt_goods_sale_month_05;
drop procedure v_rpt_goods_sale_month_06;
drop procedure v_rpt_goods_sale_month_07;
drop procedure v_rpt_goods_sale_month_08;
drop procedure v_rpt_goods_sale_month_09;
drop procedure v_rpt_goods_sale_month_10;
drop procedure v_rpt_goods_sale_month_11;
drop procedure v_rpt_goods_sale_month_12;


/* ============================================================= */



drop view V_RPT_GOODS_SALE;
drop view V_RPT_GOODS_REGISTER;
drop view V_RPT_INVOICE;
drop view V_RPT_GOODS_REST;
drop view V_RPT_GOODS_OUTCOME;
drop view V_RPT_GOODS_INCOME;
drop view V_GOODS_PURCHASE;
drop view V_GOODS_SALE;
drop view V_GOODS_DETAIL_REGISTER;
drop view V_GOODS_REGISTER;
drop view V_PARTNER_MOVE;
drop view V_PARTNER_REGISTER;
drop view V_BUSINESSABLE;
drop view V_PAYMENT_ROTATE;
drop view V_PAYMENT;
drop view V_PAYMENT_OUTCOME;
drop view V_PAYMENT_INCOME;
drop view V_PARTNER_BANK_ACCOUNT;
drop view V_BANK;
drop view V_DEF_PARTNER_PHONE;
drop view V_DEF_CONTACTABLE_PHONE;
drop view V_CONTACTABLE_PHONE;
drop view V_PHONE;
drop view V_DEF_PARTNER_ADDRESS;
drop view V_DEF_CONTACTABLE_ADDRESS;
drop view V_CONTACTABLE_ADDRESS;
drop view V_ADDRESS;
drop view V_ADDRESS_CITY;
drop view V_CITY;
drop view V_CONTRACTOR_UNION;
drop view V_CONTRACTOR;
drop view V_ENTRY_ITEM;
drop view V_FINANCE_DOCUMENT;
drop view V_DOCUMENT;
drop view V_INTANGIBLE;
drop view V_ASSET;
drop view V_GOODS;
drop view V_PRODUCT_MOVE;
drop view V_PRODUCT;
drop view V_WAREHOUSE_MOVE;
drop view V_RESPONSIBLE;
drop view V_WAREHOUSE_UNION;
drop view V_WAREHOUSE;
drop view V_EMPLOYEE;
drop view V_SYSTEM_PERMISSION;
drop view V_SYSTEM_USER;
drop view V_SYSTEM_INFO;
drop view V_ORGANIZATION;
