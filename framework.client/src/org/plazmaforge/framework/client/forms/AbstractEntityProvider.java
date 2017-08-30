/*
 * Copyright (C) 2005-2010 Oleh Hapon ohapon@users.sourceforge.net
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA.
 * 
 * Oleh Hapon
 * Kyiv, UKRAINE
 * ohapon@users.sourceforge.net
 */

package org.plazmaforge.framework.client.forms;

import java.io.Serializable;

import org.plazmaforge.framework.client.IEntityManager;
import org.plazmaforge.framework.client.IServiceFactory;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.views.IView;
import org.plazmaforge.framework.core.criteria.ICriteria;
import org.plazmaforge.framework.core.exception.ApplicationException;



/** 
 * @author Oleh Hapon
 *
 */

public abstract class AbstractEntityProvider extends EntityModel implements IEntityProvider {

    private IForm formHolder;
    
    private IView view;
    
    private IEditForm editForm;
    
    private IServiceFactory serviceFactory;
    
    private IEntityManager entityManager;
    
    private int mode;
    
    private boolean supportEditForm = true;
    
    
    public IForm getFormHolder() {
        return formHolder;
    }

    public void setFormHolder(IForm formHolder) {
        this.formHolder = formHolder;
    }

    public IEditForm getEditForm() {
        return editForm;
    }

    public void setEditForm(IEditForm editForm) {
        this.editForm = editForm;
    }

    public IView getView() {
        return view;
    }

    public void setView(IView view) {
        this.view = view;
    }
    
    
    
    public IServiceFactory getServiceFactory() {
        return serviceFactory;
    }

    public void setServiceFactory(IServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    public IEntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(IEntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Object newEntity() throws ApplicationException {
	if (getEntityClass() == null) {
	    return null;
	}
	if (getEntityManager() == null) {
	    return null;
	}
	return getEntityManager().newEntity(getEntityClass());
    }

    
    
    
    public Serializable createEntity(Object entity) throws ApplicationException {
	setCreated(entity);
	return null; // [NULL]. Return null id
    }
    
    public void storeEntity(Object entity) throws ApplicationException {
	setModified(entity);
    }
    
    
    
    public Object findEntityById(Serializable id) throws ApplicationException {
	return null;
    }

    public void removeEntity(Object entity) throws ApplicationException {
	setDeleted(entity);
    }

    public void removeEntityById(Serializable id) throws ApplicationException {
	if (getEntityManager() == null) {
	    return;
	}
	getEntityManager().removeEntityById(getEntityService(), id);
    }

    
    
    
    public Serializable getEntityId(Object entity) {
	if (getEntityManager() == null) {
	    return null;
	}
	return getEntityManager().getEntityId(entity);
    }
    
    
    public void setCreated(Object entity) {
	if (getEntityManager() == null) {
	    return;
	}
	getEntityManager().setCreated(entity);
    }
    
    public void setDeleted(Object entity) {
	if (getEntityManager() == null) {
	    return;
	}
	getEntityManager().setDeleted(entity);
    }
    
    public void setModified(Object entity) {
	if (getEntityManager() == null) {
	    return;
	}
	getEntityManager().setModified(entity);
    }
    
    public Object getEntityService() {
	if (super.getEntityService() == null) {
	    super.setEntityService(createEntityService());
	}
	return super.getEntityService();
    }
    
    protected Object createEntityService() {
	if (getEntityServiceClass() == null) {
	    return null;
	}
	if (getServiceFactory() == null) {
	    return null;
	}
	return getServiceFactory().getService(getEntityServiceClass());
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }
    
    public boolean isAddMode() {
	return mode == PWT.ADD_MODE;
    }

    public boolean isEditMode() {
	return mode == PWT.EDIT_MODE;
    }

    public void afterChangeModel() {
	
    }

    public boolean isSupportEditForm() {
        return supportEditForm;
    }

    public void setSupportEditForm(boolean supportEditForm) {
        this.supportEditForm = supportEditForm;
    }

    public void forceLoadDataByCriteria(ICriteria criteria) throws ApplicationException {
	// EMPTY
    }
    
}
