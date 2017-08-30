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

import org.plazmaforge.bsolution.base.common.beans.Currency;

/**
 * @author Oleh Hapon 
 * Date: 16.08.2004 
 * Time: 20:44:42 
 * $Id: PartnerRest.java,v 1.2 2010/04/28 06:24:25 ohapon Exp $
 */
public class PartnerRest extends PartnerRegister {

    private Currency currency;

    private double currencyDebitAmount;

    private double currencyCreditAmount;

    public Currency getCurrency() {
	return currency;
    }

    public void setCurrency(Currency currency) {
	this.currency = currency;
    }

    public double getCurrencyAmount() {
	return currencyDebitAmount - currencyCreditAmount;
    }

    public void setCurrencyAmount(double currencyAmount) {
	initCurrencyAmount(currencyAmount);
    }

    public void setCurrencyDebitAmount(double currencyDebitAmount) {
	this.currencyDebitAmount = currencyDebitAmount;
    }

    public void setCurrencyCreditAmount(double currencyCreditAmount) {
	this.currencyCreditAmount = currencyCreditAmount;
    }

    public double getCurrencyDebitAmount() {
	return currencyDebitAmount;
    }

    public double getCurrencyCreditAmount() {
	return currencyCreditAmount;
    }

    private void initDebitAmount(double amount, double currencyAmount) {
	setDebitAmount(amount);
	this.currencyDebitAmount = currencyAmount;
    }

    private void initCreditAmount(double amount, double currencyAmount) {
	setCreditAmount(amount);
	this.currencyCreditAmount = currencyAmount;
    }

    // TODO: Stub. Must real implements
    private void initAmount(double amount) {
	if (DEBIT.equals(getOperationType())) {
	    initDebitAmount(amount, 0);
	    initCreditAmount(0, 0);
	} else {
	    initDebitAmount(0, 0);
	    initCreditAmount(amount, 0);
	}
    }

    private void initCurrencyAmount(double currencyAmount) {
	if (DEBIT.equals(getOperationType())) {
	    initDebitAmount(0, currencyAmount);
	    initCreditAmount(0, 0);
	} else {
	    initDebitAmount(0, 0);
	    initCreditAmount(0, currencyAmount);
	}
    }

}
