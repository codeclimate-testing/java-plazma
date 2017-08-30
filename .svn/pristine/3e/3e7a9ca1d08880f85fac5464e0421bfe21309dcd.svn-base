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
 * Created on 24.01.2006
 */
package org.plazmaforge.framework.platform;


import org.plazmaforge.framework.app.AppEnvironment;
import org.plazmaforge.framework.app.ConfigLoader;
import org.plazmaforge.framework.app.IAppManager;
import org.plazmaforge.framework.core.DataTransfer;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.service.ServiceLocator;
import org.plazmaforge.framework.ext.service.support.spring.SpringServiceLocator;
import org.plazmaforge.framework.platform.service.PeriodCreator;
import org.plazmaforge.framework.util.ClassUtilsExt;
import org.plazmaforge.framework.util.StringUtils;


/**
 * <code>Platform Application Manager</code>
 * 
 * 
 * @author Oleh Hapon
 * 
 */
public class PlatformApplicationManager implements IAppManager {

    // TODO: DEFAULT
    public static final String DEFAULT_CONNECTION_MANAGER_CLASS = "org.plazmaforge.framework.ext.service.support.spring.SpringConnectionManager";
    
    // TODO: DEFAULT
    public static final String DEFAULT_SERVICE_LOCATOR_CLASS = "org.plazmaforge.framework.ext.service.support.spring.SpringServiceLocator";
  
    public void init(DataTransfer transfer) {

    }

    public void loadConfig() throws ApplicationException {
	if (StringUtils.isEmpty(PlatformEnvironment.getConnectionManagerClass())) {
	    PlatformEnvironment.setConnectionManagerClass(DEFAULT_CONNECTION_MANAGER_CLASS);
	}
	if (StringUtils.isEmpty(PlatformEnvironment.getServiceLocatorClass())) {
	    PlatformEnvironment.setServiceLocatorClass(DEFAULT_SERVICE_LOCATOR_CLASS);
	}
    }

    public void loadSystemConfiguration() throws ApplicationException {
	loadConfig();
	if (PlatformEnvironment.getConfigLoaderClass() != null) {
	    AppEnvironment.setConfigLoader((ConfigLoader) getClassInstance(PlatformEnvironment.getConfigLoaderClass()));
	}
	initApplicationContext();
    }

    public void onStartProcess() throws ApplicationException {
    }

    public void onEndProcess() throws ApplicationException {
    }

    protected void onBeforeRegisterPackages() throws ApplicationException {
	if (PlatformEnvironment.getPeriodCreatorClass() != null) {
	    PlatformEnvironment.getSystem().setPeriodCreator((PeriodCreator) getClassInstance(PlatformEnvironment.getPeriodCreatorClass()));
	}
    }

    protected void onAfterRegisterPackages() throws ApplicationException {
	PlatformEnvironment.getSystem().initPackages();
    }

    protected void registerPackages() throws ApplicationException {
    }

    protected void initPackages() throws ApplicationException {

	onBeforeRegisterPackages();

	registerPackages();

	onAfterRegisterPackages();

    }

    protected void initApplicationContext() throws ApplicationException {
	initPackages();
	long time = System.currentTimeMillis();
	String serviceLocatorClass = PlatformEnvironment.getServiceLocatorClass();
	System.out.println("SERVICE_LOCATOR_CLASS = [" + serviceLocatorClass + "]");
	ServiceLocator serviceLocator = (ServiceLocator) getClassInstance(serviceLocatorClass);
	
	serviceLocator.setProperty("root.dir", AppEnvironment.getRootDir());
	serviceLocator.setProperty("root.config.dir", AppEnvironment.getRootConfigDir());
	
	serviceLocator.setProperty("location", SpringServiceLocator.DEFAULT_LOCATION);
	serviceLocator.setProperty("location.list", SpringServiceLocator.DEFAULT_LOCATION_LIST);
	
	serviceLocator.init();
	
	initContext();
	initSystem();
	loadEntities();
	
	//initContext();
	System.out.println("Start time = [" + ((System.currentTimeMillis() - time) / 1000) + "]");
    }

    protected void initContext() throws ApplicationException {}
    
    protected void initSystem() throws ApplicationException {}
    
    protected void loadEntities() throws ApplicationException {}

    public void initComponents() throws ApplicationException {

	boolean isLogin = false;
	try {
	    onBeforeLogin();
	    
	    login();
	    
	    isLogin = isLogin();
	    if (!isLogin) {
		System.exit(0);
	    }
	    onAfterLogin();

	} catch (Exception e) {
	    throw new ApplicationException(e);
	}
    }

    protected void onBeforeLogin() throws ApplicationException {
	onEndProcess();
    }

    protected void onAfterLogin() throws ApplicationException {
	initEnvironment();
    }

    protected void login() throws ApplicationException {}
    
    
    protected boolean isLogin() {
	return true;
    }

    protected void initEnvironment() throws ApplicationException {
    }

    public void exit() {
	System.exit(0);
    }

    protected Object getClassInstance(String className) throws ApplicationException {
	return ClassUtilsExt.getClassInstance(className);
    }
}
