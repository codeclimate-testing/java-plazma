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
package org.plazmaforge.bsolution.finance.client.swing.actions;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.finance.common.services.EntryCalculateService;
import org.plazmaforge.framework.client.swing.SwingEnvironment;
import org.plazmaforge.framework.client.swing.message.Message;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.service.ServiceFactory;


/*
 * Created 01.10.2006
 */
public class EntryCalculateAction extends GUIFinanceAction {

    public void perform(ActionEvent e) throws ApplicationException {
	if (Message.confirmYesNo(SwingEnvironment.getFrame(),
		"Do you want to calculate entry ?") != JOptionPane.OK_OPTION) {
	    return;
	}

	EntryCalculateService service = (EntryCalculateService) ServiceFactory.getService(EntryCalculateService.class);
	Map parameters = new HashMap();
	parameters.put("ORGANIZATION_ID", EnterpriseEnvironment.getOrganizationId(SessionEnvironment.getContext()));
	parameters.put("PERIOD_ID", EnterpriseEnvironment.getPayrollPeriodId());
	service.calculate(parameters);
    }

}
