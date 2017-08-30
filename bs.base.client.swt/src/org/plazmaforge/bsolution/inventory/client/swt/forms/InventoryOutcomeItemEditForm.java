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
 * Created on 11.06.2007
 *
 */

package org.plazmaforge.bsolution.inventory.client.swt.forms;


import java.util.List;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.bsolution.finance.client.swt.forms.common.XTaxCombo;
import org.plazmaforge.bsolution.goods.client.swt.forms.AbstractGoodsDocumentItemEditForm;
import org.plazmaforge.bsolution.product.client.swt.forms.common.XProductUnitCombo;
import org.plazmaforge.bsolution.product.common.beans.Product;
import org.plazmaforge.bsolution.product.common.services.ProductService;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XCombo;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: InventoryOutcomeItemEditForm.java,v 1.3 2010/12/05 07:57:21 ohapon Exp $
 */

public class InventoryOutcomeItemEditForm extends AbstractGoodsDocumentItemEditForm {

    private Label goodsLabel;
    private Label productFeatureLabel;
    private Label productInstanceLabel;
    private Label unitLabel;
    private Label unitRateLabel;
    private Label quantityLabel;
    private Label currencyPriceLabel;
    private Label currencyAmountLabel;
    private Label taxLabel;
    private Label currencyTaxAmountLabel;
    
 
    private XComboEdit goodsField;
    private XTextField productFeatureField;
    private XCombo productInstanceField;
    private XProductUnitCombo unitField;
    private XCurrencyField unitRateField;
    private XCurrencyField quantityField;
    private XCurrencyField currencyPriceField;     
    private XCurrencyField currencyAmountField;
    private XTaxCombo taxField;
    private XCurrencyField currencyTaxAmountField;
    

    public  InventoryOutcomeItemEditForm(Composite parent, int style) {
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
	goodsLabel.setText(Messages.getString("InventoryOutcomeItemEditForm.goodsLabel.text")); //$NON-NLS-1$

    	goodsField = new XComboEdit(this, SWT.BORDER, PWT.VIEW_BUTTON | PWT.EDIT_BUTTON | PWT.DELETE_BUTTON);
	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1);
	gridData.widthHint = 300;
    	goodsField.setLayoutData(gridData);

    	////
    	
    	productFeatureLabel = new Label(this, SWT.NONE);
    	productFeatureLabel.setText(Messages.getString("InventoryOutcomeItemEditForm.productFeatureLabel.text")); //$NON-NLS-1$

    	productFeatureField = new XTextField(this, SWT.BORDER);
	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1);
	gridData.widthHint = 300;
	productFeatureField.setLayoutData(gridData);
	
	
	////
    	
    	productInstanceLabel = new Label(this, SWT.NONE);
    	productInstanceLabel.setText(Messages.getString("InventoryOutcomeItemEditForm.productInstanceLabel.text")); //$NON-NLS-1$

    	productInstanceField = new XCombo(this, SWT.BORDER);
	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1);
	gridData.widthHint = 300;
	productInstanceField.setLayoutData(gridData);
	productInstanceField.setDisplayValueProperty("serialNumber");

	
	////
	
	
    	label = new Label(this, SWT.HORIZONTAL | SWT.SEPARATOR);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
   	
    	
    	
	unitLabel = new Label(this, SWT.NONE);
    	unitLabel.setText(Messages.getString("InventoryOutcomeItemEditForm.unitLabel.text")); //$NON-NLS-1$

    	unitField = new XProductUnitCombo(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	unitField.setLayoutData(gridData);
    	
	unitRateLabel = new Label(this, SWT.NONE);
	gridData = new GridData();
	gridData.horizontalIndent = 40;
	unitRateLabel.setLayoutData(gridData);
	unitRateLabel.setText(Messages.getString("InventoryOutcomeItemEditForm.unitRateLabel.text")); //$NON-NLS-1$

    	unitRateField = new XCurrencyField(this, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	gridData.widthHint = 100;
	unitRateField.setLayoutData(gridData);

    	quantityLabel = new Label(this, SWT.NONE);
	quantityLabel.setText(Messages.getString("InventoryOutcomeItemEditForm.quantityLabel.text")); //$NON-NLS-1$

    	quantityField = new XCurrencyField(this, SWT.BORDER); 
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	quantityField.setLayoutData(gridData);
    	
   	

    	currencyPriceLabel = new Label(this, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 40;
    	currencyPriceLabel.setLayoutData(gridData);
	currencyPriceLabel.setText(Messages.getString("InventoryOutcomeItemEditForm.currencyPriceLabel.text")); //$NON-NLS-1$

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
	currencyAmountLabel.setText(Messages.getString("InventoryOutcomeItemEditForm.currencyAmountLabel.text")); //$NON-NLS-1$

	currencyAmountField = new XCurrencyField(this, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyAmountField.setLayoutData(gridData);
    	
    	label = new Label(this, SWT.HORIZONTAL | SWT.SEPARATOR);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
   	
	taxLabel = new Label(this, SWT.NONE);
	taxLabel.setText(Messages.getString("InventoryOutcomeItemEditForm.taxLabel.text")); //$NON-NLS-1$

	taxField = new XTaxCombo(this, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	gridData.widthHint = 100;
	taxField.setLayoutData(gridData);
	
    	
	currencyTaxAmountLabel = new Label(this, SWT.NONE);
	gridData = new GridData();
	gridData.horizontalIndent = 40;
	currencyTaxAmountLabel.setLayoutData(gridData);
	currencyTaxAmountLabel.setText(Messages.getString("InventoryOutcomeItemEditForm.currencyTaxAmountLabel.text")); //$NON-NLS-1$

	currencyTaxAmountField = new XCurrencyField(this, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyTaxAmountField.setLayoutData(gridData);
    	
    	this.setSize(new Point(470, 108)); 
    	
    	// ITEM INIT
    	initGoodsField(goodsField);
    	initUnitField(unitField);
    	initUnitRateField(unitRateField);
    	initTaxField(taxField);
    	initQuantityField(quantityField);
    	initCurrencyPriceField(currencyPriceField);
    	initCurrencyAmountField(currencyAmountField);
    	initCurrencyTaxAmountField(currencyTaxAmountField);
    	
    	initNoEditableField(unitRateField);
    }
    
    protected void bindControls() {
	
	//addMapControl(goodsField, "product", goodsLabel, REQUIRED);
	
	bindControl(goodsField, "product");
	bindControl(productFeatureField, "productFeatureName");
	
	bindControl(productInstanceField, "productInstance");
	
	bindControl(unitField, "unit", unitLabel, REQUIRED);
	bindControl(unitRateField, "unitRate");
	bindControl(quantityField, "quantity");
	bindControl(currencyPriceField, "enterCurrencyPrice");
	bindControl(currencyAmountField, "enterCurrencyAmount");
	bindControl(taxField, "taxId");
	bindControl(currencyTaxAmountField, "currencyTaxAmount");
	
    }    
    
    public void beforeUpdateForm() throws ApplicationException {
	super.beforeUpdateForm();
	if (productInstanceField != null) {
	    initProductInstanceByProductId(getProductId());
	}
    }

    protected void onGoodsFieldAction() {
	super.onGoodsFieldAction();
	Product product = (Product) goodsField.getValue();
	if (!isEditableGoods() && product == null) {
	    productInstanceField.setDataList(null);
	    productInstanceField.setValue(null);
	    return;
	}
	Integer productId = product == null ? null : product.getId();
	initProductInstanceByProductId(productId);
    }
  
    protected void initProductInstanceByProductId(Integer productId) {
	List dataList = null;
	if (productId != null) {
	    try {
		ProductService service = (ProductService) getService(ProductService.class);
		dataList = service.findInstanceByProductId(productId);
	    } catch (Exception ex) {
		ex.printStackTrace();
	    }
	}
	productInstanceField.setDataList(dataList);
    }

}  //  @jve:decl-index=0:visual-constraint="25,19"
