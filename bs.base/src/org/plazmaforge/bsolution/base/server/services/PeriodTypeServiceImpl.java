package org.plazmaforge.bsolution.base.server.services;

import java.util.List;

import org.plazmaforge.bsolution.base.common.beans.PeriodType;
import org.plazmaforge.bsolution.base.common.services.PeriodTypeService;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.exception.FinderException;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;

public class PeriodTypeServiceImpl extends AbstractEntityService<PeriodType, Integer> implements PeriodTypeService {

    protected Class getEntityClass() {
	return PeriodType.class;
    }

    public PeriodType sysFindById(Integer id) throws DAOException, FinderException {
	return findById(id);
    }
    
    public List<PeriodType> sysFindAll() throws DAOException {
	return findAll();
    }
}
