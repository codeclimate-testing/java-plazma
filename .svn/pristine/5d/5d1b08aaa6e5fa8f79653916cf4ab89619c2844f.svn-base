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

package org.plazmaforge.bsolution.pim.common.beans;

import java.util.Date;

import org.plazmaforge.bsolution.contact.common.beans.ContactTitle;
import org.plazmaforge.bsolution.organization.common.beans.OrganizableEntity;
import org.plazmaforge.framework.ext.model.ICalendarEvent;

public class PIMEventHeader extends OrganizableEntity implements ICalendarEvent {

    private ContactTitle responsible;
    
    private String name;
   
    private Date eventDateTime;
    
    private Date reminderDateTime;
    
    private boolean reminder;

    public ContactTitle getResponsible() {
        return responsible;
    }

    public void setResponsible(ContactTitle responsible) {
        this.responsible = responsible;
    }
    
    public String getResponsibleName() {
        return responsible == null ? null : responsible.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(Date eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public Date getReminderDateTime() {
        return reminderDateTime;
    }

    public void setReminderDateTime(Date reminderDateTime) {
        this.reminderDateTime = reminderDateTime;
    }

    public boolean isReminder() {
        return reminder;
    }

    public void setReminder(boolean reminder) {
        this.reminder = reminder;
    }

    ////
    
    public String getEventId() {
	return getId() == null ? null : getId().toString();
    }
    
    public String getEventType() {
	return "PIM_EVENT";
    }
    
    public String getEventName() {
	return getName();
    }
    
    public Date getEventDate() {
	return getEventDateTime();
    }

}
