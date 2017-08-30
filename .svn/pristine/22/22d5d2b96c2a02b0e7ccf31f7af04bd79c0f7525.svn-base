package org.plazmaforge.bsolution.project.server.services;

import org.plazmaforge.bsolution.organization.server.services.AbstractResponsableService;
import org.plazmaforge.bsolution.project.ProjectContext;
import org.plazmaforge.bsolution.project.common.beans.ProjectStatus;
import org.plazmaforge.bsolution.project.common.beans.ProjectType;
import org.plazmaforge.bsolution.project.common.services.ProjectContextService;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.exception.FinderException;

public class ERMProjectContextService extends AbstractResponsableService<ProjectContext, Integer> implements ProjectContextService {

    private Integer ID = new Integer(1);

    protected Class getEntityClass() {
	return ProjectContext.class;
    }

    public ProjectContext load() throws DAOException, FinderException {
	ProjectContext context =  findById(ID);
	context.setInitProjectType(findProjectType());
	context.setInitProjectStatus(findProjectStatus());
	return context;
    }
    
    protected ProjectType findProjectType() throws DAOException, FinderException {
	return getEntityManager().load(ProjectType.class, "code", ProjectType.STANDARD_TYPE);
    }

    protected ProjectStatus findProjectStatus() throws DAOException, FinderException {
	return getEntityManager().load(ProjectStatus.class, "code", ProjectStatus.NOTSTARTED_STATUS);
    }
}
