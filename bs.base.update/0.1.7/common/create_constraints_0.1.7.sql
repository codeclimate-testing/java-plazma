
alter table ADDRESS
   add constraint FK_ADDRESS_ADDRESS_A_ADDRESS_ foreign key (ADDRESS_TYPE_ID)
      references ADDRESS_TYPE (ID);

alter table ADDRESS
   add constraint FK_ADDRESS_ADDRESS_A_APPARTME foreign key (APPARTMENT_TYPE_ID)
      references APPARTMENT_TYPE (ID);

alter table ADDRESS
   add constraint FK_ADDRESS_ADDRESS_C_CITY foreign key (CITY_ID)
      references CITY (ID);

alter table ADDRESS
   add constraint FK_ADDRESS_ADDRESS_C_CONTACTA foreign key (CONTACTABLE_ID)
      references CONTACTABLE (ID);

alter table ADDRESS
   add constraint FK_ADDRESS_ADDRESS_L_LOCALITY foreign key (LOCALITY_ID)
      references LOCALITY (ID);

alter table ADDRESS
   add constraint FK_ADDRESS_ADDRESS_S_STREET_T foreign key (STREET_TYPE_ID)
      references STREET_TYPE (ID);

alter table ASSET
   add constraint FK_ASSET_ASS_ASS_C_ASSET_CL foreign key (ASSET_CLASS_ID)
      references ASSET_CLASS (ID);

alter table BANK_ACCOUNT
   add constraint FK_BANK_ACC_BANKACC_B_BANK foreign key (BANK_ID)
      references BANK (ID);

alter table BANK_ACCOUNT
   add constraint FK_BANK_ACC_BANKACC_P_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table BANK_CONTEXT
   add constraint FK_BANK_CON_BNK_CTX_I_PARTNER foreign key (INCOME_PARTNER_ID)
      references PARTNER (ID);

alter table BANK_CONTEXT
   add constraint FK_BANK_CON_BNK_CTX_O_PARTNER foreign key (OUTCOME_PARTNER_ID)
      references PARTNER (ID);

alter table BANK_CONTEXT
   add constraint FK_BANK_CON_BNK_CTX_P_PAYMENT_ foreign key (PAYMENT_TYPE_ID)
      references PAYMENT_TYPE (ID);

alter table BANK_CONTEXT
   add constraint FK_BANK_CON_BNK_CTX_P_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table BANK_CONTEXT
   add constraint FK_BANK_CON_BNK_CTX_T_TAXPRINT foreign key (TAXPRINT_TYPE_ID)
      references TAXPRINT_TYPE (ID);

alter table BRIGADE
   add constraint FK_BRIGADE_BRIGADE_O_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table BUSINESSABLE
   add constraint FK_BUSINESS_BUSINESS__SYSTEM_E foreign key (ENTITY_ID)
      references SYSTEM_ENTITY (ID);

alter table BUSINESSABLE_ENTITY
   add constraint FK_BUSINESS_BUS_ENTIT_SYSTEM_E foreign key (ENTITY_ID)
      references SYSTEM_ENTITY (ID);

alter table BUSINESSABLE_REGISTER
   add constraint FK_BUSINESS_BSREG_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table BUSINESSABLE_REGISTER
   add constraint FK_BUSINESS_BSREG_PER_PERIOD foreign key (PERIOD_ID)
      references PERIOD (ID);

alter table BUSINESSABLE_REGISTER
   add constraint FK_BUSINESS_REGISTER__BUSINESS foreign key (BUSINESSABLE_ID)
      references BUSINESSABLE (ID);

alter table CASH_INCOME
   add constraint FK_CASH_INC_CASH_INC__CONTRACT foreign key (CONTRACTOR_ID)
      references CONTRACTOR (ID);

alter table CASH_OUTCOME
   add constraint FK_CASH_OUT_CASH_OUT__CONTRACT foreign key (CONTRACTOR_ID)
      references CONTRACTOR (ID);

alter table CONTACT
   add constraint FK_CONTACT_DEPARTMEN_DEPARTME foreign key (DEPARTMENT_ID)
      references DEPARTMENT (ID);

alter table CONTACT
   add constraint FK_CONTACT_ORG_CONTA_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table CONTACT
   add constraint FK_CONTACT_POSITION__POSITION foreign key (POSITION_ID)
      references POSITIONS (ID);

alter table CONTACT
   add constraint FK_CONTACT_PRT_CONTA_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table CONTACT
   add constraint FK_CONTACT_RESPONSIB_EMPLOYEE foreign key (RESPONSIBLE_ID)
      references EMPLOYEE (ID);

alter table CONTACT
   add constraint FK_CONTACT_TYPE_CONT_CONTACT_ foreign key (CONTACT_TYPE_ID)
      references CONTACT_TYPE (ID);

alter table CONTACTABLE
   add constraint FK_CONTACTA_CONTACTAB_SYSTEM_E foreign key (ENTITY_ID)
      references SYSTEM_ENTITY (ID);

alter table CONTACTABLE
   add constraint FK_CONTACTA_CONT_ADD_ADDRESS foreign key (ADDRESS_ID)
      references ADDRESS (ID);

alter table CONTACTABLE
   add constraint FK_CONTACTA_CONT_EML_EMAIL foreign key (EMAIL_ID)
      references EMAIL (ID);

alter table CONTACTABLE
   add constraint FK_CONTACTA_CONT_PHO_PHONE foreign key (PHONE_ID)
      references PHONE (ID);

alter table CONTACTABLE
   add constraint FK_CONTACTA_CONT_WEB_WEB foreign key (WEB_ID)
      references WEB (ID);

alter table CONTACTABLE_ENTITY
   add constraint FK_CONTACTA_CNT_ENTIT_SYSTEM_E foreign key (ENTITY_ID)
      references SYSTEM_ENTITY (ID);

alter table CONTACT_CONTEXT
   add constraint FK_CONTACT__CNT_CTX_A_ADDRESS_ foreign key (ADDRESS_TYPE_ID)
      references ADDRESS_TYPE (ID);

alter table CONTACT_CONTEXT
   add constraint FK_CONTACT__CNT_CTX_C_CONTACT_ foreign key (CONTACT_TYPE_ID)
      references CONTACT_TYPE (ID);

alter table CONTACT_CONTEXT
   add constraint FK_CONTACT__CNT_CTX_P_PHONE_TY foreign key (PHONE_TYPE_ID)
      references PHONE_TYPE (ID);

alter table CONTACT_CONTEXT
   add constraint FK_CONTACT__CNT_CTX_R_EMPLOYEE foreign key (RESPONSIBLE_ID)
      references EMPLOYEE (ID);

alter table CONTRACT
   add constraint FK_CONTRACT_CONTRACT__PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table CONTRACT
   add constraint FK_CONTRACT_ORG_CR_BA_BANK_ACC foreign key (ORGANIZATION_BANK_ACCOUNT_ID)
      references BANK_ACCOUNT (ID);

alter table CONTRACT
   add constraint FK_CONTRACT_ORG_CR_CN_CONTACT foreign key (ORGANIZATION_CONTACT_ID)
      references CONTACT (ID);

alter table CONTRACT
   add constraint FK_CONTRACT_PRT_CR_BA_BANK_ACC foreign key (PARTNER_BANK_ACCOUNT_ID)
      references BANK_ACCOUNT (ID);

alter table CONTRACT
   add constraint FK_CONTRACT_PRT_CR_CN_CONTACT foreign key (PARTNER_CONTACT_ID)
      references CONTACT (ID);

alter table CONTRACTOR_MOVE
   add constraint FK_CONTRACT_CTR_MOVE__CONTRACT foreign key (CONTRACTOR_ID)
      references CONTRACTOR (ID);

alter table CONTRACTOR_MOVE
   add constraint FK_CONTRACT_CTR_MOVE__FINANCE_ foreign key (OWNER_ID)
      references FINANCE_DOCUMENT (ID);

alter table DEPARTMENT
   add constraint FK_DEPARTME_DEP_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table DISTRICT
   add constraint FK_DISTRICT_DISTRICT__REGION foreign key (REGION_ID)
      references REGION (ID);

alter table DOCUMENT
   add constraint FK_DOCUMENT_DOC_CONTR_CONTRACT foreign key (CONTRACT_ID)
      references CONTRACT (ID);

alter table DOCUMENT
   add constraint FK_DOCUMENT_DOC_DEP_DEPARTME foreign key (DEPARTMENT_ID)
      references DEPARTMENT (ID);

alter table DOCUMENT
   add constraint FK_DOCUMENT_DOC_DOC_T_DOCUMENT foreign key (DOCUMENT_TYPE_ID)
      references DOCUMENT_TYPE (ID);

alter table DOCUMENT
   add constraint FK_DOCUMENT_DOC_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table DOCUMENT
   add constraint FK_DOCUMENT_DOC_PARTN_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table DOCUMENT
   add constraint FK_DOCUMENT_DOC_PERIO_PERIOD foreign key (PERIOD_ID)
      references PERIOD (ID);

alter table DOCUMENT
   add constraint FK_DOCUMENT_DOC_PRJ_PROJECT foreign key (PROJECT_ID)
      references PROJECT (ID);

alter table DOCUMENT
   add constraint FK_DOCUMENT_DOC_STATU_DOCUMENT foreign key (DOCUMENT_STATUS_ID)
      references DOCUMENT_STATUS (ID);

alter table DOCUMENT
   add constraint FK_DOCUMENT_DOC_USR_SYSTEM_U foreign key (USER_ID)
      references SYSTEM_USER (ID);

alter table DOCUMENT
   add constraint FK_DOCUMENT_REASON_DO_DOCUMENT foreign key (REASON_DOCUMENT_ID)
      references DOCUMENT (ID);

alter table DOCUMENT_ATTR
   add constraint FK_DOCUMENT_DA_DA_T_DOCUMENT foreign key (ATTR_TYPE_ID)
      references DOCUMENT_ATTR_TYPE (ID);

alter table DOCUMENT_ATTR
   add constraint FK_DOCUMENT_DA_DT_DOCUMENT foreign key (DOCUMENT_TYPE_ID)
      references DOCUMENT_TYPE (ID);

alter table DOCUMENT_ATTR
   add constraint FK_DOCUMENT_DOC_ATTR__DOCUMENT foreign key (DOCUMENT_ID)
      references DOCUMENT (ID);

alter table DOCUMENT_ATTR_TYPE
   add constraint FK_DOCUMENT_DA_T_DOCUMENT foreign key (DOCUMENT_TYPE_ID)
      references DOCUMENT_TYPE (ID);

alter table DOCUMENT_ATTR_TYPE
   add constraint FK_DOCUMENT_DA_T_DA_T_DOCUMENT foreign key (ATTR_TYPE_GROUP_ID)
      references DOCUMENT_ATTR_TYPE_GROUP (ID);

alter table DOCUMENT_ATTR_TYPE
   add constraint FK_DOCUMENT_DA_T_DT_DATA_TYP foreign key (DATA_TYPE_ID)
      references DATA_TYPE (ID);

alter table DOCUMENT_ATTR_TYPE_GROUP
   add constraint FK_DOCUMENT_DA_TG_DOCUMENT foreign key (DOCUMENT_TYPE_ID)
      references DOCUMENT_TYPE (ID);

alter table DOCUMENT_FILE
   add constraint FK_DOCUMENT_DF_DOC_TY_DOCUMENT foreign key (DOCUMENT_TYPE_ID)
      references DOCUMENT_TYPE (ID);

alter table DOCUMENT_FILE
   add constraint FK_DOCUMENT_DF_SF_STO_SYSTEM_F foreign key (FILE_STORAGE_ID)
      references SYSTEM_FILE_STORAGE (ID);

alter table DOCUMENT_FILE
   add constraint FK_DOCUMENT_DF_SF_TYP_SYSTEM_F foreign key (FILE_TYPE_ID)
      references SYSTEM_FILE_TYPE (ID);

alter table DOCUMENT_FILE
   add constraint FK_DOCUMENT_DOC_FILE__DOCUMENT foreign key (DOCUMENT_ID)
      references DOCUMENT (ID);

alter table DOCUMENT_IMAGE
   add constraint FK_DOCUMENT_DI_DOC_TY_DOCUMENT foreign key (DOCUMENT_TYPE_ID)
      references DOCUMENT_TYPE (ID);

alter table DOCUMENT_IMAGE
   add constraint FK_DOCUMENT_DI_SF_TYP_SYSTEM_F foreign key (FILE_TYPE_ID)
      references SYSTEM_FILE_TYPE (ID);

alter table DOCUMENT_IMAGE
   add constraint FK_DOCUMENT_DI_SI_STO_SYSTEM_I foreign key (IMAGE_STORAGE_ID)
      references SYSTEM_IMAGE_STORAGE (ID);

alter table DOCUMENT_IMAGE
   add constraint FK_DOCUMENT_DOC_IMAGE_DOCUMENT foreign key (DOCUMENT_ID)
      references DOCUMENT (ID);

alter table DOCUMENT_STATUS
   add constraint FK_DOCUMENT_DOC_STAT__DOCUMENT foreign key (DOCUMENT_TYPE_ID)
      references DOCUMENT_TYPE (ID);

alter table DOCUMENT_TYPE
   add constraint FK_DOCUMENT_DOCUMENT__SYSTEM_E foreign key (ENTITY_ID)
      references SYSTEM_ENTITY (ID);

alter table DOCUMENT_TYPE_ITEM
   add constraint FK_DOCUMENT_DTI_DT_DOCUMENT foreign key (DOCUMNT_TYPE_ID)
      references DOCUMENT_TYPE (ID);

alter table DRUGSTORE
   add constraint FK_DRUGSTOR_DRUGSTORE_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table EMAIL
   add constraint FK_EMAIL_EMAIL_CON_CONTACTA foreign key (CONTACTABLE_ID)
      references CONTACTABLE (ID);

alter table EMPLOYEE
   add constraint FK_EMPLOYEE_EMP_DEP_DEPARTME foreign key (DEPARTMENT_ID)
      references DEPARTMENT (ID);

alter table EMPLOYEE
   add constraint FK_EMPLOYEE_EMP_ECAT_EMPLOYEE foreign key (EMPLOYEE_CATEGORY_ID)
      references EMPLOYEE_CATEGORY (ID);

alter table EMPLOYEE
   add constraint FK_EMPLOYEE_EMP_LA_LEDGER_A foreign key (LEDGER_ACCOUNT_ID)
      references LEDGER_ACCOUNT (ID);

alter table EMPLOYEE
   add constraint FK_EMPLOYEE_EMP_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table EMPLOYEE
   add constraint FK_EMPLOYEE_EMP_PFORM_PAYROLL_ foreign key (PAYROLL_FORM_ID)
      references PAYROLL_FORM (ID);

alter table EMPLOYEE
   add constraint FK_EMPLOYEE_EMP_POS_POSITION foreign key (POSITION_ID)
      references POSITIONS (ID);

alter table EMPLOYEE
   add constraint FK_EMPLOYEE_EMP_PRS_PERSON foreign key (PERSON_ID)
      references PERSON (ID);

alter table EMPLOYEE
   add constraint FK_EMPLOYEE_EMP_RANK_EMPLOYEE foreign key (EMPLOYEE_RANK_ID)
      references EMPLOYEE_RANK (ID);

alter table EMPLOYEE_DISCHARGE
   add constraint FK_EMPLOYEE_EMPDIS_DT_DISCHARG foreign key (DISCHARGE_TYPE_ID)
      references DISCHARGE_TYPE (ID);

alter table EMPLOYEE_DISCHARGE
   add constraint FK_EMPLOYEE_EMP_DIS_EMPLOYEE foreign key (EMPLOYEE_ID)
      references EMPLOYEE (ID);

alter table EMPLOYEE_MOVE
   add constraint FK_EMPLOYEE_EMP_MOVE__EMPLOYEE foreign key (EMPLOYEE_ID)
      references EMPLOYEE (ID);

alter table EMPLOYEE_MOVE
   add constraint FK_EMPLOYEE_EMP_MOVE__FINANCE_ foreign key (OWNER_ID)
      references FINANCE_DOCUMENT (ID);

alter table EMPLOYEE_PAYROLL
   add constraint FK_EMPLOYEE_EMPPAY_EM_EMPLOYEE foreign key (EMPLOYEE_ID)
      references EMPLOYEE (ID);

alter table EMPLOYEE_PAYROLL
   add constraint FK_EMPLOYEE_EMPPAY_OR_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table EMPLOYEE_PAYROLL
   add constraint FK_EMPLOYEE_EMPPAY_PA_PAYROLL foreign key (PAYROLL_ID)
      references PAYROLL (ID);

alter table EMPLOYEE_PAYROLL
   add constraint FK_EMPLOYEE_EMPPAY_PE_PERIOD foreign key (PERIOD_ID)
      references PERIOD (ID);

alter table EMPLOYEE_RECEPTION
   add constraint FK_EMPLOYEE_EMPREC_CA_EMPLOYEE foreign key (EMPLOYEE_CATEGORY_ID)
      references EMPLOYEE_CATEGORY (ID);

alter table EMPLOYEE_RECEPTION
   add constraint FK_EMPLOYEE_EMPREC_DE_DEPARTME foreign key (DEPARTMENT_ID)
      references DEPARTMENT (ID);

alter table EMPLOYEE_RECEPTION
   add constraint FK_EMPLOYEE_EMPREC_EM_EMPLOYEE foreign key (EMPLOYEE_RANK_ID)
      references EMPLOYEE_RANK (ID);

alter table EMPLOYEE_RECEPTION
   add constraint FK_EMPLOYEE_EMPREC_PF_PAYROLL_ foreign key (PAYROLL_FORM_ID)
      references PAYROLL_FORM (ID);

alter table EMPLOYEE_RECEPTION
   add constraint FK_EMPLOYEE_EMPREC_PR_PERSON foreign key (PERSON_ID)
      references PERSON (ID);

alter table EMPLOYEE_SICKLIST
   add constraint FK_EMPLOYEE_EMPSIC_EM_EMPLOYEE foreign key (EMPLOYEE_ID)
      references EMPLOYEE (ID);

alter table EMPLOYEE_SICKLIST
   add constraint FK_EMPLOYEE_ESC_SCAT_SICKLIST foreign key (SICKLIST_AVERANGE_TYPE_ID)
      references SICKLIST_AVERANGE_TYPE (ID);

alter table EMPLOYEE_SICKLIST
   add constraint FK_EMPLOYEE_ESC_SCLST_SICKLIST foreign key (SICKLIST_TYPE_ID)
      references SICKLIST_TYPE (ID);

alter table EMPLOYEE_SICKLIST
   add constraint FK_EMPLOYEE_ESC_SCTP_SICK_TYP foreign key (SICK_TYPE_ID)
      references SICK_TYPE (ID);

alter table EMPLOYEE_SICKLIST_AVERANGE
   add constraint FK_EMPLOYEE_EMPSICAVG_EMPLOYEE foreign key (OWNER_ID)
      references EMPLOYEE_SICKLIST (ID);

alter table EMPLOYEE_TOTAL
   add constraint FK_EMPLOYEE_EMPTOT_EM_EMPLOYEE foreign key (EMPLOYEE_ID)
      references EMPLOYEE (ID);

alter table EMPLOYEE_TOTAL
   add constraint FK_EMPLOYEE_EMPTOT_PE_PERIOD foreign key (PERIOD_ID)
      references PERIOD (ID);

alter table EMPLOYEE_VACATION
   add constraint FK_EMPLOYEE_EMPLEA_EM_EMPLOYEE foreign key (EMPLOYEE_ID)
      references EMPLOYEE (ID);

alter table EMPLOYEE_VACATION
   add constraint FK_EMPLOYEE_EV_ADDVCL_VACATION foreign key (ADD_VACATION_CALCULATE_ID)
      references VACATION_CALCULATE (ID);

alter table EMPLOYEE_VACATION
   add constraint FK_EMPLOYEE_EV_VAT_VACATION foreign key (VACATION_AVERANGE_TYPE_ID)
      references VACATION_AVERANGE_TYPE (ID);

alter table EMPLOYEE_VACATION
   add constraint FK_EMPLOYEE_EV_VCL_VACATION foreign key (VACATION_CALCULATE_ID)
      references VACATION_CALCULATE (ID);

alter table EMPLOYEE_VACATION
   add constraint FK_EMPLOYEE_EV_VTP_VACATION foreign key (VACATION_TYPE_ID)
      references VACATION_TYPE (ID);

alter table EMPLOYEE_VACATION_AVERANGE
   add constraint FK_EMPLOYEE_EMPVACAVR_EMPLOYEE foreign key (OWNER_ID)
      references EMPLOYEE_VACATION (ID);

alter table ENTRY_ITEM
   add constraint FK_ENTRY_IT_CDT_ENTRY_LEDGER_A foreign key (CREDIT_LEDGER_ACCOUNT_ID)
      references LEDGER_ACCOUNT (ID);

alter table ENTRY_ITEM
   add constraint FK_ENTRY_IT_CDT_EN_IT_BUSINESS foreign key (CREDIT_OBJECT_ID)
      references BUSINESSABLE (ID);

alter table ENTRY_ITEM
   add constraint FK_ENTRY_IT_DBT_ENTRY_LEDGER_A foreign key (DEBIT_LEDGER_ACCOUNT_ID)
      references LEDGER_ACCOUNT (ID);

alter table ENTRY_ITEM
   add constraint FK_ENTRY_IT_DBT_EN_IT_BUSINESS foreign key (DEBIT_OBJECT_ID)
      references BUSINESSABLE (ID);

alter table ENTRY_ITEM
   add constraint FK_ENTRY_IT_ENTRY_ITE_FINANCE_ foreign key (OWNER_ID)
      references FINANCE_DOCUMENT (ID);

alter table EXEC_WORK_ITEM
   add constraint FK_EXEC_WOR_EWORK_ITE_EXEC_WOR foreign key (EXEC_WORK_ID)
      references EXEC_WORK (ID);

alter table EXEC_WORK_ITEM
   add constraint FK_EXEC_WOR_EWORK_ITE_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table EXEC_WORK_ITEM
   add constraint FK_EXEC_WOR_EWORK_ITE_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table EXEC_WORK_ITEM
   add constraint FK_EXEC_WOR_EWORK_PRO_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table FACTORY
   add constraint FK_FACTORY_FACTORY_O_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table FINANCE_DOCUMENT
   add constraint FK_FINANCE__FINDOC_CU_CURRENCY foreign key (CURRENCY_ID)
      references CURRENCY (ID);

alter table FINANCE_DOCUMENT
   add constraint FK_FINANCE__FINDOC_TA_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table FINANCE_DOCUMENT_TYPE
   add constraint FK_FINANCE__FINDOC_TY_DOCUMENT foreign key (DOCUMENT_TYPE_ID)
      references DOCUMENT_TYPE (ID);

alter table GOODS
   add constraint FK_GOODS_GDS_COUNT_COUNTRY foreign key (COUNTRY_ID)
      references COUNTRY (ID);

alter table GOODS
   add constraint FK_GOODS_GDS_GDSTY_GOODS_TY foreign key (GOODS_TYPE_ID)
      references GOODS_TYPE (ID);

alter table GOODS_INCOME
   add constraint FK_GOODS_IN_GDS_IN_WR_WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table GOODS_INCOME
   add constraint FK_GOODS_IN_GINCOME_R_RESPONSI foreign key (RESPONSIBLE_ID)
      references RESPONSIBLE (ID);

alter table GOODS_INCOME_ITEM
   add constraint FK_GOODS_IN_GINCOME_I_GOODS_IN foreign key (GOODS_INCOME_ID)
      references GOODS_INCOME (ID);

alter table GOODS_INCOME_ITEM
   add constraint FK_GOODS_IN_GINCOME_P_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table GOODS_INCOME_ITEM
   add constraint FK_GOODS_IN_GINCOME_T_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table GOODS_INCOME_ITEM
   add constraint FK_GOODS_IN_GINCOME_U_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table GOODS_MOVE
   add constraint FK_GOODS_MO_GDM_IN_WR_WAREHOUS foreign key (INCOME_WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table GOODS_MOVE
   add constraint FK_GOODS_MO_GDM_OUT_W_WAREHOUS foreign key (OUTCOME_WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table GOODS_MOVE
   add constraint FK_GOODS_MO_GMOVE_INC_RESPONSI foreign key (INCOME_RESPONSIBLE_ID)
      references RESPONSIBLE (ID);

alter table GOODS_MOVE
   add constraint FK_GOODS_MO_GMOVE_OUT_RESPONSI foreign key (OUTCOME_RESPONSIBLE_ID)
      references RESPONSIBLE (ID);

alter table GOODS_MOVE_ITEM
   add constraint FK_GOODS_MO_GDSMI_TAX_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table GOODS_MOVE_ITEM
   add constraint FK_GOODS_MO_GDSMI_UN_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table GOODS_MOVE_ITEM
   add constraint FK_GOODS_MO_GMOVE_ITE_GOODS_MO foreign key (GOODS_MOVE_ID)
      references GOODS_MOVE (ID);

alter table GOODS_MOVE_ITEM
   add constraint FK_GOODS_MO_GMOVE_PRO_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table GOODS_OUTCOME
   add constraint FK_GOODS_OU_GDS_OUT_W_WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table GOODS_OUTCOME
   add constraint FK_GOODS_OU_GOUTCOME__RESPONSI foreign key (RESPONSIBLE_ID)
      references RESPONSIBLE (ID);

alter table GOODS_OUTCOME_ITEM
   add constraint FK_GOODS_OU_GOUTCOME__GOODS_OU foreign key (GOODS_OUTCOME_ID)
      references GOODS_OUTCOME (ID);

alter table GOODS_OUTCOME_ITEM
   add constraint FK_GOODS_OU_GOUTCOME__TAX foreign key (TAX_ID)
      references TAX (ID);

alter table GOODS_OUTCOME_ITEM
   add constraint FK_GOODS_OU_GOUTCOME__UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table GOODS_OUTCOME_ITEM
   add constraint FK_GOODS_OU_GOUTCONE__PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table GOODS_OUTCOME_ITEM
   add constraint FK_GOODS_OU_PR_INS_PRODUCT_ foreign key (PRODUCT_INSTANCE_ID)
      references PRODUCT_INSTANCE (ID);

alter table GOODS_REST
   add constraint FK_GOODS_RE_GDSR_RE_RESPONSI foreign key (RESPONSIBLE_ID)
      references RESPONSIBLE (ID);

alter table GOODS_REST
   add constraint FK_GOODS_RE_GDS_RST_W_WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table GOODS_REST_ITEM
   add constraint FK_GOODS_RE_GDSRI_TAX_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table GOODS_REST_ITEM
   add constraint FK_GOODS_RE_GDSRI_UN_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table GOODS_REST_ITEM
   add constraint FK_GOODS_RE_GDSR_ITEM_GOODS_RE foreign key (GOODS_REST_ID)
      references GOODS_REST (ID);

alter table GOODS_REST_ITEM
   add constraint FK_GOODS_RE_GREST_PRO_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table GOODS_WRITEOFF
   add constraint FK_GOODS_WR_GDSW_RE_RESPONSI foreign key (RESPONSIBLE_ID)
      references RESPONSIBLE (ID);

alter table GOODS_WRITEOFF
   add constraint FK_GOODS_WR_GDS_OFF_W_WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table GOODS_WRITEOFF_ITEM
   add constraint FK_GOODS_WR_GDSWI_TAX_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table GOODS_WRITEOFF_ITEM
   add constraint FK_GOODS_WR_GDSWI_UN_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table GOODS_WRITEOFF_ITEM
   add constraint FK_GOODS_WR_GDSW_ITEM_GOODS_WR foreign key (GOODS_WRITEOFF_ID)
      references GOODS_WRITEOFF (ID);

alter table GOODS_WRITEOFF_ITEM
   add constraint FK_GOODS_WR_GWRITEOFF_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table INVOICE
   add constraint FK_INVOICE_INV_PT_PRICE_TY foreign key (PRICE_TYPE_ID)
      references PRICE_TYPE (ID);

alter table INVOICE_ITEM
   add constraint FK_INVOICE__GDSII_TAX_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table INVOICE_ITEM
   add constraint FK_INVOICE__INVI_UNIT_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table INVOICE_ITEM
   add constraint FK_INVOICE__INVOICE_I_INVOICE foreign key (INVOICE_ID)
      references INVOICE (ID);

alter table INVOICE_ITEM
   add constraint FK_INVOICE__INVOICE_P_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table LEDGER_ACCOUNT
   add constraint FK_LEDGER_A_LA_LA_TYP_LEDGER_A foreign key (LEDGER_ACCOUNT_TYPE_ID)
      references LEDGER_ACCOUNT_TYPE (ID);

alter table LEDGER_ACCOUNT_REGISTER
   add constraint FK_LEDGER_A_LA_REG_LA_LEDGER_A foreign key (LEDGER_ACCOUNT_ID)
      references LEDGER_ACCOUNT (ID);

alter table LEDGER_ACCOUNT_REGISTER
   add constraint FK_LEDGER_A_LA_REG_OR_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table LEDGER_ACCOUNT_REGISTER
   add constraint FK_LEDGER_A_LA_REG_PE_PERIOD foreign key (PERIOD_ID)
      references PERIOD (ID);

alter table LEDGER_ACCOUNT_REST
   add constraint FK_LEDGER_A_LA_REST_L_LEDGER_A foreign key (LEDGER_ACCOUNT_ID)
      references LEDGER_ACCOUNT (ID);

alter table LEDGER_ACCOUNT_REST
   add constraint FK_LEDGER_A_LA_REST_O_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table LEDGER_ACCOUNT_REST
   add constraint FK_LEDGER_A_LA_RES_CU_CURRENCY foreign key (CURRENCY_ID)
      references CURRENCY (ID);

alter table LEDGER_ACCOUNT_REST
   add constraint FK_LEDGER_A_LA_RES_PE_PERIOD foreign key (PERIOD_ID)
      references PERIOD (ID);

alter table LOCALITY
   add constraint FK_LOCALITY_LOCALITY__COUNTRY foreign key (COUNTRY_ID)
      references COUNTRY (ID);

alter table LOCALITY
   add constraint FK_LOCALITY_LOCALITY__DISTRICT foreign key (DISTRICT_ID)
      references DISTRICT (ID);

alter table LOCALITY
   add constraint FK_LOCALITY_LOCALITY__LOCALITY foreign key (LOCALITY_TYPE_ID)
      references LOCALITY_TYPE (ID);

alter table LOCALITY
   add constraint FK_LOCALITY_LOCALITY__REGION foreign key (REGION_ID)
      references REGION (ID);

alter table PARTNER
   add constraint FK_PARTNER_PRT_BNK_A_BANK_ACC foreign key (BANK_ACCOUNT_ID)
      references BANK_ACCOUNT (ID);

alter table PARTNER
   add constraint FK_PARTNER_PRT_FP_FORM_PRO foreign key (FORM_PROPERTY_ID)
      references FORM_PROPERTY (ID);

alter table PARTNER
   add constraint FK_PARTNER_PRT_INDS_INDUSTRY foreign key (INDUSTRY_ID)
      references INDUSTRY (ID);

alter table PARTNER
   add constraint FK_PARTNER_PRT_LA_LEDGER_A foreign key (LEDGER_ACCOUNT_ID)
      references LEDGER_ACCOUNT (ID);

alter table PARTNER
   add constraint FK_PARTNER_PRT_PRTG_PARTNER_ foreign key (PARTNER_GROUP_ID)
      references PARTNER_GROUP (ID);

alter table PARTNER_ACTIVITY_TYPE_LINK
   add constraint FK_PARTNER__PRT_ATL_A_ACTIVITY foreign key (ACTIVITY_TYPE_ID)
      references ACTIVITY_TYPE (ID);

alter table PARTNER_ACTIVITY_TYPE_LINK
   add constraint FK_PARTNER__PRT_ATL_P_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table PARTNER_CATEGORY_LINK
   add constraint FK_PARTNER__PCL_PRT_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table PARTNER_CATEGORY_LINK
   add constraint FK_PARTNER__PCL_PRTC_PARTNER_ foreign key (PARTNER_CATEGORY_ID)
      references PARTNER_CATEGORY (ID);

alter table PARTNER_MOVE
   add constraint FK_PARTNER__PRT_MOVE__FINANCE_ foreign key (OWNER_ID)
      references FINANCE_DOCUMENT (ID);

alter table PARTNER_MOVE
   add constraint FK_PARTNER__PRT_MOVE__PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table PARTNER_REGISTER
   add constraint FK_PARTNER__PARTNER_R_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table PARTNER_REGISTER
   add constraint FK_PARTNER__PARTNER_R_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table PARTNER_REGISTER
   add constraint FK_PARTNER__PARTNER_R_PERIOD foreign key (PERIOD_ID)
      references PERIOD (ID);

alter table PARTNER_REST
   add constraint FK_PARTNER__PRTR_CURR_CURRENCY foreign key (CURRENCY_ID)
      references CURRENCY (ID);

alter table PARTNER_REST
   add constraint FK_PARTNER__PRTR_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table PARTNER_REST
   add constraint FK_PARTNER__PRTR_PERI_PERIOD foreign key (PERIOD_ID)
      references PERIOD (ID);

alter table PARTNER_REST
   add constraint FK_PARTNER__PRTR_PRT_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table PAYMENT_DOCUMENT_LINK
   add constraint FK_PAYMENT__PAY_DOC_D_DOCUMENT foreign key (DOCUMENT_ID)
      references DOCUMENT (ID);

alter table PAYMENT_DOCUMENT_LINK
   add constraint FK_PAYMENT__PAY_DOC_P_DOCUMENT foreign key (PAYMENT_ID)
      references DOCUMENT (ID);

alter table PAYMENT_INCOME
   add constraint FK_PAYMENT__PINCOME_O_BANK_ACC foreign key (ORGANIZATION_BANK_ACCOUNT_ID)
      references BANK_ACCOUNT (ID);

alter table PAYMENT_INCOME
   add constraint FK_PAYMENT__PINCOME_P_BANK_ACC foreign key (PARTNER_BANK_ACCOUNT_ID)
      references BANK_ACCOUNT (ID);

alter table PAYMENT_INCOME
   add constraint FK_PAYMENT__PINCOME_P_PAYMENT_ foreign key (PAYMENT_TYPE_ID)
      references PAYMENT_TYPE (ID);

alter table PAYMENT_INCOME
   add constraint FK_PAYMENT__PINCOME_T_TAXPRINT foreign key (TAXPRINT_TYPE_ID)
      references TAXPRINT_TYPE (ID);

alter table PAYMENT_OUTCOME
   add constraint FK_PAYMENT__PO_ORG_BA_BANK_ACC foreign key (ORGANIZATION_BANK_ACCOUNT_ID)
      references BANK_ACCOUNT (ID);

alter table PAYMENT_OUTCOME
   add constraint FK_PAYMENT__PO_PRT_BA_BANK_ACC foreign key (PARTNER_BANK_ACCOUNT_ID)
      references BANK_ACCOUNT (ID);

alter table PAYMENT_OUTCOME
   add constraint FK_PAYMENT__PO_PTYPE_PAYMENT_ foreign key (PAYMENT_TYPE_ID)
      references PAYMENT_TYPE (ID);

alter table PAYMENT_OUTCOME
   add constraint FK_PAYMENT__PO_TAXPRN_TAXPRINT foreign key (TAXPRINT_TYPE_ID)
      references TAXPRINT_TYPE (ID);

alter table PAYMENT_OUTCOME_TEMPLATE
   add constraint FK_PAYMENT__POT_CRC_CURRENCY foreign key (CURRENCY_ID)
      references CURRENCY (ID);

alter table PAYMENT_OUTCOME_TEMPLATE
   add constraint FK_PAYMENT__POT_DEPAR_DEPARTME foreign key (DEPARTMENT_ID)
      references DEPARTMENT (ID);

alter table PAYMENT_OUTCOME_TEMPLATE
   add constraint FK_PAYMENT__POT_OBA_BANK_ACC foreign key (ORGANIZATION_BANK_ACCOUNT_ID)
      references BANK_ACCOUNT (ID);

alter table PAYMENT_OUTCOME_TEMPLATE
   add constraint FK_PAYMENT__POT_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table PAYMENT_OUTCOME_TEMPLATE
   add constraint FK_PAYMENT__POT_PARTN_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table PAYMENT_OUTCOME_TEMPLATE
   add constraint FK_PAYMENT__POT_PBA_BANK_ACC foreign key (PARTNER_BANK_ACCOUNT_ID)
      references BANK_ACCOUNT (ID);

alter table PAYMENT_OUTCOME_TEMPLATE
   add constraint FK_PAYMENT__POT_PRJ_PROJECT foreign key (PROJECT_ID)
      references PROJECT (ID);

alter table PAYMENT_OUTCOME_TEMPLATE
   add constraint FK_PAYMENT__POT_PT_PAYMENT_ foreign key (PAYMENT_TYPE_ID)
      references PAYMENT_TYPE (ID);

alter table PAYMENT_OUTCOME_TEMPLATE
   add constraint FK_PAYMENT__POT_TAX_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table PAYMENT_OUTCOME_TEMPLATE
   add constraint FK_PAYMENT__POT_TPT_TAXPRINT foreign key (TAXPRINT_TYPE_ID)
      references TAXPRINT_TYPE (ID);

alter table PAYMENT_OUTCOME_TEMPLATE
   add constraint FK_PAYMENT__POT_USER_SYSTEM_U foreign key (USER_ID)
      references SYSTEM_USER (ID);

alter table PAYROLL
   add constraint FK_PAYROLL_PAY_ALGOR_PAYROLL_ foreign key (PAYROLL_ALGORITM_ID)
      references PAYROLL_ALGORITM (ID);

alter table PAYROLL
   add constraint FK_PAYROLL_PAY_PALGT_PAYROLL_ foreign key (PAYROLL_ALGORITM_TYPE_ID)
      references PAYROLL_ALGORITM_TYPE (ID);

alter table PAYROLL
   add constraint FK_PAYROLL_PAY_PAYGR_PAYROLL_ foreign key (PAYROLL_GROUP_ID)
      references PAYROLL_GROUP (ID);

alter table PAYROLL
   add constraint FK_PAYROLL_PAY_PAYMO_PAYROLL_ foreign key (PAYROLL_MODE_ID)
      references PAYROLL_MODE (ID);

alter table PAYROLL
   add constraint FK_PAYROLL_PAY_PAYTY_PAYROLL_ foreign key (PAYROLL_TYPE_ID)
      references PAYROLL_TYPE (ID);

alter table PAYROLL_ITEM
   add constraint FK_PAYROLL__PAYITEM_O_PAYROLL foreign key (OWNER_ID)
      references PAYROLL (ID);

alter table PAYROLL_ITEM
   add constraint FK_PAYROLL__PAYITEM_P_PAYROLL foreign key (PAYROLL_ID)
      references PAYROLL (ID);

alter table PERIOD
   add constraint FK_PERIOD_PERIOD_PT_PERIOD_T foreign key (PERIOD_TYPE_ID)
      references PERIOD_TYPE (ID);

alter table PERSON_CARD
   add constraint FK_PERSON_C_PC_CRES_COUNTRY foreign key (COUNTRY_RESIDENCE_ID)
      references COUNTRY (ID);

alter table PERSON_CARD
   add constraint FK_PERSON_C_PC_DPSPEC_SPECIALI foreign key (DIPLOMA_SPECIALITY_ID)
      references SPECIALITY (ID);

alter table PERSON_CARD
   add constraint FK_PERSON_C_PC_DT_PERSON_D foreign key (DOCUMENT_TYPE_ID)
      references PERSON_DOCUMENT_TYPE (ID);

alter table PERSON_CARD
   add constraint FK_PERSON_C_PC_FS_FAMILY_S foreign key (FAMILY_STATUS_ID)
      references FAMILY_STATUS (ID);

alter table PERSON_CARD
   add constraint FK_PERSON_C_PC_LAN_LANGUAGE foreign key (LANGUAGE_ID)
      references LANGUAGE (ID);

alter table PERSON_CARD
   add constraint FK_PERSON_C_PC_NTL_COUNTRY foreign key (NATIONALITY_ID)
      references COUNTRY (ID);

alter table PERSON_CARD
   add constraint FK_PERSON_C_PERSON_CA_PERSON foreign key (PERSON_ID)
      references PERSON (ID);

alter table PERSON_DOCUMENT
   add constraint FK_PERSON_D_PERSON_DO_PERSON foreign key (PERSON_ID)
      references PERSON (ID);

alter table PERSON_DOCUMENT
   add constraint FK_PERSON_D_PRSDOC_PR_PERSON_D foreign key (PERSON_DOC_TYPE_ID)
      references PERSON_DOCUMENT_TYPE (ID);

alter table PERSON_EDUCATION
   add constraint FK_PERSON_E_PRSEDU_AD_ACADEMIC foreign key (ACADEMIC_DEGREE_ID)
      references ACADEMIC_DEGREE (ID);

alter table PERSON_EDUCATION
   add constraint FK_PERSON_E_PRSEDU_EF_EDUCATIO foreign key (EDUCATION_FORM_ID)
      references EDUCATION_FORM (ID);

alter table PERSON_EDUCATION
   add constraint FK_PERSON_E_PRSEDU_EI_EDUCATIO foreign key (EDUCATION_INSTITUTE_ID)
      references EDUCATION_INSTITUTE (ID);

alter table PERSON_EDUCATION
   add constraint FK_PERSON_E_PRSEDU_ET_EDUCATIO foreign key (EDUCATION_TYPE_ID)
      references EDUCATION_TYPE (ID);

alter table PERSON_EDUCATION
   add constraint FK_PERSON_E_PRSEDU_PR_PERSON foreign key (PERSON_ID)
      references PERSON (ID);

alter table PERSON_FAMILY
   add constraint FK_PERSON_F_PF_PRS_PERSON foreign key (PERSON_ID)
      references PERSON (ID);

alter table PERSON_FAMILY
   add constraint FK_PERSON_F_PRSFAM_FA_FAMILIAR foreign key (FAMILIARITY_ID)
      references FAMILIARITY (ID);

alter table PERSON_JOB
   add constraint FK_PERSON_J_PRSJOB_PR_PERSON foreign key (PERSON_ID)
      references PERSON (ID);

alter table PERSON_LANGUAGE
   add constraint FK_PERSON_L_PRSLAN_LA_LANGUAGE foreign key (LANGUAGE_ID)
      references LANGUAGE (ID);

alter table PERSON_LANGUAGE
   add constraint FK_PERSON_L_PRSLAN_PR_PERSON foreign key (PERSON_ID)
      references PERSON (ID);

alter table PERSON_MILITARY
   add constraint FK_PERSON_M_PERSON_MI_PERSON foreign key (PERSON_ID)
      references PERSON (ID);

alter table PERSON_MILITARY
   add constraint FK_PERSON_M_PM_MR_MILITARY foreign key (MILITARY_RANK_ID)
      references MILITARY_RANK (ID);

alter table PERSON_MILITARY
   add constraint FK_PERSON_M_PM_MS_MILITARY foreign key (MILITARY_STATUS_ID)
      references MILITARY_STATUS (ID);

alter table PERSON_MILITARY
   add constraint FK_PERSON_M_PM_MSPEC_MILITARY foreign key (MILITARY_SPECIALITY_ID)
      references MILITARY_SPECIALITY (ID);

alter table PHONE
   add constraint FK_PHONE_PHONE_CON_CONTACTA foreign key (CONTACTABLE_ID)
      references CONTACTABLE (ID);

alter table PHONE
   add constraint FK_PHONE_PHONE_PHO_PHONE_TY foreign key (PHONE_TYPE_ID)
      references PHONE_TYPE (ID);

alter table PRODUCT
   add constraint FK_PRODUCT_DIM_UNT_UNIT foreign key (DIMENSION_UNIT_ID)
      references UNIT (ID);

alter table PRODUCT
   add constraint FK_PRODUCT_PROD_CLAS_PRODUCT_ foreign key (PRODUCT_CLASS_ID)
      references PRODUCT_CLASS (ID);

alter table PRODUCT
   add constraint FK_PRODUCT_PROD_CUR_CURRENCY foreign key (CURRENCY_ID)
      references CURRENCY (ID);

alter table PRODUCT
   add constraint FK_PRODUCT_PROD_LA_LEDGER_A foreign key (LEDGER_ACCOUNT_ID)
      references LEDGER_ACCOUNT (ID);

alter table PRODUCT
   add constraint FK_PRODUCT_PROD_MANU_PARTNER foreign key (MANUFACTURER_ID)
      references PARTNER (ID);

alter table PRODUCT
   add constraint FK_PRODUCT_PROD_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table PRODUCT
   add constraint FK_PRODUCT_PROD_PGRO_PRODUCT_ foreign key (PRODUCT_GROUP_ID)
      references PRODUCT_GROUP (ID);

alter table PRODUCT
   add constraint FK_PRODUCT_PROD_SUPP_PARTNER foreign key (SUPPLIER_ID)
      references PARTNER (ID);

alter table PRODUCT
   add constraint FK_PRODUCT_PROD_UNIT_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table PRODUCT
   add constraint FK_PRODUCT_WAR_PRD_U_UNIT foreign key (WARRANTY_PERIOD_UNIT_ID)
      references UNIT (ID);

alter table PRODUCT
   add constraint FK_PRODUCT_WG_UNT_UNIT foreign key (WEIGHT_UNIT_ID)
      references UNIT (ID);

alter table PRODUCT_CLASS
   add constraint FK_PRODUCT__PCLASS_GR_PRODUCT_ foreign key (PRODUCT_CLASS_GROUP_ID)
      references PRODUCT_CLASS_GROUP (ID);

alter table PRODUCT_CLASS
   add constraint FK_PRODUCT__PCLASS_TY_PRODUCT_ foreign key (PRODUCT_CLASS_TYPE_ID)
      references PRODUCT_CLASS_TYPE (ID);

alter table PRODUCT_DETAIL_REGISTER
   add constraint FK_PRODUCT__PDR_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table PRODUCT_DETAIL_REGISTER
   add constraint FK_PRODUCT__PDR_PERIO_PERIOD foreign key (PERIOD_ID)
      references PERIOD (ID);

alter table PRODUCT_DETAIL_REGISTER
   add constraint FK_PRODUCT__PDR_PROD_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table PRODUCT_DETAIL_REGISTER
   add constraint FK_PRODUCT__PDR_RESPO_RESPONSI foreign key (RESPONSIBLE_ID)
      references RESPONSIBLE (ID);

alter table PRODUCT_DETAIL_REGISTER
   add constraint FK_PRODUCT__PDR_WAREH_WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table PRODUCT_GROUP
   add constraint FK_PRODUCT__PGROUP_PS_PRODUCT_ foreign key (PRODUCT_SECTION_ID)
      references PRODUCT_SECTION (ID);

alter table PRODUCT_INSTANCE
   add constraint FK_PRODUCT__PRD_INS_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table PRODUCT_MOVE
   add constraint FK_PRODUCT__PROD_MOVE_FINANCE_ foreign key (OWNER_ID)
      references FINANCE_DOCUMENT (ID);

alter table PRODUCT_MOVE
   add constraint FK_PRODUCT__PROD_MOVE_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table PRODUCT_MOVE
   add constraint FK_PRODUCT__PROD_MOVE_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table PRODUCT_PRICE
   add constraint FK_PRODUCT__PPRICE_CU_CURRENCY foreign key (CURRENCY_ID)
      references CURRENCY (ID);

alter table PRODUCT_PRICE
   add constraint FK_PRODUCT__PPRICE_PR_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table PRODUCT_PRICE
   add constraint FK_PRODUCT__PPRICE_PT_PRICE_TY foreign key (PRICE_TYPE_ID)
      references PRICE_TYPE (ID);

alter table PRODUCT_PRICE
   add constraint FK_PRODUCT__PPRICE_UN_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table PRODUCT_REGISTER
   add constraint FK_PRODUCT__GR_PERIOD_PERIOD foreign key (PERIOD_ID)
      references PERIOD (ID);

alter table PRODUCT_REGISTER
   add constraint FK_PRODUCT__PR_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table PRODUCT_REGISTER
   add constraint FK_PRODUCT__PR_PROD_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table PRODUCT_UNIT
   add constraint FK_PRODUCT__PUNIT_PRO_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table PRODUCT_UNIT
   add constraint FK_PRODUCT__PUNIT_UNI_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table PROJECT
   add constraint FK_PROJECT_CURRENCY__CURRENCY foreign key (CURRENCY_ID)
      references CURRENCY (ID);

alter table PROJECT
   add constraint FK_PROJECT_ORG_PROJE_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table PROJECT
   add constraint FK_PROJECT_PRJ_TAX_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table PROJECT
   add constraint FK_PROJECT_PRJ_TYPE__PROJECT_ foreign key (PROJECT_TYPE_ID)
      references PROJECT_TYPE (ID);

alter table PROJECT
   add constraint FK_PROJECT_PRT_PROJE_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table PROJECT
   add constraint FK_PROJECT_RESPONSIB_EMPLOYEE foreign key (RESPONSIBLE_ID)
      references EMPLOYEE (ID);

alter table PROJECT
   add constraint FK_PROJECT_STAGE_PRO_PROJECT_ foreign key (PROJECT_STAGE_ID)
      references PROJECT_STAGE (ID);

alter table PROJECT
   add constraint FK_PROJECT_STATUS_PR_PROJECT_ foreign key (PROJECT_STATUS_ID)
      references PROJECT_STATUS (ID);

alter table PROJECT_CONTACT_LINK
   add constraint FK_PROJECT__PRJ_CNT_C_CONTACT foreign key (CONTACT_ID)
      references CONTACT (ID);

alter table PROJECT_CONTACT_LINK
   add constraint FK_PROJECT__PRJ_PRJ_C_PROJECT foreign key (PROJECT_ID)
      references PROJECT (ID);

alter table PROJECT_CONTACT_LINK
   add constraint FK_PROJECT__PRJ_ROLE_PROJECT_ foreign key (PROJECT_ROLE_ID)
      references PROJECT_ROLE (ID);

alter table PROJECT_CONTEXT
   add constraint FK_PROJECT__PCX_PSTG_PROJECT_ foreign key (PROJECT_STAGE_ID)
      references PROJECT_STAGE (ID);

alter table PROJECT_CONTEXT
   add constraint FK_PROJECT__PCX_PSTT_PROJECT_ foreign key (PROJECT_STATUS_ID)
      references PROJECT_STATUS (ID);

alter table PROJECT_CONTEXT
   add constraint FK_PROJECT__PCX_PTP_PROJECT_ foreign key (PROJECT_TYPE_ID)
      references PROJECT_TYPE (ID);

alter table PROJECT_CONTEXT
   add constraint FK_PROJECT__PRJ_CTX_C_CURRENCY foreign key (CURRENCY_ID)
      references CURRENCY (ID);

alter table PROJECT_CONTEXT
   add constraint FK_PROJECT__PRJ_CTX_E_EMPLOYEE foreign key (RESPONSIBLE_ID)
      references EMPLOYEE (ID);

alter table PROJECT_CONTEXT
   add constraint FK_PROJECT__PRJ_CTX_P_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table PROJECT_EMPLOYEE_LINK
   add constraint FK_PROJECT__PRJ_EMP_E_EMPLOYEE foreign key (EMPLOYEE_ID)
      references EMPLOYEE (ID);

alter table PROJECT_EMPLOYEE_LINK
   add constraint FK_PROJECT__PRJ_EMP_P_PROJECT foreign key (PROJECT_ID)
      references PROJECT (ID);

alter table PROJECT_EMPLOYEE_LINK
   add constraint FK_PROJECT__PRJ_EMP_P_PROJECT_ foreign key (PROJECT_ROLE_ID)
      references PROJECT_ROLE (ID);

alter table PROJECT_STAGE
   add constraint FK_PROJECT__PRJ_STAGE_PROJECT_ foreign key (PROJECT_STAGE_GROUP_ID)
      references PROJECT_STAGE_GROUP (ID);

alter table PROJECT_STAGE
   add constraint FK_PROJECT__PRJ_TYPE__PROJECT_ foreign key (PROJECT_TYPE_ID)
      references PROJECT_TYPE (ID);

alter table PROJECT_STAGE_LINK
   add constraint FK_PROJECT__PRG_PRG_S_PROJECT foreign key (PROJECT_ID)
      references PROJECT (ID);

alter table PROJECT_STAGE_LINK
   add constraint FK_PROJECT__PRG_STAGE_PROJECT_ foreign key (PROJECT_STAGE_ID)
      references PROJECT_STAGE (ID);

alter table PURCHASE_ORDER
   add constraint FK_PURCHASE_PCHORD_RE_RESPONSI foreign key (RESPONSIBLE_ID)
      references RESPONSIBLE (ID);

alter table PURCHASE_ORDER
   add constraint FK_PURCHASE_PCHORD_WR_WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table PURCHASE_ORDER
   add constraint FK_PURCHASE_PO_PT_PRICE_TY foreign key (PRICE_TYPE_ID)
      references PRICE_TYPE (ID);

alter table PURCHASE_ORDER_ITEM
   add constraint FK_PURCHASE_PCHORD_IT_PURCHASE foreign key (PURCHASE_ORDER_ID)
      references PURCHASE_ORDER (ID);

alter table PURCHASE_ORDER_ITEM
   add constraint FK_PURCHASE_PCHORD_IT_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table PURCHASE_ORDER_ITEM
   add constraint FK_PURCHASE_PCHORD_IT_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table PURCHASE_ORDER_ITEM
   add constraint FK_PURCHASE_PURCHASEO_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table PURCHASE_PLAN
   add constraint FK_PURCHASE_PURCHASE__PRICE_TY foreign key (PRICE_TYPE_ID)
      references PRICE_TYPE (ID);

alter table PURCHASE_PLAN
   add constraint FK_PURCHASE_PURCHASE__RESPONSI foreign key (RESPONSIBLE_ID)
      references RESPONSIBLE (ID);

alter table PURCHASE_PLAN_ITEM
   add constraint FK_PURCHASE_PURCHASEP_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table PURCHASE_PLAN_ITEM
   add constraint FK_PURCHASE_PURCHASE__PURCHASE foreign key (PURCHASE_PLAN_ID)
      references PURCHASE_PLAN (ID);

alter table PURCHASE_PLAN_ITEM
   add constraint FK_PURCHASE_PURCHASE__TAX foreign key (TAX_ID)
      references TAX (ID);

alter table PURCHASE_PLAN_ITEM
   add constraint FK_PURCHASE_PURCHASE__UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table REGION
   add constraint FK_REGION_REGION_CO_COUNTRY foreign key (COUNTRY_ID)
      references COUNTRY (ID);

alter table RESPONSIBLE
   add constraint FK_RESPONSI_RESPONSIB_EMPLOYEE foreign key (EMPLOYEE_ID)
      references EMPLOYEE (ID);

alter table RESPONSIBLE
   add constraint FK_RESPONSI_RESPONSIB_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table RESPONSIBLE
   add constraint FK_RESPONSI_RESPONSIB_WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table SALE_ORDER
   add constraint FK_SALE_ORD_SALORD_RE_RESPONSI foreign key (RESPONSIBLE_ID)
      references RESPONSIBLE (ID);

alter table SALE_ORDER
   add constraint FK_SALE_ORD_SALORD_WR_WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table SALE_ORDER
   add constraint FK_SALE_ORD_SO_ADR_ADDRESS foreign key (DELIVERY_ADDRESS_ID)
      references ADDRESS (ID);

alter table SALE_ORDER
   add constraint FK_SALE_ORD_SO_PT_PRICE_TY foreign key (PRICE_TYPE_ID)
      references PRICE_TYPE (ID);

alter table SALE_ORDER_ITEM
   add constraint FK_SALE_ORD_SALEORD_I_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table SALE_ORDER_ITEM
   add constraint FK_SALE_ORD_SALEORD_P_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table SALE_ORDER_ITEM
   add constraint FK_SALE_ORD_SALORD_IT_SALE_ORD foreign key (SALE_ORDER_ID)
      references SALE_ORDER (ID);

alter table SALE_ORDER_ITEM
   add constraint FK_SALE_ORD_SALORD_IT_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table SALE_PLAN
   add constraint FK_SALE_PLA_SALE_PLAN_PRICE_TY foreign key (PRICE_TYPE_ID)
      references PRICE_TYPE (ID);

alter table SALE_PLAN
   add constraint FK_SALE_PLA_SALE_PLAN_RESPONSI foreign key (RESPONSIBLE_ID)
      references RESPONSIBLE (ID);

alter table SALE_PLAN_ITEM
   add constraint FK_SALE_PLA_SALEPLAN__PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table SALE_PLAN_ITEM
   add constraint FK_SALE_PLA_SALE_PLAN_SALE_PLA foreign key (SALE_PLAN_ID)
      references SALE_PLAN (ID);

alter table SALE_PLAN_ITEM
   add constraint FK_SALE_PLA_SPI_TAX_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table SALE_PLAN_ITEM
   add constraint FK_SALE_PLA_SPI_UNIT_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table SECURE_OBJECT
   add constraint FK_SECURE_O_SE_ENTITY_SYSTEM_E foreign key (ENTITY_ID)
      references SYSTEM_ENTITY (ID);

alter table SHOP
   add constraint FK_SHOP_SHOP_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table STORE
   add constraint FK_STORE_STORE_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table SYSTEM_ATTR
   add constraint FK_SYSTEM_A_SA_SA_TYP_SYSTEM_A foreign key (ATTR_TYPE_ID)
      references SYSTEM_ATTR_TYPE (ID);

alter table SYSTEM_ATTR
   add constraint FK_SYSTEM_A_SA_SE_SYSTEM_E foreign key (ENTITY_ID)
      references SYSTEM_ENTITY (ID);

alter table SYSTEM_ATTR_TYPE
   add constraint FK_SYSTEM_A_SA_T_SYSTEM_E foreign key (ENTITY_ID)
      references SYSTEM_ENTITY (ID);

alter table SYSTEM_ATTR_TYPE
   add constraint FK_SYSTEM_A_SA_T_DAT__DATA_TYP foreign key (DATA_TYPE_ID)
      references DATA_TYPE (ID);

alter table SYSTEM_ATTR_TYPE
   add constraint FK_SYSTEM_A_SA_T_SA_T_SYSTEM_A foreign key (ATTR_TYPE_GROUP_ID)
      references SYSTEM_ATTR_TYPE_GROUP (ID);

alter table SYSTEM_ATTR_TYPE_GROUP
   add constraint FK_SYSTEM_A_SA_TG_SE_SYSTEM_E foreign key (ENTITY_ID)
      references SYSTEM_ENTITY (ID);

alter table SYSTEM_ENTITY
   add constraint FK_SYSTEM_E_ENTITY_EN_SYSTEM_E foreign key (ENTITY_TYPE_ID)
      references SYSTEM_ENTITY_TYPE (ID);

alter table SYSTEM_ENUMERATION
   add constraint FK_SYSTEM_E_ENUM_ENTI_SYSTEM_E foreign key (ENTITY_ID)
      references SYSTEM_ENTITY (ID);

alter table SYSTEM_FILE
   add constraint FK_SYSTEM_F_SF_SF_STO_SYSTEM_F foreign key (FILE_STORAGE_ID)
      references SYSTEM_FILE_STORAGE (ID);

alter table SYSTEM_FILE
   add constraint FK_SYSTEM_F_SF_SF_TYP_SYSTEM_F foreign key (FILE_TYPE_ID)
      references SYSTEM_FILE_TYPE (ID);

alter table SYSTEM_FILE
   add constraint FK_SYSTEM_F_SF_SYS_E_SYSTEM_E foreign key (ENTITY_ID)
      references SYSTEM_ENTITY (ID);

alter table SYSTEM_IMAGE
   add constraint FK_SYSTEM_I_SI_SF_TYP_SYSTEM_F foreign key (FILE_TYPE_ID)
      references SYSTEM_FILE_TYPE (ID);

alter table SYSTEM_IMAGE
   add constraint FK_SYSTEM_I_SI_SI_STO_SYSTEM_I foreign key (IMAGE_STORAGE_ID)
      references SYSTEM_IMAGE_STORAGE (ID);

alter table SYSTEM_IMAGE
   add constraint FK_SYSTEM_I_SI_SYS_E_SYSTEM_E foreign key (ENTITY_ID)
      references SYSTEM_ENTITY (ID);

alter table SYSTEM_INFO
   add constraint FK_SYSTEM_I_SI_CST_PARTNER foreign key (CUSTOMER_ID)
      references PARTNER (ID);

alter table SYSTEM_INFO
   add constraint FK_SYSTEM_I_SI_EMP_EMPLOYEE foreign key (RESPONSIBLE_ID)
      references EMPLOYEE (ID);

alter table SYSTEM_INFO
   add constraint FK_SYSTEM_I_SI_IWRH_WAREHOUS foreign key (INCOME_WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table SYSTEM_INFO
   add constraint FK_SYSTEM_I_SI_OWRH_WAREHOUS foreign key (OUTCOME_WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table SYSTEM_INFO
   add constraint FK_SYSTEM_I_SI_PRT_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table SYSTEM_INFO
   add constraint FK_SYSTEM_I_SI_RSP_RESPONSI foreign key (MATERIAL_RESPONSIBLE_ID)
      references RESPONSIBLE (ID);

alter table SYSTEM_INFO
   add constraint FK_SYSTEM_I_SI_SPP_PARTNER foreign key (SUPPLIER_ID)
      references PARTNER (ID);

alter table SYSTEM_INFO
   add constraint FK_SYSTEM_I_SI_WRH_WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table SYSTEM_INFO
   add constraint FK_SYSTEM_I_SYS_CURRE_CURRENCY foreign key (CURRENCY_ID)
      references CURRENCY (ID);

alter table SYSTEM_INFO
   add constraint FK_SYSTEM_I_SYS_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table SYSTEM_INFO
   add constraint FK_SYSTEM_I_SYS_PERIO_PERIOD foreign key (PERIOD_ID)
      references PERIOD (ID);

alter table SYSTEM_INFO
   add constraint FK_SYSTEM_I_SYS_TAX_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table SYSTEM_INFO
   add constraint FK_SYSTEM_I_SYS_UNIT_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table SYSTEM_MONTH
   add constraint FK_SYSTEM_M_MONTH_QUA_SYSTEM_Q foreign key (QUARTER_ID)
      references SYSTEM_QUARTER (ID);

alter table SYSTEM_PERMISSION
   add constraint FK_SYSTEM_P_PERMISSIO_SECURE_O foreign key (SECURE_ENTITY_ID)
      references SECURE_OBJECT (ID);

alter table SYSTEM_PERMISSION
   add constraint FK_SYSTEM_P_PERMISSIO_SYSTEM_R foreign key (ROLE_ID)
      references SYSTEM_ROLE (ID);

alter table SYSTEM_REFERENCE
   add constraint FK_SYSTEM_R_REF_ENTIT_SYSTEM_E foreign key (ENTITY_ID)
      references SYSTEM_ENTITY (ID);

alter table SYSTEM_USER
   add constraint FK_SYSTEM_U_USER_ENTI_SYSTEM_E foreign key (ENTITY_ID)
      references SYSTEM_ENTITY (ID);

alter table SYSTEM_USER_ROLE
   add constraint FK_SYSTEM_U_UR_ROLE_SYSTEM_R foreign key (ROLE_ID)
      references SYSTEM_ROLE (ID);

alter table SYSTEM_USER_ROLE
   add constraint FK_SYSTEM_U_UR_USER_SYSTEM_U foreign key (USER_ID)
      references SYSTEM_USER (ID);

alter table SYSTEM_VARIABLE
   add constraint FK_SYSTEM_V_SYSVAR_DA_DATA_TYP foreign key (DATA_TYPE_ID)
      references DATA_TYPE (ID);

alter table SYSTEM_VARIABLE
   add constraint FK_SYSTEM_V_SYSVAR_SY_SYSTEM_E foreign key (ENTITY_ID)
      references SYSTEM_ENTITY (ID);

alter table TASK
   add constraint FK_TASK_DOC_TASK_DOCUMENT foreign key (DOCUMENT_ID)
      references DOCUMENT (ID);

alter table TASK
   add constraint FK_TASK_ORG_TASK_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table TASK
   add constraint FK_TASK_PRJ_TASK_PROJECT foreign key (PROJECT_ID)
      references PROJECT (ID);

alter table TASK
   add constraint FK_TASK_PRT_TASK_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table TASK
   add constraint FK_TASK_RESPONSIB_EMPLOYEE foreign key (RESPONSIBLE_ID)
      references EMPLOYEE (ID);

alter table TASK
   add constraint FK_TASK_RESULT_TA_TASK_RES foreign key (TASK_RESULT_ID)
      references TASK_RESULT (ID);

alter table TASK
   add constraint FK_TASK_TASK_PRIO_TASK_PRI foreign key (TASK_PRIORITY_ID)
      references TASK_PRIORITY (ID);

alter table TASK
   add constraint FK_TASK_TASK_STAT_TASK_STA foreign key (TASK_STATUS_ID)
      references TASK_STATUS (ID);

alter table TASK
   add constraint FK_TASK_TYPE_TASK_TASK_TYP foreign key (TASK_TYPE_ID)
      references TASK_TYPE (ID);

alter table TASK_CONTACT_LINK
   add constraint FK_TASK_CON_TASK_CNT__CONTACT foreign key (CONTACT_ID)
      references CONTACT (ID);

alter table TASK_CONTACT_LINK
   add constraint FK_TASK_CON_TASK_ROLE_TASK_ROL foreign key (TASK_ROLE_ID)
      references TASK_ROLE (ID);

alter table TASK_CONTACT_LINK
   add constraint FK_TASK_CON_TASK_TSK__TASK foreign key (TASK_ID)
      references TASK (ID);

alter table TASK_CONTEXT
   add constraint FK_TASK_CON_TSK_CTX_E_EMPLOYEE foreign key (RESPONSIBLE_ID)
      references EMPLOYEE (ID);

alter table TASK_CONTEXT
   add constraint FK_TASK_CON_TSK_CTX_P_PROJECT foreign key (PROJECT_ID)
      references PROJECT (ID);

alter table TASK_CONTEXT
   add constraint FK_TASK_CON_TSK_CTX_P_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

alter table TASK_CONTEXT
   add constraint FK_TASK_CON_TSK_CTX_T_TASK_PRI foreign key (TASK_PRIORITY_ID)
      references TASK_PRIORITY (ID);

alter table TASK_CONTEXT
   add constraint FK_TASK_CON_TSK_CTX_T_TASK_RES foreign key (TASK_RESULT_ID)
      references TASK_RESULT (ID);

alter table TASK_CONTEXT
   add constraint FK_TASK_CON_TSK_CTX_T_TASK_STA foreign key (TASK_STATUS_ID)
      references TASK_STATUS (ID);

alter table TASK_CONTEXT
   add constraint FK_TASK_CON_TSK_CTX_T_TASK_TYP foreign key (TASK_TYPE_ID)
      references TASK_TYPE (ID);

alter table TASK_EMPLOYEE_LINK
   add constraint FK_TASK_EMP_TSK_EMP_E_EMPLOYEE foreign key (EMPLOYEE_ID)
      references EMPLOYEE (ID);

alter table TASK_EMPLOYEE_LINK
   add constraint FK_TASK_EMP_TSK_EMP_T_TASK foreign key (TASK_ID)
      references TASK (ID);

alter table TASK_EMPLOYEE_LINK
   add constraint FK_TASK_EMP_TSK_EMP_T_TASK_ROL foreign key (TASK_ROLE_ID)
      references TASK_ROLE (ID);

alter table TASK_RESULT
   add constraint FK_TASK_RES_TYPE_TASK_TASK_TYP foreign key (TASK_TYPE_ID)
      references TASK_TYPE (ID);

alter table TAX_WAYBILL_ITEM
   add constraint FK_TAX_WAYB_TAXWBL_IT_TAX_WAYB foreign key (TAX_WAYBILL_ID)
      references TAX_WAYBILL (ID);

alter table TAX_WAYBILL_ITEM
   add constraint FK_TAX_WAYB_TAXWBL_PR_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table TAX_WAYBILL_ITEM
   add constraint FK_TAX_WAYB_TAXWBL_TA_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table TAX_WAYBILL_ITEM
   add constraint FK_TAX_WAYB_TAXWBL_UN_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table TEMPLATE_ENTRY
   add constraint FK_TEMPLATE_TEMPL_ENT_FINANCE_ foreign key (FINANCE_DOCUMENT_TYPE_ID)
      references FINANCE_DOCUMENT_TYPE (ID);

alter table TEMPLATE_ENTRY_ITEM
   add constraint FK_TEMPLATE_CTEI_LA_LEDGER_A foreign key (CREDIT_LEDACC_ID)
      references LEDGER_ACCOUNT (ID);

alter table TEMPLATE_ENTRY_ITEM
   add constraint FK_TEMPLATE_DTEI_LA_LEDGER_A foreign key (DEBIT_LEDACC_ID)
      references LEDGER_ACCOUNT (ID);

alter table TEMPLATE_ENTRY_ITEM
   add constraint FK_TEMPLATE_TEMPL_ENT_TEMPLATE foreign key (TEMPLATE_ENTRY_ID)
      references TEMPLATE_ENTRY (ID);

alter table WAREHOUSE_ENTITY
   add constraint FK_WAREHOUS_WRH_ENTIT_SYSTEM_E foreign key (ENTITY_ID)
      references SYSTEM_ENTITY (ID);

alter table WAREHOUSE_MOVE
   add constraint FK_WAREHOUS_WRH_MOVE__FINANCE_ foreign key (OWNER_ID)
      references FINANCE_DOCUMENT (ID);

alter table WAREHOUSE_MOVE
   add constraint FK_WAREHOUS_WRH_MOVE__RESPONSI foreign key (RESPONSIBLE_ID)
      references RESPONSIBLE (ID);

alter table WAREHOUSE_MOVE
   add constraint FK_WAREHOUS_WRH_MOVE__WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table WEB
   add constraint FK_WEB_WEB_CONTA_CONTACTA foreign key (CONTACTABLE_ID)
      references CONTACTABLE (ID);

alter table WORKS
   add constraint FK_WORKS_WORKS_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table WORKSHOP
   add constraint FK_WORKSHOP_WORKSHOPS_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

