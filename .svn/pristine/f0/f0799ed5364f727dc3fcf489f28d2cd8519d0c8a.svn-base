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

package org.plazmaforge.framework.platform.service.impl.ejb;

import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.service.ServiceFactory;
import org.plazmaforge.framework.ext.service.ServiceLocator;
import org.plazmaforge.framework.platform.service.Initializer;
import org.plazmaforge.framework.platform.service.impl.DefaultInitializer;


/**
 * <code>EJBEnvironment</code>
 * 
 * @author hapon
 * 
 */
public class EJBEnvironment {

    private static EJBEnvironment instance;

    /** Inner service locator * */
    private ServiceLocator serviceLocator;

    private EJBEnvironment() {
	super();
    }

    public static EJBEnvironment getInstance() {
	if (instance == null) {
	    instance = new EJBEnvironment();
	    instance.init();
	}
	return instance;
    }

    /**
     * Initialize EJB Server
     * 
     */
    protected void init() {
	try {
	    
	    Initializer initializer = new DefaultInitializer();
	    initializer.init();
	    

	    /*
	    AppEnvironment.setExternalConfigFile(true);

	    AppConfigurer configurer = new AppConfigurer();
	    configurer.loadConfig();

	    // load Root PlatformSystem Configurer
	    SystemConfigurer systemConfigurer = new XMLSystemConfigurer();
	    systemConfigurer.loadObjects();

	    System.out.println("PLAZMA: Creating PlatformApplicationManager ... ");
	    PlatformApplicationManager manager = getApplicationManager(AppEnvironment.getApplicationManagerClass());

	    System.out.println("PLAZMA: PlatformApplicationManager is created");
	    System.out.println("PLAZMA: Loading Configuration ... ");

	    manager.loadSystemConfiguration();

	    System.out.println("PLAZMA: PlatformSystem Configuration id loaded");
	    */

	} catch (ApplicationException ex) {
	    ex.printStackTrace();
	}
    }

    /*
    private PlatformApplicationManager getApplicationManager(String className) {
	try {
	    return (PlatformApplicationManager) ClassUtilities.getClassInstance(className);
	} catch (Exception ex) {
	    return new PlatformApplicationManager();
	}

    }
    */

    public static ServiceLocator getServiceLocator() {

	// If service locator doesn't init then use general service locator
	if (getInstance().serviceLocator == null) {
	    getInstance().serviceLocator = ServiceFactory.getServiceLocator();
	}
	return getInstance().serviceLocator;
    }

    /*
    public static void setServiceLocator(ServiceLocator serviceLocator) {
	getInstance().serviceLocator = serviceLocator;
    }
    */

}
