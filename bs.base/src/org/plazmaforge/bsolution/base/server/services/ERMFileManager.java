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
import org.plazmaforge.framework.ext.model.File;
import org.plazmaforge.framework.ext.model.FileHelper;
import org.plazmaforge.framework.ext.model.IFileHolder;
import org.plazmaforge.framework.ext.model.FileHelper.FileManager;

public class ERMFileManager extends AbstractProcedure {

    private FileHelper fileHelper;
    
    public void execute(Connection cn, Map<String, Object> parameters) throws SQLException {
	try {
	    String entryPoint = getEntryPoint(parameters);
	    Object[] values = getParameterValues(parameters, 1, true);
	    Object data = values[0];
	    IFileHolder fileHolder = getFileHolder(data);
	    setEntityManager(getEntityManager(parameters));
	    if ("loadFiles".equals(entryPoint)) {
		getFileHelper().loadFiles(fileHolder);
	    } else if ("saveFiles".equals(entryPoint)) {
		getFileHelper().saveFiles(fileHolder);
	    } else if ("deleteFiles".equals(entryPoint)) {
		getFileHelper().deleteFiles(fileHolder);
	    } else {
		throw new RuntimeException("Entry point '" + entryPoint + "' not found");
	    }
	} catch (Exception ex) {
	   throw new RuntimeException(ex.getMessage());
	} finally {
	    setEntityManager(null);
	}
    }	

    protected FileHelper getFileHelper() {
	if (fileHelper == null) {
	    fileHelper = new FileHelper(new FileManagerImpl());
	}
        return fileHelper;
    }
    
    protected IFileHolder getFileHolder(Object data) {
	if (!(data instanceof IFileHolder)) {
	    return null;
	}
	return (IFileHolder) data;
    }

 
    public class FileManagerImpl implements FileManager {
	

 	public List<File> doFindByOwner(IEntityConfig entity, Integer ownerId) throws DAOException {
  	   Criteria criteria = new Criteria();
  	   criteria.addFilter("entity.id", entity.getId());
  	   criteria.addFilter("ownerId", ownerId);
  	   return getEntityManager().findAll(File.class, criteria);
 	}

 	public void doInsertFile(File file) throws DAOException, CreateException {
 	    getEntityManager().insert(file);
 	}

 	public void doUpdateFile(File file) throws DAOException, FinderException {
 	    getEntityManager().update(file);
 	}
 	    
 	public void doDeleteFile(File file) throws DAOException, RemoveException {
 	    getEntityManager().delete(file);
 	}
    }


    

}
