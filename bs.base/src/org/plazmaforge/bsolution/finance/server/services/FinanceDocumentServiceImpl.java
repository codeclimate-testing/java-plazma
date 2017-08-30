package org.plazmaforge.bsolution.finance.server.services;

import java.util.List;

import org.plazmaforge.bsolution.finance.common.beans.EntryItem;
import org.plazmaforge.bsolution.finance.common.beans.FinanceDocument;
import org.plazmaforge.bsolution.finance.common.services.FinanceDocumentService;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;

public class FinanceDocumentServiceImpl extends AbstractEntityService<FinanceDocument, Integer> implements FinanceDocumentService {
    
    protected Class getEntityClass() {
        return FinanceDocument.class;
    }
    
    public List<EntryItem> findEntryItemsByFinanceDocument(Integer id) throws DAOException {
	return getEntityManager().findAll(getEntityClass(), "id", id);
    }


}
