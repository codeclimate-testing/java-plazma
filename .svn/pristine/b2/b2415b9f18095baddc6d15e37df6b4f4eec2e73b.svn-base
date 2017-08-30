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
import org.plazmaforge.bsolution.carservice.common.beans.CarPaintType;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.models.UpdateEvent;
import org.plazmaforge.framework.client.models.UpdateListener;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;

/**
 * 
 * @author ohapon
 *
 */
public class CarInsurerPaintTypePriceEditForm extends AbstractEditForm {

    private Label carPaintTypeLabel;
    
    private Label carPaintMarkLabel;
    
    private Label priceLabel;
    
    
    
    private XComboEdit carPaintTypeField;
    
    private XComboEdit carPaintMarkField;
    
    private XCurrencyField priceField;
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public CarInsurerPaintTypePriceEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {

	setDataSourceSupport(false);
	
	setTitle(Messages.getString("CarInsurerPaintTypePriceEditForm.title")); //$NON-NLS-1$
	
	GridLayout gridLayout;
	GridData gridData;

    	gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	    	
    	gridLayout.numColumns = 2;
    	
    	setLayout(gridLayout);

    	carPaintTypeLabel = new Label(this, SWT.NONE);
    	carPaintTypeLabel.setText(Messages.getString("CarInsurerPaintTypePriceEditForm.carPaintTypeLabel.text")); //$NON-NLS-1$

    	carPaintTypeField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 300;
    	carPaintTypeField.setLayoutData(gridData);

    	////
    	carPaintMarkLabel = new Label(this, SWT.NONE);
    	carPaintMarkLabel.setText(Messages.getString("CarInsurerPaintTypePriceEditForm.carPaintMarkLabel.text")); //$NON-NLS-1$

    	carPaintMarkField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 300;
    	carPaintMarkField.setLayoutData(gridData);
    	
    	////
    	priceLabel = new Label(this, SWT.NONE);
    	priceLabel.setText(Messages.getString("CarInsurerPaintTypePriceEditForm.priceLabel.text")); //$NON-NLS-1$

    	priceField = new XCurrencyField(this, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	priceField.setLayoutData(gridData);
    	priceField.setTextLimit(100);
    
    	this.setSize(new Point(574, 298));
    	
    	
    	
    }
    
   
    
    protected void bindControls() {
	bindControl(carPaintTypeField, "carPaintType", carPaintTypeLabel, REQUIRED);
	bindControl(carPaintMarkField, "carPaintMark", carPaintMarkLabel, REQUIRED);
	bindControl(priceField, "price");
    }
    
   
}
