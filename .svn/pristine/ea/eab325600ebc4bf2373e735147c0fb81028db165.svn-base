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

import org.plazmaforge.bs.base.shared.entities.BusinessableElement;
import org.plazmaforge.bs.base.shared.entities.IBusinessableOwner;

/**
 * 
 * @author ohapon
 *
 */
public abstract class AbstractStructurable extends OrganizableDictionary implements IStructurable, IBusinessableOwner {

    private static final long serialVersionUID = -786258874581100376L;


    private Integer parentId;


    private BusinessableElement businessableElement;

    public AbstractStructurable() {
	businessableElement = createBusinessableElement();
	businessableElement.setOwner(this);
    }

    public Integer getParentId() {
	return parentId;
    }

    public void setParentId(Integer parentId) {
	this.parentId = parentId;
    }


    public Integer getBusinessableId() {
	return getId();
    }
    
    public String getBusinessableName() {
	return getFullName();
    }
    
    public Integer getOwnerId() {
	return getId();
    }

    public BusinessableElement getBusinessableElement() {
	return businessableElement;
    }

    public void setBusinessableElement(BusinessableElement businessableElement) {
	this.businessableElement = businessableElement == null ? createBusinessableElement() : businessableElement;
	this.businessableElement.setOwner(this);
    }
    
    protected BusinessableElement createBusinessableElement() {
	return new BusinessableElement();
    }

    public String getFullName() {
	return super.getFullName() == null ? getName() : super.getFullName();
    }

}
