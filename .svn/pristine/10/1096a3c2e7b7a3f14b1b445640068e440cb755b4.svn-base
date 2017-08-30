package org.plazmaforge.bsolution.finance.client.swt.acceptors;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.dialogs.AbstractReportDialog;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.DateUtils;

public class PensionReport26Dialog extends AbstractReportDialog {

    private Label yearLabel;
    private Label reportDateLabel;

    private Spinner yearField;    
    private XDateCombo reportDateField;
    
    ////
    
    private int year;
    private Date reportDate;
    
    public PensionReport26Dialog(Shell parentShell) {
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
    	
    	yearLabel = new Label(parent, SWT.NONE);
    	yearLabel.setText(Messages.getString("PensionReportDialog.year")); //$NON-NLS-1$
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
    	yearLabel.setLayoutData(gridData);

    	yearField = new Spinner(parent, SWT.BORDER); 
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
	gridData.widthHint = 70;
    	yearField.setLayoutData(gridData);
    	

    	Label label = new Label(parent, SWT.NONE);
        label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));

    	reportDateLabel = new Label(parent, SWT.NONE);
    	reportDateLabel.setText(Messages.getString("PensionReportDialog.reportDate")); //$NON-NLS-1$
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
    	reportDateLabel.setLayoutData(gridData);

    	reportDateField = new XDateCombo(parent, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
	reportDateField.setLayoutData(gridData);
	
	
	initYearSpinner(yearField);

    }
    
    protected void initData() {
	super.initData();
	
	Calendar calendar = Calendar.getInstance();
	Date reportDate = calendar.getTime();
	Date startDate = EnterpriseEnvironment.getYearPeriodStartDate();
	int year = DateUtils.getYear(startDate);

	setReportDate(reportDate);
	setYear(year);
	
	yearField.setSelection(year);
	reportDateField.setDate(reportDate);
	
    }
    
    protected void initYearSpinner(Spinner spinner) {
	spinner.setMinimum(1900);
	spinner.setMaximum(3000);
    }
    
   
    public Date getReportDate() {
        return reportDate;
    }


    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }
    

    public int getYear() {
        return year;
    }


    public void setYear(int year) {
        this.year = year;
    }


    protected void populateData() {
	super.populateData();
	setYear(yearField.getSelection());
	setReportDate(reportDateField.getDate());
    }

    public Map<String, Object> readParameters() throws ApplicationException {
        Map<String, Object> parameters = new HashMap<String, Object>();
        
        // Set year by start work date
        //OrganizationAcceptorUtilities.initYearParameterByStartDate(parameters, getStartWorkDate());
        
        parameters.put("YEAR", getYear());
        parameters.put("REPORT_DATE", getReportDate());
        parameters.put("REPORT_TYPE", "12");
        
        return parameters;
    }
}
