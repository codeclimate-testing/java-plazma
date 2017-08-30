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

import org.plazmaforge.framework.ext.model.BaseEntity;

/**
 * @author Oleh Hapon 
 * Date: 07.02.2003 
 * Time: 14:08:28
 * $Id: TemplateEntryItem.java,v 1.3 2010/12/05 07:55:58 ohapon Exp $
 */
public class TemplateEntryItem extends BaseEntity {

    /** Owner **/
    private TemplateEntry templateEntry;

    
    
    
    /** 
     * Debit ledger account expression 
     * Digits or expression 
     * For example: 631, 281, Doc.Account, Product.Account
     */
    private String debitLedgerAccountExpression;
    
    /**
     * Debit ledger account.
     * Use when the debit ledger account expression is digit
     */
    private LedgerAccount debitLedgerAccount;

    
    /** 
     * Debit object expression
     */
    private String debitObjectExpression;
    
    
    
    

    /** 
     * Credit ledger account expression
     * Digits or expression
     * For example: 631, 281, Doc.Account, Product.Account 
     */
    private String creditLedgerAccountExpression;
    
    /**
     * Credit ledger account
     * Use when the credit ledger account expression is digit
     */
    private LedgerAccount creditLedgerAccount;

    
    /** Credit object expression **/
    private String creditObjectExpression;
    
    
    

    /** Amount expression **/
    private String amountExpression;
    
    
    private String content;
    
    private String entryItemClass;
    
    
    
    
    
    

    public TemplateEntry getTemplateEntry() {
	return templateEntry;
    }

    public void setTemplateEntry(TemplateEntry templateEntry) {
	this.templateEntry = templateEntry;
    }

    public String getAmountExpression() {
	return amountExpression;
    }

    public void setAmountExpression(String amountExpression) {
	this.amountExpression = amountExpression;
    }

    public String getCreditLedgerAccountExpression() {
	return creditLedgerAccountExpression;
    }

    
    public void setCreditLedgerAccountExpression(
	    String creditLedgerAccountExpression) {
	this.creditLedgerAccountExpression = creditLedgerAccountExpression;
    }
    
    

    public String getCreditObjectExpression() {
	return creditObjectExpression;
    }

    public void setCreditObjectExpression(String creditObjectExpression) {
	this.creditObjectExpression = creditObjectExpression;
    }

    public String getDebitLedgerAccountExpression() {
	return debitLedgerAccountExpression;
    }

    
    public void setDebitLedgerAccountExpression(
	    String debitLedgerAccountExpression) {
	this.debitLedgerAccountExpression = debitLedgerAccountExpression;
    }
    
    

    public String getDebitObjectExpression() {
	return debitObjectExpression;
    }

    public void setDebitObjectExpression(String debitObjectExpression) {
	this.debitObjectExpression = debitObjectExpression;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEntryItemClass() {
        return entryItemClass;
    }

    public void setEntryItemClass(String entryItemClass) {
        this.entryItemClass = entryItemClass;
    }
    
    public String[] getExpressions() {
	String[] exp = new String[5];
	exp[0] = getCreditLedgerAccountExpression();
	exp[1] = getCreditObjectExpression();
	exp[2] = getDebitLedgerAccountExpression();
	exp[3] = getDebitObjectExpression();
	exp[4] = getAmountExpression();
	return exp;
    }

    public LedgerAccount getDebitLedgerAccount() {
        return debitLedgerAccount;
    }

    public void setDebitLedgerAccount(LedgerAccount debitLedgerAccount) {
        this.debitLedgerAccount = debitLedgerAccount;
    }

    public LedgerAccount getCreditLedgerAccount() {
        return creditLedgerAccount;
    }

    public void setCreditLedgerAccount(LedgerAccount creditLedgerAccount) {
        this.creditLedgerAccount = creditLedgerAccount;
    }

    
    
}
