package org.plazmaforge.bsolution.document.server.services;

import java.util.List;

import org.plazmaforge.bsolution.document.common.beans.DocumentStatus;
import org.plazmaforge.bsolution.document.common.services.DocumentStatusService;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;

public class DocumentStatusServiceImpl extends AbstractEntityService<DocumentStatus, Integer> implements  DocumentStatusService {

    protected Class getEntityClass() {
        return DocumentStatus.class;
    }
    
    public List<DocumentStatus> findByType(String documentType) throws DAOException {
	if (documentType == null) {
	    return null;
	}
	return getEntityManager().findAll(getEntityClass(), "documentType.entity.id", documentType);
    }
}
