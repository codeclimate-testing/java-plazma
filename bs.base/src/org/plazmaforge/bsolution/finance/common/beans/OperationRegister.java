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

/**
 * Operation register
 * 
 * Operation must be DEBIT or CREDIT
 */

/**
 * @author Oleh Hapon Date: 16.08.2004 Time: 20:55:39 $Id: OperationRegister.java,v 1.2 2010/04/28 06:24:25 ohapon Exp $
 */
public class OperationRegister extends Register {

    /** Debit operation type **/
    public static final String DEBIT = "D";

    /** Credit operation type **/
    public static final String CREDIT = "C";

    /** Operation type **/
    private String operationType = DEBIT;

    /** Debit amount **/
    private double debitAmount;

    /** Credit amount **/
    private double creditAmount;

    
    // TODO: Use OPERATION_TYPE column in table to store oparetaionType
    private boolean initOperationType;
    
    
    public double getAmount() {
	return getResultAmount() * getSignOperationType();
    }

    public void setAmount(double amount) {
	initAmount(amount);
    }

    public double getResultAmount() {
	return debitAmount - creditAmount;
    }

    public String getOperationType() {
	
	// TODO: Use OPERATION_TYPE column in table to store oparetaionType
	if (!initOperationType) {
	    initOperationType = true;
	    initOperationType();
	}
	
	return operationType;
    }

    public int getSignOperationType() {
	return isDebit() ? 1 : -1;
    }

    public boolean isDebit() {
	return DEBIT.equals(getOperationType());
    }

    public boolean isCredit() {
	return CREDIT.equals(getOperationType());
    }

    public void setOperationType(String operationType) {
	if (!isDebit() && !isCredit()) {
	    throw new IllegalArgumentException("Operation type ["
		    + operationType + "] must be 'D' or 'C' ");
	}
	this.operationType = operationType;
	// initAmount();
    }

    public void initOperationType() {
	if (getResultAmount() >= 0) {
	    setOperationType(DEBIT);
	} else {
	    setOperationType(CREDIT);
	}
    }

    public double getDebitAmount() {
	return debitAmount;
    }

    public void setDebitAmount(double debitAmount) {
	this.debitAmount = debitAmount;
    }

    public void setCreditAmount(double creditAmount) {
	this.creditAmount = creditAmount;
    }

    public double getCreditAmount() {
	return creditAmount;
    }

    private void initDebitAmount(double amount) {
	this.debitAmount = amount;
    }

    private void initCreditAmount(double amount) {
	this.creditAmount = amount;
    }

    private void initAmount(double amount) {
	if (isDebit()) {
	    initDebitAmount(amount);
	    initCreditAmount(0);
	} else {
	    initDebitAmount(0);
	    initCreditAmount(amount);
	}
    }

    public void init() {
	super.init();
	initOperationType();
    }

}
