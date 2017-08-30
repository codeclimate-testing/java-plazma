package org.plazmaforge.bsolution.partner.server.services;

import java.util.List;

import org.plazmaforge.bsolution.partner.common.beans.PartnerRepresentative;
import org.plazmaforge.bsolution.partner.common.services.PartnerRepresentativeService;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;

public class PartnerRepresentativeServiceImpl extends AbstractEntityService<PartnerRepresentative, Integer>  implements PartnerRepresentativeService {

    protected Class getEntityClass() {
        return PartnerRepresentative.class;
    }
    
    public List<PartnerRepresentative> findByPartner(final Integer partnerId) {
	    return findByPartner(partnerId, null);
    }

    public List<PartnerRepresentative> findByPartner(final Integer partnerId, Criteria criteria) {
	criteria.addFilter("partner.id", partnerId);
	return getEntityManager().findAll(getEntityHeaderClass(), criteria);
    }

}