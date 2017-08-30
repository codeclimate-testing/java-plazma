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
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.bsolution.finance.common.beans.LedgerAccount;
import org.plazmaforge.bsolution.finance.common.beans.TemplateEntryItem;
import org.plazmaforge.bsolution.finance.common.services.LedgerAccountService;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.models.UpdateEvent;
import org.plazmaforge.framework.client.models.UpdateListener;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;


/** 
 * @author Oleh Hapon
 * $Id: TemplateEntryItemEditForm.java,v 1.4 2010/12/05 07:57:18 ohapon Exp $
 */

public class TemplateEntryItemEditForm extends AbstractEditForm {

    
    private Label debitAccountExpLabel;

    private Label debitObjectExpLabel;

    private Label creditAccountExpLabel;

    private Label creditObjectExpLabel;

    private Label amountExpLabel;
    
    private Label contentLabel;
    
    private Label entryItemClassLabel;
    
    
    
    private XTextField debitAccountExpField;
    
    private XComboEdit debitAccountField;
    
    private XTextField debitObjectExpField;
    
    
    
    
    private XTextField creditAccountExpField;
    
    private XTextField creditObjectExpField;
    
    private XComboEdit creditAccountField;
    
    
    

    private XTextField amountExpField;

    private XTextField contentField;
    
    private XTextField entryItemClassField;
 
    
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public TemplateEntryItemEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	setDataSourceSupport(false);
	
	setTitle(Messages.getString("TemplateEntryItemEditForm.title")); //$NON-NLS-1$
	
	GridLayout gridLayout = new GridLayout();
	
	gridLayout.numColumns = 3;
	setLayout(gridLayout);
    	
	GridData gridData = null;
	int FIELD_WIDTH  = 400;
    	
    	debitAccountExpLabel = new Label(this, SWT.NONE);
	debitAccountExpLabel.setText(Messages.getString("TemplateEntryItemEditForm.debitAccountExpLabel.text")); //$NON-NLS-1$

    	debitAccountExpField = new XTextField(this, SWT.BORDER);
    	debitAccountExpField.setLayoutData(new GridData(70, SWT.DEFAULT));
    	debitAccountExpField.setTextLimit(50);
    	
    	debitAccountField = new XComboEdit(this, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
    	debitAccountField.setLayoutData(gridData);
    	
    	

    	debitObjectExpLabel = new Label(this, SWT.NONE);
	debitObjectExpLabel.setText(Messages.getString("TemplateEntryItemEditForm.debitObjectExpLabel.text")); //$NON-NLS-1$

    	debitObjectExpField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
    	gridData.widthHint = FIELD_WIDTH;
    	debitObjectExpField.setLayoutData(gridData);
    	debitObjectExpField.setTextLimit(50);

    	
    	creditAccountExpLabel = new Label(this, SWT.NONE);
	creditAccountExpLabel.setText(Messages.getString("TemplateEntryItemEditForm.creditAccountExpLabel.text")); //$NON-NLS-1$

    	creditAccountExpField = new XTextField(this, SWT.BORDER);
    	creditAccountExpField.setLayoutData(new GridData(70, SWT.DEFAULT));
    	creditAccountExpField.setTextLimit(50);

    	creditAccountField = new XComboEdit(this, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
    	creditAccountField.setLayoutData(gridData);
    	
    	
    	creditObjectExpLabel = new Label(this, SWT.NONE);
	creditObjectExpLabel.setText(Messages.getString("TemplateEntryItemEditForm.creditObjectExpLabel.text")); //$NON-NLS-1$

    	creditObjectExpField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
    	gridData.widthHint = FIELD_WIDTH;
    	creditObjectExpField.setLayoutData(gridData);
    	creditObjectExpField.setTextLimit(50);
    	
    	
    	amountExpLabel = new Label(this, SWT.NONE);
	amountExpLabel.setText(Messages.getString("TemplateEntryItemEditForm.amountExpLabel.text")); //$NON-NLS-1$

    	amountExpField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
    	gridData.widthHint = FIELD_WIDTH;

    	amountExpField.setLayoutData(gridData);
    	amountExpField.setTextLimit(50);
    	
    	
 	contentLabel = new Label(this, SWT.NONE);
 	contentLabel.setText(Messages.getString("TemplateEntryItemEditForm.contentLabel.text")); //$NON-NLS-1$

 	contentField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
    	gridData.widthHint = FIELD_WIDTH;

 	contentField.setLayoutData(gridData);
 	contentField.setTextLimit(64);
    	

 	entryItemClassLabel = new Label(this, SWT.NONE);
 	entryItemClassLabel.setText(Messages.getString("TemplateEntryItemEditForm.entryItemClassLabel.text")); //$NON-NLS-1$

 	entryItemClassField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
    	gridData.widthHint = FIELD_WIDTH;
 	entryItemClassField.setLayoutData(gridData);
 	entryItemClassField.setTextLimit(50);

 	
 	initAccountField(debitAccountExpField, debitAccountField);
 	initAccountField(creditAccountExpField, creditAccountField);
 	
 	this.setSize(new Point(470, 108));
    }
    
    protected void initAccountField(final XTextField accountExpField, final XComboEdit accountField) {
	
	// INIT CODE FIELD
	accountExpField.addFocusListener(new FocusAdapter() {
	   public void focusLost(FocusEvent e) {
	      String code = accountExpField.getText();
	      accountField.setValue(getLedgerAccountByCode(code));
	  }
	});
	
	// INIT ACCOUNT FIELD
 	accountField.setEntityClass(LedgerAccount.class);
 	accountField.setListFormClass(LedgerAccountListForm.class);
 	accountField.addUpdateListener(new UpdateListener() {
  	   public void update(UpdateEvent evt) {
  	      LedgerAccount la = (LedgerAccount) accountField.getValue();
  	      accountExpField.setValue(la == null ? null : la.getCode());
  	   }
  	}); 	

    }
    
    protected void bindControls() {
	
	bindControl(debitAccountExpField, "debitLedgerAccountExpression", debitAccountExpLabel, REQUIRED);
	bindControl(debitAccountField, "debitLedgerAccount");
	bindControl(debitObjectExpField, "debitObjectExpression");
	
	bindControl(creditAccountExpField, "creditLedgerAccountExpression", creditAccountExpLabel, REQUIRED);
	bindControl(creditAccountField, "creditLedgerAccount");	
	bindControl(creditObjectExpField, "creditObjectExpression");
	
	bindControl(amountExpField, "amountExpression");
	
	bindControl(contentField, "content");
	bindControl(entryItemClassField, "entryItemClass");
    }

    public void doHelpAction() throws ApplicationException {
	openPropertiesDialog(TemplateEntryUtilities.getHelpElements());
    }
    
    
    /*
    public void updateForm() throws ApplicationException {
	super.updateForm();
	updateLedgerAccountByCode();
    }
    */
    
    public void updateData() throws ApplicationException {
	updateLedgerAccountByCode();
	super.updateData();
    }
    
    protected void updateLedgerAccountByCode() {
	if (getTemplateEntryItem() == null) {
	    debitAccountField.setValue(null);
	    creditAccountField.setValue(null);
	    return;
	}
	debitAccountField.setValue(getLedgerAccountByCode(getTemplateEntryItem().getDebitLedgerAccountExpression()));
	creditAccountField.setValue(getLedgerAccountByCode(getTemplateEntryItem().getCreditLedgerAccountExpression()));
    }
    
    
    protected TemplateEntryItem getTemplateEntryItem() {
	return (TemplateEntryItem) getEntity();
    }
    
    protected LedgerAccountService getLedgerAccountService() {
	return (LedgerAccountService) getService(LedgerAccountService.class);
    }
    
    protected LedgerAccount getLedgerAccountByCode(String code) {
	try {
	    return getLedgerAccountService().findByCode(code);
	} catch (ApplicationException ex) {
	    return null;
	}
	
    }
    
    
}  //  @jve:decl-index=0:visual-constraint="10,10"


