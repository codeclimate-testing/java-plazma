
/*==============================================================*/
/* Update system                                                */
/*==============================================================*/


/*==============================================================*/
/* 2012-05-29                                                   */
/*==============================================================*/

UPDATE SYS_ENTITY_TYPE SET ID = 'LOOKUP ', CODE = 'LOOKUP' WHERE ID = 'REFERENCE';

/*==============================================================*/
/* 2012-06-20                                                   */
/*==============================================================*/

UPDATE SYS_ENTITY SET ENTITY_PACKAGE = 'FINANCE'  WHERE ID = 'CONTRACT';

UPDATE DOCUMENT_RELATION SET CREATOR_CLASS = 'org.plazmaforge.bsolution.finance.common.DocumentCreator' WHERE CREATOR_CLASS = 'org.plazmaforge.bsolution.finance.common.DefaultDocumentCreator';
UPDATE DOCUMENT_RELATION SET CREATOR_CLASS = 'org.plazmaforge.bsolution.finance.common.FinanceDocumentCreator' WHERE CREATOR_CLASS = 'org.plazmaforge.bsolution.finance.common.DefaultFinanceDocumentCreator';
UPDATE DOCUMENT_RELATION SET CREATOR_CLASS = 'org.plazmaforge.bsolution.product.common.ProductDocumentCreator' WHERE CREATOR_CLASS = 'org.plazmaforge.bsolution.product.common.DefaultProductDocumentCreator';
UPDATE DOCUMENT_RELATION SET CREATOR_CLASS = 'org.plazmaforge.bsolution.bank.common.PaymentDocumentCreator' WHERE CREATOR_CLASS = 'org.plazmaforge.bsolution.bank.common.DefaultPaymentDocumentCreator';	
UPDATE DOCUMENT_RELATION SET CREATOR_CLASS = 'org.plazmaforge.bsolution.product.common.WarehouseProductDocumentCreator' WHERE CREATOR_CLASS = 'org.plazmaforge.bsolution.product.common.DefaultWarehouseProductDocumentCreator';
	
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (5, 14, 13,'org.plazmaforge.bsolution.finance.common.ContractDocumentCreator');	
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (13, 12, 13,'org.plazmaforge.bsolution.finance.common.ContractDocumentCreator');	
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (24, 15, 13,'org.plazmaforge.bsolution.finance.common.ContractDocumentCreator');	
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (33, 22, 13,'org.plazmaforge.bsolution.finance.common.ContractDocumentCreator');	

INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (40, 13, 14, 'org.plazmaforge.bsolution.finance.common.FinanceDocumentCreator');	
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (41, 13, 12, 'org.plazmaforge.bsolution.finance.common.FinanceDocumentCreator');	
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (42, 13, 15, 'org.plazmaforge.bsolution.finance.common.FinanceDocumentCreator');	
INSERT INTO DOCUMENT_RELATION (ID, PARENT_TYPE_ID, CHILD_TYPE_ID, CREATOR_CLASS) VALUES (43, 13, 22, 'org.plazmaforge.bsolution.finance.common.FinanceDocumentCreator');	

