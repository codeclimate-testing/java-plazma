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
 * Created on 06.06.2007
 *
 */

package org.plazmaforge.bsolution.goods.client.swt.forms;

import org.eclipse.swt.widgets.Composite;
import org.plazmaforge.bsolution.finance.client.swt.forms.AbstractFinanceDocumentEditForm;
import org.plazmaforge.bsolution.organization.common.beans.Warehouse;
import org.plazmaforge.bsolution.product.common.beans.PriceType;
import org.plazmaforge.bsolution.product.common.beans.ProductDocument;
import org.plazmaforge.bsolution.product.common.beans.ProductDocumentItem;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XPercentField;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;
import org.plazmaforge.framework.core.exception.ApplicationException;


/** 
 * @author Oleh Hapon
 * $Id: AbstractGoodsDocumentEditForm.java,v 1.5 2010/12/05 07:57:19 ohapon Exp $
 */

public abstract class AbstractGoodsDocumentEditForm extends AbstractFinanceDocumentEditForm {

    
    private XComboEdit priceTypeField;
    
    private XPercentField pricePercentField;
    
    
    
    public AbstractGoodsDocumentEditForm(Composite parent, int style) {
	super(parent, style);
    }
    
    protected void initPriceTypeField(XComboEdit priceTypeField) {
	this.priceTypeField = priceTypeField;
    }
    
    protected void initPricePercentField(XPercentField pricePercentField) {
	this.pricePercentField = pricePercentField;
    }
    
    protected void initWarehouseField(XComboEdit warehouseField) {
	warehouseField.setAssociationValueClass(Warehouse.class);
    }
  
    protected void initProductItemType(TableEntityProvider type) {
	type.setListProperty("productItems");
	type.setAddMethod("addProductItem", ProductDocumentItem.class);
    }

    protected ProductDocument getProductDocument() {
	return (ProductDocument) getEntity();
	
    }
    
    /**
     * General calculate document (items and header)
     */
    protected void calculateGeneral() {
	getProductDocument().calculateGeneral();
    }
    
    protected void afterModifyItem(Object item) throws ApplicationException {
        updateAmount();
    }
    
    protected void updateAmount() {
        calculateGeneral();
        updateAmountControls();
    }
    
    protected void updateAmountControls() {}

 
    protected PriceType getPriceTypeValue() {
	if (priceTypeField == null) {
	    return getProductDocument() == null ? null : getProductDocument().getPriceType();
	}
	return (PriceType) priceTypeField.getValue();
    }

    protected float getPricePercentValue() {
	if (pricePercentField == null) {
	    return getProductDocument() == null ? 0f : getProductDocument().getPricePercent();
	}
	return pricePercentField.floatValue();
    }

}
