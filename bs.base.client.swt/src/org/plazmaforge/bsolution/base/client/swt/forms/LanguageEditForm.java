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
 * $Id: LanguageEditForm.java,v 1.3 2010/05/17 11:17:43 ohapon Exp $
 */

public class LanguageEditForm extends AbstractEditForm {

    private Label codeLabel;

    private Label code3Label;
    
    private Label numericCodeLabel;
    
    private Label nameLabel;
    
    
    private XTextField codeField;

    private XTextField code3Field;
    
    private XTextField numericCodeField;
    
    private XTextField nameField;

 
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public LanguageEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	setTitle(Messages.getString("LanguageEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	gridLayout.numColumns = 2;
	setLayout(gridLayout);
    	
    	
    	codeLabel = new Label(this, SWT.NONE);
	codeLabel.setText(Messages.getString("LanguageEditForm.codeLabel.text")); //$NON-NLS-1$

    	codeField = new XTextField(this, SWT.BORDER);
    	codeField.setLayoutData(new GridData(100, SWT.DEFAULT));
    	codeField.setTextLimit(2);

    	
    	code3Label = new Label(this, SWT.NONE);
	code3Label.setText(Messages.getString("LanguageEditForm.code3Label.text")); //$NON-NLS-1$

    	code3Field = new XTextField(this, SWT.BORDER);
    	code3Field.setLayoutData(new GridData(100, SWT.DEFAULT));
    	code3Field.setTextLimit(3);


    	numericCodeLabel = new Label(this, SWT.NONE);
    	numericCodeLabel.setText(Messages.getString("LanguageEditForm.numericCodeLabel.text")); //$NON-NLS-1$

    	numericCodeField = new XTextField(this, SWT.BORDER);
    	numericCodeField.setLayoutData(new GridData(100, SWT.DEFAULT));
    	numericCodeField.setTextLimit(3);

    	
    	
    	nameLabel = new Label(this, SWT.NONE);
	nameLabel.setText(Messages.getString("LanguageEditForm.nameLabel.text")); //$NON-NLS-1$

    	nameField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 350;
    	nameField.setLayoutData(gridData);
    	nameField.setTextLimit(50);
    	
    	this.setSize(new Point(470, 108));
    }
    
    protected void bindControls() {
	bindControl(codeField, "code", codeLabel, REQUIRED);
	bindControl(code3Field, "code3");
	bindControl(numericCodeField, "numericCode");	
	bindControl(nameField, "name", nameLabel, REQUIRED);
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"
