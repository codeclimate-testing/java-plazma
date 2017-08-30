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
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.bsolution.contact.common.beans.LocalityType;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.models.DataFilter;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;

/** 
 * @author Oleh Hapon
 * $Id: LocalityEditForm.java,v 1.2 2010/04/28 06:31:05 ohapon Exp $
 */
public class LocalityEditForm extends AbstractEditForm {

    private Label countryLabel;
    
    private Label regionLabel;
    
    private Label nameLabel;
    
    
    private XComboEdit countryField;
    
    private XComboEdit regionField;
    
    private XTextField nameField;

    private XComboEdit localityTypeField;
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public LocalityEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {

	setTitle(Messages.getString("LocalityEditForm.title")); //$NON-NLS-1$
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	
	gridLayout.numColumns = 3;
	setLayout(gridLayout);
    	
    	
    	countryLabel = new Label(this, SWT.NONE);
    	countryLabel.setText(Messages.getString("LocalityEditForm.countryLabel.text")); //$NON-NLS-1$

    	countryField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON | PWT.EDIT_BUTTON);
    	countryField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
    	
    	regionLabel = new Label(this, SWT.NONE);
    	regionLabel.setText(Messages.getString("LocalityEditForm.regionLabel.text")); //$NON-NLS-1$
	
    	regionField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON | PWT.EDIT_BUTTON | PWT.DELETE_BUTTON);
    	regionField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
    	
    	
    	nameLabel = new Label(this, SWT.NONE);
    	nameLabel.setText(Messages.getString("LocalityEditForm.nameLabel.text")); //$NON-NLS-1$
    	
    	localityTypeField = new XComboEdit(this, SWT.BORDER);
    	localityTypeField.setLayoutData(new GridData());
    	
    	// Locality type list without city type
    	localityTypeField.addDataFilter(new DataFilter( ){
    	    public boolean isFilter(Object data) {
    		if (data instanceof  LocalityType) {
    		    return !((LocalityType) data).isCity();
    		}
    		return true;
    	    }
    	});
    	
    	GridData gridData;

    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 300;
    
    	nameField = new XTextField(this, SWT.BORDER);
    	nameField.setLayoutData(gridData);
    	nameField.setTextLimit(50);
    	
    	
    	this.setSize(new Point(574, 298));
    }
    
    protected void bindControls() {
	bindControl(countryField, "country", countryLabel, REQUIRED);
	bindControl(regionField, "region");
	bindControl(localityTypeField, "localityType", Messages.getString("LocalityEditForm.localityTypeLabel"), REQUIRED); //$NON-NLS-2$
	bindControl(nameField, "name", nameLabel, REQUIRED);
    }


}  //  @jve:decl-index=0:visual-constraint="10,10"

