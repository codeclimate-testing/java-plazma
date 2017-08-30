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

package org.plazmaforge.framework.platform.structure.impl;

import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.service.ServiceFactory;
import org.plazmaforge.framework.platform.service.CompressionExecutor;
import org.plazmaforge.framework.platform.structure.Package;


/**
 * <code>DefaultPackage</code> implements <code>Package</code>
 * 
 */
public class DefaultPackage implements Package {

    private String id;

    private String code;

    private String name;

    private String description;

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getId() {
	// Stub
	if (id == null) {
	    id = "PKG:" + this.hashCode() + this.getClass();
	}
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

    public void init() throws ApplicationException {

    }

    public CompressionExecutor getCompressionExecutor() {
	return null;
    }

    protected CompressionExecutor getCompressionExecutor(Class serviceInterface) {
	return (CompressionExecutor) ServiceFactory
		.getService(serviceInterface);
    }

}
