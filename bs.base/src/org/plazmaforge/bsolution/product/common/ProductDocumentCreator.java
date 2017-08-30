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
package org.plazmaforge.bsolution.product.common;

import java.util.List;

import org.plazmaforge.bsolution.document.common.beans.Document;
import org.plazmaforge.bsolution.finance.common.FinanceDocumentCreator;
import org.plazmaforge.bsolution.product.common.beans.ProductDocument;
import org.plazmaforge.bsolution.product.common.beans.ProductDocumentItem;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.ClassUtilsExt;


/** 
 * @author Oleh Hapon
 * $Id: DefaultProductDocumentCreator.java,v 1.4 2010/12/05 07:56:04 ohapon Exp $
 */
public class ProductDocumentCreator extends FinanceDocumentCreator {

    protected void populate(Document parentDocument, Document document) throws ApplicationException {
	if (parentDocument == null || document == null) {
	    return;
	}
	super.populate(parentDocument, document);

	ProductDocument parentProductDocument = (ProductDocument) parentDocument;  
	ProductDocument productDocument = (ProductDocument) document;
	
	// PRICE MANAGEMENT
	productDocument.setPriceType(parentProductDocument.getPriceType());
	productDocument.setCorrectPriceType(parentProductDocument.getCorrectPriceType());
	productDocument.setDiscountPercent(parentProductDocument.getDiscountPercent());
	productDocument.setMarkupPercent(parentProductDocument.getMarkupPercent());
	
	
	// PRODUCT ITEMS
	List<ProductDocumentItem> parentItems = parentProductDocument.getProductItems();
	for (ProductDocumentItem parentItem : parentItems) {
	    ProductDocumentItem newItem = createItemByDocumentClass(document.getClass());
	    populateItem(parentItem, newItem);
	    productDocument.addProductItem(newItem);
	}
    }
    
    protected ProductDocumentItem createItemByDocumentClass(Class documentClass) throws ApplicationException {
	String itemClassName = documentClass.getName() + "Item";
	return (ProductDocumentItem) ClassUtilsExt.getClassInstance(itemClassName);
    }
    
    protected void populateItem(ProductDocumentItem parentItem, ProductDocumentItem item) throws ApplicationException {
	
	// PRODUCT
	item.setProduct(parentItem.getProduct());
	item.setProductFeatureName(parentItem.getProductFeatureName());
	
	// UNIT
	item.setUnit(parentItem.getUnit());
	item.setUnitRate(parentItem.getUnitRate());
	
	// QUANTITY
	item.setQuantity(parentItem.getQuantity());
	
	
	// PRICE
	item.setPrice(parentItem.getPrice());
	item.setPriceWithTax(parentItem.getPriceWithTax());
	item.setTaxPrice(parentItem.getTaxPrice());

	// CURRENCY PRICE
	item.setCurrencyPrice(parentItem.getCurrencyPrice());
	item.setCurrencyPriceWithTax(parentItem.getCurrencyPriceWithTax());
	item.setCurrencyTaxPrice(parentItem.getCurrencyTaxPrice());

	
	
	// BASE PRICE
	item.setBasePrice(parentItem.getBasePrice());
	item.setBasePriceWithTax(parentItem.getBasePriceWithTax());
	item.setTaxBasePrice(parentItem.getTaxBasePrice());

	// CURRENCY BASE PRICE
	item.setCurrencyBasePrice(parentItem.getCurrencyBasePrice());
	item.setCurrencyBasePriceWithTax(parentItem.getCurrencyBasePriceWithTax());
	item.setCurrencyTaxBasePrice(parentItem.getCurrencyTaxBasePrice());

	
	
	// AMOUNT
	item.setAmount(parentItem.getAmount());
	item.setAmountWithTax(parentItem.getAmountWithTax());
	item.setTaxAmount(parentItem.getTaxAmount());
	
	// CURRENCY AMOUNT
	item.setCurrencyAmount(parentItem.getCurrencyAmount());
	item.setCurrencyAmountWithTax(parentItem.getCurrencyAmountWithTax());
	item.setCurrencyTaxAmount(parentItem.getCurrencyTaxAmount());

	
	// TAX
	item.setTax(parentItem.isTax());
	item.setTaxId(parentItem.getTaxId());
	item.setTaxPercent(parentItem.getTaxPercent());
	
	
	// PRICE MANAGEMENT
	item.setPriceType(parentItem.getPriceType());
	item.setCorrectPriceType(parentItem.getCorrectPriceType());
	item.setDiscountPercent(parentItem.getDiscountPercent());
	item.setMarkupPercent(parentItem.getMarkupPercent());
	
	
	
    }
}
