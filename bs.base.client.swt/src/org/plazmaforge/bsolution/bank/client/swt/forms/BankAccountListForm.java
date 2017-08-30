package org.plazmaforge.bsolution.bank.client.swt.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.bank.common.beans.BankAccount;
import org.plazmaforge.bsolution.bank.common.services.BankAccountService;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.forms.AbstractListForm;

public class BankAccountListForm extends AbstractListForm {

    
    private Table table;
    
    
    public BankAccountListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	
	setEntityClass(BankAccount.class);
	setEntityServiceClass(BankAccountService.class);
	setEntityEditFormClass(BankAccountEditForm.class);
	
	
	setTitle(Messages.getString("BankAccountListForm.title")); //$NON-NLS-1$
        TableColumn tableColumn;
        TableColumn nameColumn;
        TableColumn bankNameColumn;
        TableColumn accountNoColumn;
        
        setLayout(new FillLayout());
 

    	table = new Table(this, SWTToolkit.TABLE_STYLE);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	bankNameColumn = new TableColumn(table, SWT.NONE);
    	bankNameColumn.setWidth(200);
    	bankNameColumn.setText(Messages.getString("BankAccountListForm.partnerNameColumn.text")); //$NON-NLS-1$

    	bankNameColumn = new TableColumn(table, SWT.NONE);
    	bankNameColumn.setWidth(200);
    	bankNameColumn.setText(Messages.getString("BankAccountListForm.bankNameColumn.text")); //$NON-NLS-1$

    	nameColumn = new TableColumn(table, SWT.NONE);
    	nameColumn.setWidth(200);
    	nameColumn.setText(Messages.getString("BankAccountListForm.nameColumn.text")); //$NON-NLS-1$

	accountNoColumn = new TableColumn(table, SWT.NONE);
    	accountNoColumn.setWidth(200);
    	accountNoColumn.setText(Messages.getString("BankAccountListForm.accountNoColumn.text")); //$NON-NLS-1$
    	
    		    	

        this.setSize(new Point(700, 300));
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "partnerName");
	bindColumn(2, "bankName");
	bindColumn(3, "name");
	bindColumn(4, "accountNo");
    }

}
