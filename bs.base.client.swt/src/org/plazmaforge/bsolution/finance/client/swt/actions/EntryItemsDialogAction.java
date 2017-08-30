/*
 * Copyright (C) 2005-2010 Oleh Hapon ohapon@users.sourceforge.net
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA.
 * 
 * Oleh Hapon
 * Kyiv, UKRAINE
 * ohapon@users.sourceforge.net
 */

/* 
 * Created on 29.12.2007
 *
 */

package org.plazmaforge.bsolution.finance.client.swt.actions;

import java.util.List;
import java.util.Map;

import org.plazmaforge.bsolution.document.client.swt.forms.AbstractDocumentListForm;
import org.plazmaforge.bsolution.finance.client.swt.dialogs.EntryItemsDialog;
import org.plazmaforge.bsolution.finance.client.swt.forms.AbstractFinanceDocumentListForm;
import org.plazmaforge.bsolution.finance.common.beans.EntryItem;
import org.plazmaforge.bsolution.finance.common.services.FinanceDocumentService;
import org.plazmaforge.framework.action.DefaultAcceptorAction;
import org.plazmaforge.framework.client.Toolkit;
import org.plazmaforge.framework.client.swt.SWTEnvironment;
import org.plazmaforge.framework.client.swt.forms.AbstractForm;
import org.plazmaforge.framework.core.IAcceptor;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.service.ServiceFactory;


/** 
 * @author Oleh Hapon
 * $Id: EntryItemsDialogAction.java,v 1.5 2010/12/05 07:57:21 ohapon Exp $
 */

public class EntryItemsDialogAction extends DefaultAcceptorAction {

    public void execute() throws ApplicationException {
	
	Map parameters = getAcceptor().readParameters();
        if (parameters == null) {
            Toolkit.openMessageDialog("Info", AbstractForm.NO_DATA_MESSAGE);
            return;
        }
        Integer id = (Integer) parameters.get(IAcceptor.ID);
        if (id == null) {
            Toolkit.openMessageDialog("Info", AbstractDocumentListForm.DOCUMENT_NOT_SELECTED_MESSAGE);
            return;
        }
        List<EntryItem> items = getService().findEntryItemsByFinanceDocument(id);
        if (items == null || items.size() == 0) {
            Toolkit.openMessageDialog("Info", AbstractFinanceDocumentListForm.NO_ENTRIES_MESSAGE);
            return;
        }
        EntryItemsDialog dialog = new EntryItemsDialog(SWTEnvironment.getShell());
	dialog.setList(items);
	dialog.open();
    }
    
    private FinanceDocumentService getService() {
	return (FinanceDocumentService) ServiceFactory.getService(FinanceDocumentService.class);
    }
}
