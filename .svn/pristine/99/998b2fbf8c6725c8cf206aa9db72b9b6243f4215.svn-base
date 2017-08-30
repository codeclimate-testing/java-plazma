/*
 * Copyright (C) 2012-2013 Oleh Hapon ohapon@users.sourceforge.net
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

/**
 * 
 */
package org.plazmaforge.bs;

import java.util.HashSet;
import java.util.Set;

import org.plazmaforge.framework.util.ClassUtils;

/**
 * @author ohapon
 *
 */
public class DesktopApplicationEntityCreator extends ApplicationEntityCreator {

    private Set<String> errorSet = new HashSet<String>();
    
    protected Object createEntity(String type) {
	if (type == null) {
	    // TODO: ERROR: Type is null.
	    return null;
	}
	if (errorSet.contains(type)) {
	    // TODO: ERROR: Type is error
	    return null;
	}
	Object entity = ClassUtils.newSafeInstance(type);
	if (entity == null) {
	    errorSet.add(type);
	    // TODO: ERROR: Can't create instance by type={type}
	    return null;
	}
	return entity;

    }
    
}
