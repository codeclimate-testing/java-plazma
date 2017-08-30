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

import java.util.Map;

import org.plazmaforge.framework.core.data.Callback;
import org.plazmaforge.framework.core.data.Parameters;
import org.plazmaforge.framework.core.data.path.TypeResolver;
import org.plazmaforge.framework.core.logging.Logger;
import org.plazmaforge.framework.core.service.ReflectionServiceMethodInvoker;
import org.plazmaforge.framework.core.service.ServiceCaller;
import org.plazmaforge.framework.ext.service.ServiceLocator;
import org.plazmaforge.framework.uwt.Application;

/**
 * @author ohapon
 *
 */
public class DesktopApplicationServiceCaller implements ServiceCaller {

    private boolean async = true;
    
    private static final Logger logger = Logger.getLogger(DesktopApplicationServiceCaller.class.getName());
    
    
    @Override
    public <T> void call(final String serviceName, final String methodName, final Object[] parameters, final Callback<T> callback) {
	
	if (!async) {
	    doCall(serviceName, methodName, parameters, callback);
	    return;
	}
	
	Runnable runnable = new Runnable (){
	    public void run() {
		doCall(serviceName, methodName, parameters, callback);
	    }
	};
	Application.getCurrent().asyncExec(runnable);

    }

    @Override
    public <T> void call(String service, String method, Map<String, Object> parameters, Callback<T> callback) {
	
    }
    
    
    protected <T> void doCall(String serviceName, String methodName, Object[] parameters, Callback<T> callback) {
	try {
	    Object service = getService(serviceName);
	    ReflectionServiceMethodInvoker methodInvoker = new ReflectionServiceMethodInvoker();
	    Object result = methodInvoker.invoke(service, methodName, Parameters.byIndex(parameters));
	    
	    callback.onSuccess((T) result);
	} catch (Throwable e) {
	    // Translate to root exception (cause)
	    Throwable cause = ReflectionServiceMethodInvoker.getErrorCause(e);
	    logger.error("Call service error: service=" + serviceName + ", method=" + methodName + ", parameters=[" + (parameters == null ? 0 : parameters.length) + "]", cause);
	    callback.onFailure(cause);
	}
    }
    
    protected <T> void doCall(String service, String method, Map<String, Object> parameters, Callback<T> callback) {
	// Not implemented
    }

    
    
    private Object getService(String serviceName) {
	// Resolve service path '<package>/<ServiceName>'
	String serviceClass = resolvePath(serviceName, "Service");
	ServiceLocator serviceLocator = getServiceLocator();
	return serviceLocator == null ? null: serviceLocator.getServiceByClass(serviceClass);
    }
    
    private ServiceLocator getServiceLocator() {
	return (ServiceLocator) Application.getCurrent().getApplicationContext().getAttribute("service.locator");
    }

    private String resolvePath(String path, String type) {
	TypeResolver typeResolver = getTypeResolver();
	return typeResolver == null ? null : typeResolver.getClassNameByPath(path, type);
    }
    
    private TypeResolver getTypeResolver() {
	return (TypeResolver) Application.getCurrent().getApplicationContext().getAttribute("type.resolver");
    }
    
    
}
