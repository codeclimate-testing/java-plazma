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
package org.plazmaforge.bsolution.bank.common.beans;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.plazmaforge.bsolution.finance.common.beans.FinanceDocument;
import org.plazmaforge.bsolution.finance.common.beans.IPartnerableDocument;


/**
 * @author Oleh Hapon
 * Date: 17.07.2004
 * Time: 13:42:03
 * $Id: PaymentDocument.java,v 1.3 2010/04/28 06:24:27 ohapon Exp $
 */
public class PaymentDocument extends FinanceDocument implements IPartnerableDocument {

    private BankAccount organizationBankAccount;

    private BankAccount partnerBankAccount;

    private PaymentType paymentType;

    private TaxPrintType taxPrintType;

    private Date paymentDate;

    private String paymentMissing;

    
    private List<FinanceDocument> reasonDocuments;
    
    public BankAccount getOrganizationBankAccount() {
	return organizationBankAccount;
    }

    public void setOrganizationBankAccount(BankAccount organizationBankAccount) {
	this.organizationBankAccount = organizationBankAccount;
    }

    public BankAccount getPartnerBankAccount() {
	return partnerBankAccount;
    }

    public void setPartnerBankAccount(BankAccount bankAccount) {
	this.partnerBankAccount = bankAccount;
    }


    public PaymentType getPaymentType() {
	return paymentType;
    }

    public void setPaymentType(PaymentType payType) {
	this.paymentType = payType;
    }

    public TaxPrintType getTaxPrintType() {
	return taxPrintType;
    }

    public void setTaxPrintType(TaxPrintType taxPrintType) {
	this.taxPrintType = taxPrintType;
    }

    public Date getPaymentDate() {
	return paymentDate;
    }

    public void setPaymentDate(Date payDate) {
	this.paymentDate = payDate;
    }

    public String getPaymentMissing() {
	return paymentMissing;
    }

    public void setPaymentMissing(String payMissing) {
	this.paymentMissing = payMissing;
    }

    public String getAccountNo() {
	return getPartnerBankAccount() == null ? null : getPartnerBankAccount()
		.getAccountNo();
    }

    public String getPartnerName() {
	return getPartner() == null ? null : getPartner().getName();
    }

    public List<FinanceDocument> getReasonDocuments() {
	if (reasonDocuments == null) {
	    reasonDocuments = new ArrayList<FinanceDocument>();
	}
        return reasonDocuments;
    }

    public void setReasonDocuments(List<FinanceDocument> reasonDocuments) {
        this.reasonDocuments = reasonDocuments;
    }

    public void addReasonDocument(FinanceDocument reasonDocument) {
        getReasonDocuments().add(reasonDocument);
    }
    
    /**
     * Return doc link.
     * Create new list.
     * @return
     */
    public List<PaymentDocumentLink> getPaymentDocumentLinks() {
	List<PaymentDocumentLink> links = new ArrayList<PaymentDocumentLink>();
	List<FinanceDocument> reasonDocuments = getReasonDocuments();
	for (FinanceDocument reasonDocument : reasonDocuments) {
	    PaymentDocumentLink link = new PaymentDocumentLink();
	    link.setId(reasonDocument.getLinkId());
	    link.setPaymentDocument(this);
	    link.setReasonDocument(reasonDocument);
	    
	    // FIX 2008-10-03: Problem with delete links
	    if (reasonDocument.isDeleted()) {
		link.setDeleted();
	    }
	    
	    links.add(link);
	}
	return links;
    }
}
