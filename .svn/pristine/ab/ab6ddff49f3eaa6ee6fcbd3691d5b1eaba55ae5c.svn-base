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
 * Created on 27.03.2008
 *
 */

package org.plazmaforge.framework.report.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * @author Oleh Hapon
 * $Id: DataEntity.java,v 1.2 2010/04/28 06:34:33 ohapon Exp $
 */

public class DataEntity {

    private Serializable id;
    
    private String name;
    
    private List<DataAttribute> attributes = new ArrayList<DataAttribute>();
    private Map<String, DataAttribute> attributeMap = new HashMap<String, DataAttribute>();
    
    private String status;
    
    
    public Serializable getId() {
        return id;
    }

    public void setId(Serializable id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAttribute(DataAttribute attribute) {
	attributes.add(attribute);
	attributeMap.put(attribute.getName(), attribute);
    }
    
    public DataAttribute getAttribute(String name) {
	return attributeMap.get(name);
    }
    
    public Object getValue(String name) {
	if ("$VALUES".equals(name)) {
	    if (attributes.size() == 0) {
		return null;
	    }
	    StringBuffer buf = new StringBuffer();
	    for (int i = 0; i < attributes.size() ; i++) {
		if (i > 0) {
		    buf.append(", ");
		}
		buf.append(" " + attributes.get(i).getValue());
	    }
	    return buf.toString();
	} else if ("$STATUS".equals(name)) {
	    return status;
	}
	DataAttribute attribute = getAttribute(name);
	return attribute == null ? null : attribute.getValue();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    

}
