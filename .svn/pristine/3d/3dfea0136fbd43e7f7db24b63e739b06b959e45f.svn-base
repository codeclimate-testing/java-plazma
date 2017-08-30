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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;

/**
 * 
 * @author Oleh Hapon
 * $Id: CarServOrderPaintTypeEditForm.java,v 1.2 2010/04/28 06:23:01 ohapon Exp $
 */
public class CarServOrderPaintTypeEditForm extends AbstractEditForm {

    private Label carPaintTypeLabel;
 
    private XComboEdit carPaintTypeField;
    
    
    public CarServOrderPaintTypeEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();
	setDataSourceSupport(false); // ITEM FORM
    }
    
    
    private void initialize() {

	GridData gridData;
	GridLayout gridLayout = new GridLayout();
	gridLayout.numColumns = 2;
	setLayout(gridLayout);	
	
    	carPaintTypeLabel = new Label(this, SWT.NONE);
	carPaintTypeLabel.setText(Messages.getString("CarServOrderPaintTypeEditForm.carPaintTypeLabel.text")); //$NON-NLS-1$

    	carPaintTypeField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
	gridData.widthHint = 300;
    	carPaintTypeField.setLayoutData(gridData);

    	////
    	
    }
    
    protected void bindControls() {
	bindControl(carPaintTypeField, "carPaintType");
	
    }    
}
