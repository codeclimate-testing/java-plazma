package org.plazmaforge.bsolution.base.web;



import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.plazmaforge.framework.app.AppEnvironment;

public class InitServlet extends HttpServlet {

  
    public void init(ServletConfig config) throws ServletException {
	
	ServletContext context = config.getServletContext();
	
	// Set static (default) application attributes
	setInitAttribute(context, "user.dir", AppEnvironment.USER_DIR);
	setInitAttribute(context, "default.config.name", AppEnvironment.DEFAULT_CONFIG_NAME);
	setInitAttribute(context, "default.logs.dir.name", AppEnvironment.DEFAULT_LOGS_DIR_NAME);
	setInitAttribute(context, "default.app.context.name", AppEnvironment.DEFAULT_APP_CONTEXT_NAME);
	setInitAttribute(context, "default.root.property.file", AppEnvironment.DEFAULT_ROOT_PROPERTY_FILE);
	setInitAttribute(context, "default.application.config.file", AppEnvironment.DEFAULT_APPLICATION_CONFIG_FILE);	    
	setInitAttribute(context, "default.system.config.file", AppEnvironment.DEFAULT_SYSTEM_CONFIG_FILE);	

	// Set dynamic application attributes
	setInitAttribute(context, AppEnvironment.ROOT_DIR_PROPERTY, config.getInitParameter(AppEnvironment.ROOT_DIR_PROPERTY), true);
	
	
	WEBApplicationLoader applicationLoader = new WEBApplicationLoader();
	applicationLoader.load(null);
	
    }
    
    private void setInitAttribute(ServletContext context, String name, String value) {
	setInitAttribute(context, name, value, false);
    }
    
    private void setInitAttribute(ServletContext context, String name, String value, boolean isSystem) {
	if (name == null || value == null) {
	    return;
	}
	context.setAttribute(name, value);
	if (!isSystem) {
	    return;
	}
	System.setProperty(name, value);
    }
}
