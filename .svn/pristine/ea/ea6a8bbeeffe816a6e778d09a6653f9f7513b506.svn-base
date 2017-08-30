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

package org.plazmaforge.bsolution.project;

import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.common.beans.Currency;
import org.plazmaforge.bsolution.contact.common.beans.ContactTitle;
import org.plazmaforge.bsolution.partner.common.beans.PartnerTitle;
import org.plazmaforge.bsolution.project.common.beans.ProjectStage;
import org.plazmaforge.bsolution.project.common.beans.ProjectStatus;
import org.plazmaforge.bsolution.project.common.beans.ProjectType;
import org.plazmaforge.bsolution.project.common.services.ProjectContextService;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.service.ServiceFactory;
import org.plazmaforge.framework.platform.Environment;



/**
 * @author Oleh Hapon
 *
 * $Id: ProjectEnvironment.java,v 1.3 2010/12/05 07:56:00 ohapon Exp $
 * 
 */

public class ProjectEnvironment extends Environment {

    private static ProjectEnvironment instance;

    private ProjectContext context;

    private ProjectEnvironment() {
	// context = new ProjectContext();
    }

    public static ProjectEnvironment getInstance() {
	if (instance == null) {
	    instance = new ProjectEnvironment();
	    instance.loadContext();
	}
	return instance;

    }

    public static ProjectContext getContext() {
	return getInstance().context;
    }

    /**
     * Load Context
     * 
     */
    private void loadContext() {
	try {
	    context = ((ProjectContextService) ServiceFactory
		    .getService(ProjectContextService.class)).load();

	    if (context == null) {
		throw new Exception("ProjectContext is null");
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	} finally {
	    if (context == null) {
		context = new ProjectContext();
	    }
	}

    }

    public static void refresh() throws ApplicationException {
	getInstance().loadContext();
    }

    public static Currency getCurrency() {
	return getContext().getCurrency() == null ? EnterpriseEnvironment
		.getCurrency() : getContext().getCurrency();
    }

    public static PartnerTitle getPartner() {
	return getContext().getPartner() == null ? EnterpriseEnvironment
		.getPartner() : getContext().getPartner();
    }

    public static ContactTitle getResponsible() {
	return getContext().getResponsible() == null ? EnterpriseEnvironment
		.getResponsible() : getContext().getResponsible();
    }

    public static ProjectStage getProjectStage() {
	return getContext().getProjectStage();
    }

    public static ProjectStatus getProjectStatus() {
	return getContext().getProjectStatus();
    }

    public static ProjectStatus getDefaultProjectStatus() {
	return getContext().getDefaultProjectStatus();
    }
    
    public static ProjectType getProjectType() {
	return getContext().getProjectType();
    }

    public static ProjectType getDefaultProjectType() {
	return getContext().getDefaultProjectType();
    }

}
