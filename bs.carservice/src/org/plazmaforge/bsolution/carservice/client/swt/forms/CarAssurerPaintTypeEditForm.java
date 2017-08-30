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
 * $Id: CarAssurerPaintTypeEditForm.java,v 1.2 2010/04/28 06:23:01 ohapon Exp $
 */
public class CarAssurerPaintTypeEditForm extends AbstractEditForm {

    
    private Label assurerLabel;
    private Label carPaintTypeLabel;
    private Label carClassLabel;    
    private Label volumeLabel;    
    private Label priceLabel;
    
    private XComboEdit assurerField;
    private XComboEdit carPaintTypeField;    
    private XComboEdit carClassField;    
    private XNumberField volumeField;
    private XCurrencyField priceField;    
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public CarAssurerPaintTypeEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	setTitle(Messages.getString("CarAssurerPaintTypeEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	gridLayout.numColumns = 2;
	setLayout(gridLayout);
    	

    	assurerLabel = new Label(this, SWT.NONE);
    	assurerLabel.setText(Messages.getString("CarAssurerPaintTypeEditForm.assurerLabel.text")); //$NON-NLS-1$

    	assurerField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	assurerField.setAssociationValueClass(Partner.class);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 250;
    	assurerField.setLayoutData(gridData);
    	

	carPaintTypeLabel = new Label(this, SWT.NONE);
	carPaintTypeLabel.setText(Messages.getString("CarAssurerPaintTypeEditForm.carPaintTypeLabel.text")); //$NON-NLS-1$

	carPaintTypeField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
	carPaintTypeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

	
	carClassLabel = new Label(this, SWT.NONE);
	carClassLabel.setText(Messages.getString("CarAssurerPaintTypeEditForm.carClassLabel.text")); //$NON-NLS-1$

	carClassField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
	carClassField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

	volumeLabel = new Label(this, SWT.NONE);
	volumeLabel.setText(Messages.getString("CarAssurerPaintTypeEditForm.volumeLabel.text")); //$NON-NLS-1$

	volumeField = new XNumberField(this, SWT.BORDER);
	volumeField.setPattern("-#,###,##0.000");
	
	volumeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

	priceLabel = new Label(this, SWT.NONE);
	priceLabel.setText(Messages.getString("CarAssurerPaintTypeEditForm.priceLabel.text")); //$NON-NLS-1$

	priceField = new XCurrencyField(this, SWT.BORDER);
	priceField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
	
    	this.setSize(new Point(470, 108));
    }
    
    protected void bindControls() {
	bindControl(assurerField, "assurer", assurerLabel, REQUIRED);
	bindControl(carPaintTypeField, "carPaintType", carPaintTypeLabel, REQUIRED);
	bindControl(carClassField, "carClass", carClassLabel, REQUIRED);	
	bindControl(volumeField, "volume");
	bindControl(priceField, "price");
    }

}
