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
 * Created on 3 ��� 2007
 *
 */

package org.plazmaforge.framework.platform.service.impl.rmi;

import java.util.Properties;

import org.plazmaforge.framework.app.AppEnvironment;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.platform.service.ServiceInvoker;
import org.plazmaforge.framework.platform.service.ServiceProxy;
import org.plazmaforge.framework.platform.service.impl.AbstractInvokeServiceLocator;
import org.plazmaforge.framework.util.SystemInfo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;



/** 
 * @author Oleh Hapon
 * $Id: RMIServiceLocator.java,v 1.5 2010/12/05 07:51:33 ohapon Exp $
 */

public class RMIServiceLocator extends AbstractInvokeServiceLocator {

    /** Location * */
    public static final String DEFAULT_LOCATION_PROPERTY = "rmi-context.xml";

    public static String DEFAULT_SERVICE_INVOKER = "rmiServiceInvoker";
    
    
    
    
    /** Spring application context * */
    private ApplicationContext applicationContext;

    /**
     * Get application context
     * 
     * @return
     */
    public ApplicationContext getApplicationContext() {
	return applicationContext;
    }

    /**
     * Set application context
     * 
     * @param applicationContext
     */
    public void setApplicationContext(ApplicationContext applicationContext) {
	this.applicationContext = applicationContext;
    }

    
    
    
    
    
    
    protected ServiceInvoker getServiceInvoker() throws Exception {
	ServiceInvoker invoker =  (ServiceInvoker) getApplicationContext().getBean(DEFAULT_SERVICE_INVOKER);
	return invoker;
    }
    
    protected ServiceProxy getServiceProxy(ServiceInvoker invoker) {
	return new RMIServiceProxy(invoker);
    }
    
    public void init() throws ApplicationException {
	
	ApplicationContext ctx = createApplicationContext();

	setApplicationContext(ctx);
	
	super.init();
	
    }
    
    protected ApplicationContext createApplicationContext() throws ApplicationException {
	ConfigurableApplicationContext ctx = null;
	try {
	
		String contextLocation = null;
		if (AppEnvironment.isExternalConfigFile()) {

		    // Load context from conf folder
		    contextLocation = AppEnvironment.getRootConfigFileName(this.getLocation());

		    // TODO: You must fixed Spring
		    // Spring remove first '/'
		    if (!SystemInfo.isWindows && contextLocation.startsWith("/")) {
			contextLocation = "/" + contextLocation;
		    }

		    log("APPLICATION_CONTEXT_FILE = [" + contextLocation + "]");
		    
		    // 2010-04-29
		    // FileSystemXmlApplicationContext -> MyFileSystemXmlApplicationContext
		    // See org.plazmaforge.framework.platform.service.impl.spring.SpringServiceLocator
		    
		    ctx = new MyFileSystemXmlApplicationContext(contextLocation);
		} else {

		    // Load context from root package
		    contextLocation = this.getLocation();
		    log("APPLICATION_CONTEXT_LOCATION = [" + contextLocation + "]");
		    ctx = new ClassPathXmlApplicationContext(contextLocation);
		}

		if (ctx == null) {
		    log("APPLICATION_CONTEXT is null");
		    return ctx;
		}
		
		log("APPLICATION_CONTEXT was loaded");
		
		// Replace ${args}
		// Example ${user.dir}
		//
		// This you can replace properties for DEMO mode
		// Example
		// jdbc.url=jdbc:hsqldb:file:${user.dir}/db/hsql/plazma_eng_demo

		// TODO: Use method clone() of Properties

		Properties props = System.getProperties();
		PropertyPlaceholderConfigurer cfg = new PropertyPlaceholderConfigurer();
		cfg.setProperties(props);
		cfg.postProcessBeanFactory(ctx.getBeanFactory());
	    
	} catch (Exception ex) {
	    throw new ApplicationException(ex);
	}

	return ctx;

    }
    
    protected String getLocation() {
	return DEFAULT_LOCATION_PROPERTY;
    }    
    
    
    class MyFileSystemXmlApplicationContext extends FileSystemXmlApplicationContext {

	public MyFileSystemXmlApplicationContext(String configLocation) throws BeansException {
	    super(configLocation);
	}

	public MyFileSystemXmlApplicationContext(String[] configLocations, ApplicationContext parent) throws BeansException {
	    super(configLocations, parent);
	}

	public MyFileSystemXmlApplicationContext(String[] configLocations, boolean refresh, ApplicationContext parent) throws BeansException {
	    super(configLocations, refresh, parent);
	}

	public MyFileSystemXmlApplicationContext(String[] configLocations, boolean refresh) throws BeansException {
	    super(configLocations, refresh);
	}

	public MyFileSystemXmlApplicationContext(String[] configLocations) throws BeansException {
	    super(configLocations);
	}

	public MyFileSystemXmlApplicationContext(String[] configLocations, ClassLoader classLoader) throws BeansException {
	    this(configLocations);
	    setClassLoader(classLoader);
	}

	protected Resource getResourceByPath(String path)  {
	     
	    //Disable remove first '/'. It is problem at Linux
	    //if(path != null && path.startsWith("/")) {
	    //  path = path.substring(1);
	    //}
	
	    return new FileSystemResource(path);
        }
    }
    
}
