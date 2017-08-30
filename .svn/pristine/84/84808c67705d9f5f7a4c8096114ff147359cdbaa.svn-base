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

package org.plazmaforge.bsolution.carservice.client.swt.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.bsolution.goods.client.swt.forms.AbstractGoodsDocumentItemEditForm;
import org.plazmaforge.bsolution.partner.common.beans.Partner;
import org.plazmaforge.bsolution.product.client.swt.forms.common.XProductUnitCombo;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;

/**
 * 
 * @author Oleh Hapon
 * $Id: CarMtrlPurchaseRequestItemEditForm.java,v 1.2 2010/04/28 06:23:01 ohapon Exp $
 */
public class CarMtrlPurchaseRequestItemEditForm extends AbstractGoodsDocumentItemEditForm {

    private Label goodsLabel;
    private Label unitLabel;
    private Label unitRateLabel;
    private Label quantityLabel;
    private Label currencyPriceLabel;
    private Label currencyAmountLabel;
    
    private Label supplierLabel;
    private Label deliveryDateLabel;
     
 
    private XComboEdit goodsField;
    private XProductUnitCombo unitField;
    private XCurrencyField unitRateField;
    private XCurrencyField quantityField;
    private XCurrencyField currencyPriceField;     
    private XCurrencyField currencyAmountField;
    
    private XComboEdit supplierField;
    private XDateCombo deliveryDateField;
     

    public  CarMtrlPurchaseRequestItemEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    private void initialize() {

	Label label;
	

	GridData gridData;
	GridLayout gridLayout = new GridLayout();
	gridLayout.numColumns = 4;
	setLayout(gridLayout);	
	
    	goodsLabel = new Label(this, SWT.NONE);
	goodsLabel.setText(Messages.getString("CarMtrlPurchaseRequestItemEditForm.goodsLabel.text")); //$NON-NLS-1$

    	goodsField = new XComboEdit(this, SWT.BORDER, PWT.VIEW_BUTTON | PWT.EDIT_BUTTON | PWT.DELETE_BUTTON);
	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1);
	gridData.widthHint = 300;
    	goodsField.setLayoutData(gridData);

    	label = new Label(this, SWT.HORIZONTAL | SWT.SEPARATOR);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
   	
    	
    	
	unitLabel = new Label(this, SWT.NONE);
    	unitLabel.setText(Messages.getString("CarMtrlPurchaseRequestItemEditForm.unitLabel.text")); //$NON-NLS-1$

    	unitField = new XProductUnitCombo(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	unitField.setLayoutData(gridData);
    	
	unitRateLabel = new Label(this, SWT.NONE);
	gridData = new GridData();
	gridData.horizontalIndent = 40;
	unitRateLabel.setLayoutData(gridData);
	unitRateLabel.setText(Messages.getString("CarMtrlPurchaseRequestItemEditForm.unitRateLabel.text")); //$NON-NLS-1$

    	unitRateField = new XCurrencyField(this, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	gridData.widthHint = 100;
	unitRateField.setLayoutData(gridData);

    	quantityLabel = new Label(this, SWT.NONE);
	quantityLabel.setText(Messages.getString("CarMtrlPurchaseRequestItemEditForm.quantityLabel.text")); //$NON-NLS-1$

    	quantityField = new XCurrencyField(this, SWT.BORDER); 
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	quantityField.setLayoutData(gridData);
    	
   	

    	currencyPriceLabel = new Label(this, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 40;
    	currencyPriceLabel.setLayoutData(gridData);
	currencyPriceLabel.setText(Messages.getString("CarMtrlPurchaseRequestItemEditForm.currencyPriceLabel.text")); //$NON-NLS-1$

    	currencyPriceField = new XCurrencyField(this, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	gridData.widthHint = 100;
	currencyPriceField.setLayoutData(gridData);
	
	
	label = new Label(this, SWT.NONE);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
	
	
 	currencyAmountLabel = new Label(this, SWT.NONE);
 	gridData = new GridData();
 	gridData.horizontalIndent = 40;
 	currencyAmountLabel.setLayoutData(gridData);
	currencyAmountLabel.setText(Messages.getString("CarMtrlPurchaseRequestItemEditForm.currencyAmountLabel.text")); //$NON-NLS-1$

	currencyAmountField = new XCurrencyField(this, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyAmountField.setLayoutData(gridData);
    	
    	////
    	
    	supplierLabel = new Label(this, SWT.NONE);
    	supplierLabel.setText(Messages.getString("CarMtrlPurchaseRequestItemEditForm.supplierLabel.text")); //$NON-NLS-1$

    	supplierField = new XComboEdit(this, SWT.BORDER, PWT.VIEW_BUTTON);
	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1);
	gridData.widthHint = 300;
	supplierField.setLayoutData(gridData);

	deliveryDateLabel = new Label(this, SWT.NONE);
	deliveryDateLabel.setText(Messages.getString("CarMtrlPurchaseRequestItemEditForm.deliveryDateLabel.text")); //$NON-NLS-1$

	deliveryDateField = new XDateCombo(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	deliveryDateField.setLayoutData(gridData);
	    	
    	this.setSize(new Point(470, 108)); 
    	
    	// ITEM INIT
    	initGoodsField(goodsField);
    	initUnitField(unitField);
    	initUnitRateField(unitRateField);
    	initQuantityField(quantityField);
    	initCurrencyPriceField(currencyPriceField);
    	initCurrencyAmountField(currencyAmountField);
    
    	initNoEditableField(unitRateField);
    	
    	supplierField.setAssociationValueClass(Partner.class);
    }
    
    protected void bindControls() {
	
	//addMapControl(goodsField, "product", goodsLabel, REQUIRED);
	
	bindControl(goodsField, "product");
	bindControl(unitField, "unit", unitLabel, REQUIRED);
	bindControl(unitRateField, "unitRate");
	bindControl(quantityField, "quantity");
	bindControl(currencyPriceField, "enterCurrencyPrice");
	bindControl(currencyAmountField, "enterCurrencyAmount");
	
	bindControl(supplierField, "supplier", supplierLabel, REQUIRED);
	bindControl(deliveryDateField, "deliveryDate");

    }    
    
}
