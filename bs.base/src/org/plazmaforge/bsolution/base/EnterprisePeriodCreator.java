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
package org.plazmaforge.bsolution.base;

import java.io.Serializable;

import org.plazmaforge.bsolution.base.common.services.PeriodService;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.service.ServiceFactory;
import org.plazmaforge.framework.platform.service.CompressionExecutor;
import org.plazmaforge.framework.platform.service.PeriodCreator;


public class EnterprisePeriodCreator implements PeriodCreator {

    public Integer createPeriod(CompressionExecutor[] executors, Serializable context) throws ApplicationException {
	SessionContext enterpriseContext = (SessionContext) context; 
	PeriodService periodService = (PeriodService) ServiceFactory.getService(PeriodService.class);
	
	Integer organizationId = EnterpriseEnvironment.getOrganizationId(enterpriseContext);
	Integer periodId = EnterpriseEnvironment.getPeriodId();
	Integer newPeriod = periodService.registerPeriod(organizationId, periodId, executors);
	

	if (newPeriod != null && !newPeriod.equals(EnterpriseEnvironment.getPeriodId())) {
	    EnterpriseEnvironment.loadSystemInfo();
	}

//	if (newPeriod != null
//		&& newPeriod.equals(EnterpriseEnvironment.getPeriodId())) {
//	    EnterpriseEnvironment.loadSystemInfo();
//	} else {
//	    newPeriod = null;
//	}
	
	return newPeriod;

    }
}
