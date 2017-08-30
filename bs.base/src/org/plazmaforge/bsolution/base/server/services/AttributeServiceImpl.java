package org.plazmaforge.bsolution.base.server.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.bsolution.base.common.services.AttributeService;
import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.exception.RemoveException;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.ext.model.Attribute;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;
import org.plazmaforge.framework.util.DBUtils;


public class AttributeServiceImpl extends AbstractEntityService<Attribute, Integer> implements AttributeService {

    protected Class getEntityClass() {
        return Attribute.class;
    }
    
    public List<Attribute> findByEntity(IEntityConfig entity) throws DAOException {
        Criteria criteria = new Criteria();
        criteria.addFilter("entity.id", entity.getId());
        return getEntityManager().findAll(Attribute.class, criteria);
    }

    public List<Integer> findIdsByEntity(IEntityConfig entity) throws DAOException {
        Criteria criteria = new Criteria();
        criteria.addFilter("entity.id", entity.getId());
        List<Attribute> list = getEntityManager().findAll(Attribute.class, criteria);
        List<Integer> ids = new ArrayList<Integer>();
        if (list == null || list.isEmpty()) {
            return ids;
        }
        for (Attribute attr: list) {
            ids.add(attr.getId());
        }
        return ids;
    }

    public void removeByEntity(IEntityConfig entity) throws DAOException, RemoveException {
	try {
	    String entityId = ((IEntityConfig) entity).getId();
	    DBUtils.execute(getConnection(), "DELETE FROM SYS_ENTITY_ATTR_VALUE WHERE ENTITY_ID = " + entityId);
	    DBUtils.execute(getConnection(), "DELETE FROM SYS_ENTITY_ATTR WHERE ENTITY_ID = " + entityId);
	    onPostDelete(entity);
	} catch (SQLException ex ) {
	    throw new RuntimeException(ex);
	}
    }
    
    
    // PRE DELETE
    protected void onPreDelete(Object entity) {
	try {
	    Integer attributeId = null;
	    if (entity instanceof Integer) {
		attributeId = (Integer) entity;
	    } else {
		attributeId = ((Attribute) entity).getId();
	    }
	    DBUtils.execute(getConnection(), "DELETE FROM SYS_ENTITY_ATTR_VALUE WHERE ATTR_ID = " + attributeId);
	} catch (SQLException ex ) {
	    throw new RuntimeException(ex);
	}
    }

}
