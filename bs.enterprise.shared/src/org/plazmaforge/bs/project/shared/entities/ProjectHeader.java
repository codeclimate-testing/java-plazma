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
package org.plazmaforge.bs.project.shared.entities;

import org.plazmaforge.bs.contact.shared.entities.ContactTitle;
import org.plazmaforge.bs.organization.shared.entities.IOrganizable;
import org.plazmaforge.bs.organization.shared.entities.IOrganizationTitle;
import org.plazmaforge.framework.ext.model.IHistoryEntity;
import org.plazmaforge.framework.ext.model.IStringPresentation;

/**
 * 
 * @author ohapon
 *
 */
public class ProjectHeader extends ProjectTitle implements IHistoryEntity, IStringPresentation, IOrganizable {

    private static final long serialVersionUID = 5749534995501664184L;
    

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
