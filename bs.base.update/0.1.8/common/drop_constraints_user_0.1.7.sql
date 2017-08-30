alter table EMPLOYEE_SICKLIST drop constraint FK_EMPLOYEE_SICKLIST_DOC;
alter table EMPLOYEE_VACATION drop constraint FK_EMPLOYEE_VACATION_DOC;
alter table EMPLOYEE_DISCHARGE drop constraint FK_EMPLOYEE_DISCHARGE_DOC;
alter table EMPLOYEE_RECEPTION drop constraint FK_EMPLOYEE_RECEPTION_DOC;


alter table CASH_OUTCOME drop constraint FK_CASH_OUTCOME_FIN_DOC;
alter table CASH_INCOME drop constraint FK_CASH_INCOME_FIN_DOC;

alter table EXEC_WORK drop constraint FK_EXEC_WORK_FIN_DOC;

alter table PURCHASE_PLAN drop constraint FK_PURCHASE_PLAN_FIN_DOC;
alter table SALE_PLAN drop constraint FK_SALE_PLAN_FIN_DOC;

alter table TAX_WAYBILL drop constraint FK_TAX_WAYBILL_FIN_DOC;

alter table PURCHASE_ORDER drop constraint FK_PURCHASE_ORDER_FIN_DOC;
alter table SALE_ORDER drop constraint FK_SALE_ORDER_FIN_DOC;

alter table CONTRACT drop constraint FK_CONTRACT_FIN_DOC;
alter table INVOICE drop constraint FK_INVOICE_FIN_DOC;


alter table PAYMENT_OUTCOME drop constraint FK_PAYMENT_OUTCOME_FIN_DOC;
alter table PAYMENT_INCOME drop constraint FK_PAYMENT_INCOME_FIN_DOC;

alter table GOODS_WRITEOFF drop constraint FK_GOODS_WRITEOFF_FIN_DOC;
alter table GOODS_MOVE drop constraint FK_GOODS_MOVE_FIN_DOC;
alter table GOODS_OUTCOME drop constraint FK_GOODS_OUTCOME_FIN_DOC;
alter table GOODS_INCOME drop constraint FK_GOODS_INCOME_FIN_DOC;
alter table GOODS_REST drop constraint FK_GOODS_REST_FIN_DOC;

alter table FINANCE_DOCUMENT drop constraint FK_DOCUMENT_FIN_DOCUMENT;
alter table GOODS drop constraint FK_GOODS_PRODUCT;


drop index fin_doc_type_move;
drop index doc_type_category;
drop index doc_type_section;

drop index system_entity_code;
drop index businessable_entity_id;

drop index contactable_owner;
drop index businessable_owner;
