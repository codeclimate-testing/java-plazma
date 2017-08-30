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
package org.plazmaforge.bsolution.finance.common.beans;

import org.plazmaforge.framework.ext.model.Dictionary;

/**
 * @author Oleh Hapon Date: 07.02.2003 Time: 13:56:10
 * 
 * $Id: LedgerAccount.java,v 1.4 2010/04/28 06:24:25 ohapon Exp $
 */
public class LedgerAccount extends Dictionary {

    private Integer parentId;

    private boolean currency;

    private boolean quantity;

    private boolean offBalance;

    private LedgerAccountType ledgerAccountType;

    public Integer getParentId() {
	return parentId;
    }

    public void setParentId(Integer parentId) {
	this.parentId = parentId;
    }

    public boolean isCurrency() {
	return currency;
    }

    public void setCurrency(boolean currency) {
	this.currency = currency;
    }

    public boolean isQuantity() {
	return quantity;
    }

    public void setQuantity(boolean quantity) {
	this.quantity = quantity;
    }

    public boolean isOffBalance() {
	return offBalance;
    }

    public void setOffBalance(boolean offBalance) {
	this.offBalance = offBalance;
    }

    public LedgerAccountType getLedgerAccountType() {
	return ledgerAccountType;
    }

    public void setLedgerAccountType(LedgerAccountType accountType) {
	this.ledgerAccountType = accountType;
    }

    public String getAccountTypeCode() {
	return ledgerAccountType == null ? null : ledgerAccountType.getCode();
    }

    public String getAccountTypeName() {
	return ledgerAccountType == null ? null : ledgerAccountType.getName();
    }

    public String getAccount() {
	return getCode();
    }
    

    public String getAccountCode() {
	return getCode();
    }

    public String getAccountName() {
	return getName();
    }
    
    public String getAccountFullName() {
	return (getCode() == null ? "" : getCode())
		+ (getName() == null ? "" : (" " + getName()));
    }


}
