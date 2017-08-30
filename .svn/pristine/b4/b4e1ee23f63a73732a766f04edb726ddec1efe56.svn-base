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
import org.plazmaforge.framework.client.swt.controls.XCheckBox;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;

/** 
 * @author Oleh Hapon
 * $Id: PersonLanguageEditForm.java,v 1.2 2010/04/28 06:31:02 ohapon Exp $
 */

public class PersonLanguageEditForm extends AbstractPersonableEdit {
    
    private Label languageLabel;
    private Label easyLabel;
  
    private XComboEdit languageField;
    private XCheckBox easyField;
  
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public PersonLanguageEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	setTitle(Messages.getString("PersonLanguageEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	
	gridLayout.numColumns = 2;
	setLayout(gridLayout);
    	
   
	languageLabel = new Label(this, SWT.NONE);
	languageLabel.setText(Messages.getString("PersonLanguageEditForm.languageLabel.text")); //$NON-NLS-1$

    	languageField = new XComboEdit(this, SWT.BORDER, PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 350;
    	languageField.setLayoutData(gridData);
    	
    	
	easyLabel = new Label(this, SWT.NONE);
	easyLabel.setText(Messages.getString("PersonLanguageEditForm.easyLabel.text")); //$NON-NLS-1$

    	easyField = new XCheckBox(this, SWT.NONE);
    	gridData = new GridData();
    	easyField.setLayoutData(gridData);
    	
    	
    	this.setSize(new Point(470, 108));
    }
    
    protected void bindControls() {
	bindControl(languageField, "language", languageLabel, REQUIRED);
	bindControl(easyField, "easy", Boolean.TYPE);
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"

