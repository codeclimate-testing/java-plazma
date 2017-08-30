package org.plazmaforge.bsolution.base.server.services;

import java.util.List;

import org.plazmaforge.bsolution.base.common.services.FileService;
import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.ext.model.File;
import org.plazmaforge.framework.ext.model.FileHelper;
import org.plazmaforge.framework.ext.model.IFileHolder;
import org.plazmaforge.framework.ext.model.FileHelper.FileManager;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;

public class FileServiceImpl extends AbstractEntityService<File, Integer> implements FileService {

    protected Class getEntityClass() {
        return File.class;
    }

    private FileHelper fileHelper;
    
    public List<File> findByOwner(IEntityConfig entity, Integer ownerId) throws DAOException {
        Criteria criteria = new Criteria();
        criteria.addFilter("entity.id", entity.getId());
        criteria.addFilter("ownerId", ownerId);
        return getEntityManager().findAll(File.class, criteria);
    }
    
    
    public FileHelper getFileHelper() {
	if (fileHelper == null) {
	    fileHelper = new FileHelper(new FileManagerImpl());
	}
        return fileHelper;
    }


    public void loadFiles(IFileHolder holder) throws DAOException {
	try {
	    getFileHelper().loadFiles(holder);
	} catch (DAOException e) {
	    throw e;
	} catch (ApplicationException e) {
	    throw new DAOException(e);
	}
    }
    
    public List<File> getFiles(IFileHolder holder) throws DAOException {
	try {
	    return getFileHelper().getFiles(holder);
	} catch (DAOException e) {
	    throw e;
	} catch (ApplicationException e) {
	    throw new DAOException(e);
	}
    }
    
    public void storeFiles(IFileHolder holder) throws DAOException {
	try {
	    getFileHelper().saveFiles(holder);
	} catch (DAOException e) {
	    throw e;
	} catch (ApplicationException e) {
	    throw new DAOException(e);
	}
    }

    public void removeFiles(IFileHolder holder) throws DAOException {
	try {
	    getFileHelper().deleteFiles(holder);
	} catch (DAOException e) {
	    throw e;
	} catch (ApplicationException e) {
	    throw new DAOException(e);
	}
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public class FileManagerImpl implements FileManager {

	@Override
	public List<File> doFindByOwner(IEntityConfig entity, Integer ownerId) throws ApplicationException {
	    return findByOwner(entity, ownerId);
	}

	@Override
	public void doInsertFile(File file) throws ApplicationException {
	    create(file);
	}

	@Override
	public void doUpdateFile(File file) throws ApplicationException {
	    store(file);
	}

	@Override
	public void doDeleteFile(File file) throws ApplicationException {
	    remove(file);
	}

    }


}
