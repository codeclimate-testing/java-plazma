package org.plazmaforge.bsolution.document.client.swing.actions;

import java.awt.event.ActionEvent;
import java.util.List;

import org.plazmaforge.bsolution.base.common.services.SystemEntityService;
import org.plazmaforge.framework.client.swing.SwingFormManager;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.service.ServiceFactory;


public class ChooseDocumentAction extends GUIDocumentAction {

    public void perform(ActionEvent e) throws ApplicationException {
	List entities = ((SystemEntityService) ServiceFactory.getService(SystemEntityService.class)).findByEntityTypeAndForm("DOCUMENT");
	SwingFormManager.showSelectedListForm(entities);
    }

}
