package org.plazmaforge.bsolution.contact.server.services;

import java.util.List;

import org.plazmaforge.bsolution.contact.common.beans.Contact;
import org.plazmaforge.bsolution.contact.common.beans.ContactHeader;
import org.plazmaforge.bsolution.contact.common.services.ContactService;
import org.plazmaforge.bsolution.organization.server.services.AbstractOrganizableService;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.criteria.Criteria;

public class ContactServiceImpl extends AbstractOrganizableService<Contact, Integer> implements ContactService {

    
    protected Class getEntityClass() {
	return Contact.class;
    }
    
    protected Class getEntityHeaderClass() {
	return ContactHeader.class;
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
