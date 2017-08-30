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
 * Created on 3 Тра 2007
 *
 */

package org.plazmaforge.framework.platform.service.impl;

import java.lang.reflect.Proxy;

import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.core.exception.ServiceNotFoundException;
import org.plazmaforge.framework.ext.service.AbstractServiceLocator;
import org.plazmaforge.framework.ext.service.ServiceFactory;
import org.plazmaforge.framework.ext.service.impl.GenericEntityServiceImpl;
import org.plazmaforge.framework.platform.service.ServiceInvoker;
import org.plazmaforge.framework.platform.service.ServiceProxy;



/** 
 * @author Oleh Hapon
 * $Id: AbstractInvokeServiceLocator.java,v 1.3 2010/12/05 07:51:26 ohapon Exp $
 */

public abstract class AbstractInvokeServiceLocator extends AbstractServiceLocator {

    protected abstract ServiceInvoker getServiceInvoker() throws Exception;
    
    protected abstract ServiceProxy getServiceProxy(ServiceInvoker invoker);
    
    
    
    
    public Object getService(Class<?> serviceInterface) {
	try {
	    ServiceInvoker invoker = getServiceInvoker();
	    ServiceProxy proxy = getServiceProxy(invoker);
	    proxy.setServiceName(getServiceNameByClass(serviceInterface));
	    proxy.setServiceClass(serviceInterface);
	    Class[] interfaces = new Class[] { serviceInterface };
	    return Proxy.newProxyInstance(serviceInterface.getClassLoader(), interfaces, proxy);
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return null;

    }

    public Object getServiceByClass(String serviceClassName) {
	try {
	    Class<?> serviceClass = getLazyClass(serviceClassName);
	    if (serviceClass != null) {
		// Service class is real
		return getService(serviceClass);
	    }
	    serviceClass = GenericEntityServiceImpl.class;
	    GenericEntityServiceImpl service = (GenericEntityServiceImpl) getService(serviceClass);
	    return service;
	} catch (Exception ex) {
	    throw new ServiceNotFoundException(ex);
	}
    }
    
    public void init() throws ApplicationException {
	ServiceFactory.setServiceLocator(this);
	loadConfigurers();
    }

}
