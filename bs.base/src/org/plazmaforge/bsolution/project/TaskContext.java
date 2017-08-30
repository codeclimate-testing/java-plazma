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

package org.plazmaforge.bsolution.project;

import org.plazmaforge.bsolution.contact.common.beans.ContactTitle;
import org.plazmaforge.bsolution.partner.common.beans.PartnerTitle;
import org.plazmaforge.bsolution.project.common.beans.ProjectHeader;
import org.plazmaforge.bsolution.project.common.beans.TaskPriority;
import org.plazmaforge.bsolution.project.common.beans.TaskResult;
import org.plazmaforge.bsolution.project.common.beans.TaskStatus;
import org.plazmaforge.bsolution.project.common.beans.TaskType;
import org.plazmaforge.framework.ext.model.BaseEntity;
import org.plazmaforge.framework.platform.structure.ModuleContext;


/**
 * @author Oleh Hapon
 *
 * $Id: TaskContext.java,v 1.3 2010/12/05 07:56:00 ohapon Exp $
 * 
 */

public class TaskContext extends BaseEntity  implements ModuleContext {

    private PartnerTitle partner;

    private ContactTitle responsible;

    private ProjectHeader project;

    private TaskPriority taskPriority;
    
    private TaskPriority initTaskPriority;

    private TaskStatus taskStatus;
    
    private TaskStatus initTaskStatus;

    private TaskType taskType;
    
    private TaskType initTaskType;

    private TaskResult taskResult;

    public PartnerTitle getPartner() {
	return partner;
    }

    public void setPartner(PartnerTitle partner) {
	this.partner = partner;
    }

    public ContactTitle getResponsible() {
	return responsible;
    }

    public void setResponsible(ContactTitle responsible) {
	this.responsible = responsible;
    }

    public ProjectHeader getProject() {
	return project;
    }

    public void setProject(ProjectHeader project) {
	this.project = project;
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
    
    public TaskType getInitTaskType() {
        return initTaskType;
    }

    public void setInitTaskType(TaskType initTaskType) {
        this.initTaskType = initTaskType;
    }

    public TaskPriority getInitTaskPriority() {
        return initTaskPriority;
    }

    public void setInitTaskPriority(TaskPriority initTaskPriority) {
        this.initTaskPriority = initTaskPriority;
    }

    public TaskStatus getInitTaskStatus() {
        return initTaskStatus;
    }

    public void setInitTaskStatus(TaskStatus initTaskStatus) {
        this.initTaskStatus = initTaskStatus;
    }

    ////
    
    public TaskType getDefaultTaskType() {
        return taskType == null ? initTaskType : taskType;
    }    
    
    public TaskPriority getDefaultTaskPriority() {
        return taskPriority == null ? initTaskPriority : taskPriority;
    }

    public TaskStatus getDefaultTaskStatus() {
        return taskStatus == null ? initTaskStatus : taskStatus;
    }

}
