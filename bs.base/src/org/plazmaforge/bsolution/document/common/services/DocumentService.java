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
package org.plazmaforge.bsolution.document.common.services;


import java.io.Serializable;
import java.util.List;
import java.util.Date;

import org.plazmaforge.bsolution.base.common.services.AttributeServiceHolder;
import org.plazmaforge.bsolution.base.common.services.FileServiceHolder;
import org.plazmaforge.bsolution.organization.common.services.OrganizableService;
import org.plazmaforge.bsolution.partner.common.services.PartnerableService;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.core.exception.DAOException;


/**
 * @author Oleh Hapon
 * Date: 08.05.2004
 * Time: 20:09:59
 * $Id: DocumentService.java,v 1.4 2010/12/05 07:56:05 ohapon Exp $
 * 
 * Base service for all documents
 * 
 */
public interface DocumentService<E, PK extends Serializable> extends OrganizableService<E, PK>, PartnerableService<E, PK>, AttributeServiceHolder, FileServiceHolder {

    
    /**
     * Find document by organization and period
     * @param organizationId
     * @param periodId
     * @return
     * @throws DAOException
     */
    List findByOrganizationIdAndPeriodId(Integer organizationId, Integer periodId) throws DAOException;
    
    
    List findByOrganizationIdAndPeriodId(Integer organizationId, Integer periodId, Integer partnerId) throws DAOException;
    
    List findByOrganizationIdAndPeriodId(Integer organizationId, Integer periodId, Integer partnerId, Criteria criteria) throws DAOException;


    ////
    
    
    List findByOrganizationIdAndInterval(Integer organizationId, Date startDate, Date endDate) throws DAOException;
    
    
    List findByOrganizationIdAndInterval(Integer organizationId, Date startDate, Date endDate, Integer partnerId) throws DAOException;
    
    List findByOrganizationIdAndInterval(final Integer organizationId, final Date startDate, final Date endDate, final Integer partnerId, Criteria criteria) throws DAOException;

}
