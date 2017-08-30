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
 * Created on 11.07.2007
 *
 */

package org.plazmaforge.bsolution.personality.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.controls.XTextField;

/** 
 * @author Oleh Hapon
 * $Id: PersonFamilyEditForm.java,v 1.2 2010/04/28 06:31:02 ohapon Exp $
 */

public class PersonFamilyEditForm extends AbstractPersonableEdit {
    
    private Label nameLabel;
    private Label familiarityLabel;
    private Label birthDateLabel;
  
    
    private XTextField nameField;
    private XComboEdit familiarityField;
    private XDateCombo birthDateField;
  
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public PersonFamilyEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	setTitle(Messages.getString("PersonFamilyEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	
	gridLayout.numColumns = 2;
	setLayout(gridLayout);
    	
    	
       	nameLabel = new Label(this, SWT.NONE);
	nameLabel.setText(Messages.getString("PersonFamilyEditForm.nameLabel.text")); //$NON-NLS-1$

    	nameField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 350;
    	nameField.setLayoutData(gridData);
    	nameField.setTextLimit(50);
    	
    	
	familiarityLabel = new Label(this, SWT.NONE);
	familiarityLabel.setText(Messages.getString("PersonFamilyEditForm.familiarityLabel.text")); //$NON-NLS-1$

    	familiarityField = new XComboEdit(this, SWT.BORDER, PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 350;
    	familiarityField.setLayoutData(gridData);
    	
    	
	birthDateLabel = new Label(this, SWT.NONE);
	birthDateLabel.setText(Messages.getString("PersonFamilyEditForm.birthDateLabel.text")); //$NON-NLS-1$

    	birthDateField = new XDateCombo(this, SWT.BORDER);
    	gridData = new GridData(100, SWT.DEFAULT);
    	birthDateField.setLayoutData(gridData);
    	
    	
    	this.setSize(new Point(470, 108));
    }
    
    protected void bindControls() {
	bindControl(nameField, "name", nameLabel, REQUIRED);
	bindControl(familiarityField, "familiarity", familiarityLabel, REQUIRED);
	bindControl(birthDateField, "birthDate");
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"

