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

package org.plazmaforge.bsolution.pim;

import org.plazmaforge.bsolution.pim.common.beans.PIMAppointmentPriority;
import org.plazmaforge.bsolution.pim.common.beans.PIMAppointmentType;
import org.plazmaforge.bsolution.pim.common.services.PIMContextService;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.service.ServiceFactory;
import org.plazmaforge.framework.platform.Environment;

public class PIMEnvironment extends Environment {

    private static PIMEnvironment instance;

    private PIMContext context;

    private PIMEnvironment() {
    }

    public static PIMEnvironment getInstance() {
	if (instance == null) {
	    instance = new PIMEnvironment();
	    instance.loadContext();
	}
	return instance;

    }

    public static PIMContext getContext() {
	return getInstance().context;
    }

    /**
     * Load Context
     * 
     */
    private void loadContext() {
	try {
	    context = ((PIMContextService) ServiceFactory.getService(PIMContextService.class)).load();
	    if (context == null) {
		throw new Exception("PIMContext is null");
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	} finally {
	    if (context == null) {
		context = new PIMContext();
	    }
	}

    }

    public static void refresh() throws ApplicationException {
	getInstance().loadContext();
    }
    
    public static PIMAppointmentType getAppointmentType() {
	return getInstance().getContext().getAppointmentType();
    }
    
    public static PIMAppointmentPriority getAppointmentPriority() {
	return getInstance().getContext().getAppointmentPriority();
    }
    
}
