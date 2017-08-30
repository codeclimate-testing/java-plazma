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
package org.plazmaforge.bsolution.base.common.services;


import java.util.List;

import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.config.object.IEntityTypeConfig;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.exception.FinderException;
import org.plazmaforge.framework.ext.service.EntityService;
import org.plazmaforge.framework.platform.ISystemEntityService;

public interface SystemEntityService extends EntityService<IEntityConfig, String>, ISystemEntityService {

    List<IEntityConfig> findByEntityType(String entityType)  throws DAOException;
    
    List<IEntityConfig> findByEntityTypeAndForm(String entityType) throws DAOException;

    List<IEntityConfig> findByCustom() throws DAOException;

    List<IEntityConfig> findByCustomAttribute() throws DAOException;
    
    
    List<IEntityConfig> findByCustomize(Criteria criteria) throws DAOException;
    
    List<IEntityConfig> findByCustomize() throws DAOException;
    
    IEntityTypeConfig findEntityTypeById(String id) throws DAOException, FinderException;

}
