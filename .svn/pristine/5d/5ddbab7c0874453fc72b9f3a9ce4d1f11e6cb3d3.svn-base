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
 * Created on 10.04.2007
 *
 */

package org.plazmaforge.bsolution.product.client.swt.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;


/** 
 * @author Oleh Hapon
 * $Id: ProductPriceEditForm.java,v 1.4 2010/04/28 06:31:03 ohapon Exp $
 */

public class ProductPriceEditForm extends AbstractEditForm {

    private Label priceTypeLabel;
    private Label pricePercentLabel;
    private Label priceLabel;
    private Label currencyLabel;
    private Label unitLabel;
    
 
    private XComboEdit priceTypeField;
    private XCurrencyField pricePercentField;
    private XCurrencyField priceField;
    private XComboEdit currencyField;     
    private XComboEdit unitField;

    
    

    public ProductPriceEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    private void initialize() {

	setDataSourceSupport(false); // ITEM FORM

	setTitle(Messages.getString("ProductPriceEditForm.title")); //$NON-NLS-1$
	
	GridData gridData;
	GridLayout gridLayout = new GridLayout();
	gridLayout.numColumns = 2;
	setLayout(gridLayout);	
	
    	priceTypeLabel = new Label(this, SWT.NONE);
	priceTypeLabel.setText(Messages.getString("ProductPriceEditForm.priceTypeLabel.text")); //$NON-NLS-1$

    	priceTypeField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 200;
    	priceTypeField.setLayoutData(gridData);
    	
	pricePercentLabel = new Label(this, SWT.NONE);
	pricePercentLabel.setText(Messages.getString("ProductPriceEditForm.pricePercentLabel.text")); //$NON-NLS-1$

    	pricePercentField = new XCurrencyField(this, SWT.BORDER);
	pricePercentField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	priceLabel = new Label(this, SWT.NONE);
	priceLabel.setText(Messages.getString("ProductPriceEditForm.priceLabel.text")); //$NON-NLS-1$

    	priceField = new XCurrencyField(this, SWT.BORDER); 
    	priceField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	
   	

    	currencyLabel = new Label(this, SWT.NONE);
	currencyLabel.setText(Messages.getString("ProductPriceEditForm.currencyLabel.text")); //$NON-NLS-1$

    	currencyField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
	currencyField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	unitLabel = new Label(this, SWT.NONE);
    	unitLabel.setText(Messages.getString("ProductPriceEditForm.unitLabel.text")); //$NON-NLS-1$

    	unitField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	unitField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	
    	this.setSize(new Point(470, 108)); 
    }
    
    protected void bindControls() {
	bindControl(priceTypeField, "priceType", priceTypeLabel, REQUIRED);
	bindControl(pricePercentField, "pricePercent");
	bindControl(priceField, "price", priceLabel, REQUIRED);	
	bindControl(currencyField, "currency", currencyLabel, REQUIRED);	
	bindControl(unitField, "unit", unitLabel, REQUIRED);	
    }    

}  //  @jve:decl-index=0:visual-constraint="25,19"
