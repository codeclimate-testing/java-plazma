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

import org.plazmaforge.framework.app.AppConfigurer;
import org.plazmaforge.framework.app.AppEnvironment;
import org.plazmaforge.framework.config.AppConfiguration;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.platform.PlatformApplicationManager;
import org.plazmaforge.framework.platform.service.Initializer;


/** 
 * @author Oleh Hapon
 * $Id: DefaultInitializer.java,v 1.4 2010/12/05 07:51:26 ohapon Exp $
 */

public class DefaultInitializer implements Initializer {

    public void init() throws ApplicationException {
	
	// Initialize Application Environment 
	AppEnvironment.init();
	
	// Set external config file mode
	AppEnvironment.setExternalConfigFile(true);

	// Load application configuration
	AppConfiguration applicationConfiguration = AppConfigurer.createCurrenctConfiguration(); 
	AppConfigurer configurer = new AppConfigurer(applicationConfiguration);
	//configurer.setCheckSystemConfigFile(false);
	
	configurer.loadConfiguration();
	
	if (configurer.getAppManager() == null) {
	    configurer.setAppManager(new PlatformApplicationManager());
	}

	System.out.println("PLAZMA: Application Manager was created");
	System.out.println("PLAZMA: Loading Configuration ...");

	configurer.getAppManager().loadSystemConfiguration();

	System.out.println("PLAZMA: System Configuration was loaded");
	
    }

 

}
