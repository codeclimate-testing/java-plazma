package org.plazmaforge.bsolution.base.server.services;

import java.util.List;

import org.plazmaforge.bsolution.base.common.services.AttributeValueService;
import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.ext.model.Attribute;
import org.plazmaforge.framework.ext.model.AttributeHelper;
import org.plazmaforge.framework.ext.model.AttributeValue;
import org.plazmaforge.framework.ext.model.IAttributeHolder;
import org.plazmaforge.framework.ext.model.AttributeHelper.AttributeManager;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;

public class AttributeValueServiceImpl extends AbstractEntityService<AttributeValue, Integer> implements AttributeValueService {

    protected Class getEntityClass() {
        return AttributeValue.class;
    }
    
    private AttributeHelper attributeHelper;
    
    public Integer createAttribute(Attribute attribute) throws DAOException {
	return (Integer) getEntityManager().insert(attribute);
    }
    
    public List<Attribute> findAttributesByEntity(IEntityConfig entity) throws DAOException {
	Criteria criteria = new Criteria();
	criteria.addFilter("entity.id", entity.getId());
	return getEntityManager().findAll(Attribute.class, criteria);
    }

    public List<AttributeValue> findByOwner(IEntityConfig entity, Integer ownerId) throws DAOException {
	Criteria criteria = new Criteria();
	criteria.addFilter("entity.id", entity.getId());
	criteria.addFilter("ownerId", ownerId);
	return getEntityManager().findAll(AttributeValue.class, criteria);
    }
    
    private AttributeHelper getAttributeHelper( ){
	if (attributeHelper == null) {
	    attributeHelper = new AttributeHelper(new AttributeManagerImpl());
	}
	return attributeHelper;
    }
    
    public void loadAttributeValues(IAttributeHolder holder) throws DAOException {
	try {
	    getAttributeHelper().loadAttributeValues(holder);
	} catch (DAOException e) {
	    throw e;
	} catch (ApplicationException e) {
	    throw new DAOException(e);
	}
    }
    
    public List<AttributeValue> getAttributes(IAttributeHolder holder) throws DAOException {
	try {
	    return getAttributeHelper().getAttributes(holder);
	} catch (DAOException e) {
	    throw e;
	} catch (ApplicationException e) {
	    throw new DAOException(e);
	}
    }
    
    public void storeAttributeValues(IAttributeHolder holder) throws DAOException {
	try {
	    getAttributeHelper().saveAttributeValues(holder);
	} catch (DAOException e) {
	    throw e;
	} catch (ApplicationException e) {
	    throw new DAOException(e);
	}
    }

    public void removeAttributeValues(IAttributeHolder holder) throws DAOException {
	try {
	    getAttributeHelper().deleteAttributeValues(holder);
	} catch (DAOException e) {
	    throw e;
	} catch (ApplicationException e) {
	    throw new DAOException(e);
	}
    }

     
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public class AttributeManagerImpl implements AttributeManager {
	
	public Integer doInsertAttribute(Attribute attribute) throws ApplicationException {
	    return createAttribute(attribute);
	}

	public List<Attribute> doFindAttributesByEntity(IEntityConfig entity) throws ApplicationException {
	    return findAttributesByEntity(entity);
	}

	public List<AttributeValue> doFindByOwner(IEntityConfig entity, Integer ownerId) throws ApplicationException {
	    return findByOwner(entity, ownerId);
	}
	
	
	public void doInsertAttributeValue(AttributeValue attributeValue)  throws ApplicationException {
	    create(attributeValue);
	}
	    
	public void doUpdateAttributeValue(AttributeValue attributeValue)  throws ApplicationException {
	    store(attributeValue);
	}
	
	    
	public void doDeleteAttributeValue(AttributeValue attributeValue)  throws ApplicationException {
	    remove(attributeValue);
	}
   }

}
