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

import org.plazmaforge.bsolution.contact.common.beans.ContactHeader;
import org.plazmaforge.bsolution.contact.common.beans.ContactTitle;
import org.plazmaforge.bsolution.project.common.beans.ProjectHeader;
import org.plazmaforge.bsolution.project.common.beans.TaskPriority;
import org.plazmaforge.bsolution.project.common.beans.TaskResult;
import org.plazmaforge.bsolution.project.common.beans.TaskStatus;
import org.plazmaforge.bsolution.project.common.beans.TaskType;
import org.plazmaforge.bsolution.project.common.services.TaskContextService;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.service.ServiceFactory;


/**
 * @author Oleh Hapon
 *
 * $Id: TaskEnvironment.java,v 1.3 2010/12/05 07:56:00 ohapon Exp $
 * 
 */

public class TaskEnvironment {

    private static TaskEnvironment instance;

    private TaskContext context;

    private TaskEnvironment() {
	// context = new TaskContext();
    }

    public static TaskEnvironment getInstance() {
	if (instance == null) {
	    instance = new TaskEnvironment();
	    instance.loadContext();
	}
	return instance;

    }

    public static TaskContext getContext() {
	return getInstance().context;
    }

    /**
     * Load Context
     * 
     */
    private void loadContext() {
	try {
	    context = ((TaskContextService) ServiceFactory.getService(TaskContextService.class)).load();

	    if (context == null) {
		throw new Exception("TaskContext is null");
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	} finally {
	    if (context == null) {
		context = new TaskContext();
	    }
	}

    }

    public static void refresh() throws ApplicationException {
	getInstance().loadContext();
    }

    public static ProjectHeader getProject() {
	return getContext().getProject();
    }

    public static ContactTitle getResponsible() {
	return getContext().getResponsible() == null ? ProjectEnvironment.getResponsible() : getContext().getResponsible();
    }

    public static TaskPriority getTaskPriority() {
	return getContext().getTaskPriority();
    }

    public static TaskPriority getDefaultTaskPriority() {
	return getContext().getDefaultTaskPriority();
    }
    
    public static TaskResult getTaskResult() {
	return getContext().getTaskResult();
    }

    public static TaskStatus getTaskStatus() {
	return getContext().getTaskStatus();
    }

    public static TaskStatus getDefaultTaskStatus() {
	return getContext().getDefaultTaskStatus();
    }

    public static TaskType getTaskType() {
	return getContext().getTaskType();
    }
    
    public static TaskType getDefaultTaskType() {
	return getContext().getDefaultTaskType();
    }
    
}
