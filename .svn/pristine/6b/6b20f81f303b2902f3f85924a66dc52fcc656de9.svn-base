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
 * Created on 02.01.2008
 *
 */

package org.plazmaforge.bsolution.finance.client.swt.actions;


import org.eclipse.swt.widgets.Shell;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.finance.common.services.EntryCalculateService;
import org.plazmaforge.framework.client.swt.SWTEnvironment;
import org.plazmaforge.framework.client.swt.action.SWTProcessAction;
import org.plazmaforge.framework.client.swt.app.SWTProcessRunner;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.service.ServiceFactory;

/** 
 * @author Oleh Hapon
 * $Id: EntryRemoveAction.java,v 1.5 2010/12/05 07:57:21 ohapon Exp $
 */

public class EntryRemoveAction extends SWTProcessAction {
    
    public void executeProcess() throws ApplicationException {
	EntryCalculateService service = (EntryCalculateService) ServiceFactory.getService(EntryCalculateService.class);
	Integer organizationId = EnterpriseEnvironment.getOrganizationId(SessionEnvironment.getContext());
	Integer periodId =  EnterpriseEnvironment.getPayrollPeriodId();
	service.removeEntryItems(organizationId, periodId);
    }
    
    protected void initRunner(SWTProcessRunner runner) {
	runner.setConfirmDialog(true);
	runner.setResultDialog(true);
	
	runner.setConfirmMessage(Messages.getString("EntryRemoveAction.confirm"));
	runner.setResultMessage(Messages.getString("EntryRemoveAction.result"));
    }

    
    protected Shell getShell(){
	return SWTEnvironment.getShell();
    }

}