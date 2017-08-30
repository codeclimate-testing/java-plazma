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
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;

/** 
 * @author Oleh Hapon
 * $Id: ApartmentTypeEditForm.java,v 1.1 2010/05/17 12:57:51 ohapon Exp $
 */
public class ApartmentTypeEditForm extends AbstractEditForm {

    private Label nameLabel;

    private Label fullNameLabel;
    
    
    private XTextField nameField;
    
    private XTextField fullNameField;

 
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public ApartmentTypeEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	setTitle(Messages.getString("ApartmentTypeEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	gridLayout.numColumns = 2;
	setLayout(gridLayout);
    	
    	
    	nameLabel = new Label(this, SWT.NONE);
	nameLabel.setText(Messages.getString("ApartmentTypeEditForm.nameLabel.text")); //$NON-NLS-1$

    	nameField = new XTextField(this, SWT.BORDER);
    	nameField.setLayoutData(new GridData(100, SWT.DEFAULT));
    	nameField.setTextLimit(10);

    	fullNameLabel = new Label(this, SWT.NONE);
	fullNameLabel.setText(Messages.getString("ApartmentTypeEditForm.fullNameLabel.text")); //$NON-NLS-1$

    	fullNameField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 350;
    	fullNameField.setLayoutData(gridData);
    	fullNameField.setTextLimit(30);
    	
    	this.setSize(new Point(470, 108));
    }
    
    protected void bindControls() {
	bindControl(nameField, "name", nameLabel, REQUIRED);
	bindControl(fullNameField, "fullName");
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"
