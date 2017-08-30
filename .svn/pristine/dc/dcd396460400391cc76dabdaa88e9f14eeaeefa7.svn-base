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

package org.plazmaforge.framework.client;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * The Entity Manager.
 * Create, load, store, remove, find entities. The manager is bridge from service layer and rich client.
 * We use manager for only simple/standard service method.
 * If you use complex/no standard service methods then you have to use <code>IServiceFactory</code>.
 * <code>
 *     MyService service = (MyService) Environment.getServiceFactory().getService(MyService.class);
 * </code>
 * 
 * @author ohapon
 *
 */
public interface IEntityManager {
    
    /**
     * Create the entity
     * @param service
     * @param entity
     * @return entity
     * @throws ApplicationException
     */
    Serializable createEntity(Object service, Object entity) throws ApplicationException;

    
    /**
     * Load the entity by id
     * @param service
     * @param id
     * @return
     * @throws ApplicationException
     */
    Object loadEntityById(Object service, Serializable id) throws ApplicationException;
    
    
    /**
     * Load the header of entity (light entity) by id
     * @param service
     * @param id
     * @return
     * @throws ApplicationException
     */
    Object loadHeaderById(Object service, Serializable id) throws ApplicationException;
    
    
    /**
     * Store the entity
     * @param service
     * @param entity
     * @throws ApplicationException
     */
    void storeEntity(Object service, Object entity) throws ApplicationException;
    
    /**
     * Remove the entity by id
     * @param service
     * @param id
     * @throws ApplicationException
     */
    void removeEntityById(Object service, Serializable id) throws ApplicationException;
    
    /**
     * Remove the entity
     * @param service
     * @param entity
     * @throws ApplicationException
     */
    void removeEntity(Object service, Object entity) throws ApplicationException;
    
    
    /**
     * Load the entity by criteria
     * @param service
     * @param findCriteria
     * @return
     * @throws ApplicationException
     */
    Object loadEntityByCriteria(Object service, Object[] findCriteria) throws ApplicationException;
    
    
    /**
     * Load the entity by criteria
     * @param service
     * @param findCriteria
     * @return
     * @throws ApplicationException
     */
    Object loadEntityByCriteria(Object service, Map findCriteria) throws ApplicationException;
    
    
    /**
     * Find all entities
     * @param service
     * @return entities
     * @throws ApplicationException
     */
    List findAll(Object service) throws ApplicationException;
    
    
    /**
     * Find entities by criteria
     * @param service
     * @param criteria
     * @return
     * @throws ApplicationException
     */
    List findByCriteria(Object service, Criteria criteria) throws ApplicationException;
    
    
    /**
     * Find entities by criteria
     * @param service
     * @param findCriteria
     * @return entities
     * @throws ApplicationException
     */
    List findByCriteria(Object service, Object[] findCriteria) throws ApplicationException;
    
    
    /**
     * Find entities by criteria
     * @param service
     * @param findCriteria
     * @return entities
     * @throws ApplicationException
     */
    List findByCriteria(Object service, Map findCriteria) throws ApplicationException;
    
    
    /**
     * Get id of entity
     * @param entity
     * @return
     */
    Serializable getEntityId(Object entity);
    
    /**
     * Create new instance of entity class
     * @param entityClass
     * @return
     * @throws ApplicationException
     */
    Object newEntity(Class entityClass) throws ApplicationException;
    
    
    
    void setCreated(Object entity);
    
    void setDeleted(Object entity);
    
    void setModified(Object entity);

    List<IEntityConfig> getEntityConfigListByType(String type);
    
    List<IEntityConfig> getEntityConfigListByTypeAndForm(String type);
}
