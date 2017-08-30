package org.plazmaforge.bsolution.document.server.services;

import java.io.Serializable;

import org.plazmaforge.bsolution.document.common.services.GenericDocumentService;

public class GenericDocumentServiceImpl<E, PK extends Serializable> extends AbstractDocumentService<E, Serializable> implements GenericDocumentService<E, Serializable> {

    
    private Class<E> entityClass;

    @Override
    public Class<E> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<E> entityClass) {
        this.entityClass = entityClass;
    }
}
