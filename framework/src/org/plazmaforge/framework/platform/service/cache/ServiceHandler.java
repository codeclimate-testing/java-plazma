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
 * Created on 15.09.2008
 *
 */

package org.plazmaforge.framework.platform.service.cache;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/** 
 * @author Oleh Hapon
 * $Id: ServiceHandler.java,v 1.3 2010/04/28 06:34:32 ohapon Exp $
 */

public class ServiceHandler implements InvocationHandler {

    private Object original;

    private ServiceCache serviceCache;

    public ServiceHandler(Object original, ServiceCache serviceCache) {
	this.original = original;
	this.serviceCache = serviceCache;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

	if (!serviceCache.acceptMethod(method)) {
	    serviceCache.sendMessage(method);
	    return getMethodValue(method, args);
	}

	Object methodValue = null;

	if (serviceCache.isDirty()) {
	    methodValue = getMethodValue(method, args);
	    serviceCache.setTime(System.currentTimeMillis() / 1000);
	    serviceCache.setMethodValue(methodValue);
	    serviceCache.setDirty(false);
	} else {
	    long time = System.currentTimeMillis() / 1000; // in second
	    if ((time - serviceCache.getTime()) > serviceCache.getExpireTime()) { // in second

		methodValue = getMethodValue(method, args);
		serviceCache.setTime(System.currentTimeMillis() / 1000); // in second
		serviceCache.setMethodValue(methodValue);

	    } else {
		methodValue = serviceCache.getMethodValue();
	    }
	}

	return methodValue;
    }

    protected Object getMethodValue(Method method, Object[] args) throws Throwable {
	return method.invoke(original, args);
    }

}
