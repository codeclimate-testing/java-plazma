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

/* 
 * Created on 08.08.2007
 *
 */

package org.plazmaforge.framework.core.data;

import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.ext.model.BaseEntity;


/** 
 * @author Oleh Hapon
 * $Id: Enumeration.java,v 1.3 2010/12/05 07:55:59 ohapon Exp $
 */

public class Enumeration extends BaseEntity implements IEnumeration {

    private String code;

    private String name;

    private String description;
    
    private IEntityConfig entity;
    
    public Integer getAttributeOwnerId() {
	return getId();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IEntityConfig getEntity() {
        return entity;
    }

    public void setEntity(IEntityConfig entity) {
        this.entity = entity;
    }
    
    public IEntityConfig getAttributeEntity() {
	return getEntity();
    }
    
    
}
