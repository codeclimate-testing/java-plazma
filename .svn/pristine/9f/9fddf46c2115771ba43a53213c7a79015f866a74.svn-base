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
package org.plazmaforge.bsolution.contact.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.core.LocaleManager;

/** 
 * @author Oleh Hapon
 * $Id: AddressPanel.java,v 1.3 2010/12/05 07:57:21 ohapon Exp $
 */
public class AddressPanel extends Composite {


    private Label zipCodeLabel;
    
    private Label cityLabel;
    
    private Label localityLabel;    

    private Label addressStringLabel;
    
    
    private XTextField zipCodeField;
    
    private XComboEdit cityField;
    
    private XComboEdit localityField;

    private XTextField addressStringField;
    
    public AddressPanel(Composite parent, int style) {
	
	super(parent, style);
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
    	gridLayout.numColumns = 2;
    	setLayout(gridLayout);
    	
    	
    	
    	zipCodeLabel = new Label(this, SWT.NONE);
	zipCodeLabel.setText(Messages.getString("AddressEditForm.zipCodeLabel.text")); //$NON-NLS-1$
	zipCodeLabel.setLayoutData(new GridData());
	
    	zipCodeField = new XTextField(this, SWT.BORDER);
    	zipCodeField.setLayoutData(new GridData(150, SWT.DEFAULT));
    	zipCodeField.setTextLimit(10);

    	cityLabel = new Label(this, SWT.NONE);
	cityLabel.setText(Messages.getString("AddressEditForm.cityLabel.text")); //$NON-NLS-1$
	cityLabel.setLayoutData(new GridData());
    	
    	cityField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	cityField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	if (isUseLocality()) {
    	    localityLabel = new Label(this, SWT.NONE);
	    localityLabel.setText(Messages.getString("AddressEditForm.localityLabel.text")); //$NON-NLS-1$
	    localityLabel.setLayoutData(new GridData());
	    
    	    localityField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	    localityField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	}
    	
    	addressStringLabel = new Label(this, SWT.NONE);
	addressStringLabel.setText(Messages.getString("AddressEditForm.addressString.text")); //$NON-NLS-1$
	addressStringLabel.setLayoutData(new GridData());

    	GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.heightHint = 50;
    	gridData.widthHint = 300;
    
    	addressStringField = new XTextField(this, SWT.BORDER | SWT.MULTI);
    	addressStringField.setLayoutData(gridData);
    	addressStringField.setTextLimit(100);
    	
    	
    	
    }

    private boolean isUseLocality() {
	return LocaleManager.isUseLocalityInAddress();
    }

    public Control[] getFixedLabels() {
	return new Control[] {zipCodeLabel, cityLabel, localityLabel, addressStringLabel};
    }
}