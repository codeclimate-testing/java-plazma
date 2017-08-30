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

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import java.rmi.RemoteException;

import org.plazmaforge.framework.core.exception.AccessDeniedException;
import org.plazmaforge.framework.ext.security.UserContextHolder;
import org.plazmaforge.framework.ext.service.ServiceLocator;
import org.plazmaforge.framework.platform.service.InvokeContext;
import org.plazmaforge.framework.platform.service.InvokeData;



/** 
 * @author Oleh Hapon
 * $Id: AbstractServiceInvoker.java,v 1.4 2010/12/05 07:51:26 ohapon Exp $
 */

public abstract class AbstractServiceInvoker {

    protected abstract ServiceLocator getServiceLocator();
    
    public Object invoke(InvokeData data) throws RemoteException {
	try {
	    ByteArrayInputStream bais = new ByteArrayInputStream(data.getData());
	    ObjectInputStream ios = new ObjectInputStream(bais);
	    InvokeContext context = (InvokeContext) ios.readObject();

	    ServiceLocator servicLocator = getServiceLocator();

	    Object service = servicLocator.getService(context.getServiceClass());
	    
	    Method method = context.getServiceClass().getMethod(context.getMethodName(), context.getMethodParamsType());
	    
	    // Set secure context
	    if (context.getUserContext() != null) {
		UserContextHolder.setContext(context.getUserContext());
	    }
	    
	    return method.invoke(service, context.getArgs());

	} catch (Throwable ex) {
    
	    Throwable cause = ex.getCause();
	    if (cause != null && cause instanceof org.springframework.security.access.AccessDeniedException) {
		cause = new AccessDeniedException(AccessDeniedException.ACCESS_DENIED);
	    }
	    throw new RemoteException("InvokeException", cause);
	}
    }
    
}
