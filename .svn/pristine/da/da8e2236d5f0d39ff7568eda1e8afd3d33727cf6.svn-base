package org.plazmaforge.bsolution.organization.server.services;

import java.io.Serializable;
import java.util.List;

import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.criteria.Criteria;

public abstract class AbstractResponsableService<E, PK extends Serializable> extends AbstractOrganizableService<E, PK> {

public static final String RESPONSIBLE_ID_PROPERTY = "responsible.id";
    
    private String responsibleIdProperty = RESPONSIBLE_ID_PROPERTY;
    
    ////
    
    public String getResponsibleIdProperty() {
        return responsibleIdProperty;
    }

    public void setResponsibleIdProperty(String responsibleIdProperty) {
        this.responsibleIdProperty = responsibleIdProperty;
    }

    ////
    
    public List findByOrganizationId(final Integer organizationId) throws DAOException {
	return findByOrganizationId(organizationId, null, null);
    }
    
    public List findByOrganizationId(final Integer organizationId, final Criteria criteria) throws DAOException {
	return findByOrganizationId(organizationId, null, criteria);
    }

    
    
    public List findByOrganizationId(final Integer organizationId, final Integer responsibleId) throws DAOException {
	return findByOrganizationId(organizationId, responsibleId, null);
    }
    
    public List findByOrganizationId(final Integer organizationId, final Integer responsibleId, final Criteria criteria) throws DAOException {
	criteria.addFilter(getOrganizationIdProperty(), organizationId);
	if (responsibleId != null) {
	    criteria.addFilter(getResponsibleIdProperty(), responsibleId);
	}
	return getEntityManager().findAll(getEntityClass(), criteria);
    }    
}
