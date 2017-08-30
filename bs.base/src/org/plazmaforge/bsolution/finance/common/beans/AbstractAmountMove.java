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
 * @author Oleh Hapon
 * 
 * $Id: AbstractAmountMove.java,v 1.2 2010/04/28 06:24:25 ohapon Exp $
 */
public class AbstractAmountMove extends AbstractMove {

    private double amount;

    private double amountWithTax;

    private double taxAmount;

    public double getAmount() {
	return amount;
    }

    public void setAmount(double amount) {
	this.amount = amount;
    }

    public double getAmountWithTax() {
	return amountWithTax;
    }

    public void setAmountWithTax(double amountWithTax) {
	this.amountWithTax = amountWithTax;
    }

    public double getTaxAmount() {
	return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
	this.taxAmount = taxAmount;
    }

}
