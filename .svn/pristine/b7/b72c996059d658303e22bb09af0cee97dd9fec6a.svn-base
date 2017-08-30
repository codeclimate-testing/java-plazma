package org.plazmaforge.bsolution.project.server.services;

import java.util.List;

import org.plazmaforge.bsolution.organization.server.services.AbstractOrganizableService;
import org.plazmaforge.bsolution.project.common.beans.Project;
import org.plazmaforge.bsolution.project.common.services.ProjectService;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.criteria.Criteria;

public class ERMProjectService extends AbstractOrganizableService<Project, Integer> implements ProjectService {

    
    protected Class getEntityClass() {
	return Project.class;
    }
    
    public List findByOrganizationId(final Integer organizationId, final Integer partnerId) throws DAOException {
	return findByOrganizationId(organizationId, partnerId, null, null);
    }
    
    public List findByOrganizationId(final Integer organizationId, final Integer partnerId, final Criteria criteria) throws DAOException {
	return findByOrganizationId(organizationId, partnerId, null, criteria);
    }

    public List findByOrganizationId(final Integer organizationId, final Integer partnerId, final Integer responsibleId) throws DAOException {
	return findByOrganizationId(organizationId, partnerId, responsibleId, null);
    }
    
    public List findByOrganizationId(final Integer organizationId, final Integer partnerId, final Integer responsibleId, final Criteria criteria) throws DAOException {
	criteria.addFilter("organization.id", organizationId);
	if (partnerId != null) {
	    criteria.addFilter("partner.id", partnerId);
	}
	if (responsibleId != null) {
	    criteria.addFilter("responsible.id", responsibleId);
	}
	return getEntityManager().findAll(getEntityHeaderClass(), criteria);
    }    
}
