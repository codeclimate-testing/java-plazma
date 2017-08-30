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
import org.plazmaforge.bsolution.carservice.common.beans.CarPaint;
import org.plazmaforge.bsolution.carservice.common.beans.CarPart;
import org.plazmaforge.bsolution.finance.client.swt.forms.common.XTaxCombo;
import org.plazmaforge.bsolution.goods.client.swt.forms.AbstractGoodsDocumentItemEditForm;
import org.plazmaforge.bsolution.product.client.swt.forms.common.XProductUnitCombo;
import org.plazmaforge.bsolution.product.common.beans.PriceType;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.core.exception.ApplicationException;

/**
 * 
 * @author Oleh Hapon
 * $Id: CarServOrderItemEditForm.java,v 1.4 2010/12/05 07:53:48 ohapon Exp $
 */
public class CarServOrderItemEditForm extends AbstractGoodsDocumentItemEditForm {

    private Label goodsLabel;
    //private Label productFeatureLabel;
    //private Label warehouseLabel;
    
    private Label unitLabel;
    private Label unitRateLabel;
    private Label quantityLabel;
    
    private Label currencyBasePriceLabel;    
    private Label pricePercentLabel;
    private Label currencyPriceLabel;
    
    private Label currencyAmountLabel;
    private Label taxLabel;
    private Label currencyTaxAmountLabel;
    
 
    private XComboEdit goodsField;
    //private XTextField productFeatureField;  
    //private XComboEdit warehouseField;
    
    private XProductUnitCombo unitField;
    private XCurrencyField unitRateField;
    private XCurrencyField quantityField;
    
    private XCurrencyField currencyBasePriceField;     
    private XCurrencyField pricePercentField;    
    private XCurrencyField currencyPriceField;
    
    private XCurrencyField currencyAmountField;
    private XTaxCombo taxField;
    private XCurrencyField currencyTaxAmountField;
    

    public  CarServOrderItemEditForm(Composite parent, int style) {
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
	goodsLabel.setText(Messages.getString("CarServOrderItemEditForm.goodsLabel.text")); //$NON-NLS-1$

    	goodsField = new XComboEdit(this, SWT.BORDER, PWT.VIEW_BUTTON | PWT.EDIT_BUTTON | PWT.DELETE_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
	//gridData.widthHint = 300;
    	goodsField.setLayoutData(gridData);

    	////
    	
    	/*
    	productFeatureLabel = new Label(this, SWT.NONE);
    	productFeatureLabel.setText(Messages.getString("CarServOrderItemEditForm.productFeatureLabel.text")); //$NON-NLS-1$

    	productFeatureField = new XTextField(this, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
	//gridData.widthHint = 300;
	productFeatureField.setLayoutData(gridData);

	
    	label = new Label(this, SWT.HORIZONTAL | SWT.SEPARATOR);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
   	
    	
    	warehouseLabel = new Label(this, SWT.NONE);
	warehouseLabel.setText(Messages.getString("CarServOrderItemEditForm.warehouseLabel.text")); //$NON-NLS-1$

    	warehouseField = new XComboEdit(this, SWT.BORDER, PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	warehouseField.setLayoutData(gridData);
    	*/

    	
    	label = new Label(this, SWT.HORIZONTAL | SWT.SEPARATOR);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
    	
    	
    	
    	
	unitLabel = new Label(this, SWT.NONE);
    	unitLabel.setText(Messages.getString("CarServOrderItemEditForm.unitLabel.text")); //$NON-NLS-1$

    	unitField = new XProductUnitCombo(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	unitField.setLayoutData(gridData);
    	
    	
    	////~
    	currencyBasePriceLabel = new Label(this, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 40;
    	currencyBasePriceLabel.setLayoutData(gridData);
    	currencyBasePriceLabel.setText(Messages.getString("CarServOrderItemEditForm.currencyBasePriceLabel.text")); //$NON-NLS-1$

    	currencyBasePriceField = new XCurrencyField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyBasePriceField.setLayoutData(gridData);
    	////~
    	
    	unitRateLabel = new Label(this, SWT.NONE);
    	gridData = new GridData();
    	unitRateLabel.setLayoutData(gridData);
    	unitRateLabel.setText(Messages.getString("CarServOrderItemEditForm.unitRateLabel.text")); //$NON-NLS-1$

    	unitRateField = new XCurrencyField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	unitRateField.setLayoutData(gridData);
    	//initUnitRateField(unitRateField);
    	
	
    	////~
    	pricePercentLabel = new Label(this, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 40;
    	pricePercentLabel.setLayoutData(gridData);
    	pricePercentLabel.setText(Messages.getString("CarServOrderItemEditForm.pricePercentLabel.text")); //$NON-NLS-1$

    	pricePercentField = new XCurrencyField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	pricePercentField.setLayoutData(gridData);
    	////~
    	
    	
    	quantityLabel = new Label(this, SWT.NONE);
	quantityLabel.setText(Messages.getString("CarServOrderItemEditForm.quantityLabel.text")); //$NON-NLS-1$

    	quantityField = new XCurrencyField(this, SWT.BORDER); 
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	quantityField.setLayoutData(gridData);
	

    	currencyPriceLabel = new Label(this, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 40;
    	currencyPriceLabel.setLayoutData(gridData);
    	currencyPriceLabel.setText(Messages.getString("CarServOrderItemEditForm.currencyPriceLabel.text")); //$NON-NLS-1$

    	currencyPriceField = new XCurrencyField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyPriceField.setLayoutData(gridData);
    	initCurrencyPriceField(currencyPriceField);
	
	
	//
	label = new Label(this, SWT.NONE);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
	
	
    	currencyAmountLabel = new Label(this, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 40;
    	currencyAmountLabel.setLayoutData(gridData);
    	currencyAmountLabel.setText(Messages.getString("CarServOrderItemEditForm.currencyAmountLabel.text")); //$NON-NLS-1$

    	currencyAmountField = new XCurrencyField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyAmountField.setLayoutData(gridData);
    	initCurrencyAmountField(currencyAmountField);

	//
 
    	
    	//-----------------------------------------------------------------------------------------------
    	
    	label = new Label(this, SWT.HORIZONTAL | SWT.SEPARATOR);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
   	
	taxLabel = new Label(this, SWT.NONE);
	taxLabel.setText(Messages.getString("CarServOrderItemEditForm.taxLabel.text")); //$NON-NLS-1$

	taxField = new XTaxCombo(this, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	gridData.widthHint = 100;
	taxField.setLayoutData(gridData);
	
    	
	currencyTaxAmountLabel = new Label(this, SWT.NONE);
	gridData = new GridData();
	gridData.horizontalIndent = 40;
	currencyTaxAmountLabel.setLayoutData(gridData);
	currencyTaxAmountLabel.setText(Messages.getString("CarServOrderItemEditForm.currencyTaxAmountLabel.text")); //$NON-NLS-1$

	currencyTaxAmountField = new XCurrencyField(this, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyTaxAmountField.setLayoutData(gridData);
    	
    	this.setSize(new Point(470, 108)); 
    	
    	// ITEM INIT
    	initGoodsField(goodsField);
    	
    	
    	initUnitField(unitField);
    	initTaxField(taxField);
    	initQuantityField(quantityField);
    	initCurrencyTaxAmountField(currencyTaxAmountField);
    	
    	initNoEditableField(unitRateField);
    	initCurrencyBasePriceField(currencyBasePriceField); 
    	initPricePercentField(pricePercentField);    	
    	
    }
    
    @Override
    public void init() throws ApplicationException {
	
	// USE ONLY FOR CART PART /////////////////////////////////////////////////////////////////////////////////// 
	String entityType = (String) getData("entity.type");
    	if (CarPart.CLASS_ID.equals(entityType)) {
    	    goodsLabel.setText(Messages.getString("CarServOrderItemEditForm.carPartLabel.text")); //$NON-NLS-1$
    	    goodsField.setAssociationValueClass(CarPart.class);
    	    
    	} else if (CarPaint.CLASS_ID.equals(entityType)) {
    	    goodsLabel.setText(Messages.getString("CarServOrderItemEditForm.carPaintLabel.text")); //$NON-NLS-1$
    	    goodsField.setAssociationValueClass(CarPaint.class);
    	}
    	////////////////////////////////////////////////////////////////////////////////////////////////////////////
    	
    	
	super.init();
    }

    
    protected void bindControls() {
	
	bindControl(goodsField, "product");
	
	//bindControl(productFeatureField, "productFeatureName");
	//bindControl(warehouseField, "warehouse");
	
	bindControl(unitField, "unit", unitLabel, REQUIRED);
	bindControl(unitRateField, "unitRate");
	bindControl(quantityField, "quantity");
	
	bindControl(currencyBasePriceField, "enterCurrencyBasePrice");
	bindControl(pricePercentField, "pricePercent");
	bindControl(currencyPriceField, "enterCurrencyPrice");
	
	bindControl(currencyAmountField, "enterCurrencyAmount");
	bindControl(taxField, "taxId");
	bindControl(currencyTaxAmountField, "currencyTaxAmount");
	

    }    
    

    protected int getDefaultPriceType() {
	return PriceType.LIST_PRICE;
    }

  
}
