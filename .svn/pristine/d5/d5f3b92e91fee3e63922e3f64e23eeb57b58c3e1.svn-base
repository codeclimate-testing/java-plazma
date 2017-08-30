package org.plazmaforge.bsolution.partner.server.services;

import java.io.Serializable;

import org.plazmaforge.bsolution.partner.common.services.PartnerableService;
import org.plazmaforge.framework.ext.service.GenericEntityService;

public class GenericPartnerableServiceImpl <E, PK extends Serializable> extends AbstractPartnerableService<E, Serializable> implements PartnerableService<E, Serializable>, GenericEntityService<E, Serializable>{

    private Class<E> entityClass;

    @Override
    public Class<E> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<E> entityClass) {
        this.entityClass = entityClass;
    }
}
