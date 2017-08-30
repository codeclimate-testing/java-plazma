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

package org.plazmaforge.bsolution.base.client.swt;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.plazmaforge.bsolution.base.common.services.SystemEntityService;
import org.plazmaforge.framework.client.IEntityManager;
import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.model.IEntityObject;
import org.plazmaforge.framework.ext.model.Statable;
import org.plazmaforge.framework.ext.service.EntityService;
import org.plazmaforge.framework.ext.service.ServiceFactory;


/**
 * The implementation <code>IEntityManager</code>
 * 
 * @author Oleh Hapon
 * $Id: RCPEntityManager.java,v 1.5 2010/12/05 07:57:23 ohapon Exp $
 */
public class RCPEntityManager implements IEntityManager {
    
    protected final Log logger = LogFactory.getLog(getClass());
    
    
    /**
     * Create the entity
     * @param service
     * @param entity
     * @return entity
     * @throws ApplicationException
     */
    public Serializable createEntity(Object service, Object entity) throws ApplicationException {
	if (!checkService(service)) {
	    return null;
	}
	return ((EntityService) service).create(entity);
    }

    
    /**
     * Load the entity by id
     * @param service
     * @param id
     * @return
     * @throws ApplicationException
     */
    public Object loadEntityById(Object service, Serializable id) throws ApplicationException {
	if (!checkService(service)) {
	    return null;
	}	
	return ((EntityService) service).findById(id);
    }
    
    
    /**
     * Load the header of entity (light entity) by id
     * @param service
     * @param id
     * @return
     * @throws ApplicationException
     */
    public Object loadHeaderById(Object service, Serializable id) throws ApplicationException {
	if (!checkService(service)) {
	    return null;
	}	
	return ((EntityService) service).findHeaderById(id);
    }    
    
    /**
     * Store the entity
     * @param service
     * @param entity
     * @throws ApplicationException
     */
    public void storeEntity(Object service, Object entity) throws ApplicationException {
	if (!checkService(service)) {
	    return;
	}	
	((EntityService) service).store(entity);
    }
    
    /**
     * Remove the entity by id
     * @param service
     * @param id
     * @throws ApplicationException
     */
    public void removeEntityById(Object service, Serializable id) throws ApplicationException {
	if (!checkService(service)) {
	    return;
	}	
	((EntityService) service).removeById(id);	
    }
    
    /**
     * Remove the entity
     * @param service
     * @param entity
     * @throws ApplicationException
     */
    public void removeEntity(Object service, Object entity) throws ApplicationException {
	if (!checkService(service)) {
	    return;
	}	
	((EntityService) service).remove(entity);	
    }
    
    
    /**
     * Load the entity by criteria
     * @param service
     * @param findCriteria
     * @return
     * @throws ApplicationException
     */
    public Object loadEntityByCriteria(Object service, Object[] findCriteria) throws ApplicationException {
	//TODO: Not implemented
	return null;
    }
    
    
    /**
     * Load the entity by criteria
     * @param service
     * @param findCriteria
     * @return
     * @throws ApplicationException
     */
    public Object loadEntityByCriteria(Object service, Map findCriteria) throws ApplicationException {
	//TODO: Not implemented
	return null;
    }
    
    
    /**
     * Find all entities
     * @param service
     * @return entities
     * @throws ApplicationException
     */
    public List findAll(Object service) throws ApplicationException {
	if (!checkService(service)) {
	    return null;
	}	
	return ((EntityService) service).findAll();
    }
    
    public List findByCriteria(Object service, Criteria criteria) throws ApplicationException {
	return ((EntityService) service).findByCriteria(criteria);
    }
    
    
    /**
     * Find entities by criteria
     * @param service
     * @param findCriteria
     * @return entities
     * @throws ApplicationException
     */
    public List findByCriteria(Object service, Object[] findCriteria) throws ApplicationException {
	//TODO: Not implemented	
	return null;
    }
    
    
    /**
     * Find entities by criteria
     * @param service
     * @param findCriteria
     * @return entities
     * @throws ApplicationException
     */
    public List findByCriteria(Object service, Map findCriteria) throws ApplicationException {
	//TODO: Not implemented
	return null;
    }
    
    
    /**
     * Get id of entity
     * @param entity
     * @return id
     */
    public Serializable getEntityId(Object entity) {
	if (entity == null) {
	    return null;
	}
	if (entity instanceof IEntityObject) {
	    return (Serializable) ((IEntityObject) entity).getId();
	}
	return null;//entity.hashCode();
    }
     
    public Object newEntity(Class entityClass) throws ApplicationException {
	if (entityClass == null) {
	    return null;
	}
	try {
	    return entityClass.newInstance(); 
	} catch (Exception ex) {
	    return null;
	}
	
    }
    
    /**
     * Returns true if service is not null and service implements <code>EntityService</code> 
     * @param service
     * @return flag
     */
    private boolean checkService(Object service) {
	return (service != null && (service instanceof EntityService));
    }
    
    
    public void setCreated(Object entity) {
	if (entity == null) {
	    return;
	}
	if (entity instanceof Statable) {
	    ((Statable) entity).setCreated();
	}
    }
    
    public void setDeleted(Object entity) {
	if (entity == null) {
	    return;
	}
	if (entity instanceof Statable) {
	    ((Statable) entity).setDeleted();
	}	
    }
    
    public void setModified(Object entity) {
	if (entity == null) {
	    return;
	}
	if (entity instanceof Statable) {
	    ((Statable) entity).setModified();
	}	
    }
    
    public List<IEntityConfig> getEntityConfigListByType(String type) {
	return findEntityConfigList(type, false);
    }

    public List<IEntityConfig> getEntityConfigListByTypeAndForm(String type) {
	return findEntityConfigList(type, true);
    }

    public List<IEntityConfig> findEntityConfigList(String type, boolean isForm) {
//	if (type == null) {
//	    return null;
//	}
	try {
	    List<IEntityConfig> entities = null;
	    if (isForm) {
		entities = getSystemEntityService().findByEntityTypeAndForm(type);
	    } else {
		entities = getSystemEntityService().findByEntityType(type);
	    }
	    sortEntities(entities);
	    return entities;
	} catch (Throwable ex) {
	    logger.error(ex);
	}
	return null;
	
    }
    
    private SystemEntityService getSystemEntityService() {
	return ((SystemEntityService) ServiceFactory.getService(SystemEntityService.class));
    }
    
    
    private void sortEntities(List<IEntityConfig> entities) {
	    
	    Collections.sort(entities, new Comparator<IEntityConfig>() {
		public int compare(IEntityConfig e1, IEntityConfig e2) {
		    if (e1 == null) {
			return -1;
		    }
		    if (e2 == null) {
			return 1;
		    }
		    String s1 = e1.toString();
		    String s2 = e2.toString();
		    if (s1 == null) {
			return -1;
		    }
		    if (s2 == null) {
			return 1;
		    }		    
		    return s1.compareTo(s2);
		}
	    });
    }
    
}
