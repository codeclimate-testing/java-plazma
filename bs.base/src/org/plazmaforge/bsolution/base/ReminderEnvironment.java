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

import java.util.HashMap;
import java.util.Map;

import org.plazmaforge.bsolution.base.common.services.ReminderService;
import org.plazmaforge.framework.ext.service.ServiceFactory;

public class ReminderEnvironment {

    private static ReminderEnvironment instance;

    private Map<String, Class> reminderServices = new HashMap<String, Class>();
    
    private ReminderEnvironment() {
    }

    public static ReminderEnvironment getInstance() {
	if (instance == null) {
	    instance = new ReminderEnvironment(); 
	}
        return instance;
    }
    
    public void registerReminderService(String type, Class serviceClass) {
	getInstance().reminderServices.put(type, serviceClass);
    }

    public Class getReminderServiceClass(String type) {
	return getInstance().reminderServices.get(type);
    }

    public ReminderService getReminderService(String type) {
	Class serviceClass = getReminderServiceClass(type);
	if (serviceClass == null) {
	    return null;
	}
	return (ReminderService) ServiceFactory.getService(serviceClass);
    }

}
