

alter table ADDRESS
   drop constraint FK_ADDRESS_ADDRESS_A_ADDRESS_;


alter table ADDRESS
   drop constraint FK_ADDRESS_ADDRESS_A_APPARTME;


alter table ADDRESS
   drop constraint FK_ADDRESS_ADDRESS_C_CITY;


alter table ADDRESS
   drop constraint FK_ADDRESS_ADDRESS_C_CONTACTA;


alter table ADDRESS
   drop constraint FK_ADDRESS_ADDRESS_L_LOCALITY;


alter table ADDRESS
   drop constraint FK_ADDRESS_ADDRESS_S_STREET_T;


alter table ASSET
   drop constraint FK_ASSET_ASS_ASS_C_ASSET_CL;


alter table BANK_ACCOUNT
   drop constraint FK_BANK_ACC_BANKACC_B_BANK;


alter table BANK_ACCOUNT
   drop constraint FK_BANK_ACC_BANKACC_P_PARTNER;


alter table BANK_CONTEXT
   drop constraint FK_BANK_CON_BNK_CTX_I_PARTNER;


alter table BANK_CONTEXT
   drop constraint FK_BANK_CON_BNK_CTX_O_PARTNER;


alter table BANK_CONTEXT
   drop constraint FK_BANK_CON_BNK_CTX_P_PAYMENT_;


alter table BANK_CONTEXT
   drop constraint FK_BANK_CON_BNK_CTX_P_PARTNER;


alter table BANK_CONTEXT
   drop constraint FK_BANK_CON_BNK_CTX_T_TAXPRINT;


alter table BRIGADE
   drop constraint FK_BRIGADE_BRIGADE_O_ORGANIZA;


alter table BUSINESSABLE
   drop constraint FK_BUSINESS_BUSINESS__SYSTEM_E;


alter table BUSINESSABLE_ENTITY
   drop constraint FK_BUSINESS_BUS_ENTIT_SYSTEM_E;


alter table BUSINESSABLE_REGISTER
   drop constraint FK_BUSINESS_BSREG_ORG_ORGANIZA;


alter table BUSINESSABLE_REGISTER
   drop constraint FK_BUSINESS_BSREG_PER_PERIOD;


alter table BUSINESSABLE_REGISTER
   drop constraint FK_BUSINESS_REGISTER__BUSINESS;


alter table CASH_INCOME
   drop constraint FK_CASH_INC_CASH_INC__CONTRACT;


alter table CASH_OUTCOME
   drop constraint FK_CASH_OUT_CASH_OUT__CONTRACT;


alter table CONTACT
   drop constraint FK_CONTACT_DEPARTMEN_DEPARTME;


alter table CONTACT
   drop constraint FK_CONTACT_ORG_CONTA_ORGANIZA;


alter table CONTACT
   drop constraint FK_CONTACT_POSITION__POSITION;


alter table CONTACT
   drop constraint FK_CONTACT_PRT_CONTA_PARTNER;


alter table CONTACT
   drop constraint FK_CONTACT_RESPONSIB_EMPLOYEE;


alter table CONTACT
   drop constraint FK_CONTACT_TYPE_CONT_CONTACT_;


alter table CONTACTABLE
   drop constraint FK_CONTACTA_CONTACTAB_SYSTEM_E;


alter table CONTACTABLE
   drop constraint FK_CONTACTA_CONT_ADD_ADDRESS;


alter table CONTACTABLE
   drop constraint FK_CONTACTA_CONT_EML_EMAIL;


alter table CONTACTABLE
   drop constraint FK_CONTACTA_CONT_PHO_PHONE;


alter table CONTACTABLE
   drop constraint FK_CONTACTA_CONT_WEB_WEB;


alter table CONTACTABLE_ENTITY
   drop constraint FK_CONTACTA_CNT_ENTIT_SYSTEM_E;


alter table CONTACT_CONTEXT
   drop constraint FK_CONTACT__CNT_CTX_A_ADDRESS_;


alter table CONTACT_CONTEXT
   drop constraint FK_CONTACT__CNT_CTX_C_CONTACT_;


alter table CONTACT_CONTEXT
   drop constraint FK_CONTACT__CNT_CTX_P_PHONE_TY;


alter table CONTACT_CONTEXT
   drop constraint FK_CONTACT__CNT_CTX_R_EMPLOYEE;


alter table CONTRACT
   drop constraint FK_CONTRACT_CONTRACT__PARTNER;


alter table CONTRACTOR_MOVE
   drop constraint FK_CONTRACT_CTR_MOVE__CONTRACT;


alter table CONTRACTOR_MOVE
   drop constraint FK_CONTRACT_CTR_MOVE__FINANCE_;


alter table DEPARTMENT
   drop constraint FK_DEPARTME_DEP_ORG_ORGANIZA;


alter table DISTRICT
   drop constraint FK_DISTRICT_DISTRICT__REGION;


alter table DOCUMENT
   drop constraint FK_DOCUMENT_DOC_CONTR_CONTRACT;


alter table DOCUMENT
   drop constraint FK_DOCUMENT_DOC_DEP_DEPARTME;


alter table DOCUMENT
   drop constraint FK_DOCUMENT_DOC_DOC_T_DOCUMENT;


alter table DOCUMENT
   drop constraint FK_DOCUMENT_DOC_ORG_ORGANIZA;


alter table DOCUMENT
   drop constraint FK_DOCUMENT_DOC_PARTN_PARTNER;


alter table DOCUMENT
   drop constraint FK_DOCUMENT_DOC_PERIO_PERIOD;


alter table DOCUMENT
   drop constraint FK_DOCUMENT_DOC_PRJ_PROJECT;


alter table DOCUMENT
   drop constraint FK_DOCUMENT_DOC_STATU_DOCUMENT;


alter table DOCUMENT
   drop constraint FK_DOCUMENT_DOC_USR_SYSTEM_U;


alter table DOCUMENT
   drop constraint FK_DOCUMENT_REASON_DO_DOCUMENT;


alter table DOCUMENT_ATTR
   drop constraint FK_DOCUMENT_DA_DA_T_DOCUMENT;


alter table DOCUMENT_ATTR
   drop constraint FK_DOCUMENT_DA_DT_DOCUMENT;


alter table DOCUMENT_ATTR
   drop constraint FK_DOCUMENT_DOC_ATTR__DOCUMENT;


alter table DOCUMENT_ATTR_TYPE
   drop constraint FK_DOCUMENT_DA_T_DOCUMENT;


alter table DOCUMENT_ATTR_TYPE
   drop constraint FK_DOCUMENT_DA_T_DA_T_DOCUMENT;


alter table DOCUMENT_ATTR_TYPE
   drop constraint FK_DOCUMENT_DA_T_DT_DATA_TYP;


alter table DOCUMENT_ATTR_TYPE_GROUP
   drop constraint FK_DOCUMENT_DA_TG_DOCUMENT;


alter table DOCUMENT_FILE
   drop constraint FK_DOCUMENT_DF_DOC_TY_DOCUMENT;


alter table DOCUMENT_FILE
   drop constraint FK_DOCUMENT_DF_SF_STO_SYSTEM_F;


alter table DOCUMENT_FILE
   drop constraint FK_DOCUMENT_DF_SF_TYP_SYSTEM_F;


alter table DOCUMENT_FILE
   drop constraint FK_DOCUMENT_DOC_FILE__DOCUMENT;


alter table DOCUMENT_IMAGE
   drop constraint FK_DOCUMENT_DI_DOC_TY_DOCUMENT;


alter table DOCUMENT_IMAGE
   drop constraint FK_DOCUMENT_DI_SF_TYP_SYSTEM_F;


alter table DOCUMENT_IMAGE
   drop constraint FK_DOCUMENT_DI_SI_STO_SYSTEM_I;


alter table DOCUMENT_IMAGE
   drop constraint FK_DOCUMENT_DOC_IMAGE_DOCUMENT;


alter table DOCUMENT_STATUS
   drop constraint FK_DOCUMENT_DOC_STAT__DOCUMENT;


alter table DOCUMENT_TYPE
   drop constraint FK_DOCUMENT_DOCUMENT__SYSTEM_E;


alter table DOCUMENT_TYPE_ITEM
   drop constraint FK_DOCUMENT_DTI_DT_DOCUMENT;


alter table DRUGSTORE
   drop constraint FK_DRUGSTOR_DRUGSTORE_ORGANIZA;


alter table EMAIL
   drop constraint FK_EMAIL_EMAIL_CON_CONTACTA;


alter table EMPLOYEE
   drop constraint FK_EMPLOYEE_EMP_DEP_DEPARTME;


alter table EMPLOYEE
   drop constraint FK_EMPLOYEE_EMP_ECAT_EMPLOYEE;


alter table EMPLOYEE
   drop constraint FK_EMPLOYEE_EMP_LA_LEDGER_A;


alter table EMPLOYEE
   drop constraint FK_EMPLOYEE_EMP_ORG_ORGANIZA;


alter table EMPLOYEE
   drop constraint FK_EMPLOYEE_EMP_PFORM_PAYROLL_;


alter table EMPLOYEE
   drop constraint FK_EMPLOYEE_EMP_POS_POSITION;


alter table EMPLOYEE
   drop constraint FK_EMPLOYEE_EMP_PRS_PERSON;


alter table EMPLOYEE
   drop constraint FK_EMPLOYEE_EMP_RANK_EMPLOYEE;


alter table EMPLOYEE_DISCHARGE
   drop constraint FK_EMPLOYEE_EMPDIS_DT_DISCHARG;


alter table EMPLOYEE_DISCHARGE
   drop constraint FK_EMPLOYEE_EMP_DIS_EMPLOYEE;


alter table EMPLOYEE_MOVE
   drop constraint FK_EMPLOYEE_EMP_MOVE__EMPLOYEE;


alter table EMPLOYEE_MOVE
   drop constraint FK_EMPLOYEE_EMP_MOVE__FINANCE_;


alter table EMPLOYEE_PAYROLL
   drop constraint FK_EMPLOYEE_EMPPAY_EM_EMPLOYEE;


alter table EMPLOYEE_PAYROLL
   drop constraint FK_EMPLOYEE_EMPPAY_OR_ORGANIZA;


alter table EMPLOYEE_PAYROLL
   drop constraint FK_EMPLOYEE_EMPPAY_PA_PAYROLL;


alter table EMPLOYEE_PAYROLL
   drop constraint FK_EMPLOYEE_EMPPAY_PE_PERIOD;


alter table EMPLOYEE_RECEPTION
   drop constraint FK_EMPLOYEE_EMPREC_CA_EMPLOYEE;


alter table EMPLOYEE_RECEPTION
   drop constraint FK_EMPLOYEE_EMPREC_DE_DEPARTME;


alter table EMPLOYEE_RECEPTION
   drop constraint FK_EMPLOYEE_EMPREC_EM_EMPLOYEE;


alter table EMPLOYEE_RECEPTION
   drop constraint FK_EMPLOYEE_EMPREC_PF_PAYROLL_;


alter table EMPLOYEE_RECEPTION
   drop constraint FK_EMPLOYEE_EMPREC_PR_PERSON;


alter table EMPLOYEE_SICKLIST
   drop constraint FK_EMPLOYEE_EMPSIC_EM_EMPLOYEE;


alter table EMPLOYEE_SICKLIST
   drop constraint FK_EMPLOYEE_ESC_SCAT_SICKLIST;


alter table EMPLOYEE_SICKLIST
   drop constraint FK_EMPLOYEE_ESC_SCLST_SICKLIST;


alter table EMPLOYEE_SICKLIST
   drop constraint FK_EMPLOYEE_ESC_SCTP_SICK_TYP;


alter table EMPLOYEE_SICKLIST_AVERANGE
   drop constraint FK_EMPLOYEE_EMPSICAVG_EMPLOYEE;


alter table EMPLOYEE_TOTAL
   drop constraint FK_EMPLOYEE_EMPTOT_EM_EMPLOYEE;


alter table EMPLOYEE_TOTAL
   drop constraint FK_EMPLOYEE_EMPTOT_PE_PERIOD;


alter table EMPLOYEE_VACATION
   drop constraint FK_EMPLOYEE_EMPLEA_EM_EMPLOYEE;


alter table EMPLOYEE_VACATION
   drop constraint FK_EMPLOYEE_EV_ADDVCL_VACATION;


alter table EMPLOYEE_VACATION
   drop constraint FK_EMPLOYEE_EV_VAT_VACATION;


alter table EMPLOYEE_VACATION
   drop constraint FK_EMPLOYEE_EV_VCL_VACATION;


alter table EMPLOYEE_VACATION
   drop constraint FK_EMPLOYEE_EV_VTP_VACATION;


alter table EMPLOYEE_VACATION_AVERANGE
   drop constraint FK_EMPLOYEE_EMPVACAVR_EMPLOYEE;


alter table ENTRY_ITEM
   drop constraint FK_ENTRY_IT_CDT_ENTRY_LEDGER_A;


alter table ENTRY_ITEM
   drop constraint FK_ENTRY_IT_CDT_EN_IT_BUSINESS;


alter table ENTRY_ITEM
   drop constraint FK_ENTRY_IT_DBT_ENTRY_LEDGER_A;


alter table ENTRY_ITEM
   drop constraint FK_ENTRY_IT_DBT_EN_IT_BUSINESS;


alter table ENTRY_ITEM
   drop constraint FK_ENTRY_IT_ENTRY_ITE_FINANCE_;


alter table EXEC_WORK_ITEM
   drop constraint FK_EXEC_WOR_EWORK_ITE_EXEC_WOR;


alter table EXEC_WORK_ITEM
   drop constraint FK_EXEC_WOR_EWORK_ITE_TAX;


alter table EXEC_WORK_ITEM
   drop constraint FK_EXEC_WOR_EWORK_ITE_UNIT;


alter table EXEC_WORK_ITEM
   drop constraint FK_EXEC_WOR_EWORK_PRO_PRODUCT;


alter table FACTORY
   drop constraint FK_FACTORY_FACTORY_O_ORGANIZA;


alter table FINANCE_DOCUMENT
   drop constraint FK_FINANCE__FINDOC_CU_CURRENCY;


alter table FINANCE_DOCUMENT
   drop constraint FK_FINANCE__FINDOC_TA_TAX;


alter table FINANCE_DOCUMENT_TYPE
   drop constraint FK_FINANCE__FINDOC_TY_DOCUMENT;


alter table GOODS
   drop constraint FK_GOODS_GDS_COUNT_COUNTRY;


alter table GOODS
   drop constraint FK_GOODS_GDS_GDSTY_GOODS_TY;


alter table GOODS_INCOME
   drop constraint FK_GOODS_IN_GDS_IN_WR_WAREHOUS;


alter table GOODS_INCOME
   drop constraint FK_GOODS_IN_GINCOME_R_RESPONSI;


alter table GOODS_INCOME_ITEM
   drop constraint FK_GOODS_IN_GINCOME_I_GOODS_IN;


alter table GOODS_INCOME_ITEM
   drop constraint FK_GOODS_IN_GINCOME_P_PRODUCT;


alter table GOODS_INCOME_ITEM
   drop constraint FK_GOODS_IN_GINCOME_T_TAX;


alter table GOODS_INCOME_ITEM
   drop constraint FK_GOODS_IN_GINCOME_U_UNIT;


alter table GOODS_MOVE
   drop constraint FK_GOODS_MO_GDM_IN_WR_WAREHOUS;


alter table GOODS_MOVE
   drop constraint FK_GOODS_MO_GDM_OUT_W_WAREHOUS;


alter table GOODS_MOVE
   drop constraint FK_GOODS_MO_GMOVE_INC_RESPONSI;


alter table GOODS_MOVE
   drop constraint FK_GOODS_MO_GMOVE_OUT_RESPONSI;


alter table GOODS_MOVE_ITEM
   drop constraint FK_GOODS_MO_GDSMI_TAX_TAX;


alter table GOODS_MOVE_ITEM
   drop constraint FK_GOODS_MO_GDSMI_UN_UNIT;


alter table GOODS_MOVE_ITEM
   drop constraint FK_GOODS_MO_GMOVE_ITE_GOODS_MO;


alter table GOODS_MOVE_ITEM
   drop constraint FK_GOODS_MO_GMOVE_PRO_PRODUCT;


alter table GOODS_OUTCOME
   drop constraint FK_GOODS_OU_GDS_OUT_W_WAREHOUS;


alter table GOODS_OUTCOME
   drop constraint FK_GOODS_OU_GOUTCOME__RESPONSI;


alter table GOODS_OUTCOME_ITEM
   drop constraint FK_GOODS_OU_GOUTCOME__GOODS_OU;


alter table GOODS_OUTCOME_ITEM
   drop constraint FK_GOODS_OU_GOUTCOME__TAX;


alter table GOODS_OUTCOME_ITEM
   drop constraint FK_GOODS_OU_GOUTCOME__UNIT;


alter table GOODS_OUTCOME_ITEM
   drop constraint FK_GOODS_OU_GOUTCONE__PRODUCT;


alter table GOODS_REST
   drop constraint FK_GOODS_RE_GDSR_RE_RESPONSI;


alter table GOODS_REST
   drop constraint FK_GOODS_RE_GDS_RST_W_WAREHOUS;


alter table GOODS_REST_ITEM
   drop constraint FK_GOODS_RE_GDSRI_TAX_TAX;


alter table GOODS_REST_ITEM
   drop constraint FK_GOODS_RE_GDSRI_UN_UNIT;


alter table GOODS_REST_ITEM
   drop constraint FK_GOODS_RE_GDSR_ITEM_GOODS_RE;


alter table GOODS_REST_ITEM
   drop constraint FK_GOODS_RE_GREST_PRO_PRODUCT;


alter table GOODS_WRITEOFF
   drop constraint FK_GOODS_WR_GDSW_RE_RESPONSI;


alter table GOODS_WRITEOFF
   drop constraint FK_GOODS_WR_GDS_OFF_W_WAREHOUS;


alter table GOODS_WRITEOFF_ITEM
   drop constraint FK_GOODS_WR_GDSWI_TAX_TAX;


alter table GOODS_WRITEOFF_ITEM
   drop constraint FK_GOODS_WR_GDSWI_UN_UNIT;


alter table GOODS_WRITEOFF_ITEM
   drop constraint FK_GOODS_WR_GDSW_ITEM_GOODS_WR;


alter table GOODS_WRITEOFF_ITEM
   drop constraint FK_GOODS_WR_GWRITEOFF_PRODUCT;


alter table INVOICE
   drop constraint FK_INVOICE_INV_PT_PRICE_TY;


alter table INVOICE_ITEM
   drop constraint FK_INVOICE__GDSII_TAX_TAX;


alter table INVOICE_ITEM
   drop constraint FK_INVOICE__INVI_UNIT_UNIT;


alter table INVOICE_ITEM
   drop constraint FK_INVOICE__INVOICE_I_INVOICE;


alter table INVOICE_ITEM
   drop constraint FK_INVOICE__INVOICE_P_PRODUCT;


alter table LEDGER_ACCOUNT
   drop constraint FK_LEDGER_A_LA_LA_TYP_LEDGER_A;


alter table LEDGER_ACCOUNT_REGISTER
   drop constraint FK_LEDGER_A_LA_REG_LA_LEDGER_A;


alter table LEDGER_ACCOUNT_REGISTER
   drop constraint FK_LEDGER_A_LA_REG_OR_ORGANIZA;


alter table LEDGER_ACCOUNT_REGISTER
   drop constraint FK_LEDGER_A_LA_REG_PE_PERIOD;


alter table LEDGER_ACCOUNT_REST
   drop constraint FK_LEDGER_A_LA_REST_L_LEDGER_A;


alter table LEDGER_ACCOUNT_REST
   drop constraint FK_LEDGER_A_LA_REST_O_ORGANIZA;


alter table LEDGER_ACCOUNT_REST
   drop constraint FK_LEDGER_A_LA_RES_CU_CURRENCY;


alter table LEDGER_ACCOUNT_REST
   drop constraint FK_LEDGER_A_LA_RES_PE_PERIOD;


alter table LOCALITY
   drop constraint FK_LOCALITY_LOCALITY__COUNTRY;


alter table LOCALITY
   drop constraint FK_LOCALITY_LOCALITY__DISTRICT;


alter table LOCALITY
   drop constraint FK_LOCALITY_LOCALITY__LOCALITY;


alter table LOCALITY
   drop constraint FK_LOCALITY_LOCALITY__REGION;


alter table PARTNER
   drop constraint FK_PARTNER_PRT_BNK_A_BANK_ACC;


alter table PARTNER
   drop constraint FK_PARTNER_PRT_FP_FORM_PRO;


alter table PARTNER
   drop constraint FK_PARTNER_PRT_INDS_INDUSTRY;


alter table PARTNER
   drop constraint FK_PARTNER_PRT_LA_LEDGER_A;


alter table PARTNER
   drop constraint FK_PARTNER_PRT_PRTG_PARTNER_;


alter table PARTNER_ACTIVITY_TYPE_LINK
   drop constraint FK_PARTNER__PRT_ATL_A_ACTIVITY;


alter table PARTNER_ACTIVITY_TYPE_LINK
   drop constraint FK_PARTNER__PRT_ATL_P_PARTNER;


alter table PARTNER_CATEGORY_LINK
   drop constraint FK_PARTNER__PCL_PRT_PARTNER;


alter table PARTNER_CATEGORY_LINK
   drop constraint FK_PARTNER__PCL_PRTC_PARTNER_;


alter table PARTNER_MOVE
   drop constraint FK_PARTNER__PRT_MOVE__FINANCE_;


alter table PARTNER_MOVE
   drop constraint FK_PARTNER__PRT_MOVE__PARTNER;


alter table PARTNER_REGISTER
   drop constraint FK_PARTNER__PARTNER_R_ORGANIZA;


alter table PARTNER_REGISTER
   drop constraint FK_PARTNER__PARTNER_R_PARTNER;


alter table PARTNER_REGISTER
   drop constraint FK_PARTNER__PARTNER_R_PERIOD;


alter table PARTNER_REST
   drop constraint FK_PARTNER__PRTR_CURR_CURRENCY;


alter table PARTNER_REST
   drop constraint FK_PARTNER__PRTR_ORG_ORGANIZA;


alter table PARTNER_REST
   drop constraint FK_PARTNER__PRTR_PERI_PERIOD;


alter table PARTNER_REST
   drop constraint FK_PARTNER__PRTR_PRT_PARTNER;


alter table PAYMENT_DOCUMENT_LINK
   drop constraint FK_PAYMENT__PAY_DOC_D_DOCUMENT;


alter table PAYMENT_DOCUMENT_LINK
   drop constraint FK_PAYMENT__PAY_DOC_P_DOCUMENT;


alter table PAYMENT_INCOME
   drop constraint FK_PAYMENT__PINCOME_O_BANK_ACC;


alter table PAYMENT_INCOME
   drop constraint FK_PAYMENT__PINCOME_P_BANK_ACC;


alter table PAYMENT_INCOME
   drop constraint FK_PAYMENT__PINCOME_P_PAYMENT_;


alter table PAYMENT_INCOME
   drop constraint FK_PAYMENT__PINCOME_T_TAXPRINT;


alter table PAYMENT_OUTCOME
   drop constraint FK_PAYMENT__PO_ORG_BA_BANK_ACC;


alter table PAYMENT_OUTCOME
   drop constraint FK_PAYMENT__PO_PRT_BA_BANK_ACC;


alter table PAYMENT_OUTCOME
   drop constraint FK_PAYMENT__PO_PTYPE_PAYMENT_;


alter table PAYMENT_OUTCOME
   drop constraint FK_PAYMENT__PO_TAXPRN_TAXPRINT;


alter table PAYMENT_OUTCOME_TEMPLATE
   drop constraint FK_PAYMENT__POT_CRC_CURRENCY;


alter table PAYMENT_OUTCOME_TEMPLATE
   drop constraint FK_PAYMENT__POT_DEPAR_DEPARTME;


alter table PAYMENT_OUTCOME_TEMPLATE
   drop constraint FK_PAYMENT__POT_OBA_BANK_ACC;


alter table PAYMENT_OUTCOME_TEMPLATE
   drop constraint FK_PAYMENT__POT_ORG_ORGANIZA;


alter table PAYMENT_OUTCOME_TEMPLATE
   drop constraint FK_PAYMENT__POT_PARTN_PARTNER;


alter table PAYMENT_OUTCOME_TEMPLATE
   drop constraint FK_PAYMENT__POT_PBA_BANK_ACC;


alter table PAYMENT_OUTCOME_TEMPLATE
   drop constraint FK_PAYMENT__POT_PRJ_PROJECT;


alter table PAYMENT_OUTCOME_TEMPLATE
   drop constraint FK_PAYMENT__POT_PT_PAYMENT_;


alter table PAYMENT_OUTCOME_TEMPLATE
   drop constraint FK_PAYMENT__POT_TAX_TAX;


alter table PAYMENT_OUTCOME_TEMPLATE
   drop constraint FK_PAYMENT__POT_TPT_TAXPRINT;


alter table PAYMENT_OUTCOME_TEMPLATE
   drop constraint FK_PAYMENT__POT_USER_SYSTEM_U;


alter table PAYROLL
   drop constraint FK_PAYROLL_PAY_ALGOR_PAYROLL_;


alter table PAYROLL
   drop constraint FK_PAYROLL_PAY_PALGT_PAYROLL_;


alter table PAYROLL
   drop constraint FK_PAYROLL_PAY_PAYGR_PAYROLL_;


alter table PAYROLL
   drop constraint FK_PAYROLL_PAY_PAYMO_PAYROLL_;


alter table PAYROLL
   drop constraint FK_PAYROLL_PAY_PAYTY_PAYROLL_;


alter table PAYROLL_ITEM
   drop constraint FK_PAYROLL__PAYITEM_O_PAYROLL;


alter table PAYROLL_ITEM
   drop constraint FK_PAYROLL__PAYITEM_P_PAYROLL;


alter table PERIOD
   drop constraint FK_PERIOD_PERIOD_PT_PERIOD_T;


alter table PERSON_CARD
   drop constraint FK_PERSON_C_PC_CRES_COUNTRY;


alter table PERSON_CARD
   drop constraint FK_PERSON_C_PC_DPSPEC_SPECIALI;


alter table PERSON_CARD
   drop constraint FK_PERSON_C_PC_DT_PERSON_D;


alter table PERSON_CARD
   drop constraint FK_PERSON_C_PC_FS_FAMILY_S;


alter table PERSON_CARD
   drop constraint FK_PERSON_C_PC_LAN_LANGUAGE;


alter table PERSON_CARD
   drop constraint FK_PERSON_C_PC_NTL_COUNTRY;


alter table PERSON_CARD
   drop constraint FK_PERSON_C_PERSON_CA_PERSON;


alter table PERSON_DOCUMENT
   drop constraint FK_PERSON_D_PERSON_DO_PERSON;


alter table PERSON_DOCUMENT
   drop constraint FK_PERSON_D_PRSDOC_PR_PERSON_D;


alter table PERSON_EDUCATION
   drop constraint FK_PERSON_E_PRSEDU_AD_ACADEMIC;


alter table PERSON_EDUCATION
   drop constraint FK_PERSON_E_PRSEDU_EF_EDUCATIO;


alter table PERSON_EDUCATION
   drop constraint FK_PERSON_E_PRSEDU_EI_EDUCATIO;


alter table PERSON_EDUCATION
   drop constraint FK_PERSON_E_PRSEDU_ET_EDUCATIO;


alter table PERSON_EDUCATION
   drop constraint FK_PERSON_E_PRSEDU_PR_PERSON;


alter table PERSON_FAMILY
   drop constraint FK_PERSON_F_PF_PRS_PERSON;


alter table PERSON_FAMILY
   drop constraint FK_PERSON_F_PRSFAM_FA_FAMILIAR;


alter table PERSON_JOB
   drop constraint FK_PERSON_J_PRSJOB_PR_PERSON;


alter table PERSON_LANGUAGE
   drop constraint FK_PERSON_L_PRSLAN_LA_LANGUAGE;


alter table PERSON_LANGUAGE
   drop constraint FK_PERSON_L_PRSLAN_PR_PERSON;


alter table PERSON_MILITARY
   drop constraint FK_PERSON_M_PERSON_MI_PERSON;


alter table PERSON_MILITARY
   drop constraint FK_PERSON_M_PM_MR_MILITARY;


alter table PERSON_MILITARY
   drop constraint FK_PERSON_M_PM_MS_MILITARY;


alter table PERSON_MILITARY
   drop constraint FK_PERSON_M_PM_MSPEC_MILITARY;


alter table PHONE
   drop constraint FK_PHONE_PHONE_CON_CONTACTA;


alter table PHONE
   drop constraint FK_PHONE_PHONE_PHO_PHONE_TY;


alter table PRODUCT
   drop constraint FK_PRODUCT_PROD_CLAS_PRODUCT_;


alter table PRODUCT
   drop constraint FK_PRODUCT_PROD_CUR_CURRENCY;


alter table PRODUCT
   drop constraint FK_PRODUCT_PROD_LA_LEDGER_A;


alter table PRODUCT
   drop constraint FK_PRODUCT_PROD_MANU_PARTNER;


alter table PRODUCT
   drop constraint FK_PRODUCT_PROD_ORG_ORGANIZA;


alter table PRODUCT
   drop constraint FK_PRODUCT_PROD_PGRO_PRODUCT_;


alter table PRODUCT
   drop constraint FK_PRODUCT_PROD_SUPP_PARTNER;


alter table PRODUCT
   drop constraint FK_PRODUCT_PROD_UNIT_UNIT;


alter table PRODUCT_CLASS
   drop constraint FK_PRODUCT__PCLASS_GR_PRODUCT_;


alter table PRODUCT_CLASS
   drop constraint FK_PRODUCT__PCLASS_TY_PRODUCT_;


alter table PRODUCT_DETAIL_REGISTER
   drop constraint FK_PRODUCT__PDR_ORG_ORGANIZA;


alter table PRODUCT_DETAIL_REGISTER
   drop constraint FK_PRODUCT__PDR_PERIO_PERIOD;


alter table PRODUCT_DETAIL_REGISTER
   drop constraint FK_PRODUCT__PDR_PROD_PRODUCT;


alter table PRODUCT_DETAIL_REGISTER
   drop constraint FK_PRODUCT__PDR_RESPO_RESPONSI;


alter table PRODUCT_DETAIL_REGISTER
   drop constraint FK_PRODUCT__PDR_WAREH_WAREHOUS;


alter table PRODUCT_GROUP
   drop constraint FK_PRODUCT__PGROUP_PS_PRODUCT_;


alter table PRODUCT_MOVE
   drop constraint FK_PRODUCT__PROD_MOVE_FINANCE_;


alter table PRODUCT_MOVE
   drop constraint FK_PRODUCT__PROD_MOVE_PRODUCT;


alter table PRODUCT_MOVE
   drop constraint FK_PRODUCT__PROD_MOVE_UNIT;


alter table PRODUCT_PRICE
   drop constraint FK_PRODUCT__PPRICE_CU_CURRENCY;


alter table PRODUCT_PRICE
   drop constraint FK_PRODUCT__PPRICE_PR_PRODUCT;


alter table PRODUCT_PRICE
   drop constraint FK_PRODUCT__PPRICE_PT_PRICE_TY;


alter table PRODUCT_PRICE
   drop constraint FK_PRODUCT__PPRICE_UN_UNIT;


alter table PRODUCT_REGISTER
   drop constraint FK_PRODUCT__GR_PERIOD_PERIOD;


alter table PRODUCT_REGISTER
   drop constraint FK_PRODUCT__PR_ORG_ORGANIZA;


alter table PRODUCT_REGISTER
   drop constraint FK_PRODUCT__PR_PROD_PRODUCT;


alter table PRODUCT_UNIT
   drop constraint FK_PRODUCT__PUNIT_PRO_PRODUCT;


alter table PRODUCT_UNIT
   drop constraint FK_PRODUCT__PUNIT_UNI_UNIT;


alter table PROJECT
   drop constraint FK_PROJECT_CURRENCY__CURRENCY;


alter table PROJECT
   drop constraint FK_PROJECT_ORG_PROJE_ORGANIZA;


alter table PROJECT
   drop constraint FK_PROJECT_PRJ_TAX_TAX;


alter table PROJECT
   drop constraint FK_PROJECT_PRJ_TYPE__PROJECT_;


alter table PROJECT
   drop constraint FK_PROJECT_PRT_PROJE_PARTNER;


alter table PROJECT
   drop constraint FK_PROJECT_RESPONSIB_EMPLOYEE;


alter table PROJECT
   drop constraint FK_PROJECT_STAGE_PRO_PROJECT_;


alter table PROJECT
   drop constraint FK_PROJECT_STATUS_PR_PROJECT_;


alter table PROJECT_CONTACT_LINK
   drop constraint FK_PROJECT__PRJ_CNT_C_CONTACT;


alter table PROJECT_CONTACT_LINK
   drop constraint FK_PROJECT__PRJ_PRJ_C_PROJECT;


alter table PROJECT_CONTACT_LINK
   drop constraint FK_PROJECT__PRJ_ROLE_PROJECT_;


alter table PROJECT_CONTEXT
   drop constraint FK_PROJECT__PCX_PSTG_PROJECT_;


alter table PROJECT_CONTEXT
   drop constraint FK_PROJECT__PCX_PSTT_PROJECT_;


alter table PROJECT_CONTEXT
   drop constraint FK_PROJECT__PCX_PTP_PROJECT_;


alter table PROJECT_CONTEXT
   drop constraint FK_PROJECT__PRJ_CTX_C_CURRENCY;


alter table PROJECT_CONTEXT
   drop constraint FK_PROJECT__PRJ_CTX_E_EMPLOYEE;


alter table PROJECT_CONTEXT
   drop constraint FK_PROJECT__PRJ_CTX_P_PARTNER;


alter table PROJECT_EMPLOYEE_LINK
   drop constraint FK_PROJECT__PRJ_EMP_E_EMPLOYEE;


alter table PROJECT_EMPLOYEE_LINK
   drop constraint FK_PROJECT__PRJ_EMP_P_PROJECT;


alter table PROJECT_EMPLOYEE_LINK
   drop constraint FK_PROJECT__PRJ_EMP_P_PROJECT_;


alter table PROJECT_STAGE
   drop constraint FK_PROJECT__PRJ_STAGE_PROJECT_;


alter table PROJECT_STAGE
   drop constraint FK_PROJECT__PRJ_TYPE__PROJECT_;


alter table PROJECT_STAGE_LINK
   drop constraint FK_PROJECT__PRG_PRG_S_PROJECT;


alter table PROJECT_STAGE_LINK
   drop constraint FK_PROJECT__PRG_STAGE_PROJECT_;


alter table PURCHASE_ORDER
   drop constraint FK_PURCHASE_PCHORD_RE_RESPONSI;


alter table PURCHASE_ORDER
   drop constraint FK_PURCHASE_PCHORD_WR_WAREHOUS;


alter table PURCHASE_ORDER
   drop constraint FK_PURCHASE_PO_PT_PRICE_TY;


alter table PURCHASE_ORDER_ITEM
   drop constraint FK_PURCHASE_PCHORD_IT_PURCHASE;


alter table PURCHASE_ORDER_ITEM
   drop constraint FK_PURCHASE_PCHORD_IT_TAX;


alter table PURCHASE_ORDER_ITEM
   drop constraint FK_PURCHASE_PCHORD_IT_UNIT;


alter table PURCHASE_ORDER_ITEM
   drop constraint FK_PURCHASE_PURCHASEO_PRODUCT;


alter table PURCHASE_PLAN
   drop constraint FK_PURCHASE_PURCHASE__PRICE_TY;


alter table PURCHASE_PLAN
   drop constraint FK_PURCHASE_PURCHASE__RESPONSI;


alter table PURCHASE_PLAN_ITEM
   drop constraint FK_PURCHASE_PURCHASEP_PRODUCT;


alter table PURCHASE_PLAN_ITEM
   drop constraint FK_PURCHASE_PURCHASE__PURCHASE;


alter table PURCHASE_PLAN_ITEM
   drop constraint FK_PURCHASE_PURCHASE__TAX;


alter table PURCHASE_PLAN_ITEM
   drop constraint FK_PURCHASE_PURCHASE__UNIT;


alter table REGION
   drop constraint FK_REGION_REGION_CO_COUNTRY;


alter table RESPONSIBLE
   drop constraint FK_RESPONSI_RESPONSIB_EMPLOYEE;


alter table RESPONSIBLE
   drop constraint FK_RESPONSI_RESPONSIB_ORGANIZA;


alter table RESPONSIBLE
   drop constraint FK_RESPONSI_RESPONSIB_WAREHOUS;


alter table SALE_ORDER
   drop constraint FK_SALE_ORD_SALORD_RE_RESPONSI;


alter table SALE_ORDER
   drop constraint FK_SALE_ORD_SALORD_WR_WAREHOUS;


alter table SALE_ORDER
   drop constraint FK_SALE_ORD_SO_ADR_ADDRESS;


alter table SALE_ORDER
   drop constraint FK_SALE_ORD_SO_PT_PRICE_TY;


alter table SALE_ORDER_ITEM
   drop constraint FK_SALE_ORD_SALEORD_I_TAX;


alter table SALE_ORDER_ITEM
   drop constraint FK_SALE_ORD_SALEORD_P_PRODUCT;


alter table SALE_ORDER_ITEM
   drop constraint FK_SALE_ORD_SALORD_IT_SALE_ORD;


alter table SALE_ORDER_ITEM
   drop constraint FK_SALE_ORD_SALORD_IT_UNIT;


alter table SALE_PLAN
   drop constraint FK_SALE_PLA_SALE_PLAN_PRICE_TY;


alter table SALE_PLAN
   drop constraint FK_SALE_PLA_SALE_PLAN_RESPONSI;


alter table SALE_PLAN_ITEM
   drop constraint FK_SALE_PLA_SALEPLAN__PRODUCT;


alter table SALE_PLAN_ITEM
   drop constraint FK_SALE_PLA_SALE_PLAN_SALE_PLA;


alter table SALE_PLAN_ITEM
   drop constraint FK_SALE_PLA_SPI_TAX_TAX;


alter table SALE_PLAN_ITEM
   drop constraint FK_SALE_PLA_SPI_UNIT_UNIT;


alter table SECURE_OBJECT
   drop constraint FK_SECURE_O_SE_ENTITY_SYSTEM_E;


alter table SHOP
   drop constraint FK_SHOP_SHOP_ORG_ORGANIZA;


alter table STORE
   drop constraint FK_STORE_STORE_ORG_ORGANIZA;


alter table SYSTEM_ATTR
   drop constraint FK_SYSTEM_A_SA_SA_TYP_SYSTEM_A;


alter table SYSTEM_ATTR
   drop constraint FK_SYSTEM_A_SA_SE_SYSTEM_E;


alter table SYSTEM_ATTR_TYPE
   drop constraint FK_SYSTEM_A_SA_T_SYSTEM_E;


alter table SYSTEM_ATTR_TYPE
   drop constraint FK_SYSTEM_A_SA_T_DAT__DATA_TYP;


alter table SYSTEM_ATTR_TYPE
   drop constraint FK_SYSTEM_A_SA_T_SA_T_SYSTEM_A;


alter table SYSTEM_ATTR_TYPE_GROUP
   drop constraint FK_SYSTEM_A_SA_TG_SE_SYSTEM_E;


alter table SYSTEM_ENTITY
   drop constraint FK_SYSTEM_E_ENTITY_EN_SYSTEM_E;


alter table SYSTEM_ENUMERATION
   drop constraint FK_SYSTEM_E_ENUM_ENTI_SYSTEM_E;


alter table SYSTEM_FILE
   drop constraint FK_SYSTEM_F_SF_SF_STO_SYSTEM_F;


alter table SYSTEM_FILE
   drop constraint FK_SYSTEM_F_SF_SF_TYP_SYSTEM_F;


alter table SYSTEM_FILE
   drop constraint FK_SYSTEM_F_SF_SYS_E_SYSTEM_E;


alter table SYSTEM_IMAGE
   drop constraint FK_SYSTEM_I_SI_SF_TYP_SYSTEM_F;


alter table SYSTEM_IMAGE
   drop constraint FK_SYSTEM_I_SI_SI_STO_SYSTEM_I;


alter table SYSTEM_IMAGE
   drop constraint FK_SYSTEM_I_SI_SYS_E_SYSTEM_E;


alter table SYSTEM_INFO
   drop constraint FK_SYSTEM_I_SI_CST_PARTNER;


alter table SYSTEM_INFO
   drop constraint FK_SYSTEM_I_SI_EMP_EMPLOYEE;


alter table SYSTEM_INFO
   drop constraint FK_SYSTEM_I_SI_IWRH_WAREHOUS;


alter table SYSTEM_INFO
   drop constraint FK_SYSTEM_I_SI_OWRH_WAREHOUS;


alter table SYSTEM_INFO
   drop constraint FK_SYSTEM_I_SI_PRT_PARTNER;


alter table SYSTEM_INFO
   drop constraint FK_SYSTEM_I_SI_RSP_RESPONSI;


alter table SYSTEM_INFO
   drop constraint FK_SYSTEM_I_SI_SPP_PARTNER;


alter table SYSTEM_INFO
   drop constraint FK_SYSTEM_I_SI_WRH_WAREHOUS;


alter table SYSTEM_INFO
   drop constraint FK_SYSTEM_I_SYS_CURRE_CURRENCY;


alter table SYSTEM_INFO
   drop constraint FK_SYSTEM_I_SYS_ORG_ORGANIZA;


alter table SYSTEM_INFO
   drop constraint FK_SYSTEM_I_SYS_PERIO_PERIOD;


alter table SYSTEM_INFO
   drop constraint FK_SYSTEM_I_SYS_TAX_TAX;


alter table SYSTEM_INFO
   drop constraint FK_SYSTEM_I_SYS_UNIT_UNIT;


alter table SYSTEM_MONTH
   drop constraint FK_SYSTEM_M_MONTH_QUA_SYSTEM_Q;


alter table SYSTEM_PERMISSION
   drop constraint FK_SYSTEM_P_PERMISSIO_SECURE_O;


alter table SYSTEM_PERMISSION
   drop constraint FK_SYSTEM_P_PERMISSIO_SYSTEM_R;


alter table SYSTEM_REFERENCE
   drop constraint FK_SYSTEM_R_REF_ENTIT_SYSTEM_E;


alter table SYSTEM_USER
   drop constraint FK_SYSTEM_U_USER_ENTI_SYSTEM_E;


alter table SYSTEM_USER_ROLE
   drop constraint FK_SYSTEM_U_UR_ROLE_SYSTEM_R;


alter table SYSTEM_USER_ROLE
   drop constraint FK_SYSTEM_U_UR_USER_SYSTEM_U;


alter table SYSTEM_VARIABLE
   drop constraint FK_SYSTEM_V_SYSVAR_DA_DATA_TYP;


alter table SYSTEM_VARIABLE
   drop constraint FK_SYSTEM_V_SYSVAR_SY_SYSTEM_E;


alter table TASK
   drop constraint FK_TASK_DOC_TASK_DOCUMENT;


alter table TASK
   drop constraint FK_TASK_ORG_TASK_ORGANIZA;


alter table TASK
   drop constraint FK_TASK_PRJ_TASK_PROJECT;


alter table TASK
   drop constraint FK_TASK_PRT_TASK_PARTNER;


alter table TASK
   drop constraint FK_TASK_RESPONSIB_EMPLOYEE;


alter table TASK
   drop constraint FK_TASK_RESULT_TA_TASK_RES;


alter table TASK
   drop constraint FK_TASK_TASK_PRIO_TASK_PRI;


alter table TASK
   drop constraint FK_TASK_TASK_STAT_TASK_STA;


alter table TASK
   drop constraint FK_TASK_TYPE_TASK_TASK_TYP;


alter table TASK_CONTACT_LINK
   drop constraint FK_TASK_CON_TASK_CNT__CONTACT;


alter table TASK_CONTACT_LINK
   drop constraint FK_TASK_CON_TASK_ROLE_TASK_ROL;


alter table TASK_CONTACT_LINK
   drop constraint FK_TASK_CON_TASK_TSK__TASK;


alter table TASK_CONTEXT
   drop constraint FK_TASK_CON_TSK_CTX_E_EMPLOYEE;


alter table TASK_CONTEXT
   drop constraint FK_TASK_CON_TSK_CTX_P_PROJECT;


alter table TASK_CONTEXT
   drop constraint FK_TASK_CON_TSK_CTX_P_PARTNER;


alter table TASK_CONTEXT
   drop constraint FK_TASK_CON_TSK_CTX_T_TASK_PRI;


alter table TASK_CONTEXT
   drop constraint FK_TASK_CON_TSK_CTX_T_TASK_RES;


alter table TASK_CONTEXT
   drop constraint FK_TASK_CON_TSK_CTX_T_TASK_STA;


alter table TASK_CONTEXT
   drop constraint FK_TASK_CON_TSK_CTX_T_TASK_TYP;


alter table TASK_EMPLOYEE_LINK
   drop constraint FK_TASK_EMP_TSK_EMP_E_EMPLOYEE;


alter table TASK_EMPLOYEE_LINK
   drop constraint FK_TASK_EMP_TSK_EMP_T_TASK;


alter table TASK_EMPLOYEE_LINK
   drop constraint FK_TASK_EMP_TSK_EMP_T_TASK_ROL;


alter table TASK_RESULT
   drop constraint FK_TASK_RES_TYPE_TASK_TASK_TYP;


alter table TAX_WAYBILL_ITEM
   drop constraint FK_TAX_WAYB_TAXWBL_IT_TAX_WAYB;


alter table TAX_WAYBILL_ITEM
   drop constraint FK_TAX_WAYB_TAXWBL_PR_PRODUCT;


alter table TAX_WAYBILL_ITEM
   drop constraint FK_TAX_WAYB_TAXWBL_TA_TAX;


alter table TAX_WAYBILL_ITEM
   drop constraint FK_TAX_WAYB_TAXWBL_UN_UNIT;


alter table TEMPLATE_ENTRY
   drop constraint FK_TEMPLATE_TEMPL_ENT_FINANCE_;


alter table TEMPLATE_ENTRY_ITEM
   drop constraint FK_TEMPLATE_CTEI_LA_LEDGER_A;


alter table TEMPLATE_ENTRY_ITEM
   drop constraint FK_TEMPLATE_DTEI_LA_LEDGER_A;


alter table TEMPLATE_ENTRY_ITEM
   drop constraint FK_TEMPLATE_TEMPL_ENT_TEMPLATE;


alter table WAREHOUSE_ENTITY
   drop constraint FK_WAREHOUS_WRH_ENTIT_SYSTEM_E;


alter table WAREHOUSE_MOVE
   drop constraint FK_WAREHOUS_WRH_MOVE__FINANCE_;


alter table WAREHOUSE_MOVE
   drop constraint FK_WAREHOUS_WRH_MOVE__RESPONSI;


alter table WAREHOUSE_MOVE
   drop constraint FK_WAREHOUS_WRH_MOVE__WAREHOUS;


alter table WEB
   drop constraint FK_WEB_WEB_CONTA_CONTACTA;


alter table WORKS
   drop constraint FK_WORKS_WORKS_ORG_ORGANIZA;


alter table WORKSHOP
   drop constraint FK_WORKSHOP_WORKSHOPS_ORGANIZA;


