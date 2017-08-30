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

import org.plazmaforge.bsolution.partner.common.beans.IPartnerTitle;
import org.plazmaforge.framework.ext.model.IStringPresentation;
import org.plazmaforge.framework.ext.model.BaseEntity;



/**
 * @author Oleh Hapon
 * Date: 13.07.2004
 * Time: 7:52:53
 * $Id: BankAccount.java,v 1.4 2010/12/05 07:56:02 ohapon Exp $
 */
public class BankAccount extends BaseEntity implements IStringPresentation {

    private IBankTitle bank;
    private IPartnerTitle partner;
    private String name;
    private String accountNo;

    public IBankTitle getBank() {
        return bank;
    }
    
    public String getBankName() {
        return bank == null ? null : bank.getName();
    }
    
    public void setBank(IBankTitle bank) {
        this.bank = bank;
    }
    
    public IPartnerTitle getPartner() {
        return partner;
    }

    
    public String getPartnerName() {
        return partner == null ? null : partner.getName();
    }

    public Integer getPartnerId() {
        return partner == null ? null : partner.getId();
    }

    public void setPartner(IPartnerTitle partner) {
        this.partner = partner;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }


    public String toString() {
        return accountNo;
    }
    
       
    public String getStringPresentation() {
	if (isEmpty(getAccountNo())) {
	    return getPartnerName();
	}
	return getAccountNo().trim() + (isEmpty(getPartnerName()) ? "" : ("/" + getPartnerName()));
	
    }
    
    public String getCodeStringPresentation() {
	return getStringPresentation();
    }
    
   
}
