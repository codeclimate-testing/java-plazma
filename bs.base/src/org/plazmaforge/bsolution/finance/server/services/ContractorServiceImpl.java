package org.plazmaforge.bsolution.finance.server.services;


import org.plazmaforge.bsolution.finance.common.beans.Contractor;
import org.plazmaforge.bsolution.finance.common.services.ContractorService;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.ext.service.OwnCriteriaService;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;

public class ContractorServiceImpl extends AbstractEntityService<Contractor, Integer> implements ContractorService, OwnCriteriaService {

    protected Class getEntityClass() {
	return Contractor.class;
    }
 

    public Contractor findByOwnerId(Integer ownerId) throws DAOException {
	return getEntityManager().load(getEntityHeaderClass(), "ownerId", ownerId);
    }
    

}
