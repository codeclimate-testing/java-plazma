package org.plazmaforge.bsolution.base.client.swing.acceptors;

import org.plazmaforge.bsolution.base.client.swing.forms.common.PeriodReportDialog;
import org.plazmaforge.bsolution.base.common.acceptors.OrganizationDialogAcceptor;
import org.plazmaforge.framework.client.swing.SwingEnvironment;
import org.plazmaforge.framework.report.IReportDialog;


public class OrganizationPeriodDialogAcceptor extends OrganizationDialogAcceptor {

    protected IReportDialog createReportDialog() {
        return new PeriodReportDialog(SwingEnvironment.getFrame());
    }

}
