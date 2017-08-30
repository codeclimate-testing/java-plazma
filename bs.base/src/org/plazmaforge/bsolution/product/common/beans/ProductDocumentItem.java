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

import org.plazmaforge.bsolution.base.common.beans.Unit;
import org.plazmaforge.bsolution.finance.FinanceEnvironment;
import org.plazmaforge.bsolution.finance.common.beans.ITaxHolder;
import org.plazmaforge.bsolution.finance.common.beans.TaxHolder;
import org.plazmaforge.bsolution.finance.common.beans.ValueHolder;
import org.plazmaforge.bsolution.product.ProductCalculator;
import org.plazmaforge.framework.ext.model.BaseEntity;
import org.plazmaforge.framework.util.NameUtils;


/**
 * @author Oleh Hapon
 * Date: 02.07.2003
 * Time: 13:48:13
 */
public class ProductDocumentItem extends BaseEntity implements ITaxHolder {


    /** Default quantity 1d **/
    public static final double DEFAULT_QUANTITY  = 1d;
    
    /** Empty quantity **/
    public static final double EMPTY_QUANTITY  = 0d;

    /** Defaul unit rate **/
    public static final double DEFAULT_UNIT_RATE  = 1d;
    
    

    
    /** Quantity **/
    private double quantity;
    
    /** Account Quantity **/    
    private double accountQuantity;
    
    /** Unit **/
    private Unit unit;

    /** Unit Rate **/
    private double unitRate;
    
    
    /** Price **/
    private ValueHolder currencyPriceHolder = new ValueHolder();
    private ValueHolder priceHolder = new ValueHolder();

    /** Base Price **/
    private ValueHolder currencyBasePriceHolder = new ValueHolder();
    private ValueHolder basePriceHolder = new ValueHolder();    

    /** Account Price **/
    private ValueHolder accountPriceHolder = new ValueHolder();

    /** Amount **/
    private ValueHolder currencyAmountHolder = new ValueHolder();
    private ValueHolder amountHolder = new ValueHolder();
    
    /** Tax **/
    private TaxHolder taxHolder = new TaxHolder();
    
    
    
    /**
     * The parent of item
     */
    private ProductDocument productDocument;

    private ProductHeader product;
    
    private String productFeatureName;
    
    private ProductInstance productInstance;

    // --------------------------------------------------------------------------------------------------------
    // Price Type 
    // --------------------------------------------------------------------------------------------------------
    private PriceType priceType;

    private String correctPriceType;
    
    private float discountPercent;
    
    private float markupPercent;
    

    /** Item Type (special marker) **/
    private String itemType;

    /** Note of the item **/
    private String note;
    
    
    
    public ProductDocumentItem() {
	// TODO: Must change. 
	//setUnitId(Unit.DEFAULT_UNIT_ID);
	setTax(true);
    }

    public ProductDocument getProductDocument() {
	return productDocument;
    }

    public void setProductDocument(ProductDocument productDocument) {
	this.productDocument = productDocument;
    }

    
    // Quantity

    public double getQuantity() {
	return quantity;
    }

    public void setQuantity(double quantity) {
	this.quantity = quantity;
    }


    // Account Quantity
    
    public double getAccountQuantity() {
        return accountQuantity;
    }

    public void setAccountQuantity(double accountQuantity) {
        this.accountQuantity = accountQuantity;
    }
    


    // Unit
    
    public Unit getUnit() {
	return unit;
    }

    public void setUnit(Unit unit) {
	this.unit = unit;
    }
    
    public Integer getUnitId() {
	return unit == null ? null : unit.getId(); 
    }

    public String getUnitName() {
	return unit == null ? null : unit.getName();
    }

    public double getUnitRate() {
	return unitRate;
    }

    public void setUnitRate(double unitRate) {
	this.unitRate = unitRate;
    }

    
    
    // Currency Base Price
    
    public double getCurrencyTaxBasePrice() {
        return currencyBasePriceHolder.getTaxValue();
    }

    public void setCurrencyTaxBasePrice(double currencyTaxBasePrice) {
	currencyBasePriceHolder.setTaxValue(currencyTaxBasePrice);
    }
    
    public double getCurrencyBasePrice() {
        return currencyBasePriceHolder.getValue();
    }

    public void setCurrencyBasePrice(double currencyBasePrice) {
	currencyBasePriceHolder.setValue(currencyBasePrice);
    }

    public double getCurrencyBasePriceWithTax() {
        return currencyBasePriceHolder.getValueWithTax();
    }

    public void setCurrencyBasePriceWithTax(double currencyBasePriceWithTax) {
	currencyBasePriceHolder.setValueWithTax(currencyBasePriceWithTax);
    }

    
    // Base Price
    
    public double getTaxBasePrice() {
        return basePriceHolder.getTaxValue();
    }

    public void setTaxBasePrice(double taxBasePrice) {
	basePriceHolder.setTaxValue(taxBasePrice);
    }
    
    public double getBasePrice() {
        return basePriceHolder.getValue();
    }

    public void setBasePrice(double basePrice) {
	basePriceHolder.setValue(basePrice);
    }

    public double getBasePriceWithTax() {
	return basePriceHolder.getValueWithTax();
    }

    public void setBasePriceWithTax(double basePriceWithTax) {
	basePriceHolder.setValueWithTax(basePriceWithTax);
    }

    
    
    
    // Currency Price
    
    public double getCurrencyPrice() {
	return currencyPriceHolder.getValue();
    }

    public void setCurrencyPrice(double currencyPrice) {
	currencyPriceHolder.setValue(currencyPrice);
    }

    public double getCurrencyTaxPrice() {
	return currencyPriceHolder.getTaxValue();
    }

    public void setCurrencyTaxPrice(double currencyTaxPrice) {
	currencyPriceHolder.setTaxValue(currencyTaxPrice);
    }

    public double getCurrencyPriceWithTax() {
	return currencyPriceHolder.getValueWithTax();
    }

    public void setCurrencyPriceWithTax(double currencyPriceWithTax) {
	currencyPriceHolder.setValueWithTax(currencyPriceWithTax);
    }

    
    
    // Price
    
    public double getPrice() {
	return priceHolder.getValue();
    }

    public void setPrice(double price) {
	priceHolder.setValue(price);
    }

    public double getTaxPrice() {
	return priceHolder.getTaxValue();
    }

    public void setTaxPrice(double taxPrice) {
	priceHolder.setTaxValue(taxPrice);
    }

    public double getPriceWithTax() {
	return priceHolder.getValueWithTax();
    }

    public void setPriceWithTax(double priceWithTax) {
	priceHolder.setValueWithTax(priceWithTax);
    }
    


    
    // Account Price
    
    public double getAccountPrice() {
        return accountPriceHolder.getValue();
    }

    public void setAccountPrice(double accountPrice) {
        accountPriceHolder.setValue(accountPrice);
    }

    public double getAccountPriceWithTax() {
        return accountPriceHolder.getValueWithTax();
    }

    public void setAccountPriceWithTax(double accountPriceWithTax) {
	accountPriceHolder.setValueWithTax(accountPriceWithTax);
    }


    public double getAccountTaxPrice() {
        return accountPriceHolder.getTaxValue();
    }

    public void setAccountTaxPrice(double accountTaxPrice) {
	accountPriceHolder.setTaxValue(accountTaxPrice);
    }

    

    // Currency Amount
    
    public double getCurrencyAmount() {
	return currencyAmountHolder.getValue();
    }

    public void setCurrencyAmount(double currencyAmount) {
	currencyAmountHolder.setValue(currencyAmount);
    }

    public double getCurrencyTaxAmount() {
	return currencyAmountHolder.getTaxValue();
    }

    public void setCurrencyTaxAmount(double currencyTaxAmount) {
	currencyAmountHolder.setTaxValue(currencyTaxAmount);
    }

    public double getCurrencyAmountWithTax() {
	return currencyAmountHolder.getValueWithTax();
    }

    public void setCurrencyAmountWithTax(double currencyAmountWithTax) {
	currencyAmountHolder.setValueWithTax(currencyAmountWithTax);
    }

    

    // Amount
    
    public double getAmount() {
	return amountHolder.getValue();
    }

    public void setAmount(double amount) {
	amountHolder.setValue(amount);
    }

    public double getTaxAmount() {
	return amountHolder.getTaxValue();
    }

    public void setTaxAmount(double taxAmount) {
	amountHolder.setTaxValue(taxAmount);
	setTax(taxAmount > 0 ? true : false);
    }

    public double getAmountWithTax() {
	return amountHolder.getValueWithTax();
    }

    public void setAmountWithTax(double amountWithTax) {
	amountHolder.setValueWithTax(amountWithTax);
    }


    

    public String getProductCode() {
	return product == null ? null : product.getCode();
    }

    public String getProductName() {
	return product == null ? null : product.getName();
    }

    public String getDetailProductName() {
	return NameUtils.getDetailName("PRODUCT", getProductName(), getProductFeatureName());
    }
    
    


    public ProductHeader getProduct() {
	return product;
    }

    public void setProduct(ProductHeader product) {
	this.product = product;
    }

    public Integer getProductId() {
	return product == null ? null : product.getId();
    }
    
    public String getProductFeatureName() {
        return productFeatureName;
    }

    public void setProductFeatureName(String productFeatureName) {
        this.productFeatureName = productFeatureName != null && productFeatureName.length() == 0 ? null : productFeatureName;
    }

    

    /**
     * General calculate 
     * @param currencyRate
     */
    public void calculateGeneral(double currencyRate) {
	ProductCalculator.calculateGeneral(this, currencyRate);
    }

    /**
     * Calculate national values with tax
     */
    public void calculateNationalValuesWithTax() {
	ProductCalculator.calculateNationalValuesWithTax(this);
    }

    /**
     * Calculate currency values
     */
    public void calculateCurrencyValues() {
	ProductCalculator.calculateCurrencyValues(this);
    }

    /**
     * Calculate national values by currencyRate
     */
    public void calculateNationalValues(double currencyRate) {
	ProductCalculator.calculateNationalValues(this, currencyRate);
    }
    
    

    public double getItemPrice() {
	return getPriceWithTax();
    }

    public double getItemAmount() {
	return getAmountWithTax();
    }

    public double getCurrencyItemPrice() {
	return getCurrencyPriceWithTax();
    }

    public double getCuttencyItemAmount() {
	return getCurrencyAmountWithTax();
    }

    

    // Tax
    
    public boolean isTax() {
	return taxHolder.isTax();
    }

    public void setTax(boolean tax) {
	taxHolder.setTax(tax);
    }

    public Integer getTaxId() {
	return taxHolder.getTaxId(); 
    }

    public void setTaxId(Integer taxId) {
	taxHolder.setTaxId(taxId);
    }

    public float getTaxPercent() {
	return taxHolder.getTaxPercent();
    }

    public void setTaxPercent(float taxPercent) {
	taxHolder.setTaxPercent(taxPercent);
    }
    
    
    // --------------------------------------------------------------------------------------------------
    //
    // Enter methods
    //
    // --------------------------------------------------------------------------------------------------

    public boolean isIncludeTaxInAmount() {
	return productDocument == null ? FinanceEnvironment.isIncludeTaxInAmount(this.getClass()) : productDocument.isIncludeTaxInAmount();
    }

    public boolean isBothTaxAmount() {
	return productDocument == null ? FinanceEnvironment.isBothTaxAmount(this.getClass()) : productDocument.isBothTaxAmount();
    }

    public void setEnterPrice(double enterPrice) {
	if (isIncludeTaxInAmount()) {
	    setPriceWithTax(enterPrice);
	} else {
	    setPrice(enterPrice);
	}
    }

    public double getEnterPrice() {
	return isIncludeTaxInAmount() ? getPriceWithTax() : getPrice();
    }

    public void setEnterAmount(double enterAmount) {
	if (isIncludeTaxInAmount()) {
	    setAmountWithTax(enterAmount);
	} else {
	    setAmount(enterAmount);
	}
    }

    public double getEnterAmount() {
	return isIncludeTaxInAmount() ? getAmountWithTax() : getAmount();
    }

    public void setEnterCurrencyPrice(double enterPrice) {
	if (isIncludeTaxInAmount()) {
	    setCurrencyPriceWithTax(enterPrice);
	} else {
	    setCurrencyPrice(enterPrice);
	}
    }

    public double getEnterCurrencyPrice() {
	return isIncludeTaxInAmount() ? getCurrencyPriceWithTax() : getCurrencyPrice();
    }

    public void setEnterCurrencyAmount(double enterCurrencyAmount) {
	if (isIncludeTaxInAmount()) {
	    setCurrencyAmountWithTax(enterCurrencyAmount);
	} else {
	    setCurrencyAmount(enterCurrencyAmount);
	}
    }

    public double getEnterCurrencyAmount() {
	return isIncludeTaxInAmount() ? getCurrencyAmountWithTax() : getCurrencyAmount();
    }
    
    

    //// price block
    
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

    



    ////
    
    
    public void setEnterBasePrice(double enterPrice) {
	if (isIncludeTaxInAmount()) {
	    setBasePriceWithTax(enterPrice);
	} else {
	    setBasePrice(enterPrice);
	}
    }

    public double getEnterBasePrice() {
	return isIncludeTaxInAmount() ? getBasePriceWithTax() : getBasePrice();
    }

    ////
    
    
    public void setEnterCurrencyBasePrice(double enterPrice) {
	if (isIncludeTaxInAmount()) {
	    setCurrencyBasePriceWithTax(enterPrice);
	} else {
	    setCurrencyBasePrice(enterPrice);
	}
    }

    public double getEnterCurrencyBasePrice() {
	return isIncludeTaxInAmount() ? getCurrencyBasePriceWithTax() : getCurrencyBasePrice();
    }    
    
    ////
    
    public boolean isCorrectedPriceItem() {
	return false;
    }

//    public Object clone() {
//	return super.clone();
//    }

    //// 


    public ProductInstance getProductInstance() {
        return productInstance;
    }

    public void setProductInstance(ProductInstance productInstance) {
        this.productInstance = productInstance;
    }
    
    ////
    
    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

 
    
    ////
    
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    public String getSupplierName() {
	return getProduct() == null ? null : getProduct().getSupplierName(); 
    }
    
    
    public String getDocumentTitle() {
	return getProduct() == null ? null : (getProduct().getDocument() == null ? null : getProduct().getDocumentTitle());
    }
    
    public String getResponsibleName() {
	return getProduct() == null ? null : (getProduct().getResponsible() == null ? null : getProduct().getResponsibleName());
    }
    
}
