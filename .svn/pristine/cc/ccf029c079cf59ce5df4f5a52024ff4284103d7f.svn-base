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
package org.plazmaforge.bsolution.base.common.beans;

import org.plazmaforge.framework.config.object.IEntityConfig;


/**
 * @author Oleh Hapon Date: 11.12.2004 Time: 17:25:37 $Id: Ownerable.java,v 1.2 2010/04/28 06:24:17 ohapon Exp $
 */
public class Ownerable implements IOwnerable {

    private Integer ownerId;

    private IEntityConfig entity;

    private String fullName;

    public IEntityConfig getEntity() {
	return entity;
    }

    public void setEntity(IEntityConfig entity) {
	this.entity = entity;
    }
    
    
    public String getEntityConfigId() {
	return getEntity() == null ? null : getEntity().getConfigId();
    }

//    public String getEntityCode() {
//	return getEntity() == null ? null : getEntity().getConfigSimpleCode();
//    }
//
//    public String getEntityName() {
//	return getEntity() == null ? null : getEntity().getConfigName();
//    }  
    
    

    public Integer getOwnerId() {
	return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
	this.ownerId = ownerId;
    }

    public String getFullName() {
	return fullName;
    }

    public void setFullName(String fullName) {
	this.fullName = fullName;
    }
}
