package org.plazmaforge.bsolution.organization.server.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.plazmaforge.bsolution.organization.common.beans.IWarehouse;
import org.plazmaforge.framework.erm.procedure.AbstractProcedure;
import org.plazmaforge.framework.util.DBUtils;

public class ERMWarehouseManager extends AbstractProcedure {

    public void execute(Connection cn, Map<String, Object> parameters) throws SQLException {
	try {
	    String entryPoint = getEntryPoint(parameters);
	    Object[] values = null;
	    IWarehouse warehouse = null;
	    setEntityManager(getEntityManager(parameters));
	    if ("postInsert".equals(entryPoint)) {
		values = getParameterValues(parameters, 1, true);
		warehouse = (IWarehouse) values[0];
		postInsert(cn, warehouse);
	    } else if ("postDelete".equals(entryPoint)) {
		values = getParameterValues(parameters, 1, true);
		warehouse = (IWarehouse) values[0];
		postDelete(cn, warehouse);
	    } else {
		throw new RuntimeException("Entry point '" + entryPoint + "' not found");
	    }
	} catch (Exception ex) {
	    throw new RuntimeException(ex.getMessage());
	} finally {
	    setEntityManager(null);
	}
    }

    
    protected void postInsert(Connection cn, IWarehouse warehouse) throws SQLException {
	if (warehouse == null || warehouse.getWarehouseId() == null) {
	    return;
	}
	DBUtils.execute(cn, "INSERT INTO WAREHOUSE (ID) VALUES ( " + warehouse.getWarehouseId() + ")");
    }

    protected void postDelete(Connection cn, IWarehouse warehouse) throws SQLException {
	if (warehouse == null || warehouse.getWarehouseId() == null) {
	    return;
	}
	DBUtils.execute(cn, "DELETE FROM WAREHOUSE WHERE ID = " + warehouse.getWarehouseId());
    }

}
