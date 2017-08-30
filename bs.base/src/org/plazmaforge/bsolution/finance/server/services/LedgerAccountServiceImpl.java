package org.plazmaforge.bsolution.finance.server.services;

import org.plazmaforge.bsolution.finance.common.beans.LedgerAccount;
import org.plazmaforge.bsolution.finance.common.services.LedgerAccountService;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.ext.service.OwnCriteriaService;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;

public class LedgerAccountServiceImpl extends AbstractEntityService<LedgerAccount, Integer> implements LedgerAccountService, OwnCriteriaService {

    protected Class getEntityClass() {
        return LedgerAccount.class;
    }
    
    public LedgerAccount findByCode(final String code) throws DAOException {
	return getEntityManager().load(getEntityClass(), "code", code);
    }
    
}
