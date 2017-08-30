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
import org.plazmaforge.framework.client.swt.controls.XNumberField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;

/**
 * 
 * @author Oleh Hapon
 * $Id: CarAssurerPriceEditForm.java,v 1.2 2010/04/28 06:23:01 ohapon Exp $
 */
public class CarAssurerPriceEditForm extends AbstractEditForm {

    
    private Label assurerLabel;
    private Label carAgeLabel;    
    private Label priceLabel;
    
    private XComboEdit assurerField;
    private XComboEdit carAgeField;    
    private XCurrencyField priceField;    
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public CarAssurerPriceEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	setTitle(Messages.getString("CarAssurerPriceEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	gridLayout.numColumns = 2;
	setLayout(gridLayout);
    	

    	assurerLabel = new Label(this, SWT.NONE);
    	assurerLabel.setText(Messages.getString("CarAssurerPriceEditForm.assurerLabel.text")); //$NON-NLS-1$

    	assurerField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	assurerField.setAssociationValueClass(Partner.class);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 250;
    	assurerField.setLayoutData(gridData);
    	

	carAgeLabel = new Label(this, SWT.NONE);
	carAgeLabel.setText(Messages.getString("CarAssurerPriceEditForm.carAgeLabel.text")); //$NON-NLS-1$

	carAgeField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
	carAgeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));


	priceLabel = new Label(this, SWT.NONE);
	priceLabel.setText(Messages.getString("CarAssurerPriceEditForm.priceLabel.text")); //$NON-NLS-1$

	priceField = new XCurrencyField(this, SWT.BORDER);
	priceField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
	
    	this.setSize(new Point(470, 108));
    }
    
    protected void bindControls() {
	bindControl(assurerField, "assurer", assurerLabel, REQUIRED);
	bindControl(carAgeField, "carAge", carAgeLabel, REQUIRED);	
	bindControl(priceField, "price");
    }
}
