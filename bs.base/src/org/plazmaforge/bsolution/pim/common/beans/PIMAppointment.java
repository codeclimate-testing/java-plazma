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

import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.config.object.IEntityConfigurable;
import org.plazmaforge.framework.ext.structure.Recurrence;
import org.plazmaforge.framework.platform.EntityEnvironment;


public class PIMAppointment extends PIMAppointmentHeader implements IEntityConfigurable  {

    public static final String CLASS_ID = "PIM_APPOINTMENT";
    
    private static IEntityConfig entity;
    
    
    
    private String description;
    
    private String location;
    
    private Recurrence recurrence;

    
    private List<PIMAppointmentContact> appointmentContacts;
    
    ////
    
    protected String getClassId() {
	return CLASS_ID;
    }
    
    public IEntityConfig getEntity() {
	if (entity == null) {
	    entity = EntityEnvironment.getEntityById(getClassId());
	}
	return entity;
    }
    
    public String getEntityConfigId() {
	return getEntity() == null ? null : getEntity().getConfigId();
    }

    ////
    
    public void init() {
	super.init();
	getAppointmentContacts().size();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Recurrence getRecurrence() {
	if (recurrence == null) {
	    recurrence = new Recurrence();
	}
        return recurrence;
    }

    public void setRecurrence(Recurrence recurrence) {
        this.recurrence = recurrence;
    } 
    
    public String getRecurrenceExpression() {
	return recurrence.getExpression();
    }
    
    public void setRecurrenceExpression(String expression) {
	recurrence.setExpression(expression);
    }
    
    ////
    
    public List<PIMAppointmentContact> getAppointmentContacts() {
	if (appointmentContacts == null) {
	    appointmentContacts = new ArrayList<PIMAppointmentContact>(); 
	}
        return appointmentContacts;
    }

    public void setAppointmentContacts(List<PIMAppointmentContact> appointmentContacts) {
        this.appointmentContacts = appointmentContacts;
    }

    public void addAppointmentContact(PIMAppointmentContact appointmentContact) {
	appointmentContact.setAppointment(this);
        getAppointmentContacts().add(appointmentContact);
    }

}
