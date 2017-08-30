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

package org.plazmaforge.framework.platform;

import org.apache.log4j.Logger;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.core.exception.ServiceNotFoundException;
import org.plazmaforge.framework.ext.service.ServiceFactory;
import org.plazmaforge.framework.util.ClassUtilsExt;

/**
 * The Environment
 * 
 * @author Oleh Hapon
 */
public class Environment {
    
    public static final String LOG_LINE = "******************************************************************************";
    

    protected static void logInfo(Logger logger, Object message, boolean isSystemOut) {
	if (logger == null || message == null) {
	    return;
	}
	logger.info(message);
	if (isSystemOut) {
	    System.out.println(message);
	}
    }

    protected static void logWarn(Logger logger, Object message) {
	if (logger == null || message == null) {
	    return;
	}
	logger.warn(message);
    }

    protected static void logError(Logger logger, Object message) {
	if (logger == null || message == null) {
	    return;
	}
	logger.error(message);
    }

    protected static void logError(Logger logger, Object message, Throwable t) {
	if (logger == null || message == null) {
	    return;
	}
	logger.error(message, t);
    }

    
    protected static void logInfo(Logger logger, Object message) {
	logInfo(logger, message, true);
    }
    
    /**
     * Return service by class
     * @param serviceClass
     * @return
     */
    public static Object getService(Class serviceClass) {
	try {
	    return ServiceFactory.getService(serviceClass);
	} catch (ServiceNotFoundException e) {
	    return null;
	}
	
    }
    
    /**
     * Return service by class name
     * @param serviceClassName
     * @return
     */
    public static Object getServiceByClass(String serviceClassName) {
	try {
	    return ServiceFactory.getServiceByClass(serviceClassName);
	} catch (ServiceNotFoundException e) {
	    return null;
	}
    }
    
    /**
     * Return service by system property
     * @param propertyName
     * @return
     */
    public static Object getServiceByProperty(String propertyName) {
	String serviceClassName = PlatformEnvironment.getProperty(propertyName);
	return getServiceByClass(serviceClassName);
    }

    public static Class getClassByProperty(String propertyName) throws ApplicationException {
	String className = PlatformEnvironment.getProperty(propertyName);
	return ClassUtilsExt.getClass(className);
    }
    
    public static Object getInstanceByProperty(String propertyName) throws ApplicationException {
	Class klass = getClassByProperty(propertyName);
	return ClassUtilsExt.getClassInstance(klass);
    }



}
