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
import java.util.List;
import java.util.Map;

import org.plazmaforge.framework.action.IAction;
import org.plazmaforge.framework.action.IActionDescriptor;
import org.plazmaforge.framework.client.controls.IControl;
import org.plazmaforge.framework.client.models.FormListener;
import org.plazmaforge.framework.core.IAcceptor;
import org.plazmaforge.framework.report.IReportAction;


/** 
 * @author Oleh Hapon
 * $Id: IForm.java,v 1.8 2010/12/05 07:51:56 ohapon Exp $
 */

public interface IForm extends IFormObject, IFormConstants {

    /**
     * Returns the entity id
     * @param id
     */
    void setEntityId(Serializable id);
    
    /**
     * Sets the entity id
     */
    Serializable getEntityId();
    
    
    /**
     * Returns the parent entity id
     * @param id
     */
    void setParentEntityId(Serializable id);
    
    /**
     * Sets the parent entity id
     */
    Serializable getParentEntityId();
    
    
    boolean isSupportParentEntity();
    
    
    void setSupportParentEntity(boolean flag);
    

    /**
     * Returns the entity
     * @param id
     */
    void setEntity(Object entity);
    
    /**
     * Sets the entity
     */
    Object getEntity();
    
    
    
    /**
     * Returns the parent entity
     * @param id
     */
    void setParentEntity(Object parentEntity);
    
    /**
     * Sets the parent entity id
     */
    Object getParentEntity();    
    
    /**
     * Sets the form decorator
     * @param decorator
     */
    void setDecorator(IFormDecorator decorator);
    
    /**
     * Returns the <code>IFormDecorator</code>
     * @return <code>IFormDecorator</code>
     */
    IFormDecorator getDecorator();
    
    /**
     * Returns the <code>IFormModel</code>
     * @return
     */
    IFormModel getModel();
    
    /**
     * Sets the title
     * @param title
     */
    void setTitle(String title);
    
    /**
     * Returns the title
     * @return
     */
    String getTitle();
    
    void setStatusText(String text);
    
    /**
     * Returns entity controls of the form
     * @return
     */
    IControl[] createEntityControls();
    
    /**
     * Runs the action
     * @param actionIdentificator
     */
    void doAction(String actionIdentificator);
    
    /**
     * Returns true if the form is modify 
     * @return
     */
    boolean isModify();  
    
    /**
     * Disposes
     *
     */
    void dispose();
    
    /**
     * Return true if the form is disposed
     * @return
     */
    boolean isDisposed();
    
    /**
     * Sets editable mode of the form
     * @see org.plazmaforge.framework.client.PWT
     * @param mode
     */
    void setMode(int mode);
    
    /**
     * Return editable mode of the form
     * @see org.plazmaforge.framework.client.PWT
     * @return
     */
    int getMode();
    
    /**
     * Return true if editable mode of form is PWT.EDIT_MODE
     * @see org.plazmaforge.framework.client.PWT
     * @return
     */
    boolean isEditMode();
    
    /**
     * Return true if editable mode of form is PWT.ADD_MODE
     * @see org.plazmaforge.framework.client.PWT
     * @return
     */
    boolean isAddMode();

    /**
     * Return true if editable mode of form is PWT.COPY_MODE
     * @see org.plazmaforge.framework.client.PWT
     * @return
     */
    boolean isCopyMode();

    /**
     * Return true if editable mode of form is PWT.VIEW_MODE
     * @see org.plazmaforge.framework.client.PWT
     * @return
     */
    boolean isViewMode();  
    
    /**
     * Returns true if the form has data source or form works with entity service.
     * If the form doesn't have data source then you have to use <code>setEntity</code> method.
     * @return
     */
    boolean hasDataSource();
    
    /**
     * Set child mode of form. The child form doesn't have data source or entity service.
     * @param isChildFormMode
     */
    void setChildFormMode(boolean isChildFormMode);
    
    /**
     * Returns true if form is child.
     * @return
     */
    boolean isChildFormMode();
    
    /**
     * Returns width of the form
     * @return
     */
    int getWidth();
    
    /**
     * Returns height of the form
     * @return
     */
    int getHeight();
    
    
    void setParentForm(IForm parentForm);
    
    
    void sendMessage(String msg);
    
    
    void addAction(IAction action);
    
    void addActionDescriptor(IActionDescriptor actionDescriptor);
    
    IActionDescriptor getActionDescriptor(IAction action);
    
    Map<IAction, IActionDescriptor> getActionDescriptorMap();
    
    
    void addReportAction(IReportAction action);
    
    List<IAction> getActions(); 
    
    List<IReportAction> getReportActions();    
    
    boolean hasReportActions();
    
    int getActionCount();
    
    int getReportCount();
    
    IAcceptor getFormAcceptor();
    
    boolean isSupportReportAction(IReportAction action);
    
    boolean setFocus();
    
    Serializable getForwardId() ;


    void setForwardId(Serializable forwardId);

    
    Object getForwardEntity();


    void setForwardEntity(Object forwardEntity);


    Object getCategoryEntity();


    void setCategoryEntity(Object categoryEntity);

    
    ///---
    
    boolean isSupportAddMode();

    boolean isSupportDelMode();

    boolean isSupportEditMode();
    
    ////
    
    boolean isSupportCopyMode();
    
    ////
    
    
    void setCurrentEntityProvider(IEntityProvider provider);
    
    IEntityProvider getCurrentEntityProvider();
    
    ////
    void setIdentifier(Serializable identifier);
    
    Serializable getIdentifier();
    
    ////
    
    List<String> getArguments();
    
    void setArguments(List<String> arguments);

    String getArgument();
    
    // Store custom data values
    void setData(String key, Object value);
    
    Object getData(String key);
    
    
    
    //////////////////////////////////////////
    
    
    void addFormListener(FormListener listener);

    void removeFormListener(FormListener listener);
    
    boolean isForceUpdate();
}
