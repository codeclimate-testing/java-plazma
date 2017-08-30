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

package org.plazmaforge.framework.platform.service;

import java.io.Serializable;

import org.plazmaforge.framework.ext.security.UserContext;

public class InvokeContext implements Serializable {

    private String serviceName;

    private Class serviceClass;

    private String methodName;

    private Class[] methodParamsType;

    private Serializable[] args;
    

    private UserContext userContext;
    
    

    public Serializable[] getArgs() {
	return args;
    }

    public void setArgs(Serializable[] args) {
	this.args = args;
    }

    public String getMethodName() {
	return methodName;
    }

    public void setMethodName(String methodName) {
	this.methodName = methodName;
    }

    public Class[] getMethodParamsType() {
	return methodParamsType;
    }

    public void setMethodParamsType(Class[] methodParamsType) {
	this.methodParamsType = methodParamsType;
    }

    public Class getServiceClass() {
	return serviceClass;
    }

    public void setServiceClass(Class serviceClass) {
	this.serviceClass = serviceClass;
    }

    public String getServiceName() {
	return serviceName;
    }

    public void setServiceName(String serviceName) {
	this.serviceName = serviceName;
    }

    public UserContext getUserContext() {
	return userContext;
    }

    public void setUserContext(UserContext userContext) {
	this.userContext = userContext;
    }

}
