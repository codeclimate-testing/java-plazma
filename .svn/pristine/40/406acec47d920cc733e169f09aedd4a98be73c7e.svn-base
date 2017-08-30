package org.plazmaforge.bsolution.base.server.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.plazmaforge.framework.erm.procedure.AbstractProcedure;
import org.plazmaforge.framework.ext.model.ImageEntryHelper;
import org.plazmaforge.framework.platform.PlatformEnvironment;

/**
 * Image manager
 * Load/Insert/Update/Delete image of entity
 * 
 * @author ohapon
 *
 */
public class ERMImageManager extends AbstractProcedure {

    public void execute(Connection cn, Map<String, Object> parameters) throws SQLException {
	try {
	    String entryPoint = getEntryPoint(parameters);
	    Object[] values = null;
	    String storagePath = PlatformEnvironment.getDataStoragePath();
	    Object data = null;
	    String imageTable = null;
	    String imageField = null;
	    if ("loadImageFS".equals(entryPoint)) {
		values = getParameterValues(parameters, 2, true);
		data = values[0];
		imageTable = (String) values[1];
		ImageEntryHelper.loadEntityImageFS(data, storagePath, imageTable);
	    } else if ("insertImageFS".equals(entryPoint)) {
		values = getParameterValues(parameters, 3, true);
		data = values[0];
		imageTable = (String) values[1];
		imageField = (String) values[2];
		ImageEntryHelper.insertEntityImageFS(data, storagePath, imageTable, imageField);
	    } else if ("updateImageFS".equals(entryPoint)) {
		values = getParameterValues(parameters, 3, true);
		data = values[0];
		imageTable = (String) values[1];
		imageField = (String) values[2];
		ImageEntryHelper.updateEntityImageFS(data, storagePath, imageTable, imageField);
	    } else if ("deleteImageFS".equals(entryPoint)) {
		values = getParameterValues(parameters, 2, true);
		data = values[0];
		imageTable = (String) values[1];
		ImageEntryHelper.deleteEntityImageFS(data, storagePath, imageTable);
	    } else {
		throw new RuntimeException("Entry point '" + entryPoint + "' not found");
	    }
	} catch (Exception ex) {
	    throw new RuntimeException(ex.getMessage());
	}
    }

}
