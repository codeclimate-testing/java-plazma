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

package org.plazmaforge.bsolution.base.client.swt.forms;


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
 * $Id: CurrencyEditForm.java,v 1.4 2010/05/17 11:26:16 ohapon Exp $
 */

public class CurrencyEditForm extends AbstractEditForm {

    private Label codeLabel;
    
    private Label numericCodeLabel;
    
    private Label nameLabel; 
    
    
    private XTextField codeField;
    
    private XTextField numericCodeField;    
    
    private XTextField nameField;
    
    private XTextField fullNameField;

       
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public CurrencyEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
		
	setTitle(Messages.getString("CurrencyEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	gridLayout.numColumns = 4;
	setLayout(gridLayout);
    	
    	
    	codeLabel = new Label(this, SWT.NONE);
    	codeLabel.setText(Messages.getString("CurrencyEditForm.codeLabel.text")); //$NON-NLS-1$

    	codeField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 70;
    	codeField.setLayoutData(gridData);
    	codeField.setTextLimit(3);
    	
    	
    	numericCodeLabel = new Label(this, SWT.NONE);
    	numericCodeLabel.setText(Messages.getString("CurrencyEditForm.numericCodeLabel.text")); //$NON-NLS-1$

    	numericCodeField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
  	gridData.widthHint = 70;
    	numericCodeField.setLayoutData(gridData);
    	numericCodeField.setTextLimit(3);
    	
    	nameLabel = new Label(this, SWT.NONE);
	nameLabel.setText(Messages.getString("CurrencyEditForm.nameLabel.text")); //$NON-NLS-1$

    	nameField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
     	gridData.horizontalSpan = 3;
    	gridData.grabExcessHorizontalSpace = false;
    	nameField.setLayoutData(gridData);
    	nameField.setTextLimit(10);
    	
  	Label fullNameLabel = new Label(this, SWT.NONE);
  	fullNameLabel.setText(Messages.getString("CurrencyEditForm.fullNameLabel.text")); //$NON-NLS-1$

    	fullNameField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.horizontalSpan = 3;
     	gridData.grabExcessHorizontalSpace = false;
    	fullNameField.setLayoutData(gridData);    	
    	fullNameField.setTextLimit(20);
    	
    	this.setSize(new Point(395, 108));
    }
    
    protected void bindControls() {
	bindControl(codeField, "code", codeLabel, REQUIRED);
	bindControl(numericCodeField, "numericCode");
	bindControl(nameField, "name", nameLabel, REQUIRED);
	bindControl(fullNameField, "fullName");
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"
