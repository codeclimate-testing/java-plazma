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

package org.plazmaforge.bsolution.bank.common;


import org.plazmaforge.bsolution.bank.BankEnvironment;
import org.plazmaforge.bsolution.bank.common.beans.BankAccount;
import org.plazmaforge.bsolution.bank.common.beans.PaymentDocument;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.document.common.beans.Document;
import org.plazmaforge.bsolution.finance.common.FinanceDocumentCreator;
import org.plazmaforge.bsolution.partner.common.beans.IPartnerTitle;
import org.plazmaforge.bsolution.partner.common.beans.Partner;
import org.plazmaforge.bsolution.partner.common.services.PartnerService;
import org.plazmaforge.framework.core.exception.ApplicationException;


/** 
 * @author Oleh Hapon
 * $Id: DefaultPaymentDocumentCreator.java,v 1.3 2010/12/05 07:55:58 ohapon Exp $
 */

public class PaymentDocumentCreator extends FinanceDocumentCreator {
    
    protected void populate(Document parentDocument, Document document) throws ApplicationException {
	if (parentDocument == null || document == null) {
	    return;
	}
	super.populate(parentDocument, document);
	PaymentDocument paymentDocument = (PaymentDocument) document;
	
	Integer organizationId = parentDocument.getOrganizationId();
	if (organizationId == null) {
	    throw new ApplicationException("Organization is null"); 
	}
	IPartnerTitle partner = parentDocument.getPartner();
	if (partner == null) {
	    throw new ApplicationException("Partner is null"); 
	}
	Integer partnerId = partner.getId(); 
	if (partnerId == null) {
	    throw new ApplicationException("Partner ID is null"); 
	}
	
	BankAccount organizationBankAccount = getDefaultPartnerBankAccount(organizationId);
	BankAccount partnerBankAccount = getDefaultPartnerBankAccount(partnerId);

	if (organizationBankAccount == null && partnerBankAccount == null) {
	    throw new ApplicationException("Organization and Partner Bank Accounts are null"); 
	}

	if (organizationBankAccount == null) {
	    throw new ApplicationException("Organization Bank Account is null"); 
	}
	
	if (partnerBankAccount == null) {
	    throw new ApplicationException("Partner Bank Account is null"); 
	}
	
	
	paymentDocument.setOrganizationBankAccount(organizationBankAccount);
	paymentDocument.setPartnerBankAccount(partnerBankAccount);
	
	
	paymentDocument.setPaymentDate(EnterpriseEnvironment.getDate());
	paymentDocument.setPaymentType(BankEnvironment.getPaymentType());
	paymentDocument.setTaxPrintType(BankEnvironment.getTaxPrintType());
	
	paymentDocument.setPaymentMissing("Payment missing");

    }

    protected BankAccount getDefaultPartnerBankAccount(Integer partnerId) throws ApplicationException  {
	return getPartnerService().findDefaultBankAccount(partnerId);
    }

    protected Partner getPartner(Integer id) throws ApplicationException  {
	return (Partner) getPartnerService().findById(id);
    }
    
    protected PartnerService getPartnerService() {
	return (PartnerService) getService(PartnerService.class);
    }
    

}
