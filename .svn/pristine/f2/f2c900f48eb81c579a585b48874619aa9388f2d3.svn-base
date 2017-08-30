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
 * <code>EJBServiceEnvironment</code>
 * 
 * Created on 02.02.2006
 *
 */
package org.plazmaforge.framework.platform.service.impl.ejb;

import java.rmi.RemoteException;
import java.util.Properties;

import javax.ejb.CreateException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import org.plazmaforge.framework.platform.PlatformEnvironment;
import org.plazmaforge.framework.platform.service.impl.ejb.bean.StatefulService;
import org.plazmaforge.framework.platform.service.impl.ejb.bean.StatefulServiceHome;
import org.plazmaforge.framework.platform.service.impl.ejb.bean.StatelessService;
import org.plazmaforge.framework.platform.service.impl.ejb.bean.StatelessServiceHome;


public class EJBServiceEnvironment {

    public static final String DEFAULT_JNDI_PATH = "java:/comp/env/";

    public static final String DEFAULT_EJB_PROPERTIES_NAME = "ejb";

    private Properties environmentProperties;

    private String statelessSessionName = "StatelessService";

    private String statefulSessionName = "StatefulService";

    private boolean cashStateless = true;

    private boolean cashStateful = true;

    private Object statelessSessionHome;

    private Object statefulSessionHome;

    private String jndiPath;

    private String ejbPropertiesName;

    private static EJBServiceEnvironment instance;

    private EJBServiceEnvironment() {
    }

    public static EJBServiceEnvironment getInstance() {
	if (instance == null) {
	    instance = new EJBServiceEnvironment();
	    instance.jndiPath = DEFAULT_JNDI_PATH;
	    instance.ejbPropertiesName = DEFAULT_EJB_PROPERTIES_NAME;
	}
	return instance;
    }

    public Properties getEnvironmentProperties() {
	if (environmentProperties == null) {
	    environmentProperties = createDefaultEnvironmentProperties();
	}
	return environmentProperties;
    }

    public void setEnvironmentProperties(Properties environmentProperties) {
	this.environmentProperties = environmentProperties;
    }

    private Properties createDefaultEnvironmentProperties() {
	return PlatformEnvironment.getPropertyStore(getEjbPropertiesName());
    }

    public static void setStatelessSessionName(String statelessSessionName) {
	getInstance().statelessSessionName = statelessSessionName;
    }

    public static String getStatelessSessionName() {
	return getInstance().statelessSessionName;
    }

    public static void setStatefulSessionName(String statefulSessionName) {
	getInstance().statefulSessionName = statefulSessionName;
    }

    public static String getStatefulSessionName() {
	return getInstance().statefulSessionName;
    }

    public boolean isCashStateful() {
	return cashStateful;
    }

    public void setCashStateful(boolean cashStateful) {
	this.cashStateful = cashStateful;
    }

    public boolean isCashStateless() {
	return cashStateless;
    }

    public void setCashStateless(boolean cashStateless) {
	this.cashStateless = cashStateless;
    }

    public static StatelessService getStatelessSessionBean()
	    throws NamingException, CreateException, RemoteException {
	return getStatelessSessionHome().create();
    }

    public static StatefulService getStatefulSessionBean()
	    throws NamingException, CreateException, RemoteException {
	return getStatefulSessionHome().create();
    }

    public static StatelessServiceHome getStatelessSessionHome()
	    throws NamingException {
	if (!getInstance().cashStateless
		|| (getInstance().cashStateless && getInstance().statelessSessionHome == null)) {
	    return (StatelessServiceHome) getEJBHome(getStatelessSessionName(),
		    StatelessServiceHome.class);
	}
	return (StatelessServiceHome) getInstance().statelessSessionHome;
    }

    public static StatefulServiceHome getStatefulSessionHome()
	    throws NamingException {
	if (!getInstance().cashStateful
		|| (getInstance().cashStateful && getInstance().statefulSessionHome == null)) {
	    return (StatefulServiceHome) getEJBHome(getStatefulSessionName(),
		    StatefulServiceHome.class);
	}
	return (StatefulServiceHome) getInstance().statefulSessionHome;
    }

    public static String getJNDIPath() {
	return getInstance().jndiPath;
    }

    public static String getEjbPropertiesName() {
	return getInstance().ejbPropertiesName;
    }

    public static Context getContext() throws NamingException {
	Properties env = getInstance().getEnvironmentProperties();
	Context ctx = new InitialContext(env);
	return ctx;
    }

    public static Object lookup(String name) throws NamingException {
	return getContext().lookup(name);
    }

    public static Object getEJBHome(String serviceName, Class klass)
	    throws NamingException {
	Object obj = getContext().lookup(serviceName);
	obj = PortableRemoteObject.narrow(obj, klass);
	return obj;
    }

}
