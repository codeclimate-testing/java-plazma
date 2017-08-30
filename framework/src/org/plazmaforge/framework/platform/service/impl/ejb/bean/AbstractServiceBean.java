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

package org.plazmaforge.framework.platform.service.impl.ejb.bean;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import org.plazmaforge.framework.ext.security.UserContextHolder;
import org.plazmaforge.framework.ext.service.ServiceLocator;
import org.plazmaforge.framework.platform.service.InvokeContext;
import org.plazmaforge.framework.platform.service.InvokeData;
import org.plazmaforge.framework.platform.service.impl.ejb.EJBEnvironment;


public abstract class AbstractServiceBean implements SessionBean {

    public void ejbCreate() throws javax.ejb.CreateException {

    }

    public void ejbActivate() throws EJBException {

    }

    public void ejbPassivate() throws EJBException {

    }

    public void ejbRemove() throws EJBException {

    }

    public void setSessionContext(SessionContext sessionContext)
	    throws EJBException {

    }

    public Object invoke(InvokeData data) throws RemoteException {
	try {
	    ByteArrayInputStream bais = new ByteArrayInputStream(data.getData());
	    ObjectInputStream ios = new ObjectInputStream(bais);
	    InvokeContext context = (InvokeContext) ios.readObject();

	    ServiceLocator servicLocator = EJBEnvironment.getServiceLocator();

	    Object service = servicLocator.getService(context.getServiceClass());
	    Method method = context.getServiceClass().getMethod(context.getMethodName(), context.getMethodParamsType());

	    // Set user context
	    UserContextHolder.setContext(context.getUserContext());

	    return method.invoke(service, context.getArgs());

	} catch (Exception ex) {
	    throw new RemoteException(ex.getMessage());
	}
    }

}
