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

package org.plazmaforge.bsolution.product.client.swt.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.eclipse.swt.SWT;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.product.common.beans.ProductMoveInfo;
import org.plazmaforge.bsolution.product.common.services.ProductManagerService;
import org.plazmaforge.framework.action.DefaultAcceptorAction;
import org.plazmaforge.framework.client.Toolkit;
import org.plazmaforge.framework.client.swt.SWTEnvironment;
import org.plazmaforge.framework.client.swt.dialogs.ResultDialog;
import org.plazmaforge.framework.client.swt.forms.AbstractForm;
import org.plazmaforge.framework.core.IAcceptor;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.service.ServiceFactory;

/** 
 * @author Oleh Hapon
 * $Id: ProductMoveInfoAction.java,v 1.5 2010/12/05 07:57:22 ohapon Exp $
 */

public class ProductMoveInfoAction extends DefaultAcceptorAction {

    public void execute() throws ApplicationException {
	
	Map parameters = getAcceptor().readParameters();
        if (parameters == null) {
            Toolkit.openMessageDialog("Info", AbstractForm.NO_DATA_MESSAGE);
            return;
        }
        Integer id = (Integer) parameters.get(IAcceptor.ID);
        if (id == null) {
            Toolkit.openMessageDialog("Info", AbstractForm.ROW_NOT_SELECTED_MESSAGE);
            return;
        }
	
	ProductManagerService service = (ProductManagerService) ServiceFactory.getService(ProductManagerService.class);
	if (service == null) {
	    throw new ApplicationException("ProductManagerService not found");
	}

	Integer productId = id;
	Integer periodId = EnterpriseEnvironment.getPeriodId();
	
	ProductMoveInfo info = service.getMoveInfo(periodId, productId);
	
	List message = new ArrayList();
	Object[] line = new String[2];
	line[0] = Messages.getString("Start");
	line[1] = "" + info.getStartQuantity();
	message.add(line);
	
	line = new String[2];
	line[0] = Messages.getString("Income");
	line[1] = "" + info.getIncomeQuantity();
	message.add(line);
	
	line = new String[2];
	line[0] = Messages.getString("Outcome");
	line[1] = "" + info.getOutcomeQuantity();
	message.add(line);

	line = new String[2];
	line[0] = Messages.getString("End");
	line[1] = "" + info.getEndQuantity();
	message.add(line);
	
	ResultDialog dialog = new ResultDialog(SWTEnvironment.getShell());
	dialog.setValueColumnStyle(SWT.RIGHT);
	dialog.setLabelColumnName(Messages.getString("Name"));
	dialog.setValueColumnName(Messages.getString("Quantity"));
	dialog.setList(message);
	dialog.open();
    }
}