package org.plazmaforge.bsolution.organization.server.services;

import java.io.Serializable;

import org.plazmaforge.bsolution.organization.common.services.GenericStructurableService;

public class GenericStructurableServiceImpl<E, PK extends Serializable> extends AbstractOrganizableService<E, Serializable> implements  GenericStructurableService<E, Serializable> {

    private Class<E> entityClass;

    @Override
    public Class<E> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<E> entityClass) {
        this.entityClass = entityClass;
    }
}
