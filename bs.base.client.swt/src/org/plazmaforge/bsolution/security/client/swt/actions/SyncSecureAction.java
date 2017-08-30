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
 * Created on 18.05.2009
 *
 */

package org.plazmaforge.bsolution.security.client.swt.actions;

import org.plazmaforge.bsolution.base.common.services.SystemInfoService;
import org.plazmaforge.framework.client.swt.action.SWTProcessAction;
import org.plazmaforge.framework.client.swt.app.SWTProcessRunner;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.service.ServiceFactory;

/** 
 * @author Oleh Hapon
 * $Id: SyncSecureAction.java,v 1.5 2010/12/05 07:57:23 ohapon Exp $
 */

public class SyncSecureAction extends SWTProcessAction {

    public void executeProcess() throws ApplicationException {
	
	SystemInfoService service = (SystemInfoService) ServiceFactory.getService(SystemInfoService.class);
	service.syncSecureSystem();
    }
    
    protected void initRunner(SWTProcessRunner runner) {
	runner.setConfirmDialog(true);
	runner.setResultDialog(true);
	
	runner.setConfirmMessage(Messages.getString("SyncSecureAction.confirm"));
	runner.setResultMessage(Messages.getString("SyncSecureAction.result"));
    }

}
