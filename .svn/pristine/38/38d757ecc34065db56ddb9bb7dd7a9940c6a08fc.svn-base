package org.plazmaforge.bsolution.project.server.services;

import org.plazmaforge.bsolution.organization.server.services.AbstractResponsableService;
import org.plazmaforge.bsolution.project.TaskContext;
import org.plazmaforge.bsolution.project.common.beans.TaskPriority;
import org.plazmaforge.bsolution.project.common.beans.TaskStatus;
import org.plazmaforge.bsolution.project.common.beans.TaskType;
import org.plazmaforge.bsolution.project.common.services.TaskContextService;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.exception.FinderException;

public class ERMTaskContextService extends AbstractResponsableService<TaskContext, Integer> implements TaskContextService {

    private Integer ID = new Integer(1);

    protected Class getEntityClass() {
	return TaskContext.class;
    }

    public TaskContext load() throws DAOException, FinderException {
	TaskContext context =  findById(ID);
	context.setInitTaskType(findTaskType());
	context.setInitTaskStatus(findTaskStatus());
	context.setInitTaskPriority(findTaskPriority());
	return context;
    }

    protected TaskType findTaskType() throws DAOException, FinderException {
	return getEntityManager().load(TaskType.class, "code", TaskType.STANDARD_TYPE);
    }

    protected TaskStatus findTaskStatus() throws DAOException, FinderException {
	return getEntityManager().load(TaskStatus.class, "code", TaskStatus.NOTSTARTED_STATUS);
    }

    protected TaskPriority findTaskPriority() throws DAOException, FinderException {
	return getEntityManager().load(TaskPriority.class, "code", TaskPriority.NORMAL_PRIORITY);
    }
    
}
