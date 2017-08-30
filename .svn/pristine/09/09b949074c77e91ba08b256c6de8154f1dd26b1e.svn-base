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
 * Created on 2  ‚≥ 2007
 *
 */

package org.plazmaforge.bsolution.finance.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.bsolution.finance.common.beans.LedgerAccount;
import org.plazmaforge.bsolution.finance.common.services.LedgerAccountService;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;


/** 
 * @author Oleh Hapon
 * $Id: LedgerAccountEditForm.java,v 1.3 2010/12/05 07:57:18 ohapon Exp $
 */

public class LedgerAccountEditForm extends AbstractEditForm {

    private Label codeLabel;

    private Label nameLabel;

    private Label ledgerAccountTypeLabel;

    private Label parentLabel;   
    
    
    private XTextField codeField;
    
    private XTextField nameField;
    
    private XComboEdit ledgerAccountTypeField;
    
    private XComboEdit parentField;

   
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public LedgerAccountEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	setTitle(Messages.getString("LedgerAccountEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	
	gridLayout.numColumns = 2;
	setLayout(gridLayout);
    	
    	
    	codeLabel = new Label(this, SWT.NONE);
	codeLabel.setText(Messages.getString("LedgerAccountEditForm.codeLabel.text")); //$NON-NLS-1$

    	codeField = new XTextField(this, SWT.BORDER);
    	codeField.setLayoutData(new GridData(100, SWT.DEFAULT));
    	codeField.setTextLimit(10);

    	nameLabel = new Label(this, SWT.NONE);
	nameLabel.setText(Messages.getString("LedgerAccountEditForm.nameLabel.text")); //$NON-NLS-1$

    	nameField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 350;
    	nameField.setLayoutData(gridData);
    	nameField.setTextLimit(100);
    	
    	ledgerAccountTypeLabel = new Label(this, SWT.NONE);
	ledgerAccountTypeLabel.setText(Messages.getString("LedgerAccountEditForm.ledgerAccountTypeLabel.text")); //$NON-NLS-1$

    	ledgerAccountTypeField = new XComboEdit(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 350;
    	ledgerAccountTypeField.setLayoutData(gridData);
    	

    	parentLabel = new Label(this, SWT.NONE);
	parentLabel.setText(Messages.getString("LedgerAccountEditForm.parentLabel.text")); //$NON-NLS-1$

    	parentField = new XComboEdit(this, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 350;
    	parentField.setLayoutData(gridData);
    	
    	parentField.setEntityClass(LedgerAccount.class);
    	parentField.setListFormClass(LedgerAccountListForm.class);
    	
    	this.setSize(new Point(470, 108));
    }
    
    protected void bindControls() {
	bindControl(codeField, "code", codeLabel, REQUIRED);
	bindControl(nameField, "name", nameLabel, REQUIRED);
	bindControl(ledgerAccountTypeField, "ledgerAccountType", ledgerAccountTypeLabel, REQUIRED);
    }
    
    public void updateForm() throws ApplicationException {
	Integer parentId = getLedgerAccount().getParentId();
	if (parentId != null) {
	    parentField.setValue(getLedgerAccountService().findById(parentId));
	}
	super.updateForm();
    }

    public void updateData() throws ApplicationException {
	LedgerAccount parent = (LedgerAccount) parentField.getValue();
	Integer parentId = parent == null ? null : parent.getId();
	getLedgerAccount().setParentId(parentId);
	super.updateData();
    }

    protected LedgerAccount getLedgerAccount() {
	return (LedgerAccount) getEntity();
    }
    
    protected LedgerAccountService getLedgerAccountService() {
	return (LedgerAccountService) getService(LedgerAccountService.class);
    }
}  //  @jve:decl-index=0:visual-constraint="10,10"


