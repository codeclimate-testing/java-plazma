package org.plazmaforge.bsolution.base.server.services;

import org.plazmaforge.bsolution.base.EnterpriseContext;
import org.plazmaforge.bsolution.base.common.services.EnterpriseContextService;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.exception.FinderException;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;

public class EnterpriseContextServiceImpl extends AbstractEntityService<EnterpriseContext, Integer> implements EnterpriseContextService {

    private Integer ID = new Integer(1);

    protected Class getEntityClass() {
	return EnterpriseContext.class;
    }

    public EnterpriseContext load() throws DAOException, FinderException {
	EnterpriseContext context =  findById(ID);
	return context;
    }
    

}
