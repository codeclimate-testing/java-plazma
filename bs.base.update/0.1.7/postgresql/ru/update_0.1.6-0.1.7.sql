
/*==============================================================*/
/* PostgreSQL                                                   */
/* http://www.postgresql.org                                    */
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

/*==============================================================*/
/* Table: PRODUCT_INSTANCE                                      */
/*==============================================================*/

create table PRODUCT_INSTANCE (
ID                   INTEGER                        not null,
PRODUCT_ID           INTEGER                        not null,
SERIAL_NUMBER        VARCHAR(30),
NAME                 VARCHAR(50),
constraint PK_PRODUCT_INSTANCE primary key (ID)
);


/*==============================================================*/
/*                                                              */
/* ADD COLUMNS                                                  */
/*                                                              */
/*==============================================================*/

/*==============================================================*/
/* Table: CONTACT                                               */
/*==============================================================*/

ALTER TABLE CONTACT
 ADD NAME_EN VARCHAR(50);

ALTER TABLE CONTACT
 ADD FULL_POSITION_NAME_EN VARCHAR(100);

ALTER TABLE CONTACT
 ADD WORK_ON_BASIS VARCHAR(100);

ALTER TABLE CONTACT
 ADD WORK_ON_BASIS_EN VARCHAR(100);


/*==============================================================*/
/* Table: CONTRACT                                              */
/*==============================================================*/

ALTER TABLE CONTRACT
  ADD ORGANIZATION_CONTACT_ID INTEGER;
  
ALTER TABLE CONTRACT
  ADD ORGANIZATION_BANK_ACCOUNT_ID INTEGER;

ALTER TABLE CONTRACT
  ADD PARTNER_CONTACT_ID   INTEGER;
  
ALTER TABLE CONTRACT
  ADD PARTNER_BANK_ACCOUNT_ID INTEGER;


ALTER TABLE CONTRACT
  ADD END_DATE DATE;
  
  
ALTER TABLE CONTRACT
  ADD ORGANIZATION_PERSON  VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD ORGANIZATION_PERSON_EN VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD ORGANIZATION_PERSON_DETAIL VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD ORGANIZATION_PERSON_DETAIL_EN VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD ORGANIZATION_PERSON_ON_BASIS VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD ORGANIZATION_PERSON_ON_BASIS_EN VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD ORGANIZATION_ADDRESS VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD ORGANIZATION_ADDRESS_EN VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD ORGANIZATION_PHONE VARCHAR(20);
  
ALTER TABLE CONTRACT
  ADD ORGANIZATION_FAX VARCHAR(20);
  
ALTER TABLE CONTRACT
  ADD ORGANIZATION_BANK_NAME VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD ORGANIZATION_BANK_NAME_EN VARCHAR(100);
  
  
ALTER TABLE CONTRACT
  ADD PARTNER_PERSON VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD PARTNER_PERSON_EN VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD PARTNER_PERSON_DETAIL VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD PARTNER_PERSON_DETAIL_EN VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD PARTNER_PERSON_ON_BASIS VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD PARTNER_PERSON_ON_BASIS_EN VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD PARTNER_ADDRESS VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD PARTNER_ADDRESS_EN VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD PARTNER_PHONE VARCHAR(20);
  
ALTER TABLE CONTRACT
  ADD PARTNER_FAX  VARCHAR(20);
  
ALTER TABLE CONTRACT
  ADD PARTNER_BANK_NAME VARCHAR(100);
  
ALTER TABLE CONTRACT
  ADD PARTNER_BANK_NAME_EN VARCHAR(100);
  

ALTER TABLE CONTRACT
  ADD PREPAY_AMOUNT NUMERIC(15,2) default 0 not null;
  
ALTER TABLE CONTRACT
  ADD CURRENCY_PREPAY_AMOUNT NUMERIC(15,2) default 0 not null;



/*==============================================================*/
/* Table: PRODUCT                                               */
/*==============================================================*/

ALTER TABLE PRODUCT
  ADD SMALL_WHOLESALE_PRICE NUMERIC(15,4) default 0 not null;

ALTER TABLE PRODUCT
  ADD CURRENCY_PRICE NUMERIC(15,4)	default 0 not null;
  
ALTER TABLE PRODUCT
  ADD CURRENCY_WHOLESALE_PRICE NUMERIC(15,4) default 0 not null;
  
ALTER TABLE PRODUCT
  ADD CURRENCY_SMALL_WHOLESALE_PRICE NUMERIC(15,4) default 0 not null;
  
ALTER TABLE PRODUCT
  ADD CURRENCY_RETAIL_PRICE NUMERIC(15,4) default 0 not null;
  

ALTER TABLE PRODUCT
  ADD WARRANTY_PERIOD INTEGER;
  
ALTER TABLE PRODUCT
  ADD BAR_CODE VARCHAR(30);


ALTER TABLE PRODUCT
  ADD DIM_LENGTH NUMERIC(12,3) default 0 not null;

ALTER TABLE PRODUCT
  ADD DIM_WIDTH NUMERIC(12,3) default 0 not null;

ALTER TABLE PRODUCT
  ADD DIM_HEIGHT NUMERIC(12,3) default 0 not null;
  
ALTER TABLE PRODUCT
  ADD WEIGHT NUMERIC(12,3) default 0 not null;
  
ALTER TABLE PRODUCT
  ADD PRODUCT_IMAGE VARCHAR(50);


ALTER TABLE PRODUCT
  ADD WARRANTY_PERIOD_UNIT_ID INTEGER;
  
ALTER TABLE PRODUCT
  ADD WEIGHT_UNIT_ID INTEGER;
  
ALTER TABLE PRODUCT
  ADD DIMENSION_UNIT_ID INTEGER;



/* Fix currency rate */
UPDATE PRODUCT SET CURRENCY_RATE = 1.0 WHERE CURRENCY_RATE IS NULL OR CURRENCY_RATE = 0;

/* Set currency prices */ 
UPDATE PRODUCT SET CURRENCY_PRICE = PRICE / CURRENCY_RATE;
UPDATE PRODUCT SET CURRENCY_WHOLESALE_PRICE  = WHOLESALE_PRICE / CURRENCY_RATE;
UPDATE PRODUCT SET CURRENCY_RETAIL_PRICE = RETAIL_PRICE / CURRENCY_RATE;


/*==============================================================*/
/* Table: PRODUCT_CLASS                                         */
/*==============================================================*/

ALTER TABLE PRODUCT_CLASS
 ADD NAME_EN VARCHAR(100);


/*==============================================================*/
/* Table: PRODUCT_GROUP                                         */
/*==============================================================*/

ALTER TABLE PRODUCT_GROUP
 ADD NAME_EN VARCHAR(30);
 

/*==============================================================*/
/* Table: UNIT                                                  */
/*==============================================================*/
 
ALTER TABLE UNIT 
 ADD NAME_EN VARCHAR(10);


/*==============================================================*/
/* Table: PARTNER                                               */
/*==============================================================*/

ALTER TABLE PARTNER
  ADD NAME_EN VARCHAR(50);
  
ALTER TABLE PARTNER  
  ADD PARTNER_IMAGE VARCHAR(50);
  
ALTER TABLE PARTNER    
  ADD IS_PERSON CHAR(1) default 'N' not null;


/*==============================================================*/
/* Table: PERSON                                                */
/*==============================================================*/

ALTER TABLE PERSON
  ADD PERSON_PHOTO VARCHAR(50);


/*==============================================================*/
/* Table: GOODS_OUTCOME_ITEM                                    */
/*==============================================================*/

ALTER TABLE GOODS_OUTCOME_ITEM
  ADD PRODUCT_INSTANCE_ID INTEGER;


/*==============================================================*/
/* Table: SYSTEM_INFO                                           */
/*==============================================================*/

ALTER TABLE SYSTEM_INFO
 ADD IS_MULTI_CURRENCIES  CHAR(1) default 'Y' not null;
 
ALTER TABLE SYSTEM_INFO
 ADD IS_INTERNATIONAL_ATTRIBUTES CHAR(1) default 'N' not null;
 
ALTER TABLE SYSTEM_INFO
 ADD IS_PROJECT_IN_DOCUMENT CHAR(1) default 'N' not null;


/*==============================================================*/
/* Table: SYSTEM_FILE                                           */
/*==============================================================*/
ALTER TABLE SYSTEM_FILE
 DROP FILE_PATH;



/* Change length of FILE_NAME: VARCHAR(50) -> VARCHAR(255) */

ALTER TABLE SYSTEM_FILE
 ADD FILE_NAME_2 VARCHAR(50);

UPDATE SYSTEM_FILE SET FILE_NAME_2 = FILE_NAME;

ALTER TABLE SYSTEM_FILE
 DROP FILE_NAME;

ALTER TABLE SYSTEM_FILE
 ADD FILE_NAME  VARCHAR(255);

UPDATE SYSTEM_FILE SET FILE_NAME = FILE_NAME_2;

ALTER TABLE SYSTEM_FILE
 DROP FILE_NAME_2;



ALTER TABLE SYSTEM_FILE
 ADD NAME VARCHAR(50);

ALTER TABLE SYSTEM_FILE
 ADD DESCRIPTION VARCHAR(255);


/*==============================================================*/
/*                                                              */
/* DROP COLUMNS                                                 */
/*                                                              */
/*==============================================================*/

ALTER TABLE GOODS
  DROP BAR_CODE;

/*===================================================*/
/*                                                   */
/* Update system                                     */
/*                                                   */
/*===================================================*/
/* 1. Rename entities
/*===================================================*/

 UPDATE SYSTEM_ENTITY SET ID = 'ASSET', CODE =  'ASSET' WHERE ID = 'FIXEDASSETS';
 UPDATE SYSTEM_ENTITY SET ID = 'PRODUCT_DETAIL_REGISTER', CODE =  'PRODUCT_DETAIL_REGISTER' WHERE ID = 'GOODS_DETAIL_REGISTER';
 UPDATE SYSTEM_ENTITY SET ID = 'PRODUCT_REGISTER', CODE = 'PRODUCT_REGISTER' WHERE ID = 'GOODS_REGISTER';
 UPDATE SYSTEM_ENTITY SET ID = 'M_PRODUCT_DETAIL_REGISTER', CODE = 'M_PRODUCT_DETAIL_REGISTER' WHERE ID = 'M_GOODS_DETAIL_REGISTER';
 UPDATE SYSTEM_ENTITY SET ID = 'M_PRODUCT_DETAIL_REGISTER_ID', CODE = 'M_PRODUCT_DETAIL_REGISTER_ID' WHERE ID = 'M_GOODS_DETAIL_REGISTER_ID';
 UPDATE SYSTEM_ENTITY SET ID = 'M_PRODUCT_DETAIL_REGISTER_SUM', CODE = 'M_PRODUCT_DETAIL_REGISTER_SUM' WHERE ID = 'M_GOODS_DETAIL_REGISTER_SUM';
 UPDATE SYSTEM_ENTITY SET ID = 'M_PRODUCT_REGISTER', CODE = 'M_PRODUCT_REGISTER' WHERE ID = 'M_GOODS_REGISTER';
 UPDATE SYSTEM_ENTITY SET ID = 'M_PRODUCT_REGISTER_ID', CODE = 'M_PRODUCT_REGISTER_ID' WHERE ID = 'M_GOODS_REGISTER_ID';
 UPDATE SYSTEM_ENTITY SET ID = 'M_PRODUCT_REGISTER_SUM', CODE = 'M_PRODUCT_REGISTER_SUM' WHERE ID = 'M_GOODS_REGISTER_SUM';
 UPDATE SYSTEM_ENTITY SET ID = 'INTANGIBLE', CODE = 'INTANGIBLE' WHERE ID = 'NONMATERIAL';
 UPDATE SYSTEM_ENTITY SET ID = 'SECURE_OBJECT', CODE = 'SECURE_OBJECT' WHERE ID = 'SECURE_ENTITY';

/*===================================================*/
/* 2. Delete entities
/*===================================================*/

 DELETE FROM SYSTEM_ENTITY WHERE ID = 'LITTLEARTICLE';
 DELETE FROM SYSTEM_ENTITY WHERE ID = 'MATERIAL';

/*===================================================*/
/* 3. Insert entities
/*===================================================*/

 INSERT INTO SYSTEM_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID) VALUES ('CONTACT_CONTEXT', 'CONTACT_CONTEXT', '-', 'ENTITY');
 INSERT INTO SYSTEM_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID) VALUES ('M_LEDGER_ACCOUNT_REGISTER', 'M_LEDGER_ACCOUNT_REGISTER', '-', 'ENTITY');
 INSERT INTO SYSTEM_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID) VALUES ('M_LEDGER_ACCOUNT_REGISTER_ID', 'M_LEDGER_ACCOUNT_REGISTER_ID', '-', 'ENTITY');
 INSERT INTO SYSTEM_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID) VALUES ('M_LEDGER_ACCOUNT_REGISTER_SUM', 'M_LEDGER_ACCOUNT_REGISTER_SUM', '-', 'ENTITY');
 INSERT INTO SYSTEM_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID) VALUES ('PAYMENT_DOCUMENT_LINK', 'PAYMENT_DOCUMENT_LINK', '-', 'ENTITY');
 INSERT INTO SYSTEM_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID) VALUES ('PAYMENT_MISSING', 'PAYMENT_MISSING', '-', 'ENTITY');
 INSERT INTO SYSTEM_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID) VALUES ('PAYMENT_OUTCOME_TEMPLATE', 'PAYMENT_OUTCOME_TEMPLATE', '-', 'ENTITY');
 INSERT INTO SYSTEM_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID) VALUES ('PRODUCT_INSTANCE', 'PRODUCT_INSTANCE', '-', 'ENTITY');
 INSERT INTO SYSTEM_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID) VALUES ('PROJECT_EMPLOYEE_LINK', 'PROJECT_EMPLOYEE_LINK', '-', 'ENTITY');
 INSERT INTO SYSTEM_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID) VALUES ('SYSTEM_ATTR', 'SYSTEM_ATTR', '-', 'ENTITY');
 INSERT INTO SYSTEM_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID) VALUES ('SYSTEM_ATTR_TYPE', 'SYSTEM_ATTR_TYPE', '-', 'ENTITY');
 INSERT INTO SYSTEM_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID) VALUES ('SYSTEM_ATTR_TYPE_GROUP', 'SYSTEM_ATTR_TYPE_GROUP', '-', 'ENTITY');
 INSERT INTO SYSTEM_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID) VALUES ('SYSTEM_ENUMERATION', 'SYSTEM_ENUMERATION', '-', 'ENTITY');
 INSERT INTO SYSTEM_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID) VALUES ('SYSTEM_PREFERENCE', 'SYSTEM_PREFERENCE', '-', 'ENTITY');
 INSERT INTO SYSTEM_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID) VALUES ('SYSTEM_REFERENCE', 'SYSTEM_REFERENCE', '-', 'ENTITY');
 INSERT INTO SYSTEM_ENTITY (ID, CODE, NAME, ENTITY_TYPE_ID) VALUES ('TASK_EMPLOYEE_LINK', 'TASK_EMPLOYEE_LINK', '-', 'ENTITY');


UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'ACADEMIC_DEGREE',
    NAME = 'Учёная степень',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'Y'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'Y'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'DRUGSTORE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'EDUCATION_FORM',
    NAME = 'Форма образования',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'EDUCATION_FORM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'EDUCATION_INSTITUTE',
    NAME = 'Учебное заведение',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'EDUCATION_INSTITUTE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'EDUCATION_TYPE',
    NAME = 'Тип образования',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'Y'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'ENTRY_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'EXEC_WORK',
    NAME = 'Акт выполненных работ',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'EXEC_WORK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'EXEC_WORK_ITEM',
    NAME = 'Строчки по акту выполненных работ',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'EXEC_WORK_ITEM');

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
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'FACTORY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'FAMILIARITY',
    NAME = 'Родственные связи',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'FAMILIARITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'FAMILY_STATUS',
    NAME = 'Семейное положение',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'Y'
WHERE (ID = 'GOODS');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'GOODS_INCOME',
    NAME = 'Приходная накладная',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'GOODS_INCOME');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'GOODS_INCOME_ITEM',
    NAME = 'Строчки приходной накладной',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'GOODS_INCOME_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'GOODS_MOVE',
    NAME = 'Накладная на внутренне перемещение',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'GOODS_MOVE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'GOODS_MOVE_ITEM',
    NAME = 'Строчки накладной на внутренне перемещение',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'GOODS_MOVE_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'GOODS_OUTCOME',
    NAME = 'Расходная накладная',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'GOODS_OUTCOME');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'GOODS_OUTCOME_ITEM',
    NAME = 'Строчки расходной накладной',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'GOODS_OUTCOME_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'GOODS_REST',
    NAME = 'Остатки по товару',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'GOODS_REST');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'GOODS_REST_ITEM',
    NAME = 'Строчки остатков по товару',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'GOODS_REST_ITEM');

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
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'GOODS_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'GOODS_WRITEOFF',
    NAME = 'Акт на списание',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'GOODS_WRITEOFF');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'GOODS_WRITEOFF_ITEM',
    NAME = 'Строчки акта на списание',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'GOODS_WRITEOFF_ITEM');

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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'INTANGIBLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'INVOICE',
    NAME = 'Счёт-фактура',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'INVOICE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'INVOICE_ITEM',
    NAME = 'Строчки счёта-фактуры',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'INVOICE_ITEM');

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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'LOCALITY_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'MILITARY_RANK',
    NAME = 'Воинское звание',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'MILITARY_RANK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'MILITARY_SPECIALITY',
    NAME = 'Воинская специальность',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'MILITARY_SPECIALITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'MILITARY_STATUS',
    NAME = 'Воинский статус',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'Y'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PERIOD_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON',
    NAME = 'Физическое лицо',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'Y'
WHERE (ID = 'PERSON');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_CARD',
    NAME = 'Карточка физического лица',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PERSON_CARD');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_DOCUMENT',
    NAME = 'Документ физического лица',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PERSON_DOCUMENT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_DOCUMENT_TYPE',
    NAME = 'Тип документа физического лица',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PERSON_DOCUMENT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_EDUCATION',
    NAME = 'Образование физического лица',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PERSON_EDUCATION');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_FAMILY',
    NAME = 'Семья физического лица',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PERSON_FAMILY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_JOB',
    NAME = 'Работа физического лица',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PERSON_JOB');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_LANGUAGE',
    NAME = 'Язык общения физического лица',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PERSON_LANGUAGE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_MILITARY',
    NAME = 'Воинская информация по физическому лицу',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'Y'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PROJECT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PURCHASE_ORDER',
    NAME = 'Заказ на покупку',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PURCHASE_ORDER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PURCHASE_ORDER_ITEM',
    NAME = 'Строчки заказа на покупку',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PURCHASE_ORDER_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PURCHASE_PLAN',
    NAME = 'План на покупку',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PURCHASE_PLAN');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PURCHASE_PLAN_ITEM',
    NAME = 'Строчки плана на покупку',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PURCHASE_PLAN_ITEM');

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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'RESPONSIBLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'SALE_ORDER',
    NAME = 'Заказ на продажу',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SALE_ORDER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'SALE_ORDER_ITEM',
    NAME = 'Строчки заказа на продажу',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SALE_ORDER_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'SALE_PLAN',
    NAME = 'План на продажу',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SALE_PLAN');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'SALE_PLAN_ITEM',
    NAME = 'Строчки плана на продажу',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SALE_PLAN_ITEM');

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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SICK_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SPECIALITY',
    NAME = 'Специальность',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SYSTEM_MONTH');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_PERMISSION',
    NAME = 'Права доступа',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SYSTEM_REFERENCE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_ROLE',
    NAME = 'Роль',
    ENTITY_CLASS = 'Role',
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SYSTEM_ROLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_USER',
    NAME = 'Пользователь',
    ENTITY_CLASS = 'User',
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SYSTEM_USER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_USER_ROLE',
    NAME = 'Роль пользователя',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'Y'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'TAXPRINT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'TAX_WAYBILL',
    NAME = 'Налоговая накладная',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'TAX_WAYBILL');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'TAX_WAYBILL_ITEM',
    NAME = 'Строчки налоговой накладной',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'TAX_WAYBILL_ITEM');

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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
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
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'WORKSHOP');


/* EMPTY */
update system_info set db_version = '0.1.7', app_version = '0.1.7', is_init = 'N'  where id = 1;


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

/*==============================================================*/
/* PostgreSQL                                                   */
/* http://www.postgresql.org                                    */
/*==============================================================*/

CREATE VIEW v_organization (
  id,
  organization_name,
  organization_code,
  organization_swift_code
) AS
SELECT
  o.id,
  p.name,
  p.code,
  p.swift_code
 FROM organization o 
 INNER JOIN partner p ON p.id = o.id;

CREATE VIEW v_system_info (
 period_id,
 organization_id,
 currency_id,
 unit_id,
 period_name,
 period_start_date,
 period_end_date,
 organization_name,
 currency_name,
 unit_name
) AS
SELECT 
 i.period_id,
 i.organization_id,
 i.currency_id,
 i.unit_id,
 p.name,
 p.start_date,
 p.end_date,
 o.organization_name,
 c.name,
 u.name
FROM system_info i
 INNER JOIN period p ON p.id = i.period_id
 INNER JOIN v_organization o ON o.id = i.organization_id
 INNER JOIN currency c ON c.id = i.currency_id
 INNER JOIN unit u ON u.id = i.unit_id;

CREATE VIEW v_system_user (
 id,
 usrname,
 passwd,
 owner_id,
 entity_id,
 name,
 organization_id,
 registration_date,
 organization_name
) AS
SELECT u.id, u.usrname, u.passwd, u.owner_id, u.entity_id,
 p.last_name || ' ' || p.first_name || ' ' || p.middle_name as name,
 o.id as organization_id, u.registration_date, o.organization_name
 FROM system_user u
 INNER JOIN system_entity e ON e.id = u.entity_id
 INNER JOIN employee ee ON ee.id = u.owner_id
 INNER JOIN person p ON p.id = ee.person_id
 INNER JOIN v_organization o ON o.id = ee.organization_id
 WHERE e.code = 'EMPLOYEE';



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
 o.id as id,
 p.secure_entity_id,
 p.id as system_permission_id,
 o.entity_id,
 o.code,
 o.name,
 o.object_type,
 p.role_id,
 p.is_read,
 p.is_write,
 p.is_exec
FROM secure_object o
LEFT JOIN system_permission p ON o.id = p.secure_entity_id;


CREATE VIEW V_EMPLOYEE (
    id,
    organization_id,
    person_id,
    first_name,
    last_name,
    middle_name,
    name
) AS
SELECT 
 e.id,
 e.organization_id,
 e.person_id,
 p.first_name,
 p.last_name,
 p.middle_name,
 p.name
 FROM employee e
 INNER JOIN person p ON p.id = e.person_id;
 


CREATE VIEW v_warehouse (
  id,
  owner_id,
  entity_id,
  name
) AS
SELECT b.id, b.owner_id, b.entity_id, b.name
 FROM businessable b
 INNER JOIN warehouse s ON s.id = b.owner_id;

 




CREATE VIEW v_warehouse_union (
  id, 
  owner_id, 
  entity_id, 
  entity_code, 
  entity_name, 
  organization_id, 
  parent_id, 
  name
) AS 
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, o.organization_id, o.parent_id, o.name
 FROM businessable b
 INNER JOIN store o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'STORE'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, o.organization_id, o.parent_id, o.name
 FROM businessable b
 INNER JOIN drugstore o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'DRUGSTORE'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, o.organization_id, o.parent_id, o.name
 FROM businessable b
 INNER JOIN shop o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'SHOP'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, o.organization_id, o.parent_id, o.name
 FROM businessable b
 INNER JOIN factory o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'FACTORY'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, o.organization_id, o.parent_id, o.name
 FROM businessable b
 INNER JOIN works o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'WORKS';



CREATE VIEW v_responsible (
 id,
 organization_id,
 employee_id,
 warehouse_id,
 person_id,
 responsible_name,
 warehouse_name
) AS
SELECT 
 re.id, 
 re.organization_id, 
 re.employee_id,
 re.warehouse_id,
 p.id as person_id,
 p.name,
 s.name
 FROM responsible re 
 INNER JOIN employee e ON e.id = re.employee_id
 INNER JOIN person p ON p.id = e.person_id
 LEFT JOIN v_warehouse s ON s.id = re.warehouse_id;


CREATE VIEW v_warehouse_move (
  id,
  document_id,
  warehouse_id,
  warehouse_name,
  move_type
) AS
SELECT 
  m.id,
  m.owner_id as document_id,
  m.warehouse_id,
  s.name as warehouse_name,
  m.move_type
 FROM warehouse_move m
 INNER JOIN v_warehouse s ON s.id = m.warehouse_id;

CREATE VIEW v_product (
 id,
 product_code,
 product_name,
 product_class_id,
 product_class_code,
 product_group_id,
 bar_code,
 organization_id,
 currency_id,
 currency_rate,
 ledger_account_id,
 manufacturer_id,
 supplier_id,
 start_date,
 end_date,
 unit_id,
 price,
 wholesale_price,
 small_wholesale_price,
 retail_price,
 currency_price,
 currency_small_wholesale_price,
 currency_wholesale_price,
 currency_retail_price,
 tax_percent,
 addprice_percent,
 min_quantity,
 availability_quantity,
 reserve_quantity,
 await_quantity,
 warranty_period_unit_id,
 warranty_period,
 dimension_unit_id,
 dim_length,
 dim_width,
 dim_height,
 weight_unit_id,
 weight,
 product_image,
 note

) AS
SELECT 
 p.id,    
 p.code,
 c.name,
 p.product_class_id,
 c.code,
 p.product_group_id,
 p.bar_code,
 p.organization_id,
 p.currency_id,
 p.currency_rate,
 p.ledger_account_id,
 p.manufacturer_id,
 p.supplier_id,
 p.start_date,
 p.end_date,
 p.unit_id,
 p.price,
 p.wholesale_price,
 p.small_wholesale_price,
 p.retail_price,
 p.currency_price,
 p.currency_small_wholesale_price,
 p.currency_wholesale_price,
 p.currency_retail_price,
 p.tax_percent,
 p.addprice_percent,
 p.min_quantity,
 p.availability_quantity,
 p.reserve_quantity,
 p.await_quantity,
 p.warranty_period_unit_id,
 p.warranty_period,
 p.dimension_unit_id,
 p.dim_length,
 p.dim_width,
 p.dim_height,
 p.weight_unit_id,
 p.weight,
 p.product_image,
 p.note

FROM product p
INNER JOIN product_class c ON c.id = p.product_class_id;



CREATE VIEW v_product_move (
  id,
  document_id,
  product_id,
  product_code,
  product_name,
  unit_id,
  item_unit_id,
  unit_rate,
  unit_name,
  product_price,
  price,
  price_with_tax,
  tax_price,
  quantity,
  amount,
  amount_with_tax,
  tax_amount,
  item_price,
  item_account_price,
  item_amount,
  account_quantity,
  account_price,
  account_price_with_tax
) AS
SELECT 
  i.id,
  i.owner_id,
  i.product_id,
  p.product_code,
  p.product_name,
  p.unit_id,
  i.unit_id,
  i.unit_rate,
  u.name,
  p.price,
  i.price,
  i.price_with_tax,
  i.tax_price,
  i.quantity,
  i.amount,
  i.amount_with_tax,
  i.tax_amount,
  i.price_with_tax,
  i.account_price_with_tax,
  i.amount_with_tax,
  i.account_quantity,
  i.account_price,
  i.account_price_with_tax
 FROM product_move i
 INNER JOIN v_product p ON p.id = i.product_id
 INNER JOIN unit u ON u.id = i.unit_id;
CREATE VIEW v_goods (
 id,
 product_code,
 product_name,
 product_class_id,
 product_group_id,
 currency_id,
 organization_id,
 unit_id,
 price,
 start_date,
 end_date,
 tax_percent,
 addprice_percent,
 min_quantity,
 currency_rate,
 country_id,
 goods_type_id,
 goods_type_name,
 product_class_code
) AS
SELECT 
 p.id,    
 p.product_code,
 p.product_name,
 p.product_class_id,
 p.product_group_id,
 p.currency_id,
 p.organization_id,
 p.unit_id,
 p.price,
 p.start_date,
 p.end_date,
 p.tax_percent,
 p.addprice_percent,
 p.min_quantity,
 p.currency_rate,
 g.country_id,
 g.goods_type_id,
 t.name,
 p.product_class_code
 FROM goods g
 INNER JOIN v_product p ON p.id = g.id
 INNER JOIN goods_type t ON t.id = g.goods_type_id;






CREATE VIEW v_asset (
 id,	
 product_code,
 product_name,
 product_class_id,
 product_group_id,
 currency_id,
 organization_id,
 unit_id,
 price,
 start_date,
 end_date,
 tax_percent,
 addprice_percent,
 min_quantity,
 currency_rate
) AS
SELECT 
 p.id,	
 p.product_code,
 p.product_name,
 p.product_class_id,
 p.product_group_id,
 p.currency_id,
 p.organization_id,
 p.unit_id,
 p.price,
 p.start_date,
 p.end_date,
 p.tax_percent,
 p.addprice_percent,
 p.min_quantity,
 p.currency_rate
 FROM asset a
 INNER JOIN v_product p ON p.id = a.id;


CREATE VIEW v_intangible (
 id,	
 product_code,
 product_name,
 product_class_id,
 product_group_id,
 currency_id,
 organization_id,
 unit_id,
 price,
 start_date,
 end_date,
 tax_percent,
 addprice_percent,
 min_quantity,
 currency_rate
) AS
SELECT 
 p.id,	
 p.product_code,
 p.product_name,
 p.product_class_id,
 p.product_group_id,
 p.currency_id,
 p.organization_id,
 p.unit_id,
 p.price,
 p.start_date,
 p.end_date,
 p.tax_percent,
 p.addprice_percent,
 p.min_quantity,
 p.currency_rate
 FROM intangible i
 INNER JOIN v_product p ON p.id = i.id;


/*                                                       */
/*   PostgreSQL implementation                           */
/*                                                       */
/*   Use functions:                                      */
/*                                                       */
/*   TO_NUMBER(TO_CHAR(document_date, 'YYYY'), '9999')   */
/*   TO_NUMBER(TO_CHAR(document_date, 'MM'), '99' )      */
/*                                                       */


CREATE VIEW v_document (
  id,
  organization_id,
  organization_name,
  organization_code,
  organization_swift_code,
  document_type_id,
  document_type_code,
  document_type_name,
  period_id,
  document_code,
  document_date,
  document_year,
  document_month,
  partner_id,
  user_id,
  contract_id,
  reason_document_id,
  reason,
  note,
  usrname
) AS
SELECT
  d.id,
  d.organization_id,
  o.organization_name,
  o.organization_code,
  o.organization_swift_code,
  d.document_type_id,
  e.code as document_type_code,
  e.name as document_type_name,
  d.period_id,
  d.code,
  d.document_date,
  TO_NUMBER(TO_CHAR(d.document_date,'YYYY'), '9999'),
  TO_NUMBER(TO_CHAR(d.document_date,'MM'), '99'),
  d.partner_id,
  d.user_id,
  d.contract_id,
  d.reason_document_id,
  d.reason,
  d.note,
  u.usrname
 FROM document d
 INNER JOIN v_organization o ON o.id = d.organization_id
 INNER JOIN document_type dt ON dt.id = d.document_type_id
 INNER JOIN system_entity e ON e.id = dt.entity_id
 LEFT JOIN system_user u ON u.id = d.user_id;




CREATE VIEW v_finance_document (
  id, 
  organization_id,
  organization_name,
  organization_code,
  organization_swift_code,
  document_type_id, 
  document_type_code,
  document_type_name,
  period_id,
  document_code, 
  document_date,
  document_year,
  document_month,
  partner_id,
  user_id,
  contract_id,
  reason_document_id,
  reason,
  note,
  usrname,
  currency_id, 
  currency_rate,
  currency_rate_date,
  currency_code,
  currency_char_code,
  currency_name,
  amount,
  amount_with_tax,
  tax_amount,
  currency_amount,
  currency_amount_with_tax,
  currency_tax_amount,
  total,
  total_with_tax,
  tax_total,
  currency_total,
  currency_total_with_tax,
  currency_tax_total,
  document_amount,
  document_total,
  currency_document_amount,
  currency_document_total,
  is_operation,
  is_account_items
) AS
SELECT 
  d.id, 
  d.organization_id,
  d.organization_name,
  d.organization_code,
  d.organization_swift_code,
  d.document_type_id, 
  d.document_type_code,
  d.document_type_name,
  d.period_id,
  d.document_code, 
  d.document_date,
  d.document_year,
  d.document_month,
  d.partner_id,  
  d.user_id,
  d.contract_id,
  d.reason_document_id,
  d.reason,
  d.note,
  d.usrname,
  fd.currency_id, 
  fd.currency_rate,
  fd.currency_rate_date,
  cr.code as currency_code,
  cr.char_code as currency_char_code,
  cr.name as currency_name,
  fd.amount,
  fd.amount_with_tax,
  fd.tax_amount,
  fd.currency_amount,
  fd.currency_amount_with_tax,
  fd.currency_tax_amount,
  fd.total,
  fd.total_with_tax,
  fd.tax_total,
  fd.currency_total,
  fd.currency_total_with_tax,
  fd.currency_tax_total,
  fd.amount_with_tax as document_amount,
  fd.total_with_tax as document_total,
  fd.currency_amount_with_tax as currency_document_amount,
  fd.currency_total_with_tax as currency_document_total,
  fd.is_operation,
  fd.is_account_items
 FROM finance_document fd
 INNER JOIN v_document d ON fd.id = d.id
 LEFT JOIN currency cr ON cr.id = fd.currency_id;



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
SELECT b.id, b.owner_id, b.entity_id, b.name
 FROM businessable b WHERE b.entity_id = 'PARTNER' or b.entity_id = 'EMPLOYEE';

CREATE VIEW V_CONTRACTOR_UNION (
    ID,
    OWNER_ID,
    ENTITY_ID,
    ENTITY_CODE,
    ENTITY_NAME,
    ORGANIZATION_ID,
    NAME)
AS
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, -1, CAST(o.name as VARCHAR(100))
 FROM businessable b
 INNER JOIN partner o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'PARTNER'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, o.organization_id, CAST(p.name as VARCHAR(100))
 FROM businessable b
 INNER JOIN employee o ON o.id = b.owner_id
 INNER JOIN person p ON p.id = o.person_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'EMPLOYEE';
CREATE VIEW v_city (
  id,
  country_id,
  locality_type_id,
  region_id,
  district_id,
  name
) AS
SELECT
  c.id,
  l.country_id,
  l.locality_type_id,
  l.region_id,
  l.district_id,
  l.name
 FROM city c
 INNER JOIN locality l ON l.id = c.id;

CREATE VIEW v_address_city (
  id,
  contactable_id,
  country_id,
  locality_type_id,
  region_id,
  district_id,
  name
) AS
SELECT 
  a.id,
  a.contactable_id,
  c.country_id,
  c.locality_type_id,
  c.region_id,
  c.district_id,
  c.name
FROM address a
INNER JOIN v_city c ON c.id = a.city_id;

CREATE VIEW v_address (
 id,
 address_type_id,
 contactable_id,
 city_id,
 city_name,
 locality_id,
 locality_type_name,
 locality_name,
 street_type_id,
 address_string,
 full_address_string,
 zip_code,
 street,
 house_num,
 case_num,
 appart_num,
 note
) AS
SELECT 
 a.id,
 a.address_type_id,
 a.contactable_id,
 a.city_id,
 c.name,
 a.locality_id,
 lt.name,
 l.name,
 a.street_type_id,
 a.address_string,
 a.full_address_string,
 a.zip_code,
 a.street,
 a.house_num,
 a.case_num,
 a.appart_num,
 a.note
 FROM address a
 LEFT JOIN v_city c ON c.id = a.city_id
 LEFT JOIN locality l ON l.id = a.locality_id
 LEFT JOIN locality_type lt ON lt.id = l.locality_type_id;

CREATE VIEW v_contactable_address (
 contactable_id,
 address_id,
 address_type_id,
 city_id,
 city_name,
 locality_id,
 locality_type_name,
 locality_name,
 street_type_id,
 address_string,
 full_address_string,
 zip_code,
 street,
 house_num,
 case_num,
 appart_num,
 note,
 owner_id,
 entity_id
) AS
SELECT 
 c.id as contactable_id,
 a.id as address_id,
 a.address_type_id,
 a.city_id,
 a.city_name,
 a.locality_id,
 a.locality_type_name,
 a.locality_name,
 a.street_type_id,
 a.address_string,
 a.full_address_string,
 a.zip_code,
 a.street,
 a.house_num,
 a.case_num,
 a.appart_num,
 a.note,
 c.owner_id,
 c.entity_id
 FROM contactable c 
 INNER JOIN v_address a ON a.contactable_id = c.id;

CREATE VIEW v_def_contactable_address (
 contactable_id,
 address_id,
 address_type_id,
 city_id,
 city_name,
 locality_id,
 locality_type_name,
 locality_name,
 street_type_id,
 address_string,
 full_address_string,
 zip_code,
 street,
 house_num,
 case_num,
 appart_num,
 note,
 owner_id,
 entity_id
) AS
SELECT 
 c.id as contactable_id,
 a.id as address_id,
 a.address_type_id,
 a.city_id,
 a.city_name,
 a.locality_id,
 a.locality_type_name,
 a.locality_name,
 a.street_type_id,
 a.address_string,
 a.full_address_string,
 a.zip_code,
 a.street,
 a.house_num,
 a.case_num,
 a.appart_num,
 a.note,
 c.owner_id,
 c.entity_id
 FROM contactable c 
 LEFT JOIN v_address a ON a.id = c.address_id;

CREATE VIEW v_def_partner_address (
 partner_id,
 contactable_id,
 address_id,
 address_type_id,
 city_id,
 city_name,
 locality_id,
 locality_type_name,
 locality_name,
 street_type_id,
 address_string,
 full_address_string,
 zip_code,
 street,
 house_num,
 case_num,
 appart_num,
 note,
 entity_id
) AS
SELECT 
 p.id,
 a.contactable_id,
 a.address_id,
 a.address_type_id,
 a.city_id,
 a.city_name,
 a.locality_id,
 a.locality_type_name,
 a.locality_name,
 a.street_type_id,
 a.address_string,
 a.full_address_string,
 a.zip_code,
 a.street,
 a.house_num,
 a.case_num,
 a.appart_num,
 a.note,
 a.entity_id
 FROM  partner p
 LEFT JOIN v_def_contactable_address a ON a.owner_id = p.id;

CREATE VIEW v_phone (
 id,
 phone_type_id,
 contactable_id,
 phone_code,
 phone_number,
 phone_string,
 note
) AS
SELECT 
 p.id,
 p.phone_type_id,
 p.contactable_id,
 p.phone_code,
 p.phone_number,
 p.phone_string,
 p.note
 FROM phone p;

CREATE VIEW v_contactable_phone (
 contactable_id,
 phone_id,
 phone_type_id,
 phone_code,
 phone_number,
 phone_string,
 note,
 owner_id,
 entity_id
) AS
SELECT 
 c.id as contactable_id,
 p.id as phone_id,
 p.phone_type_id,
 p.phone_code,
 p.phone_number,
 p.phone_string,
 p.note,
 c.owner_id,
 c.entity_id
 FROM contactable c 
 INNER JOIN v_phone p ON p.contactable_id = c.id;

CREATE VIEW v_def_contactable_phone (
 contactable_id,
 phone_id,
 phone_type_id,
 phone_code,
 phone_number,
 phone_string,
 note,
 owner_id,
 entity_id
) AS
SELECT 
 c.id as contactable_id,
 p.id as phone_id,
 p.phone_type_id,
 p.phone_code,
 p.phone_number,
 p.phone_string,
 p.note,
 c.owner_id,
 c.entity_id
 FROM contactable c 
 LEFT JOIN v_phone p ON p.id = c.phone_id;

CREATE VIEW v_def_partner_phone (
 partner_id,
 contactable_id,
 phone_id,
 phone_type_id,
 phone_code,
 phone_number,
 phone_string,
 note,
 entity_id
) AS
SELECT 
 p.id,
 ph.contactable_id,
 ph.phone_id,
 ph.phone_type_id,
 ph.phone_code,
 ph.phone_number,
 ph.phone_string,
 ph.note,
 ph.entity_id
 FROM  partner p
 LEFT JOIN v_def_contactable_phone ph ON ph.owner_id = p.id;

CREATE VIEW v_bank (
  id,
  code,
  name,
  full_name,
  tax_code,
  year_create,
  work_time,
  note,
  is_tax,
  swift_code,
  tax_doc_code,
  form_property_id,
  partner_group_id,
  bank_swift_code,
  correspondent_account,
  stopped_percent,
  address_id,
  address_type_id,
  city_id,
  city_name,
  locality_id,
  street_type_id,
  address_string,
  zip_code,
  street,
  house_num,
  case_num,
  appart_num,
  address_note,
  phone_id,
  phone_type_id,
  phone_code,
  phone_number,
  phone_string,
  phone_note
) AS
SELECT 
  b.id,
  p.code,
  p.name,
  p.full_name,
  p.tax_code,
  p.year_create,
  p.work_time,
  p.note,
  p.is_tax,
  p.swift_code,
  p.tax_doc_code,
  p.form_property_id,
  p.partner_group_id,
  b.bank_swift_code,
  b.correspondent_account,
  b.stopped_percent,
  da.address_id,
  da.address_type_id,
  da.city_id,
  c.name as city_name,
  da.locality_id,
  da.street_type_id,
  da.address_string,
  da.zip_code,
  da.street,
  da.house_num,
  da.case_num,
  da.appart_num,
  da.note as address_note,
  dp.phone_id,
  dp.phone_type_id,
  dp.phone_code,
  dp.phone_number,
  dp.phone_string,
  dp.note as phone_note
 FROM bank b
 INNER JOIN partner p ON p.id = b.id
 INNER JOIN v_def_partner_address da ON da.partner_id = p.id
 INNER JOIN v_def_partner_phone dp ON dp.partner_id = p.id
 LEFT JOIN v_city c ON c.id = da.city_id;

CREATE VIEW v_partner_bank_account (
  id,
  bank_id,
  partner_id,
  name,
  account_no
) AS
SELECT 
  ba.id,
  ba.bank_id,
  ba.partner_id,
  ba.name,
  ba.account_no
FROM bank_account ba;

CREATE VIEW V_PAYMENT_INCOME (
    ID,
    ORGANIZATION_ID,
    ORGANIZATION_NAME,
    ORGANIZATION_CODE,
    ORGANIZATION_SWIFT_CODE,
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
    PARTNER_BANK_SWIFT_CODE,
    PARTNER_BANK_NAME,
    PARTNER_BANK_CITY_NAME,
    ORGANIZATION_BANK_ACCOUNT_ID,
    ORGANIZATION_BANK_ACCOUNT_NO,
    ORGANIZATION_BANK_SWIFT_CODE,
    ORGANIZATION_BANK_NAME,
    ORGANIZATION_BANK_CITY_NAME,
    PARTNER_ID,
    PARTNER_NAME,
    PARTNER_CODE,
    PARTNER_SWIFT_CODE,
    PAYMENT_MISSING
) AS
SELECT
  pay.id,
  fd.organization_id,
  fd.organization_name,
  fd.organization_code,
  fd.organization_swift_code,
  fd.document_type_id, 
  fd.document_type_code,
  fd.document_type_name,
  fd.period_id,
  fd.document_code, 
  fd.document_date,
  fd.user_id,
  fd.usrname,
  fd.contract_id,
  fd.reason_document_id,
  fd.reason,
  fd.note,
  fd.currency_id,
  fd.amount_with_tax,
  fd.tax_amount, 
  fd.amount,
  fd.currency_amount_with_tax,
  fd.currency_tax_amount,
  fd.currency_amount,
  fd.total,
  fd.total_with_tax,
  fd.tax_total,
  fd.currency_total,
  fd.currency_total_with_tax,
  fd.currency_tax_total,
  fd.document_amount,
  fd.document_total,
  fd.currency_document_amount,
  fd.currency_document_total,
  pay.partner_bank_account_id,
  prt_ba.account_no as partner_bank_account_no,
  prt_bk.bank_swift_code as partner_bank_swift_code,
  prt_bk.name as partner_bank_name,
  prt_bk.city_name as partner_bank_city_name,
  pay.organization_bank_account_id,
  org_ba.account_no as organization_bank_account_no,
  org_bk.bank_swift_code as organization_bank_swift_code,
  org_bk.name as organization_bank_name,
  org_bk.city_name as organization_bank_city_name,
  fd.partner_id,
  prt.name as partner_name,
  prt.code as partner_code,
  prt.swift_code as partner_swift_code,
  pay.payment_missing
 FROM payment_income pay
 INNER JOIN v_finance_document fd ON fd.id = pay.id
 INNER JOIN organization org ON org.id= fd.organization_id
 INNER JOIN bank_account org_ba ON org_ba.id = pay.organization_bank_account_id
 INNER JOIN v_bank org_bk ON org_bk.id = org_ba.bank_id
 INNER JOIN bank_account prt_ba ON prt_ba.id = pay.partner_bank_account_id
 INNER JOIN v_bank prt_bk ON prt_bk.id = prt_ba.bank_id
 INNER JOIN partner prt ON prt.id = fd.partner_id;
 
CREATE VIEW V_PAYMENT_OUTCOME (
    ID,
    ORGANIZATION_ID,
    ORGANIZATION_NAME,
    ORGANIZATION_CODE,
    ORGANIZATION_SWIFT_CODE,
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
    PARTNER_BANK_SWIFT_CODE,
    PARTNER_BANK_NAME,
    PARTNER_BANK_CITY_NAME,
    ORGANIZATION_BANK_ACCOUNT_ID,
    ORGANIZATION_BANK_ACCOUNT_NO,
    ORGANIZATION_BANK_SWIFT_CODE,
    ORGANIZATION_BANK_NAME,
    ORGANIZATION_BANK_CITY_NAME,
    PARTNER_ID,
    PARTNER_NAME,
    PARTNER_CODE,
    PARTNER_SWIFT_CODE,
    PAYMENT_MISSING
) AS
SELECT
  pay.id,
  fd.organization_id,
  fd.organization_name,
  fd.organization_code,
  fd.organization_swift_code,
  fd.document_type_id, 
  fd.document_type_code,
  fd.document_type_name,
  fd.period_id,
  fd.document_code, 
  fd.document_date,
  fd.user_id,
  fd.usrname,
  fd.contract_id,
  fd.reason_document_id,
  fd.reason,
  fd.note,
  fd.currency_id,
  fd.amount_with_tax,
  fd.tax_amount, 
  fd.amount,
  fd.currency_amount_with_tax,
  fd.currency_tax_amount,
  fd.currency_amount,
  fd.total,
  fd.total_with_tax,
  fd.tax_total,
  fd.currency_total,
  fd.currency_total_with_tax,
  fd.currency_tax_total,
  fd.document_amount,
  fd.document_total,
  fd.currency_document_amount,
  fd.currency_document_total,
  pay.partner_bank_account_id,
  prt_ba.account_no as partner_bank_account_no,
  prt_bk.bank_swift_code as partner_bank_swift_code,
  prt_bk.name as partner_bank_name,
  prt_bk.city_name as partner_bank_city_name,
  pay.organization_bank_account_id,
  org_ba.account_no as organization_bank_account_no,
  org_bk.bank_swift_code as organization_bank_swift_code,
  org_bk.name as organization_bank_name,
  org_bk.city_name as organization_bank_city_name,
  fd.partner_id,
  prt.name as partner_name,
  prt.code as partner_code,
  prt.swift_code as partner_swift_code,
  pay.payment_missing
 FROM payment_outcome pay
 INNER JOIN v_finance_document fd ON fd.id = pay.id
 INNER JOIN organization org ON org.id= fd.organization_id
 INNER JOIN bank_account org_ba ON org_ba.id = pay.organization_bank_account_id
 INNER JOIN v_bank org_bk ON org_bk.id = org_ba.bank_id
 INNER JOIN bank_account prt_ba ON prt_ba.id = pay.partner_bank_account_id
 INNER JOIN v_bank prt_bk ON prt_bk.id = prt_ba.bank_id
 INNER JOIN partner prt ON prt.id = fd.partner_id;
 
 

CREATE VIEW V_PAYMENT (
    ID,
    ORGANIZATION_ID,
    DEBIT_PARTNER_ID,
    DEBIT_PARTNER_NAME,
    DEBIT_PARTNER_CODE,
    DEBIT_PARTNER_SWIFT_CODE,
    CREDIT_PARTNER_ID,
    CREDIT_PARTNER_NAME,
    CREDIT_PARTNER_CODE,
    CREDIT_PARTNER_SWIFT_CODE,
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
    DEBIT_PARTNER_BANK_SWIFT_CODE,
    DEBIT_PARTNER_BANK_NAME,
    DEBIT_PARTNER_BANK_CITY_NAME,
    CREDIT_PARTNER_BANK_ACCOUNT_NO,
    CREDIT_PARTNER_BANK_SWIFT_CODE,
    CREDIT_PARTNER_BANK_NAME,
    CREDIT_PARTNER_BANK_CITY_NAME,
    PAYMENT_MISSING
) AS
SELECT
  p.id,
  p.organization_id,
  p.organization_id,
  p.organization_name,
  p.organization_code,
  p.organization_swift_code,
  p.partner_id,
  p.partner_name,
  p.partner_code,
  p.partner_swift_code,
  p.document_type_id,
  p.document_type_code,
  p.document_type_name,
  p.period_id,
  p.document_code,
  p.document_date,
  p.user_id,
  p.usrname,
  p.contract_id,
  p.reason_document_id,
  p.reason,
  p.note,
  p.currency_id,
  p.amount_with_tax,
  p.tax_amount,
  p.amount,
  p.currency_amount_with_tax,
  p.currency_tax_amount,
  p.currency_amount,
  p.total,
  p.total_with_tax,
  p.tax_total,
  p.currency_total,
  p.currency_total_with_tax,
  p.currency_tax_total,
  p.document_amount,
  p.document_total,
  p.currency_document_amount,
  p.currency_document_total,
  p.organization_bank_account_no,
  p.organization_bank_swift_code,
  p.organization_bank_name,
  p.organization_bank_city_name,
  p.partner_bank_account_no,
  p.partner_bank_swift_code,
  p.partner_bank_name,
  p.partner_bank_city_name,
  p.payment_missing
 FROM v_payment_outcome p
 UNION ALL
SELECT
  p.id,
  p.organization_id,
  p.partner_id,
  p.partner_name,
  p.partner_code,
  p.partner_swift_code,
  p.organization_id,
  p.organization_name,
  p.organization_code,
  p.organization_swift_code,
  p.document_type_id,
  p.document_type_code,
  p.document_type_name,
  p.period_id,
  p.document_code,
  p.document_date,
  p.user_id,
  p.usrname,
  p.contract_id,
  p.reason_document_id,
  p.reason,
  p.note,
  p.currency_id,
  p.amount_with_tax,
  p.tax_amount,
  p.amount,
  p.currency_amount_with_tax,
  p.currency_tax_amount,
  p.currency_amount,
  p.total,
  p.total_with_tax,
  p.tax_total,
  p.currency_total,
  p.currency_total_with_tax,
  p.currency_tax_total,
  p.document_amount,
  p.document_total,
  p.currency_document_amount,
  p.currency_document_total,
  p.partner_bank_account_no,
  p.partner_bank_swift_code,
  p.partner_bank_name,
  p.partner_bank_city_name,
  p.organization_bank_account_no,
  p.organization_bank_swift_code,
  p.organization_bank_name,
  p.organization_bank_city_name,
  p.payment_missing
 FROM v_payment_income p;
 
 
CREATE VIEW V_PAYMENT_ROTATE (
    ID,
    ORGANIZATION_ID,
    PARTNER_ID,
    PARTNER_NAME,
    PARTNER_CODE,
    PARTNER_SWIFT_CODE,
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
    PARTNER_BANK_SWIFT_CODE,
    PARTNER_BANK_NAME,
    PARTNER_BANK_CITY_NAME,
    ORGANIZATION_BANK_ACCOUNT_ID,
    ORGANIZATION_BANK_ACCOUNT_NO,
    ORGANIZATION_BANK_SWIFT_CODE,
    ORGANIZATION_BANK_NAME,
    ORGANIZATION_BANK_CITY_NAME,
    PAYMENT_MISSING
) AS
SELECT
  p.id,
  p.organization_id,
  p.partner_id,
  p.partner_name,
  p.partner_code,
  p.partner_swift_code,
  p.document_type_id,
  p.document_type_code,
  p.document_type_name,
  p.period_id,
  p.document_code,
  p.document_date,
  p.user_id,
  p.usrname,
  p.contract_id,
  p.reason_document_id,
  p.reason,
  p.note,
  p.currency_id,
  p.document_total as debit_amount,
  0.0 as credit_amount,
  p.partner_bank_account_id,
  p.partner_bank_account_no,
  p.partner_bank_swift_code,
  p.partner_bank_name,
  p.partner_bank_city_name,
  p.organization_bank_account_id,
  p.organization_bank_account_no,
  p.organization_bank_swift_code,
  p.organization_bank_name,
  p.organization_bank_city_name,
  p.payment_missing
 FROM v_payment_outcome p
 UNION ALL
SELECT
  p.id,
  p.organization_id,
  p.partner_id,
  p.partner_name,
  p.partner_code,
  p.partner_swift_code,
  p.document_type_id,
  p.document_type_code,
  p.document_type_name,
  p.period_id,
  p.document_code,
  p.document_date,
  p.user_id,
  p.usrname,
  p.contract_id,
  p.reason_document_id,
  p.reason,
  p.note,
  p.currency_id,
  0.0 as debit_amount,
  p.document_total as credit_amount,
  p.partner_bank_account_id,
  p.partner_bank_account_no,
  p.partner_bank_swift_code,
  p.partner_bank_name,
  p.partner_bank_city_name,
  p.organization_bank_account_id,
  p.organization_bank_account_no,
  p.organization_bank_swift_code,
  p.organization_bank_name,
  p.organization_bank_city_name,
  p.payment_missing
 FROM v_payment_income p;


CREATE VIEW v_businessable (
  id, 
  owner_id, 
  entity_id, 
  entity_code, 
  entity_name, 
  name
) AS 
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, CAST(o.name AS VARCHAR(100))
 FROM businessable b
 INNER JOIN department o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'DEPARTMENT'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, CAST(o.name AS VARCHAR(100))
 FROM businessable b
 INNER JOIN store o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'STORE'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, CAST(o.name AS VARCHAR(100))
 FROM businessable b
 INNER JOIN drugstore o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'DRUGSTORE'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, CAST(o.name AS VARCHAR(100))
 FROM businessable b
 INNER JOIN shop o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'SHOP'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, CAST(o.name AS VARCHAR(100))
 FROM businessable b
 INNER JOIN brigade o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'BRIGADE'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, CAST(o.name AS VARCHAR(100))
 FROM businessable b
 INNER JOIN workshop o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'WORKSHOP'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, CAST(o.name AS VARCHAR(100))
 FROM businessable b
 INNER JOIN factory o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'FACTORY'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, CAST(o.name AS VARCHAR(100))
 FROM businessable b
 INNER JOIN works o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'WORKS'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, CAST(o.responsible_name AS VARCHAR(100))
 FROM businessable b
 INNER JOIN v_responsible o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'RESPONSIBLE'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, CAST(o.name AS VARCHAR(100))
 FROM businessable b
 INNER JOIN partner o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'PARTNER'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, CAST(o.name AS VARCHAR(100))
 FROM businessable b
 INNER JOIN v_bank o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'BANK'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, CAST(o.product_name AS VARCHAR(100))
 FROM businessable b
 INNER JOIN v_goods o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'GOODS'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, CAST(o.product_name AS VARCHAR(100))
 FROM businessable b
 INNER JOIN v_asset o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'ASSET'
UNION ALL
SELECT b.id, b.owner_id, b.entity_id, e.code, e.name, CAST(o.name AS VARCHAR(100))
 FROM businessable b
 INNER JOIN v_employee o ON o.id = b.owner_id
 INNER JOIN system_entity e ON e.id = b.entity_id
 WHERE e.code = 'EMPLOYEE';

CREATE VIEW v_partner_register (
 id,
 organization_id,
 period_id,
 partner_id,
 debit_amount,
 credit_amount
) AS 
SELECT 
 r.id,
 r.organization_id,
 r.period_id,
 r.partner_id,
 r.debit_amount,
 r.credit_amount
 FROM partner_register r;


CREATE VIEW v_partner_move (
  id,
  document_id,
  partner_id,
  partner_name,
  amount,
  amount_with_tax,
  tax_amount
) AS
SELECT 
  m.id,
  m.owner_id as document_id,
  m.partner_id,
  p.name as partner_name,
  m.amount,
  m.amount_with_tax,
  m.tax_amount
 FROM partner_move m
 INNER JOIN partner p ON p.id = m.partner_id;

CREATE VIEW v_goods_register (
 id,
 organization_id,
 period_id,
 goods_id,
 quantity,
 price,
 amount
) AS
SELECT 
 r.id,
 r.organization_id,
 r.period_id,
 r.product_id as goods_id,
 r.quantity,
 r.price,
 r.amount
FROM product_register r
INNER JOIN goods g ON g.id = r.product_id;


CREATE VIEW v_goods_detail_register (
 id,
 organization_id,
 period_id,
 goods_id,
 warehouse_id,
 responsible_id,
 quantity,
 amount
) AS
SELECT 
 r.id,
 r.organization_id,
 r.period_id,
 r.product_id as goods_id,
 r.warehouse_id,
 r.responsible_id,
 r.quantity,
 r.amount
FROM product_detail_register r
INNER JOIN goods g ON g.id = r.product_id;



CREATE VIEW v_goods_sale (
  period_id,
  organization_id,
  document_id,
  document_code,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  quantity,
  amount,
  document_amount
) AS
SELECT 
  fd.period_id,
  fd.organization_id,
  fd.id as document_id,
  fd.document_code,
  fd.document_date,
  fd.document_year,
  fd.document_month,
  i.product_id,
  i.product_code,
  i.product_name,
  i.item_unit_id,
  i.unit_id,
  i.unit_name,
  i.product_price,
  i.item_account_price as price,
  i.item_price as item_price,
  i.account_quantity as quantity,
  i.item_amount as amount,
  fd.document_amount
 FROM v_product_move i
 INNER JOIN v_finance_document fd ON fd.id = i.document_id
 INNER JOIN document_type t ON t.id = fd.document_type_id 
 AND t.document_section = 'GOODS' AND t.document_category = 'SALE';

/* USE IS_COMPLETE */


CREATE VIEW v_goods_purchase (
  period_id,
  organization_id,
  document_id,
  document_code,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  quantity,
  amount,
  document_amount,
  warehouse_id,
  warehouse_name,
  partner_id,
  partner_name
) AS
SELECT 
  fd.period_id,
  fd.organization_id,
  fd.id as document_id,
  fd.document_code,
  fd.document_date,
  fd.document_year,
  fd.document_month,
  i.product_id,
  i.product_code,
  i.product_name,
  i.item_unit_id,
  i.unit_id,
  i.unit_name,
  i.product_price,
  i.item_account_price as price,
  i.item_price as item_price,
  i.account_quantity as quantity,
  i.item_amount as amount,
  fd.document_amount,
  sto.warehouse_id,
  sto.warehouse_name,
  prt.partner_id,
  prt.partner_name
 FROM v_product_move i
 INNER JOIN v_finance_document fd ON fd.id = i.document_id
 INNER JOIN v_warehouse_move sto ON sto.document_id = fd.id
 INNER JOIN v_partner_move prt ON prt.document_id = fd.id
 INNER JOIN document_type t ON t.id = fd.document_type_id 
 AND t.document_section = 'GOODS' AND t.document_category = 'PURCHASE';

/* USE IS_COMPLETE */


CREATE VIEW v_rpt_goods_income (
  period_id,
  organization_id,
  document_id,
  document_code,
  document_date,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  price,
  quantity,
  amount,
  document_amount,
  warehouse_id,
  warehouse_name,
  partner_id,
  partner_name
) AS
SELECT
  fd.period_id,
  fd.organization_id,
  i.goods_income_id,
  fd.document_code,
  fd.document_date,
  i.product_id,
  p.product_code,
  p.product_name,
  i.unit_id,
  i.unit_id,
  u.name,
  i.price,
  i.quantity,
  i.amount,
  fd.document_amount,
  d.warehouse_id,
  sto.name,
  fd.partner_id,
  prt.name
 FROM goods_income_item i
 INNER JOIN goods_income d ON d.id = i.goods_income_id
 INNER JOIN v_finance_document fd ON fd.id = d.id
 INNER JOIN v_product p ON p.id = i.product_id
 INNER JOIN unit u ON u.id = i.unit_id
 INNER JOIN v_warehouse sto ON sto.id = d.warehouse_id
 INNER JOIN partner prt ON prt.id = fd.partner_id;
 

CREATE VIEW v_rpt_goods_outcome (
  period_id,
  organization_id,
  document_id,
  document_code,
  document_date,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  price,
  quantity,
  amount,
  document_amount,
  warehouse_id,
  warehouse_name,
  partner_id,
  partner_name
) AS
SELECT 
  fd.period_id,
  fd.organization_id,
  i.goods_outcome_id,
  fd.document_code,
  fd.document_date,
  i.product_id,
  p.product_code,
  p.product_name,
  i.unit_id,
  i.unit_id,
  u.name,
  i.price,
  i.quantity,
  i.amount,
  fd.document_amount,
  d.warehouse_id,
  sto.name,
  fd.partner_id,
  prt.name
 FROM goods_outcome_item i
 INNER JOIN goods_outcome d ON d.id = i.goods_outcome_id
 INNER JOIN v_finance_document fd ON fd.id = d.id
 INNER JOIN v_product p ON p.id = i.product_id
 INNER JOIN unit u ON u.id = i.unit_id
 INNER JOIN v_warehouse sto ON sto.id = d.warehouse_id
 INNER JOIN partner prt ON prt.id = fd.partner_id;


CREATE VIEW v_rpt_goods_rest (
  period_id,
  organization_id,
  document_id,
  document_code,
  document_date,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  quantity,
  price,
  amount,
  warehouse_id
) AS
SELECT 
  fd.period_id,
  fd.organization_id,
  i.goods_rest_id,
  fd.document_code,
  fd.document_date,
  i.product_id,
  p.product_code,
  p.product_name,
  i.unit_id,
  p.unit_id,
  u.name,
  p.price as product_price,
  i.account_quantity as quantity,
  i.account_price as price,
  i.amount,
  d.warehouse_id
 FROM goods_rest_item i
 INNER JOIN goods_rest d ON d.id = i.goods_rest_id
 INNER JOIN v_finance_document fd ON fd.id = d.id
 INNER JOIN v_product p ON p.id = i.product_id
 INNER JOIN unit u ON u.id = p.unit_id;

CREATE VIEW v_rpt_invoice (
  period_id,
  organization_id,
  invoice_id,
  document_code,
  document_date,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  price,
  quantity,
  amount,
  document_amount,
  partner_id,
  partner_name
) AS
SELECT 
  fd.period_id,
  fd.organization_id,
  i.invoice_id,
  fd.document_code,
  fd.document_date,
  i.product_id,
  p.product_code,
  p.product_name,
  i.unit_id,
  i.unit_id,
  u.name,
  i.price,
  i.quantity,
  i.amount,
  fd.document_amount,
  fd.partner_id,
  prt.name
 FROM invoice_item i
 INNER JOIN invoice d ON d.id = i.invoice_id
 INNER JOIN v_finance_document fd ON fd.id = d.id 
 INNER JOIN v_product p ON p.id = i.product_id
 INNER JOIN unit u ON u.id = i.unit_id
 INNER JOIN partner prt ON prt.id = fd.partner_id;

CREATE VIEW v_rpt_goods_register (
  period_id,
  organization_id,
  goods_id,
  product_code,
  product_name,
  unit_id,
  unit_name,
  product_price,
  price,
  quantity,
  amount
) AS
SELECT 
  r.period_id,
  r.organization_id,
  r.goods_id,
  p.product_code,
  p.product_name,
  p.unit_id,
  u.name,
  p.price as product_price,
  r.price,
  r.quantity,
  r.amount
 FROM v_goods_register r
 INNER JOIN goods g ON g.id = r.goods_id
 INNER JOIN v_product p ON p.id = g.id
 INNER JOIN unit u ON u.id = p.unit_id;

CREATE VIEW v_rpt_goods_sale (
  period_id,
  organization_id,
  document_id,
  document_code,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  quantity,
  amount,
  document_amount,
  warehouse_id,
  warehouse_name,
  partner_id,
  partner_name
) AS
SELECT
  s.period_id,
  s.organization_id,
  s.document_id,
  s.document_code,
  s.document_date,
  s.document_year,
  s.document_month,
  s.product_id,
  s.product_code,
  s.product_name,
  s.item_unit_id,
  s.unit_id,
  s.unit_name,
  s.product_price,
  s.price,
  s.item_price,
  s.quantity,
  s.amount,
  s.document_amount,
  wrh.warehouse_id,
  wrh.warehouse_name,
  prt.partner_id,
  prt.partner_name
 FROM v_goods_sale s
 INNER JOIN v_warehouse_move wrh ON wrh.document_id = s.document_id
 INNER JOIN v_partner_move prt ON prt.document_id = s.document_id;

/* 
   HSQL implementation 
 
   Use Views
*/

/* Create Views by month (TEST/DEMO) */

/* 01 Month Jan */
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
  r.period_id,
  r.organization_id,
  r.document_date,
  r.document_year,
  r.document_month,
  r.product_id,
  r.product_code,
  r.product_name,
  r.item_unit_id,
  r.unit_id,
  r.unit_name,
  r.product_price,
  r.price,
  r.item_price,
  r.quantity as q01, 0.0 as q02, 0.0 as q03, 0.0 as q04, 0.0 as q05, 0.0 as q06, 0.0 as q07, 0.0 as q08, 0.0 as q09, 0.0 as q10, 0.0 as q11, 0.0 as q12, 
  r.amount as s01,   0.0 as s02, 0.0 as s03, 0.0 as s04, 0.0 as s05, 0.0 as s06, 0.0 as s07, 0.0 as s08, 0.0 as s09, 0.0 as s10, 0.0 as s11, 0.0 as s12 
 FROM v_goods_sale r
 WHERE r.document_month = 1;


/* 02 Month Feb */
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
  r.period_id,
  r.organization_id,
  r.document_date,
  r.document_year,
  r.document_month,
  r.product_id,
  r.product_code,
  r.product_name,
  r.item_unit_id,
  r.unit_id,
  r.unit_name,
  r.product_price,
  r.price,
  r.item_price,
  0.0 as q01, r.quantity as q02, 0.0 as q03, 0.0 as q04, 0.0 as q05, 0.0 as q06, 0.0 as q07, 0.0 as q08, 0.0 as q09, 0.0 as q10, 0.0 as q11, 0.0 as q12, 
  0.0 as s01, r.amount as s02, 0.0 as s03, 0.0 as s04, 0.0 as s05, 0.0 as s06, 0.0 as s07, 0.0 as s08, 0.0 as s09, 0.0 as s10, 0.0 as s11, 0.0 as s12 
 FROM v_goods_sale r
 WHERE r.document_month = 2;

/* 03 Month Mar */
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
  r.period_id,
  r.organization_id,
  r.document_date,
  r.document_year,
  r.document_month,
  r.product_id,
  r.product_code,
  r.product_name,
  r.item_unit_id,
  r.unit_id,
  r.unit_name,
  r.product_price,
  r.price,
  r.item_price,
  0.0 as q01, 0.0 as q02, r.quantity as q03, 0.0 as q04, 0.0 as q05, 0.0 as q06, 0.0 as q07, 0.0 as q08, 0.0 as q09, 0.0 as q10, 0.0 as q11, 0.0 as q12, 
  0.0 as s01, 0.0 as s02, r.amount as s03, 0.0 as s04, 0.0 as s05, 0.0 as s06, 0.0 as s07, 0.0 as s08, 0.0 as s09, 0.0 as s10, 0.0 as s11, 0.0 as s12 
 FROM v_goods_sale r
 WHERE r.document_month = 3;

/* 04 Month Apr */
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
  r.period_id,
  r.organization_id,
  r.document_date,
  r.document_year,
  r.document_month,
  r.product_id,
  r.product_code,
  r.product_name,
  r.item_unit_id,
  r.unit_id,
  r.unit_name,
  r.product_price,
  r.price,
  r.item_price,
  0.0 as q01, 0.0 as q02, 0.0 as q03, r.quantity as q04, 0.0 as q05, 0.0 as q06, 0.0 as q07, 0.0 as q08, 0.0 as q09, 0.0 as q10, 0.0 as q11, 0.0 as q12, 
  0.0 as s01, 0.0 as s02, 0.0 as s03, r.amount as s04, 0.0 as s05, 0.0 as s06, 0.0 as s07, 0.0 as s08, 0.0 as s09, 0.0 as s10, 0.0 as s11, 0.0 as s12 
 FROM v_goods_sale r
 WHERE r.document_month = 4;

/* 05 Month May */
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
  r.period_id,
  r.organization_id,
  r.document_date,
  r.document_year,
  r.document_month,
  r.product_id,
  r.product_code,
  r.product_name,
  r.item_unit_id,
  r.unit_id,
  r.unit_name,
  r.product_price,
  r.price,
  r.item_price,
  0.0 as q01, 0.0 as q02, 0.0 as q03, 0.0 as q04, r.quantity as q05, 0.0 as q06, 0.0 as q07, 0.0 as q08, 0.0 as q09, 0.0 as q10, 0.0 as q11, 0.0 as q12, 
  0.0 as s01, 0.0 as s02, 0.0 as s03, 0.0 as s04, r.amount as s05, 0.0 as s06, 0.0 as s07, 0.0 as s08, 0.0 as s09, 0.0 as s10, 0.0 as s11, 0.0 as s12 
 FROM v_goods_sale r
 WHERE r.document_month = 5;

/* 06 Month Jun */
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
  r.period_id,
  r.organization_id,
  r.document_date,
  r.document_year,
  r.document_month,
  r.product_id,
  r.product_code,
  r.product_name,
  r.item_unit_id,
  r.unit_id,
  r.unit_name,
  r.product_price,
  r.price,
  r.item_price,
  0.0 as q01, 0.0 as q02, 0.0 as q03, 0.0 as q04, 0.0 as q05, r.quantity as q06, 0.0 as q07, 0.0 as q08, 0.0 as q09, 0.0 as q10, 0.0 as q11, 0.0 as q12, 
  0.0 as s01, 0.0 as s02, 0.0 as s03, 0.0 as s04, 0.0 as s05, r.amount as s06, 0.0 as s07, 0.0 as s08, 0.0 as s09, 0.0 as s10, 0.0 as s11, 0.0 as s12 
 FROM v_goods_sale r
 WHERE r.document_month = 6;

/* 07 Month Jul */
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
  r.period_id,
  r.organization_id,
  r.document_date,
  r.document_year,
  r.document_month,
  r.product_id,
  r.product_code,
  r.product_name,
  r.item_unit_id,
  r.unit_id,
  r.unit_name,
  r.product_price,
  r.price,
  r.item_price,
  0.0 as q01, 0.0 as q02, 0.0 as q03, 0.0 as q04, 0.0 as q05, 0.0 as q06, r.quantity as q07, 0.0 as q08, 0.0 as q09, 0.0 as q10, 0.0 as q11, 0.0 as q12, 
  0.0 as s01, 0.0 as s02, 0.0 as s03, 0.0 as s04, 0.0 as s05, 0.0 as s06, r.amount as s07, 0.0 as s08, 0.0 as s09, 0.0 as s10, 0.0 as s11, 0.0 as s12 
 FROM v_goods_sale r
 WHERE r.document_month = 7;

/* 08 Month Aug */
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
  r.period_id,
  r.organization_id,
  r.document_date,
  r.document_year,
  r.document_month,
  r.product_id,
  r.product_code,
  r.product_name,
  r.item_unit_id,
  r.unit_id,
  r.unit_name,
  r.product_price,
  r.price,
  r.item_price,
  0.0 as q01, 0.0 as q02, 0.0 as q03, 0.0 as q04, 0.0 as q05, 0.0 as q06, 0.0 as q07, r.quantity as q08, 0.0 as q09, 0.0 as q10, 0.0 as q11, 0.0 as q12, 
  0.0 as s01, 0.0 as s02, 0.0 as s03, 0.0 as s04, 0.0 as s05, 0.0 as s06, 0.0 as s07, r.amount as s08, 0.0 as s09, 0.0 as s10, 0.0 as s11, 0.0 as s12 
 FROM v_goods_sale r
 WHERE r.document_month = 8;

/* 09 Month Sep */
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
  r.period_id,
  r.organization_id,
  r.document_date,
  r.document_year,
  r.document_month,
  r.product_id,
  r.product_code,
  r.product_name,
  r.item_unit_id,
  r.unit_id,
  r.unit_name,
  r.product_price,
  r.price,
  r.item_price,
  0.0 as q01, 0.0 as q02, 0.0 as q03, 0.0 as q04, 0.0 as q05, 0.0 as q06, 0.0 as q07, 0.0 as q08, r.quantity as q09, 0.0 as q10, 0.0 as q11, 0.0 as q12, 
  0.0 as s01, 0.0 as s02, 0.0 as s03, 0.0 as s04, 0.0 as s05, 0.0 as s06, 0.0 as s07, 0.0 as s08, r.amount as s09, 0.0 as s10, 0.0 as s11, 0.0 as s12 
 FROM v_goods_sale r
 WHERE r.document_month = 9;

/* 10 Month Oct */
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
  r.period_id,
  r.organization_id,
  r.document_date,
  r.document_year,
  r.document_month,
  r.product_id,
  r.product_code,
  r.product_name,
  r.item_unit_id,
  r.unit_id,
  r.unit_name,
  r.product_price,
  r.price,
  r.item_price,
  0.0 as q01, 0.0 as q02, 0.0 as q03, 0.0 as q04, 0.0 as q05, 0.0 as q06, 0.0 as q07, 0.0 as q08, 0.0 as q09, r.quantity as q10, 0.0 as q11, 0.0 as q12, 
  0.0 as s01, 0.0 as s02, 0.0 as s03, 0.0 as s04, 0.0 as s05, 0.0 as s06, 0.0 as s07, 0.0 as s08, 0.0 as s09, r.amount as s10, 0.0 as s11, 0.0 as s12 
 FROM v_goods_sale r
 WHERE r.document_month = 10;

/* 11 Month Nov */
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
  r.period_id,
  r.organization_id,
  r.document_date,
  r.document_year,
  r.document_month,
  r.product_id,
  r.product_code,
  r.product_name,
  r.item_unit_id,
  r.unit_id,
  r.unit_name,
  r.product_price,
  r.price,
  r.item_price,
  0.0 as q01, 0.0 as q02, 0.0 as q03, 0.0 as q04, 0.0 as q05, 0.0 as q06, 0.0 as q07, 0.0 as q08, 0.0 as q09, 0.0 as q10, r.quantity as q11, 0.0 as q12, 
  0.0 as s01, 0.0 as s02, 0.0 as s03, 0.0 as s04, 0.0 as s05, 0.0 as s06, 0.0 as s07, 0.0 as s08, 0.0 as s09, 0.0 as s10, r.amount as s11, 0.0 as s12 
 FROM v_goods_sale r
 WHERE r.document_month = 11;

/* 12 Month Dec */
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
  r.period_id,
  r.organization_id,
  r.document_date,
  r.document_year,
  r.document_month,
  r.product_id,
  r.product_code,
  r.product_name,
  r.item_unit_id,
  r.unit_id,
  r.unit_name,
  r.product_price,
  r.price,
  r.item_price,
  0.0 as q01, 0.0 as q02, 0.0 as q03, 0.0 as q04, 0.0 as q05, 0.0 as q06, 0.0 as q07, 0.0 as q08, 0.0 as q09, 0.0 as q10, 0.0 as q11, r.quantity as q12, 
  0.0 as s01, 0.0 as s02, 0.0 as s03, 0.0 as s04, 0.0 as s05, 0.0 as s06, 0.0 as s07, 0.0 as s08, 0.0 as s09, 0.0 as s10, 0.0 as s11, r.amount as s12 
 FROM v_goods_sale r
 WHERE r.document_month = 12;




/* Create View Sales by monthes */

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
  period_id,
  organization_id,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  q01, q02, q03, q04, q05, q06, q07, q08, q09, q10, q11, q12,
  s01, s02, s03, s04, s05, s06, s07, s08, s09, s10, s11, s12
 FROM v_rpt_goods_sale_month_01 r

UNION ALL

SELECT 
  period_id,
  organization_id,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  q01, q02, q03, q04, q05, q06, q07, q08, q09, q10, q11, q12,
  s01, s02, s03, s04, s05, s06, s07, s08, s09, s10, s11, s12
 FROM v_rpt_goods_sale_month_02 r

UNION ALL

SELECT 
  period_id,
  organization_id,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  q01, q02, q03, q04, q05, q06, q07, q08, q09, q10, q11, q12,
  s01, s02, s03, s04, s05, s06, s07, s08, s09, s10, s11, s12
 FROM v_rpt_goods_sale_month_03 r

UNION ALL

SELECT 
  period_id,
  organization_id,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  q01, q02, q03, q04, q05, q06, q07, q08, q09, q10, q11, q12,
  s01, s02, s03, s04, s05, s06, s07, s08, s09, s10, s11, s12
 FROM v_rpt_goods_sale_month_04 r

UNION ALL

SELECT 
  period_id,
  organization_id,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  q01, q02, q03, q04, q05, q06, q07, q08, q09, q10, q11, q12,
  s01, s02, s03, s04, s05, s06, s07, s08, s09, s10, s11, s12
 FROM v_rpt_goods_sale_month_05 r

UNION ALL

SELECT 
  period_id,
  organization_id,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  q01, q02, q03, q04, q05, q06, q07, q08, q09, q10, q11, q12,
  s01, s02, s03, s04, s05, s06, s07, s08, s09, s10, s11, s12
 FROM v_rpt_goods_sale_month_06 r

UNION ALL

SELECT 
  period_id,
  organization_id,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  q01, q02, q03, q04, q05, q06, q07, q08, q09, q10, q11, q12,
  s01, s02, s03, s04, s05, s06, s07, s08, s09, s10, s11, s12
 FROM v_rpt_goods_sale_month_07 r

UNION ALL

SELECT 
  period_id,
  organization_id,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  q01, q02, q03, q04, q05, q06, q07, q08, q09, q10, q11, q12,
  s01, s02, s03, s04, s05, s06, s07, s08, s09, s10, s11, s12
 FROM v_rpt_goods_sale_month_08 r

UNION ALL

SELECT 
  period_id,
  organization_id,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  q01, q02, q03, q04, q05, q06, q07, q08, q09, q10, q11, q12,
  s01, s02, s03, s04, s05, s06, s07, s08, s09, s10, s11, s12
 FROM v_rpt_goods_sale_month_09 r

UNION ALL

SELECT 
  period_id,
  organization_id,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  q01, q02, q03, q04, q05, q06, q07, q08, q09, q10, q11, q12,
  s01, s02, s03, s04, s05, s06, s07, s08, s09, s10, s11, s12
 FROM v_rpt_goods_sale_month_10 r

UNION ALL

SELECT 
  period_id,
  organization_id,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  q01, q02, q03, q04, q05, q06, q07, q08, q09, q10, q11, q12,
  s01, s02, s03, s04, s05, s06, s07, s08, s09, s10, s11, s12
 FROM v_rpt_goods_sale_month_11 r

UNION ALL

SELECT 
  period_id,
  organization_id,
  document_date,
  document_year,
  document_month,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  price,
  item_price,
  q01, q02, q03, q04, q05, q06, q07, q08, q09, q10, q11, q12,
  s01, s02, s03, s04, s05, s06, s07, s08, s09, s10, s11, s12
 FROM v_rpt_goods_sale_month_12 r;






/* Sales by monthes (Jan - Dec) */

CREATE VIEW v_rpt_goods_sale_year (
  period_id,
  organization_id,
  document_date,
  document_year,
  document_month,
  s01,
  s02,
  s03,
  s04,
  s05,
  s06,
  s07,
  s08,
  s09,
  s10,
  s11,
  s12 
) AS
SELECT
  period_id,
  organization_id,
  document_date,
  document_year,
  document_month,
  s01,
  s02,
  s03,
  s04,
  s05,
  s06,
  s07,
  s08,
  s09,
  s10,
  s11,
  s12 
FROM v_rpt_goods_sale_year_product;


CREATE VIEW v_rpt_wrh_goods_register (
  period_id,
  organization_id,
  goods_id,
  warehouse_id,
  product_code,
  product_name,
  unit_id,
  unit_name,
  product_price,
  quantity,
  amount
) AS
SELECT 
  r.period_id,
  r.organization_id,
  r.goods_id,
  r.warehouse_id,
  p.product_code,
  p.product_name,
  p.unit_id,
  u.name as unit_name,
  p.price,
  r.quantity,
  r.amount
 FROM v_goods_detail_register r
 INNER JOIN goods g ON g.id = r.goods_id
 INNER JOIN v_product p ON p.id = g.id
 INNER JOIN unit u ON u.id = p.unit_id;



CREATE VIEW v_goods_credit_full (
  period_id,
  organization_id,
  document_code,
  document_date,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  quantity,
  amount
) AS
SELECT 
  fd.period_id,
  fd.organization_id,
  fd.document_code,
  fd.document_date,
  i.product_id,
  i.product_code,
  i.product_name,
  i.item_unit_id,
  i.unit_id,
  i.unit_name,
  i.item_price as item_price,
  i.account_quantity as quantity,
  i.item_amount as amount
 FROM v_product_move i
 INNER JOIN v_finance_document fd ON fd.id = i.document_id
 INNER JOIN warehouse_move sto ON sto.owner_id = fd.id
 INNER JOIN document_type t ON t.id = fd.document_type_id  AND t.document_section = 'GOODS'
 INNER JOIN finance_document_type ft ON t.id = ft.document_type_id 
  AND (ft.move_type = 'INPUT' OR (ft.move_type = 'ROTATE' AND sto.move_type = 'INPUT'));
 



CREATE VIEW v_goods_debit_full (
  period_id,
  organization_id,
  document_code,
  document_date,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  quantity,
  amount
) AS
SELECT 
  fd.period_id,
  fd.organization_id,
  fd.document_code,
  fd.document_date,
  i.product_id,
  i.product_code,
  i.product_name,
  i.item_unit_id,
  i.unit_id,
  i.unit_name,
  i.item_price as item_price,
  i.account_quantity as quantity,
  i.item_amount as amount
 FROM v_product_move i
 INNER JOIN v_finance_document fd ON fd.id = i.document_id
 INNER JOIN warehouse_move sto ON sto.owner_id = fd.id
 INNER JOIN document_type t ON t.id = fd.document_type_id  AND t.document_section = 'GOODS'
 INNER JOIN finance_document_type ft ON t.id = ft.document_type_id 
  AND (ft.move_type = 'OUTPUT' OR (ft.move_type = 'ROTATE' AND sto.move_type = 'OUTPUT'));
 



CREATE VIEW v_rpt_goods_rest_start (
  period_id,
  organization_id,
  product_id,
  product_code,
  product_name,
  unit_id,
  unit_name,
  quantity,
  amount
) AS
SELECT 
  r.period_id,
  r.organization_id,
  r.goods_id,
  r.product_code,
  r.product_name,
  r.unit_id,
  r.unit_name,
  r.quantity,
  r.amount
 FROM v_rpt_goods_register r
UNION ALL
SELECT 
  r.period_id,
  r.organization_id,
  r.product_id,
  r.product_code,
  r.product_name,
  r.unit_id,
  r.unit_name,
  r.quantity,
  r.amount
 FROM v_rpt_goods_rest r;


CREATE VIEW v_rpt_wrh_goods_rest_start (
  period_id,
  organization_id,
  product_id,
  product_code,
  product_name,
  unit_id,
  unit_name,
  quantity,
  amount,
  warehouse_id
) AS
SELECT 
  r.period_id,
  r.organization_id,
  r.goods_id,
  r.product_code,
  r.product_name,
  r.unit_id,
  r.unit_name,
  r.quantity,
  r.amount,
  r.warehouse_id
 FROM v_rpt_wrh_goods_register r
UNION ALL
SELECT 
  r.period_id,
  r.organization_id,
  r.product_id,
  r.product_code,
  r.product_name,
  r.unit_id,
  r.unit_name,
  r.quantity,
  r.amount,
  r.warehouse_id
 FROM v_rpt_goods_rest r;



CREATE VIEW v_rpt_goods_credit_full (
  period_id,
  organization_id,
  document_code,
  document_date,
  warehouse_id,
  partner_id,
  responsible_id,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  quantity,
  amount
) AS
SELECT 
  fd.period_id,
  fd.organization_id,
  fd.document_code,
  fd.document_date,
  sto.warehouse_id,
  prt.partner_id,
  NULL as responsible_id,
  i.product_id,
  i.product_code,
  i.product_name,
  i.item_unit_id,
  i.unit_id,
  i.unit_name,
  i.item_price as item_price,
  i.account_quantity as quantity,
  i.item_amount as amount
 FROM v_product_move i
 INNER JOIN v_finance_document fd ON fd.id = i.document_id
 INNER JOIN warehouse_move sto ON sto.owner_id = fd.id
 LEFT JOIN partner_move prt ON prt.owner_id = fd.id
 INNER JOIN document_type t ON t.id = fd.document_type_id  AND t.document_section = 'GOODS'
 INNER JOIN finance_document_type ft ON t.id = ft.document_type_id 
  AND (ft.move_type = 'INPUT' OR (ft.move_type = 'ROTATE' AND sto.move_type = 'INPUT'));
 



CREATE VIEW v_rpt_goods_debit_full (
  period_id,
  organization_id,
  document_code,
  document_date,
  warehouse_id,
  partner_id,
  responsible_id,
  product_id,
  product_code,
  product_name,
  item_unit_id,
  unit_id,
  unit_name,
  product_price,
  quantity,
  amount
) AS
SELECT 
  fd.period_id,
  fd.organization_id,
  fd.document_code,
  fd.document_date,
  sto.warehouse_id,
  prt.partner_id,
  NULL as responsible_id,
  i.product_id,
  i.product_code,
  i.product_name,
  i.item_unit_id,
  i.unit_id,
  i.unit_name,
  i.item_price as item_price,
  i.account_quantity as quantity,
  i.item_amount as amount
 FROM v_product_move i
 INNER JOIN v_finance_document fd ON fd.id = i.document_id
 INNER JOIN warehouse_move sto ON sto.owner_id = fd.id
 LEFT JOIN partner_move prt ON prt.owner_id = fd.id
 INNER JOIN document_type t ON t.id = fd.document_type_id  AND t.document_section = 'GOODS'
 INNER JOIN finance_document_type ft ON t.id = ft.document_type_id 
  AND (ft.move_type = 'OUTPUT' OR (ft.move_type = 'ROTATE' AND sto.move_type = 'OUTPUT'));
 



CREATE VIEW v_rpt_goods_rotate (
 organization_id,
 period_id, 
 product_id, 
 rest_quantity,
 rest_amount, 
 credit_quantity,
 credit_amount,
 debit_quantity,
 debit_amount
) AS
SELECT r.organization_id, r.period_id, 
 r.product_id, r.quantity as rest_quantity, r.amount as rest_amount, 
 0.0 as credit_quantity, 0.0 as credit_amount,
 0.0 as debit_quantity, 0.0 as debit_amount 
 FROM v_rpt_goods_rest_start r
UNION ALL 
SELECT d.organization_id, d.period_id, 
 d.product_id, 0.0 as rest_quantity, 0.0 as rest_amount, 
 d.quantity as credit_quantity, d.amount as credit_amount,
 0.0 as debit_quantity, 0.0 as debit_amount
 FROM v_goods_credit_full d
UNION ALL 
SELECT c.organization_id, c.period_id, 
 c.product_id, 0.0 as rest_quantity, 0.0 as rest_amount, 
 0.0 as credit_quantity, 0.0 as credit_amount,
 c.quantity as debit_quantity, c.amount as debit_amount
 FROM v_goods_debit_full c;

CREATE VIEW v_partner_rest (
 id,
 period_id,
 organization_id,
 partner_id,
 debit_amount,
 credit_amount
) AS
SELECT
 id,
 period_id,
 organization_id,
 partner_id,
 debit_amount,
 credit_amount
FROM
 partner_rest;

CREATE VIEW v_rpt_partner_register (
  period_id,
  organization_id,
  partner_id,
  partner_name,
  debit_amount,
  credit_amount
) AS
SELECT 
  r.period_id,
  r.organization_id,
  r.partner_id,
  p.name as partner_name,
  r.debit_amount,
  r.credit_amount
 FROM v_partner_register r
 INNER JOIN partner p ON p.id = r.partner_id;

CREATE VIEW v_rpt_partner_rest (
  period_id,
  organization_id,
  partner_id,
  partner_name,
  debit_amount,
  credit_amount
) AS
SELECT 
  r.period_id,
  r.organization_id,
  r.partner_id,
  p.name as partner_name,
  r.debit_amount,
  r.credit_amount
 FROM v_partner_rest r
 INNER JOIN partner p ON p.id = r.partner_id;

CREATE VIEW v_rpt_partner_rest_start (
  period_id,
  organization_id,
  partner_id,
  partner_name,
  credit_amount,
  debit_amount
) AS
SELECT 
  r.period_id,
  r.organization_id,
  r.partner_id,
  r.partner_name,
  r.credit_amount,
  r.debit_amount
 FROM v_rpt_partner_register r
UNION ALL
SELECT 
  r.period_id,
  r.organization_id,
  r.partner_id,
  r.partner_name,
  r.credit_amount,
  r.debit_amount
 FROM v_rpt_partner_rest r;

CREATE VIEW v_rpt_partner_credit_full (
  period_id,
  organization_id,
  document_code,
  document_date,
  partner_id,
  amount
) AS
SELECT 
  fd.period_id,
  fd.organization_id,
  fd.document_code,
  fd.document_date,
  p.partner_id,
  fd.document_total
 FROM v_finance_document fd
 INNER JOIN v_partner_move p ON fd.id = p.document_id
 INNER JOIN document_type t ON t.id = fd.document_type_id
 INNER JOIN finance_document_type ft ON t.id = ft.document_type_id 
 WHERE t.document_section = 'PAYMENT' AND ft.move_type = 'INPUT';


CREATE VIEW v_rpt_partner_debit_full (
  period_id,
  organization_id,
  document_code,
  document_date,
  partner_id,
  amount
) AS
SELECT 
  fd.period_id,
  fd.organization_id,
  fd.document_code,
  fd.document_date,
  p.partner_id,
  fd.document_total
 FROM v_finance_document fd
 INNER JOIN v_partner_move p ON fd.id = p.document_id
 INNER JOIN document_type t ON t.id = fd.document_type_id
 INNER JOIN finance_document_type ft ON t.id = ft.document_type_id 
 WHERE t.document_section = 'PAYMENT' AND ft.move_type = 'OUTPUT';


CREATE VIEW v_rpt_partner_rotate (
 organization_id,
 period_id, 
 partner_id,
 rest_credit_amount, 
 rest_debit_amount, 
 credit_amount,
 debit_amount
) AS
SELECT 
 r.organization_id,
 r.period_id, 
 r.partner_id,
 r.credit_amount as rest_credit_amount, 
 r.debit_amount as rest_debit_amount, 
 0.0 as credit_amount,
 0.0 as debit_amount
FROM v_rpt_partner_rest_start r
UNION ALL 
SELECT 
 c.organization_id,
 c.period_id, 
 c.partner_id,
 0.0 as rest_credit_amount, 
 0.0 as rest_debit_amount, 
 c.amount as credit_amount,
 0.0 as debit_amount
FROM v_rpt_partner_credit_full c
UNION ALL 
SELECT 
 d.organization_id,
 d.period_id, 
 d.partner_id,
 0.0 as rest_credit_amount, 
 0.0 as rest_debit_amount, 
 0.0 as credit_amount,
 d.amount as debit_amount
 FROM v_rpt_partner_debit_full d;

create view V_EMPLOYEE_RESULT (
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
 payroll_AMOUNT,
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
select 
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
 T.payroll_AMOUNT,
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
from EMPLOYEE E left join EMPLOYEE_TOTAL T ON T.EMPLOYEE_ID = E.ID;

CREATE VIEW v_ledger_account_rest (
 id,
 period_id,
 organization_id,
 ledger_account_id,
 debit_amount,
 credit_amount
) AS
SELECT
 id,
 period_id,
 organization_id,
 ledger_account_id,
 debit_amount,
 credit_amount
FROM
 ledger_account_rest;

CREATE VIEW v_ledger_account_register (
 id,
 organization_id,
 period_id,
 ledger_account_id,
 debit_amount,
 credit_amount
) AS 
SELECT 
 r.id,
 r.organization_id,
 r.period_id,
 r.ledger_account_id,
 r.debit_amount,
 r.credit_amount
 FROM ledger_account_register r;


CREATE VIEW v_rpt_ldg_account_rest (
  period_id,
  organization_id,
  ledger_account_id,
  ledger_account_code,
  ledger_account_name,
  debit_amount,
  credit_amount
) AS
SELECT 
  r.period_id,
  r.organization_id,
  r.ledger_account_id,
  a.code as ledger_account_code,
  a.name as ledger_account_name,
  r.debit_amount,
  r.credit_amount
 FROM v_ledger_account_rest r
 INNER JOIN ledger_account a ON a.id = r.ledger_account_id;

CREATE VIEW v_rpt_ldg_account_register (
  period_id,
  organization_id,
  ledger_account_id,
ledger_account_code,
  ledger_account_name,
  debit_amount,
  credit_amount
) AS
SELECT 
  r.period_id,
  r.organization_id,
  r.ledger_account_id,
  a.code as ledger_account_code,
  a.name as ledger_account_name,
  r.debit_amount,
  r.credit_amount
 FROM v_ledger_account_register r
 INNER JOIN ledger_account a ON a.id = r.ledger_account_id;

CREATE VIEW v_rpt_ldg_account_rest_start (
  period_id,
  organization_id,
  ledger_account_id,
  ledger_account_code,
  ledger_account_name,
  credit_amount,
  debit_amount
) AS
SELECT 
  r.period_id,
  r.organization_id,
  r.ledger_account_id,
  r.ledger_account_code,
  r.ledger_account_name,
  r.credit_amount,
  r.debit_amount
 FROM v_rpt_ldg_account_register r
UNION ALL
SELECT 
  r.period_id,
  r.organization_id,
  r.ledger_account_id,
  r.ledger_account_code,
  r.ledger_account_name,
  r.credit_amount,
  r.debit_amount
 FROM v_rpt_ldg_account_rest r;

CREATE VIEW v_rpt_ldg_account_credit_full (
  period_id,
  organization_id,
  document_code,
  document_date,
  ledger_account_id,
  corr_ledger_account_id,
  amount
) AS
SELECT 
  fd.period_id,
  fd.organization_id,
  fd.document_code,
  fd.document_date,
  i.debit_ledger_account_id,
  i.credit_ledger_account_id,
  i.amount
 FROM v_finance_document fd
 INNER JOIN entry_item i ON i.owner_id = fd.id;


CREATE VIEW v_rpt_ldg_account_debit_full (
  period_id,
  organization_id,
  document_code,
  document_date,
  ledger_account_id,
  corr_ledger_account_id,
  amount
) AS
SELECT 
  fd.period_id,
  fd.organization_id,
  fd.document_code,
  fd.document_date,
  i.credit_ledger_account_id,
  i.debit_ledger_account_id,
  i.amount
 FROM v_finance_document fd
 INNER JOIN entry_item i ON i.owner_id = fd.id;


CREATE VIEW v_rpt_ldg_account_rotate (
 organization_id,
 period_id, 
 ledger_account_id,
 rest_credit_amount, 
 rest_debit_amount, 
 credit_amount,
 debit_amount
) AS
SELECT 
 r.organization_id,
 r.period_id, 
 r.ledger_account_id,
 r.credit_amount as rest_credit_amount, 
 r.debit_amount as rest_debit_amount, 
 0.0 as credit_amount,
 0.0 as debit_amount
FROM v_rpt_ldg_account_rest_start r
UNION ALL 
SELECT 
 c.organization_id,
 c.period_id, 
 c.ledger_account_id,
 0.0 as rest_credit_amount, 
 0.0 as rest_debit_amount, 
 c.amount as credit_amount,
 0.0 as debit_amount
FROM v_rpt_ldg_account_credit_full c
UNION ALL 
SELECT 
 d.organization_id,
 d.period_id, 
 d.ledger_account_id,
 0.0 as rest_credit_amount, 
 0.0 as rest_debit_amount, 
 0.0 as credit_amount,
 d.amount as debit_amount
 FROM v_rpt_ldg_account_debit_full d;

CREATE VIEW v_rpt_ldg_account_all (
 organization_id,
 period_id, 
 ledger_account_id
) AS
SELECT 
 r.organization_id,
 r.period_id, 
 r.ledger_account_id
FROM v_rpt_ldg_account_rest_start r
UNION 
SELECT 
 c.organization_id,
 c.period_id, 
 c.ledger_account_id
FROM v_rpt_ldg_account_credit_full c
UNION 
SELECT 
 d.organization_id,
 d.period_id, 
 d.ledger_account_id
 FROM v_rpt_ldg_account_debit_full d;

CREATE VIEW v_rpt_ldg_account_corr (
 organization_id,
 period_id, 
 operation_type,
 ledger_account_id,
 corr_ledger_account_id,
 amount,
 balance_amount
) AS
SELECT 
 c.organization_id,
 c.period_id, 
 1 as operation_type,
 c.ledger_account_id,
 c.corr_ledger_account_id,
 c.amount,
 c.amount
FROM v_rpt_ldg_account_credit_full c
UNION ALL 
SELECT 
 d.organization_id,
 d.period_id, 
 2 as operation_type,
 d.ledger_account_id,
 d.corr_ledger_account_id,
 d.amount,
 d.amount * -1
 FROM v_rpt_ldg_account_debit_full d;

/*                                                       */
/*   PostgreSQL implementation                           */
/*                                                       */
/*   Use functions:                                      */
/*                                                       */
/*   TO_NUMBER(TO_CHAR(document_date, 'YYYY'), '9999')   */
/*   TO_NUMBER(TO_CHAR(document_date, 'MM'), '99')       */
/*                                                       */


CREATE VIEW v_project_date (
  id,
  organization_id,
  start_date,
  end_date,
  actual_end_date,
  start_year,
  end_year,
  actual_end_year,
  start_month,
  end_month,
  actual_end_month,
  start_day,
  end_day,
  actual_end_day
) AS
SELECT
  p.id,
  p.organization_id,
  p.start_date,
  p.end_date,
  p.actual_end_date,
  TO_NUMBER(TO_CHAR(p.start_date, 'YYYY'), '9999'),
  TO_NUMBER(TO_CHAR(p.end_date, 'YYYY'), '9999'),
  TO_NUMBER(TO_CHAR(p.actual_end_date, 'YYYY'), '9999'),
  TO_NUMBER(TO_CHAR(p.start_date, 'MM'), '99'),
  TO_NUMBER(TO_CHAR(p.end_date, 'MM'), '99'),
  TO_NUMBER(TO_CHAR(p.actual_end_date, 'MM'), '99'),
  TO_NUMBER(TO_CHAR(p.start_date, 'DD'), '99'),
  TO_NUMBER(TO_CHAR(p.end_date, 'DD'), '99'),
  TO_NUMBER(TO_CHAR(p.actual_end_date, 'DD'), '99')
FROM project p;


CREATE VIEW v_project_date_ext (
  id,
  organization_id,
  start_date,
  end_date,
  actual_end_date,
  start_year,
  end_year,
  actual_end_year,
  start_month,
  end_month,
  actual_end_month,
  start_day,
  end_day,
  actual_end_day,
  start_day_pos,
  end_day_pos,
  actual_end_day_pos
) AS
SELECT
  p.id,
  p.organization_id,
  p.start_date,
  p.end_date,
  p.actual_end_date,
  p.start_year,
  p.end_year,
  p.actual_end_year,
  p.start_month,
  p.end_month,
  p.actual_end_month,
  p.start_day,
  p.end_day,
  p.actual_end_day,
  p.start_year * 10000 + p.start_month * 100 + p.start_day,
  p.end_year * 10000 + p.end_month * 100 + p.end_day,
  p.actual_end_year * 10000 + p.actual_end_month * 100 + p.actual_end_day
FROM v_project_date p;


CREATE VIEW v_project_year_unique (
  organization_id,
  project_year
) AS
SELECT
  organization_id,
  start_year
FROM v_project_date WHERE start_year IS NOT NULL
UNION 
SELECT
  organization_id,
  end_year
FROM v_project_date  WHERE end_year IS NOT NULL
UNION 
SELECT
  organization_id,
  actual_end_year
FROM v_project_date  WHERE actual_end_year IS NOT NULL;




CREATE VIEW v_project_year_unique_inf (
  organization_id,
  project_year,
  flag_year
) AS
SELECT
  organization_id,
  project_year,
  0
FROM v_project_year_unique WHERE (project_year/4.00 - project_year/4) <> 0
UNION ALL
SELECT
  organization_id,
  project_year,
  1
FROM v_project_year_unique WHERE (project_year/4.00 - project_year/4) = 0;








CREATE VIEW v_project_period_day (
 organization_id,
 year_number,
 month_number,
 month_name,
 day_number,
 day_pos
) AS
SELECT
 py.organization_id,
 py.project_year as year_number,
 sm.month_number,
 sm.name as month_name,
 sd.day_number,
 py.project_year * 10000 + sm.month_number * 100 + sd.day_number
FROM v_project_year_unique_inf py, system_month sm, system_day sd
 WHERE (sd.day_number <= (sm.day_count + py.flag_year));






