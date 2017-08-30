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
package org.plazmaforge.bsolution.organization.client.swt.forms;

import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.plazmaforge.bsolution.base.SessionContext;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.organization.common.services.OrganizableService;
import org.plazmaforge.framework.client.swt.forms.AbstractListForm;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.core.criteria.IOwnCriteriaImplementator;
import org.plazmaforge.framework.core.exception.ApplicationException;


/** 
 * @author Oleh Hapon
 * $Id: AbstractOrganizableListForm.java,v 1.5 2010/12/05 07:57:22 ohapon Exp $
 */

public abstract class AbstractOrganizableListForm extends AbstractListForm implements IOrganizableForm, IOwnCriteriaImplementator {
    
    
    /** Organization ID **/
    private Integer organizationId;
    
    
    public AbstractOrganizableListForm(Composite parent, int style) {
	super(parent, style);
    }
    
    public Integer getOrganizationId() {
	if (organizationId == null) {
	    return getContextOrganizationId();
	}
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }
    
    protected OrganizableService getOrganizableService() {
        return (OrganizableService) getEntityService();
    }
    
    
    
    protected List loadDataList() throws ApplicationException {
        return getOrganizableService().findByOrganizationId(getOrganizationId());
    }

    protected List loadDataList(Criteria criteria) throws ApplicationException {
        return getOrganizableService().findByOrganizationId(getOrganizationId(), criteria);
    }

    ////
    
    protected SessionContext getEnterpriseContext() {
	return SessionEnvironment.getContext();
    }

    public Integer getContextOrganizationId() {
	return EnterpriseEnvironment.getOrganizationId(getEnterpriseContext());
    }

    public Integer getContextUserId() {
	return EnterpriseEnvironment.getUserId(getEnterpriseContext());
    }
    
    public Integer getContextResponsibleId() {
	return EnterpriseEnvironment.getResponsibleId(getEnterpriseContext());
    }
    
    
}
