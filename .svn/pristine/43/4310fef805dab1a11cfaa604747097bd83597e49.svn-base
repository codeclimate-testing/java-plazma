
/*==============================================================*/
/* MySQL                                                        */
/* http://www.mysql.com                                         */
/*==============================================================*/


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





/* FIXED */


alter table CONTRACT
   drop constraint FK_CONTRACT_ORG_CR_BA_BANK_ACC;


alter table CONTRACT
   drop constraint FK_CONTRACT_ORG_CR_CN_CONTACT;


alter table CONTRACT
   drop constraint FK_CONTRACT_PRT_CR_BA_BANK_ACC;


alter table CONTRACT
   drop constraint FK_CONTRACT_PRT_CR_CN_CONTACT;





alter table GOODS_OUTCOME_ITEM
   drop constraint FK_GOODS_OU_PR_INS_PRODUCT_;


alter table PRODUCT
   drop constraint FK_PRODUCT_DIM_UNT_UNIT;


alter table PRODUCT
   drop constraint FK_PRODUCT_WAR_PRD_U_UNIT;



alter table PRODUCT
   drop constraint FK_PRODUCT_WG_UNT_UNIT;


alter table PRODUCT_INSTANCE
   drop constraint FK_PRODUCT__PRD_INS_PRODUCT;
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
drop view V_PROJECT_PERIOD_DAY;
drop view V_PROJECT_YEAR_UNIQUE_INF;
drop view V_PROJECT_YEAR_UNIQUE;
drop view V_PROJECT_DATE_EXT;
drop view V_PROJECT_DATE;
drop view V_RPT_LDG_ACCOUNT_CORR;
drop view V_RPT_LDG_ACCOUNT_ALL;
drop view V_RPT_LDG_ACCOUNT_ROTATE;
drop view V_RPT_LDG_ACCOUNT_DEBIT_FULL;
drop view V_RPT_LDG_ACCOUNT_CREDIT_FULL;
drop view V_RPT_LDG_ACCOUNT_REST_START;
drop view V_RPT_LDG_ACCOUNT_REGISTER;
drop view V_RPT_LDG_ACCOUNT_REST;
drop view V_LEDGER_ACCOUNT_REGISTER;
drop view V_LEDGER_ACCOUNT_REST;
drop view V_EMPLOYEE_RESULT;
drop view V_RPT_PARTNER_ROTATE;
drop view V_RPT_PARTNER_DEBIT_FULL;
drop view V_RPT_PARTNER_CREDIT_FULL;
drop view V_RPT_PARTNER_REST_START;
drop view V_RPT_PARTNER_REST;
drop view V_RPT_PARTNER_REGISTER;
drop view V_PARTNER_REST;
drop view V_RPT_GOODS_ROTATE;
drop view V_RPT_GOODS_DEBIT_FULL;
drop view V_RPT_GOODS_CREDIT_FULL;
drop view V_RPT_WRH_GOODS_REST_START;
drop view V_RPT_GOODS_REST_START;
drop view V_GOODS_DEBIT_FULL;
drop view V_GOODS_CREDIT_FULL;
drop view V_RPT_WRH_GOODS_REGISTER;

/* ============================================================= */

drop view v_rpt_goods_sale_year;
drop view v_rpt_goods_sale_year_product;

/* ============================================================= */

drop view V_RPT_GOODS_SALE;
drop view V_RPT_GOODS_REGISTER;
drop view V_RPT_INVOICE;
drop view V_RPT_GOODS_REST;
drop view V_RPT_GOODS_OUTCOME;
drop view V_RPT_GOODS_INCOME;
drop view V_GOODS_PURCHASE;
drop view V_GOODS_SALE;
drop view V_GOODS_DETAIL_REGISTER;
drop view V_GOODS_REGISTER;
drop view V_PARTNER_MOVE;
drop view V_PARTNER_REGISTER;
drop view V_BUSINESSABLE;
drop view V_PAYMENT_ROTATE;
drop view V_PAYMENT;
drop view V_PAYMENT_OUTCOME;
drop view V_PAYMENT_INCOME;
drop view V_PARTNER_BANK_ACCOUNT;
drop view V_BANK;
drop view V_DEF_PARTNER_PHONE;
drop view V_DEF_CONTACTABLE_PHONE;
drop view V_CONTACTABLE_PHONE;
drop view V_PHONE;
drop view V_DEF_PARTNER_ADDRESS;
drop view V_DEF_CONTACTABLE_ADDRESS;
drop view V_CONTACTABLE_ADDRESS;
drop view V_ADDRESS;
drop view V_ADDRESS_CITY;
drop view V_CITY;
drop view V_CONTRACTOR_UNION;
drop view V_CONTRACTOR;
drop view V_ENTRY_ITEM;
drop view V_FINANCE_DOCUMENT;
drop view V_DOCUMENT;
drop view V_INTANGIBLE;
drop view V_ASSET;
drop view V_GOODS;
drop view V_PRODUCT_MOVE;
drop view V_PRODUCT;
drop view V_WAREHOUSE_MOVE;
drop view V_RESPONSIBLE;
drop view V_WAREHOUSE_UNION;
drop view V_WAREHOUSE;
drop view V_EMPLOYEE;
drop view V_SYSTEM_PERMISSION;
drop view V_SYSTEM_USER;
drop view V_SYSTEM_INFO;
drop view V_ORGANIZATION;

/*==============================================================*/
/*                                                              */
/* CREATE TABLES                                                */
/*                                                              */
/*==============================================================*/

/* INVOICE -> SALE_INVOICE                                      */
/* INVOICE_ITEM -> SALE_INVOICE_ITEM                            */
/* EXEC_WORK -> SALE_SERV                                       */
/* EXEC_WORK_ITEM -> SALE_SERV_ITEM                             */
/* TAX_WAYBILL -> SALE_TAX_WAYBILL                              */
/* TAX_WAYBILL_ITEM -> SALE_TAX_WAYBILL_ITEM                    */

/* ADD PURCHASE_INVOICE                                         */
/* ADD PURCHASE_INVOICE_ITEM                                    */
/* ADD PURCHASE_SERV                                            */
/* ADD PURCHASE_SERV_ITEM                                       */
/* ADD PURCHASE_TAX_WAYBILL                                     */
/* ADD PURCHASE_TAX_WAYBILL_ITEM                                */

/* GOODS_REST -> INVENTORY_REST                                 */
/* GOODS_REST_ITEM -> INVENTORY_REST_ITEM                       */
/* GOODS_MOVE -> INVENTORY_MOVE (recreate)                      */
/* GOODS_MOVE_ITEM -> INVENTORY_MOVE_ITEM                       */
/* GOODS_WRITEOFF -> INVENTORY_WRITEOF (recreate)               */
/* GOODS_WRITEOFF_ITEM -> INVENTORY_WRITEOF_ITEM                */

/* ADD INVENTORY_INCOME (recreate)                              */
/* ADD INVENTORY_INCOME_ITEM                                    */
/* ADD INVENTORY_OUTCOME (recreate)                             */
/* ADD INVENTORY_OUTCOME_ITEM                                   */

/* ADD BRANCH                                                   */
/* ADD BRANCH_DOCUMENT_TYPE                                     */
/* ADD PARTNER_REPRESENTATIVE                                   */
/* ADD PARTNER_TYPE                                             */
/* ADD SYSTEM_USER_ORG                                          */

/*==============================================================*/
/* Table: SALE_INVOICE                                          */
/*==============================================================*/
create table SALE_INVOICE (
ID                   INTEGER                        not null,
PRICE_TYPE_ID        INTEGER,
DELIVERY             NUMERIC(15,2)                  not null,
TAX_DELIVERY         NUMERIC(15,2)                  not null,
DELIVERY_WITH_TAX    NUMERIC(15,2)                  not null,
CURRENCY_DELIVERY    NUMERIC(15,2)                  not null,
CURRENCY_TAX_DELIVERY NUMERIC(15,2)                  not null,
CURRENCY_DELIVERY_WITH_TAX NUMERIC(15,2)                  not null,
IS_PAID              CHAR(1)                        default 'N' not null,
CORRECT_PRICE_TYPE   CHAR(3),
DISCOUNT_PERCENT     NUMERIC(6,2)                   default 0 not null,
MARKUP_PERCENT       NUMERIC(6,2)                   default 0 not null,
constraint PK_SALE_INVOICE primary key (ID)
);

/*==============================================================*/
/* Table: SALE_INVOICE_ITEM                                     */
/*==============================================================*/
create table SALE_INVOICE_ITEM (
ID                   INTEGER                        not null,
SALE_INVOICE_ID      INTEGER                        not null,
TAX_ID               INTEGER,
PRODUCT_ID           INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
PRODUCT_FEATURE_NAME VARCHAR(100),
PRICE                NUMERIC(15,2)                  not null,
TAX_PRICE            NUMERIC(9,2)                   not null,
QUANTITY             NUMERIC(9,4)                   not null,
AMOUNT               NUMERIC(15,2)                  not null,
TAX_AMOUNT           NUMERIC(15,2)                  not null,
IS_TAX               CHAR(1)                        default 'N' not null,
CURRENCY_PRICE       NUMERIC(9,2)                   not null,
CURRENCY_TAX_PRICE   NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT      NUMERIC(15,2)                  not null,
CURRENCY_TAX_AMOUNT  NUMERIC(15,2)                  not null,
UNIT_RATE            NUMERIC(15,3)                  not null,
PRICE_WITH_TAX       NUMERIC(9,2)                   not null,
AMOUNT_WITH_TAX      NUMERIC(15,2)                  not null,
CURRENCY_PRICE_WITH_TAX NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT_WITH_TAX NUMERIC(15,2)                  not null,
TAX_PERCENT          NUMERIC(6,2)                   default 0 not null,
CORRECT_PRICE_TYPE   CHAR(3),
DISCOUNT_PERCENT     NUMERIC(6,2)                   default 0 not null,
MARKUP_PERCENT       NUMERIC(6,2)                   default 0 not null,
BASE_PRICE           NUMERIC(9,2)                   default 0 not null,
TAX_BASE_PRICE       NUMERIC(9,2)                   default 0 not null,
BASE_PRICE_WITH_TAX  NUMERIC(9,2)                   default 0 not null,
CURRENCY_BASE_PRICE  NUMERIC(9,2)                   default 0 not null,
CURRENCY_TAX_BASE_PRICE NUMERIC(9,2)                   default 0 not null,
CURRENCY_BASE_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
ACCOUNT_QUANTITY     NUMERIC(9,4)                   default 0 not null,
ACCOUNT_PRICE        NUMERIC(9,2)                   default 0 not null,
ACCOUNT_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
ACCOUNT_TAX_PRICE    NUMERIC(9,2)                   default 0 not null,
constraint PK_SALE_INVOICE_ITEM primary key (ID)
);

/*==============================================================*/
/* Table: SALE_SERV                                             */
/*==============================================================*/
create table SALE_SERV (
ID                   INTEGER                        not null,
constraint PK_SALE_SERV primary key (ID)
);

/*==============================================================*/
/* Table: SALE_SERV_ITEM                                        */
/*==============================================================*/
create table SALE_SERV_ITEM (
ID                   INTEGER                        not null,
SALE_SERV_ID         INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
TAX_ID               INTEGER,
PRODUCT_ID           INTEGER                        not null,
PRODUCT_FEATURE_NAME VARCHAR(100),
PRICE                NUMERIC(9,2)                   default 0 not null,
TAX_PRICE            NUMERIC(9,2)                   default 0 not null,
QUANTITY             NUMERIC(9,4)                   not null,
AMOUNT               NUMERIC(15,2)                  not null,
TAX_AMOUNT           NUMERIC(15,2)                  not null,
IS_TAX               CHAR(1)                        default 'N' not null,
CURRENCY_PRICE       NUMERIC(9,2)                   not null,
CURRENCY_TAX_PRICE   NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT      NUMERIC(15,2)                  default 0 not null,
CURRENCY_TAX_AMOUNT  NUMERIC(15,2)                  default 0 not null,
UNIT_RATE            NUMERIC(15,3)                  not null,
PRICE_WITH_TAX       NUMERIC(9,2)                   not null,
AMOUNT_WITH_TAX      NUMERIC(15,2)                  not null,
CURRENCY_PRICE_WITH_TAX NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT_WITH_TAX NUMERIC(15,2)                  not null,
TAX_PERCENT          NUMERIC(6,2)                   default 0 not null,
ACCOUNT_QUANTITY     NUMERIC(9,4)                   default 0 not null,
ACCOUNT_PRICE        NUMERIC(9,2)                   default 0 not null,
ACCOUNT_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
ACCOUNT_TAX_PRICE    NUMERIC(9,2)                   default 0 not null,
constraint PK_SALE_SERV_ITEM primary key (ID)
);

/*==============================================================*/
/* Table: SALE_TAX_WAYBILL                                      */
/*==============================================================*/
create table SALE_TAX_WAYBILL (
ID                   INTEGER                        not null,
constraint PK_SALE_TAX_WAYBILL primary key (ID)
);

/*==============================================================*/
/* Table: SALE_TAX_WAYBILL_ITEM                                 */
/*==============================================================*/
create table SALE_TAX_WAYBILL_ITEM (
ID                   INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
SALE_TAX_WAYBILL_ID  INTEGER                        not null,
TAX_ID               INTEGER,
PRODUCT_FEATURE_NAME VARCHAR(100),
PRICE                NUMERIC(9,2)                   default 0 not null,
TAX_PRICE            NUMERIC(9,2)                   default 0 not null,
QUANTITY             NUMERIC(9,4)                   not null,
AMOUNT               NUMERIC(15,2)                  not null,
TAX_AMOUNT           NUMERIC(15,2)                  not null,
IS_TAX               CHAR(1)                        default 'N' not null,
CURRENCY_PRICE       NUMERIC(9,2)                   not null,
CURRENCY_TAX_PRICE   NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT      NUMERIC(15,2)                  default 0 not null,
CURRENCY_TAX_AMOUNT  NUMERIC(15,2)                  default 0 not null,
UNIT_RATE            NUMERIC(15,3)                  not null,
PRICE_WITH_TAX       NUMERIC(9,2)                   not null,
AMOUNT_WITH_TAX      NUMERIC(15,2)                  not null,
CURRENCY_PRICE_WITH_TAX NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT_WITH_TAX NUMERIC(15,2)                  not null,
TAX_PERCENT          NUMERIC(6,2)                   default 0 not null,
ACCOUNT_QUANTITY     NUMERIC(9,4)                   default 0 not null,
ACCOUNT_PRICE        NUMERIC(9,2)                   default 0 not null,
ACCOUNT_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
ACCOUNT_TAX_PRICE    NUMERIC(9,2)                   default 0 not null,
constraint PK_SALE_TAX_WAYBILL_ITEM primary key (ID)
);


/*===================================================================*/

INSERT INTO SALE_INVOICE SELECT * FROM INVOICE;
DROP TABLE INVOICE;
 
INSERT INTO SALE_INVOICE_ITEM
 SELECT 
 ID, 
 INVOICE_ID AS SALE_INVOICE_ID,
 TAX_ID,
 PRODUCT_ID,
 UNIT_ID,
 PRODUCT_FEATURE_NAME,
 PRICE,
 TAX_PRICE,
 QUANTITY,
 AMOUNT,
 TAX_AMOUNT,
 IS_TAX,
 CURRENCY_PRICE,
 CURRENCY_TAX_PRICE,
 CURRENCY_AMOUNT,
 CURRENCY_TAX_AMOUNT,
 UNIT_RATE,
 PRICE_WITH_TAX,
 AMOUNT_WITH_TAX,
 CURRENCY_PRICE_WITH_TAX,
 CURRENCY_AMOUNT_WITH_TAX,
 TAX_PERCENT,
 CORRECT_PRICE_TYPE,
 DISCOUNT_PERCENT,
 MARKUP_PERCENT,
 BASE_PRICE,
 TAX_BASE_PRICE,
 BASE_PRICE_WITH_TAX,
 CURRENCY_BASE_PRICE,
 CURRENCY_TAX_BASE_PRICE,
 CURRENCY_BASE_PRICE_WITH_TAX,
 ACCOUNT_QUANTITY,
 ACCOUNT_PRICE,
 ACCOUNT_PRICE_WITH_TAX,
 ACCOUNT_TAX_PRICE
 FROM INVOICE_ITEM;

DROP TABLE INVOICE_ITEM;

/*===================================================================*/

INSERT INTO SALE_SERV SELECT * FROM EXEC_WORK;
DROP TABLE EXEC_WORK;

INSERT INTO SALE_SERV_ITEM 
 SELECT 
 ID,
 EXEC_WORK_ID AS SALE_SERV_ID,
 UNIT_ID,
 TAX_ID,
 PRODUCT_ID,
 PRODUCT_FEATURE_NAME,
 PRICE,
 TAX_PRICE,
 QUANTITY,
 AMOUNT,
 TAX_AMOUNT,
 IS_TAX,
 CURRENCY_PRICE,
 CURRENCY_TAX_PRICE,
 CURRENCY_AMOUNT,
 CURRENCY_TAX_AMOUNT,
 UNIT_RATE,
 PRICE_WITH_TAX,
 AMOUNT_WITH_TAX,
 CURRENCY_PRICE_WITH_TAX,
 CURRENCY_AMOUNT_WITH_TAX,
 TAX_PERCENT,
 ACCOUNT_QUANTITY,
 ACCOUNT_PRICE,
 ACCOUNT_PRICE_WITH_TAX,
 ACCOUNT_TAX_PRICE
 FROM EXEC_WORK_ITEM;

DROP TABLE EXEC_WORK_ITEM;


INSERT INTO SALE_TAX_WAYBILL SELECT ID FROM TAX_WAYBILL;
DROP TABLE TAX_WAYBILL;

INSERT INTO SALE_TAX_WAYBILL_ITEM 
 SELECT
 ID,
 UNIT_ID,
 PRODUCT_ID,
 TAX_WAYBILL_ID AS SALE_TAX_WAYBILL_ID,
 TAX_ID,
 PRODUCT_FEATURE_NAME,
 PRICE,
 TAX_PRICE,
 QUANTITY,
 AMOUNT,
 TAX_AMOUNT,
 IS_TAX,
 CURRENCY_PRICE,
 CURRENCY_TAX_PRICE,
 CURRENCY_AMOUNT,
 CURRENCY_TAX_AMOUNT,
 UNIT_RATE,
 PRICE_WITH_TAX,
 AMOUNT_WITH_TAX,
 CURRENCY_PRICE_WITH_TAX,
 CURRENCY_AMOUNT_WITH_TAX,
 TAX_PERCENT,
 ACCOUNT_QUANTITY,
 ACCOUNT_PRICE,
 ACCOUNT_PRICE_WITH_TAX,
 ACCOUNT_TAX_PRICE
 FROM TAX_WAYBILL_ITEM;

DROP TABLE TAX_WAYBILL_ITEM;








/*==============================================================*/
/* Table: PURCHASE_INVOICE                                      */
/*==============================================================*/
create table PURCHASE_INVOICE (
ID                   INTEGER                        not null,
PRICE_TYPE_ID        INTEGER,
DELIVERY             NUMERIC(15,2)                  default 0 not null,
TAX_DELIVERY         NUMERIC(15,2)                  default 0 not null,
DELIVERY_WITH_TAX    NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY    NUMERIC(15,2)                  default 0 not null,
CURRENCY_TAX_DELIVERY NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY_WITH_TAX NUMERIC(15,2)                  default 0 not null,
IS_PAID              CHAR(1)                        default 'N' not null,
CORRECT_PRICE_TYPE   CHAR(3),
DISCOUNT_PERCENT     NUMERIC(6,2)                   default 0 not null,
MARKUP_PERCENT       NUMERIC(6,2)                   default 0 not null,
constraint PK_PURCHASE_INVOICE primary key (ID)
);

/*==============================================================*/
/* Table: PURCHASE_INVOICE_ITEM                                 */
/*==============================================================*/
create table PURCHASE_INVOICE_ITEM (
ID                   INTEGER                        not null,
TAX_ID               INTEGER,
PURCHASE_INVOICE_ID  INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
PRODUCT_FEATURE_NAME VARCHAR(100),
PRICE                NUMERIC(9,2)                   default 0 not null,
TAX_PRICE            NUMERIC(9,2)                   default 0 not null,
QUANTITY             NUMERIC(9,4)                   default 0 not null,
AMOUNT               NUMERIC(15,2)                  not null,
TAX_AMOUNT           NUMERIC(15,2)                  not null,
IS_TAX               CHAR(1)                        not null,
CURRENCY_PRICE       NUMERIC(15,4)                  default 0 not null,
CURRENCY_TAX_PRICE   NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT      NUMERIC(15,2)                  not null,
CURRENCY_TAX_AMOUNT  NUMERIC(15,2)                  not null,
UNIT_RATE            NUMERIC(15,3)                  not null,
PRICE_WITH_TAX       NUMERIC(9,2)                   not null,
AMOUNT_WITH_TAX      NUMERIC(15,2)                  not null,
CURRENCY_PRICE_WITH_TAX NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT_WITH_TAX NUMERIC(15,2)                  not null,
TAX_PERCENT          NUMERIC(6,2)                   default 0 not null,
CORRECT_PRICE_TYPE   CHAR(3),
DISCOUNT_PERCENT     NUMERIC(6,2)                   default 0 not null,
MARKUP_PERCENT       NUMERIC(6,2)                   default 0 not null,
BASE_PRICE           NUMERIC(9,2)                   default 0 not null,
TAX_BASE_PRICE       NUMERIC(9,2)                   default 0 not null,
BASE_PRICE_WITH_TAX  NUMERIC(9,2)                   default 0 not null,
CURRENCY_BASE_PRICE  NUMERIC(9,2)                   default 0 not null,
CURRENCY_TAX_BASE_PRICE NUMERIC(9,2)                   default 0 not null,
CURRENCY_BASE_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
ACCOUNT_QUANTITY     NUMERIC(9,4)                   default 0 not null,
ACCOUNT_PRICE        NUMERIC(9,2)                   default 0 not null,
ACCOUNT_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
ACCOUNT_TAX_PRICE    NUMERIC(9,2)                   default 0 not null,
constraint PK_PURCHASE_INVOICE_ITEM primary key (ID)
);


/*==============================================================*/
/* Table: PURCHASE_SERV                                         */
/*==============================================================*/
create table PURCHASE_SERV (
ID                   INTEGER                        not null,
constraint PK_PURCHASE_SERV primary key (ID)
);

/*==============================================================*/
/* Table: PURCHASE_SERV_ITEM                                    */
/*==============================================================*/
create table PURCHASE_SERV_ITEM (
ID                   INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
TAX_ID               INTEGER,
PURCHASE_SERV_ID     INTEGER                        not null,
PRODUCT_FEATURE_NAME VARCHAR(100),
PRICE                NUMERIC(9,2)                   default 0 not null,
TAX_PRICE            NUMERIC(9,2)                   default 0 not null,
QUANTITY             NUMERIC(9,4)                   default 0 not null,
AMOUNT               NUMERIC(15,2)                  not null,
TAX_AMOUNT           NUMERIC(15,2)                  not null,
IS_TAX               CHAR(1)                        not null,
CURRENCY_PRICE       NUMERIC(15,4)                  default 0 not null,
CURRENCY_TAX_PRICE   NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT      NUMERIC(15,2)                  not null,
CURRENCY_TAX_AMOUNT  NUMERIC(15,2)                  not null,
UNIT_RATE            NUMERIC(15,3)                  not null,
PRICE_WITH_TAX       NUMERIC(9,2)                   not null,
AMOUNT_WITH_TAX      NUMERIC(15,2)                  not null,
CURRENCY_PRICE_WITH_TAX NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT_WITH_TAX NUMERIC(15,2)                  not null,
TAX_PERCENT          NUMERIC(6,2)                   default 0 not null,
ACCOUNT_QUANTITY     NUMERIC(9,4)                   default 0 not null,
ACCOUNT_PRICE        NUMERIC(9,2)                   default 0 not null,
ACCOUNT_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
ACCOUNT_TAX_PRICE    NUMERIC(9,2)                   default 0 not null,
constraint PK_PURCHASE_SERV_ITEM primary key (ID)
);

/*==============================================================*/
/* Table: PURCHASE_TAX_WAYBILL                                  */
/*==============================================================*/
create table PURCHASE_TAX_WAYBILL (
ID                   INTEGER                        not null,
constraint PK_PURCHASE_TAX_WAYBILL primary key (ID)
);

/*==============================================================*/
/* Table: PURCHASE_TAX_WAYBILL_ITEM                             */
/*==============================================================*/
create table PURCHASE_TAX_WAYBILL_ITEM (
ID                   INTEGER                        not null,
PURCHASE_TAX_WAYBILL_ID INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
TAX_ID               INTEGER,
UNIT_ID              INTEGER                        not null,
PRODUCT_FEATURE_NAME VARCHAR(100),
PRICE                NUMERIC(9,2)                   default 0 not null,
TAX_PRICE            NUMERIC(9,2)                   default 0 not null,
QUANTITY             NUMERIC(9,4)                   default 0 not null,
AMOUNT               NUMERIC(15,2)                  not null,
TAX_AMOUNT           NUMERIC(15,2)                  not null,
IS_TAX               CHAR(1)                        not null,
CURRENCY_PRICE       NUMERIC(15,4)                  default 0 not null,
CURRENCY_TAX_PRICE   NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT      NUMERIC(15,2)                  not null,
CURRENCY_TAX_AMOUNT  NUMERIC(15,2)                  not null,
UNIT_RATE            NUMERIC(15,3)                  not null,
PRICE_WITH_TAX       NUMERIC(9,2)                   not null,
AMOUNT_WITH_TAX      NUMERIC(15,2)                  not null,
CURRENCY_PRICE_WITH_TAX NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT_WITH_TAX NUMERIC(15,2)                  not null,
TAX_PERCENT          NUMERIC(6,2)                   default 0 not null,
ACCOUNT_QUANTITY     NUMERIC(9,4)                   default 0 not null,
ACCOUNT_PRICE        NUMERIC(9,2)                   default 0 not null,
ACCOUNT_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
ACCOUNT_TAX_PRICE    NUMERIC(9,2)                   default 0 not null,
constraint PK_PURCHASE_TAX_WAYBILL_ITEM primary key (ID)
);

/*==============================================================*/
/*                                                              */
/* TODO: Must update system_entity, document_type (new docs)    */
/*                                                              */
/*==============================================================*/


/*==============================================================*/
/*                                                              */
/* ADD COLUMNS                                                  */
/*                                                              */
/*==============================================================*/

ALTER TABLE BUSINESSABLE
 ADD ORGANIZATION_ID INTEGER;

ALTER TABLE BUSINESSABLE
 ADD BRANCH_ID INTEGER;

ALTER TABLE PARTNER
 ADD NEC VARCHAR(20);
/* SWIFT_CODE */

ALTER TABLE PARTNER
 ADD IDN VARCHAR(12);
/* TAX_CODE */

UPDATE PARTNER SET NEC = SWIFT_CODE;
UPDATE PARTNER SET IDN = TAX_CODE;

ALTER TABLE PARTNER
 DROP SWIFT_CODE;

ALTER TABLE PARTNER
 DROP TAX_CODE;



/* PERSON_CARD.TAX_CODE -> IDN */
ALTER TABLE PERSON_CARD
 ADD IDN VARCHAR(12);

UPDATE PERSON_CARD SET IDN = TAX_CODE;

ALTER TABLE PERSON_CARD
 DROP TAX_CODE;


/* BANK.BANK_SWIFT_CODE -> BIC */

ALTER TABLE BANK
 ADD BIC VARCHAR(12);

UPDATE BANK SET BIC = BANK_SWIFT_CODE;

ALTER TABLE BANK
 DROP BANK_SWIFT_CODE;

/*==============================================================*/
/* Table:                                                       */
/*==============================================================*/



/*==============================================================*/
/*                                                              */
/* DROP COLUMNS                                                 */
/*                                                              */
/*==============================================================*/



/*==============================================================*/
/*                                                              */ 
/* Date: 2008-07-03                                             */
/*                                                              */
/*==============================================================*/


ALTER TABLE SYSTEM_INFO
 ADD BRANCH_ID INTEGER;


ALTER TABLE DOCUMENT_TYPE
 ADD IS_DOCUMENT_CODE_READ_ONLY CHAR(1) default 'N' not null;

ALTER TABLE DOCUMENT_TYPE
 ADD IS_DOCUMENT_DATE_READ_ONLY CHAR(1) default 'N' not null;


/*==============================================================*/
/* Table: BRANCH                                                */
/*==============================================================*/
create table BRANCH (
ID                   INTEGER                        not null,
ORGANIZATION_ID      INTEGER                        not null,
NAME                 VARCHAR(50)                    not null,
constraint PK_BRANCH primary key (ID)
);


/*==============================================================*/
/* Table: BRANCH_DOCUMENT_TYPE                                  */
/*==============================================================*/
CREATE TABLE BRANCH_DOCUMENT_TYPE (
ID                   INTEGER                        not null,
DOCUMENT_TYPE_ID     INTEGER                        not null,
DOCUMENT_CODE_PREFIX VARCHAR(10),
DOCUMENT_CODE_SUFFIX VARCHAR(10),
LAST_DOCUMENT_NUMBER INTEGER,
constraint PK_BRANCH_DOCUMENT_TYPE primary key (ID)
);


/*==============================================================*/
/* Table: PARTNER_REPRESENTATIVE                                */
/*==============================================================*/
CREATE TABLE PARTNER_REPRESENTATIVE (
ID                   INTEGER                        not null,
PARTNER_ID           INTEGER                        not null,
CODE                 VARCHAR(20),
NAME                 VARCHAR(100)                   not null,
DOCUMENT             VARCHAR(20),
ADDRESS              VARCHAR(100),
PHONE                VARCHAR(20),
constraint PK_PARTNER_REPRESENTATIVE primary key (ID)
);

ALTER TABLE TASK
 ADD PERCENT_COMPLETE  NUMERIC(6,2) default 0 not null;
 
ALTER TABLE TASK
 ADD ACTUAL_END_DATE_TIME TIMESTAMP;
 
UPDATE TASK SET PERCENT_COMPLETE = DONE_PERCENT;
UPDATE TASK SET ACTUAL_END_DATE_TIME = COMPLETED_DATE_TIME;

ALTER TABLE TASK
 DROP DONE_PERCENT;

ALTER TABLE TASK
 DROP COMPLETED_DATE_TIME;


ALTER TABLE PROJECT
 ADD PERCENT_COMPLETE NUMERIC(6,2) default 0 not null;
 
 
ALTER TABLE GOODS
 ADD IS_INVENTORY CHAR(1) default 'N' not null;

/* 1 - GOODS, 3 - SET, 4 - PRODUCT */
UPDATE GOODS SET IS_INVENTORY = 'Y' WHERE GOODS_TYPE_ID = 1 OR GOODS_TYPE_ID = 3 OR GOODS_TYPE_ID = 4;





/*==============================================================*/
/* Table: INVENTORY_REST                                        */
/*==============================================================*/
create table INVENTORY_REST (
ID                   INTEGER                        not null,
RESPONSIBLE_ID       INTEGER,
WAREHOUSE_ID         INTEGER                        not null,
constraint PK_INVENTORY_REST primary key (ID)
);

/*==============================================================*/
/* Table: INVENTORY_REST_ITEM                                   */
/*==============================================================*/
create table INVENTORY_REST_ITEM (
ID                   INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
INVENTORY_REST_ID    INTEGER                        not null,
TAX_ID               INTEGER,
PRICE                NUMERIC(9,2)                   not null,
TAX_PRICE            NUMERIC(9,2)                   not null,
QUANTITY             NUMERIC(9,4)                   not null,
AMOUNT               NUMERIC(15,2)                  not null,
TAX_AMOUNT           NUMERIC(15,2)                  not null,
IS_TAX               CHAR(1)                        default 'N' not null,
CURRENCY_PRICE       NUMERIC(9,2)                   not null,
CURRENCY_TAX_PRICE   NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT      NUMERIC(15,2)                  not null,
CURRENCY_TAX_AMOUNT  NUMERIC(15,2)                  not null,
UNIT_RATE            NUMERIC(15,3)                  not null,
PRICE_WITH_TAX       NUMERIC(9,2)                   not null,
AMOUNT_WITH_TAX      NUMERIC(15,2)                  not null,
CURRENCY_PRICE_WITH_TAX NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT_WITH_TAX NUMERIC(15,2)                  not null,
TAX_PERCENT          NUMERIC(6,2)                   default 0 not null,
ACCOUNT_QUANTITY     NUMERIC(9,4)                   default 0 not null,
ACCOUNT_PRICE        NUMERIC(9,2)                   default 0 not null,
ACCOUNT_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
ACCOUNT_TAX_PRICE    NUMERIC(9,2)                   default 0 not null,
constraint PK_INVENTORY_REST_ITEM primary key (ID)
);



/*===================================================================*/

INSERT INTO INVENTORY_REST SELECT * FROM GOODS_REST;
DROP TABLE GOODS_REST;

INSERT INTO INVENTORY_REST_ITEM 
 SELECT 
 ID,
 PRODUCT_ID,
 UNIT_ID,
 GOODS_REST_ID AS INVENTORY_REST_ID,
 TAX_ID,
 PRICE,
 TAX_PRICE,
 QUANTITY,
 AMOUNT,
 TAX_AMOUNT,
 IS_TAX,
 CURRENCY_PRICE,
 CURRENCY_TAX_PRICE,
 CURRENCY_AMOUNT,
 CURRENCY_TAX_AMOUNT,
 UNIT_RATE,
 PRICE_WITH_TAX,
 AMOUNT_WITH_TAX,
 CURRENCY_PRICE_WITH_TAX,
 CURRENCY_AMOUNT_WITH_TAX,
 TAX_PERCENT,
 ACCOUNT_QUANTITY,
 ACCOUNT_PRICE,
 ACCOUNT_PRICE_WITH_TAX,
 ACCOUNT_TAX_PRICE
 FROM GOODS_REST_ITEM;

DROP TABLE GOODS_REST_ITEM;





drop table INVENTORY_MOVE;


/*==============================================================*/
/* Table: INVENTORY_MOVE                                        */
/*==============================================================*/
create table INVENTORY_MOVE (
ID                   INTEGER                        not null,
INCOME_WAREHOUSE_ID  INTEGER                        not null,
OUTCOME_WAREHOUSE_ID INTEGER                        not null,
INCOME_RESPONSIBLE_ID INTEGER,
OUTCOME_RESPONSIBLE_ID INTEGER,
constraint PK_INVENTORY_MOVE primary key (ID)
);

/*==============================================================*/
/* Table: INVENTORY_MOVE_ITEM                                   */
/*==============================================================*/
create table INVENTORY_MOVE_ITEM (
ID                   INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
INVENTORY_MOVE_ID    INTEGER                        not null,
TAX_ID               INTEGER,
PRODUCT_ID           INTEGER                        not null,
PRICE                NUMERIC(9,2)                   not null,
TAX_PRICE            NUMERIC(9,2)                   not null,
QUANTITY             NUMERIC(9,4)                   not null,
AMOUNT               NUMERIC(15,2)                  not null,
TAX_AMOUNT           NUMERIC(15,2)                  not null,
IS_TAX               CHAR(1)                        default 'N' not null,
CURRENCY_PRICE       NUMERIC(9,2)                   not null,
CURRENCY_TAX_PRICE   NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT      NUMERIC(15,2)                  not null,
CURRENCY_TAX_AMOUNT  NUMERIC(15,2)                  not null,
UNIT_RATE            NUMERIC(15,3)                  not null,
PRICE_WITH_TAX       NUMERIC(9,2)                   not null,
AMOUNT_WITH_TAX      NUMERIC(15,2)                  not null,
CURRENCY_PRICE_WITH_TAX NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT_WITH_TAX NUMERIC(15,2)                  not null,
TAX_PERCENT          NUMERIC(6,2)                   default 0 not null,
ACCOUNT_QUANTITY     NUMERIC(9,4)                   default 0 not null,
ACCOUNT_PRICE        NUMERIC(9,2)                   default 0 not null,
ACCOUNT_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
ACCOUNT_TAX_PRICE    NUMERIC(9,2)                   default 0 not null,
constraint PK_INVENTORY_MOVE_ITEM primary key (ID)
);


/*===================================================================*/

INSERT INTO INVENTORY_MOVE SELECT * FROM GOODS_MOVE;
DROP TABLE GOODS_MOVE;

INSERT INTO INVENTORY_MOVE_ITEM 
 SELECT 
 ID,
 UNIT_ID,
 GOODS_MOVE_ID AS INVENTORY_MOVE_ID,
 TAX_ID,
 PRODUCT_ID,
 PRICE,
 TAX_PRICE,
 QUANTITY,
 AMOUNT,
 TAX_AMOUNT,
 IS_TAX,
 CURRENCY_PRICE,
 CURRENCY_TAX_PRICE,
 CURRENCY_AMOUNT,
 CURRENCY_TAX_AMOUNT,
 UNIT_RATE,
 PRICE_WITH_TAX,
 AMOUNT_WITH_TAX,
 CURRENCY_PRICE_WITH_TAX,
 CURRENCY_AMOUNT_WITH_TAX,
 TAX_PERCENT,
 ACCOUNT_QUANTITY,
 ACCOUNT_PRICE,
 ACCOUNT_PRICE_WITH_TAX,
 ACCOUNT_TAX_PRICE
 FROM GOODS_MOVE_ITEM;

DROP TABLE GOODS_MOVE_ITEM;


drop table INVENTORY_WRITEOFF;

/*==============================================================*/
/* Table: INVENTORY_WRITEOFF                                    */
/*==============================================================*/
create table INVENTORY_WRITEOFF (
ID                   INTEGER                        not null,
WAREHOUSE_ID         INTEGER                        not null,
RESPONSIBLE_ID       INTEGER,
constraint PK_INVENTORY_WRITEOFF primary key (ID)
);

/*==============================================================*/
/* Table: INVENTORY_WRITEOFF_ITEM                               */
/*==============================================================*/
create table INVENTORY_WRITEOFF_ITEM (
ID                   INTEGER                        not null,
INVENTORY_WRITEOFF_ID INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
TAX_ID               INTEGER,
PRICE                NUMERIC(9,2)                   not null,
TAX_PRICE            NUMERIC(9,2)                   not null,
QUANTITY             NUMERIC(9,4)                   not null,
AMOUNT               NUMERIC(15,2)                  not null,
TAX_AMOUNT           NUMERIC(15,2)                  not null,
IS_TAX               CHAR(1)                        default 'N' not null,
CURRENCY_PRICE       NUMERIC(9,2)                   not null,
CURRENCY_TAX_PRICE   NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT      NUMERIC(15,2)                  not null,
CURRENCY_TAX_AMOUNT  NUMERIC(15,2)                  not null,
UNIT_RATE            NUMERIC(15,3)                  not null,
PRICE_WITH_TAX       NUMERIC(9,2)                   not null,
AMOUNT_WITH_TAX      NUMERIC(15,2)                  not null,
CURRENCY_PRICE_WITH_TAX NUMERIC(9,2)                   not null,
CURRENCY_AMOUNT_WITH_TAX NUMERIC(15,2)                  not null,
TAX_PERCENT          NUMERIC(6,2)                   default 0 not null,
ACCOUNT_QUANTITY     NUMERIC(9,4)                   default 0 not null,
ACCOUNT_PRICE        NUMERIC(9,2)                   default 0 not null,
ACCOUNT_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
ACCOUNT_TAX_PRICE    NUMERIC(9,2)                   default 0 not null,
constraint PK_INVENTORY_WRITEOFF_ITEM primary key (ID)
);


/*==============================================================*/
INSERT INTO INVENTORY_WRITEOFF SELECT * FROM GOODS_WRITEOFF;
DROP TABLE GOODS_WRITEOFF;

INSERT INTO INVENTORY_WRITEOFF_ITEM 
 SELECT 
 ID,
 GOODS_WRITEOFF_ID AS INVENTORY_WRITEOFF_ID,
 UNIT_ID,
 PRODUCT_ID,
 TAX_ID,
 PRICE,
 TAX_PRICE,
 QUANTITY,
 AMOUNT,
 TAX_AMOUNT,
 IS_TAX,
 CURRENCY_PRICE,
 CURRENCY_TAX_PRICE,
 CURRENCY_AMOUNT,
 CURRENCY_TAX_AMOUNT,
 UNIT_RATE,
 PRICE_WITH_TAX,
 AMOUNT_WITH_TAX,
 CURRENCY_PRICE_WITH_TAX,
 CURRENCY_AMOUNT_WITH_TAX,
 TAX_PERCENT,
 ACCOUNT_QUANTITY,
 ACCOUNT_PRICE,
 ACCOUNT_PRICE_WITH_TAX,
 ACCOUNT_TAX_PRICE
FROM GOODS_WRITEOFF_ITEM;

DROP TABLE GOODS_WRITEOFF_ITEM;



drop table INVENTORY_INCOME;

/*==============================================================*/
/* Table: INVENTORY_INCOME                                      */
/*==============================================================*/
create table INVENTORY_INCOME (
ID                   INTEGER                        not null,
WAREHOUSE_ID         INTEGER                        not null,
RESPONSIBLE_ID       INTEGER,
DELIVERY             NUMERIC(15,2)                  default 0 not null,
TAX_DELIVERY         NUMERIC(15,2)                  default 0 not null,
DELIVERY_WITH_TAX    NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY    NUMERIC(15,2)                  default 0 not null,
CURRENCY_TAX_DELIVERY NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY_WITH_TAX NUMERIC(15,2)                  default 0 not null,
constraint PK_INVENTORY_INCOME primary key (ID)
);

/*==============================================================*/
/* Table: INVENTORY_INCOME_ITEM                                 */
/*==============================================================*/
create table INVENTORY_INCOME_ITEM (
ID                   INTEGER                        not null,
INVENTORY_INCOME_ID  INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
TAX_ID               INTEGER,
PRODUCT_FEATURE_NAME VARCHAR(100),
PRICE                NUMERIC(9,2)                   default 0 not null,
TAX_PRICE            NUMERIC(9,2)                   default 0 not null,
QUANTITY             NUMERIC(9,4)                   default 0 not null,
AMOUNT               NUMERIC(15,2)                  default 0 not null,
TAX_AMOUNT           NUMERIC(15,2)                  default 0 not null,
IS_TAX               CHAR(1)                        default 'N' not null,
CURRENCY_PRICE       NUMERIC(9,2)                   default 0 not null,
CURRENCY_TAX_PRICE   NUMERIC(9,2)                   default 0 not null,
CURRENCY_AMOUNT      NUMERIC(15,2)                  default 0 not null,
CURRENCY_TAX_AMOUNT  NUMERIC(15,2)                  default 0 not null,
UNIT_RATE            NUMERIC(15,3)                  not null,
PRICE_WITH_TAX       NUMERIC(9,2)                   default 0 not null,
AMOUNT_WITH_TAX      NUMERIC(15,2)                  default 0 not null,
CURRENCY_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
CURRENCY_AMOUNT_WITH_TAX NUMERIC(15,2)                  default 0 not null,
TAX_PERCENT          NUMERIC(6,2)                   default 0 not null,
ACCOUNT_QUANTITY     NUMERIC(9,4)                   default 0 not null,
ACCOUNT_PRICE        NUMERIC(9,2)                   default 0 not null,
ACCOUNT_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
ACCOUNT_TAX_PRICE    NUMERIC(9,2)                   default 0 not null,
constraint PK_INVENTORY_INCOME_ITEM primary key (ID)
);


drop table INVENTORY_OUTCOME;

/*==============================================================*/
/* Table: INVENTORY_OUTCOME                                     */
/*==============================================================*/
create table INVENTORY_OUTCOME (
ID                   INTEGER                        not null,
WAREHOUSE_ID         INTEGER                        not null,
RESPONSIBLE_ID       INTEGER,
DELIVERY             NUMERIC(15,2)                  default 0 not null,
TAX_DELIVERY         NUMERIC(15,2)                  default 0 not null,
DELIVERY_WITH_TAX    NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY    NUMERIC(15,2)                  default 0 not null,
CURRENCY_TAX_DELIVERY NUMERIC(15,2)                  default 0 not null,
CURRENCY_DELIVERY_WITH_TAX NUMERIC(15,2)                  default 0 not null,
constraint PK_INVENTORY_OUTCOME primary key (ID)
);

/*==============================================================*/
/* Table: INVENTORY_OUTCOME_ITEM                                */
/*==============================================================*/
create table INVENTORY_OUTCOME_ITEM (
ID                   INTEGER                        not null,
UNIT_ID              INTEGER                        not null,
TAX_ID               INTEGER,
PRODUCT_INSTANCE_ID  INTEGER,
PRODUCT_ID           INTEGER                        not null,
INVENTORY_OUTCOME_ID INTEGER                        not null,
PRODUCT_FEATURE_NAME VARCHAR(100),
PRICE                NUMERIC(9,2)                   default 0 not null,
TAX_PRICE            NUMERIC(9,2)                   default 0 not null,
QUANTITY             NUMERIC(9,4)                   default 0 not null,
AMOUNT               NUMERIC(15,2)                  default 0 not null,
TAX_AMOUNT           NUMERIC(15,2)                  default 0 not null,
IS_TAX               CHAR(1)                        default 'N' not null,
CURRENCY_PRICE       NUMERIC(9,2)                   default 0 not null,
CURRENCY_TAX_PRICE   NUMERIC(9,2)                   default 0 not null,
CURRENCY_AMOUNT      NUMERIC(15,2)                  default 0 not null,
CURRENCY_TAX_AMOUNT  NUMERIC(15,2)                  default 0 not null,
UNIT_RATE            NUMERIC(15,3)                  not null,
PRICE_WITH_TAX       NUMERIC(9,2)                   default 0 not null,
AMOUNT_WITH_TAX      NUMERIC(15,2)                  default 0 not null,
CURRENCY_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
CURRENCY_AMOUNT_WITH_TAX NUMERIC(15,2)                  default 0 not null,
TAX_PERCENT          NUMERIC(6,2)                   default 0 not null,
ACCOUNT_QUANTITY     NUMERIC(9,4)                   default 0 not null,
ACCOUNT_PRICE        NUMERIC(9,2)                   default 0 not null,
ACCOUNT_PRICE_WITH_TAX NUMERIC(9,2)                   default 0 not null,
ACCOUNT_TAX_PRICE    NUMERIC(9,2)                   default 0 not null,
constraint PK_INVENTORY_OUTCOME_ITEM primary key (ID)
);


ALTER TABLE  SYSTEM_ROLE
 ADD DEFAULT_UI_ID CHAR(30);


ALTER TABLE  SYSTEM_USER
 ADD DEFAULT_UI_ID CHAR(30);


create table SYSTEM_ROLE_UI (
ID                   INTEGER                        not null,
ROLE_ID              INTEGER                        not null,
UI_ID                VARCHAR(30)                    not null,
constraint PK_SYSTEM_ROLE_UI primary key (ID)
);



ALTER TABLE SYSTEM_ENTITY
 ADD IS_CACHE CHAR(1) default 'N' not null;

ALTER TABLE SYSTEM_ENTITY
 ADD CACHE_EXPIRE_TIME INTEGER default 0 not null;


/* PRODUCT.LIST_PRICE */

ALTER TABLE PRODUCT
 ADD LIST_PRICE  NUMERIC(15,4) default 0 not null;

ALTER TABLE PRODUCT
 ADD CURRENCY_LIST_PRICE  NUMERIC(15,4) default 0 not null;

UPDATE PRODUCT SET LIST_PRICE = PRICE, CURRENCY_LIST_PRICE = CURRENCY_PRICE;


/* PRODUCT.AVAILABILITY_QUANTITY -> AVAILABLE_QUANTITY */
/* PRODUCT.RESERVE_QUANTITY -> RESERVED_QUANTITY */
/* PRODUCT.AWAIT_QUANTITY -> EXPECTED_QUANTITY */
    
ALTER TABLE PRODUCT
 ADD AVAILABLE_QUANTITY NUMERIC(15,4) default 0 not null;

ALTER TABLE PRODUCT
 ADD RESERVED_QUANTITY NUMERIC(15,4) default 0 not null;

ALTER TABLE PRODUCT
 ADD EXPECTED_QUANTITY NUMERIC(15,4) default 0 not null;


UPDATE PRODUCT SET AVAILABLE_QUANTITY = AVAILABILITY_QUANTITY;
UPDATE PRODUCT SET RESERVED_QUANTITY = RESERVE_QUANTITY;
UPDATE PRODUCT SET EXPECTED_QUANTITY = AWAIT_QUANTITY;



/*==============================================================*/
/* Table: PARTNER_TYPE                                          */
/*==============================================================*/
create table PARTNER_TYPE (
ID                   INTEGER                        not null,
NAME                 VARCHAR(30)                    not null,
constraint PK_PARTNER_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: SYSTEM_USER_ORG                                       */
/*==============================================================*/
create table SYSTEM_USER_ORG (
ID                   INTEGER                        not null,
ORGANIZATION_ID      INTEGER                        not null,
USER_ID              INTEGER                        not null,
constraint PK_SYSTEM_USER_ORG primary key (ID)
);





/*==============================================================*/
/* FIX                                                          */
/*==============================================================*/



ALTER TABLE BRIGADE
 ADD BRANCH_ID INTEGER;

ALTER TABLE BUSINESSABLE_REGISTER
 ADD BRANCH_ID INTEGER;

ALTER TABLE DEPARTMENT
 ADD BRANCH_ID INTEGER;

ALTER TABLE DOCUMENT
 ADD BRANCH_ID INTEGER;

ALTER TABLE DRUGSTORE
 ADD BRANCH_ID INTEGER;

ALTER TABLE EMPLOYEE
 ADD BRANCH_ID INTEGER;

ALTER TABLE EMPLOYEE_PAYROLL
 ADD BRANCH_ID INTEGER;

ALTER TABLE FACTORY
 ADD BRANCH_ID INTEGER;

/* It was removed to <lang>/update_data...*/
/*
ALTER TABLE PARTNER
 ADD PARTNER_TYPE_ID INTEGER DEFAULT 1 NOT NULL;
*/

ALTER TABLE PRODUCT
 DROP AVAILABILITY_QUANTITY;

ALTER TABLE PRODUCT
 DROP RESERVE_QUANTITY;

ALTER TABLE PRODUCT
 DROP AWAIT_QUANTITY;

ALTER TABLE PROJECT
 ADD BRANCH_ID INTEGER;

ALTER TABLE RESPONSIBLE
 ADD BRANCH_ID INTEGER;


ALTER TABLE SHOP
 ADD BRANCH_ID INTEGER;

ALTER TABLE STORE
 ADD BRANCH_ID INTEGER;

ALTER TABLE SYSTEM_INFO
 ADD IS_AUTO_CALCULATE_PROD_REST CHAR(1) DEFAULT 'Y' NOT NULL;

ALTER TABLE SYSTEM_ROLE
 DROP UI_ID;

ALTER TABLE SYSTEM_USER
 DROP UI_ID;

ALTER TABLE TASK
 ADD BRANCH_ID INTEGER;

ALTER TABLE WORKS
 ADD BRANCH_ID INTEGER;

ALTER TABLE WORKSHOP
 ADD BRANCH_ID INTEGER;
/*===================================================*/
/*                                                   */
/* Update system                                     */
/*                                                   */
/*===================================================*/
/* 1. Rename entities
/*===================================================*/


/* SYSTEM_ENTITY */

 UPDATE SYSTEM_ENTITY SET ID = 'SALE_INVOICE', CODE =  'SALE_INVOICE' WHERE ID = 'INVOICE';
 UPDATE SYSTEM_ENTITY SET ID = 'SALE_INVOICE_ITEM', CODE =  'SALE_INVOICE_ITEM' WHERE ID = 'INVOICE_ITEM';
 UPDATE SYSTEM_ENTITY SET ID = 'SALE_SERV', CODE =  'SALE_SERV' WHERE ID = 'EXEC_WORK';
 UPDATE SYSTEM_ENTITY SET ID = 'SALE_SERV_ITEM', CODE =  'SALE_SERV_ITEM' WHERE ID = 'EXEC_WORK_ITEM';
 UPDATE SYSTEM_ENTITY SET ID = 'SALE_TAX_WAYBILL', CODE =  'SALE_TAX_WAYBILL' WHERE ID = 'TAX_WAYBILL';
 UPDATE SYSTEM_ENTITY SET ID = 'SALE_TAX_WAYBILL_ITEM', CODE =  'SALE_TAX_WAYBILL_ITEM' WHERE ID = 'TAX_WAYBILL_ITEM';
 UPDATE SYSTEM_ENTITY SET ID = 'INVENTORY_REST', CODE =  'INVENTORY_REST' WHERE ID = 'GOODS_REST';
 UPDATE SYSTEM_ENTITY SET ID = 'INVENTORY_REST_ITEM', CODE =  'INVENTORY_REST_ITEM' WHERE ID = 'GOODS_REST_ITEM';
 UPDATE SYSTEM_ENTITY SET ID = 'INVENTORY_MOVE', CODE =  'INVENTORY_MOVE' WHERE ID = 'GOODS_MOVE';
 UPDATE SYSTEM_ENTITY SET ID = 'INVENTORY_MOVE_ITEM', CODE =  'INVENTORY_MOVE_ITEM' WHERE ID = 'GOODS_MOVE_ITEM';
 UPDATE SYSTEM_ENTITY SET ID = 'INVENTORY_WRITEOFF', CODE =  'INVENTORY_WRITEOFF' WHERE ID = 'GOODS_WRITEOFF';
 UPDATE SYSTEM_ENTITY SET ID = 'INVENTORY_WRITEOFF_ITEM', CODE =  'INVENTORY_WRITEOFF_ITEM' WHERE ID = 'GOODS_WRITEOFF_ITEM';



/* DOCUMENT_TYPE */

 UPDATE DOCUMENT_TYPE SET ENTITY_ID = 'SALE_INVOICE' WHERE ENTITY_ID = 'INVOICE';
 UPDATE DOCUMENT_TYPE SET ENTITY_ID = 'SALE_INVOICE_ITEM' WHERE ENTITY_ID = 'INVOICE_ITEM';
 UPDATE DOCUMENT_TYPE SET ENTITY_ID = 'SALE_SERV' WHERE ENTITY_ID = 'EXEC_WORK';
 UPDATE DOCUMENT_TYPE SET ENTITY_ID = 'SALE_SERV_ITEM' WHERE ENTITY_ID = 'EXEC_WORK_ITEM';
 UPDATE DOCUMENT_TYPE SET ENTITY_ID = 'SALE_TAX_WAYBILL' WHERE ENTITY_ID = 'TAX_WAYBILL';
 UPDATE DOCUMENT_TYPE SET ENTITY_ID = 'SALE_TAX_WAYBILL_ITEM' WHERE ENTITY_ID = 'TAX_WAYBILL_ITEM';
 UPDATE DOCUMENT_TYPE SET ENTITY_ID = 'INVENTORY_REST' WHERE ENTITY_ID = 'GOODS_REST';
 UPDATE DOCUMENT_TYPE SET ENTITY_ID = 'INVENTORY_REST_ITEM' WHERE ENTITY_ID = 'GOODS_REST_ITEM';
 UPDATE DOCUMENT_TYPE SET ENTITY_ID = 'INVENTORY_MOVE' WHERE ENTITY_ID = 'GOODS_MOVE';
 UPDATE DOCUMENT_TYPE SET ENTITY_ID = 'INVENTORY_MOVE_ITEM' WHERE ENTITY_ID = 'GOODS_MOVE_ITEM';
 UPDATE DOCUMENT_TYPE SET ENTITY_ID = 'INVENTORY_WRITEOFF' WHERE ENTITY_ID = 'GOODS_WRITEOFF';
 UPDATE DOCUMENT_TYPE SET ENTITY_ID = 'INVENTORY_WRITEOFF_ITEM' WHERE ENTITY_ID = 'GOODS_WRITEOFF_ITEM';


 
/* SECURE_OBJECT */

 UPDATE SECURE_OBJECT SET ENTITY_ID = 'SALE_INVOICE', CODE =  'SALE_INVOICE' WHERE ENTITY_ID = 'INVOICE';
 UPDATE SECURE_OBJECT SET ENTITY_ID = 'SALE_INVOICE_ITEM', CODE =  'SALE_INVOICE_ITEM' WHERE ENTITY_ID = 'INVOICE_ITEM';
 UPDATE SECURE_OBJECT SET ENTITY_ID = 'SALE_SERV', CODE =  'SALE_SERV' WHERE ENTITY_ID = 'EXEC_WORK';
 UPDATE SECURE_OBJECT SET ENTITY_ID = 'SALE_SERV_ITEM', CODE =  'SALE_SERV_ITEM' WHERE ENTITY_ID = 'EXEC_WORK_ITEM';
 UPDATE SECURE_OBJECT SET ENTITY_ID = 'SALE_TAX_WAYBILL', CODE =  'SALE_TAX_WAYBILL' WHERE ENTITY_ID = 'TAX_WAYBILL';
 UPDATE SECURE_OBJECT SET ENTITY_ID = 'SALE_TAX_WAYBILL_ITEM', CODE =  'SALE_TAX_WAYBILL_ITEM' WHERE ENTITY_ID = 'TAX_WAYBILL_ITEM';
 UPDATE SECURE_OBJECT SET ENTITY_ID = 'INVENTORY_REST', CODE =  'INVENTORY_REST' WHERE ENTITY_ID = 'GOODS_REST';
 UPDATE SECURE_OBJECT SET ENTITY_ID = 'INVENTORY_REST_ITEM', CODE =  'INVENTORY_REST_ITEM' WHERE ENTITY_ID = 'GOODS_REST_ITEM';
 UPDATE SECURE_OBJECT SET ENTITY_ID = 'INVENTORY_MOVE', CODE =  'INVENTORY_MOVE' WHERE ENTITY_ID = 'GOODS_MOVE';
 UPDATE SECURE_OBJECT SET ENTITY_ID = 'INVENTORY_MOVE_ITEM', CODE =  'INVENTORY_MOVE_ITEM' WHERE ENTITY_ID = 'GOODS_MOVE_ITEM';
 UPDATE SECURE_OBJECT SET ENTITY_ID = 'INVENTORY_WRITEOFF', CODE =  'INVENTORY_WRITEOFF' WHERE ENTITY_ID = 'GOODS_WRITEOFF';
 UPDATE SECURE_OBJECT SET ENTITY_ID = 'INVENTORY_WRITEOFF_ITEM', CODE =  'INVENTORY_WRITEOFF_ITEM' WHERE ENTITY_ID = 'GOODS_WRITEOFF_ITEM';



/* SYSTEM_ATTR */

 UPDATE SYSTEM_ATTR SET ENTITY_ID = 'SALE_INVOICE' WHERE ENTITY_ID = 'INVOICE';
 UPDATE SYSTEM_ATTR SET ENTITY_ID = 'SALE_INVOICE_ITEM' WHERE ENTITY_ID = 'INVOICE_ITEM';
 UPDATE SYSTEM_ATTR SET ENTITY_ID = 'SALE_SERV' WHERE ENTITY_ID = 'EXEC_WORK';
 UPDATE SYSTEM_ATTR SET ENTITY_ID = 'SALE_SERV_ITEM' WHERE ENTITY_ID = 'EXEC_WORK_ITEM';
 UPDATE SYSTEM_ATTR SET ENTITY_ID = 'SALE_TAX_WAYBILL' WHERE ENTITY_ID = 'TAX_WAYBILL';
 UPDATE SYSTEM_ATTR SET ENTITY_ID = 'SALE_TAX_WAYBILL_ITEM' WHERE ENTITY_ID = 'TAX_WAYBILL_ITEM';
 UPDATE SYSTEM_ATTR SET ENTITY_ID = 'INVENTORY_REST' WHERE ENTITY_ID = 'GOODS_REST';
 UPDATE SYSTEM_ATTR SET ENTITY_ID = 'INVENTORY_REST_ITEM' WHERE ENTITY_ID = 'GOODS_REST_ITEM';
 UPDATE SYSTEM_ATTR SET ENTITY_ID = 'INVENTORY_MOVE' WHERE ENTITY_ID = 'GOODS_MOVE';
 UPDATE SYSTEM_ATTR SET ENTITY_ID = 'INVENTORY_MOVE_ITEM' WHERE ENTITY_ID = 'GOODS_MOVE_ITEM';
 UPDATE SYSTEM_ATTR SET ENTITY_ID = 'INVENTORY_WRITEOFF' WHERE ENTITY_ID = 'GOODS_WRITEOFF';
 UPDATE SYSTEM_ATTR SET ENTITY_ID = 'INVENTORY_WRITEOFF_ITEM' WHERE ENTITY_ID = 'GOODS_WRITEOFF_ITEM';



/* SYSTEM_ATTR_TYPE */

 UPDATE SYSTEM_ATTR_TYPE SET ENTITY_ID = 'SALE_INVOICE' WHERE ENTITY_ID = 'INVOICE';
 UPDATE SYSTEM_ATTR_TYPE SET ENTITY_ID = 'SALE_INVOICE_ITEM' WHERE ENTITY_ID = 'INVOICE_ITEM';
 UPDATE SYSTEM_ATTR_TYPE SET ENTITY_ID = 'SALE_SERV' WHERE ENTITY_ID = 'EXEC_WORK';
 UPDATE SYSTEM_ATTR_TYPE SET ENTITY_ID = 'SALE_SERV_ITEM' WHERE ENTITY_ID = 'EXEC_WORK_ITEM';
 UPDATE SYSTEM_ATTR_TYPE SET ENTITY_ID = 'SALE_TAX_WAYBILL' WHERE ENTITY_ID = 'TAX_WAYBILL';
 UPDATE SYSTEM_ATTR_TYPE SET ENTITY_ID = 'SALE_TAX_WAYBILL_ITEM' WHERE ENTITY_ID = 'TAX_WAYBILL_ITEM';
 UPDATE SYSTEM_ATTR_TYPE SET ENTITY_ID = 'INVENTORY_REST' WHERE ENTITY_ID = 'GOODS_REST';
 UPDATE SYSTEM_ATTR_TYPE SET ENTITY_ID = 'INVENTORY_REST_ITEM' WHERE ENTITY_ID = 'GOODS_REST_ITEM';
 UPDATE SYSTEM_ATTR_TYPE SET ENTITY_ID = 'INVENTORY_MOVE' WHERE ENTITY_ID = 'GOODS_MOVE';
 UPDATE SYSTEM_ATTR_TYPE SET ENTITY_ID = 'INVENTORY_MOVE_ITEM' WHERE ENTITY_ID = 'GOODS_MOVE_ITEM';
 UPDATE SYSTEM_ATTR_TYPE SET ENTITY_ID = 'INVENTORY_WRITEOFF' WHERE ENTITY_ID = 'GOODS_WRITEOFF';
 UPDATE SYSTEM_ATTR_TYPE SET ENTITY_ID = 'INVENTORY_WRITEOFF_ITEM' WHERE ENTITY_ID = 'GOODS_WRITEOFF_ITEM';



 /* SYSTEM_ATTR_TYPE_GROUP */

 UPDATE SYSTEM_ATTR_TYPE_GROUP SET ENTITY_ID = 'SALE_INVOICE' WHERE ENTITY_ID = 'INVOICE';
 UPDATE SYSTEM_ATTR_TYPE_GROUP SET ENTITY_ID = 'SALE_INVOICE_ITEM' WHERE ENTITY_ID = 'INVOICE_ITEM';
 UPDATE SYSTEM_ATTR_TYPE_GROUP SET ENTITY_ID = 'SALE_SERV' WHERE ENTITY_ID = 'EXEC_WORK';
 UPDATE SYSTEM_ATTR_TYPE_GROUP SET ENTITY_ID = 'SALE_SERV_ITEM' WHERE ENTITY_ID = 'EXEC_WORK_ITEM';
 UPDATE SYSTEM_ATTR_TYPE_GROUP SET ENTITY_ID = 'SALE_TAX_WAYBILL' WHERE ENTITY_ID = 'TAX_WAYBILL';
 UPDATE SYSTEM_ATTR_TYPE_GROUP SET ENTITY_ID = 'SALE_TAX_WAYBILL_ITEM' WHERE ENTITY_ID = 'TAX_WAYBILL_ITEM';
 UPDATE SYSTEM_ATTR_TYPE_GROUP SET ENTITY_ID = 'INVENTORY_REST' WHERE ENTITY_ID = 'GOODS_REST';
 UPDATE SYSTEM_ATTR_TYPE_GROUP SET ENTITY_ID = 'INVENTORY_REST_ITEM' WHERE ENTITY_ID = 'GOODS_REST_ITEM';
 UPDATE SYSTEM_ATTR_TYPE_GROUP SET ENTITY_ID = 'INVENTORY_MOVE' WHERE ENTITY_ID = 'GOODS_MOVE';
 UPDATE SYSTEM_ATTR_TYPE_GROUP SET ENTITY_ID = 'INVENTORY_MOVE_ITEM' WHERE ENTITY_ID = 'GOODS_MOVE_ITEM';
 UPDATE SYSTEM_ATTR_TYPE_GROUP SET ENTITY_ID = 'INVENTORY_WRITEOFF' WHERE ENTITY_ID = 'GOODS_WRITEOFF';
 UPDATE SYSTEM_ATTR_TYPE_GROUP SET ENTITY_ID = 'INVENTORY_WRITEOFF_ITEM' WHERE ENTITY_ID = 'GOODS_WRITEOFF_ITEM';

/*===================================================*/
/* 2. Delete entities
/*===================================================*/


/*===================================================*/
/* 3. Insert entities
/*===================================================*/


 INSERT INTO SYSTEM_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID) VALUES ('PURCHASE_INVOICE', 'PURCHASE_INVOICE', '-', 'ENTITY');
 INSERT INTO SYSTEM_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID) VALUES ('PURCHASE_INVOICE_ITEM', 'PURCHASE_INVOICE_ITEM', '-', 'ENTITY');
 INSERT INTO SYSTEM_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID) VALUES ('PURCHASE_SERV', 'PURCHASE_SERV', '-', 'ENTITY');
 INSERT INTO SYSTEM_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID) VALUES ('PURCHASE_SERV_ITEM', 'PURCHASE_SERV_ITEM', '-', 'ENTITY');
 INSERT INTO SYSTEM_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID) VALUES ('PURCHASE_TAX_WAYBILL', 'PURCHASE_TAX_WAYBILL', '-', 'ENTITY');
 INSERT INTO SYSTEM_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID) VALUES ('PURCHASE_TAX_WAYBILL_ITEM', 'PURCHASE_TAX_WAYBILL_ITEM', '-', 'ENTITY');
 INSERT INTO SYSTEM_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID) VALUES ('INVENTORY_INCOME', 'INVENTORY_INCOME', '-', 'ENTITY');
 INSERT INTO SYSTEM_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID) VALUES ('INVENTORY_INCOME_ITEM', 'INVENTORY_INCOME_ITEM', '-', 'ENTITY');
 INSERT INTO SYSTEM_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID) VALUES ('INVENTORY_OUTCOME', 'INVENTORY_OUTCOME', '-', 'ENTITY');
 INSERT INTO SYSTEM_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID) VALUES ('INVENTORY_OUTCOME_ITEM', 'INVENTORY_OUTCOME_ITEM', '-', 'ENTITY');


/* ID is started from 22 !!! */

 INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (22, 'PURCHASE_INVOICE','GOODS', NULL);
 INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (23, 'PURCHASE_SERV','GOODS', NULL);
 INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (24, 'PURCHASE_TAX_WAYBILL','GOODS', NULL);
 INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (25, 'INVENTORY_INCOME','INVENTORY', NULL);
 INSERT INTO DOCUMENT_TYPE (ID, ENTITY_ID, DOCUMENT_SECTION, DOCUMENT_CATEGORY) VALUES (26, 'INVENTORY_OUTCOME','INVENTORY', NULL);

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'ACADEMIC_DEGREE',
    NAME = 'Учёная степень',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'ACADEMIC_DEGREE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'ACTIVITY_TYPE',
    NAME = 'Тип активности компаний',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PARTNER',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'ACTIVITY_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'ADDRESS',
    NAME = 'Адрес',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'ADDRESS');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'ADDRESS_TYPE',
    NAME = 'Тип адреса',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'ADDRESS_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'APPARTMENT_TYPE',
    NAME = 'Тип апартаментов',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'APPARTMENT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'ASSET',
    NAME = 'Основное средство',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'ASSET');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'BANK',
    NAME = 'Банк',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'Y',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'BANK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'BANK_ACCOUNT',
    NAME = 'Банковский счет',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'BANK_ACCOUNT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'BANK_CONTEXT',
    NAME = 'Контекст модуля <Банк>',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'BANK_CONTEXT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'BRIGADE',
    NAME = 'Бригада',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'BRIGADE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'BUSINESSABLE',
    NAME = 'Бизнес-объект',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'BUSINESSABLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'BUSINESSABLE_ENTITY',
    NAME = 'Бизнес-сущность',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'BUSINESSABLE_ENTITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'BUSINESSABLE_REGISTER',
    NAME = 'Регистр бизнес объектов',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'BUSINESSABLE_REGISTER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'CASH_INCOME',
    NAME = 'Приходный кассовый ордер',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CASH',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'CASH_INCOME');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'CASH_OUTCOME',
    NAME = 'Расходный кассовый ордер',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CASH',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'CASH_OUTCOME');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'CITY',
    NAME = 'Город',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'CITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'CONTACT',
    NAME = 'Контакт',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'ORGANIZATION',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'Y',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'CONTACT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'CONTACTABLE',
    NAME = 'Контакт-объект',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'CONTACTABLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'CONTACTABLE_ENTITY',
    NAME = 'Контакт-сущность',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'CONTACTABLE_ENTITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'CONTACT_CONTEXT',
    NAME = 'Контекст модуля <Контакты>',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'CONTACT_CONTEXT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'CONTACT_TYPE',
    NAME = 'Тип контактов',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'CONTACT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'CONTRACT',
    NAME = 'Договор',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'DOCUMENT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'CONTRACT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'CONTRACTOR',
    NAME = 'Контрактник',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'CONTRACTOR');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'CONTRACTOR_MOVE',
    NAME = 'Движение по контрактнику',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'CONTRACTOR_MOVE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'COUNTRY',
    NAME = 'Страна',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'COUNTRY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'CURRENCY',
    NAME = 'Валюта',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'CURRENCY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'DATA_TYPE',
    NAME = 'Тип данных',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'DATA_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'DEPARTMENT',
    NAME = 'Подразделение',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'ORGANIZATION',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'DEPARTMENT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'DISCHARGE_TYPE',
    NAME = 'Тип увольнения',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'EMPLOYEE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'DISCHARGE_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'DISTRICT',
    NAME = 'Район',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'DISTRICT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'DOCUMENT',
    NAME = 'Документ',
    ENTITY_CLASS = 'JournalDocument',
    ENTITY_PACKAGE = 'DOCUMENT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'DOCUMENT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'DOCUMENT_TYPE',
    NAME = 'Тип документа',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'DOCUMENT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'DOCUMENT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'DRUGSTORE',
    NAME = 'Аптека',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'DRUGSTORE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'EDUCATION_FORM',
    NAME = 'Форма образования',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EDUCATION_FORM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'EDUCATION_INSTITUTE',
    NAME = 'Учебное заведение',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EDUCATION_INSTITUTE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'EDUCATION_TYPE',
    NAME = 'Тип образования',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EDUCATION_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'EMAIL',
    NAME = 'E-mail',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EMAIL');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'EMPLOYEE',
    NAME = 'Служащий',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'EMPLOYEE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'Y',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EMPLOYEE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'EMPLOYEE_CATEGORY',
    NAME = 'Категория служащих',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'EMPLOYEE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EMPLOYEE_CATEGORY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'EMPLOYEE_DISCHARGE',
    NAME = 'Приказ об увольнении',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'EMPLOYEE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EMPLOYEE_DISCHARGE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'EMPLOYEE_VACATION',
    NAME = 'Отпускные',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EMPLOYEE_VACATION');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'EMPLOYEE_VACATION_AVERANGE',
    NAME = 'Средние по отпускным',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EMPLOYEE_VACATION_AVERANGE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'EMPLOYEE_MOVE',
    NAME = 'Движения по служащим',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'EMPLOYEE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'N',
    IS_FORM = 'Y',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EMPLOYEE_MOVE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'EMPLOYEE_PAYROLL',
    NAME = 'Зарплата служащего',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EMPLOYEE_PAYROLL');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'EMPLOYEE_RANK',
    NAME = 'Ранг служащего',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'EMPLOYEE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EMPLOYEE_RANK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'EMPLOYEE_RECEPTION',
    NAME = 'Приказ о приёме на работу',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'EMPLOYEE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EMPLOYEE_RECEPTION');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'EMPLOYEE_SICKLIST',
    NAME = 'Больничные',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EMPLOYEE_SICKLIST');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'EMPLOYEE_SICKLIST_AVERANGE',
    NAME = 'Средние по больничным',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EMPLOYEE_SICKLIST_AVERANGE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'EMPLOYEE_TOTAL',
    NAME = 'Итог по служащему',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EMPLOYEE_TOTAL');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'ENTRY_ITEM',
    NAME = 'Проводки по документу',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'ENTRY_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'FACTORY',
    NAME = 'Фабрика',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'FACTORY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'FAMILIARITY',
    NAME = 'Родственные связи',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'FAMILIARITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'FAMILY_STATUS',
    NAME = 'Семейное положение',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'FAMILY_STATUS');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'FINANCE_DOCUMENT',
    NAME = 'Финансовый документ',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'FINANCE_DOCUMENT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'FINANCE_DOCUMENT_TYPE',
    NAME = 'Тип финансового документа',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'FINANCE_DOCUMENT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'FORM_PROPERTY',
    NAME = 'Форма собственности',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PARTNER',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'FORM_PROPERTY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'GOODS',
    NAME = 'Товар/услуга',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'Y',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'GOODS');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'GOODS_INCOME',
    NAME = 'Накладная на реализацию',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'GOODS_INCOME');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'GOODS_INCOME_ITEM',
    NAME = 'Строчки накладной на реализацию',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'GOODS_INCOME_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'GOODS_OUTCOME',
    NAME = 'Накладная на закупку',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'GOODS_OUTCOME');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'GOODS_OUTCOME_ITEM',
    NAME = 'Строчки накладной на закупку',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'GOODS_OUTCOME_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'GOODS_TYPE',
    NAME = 'Тип товара',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'GOODS_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'INVENTORY_MOVE',
    NAME = 'Накладная на внутренне перемещение',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'INVENTORY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'INVENTORY_MOVE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'INVENTORY_MOVE_ITEM',
    NAME = 'Строчки накладной на внутренне перемещение',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'INVENTORY',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'INVENTORY_MOVE_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'INVENTORY_REST',
    NAME = 'Остатки по товару',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'INVENTORY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'INVENTORY_REST');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'INVENTORY_REST_ITEM',
    NAME = 'Строчки остатков по товару',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'INVENTORY',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'INVENTORY_REST_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'INVENTORY_WRITEOFF',
    NAME = 'Акт на списание',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'INVENTORY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'INVENTORY_WRITEOFF');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'INVENTORY_WRITEOFF_ITEM',
    NAME = 'Строчки акта на списание',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'INVENTORY',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'INVENTORY_WRITEOFF_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'INVENTORY_INCOME',
    NAME = 'Приходная накладная',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'INVENTORY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'INVENTORY_INCOME');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'INVENTORY_INCOME_ITEM',
    NAME = 'Строчки приходной накладной',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'INVENTORY',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'INVENTORY_INCOME_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'INVENTORY_OUTCOME',
    NAME = 'Расходная накладная',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'INVENTORY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'INVENTORY_OUTCOME');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'INVENTORY_OUTCOME_ITEM',
    NAME = 'Строчки расходной накладной',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'INVENTORY',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'INVENTORY_OUTCOME_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'INDUSTRY',
    NAME = 'Индустрия',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PARTNER',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'INDUSTRY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'INTANGIBLE',
    NAME = 'Нематериальные активы',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'INTANGIBLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'LANGUAGE',
    NAME = 'Язык',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'LANGUAGE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'VACATION_AVERANGE_TYPE',
    NAME = 'Тип средних по отпуску',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'VACATION_AVERANGE_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'VACATION_CALCULATE',
    NAME = 'Тип расчёта по отпуску',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'VACATION_CALCULATE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'VACATION_TYPE',
    NAME = 'Тип отпуска',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'VACATION_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'LEDGER_ACCOUNT',
    NAME = 'Бухгалтерский счёт',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'LEDGER_ACCOUNT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'LEDGER_ACCOUNT_REGISTER',
    NAME = 'Регистр по бухгалтерскому счёту',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'LEDGER_ACCOUNT_REGISTER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'LEDGER_ACCOUNT_REST',
    NAME = 'Остатки по бухгалтерскому счёту',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'LEDGER_ACCOUNT_REST');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'LEDGER_ACCOUNT_TYPE',
    NAME = 'Тип бухгалтерского счёта',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'LEDGER_ACCOUNT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'LOCALITY',
    NAME = 'Населённый пункт',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'LOCALITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'LOCALITY_TYPE',
    NAME = 'Тип населённого пункта',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'LOCALITY_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'MILITARY_RANK',
    NAME = 'Воинское звание',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'MILITARY_RANK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'MILITARY_SPECIALITY',
    NAME = 'Воинская специальность',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'MILITARY_SPECIALITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'MILITARY_STATUS',
    NAME = 'Воинский статус',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'MILITARY_STATUS');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'M_LEDGER_ACCOUNT_REGISTER',
    NAME = '-',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'M_LEDGER_ACCOUNT_REGISTER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'M_LEDGER_ACCOUNT_REGISTER_ID',
    NAME = '-',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'M_LEDGER_ACCOUNT_REGISTER_ID');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'M_LEDGER_ACCOUNT_REGISTER_SUM',
    NAME = '-',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'M_LEDGER_ACCOUNT_REGISTER_SUM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'M_PARTNER_REGISTER',
    NAME = '-',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'M_PARTNER_REGISTER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'M_PARTNER_REGISTER_ID',
    NAME = '-',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'M_PARTNER_REGISTER_ID');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'M_PARTNER_REGISTER_SUM',
    NAME = '-',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'M_PARTNER_REGISTER_SUM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'M_PRODUCT_DETAIL_REGISTER',
    NAME = '-',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'M_PRODUCT_DETAIL_REGISTER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'M_PRODUCT_DETAIL_REGISTER_ID',
    NAME = '-',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'M_PRODUCT_DETAIL_REGISTER_ID');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'M_PRODUCT_DETAIL_REGISTER_SUM',
    NAME = '-',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'M_PRODUCT_DETAIL_REGISTER_SUM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'M_PRODUCT_REGISTER',
    NAME = '-',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'M_PRODUCT_REGISTER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'M_PRODUCT_REGISTER_ID',
    NAME = '-',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'M_PRODUCT_REGISTER_ID');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'M_PRODUCT_REGISTER_SUM',
    NAME = '-',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'M_PRODUCT_REGISTER_SUM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'ORGANIZATION',
    NAME = 'Организация',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'ORGANIZATION',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'ORGANIZATION');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PARTNER',
    NAME = 'Контрагент',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PARTNER',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'Y',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PARTNER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PARTNER_ACTIVITY_TYPE_LINK',
    NAME = 'Деятельность по контрагенту',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PARTNER',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PARTNER_ACTIVITY_TYPE_LINK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PARTNER_CATEGORY',
    NAME = 'Категория контрагентов',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PARTNER',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PARTNER_CATEGORY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PARTNER_CATEGORY_LINK',
    NAME = 'Категории по контрагенту',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PARTNER',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PARTNER_CATEGORY_LINK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PARTNER_GROUP',
    NAME = 'Группа контрагентов',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PARTNER',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PARTNER_GROUP');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'PARTNER_MOVE',
    NAME = 'Движение по контрагенту',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PARTNER_MOVE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'PARTNER_REGISTER',
    NAME = 'Регистр по контрагенту',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PARTNER_REGISTER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'PARTNER_REST',
    NAME = 'Остатки по контрагенту',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PARTNER_REST');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYMENT_DOCUMENT_LINK',
    NAME = 'Документы для оплаты',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PAYMENT_DOCUMENT_LINK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PAYMENT_INCOME',
    NAME = 'Платёжное требование',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PAYMENT_INCOME');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYMENT_MISSING',
    NAME = 'Назначение платежа',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PAYMENT_MISSING');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PAYMENT_OUTCOME',
    NAME = 'Платежное поручение',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PAYMENT_OUTCOME');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYMENT_OUTCOME_TEMPLATE',
    NAME = 'Шаблон платежного поручения',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PAYMENT_OUTCOME_TEMPLATE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYMENT_TYPE',
    NAME = 'Тип оплаты',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PAYMENT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYROLL',
    NAME = 'Начисления/Удержания',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PAYROLL');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYROLL_ALGORITM',
    NAME = 'Алгоритм начислений/удержаний',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PAYROLL_ALGORITM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYROLL_ALGORITM_TYPE',
    NAME = 'Тип алгоритма начислений/удержаний',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PAYROLL_ALGORITM_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYROLL_FORM',
    NAME = 'Форма оплаты труда',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PAYROLL_FORM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYROLL_GROUP',
    NAME = 'Группа начислений/удержаний',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PAYROLL_GROUP');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYROLL_ITEM',
    NAME = 'Подчинённые начисления/удержания',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'N',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PAYROLL_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYROLL_MODE',
    NAME = 'Режим начислений/удержаний',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PAYROLL_MODE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYROLL_TYPE',
    NAME = 'Тип начислений/удержаний',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PAYROLL_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'PERIOD',
    NAME = 'Период',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PERIOD');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERIOD_TYPE',
    NAME = 'Тип периода',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PERIOD_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON',
    NAME = 'Физическое лицо',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'Y',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PERSON');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_CARD',
    NAME = 'Карточка физического лица',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PERSON_CARD');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_DOCUMENT',
    NAME = 'Документ физического лица',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PERSON_DOCUMENT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_DOCUMENT_TYPE',
    NAME = 'Тип документа физического лица',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PERSON_DOCUMENT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_EDUCATION',
    NAME = 'Образование физического лица',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PERSON_EDUCATION');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_FAMILY',
    NAME = 'Семья физического лица',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PERSON_FAMILY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_JOB',
    NAME = 'Работа физического лица',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PERSON_JOB');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_LANGUAGE',
    NAME = 'Язык общения физического лица',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PERSON_LANGUAGE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_MILITARY',
    NAME = 'Воинская информация по физическому лицу',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PERSON_MILITARY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PHONE',
    NAME = 'Телефон',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PHONE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PHONE_TYPE',
    NAME = 'Тип телефона',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PHONE_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'POSITIONS',
    NAME = 'Должность',
    ENTITY_CLASS = 'Position',
    ENTITY_PACKAGE = 'EMPLOYEE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'POSITIONS');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRICE_TYPE',
    NAME = 'Тип цены',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PRICE_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT',
    NAME = 'Карточка продукта',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PRODUCT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT_CLASS',
    NAME = 'Классификатор товаров/услуг',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PRODUCT_CLASS');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT_CLASS_GROUP',
    NAME = 'Группа класса продукта',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PRODUCT_CLASS_GROUP');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT_CLASS_TYPE',
    NAME = 'Тип класса продукта',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PRODUCT_CLASS_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'PRODUCT_DETAIL_REGISTER',
    NAME = 'Детализация регистра по товару',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PRODUCT_DETAIL_REGISTER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT_GROUP',
    NAME = 'Группа карточки продукта',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PRODUCT_GROUP');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT_INSTANCE',
    NAME = 'Экземпляр продукта',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PRODUCT_INSTANCE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT_MOVE',
    NAME = 'Движение по карточке продукта',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PRODUCT_MOVE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT_PRICE',
    NAME = 'Цена по карточке продукта',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PRODUCT_PRICE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'PRODUCT_REGISTER',
    NAME = 'Регистр товара',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PRODUCT_REGISTER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT_SECTION',
    NAME = 'Секция карточки продукта',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PRODUCT_SECTION');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT_UNIT',
    NAME = 'Единица измерения по карточке продукта',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PRODUCT_UNIT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'PROJECT',
    NAME = 'Проект',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'Y',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PROJECT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'PROJECT_CONTACT_LINK',
    NAME = 'Контакты по проекту',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'N',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PROJECT_CONTACT_LINK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PROJECT_CONTEXT',
    NAME = 'Контекст модуля <Проекты>',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PROJECT_CONTEXT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'PROJECT_EMPLOYEE_LINK',
    NAME = 'Сотрудники по проекту',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'N',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PROJECT_EMPLOYEE_LINK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PROJECT_ROLE',
    NAME = 'Роли по проекту',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PROJECT_ROLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PROJECT_STAGE',
    NAME = 'Стадия проекта',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PROJECT_STAGE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PROJECT_STAGE_GROUP',
    NAME = 'Группа стадий проекта',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PROJECT_STAGE_GROUP');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PROJECT_STAGE_LINK',
    NAME = 'Стадии по проекту',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PROJECT_STAGE_LINK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PROJECT_STATUS',
    NAME = 'Состояние проекта',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PROJECT_STATUS');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PROJECT_TYPE',
    NAME = 'Тип  проекта',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PROJECT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PURCHASE_INVOICE',
    NAME = 'Счёт-фактура на покупку',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PURCHASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PURCHASE_INVOICE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PURCHASE_INVOICE_ITEM',
    NAME = 'Строчки счёта-фактуры на покупку',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PURCHASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PURCHASE_INVOICE_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PURCHASE_ORDER',
    NAME = 'Заказ на покупку',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PURCHASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PURCHASE_ORDER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PURCHASE_ORDER_ITEM',
    NAME = 'Строчки заказа на покупку',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PURCHASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PURCHASE_ORDER_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PURCHASE_PLAN',
    NAME = 'План на покупку',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PURCHASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PURCHASE_PLAN');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PURCHASE_PLAN_ITEM',
    NAME = 'Строчки плана на покупку',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PURCHASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PURCHASE_PLAN_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PURCHASE_SERV',
    NAME = 'Акт выполненных работ (вход.)',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PURCHASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PURCHASE_SERV');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PURCHASE_SERV_ITEM',
    NAME = 'Строчки по акту выполненных работ (вход.)',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PURCHASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PURCHASE_SERV_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PURCHASE_TAX_WAYBILL',
    NAME = 'Налоговая накладная (вход.)',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PURCHASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PURCHASE_TAX_WAYBILL');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PURCHASE_TAX_WAYBILL_ITEM',
    NAME = 'Строчки налоговой накладной (вход.)',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PURCHASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PURCHASE_TAX_WAYBILL_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'REGION',
    NAME = 'Регион',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'REGION');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'RESPONSIBLE',
    NAME = 'Ответственный',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'ORGANIZATION',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'RESPONSIBLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'SALE_INVOICE',
    NAME = 'Счёт-фактура на продажу',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'SALE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SALE_INVOICE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'SALE_INVOICE_ITEM',
    NAME = 'Строчки счёта-фактуры на продажу',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'SALE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SALE_INVOICE_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'SALE_ORDER',
    NAME = 'Заказ на продажу',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'SALE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SALE_ORDER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'SALE_ORDER_ITEM',
    NAME = 'Строчки заказа на продажу',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'SALE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SALE_ORDER_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'SALE_PLAN',
    NAME = 'План на продажу',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'SALE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SALE_PLAN');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'SALE_PLAN_ITEM',
    NAME = 'Строчки плана на продажу',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'SALE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SALE_PLAN_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'SALE_SERV',
    NAME = 'Акт выполненных работ',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'SALE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SALE_SERV');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'SALE_SERV_ITEM',
    NAME = 'Строчки по акту выполненных работ',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'SALE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SALE_SERV_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'SALE_TAX_WAYBILL',
    NAME = 'Налоговая накладная',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'SALE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SALE_TAX_WAYBILL');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'SALE_TAX_WAYBILL_ITEM',
    NAME = 'Строчки налоговой накладной',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'SALE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SALE_TAX_WAYBILL_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'SECURE_OBJECT',
    NAME = 'Объекты на которые устанавливается права доступа',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SECURE_OBJECT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SHOP',
    NAME = 'Магазин',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SHOP');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SICKLIST_AVERANGE_TYPE',
    NAME = 'Тип средних для больничных',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SICKLIST_AVERANGE_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SICKLIST_TYPE',
    NAME = 'Тип больничного листа',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SICKLIST_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SICK_TYPE',
    NAME = 'Тип болезни',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SICK_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SPECIALITY',
    NAME = 'Специальность',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SPECIALITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'WAREHOUSE',
    NAME = 'Места хранения',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'ORGANIZATION',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'WAREHOUSE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'WAREHOUSE_ENTITY',
    NAME = 'Сущности относящиеся к местам хранения',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'ORGANIZATION',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'WAREHOUSE_ENTITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'WAREHOUSE_MOVE',
    NAME = 'Движение по местам хранения',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'WAREHOUSE_MOVE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'STORE',
    NAME = 'Склад',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'ORGANIZATION',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'STORE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'STREET_TYPE',
    NAME = 'Тип улицы',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'STREET_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'SYSTEM_ATTR',
    NAME = 'Атрибут (custom)',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_ATTR');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'SYSTEM_ATTR_TYPE',
    NAME = 'Тип атрибута (custom)',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_ATTR_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'SYSTEM_ATTR_TYPE_GROUP',
    NAME = 'Группа типа атрибута (custom)',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_ATTR_TYPE_GROUP');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_DAY',
    NAME = 'Системный день',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_DAY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'SYSTEM_ENTITY',
    NAME = 'Системная сущность',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_ENTITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_ENTITY_TYPE',
    NAME = 'Тип системных сущностей',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_ENTITY_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'SYSTEM_ENUMERATION',
    NAME = 'Перечисление (custom)',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_ENUMERATION');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_INFO',
    NAME = 'Системная информация',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_INFO');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_MONTH',
    NAME = 'Системный месяц',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_MONTH');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_PERMISSION',
    NAME = 'Права доступа',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'SECURITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_PERMISSION');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_PREFERENCE',
    NAME = 'Системные настройки',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_PREFERENCE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_QUARTER',
    NAME = 'Системный квартал',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'Y',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_QUARTER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'SYSTEM_REFERENCE',
    NAME = 'Справочник (custom)',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_REFERENCE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_ROLE',
    NAME = 'Роль',
    ENTITY_CLASS = 'Role',
    ENTITY_PACKAGE = 'SECURITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_ROLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_USER',
    NAME = 'Пользователь',
    ENTITY_CLASS = 'User',
    ENTITY_PACKAGE = 'SECURITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_USER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_USER_ROLE',
    NAME = 'Роль пользователя',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'SECURITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_USER_ROLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_VARIABLE',
    NAME = 'Системные переменные',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_VARIABLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'TASK',
    NAME = 'Задача',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'Y',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'TASK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TASK_CONTACT_LINK',
    NAME = 'Контакты по задаче',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'N',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'TASK_CONTACT_LINK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'TASK_CONTEXT',
    NAME = 'Контекст модуля <Задачи>',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'TASK_CONTEXT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'TASK_EMPLOYEE_LINK',
    NAME = 'Сотрудники по задаче',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'N',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'TASK_EMPLOYEE_LINK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TASK_PRIORITY',
    NAME = 'Приоритет задачи',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'TASK_PRIORITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TASK_RESULT',
    NAME = 'Результат задачи',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'TASK_RESULT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TASK_ROLE',
    NAME = 'Роль в задаче',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'TASK_ROLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TASK_STATUS',
    NAME = 'Состояние задачи',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'TASK_STATUS');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TASK_TYPE',
    NAME = 'Тип задачи',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'TASK_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TAX',
    NAME = 'Налог',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'TAX');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TAXPRINT_TYPE',
    NAME = 'Форма печати налога',
    ENTITY_CLASS = 'TaxPrintType',
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'TAXPRINT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TEMPLATE_ENTRY',
    NAME = 'Шаблон проводки',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'TEMPLATE_ENTRY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TEMPLATE_ENTRY_ITEM',
    NAME = 'Строчки шаблона проводки',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'TEMPLATE_ENTRY_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'UNIT',
    NAME = 'Единица измерения',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'UNIT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'WEB',
    NAME = 'WEB ресурс',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'WEB');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'WORKS',
    NAME = 'Завод',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'WORKS');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'WORKSHOP',
    NAME = 'Цех',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'WORKSHOP');


/* EMPTY */
INSERT INTO PARTNER_TYPE (ID, NAME) VALUES (1, 'Юридическое лицо');
INSERT INTO PARTNER_TYPE (ID, NAME) VALUES (2, 'Физическое лицо');

ALTER TABLE PARTNER
 ADD PARTNER_TYPE_ID INTEGER DEFAULT 1 NOT NULL;


update system_info set db_version = '0.1.8', app_version = '0.1.8', is_init = 'N'  where id = 1;



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

alter table BRANCH
   add constraint FK_BRANCH_BRN_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table BRANCH_DOCUMENT_TYPE
   add constraint FK_BRANCH_D_BRN_DT_DOCUMENT foreign key (DOCUMENT_TYPE_ID)
      references DOCUMENT_TYPE (ID);

alter table BRIGADE
   add constraint FK_BRIGADE_BD_BR_BRANCH foreign key (BRANCH_ID)
      references BRANCH (ID);

alter table BRIGADE
   add constraint FK_BRIGADE_BRIGADE_O_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table BUSINESSABLE
   add constraint FK_BUSINESS_BSS_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table BUSINESSABLE
   add constraint FK_BUSINESS_BS_BR_BRANCH foreign key (BRANCH_ID)
      references BRANCH (ID);

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
   add constraint FK_BUSINESS_BSRG_BR_BRANCH foreign key (BRANCH_ID)
      references BRANCH (ID);

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

alter table DEPARTMENT
   add constraint FK_DEPARTME_DP_BR_BRANCH foreign key (BRANCH_ID)
      references BRANCH (ID);

alter table DISTRICT
   add constraint FK_DISTRICT_DISTRICT__REGION foreign key (REGION_ID)
      references REGION (ID);

alter table DOCUMENT
   add constraint FK_DOCUMENT_DOC_BR_BRANCH foreign key (BRANCH_ID)
      references BRANCH (ID);

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

alter table DRUGSTORE
   add constraint FK_DRUGSTOR_DS_BR_BRANCH foreign key (BRANCH_ID)
      references BRANCH (ID);

alter table EMAIL
   add constraint FK_EMAIL_EMAIL_CON_CONTACTA foreign key (CONTACTABLE_ID)
      references CONTACTABLE (ID);

alter table EMPLOYEE
   add constraint FK_EMPLOYEE_EMP_BR_BRANCH foreign key (BRANCH_ID)
      references BRANCH (ID);

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

alter table EMPLOYEE_PAYROLL
   add constraint FK_EMPLOYEE_EMP_PRL_B_BRANCH foreign key (BRANCH_ID)
      references BRANCH (ID);

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

alter table FACTORY
   add constraint FK_FACTORY_FACTORY_O_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table FACTORY
   add constraint FK_FACTORY_FC_BR_BRANCH foreign key (BRANCH_ID)
      references BRANCH (ID);

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

alter table INVENTORY_INCOME
   add constraint FK_INVENTOR_INVI_RES_RESPONSI foreign key (RESPONSIBLE_ID)
      references RESPONSIBLE (ID);

alter table INVENTORY_INCOME
   add constraint FK_INVENTOR_INVI_WRH_WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table INVENTORY_INCOME_ITEM
   add constraint FK_INVENTOR_INVINCI_I_INVENTOR foreign key (INVENTORY_INCOME_ID)
      references INVENTORY_INCOME (ID);

alter table INVENTORY_INCOME_ITEM
   add constraint FK_INVENTOR_INVINCI_P_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table INVENTORY_INCOME_ITEM
   add constraint FK_INVENTOR_INVINCI_T_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table INVENTORY_INCOME_ITEM
   add constraint FK_INVENTOR_INVINCI_U_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table INVENTORY_MOVE
   add constraint FK_INVENTOR_INVM_INCO_RESPONSI foreign key (INCOME_RESPONSIBLE_ID)
      references RESPONSIBLE (ID);

alter table INVENTORY_MOVE
   add constraint FK_INVENTOR_INVM_IN_W_WAREHOUS foreign key (INCOME_WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table INVENTORY_MOVE
   add constraint FK_INVENTOR_INVM_OUTC_RESPONSI foreign key (OUTCOME_RESPONSIBLE_ID)
      references RESPONSIBLE (ID);

alter table INVENTORY_MOVE
   add constraint FK_INVENTOR_INVM_OUT__WAREHOUS foreign key (OUTCOME_WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table INVENTORY_MOVE_ITEM
   add constraint FK_INVENTOR_INVMI_PRO_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table INVENTORY_MOVE_ITEM
   add constraint FK_INVENTOR_INVMI_TAX_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table INVENTORY_MOVE_ITEM
   add constraint FK_INVENTOR_INVMI_UN_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table INVENTORY_MOVE_ITEM
   add constraint FK_INVENTOR_INVM_ITEM_INVENTOR foreign key (INVENTORY_MOVE_ID)
      references INVENTORY_MOVE (ID);

alter table INVENTORY_OUTCOME
   add constraint FK_INVENTOR_INVO_RES_RESPONSI foreign key (RESPONSIBLE_ID)
      references RESPONSIBLE (ID);

alter table INVENTORY_OUTCOME
   add constraint FK_INVENTOR_INVO_WRH_WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table INVENTORY_OUTCOME_ITEM
   add constraint FK_INVENTOR_INVOUTI_I_INVENTOR foreign key (INVENTORY_OUTCOME_ID)
      references INVENTORY_OUTCOME (ID);

alter table INVENTORY_OUTCOME_ITEM
   add constraint FK_INVENTOR_INVOUTI_P_PRODUCT_ foreign key (PRODUCT_INSTANCE_ID)
      references PRODUCT_INSTANCE (ID);

alter table INVENTORY_OUTCOME_ITEM
   add constraint FK_INVENTOR_INVOUTI_T_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table INVENTORY_OUTCOME_ITEM
   add constraint FK_INVENTOR_INVOUTI_U_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table INVENTORY_OUTCOME_ITEM
   add constraint FK_INVENTOR_INVOUTO_P_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table INVENTORY_REST
   add constraint FK_INVENTOR_INVR_RE_RESPONSI foreign key (RESPONSIBLE_ID)
      references RESPONSIBLE (ID);

alter table INVENTORY_REST
   add constraint FK_INVENTOR_INVR_WRH_WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table INVENTORY_REST_ITEM
   add constraint FK_INVENTOR_INVRI_TAX_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table INVENTORY_REST_ITEM
   add constraint FK_INVENTOR_INVRI_UN_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table INVENTORY_REST_ITEM
   add constraint FK_INVENTOR_INVR_ITEM_INVENTOR foreign key (INVENTORY_REST_ID)
      references INVENTORY_REST (ID);

alter table INVENTORY_REST_ITEM
   add constraint FK_INVENTOR_INVR_PROD_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table INVENTORY_WRITEOFF
   add constraint FK_INVENTOR_INVW_RE_RESPONSI foreign key (RESPONSIBLE_ID)
      references RESPONSIBLE (ID);

alter table INVENTORY_WRITEOFF
   add constraint FK_INVENTOR_INVW_WRH_WAREHOUS foreign key (WAREHOUSE_ID)
      references WAREHOUSE (ID);

alter table INVENTORY_WRITEOFF_ITEM
   add constraint FK_INVENTOR_INVWI_TAX_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table INVENTORY_WRITEOFF_ITEM
   add constraint FK_INVENTOR_INVWI_UN_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table INVENTORY_WRITEOFF_ITEM
   add constraint FK_INVENTOR_INVW_ITEM_INVENTOR foreign key (INVENTORY_WRITEOFF_ID)
      references INVENTORY_WRITEOFF (ID);

alter table INVENTORY_WRITEOFF_ITEM
   add constraint FK_INVENTOR_INVW_PROD_PRODUCT foreign key (PRODUCT_ID)
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

alter table PARTNER_REPRESENTATIVE
   add constraint FK_PARTNER__PREP_PRT_PARTNER foreign key (PARTNER_ID)
      references PARTNER (ID);

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
   add constraint FK_PROJECT_PRJ_BR_BRANCH foreign key (BRANCH_ID)
      references BRANCH (ID);

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

alter table PURCHASE_INVOICE
   add constraint FK_PURCHASE_PCH_INV_P_PRICE_TY foreign key (PRICE_TYPE_ID)
      references PRICE_TYPE (ID);

alter table PURCHASE_INVOICE_ITEM
   add constraint FK_PURCHASE_PINVI_PRO_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table PURCHASE_INVOICE_ITEM
   add constraint FK_PURCHASE_PINVI_UNI_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table PURCHASE_INVOICE_ITEM
   add constraint FK_PURCHASE_PINV_ITEM_PURCHASE foreign key (PURCHASE_INVOICE_ID)
      references PURCHASE_INVOICE (ID);

alter table PURCHASE_INVOICE_ITEM
   add constraint FK_PURCHASE_PINV_TAX_TAX foreign key (TAX_ID)
      references TAX (ID);

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

alter table PURCHASE_SERV_ITEM
   add constraint FK_PURCHASE_PSERVI_PR_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table PURCHASE_SERV_ITEM
   add constraint FK_PURCHASE_PSERVI_PS_PURCHASE foreign key (PURCHASE_SERV_ID)
      references PURCHASE_SERV (ID);

alter table PURCHASE_SERV_ITEM
   add constraint FK_PURCHASE_PSERVI_TA_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table PURCHASE_SERV_ITEM
   add constraint FK_PURCHASE_PSERVI_UN_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table PURCHASE_TAX_WAYBILL_ITEM
   add constraint FK_PURCHASE_PTWI_PROD_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table PURCHASE_TAX_WAYBILL_ITEM
   add constraint FK_PURCHASE_PTWI_PTW_PURCHASE foreign key (PURCHASE_TAX_WAYBILL_ID)
      references PURCHASE_TAX_WAYBILL (ID);

alter table PURCHASE_TAX_WAYBILL_ITEM
   add constraint FK_PURCHASE_PTWI_TAX_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table PURCHASE_TAX_WAYBILL_ITEM
   add constraint FK_PURCHASE_PTWI_UNIT_UNIT foreign key (UNIT_ID)
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

alter table RESPONSIBLE
   add constraint FK_RESPONSI_RES_BR_BRANCH foreign key (BRANCH_ID)
      references BRANCH (ID);

alter table SALE_INVOICE
   add constraint FK_SALE_INV_SLE_INV_P_PRICE_TY foreign key (PRICE_TYPE_ID)
      references PRICE_TYPE (ID);

alter table SALE_INVOICE_ITEM
   add constraint FK_SALE_INV_SINVI_PRO_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table SALE_INVOICE_ITEM
   add constraint FK_SALE_INV_SINVI_UNI_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table SALE_INVOICE_ITEM
   add constraint FK_SALE_INV_SINV_ITEM_SALE_INV foreign key (SALE_INVOICE_ID)
      references SALE_INVOICE (ID);

alter table SALE_INVOICE_ITEM
   add constraint FK_SALE_INV_SINV_TAX_TAX foreign key (TAX_ID)
      references TAX (ID);

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

alter table SALE_SERV_ITEM
   add constraint FK_SALE_SER_SSERVI_SS_SALE_SER foreign key (SALE_SERV_ID)
      references SALE_SERV (ID);

alter table SALE_SERV_ITEM
   add constraint FK_SALE_SER_SSERVI_TA_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table SALE_SERV_ITEM
   add constraint FK_SALE_SER_SSERVI_UN_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table SALE_SERV_ITEM
   add constraint FK_SALE_SER_SSERV_PRO_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table SALE_TAX_WAYBILL_ITEM
   add constraint FK_SALE_TAX_STWI_PROD_PRODUCT foreign key (PRODUCT_ID)
      references PRODUCT (ID);

alter table SALE_TAX_WAYBILL_ITEM
   add constraint FK_SALE_TAX_STWI_STW_SALE_TAX foreign key (SALE_TAX_WAYBILL_ID)
      references SALE_TAX_WAYBILL (ID);

alter table SALE_TAX_WAYBILL_ITEM
   add constraint FK_SALE_TAX_STWI_TAX_TAX foreign key (TAX_ID)
      references TAX (ID);

alter table SALE_TAX_WAYBILL_ITEM
   add constraint FK_SALE_TAX_STWI_UNIT_UNIT foreign key (UNIT_ID)
      references UNIT (ID);

alter table SECURE_OBJECT
   add constraint FK_SECURE_O_SE_ENTITY_SYSTEM_E foreign key (ENTITY_ID)
      references SYSTEM_ENTITY (ID);

alter table SHOP
   add constraint FK_SHOP_SHOP_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table SHOP
   add constraint FK_SHOP_SH_BR_BRANCH foreign key (BRANCH_ID)
      references BRANCH (ID);

alter table STORE
   add constraint FK_STORE_STORE_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table STORE
   add constraint FK_STORE_ST_BR_BRANCH foreign key (BRANCH_ID)
      references BRANCH (ID);

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
   add constraint FK_SYSTEM_I_SI_BRANCH_BRANCH foreign key (BRANCH_ID)
      references BRANCH (ID);

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

alter table SYSTEM_ROLE_UI
   add constraint FK_SYSTEM_R_SRU_SR_SYSTEM_R foreign key (ROLE_ID)
      references SYSTEM_ROLE (ID);

alter table SYSTEM_USER
   add constraint FK_SYSTEM_U_USER_ENTI_SYSTEM_E foreign key (ENTITY_ID)
      references SYSTEM_ENTITY (ID);

alter table SYSTEM_USER_ORG
   add constraint FK_SYSTEM_U_SUO_ORG_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table SYSTEM_USER_ORG
   add constraint FK_SYSTEM_U_SUO_U_SYSTEM_U foreign key (USER_ID)
      references SYSTEM_USER (ID);

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
   add constraint FK_TASK_TSK_BR_BRANCH foreign key (BRANCH_ID)
      references BRANCH (ID);

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

alter table WORKS
   add constraint FK_WORKS_WS_BR_BRANCH foreign key (BRANCH_ID)
      references BRANCH (ID);

alter table WORKSHOP
   add constraint FK_WORKSHOP_WORKSHOPS_ORGANIZA foreign key (ORGANIZATION_ID)
      references ORGANIZATION (ID);

alter table WORKSHOP
   add constraint FK_WORKSHOP_WP_BR_BRANCH foreign key (BRANCH_ID)
      references BRANCH (ID);




/* CREATE CUST CONSTRAINTS */ 


CREATE UNIQUE INDEX BUSINESSABLE_OWNER ON BUSINESSABLE (OWNER_ID);
CREATE UNIQUE INDEX CONTACTABLE_OWNER ON CONTACTABLE (OWNER_ID);

CREATE INDEX BUSINESSABLE_ENTITY_ID ON BUSINESSABLE (ENTITY_ID);
CREATE INDEX SYSTEM_ENTITY_CODE ON SYSTEM_ENTITY (CODE);

CREATE UNIQUE INDEX USER_ROLE_UNIQUE ON SYSTEM_USER_ROLE (USER_ID, ROLE_ID);
CREATE UNIQUE INDEX ROLE_UI_UNIQUE ON SYSTEM_ROLE_UI (ROLE_ID, UI_ID);
CREATE UNIQUE INDEX USER_ORG_UNIQUE ON SYSTEM_USER_ORG (USER_ID, ORGANIZATION_ID);

CREATE INDEX DOC_TYPE_SECTION ON DOCUMENT_TYPE (DOCUMENT_SECTION);
CREATE INDEX DOC_TYPE_CATEGORY ON DOCUMENT_TYPE (DOCUMENT_CATEGORY);
CREATE INDEX FIN_DOC_TYPE_MOVE ON FINANCE_DOCUMENT_TYPE (MOVE_TYPE);

/* ERROR BY UPDATE */
/* CREATE UNIQUE INDEX PARTNER_MOVE_OWNER ON PARTNER_MOVE (OWNER_ID, PARTNER_ID); */


ALTER TABLE GOODS ADD CONSTRAINT FK_GOODS_PRODUCT FOREIGN KEY (ID) REFERENCES PRODUCT (ID);

ALTER TABLE FINANCE_DOCUMENT ADD CONSTRAINT FK_DOCUMENT_FIN_DOCUMENT FOREIGN KEY (ID) REFERENCES DOCUMENT (ID);
ALTER TABLE CONTRACT ADD CONSTRAINT FK_CONTRACT_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);

ALTER TABLE INVENTORY_REST ADD CONSTRAINT FK_INVENTORY_REST_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE INVENTORY_MOVE ADD CONSTRAINT FK_INVENTORY_MOVE_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE INVENTORY_WRITEOFF ADD CONSTRAINT FK_INVENTORY_WRITEOFF_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE INVENTORY_INCOME ADD CONSTRAINT FK_INVENTORY_INCOME_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE INVENTORY_OUTCOME ADD CONSTRAINT FK_INVENTORY_OUTCOME_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);


ALTER TABLE GOODS_INCOME ADD CONSTRAINT FK_GOODS_INCOME_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE GOODS_OUTCOME ADD CONSTRAINT FK_GOODS_OUTCOME_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);

ALTER TABLE PAYMENT_INCOME ADD CONSTRAINT FK_PAYMENT_INCOME_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE PAYMENT_OUTCOME ADD CONSTRAINT FK_PAYMENT_OUTCOME_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);

ALTER TABLE SALE_INVOICE ADD CONSTRAINT FK_SALE_INV_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE SALE_ORDER ADD CONSTRAINT FK_SALE_ORDER_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE SALE_PLAN ADD CONSTRAINT FK_SALE_PLAN_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE SALE_SERV ADD CONSTRAINT FK_SALE_SERV_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE SALE_TAX_WAYBILL ADD CONSTRAINT FK_SALE_TXWB_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);

ALTER TABLE PURCHASE_INVOICE ADD CONSTRAINT FK_PURCHASE_INV_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE PURCHASE_ORDER ADD CONSTRAINT FK_PURCHASE_ORDER_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE PURCHASE_PLAN ADD CONSTRAINT FK_PURCHASE_PLAN_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE PURCHASE_SERV ADD CONSTRAINT FK_PURCHASE_SERV_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE PURCHASE_TAX_WAYBILL ADD CONSTRAINT FK_PURCHASE_TXWB_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);

ALTER TABLE CASH_INCOME ADD CONSTRAINT FK_CASH_INCOME_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);
ALTER TABLE CASH_OUTCOME ADD CONSTRAINT FK_CASH_OUTCOME_FIN_DOC FOREIGN KEY (ID) REFERENCES FINANCE_DOCUMENT (ID);


ALTER TABLE EMPLOYEE_RECEPTION ADD CONSTRAINT FK_EMPLOYEE_RECEPTION_DOC FOREIGN KEY (ID) REFERENCES DOCUMENT (ID);
ALTER TABLE EMPLOYEE_DISCHARGE ADD CONSTRAINT FK_EMPLOYEE_DISCHARGE_DOC FOREIGN KEY (ID) REFERENCES DOCUMENT (ID);
ALTER TABLE EMPLOYEE_VACATION ADD CONSTRAINT FK_EMPLOYEE_VACATION_DOC FOREIGN KEY (ID) REFERENCES DOCUMENT (ID);
ALTER TABLE EMPLOYEE_SICKLIST ADD CONSTRAINT FK_EMPLOYEE_SICKLIST_DOC FOREIGN KEY (ID) REFERENCES DOCUMENT (ID);


/* ALTER TABLE DOCUMENT ADD COLUMN PARTNER_ID INTEGER; */
/* ALTER TABLE DOCUMENT ADD CONSTRAINT FK_DOCUMENT_PARTNER FOREIGN KEY (PARTNER_ID) REFERENCES PARTNER (ID); */


ALTER TABLE PARTNER ADD CONSTRAINT FK_PARTNER_PARTNER_TYPE FOREIGN KEY (PARTNER_TYPE_ID) REFERENCES PARTNER_TYPE (ID);




/*==============================================================*/
/* MySQL                                                        */
/* http://www.mysql.com                                         */
/*==============================================================*/

CREATE VIEW V_ORGANIZATION (
  ID,
  ORGANIZATION_NAME,
  ORGANIZATION_CODE,
  ORGANIZATION_NEC
) AS
SELECT
  O.ID,
  P.NAME,
  P.CODE,
  P.NEC
 FROM ORGANIZATION O 
 INNER JOIN PARTNER P ON P.ID = O.ID;

CREATE VIEW V_SYSTEM_INFO (
 PERIOD_ID,
 ORGANIZATION_ID,
 CURRENCY_ID,
 UNIT_ID,
 PERIOD_NAME,
 PERIOD_START_DATE,
 PERIOD_END_DATE,
 ORGANIZATION_NAME,
 CURRENCY_NAME,
 UNIT_NAME
) AS
SELECT 
 I.PERIOD_ID,
 I.ORGANIZATION_ID,
 I.CURRENCY_ID,
 I.UNIT_ID,
 P.NAME,
 P.START_DATE,
 P.END_DATE,
 O.ORGANIZATION_NAME,
 C.NAME,
 U.NAME
FROM SYSTEM_INFO I
 INNER JOIN PERIOD P ON P.ID = I.PERIOD_ID
 INNER JOIN V_ORGANIZATION O ON O.ID = I.ORGANIZATION_ID
 INNER JOIN CURRENCY C ON C.ID = I.CURRENCY_ID
 INNER JOIN UNIT U ON U.ID = I.UNIT_ID;

CREATE VIEW V_SYSTEM_USER (
 ID,
 USRNAME,
 PASSWD,
 OWNER_ID,
 ENTITY_ID,
 NAME,
 ORGANIZATION_ID,
 REGISTRATION_DATE,
 ORGANIZATION_NAME
) AS
SELECT U.ID, U.USRNAME, U.PASSWD, U.OWNER_ID, U.ENTITY_ID,
 P.LAST_NAME || ' ' || P.FIRST_NAME || ' ' || P.MIDDLE_NAME AS NAME,
 O.ID AS ORGANIZATION_ID, U.REGISTRATION_DATE, O.ORGANIZATION_NAME
 FROM SYSTEM_USER U
 INNER JOIN SYSTEM_ENTITY E ON E.ID = U.ENTITY_ID
 INNER JOIN EMPLOYEE EE ON EE.ID = U.OWNER_ID
 INNER JOIN PERSON P ON P.ID = EE.PERSON_ID
 INNER JOIN V_ORGANIZATION O ON O.ID = EE.ORGANIZATION_ID
 WHERE E.CODE = 'EMPLOYEE';



CREATE VIEW V_SYSTEM_PERMISSION (
 ID,
 SECURE_ENTITY_ID,
 SYSTEM_PERMISSION_ID,
 ENTITY_ID,
 CODE,
 NAME,
 OBJECT_TYPE,
 ROLE_ID,
 IS_READ,
 IS_WRITE,
 IS_EXEC
) AS
SELECT
 O.ID AS ID,
 P.SECURE_ENTITY_ID,
 P.ID AS SYSTEM_PERMISSION_ID,
 O.ENTITY_ID,
 O.CODE,
 O.NAME,
 O.OBJECT_TYPE,
 P.ROLE_ID,
 P.IS_READ,
 P.IS_WRITE,
 P.IS_EXEC
FROM SECURE_OBJECT O
LEFT JOIN SYSTEM_PERMISSION P ON O.ID = P.SECURE_ENTITY_ID;


CREATE VIEW V_EMPLOYEE (
    ID,
    ORGANIZATION_ID,
    PERSON_ID,
    FIRST_NAME,
    LAST_NAME,
    MIDDLE_NAME,
    NAME
) AS
SELECT 
 E.ID,
 E.ORGANIZATION_ID,
 E.PERSON_ID,
 P.FIRST_NAME,
 P.LAST_NAME,
 P.MIDDLE_NAME,
 P.NAME
 FROM EMPLOYEE E
 INNER JOIN PERSON P ON P.ID = E.PERSON_ID;
 


CREATE VIEW V_WAREHOUSE (
  ID,
  OWNER_ID,
  ENTITY_ID,
  NAME
) AS
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, B.NAME
 FROM BUSINESSABLE B
 INNER JOIN WAREHOUSE S ON S.ID = B.OWNER_ID;

 




CREATE VIEW V_WAREHOUSE_UNION (
  ID, 
  OWNER_ID, 
  ENTITY_ID, 
  ENTITY_CODE, 
  ENTITY_NAME, 
  ORGANIZATION_ID, 
  PARENT_ID, 
  NAME
) AS 
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, O.ORGANIZATION_ID, O.PARENT_ID, O.NAME
 FROM BUSINESSABLE B
 INNER JOIN STORE O ON O.ID = B.OWNER_ID
 INNER JOIN SYSTEM_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'STORE'
UNION ALL
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, O.ORGANIZATION_ID, O.PARENT_ID, O.NAME
 FROM BUSINESSABLE B
 INNER JOIN DRUGSTORE O ON O.ID = B.OWNER_ID
 INNER JOIN SYSTEM_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'DRUGSTORE'
UNION ALL
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, O.ORGANIZATION_ID, O.PARENT_ID, O.NAME
 FROM BUSINESSABLE B
 INNER JOIN SHOP O ON O.ID = B.OWNER_ID
 INNER JOIN SYSTEM_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'SHOP'
UNION ALL
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, O.ORGANIZATION_ID, O.PARENT_ID, O.NAME
 FROM BUSINESSABLE B
 INNER JOIN FACTORY O ON O.ID = B.OWNER_ID
 INNER JOIN SYSTEM_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'FACTORY'
UNION ALL
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, O.ORGANIZATION_ID, O.PARENT_ID, O.NAME
 FROM BUSINESSABLE B
 INNER JOIN WORKS O ON O.ID = B.OWNER_ID
 INNER JOIN SYSTEM_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'WORKS';



CREATE VIEW V_RESPONSIBLE (
 ID,
 ORGANIZATION_ID,
 EMPLOYEE_ID,
 WAREHOUSE_ID,
 PERSON_ID,
 RESPONSIBLE_NAME,
 WAREHOUSE_NAME
) AS
SELECT 
 RE.ID, 
 RE.ORGANIZATION_ID, 
 RE.EMPLOYEE_ID,
 RE.WAREHOUSE_ID,
 P.ID AS PERSON_ID,
 P.NAME,
 S.NAME
 FROM RESPONSIBLE RE 
 INNER JOIN EMPLOYEE E ON E.ID = RE.EMPLOYEE_ID
 INNER JOIN PERSON P ON P.ID = E.PERSON_ID
 LEFT JOIN V_WAREHOUSE S ON S.ID = RE.WAREHOUSE_ID;


CREATE VIEW V_WAREHOUSE_MOVE (
  ID,
  DOCUMENT_ID,
  WAREHOUSE_ID,
  WAREHOUSE_NAME,
  MOVE_TYPE
) AS
SELECT 
  M.ID,
  M.OWNER_ID AS DOCUMENT_ID,
  M.WAREHOUSE_ID,
  S.NAME AS WAREHOUSE_NAME,
  M.MOVE_TYPE
 FROM WAREHOUSE_MOVE M
 INNER JOIN V_WAREHOUSE S ON S.ID = M.WAREHOUSE_ID;

CREATE VIEW V_PRODUCT (
 ID,
 PRODUCT_CODE,
 PRODUCT_NAME,
 PRODUCT_CLASS_ID,
 PRODUCT_CLASS_CODE,
 PRODUCT_GROUP_ID,
 BAR_CODE,
 ORGANIZATION_ID,
 CURRENCY_ID,
 CURRENCY_RATE,
 LEDGER_ACCOUNT_ID,
 MANUFACTURER_ID,
 SUPPLIER_ID,
 START_DATE,
 END_DATE,
 UNIT_ID,
 PRICE,
 COST_PRICE, 
 LIST_PRICE,
 WHOLESALE_PRICE,
 SMALL_WHOLESALE_PRICE,
 RETAIL_PRICE,
 CURRENCY_PRICE,
 CURRENCY_SMALL_WHOLESALE_PRICE,
 CURRENCY_WHOLESALE_PRICE,
 CURRENCY_RETAIL_PRICE,
 TAX_PERCENT,
 ADDPRICE_PERCENT,
 MIN_QUANTITY,
 AVAILABLE_QUANTITY,
 RESERVED_QUANTITY,
 EXPECTED_QUANTITY,
 WARRANTY_PERIOD_UNIT_ID,
 WARRANTY_PERIOD,
 DIMENSION_UNIT_ID,
 DIM_LENGTH,
 DIM_WIDTH,
 DIM_HEIGHT,
 WEIGHT_UNIT_ID,
 WEIGHT,
 PRODUCT_IMAGE,
 NOTE

) AS
SELECT 
 P.ID,    
 P.CODE,
 C.NAME,
 P.PRODUCT_CLASS_ID,
 C.CODE,
 P.PRODUCT_GROUP_ID,
 P.BAR_CODE,
 P.ORGANIZATION_ID,
 P.CURRENCY_ID,
 P.CURRENCY_RATE,
 P.LEDGER_ACCOUNT_ID,
 P.MANUFACTURER_ID,
 P.SUPPLIER_ID,
 P.START_DATE,
 P.END_DATE,
 P.UNIT_ID,
 P.PRICE,
 P.PRICE,
 P.LIST_PRICE,
 P.WHOLESALE_PRICE,
 P.SMALL_WHOLESALE_PRICE,
 P.RETAIL_PRICE,
 P.CURRENCY_PRICE,
 P.CURRENCY_SMALL_WHOLESALE_PRICE,
 P.CURRENCY_WHOLESALE_PRICE,
 P.CURRENCY_RETAIL_PRICE,
 P.TAX_PERCENT,
 P.ADDPRICE_PERCENT,
 P.MIN_QUANTITY,
 P.AVAILABLE_QUANTITY,
 P.RESERVED_QUANTITY,
 P.EXPECTED_QUANTITY,
 P.WARRANTY_PERIOD_UNIT_ID,
 P.WARRANTY_PERIOD,
 P.DIMENSION_UNIT_ID,
 P.DIM_LENGTH,
 P.DIM_WIDTH,
 P.DIM_HEIGHT,
 P.WEIGHT_UNIT_ID,
 P.WEIGHT,
 P.PRODUCT_IMAGE,
 P.NOTE

FROM PRODUCT P
INNER JOIN PRODUCT_CLASS C ON C.ID = P.PRODUCT_CLASS_ID;



CREATE VIEW V_PRODUCT_MOVE (
  ID,
  DOCUMENT_ID,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  UNIT_ID,
  ITEM_UNIT_ID,
  UNIT_RATE,
  UNIT_NAME,
  PRODUCT_PRICE,
  PRICE,
  PRICE_WITH_TAX,
  TAX_PRICE,
  QUANTITY,
  AMOUNT,
  AMOUNT_WITH_TAX,
  TAX_AMOUNT,
  ITEM_PRICE,
  ITEM_ACCOUNT_PRICE,
  ITEM_AMOUNT,
  ACCOUNT_QUANTITY,
  ACCOUNT_PRICE,
  ACCOUNT_PRICE_WITH_TAX
) AS
SELECT 
  I.ID,
  I.OWNER_ID,
  I.PRODUCT_ID,
  P.PRODUCT_CODE,
  P.PRODUCT_NAME,
  P.UNIT_ID,
  I.UNIT_ID,
  I.UNIT_RATE,
  U.NAME,
  P.PRICE,
  I.PRICE,
  I.PRICE_WITH_TAX,
  I.TAX_PRICE,
  I.QUANTITY,
  I.AMOUNT,
  I.AMOUNT_WITH_TAX,
  I.TAX_AMOUNT,
  I.PRICE_WITH_TAX,
  I.ACCOUNT_PRICE_WITH_TAX,
  I.AMOUNT_WITH_TAX,
  I.ACCOUNT_QUANTITY,
  I.ACCOUNT_PRICE,
  I.ACCOUNT_PRICE_WITH_TAX
 FROM PRODUCT_MOVE I
 INNER JOIN V_PRODUCT P ON P.ID = I.PRODUCT_ID
 INNER JOIN UNIT U ON U.ID = I.UNIT_ID;
CREATE VIEW V_GOODS (
 ID,
 PRODUCT_CODE,
 PRODUCT_NAME,
 PRODUCT_CLASS_ID,
 PRODUCT_GROUP_ID,
 CURRENCY_ID,
 ORGANIZATION_ID,
 UNIT_ID,
 PRICE,
 START_DATE,
 END_DATE,
 TAX_PERCENT,
 ADDPRICE_PERCENT,
 MIN_QUANTITY,
 CURRENCY_RATE,
 COUNTRY_ID,
 GOODS_TYPE_ID,
 GOODS_TYPE_NAME,
 PRODUCT_CLASS_CODE
) AS
SELECT 
 P.ID,    
 P.PRODUCT_CODE,
 P.PRODUCT_NAME,
 P.PRODUCT_CLASS_ID,
 P.PRODUCT_GROUP_ID,
 P.CURRENCY_ID,
 P.ORGANIZATION_ID,
 P.UNIT_ID,
 P.PRICE,
 P.START_DATE,
 P.END_DATE,
 P.TAX_PERCENT,
 P.ADDPRICE_PERCENT,
 P.MIN_QUANTITY,
 P.CURRENCY_RATE,
 G.COUNTRY_ID,
 G.GOODS_TYPE_ID,
 T.NAME,
 P.PRODUCT_CLASS_CODE
 FROM GOODS G
 INNER JOIN V_PRODUCT P ON P.ID = G.ID
 INNER JOIN GOODS_TYPE T ON T.ID = G.GOODS_TYPE_ID;






CREATE VIEW V_ASSET (
 ID,	
 PRODUCT_CODE,
 PRODUCT_NAME,
 PRODUCT_CLASS_ID,
 PRODUCT_GROUP_ID,
 CURRENCY_ID,
 ORGANIZATION_ID,
 UNIT_ID,
 PRICE,
 START_DATE,
 END_DATE,
 TAX_PERCENT,
 ADDPRICE_PERCENT,
 MIN_QUANTITY,
 CURRENCY_RATE
) AS
SELECT 
 P.ID,	
 P.PRODUCT_CODE,
 P.PRODUCT_NAME,
 P.PRODUCT_CLASS_ID,
 P.PRODUCT_GROUP_ID,
 P.CURRENCY_ID,
 P.ORGANIZATION_ID,
 P.UNIT_ID,
 P.PRICE,
 P.START_DATE,
 P.END_DATE,
 P.TAX_PERCENT,
 P.ADDPRICE_PERCENT,
 P.MIN_QUANTITY,
 P.CURRENCY_RATE
 FROM ASSET A
 INNER JOIN V_PRODUCT P ON P.ID = A.ID;


CREATE VIEW V_INTANGIBLE (
 ID,	
 PRODUCT_CODE,
 PRODUCT_NAME,
 PRODUCT_CLASS_ID,
 PRODUCT_GROUP_ID,
 CURRENCY_ID,
 ORGANIZATION_ID,
 UNIT_ID,
 PRICE,
 START_DATE,
 END_DATE,
 TAX_PERCENT,
 ADDPRICE_PERCENT,
 MIN_QUANTITY,
 CURRENCY_RATE
) AS
SELECT 
 P.ID,	
 P.PRODUCT_CODE,
 P.PRODUCT_NAME,
 P.PRODUCT_CLASS_ID,
 P.PRODUCT_GROUP_ID,
 P.CURRENCY_ID,
 P.ORGANIZATION_ID,
 P.UNIT_ID,
 P.PRICE,
 P.START_DATE,
 P.END_DATE,
 P.TAX_PERCENT,
 P.ADDPRICE_PERCENT,
 P.MIN_QUANTITY,
 P.CURRENCY_RATE
 FROM INTANGIBLE I
 INNER JOIN V_PRODUCT P ON P.ID = I.ID;


/*                                     */
/*   MySQL implementations             */
/*                                     */
/*   Use functions YEAR() and MONTH(): */
/*                                     */
/*   YEAR(DOCUMENT_DATE)               */
/*   MONTH(DOCUMENT_DATE)              */
/*                                     */


CREATE VIEW V_DOCUMENT (
  ID,
  ORGANIZATION_ID,
  ORGANIZATION_NAME,
  ORGANIZATION_CODE,
  ORGANIZATION_NEC,
  DOCUMENT_TYPE_ID,
  DOCUMENT_TYPE_CODE,
  DOCUMENT_TYPE_NAME,
  PERIOD_ID,
  DOCUMENT_CODE,
  DOCUMENT_DATE,
  DOCUMENT_YEAR,
  DOCUMENT_MONTH,
  PARTNER_ID,
  USER_ID,
  CONTRACT_ID,
  REASON_DOCUMENT_ID,
  REASON,
  NOTE,
  USRNAME
) AS
SELECT
  D.ID,
  D.ORGANIZATION_ID,
  O.ORGANIZATION_NAME,
  O.ORGANIZATION_CODE,
  O.ORGANIZATION_NEC,
  D.DOCUMENT_TYPE_ID,
  E.CODE AS DOCUMENT_TYPE_CODE,
  E.NAME AS DOCUMENT_TYPE_NAME,
  D.PERIOD_ID,
  D.CODE,
  D.DOCUMENT_DATE,
  YEAR(D.DOCUMENT_DATE),
  MONTH(D.DOCUMENT_DATE),
  D.PARTNER_ID,
  D.USER_ID,
  D.CONTRACT_ID,
  D.REASON_DOCUMENT_ID,
  D.REASON,
  D.NOTE,
  U.USRNAME
 FROM DOCUMENT D
 INNER JOIN V_ORGANIZATION O ON O.ID = D.ORGANIZATION_ID
 INNER JOIN DOCUMENT_TYPE DT ON DT.ID = D.DOCUMENT_TYPE_ID
 INNER JOIN SYSTEM_ENTITY E ON E.ID = DT.ENTITY_ID
 LEFT JOIN SYSTEM_USER U ON U.ID = D.USER_ID;




CREATE VIEW V_FINANCE_DOCUMENT (
  ID, 
  ORGANIZATION_ID,
  ORGANIZATION_NAME,
  ORGANIZATION_CODE,
  ORGANIZATION_NEC,
  DOCUMENT_TYPE_ID, 
  DOCUMENT_TYPE_CODE,
  DOCUMENT_TYPE_NAME,
  PERIOD_ID,
  DOCUMENT_CODE, 
  DOCUMENT_DATE,
  DOCUMENT_YEAR,
  DOCUMENT_MONTH,
  PARTNER_ID,
  USER_ID,
  CONTRACT_ID,
  REASON_DOCUMENT_ID,
  REASON,
  NOTE,
  USRNAME,
  CURRENCY_ID, 
  CURRENCY_RATE,
  CURRENCY_RATE_DATE,
  CURRENCY_CODE,
  CURRENCY_CHAR_CODE,
  CURRENCY_NAME,
  AMOUNT,
  AMOUNT_WITH_TAX,
  TAX_AMOUNT,
  CURRENCY_AMOUNT,
  CURRENCY_AMOUNT_WITH_TAX,
  CURRENCY_TAX_AMOUNT,
  TOTAL,
  TOTAL_WITH_TAX,
  TAX_TOTAL,
  CURRENCY_TOTAL,
  CURRENCY_TOTAL_WITH_TAX,
  CURRENCY_TAX_TOTAL,
  DOCUMENT_AMOUNT,
  DOCUMENT_TOTAL,
  CURRENCY_DOCUMENT_AMOUNT,
  CURRENCY_DOCUMENT_TOTAL,
  IS_OPERATION,
  IS_ACCOUNT_ITEMS
) AS
SELECT 
  D.ID, 
  D.ORGANIZATION_ID,
  D.ORGANIZATION_NAME,
  D.ORGANIZATION_CODE,
  D.ORGANIZATION_NEC,
  D.DOCUMENT_TYPE_ID, 
  D.DOCUMENT_TYPE_CODE,
  D.DOCUMENT_TYPE_NAME,
  D.PERIOD_ID,
  D.DOCUMENT_CODE, 
  D.DOCUMENT_DATE,
  D.DOCUMENT_YEAR,
  D.DOCUMENT_MONTH,
  D.PARTNER_ID,  
  D.USER_ID,
  D.CONTRACT_ID,
  D.REASON_DOCUMENT_ID,
  D.REASON,
  D.NOTE,
  D.USRNAME,
  FD.CURRENCY_ID, 
  FD.CURRENCY_RATE,
  FD.CURRENCY_RATE_DATE,
  CR.CODE AS CURRENCY_CODE,
  CR.CHAR_CODE AS CURRENCY_CHAR_CODE,
  CR.NAME AS CURRENCY_NAME,
  FD.AMOUNT,
  FD.AMOUNT_WITH_TAX,
  FD.TAX_AMOUNT,
  FD.CURRENCY_AMOUNT,
  FD.CURRENCY_AMOUNT_WITH_TAX,
  FD.CURRENCY_TAX_AMOUNT,
  FD.TOTAL,
  FD.TOTAL_WITH_TAX,
  FD.TAX_TOTAL,
  FD.CURRENCY_TOTAL,
  FD.CURRENCY_TOTAL_WITH_TAX,
  FD.CURRENCY_TAX_TOTAL,
  FD.AMOUNT_WITH_TAX AS DOCUMENT_AMOUNT,
  FD.TOTAL_WITH_TAX AS DOCUMENT_TOTAL,
  FD.CURRENCY_AMOUNT_WITH_TAX AS CURRENCY_DOCUMENT_AMOUNT,
  FD.CURRENCY_TOTAL_WITH_TAX AS CURRENCY_DOCUMENT_TOTAL,
  FD.IS_OPERATION,
  FD.IS_ACCOUNT_ITEMS
 FROM FINANCE_DOCUMENT FD
 INNER JOIN V_DOCUMENT D ON FD.ID = D.ID
 LEFT JOIN CURRENCY CR ON CR.ID = FD.CURRENCY_ID;



CREATE VIEW V_ENTRY_ITEM (
    ID,
    OWNER_ID,
    DEBIT_LEDGER_ACCOUNT_ID,
    DEBIT_OBJECT_ID,
    DEBIT_OBJECT_NAME,
    CREDIT_LEDGER_ACCOUNT_ID,
    CREDIT_OBJECT_ID,
    CREDIT_OBJECT_NAME,
    AMOUNT,
    CONTENT)
AS
SELECT 
    I.ID,
    I.OWNER_ID,
    I.DEBIT_LEDGER_ACCOUNT_ID,
    I.DEBIT_OBJECT_ID,
    D.NAME AS DEBIT_OBJECT_NAME,
    I.CREDIT_LEDGER_ACCOUNT_ID,
    I.CREDIT_OBJECT_ID,
    C.NAME AS CREDIT_OBJECT_NAME,
    I.AMOUNT,
    I.CONTENT
FROM ENTRY_ITEM I
 LEFT JOIN BUSINESSABLE D ON D.ID = I.DEBIT_OBJECT_ID
 LEFT JOIN BUSINESSABLE C ON C.ID = I.CREDIT_OBJECT_ID;


CREATE VIEW V_CONTRACTOR (
 ID,
 OWNER_ID,
 ENTITY_ID,
 NAME
) AS
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, B.NAME
 FROM BUSINESSABLE B WHERE B.ENTITY_ID = 'PARTNER' OR B.ENTITY_ID = 'EMPLOYEE';

CREATE VIEW V_CONTRACTOR_UNION (
    ID,
    OWNER_ID,
    ENTITY_ID,
    ENTITY_CODE,
    ENTITY_NAME,
    ORGANIZATION_ID,
    NAME)
AS
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, -1, CAST(O.NAME AS CHAR(100))
 FROM BUSINESSABLE B
 INNER JOIN PARTNER O ON O.ID = B.OWNER_ID
 INNER JOIN SYSTEM_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'PARTNER'
UNION ALL
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, O.ORGANIZATION_ID, CAST(P.NAME AS CHAR(100))
 FROM BUSINESSABLE B
 INNER JOIN EMPLOYEE O ON O.ID = B.OWNER_ID
 INNER JOIN PERSON P ON P.ID = O.PERSON_ID
 INNER JOIN SYSTEM_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'EMPLOYEE';
CREATE VIEW V_CITY (
  ID,
  COUNTRY_ID,
  LOCALITY_TYPE_ID,
  REGION_ID,
  DISTRICT_ID,
  NAME
) AS
SELECT
  C.ID,
  L.COUNTRY_ID,
  L.LOCALITY_TYPE_ID,
  L.REGION_ID,
  L.DISTRICT_ID,
  L.NAME
 FROM CITY C
 INNER JOIN LOCALITY L ON L.ID = C.ID;

CREATE VIEW V_ADDRESS_CITY (
  ID,
  CONTACTABLE_ID,
  COUNTRY_ID,
  LOCALITY_TYPE_ID,
  REGION_ID,
  DISTRICT_ID,
  NAME
) AS
SELECT 
  A.ID,
  A.CONTACTABLE_ID,
  C.COUNTRY_ID,
  C.LOCALITY_TYPE_ID,
  C.REGION_ID,
  C.DISTRICT_ID,
  C.NAME
FROM ADDRESS A
INNER JOIN V_CITY C ON C.ID = A.CITY_ID;

CREATE VIEW V_ADDRESS (
 ID,
 ADDRESS_TYPE_ID,
 CONTACTABLE_ID,
 CITY_ID,
 CITY_NAME,
 LOCALITY_ID,
 LOCALITY_TYPE_NAME,
 LOCALITY_NAME,
 STREET_TYPE_ID,
 ADDRESS_STRING,
 FULL_ADDRESS_STRING,
 ZIP_CODE,
 STREET,
 HOUSE_NUM,
 CASE_NUM,
 APPART_NUM,
 NOTE
) AS
SELECT 
 A.ID,
 A.ADDRESS_TYPE_ID,
 A.CONTACTABLE_ID,
 A.CITY_ID,
 C.NAME,
 A.LOCALITY_ID,
 LT.NAME,
 L.NAME,
 A.STREET_TYPE_ID,
 A.ADDRESS_STRING,
 A.FULL_ADDRESS_STRING,
 A.ZIP_CODE,
 A.STREET,
 A.HOUSE_NUM,
 A.CASE_NUM,
 A.APPART_NUM,
 A.NOTE
 FROM ADDRESS A
 LEFT JOIN V_CITY C ON C.ID = A.CITY_ID
 LEFT JOIN LOCALITY L ON L.ID = A.LOCALITY_ID
 LEFT JOIN LOCALITY_TYPE LT ON LT.ID = L.LOCALITY_TYPE_ID;

CREATE VIEW V_CONTACTABLE_ADDRESS (
 CONTACTABLE_ID,
 ADDRESS_ID,
 ADDRESS_TYPE_ID,
 CITY_ID,
 CITY_NAME,
 LOCALITY_ID,
 LOCALITY_TYPE_NAME,
 LOCALITY_NAME,
 STREET_TYPE_ID,
 ADDRESS_STRING,
 FULL_ADDRESS_STRING,
 ZIP_CODE,
 STREET,
 HOUSE_NUM,
 CASE_NUM,
 APPART_NUM,
 NOTE,
 OWNER_ID,
 ENTITY_ID
) AS
SELECT 
 C.ID AS CONTACTABLE_ID,
 A.ID AS ADDRESS_ID,
 A.ADDRESS_TYPE_ID,
 A.CITY_ID,
 A.CITY_NAME,
 A.LOCALITY_ID,
 A.LOCALITY_TYPE_NAME,
 A.LOCALITY_NAME,
 A.STREET_TYPE_ID,
 A.ADDRESS_STRING,
 A.FULL_ADDRESS_STRING,
 A.ZIP_CODE,
 A.STREET,
 A.HOUSE_NUM,
 A.CASE_NUM,
 A.APPART_NUM,
 A.NOTE,
 C.OWNER_ID,
 C.ENTITY_ID
 FROM CONTACTABLE C 
 INNER JOIN V_ADDRESS A ON A.CONTACTABLE_ID = C.ID;

CREATE VIEW V_DEF_CONTACTABLE_ADDRESS (
 CONTACTABLE_ID,
 ADDRESS_ID,
 ADDRESS_TYPE_ID,
 CITY_ID,
 CITY_NAME,
 LOCALITY_ID,
 LOCALITY_TYPE_NAME,
 LOCALITY_NAME,
 STREET_TYPE_ID,
 ADDRESS_STRING,
 FULL_ADDRESS_STRING,
 ZIP_CODE,
 STREET,
 HOUSE_NUM,
 CASE_NUM,
 APPART_NUM,
 NOTE,
 OWNER_ID,
 ENTITY_ID
) AS
SELECT 
 C.ID AS CONTACTABLE_ID,
 A.ID AS ADDRESS_ID,
 A.ADDRESS_TYPE_ID,
 A.CITY_ID,
 A.CITY_NAME,
 A.LOCALITY_ID,
 A.LOCALITY_TYPE_NAME,
 A.LOCALITY_NAME,
 A.STREET_TYPE_ID,
 A.ADDRESS_STRING,
 A.FULL_ADDRESS_STRING,
 A.ZIP_CODE,
 A.STREET,
 A.HOUSE_NUM,
 A.CASE_NUM,
 A.APPART_NUM,
 A.NOTE,
 C.OWNER_ID,
 C.ENTITY_ID
 FROM CONTACTABLE C 
 LEFT JOIN V_ADDRESS A ON A.ID = C.ADDRESS_ID;

CREATE VIEW V_DEF_PARTNER_ADDRESS (
 PARTNER_ID,
 CONTACTABLE_ID,
 ADDRESS_ID,
 ADDRESS_TYPE_ID,
 CITY_ID,
 CITY_NAME,
 LOCALITY_ID,
 LOCALITY_TYPE_NAME,
 LOCALITY_NAME,
 STREET_TYPE_ID,
 ADDRESS_STRING,
 FULL_ADDRESS_STRING,
 ZIP_CODE,
 STREET,
 HOUSE_NUM,
 CASE_NUM,
 APPART_NUM,
 NOTE,
 ENTITY_ID
) AS
SELECT 
 P.ID,
 A.CONTACTABLE_ID,
 A.ADDRESS_ID,
 A.ADDRESS_TYPE_ID,
 A.CITY_ID,
 A.CITY_NAME,
 A.LOCALITY_ID,
 A.LOCALITY_TYPE_NAME,
 A.LOCALITY_NAME,
 A.STREET_TYPE_ID,
 A.ADDRESS_STRING,
 A.FULL_ADDRESS_STRING,
 A.ZIP_CODE,
 A.STREET,
 A.HOUSE_NUM,
 A.CASE_NUM,
 A.APPART_NUM,
 A.NOTE,
 A.ENTITY_ID
 FROM  PARTNER P
 LEFT JOIN V_DEF_CONTACTABLE_ADDRESS A ON A.OWNER_ID = P.ID;

CREATE VIEW V_PHONE (
 ID,
 PHONE_TYPE_ID,
 CONTACTABLE_ID,
 PHONE_CODE,
 PHONE_NUMBER,
 PHONE_STRING,
 NOTE
) AS
SELECT 
 P.ID,
 P.PHONE_TYPE_ID,
 P.CONTACTABLE_ID,
 P.PHONE_CODE,
 P.PHONE_NUMBER,
 P.PHONE_STRING,
 P.NOTE
 FROM PHONE P;

CREATE VIEW V_CONTACTABLE_PHONE (
 CONTACTABLE_ID,
 PHONE_ID,
 PHONE_TYPE_ID,
 PHONE_CODE,
 PHONE_NUMBER,
 PHONE_STRING,
 NOTE,
 OWNER_ID,
 ENTITY_ID
) AS
SELECT 
 C.ID AS CONTACTABLE_ID,
 P.ID AS PHONE_ID,
 P.PHONE_TYPE_ID,
 P.PHONE_CODE,
 P.PHONE_NUMBER,
 P.PHONE_STRING,
 P.NOTE,
 C.OWNER_ID,
 C.ENTITY_ID
 FROM CONTACTABLE C 
 INNER JOIN V_PHONE P ON P.CONTACTABLE_ID = C.ID;

CREATE VIEW V_DEF_CONTACTABLE_PHONE (
 CONTACTABLE_ID,
 PHONE_ID,
 PHONE_TYPE_ID,
 PHONE_CODE,
 PHONE_NUMBER,
 PHONE_STRING,
 NOTE,
 OWNER_ID,
 ENTITY_ID
) AS
SELECT 
 C.ID AS CONTACTABLE_ID,
 P.ID AS PHONE_ID,
 P.PHONE_TYPE_ID,
 P.PHONE_CODE,
 P.PHONE_NUMBER,
 P.PHONE_STRING,
 P.NOTE,
 C.OWNER_ID,
 C.ENTITY_ID
 FROM CONTACTABLE C 
 LEFT JOIN V_PHONE P ON P.ID = C.PHONE_ID;

CREATE VIEW V_DEF_PARTNER_PHONE (
 PARTNER_ID,
 CONTACTABLE_ID,
 PHONE_ID,
 PHONE_TYPE_ID,
 PHONE_CODE,
 PHONE_NUMBER,
 PHONE_STRING,
 NOTE,
 ENTITY_ID
) AS
SELECT 
 P.ID,
 PH.CONTACTABLE_ID,
 PH.PHONE_ID,
 PH.PHONE_TYPE_ID,
 PH.PHONE_CODE,
 PH.PHONE_NUMBER,
 PH.PHONE_STRING,
 PH.NOTE,
 PH.ENTITY_ID
 FROM  PARTNER P
 LEFT JOIN V_DEF_CONTACTABLE_PHONE PH ON PH.OWNER_ID = P.ID;

CREATE VIEW V_BANK (
  ID,
  CODE,
  NAME,
  FULL_NAME,
  IDN,
  YEAR_CREATE,
  WORK_TIME,
  NOTE,
  IS_TAX,
  NEC,
  TAX_DOC_CODE,
  FORM_PROPERTY_ID,
  PARTNER_GROUP_ID,
  BIC,
  CORRESPONDENT_ACCOUNT,
  STOPPED_PERCENT,
  ADDRESS_ID,
  ADDRESS_TYPE_ID,
  CITY_ID,
  CITY_NAME,
  LOCALITY_ID,
  STREET_TYPE_ID,
  ADDRESS_STRING,
  ZIP_CODE,
  STREET,
  HOUSE_NUM,
  CASE_NUM,
  APPART_NUM,
  ADDRESS_NOTE,
  PHONE_ID,
  PHONE_TYPE_ID,
  PHONE_CODE,
  PHONE_NUMBER,
  PHONE_STRING,
  PHONE_NOTE
) AS
SELECT 
  B.ID,
  P.CODE,
  P.NAME,
  P.FULL_NAME,
  P.IDN,
  P.YEAR_CREATE,
  P.WORK_TIME,
  P.NOTE,
  P.IS_TAX,
  P.NEC,
  P.TAX_DOC_CODE,
  P.FORM_PROPERTY_ID,
  P.PARTNER_GROUP_ID,
  B.BIC,
  B.CORRESPONDENT_ACCOUNT,
  B.STOPPED_PERCENT,
  DA.ADDRESS_ID,
  DA.ADDRESS_TYPE_ID,
  DA.CITY_ID,
  C.NAME AS CITY_NAME,
  DA.LOCALITY_ID,
  DA.STREET_TYPE_ID,
  DA.ADDRESS_STRING,
  DA.ZIP_CODE,
  DA.STREET,
  DA.HOUSE_NUM,
  DA.CASE_NUM,
  DA.APPART_NUM,
  DA.NOTE AS ADDRESS_NOTE,
  DP.PHONE_ID,
  DP.PHONE_TYPE_ID,
  DP.PHONE_CODE,
  DP.PHONE_NUMBER,
  DP.PHONE_STRING,
  DP.NOTE AS PHONE_NOTE
 FROM BANK B
 INNER JOIN PARTNER P ON P.ID = B.ID
 INNER JOIN V_DEF_PARTNER_ADDRESS DA ON DA.PARTNER_ID = P.ID
 INNER JOIN V_DEF_PARTNER_PHONE DP ON DP.PARTNER_ID = P.ID
 LEFT JOIN V_CITY C ON C.ID = DA.CITY_ID;

CREATE VIEW V_PARTNER_BANK_ACCOUNT (
  ID,
  BANK_ID,
  PARTNER_ID,
  NAME,
  ACCOUNT_NO
) AS
SELECT 
  BA.ID,
  BA.BANK_ID,
  BA.PARTNER_ID,
  BA.NAME,
  BA.ACCOUNT_NO
FROM BANK_ACCOUNT BA;

CREATE VIEW V_PAYMENT_INCOME (
    ID,
    ORGANIZATION_ID,
    ORGANIZATION_NAME,
    ORGANIZATION_CODE,
    ORGANIZATION_NEC,
    DOCUMENT_TYPE_ID,
    DOCUMENT_TYPE_CODE,
    DOCUMENT_TYPE_NAME,
    PERIOD_ID,
    DOCUMENT_CODE,
    DOCUMENT_DATE,
    USER_ID,
    USRNAME,
    CONTRACT_ID,
    REASON_DOCUMENT_ID,
    REASON,
    NOTE,
    CURRENCY_ID,
    AMOUNT_WITH_TAX,
    TAX_AMOUNT,
    AMOUNT,
    CURRENCY_AMOUNT_WITH_TAX,
    CURRENCY_TAX_AMOUNT,
    CURRENCY_AMOUNT,
    TOTAL,
    TOTAL_WITH_TAX,
    TAX_TOTAL,
    CURRENCY_TOTAL,
    CURRENCY_TOTAL_WITH_TAX,
    CURRENCY_TAX_TOTAL,
    DOCUMENT_AMOUNT,
    DOCUMENT_TOTAL,
    CURRENCY_DOCUMENT_AMOUNT,
    CURRENCY_DOCUMENT_TOTAL,
    PARTNER_BANK_ACCOUNT_ID,
    PARTNER_BANK_ACCOUNT_NO,
    PARTNER_BANK_BIC,
    PARTNER_BANK_NAME,
    PARTNER_BANK_CITY_NAME,
    ORGANIZATION_BANK_ACCOUNT_ID,
    ORGANIZATION_BANK_ACCOUNT_NO,
    ORGANIZATION_BANK_BIC,
    ORGANIZATION_BANK_NAME,
    ORGANIZATION_BANK_CITY_NAME,
    PARTNER_ID,
    PARTNER_NAME,
    PARTNER_CODE,
    PARTNER_NEC,
    PAYMENT_MISSING
) AS
SELECT
  PAY.ID,
  FD.ORGANIZATION_ID,
  FD.ORGANIZATION_NAME,
  FD.ORGANIZATION_CODE,
  FD.ORGANIZATION_NEC,
  FD.DOCUMENT_TYPE_ID, 
  FD.DOCUMENT_TYPE_CODE,
  FD.DOCUMENT_TYPE_NAME,
  FD.PERIOD_ID,
  FD.DOCUMENT_CODE, 
  FD.DOCUMENT_DATE,
  FD.USER_ID,
  FD.USRNAME,
  FD.CONTRACT_ID,
  FD.REASON_DOCUMENT_ID,
  FD.REASON,
  FD.NOTE,
  FD.CURRENCY_ID,
  FD.AMOUNT_WITH_TAX,
  FD.TAX_AMOUNT, 
  FD.AMOUNT,
  FD.CURRENCY_AMOUNT_WITH_TAX,
  FD.CURRENCY_TAX_AMOUNT,
  FD.CURRENCY_AMOUNT,
  FD.TOTAL,
  FD.TOTAL_WITH_TAX,
  FD.TAX_TOTAL,
  FD.CURRENCY_TOTAL,
  FD.CURRENCY_TOTAL_WITH_TAX,
  FD.CURRENCY_TAX_TOTAL,
  FD.DOCUMENT_AMOUNT,
  FD.DOCUMENT_TOTAL,
  FD.CURRENCY_DOCUMENT_AMOUNT,
  FD.CURRENCY_DOCUMENT_TOTAL,
  PAY.PARTNER_BANK_ACCOUNT_ID,
  PRT_BA.ACCOUNT_NO AS PARTNER_BANK_ACCOUNT_NO,
  PRT_BK.BIC AS PARTNER_BANK_BIC,
  PRT_BK.NAME AS PARTNER_BANK_NAME,
  PRT_BK.CITY_NAME AS PARTNER_BANK_CITY_NAME,
  PAY.ORGANIZATION_BANK_ACCOUNT_ID,
  ORG_BA.ACCOUNT_NO AS ORGANIZATION_BANK_ACCOUNT_NO,
  ORG_BK.BIC AS ORGANIZATION_BANK_BIC,
  ORG_BK.NAME AS ORGANIZATION_BANK_NAME,
  ORG_BK.CITY_NAME AS ORGANIZATION_BANK_CITY_NAME,
  FD.PARTNER_ID,
  PRT.NAME AS PARTNER_NAME,
  PRT.CODE AS PARTNER_CODE,
  PRT.NEC AS PARTNER_NEC,
  PAY.PAYMENT_MISSING
 FROM PAYMENT_INCOME PAY
 INNER JOIN V_FINANCE_DOCUMENT FD ON FD.ID = PAY.ID
 INNER JOIN ORGANIZATION ORG ON ORG.ID= FD.ORGANIZATION_ID
 INNER JOIN BANK_ACCOUNT ORG_BA ON ORG_BA.ID = PAY.ORGANIZATION_BANK_ACCOUNT_ID
 INNER JOIN V_BANK ORG_BK ON ORG_BK.ID = ORG_BA.BANK_ID
 INNER JOIN BANK_ACCOUNT PRT_BA ON PRT_BA.ID = PAY.PARTNER_BANK_ACCOUNT_ID
 INNER JOIN V_BANK PRT_BK ON PRT_BK.ID = PRT_BA.BANK_ID
 INNER JOIN PARTNER PRT ON PRT.ID = FD.PARTNER_ID;
 
CREATE VIEW V_PAYMENT_OUTCOME (
    ID,
    ORGANIZATION_ID,
    ORGANIZATION_NAME,
    ORGANIZATION_CODE,
    ORGANIZATION_NEC,
    DOCUMENT_TYPE_ID,
    DOCUMENT_TYPE_CODE,
    DOCUMENT_TYPE_NAME,
    PERIOD_ID,
    DOCUMENT_CODE,
    DOCUMENT_DATE,
    USER_ID,
    USRNAME,
    CONTRACT_ID,
    REASON_DOCUMENT_ID,
    REASON,
    NOTE,
    CURRENCY_ID,
    AMOUNT_WITH_TAX,
    TAX_AMOUNT,
    AMOUNT,
    CURRENCY_AMOUNT_WITH_TAX,
    CURRENCY_TAX_AMOUNT,
    CURRENCY_AMOUNT,
    TOTAL,
    TOTAL_WITH_TAX,
    TAX_TOTAL,
    CURRENCY_TOTAL,
    CURRENCY_TOTAL_WITH_TAX,
    CURRENCY_TAX_TOTAL,
    DOCUMENT_AMOUNT,
    DOCUMENT_TOTAL,
    CURRENCY_DOCUMENT_AMOUNT,
    CURRENCY_DOCUMENT_TOTAL,
    PARTNER_BANK_ACCOUNT_ID,
    PARTNER_BANK_ACCOUNT_NO,
    PARTNER_BANK_BIC,
    PARTNER_BANK_NAME,
    PARTNER_BANK_CITY_NAME,
    ORGANIZATION_BANK_ACCOUNT_ID,
    ORGANIZATION_BANK_ACCOUNT_NO,
    ORGANIZATION_BANK_BIC,
    ORGANIZATION_BANK_NAME,
    ORGANIZATION_BANK_CITY_NAME,
    PARTNER_ID,
    PARTNER_NAME,
    PARTNER_CODE,
    PARTNER_NEC,
    PAYMENT_MISSING
) AS
SELECT
  PAY.ID,
  FD.ORGANIZATION_ID,
  FD.ORGANIZATION_NAME,
  FD.ORGANIZATION_CODE,
  FD.ORGANIZATION_NEC,
  FD.DOCUMENT_TYPE_ID, 
  FD.DOCUMENT_TYPE_CODE,
  FD.DOCUMENT_TYPE_NAME,
  FD.PERIOD_ID,
  FD.DOCUMENT_CODE, 
  FD.DOCUMENT_DATE,
  FD.USER_ID,
  FD.USRNAME,
  FD.CONTRACT_ID,
  FD.REASON_DOCUMENT_ID,
  FD.REASON,
  FD.NOTE,
  FD.CURRENCY_ID,
  FD.AMOUNT_WITH_TAX,
  FD.TAX_AMOUNT, 
  FD.AMOUNT,
  FD.CURRENCY_AMOUNT_WITH_TAX,
  FD.CURRENCY_TAX_AMOUNT,
  FD.CURRENCY_AMOUNT,
  FD.TOTAL,
  FD.TOTAL_WITH_TAX,
  FD.TAX_TOTAL,
  FD.CURRENCY_TOTAL,
  FD.CURRENCY_TOTAL_WITH_TAX,
  FD.CURRENCY_TAX_TOTAL,
  FD.DOCUMENT_AMOUNT,
  FD.DOCUMENT_TOTAL,
  FD.CURRENCY_DOCUMENT_AMOUNT,
  FD.CURRENCY_DOCUMENT_TOTAL,
  PAY.PARTNER_BANK_ACCOUNT_ID,
  PRT_BA.ACCOUNT_NO AS PARTNER_BANK_ACCOUNT_NO,
  PRT_BK.BIC AS PARTNER_BANK_BIC,
  PRT_BK.NAME AS PARTNER_BANK_NAME,
  PRT_BK.CITY_NAME AS PARTNER_BANK_CITY_NAME,
  PAY.ORGANIZATION_BANK_ACCOUNT_ID,
  ORG_BA.ACCOUNT_NO AS ORGANIZATION_BANK_ACCOUNT_NO,
  ORG_BK.BIC AS ORGANIZATION_BANK_BIC,
  ORG_BK.NAME AS ORGANIZATION_BANK_NAME,
  ORG_BK.CITY_NAME AS ORGANIZATION_BANK_CITY_NAME,
  FD.PARTNER_ID,
  PRT.NAME AS PARTNER_NAME,
  PRT.CODE AS PARTNER_CODE,
  PRT.NEC AS PARTNER_NEC,
  PAY.PAYMENT_MISSING
 FROM PAYMENT_OUTCOME PAY
 INNER JOIN V_FINANCE_DOCUMENT FD ON FD.ID = PAY.ID
 INNER JOIN ORGANIZATION ORG ON ORG.ID= FD.ORGANIZATION_ID
 INNER JOIN BANK_ACCOUNT ORG_BA ON ORG_BA.ID = PAY.ORGANIZATION_BANK_ACCOUNT_ID
 INNER JOIN V_BANK ORG_BK ON ORG_BK.ID = ORG_BA.BANK_ID
 INNER JOIN BANK_ACCOUNT PRT_BA ON PRT_BA.ID = PAY.PARTNER_BANK_ACCOUNT_ID
 INNER JOIN V_BANK PRT_BK ON PRT_BK.ID = PRT_BA.BANK_ID
 INNER JOIN PARTNER PRT ON PRT.ID = FD.PARTNER_ID;
 
 

CREATE VIEW V_PAYMENT (
    ID,
    ORGANIZATION_ID,
    DEBIT_PARTNER_ID,
    DEBIT_PARTNER_NAME,
    DEBIT_PARTNER_CODE,
    DEBIT_PARTNER_NEC,
    CREDIT_PARTNER_ID,
    CREDIT_PARTNER_NAME,
    CREDIT_PARTNER_CODE,
    CREDIT_PARTNER_NEC,
    DOCUMENT_TYPE_ID,
    DOCUMENT_TYPE_CODE,
    DOCUMENT_TYPE_NAME,
    PERIOD_ID,
    DOCUMENT_CODE,
    DOCUMENT_DATE,
    USER_ID,
    USRNAME,
    CONTRACT_ID,
    REASON_DOCUMENT_ID,
    REASON,
    NOTE,
    CURRENCY_ID,
    AMOUNT_WITH_TAX,
    TAX_AMOUNT,
    AMOUNT,
    CURRENCY_AMOUNT_WITH_TAX,
    CURRENCY_TAX_AMOUNT,
    CURRENCY_AMOUNT,
    TOTAL,
    TOTAL_WITH_TAX,
    TAX_TOTAL,
    CURRENCY_TOTAL,
    CURRENCY_TOTAL_WITH_TAX,
    CURRENCY_TAX_TOTAL,
    DOCUMENT_AMOUNT,
    DOCUMENT_TOTAL,
    CURRENCY_DOCUMENT_AMOUNT,
    CURRENCY_DOCUMENT_TOTAL,
    DEBIT_PARTNER_BANK_ACCOUNT_NO,
    DEBIT_PARTNER_BANK_BIC,
    DEBIT_PARTNER_BANK_NAME,
    DEBIT_PARTNER_BANK_CITY_NAME,
    CREDIT_PARTNER_BANK_ACCOUNT_NO,
    CREDIT_PARTNER_BANK_BIC,
    CREDIT_PARTNER_BANK_NAME,
    CREDIT_PARTNER_BANK_CITY_NAME,
    PAYMENT_MISSING
) AS
SELECT
  P.ID,
  P.ORGANIZATION_ID,
  P.ORGANIZATION_ID,
  P.ORGANIZATION_NAME,
  P.ORGANIZATION_CODE,
  P.ORGANIZATION_NEC,
  P.PARTNER_ID,
  P.PARTNER_NAME,
  P.PARTNER_CODE,
  P.PARTNER_NEC,
  P.DOCUMENT_TYPE_ID,
  P.DOCUMENT_TYPE_CODE,
  P.DOCUMENT_TYPE_NAME,
  P.PERIOD_ID,
  P.DOCUMENT_CODE,
  P.DOCUMENT_DATE,
  P.USER_ID,
  P.USRNAME,
  P.CONTRACT_ID,
  P.REASON_DOCUMENT_ID,
  P.REASON,
  P.NOTE,
  P.CURRENCY_ID,
  P.AMOUNT_WITH_TAX,
  P.TAX_AMOUNT,
  P.AMOUNT,
  P.CURRENCY_AMOUNT_WITH_TAX,
  P.CURRENCY_TAX_AMOUNT,
  P.CURRENCY_AMOUNT,
  P.TOTAL,
  P.TOTAL_WITH_TAX,
  P.TAX_TOTAL,
  P.CURRENCY_TOTAL,
  P.CURRENCY_TOTAL_WITH_TAX,
  P.CURRENCY_TAX_TOTAL,
  P.DOCUMENT_AMOUNT,
  P.DOCUMENT_TOTAL,
  P.CURRENCY_DOCUMENT_AMOUNT,
  P.CURRENCY_DOCUMENT_TOTAL,
  P.ORGANIZATION_BANK_ACCOUNT_NO,
  P.ORGANIZATION_BANK_BIC,
  P.ORGANIZATION_BANK_NAME,
  P.ORGANIZATION_BANK_CITY_NAME,
  P.PARTNER_BANK_ACCOUNT_NO,
  P.PARTNER_BANK_BIC,
  P.PARTNER_BANK_NAME,
  P.PARTNER_BANK_CITY_NAME,
  P.PAYMENT_MISSING
 FROM V_PAYMENT_OUTCOME P
 UNION ALL
SELECT
  P.ID,
  P.ORGANIZATION_ID,
  P.PARTNER_ID,
  P.PARTNER_NAME,
  P.PARTNER_CODE,
  P.PARTNER_NEC,
  P.ORGANIZATION_ID,
  P.ORGANIZATION_NAME,
  P.ORGANIZATION_CODE,
  P.ORGANIZATION_NEC,
  P.DOCUMENT_TYPE_ID,
  P.DOCUMENT_TYPE_CODE,
  P.DOCUMENT_TYPE_NAME,
  P.PERIOD_ID,
  P.DOCUMENT_CODE,
  P.DOCUMENT_DATE,
  P.USER_ID,
  P.USRNAME,
  P.CONTRACT_ID,
  P.REASON_DOCUMENT_ID,
  P.REASON,
  P.NOTE,
  P.CURRENCY_ID,
  P.AMOUNT_WITH_TAX,
  P.TAX_AMOUNT,
  P.AMOUNT,
  P.CURRENCY_AMOUNT_WITH_TAX,
  P.CURRENCY_TAX_AMOUNT,
  P.CURRENCY_AMOUNT,
  P.TOTAL,
  P.TOTAL_WITH_TAX,
  P.TAX_TOTAL,
  P.CURRENCY_TOTAL,
  P.CURRENCY_TOTAL_WITH_TAX,
  P.CURRENCY_TAX_TOTAL,
  P.DOCUMENT_AMOUNT,
  P.DOCUMENT_TOTAL,
  P.CURRENCY_DOCUMENT_AMOUNT,
  P.CURRENCY_DOCUMENT_TOTAL,
  P.PARTNER_BANK_ACCOUNT_NO,
  P.PARTNER_BANK_BIC,
  P.PARTNER_BANK_NAME,
  P.PARTNER_BANK_CITY_NAME,
  P.ORGANIZATION_BANK_ACCOUNT_NO,
  P.ORGANIZATION_BANK_BIC,
  P.ORGANIZATION_BANK_NAME,
  P.ORGANIZATION_BANK_CITY_NAME,
  P.PAYMENT_MISSING
 FROM V_PAYMENT_INCOME P;
 
 
CREATE VIEW V_PAYMENT_ROTATE (
    ID,
    ORGANIZATION_ID,
    PARTNER_ID,
    PARTNER_NAME,
    PARTNER_CODE,
    PARTNER_NEC,
    DOCUMENT_TYPE_ID,
    DOCUMENT_TYPE_CODE,
    DOCUMENT_TYPE_NAME,
    PERIOD_ID,
    DOCUMENT_CODE,
    DOCUMENT_DATE,
    USER_ID,
    USRNAME,
    CONTRACT_ID,
    REASON_DOCUMENT_ID,
    REASON,
    NOTE,
    CURRENCY_ID,
    DEBIT_AMOUNT,
    CREDIT_AMOUNT,
    PARTNER_BANK_ACCOUNT_ID,
    PARTNER_BANK_ACCOUNT_NO,
    PARTNER_BANK_BIC,
    PARTNER_BANK_NAME,
    PARTNER_BANK_CITY_NAME,
    ORGANIZATION_BANK_ACCOUNT_ID,
    ORGANIZATION_BANK_ACCOUNT_NO,
    ORGANIZATION_BANK_BIC,
    ORGANIZATION_BANK_NAME,
    ORGANIZATION_BANK_CITY_NAME,
    PAYMENT_MISSING
) AS
SELECT
  P.ID,
  P.ORGANIZATION_ID,
  P.PARTNER_ID,
  P.PARTNER_NAME,
  P.PARTNER_CODE,
  P.PARTNER_NEC,
  P.DOCUMENT_TYPE_ID,
  P.DOCUMENT_TYPE_CODE,
  P.DOCUMENT_TYPE_NAME,
  P.PERIOD_ID,
  P.DOCUMENT_CODE,
  P.DOCUMENT_DATE,
  P.USER_ID,
  P.USRNAME,
  P.CONTRACT_ID,
  P.REASON_DOCUMENT_ID,
  P.REASON,
  P.NOTE,
  P.CURRENCY_ID,
  P.DOCUMENT_TOTAL AS DEBIT_AMOUNT,
  0.0 AS CREDIT_AMOUNT,
  P.PARTNER_BANK_ACCOUNT_ID,
  P.PARTNER_BANK_ACCOUNT_NO,
  P.PARTNER_BANK_BIC,
  P.PARTNER_BANK_NAME,
  P.PARTNER_BANK_CITY_NAME,
  P.ORGANIZATION_BANK_ACCOUNT_ID,
  P.ORGANIZATION_BANK_ACCOUNT_NO,
  P.ORGANIZATION_BANK_BIC,
  P.ORGANIZATION_BANK_NAME,
  P.ORGANIZATION_BANK_CITY_NAME,
  P.PAYMENT_MISSING
 FROM V_PAYMENT_OUTCOME P
 UNION ALL
SELECT
  P.ID,
  P.ORGANIZATION_ID,
  P.PARTNER_ID,
  P.PARTNER_NAME,
  P.PARTNER_CODE,
  P.PARTNER_NEC,
  P.DOCUMENT_TYPE_ID,
  P.DOCUMENT_TYPE_CODE,
  P.DOCUMENT_TYPE_NAME,
  P.PERIOD_ID,
  P.DOCUMENT_CODE,
  P.DOCUMENT_DATE,
  P.USER_ID,
  P.USRNAME,
  P.CONTRACT_ID,
  P.REASON_DOCUMENT_ID,
  P.REASON,
  P.NOTE,
  P.CURRENCY_ID,
  0.0 AS DEBIT_AMOUNT,
  P.DOCUMENT_TOTAL AS CREDIT_AMOUNT,
  P.PARTNER_BANK_ACCOUNT_ID,
  P.PARTNER_BANK_ACCOUNT_NO,
  P.PARTNER_BANK_BIC,
  P.PARTNER_BANK_NAME,
  P.PARTNER_BANK_CITY_NAME,
  P.ORGANIZATION_BANK_ACCOUNT_ID,
  P.ORGANIZATION_BANK_ACCOUNT_NO,
  P.ORGANIZATION_BANK_BIC,
  P.ORGANIZATION_BANK_NAME,
  P.ORGANIZATION_BANK_CITY_NAME,
  P.PAYMENT_MISSING
 FROM V_PAYMENT_INCOME P;


CREATE VIEW V_BUSINESSABLE (
  ID, 
  OWNER_ID, 
  ENTITY_ID, 
  ENTITY_CODE, 
  ENTITY_NAME, 
  NAME
) AS 
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, CAST(O.NAME AS CHAR(100))
 FROM BUSINESSABLE B
 INNER JOIN DEPARTMENT O ON O.ID = B.OWNER_ID
 INNER JOIN SYSTEM_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'DEPARTMENT'
UNION ALL
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, CAST(O.NAME AS CHAR(100))
 FROM BUSINESSABLE B
 INNER JOIN STORE O ON O.ID = B.OWNER_ID
 INNER JOIN SYSTEM_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'STORE'
UNION ALL
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, CAST(O.NAME AS CHAR(100))
 FROM BUSINESSABLE B
 INNER JOIN DRUGSTORE O ON O.ID = B.OWNER_ID
 INNER JOIN SYSTEM_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'DRUGSTORE'
UNION ALL
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, CAST(O.NAME AS CHAR(100))
 FROM BUSINESSABLE B
 INNER JOIN SHOP O ON O.ID = B.OWNER_ID
 INNER JOIN SYSTEM_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'SHOP'
UNION ALL
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, CAST(O.NAME AS CHAR(100))
 FROM BUSINESSABLE B
 INNER JOIN BRIGADE O ON O.ID = B.OWNER_ID
 INNER JOIN SYSTEM_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'BRIGADE'
UNION ALL
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, CAST(O.NAME AS CHAR(100))
 FROM BUSINESSABLE B
 INNER JOIN WORKSHOP O ON O.ID = B.OWNER_ID
 INNER JOIN SYSTEM_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'WORKSHOP'
UNION ALL
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, CAST(O.NAME AS CHAR(100))
 FROM BUSINESSABLE B
 INNER JOIN FACTORY O ON O.ID = B.OWNER_ID
 INNER JOIN SYSTEM_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'FACTORY'
UNION ALL
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, CAST(O.NAME AS CHAR(100))
 FROM BUSINESSABLE B
 INNER JOIN WORKS O ON O.ID = B.OWNER_ID
 INNER JOIN SYSTEM_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'WORKS'
UNION ALL
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, CAST(O.RESPONSIBLE_NAME AS CHAR(100))
 FROM BUSINESSABLE B
 INNER JOIN V_RESPONSIBLE O ON O.ID = B.OWNER_ID
 INNER JOIN SYSTEM_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'RESPONSIBLE'
UNION ALL
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, CAST(O.NAME AS CHAR(100))
 FROM BUSINESSABLE B
 INNER JOIN PARTNER O ON O.ID = B.OWNER_ID
 INNER JOIN SYSTEM_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'PARTNER'
UNION ALL
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, CAST(O.NAME AS CHAR(100))
 FROM BUSINESSABLE B
 INNER JOIN V_BANK O ON O.ID = B.OWNER_ID
 INNER JOIN SYSTEM_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'BANK'
UNION ALL
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, CAST(O.PRODUCT_NAME AS CHAR(100))
 FROM BUSINESSABLE B
 INNER JOIN V_GOODS O ON O.ID = B.OWNER_ID
 INNER JOIN SYSTEM_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'GOODS'
UNION ALL
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, CAST(O.PRODUCT_NAME AS CHAR(100))
 FROM BUSINESSABLE B
 INNER JOIN V_ASSET O ON O.ID = B.OWNER_ID
 INNER JOIN SYSTEM_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'ASSET'
UNION ALL
SELECT B.ID, B.OWNER_ID, B.ENTITY_ID, E.CODE, E.NAME, CAST(O.NAME AS CHAR(100))
 FROM BUSINESSABLE B
 INNER JOIN V_EMPLOYEE O ON O.ID = B.OWNER_ID
 INNER JOIN SYSTEM_ENTITY E ON E.ID = B.ENTITY_ID
 WHERE E.CODE = 'EMPLOYEE'; 

CREATE VIEW V_PARTNER_REGISTER (
 ID,
 ORGANIZATION_ID,
 PERIOD_ID,
 PARTNER_ID,
 DEBIT_AMOUNT,
 CREDIT_AMOUNT
) AS 
SELECT 
 R.ID,
 R.ORGANIZATION_ID,
 R.PERIOD_ID,
 R.PARTNER_ID,
 R.DEBIT_AMOUNT,
 R.CREDIT_AMOUNT
 FROM PARTNER_REGISTER R;


CREATE VIEW V_PARTNER_MOVE (
  ID,
  DOCUMENT_ID,
  PARTNER_ID,
  PARTNER_NAME,
  AMOUNT,
  AMOUNT_WITH_TAX,
  TAX_AMOUNT
) AS
SELECT 
  M.ID,
  M.OWNER_ID AS DOCUMENT_ID,
  M.PARTNER_ID,
  P.NAME AS PARTNER_NAME,
  M.AMOUNT,
  M.AMOUNT_WITH_TAX,
  M.TAX_AMOUNT
 FROM PARTNER_MOVE M
 INNER JOIN PARTNER P ON P.ID = M.PARTNER_ID;

CREATE VIEW V_GOODS_REGISTER (
 ID,
 ORGANIZATION_ID,
 PERIOD_ID,
 GOODS_ID,
 QUANTITY,
 PRICE,
 AMOUNT
) AS
SELECT 
 R.ID,
 R.ORGANIZATION_ID,
 R.PERIOD_ID,
 R.PRODUCT_ID AS GOODS_ID,
 R.QUANTITY,
 R.PRICE,
 R.AMOUNT
FROM PRODUCT_REGISTER R
INNER JOIN GOODS G ON G.ID = R.PRODUCT_ID;


CREATE VIEW V_GOODS_DETAIL_REGISTER (
 ID,
 ORGANIZATION_ID,
 PERIOD_ID,
 GOODS_ID,
 WAREHOUSE_ID,
 RESPONSIBLE_ID,
 QUANTITY,
 AMOUNT
) AS
SELECT 
 R.ID,
 R.ORGANIZATION_ID,
 R.PERIOD_ID,
 R.PRODUCT_ID AS GOODS_ID,
 R.WAREHOUSE_ID,
 R.RESPONSIBLE_ID,
 R.QUANTITY,
 R.AMOUNT
FROM PRODUCT_DETAIL_REGISTER R
INNER JOIN GOODS G ON G.ID = R.PRODUCT_ID;



CREATE VIEW V_GOODS_SALE (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_ID,
  DOCUMENT_CODE,
  DOCUMENT_DATE,
  DOCUMENT_YEAR,
  DOCUMENT_MONTH,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRODUCT_PRICE,
  PRICE,
  ITEM_PRICE,
  QUANTITY,
  AMOUNT,
  DOCUMENT_AMOUNT
) AS
SELECT 
  FD.PERIOD_ID,
  FD.ORGANIZATION_ID,
  FD.ID AS DOCUMENT_ID,
  FD.DOCUMENT_CODE,
  FD.DOCUMENT_DATE,
  FD.DOCUMENT_YEAR,
  FD.DOCUMENT_MONTH,
  I.PRODUCT_ID,
  I.PRODUCT_CODE,
  I.PRODUCT_NAME,
  I.ITEM_UNIT_ID,
  I.UNIT_ID,
  I.UNIT_NAME,
  I.PRODUCT_PRICE,
  I.ITEM_ACCOUNT_PRICE AS PRICE,
  I.ITEM_PRICE AS ITEM_PRICE,
  I.ACCOUNT_QUANTITY AS QUANTITY,
  I.ITEM_AMOUNT AS AMOUNT,
  FD.DOCUMENT_AMOUNT
 FROM V_PRODUCT_MOVE I
 INNER JOIN V_FINANCE_DOCUMENT FD ON FD.ID = I.DOCUMENT_ID
 INNER JOIN DOCUMENT_TYPE T ON T.ID = FD.DOCUMENT_TYPE_ID 
 AND T.DOCUMENT_SECTION = 'GOODS' AND T.DOCUMENT_CATEGORY = 'SALE';

/* USE IS_COMPLETE */


CREATE VIEW V_GOODS_PURCHASE (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_ID,
  DOCUMENT_CODE,
  DOCUMENT_DATE,
  DOCUMENT_YEAR,
  DOCUMENT_MONTH,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRODUCT_PRICE,
  PRICE,
  ITEM_PRICE,
  QUANTITY,
  AMOUNT,
  DOCUMENT_AMOUNT,
  WAREHOUSE_ID,
  WAREHOUSE_NAME,
  PARTNER_ID,
  PARTNER_NAME
) AS
SELECT 
  FD.PERIOD_ID,
  FD.ORGANIZATION_ID,
  FD.ID AS DOCUMENT_ID,
  FD.DOCUMENT_CODE,
  FD.DOCUMENT_DATE,
  FD.DOCUMENT_YEAR,
  FD.DOCUMENT_MONTH,
  I.PRODUCT_ID,
  I.PRODUCT_CODE,
  I.PRODUCT_NAME,
  I.ITEM_UNIT_ID,
  I.UNIT_ID,
  I.UNIT_NAME,
  I.PRODUCT_PRICE,
  I.ITEM_ACCOUNT_PRICE AS PRICE,
  I.ITEM_PRICE AS ITEM_PRICE,
  I.ACCOUNT_QUANTITY AS QUANTITY,
  I.ITEM_AMOUNT AS AMOUNT,
  FD.DOCUMENT_AMOUNT,
  STO.WAREHOUSE_ID,
  STO.WAREHOUSE_NAME,
  PRT.PARTNER_ID,
  PRT.PARTNER_NAME
 FROM V_PRODUCT_MOVE I
 INNER JOIN V_FINANCE_DOCUMENT FD ON FD.ID = I.DOCUMENT_ID
 INNER JOIN V_WAREHOUSE_MOVE STO ON STO.DOCUMENT_ID = FD.ID
 INNER JOIN V_PARTNER_MOVE PRT ON PRT.DOCUMENT_ID = FD.ID
 INNER JOIN DOCUMENT_TYPE T ON T.ID = FD.DOCUMENT_TYPE_ID 
 AND T.DOCUMENT_SECTION = 'GOODS' AND T.DOCUMENT_CATEGORY = 'PURCHASE';

/* USE IS_COMPLETE */


CREATE VIEW V_RPT_GOODS_INCOME (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_ID,
  DOCUMENT_CODE,
  DOCUMENT_DATE,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRICE,
  QUANTITY,
  AMOUNT,
  DOCUMENT_AMOUNT,
  WAREHOUSE_ID,
  WAREHOUSE_NAME,
  PARTNER_ID,
  PARTNER_NAME
) AS
SELECT
  FD.PERIOD_ID,
  FD.ORGANIZATION_ID,
  I.GOODS_INCOME_ID,
  FD.DOCUMENT_CODE,
  FD.DOCUMENT_DATE,
  I.PRODUCT_ID,
  P.PRODUCT_CODE,
  P.PRODUCT_NAME,
  I.UNIT_ID,
  I.UNIT_ID,
  U.NAME,
  I.PRICE,
  I.QUANTITY,
  I.AMOUNT,
  FD.DOCUMENT_AMOUNT,
  D.WAREHOUSE_ID,
  STO.NAME,
  FD.PARTNER_ID,
  PRT.NAME
 FROM GOODS_INCOME_ITEM I
 INNER JOIN GOODS_INCOME D ON D.ID = I.GOODS_INCOME_ID
 INNER JOIN V_FINANCE_DOCUMENT FD ON FD.ID = D.ID
 INNER JOIN V_PRODUCT P ON P.ID = I.PRODUCT_ID
 INNER JOIN UNIT U ON U.ID = I.UNIT_ID
 INNER JOIN V_WAREHOUSE STO ON STO.ID = D.WAREHOUSE_ID
 INNER JOIN PARTNER PRT ON PRT.ID = FD.PARTNER_ID;
 

CREATE VIEW V_RPT_GOODS_OUTCOME (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_ID,
  DOCUMENT_CODE,
  DOCUMENT_DATE,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRICE,
  QUANTITY,
  AMOUNT,
  DOCUMENT_AMOUNT,
  WAREHOUSE_ID,
  WAREHOUSE_NAME,
  PARTNER_ID,
  PARTNER_NAME
) AS
SELECT 
  FD.PERIOD_ID,
  FD.ORGANIZATION_ID,
  I.GOODS_OUTCOME_ID,
  FD.DOCUMENT_CODE,
  FD.DOCUMENT_DATE,
  I.PRODUCT_ID,
  P.PRODUCT_CODE,
  P.PRODUCT_NAME,
  I.UNIT_ID,
  I.UNIT_ID,
  U.NAME,
  I.PRICE,
  I.QUANTITY,
  I.AMOUNT,
  FD.DOCUMENT_AMOUNT,
  D.WAREHOUSE_ID,
  STO.NAME,
  FD.PARTNER_ID,
  PRT.NAME
 FROM GOODS_OUTCOME_ITEM I
 INNER JOIN GOODS_OUTCOME D ON D.ID = I.GOODS_OUTCOME_ID
 INNER JOIN V_FINANCE_DOCUMENT FD ON FD.ID = D.ID
 INNER JOIN V_PRODUCT P ON P.ID = I.PRODUCT_ID
 INNER JOIN UNIT U ON U.ID = I.UNIT_ID
 INNER JOIN V_WAREHOUSE STO ON STO.ID = D.WAREHOUSE_ID
 INNER JOIN PARTNER PRT ON PRT.ID = FD.PARTNER_ID;


CREATE VIEW V_RPT_GOODS_REST (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_ID,
  DOCUMENT_CODE,
  DOCUMENT_DATE,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRODUCT_PRICE,
  QUANTITY,
  PRICE,
  AMOUNT,
  WAREHOUSE_ID
) AS
SELECT 
  FD.PERIOD_ID,
  FD.ORGANIZATION_ID,
  I.INVENTORY_REST_ID,
  FD.DOCUMENT_CODE,
  FD.DOCUMENT_DATE,
  I.PRODUCT_ID,
  P.PRODUCT_CODE,
  P.PRODUCT_NAME,
  I.UNIT_ID,
  P.UNIT_ID,
  U.NAME,
  P.PRICE AS PRODUCT_PRICE,
  I.ACCOUNT_QUANTITY AS QUANTITY,
  I.ACCOUNT_PRICE AS PRICE,
  I.AMOUNT,
  D.WAREHOUSE_ID
 FROM INVENTORY_REST_ITEM I
 INNER JOIN INVENTORY_REST D ON D.ID = I.INVENTORY_REST_ID
 INNER JOIN V_FINANCE_DOCUMENT FD ON FD.ID = D.ID
 INNER JOIN V_PRODUCT P ON P.ID = I.PRODUCT_ID
 INNER JOIN UNIT U ON U.ID = P.UNIT_ID;

CREATE VIEW V_RPT_INVOICE (
  PERIOD_ID,
  ORGANIZATION_ID,
  INVOICE_ID,
  DOCUMENT_CODE,
  DOCUMENT_DATE,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRICE,
  QUANTITY,
  AMOUNT,
  DOCUMENT_AMOUNT,
  PARTNER_ID,
  PARTNER_NAME
) AS
SELECT 
  FD.PERIOD_ID,
  FD.ORGANIZATION_ID,
  I.SALE_INVOICE_ID,
  FD.DOCUMENT_CODE,
  FD.DOCUMENT_DATE,
  I.PRODUCT_ID,
  P.PRODUCT_CODE,
  P.PRODUCT_NAME,
  I.UNIT_ID,
  I.UNIT_ID,
  U.NAME,
  I.PRICE,
  I.QUANTITY,
  I.AMOUNT,
  FD.DOCUMENT_AMOUNT,
  FD.PARTNER_ID,
  PRT.NAME
 FROM SALE_INVOICE_ITEM I
 INNER JOIN SALE_INVOICE D ON D.ID = I.SALE_INVOICE_ID
 INNER JOIN V_FINANCE_DOCUMENT FD ON FD.ID = D.ID 
 INNER JOIN V_PRODUCT P ON P.ID = I.PRODUCT_ID
 INNER JOIN UNIT U ON U.ID = I.UNIT_ID
 INNER JOIN PARTNER PRT ON PRT.ID = FD.PARTNER_ID;

CREATE VIEW V_RPT_GOODS_REGISTER (
  PERIOD_ID,
  ORGANIZATION_ID,
  GOODS_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  UNIT_ID,
  UNIT_NAME,
  PRODUCT_PRICE,
  PRICE,
  QUANTITY,
  AMOUNT
) AS
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.GOODS_ID,
  P.PRODUCT_CODE,
  P.PRODUCT_NAME,
  P.UNIT_ID,
  U.NAME,
  P.PRICE AS PRODUCT_PRICE,
  R.PRICE,
  R.QUANTITY,
  R.AMOUNT
 FROM V_GOODS_REGISTER R
 INNER JOIN GOODS G ON G.ID = R.GOODS_ID
 INNER JOIN V_PRODUCT P ON P.ID = G.ID
 INNER JOIN UNIT U ON U.ID = P.UNIT_ID;

CREATE VIEW V_RPT_GOODS_SALE (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_ID,
  DOCUMENT_CODE,
  DOCUMENT_DATE,
  DOCUMENT_YEAR,
  DOCUMENT_MONTH,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRODUCT_PRICE,
  PRICE,
  ITEM_PRICE,
  QUANTITY,
  AMOUNT,
  DOCUMENT_AMOUNT,
  WAREHOUSE_ID,
  WAREHOUSE_NAME,
  PARTNER_ID,
  PARTNER_NAME
) AS
SELECT
  S.PERIOD_ID,
  S.ORGANIZATION_ID,
  S.DOCUMENT_ID,
  S.DOCUMENT_CODE,
  S.DOCUMENT_DATE,
  S.DOCUMENT_YEAR,
  S.DOCUMENT_MONTH,
  S.PRODUCT_ID,
  S.PRODUCT_CODE,
  S.PRODUCT_NAME,
  S.ITEM_UNIT_ID,
  S.UNIT_ID,
  S.UNIT_NAME,
  S.PRODUCT_PRICE,
  S.PRICE,
  S.ITEM_PRICE,
  S.QUANTITY,
  S.AMOUNT,
  S.DOCUMENT_AMOUNT,
  WRH.WAREHOUSE_ID,
  WRH.WAREHOUSE_NAME,
  PRT.PARTNER_ID,
  PRT.PARTNER_NAME
 FROM V_GOODS_SALE S
 INNER JOIN V_WAREHOUSE_MOVE WRH ON WRH.DOCUMENT_ID = S.DOCUMENT_ID
 INNER JOIN V_PARTNER_MOVE PRT ON PRT.DOCUMENT_ID = S.DOCUMENT_ID;

/* 
   MYSQL IMPLEMENTATION 
 
   USE VIEWS
*/

/* CREATE VIEWS BY MONTH (TEST/DEMO) */

/* 01 MONTH JAN */
CREATE VIEW V_RPT_GOODS_SALE_MONTH_01 (
    PERIOD_ID,
    ORGANIZATION_ID,
    DOCUMENT_DATE,
    DOCUMENT_YEAR,
    DOCUMENT_MONTH,
    PRODUCT_ID,
    PRODUCT_CODE,
    PRODUCT_NAME,
    ITEM_UNIT_ID,
    UNIT_ID,
    UNIT_NAME,
    PRODUCT_PRICE,
    PRICE,
    ITEM_PRICE,
    Q01,
    Q02,
    Q03,
    Q04,
    Q05,
    Q06,
    Q07,
    Q08,
    Q09,
    Q10,
    Q11,
    Q12,
    S01,
    S02,
    S03,
    S04,
    S05,
    S06,
    S07,
    S08,
    S09,
    S10,
    S11,
    S12)
AS
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  R.QUANTITY AS Q01, 0.0 AS Q02, 0.0 AS Q03, 0.0 AS Q04, 0.0 AS Q05, 0.0 AS Q06, 0.0 AS Q07, 0.0 AS Q08, 0.0 AS Q09, 0.0 AS Q10, 0.0 AS Q11, 0.0 AS Q12, 
  R.AMOUNT AS S01,   0.0 AS S02, 0.0 AS S03, 0.0 AS S04, 0.0 AS S05, 0.0 AS S06, 0.0 AS S07, 0.0 AS S08, 0.0 AS S09, 0.0 AS S10, 0.0 AS S11, 0.0 AS S12 
 FROM V_GOODS_SALE R
 WHERE R.DOCUMENT_MONTH = 1;


/* 02 MONTH FEB */
CREATE VIEW V_RPT_GOODS_SALE_MONTH_02 (
    PERIOD_ID,
    ORGANIZATION_ID,
    DOCUMENT_DATE,
    DOCUMENT_YEAR,
    DOCUMENT_MONTH,
    PRODUCT_ID,
    PRODUCT_CODE,
    PRODUCT_NAME,
    ITEM_UNIT_ID,
    UNIT_ID,
    UNIT_NAME,
    PRODUCT_PRICE,
    PRICE,
    ITEM_PRICE,
    Q01,
    Q02,
    Q03,
    Q04,
    Q05,
    Q06,
    Q07,
    Q08,
    Q09,
    Q10,
    Q11,
    Q12,
    S01,
    S02,
    S03,
    S04,
    S05,
    S06,
    S07,
    S08,
    S09,
    S10,
    S11,
    S12)
AS
SELECT
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  0.0 AS Q01, R.QUANTITY AS Q02, 0.0 AS Q03, 0.0 AS Q04, 0.0 AS Q05, 0.0 AS Q06, 0.0 AS Q07, 0.0 AS Q08, 0.0 AS Q09, 0.0 AS Q10, 0.0 AS Q11, 0.0 AS Q12, 
  0.0 AS S01, R.AMOUNT AS S02, 0.0 AS S03, 0.0 AS S04, 0.0 AS S05, 0.0 AS S06, 0.0 AS S07, 0.0 AS S08, 0.0 AS S09, 0.0 AS S10, 0.0 AS S11, 0.0 AS S12 
 FROM V_GOODS_SALE R
 WHERE R.DOCUMENT_MONTH = 2;

/* 03 MONTH MAR */
CREATE VIEW V_RPT_GOODS_SALE_MONTH_03 (
    PERIOD_ID,
    ORGANIZATION_ID,
    DOCUMENT_DATE,
    DOCUMENT_YEAR,
    DOCUMENT_MONTH,
    PRODUCT_ID,
    PRODUCT_CODE,
    PRODUCT_NAME,
    ITEM_UNIT_ID,
    UNIT_ID,
    UNIT_NAME,
    PRODUCT_PRICE,
    PRICE,
    ITEM_PRICE,
    Q01,
    Q02,
    Q03,
    Q04,
    Q05,
    Q06,
    Q07,
    Q08,
    Q09,
    Q10,
    Q11,
    Q12,
    S01,
    S02,
    S03,
    S04,
    S05,
    S06,
    S07,
    S08,
    S09,
    S10,
    S11,
    S12)
AS


SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  0.0 AS Q01, 0.0 AS Q02, R.QUANTITY AS Q03, 0.0 AS Q04, 0.0 AS Q05, 0.0 AS Q06, 0.0 AS Q07, 0.0 AS Q08, 0.0 AS Q09, 0.0 AS Q10, 0.0 AS Q11, 0.0 AS Q12, 
  0.0 AS S01, 0.0 AS S02, R.AMOUNT AS S03, 0.0 AS S04, 0.0 AS S05, 0.0 AS S06, 0.0 AS S07, 0.0 AS S08, 0.0 AS S09, 0.0 AS S10, 0.0 AS S11, 0.0 AS S12 
 FROM V_GOODS_SALE R
 WHERE R.DOCUMENT_MONTH = 3;

/* 04 MONTH APR */
CREATE VIEW V_RPT_GOODS_SALE_MONTH_04 (
    PERIOD_ID,
    ORGANIZATION_ID,
    DOCUMENT_DATE,
    DOCUMENT_YEAR,
    DOCUMENT_MONTH,
    PRODUCT_ID,
    PRODUCT_CODE,
    PRODUCT_NAME,
    ITEM_UNIT_ID,
    UNIT_ID,
    UNIT_NAME,
    PRODUCT_PRICE,
    PRICE,
    ITEM_PRICE,
    Q01,
    Q02,
    Q03,
    Q04,
    Q05,
    Q06,
    Q07,
    Q08,
    Q09,
    Q10,
    Q11,
    Q12,
    S01,
    S02,
    S03,
    S04,
    S05,
    S06,
    S07,
    S08,
    S09,
    S10,
    S11,
    S12)
AS


SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  0.0 AS Q01, 0.0 AS Q02, 0.0 AS Q03, R.QUANTITY AS Q04, 0.0 AS Q05, 0.0 AS Q06, 0.0 AS Q07, 0.0 AS Q08, 0.0 AS Q09, 0.0 AS Q10, 0.0 AS Q11, 0.0 AS Q12, 
  0.0 AS S01, 0.0 AS S02, 0.0 AS S03, R.AMOUNT AS S04, 0.0 AS S05, 0.0 AS S06, 0.0 AS S07, 0.0 AS S08, 0.0 AS S09, 0.0 AS S10, 0.0 AS S11, 0.0 AS S12 
 FROM V_GOODS_SALE R
 WHERE R.DOCUMENT_MONTH = 4;

/* 05 MONTH MAY */
CREATE VIEW V_RPT_GOODS_SALE_MONTH_05 (
    PERIOD_ID,
    ORGANIZATION_ID,
    DOCUMENT_DATE,
    DOCUMENT_YEAR,
    DOCUMENT_MONTH,
    PRODUCT_ID,
    PRODUCT_CODE,
    PRODUCT_NAME,
    ITEM_UNIT_ID,
    UNIT_ID,
    UNIT_NAME,
    PRODUCT_PRICE,
    PRICE,
    ITEM_PRICE,
    Q01,
    Q02,
    Q03,
    Q04,
    Q05,
    Q06,
    Q07,
    Q08,
    Q09,
    Q10,
    Q11,
    Q12,
    S01,
    S02,
    S03,
    S04,
    S05,
    S06,
    S07,
    S08,
    S09,
    S10,
    S11,
    S12)
AS


SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  0.0 AS Q01, 0.0 AS Q02, 0.0 AS Q03, 0.0 AS Q04, R.QUANTITY AS Q05, 0.0 AS Q06, 0.0 AS Q07, 0.0 AS Q08, 0.0 AS Q09, 0.0 AS Q10, 0.0 AS Q11, 0.0 AS Q12, 
  0.0 AS S01, 0.0 AS S02, 0.0 AS S03, 0.0 AS S04, R.AMOUNT AS S05, 0.0 AS S06, 0.0 AS S07, 0.0 AS S08, 0.0 AS S09, 0.0 AS S10, 0.0 AS S11, 0.0 AS S12 
 FROM V_GOODS_SALE R
 WHERE R.DOCUMENT_MONTH = 5;

/* 06 MONTH JUN */
CREATE VIEW V_RPT_GOODS_SALE_MONTH_06 (
    PERIOD_ID,
    ORGANIZATION_ID,
    DOCUMENT_DATE,
    DOCUMENT_YEAR,
    DOCUMENT_MONTH,
    PRODUCT_ID,
    PRODUCT_CODE,
    PRODUCT_NAME,
    ITEM_UNIT_ID,
    UNIT_ID,
    UNIT_NAME,
    PRODUCT_PRICE,
    PRICE,
    ITEM_PRICE,
    Q01,
    Q02,
    Q03,
    Q04,
    Q05,
    Q06,
    Q07,
    Q08,
    Q09,
    Q10,
    Q11,
    Q12,
    S01,
    S02,
    S03,
    S04,
    S05,
    S06,
    S07,
    S08,
    S09,
    S10,
    S11,
    S12)
AS


SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  0.0 AS Q01, 0.0 AS Q02, 0.0 AS Q03, 0.0 AS Q04, 0.0 AS Q05, R.QUANTITY AS Q06, 0.0 AS Q07, 0.0 AS Q08, 0.0 AS Q09, 0.0 AS Q10, 0.0 AS Q11, 0.0 AS Q12, 
  0.0 AS S01, 0.0 AS S02, 0.0 AS S03, 0.0 AS S04, 0.0 AS S05, R.AMOUNT AS S06, 0.0 AS S07, 0.0 AS S08, 0.0 AS S09, 0.0 AS S10, 0.0 AS S11, 0.0 AS S12 
 FROM V_GOODS_SALE R
 WHERE R.DOCUMENT_MONTH = 6;

/* 07 MONTH JUL */
CREATE VIEW V_RPT_GOODS_SALE_MONTH_07 (
    PERIOD_ID,
    ORGANIZATION_ID,
    DOCUMENT_DATE,
    DOCUMENT_YEAR,
    DOCUMENT_MONTH,
    PRODUCT_ID,
    PRODUCT_CODE,
    PRODUCT_NAME,
    ITEM_UNIT_ID,
    UNIT_ID,
    UNIT_NAME,
    PRODUCT_PRICE,
    PRICE,
    ITEM_PRICE,
    Q01,
    Q02,
    Q03,
    Q04,
    Q05,
    Q06,
    Q07,
    Q08,
    Q09,
    Q10,
    Q11,
    Q12,
    S01,
    S02,
    S03,
    S04,
    S05,
    S06,
    S07,
    S08,
    S09,
    S10,
    S11,
    S12)
AS


SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  0.0 AS Q01, 0.0 AS Q02, 0.0 AS Q03, 0.0 AS Q04, 0.0 AS Q05, 0.0 AS Q06, R.QUANTITY AS Q07, 0.0 AS Q08, 0.0 AS Q09, 0.0 AS Q10, 0.0 AS Q11, 0.0 AS Q12, 
  0.0 AS S01, 0.0 AS S02, 0.0 AS S03, 0.0 AS S04, 0.0 AS S05, 0.0 AS S06, R.AMOUNT AS S07, 0.0 AS S08, 0.0 AS S09, 0.0 AS S10, 0.0 AS S11, 0.0 AS S12 
 FROM V_GOODS_SALE R
 WHERE R.DOCUMENT_MONTH = 7;

/* 08 MONTH AUG */
CREATE VIEW V_RPT_GOODS_SALE_MONTH_08 (
    PERIOD_ID,
    ORGANIZATION_ID,
    DOCUMENT_DATE,
    DOCUMENT_YEAR,
    DOCUMENT_MONTH,
    PRODUCT_ID,
    PRODUCT_CODE,
    PRODUCT_NAME,
    ITEM_UNIT_ID,
    UNIT_ID,
    UNIT_NAME,
    PRODUCT_PRICE,
    PRICE,
    ITEM_PRICE,
    Q01,
    Q02,
    Q03,
    Q04,
    Q05,
    Q06,
    Q07,
    Q08,
    Q09,
    Q10,
    Q11,
    Q12,
    S01,
    S02,
    S03,
    S04,
    S05,
    S06,
    S07,
    S08,
    S09,
    S10,
    S11,
    S12)
AS


SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  0.0 AS Q01, 0.0 AS Q02, 0.0 AS Q03, 0.0 AS Q04, 0.0 AS Q05, 0.0 AS Q06, 0.0 AS Q07, R.QUANTITY AS Q08, 0.0 AS Q09, 0.0 AS Q10, 0.0 AS Q11, 0.0 AS Q12, 
  0.0 AS S01, 0.0 AS S02, 0.0 AS S03, 0.0 AS S04, 0.0 AS S05, 0.0 AS S06, 0.0 AS S07, R.AMOUNT AS S08, 0.0 AS S09, 0.0 AS S10, 0.0 AS S11, 0.0 AS S12 
 FROM V_GOODS_SALE R
 WHERE R.DOCUMENT_MONTH = 8;

/* 09 MONTH SEP */
CREATE VIEW V_RPT_GOODS_SALE_MONTH_09 (
    PERIOD_ID,
    ORGANIZATION_ID,
    DOCUMENT_DATE,
    DOCUMENT_YEAR,
    DOCUMENT_MONTH,
    PRODUCT_ID,
    PRODUCT_CODE,
    PRODUCT_NAME,
    ITEM_UNIT_ID,
    UNIT_ID,
    UNIT_NAME,
    PRODUCT_PRICE,
    PRICE,
    ITEM_PRICE,
    Q01,
    Q02,
    Q03,
    Q04,
    Q05,
    Q06,
    Q07,
    Q08,
    Q09,
    Q10,
    Q11,
    Q12,
    S01,
    S02,
    S03,
    S04,
    S05,
    S06,
    S07,
    S08,
    S09,
    S10,
    S11,
    S12)
AS


SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  0.0 AS Q01, 0.0 AS Q02, 0.0 AS Q03, 0.0 AS Q04, 0.0 AS Q05, 0.0 AS Q06, 0.0 AS Q07, 0.0 AS Q08, R.QUANTITY AS Q09, 0.0 AS Q10, 0.0 AS Q11, 0.0 AS Q12, 
  0.0 AS S01, 0.0 AS S02, 0.0 AS S03, 0.0 AS S04, 0.0 AS S05, 0.0 AS S06, 0.0 AS S07, 0.0 AS S08, R.AMOUNT AS S09, 0.0 AS S10, 0.0 AS S11, 0.0 AS S12 
 FROM V_GOODS_SALE R
 WHERE R.DOCUMENT_MONTH = 9;

/* 10 MONTH OCT */
CREATE VIEW V_RPT_GOODS_SALE_MONTH_10 (
    PERIOD_ID,
    ORGANIZATION_ID,
    DOCUMENT_DATE,
    DOCUMENT_YEAR,
    DOCUMENT_MONTH,
    PRODUCT_ID,
    PRODUCT_CODE,
    PRODUCT_NAME,
    ITEM_UNIT_ID,
    UNIT_ID,
    UNIT_NAME,
    PRODUCT_PRICE,
    PRICE,
    ITEM_PRICE,
    Q01,
    Q02,
    Q03,
    Q04,
    Q05,
    Q06,
    Q07,
    Q08,
    Q09,
    Q10,
    Q11,
    Q12,
    S01,
    S02,
    S03,
    S04,
    S05,
    S06,
    S07,
    S08,
    S09,
    S10,
    S11,
    S12)
AS


SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  0.0 AS Q01, 0.0 AS Q02, 0.0 AS Q03, 0.0 AS Q04, 0.0 AS Q05, 0.0 AS Q06, 0.0 AS Q07, 0.0 AS Q08, 0.0 AS Q09, R.QUANTITY AS Q10, 0.0 AS Q11, 0.0 AS Q12, 
  0.0 AS S01, 0.0 AS S02, 0.0 AS S03, 0.0 AS S04, 0.0 AS S05, 0.0 AS S06, 0.0 AS S07, 0.0 AS S08, 0.0 AS S09, R.AMOUNT AS S10, 0.0 AS S11, 0.0 AS S12 
 FROM V_GOODS_SALE R
 WHERE R.DOCUMENT_MONTH = 10;

/* 11 MONTH NOV */
CREATE VIEW V_RPT_GOODS_SALE_MONTH_11 (
    PERIOD_ID,
    ORGANIZATION_ID,
    DOCUMENT_DATE,
    DOCUMENT_YEAR,
    DOCUMENT_MONTH,
    PRODUCT_ID,
    PRODUCT_CODE,
    PRODUCT_NAME,
    ITEM_UNIT_ID,
    UNIT_ID,
    UNIT_NAME,
    PRODUCT_PRICE,
    PRICE,
    ITEM_PRICE,
    Q01,
    Q02,
    Q03,
    Q04,
    Q05,
    Q06,
    Q07,
    Q08,
    Q09,
    Q10,
    Q11,
    Q12,
    S01,
    S02,
    S03,
    S04,
    S05,
    S06,
    S07,
    S08,
    S09,
    S10,
    S11,
    S12)
AS


SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  0.0 AS Q01, 0.0 AS Q02, 0.0 AS Q03, 0.0 AS Q04, 0.0 AS Q05, 0.0 AS Q06, 0.0 AS Q07, 0.0 AS Q08, 0.0 AS Q09, 0.0 AS Q10, R.QUANTITY AS Q11, 0.0 AS Q12, 
  0.0 AS S01, 0.0 AS S02, 0.0 AS S03, 0.0 AS S04, 0.0 AS S05, 0.0 AS S06, 0.0 AS S07, 0.0 AS S08, 0.0 AS S09, 0.0 AS S10, R.AMOUNT AS S11, 0.0 AS S12 
 FROM V_GOODS_SALE R
 WHERE R.DOCUMENT_MONTH = 11;

/* 12 MONTH DEC */
CREATE VIEW V_RPT_GOODS_SALE_MONTH_12 (
    PERIOD_ID,
    ORGANIZATION_ID,
    DOCUMENT_DATE,
    DOCUMENT_YEAR,
    DOCUMENT_MONTH,
    PRODUCT_ID,
    PRODUCT_CODE,
    PRODUCT_NAME,
    ITEM_UNIT_ID,
    UNIT_ID,
    UNIT_NAME,
    PRODUCT_PRICE,
    PRICE,
    ITEM_PRICE,
    Q01,
    Q02,
    Q03,
    Q04,
    Q05,
    Q06,
    Q07,
    Q08,
    Q09,
    Q10,
    Q11,
    Q12,
    S01,
    S02,
    S03,
    S04,
    S05,
    S06,
    S07,
    S08,
    S09,
    S10,
    S11,
    S12)
AS


SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.DOCUMENT_DATE,
  R.DOCUMENT_YEAR,
  R.DOCUMENT_MONTH,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.ITEM_UNIT_ID,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.PRODUCT_PRICE,
  R.PRICE,
  R.ITEM_PRICE,
  0.0 AS Q01, 0.0 AS Q02, 0.0 AS Q03, 0.0 AS Q04, 0.0 AS Q05, 0.0 AS Q06, 0.0 AS Q07, 0.0 AS Q08, 0.0 AS Q09, 0.0 AS Q10, 0.0 AS Q11, R.QUANTITY AS Q12, 
  0.0 AS S01, 0.0 AS S02, 0.0 AS S03, 0.0 AS S04, 0.0 AS S05, 0.0 AS S06, 0.0 AS S07, 0.0 AS S08, 0.0 AS S09, 0.0 AS S10, 0.0 AS S11, R.AMOUNT AS S12 
 FROM V_GOODS_SALE R
 WHERE R.DOCUMENT_MONTH = 12;




/* CREATE VIEW SALES BY MONTHES */

CREATE VIEW V_RPT_GOODS_SALE_YEAR_PRODUCT (
    PERIOD_ID,
    ORGANIZATION_ID,
    DOCUMENT_DATE,
    DOCUMENT_YEAR,
    DOCUMENT_MONTH,
    PRODUCT_ID,
    PRODUCT_CODE,
    PRODUCT_NAME,
    ITEM_UNIT_ID,
    UNIT_ID,
    UNIT_NAME,
    PRODUCT_PRICE,
    PRICE,
    ITEM_PRICE,
    Q01,
    Q02,
    Q03,
    Q04,
    Q05,
    Q06,
    Q07,
    Q08,
    Q09,
    Q10,
    Q11,
    Q12,
    S01,
    S02,
    S03,
    S04,
    S05,
    S06,
    S07,
    S08,
    S09,
    S10,
    S11,
    S12)
AS
SELECT 
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_DATE,
  DOCUMENT_YEAR,
  DOCUMENT_MONTH,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRODUCT_PRICE,
  PRICE,
  ITEM_PRICE,
  Q01, Q02, Q03, Q04, Q05, Q06, Q07, Q08, Q09, Q10, Q11, Q12,
  S01, S02, S03, S04, S05, S06, S07, S08, S09, S10, S11, S12
 FROM V_RPT_GOODS_SALE_MONTH_01 R

UNION ALL

SELECT 
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_DATE,
  DOCUMENT_YEAR,
  DOCUMENT_MONTH,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRODUCT_PRICE,
  PRICE,
  ITEM_PRICE,
  Q01, Q02, Q03, Q04, Q05, Q06, Q07, Q08, Q09, Q10, Q11, Q12,
  S01, S02, S03, S04, S05, S06, S07, S08, S09, S10, S11, S12
 FROM V_RPT_GOODS_SALE_MONTH_02 R

UNION ALL

SELECT 
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_DATE,
  DOCUMENT_YEAR,
  DOCUMENT_MONTH,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRODUCT_PRICE,
  PRICE,
  ITEM_PRICE,
  Q01, Q02, Q03, Q04, Q05, Q06, Q07, Q08, Q09, Q10, Q11, Q12,
  S01, S02, S03, S04, S05, S06, S07, S08, S09, S10, S11, S12
 FROM V_RPT_GOODS_SALE_MONTH_03 R

UNION ALL

SELECT 
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_DATE,
  DOCUMENT_YEAR,
  DOCUMENT_MONTH,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRODUCT_PRICE,
  PRICE,
  ITEM_PRICE,
  Q01, Q02, Q03, Q04, Q05, Q06, Q07, Q08, Q09, Q10, Q11, Q12,
  S01, S02, S03, S04, S05, S06, S07, S08, S09, S10, S11, S12
 FROM V_RPT_GOODS_SALE_MONTH_04 R

UNION ALL

SELECT 
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_DATE,
  DOCUMENT_YEAR,
  DOCUMENT_MONTH,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRODUCT_PRICE,
  PRICE,
  ITEM_PRICE,
  Q01, Q02, Q03, Q04, Q05, Q06, Q07, Q08, Q09, Q10, Q11, Q12,
  S01, S02, S03, S04, S05, S06, S07, S08, S09, S10, S11, S12
 FROM V_RPT_GOODS_SALE_MONTH_05 R

UNION ALL

SELECT 
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_DATE,
  DOCUMENT_YEAR,
  DOCUMENT_MONTH,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRODUCT_PRICE,
  PRICE,
  ITEM_PRICE,
  Q01, Q02, Q03, Q04, Q05, Q06, Q07, Q08, Q09, Q10, Q11, Q12,
  S01, S02, S03, S04, S05, S06, S07, S08, S09, S10, S11, S12
 FROM V_RPT_GOODS_SALE_MONTH_06 R

UNION ALL

SELECT 
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_DATE,
  DOCUMENT_YEAR,
  DOCUMENT_MONTH,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRODUCT_PRICE,
  PRICE,
  ITEM_PRICE,
  Q01, Q02, Q03, Q04, Q05, Q06, Q07, Q08, Q09, Q10, Q11, Q12,
  S01, S02, S03, S04, S05, S06, S07, S08, S09, S10, S11, S12
 FROM V_RPT_GOODS_SALE_MONTH_07 R

UNION ALL

SELECT 
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_DATE,
  DOCUMENT_YEAR,
  DOCUMENT_MONTH,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRODUCT_PRICE,
  PRICE,
  ITEM_PRICE,
  Q01, Q02, Q03, Q04, Q05, Q06, Q07, Q08, Q09, Q10, Q11, Q12,
  S01, S02, S03, S04, S05, S06, S07, S08, S09, S10, S11, S12
 FROM V_RPT_GOODS_SALE_MONTH_08 R

UNION ALL

SELECT 
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_DATE,
  DOCUMENT_YEAR,
  DOCUMENT_MONTH,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRODUCT_PRICE,
  PRICE,
  ITEM_PRICE,
  Q01, Q02, Q03, Q04, Q05, Q06, Q07, Q08, Q09, Q10, Q11, Q12,
  S01, S02, S03, S04, S05, S06, S07, S08, S09, S10, S11, S12
 FROM V_RPT_GOODS_SALE_MONTH_09 R

UNION ALL

SELECT 
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_DATE,
  DOCUMENT_YEAR,
  DOCUMENT_MONTH,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRODUCT_PRICE,
  PRICE,
  ITEM_PRICE,
  Q01, Q02, Q03, Q04, Q05, Q06, Q07, Q08, Q09, Q10, Q11, Q12,
  S01, S02, S03, S04, S05, S06, S07, S08, S09, S10, S11, S12
 FROM V_RPT_GOODS_SALE_MONTH_10 R

UNION ALL

SELECT 
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_DATE,
  DOCUMENT_YEAR,
  DOCUMENT_MONTH,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRODUCT_PRICE,
  PRICE,
  ITEM_PRICE,
  Q01, Q02, Q03, Q04, Q05, Q06, Q07, Q08, Q09, Q10, Q11, Q12,
  S01, S02, S03, S04, S05, S06, S07, S08, S09, S10, S11, S12
 FROM V_RPT_GOODS_SALE_MONTH_11 R

UNION ALL

SELECT 
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_DATE,
  DOCUMENT_YEAR,
  DOCUMENT_MONTH,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRODUCT_PRICE,
  PRICE,
  ITEM_PRICE,
  Q01, Q02, Q03, Q04, Q05, Q06, Q07, Q08, Q09, Q10, Q11, Q12,
  S01, S02, S03, S04, S05, S06, S07, S08, S09, S10, S11, S12
 FROM V_RPT_GOODS_SALE_MONTH_12 R;






/* SALES BY MONTHES (JAN - DEC) */

CREATE VIEW V_RPT_GOODS_SALE_YEAR (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_DATE,
  DOCUMENT_YEAR,
  DOCUMENT_MONTH,
  S01,
  S02,
  S03,
  S04,
  S05,
  S06,
  S07,
  S08,
  S09,
  S10,
  S11,
  S12 
) AS
SELECT
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_DATE,
  DOCUMENT_YEAR,
  DOCUMENT_MONTH,
  S01,
  S02,
  S03,
  S04,
  S05,
  S06,
  S07,
  S08,
  S09,
  S10,
  S11,
  S12 
FROM V_RPT_GOODS_SALE_YEAR_PRODUCT;


CREATE VIEW V_RPT_WRH_GOODS_REGISTER (
  PERIOD_ID,
  ORGANIZATION_ID,
  GOODS_ID,
  WAREHOUSE_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  UNIT_ID,
  UNIT_NAME,
  PRODUCT_PRICE,
  QUANTITY,
  AMOUNT
) AS
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.GOODS_ID,
  R.WAREHOUSE_ID,
  P.PRODUCT_CODE,
  P.PRODUCT_NAME,
  P.UNIT_ID,
  U.NAME AS UNIT_NAME,
  P.PRICE,
  R.QUANTITY,
  R.AMOUNT
 FROM V_GOODS_DETAIL_REGISTER R
 INNER JOIN GOODS G ON G.ID = R.GOODS_ID
 INNER JOIN V_PRODUCT P ON P.ID = G.ID
 INNER JOIN UNIT U ON U.ID = P.UNIT_ID;



CREATE VIEW V_GOODS_CREDIT_FULL (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_CODE,
  DOCUMENT_DATE,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRODUCT_PRICE,
  QUANTITY,
  AMOUNT
) AS
SELECT 
  FD.PERIOD_ID,
  FD.ORGANIZATION_ID,
  FD.DOCUMENT_CODE,
  FD.DOCUMENT_DATE,
  I.PRODUCT_ID,
  I.PRODUCT_CODE,
  I.PRODUCT_NAME,
  I.ITEM_UNIT_ID,
  I.UNIT_ID,
  I.UNIT_NAME,
  I.ITEM_PRICE AS ITEM_PRICE,
  I.ACCOUNT_QUANTITY AS QUANTITY,
  I.ITEM_AMOUNT AS AMOUNT
 FROM V_PRODUCT_MOVE I
 INNER JOIN V_FINANCE_DOCUMENT FD ON FD.ID = I.DOCUMENT_ID
 INNER JOIN WAREHOUSE_MOVE STO ON STO.OWNER_ID = FD.ID
 INNER JOIN DOCUMENT_TYPE T ON T.ID = FD.DOCUMENT_TYPE_ID  AND (T.DOCUMENT_SECTION = 'GOODS' OR T.DOCUMENT_SECTION = 'INVENTORY')
 INNER JOIN FINANCE_DOCUMENT_TYPE FT ON T.ID = FT.DOCUMENT_TYPE_ID 
  AND (FT.MOVE_TYPE = 'INPUT' OR (FT.MOVE_TYPE = 'ROTATE' AND STO.MOVE_TYPE = 'INPUT'));
 



CREATE VIEW V_GOODS_DEBIT_FULL (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_CODE,
  DOCUMENT_DATE,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRODUCT_PRICE,
  QUANTITY,
  AMOUNT
) AS
SELECT 
  FD.PERIOD_ID,
  FD.ORGANIZATION_ID,
  FD.DOCUMENT_CODE,
  FD.DOCUMENT_DATE,
  I.PRODUCT_ID,
  I.PRODUCT_CODE,
  I.PRODUCT_NAME,
  I.ITEM_UNIT_ID,
  I.UNIT_ID,
  I.UNIT_NAME,
  I.ITEM_PRICE AS ITEM_PRICE,
  I.ACCOUNT_QUANTITY AS QUANTITY,
  I.ITEM_AMOUNT AS AMOUNT
 FROM V_PRODUCT_MOVE I
 INNER JOIN V_FINANCE_DOCUMENT FD ON FD.ID = I.DOCUMENT_ID
 INNER JOIN WAREHOUSE_MOVE STO ON STO.OWNER_ID = FD.ID
 INNER JOIN DOCUMENT_TYPE T ON T.ID = FD.DOCUMENT_TYPE_ID  AND (T.DOCUMENT_SECTION = 'GOODS' OR T.DOCUMENT_SECTION = 'INVENTORY')
 INNER JOIN FINANCE_DOCUMENT_TYPE FT ON T.ID = FT.DOCUMENT_TYPE_ID 
  AND (FT.MOVE_TYPE = 'OUTPUT' OR (FT.MOVE_TYPE = 'ROTATE' AND STO.MOVE_TYPE = 'OUTPUT'));
 



CREATE VIEW V_RPT_GOODS_REST_START (
  PERIOD_ID,
  ORGANIZATION_ID,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  UNIT_ID,
  UNIT_NAME,
  QUANTITY,
  AMOUNT
) AS
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.GOODS_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.QUANTITY,
  R.AMOUNT
 FROM V_RPT_GOODS_REGISTER R
UNION ALL
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.QUANTITY,
  R.AMOUNT
 FROM V_RPT_GOODS_REST R;


CREATE VIEW V_RPT_WRH_GOODS_REST_START (
  PERIOD_ID,
  ORGANIZATION_ID,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  UNIT_ID,
  UNIT_NAME,
  QUANTITY,
  AMOUNT,
  WAREHOUSE_ID
) AS
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.GOODS_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.QUANTITY,
  R.AMOUNT,
  R.WAREHOUSE_ID
 FROM V_RPT_WRH_GOODS_REGISTER R
UNION ALL
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.PRODUCT_ID,
  R.PRODUCT_CODE,
  R.PRODUCT_NAME,
  R.UNIT_ID,
  R.UNIT_NAME,
  R.QUANTITY,
  R.AMOUNT,
  R.WAREHOUSE_ID
 FROM V_RPT_GOODS_REST R;



CREATE VIEW V_RPT_GOODS_CREDIT_FULL (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_CODE,
  DOCUMENT_DATE,
  WAREHOUSE_ID,
  PARTNER_ID,
  RESPONSIBLE_ID,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRODUCT_PRICE,
  QUANTITY,
  AMOUNT
) AS
SELECT 
  FD.PERIOD_ID,
  FD.ORGANIZATION_ID,
  FD.DOCUMENT_CODE,
  FD.DOCUMENT_DATE,
  STO.WAREHOUSE_ID,
  PRT.PARTNER_ID,
  NULL AS RESPONSIBLE_ID,
  I.PRODUCT_ID,
  I.PRODUCT_CODE,
  I.PRODUCT_NAME,
  I.ITEM_UNIT_ID,
  I.UNIT_ID,
  I.UNIT_NAME,
  I.ITEM_PRICE AS ITEM_PRICE,
  I.ACCOUNT_QUANTITY AS QUANTITY,
  I.ITEM_AMOUNT AS AMOUNT
 FROM V_PRODUCT_MOVE I
 INNER JOIN V_FINANCE_DOCUMENT FD ON FD.ID = I.DOCUMENT_ID
 INNER JOIN WAREHOUSE_MOVE STO ON STO.OWNER_ID = FD.ID
 LEFT JOIN PARTNER_MOVE PRT ON PRT.OWNER_ID = FD.ID
 INNER JOIN DOCUMENT_TYPE T ON T.ID = FD.DOCUMENT_TYPE_ID  AND (T.DOCUMENT_SECTION = 'GOODS' OR T.DOCUMENT_SECTION = 'INVENTORY')
 INNER JOIN FINANCE_DOCUMENT_TYPE FT ON T.ID = FT.DOCUMENT_TYPE_ID 
  AND (FT.MOVE_TYPE = 'INPUT' OR (FT.MOVE_TYPE = 'ROTATE' AND STO.MOVE_TYPE = 'INPUT'));
 



CREATE VIEW V_RPT_GOODS_DEBIT_FULL (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_CODE,
  DOCUMENT_DATE,
  WAREHOUSE_ID,
  PARTNER_ID,
  RESPONSIBLE_ID,
  PRODUCT_ID,
  PRODUCT_CODE,
  PRODUCT_NAME,
  ITEM_UNIT_ID,
  UNIT_ID,
  UNIT_NAME,
  PRODUCT_PRICE,
  QUANTITY,
  AMOUNT
) AS
SELECT 
  FD.PERIOD_ID,
  FD.ORGANIZATION_ID,
  FD.DOCUMENT_CODE,
  FD.DOCUMENT_DATE,
  STO.WAREHOUSE_ID,
  PRT.PARTNER_ID,
  NULL AS RESPONSIBLE_ID,
  I.PRODUCT_ID,
  I.PRODUCT_CODE,
  I.PRODUCT_NAME,
  I.ITEM_UNIT_ID,
  I.UNIT_ID,
  I.UNIT_NAME,
  I.ITEM_PRICE AS ITEM_PRICE,
  I.ACCOUNT_QUANTITY AS QUANTITY,
  I.ITEM_AMOUNT AS AMOUNT
 FROM V_PRODUCT_MOVE I
 INNER JOIN V_FINANCE_DOCUMENT FD ON FD.ID = I.DOCUMENT_ID
 INNER JOIN WAREHOUSE_MOVE STO ON STO.OWNER_ID = FD.ID
 LEFT JOIN PARTNER_MOVE PRT ON PRT.OWNER_ID = FD.ID
 INNER JOIN DOCUMENT_TYPE T ON T.ID = FD.DOCUMENT_TYPE_ID  AND (T.DOCUMENT_SECTION = 'GOODS' OR T.DOCUMENT_SECTION = 'INVENTORY')
 INNER JOIN FINANCE_DOCUMENT_TYPE FT ON T.ID = FT.DOCUMENT_TYPE_ID 
  AND (FT.MOVE_TYPE = 'OUTPUT' OR (FT.MOVE_TYPE = 'ROTATE' AND STO.MOVE_TYPE = 'OUTPUT'));
 



CREATE VIEW V_RPT_GOODS_ROTATE (
 ORGANIZATION_ID,
 PERIOD_ID, 
 PRODUCT_ID, 
 REST_QUANTITY,
 REST_AMOUNT, 
 CREDIT_QUANTITY,
 CREDIT_AMOUNT,
 DEBIT_QUANTITY,
 DEBIT_AMOUNT
) AS
SELECT R.ORGANIZATION_ID, R.PERIOD_ID, 
 R.PRODUCT_ID, R.QUANTITY AS REST_QUANTITY, R.AMOUNT AS REST_AMOUNT, 
 0.0 AS CREDIT_QUANTITY, 0.0 AS CREDIT_AMOUNT,
 0.0 AS DEBIT_QUANTITY, 0.0 AS DEBIT_AMOUNT 
 FROM V_RPT_GOODS_REST_START R
UNION ALL 
SELECT D.ORGANIZATION_ID, D.PERIOD_ID, 
 D.PRODUCT_ID, 0.0 AS REST_QUANTITY, 0.0 AS REST_AMOUNT, 
 D.QUANTITY AS CREDIT_QUANTITY, D.AMOUNT AS CREDIT_AMOUNT,
 0.0 AS DEBIT_QUANTITY, 0.0 AS DEBIT_AMOUNT
 FROM V_GOODS_CREDIT_FULL D
UNION ALL 
SELECT C.ORGANIZATION_ID, C.PERIOD_ID, 
 C.PRODUCT_ID, 0.0 AS REST_QUANTITY, 0.0 AS REST_AMOUNT, 
 0.0 AS CREDIT_QUANTITY, 0.0 AS CREDIT_AMOUNT,
 C.QUANTITY AS DEBIT_QUANTITY, C.AMOUNT AS DEBIT_AMOUNT
 FROM V_GOODS_DEBIT_FULL C;

CREATE VIEW V_PARTNER_REST (
 ID,
 PERIOD_ID,
 ORGANIZATION_ID,
 PARTNER_ID,
 DEBIT_AMOUNT,
 CREDIT_AMOUNT
) AS
SELECT
 ID,
 PERIOD_ID,
 ORGANIZATION_ID,
 PARTNER_ID,
 DEBIT_AMOUNT,
 CREDIT_AMOUNT
FROM
 PARTNER_REST;

CREATE VIEW V_RPT_PARTNER_REGISTER (
  PERIOD_ID,
  ORGANIZATION_ID,
  PARTNER_ID,
  PARTNER_NAME,
  DEBIT_AMOUNT,
  CREDIT_AMOUNT
) AS
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.PARTNER_ID,
  P.NAME AS PARTNER_NAME,
  R.DEBIT_AMOUNT,
  R.CREDIT_AMOUNT
 FROM V_PARTNER_REGISTER R
 INNER JOIN PARTNER P ON P.ID = R.PARTNER_ID;

CREATE VIEW V_RPT_PARTNER_REST (
  PERIOD_ID,
  ORGANIZATION_ID,
  PARTNER_ID,
  PARTNER_NAME,
  DEBIT_AMOUNT,
  CREDIT_AMOUNT
) AS
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.PARTNER_ID,
  P.NAME AS PARTNER_NAME,
  R.DEBIT_AMOUNT,
  R.CREDIT_AMOUNT
 FROM V_PARTNER_REST R
 INNER JOIN PARTNER P ON P.ID = R.PARTNER_ID;

CREATE VIEW V_RPT_PARTNER_REST_START (
  PERIOD_ID,
  ORGANIZATION_ID,
  PARTNER_ID,
  PARTNER_NAME,
  CREDIT_AMOUNT,
  DEBIT_AMOUNT
) AS
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.PARTNER_ID,
  R.PARTNER_NAME,
  R.CREDIT_AMOUNT,
  R.DEBIT_AMOUNT
 FROM V_RPT_PARTNER_REGISTER R
UNION ALL
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.PARTNER_ID,
  R.PARTNER_NAME,
  R.CREDIT_AMOUNT,
  R.DEBIT_AMOUNT
 FROM V_RPT_PARTNER_REST R;

CREATE VIEW V_RPT_PARTNER_CREDIT_FULL (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_CODE,
  DOCUMENT_DATE,
  PARTNER_ID,
  AMOUNT
) AS
SELECT 
  FD.PERIOD_ID,
  FD.ORGANIZATION_ID,
  FD.DOCUMENT_CODE,
  FD.DOCUMENT_DATE,
  P.PARTNER_ID,
  FD.DOCUMENT_TOTAL
 FROM V_FINANCE_DOCUMENT FD
 INNER JOIN V_PARTNER_MOVE P ON FD.ID = P.DOCUMENT_ID
 INNER JOIN DOCUMENT_TYPE T ON T.ID = FD.DOCUMENT_TYPE_ID
 INNER JOIN FINANCE_DOCUMENT_TYPE FT ON T.ID = FT.DOCUMENT_TYPE_ID 
 WHERE T.DOCUMENT_SECTION = 'PAYMENT' AND FT.MOVE_TYPE = 'INPUT';


CREATE VIEW V_RPT_PARTNER_DEBIT_FULL (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_CODE,
  DOCUMENT_DATE,
  PARTNER_ID,
  AMOUNT
) AS
SELECT 
  FD.PERIOD_ID,
  FD.ORGANIZATION_ID,
  FD.DOCUMENT_CODE,
  FD.DOCUMENT_DATE,
  P.PARTNER_ID,
  FD.DOCUMENT_TOTAL
 FROM V_FINANCE_DOCUMENT FD
 INNER JOIN V_PARTNER_MOVE P ON FD.ID = P.DOCUMENT_ID
 INNER JOIN DOCUMENT_TYPE T ON T.ID = FD.DOCUMENT_TYPE_ID
 INNER JOIN FINANCE_DOCUMENT_TYPE FT ON T.ID = FT.DOCUMENT_TYPE_ID 
 WHERE T.DOCUMENT_SECTION = 'PAYMENT' AND FT.MOVE_TYPE = 'OUTPUT';


CREATE VIEW V_RPT_PARTNER_ROTATE (
 ORGANIZATION_ID,
 PERIOD_ID, 
 PARTNER_ID,
 REST_CREDIT_AMOUNT, 
 REST_DEBIT_AMOUNT, 
 CREDIT_AMOUNT,
 DEBIT_AMOUNT
) AS
SELECT 
 R.ORGANIZATION_ID,
 R.PERIOD_ID, 
 R.PARTNER_ID,
 R.CREDIT_AMOUNT AS REST_CREDIT_AMOUNT, 
 R.DEBIT_AMOUNT AS REST_DEBIT_AMOUNT, 
 0.0 AS CREDIT_AMOUNT,
 0.0 AS DEBIT_AMOUNT
FROM V_RPT_PARTNER_REST_START R
UNION ALL 
SELECT 
 C.ORGANIZATION_ID,
 C.PERIOD_ID, 
 C.PARTNER_ID,
 0.0 AS REST_CREDIT_AMOUNT, 
 0.0 AS REST_DEBIT_AMOUNT, 
 C.AMOUNT AS CREDIT_AMOUNT,
 0.0 AS DEBIT_AMOUNT
FROM V_RPT_PARTNER_CREDIT_FULL C
UNION ALL 
SELECT 
 D.ORGANIZATION_ID,
 D.PERIOD_ID, 
 D.PARTNER_ID,
 0.0 AS REST_CREDIT_AMOUNT, 
 0.0 AS REST_DEBIT_AMOUNT, 
 0.0 AS CREDIT_AMOUNT,
 D.AMOUNT AS DEBIT_AMOUNT
 FROM V_RPT_PARTNER_DEBIT_FULL D;

CREATE VIEW V_EMPLOYEE_RESULT (
 ID,
 EMPLOYEE_ID,
 EMPLOYEE_TOTAL_ID,
 ORGANIZATION_ID,
 PERIOD_ID,
 WORK_DAY,
 WORK_HOUR,
 TOTAL_DAY,
 TOTAL_HOUR,
 START_BALANCE,
 END_BALANCE,
 INCREMENT_AMOUNT,
 DECREMENT_AMOUNT,
 PAYROLL_AMOUNT,
 ACU_PENSION,
 ACU_TAX,
 ACU_VACATION,
 ACU_SICK,
 ACU_FUND_SALARY,
 ACU_FUND_HELP,
 ACU_FUND_INSURANCE,
 ACU_FUND_WORK,
 ACU_SALARY13,
 ACU_SALARY12,
 ACU_ADD_PAY,
 OVERTIME_DAY,
 OVERTIME_HOUR,
 NIGHT_DAY,
 NIGHT_HOUR,
 HOLIDAY_DAY,
 HOLIDAY_HOUR,
 PREV_VACATION_AMOUNT,
 PREV_SICK_AMOUNT
) AS
SELECT 
 E.ID,
 E.ID AS EMPLOYEE_ID,
 T.ID AS EMPLOYEE_TOTAL_ID,
 E.ORGANIZATION_ID,
 T.PERIOD_ID,
 T.WORK_DAY,
 T.WORK_HOUR,
 T.TOTAL_DAY,
 T.TOTAL_HOUR,
 T.START_BALANCE,
 T.END_BALANCE,
 T.INCREMENT_AMOUNT,
 T.DECREMENT_AMOUNT,
 T.PAYROLL_AMOUNT,
 T.ACU_PENSION,
 T.ACU_TAX,
 T.ACU_VACATION,
 T.ACU_SICK,
 T.ACU_FUND_SALARY,
 T.ACU_FUND_HELP,
 T.ACU_FUND_INSURANCE,
 T.ACU_FUND_WORK,
 T.ACU_SALARY13,
 T.ACU_SALARY12,
 T.ACU_ADD_PAY,
 T.OVERTIME_DAY,
 T.OVERTIME_HOUR,
 T.NIGHT_DAY,
 T.NIGHT_HOUR,
 T.HOLIDAY_DAY,
 T.HOLIDAY_HOUR,
 T.PREV_VACATION_AMOUNT,
 T.PREV_SICK_AMOUNT
FROM EMPLOYEE E LEFT JOIN EMPLOYEE_TOTAL T ON T.EMPLOYEE_ID = E.ID;

CREATE VIEW V_LEDGER_ACCOUNT_REST (
 ID,
 PERIOD_ID,
 ORGANIZATION_ID,
 LEDGER_ACCOUNT_ID,
 DEBIT_AMOUNT,
 CREDIT_AMOUNT
) AS
SELECT
 ID,
 PERIOD_ID,
 ORGANIZATION_ID,
 LEDGER_ACCOUNT_ID,
 DEBIT_AMOUNT,
 CREDIT_AMOUNT
FROM
 LEDGER_ACCOUNT_REST;

CREATE VIEW V_LEDGER_ACCOUNT_REGISTER (
 ID,
 ORGANIZATION_ID,
 PERIOD_ID,
 LEDGER_ACCOUNT_ID,
 DEBIT_AMOUNT,
 CREDIT_AMOUNT
) AS 
SELECT 
 R.ID,
 R.ORGANIZATION_ID,
 R.PERIOD_ID,
 R.LEDGER_ACCOUNT_ID,
 R.DEBIT_AMOUNT,
 R.CREDIT_AMOUNT
 FROM LEDGER_ACCOUNT_REGISTER R;


CREATE VIEW V_RPT_LDG_ACCOUNT_REST (
  PERIOD_ID,
  ORGANIZATION_ID,
  LEDGER_ACCOUNT_ID,
  LEDGER_ACCOUNT_CODE,
  LEDGER_ACCOUNT_NAME,
  DEBIT_AMOUNT,
  CREDIT_AMOUNT
) AS
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.LEDGER_ACCOUNT_ID,
  A.CODE AS LEDGER_ACCOUNT_CODE,
  A.NAME AS LEDGER_ACCOUNT_NAME,
  R.DEBIT_AMOUNT,
  R.CREDIT_AMOUNT
 FROM V_LEDGER_ACCOUNT_REST R
 INNER JOIN LEDGER_ACCOUNT A ON A.ID = R.LEDGER_ACCOUNT_ID;

CREATE VIEW V_RPT_LDG_ACCOUNT_REGISTER (
  PERIOD_ID,
  ORGANIZATION_ID,
  LEDGER_ACCOUNT_ID,
LEDGER_ACCOUNT_CODE,
  LEDGER_ACCOUNT_NAME,
  DEBIT_AMOUNT,
  CREDIT_AMOUNT
) AS
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.LEDGER_ACCOUNT_ID,
  A.CODE AS LEDGER_ACCOUNT_CODE,
  A.NAME AS LEDGER_ACCOUNT_NAME,
  R.DEBIT_AMOUNT,
  R.CREDIT_AMOUNT
 FROM V_LEDGER_ACCOUNT_REGISTER R
 INNER JOIN LEDGER_ACCOUNT A ON A.ID = R.LEDGER_ACCOUNT_ID;

CREATE VIEW V_RPT_LDG_ACCOUNT_REST_START (
  PERIOD_ID,
  ORGANIZATION_ID,
  LEDGER_ACCOUNT_ID,
  LEDGER_ACCOUNT_CODE,
  LEDGER_ACCOUNT_NAME,
  CREDIT_AMOUNT,
  DEBIT_AMOUNT
) AS
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.LEDGER_ACCOUNT_ID,
  R.LEDGER_ACCOUNT_CODE,
  R.LEDGER_ACCOUNT_NAME,
  R.CREDIT_AMOUNT,
  R.DEBIT_AMOUNT
 FROM V_RPT_LDG_ACCOUNT_REGISTER R
UNION ALL
SELECT 
  R.PERIOD_ID,
  R.ORGANIZATION_ID,
  R.LEDGER_ACCOUNT_ID,
  R.LEDGER_ACCOUNT_CODE,
  R.LEDGER_ACCOUNT_NAME,
  R.CREDIT_AMOUNT,
  R.DEBIT_AMOUNT
 FROM V_RPT_LDG_ACCOUNT_REST R;

CREATE VIEW V_RPT_LDG_ACCOUNT_CREDIT_FULL (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_CODE,
  DOCUMENT_DATE,
  LEDGER_ACCOUNT_ID,
  CORR_LEDGER_ACCOUNT_ID,
  AMOUNT
) AS
SELECT 
  FD.PERIOD_ID,
  FD.ORGANIZATION_ID,
  FD.DOCUMENT_CODE,
  FD.DOCUMENT_DATE,
  I.DEBIT_LEDGER_ACCOUNT_ID,
  I.CREDIT_LEDGER_ACCOUNT_ID,
  I.AMOUNT
 FROM V_FINANCE_DOCUMENT FD
 INNER JOIN ENTRY_ITEM I ON I.OWNER_ID = FD.ID;


CREATE VIEW V_RPT_LDG_ACCOUNT_DEBIT_FULL (
  PERIOD_ID,
  ORGANIZATION_ID,
  DOCUMENT_CODE,
  DOCUMENT_DATE,
  LEDGER_ACCOUNT_ID,
  CORR_LEDGER_ACCOUNT_ID,
  AMOUNT
) AS
SELECT 
  FD.PERIOD_ID,
  FD.ORGANIZATION_ID,
  FD.DOCUMENT_CODE,
  FD.DOCUMENT_DATE,
  I.CREDIT_LEDGER_ACCOUNT_ID,
  I.DEBIT_LEDGER_ACCOUNT_ID,
  I.AMOUNT
 FROM V_FINANCE_DOCUMENT FD
 INNER JOIN ENTRY_ITEM I ON I.OWNER_ID = FD.ID;


CREATE VIEW V_RPT_LDG_ACCOUNT_ROTATE (
 ORGANIZATION_ID,
 PERIOD_ID, 
 LEDGER_ACCOUNT_ID,
 REST_CREDIT_AMOUNT, 
 REST_DEBIT_AMOUNT, 
 CREDIT_AMOUNT,
 DEBIT_AMOUNT
) AS
SELECT 
 R.ORGANIZATION_ID,
 R.PERIOD_ID, 
 R.LEDGER_ACCOUNT_ID,
 R.CREDIT_AMOUNT AS REST_CREDIT_AMOUNT, 
 R.DEBIT_AMOUNT AS REST_DEBIT_AMOUNT, 
 0.0 AS CREDIT_AMOUNT,
 0.0 AS DEBIT_AMOUNT
FROM V_RPT_LDG_ACCOUNT_REST_START R
UNION ALL 
SELECT 
 C.ORGANIZATION_ID,
 C.PERIOD_ID, 
 C.LEDGER_ACCOUNT_ID,
 0.0 AS REST_CREDIT_AMOUNT, 
 0.0 AS REST_DEBIT_AMOUNT, 
 C.AMOUNT AS CREDIT_AMOUNT,
 0.0 AS DEBIT_AMOUNT
FROM V_RPT_LDG_ACCOUNT_CREDIT_FULL C
UNION ALL 
SELECT 
 D.ORGANIZATION_ID,
 D.PERIOD_ID, 
 D.LEDGER_ACCOUNT_ID,
 0.0 AS REST_CREDIT_AMOUNT, 
 0.0 AS REST_DEBIT_AMOUNT, 
 0.0 AS CREDIT_AMOUNT,
 D.AMOUNT AS DEBIT_AMOUNT
 FROM V_RPT_LDG_ACCOUNT_DEBIT_FULL D;

CREATE VIEW V_RPT_LDG_ACCOUNT_ALL (
 ORGANIZATION_ID,
 PERIOD_ID, 
 LEDGER_ACCOUNT_ID
) AS
SELECT 
 R.ORGANIZATION_ID,
 R.PERIOD_ID, 
 R.LEDGER_ACCOUNT_ID
FROM V_RPT_LDG_ACCOUNT_REST_START R
UNION 
SELECT 
 C.ORGANIZATION_ID,
 C.PERIOD_ID, 
 C.LEDGER_ACCOUNT_ID
FROM V_RPT_LDG_ACCOUNT_CREDIT_FULL C
UNION 
SELECT 
 D.ORGANIZATION_ID,
 D.PERIOD_ID, 
 D.LEDGER_ACCOUNT_ID
 FROM V_RPT_LDG_ACCOUNT_DEBIT_FULL D;

CREATE VIEW V_RPT_LDG_ACCOUNT_CORR (
 ORGANIZATION_ID,
 PERIOD_ID, 
 OPERATION_TYPE,
 LEDGER_ACCOUNT_ID,
 CORR_LEDGER_ACCOUNT_ID,
 AMOUNT,
 BALANCE_AMOUNT
) AS
SELECT 
 C.ORGANIZATION_ID,
 C.PERIOD_ID, 
 1 AS OPERATION_TYPE,
 C.LEDGER_ACCOUNT_ID,
 C.CORR_LEDGER_ACCOUNT_ID,
 C.AMOUNT,
 C.AMOUNT
FROM V_RPT_LDG_ACCOUNT_CREDIT_FULL C
UNION ALL 
SELECT 
 D.ORGANIZATION_ID,
 D.PERIOD_ID, 
 2 AS OPERATION_TYPE,
 D.LEDGER_ACCOUNT_ID,
 D.CORR_LEDGER_ACCOUNT_ID,
 D.AMOUNT,
 D.AMOUNT * -1
 FROM V_RPT_LDG_ACCOUNT_DEBIT_FULL D;

/*                                     */
/*   MYSQL IMPLEMENTATION              */
/*                                     */
/*   USE FUNCTIONS YEAR() AND MONTH(): */
/*                                     */
/*   YEAR(DOCUMENT_DATE),              */
/*   MONTH(DOCUMENT_DATE)              */
/*                                     */


CREATE VIEW V_PROJECT_DATE (
  ID,
  ORGANIZATION_ID,
  START_DATE,
  END_DATE,
  ACTUAL_END_DATE,
  START_YEAR,
  END_YEAR,
  ACTUAL_END_YEAR,
  START_MONTH,
  END_MONTH,
  ACTUAL_END_MONTH,
  START_DAY,
  END_DAY,
  ACTUAL_END_DAY
) AS
SELECT
  P.ID,
  P.ORGANIZATION_ID,
  P.START_DATE,
  P.END_DATE,
  P.ACTUAL_END_DATE,
  YEAR(P.START_DATE),
  YEAR(P.END_DATE),
  YEAR(P.ACTUAL_END_DATE),
  MONTH(P.START_DATE),
  MONTH(P.END_DATE),
  MONTH(P.ACTUAL_END_DATE),
  DAY(P.START_DATE),
  DAY(P.END_DATE),
  DAY(P.ACTUAL_END_DATE)
FROM PROJECT P;


CREATE VIEW V_PROJECT_DATE_EXT (
  ID,
  ORGANIZATION_ID,
  START_DATE,
  END_DATE,
  ACTUAL_END_DATE,
  START_YEAR,
  END_YEAR,
  ACTUAL_END_YEAR,
  START_MONTH,
  END_MONTH,
  ACTUAL_END_MONTH,
  START_DAY,
  END_DAY,
  ACTUAL_END_DAY,
  START_DAY_POS,
  END_DAY_POS,
  ACTUAL_END_DAY_POS
) AS
SELECT
  P.ID,
  P.ORGANIZATION_ID,
  P.START_DATE,
  P.END_DATE,
  P.ACTUAL_END_DATE,
  P.START_YEAR,
  P.END_YEAR,
  P.ACTUAL_END_YEAR,
  P.START_MONTH,
  P.END_MONTH,
  P.ACTUAL_END_MONTH,
  P.START_DAY,
  P.END_DAY,
  P.ACTUAL_END_DAY,
  P.START_YEAR * 10000 + P.START_MONTH * 100 + P.START_DAY,
  P.END_YEAR * 10000 + P.END_MONTH * 100 + P.END_DAY,
  P.ACTUAL_END_YEAR * 10000 + P.ACTUAL_END_MONTH * 100 + P.ACTUAL_END_DAY
FROM V_PROJECT_DATE P;


CREATE VIEW V_PROJECT_YEAR_UNIQUE (
  ORGANIZATION_ID,
  PROJECT_YEAR
) AS
SELECT
  ORGANIZATION_ID,
  START_YEAR
FROM V_PROJECT_DATE WHERE START_YEAR IS NOT NULL
UNION 
SELECT
  ORGANIZATION_ID,
  END_YEAR
FROM V_PROJECT_DATE  WHERE END_YEAR IS NOT NULL
UNION 
SELECT
  ORGANIZATION_ID,
  ACTUAL_END_YEAR
FROM V_PROJECT_DATE  WHERE ACTUAL_END_YEAR IS NOT NULL;




CREATE VIEW V_PROJECT_YEAR_UNIQUE_INF (
  ORGANIZATION_ID,
  PROJECT_YEAR,
  FLAG_YEAR
) AS
SELECT
  ORGANIZATION_ID,
  PROJECT_YEAR,
  0
FROM V_PROJECT_YEAR_UNIQUE WHERE (PROJECT_YEAR/4.00 - PROJECT_YEAR/4) <> 0
UNION ALL
SELECT
  ORGANIZATION_ID,
  PROJECT_YEAR,
  1
FROM V_PROJECT_YEAR_UNIQUE WHERE (PROJECT_YEAR/4.00 - PROJECT_YEAR/4) = 0;








CREATE VIEW V_PROJECT_PERIOD_DAY (
 ORGANIZATION_ID,
 YEAR_NUMBER,
 MONTH_NUMBER,
 MONTH_NAME,
 DAY_NUMBER,
 DAY_POS
) AS
SELECT
 PY.ORGANIZATION_ID,
 PY.PROJECT_YEAR AS YEAR_NUMBER,
 SM.MONTH_NUMBER,
 SM.NAME AS MONTH_NAME,
 SD.DAY_NUMBER,
 PY.PROJECT_YEAR * 10000 + SM.MONTH_NUMBER * 100 + SD.DAY_NUMBER
FROM V_PROJECT_YEAR_UNIQUE_INF PY, SYSTEM_MONTH SM, SYSTEM_DAY SD
 WHERE (SD.DAY_NUMBER <= (SM.DAY_COUNT + PY.FLAG_YEAR));






