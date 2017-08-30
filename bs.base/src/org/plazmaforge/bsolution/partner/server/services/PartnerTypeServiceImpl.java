package org.plazmaforge.bsolution.partner.server.services;

import org.plazmaforge.bsolution.partner.common.beans.PartnerType;
import org.plazmaforge.bsolution.partner.common.services.PartnerTypeService;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.exception.FinderException;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;

public class PartnerTypeServiceImpl extends AbstractEntityService<PartnerType, Integer> implements  PartnerTypeService {

    protected Class getEntityClass() {
	return PartnerType.class;
    }

    public PartnerType sysFindById(Integer id) throws DAOException, FinderException {
	return findById(id);
    }

}
