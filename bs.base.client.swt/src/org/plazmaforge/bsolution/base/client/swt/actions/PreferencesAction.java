package org.plazmaforge.bsolution.base.client.swt.actions;

import org.plazmaforge.bsolution.base.client.swt.dialogs.PreferencesDialog;
import org.plazmaforge.framework.action.DefaultAction;
import org.plazmaforge.framework.client.swt.SWTEnvironment;
import org.plazmaforge.framework.core.exception.ApplicationException;

public class PreferencesAction extends DefaultAction  {

    public void execute() throws ApplicationException {
	PreferencesDialog dialog = new PreferencesDialog(SWTEnvironment.getShell()); 
	dialog.open();
    }

}
