package org.plazmaforge.bs.web.server;

import org.plazmaforge.bs.web.client.CallService;
import org.plazmaforge.bs.web.client.CallWhitelist;
import org.plazmaforge.framework.core.data.DataWrapper;
import org.plazmaforge.framework.core.data.Parameters;
import org.plazmaforge.framework.core.data.path.TypeResolver;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.core.service.ReflectionServiceMethodInvoker;
import org.plazmaforge.framework.ext.service.ServiceLocator;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class CallServiceImpl extends RemoteServiceServlet implements CallService {

    public void addWhitelist(CallWhitelist whitelist) {
	
    }

    public DataWrapper call(String serviceName, String methodName, Parameters parameters, String type) throws ApplicationException {

	// Wrap data because have problems with serialization
	final DataWrapper dataWrapper = new DataWrapper();

	try {
	    Object service = getService(serviceName);
	    ReflectionServiceMethodInvoker methodInvoker = new ReflectionServiceMethodInvoker();
	    Object result = methodInvoker.invoke(service, methodName, parameters);
	    dataWrapper.setData(result);
	    
	} catch (Throwable e) {
	    if (e instanceof ApplicationException){
		throw (ApplicationException) e;
	    }
	    throw new ApplicationException(ReflectionServiceMethodInvoker.getErrorCause(e));
	}
	return dataWrapper;
    }
    
    
    private Object getService(String serviceName) {
	// Resolve service path '<package>/<ServiceName>'
	String serviceClass = resolvePath(serviceName, "Service");
	ServiceLocator serviceLocator = getServiceLocator();
	return serviceLocator == null ? null: serviceLocator.getServiceByClass(serviceClass);
    }
    
    private ServiceLocator getServiceLocator() {
	return (ServiceLocator) (ServiceLocator) getServletContext().getAttribute("service.locator");
    }

    private String resolvePath(String path, String type) {
	TypeResolver typeResolver = getTypeResolver();
	return typeResolver == null ? null : typeResolver.getClassNameByPath(path, type);
    }
    
    private TypeResolver getTypeResolver() {
	return (TypeResolver) getServletContext().getAttribute("type.resolver");
    }

}
