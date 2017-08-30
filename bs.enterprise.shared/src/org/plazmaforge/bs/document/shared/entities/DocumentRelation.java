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

package org.plazmaforge.bs.document.shared.entities;

import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.ext.model.BaseEntity;

/**
 * 
 * @author ohapon
 *
 */
public class DocumentRelation extends BaseEntity {

    private static final long serialVersionUID = -9035993676272086208L;
    

    private DocumentType parentType;
    
    private DocumentType childType;
    
    private String creatorClassName;
   

    public DocumentType getParentType() {
        return parentType;
    }

    public void setParentType(DocumentType parentType) {
        this.parentType = parentType;
    }

    public IEntityConfig getParentTypeEntity() {
	return parentType == null ? null : parentType.getEntity();
    }

    public String getParentTypeCode() {
	return parentType == null ? null : parentType.getCode();
    }

    public String getParentTypeName() {
	return parentType == null ? null : parentType.getName();
    }

    public DocumentType getChildType() {
        return childType;
    }

    public IEntityConfig getChildTypeEntity() {
	return childType == null ? null : childType.getEntity();
    }

    public void setChildType(DocumentType childType) {
        this.childType = childType;
    }

    public String getChildTypeCode() {
	return childType == null ? null : childType.getCode();
    }

    public String getChildTypeName() {
	return childType == null ? null : childType.getName();
    }
    
    public String getCreatorClassName() {
        return creatorClassName;
    }

    public void setCreatorClassName(String creatorClassName) {
        this.creatorClassName = creatorClassName;
    }
    
}
