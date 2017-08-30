package org.plazmaforge.framework.client.actions;

import org.plazmaforge.framework.action.ICommand;
import org.plazmaforge.framework.client.Toolkit;
import org.plazmaforge.framework.core.exception.ApplicationException;


public class CloseAllFormsCommand implements ICommand, CommandConstants {
    
    public void execute(String parameter) throws ApplicationException {
	Toolkit.closeAllForms();
    }

    public String getName() {
	return CLOSE_ALL_FORMS;
    }
    

}
