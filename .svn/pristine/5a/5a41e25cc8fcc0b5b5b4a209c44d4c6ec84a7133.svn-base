package org.plazmaforge.bsolution.base.server.services;

import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.bsolution.base.common.services.AttributeService;
import org.plazmaforge.bsolution.base.common.services.SystemEntityService;
import org.plazmaforge.framework.config.object.EntityConfig;
import org.plazmaforge.framework.config.object.EntityTypeConfig;
import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.config.object.IEntityTypeConfig;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.exception.FinderException;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.core.criteria.Filter;
import org.plazmaforge.framework.core.criteria.ValueFilter;
import org.plazmaforge.framework.ext.model.Attribute;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;

public class SystemEntityServiceImpl  extends AbstractEntityService<IEntityConfig, String> implements SystemEntityService {
    
    private AttributeService attributeService;



    protected Class getEntityClass() {
	return EntityConfig.class;
    }
    
    
    public void setAttributeService(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    protected void prepareERMCriteria(Criteria criteria) {
	criteria.addFilter("id", "<SYS_ROW>", "<>");
    }

    public List<IEntityConfig> findByEntityType(String entityType) throws DAOException {
	return findByEntityType(entityType, null);
    }

    public List<IEntityConfig> findByEntityTypeAndForm(String entityType) throws DAOException {
	return findByEntityType(entityType, true, true, true, true, null, false);
    }

    public List<IEntityConfig> findByEntityType(String entityType,
	    Boolean isEnable, Boolean isMaster, Boolean isBean, Boolean isForm,
	    Boolean isSecure, Boolean isSystem) throws DAOException {
	Boolean[] args = new Boolean[6];

	args[0] = isEnable == null ? Boolean.TRUE : isEnable;
	args[1] = isMaster == null ? Boolean.TRUE : isMaster;
	args[2] = isBean == null ? Boolean.TRUE : isBean;
	args[3] = isForm;
	args[4] = isSecure;
	args[5] = isSystem;// == null ? Boolean.FALSE : isSystem;

	return findByEntityType(entityType, args);
    }

    protected String[] ARGS = { "enable", "master", "bean", "form", "secure", "system" };

    public List<IEntityConfig> findByEntityType(String entityType, Boolean[] args) throws DAOException {
	Criteria criteria = createERMCriteria();
	if (entityType != null) {
	    criteria.addFilter("entityType.code", entityType);
	}

	if (args == null || args.length == 0) {
	    addDefaultParameter(criteria);
	    return getEntityManager().findAll(getEntityClass(), criteria);
	}

	Boolean arg = null;
	int paramCount = 0;
	for (int i = 0; i < args.length; i++) {
	    if (i == ARGS.length) {
		break;
	    }
	    arg = args[i];
	    if (arg == null) {
		continue;
	    }
	    criteria.addFilter(ARGS[i], arg);
	    paramCount++;
	}
	if (paramCount == 0) {
	    addDefaultParameter(criteria);
	}
	return getEntityManager().findAll(getEntityClass(), criteria);
    }

    protected void addDefaultParameter(Criteria criteria) {
	criteria.addFilter("enable", true);
    }

    public List<IEntityConfig> findByCustom() throws DAOException {
	List<IEntityConfig> list = findAll();
	List<IEntityConfig> result = new ArrayList<IEntityConfig>();
	for (IEntityConfig entity : list) {
	    if (entity.isCustom()) {
		result.add(entity);
	    }
	}
	return result;
    }

    public List<IEntityConfig> findByCustomAttribute() throws DAOException {
	List<IEntityConfig> list = findAll();
	List<IEntityConfig> result = new ArrayList<IEntityConfig>();
	for (IEntityConfig entity : list) {
	    if (entity.isCustomAttribute()) {
		result.add(entity);
	    }
	}
	return result;
    }

    public List<IEntityConfig> findByCustomize() throws DAOException {
	return findByCustomize(null);
    }

    public List<IEntityConfig> findByCustomize(Criteria criteria) throws DAOException {
	criteria.addOrFilter(new ValueFilter("custom", true), new ValueFilter("customAttribute", true));
	return getEntityManager().findAll(getEntityHeaderClass(), criteria);
    }

    
    
    protected boolean findInArray(String str, String[] array) {
	if (str == null || array == null) {
	    return false;
	}
	for (String a : array) {
	    if (a.equals(str)) {
		return true;
	    }
	}
	return false;
    }
    
    @Override
    protected void onPreSave(Object entity) {
	IEntityConfig entityConfig = getCastEntity(entity);
	List attributes = entityConfig.getAttributes();
	for (Object obj : attributes) {
	    if (obj instanceof Attribute) {
		Attribute attr = (Attribute) obj;
		if (attr.getEntity() == null) {
		    attr.setEntity(entityConfig);
		}
	    }
	}
    }
    
    @Override
    protected void onPostSave(Object entity) {
	try {
	    IEntityConfig entityConfig = getCastEntity(entity);
	    List newAttributes = entityConfig.getAttributes();
	    List<Integer> oldIds = attributeService.findIdsByEntity(entityConfig);
	    attributeService.synchronizeCollection(newAttributes, oldIds);
	} catch (ApplicationException ex) {
	    throw new RuntimeException(ex);
	}
	
    }

    // POST DELETE
    @Override
    protected void onPostDelete(Object obj) {
	try {
	    IEntityConfig entity = null;
	    if (obj instanceof String) { 
		entity = new EntityConfig();
		entity.setId((String) obj);
	    } else {
		entity = getCastEntity(entity);
	    }
	    attributeService.removeByEntity(entity);
	} catch (ApplicationException ex) {
	    throw new RuntimeException(ex);
	}
    }
    
    // POST LOAD
    @Override
    public void onPostLoad(Object entity) {
	try {
	    IEntityConfig entityConfig = getCastEntity(entity);
	    List attributes = attributeService.findByEntity(entityConfig);
	    entityConfig.setAttributes(attributes);
	} catch (ApplicationException ex) {
	    throw new RuntimeException(ex);
	}
    }
    
    public IEntityTypeConfig findEntityTypeById(String id) throws DAOException, FinderException {
	return (IEntityTypeConfig) getEntityManager().loadById(EntityTypeConfig.class, id);
    }

    public List<IEntityConfig> getEntities() throws ApplicationException {
	return findAll();
    }

}
