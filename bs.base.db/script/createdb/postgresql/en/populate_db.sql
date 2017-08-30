
/*==============================================================*/
/* PostgreSQL                                                   */
/* http://www.postgresql.org                                    */
/*==============================================================*/

INSERT INTO REGION (ID, COUNTRY_ID, NAME) VALUES (1, 232, 'Missoury');
INSERT INTO REGION (ID, COUNTRY_ID, NAME) VALUES (2, 232, 'Kansas');
INSERT INTO REGION (ID, COUNTRY_ID, NAME) VALUES (3, 232, 'California');

/* 232 - USA, 38 - CANADA */
INSERT INTO LOCALITY (ID, NAME, LOCALITY_TYPE_ID, COUNTRY_ID) VALUES (1, 'Overland Park', 1, 232);
INSERT INTO LOCALITY (ID, NAME, LOCALITY_TYPE_ID, COUNTRY_ID) VALUES (2, 'Wichita', 1, 232);
INSERT INTO LOCALITY (ID, NAME, LOCALITY_TYPE_ID, COUNTRY_ID) VALUES (3, 'Kansas City MO', 1, 232);
INSERT INTO LOCALITY (ID, NAME, LOCALITY_TYPE_ID, COUNTRY_ID) VALUES (4, 'Lees Summit', 1, 232);
INSERT INTO LOCALITY (ID, NAME, LOCALITY_TYPE_ID, COUNTRY_ID) VALUES (5, 'Ottawa', 1, 232);
INSERT INTO LOCALITY (ID, NAME, LOCALITY_TYPE_ID, COUNTRY_ID) VALUES (6, 'Kansas City KS', 1, 232);
INSERT INTO LOCALITY (ID, NAME, LOCALITY_TYPE_ID, COUNTRY_ID) VALUES (7, 'St. Joseph', 1, 232);
INSERT INTO LOCALITY (ID, NAME, LOCALITY_TYPE_ID, COUNTRY_ID) VALUES (8, 'Toronto', 1, 38);



INSERT INTO CITY (ID) VALUES (1);
INSERT INTO CITY (ID) VALUES (2);
INSERT INTO CITY (ID) VALUES (3);
INSERT INTO CITY (ID) VALUES (4);
INSERT INTO CITY (ID) VALUES (5);
INSERT INTO CITY (ID) VALUES (6);
INSERT INTO CITY (ID) VALUES (7);
INSERT INTO CITY (ID) VALUES (8);


INSERT INTO PRODUCT_GROUP (ID, PRODUCT_SECTION_ID, PARENT_ID, CODE, NAME) VALUES (1, 1, NULL, '1000', 'Goods');
INSERT INTO PRODUCT_GROUP (ID, PRODUCT_SECTION_ID, PARENT_ID, CODE, NAME) VALUES (2, 1, NULL, '2000', 'Service');



INSERT INTO PAYMENT_TYPE (ID, NAME) VALUES (1,'Type 1');
INSERT INTO PAYMENT_TYPE (ID, NAME) VALUES (2,'Type 2');
INSERT INTO PAYMENT_TYPE (ID, NAME) VALUES (3,'Type 3');

INSERT INTO TAXPRINT_TYPE (ID, NAME) VALUES (1,'With VAT');
INSERT INTO TAXPRINT_TYPE (ID, NAME) VALUES (2,'Only VAT');
INSERT INTO TAXPRINT_TYPE (ID, NAME) VALUES (3,'Only amount');
INSERT INTO TAXPRINT_TYPE (ID, NAME) VALUES (4,'Without amount and VAT');

