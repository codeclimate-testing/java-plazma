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

package org.plazmaforge.framework.client.forms;

import java.io.Serializable;

import org.plazmaforge.framework.config.ConfigUtils;
import org.plazmaforge.framework.ext.association.Association;


/** 
 * @author Oleh Hapon
 *
 */

public class EntityModel implements IEntityModel {
    
    
    /**
     * The entity of model.
     */
    private Object entity;
    
    /**
     * The parent of entity.
     */
    private Object parentEntity;
    
    
    /**
     * The id of entity.
     */
    private Serializable entityId;
    
    /**
     * The id of parent entity.
     */
    private Serializable parentEntityId;

    
    /**
     * The class of entity.
     */
    private Class entityClass;
    
    /**
     * The name of class of entity.
     */
    private String entityClassName;
    
    /**
     * The name of entity.
     */
    private String entityName;    
    
    /**
     * The name of class of parent entity.
     */
    private Class parentEntityClass;    

    
    /**
     * The service name of entity.
     */
    private String entityServiceName;  
    
    /**
     * The service class of entity.
     */
    private Class entityServiceClass;
    
    /**
     * The service of entity.
     */
    private Object entityService;
    
    /**
     * The class of form of entity.
     */
    private Class entityFormClass;    
    
    /**
     * The special entity code.
     */
    private String entityCode;
    
    /**
     * Association
     */
    private Association association;
    
    public Object getEntity() {
        return entity;
    }



    public void setEntity(Object entity) {
        this.entity = entity;
    }






    public Object getParentEntity() {
        return parentEntity;
    }



    public void setParentEntity(Object parentEntity) {
        this.parentEntity = parentEntity;
    }
    


    public Serializable getEntityId() {
        return entityId;
    }



    public void setEntityId(Serializable entityId) {
        this.entityId = entityId;
    }

    
    public Serializable getParentEntityId() {
        return parentEntityId;
    }    


    public void setParentEntityId(Serializable parentEntityId) {
        this.parentEntityId = parentEntityId;
    }
    
    
    
    
    
    public Class getEntityClass() {
        return entityClass;
    }



    public void setEntityClass(Class entityClass) {
        this.entityClass = entityClass;
    }



    public String getEntityClassName() {
        return entityClassName;
    }



    public void setEntityClassName(String entityClassName) {
        this.entityClassName = entityClassName;
    }

    public String getEntityName() {
        return entityName;
    }



    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
    
    
    public Class getParentEntityClass() {
        return parentEntityClass;
    }



    public void setParentEntityClass(Class parentEntityClass) {
        this.parentEntityClass = parentEntityClass;
    }



    public Object getEntityService() {
        return entityService;
    }


    public void setEntityService(Object entityService) {
        this.entityService = entityService;
    }



    public Class getEntityServiceClass() {
        return entityServiceClass;
    }



    public void setEntityServiceClass(Class entityServiceClass) {
        this.entityServiceClass = entityServiceClass;
    }



    public String getEntityServiceName() {
        return entityServiceName;
    }

    
    public void setEntityServiceName(String entityServiceName) {
        this.entityServiceName = entityServiceName;
    }
    
    
    public Class getEntityFormClass() {
        return entityFormClass;
    }



    public void setEntityFormClass(Class entityForm) {
        this.entityFormClass = entityForm;
    }



    public String getEntityCode() {
	// If entity code is null we try generate entity code by entity class
	if (entityCode == null && entityClass != null) {
	    entityCode = generateEntityCode(); 
	}
        return entityCode;
    }

    protected String generateEntityCode() {
	if (entityClass == null) {
	    return null;
	}
	String className = entityClass.getName();
	int pos = className.lastIndexOf(".");
	if (pos > -1) {
	    className = className.substring(pos + 1);
	}
	return ConfigUtils.generateIdByCode(className);
    }


    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }



    public Association getAssociation() {
        return association;
    }



    public void setAssociation(Association association) {
        this.association = association;
    }
    
    

}
