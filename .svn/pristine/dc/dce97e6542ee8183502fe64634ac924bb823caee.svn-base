package org.plazmaforge.bsolution.contact.server.services;

import org.plazmaforge.bsolution.contact.ContactContext;
import org.plazmaforge.bsolution.contact.common.services.ContactContextService;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.exception.FinderException;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;

public class ContactContextServiceImpl extends AbstractEntityService<ContactContext, Integer> implements ContactContextService {

    private Integer ID = new Integer(1);

    protected Class getEntityClass() {
	return ContactContext.class;
    }

    public ContactContext load() throws DAOException, FinderException {
	return findById(ID);
    }

}
