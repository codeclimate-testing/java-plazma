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
 * Created on 12.06.2007
 *
 */

package org.plazmaforge.bsolution.partner.client.swt.forms;



import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.bsolution.bank.BankEnvironment;
import org.plazmaforge.bsolution.bank.common.beans.Bank;
import org.plazmaforge.bsolution.bank.common.beans.BankAccount;
import org.plazmaforge.bsolution.bank.common.services.BankAccountService;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: PartnerBankAccountEditForm.java,v 1.4 2010/12/05 07:57:19 ohapon Exp $
 */

public class PartnerBankAccountEditForm extends AbstractPartnerableEditForm {
    
    
    private Label bankLabel;
    private Label nameLabel;
    private Label accountNoLabel;

    private XTextField nameField;
    private XComboEdit bankField;
    private XTextField accountNoField;
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public PartnerBankAccountEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	//setDataSourceSupport(false);
	
	setEntityClass(BankAccount.class);
	setEntityServiceClass(BankAccountService.class);
	        
	setTitle(Messages.getString("PartnerBankAccountEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	
	gridLayout.numColumns = 2;
	setLayout(gridLayout);
    	
    	
	bankLabel = new Label(this, SWT.NONE);
	bankLabel.setText(Messages.getString("PartnerBankAccountEditForm.bankLabel.text")); //$NON-NLS-1$

    	bankField = new XComboEdit(this, SWT.BORDER, PWT.VIEW_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 350;
    	bankField.setLayoutData(gridData);

    	nameLabel = new Label(this, SWT.NONE);
	nameLabel.setText(Messages.getString("PartnerBankAccountEditForm.nameLabel.text")); //$NON-NLS-1$

    	nameField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 350;
    	nameField.setLayoutData(gridData);
    	nameField.setTextLimit(30);
    	
    	accountNoLabel = new Label(this, SWT.NONE);
	accountNoLabel.setText(Messages.getString("PartnerBankAccountEditForm.accountNoLabel.text")); //$NON-NLS-1$

    	accountNoField = new XTextField(this, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 350;
    	accountNoField.setLayoutData(gridData);
    	accountNoField.setTextLimit(BankEnvironment.BANK_ACCOUNT_SIZE);
    	
    	this.setSize(new Point(470, 108));
    	
    	bankField.setAssociationValueClass(Bank.class);
    }
    
    protected void bindControls() {
	bindControl(bankField, "bank", bankLabel, REQUIRED);
	bindControl(nameField, "name", nameLabel, REQUIRED);
	bindControl(accountNoField, "accountNo", accountNoLabel, REQUIRED);
	
    }
    
    protected BankAccount getBankAccount() {
	return (BankAccount) getEntity();
    }
    
    protected void initData() throws ApplicationException {
	super.initData();
	getBankAccount().setPartner(getPartner());
	getBankAccount().setName(Messages.getString("PartnerBankAccountEditForm.primaryAccount"));
	
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"

