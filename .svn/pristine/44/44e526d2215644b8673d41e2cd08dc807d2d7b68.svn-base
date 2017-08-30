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
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.ext.model.Attribute;
import org.plazmaforge.framework.ext.model.AttributeValue;
import org.plazmaforge.framework.ext.model.IAttributeHolder;
import org.plazmaforge.framework.ext.service.EntityService;


/**
 * 
 * @author ohapon
 *
 */
public interface AttributeValueService extends EntityService<AttributeValue, Integer> {

    /**
     * Create attribute
     * @param attribute
     * @return
     * @throws DAOException
     */
    Integer createAttribute(Attribute attribute) throws DAOException;
    
    /**
     * Load attributes by entity
     * @param entity
     * @return
     * @throws DAOException
     */
    List<Attribute> findAttributesByEntity(IEntityConfig entity) throws DAOException;

    
    /**
     * Load attribute values by owner id
     * @param entity
     * @param ownerId
     * @return
     * @throws DAOException
     */
    List<AttributeValue> findByOwner(IEntityConfig entity, Integer ownerId) throws DAOException;
    
    
    void loadAttributeValues(IAttributeHolder holder) throws DAOException;
    
    void storeAttributeValues(IAttributeHolder holder) throws DAOException;
    
    void removeAttributeValues(IAttributeHolder holder) throws DAOException;
    
}
