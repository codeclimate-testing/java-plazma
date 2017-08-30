/*
 * Copyright (C) 2005-2010 Oleh Hapon ohapon@users.sourceforge.net
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA.
 *
 * Oleh Hapon
 * Kyiv, UKRAINE
 * ohapon@users.sourceforge.net
 */
package org.plazmaforge.bsolution.base.common.acceptors;


/*
 * Created 30.10.2006
 */
public interface OrganizationAcceptorConstants {

    String ORGANIZATION_ID = "ORGANIZATION_ID";

    String ORGANIZATION_NAME = "ORGANIZATION_NAME";
    
    String ORGANIZATION_IDN = "ORGANIZATION_IDN";
    
    String ORGANIZATION_NEC = "ORGANIZATION_NEC";
    
    String IDN = "IDN";
    
    String ORGANIZATION_ADDRESS = "ORGANIZATION_ADDRESS";
    
    String ORGANIZATION_PHONE = "ORGANIZATION_PHONE";
    

    String PERIOD_ID = "PERIOD_ID";

    String PERIOD_START_DATE = "PERIOD_START_DATE";

    String PERIOD_END_DATE = "PERIOD_END_DATE";

    String START_DATE = "START_DATE";

    String END_DATE = "END_DATE";

    String START_DAY_POS = "START_DAY_POS";

    String END_DAY_POS = "END_DAY_POS";

    String YEAR = "YEAR";
    
    String QUARTER = "QUARTER";
    
    
    String PARTNER_ID = "PARTNER_ID";

    String PARTNER_NAME = "PARTNER_NAME";
    
    String PERSON_NAME = "PERSON_NAME";
    

    String FIRST_NAME = "FIRST_NAME";
    
    String MIDDLE_NAME = "MIDDLE_NAME";
    
    String LAST_NAME = "LAST_NAME";
	
	
    String BANK_ACCOUNT_ID = "BANK_ACCOUNT_ID";

    String BANK_ACCOUNT_NO = "BANK_ACCOUNT_NO";
    
    
    String EMPLOYEE_COUNT = "EMPLOYEE_COUNT";
    
    String EMPLOYEE_COUNT_QUARTER_1 = "EMPLOYEE_COUNT_QUARTER_1";
    
    String EMPLOYEE_COUNT_QUARTER_2 = "EMPLOYEE_COUNT_QUARTER_2";
    
    String EMPLOYEE_COUNT_QUARTER_3 = "EMPLOYEE_COUNT_QUARTER_3";
    
    String EMPLOYEE_COUNT_QUARTER_4 = "EMPLOYEE_COUNT_QUARTER_4";

    
    String GOV_TAX_ORGANIZATION_ID = "GOV_TAX_ORGANIZATION_ID";

    String GOV_TAX_ORGANIZATION_NAME = "GOV_TAX_ORGANIZATION_NAME";

    String GOV_TAX_DEPARTMENT_CODE = "GOV_TAX_DEPARTMENT_CODE";
    
    String GOV_TAX_DEPARTMENT_NAME = "GOV_TAX_DEPARTMENT_NAME";
    
    String GOV_TAX_BANK_ACCOUNT_ID = "GOV_TAX_BANK_ACCOUNT_ID";
    
    String GOV_TAX_DOCUMENT_MARKER = "GOV_TAX_DOCUMENT_MARKER";
    
    
    String GOV_PENSION_ORGANIZATION_ID = "GOV_PENSION_ORGANIZATION_ID";

    String GOV_PENSION_ORGANIZATION_NAME = "GOV_PENSION_ORGANIZATION_NAME";
    
    String GOV_PENSION_DEPARTMENT_CODE = "GOV_PENSION_DEPARTMENT_CODE";
    
    String GOV_PENSION_DEPARTMENT_NAME = "GOV_PENSION_DEPARTMENT_NAME";

    String GOV_PENSION_BANK_ACCOUNT_ID = "GOV_PENSION_BANK_ACCOUNT_ID";
    
    String GOV_PENSION_DOCUMENT_MARKER = "GOV_PENSION_DOCUMENT_MARKER";
    
    
    String ORGANIZATION_ACTIVITY = "ORGANIZATION_ACTIVITY";
    
    String ORGANIZATION_TAX_TYPE = "ORGANIZATION_TAX_TYPE";

    String ORGANIZATION_TAX_REG_CODE = "ORGANIZATION_TAX_REG_CODE";

    String ORGANIZATION_TAX_REG_DATE = "ORGANIZATION_TAX_REG_DATE";

    String ORGANIZATION_PENSION_REG_CODE = "ORGANIZATION_PENSION_REG_CODE";

    String ORGANIZATION_PENSION_REG_DATE = "ORGANIZATION_PENSION_REG_DATE";
    
    
    String REPORT_TYPE = "REPORT_TYPE";
    
    
    String BANK_ACCOUNTS = "BANK_ACCOUNTS";
    
    int SELECT_BANK_ACCOUNT_MODE = 1; // Select documents by bank accounts. Use only for payment documents.
    
    int SELECT_MARKER_MODE = 2; // Select documents by special marker (prefix in payment missing). Use for payment and cash documents 
    
}
