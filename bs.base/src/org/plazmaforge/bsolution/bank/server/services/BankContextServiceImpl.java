package org.plazmaforge.bsolution.bank.server.services;

import org.plazmaforge.bsolution.bank.BankContext;
import org.plazmaforge.bsolution.bank.common.services.BankContextService;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.exception.FinderException;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;

public class BankContextServiceImpl extends AbstractEntityService<BankContext, Integer> implements BankContextService {

    private Integer ID = new Integer(1);

    protected Class getEntityClass() {
	return BankContext.class;
    }

    public BankContext load() throws DAOException, FinderException {
	return findById(ID);
    }

}
