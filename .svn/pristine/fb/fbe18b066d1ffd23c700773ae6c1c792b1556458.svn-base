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

/*
 * Created on 25.02.2007 
 */
package org.plazmaforge.bsolution.product;

import org.plazmaforge.bsolution.product.common.beans.ProductDocumentItem;
import org.plazmaforge.framework.util.MoneyEnvironment;


/**
 * @author Oleh Hapon
 * $Id: ProductCalculator.java,v 1.3 2010/04/28 06:24:36 ohapon Exp $
 */

public class ProductCalculator {

    /**
     * General calculate all values of the item by currencyRate
     * @param item
     * @param currencyRate
     */
    public static void calculateGeneral(ProductDocumentItem item, double currencyRate) {
	calculateCurrencyValues(item);
	calculateNationalValues(item, currencyRate);
	calculateNationalValuesWithTax(item);
	
	calculateAccountValues(item);
    }

    public static void calculateCurrencyValues(ProductDocumentItem item) {

	// If you use both tax amount then return
	if (item.isBothTaxAmount()) {
	    return;
	}

	if (item.isIncludeTaxInAmount()) {
	    item.setCurrencyAmount(item.getCurrencyAmountWithTax() - item.getCurrencyTaxAmount()); // SWITCH
	} else {
	    item.setCurrencyAmountWithTax(item.getCurrencyAmount() + item.getCurrencyTaxAmount()); // SWITCH
	}

	/*
	if (item.getQuantity() == 0) {
	    
	    if (item.isIncludeTaxInAmount()) {
		item.setCurrencyPrice(0); // SWITCH
	    } else {
		item.setCurrencyPriceWithTax(0); // SWITCH
	    }
	    item.setCurrencyTaxPrice(0);
	    
	} else {
	    
	    if (item.isIncludeTaxInAmount()) {
		item.setCurrencyPrice(item.getCurrencyAmount() / item.getQuantity()); // SWITCH
	    } else {
		item.setCurrencyPriceWithTax(item.getCurrencyAmountWithTax() / item.getQuantity()); // SWITCH
	    }
	    item.setCurrencyTaxPrice(item.getCurrencyPriceWithTax() - item.getCurrencyPrice());
	    
	}
	*/
	
	
	
	if (item.getQuantity() == 0) {

	    if (item.isCorrectedPriceItem()) item.setCurrencyTaxBasePrice(0);
	    item.setCurrencyTaxPrice(0);

	    if (item.isIncludeTaxInAmount()) {
		if (item.isCorrectedPriceItem()) item.setCurrencyBasePrice(0);  
		item.setCurrencyPrice(0); // SWITCH
	    } else {
		if (item.isCorrectedPriceItem()) item.setCurrencyBasePriceWithTax(0);
		item.setCurrencyPriceWithTax(0); // SWITCH
	    }
	    
	} else {
	    
	    item.setCurrencyTaxPrice(item.getCurrencyTaxAmount() / item.getQuantity());
	    
	    if (item.isIncludeTaxInAmount()) {
		if (item.isCorrectedPriceItem()) item.setCurrencyBasePrice(item.getCurrencyBasePriceWithTax() - item.getCurrencyTaxBasePrice()); // SWITCH
		item.setCurrencyPrice(item.getCurrencyPriceWithTax() - item.getCurrencyTaxPrice()); // SWITCH
	    } else {
		item.setCurrencyPriceWithTax(item.getCurrencyPrice() + item.getCurrencyTaxPrice()); // SWITCH
		if (item.isCorrectedPriceItem()) item.setCurrencyBasePriceWithTax(item.getCurrencyBasePrice() + item.getCurrencyTaxBasePrice()); // SWITCH
	    }
	    
	    
	}

    }

    /**
     * Calculate national values of the item by currencyRate
     * @param item
     * @param currencyRate
     */
    public static void calculateNationalValues(ProductDocumentItem item, double currencyRate) {

	item.setPrice(MoneyEnvironment.roundMoney(currencyRate * item.getCurrencyPrice()));
	item.setTaxPrice(MoneyEnvironment.roundMoney(currencyRate * item.getCurrencyTaxPrice()));

	item.setAmount(MoneyEnvironment.roundMoney(currencyRate	* item.getCurrencyAmount()));
	item.setTaxAmount(MoneyEnvironment.roundMoney(currencyRate * item.getCurrencyTaxAmount()));

    }

    /**
     * Calculate national values with tax of the item by currencyRate
     * @param item
     */
    public static void calculateNationalValuesWithTax(ProductDocumentItem item) {
	item.setPriceWithTax(item.getPrice() + item.getTaxPrice());
	item.setAmountWithTax(item.getAmount() + item.getTaxAmount());
    }

    /**
     * Calculate accounting values of the item
     * Accounting values are national values 
     * @param item
     */
    public static void calculateAccountValues(ProductDocumentItem item) {
	double unitRate = item.getUnitRate();
	item.setAccountQuantity(unitRate * item.getQuantity());
	item.setAccountPrice(unitRate * item.getPrice());
	item.setAccountTaxPrice(unitRate * item.getTaxPrice());
	item.setAccountPriceWithTax(unitRate * item.getPriceWithTax());
    }
}
