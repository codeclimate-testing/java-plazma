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


package org.plazmaforge.bs.project.shared.entities;

import org.plazmaforge.bs.contact.shared.entities.ContactTitle;
import org.plazmaforge.framework.ext.model.BaseEntity;


/**
 * 
 * @author ohapon
 *
 */
public class TaskContactLink extends BaseEntity {

    private static final long serialVersionUID = 3309241412493122385L;
    

    private Task task;
    
    private ContactTitle contact;
    
    private TaskRole taskRole;
    
    private String description;

    public ContactTitle getContact() {
        return contact;
    }

    public void setContact(ContactTitle contact) {
        this.contact = contact;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public TaskRole getTaskRole() {
        return taskRole;
    }

    public void setTaskRole(TaskRole taskRole) {
        this.taskRole = taskRole;
    }

    public String getContactName() {
	return getContact() == null ? null : getContact().getFullName();
    }
    
    public String getTaskRoleName() {
	return getTaskRole() == null ? null : getTaskRole().getName();
    }

    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

 

    
    
    
}
