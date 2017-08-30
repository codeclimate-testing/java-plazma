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

import org.plazmaforge.bsolution.bank.common.beans.PaymentType;
import org.plazmaforge.bsolution.bank.common.beans.TaxPrintType;
import org.plazmaforge.bsolution.partner.common.beans.PartnerTitle;
import org.plazmaforge.framework.ext.model.BaseEntity;
import org.plazmaforge.framework.platform.structure.ModuleContext;


/**
 * @author Oleh Hapon
 *
 * $Id: BankContext.java,v 1.4 2010/12/05 07:56:01 ohapon Exp $
 * 
 */
public class BankContext extends BaseEntity implements ModuleContext {

    public static final String INVOICE_REASON_DOCUMENT = "INVOICE";
    
    public static final String ORDER_REASON_DOCUMENT = "ORDER";
    
    public static final String DEFAULT_PAYMENT_REASON_DOCUMENTS = "INVOICE"; //"INVOICE,ORDER";
    
    
    private PartnerTitle partner;

    private PartnerTitle incomePartner;

    private PartnerTitle outcomePartner;

    /** Default PaymentType * */
    private PaymentType paymentType;

    /** Default TaxPrintType * */
    private TaxPrintType taxPrintType;

    /** List of reason documents to payment (INVOICE, ORDER) **/
    private String paymentReasonDocuments;
    
    
    public PartnerTitle getIncomePartner() {
	return incomePartner;
    }

    public void setIncomePartner(PartnerTitle incomePartner) {
	this.incomePartner = incomePartner;
    }

    public PartnerTitle getOutcomePartner() {
	return outcomePartner;
    }

    public void setOutcomePartner(PartnerTitle outcomePartner) {
	this.outcomePartner = outcomePartner;
    }

    public PartnerTitle getPartner() {
	return partner;
    }

    public void setPartner(PartnerTitle partner) {
	this.partner = partner;
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

    public String getPaymentReasonDocuments() {
	if (paymentReasonDocuments == null) {
	    paymentReasonDocuments = DEFAULT_PAYMENT_REASON_DOCUMENTS;
	}
        return paymentReasonDocuments;
    }

    public void setPaymentReasonDocuments(String paymentReasonDocuments) {
        this.paymentReasonDocuments = paymentReasonDocuments;
    }
    
    public String[] getPaymentReasonDocumentArray() {
	return getPaymentReasonDocuments().split(",");
    }

    public boolean hasPaymentReasonDocument(String document) {
	if (document == null) {
	    return false;
	}
	String[] array = getPaymentReasonDocumentArray();
	for (String str : array) {
	    if (document.equals(str)) {
		return true;
	    }
	}
	return false;
    }
    

    
}
