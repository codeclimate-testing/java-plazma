package org.plazmaforge.bsolution.personality.server.services;

import java.io.Serializable;

import org.plazmaforge.bsolution.personality.common.services.PersonItemService;
import org.plazmaforge.framework.ext.service.GenericEntityService;


public class GenericPersonItemServiceImpl<E, PK extends Serializable> extends AbstractPersonItemService<E, Serializable> implements PersonItemService<E, Serializable>, GenericEntityService<E, Serializable> {

    private Class<E> entityClass;

    @Override
    public Class<E> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<E> entityClass) {
        this.entityClass = entityClass;
    }
    
    
}
