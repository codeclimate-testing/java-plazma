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

package org.plazmaforge.bsolution.cash.common.beans;

import java.util.Date;

import org.plazmaforge.bsolution.finance.common.beans.FinanceDocument;
import org.plazmaforge.bsolution.finance.common.beans.IContractorDocument;
import org.plazmaforge.bsolution.finance.common.beans.IContractorHeader;
import org.plazmaforge.bsolution.partner.common.beans.PartnerTitle;


/**
 * @author Oleh Hapon
 * 
 * $Id: CashDocument.java,v 1.2 2010/04/28 06:24:24 ohapon Exp $
 * 
 */

public class CashDocument extends FinanceDocument implements IContractorDocument {

    private IContractorHeader contractor;

    private Date paymentDate;

    private String paymentMissing;

    public IContractorHeader getContractor() {
	return contractor;
    }

    public void setContractor(IContractorHeader contractor) {
	this.contractor = contractor;
    }

    public Date getPaymentDate() {
	return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
	this.paymentDate = paymentDate;
    }

    public String getPaymentMissing() {
	return paymentMissing;
    }

    public void setPaymentMissing(String paymentMissing) {
	this.paymentMissing = paymentMissing;
    }

    public String getContractorName() {
	return contractor == null ? null : contractor.getName();
    }
    
    public void initContractor() {
	IContractorHeader contractor = getContractor();
	
	if (contractor == null) {
	    setPartner(null);
	    return;
	}
	
	if (contractor.isPartner()) {
	    PartnerTitle partnerHeader = new PartnerTitle();
	    partnerHeader.setId(contractor.getId());
	    setPartner(partnerHeader);
	} else {
	    setPartner(null);
	}
	
    }
}
