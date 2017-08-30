package org.plazmaforge.bsolution.document.server.services;

import java.util.List;

import org.plazmaforge.bsolution.document.common.beans.DocumentRelation;
import org.plazmaforge.bsolution.document.common.services.DocumentRelationService;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;

public class DocumentRelationServiceImpl extends AbstractEntityService<DocumentRelation, Integer> implements DocumentRelationService {

    protected Class getEntityClass() {
        return DocumentRelation.class;
    }

    public List<DocumentRelation> sysLoadDocumentRelations() throws DAOException {
        return findAll();
    }
}
