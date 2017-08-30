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
package org.plazmaforge.bs.web.server;

import java.util.List;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.plazmaforge.bs.ApplicationCommandResolver;
import org.plazmaforge.framework.config.AppConfiguration;
import org.plazmaforge.framework.config.ConfigurerManager;
import org.plazmaforge.framework.config.ConfigurerContributor;
import org.plazmaforge.framework.config.configurer.ConfigurerInfo;
import org.plazmaforge.framework.config.configurer.SystemConfigurer;
import org.plazmaforge.framework.core.data.path.TypeResolver;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.core.logging.Log4JHandler;
import org.plazmaforge.framework.core.logging.LogManager;
import org.plazmaforge.framework.core.logging.Logger;
import org.plazmaforge.framework.ext.service.ServiceLocator;
import org.plazmaforge.framework.util.ClassUtils;
import org.plazmaforge.framework.util.FileUtils;
import org.plazmaforge.framework.util.StringUtils;

/**
 * @author ohapon
 *
 */
public class InitServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private static final Logger logger = Logger.getLogger(InitServlet.class.getName());
    
    
    public void init(ServletConfig config) throws ServletException {
	
	// Add Log Handler
	LogManager.getRootLogger().addHandler(new Log4JHandler());
	
   	ServletContext servletContext = config.getServletContext();
   	
   	//String configurationDir = "D:\\Plazma\\bs.enterprise.configuration";
   	String configurationDir = System.getProperty(AppConfiguration.PROPERTY_ROOT_DIR);
   	if (StringUtils.isEmpty(configurationDir)) {
   	    logger.error("Can not load configuration. Configuration directory is not setting. Application property '" + AppConfiguration.PROPERTY_ROOT_DIR + "' is empty.");
   	    return;
   	}
   	

	TypeResolver typeResolver = new TypeResolver();
	typeResolver.setBasePackage("org.plazmaforge.bs");
	typeResolver.registerTypePackage("Entity", "shared.entities", false);
	typeResolver.registerTypePackage("ListForm", "client.forms");
	typeResolver.registerTypePackage("EditForm", "client.forms");
	typeResolver.registerTypePackage("Form", "client.forms");
	typeResolver.registerTypePackage("Service", "shared.services");
	servletContext.setAttribute("type.resolver", typeResolver);
	
	
   	ConfigurerManager configurerManager = loadConfiguration(servletContext, configurationDir);
	if  (configurerManager != null) {
	    
	    // Add ConfigurerManager to context
	    servletContext.setAttribute("configurer.manager", configurerManager);
	    
	    // Get all configurers
	    List<ConfigurerInfo<?>> configurers = configurerManager.getConfigurersInfo();
	    
	    // Contribute configurers if need
	    ConfigurerContributor contributor = new ConfigurerContributor(configurers, new ApplicationCommandResolver()); 
	    contributor.contribute();
	    
	    // Add all configurers to context
	    servletContext.setAttribute("configurer.manager.configurers", configurers);
	}
	
	
    }
    
    private ConfigurerManager loadConfiguration(ServletContext servletContext, String configurationDir) {
	try {
	    if (StringUtils.isEmpty(configurationDir)) {
		logger.error("Configuration directory is not setting");
		return null;
	    }
	    
	    String systemContext = "standalone";
	    
	    AppConfiguration configuration = new AppConfiguration();
	    Properties initProperties = new Properties();
	    initProperties.put(AppConfiguration.PROPERTY_ROOT_DIR, configurationDir);
	    //initProperties.put(AppConfiguration.PROPERTY_UI_CONTEXT, "ui");
	    configuration.init(initProperties);

	    SystemConfigurer systemConfigurer = ConfigurerManager.getSystemConfigurer(configuration);
	    String systemConfigFileName = FileUtils.getPath(systemContext, configuration.getSystemConfigFile()); // Simple file name 'system-config.xml'
	    systemConfigFileName = configuration.getRootConfigFileName(systemConfigFileName); // Absolute file name
	    systemConfigurer.setAbsoluteConfigFileName(systemConfigFileName);

	    systemConfigurer.loadObjects();
	    ConfigurerManager cm = ConfigurerManager.getInstance();

	    logger.log("Configuration is loaded");

	    loadServiceLocator(servletContext, configuration);
	    
	    return cm;

	} catch (Throwable e) {
	    logger.error("Load configuration error", e);
	}
	return null;
    }
    
    protected void loadServiceLocator(ServletContext servletContext, AppConfiguration configuration) throws ApplicationException {
	
	long time = System.currentTimeMillis();
	
	String serviceLocatorClass = configuration.getConfigurationProperty("plazma.platform.service.locator.class");
	if (serviceLocatorClass == null) {
	    logger.error("SERVICE_LOCATOR_CLASS is empty");
	    return;
	}
	logger.log("SERVICE_LOCATOR_CLASS = [" + serviceLocatorClass + "]");
	ServiceLocator serviceLocator = (ServiceLocator) ClassUtils.newSafeInstance(serviceLocatorClass);
	if (serviceLocator == null) {
	    logger.error("Can not load SERVICE_LOCATOR_CLASS by class '" + serviceLocatorClass + "'");
	    return;
	}
	
	
	serviceLocator.setProperty("root.dir", configuration.getRootDir());
	serviceLocator.setProperty("root.config.dir", configuration.getRootConfigDir());
	serviceLocator.setTypeResolver((TypeResolver) servletContext.getAttribute("type.resolver"));
	
	serviceLocator.init();
	
	logger.log("Start time = [" + ((System.currentTimeMillis() - time) / 1000) + "]");
	
	servletContext.setAttribute("service.locator", serviceLocator);
    }    

}
