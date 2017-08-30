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

package org.plazmaforge.bsolution.document.client.swt.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.SWTUtils;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;

public class DocumentStatusEditForm extends AbstractEditForm {

    private Label documentTypeLabel;
    
    private Label codeLabel;
    
    private Label nameLabel;
    
    
    private XComboEdit documentTypeField;
    
    private XTextField codeField;
    
    private XTextField nameField;
    
    
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public DocumentStatusEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	
	setTitle(Messages.getString("DocumentStatusEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	
	gridLayout.numColumns = 2;
	setLayout(gridLayout);
    	
    	
    	documentTypeLabel = new Label(this, SWT.NONE);
    	documentTypeLabel.setText(Messages.getString("DocumentStatusEditForm.documentLabel.text")); //$NON-NLS-1$
    	documentTypeLabel.setLayoutData(new GridData());

    	documentTypeField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	documentTypeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    	codeLabel = new Label(this, SWT.NONE);
    	codeLabel.setText(Messages.getString("DocumentStatusEditForm.codeLabel.text")); //$NON-NLS-1$
    	codeLabel.setLayoutData(new GridData());

    	codeField = new XTextField(this, SWT.BORDER);
    	codeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    	codeField.setTextLimit(20);
    
    	nameLabel = new Label(this, SWT.NONE);
    	nameLabel.setText(Messages.getString("DocumentStatusEditForm.nameLabel.text")); //$NON-NLS-1$
    	nameLabel.setLayoutData(new GridData());

    	nameField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 300;
    	nameField.setLayoutData(gridData);
    	nameField.setTextLimit(20);

    }
    
    public void updateForm() throws ApplicationException {
	super.updateForm();
	SWTUtils.setVisible(documentTypeLabel, !isChildFormMode());
    	SWTUtils.setVisible(documentTypeField, !isChildFormMode());
    	layout();
    }
    
    protected void bindControls() {
	if (!isChildFormMode()) {
	    bindControl(documentTypeField, "documentType", documentTypeLabel, REQUIRED);
	}
	bindControl(codeField, "code", codeLabel, REQUIRED);
	bindControl(nameField, "name", nameLabel, REQUIRED);
	
    }
    
}
