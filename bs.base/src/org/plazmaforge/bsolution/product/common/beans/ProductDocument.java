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
package org.plazmaforge.bsolution.product.common.beans;


import java.util.List;
import java.util.ArrayList;

import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.finance.common.beans.FinanceDocument;
import org.plazmaforge.bsolution.finance.common.beans.ValueHolder;
import org.plazmaforge.framework.util.MoneyEnvironment;


/**
 * @author Oleh Hapon
 * Date: 06.06.2004
 * Time: 22:42:50
 * $Id: ProductDocument.java,v 1.5 2010/04/28 06:24:21 ohapon Exp $
 */
public class ProductDocument<T extends ProductDocumentItem> extends FinanceDocument {

    
    /** Currency Delivery **/
    private ValueHolder currencyDeliveryHolder = new ValueHolder();
    
    /** Delivery **/
    private ValueHolder deliveryHolder = new ValueHolder();
    
    
    // --------------------------------------------------------------------------------------------------------
    // Price block
    // --------------------------------------------------------------------------------------------------------

    private PriceType priceType;

    private String correctPriceType;
    
    /** Recommended discount percent **/
    private float discountPercent;

    /** Recommended markup percent **/    
    private float markupPercent;
    
    
    ////

    

    private List<T> productItems;
    
    
    
    // Currency Delivery
    
    public double getCurrencyDelivery() {
	return currencyDeliveryHolder.getValue();
    }

    public void setCurrencyDelivery(double currencyDelivery) {
	currencyDeliveryHolder.setValue(currencyDelivery);
    }

    public double getCurrencyDeliveryWithTax() {
	return currencyDeliveryHolder.getValueWithTax();
    }

    public void setCurrencyDeliveryWithTax(double currencyDeliveryWithTax) {
	currencyDeliveryHolder.setValueWithTax(currencyDeliveryWithTax);
    }

    public double getCurrencyTaxDelivery() {
	return currencyDeliveryHolder.getTaxValue();
    }

    public void setCurrencyTaxDelivery(double currencyTaxDelivery) {
	currencyDeliveryHolder.setTaxValue(currencyTaxDelivery);
    }

    

    // Delivery
    
    public double getDelivery() {
	return deliveryHolder.getValue();
    }

    public void setDelivery(double delivery) {
	deliveryHolder.setValue(delivery);
    }

    public double getDeliveryWithTax() {
	return deliveryHolder.getValueWithTax();
    }

    public void setDeliveryWithTax(double deliveryWithTax) {
	deliveryHolder.setValueWithTax(deliveryWithTax);
    }

    public double getTaxDelivery() {
	return deliveryHolder.getTaxValue();
    }

    public void setTaxDelivery(double taxDelivery) {
	deliveryHolder.setTaxValue(taxDelivery);
    }

    
    

    public List<T> getProductItems() {
	if (productItems == null) {
	    productItems = new ArrayList<T>();
	}
	return productItems;
    }

    public void setProductItems(List<T> productItems) {
	this.productItems = productItems;
    }

    public void addProductItem(T item) {
	item.setProductDocument(this);
	getProductItems().add(item);
    }

    public void removeProductItem(T item) {
	removeProductItem(item, true);
    }

    public void removeProductItem(T item, boolean isResetParent) {
	if (isResetParent) {
	    item.setProductDocument(null); // Hibernate problem
	}
	getProductItems().remove(item);
    }



    
    ////
    
    public PriceType getPriceType() {
	return priceType;
    }

    public void setPriceType(PriceType priceType) {
	this.priceType = priceType;
    }
    
    public String getPriceTypeName() {
	return priceType == null ? null : priceType.getName();
    }
    
    public String getCorrectPriceType() {
        return correctPriceType;
    }

    public void setCorrectPriceType(String correctPriceType) {
        this.correctPriceType = correctPriceType;
    }
    
    public float getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(float discountPercent) {
        this.discountPercent = discountPercent;
    }

    public float getMarkupPercent() {
        return markupPercent;
    }

    public void setMarkupPercent(float markupPercent) {
        this.markupPercent = markupPercent;
    }
    
    ////
    
    public boolean isMurkupType() {
	return PriceType.MUP.equals(getCorrectPriceType());
    }
    
    public float getPricePercent() {
	if (isMurkupType()) {
	    return getMarkupPercent();
	} else {
	    return getDiscountPercent();
	}
    }

    public void setPricePercent(float percent) {
	if (isMurkupType()) {
	    setMarkupPercent(percent);
	} else {
	    setDiscountPercent(percent);
	}
    }
    
    


    /**
     * General calculate product document
     * 
     *  - calculate item values
     *  - calculate amount values  
     *  - calculate delivery values
     *  - calculate total values
     *  
     */
    public void calculateGeneral() {

	calculateItemValues();

	calculateAmountValues();

	calculateDeliveryValues();

	calculateTotalValues();

    }

    public void calculateCurrencyTotalValues() {
	setCurrencyTaxTotal(getCurrencyTaxAmount() + getCurrencyTaxDelivery());
	setCurrencyTotal(getCurrencyAmount() + getCurrencyDelivery());
	setCurrencyTotalWithTax(getCurrencyAmountWithTax() + getCurrencyDeliveryWithTax());
    }

    public void calculateNationalTotalValues() {
	setTaxTotal(getTaxAmount() + getTaxDelivery());
	setTotal(getAmount() + getDelivery());
	setTotalWithTax(getAmountWithTax() + getDeliveryWithTax());
    }

    public void calculateNationalAmountValues() {
	List<T> list = getNormalProductItems(); // NORMAL ITEMS
	if (list == null) {
	    return;
	}
	double taxAmount = 0;
	double amount = 0;
	for (T item : list) {
	    taxAmount += item.getTaxAmount();
	    amount += item.getAmount();
	}
	setTaxAmount(taxAmount);
	setAmount(amount);
	setAmountWithTax(amount + taxAmount);
    }

    public void calculateCurrencyAmountValues() {
	List<T> list = getNormalProductItems(); // NORMAL ITEMS
	if (list == null) {
	    return;
	}
	double taxAmount = 0;
	double amount = 0;
	for (T item : list) {
	    taxAmount += item.getCurrencyTaxAmount();
	    amount += item.getCurrencyAmount();
	}
	setCurrencyTaxAmount(taxAmount);
	setCurrencyAmount(amount);
	setCurrencyAmountWithTax(amount + taxAmount);
    }

    /**
     * Calculate all values of items
     */
    public void calculateItemValues() {
	List<T> list = getNormalProductItems(); // NORMAL ITEMS
	if (list == null) {
	    return;
	}
	for (T item : list) {
	    item.calculateGeneral(getCurrencyRate());
	}
    }

    public void calculateDeliveryValues() {
	
	// Currency values 
	setCurrencyTaxDelivery(MoneyEnvironment.roundMoney(EnterpriseEnvironment.getTaxPercent() * getCurrencyDelivery() / 100));
	setCurrencyDeliveryWithTax(getCurrencyDelivery() + getCurrencyTaxDelivery());

	// National values
	setDelivery(MoneyEnvironment.roundMoney(getCurrencyDelivery() * getCurrencyRate()));
	setTaxDelivery(MoneyEnvironment.roundMoney(getCurrencyTaxDelivery() * getCurrencyRate()));
	setDeliveryWithTax(getDelivery() + getTaxDelivery());
    }

    public void init() {
	super.init();

	// Force initialize
	getProductItems().size();
    }

    protected List<T> getNormalProductItems() {
	List<T> items = getProductItems();
	List<T> normalItems = new ArrayList<T>();
	if (items == null) {
	    return null;
	}
	for (T item : items) {
	    if (!item.isDeleted()) {
		normalItems.add(item);
	    }
	}
	return normalItems;
    }
    
    
    ////
    
    
    public String[] getSupportItemTypes() {
	// You have to implement support types for concrete item class
	return null;
    }
    
    public boolean isSupportItemTypes(String itemType) {
	if (itemType == null) {
	    return false;
	}
	String[] supportItemTypes = getSupportItemTypes();
	if (supportItemTypes == null || supportItemTypes.length == 0) {
	    return false;
	}
	for (String type : supportItemTypes) {
	    if (type.equals(itemType)) {
		return true;
	    }
	}
	return false;
    }
    
    public List<T> getProductItemsByType(String filterType) {
	List<T>  productItems = getProductItems();
	if (productItems == null || productItems.isEmpty()) {
	    return productItems;
	}
	String[] supportItemTypes = getSupportItemTypes();
	if (supportItemTypes == null || supportItemTypes.length == 0) {
	    // Empty list
	    return new ArrayList<T>();
	}
	List<T> filterProductItems =  new ArrayList<T>();
	for (T item : productItems) {
	    String itemType = item.getItemType();
	    if (filterType == null) {
		if (itemType == null || !isSupportItemTypes(itemType)) {
		    filterProductItems.add(item);
		}
	    } else {
		if (filterType.equals(itemType)) {
		    filterProductItems.add(item);
		}
	    }
	}
	return filterProductItems;
    }
}
