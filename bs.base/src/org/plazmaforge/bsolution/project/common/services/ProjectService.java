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
package org.plazmaforge.bsolution.project.common.services;

import java.util.List;

import org.plazmaforge.bsolution.base.common.services.AttributeServiceHolder;
import org.plazmaforge.bsolution.organization.common.services.OrganizableService;
import org.plazmaforge.bsolution.project.common.beans.Project;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.core.exception.DAOException;


public interface ProjectService extends OrganizableService<Project, Integer>, AttributeServiceHolder {
	
    List findByOrganizationId(Integer organizationId, Integer partnerId) throws DAOException;
  
    List findByOrganizationId(Integer organizationId, Integer partnerId, Criteria criteria) throws DAOException;
    
    List findByOrganizationId(Integer organizationId, Integer partnerId, Integer responsibleId) throws DAOException;
    
    List findByOrganizationId(Integer organizationId, Integer partnerId, Integer responsibleId, Criteria criteria) throws DAOException;

}
