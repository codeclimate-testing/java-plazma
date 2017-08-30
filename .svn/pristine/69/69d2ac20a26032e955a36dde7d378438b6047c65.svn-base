package org.plazmaforge.bsolution.bank.client.swt.forms;

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
import org.plazmaforge.bsolution.partner.common.beans.Partner;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;

public class BankAccountEditForm extends AbstractEditForm {

    private Label partnerLabel;
    private Label bankLabel;
    private Label nameLabel;
    private Label accountNoLabel;

    
    private XComboEdit partnerField;
    private XComboEdit bankField;
    private XTextField nameField;
    private XTextField accountNoField;
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public BankAccountEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	setEntityClass(BankAccount.class);
	setEntityServiceClass(BankAccountService.class);
	        
	setTitle(Messages.getString("BankAccountEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	
	gridLayout.numColumns = 2;
	setLayout(gridLayout);

	partnerLabel = new Label(this, SWT.NONE);
	partnerLabel.setText(Messages.getString("BankAccountEditForm.partnerLabel.text")); //$NON-NLS-1$

	partnerField = new XComboEdit(this, SWT.BORDER, PWT.VIEW_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 350;
    	partnerField.setLayoutData(gridData);

    	
	bankLabel = new Label(this, SWT.NONE);
	bankLabel.setText(Messages.getString("BankAccountEditForm.bankLabel.text")); //$NON-NLS-1$

    	bankField = new XComboEdit(this, SWT.BORDER, PWT.VIEW_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 350;
    	bankField.setLayoutData(gridData);

    	nameLabel = new Label(this, SWT.NONE);
	nameLabel.setText(Messages.getString("BankAccountEditForm.nameLabel.text")); //$NON-NLS-1$

    	nameField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 350;
    	nameField.setLayoutData(gridData);
    	nameField.setTextLimit(30);
    	
    	accountNoLabel = new Label(this, SWT.NONE);
	accountNoLabel.setText(Messages.getString("BankAccountEditForm.accountNoLabel.text")); //$NON-NLS-1$

    	accountNoField = new XTextField(this, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 350;
    	accountNoField.setLayoutData(gridData);
    	accountNoField.setTextLimit(BankEnvironment.BANK_ACCOUNT_SIZE);
    	
    	this.setSize(new Point(470, 108));
    	
    	partnerField.setAssociationValueClass(Partner.class);
    	bankField.setAssociationValueClass(Bank.class);
    }
    
    protected void bindControls() {
	bindControl(partnerField, "partner", partnerLabel, REQUIRED);
	bindControl(bankField, "bank", bankLabel, REQUIRED);
	bindControl(nameField, "name", nameLabel, REQUIRED);
	bindControl(accountNoField, "accountNo", accountNoLabel, REQUIRED);
	
    }
    
    protected BankAccount getBankAccount() {
	return (BankAccount) getEntity();
    }
    
    protected void initData() throws ApplicationException {
	super.initData();
	getBankAccount().setName(Messages.getString("BankAccountEditForm.primaryAccount"));
    }
    

}
