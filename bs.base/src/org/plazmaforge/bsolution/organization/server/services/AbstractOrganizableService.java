package org.plazmaforge.bsolution.organization.server.services;

import java.io.Serializable;
import java.util.List;

import org.plazmaforge.bsolution.base.server.services.AbstractComplexService;
import org.plazmaforge.bsolution.organization.common.beans.OrganizationHeader;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.criteria.Criteria;

public abstract class AbstractOrganizableService<E, PK extends Serializable> extends AbstractComplexService<E, PK> {

    public static final String ORGANIZATION_ID_PROPERTY = "organizationId";
    
    private String organizationIdProperty = ORGANIZATION_ID_PROPERTY;
    
    public String getOrganizationIdProperty() {
        return organizationIdProperty;
    }

    public void setOrganizationIdProperty(String organizationIdProperty) {
        this.organizationIdProperty = organizationIdProperty;
    }

    public List findByOrganizationId(final Integer organizationId) throws DAOException {
	return findByOrganizationId(organizationId, null);
    }
    
    
    /**
     * @param organizationId
     * @return
     * @throws DAOException
     */
    public List findByOrganizationId(final Integer organizationId, final Criteria criteria) throws DAOException {
	criteria.addFilter(getOrganizationIdProperty(), organizationId);
	return getEntityManager().findAll(getEntityHeaderClass(), criteria);
    }

    /**
     * 
     * @param organization
     * @return
     * @throws DAOException
     */
    public List findByOrganizationId(OrganizationHeader organization) throws DAOException {
        return findByOrganizationId(organization.getId());
    }
}
