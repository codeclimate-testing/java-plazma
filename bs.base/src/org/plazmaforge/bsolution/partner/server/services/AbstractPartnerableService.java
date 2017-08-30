package org.plazmaforge.bsolution.partner.server.services;

import java.io.Serializable;
import java.util.List;

import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;

public abstract class AbstractPartnerableService <E, PK extends Serializable> extends AbstractEntityService<E, PK> {

    private String partnerIdProperty = "partnerId";
    
    public String getPartnerIdProperty() {
        return partnerIdProperty;
    }

    public void setPartnerIdProperty(String partnerIdProperty) {
        this.partnerIdProperty = partnerIdProperty;
    }

    public List findByPartnerId(Integer partnerId) throws DAOException {
	return findByPartnerId(partnerId, null);
    }
    
    public List findByPartnerId(final Integer partnerId, final Criteria criteria) {
	criteria.addFilter(getPartnerIdProperty(), partnerId);
	return getEntityManager().findAll(getEntityClass(), criteria);
    }


}
