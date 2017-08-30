package org.plazmaforge.bsolution.organization.server.services;

import java.io.Serializable;

import org.plazmaforge.bsolution.organization.common.beans.IWarehouse;
import org.plazmaforge.bsolution.organization.common.beans.Warehouse;
import org.plazmaforge.bsolution.organization.common.services.GenericWarehouseService;
import org.plazmaforge.framework.core.exception.DAOException;

public class GenericWarehouseServiceImpl<E, PK extends Serializable> extends GenericStructurableServiceImpl<E, Serializable> implements GenericWarehouseService<E, Serializable> {

    private boolean isWarehouse;
   
    public void setEntityClass(Class<E> entityClass) {
	super.setEntityClass(entityClass);
        this.isWarehouse = entityClass != null && entityClass.getName().equals(Warehouse.class.getName());
    }
    
    public IWarehouse findByOwnerId(Integer ownerId) throws DAOException {
	if (!isWarehouse) {
	    return null;
	}
	return getEntityManager().load(Warehouse.class, "ownerId", ownerId);
    }
    
}
