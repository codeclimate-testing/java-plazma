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
package org.plazmaforge.bsolution.project.common.beans;

import org.plazmaforge.bsolution.contact.common.beans.ContactTitle;
import org.plazmaforge.bsolution.organization.common.beans.IOrganizable;
import org.plazmaforge.bsolution.organization.common.beans.IOrganizationTitle;
import org.plazmaforge.framework.ext.model.IHistoryEntity;
import org.plazmaforge.framework.ext.model.IStringPresentation;


public class ProjectHeader extends ProjectTitle implements IHistoryEntity, IStringPresentation, IOrganizable {

    private ContactTitle responsible;
    
    private IOrganizationTitle organization;
    
    public IOrganizationTitle getOrganization() {
	return organization;
    }

    public void setOrganization(IOrganizationTitle organization) {
	this.organization = organization;
    }
    
    public Integer getOrganizationId() {
	return organization == null ? null : organization.getId();
    }

    
    public ContactTitle getResponsible() {
	return responsible;
    }

    public void setResponsible(ContactTitle responsible) {
	this.responsible = responsible;
    }
    
    public String getResponsibleName() {
	return responsible == null ? null : responsible.getName();
    }
}
