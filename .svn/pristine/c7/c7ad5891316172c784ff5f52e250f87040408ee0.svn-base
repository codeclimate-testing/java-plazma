package org.plazmaforge.bsolution.finance.client.swt.acceptors;



import org.plazmaforge.bsolution.base.client.swt.forms.common.ExtPeriodReportDialog;
import org.plazmaforge.bsolution.finance.common.acceptors.BTaxReportByQuarterDialogAcceptor;
import org.plazmaforge.framework.client.swt.SWTEnvironment;
import org.plazmaforge.framework.report.IReportDialog;


public class TaxReportByQuarterDialogAcceptor extends BTaxReportByQuarterDialogAcceptor {
    
    
    protected IReportDialog createReportDialog() {
	ExtPeriodReportDialog dialog = new ExtPeriodReportDialog(SWTEnvironment.getShell());
	dialog.setMode(ExtPeriodReportDialog.QUARTER_MODE);
	dialog.setSingleMode(true);
	return dialog;
    }
    
  
    

    
}
