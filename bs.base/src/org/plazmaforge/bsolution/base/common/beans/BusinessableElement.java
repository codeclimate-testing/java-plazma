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

import org.plazmaforge.framework.ext.model.BaseEntity;


public class BusinessableElement extends BaseEntity implements IBusinessable {

    IBusinessableOwner owner;

    public IBusinessableOwner getOwner() {
	return owner;
    }

    public void setOwner(IBusinessableOwner owner) {
	this.owner = owner;
    }

    public BusinessableElement() {

    }

    public BusinessableElement(IBusinessableOwner owner) {
	this.owner = owner;
    }

    public Integer getOwnerId() {
	return owner.getId();
    }

    public void setOwnerId(Integer id) {
	/* stub */
    }  
    
//    public IEntityConfig getEntity() {
//	return owner.getEntity();
//    }
//    
//    public String getEntityId() {
//	return owner.getEntity().getId();
//    }
//    
//    public String getEntityConfigId() {
//	return owner.getEntityConfigId();
//    }
    
//    public String getEntityCode() {
//	return owner.getEntityCode();
//    }    
    
//    public String getEntityName() {
//	return owner.getEntityName();
//    }    
    
    public void setEntityId(String id) {
	/* stub */
    }  
    
    public String getFullName() {
	return owner.getBusinessableName();
    }

    public void setFullName(String name) {
	/* stub */
    }

    public Integer getBusinessableId() {
	return getId();
    }

}