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

import org.plazmaforge.bsolution.base.common.beans.Currency;
import org.plazmaforge.bsolution.document.common.beans.DocumentHeader;
import org.plazmaforge.bsolution.organization.common.beans.IOrganizable;
import org.plazmaforge.bsolution.organization.common.beans.IOrganizationTitle;


/**
 * @author Oleh Hapon
 *
 * $Id: JournalPayment.java,v 1.2 2010/04/28 06:24:27 ohapon Exp $
 * 
 */

public class JournalPayment extends DocumentHeader implements IOrganizable {

    private IOrganizationTitle organization;


    private Integer periodId;

    private Currency currency;

    private Double debitAmount;

    private Double creditAmount;

    private String partnerName;

    private String partnerBankAccountNo;

    private String organizationBankAccountNo;

    private String paymentMissing;

    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public IOrganizationTitle getOrganization() {
	return organization;
    }

    public void setOrganization(IOrganizationTitle organization) {
	this.organization = organization;
    }
    
    public Integer getOrganizationId() {
	return organization == null ? null : organization.getId();
    }

    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Double getCreditAmount() {
	return creditAmount;
    }

    public void setCreditAmount(Double creditAmount) {
	this.creditAmount = creditAmount;
    }

    public Currency getCurrency() {
	return currency;
    }

    public void setCurrency(Currency currency) {
	this.currency = currency;
    }

    public Double getDebitAmount() {
	return debitAmount;
    }

    public void setDebitAmount(Double debitAmount) {
	this.debitAmount = debitAmount;
    }

    public String getPartnerBankAccountNo() {
	return partnerBankAccountNo;
    }

    public void setPartnerBankAccountNo(String partnerBankAccountNo) {
	this.partnerBankAccountNo = partnerBankAccountNo;
    }

    public String getPartnerName() {
	return partnerName;
    }

    public void setPartnerName(String partnerName) {
	this.partnerName = partnerName;
    }

    public Integer getPeriodId() {
	return periodId;
    }

    public void setPeriodId(Integer periodId) {
	this.periodId = periodId;
    }

    public String getPaymentMissing() {
	return paymentMissing;
    }

    public void setPaymentMissing(String paymentMissing) {
	this.paymentMissing = paymentMissing;
    }

    public String getOrganizationBankAccountNo() {
	return organizationBankAccountNo;
    }

    public void setOrganizationBankAccountNo(String organizationBankAccountNo) {
	this.organizationBankAccountNo = organizationBankAccountNo;
    }

    public String getBankAccountNo() {
	return getOrganizationBankAccountNo();
    }

}
