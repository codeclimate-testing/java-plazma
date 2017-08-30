package org.plazmaforge.bsolution.personality.server.services;

import java.io.Serializable;
import java.util.List;

import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;

public abstract class AbstractPersonItemService<E, PK extends Serializable> extends AbstractEntityService<E, PK> {

    
    public List<E> findByPersonId(Integer personId) throws DAOException {
	return findByPersonId(personId, null);
    }

    
    public List<E> findByPersonId(final Integer personId, final Criteria criteria) {
	criteria.addFilter("personId", personId);
	return getEntityManager().findAll(getEntityClass(), criteria);
    }

}
