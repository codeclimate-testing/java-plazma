package org.plazmaforge.bsolution.base.server.services;

import org.plazmaforge.bsolution.base.common.services.DataTypeService;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.ext.model.DataType;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;

public class DataTypeServiceImpl extends AbstractEntityService implements DataTypeService {

    protected Class getEntityClass() {
        return DataType.class;
    }

    protected void prepareERMCriteria(Criteria criteria) {
	criteria.addFilter("enable", true);
    }
    
}
