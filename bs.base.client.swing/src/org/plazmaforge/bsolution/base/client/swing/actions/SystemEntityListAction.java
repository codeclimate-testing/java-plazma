package org.plazmaforge.bsolution.base.client.swing.actions;


import java.awt.event.ActionEvent;

import org.plazmaforge.bsolution.base.client.swing.forms.SystemEntityList;
import org.plazmaforge.framework.client.swing.SwingFormManager;
import org.plazmaforge.framework.core.exception.ApplicationException;

/**
 * @author Oleh Hapon Date: 03.06.2006 Time: 11:00:30 $Id: SystemEntityListAction.java,v 1.2 2010/12/05 07:56:42 ohapon Exp $
 */
public class SystemEntityListAction extends GUIBaseAction {

    public void perform(ActionEvent e) throws ApplicationException {
	SwingFormManager.showListForm(SystemEntityList.class);
    }
}
