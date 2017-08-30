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
import org.plazmaforge.framework.client.views.IView;
import org.plazmaforge.framework.client.views.IViewHolder;
import org.plazmaforge.framework.core.exception.ApplicationException;


/** 
 * @author Oleh Hapon
 *
 */

public interface IEntityProvider extends IEntityModel, IViewHolder {
    
    void init();
    
    IForm getFormHolder();
    
    void setFormHolder(IForm form);
    
    IView getView();
    
    void setView(IView view);
    
    
    IEditForm getEditForm();
    
    void setEditForm(IEditForm form);
    
    
    Object newEntity() throws ApplicationException;
    
    
    
    Serializable createEntity(Object entity) throws ApplicationException;
    
    void storeEntity(Object entity) throws ApplicationException;
    
    
    void removeEntity(Object entity) throws ApplicationException;
    
    void removeEntityById(Serializable id) throws ApplicationException;    
    
    Object findEntityById(Serializable id) throws ApplicationException;
    
    void updateView() throws ApplicationException;
    
    void refreshView() throws ApplicationException;
    
    
    Object getSelectedEntity();
    
    Serializable getSelectedEntityId();

    
    void setCreated(Object entity);
    
    void setDeleted(Object entity);
    
    void setModified(Object entity);
    
    
    void setEntityManager(IEntityManager entityManager);
    
    void setServiceFactory(IServiceFactory serviceFactory);
    
    void setMode(int mode);
    
    int getMode();
    
    
    
    boolean isSupportEditForm();

    void setSupportEditForm(boolean supportEditForm);
}
