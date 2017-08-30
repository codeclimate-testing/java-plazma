package org.plazmaforge.bsolution.organization.server.services;

import java.io.Serializable;
import org.plazmaforge.bsolution.organization.common.services.GenericOrganizableService;

public class GenericOrganizableServiceImpl<E, PK extends Serializable> extends AbstractOrganizableService<E, Serializable> implements GenericOrganizableService<E, Serializable> {

    private Class<E> entityClass;

    @Override
    public Class<E> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<E> entityClass) {
        this.entityClass = entityClass;
    }


}
