
INSERT INTO PARTNER_TYPE (ID, NAME) VALUES (1, 'Company');
INSERT INTO PARTNER_TYPE (ID, NAME) VALUES (2, 'Person');

ALTER TABLE PARTNER
 ADD PARTNER_TYPE_ID INTEGER DEFAULT 1 NOT NULL;