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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.plazmaforge.bs.contact.shared.entities.ContactTitle;
import org.plazmaforge.bs.document.shared.entities.DocumentHeader;
import org.plazmaforge.bs.organization.shared.entities.OrganizableEntity;
import org.plazmaforge.bs.partner.shared.entities.PartnerTitle;
import org.plazmaforge.framework.ext.model.ICalendarEvent;
import org.plazmaforge.framework.ext.model.IHistoryEntity;
import org.plazmaforge.framework.ext.model.IStatusEntity;
import org.plazmaforge.framework.ext.structure.TimeSheet;

/**
 * 
 * @author ohapon
 *
 */
public class Task extends OrganizableEntity implements IHistoryEntity, IStatusEntity, ICalendarEvent {

   
    private static final long serialVersionUID = -3831973639750797587L;
    
    
    private ProjectHeader project;

    private DocumentHeader document;

    private ContactTitle reporter;
    
    private ContactTitle responsible;

    private PartnerTitle partner;

    private TaskPriority taskPriority;

    private TaskStatus taskStatus;

    private TaskType taskType;

    private TaskResult taskResult;

    private String taskNo;

    private String name;

    private String description;

    private Date startDateTime;

    private Date endDateTime;

    private Date actualEndDateTime;

    private Date reminderDateTime;

    private double percentComplete;

    private boolean apointment;

    private String resultDetails;

    ////
    
    private TimeSheet workTime;
    
    private TimeSheet actualTime;
    
    private double workCost;
    
    ////
    
    private List<TaskWorkerLink> taskWorkerLinks;

    private List<TaskContactLink> taskContactLinks;
    
    ////
    
    public Date getReminderDateTime() {
	return reminderDateTime;
    }

    public void setReminderDateTime(Date reminderDateTime) {
	this.reminderDateTime = reminderDateTime;
    }

    public boolean isApointment() {
	return apointment;
    }

    public void setApointment(boolean appointment) {
	this.apointment = appointment;
    }

    public String getTaskNo() {
	return taskNo;
    }

    public void setTaskNo(String taskNo) {
	this.taskNo = taskNo;
    }

    public Date getActualEndDateTime() {
	return actualEndDateTime;
    }

    public void setActualEndDateTime(Date actualEndDateTime) {
	this.actualEndDateTime = actualEndDateTime;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public DocumentHeader getDocument() {
	return document;
    }

    public void setDocument(DocumentHeader document) {
	this.document = document;
    }

    public double getPercentComplete() {
	return percentComplete;
    }

    public void setPercentComplete(double percentCompelete) {
	this.percentComplete = percentCompelete;
    }

    public Date getEndDateTime() {
	return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
	this.endDateTime = endDateTime;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public PartnerTitle getPartner() {
	return partner;
    }

    public void setPartner(PartnerTitle partner) {
	this.partner = partner;
    }

    public ProjectHeader getProject() {
	return project;
    }

    public Integer getProjectId() {
	return project == null ? null : project.getId();
    }

    public void setProject(ProjectHeader project) {
	this.project = project;
    }

    public ContactTitle getReporter() {
        return reporter;
    }

    public void setReporter(ContactTitle reporter) {
        this.reporter = reporter;
    }

    public String getReporterName() {
	return reporter == null ? null : reporter.getName();
    }

    public ContactTitle getResponsible() {
	return responsible;
    }

    public void setResponsible(ContactTitle responsible) {
	this.responsible = responsible;
    }

    public String getResponsibleName() {
	return responsible == null ? null : responsible.getName();
    }
    
    public String getResultDetails() {
	return resultDetails;
    }

    public void setResultDetails(String resultDetails) {
	this.resultDetails = resultDetails;
    }

    public Date getStartDateTime() {
	return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
	this.startDateTime = startDateTime;
    }

    public TaskPriority getTaskPriority() {
	return taskPriority;
    }

    public void setTaskPriority(TaskPriority taskPriority) {
	this.taskPriority = taskPriority;
    }

    public TaskResult getTaskResult() {
	return taskResult;
    }

    public void setTaskResult(TaskResult taskResult) {
	this.taskResult = taskResult;
    }

    public TaskStatus getTaskStatus() {
	return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
	this.taskStatus = taskStatus;
    }

    public TaskType getTaskType() {
	return taskType;
    }

    public void setTaskType(TaskType taskType) {
	this.taskType = taskType;
    }

    public String getTaskPriorityName() {
	return getTaskPriority() == null ? null : getTaskPriority().getName();
    }

    public String getPartnerName() {
	return getPartner() == null ? null : getPartner().getName();
    }

    ////
    
    public List<TaskContactLink> getTaskContactLinks() {
	if (taskContactLinks == null) {
	    taskContactLinks = new ArrayList<TaskContactLink>(); 
	}
        return taskContactLinks;
    }

    public void setTaskContactLinks(List<TaskContactLink> taskContactLinks) {
        this.taskContactLinks = taskContactLinks;
    }

    public void addTaskContactLink(TaskContactLink taskContactLink) {
	taskContactLink.setTask(this);
        getTaskContactLinks().add(taskContactLink);
    }
    
    public List<TaskWorkerLink> getTaskWorkerLinks() {
	if (taskWorkerLinks == null) {
	    taskWorkerLinks = new ArrayList<TaskWorkerLink>(); 
	}
        return taskWorkerLinks;
    }

    public void setTaskWorkerLinks(List<TaskWorkerLink> taskWorkerLinks) {
        this.taskWorkerLinks = taskWorkerLinks;
    }

    public void addTaskWorkerLink(TaskWorkerLink taskWorkerLink) {
	taskWorkerLink.setTask(this);
        getTaskWorkerLinks().add(taskWorkerLink);
    }

    public void init() {
	super.init();

	// Force initialize
	getTaskWorkerLinks().size();
	getTaskContactLinks().size();
    }

    public String getStringPresentation() {
	return getName();
    }
    
    public String getCodeStringPresentation() {
	if (isEmpty(getTaskNo())) {
	    return getName();
	}
	return getTaskNo().trim() + (isEmpty(getName()) ? "" : (" " + getName()));
	
    }

    public double getWorkCost() {
        return workCost;
    }

    public void setWorkCost(double workCost) {
        this.workCost = workCost;
    }
    
    ////
    
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
    
    ////
 
    public String getEventId() {
	return getId() == null ? null : getId().toString();
    }

    public String getEventType() {
	return getClass().getSimpleName().toUpperCase();
    }
    
    public String getEventName() {
	return getName();
    }
    
    public Date getEventDate() {
	return getEndDateTime();
    }
}
