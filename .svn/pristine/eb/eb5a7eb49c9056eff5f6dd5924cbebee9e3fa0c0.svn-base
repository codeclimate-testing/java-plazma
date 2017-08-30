package org.plazmaforge.bsolution.bank.client.swt.forms.common;

import java.util.Map;



import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.plazmaforge.bsolution.bank.common.beans.BankAccount;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.base.client.swt.forms.common.ExtPeriodReportDialog;
import org.plazmaforge.bsolution.base.common.acceptors.OrganizationAcceptorUtilities;
import org.plazmaforge.bsolution.partner.client.swt.forms.PartnerBankAccountListForm;
import org.plazmaforge.bsolution.partner.client.swt.forms.PartnerListForm;
import org.plazmaforge.bsolution.partner.common.beans.IPartnerHeader;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.core.exception.ApplicationException;

public class BankAccountReportDialog extends ExtPeriodReportDialog {

    private final static String WHERE_SQL = "WHERE_SQL";

    private Label bankAccountLabel;
    private Label partnerLabel;

    private XComboEdit bankAccountField;    
    private XComboEdit partnerField;

    private BankAccount bankAccount;
    private IPartnerHeader partner;
    
    
    public BankAccountReportDialog(Shell parent) {
	super(parent);
    }

    
    protected void configureShell(Shell shell) {
	super.configureShell(shell);
	shell.setText(Messages.getString("BankAccountReportDialog.title")); //$NON-NLS-1$
    }
    
    protected void createHeaderPanel(Composite parent) {
	
    	GridData gridData;
    	
    	bankAccountLabel = new Label(parent, SWT.NONE);
    	bankAccountLabel.setText(Messages.getString("BankAccountReportDialog.bank.account")); //$NON-NLS-1$
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
    	bankAccountLabel.setLayoutData(gridData);

    	bankAccountField = new XComboEdit(parent, SWT.BORDER, PWT.VIEW_BUTTON); // PWT.POPUP_BUTTON | 
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
    	bankAccountField.setLayoutData(gridData);
    	

    	partnerLabel = new Label(parent, SWT.NONE);
    	partnerLabel.setText(Messages.getString("BankAccountReportDialog.partner")); //$NON-NLS-1$
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
    	partnerLabel.setLayoutData(gridData);

	partnerField = new XComboEdit(parent, SWT.BORDER, PWT.VIEW_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
    	partnerField.setLayoutData(gridData);

        Label label = new Label(parent, SWT.NONE);
        label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
    }
    
    protected void initData() {
	super.initData();
	
	bankAccountField.setParentEntityId(EnterpriseEnvironment.getOrganizationId(SessionEnvironment.getContext()));
	bankAccountField.setListFormClass(PartnerBankAccountListForm.class);
	bankAccountField.setDisplayValueProperty("accountNo");
	
	partnerField.setListFormClass(PartnerListForm.class);
    }
    
    protected void populateData() {
	super.populateData();

	bankAccount = (BankAccount) bankAccountField.getValue();
	partner = (IPartnerHeader) partnerField.getValue();
    }

    public Map<String, Object> readParameters() throws ApplicationException {
        Map<String, Object> parameters = super.readParameters();
        initBankAccount(parameters);  
        initPartner(parameters);
        return parameters;
    }
    
    
    protected void initBankAccount(Map<String, Object> parameters) {
	if (bankAccount == null) {
	    return;
	}
	OrganizationAcceptorUtilities.initBankAccountId(parameters, bankAccount.getId());
	OrganizationAcceptorUtilities.initBankAccountNo(parameters, bankAccount.getAccountNo());
	
	if (bankAccount.getId() != null) {
	    String whereSQL = getWhereSQL(parameters);
	    whereSQL += " AND p.ORGANIZATION_BANK_ACCOUNT_ID = " + bankAccount.getId().intValue();
	    setWhereSQL(parameters, whereSQL);
	}
	
    }
    
    protected void initPartner(Map<String, Object> parameters) {
	if (partner == null) {
	    return;
	}
	OrganizationAcceptorUtilities.initPartnerId(parameters, partner.getId());
	OrganizationAcceptorUtilities.initPartnerName(parameters, partner.getName());
	
	if (partner.getId() != null) {
	    String whereSQL = getWhereSQL(parameters);
	    whereSQL += " AND p.PARTNER_ID = " + partner.getId().intValue();
	    setWhereSQL(parameters, whereSQL);
	}
    }
    
    protected void setWhereSQL(Map<String, Object> parameters, String whereSQL) {
	parameters.put(WHERE_SQL, whereSQL);
    }
    
    protected String getWhereSQL(Map<String, Object> parameters) {
	String whereSql = (String) parameters.get(WHERE_SQL);
	if (whereSql == null) {
	    whereSql = "";
	}
	return whereSql;
    }
}
