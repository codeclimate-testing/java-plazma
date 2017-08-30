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

package org.plazmaforge.bsolution.bank;

import org.plazmaforge.bsolution.bank.common.beans.PaymentDocument;
import org.plazmaforge.bsolution.bank.common.beans.PaymentType;
import org.plazmaforge.bsolution.bank.common.beans.TaxPrintType;
import org.plazmaforge.bsolution.bank.common.services.BankContextService;
import org.plazmaforge.bsolution.bank.common.services.PaymentTypeService;
import org.plazmaforge.bsolution.bank.common.services.TaxPrintTypeService;
import org.plazmaforge.bsolution.base.SessionContext;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.finance.FinanceEnvironment;
import org.plazmaforge.bsolution.partner.common.beans.PartnerTitle;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.service.EntityService;
import org.plazmaforge.framework.platform.Environment;



/**
 * @author Oleh Hapon
 *
 * $Id: BankEnvironment.java,v 1.5 2010/12/05 07:56:01 ohapon Exp $
 * 
 */

public class BankEnvironment extends Environment {

    /** Default PaymentType ID * */
    private static final Integer DEFAULT_PAY_TYPE_ID = new Integer(1);

    /** Default TaxPrintType ID */
    private static final Integer DEFAULT_TAX_PRINT_TYPE_ID = new Integer(1);

    
    public static final int BANK_ACCOUNT_SIZE = 20;
    
    
    private static BankEnvironment instance;

    private BankContext context;

    private BankEnvironment() {
	// context = new BankContext();
    }

    public static BankEnvironment getInstance() {
	if (instance == null) {
	    instance = new BankEnvironment();
	    instance.loadContext();
	}
	return instance;

    }

    /**
     * Load Context
     * 
     */
    private void loadContext() {
	try {
	    context = ((BankContextService) getService(BankContextService.class)).load();

	    if (context == null) {
		throw new Exception("BankContext is null");
	    }

	    if (context.getPaymentType() == null) {
		// Set default
		context.setPaymentType(((EntityService<PaymentType, Integer>) getService(PaymentTypeService.class)).findById(DEFAULT_PAY_TYPE_ID));
	    }

	    if (context.getTaxPrintType() == null) {
		// Set default
		context.setTaxPrintType(((EntityService<TaxPrintType, Integer>) getService(TaxPrintTypeService.class)).findById(DEFAULT_TAX_PRINT_TYPE_ID));
	    }

	} catch (Exception ex) {
	    ex.printStackTrace();
	} finally {
	    if (context == null) {
		context = new BankContext();
	    }
	}

    }

    public static void refresh() throws ApplicationException {
	getInstance().loadContext();
    }

   
    public static BankContext getContext() {
	return getInstance().context;
    }

    public static PartnerTitle getPartner() {
	return getContext().getPartner() == null ? EnterpriseEnvironment
		.getPartner() : getContext().getPartner();
    }

    public static PartnerTitle getIncomePartner() {
	return getContext().getIncomePartner() == null ? EnterpriseEnvironment
		.getCustomer() : getContext().getIncomePartner();
    }

    public static PartnerTitle getOutcomePartner() {
	return getContext().getOutcomePartner() == null ? EnterpriseEnvironment
		.getSupplier() : getContext().getOutcomePartner();
    }

    /**
     * Get default PaymentType
     * 
     * @return
     */
    public static PaymentType getPaymentType() {
	return getContext().getPaymentType();
    }

    /**
     * Get default TaxPrintType
     * 
     * @return
     */
    public static TaxPrintType getTaxPrintType() {
	return getContext().getTaxPrintType();
    }

    /**
     * Initialize PayDocument
     * 
     * @param document
     * @param entityCode
     */
    public static void initPaymentDocument(PaymentDocument document, String entityCode, SessionContext context) {
	FinanceEnvironment.initFinanceDocument(document, entityCode, context);
	document.setPaymentDate(EnterpriseEnvironment.getDate());
	document.setPaymentType(getPaymentType());
	document.setTaxPrintType(getTaxPrintType());
    }

}
