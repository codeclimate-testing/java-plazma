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

package org.plazmaforge.bsolution.bank.client.swt.forms;


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
 * $Id: PaymentMissingEditForm.java,v 1.2 2010/04/28 06:31:08 ohapon Exp $
 */

public class PaymentMissingEditForm extends AbstractEditForm {
    
    private Label nameLabel;
    
    private XTextField nameField;

    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public PaymentMissingEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	setTitle(Messages.getString("PaymentMissingEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	gridLayout.numColumns = 2;
	setLayout(gridLayout);
    	
    	
       	nameLabel = new Label(this, SWT.NONE);
	nameLabel.setText(Messages.getString("PaymentMissingEditForm.nameLabel.text")); //$NON-NLS-1$

    	nameField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 350;
    	nameField.setLayoutData(gridData);
    	nameField.setTextLimit(50);
    	
    	this.setSize(new Point(470, 108));
    }
    
    protected void bindControls() {
	bindControl(nameField, "name", nameLabel, REQUIRED);
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"

