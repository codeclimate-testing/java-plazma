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

import org.plazmaforge.bsolution.base.common.beans.BusinessableHeader;
import org.plazmaforge.framework.ext.model.BaseEntity;


/**
 * @author Oleh Hapon Date: 07.02.2003 Time: 13:48:46
 * 
 * $Id: EntryItem.java,v 1.3 2010/12/05 07:55:58 ohapon Exp $
 */
public class EntryItem extends BaseEntity {

    /**
     * Finance Document. It is owner of entry item
     */
    private FinanceDocument owner;

    /**
     * Debit Ledger Account
     */
    private LedgerAccount debitLedgerAccount;

    /**
     * Debit Object
     */
    private BusinessableHeader debitObject;

    
    /**
     * Credit Ledger Account
     */
    private LedgerAccount creditLedgerAccount;

    /**
     * Credit Object
     */
    private BusinessableHeader creditObject;

    /**
     * Amount
     */
    private double amount;
    
    private String content;
    
  

    public FinanceDocument getOwner() {
	return owner;
    }

    public void setOwner(FinanceDocument owner) {
	this.owner = owner;
    }

    public LedgerAccount getCreditLedgerAccount() {
	return creditLedgerAccount;
    }

    public void setCreditLedgerAccount(LedgerAccount creditLedgerAccount) {
	this.creditLedgerAccount = creditLedgerAccount;
    }

    public LedgerAccount getDebitLedgerAccount() {
	return debitLedgerAccount;
    }

    public void setDebitLedgerAccount(LedgerAccount debitLedgerAccount) {
	this.debitLedgerAccount = debitLedgerAccount;
    }

    public double getAmount() {
	return amount;
    }

    public void setAmount(double amount) {
	this.amount = amount;
    }

    
    ////
    
    ////
    public Integer getCreditObjectId() {
	return creditObject == null ? null : creditObject.getId();
    }


    public Integer getDebitObjectId() {
	return debitObject == null ? null : debitObject.getId();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BusinessableHeader getCreditObject() {
        return creditObject;
    }

    public void setCreditObject(BusinessableHeader creditObject) {
        this.creditObject = creditObject;
    }

    public String getCreditObjectName() {
        return creditObject == null ? null : creditObject.getName();
    }

    
    
    public BusinessableHeader getDebitObject() {
        return debitObject;
    }

    public void setDebitObject(BusinessableHeader debitObject) {
        this.debitObject = debitObject;
    }
    
    public String getDebitObjectName() {
        return debitObject == null ? null : debitObject.getName();
    }

 
}
