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
 * Created on 26.07.2007
 *
 */

package org.plazmaforge.bsolution.contact;

import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.contact.common.beans.AddressType;
import org.plazmaforge.bsolution.contact.common.beans.ContactTitle;
import org.plazmaforge.bsolution.contact.common.beans.ContactType;
import org.plazmaforge.bsolution.contact.common.beans.PhoneType;
import org.plazmaforge.bsolution.contact.common.services.ContactContextService;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.service.ServiceFactory;
import org.plazmaforge.framework.platform.Environment;


/** 
 * @author Oleh Hapon
 * $Id: ContactEnvironment.java,v 1.3 2010/12/05 07:55:56 ohapon Exp $
 */

public class ContactEnvironment extends Environment {

    private static ContactEnvironment instance;

    private ContactContext context;

    private ContactEnvironment() {
	
    }

    public static ContactEnvironment getInstance() {
	if (instance == null) {
	    instance = new ContactEnvironment();
	    instance.loadContext();
	}
	return instance;

    }

    public static ContactContext getContext() {
	return getInstance().context;
    }

    /**
     * Load Context
     * 
     */
    private void loadContext() {
	try {
	    context = ((ContactContextService) ServiceFactory.getService(ContactContextService.class)).load();

	    if (context == null) {
		throw new Exception("ContactContext is null");
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	} finally {
	    if (context == null) {
		context = new ContactContext();
	    }
	}

    }

    public static void refresh() throws ApplicationException {
	getInstance().loadContext();
    }


    public static ContactTitle getResponsible() {
	return getContext().getResponsible() == null ? EnterpriseEnvironment
		.getResponsible() : getContext().getResponsible();
    }

    public static ContactType getContactType() {
	return getContext().getContactType();
    }

    public static AddressType getAddressType() {
	return getContext().getAddressType();
    }
 
    public static PhoneType getPhoneType() {
	return getContext().getPhoneType();
    }    
    
    
    
}
