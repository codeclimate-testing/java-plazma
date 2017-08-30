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
package org.plazmaforge.bs.web.client;

import org.plazmaforge.bs.ApplicationEntityCreator;
import org.plazmaforge.framework.uwt.gxt.core.XEntityCreator;

import com.google.gwt.core.client.GWT;

/**
 * @author ohapon
 *
 */
public class WebApplicationEntityCreator extends ApplicationEntityCreator {

    private XEntityCreator innerEntityCreator;
    
    @Override
    protected Object createEntity(String type) {
 	if (innerEntityCreator == null) {
	    innerEntityCreator = GWT.create(XEntityCreator.class);
	}
	Object entity = innerEntityCreator.createEntity(type);
	return entity;
    }
}