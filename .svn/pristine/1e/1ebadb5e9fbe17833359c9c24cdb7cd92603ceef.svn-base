


/* CREATE CUST CONSTRAINTS */ 


create unique index businessable_owner on businessable (owner_id);
create unique index contactable_owner on contactable (owner_id);

create index businessable_entity_id on businessable (entity_id);
create index system_entity_code on system_entity (code);

create index doc_type_section on document_type (document_section);
create index doc_type_category on document_type (document_category);
create index fin_doc_type_move on finance_document_type (move_type);

/* Error by update */
/* create unique index partner_move_owner on partner_move (owner_id, partner_id); */


alter table GOODS add constraint FK_GOODS_PRODUCT foreign key (ID) references PRODUCT (ID);
alter table FINANCE_DOCUMENT add constraint FK_DOCUMENT_FIN_DOCUMENT foreign key (ID) references DOCUMENT (ID);

alter table GOODS_REST add constraint FK_GOODS_REST_FIN_DOC foreign key (ID) references FINANCE_DOCUMENT (ID);
alter table GOODS_INCOME add constraint FK_GOODS_INCOME_FIN_DOC foreign key (ID) references FINANCE_DOCUMENT (ID);
alter table GOODS_OUTCOME add constraint FK_GOODS_OUTCOME_FIN_DOC foreign key (ID) references FINANCE_DOCUMENT (ID);
alter table GOODS_MOVE add constraint FK_GOODS_MOVE_FIN_DOC foreign key (ID) references FINANCE_DOCUMENT (ID);
alter table GOODS_WRITEOFF add constraint FK_GOODS_WRITEOFF_FIN_DOC foreign key (ID) references FINANCE_DOCUMENT (ID);

alter table PAYMENT_INCOME add constraint FK_PAYMENT_INCOME_FIN_DOC foreign key (ID) references FINANCE_DOCUMENT (ID);
alter table PAYMENT_OUTCOME add constraint FK_PAYMENT_OUTCOME_FIN_DOC foreign key (ID) references FINANCE_DOCUMENT (ID);


alter table INVOICE add constraint FK_INVOICE_FIN_DOC foreign key (ID) references FINANCE_DOCUMENT (ID);
alter table CONTRACT add constraint FK_CONTRACT_FIN_DOC foreign key (ID) references FINANCE_DOCUMENT (ID);

alter table SALE_ORDER add constraint FK_SALE_ORDER_FIN_DOC foreign key (ID) references FINANCE_DOCUMENT (ID);
alter table PURCHASE_ORDER add constraint FK_PURCHASE_ORDER_FIN_DOC foreign key (ID) references FINANCE_DOCUMENT (ID);

alter table TAX_WAYBILL add constraint FK_TAX_WAYBILL_FIN_DOC foreign key (ID) references FINANCE_DOCUMENT (ID);

alter table SALE_PLAN add constraint FK_SALE_PLAN_FIN_DOC foreign key (ID) references FINANCE_DOCUMENT (ID);
alter table PURCHASE_PLAN add constraint FK_PURCHASE_PLAN_FIN_DOC foreign key (ID) references FINANCE_DOCUMENT (ID);

alter table EXEC_WORK add constraint FK_EXEC_WORK_FIN_DOC foreign key (ID) references FINANCE_DOCUMENT (ID);

alter table CASH_INCOME add constraint FK_CASH_INCOME_FIN_DOC foreign key (ID) references FINANCE_DOCUMENT (ID);
alter table CASH_OUTCOME add constraint FK_CASH_OUTCOME_FIN_DOC foreign key (ID) references FINANCE_DOCUMENT (ID);


alter table EMPLOYEE_RECEPTION add constraint FK_EMPLOYEE_RECEPTION_DOC foreign key (ID) references DOCUMENT (ID);
alter table EMPLOYEE_DISCHARGE add constraint FK_EMPLOYEE_DISCHARGE_DOC foreign key (ID) references DOCUMENT (ID);
alter table EMPLOYEE_VACATION add constraint FK_EMPLOYEE_VACATION_DOC foreign key (ID) references DOCUMENT (ID);
alter table EMPLOYEE_SICKLIST add constraint FK_EMPLOYEE_SICKLIST_DOC foreign key (ID) references DOCUMENT (ID);


/* alter table DOCUMENT add column PARTNER_ID INTEGER; */
/* alter table DOCUMENT add constraint FK_DOCUMENT_PARTNER foreign key (PARTNER_ID) references PARTNER (ID); */
