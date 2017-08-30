package org.plazmaforge.bsolution.finance.client.swt.acceptors;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.common.acceptors.OrganizationAcceptorUtilities;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.dialogs.AbstractReportDialog;
import org.plazmaforge.framework.core.exception.ApplicationException;

public class PensionReportDialog extends AbstractReportDialog {

    private Label startWorkDateLabel;
    private Label endWorkDateLabel;
    private Label reportDateLabel;
    private Label formTypeLabel;
    private Label reportTypeLabel;
    private Label workBookLabel;

    private XDateCombo startWorkDateField;    
    private XDateCombo endWorkDateField;
    private XDateCombo reportDateField;
    private XComboEdit formTypeField;
    private XComboEdit reportTypeField;
    private Button workBookField;

    ////
    
    private Date startWorkDate;
    private Date endWorkDate;
    private Date reportDate;
    private int formType;
    private int reportType;
    private boolean workBook;
    
    public PensionReportDialog(Shell parentShell) {
	super(parentShell);
    }

    
    protected void configureShell(Shell shell) {
	super.configureShell(shell);
	shell.setText(Messages.getString("PensionReportDialog.title")); //$NON-NLS-1$
    }
    
    protected void createContentPanel(Composite parent) {
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.numColumns = 3;
	parent.setLayout(gridLayout);
	        
	        
    	GridData gridData;
    	
    	startWorkDateLabel = new Label(parent, SWT.NONE);
    	startWorkDateLabel.setText(Messages.getString("PensionReportDialog.startWorkDate")); //$NON-NLS-1$
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
    	startWorkDateLabel.setLayoutData(gridData);

    	startWorkDateField = new XDateCombo(parent, SWT.BORDER); 
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
    	startWorkDateField.setLayoutData(gridData);
    	

    	endWorkDateLabel = new Label(parent, SWT.NONE);
    	endWorkDateLabel.setText(Messages.getString("PensionReportDialog.endWorkDate")); //$NON-NLS-1$
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
    	endWorkDateLabel.setLayoutData(gridData);

	endWorkDateField = new XDateCombo(parent, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
    	endWorkDateField.setLayoutData(gridData);

        Label label = new Label(parent, SWT.NONE);
        label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));

    	reportDateLabel = new Label(parent, SWT.NONE);
    	reportDateLabel.setText(Messages.getString("PensionReportDialog.reportDate")); //$NON-NLS-1$
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
    	reportDateLabel.setLayoutData(gridData);

    	reportDateField = new XDateCombo(parent, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
	reportDateField.setLayoutData(gridData);

        label = new Label(parent, SWT.NONE);
        label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
        
    	formTypeLabel = new Label(parent, SWT.NONE);
    	formTypeLabel.setText(Messages.getString("PensionReportDialog.formType")); //$NON-NLS-1$
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
    	formTypeLabel.setLayoutData(gridData);

    	formTypeField = new XComboEdit(parent, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
	formTypeField.setLayoutData(gridData);
	formTypeField.add(Messages.getString("PensionReportDialog.formType1"));
	formTypeField.add(Messages.getString("PensionReportDialog.formType2"));
	formTypeField.add(Messages.getString("PensionReportDialog.formType3"));
	formTypeField.add(Messages.getString("PensionReportDialog.formType4"));

	////
	
    	reportTypeLabel = new Label(parent, SWT.NONE);
    	reportTypeLabel.setText(Messages.getString("PensionReportDialog.reportType")); //$NON-NLS-1$
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
    	reportTypeLabel.setLayoutData(gridData);

    	reportTypeField = new XComboEdit(parent, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
	reportTypeField.setLayoutData(gridData);
	reportTypeField.add("08");
	reportTypeField.add("12");

	////
	
    	workBookLabel = new Label(parent, SWT.NONE);
    	workBookLabel.setText(Messages.getString("PensionReportDialog.workBook")); //$NON-NLS-1$
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
    	workBookLabel.setLayoutData(gridData);

    	workBookField = new Button(parent, SWT.CHECK);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
	workBookField.setLayoutData(gridData);

        label = new Label(parent, SWT.NONE);
        label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
        
    }
    
    protected void initData() {
	super.initData();
	
	Calendar calendar = Calendar.getInstance();
	Date reportDate = calendar.getTime();
	Date startWorkDate = EnterpriseEnvironment.getYearPeriodStartDate();
	Date endWorkDate = EnterpriseEnvironment.getDate(EnterpriseEnvironment.getYear(), Calendar.DECEMBER, 31);
	int formType = 0;
	int reportType = 0;
	boolean workBook = true;

	setReportDate(reportDate);
	setStartWorkDate(startWorkDate);
	setEndWorkDate(endWorkDate);
	setFormType(formType);
	setReportType(reportType);
	setWorkBook(workBook);
	
	startWorkDateField.setDate(startWorkDate);
	endWorkDateField.setDate(endWorkDate);
	reportDateField.setDate(reportDate);
	formTypeField.setSelection(formType);
	reportTypeField.setSelection(reportType);
	workBookField.setSelection(workBook);
	
    }
    
    public Date getStartWorkDate() {
        return startWorkDate;
    }

    public Date getEndWorkDate() {
        return endWorkDate;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setStartWorkDate(Date startWorkDate) {
        this.startWorkDate = startWorkDate;
    }

    public void setEndWorkDate(Date endWorkDate) {
        this.endWorkDate = endWorkDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }
    
    
    public int getFormType() {
        return formType;
    }


    public boolean isWorkBook() {
        return workBook;
    }


    public void setFormType(int formType) {
        this.formType = formType;
    }


    public void setWorkBook(boolean workBook) {
        this.workBook = workBook;
    }


    public int getReportType() {
        return reportType;
    }


    public void setReportType(int reportType) {
        this.reportType = reportType;
    }


    protected void populateData() {
	super.populateData();

	setStartWorkDate(startWorkDateField.getDate());
	setEndWorkDate(endWorkDateField.getDate());
	setReportDate(reportDateField.getDate());
	setFormType(formTypeField.getSelectionIndex());
	setReportType(reportTypeField.getSelectionIndex());
	setWorkBook(workBookField.getSelection());
    }

    public Map<String, Object> readParameters() throws ApplicationException {
        Map<String, Object> parameters = new HashMap<String, Object>();
        
        // Set year by start work date
        OrganizationAcceptorUtilities.initYearParameterByStartDate(parameters, getStartWorkDate());
        
        parameters.put("START_WORK_DATE", getStartWorkDate());
        parameters.put("END_WORK_DATE", getEndWorkDate());
        parameters.put("REPORT_DATE", getReportDate());
        parameters.put("FORM_TYPE", "" + (getFormType() + 1));
        parameters.put("REPORT_TYPE", getReportType() == 1 ? "12" : "08");
        parameters.put("IS_WORK_BOOK", isWorkBook());
        
        return parameters;
    }
    
    
    
    
}
