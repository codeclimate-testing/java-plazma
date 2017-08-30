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

package org.plazmaforge.bsolution.organization.common.beans;

import org.plazmaforge.framework.config.object.EntityConfig;


/**
 * @author Oleh Hapon
 * Date: 17.12.2004
 * Time: 10:11:08
 * $Id: Structurable.java,v 1.2 2010/04/28 06:24:16 ohapon Exp $
 */
public class Structurable extends OrganizableDictionary implements IStructurable {

    private Integer ownerId;
    private EntityConfig entity;
     
    private Integer parentId;



    
    public EntityConfig getEntity() {
        if (entity == null) {
            entity = new EntityConfig();
        }
        return entity;
    }
    
    public void setEntity(EntityConfig entity) {
        this.entity = entity == null ? new EntityConfig(): entity;
    }

    public String getEntityId() {
        return getEntity().getId();
    }
    
    public String getEntityConfigId() {
	return getEntity() == null ? null : getEntity().getConfigId();
    }

    public String getEntityCode() {
	return getEntity() == null ? null : getEntity().getConfigSimpleCode();
    }

    public String getEntityName() {
	return getEntity() == null ? null : getEntity().getConfigName();
    }  

    public void setEntityId(String entityId) {
        getEntity().setId(entityId);
    }
    
    public void setEntityCode(String entityCode) {
        getEntity().setCode(entityCode);
    }

    public void setEntityName(String entityName) {
        getEntity().setName(entityName);
    }
    
    public String getFullName() {
        return getName();
    }

    public void setFullName(String fullName) {
        setName(fullName);
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerableId) {
        this.ownerId = ownerableId;
    }

    public Integer getBusinessableId() {
        return getId();
    }

    public void setBusinessableId(Integer businessableId) {
        setId(businessableId);
    }

    public Integer getParentId() {
        return parentId;
    }
    
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    
}
