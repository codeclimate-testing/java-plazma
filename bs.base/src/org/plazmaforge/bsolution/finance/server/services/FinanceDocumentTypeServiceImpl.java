package org.plazmaforge.bsolution.finance.server.services;

import org.plazmaforge.bsolution.finance.common.beans.FinanceDocumentType;
import org.plazmaforge.bsolution.finance.common.services.FinanceDocumentTypeService;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;

public class FinanceDocumentTypeServiceImpl extends AbstractEntityService<FinanceDocumentType, Integer> implements FinanceDocumentTypeService {

    protected Class getEntityClass() {
        return FinanceDocumentType.class;
    }

}
