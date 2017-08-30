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
 * Created on 20.08.2007
 *
 */

package org.plazmaforge.bsolution.project.common.beans;

import org.plazmaforge.bsolution.contact.common.beans.ContactHeader;
import org.plazmaforge.framework.ext.model.BaseEntity;
import org.plazmaforge.framework.ext.structure.TimeSheet;


/** 
 * @author Oleh Hapon
 * $Id: TaskEmployeeLink.java,v 1.3 2010/12/05 07:55:58 ohapon Exp $
 */

public class TaskWorkerLink extends BaseEntity {

    private Task task;
    
    private ContactHeader worker;

    private TimeSheet workTime;
    
    private TimeSheet actualTime;
    
    private double workCost;
    
    private String description;

  
    public ContactHeader getWorker() {
        return worker;
    }

    public void setWorker(ContactHeader worker) {
        this.worker = worker;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getWorkerName() {
	return getWorker() == null ? null : getWorker().getFullName();
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    public TimeSheet getWorkTime() {
	if (workTime == null) {
	    workTime = new TimeSheet(); 
	}
        return workTime;
    }
    
    public String getWorkTimeString() {
	return workTime == null ? "" : workTime.getFormatString();
    }
    
    public void setWorkTime(TimeSheet workTime) {
        this.workTime = workTime;
    }

    public int getWorkDays() {
        return getWorkTime().getDays();
    }

    public void setWorkDays(int workDays) {
	getWorkTime().setDays(workDays);
    }

    public int getWorkHours() {
        return getWorkTime().getHours();
    }

    public void setWorkHours(int workHours) {
	getWorkTime().setHours(workHours);
    }

    public int getWorkMinutes() {
        return getWorkTime().getMinutes();
    }

    public void setWorkMinutes(int workMinutes) {
	getWorkTime().setMinutes(workMinutes);
    }
    
    public TimeSheet getActualTime() {
	if (actualTime == null) {
	    actualTime = new TimeSheet(); 
	}
        return actualTime;
    }

    public String getActualTimeString() {
	return actualTime == null ? "" : actualTime.getFormatString();
    }
    
    public void setActualTime(TimeSheet actualTime) {
        this.actualTime = actualTime;
    }

    public int getActualDays() {
        return getActualTime().getDays();
    }

    public void setActualDays(int actualDays) {
	getActualTime().setDays(actualDays);
    }

    public int getActualHours() {
        return getActualTime().getHours();
    }

    public void setActualHours(int actualHours) {
	getActualTime().setHours(actualHours);
    }

    public int getActualMinutes() {
        return getActualTime().getMinutes();
    }

    public void setActualMinutes(int actualMinutes) {
	getActualTime().setMinutes(actualMinutes);
    }

    public double getWorkCost() {
        return workCost;
    }

    public void setWorkCost(double workCost) {
        this.workCost = workCost;
    }


    
    
}
