
INSERT INTO SALE_INVOICE_ITEM (ID, SALE_INVOICE_ID, TAX_ID, PRODUCT_ID, UNIT_ID, PRICE, TAX_PRICE, QUANTITY, AMOUNT, TAX_AMOUNT, IS_TAX, CURRENCY_PRICE, CURRENCY_TAX_PRICE, CURRENCY_AMOUNT, CURRENCY_TAX_AMOUNT, UNIT_RATE, PRICE_WITH_TAX, AMOUNT_WITH_TAX, CURRENCY_PRICE_WITH_TAX, CURRENCY_AMOUNT_WITH_TAX, TAX_PERCENT) VALUES (1, 12, 1, 400, 1, 600, 120, 1, 600, 120, 'Y', 600, 120, 600, 120, 1, 720, 720, 720, 720, 0);
INSERT INTO SALE_INVOICE_ITEM (ID, SALE_INVOICE_ID, TAX_ID, PRODUCT_ID, UNIT_ID, PRICE, TAX_PRICE, QUANTITY, AMOUNT, TAX_AMOUNT, IS_TAX, CURRENCY_PRICE, CURRENCY_TAX_PRICE, CURRENCY_AMOUNT, CURRENCY_TAX_AMOUNT, UNIT_RATE, PRICE_WITH_TAX, AMOUNT_WITH_TAX, CURRENCY_PRICE_WITH_TAX, CURRENCY_AMOUNT_WITH_TAX, TAX_PERCENT) VALUES (2, 13, 1, 402, 1, 960, 192, 2, 1920, 384, 'Y', 750, 150, 1500, 300, 1, 1152, 2304, 900, 1800, 0);
INSERT INTO SALE_INVOICE_ITEM (ID, SALE_INVOICE_ID, TAX_ID, PRODUCT_ID, UNIT_ID, PRICE, TAX_PRICE, QUANTITY, AMOUNT, TAX_AMOUNT, IS_TAX, CURRENCY_PRICE, CURRENCY_TAX_PRICE, CURRENCY_AMOUNT, CURRENCY_TAX_AMOUNT, UNIT_RATE, PRICE_WITH_TAX, AMOUNT_WITH_TAX, CURRENCY_PRICE_WITH_TAX, CURRENCY_AMOUNT_WITH_TAX, TAX_PERCENT) VALUES (3, 13, 1, 403, 1, 1152, 230.400000000000006, 3, 3456, 691.2, 'Y', 900, 180, 2700, 540, 1, 1382.40000000000009, 4147.2, 1080, 3240, 0);
INSERT INTO SALE_INVOICE_ITEM (ID, SALE_INVOICE_ID, TAX_ID, PRODUCT_ID, UNIT_ID, PRICE, TAX_PRICE, QUANTITY, AMOUNT, TAX_AMOUNT, IS_TAX, CURRENCY_PRICE, CURRENCY_TAX_PRICE, CURRENCY_AMOUNT, CURRENCY_TAX_AMOUNT, UNIT_RATE, PRICE_WITH_TAX, AMOUNT_WITH_TAX, CURRENCY_PRICE_WITH_TAX, CURRENCY_AMOUNT_WITH_TAX, TAX_PERCENT) VALUES (4, 14, 1, 404, 1, 6656, 1331.20000000000005, 1, 6656, 1331.2, 'Y', 5200, 1040, 5200, 1040, 1, 7987.19999999999982, 7987.2, 6240, 6240, 0);
INSERT INTO SALE_INVOICE_ITEM (ID, SALE_INVOICE_ID, TAX_ID, PRODUCT_ID, UNIT_ID, PRICE, TAX_PRICE, QUANTITY, AMOUNT, TAX_AMOUNT, IS_TAX, CURRENCY_PRICE, CURRENCY_TAX_PRICE, CURRENCY_AMOUNT, CURRENCY_TAX_AMOUNT, UNIT_RATE, PRICE_WITH_TAX, AMOUNT_WITH_TAX, CURRENCY_PRICE_WITH_TAX, CURRENCY_AMOUNT_WITH_TAX, TAX_PERCENT) VALUES (5, 15, 1, 403, 1, 900, 180, 5, 4500, 900, 'Y', 900, 180, 4500, 900, 1, 1080, 5400, 1080, 5400, 0);

UPDATE SALE_INVOICE_ITEM SET BASE_PRICE = PRICE, TAX_BASE_PRICE = TAX_PRICE, BASE_PRICE_WITH_TAX = PRICE_WITH_TAX, CURRENCY_BASE_PRICE = CURRENCY_PRICE, CURRENCY_TAX_BASE_PRICE = CURRENCY_TAX_PRICE, CURRENCY_BASE_PRICE_WITH_TAX = CURRENCY_PRICE_WITH_TAX;
UPDATE SALE_INVOICE_ITEM SET ACCOUNT_QUANTITY = QUANTITY * UNIT_RATE, ACCOUNT_PRICE = PRICE * UNIT_RATE, ACCOUNT_PRICE_WITH_TAX = PRICE_WITH_TAX * UNIT_RATE,  ACCOUNT_TAX_PRICE = TAX_PRICE * UNIT_RATE;


