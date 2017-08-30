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
 * Created on 02.03.2008
 *
 */

package org.plazmaforge.bsolution.product.client.swt.forms;


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
 * $Id: ProductInstanceEditForm.java,v 1.2 2010/04/28 06:31:03 ohapon Exp $
 */

public class ProductInstanceEditForm extends AbstractEditForm {

    private Label serialNumberLabel;
    private Label nameLabel;
    
    
    private XTextField serialNumberField; 
    private XTextField nameField;
 
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public ProductInstanceEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	setDataSourceSupport(false); // ITEM FORM
	
	setTitle("Serias");
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	
	gridLayout.numColumns = 2;
	setLayout(gridLayout);

 	serialNumberLabel = new Label(this, SWT.NONE);
	serialNumberLabel.setText(Messages.getString("ProductInstanceEditForm.serialNumberLabel.text")); //$NON-NLS-1$
    	
    	serialNumberField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 200;
    	serialNumberField.setLayoutData(gridData);
  

   	
    	nameLabel = new Label(this, SWT.NONE);
	nameLabel.setLayoutData(new GridData());
    	nameLabel.setText(Messages.getString("ProductInstanceEditForm.nameLabel.text")); //$NON-NLS-1$

    	nameField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	nameField.setLayoutData(gridData);
    	nameField.setTextLimit(30);
    	
    	this.setSize(new Point(470, 108));
    }
    
    protected void bindControls() {
	bindControl(serialNumberField, "serialNumber", serialNumberLabel, REQUIRED);
	bindControl(nameField, "name");
    }

}
