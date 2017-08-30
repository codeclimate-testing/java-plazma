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

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Method;

import org.plazmaforge.framework.core.exception.AccessDeniedException;
import org.plazmaforge.framework.ext.security.UserContextHolder;
import org.plazmaforge.framework.platform.service.InvokeContext;
import org.plazmaforge.framework.platform.service.InvokeData;
import org.plazmaforge.framework.platform.service.ServiceInvoker;



/** 
 * @author Oleh Hapon
 * $Id: DefaultServiceProxy.java,v 1.4 2010/12/05 07:51:26 ohapon Exp $
 */

public class DefaultServiceProxy extends AbstractServiceProxy {

    private ServiceInvoker invoker;

    public DefaultServiceProxy(ServiceInvoker invoker) {
	this.invoker = invoker;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

	InvokeContext context = new InvokeContext();
	context.setServiceName(getServiceName());
	context.setServiceClass(getServiceClass());
	context.setMethodName(method.getName());
	context.setMethodParamsType(method.getParameterTypes());

	if (UserContextHolder.getContext() != null) {
	    context.setUserContext(UserContextHolder.getContext());
	}

	if (args != null) {
	    Serializable[] sargs = new Serializable[args.length];
	    for (int i = 0; i < sargs.length; i++) {
		sargs[i] = (Serializable) args[i];
	    }
	    context.setArgs(sargs);
	}

	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	ObjectOutputStream oos = new ObjectOutputStream(baos);

	oos.writeObject(context);

	byte[] data = baos.toByteArray();
	InvokeData invokeData = new InvokeData();
	invokeData.setData(data);
	try {
	    return invoker.invoke(invokeData);
	} catch (Throwable th) {
	    Throwable cause = th.getCause();
	    if (cause instanceof AccessDeniedException) {
		throw cause;
	    }
	    throw th;
	}
    }
    

}