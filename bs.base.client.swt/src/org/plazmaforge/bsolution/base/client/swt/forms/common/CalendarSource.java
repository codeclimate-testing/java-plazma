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

package org.plazmaforge.bsolution.base.client.swt.forms.common;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.plazmaforge.bsolution.base.common.services.CalendarService;
import org.plazmaforge.framework.client.swt.controls.IOzCalendarSource;
import org.plazmaforge.framework.client.swt.controls.OzCalendarEvent;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.model.ICalendarEvent;

public class CalendarSource implements IOzCalendarSource {
	
    private CalendarService service;
    private Map<String, Object> parameters;

    public CalendarSource(CalendarService service,  Map<String, Object> parameters) {
	this.parameters = parameters;
	this.service = service;
    }

    private OzCalendarEvent createEvent(ICalendarEvent event) {
	OzCalendarEvent e = new OzCalendarEvent();
	e.setId(event.getEventId());
	e.setType(event.getEventType());
	e.setStart(event.getEventDate());
	e.setEnd(event.getEventDate());
	e.setSummury(event.getEventName());
	e.setText(event.getEventName());
	return e;
    }

    public OzCalendarEvent[] getEventsForPeriod(Date startDate, Date endDate) {
	List<ICalendarEvent> events = null;
	try {
	    events = service.findCalendarEvents(startDate, endDate, parameters);
	} catch (ApplicationException e) {
	    // stub
	}
	if (events == null) {
	    return new OzCalendarEvent[0];
	}
	int size = events.size();
	OzCalendarEvent[] ozEvents = new OzCalendarEvent[size];
	for (int i = 0; i < size; i++) {
	    ICalendarEvent e = events.get(i);
	    ozEvents[i] = createEvent(e);
	}
	return ozEvents;
    }
	
    
    public static IOzCalendarSource[] getCalendarSources(CalendarService service, Map<String, Object> parameters) {
	if (service == null) {
	    return new IOzCalendarSource[0];
	}
	IOzCalendarSource[] sources = new IOzCalendarSource[1];
	sources[0] = new CalendarSource(service, parameters);
	return sources;
    }
}

