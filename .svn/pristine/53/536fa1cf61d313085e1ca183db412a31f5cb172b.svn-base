package org.plazmaforge.bsolution.base.server.services;

import org.plazmaforge.bsolution.base.common.beans.SystemPreference;
import org.plazmaforge.bsolution.base.common.services.SystemPreferenceService;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.exception.FinderException;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;

public class SystemPreferenceServiceImpl extends AbstractEntityService<SystemPreference, Integer> implements SystemPreferenceService {

    private Integer ID = new Integer(1);

    protected Class getEntityClass() {
	return SystemPreference.class;
    }

    public SystemPreference load() throws DAOException, FinderException {
	return findById(ID);
    }

}
