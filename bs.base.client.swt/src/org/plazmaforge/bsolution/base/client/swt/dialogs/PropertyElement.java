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
 * Created on 15.02.2008
 *
 */

package org.plazmaforge.bsolution.base.client.swt.dialogs;

/** 
 * @author Oleh Hapon
 * $Id: PropertyElement.java,v 1.2 2010/04/28 06:31:03 ohapon Exp $
 */

public class PropertyElement {

    public static final int NONE = 0;
    
    public static final int CREATED = 1;
    
    public static final int MODIFIED = 2;
    
    public static final int DELETED = -1;
    
    
    
    private int state = NONE;
    
    private String id;
    
    private String name;
    
    private String value;

    
    public PropertyElement() {
	super();
    }

    public PropertyElement(String name, String value) {
	super();
	this.name = name;
	this.value = value;
	
	//TODO
	this.id = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    
    public void setCreated() {
	state = CREATED;
    }
    
    public void setModified() {
	state = MODIFIED;
    }
    
    public void setDeleted() {
	state = DELETED;
    }
    
    public String toString() {
	return name == null ? super.toString() : name;
    }
}
