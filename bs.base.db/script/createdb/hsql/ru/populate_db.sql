
/*==============================================================*/
/* HSQL                                                         */
/* http://www.hsql.org                                          */
/*==============================================================*/

INSERT INTO REGION (ID, COUNTRY_ID, NAME) VALUES (1, 191, '����������');
INSERT INTO REGION (ID, COUNTRY_ID, NAME) VALUES (2, 229, '��������');
INSERT INTO REGION (ID, COUNTRY_ID, NAME) VALUES (3, 229, '�����������');
INSERT INTO REGION (ID, COUNTRY_ID, NAME) VALUES (4, 36, '�������');



INSERT INTO LOCALITY (ID, NAME, LOCALITY_TYPE_ID, COUNTRY_ID) VALUES (1, '������', 1, 191);
INSERT INTO LOCALITY (ID, NAME, LOCALITY_TYPE_ID, COUNTRY_ID) VALUES (2, '�����-���������', 1, 191);
INSERT INTO LOCALITY (ID, NAME, LOCALITY_TYPE_ID, COUNTRY_ID) VALUES (3, '������', 1, 191);
INSERT INTO LOCALITY (ID, NAME, LOCALITY_TYPE_ID, COUNTRY_ID) VALUES (4, '������', 1, 191);
INSERT INTO LOCALITY (ID, NAME, LOCALITY_TYPE_ID, COUNTRY_ID) VALUES (5, '����', 1, 229);
INSERT INTO LOCALITY (ID, NAME, LOCALITY_TYPE_ID, COUNTRY_ID) VALUES (6, '�������', 1, 229);
INSERT INTO LOCALITY (ID, NAME, LOCALITY_TYPE_ID, COUNTRY_ID) VALUES (7, '��������������', 1, 229);
INSERT INTO LOCALITY (ID, NAME, LOCALITY_TYPE_ID, COUNTRY_ID) VALUES (8, '�����', 1, 36);

INSERT INTO CITY (ID) VALUES (1);
INSERT INTO CITY (ID) VALUES (2);
INSERT INTO CITY (ID) VALUES (3);
INSERT INTO CITY (ID) VALUES (4);
INSERT INTO CITY (ID) VALUES (5);
INSERT INTO CITY (ID) VALUES (6);
INSERT INTO CITY (ID) VALUES (7);
INSERT INTO CITY (ID) VALUES (8);


INSERT INTO PRODUCT_GROUP (ID, PRODUCT_SECTION_ID, PARENT_ID, CODE, NAME) VALUES (1, 1, NULL, '1000', '�����');
INSERT INTO PRODUCT_GROUP (ID, PRODUCT_SECTION_ID, PARENT_ID, CODE, NAME) VALUES (2, 1, NULL, '2000', '������');



INSERT INTO PAYMENT_TYPE (ID, NAME) VALUES (1,'����������');
INSERT INTO PAYMENT_TYPE (ID, NAME) VALUES (2,'������');
INSERT INTO PAYMENT_TYPE (ID, NAME) VALUES (3,'����������');

INSERT INTO TAXPRINT_TYPE (ID, NAME) VALUES (1,'��������� � ������ ����� � ���');
INSERT INTO TAXPRINT_TYPE (ID, NAME) VALUES (2,'��������� � ������ ������ ���');
INSERT INTO TAXPRINT_TYPE (ID, NAME) VALUES (3,'��������� � ������ ������ �����');
INSERT INTO TAXPRINT_TYPE (ID, NAME) VALUES (4,'�� ��������� � ������ ����� � ���');

