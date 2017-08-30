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
import org.plazmaforge.bsolution.project.common.beans.ProjectHeader;
import org.plazmaforge.framework.ext.model.ICalendarEvent;

public class PIMAppointmentHeader extends OrganizableEntity implements ICalendarEvent {

    private ContactTitle responsible;
    
    private PIMAppointmentType appointmentType;
    
    private PIMAppointmentPriority appointmentPriority;
    
    private ProjectHeader project;
    
    private String subject;
    
    private Date startDateTime;
    
    private Date endDateTime;
    
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
    
    public PIMAppointmentType getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(PIMAppointmentType appointmentType) {
        this.appointmentType = appointmentType;
    }

    public String getAppointmentTypeName() {
        return appointmentType == null ? null : appointmentType.getName();
    }

    public PIMAppointmentPriority getAppointmentPriority() {
        return appointmentPriority;
    }

    public void setAppointmentPriority(PIMAppointmentPriority appointmentPriority) {
        this.appointmentPriority = appointmentPriority;
    }

    public String getAppointmentPriorityName() {
        return appointmentPriority == null ? null : appointmentPriority.getName();
    }
    
    
    public ProjectHeader getProject() {
        return project;
    }

    public void setProject(ProjectHeader project) {
        this.project = project;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
	return getSubject();
    }
    
    public void setName(String name) {
	setSubject(name);
    }
    
    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
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
	return "PIM_APPOINTMENT";
    }
    
    public String getEventName() {
	return getName();
    }
    
    public Date getEventDate() {
	return getStartDateTime();
    }
}

