package org.plazmaforge.bsolution.base.server.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.plazmaforge.bsolution.base.common.beans.BusinessableElement;
import org.plazmaforge.bsolution.base.common.beans.IBusinessableOwner;
import org.plazmaforge.framework.erm.procedure.AbstractProcedure;

public class ERMBusinessableManager extends AbstractProcedure {

    public void execute(Connection cn, Map<String, Object> parameters) throws SQLException {
	try {
	    String entryPoint = getEntryPoint(parameters);
	    Object[] values = getParameterValues(parameters, 1, true);
	    Object data = values[0];
	    setEntityManager(getEntityManager(parameters));
	    if ("postLoad".equals(entryPoint)) {
		postLoad(cn, data);
	    } else if ("postSave".equals(entryPoint)) {
		postSave(cn, data);
	    } else if ("postDelete".equals(entryPoint)) {
		postDelete(cn, data);
	    } else {
		throw new RuntimeException("Entry point '" + entryPoint + "' not found");
	    }
	} catch (Exception ex) {
	   throw new RuntimeException(ex.getMessage());
	} finally {
	    setEntityManager(null);
	}
    }	
    
    protected void postLoad(Connection cn, Object data) {
	if (!isValidEntity(data)) {
	    return;
	}
	IBusinessableOwner owner = (IBusinessableOwner) data;
	BusinessableElement ce = getBusinessableElement(owner.getId());
	owner.setBusinessableElement(ce);
    }
    
    protected void postSave(Connection cn, Object data) {
	if (!isValidEntity(data)) {
	    return;
	}
	IBusinessableOwner owner = (IBusinessableOwner) data;
	BusinessableElement be = owner.getBusinessableElement();

	if (be.getId() == null) {
	    be.setId(owner.getId());
	    getEntityManager().insert(be);
	} else {
	    getEntityManager().update(be);
	}
    }
    
    protected void postDelete(Connection cn, Object data) {
	if (!isValidEntity(data)) {
	    return;
	}
	IBusinessableOwner owner = (IBusinessableOwner) data;
	BusinessableElement be = owner.getBusinessableElement();
	getEntityManager().delete(be);
    }
    
    protected boolean isValidEntity(final Object entity) {
	if (entity == null) {
	    return false;
	}
	if (!(entity instanceof IBusinessableOwner)) {
	    return false;
	}
	return true;
    }
    
    /**
     * Get <code>BusinessableElement</code> by id
     * @param id
     * @return
     */
    protected BusinessableElement getBusinessableElement(Integer id) {
	BusinessableElement ce = getEntityManager().loadById(BusinessableElement.class, id); // LOAD is not FIND
	ce.init();
	return ce;
    }
}
