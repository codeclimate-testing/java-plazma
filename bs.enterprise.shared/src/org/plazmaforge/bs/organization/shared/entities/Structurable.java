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

package org.plazmaforge.bs.organization.shared.entities;

import org.plazmaforge.framework.config.object.EntityConfig;

/**
 * 
 * @author ohapon
 *
 */
public class Structurable extends OrganizableDictionary implements IStructurable {

    private static final long serialVersionUID = 1341496110924593539L;
    
    private Integer ownerId;
    
    private EntityConfig entity;
     
    private Integer parentId;


    
    public EntityConfig getEntity() {
        return entity;
    }
    
    public void setEntity(EntityConfig entity) {
        this.entity = entity;
    }

    public String getEntityId() {
        return entity == null ? null : entity.getId();
    }
    
    public String getEntityName() {
	return entity == null ? null : entity.getName();
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
