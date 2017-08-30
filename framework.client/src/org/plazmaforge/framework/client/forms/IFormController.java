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
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;

import org.plazmaforge.framework.action.IAction;
import org.plazmaforge.framework.action.IActionDescriptor;
import org.plazmaforge.framework.client.IEntityManager;
import org.plazmaforge.framework.client.IFormFactory;
import org.plazmaforge.framework.client.IServiceFactory;
import org.plazmaforge.framework.client.controls.IControl;
import org.plazmaforge.framework.config.object.IConfigIdentifier;
import org.plazmaforge.framework.config.object.IFormConfig;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.association.Association;
import org.plazmaforge.framework.report.IReportAction;


/** 
 * The special form controller
 * 
 * @author Oleh Hapon
 *
 */

public interface IFormController extends IFormObject {

    /**
     * Returns the form
     * @param form
     */
    void setForm(IForm form);
    
    /**
     * Sets the form
     * @return
     */
    IForm getForm();

    
    /**
     * Returns the model of form
     * @return
     */
    IFormModel getModel();

    void setEntityManager(IEntityManager entityManager);
    
    IEntityManager getEntityManager();
    
    
    void setServiceFactory(IServiceFactory serviceFactory);
    
    IServiceFactory getServiceFactory();
    
    Object getService(String serviceName);
    
    Object getService(Class serviceClass);
    
    Object getEntityService();
    
    

    
    
    void setFormFactory(IFormFactory formFactory);
    
    IFormFactory getFormFactory();    
 
    IForm getForm(String formName) throws ApplicationException;
    
    IForm getForm(String formName, Object parent) throws ApplicationException; 
    
       
    IControl[] getEntityControls();
    
    void addEntityControl(IControl coltrol);
    
    
    
    Serializable getEntityId(Object entity);
    
    Object loadEntityById(Serializable id) throws ApplicationException;
    
    Object loadHeaderById(Serializable id) throws ApplicationException;
    
    void removeEntityById(Serializable id) throws ApplicationException;
    
    Serializable createEntity(Object entity) throws ApplicationException;
    
    Object newEntity() throws ApplicationException;
    
    
    
    DateFormat getDateFormat();
    
    DateFormat getDateTimeFormat();
    
    DateFormat getTimeFormat();
    
    NumberFormat getNumberFormat();
    
    NumberFormat getIntegerFormat(); 
    
    NumberFormat getCurrencyFormat();
    
    NumberFormat getPercentFormat();   
    
    NumberFormat getQuantityFormat();
    
    NumberFormat getCoefficientFormat();
    
    
    
    Association getAssociation();
    
    Association  createAssociationByBeanClass(Class clazz);
    
    Association createAssociation(Class clazz);
    
    
    
    
    Class getServiceType();
    
    Class getListFormType();
    
    Class getEditFormType();   

    
    void addAction(IAction action);
    
    void addActionDescriptor(IActionDescriptor actionDescriptor);
    
    IActionDescriptor getActionDescriptor(IAction action);
    
    Map<IAction, IActionDescriptor> getActionDescriptorMap();
    
    
    
    void addReportAction(IReportAction action);    

    List<IAction> getActions(); 
    
    List<IReportAction> getReportActions();    
    
    List<IReportAction> getReportActions(IFormConfig formConfig);
    
    void initActions(List<IAction> actions) throws ApplicationException;
    
    void initReportActions(List<IReportAction> actions) throws ApplicationException;
	
    boolean hasReportActions();
    
    List<IReportAction> getProviderReportActions(IEntityProvider provider);

    void addProviderReportActions(IEntityProvider provider, List<IReportAction> actions);

        
    
    void configure();
    
    void configureModel();
    
    void configureForm();
    
    IFormConfig getFormConfig(IConfigIdentifier configIdentifier);
    
    IConfigIdentifier createConfigIdentifier(Class formClass);
    
    
}
