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
import org.plazmaforge.bsolution.partner.common.beans.Partner;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;

public class CarMtrlFindReportPriceEditForm extends AbstractEditForm {

    private Label supplierLabel;
    private Label currencyPriceLabel;
    private Label deliveryDateLabel;
     
 
    private XComboEdit supplierField;
    private XCurrencyField currencyPriceField;     
    private XDateCombo deliveryDateField;
     

    public CarMtrlFindReportPriceEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    private void initialize() {

	setDataSourceSupport(false); // ITEM FORM
	
	
	Label label;
	

	GridData gridData;
	GridLayout gridLayout = new GridLayout();
	gridLayout.numColumns = 4;
	setLayout(gridLayout);	
	
    	supplierLabel = new Label(this, SWT.NONE);
	supplierLabel.setText(Messages.getString("CarMtrlFindReportPriceEditForm.supplierLabel.text")); //$NON-NLS-1$

    	supplierField = new XComboEdit(this, SWT.BORDER, PWT.VIEW_BUTTON);
	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1);
	gridData.widthHint = 300;
    	supplierField.setLayoutData(gridData);

    	label = new Label(this, SWT.HORIZONTAL | SWT.SEPARATOR);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
   	
    	currencyPriceLabel = new Label(this, SWT.NONE);
    	gridData = new GridData();
    	//gridData.horizontalIndent = 40;
    	currencyPriceLabel.setLayoutData(gridData);
	currencyPriceLabel.setText(Messages.getString("CarMtrlFindReportPriceEditForm.currencyPriceLabel.text")); //$NON-NLS-1$

    	currencyPriceField = new XCurrencyField(this, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	gridData.widthHint = 100;
	currencyPriceField.setLayoutData(gridData);
	
	
 	deliveryDateLabel = new Label(this, SWT.NONE);
 	gridData = new GridData();
 	gridData.horizontalIndent = 40;
 	deliveryDateLabel.setLayoutData(gridData);
	deliveryDateLabel.setText(Messages.getString("CarMtrlFindReportPriceEditForm.deliveryDateLabel.text")); //$NON-NLS-1$

	deliveryDateField = new XDateCombo(this, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	deliveryDateField.setLayoutData(gridData);
    	
    	
	    	
    	this.setSize(new Point(470, 108));
    	
    	supplierField.setAssociationValueClass(Partner.class);
    	
    }
    
    protected void bindControls() {
	bindControl(supplierField, "supplier", supplierLabel, REQUIRED);
	bindControl(currencyPriceField, "price"); // addMapControl(currencyPriceField, "currencyPrice");
	bindControl(deliveryDateField, "deliveryDate");
    }    
    
}
