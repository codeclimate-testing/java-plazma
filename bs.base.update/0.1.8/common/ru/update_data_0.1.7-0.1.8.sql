
INSERT INTO PARTNER_TYPE (ID, NAME) VALUES (1, '����������� ����');
INSERT INTO PARTNER_TYPE (ID, NAME) VALUES (2, '���������� ����');

ALTER TABLE PARTNER
 ADD PARTNER_TYPE_ID INTEGER DEFAULT 1 NOT NULL;
