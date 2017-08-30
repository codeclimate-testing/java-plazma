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
package org.plazmaforge.bsolution.base;


import java.util.List;

import org.apache.log4j.Logger;
import org.plazmaforge.bsolution.document.DocumentEnvironment;
import org.plazmaforge.bsolution.finance.FinanceEnvironment;
import org.plazmaforge.framework.app.AppEnvironment;
import org.plazmaforge.framework.config.configurer.PackageConfigurer;
import org.plazmaforge.framework.config.object.IPackageConfig;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.platform.EntityEnvironment;
import org.plazmaforge.framework.platform.PlatformEnvironment;
import org.plazmaforge.framework.platform.structure.Package;
import org.plazmaforge.framework.platform.structure.impl.DefaultPackage;
import org.plazmaforge.framework.security.SecureEnvironment;
import org.plazmaforge.framework.util.ClassUtilsExt;
import org.plazmaforge.framework.util.MoneyUtils;
import org.plazmaforge.framework.util.StringUtils;



/**
 * Common Application manager executor.
 * 
 * Use in :
 * 
 * - GUIClientApplicationManager (Client Swing)
 * - RichClientApplicationManager (Client SWT)
 * 
 * - ServerApplicationManager (Server)
 * 
 */


/**
 * @author Oleh Hapon
 * $Id: ApplicationManagerExecutor.java,v 1.4 2010/12/05 07:55:56 ohapon Exp $
 */
public class ApplicationManagerExecutor {

    private final Logger logger = Logger.getLogger(ApplicationManagerExecutor.class);
    
    
    public ApplicationManagerExecutor() {
	loadSecurity = false;
	
	// Client doesn't support security.
	// Only for Server and Standalone types.
	if (!AppEnvironment.isClient()) {
	    loadSecurity = true;
	}
    }

    private boolean loadSecurity; // = true;

    public boolean isLoadSecurity() {
	return loadSecurity;
    }

    public void registerPackages() throws ApplicationException {

	// Add packages to the system
	PackageConfigurer configurer = null ; //(PackageConfigurer) PlatformEnvironment.getConfigurer(PackageConfigurer.NAME);
	if (configurer == null) {
	    return;
	}
	List<IPackageConfig> objects = configurer.getObjects();
	if (objects == null) {
	    return;
	}

	for (IPackageConfig c : objects) {
	    if (!c.isEnabled()) {
		return;
	    }
	    String className = c.getClassName();
	    Package pkg = null;
	    if (StringUtils.isEmpty(className)) {
		pkg = new DefaultPackage();
	    } else {
		try {
		    pkg = (Package) ClassUtilsExt.getClassInstance(className);
		} catch (Exception ex) {
		    logger.error("Create package error:", ex);
		    pkg = new DefaultPackage();
		}
	    }
	    PlatformEnvironment.getSystem().addPackage(pkg);
	}

    }

    
    public void initSystem() throws ApplicationException {
	EnterpriseEnvironment.load();
    }
    
    
    public void loadEntities() throws ApplicationException {
	EntityEnvironment.loadContext();
	if (isLoadSecurity()) {
	    SecureEnvironment.loadContext();
	}

	DocumentEnvironment.loadContext();
	FinanceEnvironment.loadContext();
	
	System.out.println();
	System.out.println("Application info");
	System.out.println("===========================================================");
	System.out.println("AppName: " + EnterpriseConstants.APP_NAME);
	System.out.println("AppVersion: " + EnterpriseConstants.VERSION);
	System.out.println("AppType: " + AppEnvironment.getAppType());
	System.out.println("Security: " + isLoadSecurity());
	System.out.println("===========================================================");	
	System.out.println();

    }

    public void initEnvironment() throws ApplicationException {

	// TODO: Hard code
	MoneyUtils.setDefaultCurrency("UAN");
	MoneyUtils.setDefaultLanguage("ru");

    }

}
