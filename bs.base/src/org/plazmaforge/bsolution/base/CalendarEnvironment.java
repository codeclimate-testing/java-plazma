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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.plazmaforge.bsolution.base.common.services.CalendarService;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.model.ICalendarEvent;
import org.plazmaforge.framework.ext.service.ServiceFactory;

public class CalendarEnvironment {

    private static CalendarEnvironment instance;

    private Map<String, Class> calendarServices = new HashMap<String, Class>();
    
    
    private CalendarEnvironment() {
    }

    public static CalendarEnvironment getInstance() {
	if (instance == null) {
	    instance = new CalendarEnvironment(); 
	}
        return instance;
    }

    public void registerCalendarService(String type, Class serviceClass) {
	getInstance().calendarServices.put(type, serviceClass);
    }

    public Class getCalendarServiceClass(String type) {
	return getInstance().calendarServices.get(type);
    }

    public CalendarService getCalendarService(String type) {
	Class serviceClass = getCalendarServiceClass(type);
	if (serviceClass == null) {
	    return null;
	}
	return (CalendarService) ServiceFactory.getService(serviceClass);
    }
    
    public CalendarService getCalendarService() {
	GeneralCalendarService generalService = new GeneralCalendarService();
	Collection<Class>  classes = calendarServices.values();
	for (Class serviceClass : classes) {
	    CalendarService service = (CalendarService) ServiceFactory.getService(serviceClass);
	    generalService.addService(service);
	}
	return generalService;
    }
    
    class GeneralCalendarService implements CalendarService {
	
	private List<CalendarService> services = new ArrayList<CalendarService>();
	
	public void addService(CalendarService service) {
	    services.add(service);
	}
	
	public List<ICalendarEvent> findCalendarEvents(Date startDate, Date endDate, Map<String, Object> parameters) throws ApplicationException {
	    List<ICalendarEvent> allEvents = new ArrayList<ICalendarEvent>();
	    for (CalendarService service : services ) {
		List<ICalendarEvent> events = service.findCalendarEvents(startDate, endDate, parameters);
		allEvents.addAll(events);
	    }
	    return allEvents;
	}
    }

    
}
