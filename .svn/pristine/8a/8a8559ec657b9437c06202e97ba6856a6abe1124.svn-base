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
 * Created on 13.09.2008
 *
 */

package org.plazmaforge.bsolution.product.common.beans;

import org.plazmaforge.bsolution.base.common.beans.Currency;
import org.plazmaforge.bsolution.base.common.beans.Unit;
import org.plazmaforge.bsolution.contact.common.beans.ContactHeader;
import org.plazmaforge.bsolution.document.common.beans.DocumentHeader;
import org.plazmaforge.bsolution.organization.common.beans.OrganizableDictionary;
import org.plazmaforge.bsolution.organization.common.beans.MtrlResponsible;
import org.plazmaforge.bsolution.partner.common.beans.IPartnerTitle;

/** 
 * @author Oleh Hapon
 * $Id: ProductHeader.java,v 1.4 2010/10/10 11:16:14 ohapon Exp $
 */

public class ProductHeader extends OrganizableDictionary {

    
    private String barCode;
    
    private IPartnerTitle supplier;
    
    private DocumentHeader document;
    
    private ContactHeader responsible;
    
    
    //-------------------------------------------------------
    // Price block
    // ------------------------------------------------------
    
    /** Cost price in currency **/
    private double costPrice;
    
    /** List price in currency **/
    private double listPrice;
    
    
    
    /** Wholesale price in currency **/
    private double wholesalePrice;
    
    /** Small Wholesale price in currency **/
    private double smallWholesalePrice;
    
    /** Retail price in currency **/
    private double retailPrice;
    
    // ------------------------------------------------------    

    /** Cost price in currency **/
    private double currencyCostPrice;
    
    /** List price in currency **/
    private double currencyListPrice;
    
    /** Wholesale price in currency **/
    private double currencyWholesalePrice;
    
    /** Small Wholesale price in currency **/
    private double currencySmallWholesalePrice;
    
    /** Retail price in currency **/
    private double currencyRetailPrice;


    private float taxPercent;

    private float addPricePercent;

    private double currencyRate;

    private double taxPrice;

    //private double totalPrice;

    
    
    
    private Currency currency; // REQUREMENT

    private Unit unit; // REQUREMENT

    
    ///
    
    
    public String getBarCode() {
	return barCode;
    }

    public void setBarCode(String barCode) {
	this.barCode = barCode;
    }

  

    
    public double getPrice() {
	return getCostPrice();
    }

    public void setPrice(double price) {
	setCostPrice(costPrice);
    }

    
    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }
    
    
    public double getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(double wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    
    public double getSmallWholesalePrice() {
        return smallWholesalePrice;
    }

    public void setSmallWholesalePrice(double smallWholesalePrice) {
        this.smallWholesalePrice = smallWholesalePrice;
    }
    
    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    
    
    
    
    public float getTaxPercent() {
	return taxPercent;
    }

    public void setTaxPercent(float taxPercent) {
	this.taxPercent = taxPercent;
    }

    public float getAddPricePercent() {
	return addPricePercent;
    }

    public void setAddPricePercent(float addPricePercent) {
	this.addPricePercent = addPricePercent;
    }

    public double getCurrencyRate() {
	return currencyRate;
    }

    public void setCurrencyRate(double currencyRate) {
	this.currencyRate = currencyRate;
    }

    public double getTaxPrice() {
	return taxPrice;
    }

    public void setTaxPrice(double taxPrice) {
	this.taxPrice = taxPrice;
    }

//    public double getTotalPrice() {
//	return totalPrice;
//    }
//
//    public void setTotalPrice(double totalPrice) {
//	this.totalPrice = totalPrice;
//    }

    
    
    
    
    public double getCurrencyPrice() {
        return getCurrencyCostPrice();
    }

    public void setCurrencyPrice(double currencyPrice) {
	setCurrencyCostPrice(currencyPrice);
    }
    
    public double getCurrencyCostPrice() {
        return currencyCostPrice;
    }

    public void setCurrencyCostPrice(double currencyCostPrice) {
        this.currencyCostPrice = currencyCostPrice;
    }
    
    public double getCurrencyListPrice() {
        return currencyListPrice;
    }

    public void setCurrencyListPrice(double currencyListPrice) {
        this.currencyListPrice = currencyListPrice;
    }
    
    
    public double getCurrencyWholesalePrice() {
        return currencyWholesalePrice;
    }

    public void setCurrencyWholesalePrice(double currencyWholesalePrice) {
        this.currencyWholesalePrice = currencyWholesalePrice;
    }    

    public double getCurrencySmallWholesalePrice() {
        return currencySmallWholesalePrice;
    }

    public void setCurrencySmallWholesalePrice(double currencySmallWholesalePrice) {
        this.currencySmallWholesalePrice = currencySmallWholesalePrice;
    }
    
    public double getCurrencyRetailPrice() {
        return currencyRetailPrice;
    }

    public void setCurrencyRetailPrice(double currencyRetailPrice) {
        this.currencyRetailPrice = currencyRetailPrice;
    }

    
    
    
   
    /*
    public double getPrice(PriceType priceType) {
	if (priceType == null) {
	    return getPrice();
	}
	
	
	if (PriceType.isBasePrice(priceType)) {
	    return getPrice();
	} else if (PriceType.isSmallWholesalePrice(priceType)) {
	    return getSmallWholesalePrice();	    
	} else if (PriceType.isWholesalePrice(priceType)) {
	    return getWholesalePrice();
	} else if (PriceType.isRetailPrice(priceType)) {
	    return getRetailPrice();
	}
	
	
	return 0d;
    }
    */
 
  
    
    /*
    public double getCurrencyPrice(PriceType priceType) {
	if (priceType == null) {
	    return getCurrencyPrice();
	}
	
	
	if (PriceType.isBasePrice(priceType)) {
	    return getCurrencyPrice();
	} else if (PriceType.isSmallWholesalePrice(priceType)) {
	    return getCurrencySmallWholesalePrice();	    
	} else if (PriceType.isWholesalePrice(priceType)) {
	    return getCurrencyWholesalePrice();
	} else if (PriceType.isRetailPrice(priceType)) {
	    return getCurrencyRetailPrice();
	}
	
	
	return 0d;
    }
    */

    
    
    
    
    
    
    
    
    
    
    
    
    public Unit getUnit() {
	return unit;
    }

    public String getUnitName() {
	return unit == null ? null : unit.getName();
    }

    public void setUnit(Unit unit) {
	this.unit = unit;
    }

    public String getCurrencyName() {
	return currency == null ? null : currency.getName();
    }
    
    
    
    public Currency getCurrency() {
	return currency;
    }

    public void setCurrency(Currency currency) {
	this.currency = currency;
    }


    ///
    
    public IPartnerTitle getSupplier() {
	return supplier;
    }

    public void setSupplier(IPartnerTitle supplier) {
	this.supplier = supplier;
    }
    
    public String getSupplierName() {
	return supplier == null ? null : supplier.getName();
    }

    public DocumentHeader getDocument() {
        return document;
    }

    public void setDocument(DocumentHeader document) {
        this.document = document;
    }

    public String getDocumentTitle() {
        return document == null ? null : document.getShortTitle();
    }
    
    
    public ContactHeader getResponsible() {
        return responsible;
    }

    public void setResponsible(ContactHeader responsible) {
        this.responsible = responsible;
    }
    
    
    public String getResponsibleName() {
        return responsible == null ? null : responsible.getName();
    }

    
    ///
    
    
}
