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

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/** 
 * @author Oleh Hapon
 * $Id: ServiceCache.java,v 1.4 2010/04/28 06:34:32 ohapon Exp $
 */

public class ServiceCache {
    
    
    public final long MIN_EXPIRE_TIME = 60; // second

    private String serviceClassName;

    private long expireTime = MIN_EXPIRE_TIME; // (delta) second

    private long time;

    private boolean dirty = true;

    private Object methodValue;

    private List<String> cacheMethods = new ArrayList<String>();
    
    private List<String> resetMethods = new ArrayList<String>();
    
    
    public ServiceCache() {
	super();
	
	cacheMethods.add("findAll()");
	
	resetMethods.add("create*");
	resetMethods.add("remove*");
	resetMethods.add("store*");
    }

    public void sendMessage(Method method) {
	
	String name = method.getName();

	// TODO: Stub
	// Must use isResetMethod
	if (name.startsWith("create") || name.startsWith("remove") || name.startsWith("store")) {
	    dirty = true;
	}
    }

    public boolean acceptMethod(Method method) {
	// TODO: Stub.
	// Must use isCacheMethod
	if ("findAll".equals(method.getName()) && isEmptyParameters(method)) {
	    return true;
	}
	return false;
    }

    protected boolean isCacheMethod(Method method) {
	if (method == null) {
	    return false;
	}
	if (cacheMethods == null || cacheMethods.isEmpty()) {
	    return false;
	}
	String fullMethodName = getFullMethodName(method);
	if (fullMethodName == null) {
	    return false;
	}
	for (String name : cacheMethods) {
	    if (name == null) {
		continue;
	    }
	    if (name.equals(fullMethodName)) {
		return true;
	    }
	}
	return false;
    }
    
    
    protected boolean isResetMethod(Method method) {
	if (method == null) {
	    return false;
	}
	if (resetMethods == null || resetMethods.isEmpty()) {
	    return false;
	}
	//String methodName = method.getName();
	String fullMethodName = getFullMethodName(method);
	if (fullMethodName == null) {
	    return false;
	}
	for (String name : resetMethods) {
	    if (name == null) {
		continue;
	    }
	    int len = name.length();
	    if (name.endsWith("*")) {
		if (len > 1 && fullMethodName.startsWith(name.substring(0,  len - 1))) {
		   return true; 
		}
	    } else if (name.equals(fullMethodName)) {
		return true;
	    }
	}
	return false;
    }
    
    protected boolean isEmptyParameters(Method method) {
	Class[] c = method.getParameterTypes();
	if (c == null) {
	    return true;
	}
	return c.length == 0;
    }

    public Object getMethodValue() {
        return methodValue;
    }

    public void setMethodValue(Object data) {
        this.methodValue = data;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime < MIN_EXPIRE_TIME ? MIN_EXPIRE_TIME : expireTime;
    }

    public boolean isDirty() {
        return dirty;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getServiceClassName() {
        return serviceClassName;
    }

    public void setServiceClassName(String serviceClassName) {
        this.serviceClassName = serviceClassName;
    }

    public List<String> getCacheMethods() {
	if (cacheMethods == null) {
	    cacheMethods = new ArrayList<String>();
	}
        return cacheMethods;
    }

    public void setCacheMethods(List<String> cacheMethods) {
        this.cacheMethods = cacheMethods;
    }

    public List<String> getResetMethods() {
	if (resetMethods == null) {
	    resetMethods = new ArrayList<String>();
	}
	
        return resetMethods;
    }

    public void setResetMethods(List<String> resetMethods) {
        this.resetMethods = resetMethods;
    }

    protected String getFullMethodName(Method method) {
	if (method == null) {
	    return null;
	}
	boolean isEmptyParametes = false;
	Class[] parameters = method.getParameterTypes();
	if (parameters == null  || parameters.length == 0) {
	    isEmptyParametes = true;
	}
	if (isEmptyParametes) {
	    return method.getName() + "()";
	}
	StringBuffer buf = new StringBuffer(method.getName() + "(");
	for (int i = 0; i < parameters.length; i++) {
	    if (i > 0) {
		buf.append(",");
	    }
	    buf.append(parameters[i].getName());
	}
	buf.append(")");
	return buf.toString();
    }
    
}
