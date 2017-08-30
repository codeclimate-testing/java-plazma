package org.plazmaforge.bsolution.base.server.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.core.exception.CreateException;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.exception.FinderException;
import org.plazmaforge.framework.core.exception.RemoveException;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.erm.procedure.AbstractProcedure;
import org.plazmaforge.framework.ext.model.Attribute;
import org.plazmaforge.framework.ext.model.AttributeHelper;
import org.plazmaforge.framework.ext.model.AttributeValue;
import org.plazmaforge.framework.ext.model.IAttributeHolder;
import org.plazmaforge.framework.ext.model.AttributeHelper.AttributeManager;

public class ERMAttributeManager extends AbstractProcedure {

    private AttributeHelper attributeHelper;
    
    public void execute(Connection cn, Map<String, Object> parameters) throws SQLException {
	try {
	    String entryPoint = getEntryPoint(parameters);
	    Object[] values = getParameterValues(parameters, 1, true);
	    Object data = values[0];
	    IAttributeHolder attributeHolder = getAttributeHolder(data);
	    setEntityManager(getEntityManager(parameters));
	    if ("loadAttributeValues".equals(entryPoint)) {
		getAttributeHelper().loadAttributeValues(attributeHolder);
	    } else if ("saveAttributeValues".equals(entryPoint)) {
		getAttributeHelper().saveAttributeValues(attributeHolder);
	    } else if ("deleteAttributeValues".equals(entryPoint)) {
		getAttributeHelper().deleteAttributeValues(attributeHolder);
	    } else {
		throw new RuntimeException("Entry point '" + entryPoint + "' not found");
	    }
	} catch (Exception ex) {
	   throw new RuntimeException(ex);
	} finally {
	    setEntityManager(null);
	}
    }	

    protected AttributeHelper getAttributeHelper() {
	if (attributeHelper == null) {
	    attributeHelper = new AttributeHelper(new AttributeManagerImpl());
	}
        return attributeHelper;
    }
    
    protected IAttributeHolder getAttributeHolder(Object data) {
	if (!(data instanceof IAttributeHolder)) {
	    return null;
	}
	return (IAttributeHolder) data;
    }

 
    public class AttributeManagerImpl implements AttributeManager {
	
 	public Integer doInsertAttribute(Attribute attribute) throws DAOException, CreateException {
 	    return (Integer) getEntityManager().insert(attribute);
 	}

 	public List<Attribute> doFindAttributesByEntity(IEntityConfig entity) throws DAOException {
 	   Criteria criteria = new Criteria();
 	   criteria.addFilter("entity.id", entity.getId());
 	   return getEntityManager().findAll(Attribute.class, criteria);
 	}

 	public List<AttributeValue> doFindByOwner(IEntityConfig entity, Integer ownerId) throws DAOException {
  	   Criteria criteria = new Criteria();
  	   criteria.addFilter("entity.id", entity.getId());
  	   criteria.addFilter("ownerId", ownerId);
  	   return getEntityManager().findAll(AttributeValue.class, criteria);
 	}
 	
 	public void doInsertAttributeValue(AttributeValue attributeValue) throws DAOException, CreateException {
 	    getEntityManager().insert(attributeValue);
 	}
 	    
 	public void doUpdateAttributeValue(AttributeValue attributeValue) throws DAOException, FinderException {
 	    getEntityManager().update(attributeValue);
 	}
 	    
 	public void doDeleteAttributeValue(AttributeValue attributeValue) throws DAOException, RemoveException {
 	    getEntityManager().delete(attributeValue);
 	}
    }

    
}
