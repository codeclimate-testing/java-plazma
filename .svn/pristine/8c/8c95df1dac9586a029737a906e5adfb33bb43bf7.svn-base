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
 * Created on 09.06.2007
 *
 */

package org.plazmaforge.bsolution.goods.client.swt.forms;


import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.common.beans.Currency;
import org.plazmaforge.bsolution.base.common.beans.Unit;
import org.plazmaforge.bsolution.finance.client.swt.forms.common.XTaxCombo;
import org.plazmaforge.bsolution.goods.common.beans.Goods;
import org.plazmaforge.bsolution.goods.common.beans.GoodsType;
import org.plazmaforge.bsolution.product.client.swt.forms.common.XProductUnitCombo;
import org.plazmaforge.bsolution.product.common.beans.PriceType;
import org.plazmaforge.bsolution.product.common.beans.Product;
import org.plazmaforge.bsolution.product.common.beans.ProductDocument;
import org.plazmaforge.bsolution.product.common.beans.ProductDocumentItem;
import org.plazmaforge.bsolution.product.common.beans.ProductHeader;
import org.plazmaforge.bsolution.product.common.beans.ProductPrice;
import org.plazmaforge.bsolution.product.common.services.ProductService;
import org.plazmaforge.framework.client.models.ValueChangeEvent;
import org.plazmaforge.framework.client.models.ValueChangeListener;
import org.plazmaforge.framework.client.swt.SWTResourceManager;
import org.plazmaforge.framework.client.swt.controls.AbstractTextControl;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.MoneyCalculator;
import org.plazmaforge.framework.util.MoneyEnvironment;


/** 
 * @author Oleh Hapon
 * $Id: AbstractGoodsDocumentItemEditForm.java,v 1.9 2010/12/05 07:57:19 ohapon Exp $
 */

public class AbstractGoodsDocumentItemEditForm extends AbstractEditForm {

    private XComboEdit goodsField;
    private XTextField productFeatureField;
    private XProductUnitCombo unitField;
    private XCurrencyField unitRateField;
    private XCurrencyField quantityField;
    
    private XCurrencyField currencyBasePriceField;
    private XCurrencyField pricePercentField;    
    private XCurrencyField currencyPriceField;
    
    private XCurrencyField currencyAmountField;
    private XTaxCombo taxField;
    private XCurrencyField currencyTaxAmountField;
    
    private boolean editableGoods = true;
    
    public AbstractGoodsDocumentItemEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    private void initialize() {
	setDataSourceSupport(false); // ITEM FORM
	//setAutoSendFocusOut(true); // AUTO SEND FOCUS OUT
    }
    
    public void beforeUpdateForm() throws ApplicationException {
	if (unitField != null) {
	    unitField.initByProductId(getProductId());
	}
    }
    

    
    protected void initGoodsField(final XComboEdit goodsField) {
	if (goodsField == null) {
	    return;
	}
	this.goodsField = goodsField;
	goodsField.setAssociationValueClass(Goods.class);
	
	// PART 1 - ValueChangeListener ALWAYS
	goodsField.addValueChangeListener(new ValueChangeListener() {
	    public void valueChange(ValueChangeEvent e) {
		// If new value is NULL then set EDITABLE mode
		goodsField.setEditable(e.getNewValue() == null);
	    }
	});

	// PART 2
	goodsField.addValueChangeListener(new ValueChangeListener() {
	    public void valueChange(ValueChangeEvent e) {
		if (!e.isInitValueState) {
		    return;
		}
		onGoodsFieldAction();
	    }
	});
    }
    
    protected void onGoodsFieldAction() {
	ProductHeader product = (ProductHeader) goodsField.getValue();
	if (!isEditableGoods() && product == null) {
	    
	    // FIX 2008-10-22
	    if (unitField != null) {
		unitField.setValue(null);
	    }
	    
	    if (unitRateField != null) {
		unitRateField.setValue(1d);
	    }
	    
	    return;
	}
	Integer productId = product == null ? null : product.getId();
	Unit unit = product == null ? null : product.getUnit();
	
	// FIX 2008-10-22
	if (unitField != null) {
	    unitField.initByProductId(productId, true, unit);
	}
	
	onUnitFieldAction();
	setProductQuantity(product);
	setProductPrice(product, unit);
    }
    
    protected void setProductPrice(ProductHeader product, Unit unit) {
	Currency currency = getCurrencyValue(); //getProductDocument().getCurrency(); // ?????
	PriceType priceType = getPriceTypeValue();
	setProductPrice(product, unit, currency, priceType);
    }
    
    protected boolean forceSetPrice = true;
    
    protected void setProductPrice(ProductHeader product, Unit unit, Currency currency, PriceType priceType) {
	if (product == null) {
	    if (forceSetPrice) {
		setProductPriceValue(0d);
	    }
	    return;
	}
	Currency documentCurrency = currency;
	Currency productCurrency = product.getCurrency();
	if (documentCurrency == null || productCurrency == null) {
	    if (forceSetPrice) {
		setProductPriceValue(0d);
	    }
	    return;
	}
	Integer documentCurrencyId = documentCurrency.getId();
	Integer productCurrencyId = productCurrency.getId();
	if (documentCurrencyId == null || productCurrencyId == null) {
	    if (forceSetPrice) {
		setProductPriceValue(0d);
	    }
	    return;
	}
	
	// Compare currency
	if (documentCurrencyId.equals(productCurrencyId)) {
	    setProductPriceValue(getSelectedProductPrice(product, unit, currency, priceType));
	} else {
	    // TODO: getSelectedNonCurrencyPrice
	    if (forceSetPrice) {
		setProductPriceValue(0d);
	    }
	}
    }
    
    protected double getSelectedProductPrice(ProductHeader product, Unit unit, Currency currency, PriceType priceType) {
	if (priceType == null) {
	    if (PriceType.LIST_PRICE == getDefaultPriceType()) {
		return product.getCurrencyListPrice(); 
	    }
	    return product.getCurrencyCostPrice();
	}
	if (product instanceof Product) {
	    
	    try {
		    ProductService s = (ProductService) getService(ProductService.class);
		    List<ProductPrice> prices = s.findPriceByProductId(product.getId());
		    
		    return ((Product) product).findPrice(prices, priceType, currency, unit);
		
	    } catch (Exception ex) {
		logger.error(ex);
	    }
	}
	return 0d;
	
	//return product.getCurrencyPrice(priceType);
    }
    
    protected int getDefaultPriceType() {
	return PriceType.COST_PRICE;
    }
    
    protected void setProductPriceValue(double price) {
	
	if (getProductDocumentItem().isCorrectedPriceItem()) {
	    if (currencyBasePriceField != null) {
		currencyBasePriceField.setValue(price);
		calculatePriceByBasePrice();
		calculateAmount();
	    }
	} else {
	    if (currencyPriceField != null) {
		currencyPriceField.setValue(price);
		calculateAmount();
	    }
	}
	
    }
    
    protected void setProductQuantity(ProductHeader product) {
	if (quantityField == null) {
	    return;
	}
	double quantity = quantityField.doubleValue();
	if (quantity != ProductDocumentItem.EMPTY_QUANTITY) {
	    return;
	}
	quantityField.setValue(ProductDocumentItem.DEFAULT_QUANTITY);
    }
    
    protected void initUnitField(final XProductUnitCombo unitField) {
	if (unitField == null) {
	    return;
	}
	this.unitField = unitField;
	unitField.setEditableGoods(isEditableGoods());
	
	unitField.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		onUnitFieldAction();
	    }
	});
    }    
    
    protected void onUnitFieldAction() {
	if (unitField == null || unitRateField == null) {
	    return;
	}
	unitRateField.setValue(unitField.getRate());
    }    
    
    protected void initUnitRateField(final XCurrencyField unitRateField) {
	this.unitRateField = unitRateField;
    }
    
    protected void initTaxField(final XTaxCombo taxField) {
	if (taxField == null) {
	    return;
	}
	this.taxField = taxField;
	taxField.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		calculateTaxAmount();
	    }
	});
    }  
    
    
    protected void initQuantityField(final XCurrencyField quantityField) {
	if (quantityField == null) {
	    return;
	}
	this.quantityField = quantityField;
	quantityField.addFocusListener(new FocusAdapter() {
	    public void focusLost(FocusEvent e) {
		calculateAmount();
	    }
	});
    }      
    
    protected void initCurrencyBasePriceField(final XCurrencyField currencyBasePriceField) {
	if (currencyBasePriceField == null) {
	    return;
	}
	this.currencyBasePriceField = currencyBasePriceField;
	currencyBasePriceField.addFocusListener(new FocusAdapter() {
	    public void focusLost(FocusEvent e) {
		calculatePriceByBasePrice();
		calculateAmount();
	    }
	});
    } 

    protected void initPricePercentField(final XCurrencyField pricePercentField) {
	if (pricePercentField == null) {
	    return;
	}
	this.pricePercentField = pricePercentField;
	pricePercentField.addFocusListener(new FocusAdapter() {
	    public void focusLost(FocusEvent e) {
		calculatePriceByBasePrice();
		calculateAmount();
	    }
	});
    } 

    protected void initCurrencyPriceField(final XCurrencyField currencyPriceField) {
	if (currencyPriceField == null) {
	    return;
	}
	this.currencyPriceField = currencyPriceField;
	currencyPriceField.addFocusListener(new FocusAdapter() {
	    public void focusLost(FocusEvent e) {
		calculateBasePriceByPrice();
		calculateAmount();
	    }
	});
    } 
    
    
    protected void initCurrencyAmountField(final XCurrencyField currencyAmountField) {
	if (currencyAmountField == null) {
	    return;
	}
	this.currencyAmountField = currencyAmountField;
	currencyAmountField.addFocusListener(new FocusAdapter() {
	    public void focusLost(FocusEvent e) {
		calculatePrice();
		calculateBasePriceByPrice();		
		calculateTaxAmount();
	    }
	});
    } 
    
    protected void initCurrencyTaxAmountField(final XCurrencyField currencyTaxAmountField) {
	if (currencyTaxAmountField == null) {
	    return;
	}
	this.currencyTaxAmountField = currencyTaxAmountField;
    }     
    
  
    /**
     * Calculate price by quantity and amount
     *
     */
    protected void calculatePrice() {
	if (currencyPriceField == null) {
	    return;
	}
	float quantity = quantityField == null ?  0 : quantityField.floatValue();
	float amount = currencyAmountField == null ?  0 : currencyAmountField.floatValue();
	currencyPriceField.setValue(MoneyCalculator.calculatePrice(quantity, amount));
    }

    // For discount:
    // price = basePrice - (basePrice * pricePercent / 100)
    // price = basePrice * (1 - pricePercent / 100)
    // k = pricePercent / 100
    
    // price =  basePrice * (1 - k)
    // basePrice = price / (1 - k)
    
    
    protected float getPriceCoef(float k) {
	// TODO: Stub: Only discount
	return 1 - k;
    }
    
    protected void calculatePriceByBasePrice() {
	if (currencyPriceField == null) {
	    return;
	}
	float basePrice = currencyBasePriceField == null ? 0 : currencyBasePriceField.floatValue();
	float pricePercent = pricePercentField == null ?  0 : pricePercentField.floatValue();
	
	if (basePrice == 0 || pricePercent == 0) {
	    currencyPriceField.setValue(basePrice);
	    return;
	}
	float k = pricePercent / 100;
	currencyPriceField.setValue(MoneyEnvironment.roundPrice(basePrice * getPriceCoef(k)));
    }

    
    protected void calculateBasePriceByPrice() {
	if (currencyBasePriceField == null) {
	    return;
	}
	float price = currencyPriceField == null ? 0 : currencyPriceField.floatValue();
	float pricePercent = pricePercentField == null ?  0 : pricePercentField.floatValue();
	
	if (price == 0 || pricePercent == 0) {
	    currencyBasePriceField.setValue(price);
	    return;
	}
	float k = pricePercent / 100;
	currencyBasePriceField.setValue(MoneyEnvironment.roundPrice(price / getPriceCoef(k)));
    }

    /**
     * Calculate amount by quantity and price
     * 
     */
    protected void calculateAmount() {
	if (currencyAmountField == null) {
	    return;
	}
	float quantity = quantityField == null ?  0 : quantityField.floatValue();
	float price = currencyPriceField == null ?  0 : currencyPriceField.floatValue();
	currencyAmountField.setValue(MoneyCalculator.calculateAmount(quantity, price));
	calculateTaxAmount();
    }

    /**
     * Calculate tax amount by tax percent and amount
     * 
     */
    protected void calculateTaxAmount() {
	if (currencyTaxAmountField == null) {
	    return;
	}	
	float taxPercent = taxField == null ?  0 : taxField.getTaxPercent();
	float amount = currencyAmountField == null ?  0 : currencyAmountField.floatValue();
	currencyTaxAmountField.setValue(MoneyCalculator.calculateTaxAmount(taxPercent, amount, isIncludeTaxInAmount()));
    }

    protected ProductDocument getProductDocument() {
	return (ProductDocument) getParentEntity();
    }
    protected ProductDocumentItem getProductDocumentItem() {
	return (ProductDocumentItem) getEntity();
    }
    
    
    protected boolean isIncludeTaxInAmount() {
	return getProductDocumentItem() == null ? false	: getProductDocumentItem().isIncludeTaxInAmount();
    }
    
    protected ProductHeader getProduct() {
	ProductDocumentItem productDocumentItem = getProductDocumentItem();
	if (productDocumentItem == null) {
	    return null;
	}
	return productDocumentItem.getProduct(); 
    }
    
    protected Integer getProductId() {
	ProductHeader product = getProduct();
	if (product == null) {
	    return null;
	}
	return product.getId();
    }

    
    
    
    
    
    
    //------
    
    protected void afterUpdateData() throws ApplicationException {
	super.afterUpdateData();
	checkGoods();
	calculateCommon();
    }
    
    protected void checkGoods() throws ApplicationException {
	
	// ONLY FOR EDITABLE GOODS
	if (!isEditableGoods()) {
	    return;
	}

	Object value = goodsField.getValue();
	if (value != null) {
	    return;
	}
	Goods goods = new Goods();
	goods.setGoodsType(new GoodsType());
	goods.setName(goodsField.getText());
	
	goods.setOrganization(getProductDocument().getOrganization());
	goods.setUnit(getProductDocumentItem().getUnit());
	goods.setCurrency(getProductDocument().getCurrency());
	
	goods.setPrice(getProductDocumentItem().getCurrencyPriceWithTax());
	
	getProductDocumentItem().setProduct(goods);
    }

    protected void calculateCommon() {
	getProductDocumentItem().calculateGeneral(getProductDocument().getCurrencyRate());
    }
    
    protected void initNoEditableField(final AbstractTextControl field) {
	field.setEditable(false);
    	field.setBackground(getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
    }
    
    protected Color getSystemColor(int color) {
	return SWTResourceManager.getColor(color);
    }

    ////
    
    public boolean isEditableGoods() {
        return editableGoods;
    }

    public void setEditableGoods(boolean editableGoods) {
        this.editableGoods = editableGoods;
    }
    

    ////
    
    protected void validateControls(StringBuffer buf) throws ApplicationException {
	
	// ONLY FOR EDITABLE GOODS
	if (!isEditableGoods()) {
	    return;
	}
	
	if (goodsField == null) {
	    return;
	}
	Object value = goodsField.getValue();
	if (value != null) {
	    return;
	}
	String name = goodsField.getText();
	if (name == null || name.trim().length() == 0) {
	    validateField(buf, false, getNameResourceString(), getRequiredResourceString());
	}
	super.validateControls(buf);
    }
    
    protected AbstractGoodsDocumentEditForm getProductDocumentEdit() {
	return (AbstractGoodsDocumentEditForm) getParentForm();
    }
    
    protected Currency getCurrencyValue() {
	if (getProductDocumentEdit() == null) {
	    return null;
	}
	return getProductDocumentEdit().getCurrencyValue();
    }

    protected PriceType getPriceTypeValue() {
	if (getProductDocumentEdit() == null) {
	    return null;
	}
	return getProductDocumentEdit().getPriceTypeValue();
    }

    
    protected void initData() throws ApplicationException {
	super.initData();
	getProductDocumentItem().setQuantity(ProductDocumentItem.DEFAULT_QUANTITY);
	Unit unit = EnterpriseEnvironment.getUnit();
	if (unit != null) {
	    getProductDocumentItem().setUnit(unit);
	    getProductDocumentItem().setUnitRate(ProductDocumentItem.DEFAULT_UNIT_RATE);
	}
	if (getProductDocumentEdit() != null) {
	    getProductDocumentItem().setPricePercent(getProductDocumentEdit().getPricePercentValue());
	}
	
    }
    

}
