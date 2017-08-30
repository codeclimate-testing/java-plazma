package org.plazmaforge.bsolution.bank.client.swt.acceptors;

import org.plazmaforge.bsolution.bank.client.swt.forms.common.BankAccountReportDialog;
import org.plazmaforge.bsolution.base.common.acceptors.OrganizationDialogAcceptor;
import org.plazmaforge.framework.client.swt.SWTEnvironment;
import org.plazmaforge.framework.report.IReportDialog;


public class OrganizationBankAccountDialogAcceptor extends OrganizationDialogAcceptor {

    protected IReportDialog createReportDialog() {
        return new BankAccountReportDialog(SWTEnvironment.getShell());
    }

}