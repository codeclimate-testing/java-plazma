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
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XPercentField;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;

/** 
 * @author Oleh Hapon
 * $Id: TaxEditForm.java,v 1.3 2010/04/28 06:31:00 ohapon Exp $
 */

public class TaxEditForm extends AbstractEditForm {

    private Label codeLabel;

    private Label nameLabel; 
    
    
    private XTextField codeField;
    
    private XTextField nameField;
    
    private XPercentField percentField;
    
    private XCurrencyField amountField;

    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public TaxEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	setTitle(Messages.getString("TaxEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	gridLayout.numColumns = 4;
	setLayout(gridLayout);
    	
    	
    	codeLabel = new Label(this, SWT.NONE);
	codeLabel.setText(Messages.getString("TaxEditForm.codeLabel.text")); //$NON-NLS-1$

    	codeField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1);
    	gridData.widthHint = 100;
    	codeField.setLayoutData(gridData);
    	codeField.setTextLimit(10);

    	nameLabel = new Label(this, SWT.NONE);
	nameLabel.setText(Messages.getString("TaxEditForm.nameLabel.text")); //$NON-NLS-1$

    	nameField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	nameField.setLayoutData(gridData);
    	nameField.setTextLimit(50);
    	
  	Label percentLabel = new Label(this, SWT.NONE);
    	percentLabel.setText(Messages.getString("TaxEditForm.taxPercentLabel.text")); //$NON-NLS-1$

    	percentField = new XPercentField(this, SWT.BORDER);    	
    	percentField.setLayoutData(new GridData(100, SWT.DEFAULT));
    	
 	Label amountLabel = new Label(this, SWT.NONE);
    	amountLabel.setText(Messages.getString("TaxEditForm.amountLabel.text")); //$NON-NLS-1$

    	amountField = new XCurrencyField(this, SWT.BORDER);    
    	amountField.setLayoutData(new GridData(100, SWT.DEFAULT));
    	
    	this.setSize(new Point(470, 108));
    }
    
    protected void bindControls() {
	bindControl(codeField, "code", codeLabel, REQUIRED);
	bindControl(nameField, "name", nameLabel, REQUIRED);
	bindControl(percentField, "taxPercent");
	bindControl(amountField, "amount");	
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"

