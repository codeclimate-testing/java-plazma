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
/**
 * @author Oleh Hapon
 * Date: 12.12.2004
 * Time: 16:35:21
 * $Id: EntityEnvironment.java,v 1.5 2010/12/05 07:55:56 ohapon Exp $
 */
package org.plazmaforge.framework.platform;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.plazmaforge.framework.config.configurer.AssociationConfigurer;
import org.plazmaforge.framework.config.object.IAssociationConfig;
import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.association.Association;
import org.plazmaforge.framework.ext.association.AssociationCreator;
import org.plazmaforge.framework.ext.association.AssociationManager;
import org.plazmaforge.framework.ext.config.EntityManager;
import org.plazmaforge.framework.ext.service.Service;
import org.plazmaforge.framework.platform.service.cache.ServiceCacheEnvironment;


public class EntityEnvironment extends PlatformEntityEnvironment {

    private static EntityEnvironment ourInstance;
    
    private final static Logger logger = Logger.getLogger(EntityEnvironment.class);
    
    static {
	initAssociationManager();
    }

    public synchronized static EntityEnvironment getInstance() {
	if (ourInstance == null) {
	    ourInstance = new EntityEnvironment();
	}
	return ourInstance;
    }
    
    public static void initAssociationManager() {
	try {
	    // Initialize association manager
	    if (AssociationManager.getAssociationCreator() != null) {
		return;
	    }
	    Object object = getInstanceByProperty(PlatformContext.ASSOCIATION_CREATOR_CLASS);
	    if (object == null) {
		return;
	    }
	    AssociationCreator creator = (AssociationCreator) object;
	    AssociationManager.setAssociationCreator(creator);
	} catch (ApplicationException e) {
	    logError("Error initialize AssociationCreator", e);
	}
    }
    
    
    
    private EntityEnvironment() {
    }

    public static void addEntity(IEntityConfig entity) {
	EntityManager.addEntity(entity);
    }

    public static IEntityConfig getEntityById(String id) {
	if (id == null) {
	    return null;
	}
	return EntityManager.getEntityById(id);
    }

    public static String getEntityNameById(String id) {
	IEntityConfig entity = getEntityById(id);
	if (entity == null) {
	    return null;
	}
	return entity.getName();
    }

    public static boolean isMasterEntity(String id) {
	IEntityConfig entity = getEntityById(id);
	if (entity == null) {
	    return false;
	}
	return entity.isMaster();
    }

    
    public static void loadContext() throws ApplicationException {
	
	logInfo("");
	logInfo("Loading EntityContext...");
	
	ISystemEntityService service = (ISystemEntityService) getServiceByProperty(PlatformContext.SYSTEM_ENTITY_SERVICE_CLASS);
	if (service == null) {
	    logError("SystemEntityService not found");
	}
	List<IEntityConfig> entities = service.getEntities();
	
	// Add all entities
	addEntities(entities);
	
	// Add global associations
	addGlobalAssociations();
	
	// Add entity associations
	addEntityAssociations(entities);
	
	//addEntityCaches(entities);
	
	logInfo("EntityContext loaded. Entity count = [" + entities.size() + "]");

    }

    private static void addEntities(List<IEntityConfig> entities) {
	EntityManager.addEntities(entities);
    }

    private static void addEntityCache(IEntityConfig entity, Association association) {
	if (entity == null || !entity.isSupportCache() || !entity.isCache()) {
	    return;
	}
	
	//Association association = createAssociationByEntity(entity);
	if (association == null) {
	    return;
	}
	
	Class serviceClass = association.getElementByType(Service.class);
	if (serviceClass == null) {
	    return;
	}
	String serviceClassName = serviceClass.getName();
	long cacheExpireTime = entity.getCacheExpireTime();
	ServiceCacheEnvironment.addServiceCache(serviceClassName, cacheExpireTime);
	
	logInfo("Add service cache = [" + serviceClassName + " (" + cacheExpireTime + ") sec.]");
    }

    private static Association createAssociationByEntity(IEntityConfig entity) {
	try {
	    if (entity == null) {
		return null;
	    }
	    return AssociationManager.createAssociationByEntity(entity);
	} catch (Throwable ex) {
	    return null;
	}
	
    }
    
    private static void addEntityAssociations(List<IEntityConfig> entities) {
	if (entities == null) {
	    return;
	}
	for (IEntityConfig entity : entities) {
	    Association association = createAssociationByEntity(entity);
	    addEntityCache(entity, association);
	}
    }

    /**
     * Add global associations from configuration
     */
    private static void addGlobalAssociations() {
	try {
	    
	    // Get AssociationConfigurer
	    AssociationConfigurer configurer = null; // (AssociationConfigurer) PlatformEnvironment.getConfigurer(AssociationConfigurer.NAME);
	    if (configurer == null) {
		return;
	    }
	    List<IAssociationConfig> objects = configurer.getObjects();
	    if (objects == null) {
		return;
	    }
	    Iterator<IAssociationConfig> itr = objects.iterator();

	    // Add associations to manager
	    while (itr.hasNext()) {
		IAssociationConfig c = (IAssociationConfig) itr.next();
		AssociationManager.addAssociationByBeanClass(c.getClassName());
	    }
	} catch (ApplicationException ex) {
	    logError("Creation global associations error", ex);
	}	
    }

    
    protected static void logInfo(Object message) {
	logInfo(logger, message);
    }
    
    protected static void logError(Object message) {
	logError(logger, message);
    }

    protected static void logError(Object message, Throwable t) {
	logError(logger, message, t);
    }

    
}
