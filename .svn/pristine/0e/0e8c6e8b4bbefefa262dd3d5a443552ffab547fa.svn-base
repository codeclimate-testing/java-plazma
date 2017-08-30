package org.plazmaforge.bsolution.base.server.services;

import java.sql.SQLException;
import java.util.List;

import org.plazmaforge.bsolution.base.common.services.EnumerationService;
import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.core.data.Enumeration;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;
import org.plazmaforge.framework.util.DBUtils;

public class EnumerationServiceImpl extends AbstractEntityService<Enumeration, Integer> implements EnumerationService {

    protected Class getEntityClass() {
	return Enumeration.class;
    }
    
    public List<Enumeration> findByEntity(IEntityConfig entity) throws DAOException {
        Criteria criteria = new Criteria();
        criteria.addFilter("entity.id", entity.getId());
        return getEntityManager().findAll(Enumeration.class, criteria);
    }
    
    public void removeByEntity(IEntityConfig entity) throws DAOException {
   	try {
   	    DBUtils.execute(getConnection(), "DELETE FROM SYS_ENUMERATION WHERE ENTITY_ID = " + entity.getId());
   	    onPostDelete(entity);
   	} catch (SQLException ex ) {
   	    throw new RuntimeException(ex);
   	}
   }

}
