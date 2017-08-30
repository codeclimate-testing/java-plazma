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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.plazmaforge.framework.action.ActionDescriptor;
import org.plazmaforge.framework.action.IAcceptorAction;
import org.plazmaforge.framework.action.IAction;
import org.plazmaforge.framework.action.IActionDescriptor;
import org.plazmaforge.framework.client.Environment;
import org.plazmaforge.framework.client.IActionFactory;
import org.plazmaforge.framework.client.IEntityManager;
import org.plazmaforge.framework.client.IFormFactory;
import org.plazmaforge.framework.client.IReportFactory;
import org.plazmaforge.framework.client.IServiceFactory;
import org.plazmaforge.framework.client.controls.IControl;
import org.plazmaforge.framework.client.help.HelpSystem;
import org.plazmaforge.framework.config.ConfigUtils;
import org.plazmaforge.framework.config.ConfigurerManager;
import org.plazmaforge.framework.config.configurer.FormConfigurer;
import org.plazmaforge.framework.config.object.IConfigIdentifier;
import org.plazmaforge.framework.config.object.IActionDescriptorConfig;
import org.plazmaforge.framework.config.object.IFormConfig;
import org.plazmaforge.framework.config.object.IReportDescriptorConfig;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.association.Association;
import org.plazmaforge.framework.ext.association.AssociationManager;
import org.plazmaforge.framework.platform.PlatformEnvironment;
import org.plazmaforge.framework.report.IReport;
import org.plazmaforge.framework.report.IReportAction;



/** 
 * Abstract implementation of IFormController
 * 
 * @author Oleh Hapon
 * $Id: AbstractFormController.java,v 1.8 2010/12/05 07:51:56 ohapon Exp $
 */

public abstract class AbstractFormController implements IFormController {
    
   
    private IForm form;
    
    
    private IServiceFactory serviceFactory;
    
    private IFormFactory formFactory;
    
    private IEntityManager entityManager;
    
    private IActionFactory actionFactory;
    
    private IReportFactory reportFactory;    
    
    
    private IConfigIdentifier configIdentifier;
    
    private Association association; 
    
    
    
    private DateFormat dateFormat;
    
    private DateFormat dateTimeFormat;
    
    private DateFormat timeFormat;
    
    private NumberFormat numberFormat;
    
    private NumberFormat integerFormat;
    
    private NumberFormat currencyFormat;
    
    private NumberFormat percentFormat;

    private NumberFormat quantityFormat;
    
    private NumberFormat coefficientFormat;    
    
    
    private List<IAction> actions = new ArrayList<IAction>();
    
    private Map<IAction, IActionDescriptor> actionDescriptorMap = new HashMap<IAction, IActionDescriptor>();
    
    private List<IReportAction> reportActions = new ArrayList<IReportAction>();    

    private Map<IEntityProvider, List<IReportAction>> providerReportActionMap = new HashMap<IEntityProvider, List<IReportAction>>();
    
    
    private boolean noDialogWhenOneReport;
    
    public IForm getForm() {
        return form;
    }



    public void setForm(IForm form) {
        this.form = form;
    }

    public Class getFormClass() {
	return form == null ? null : form.getClass();
    }
    
    
    public IFormModel getModel() {
	if (form == null) {
	    return null;
	}
	return form.getModel();
    }



    public IFormFactory getFormFactory() {
	if (formFactory == null) {
	    formFactory = Environment.getFormFactory(); 
	}
        return formFactory;
    }



    public void setFormFactory(IFormFactory formFactory) {
        this.formFactory = formFactory;
    }


    public IActionFactory getActionFactory() {
	if (actionFactory == null) {
	    actionFactory = Environment.getActionFactory();
	}
        return actionFactory;
    }

    public void setActionFactory(IActionFactory actionFactory) {
        this.actionFactory = actionFactory;
    }

    
    public IReportFactory getReportFactory() {
	if (reportFactory == null) {
	    reportFactory = Environment.getReportFactory();
	}
        return reportFactory;
    }



    public void setReportFactory(IReportFactory reportFactory) {
        this.reportFactory = reportFactory;
    }



    public IServiceFactory getServiceFactory() {
	if (serviceFactory == null) {
	    serviceFactory = Environment.getServiceFactory(); 
	}
        return serviceFactory;
    }



    public IEntityManager getEntityManager() {
	if (entityManager == null) {
	    entityManager = Environment.getEntityManager();
	}
        return entityManager;
    }



    public void setEntityManager(IEntityManager entityManager) {
        this.entityManager = entityManager;
    }



    public void setServiceFactory(IServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }
    
    public Object getService(String serviceName) {
	if (getServiceFactory() == null) {
	    return null;
	}
	return getServiceFactory().getService(serviceName);
    }
    
    public Object getService(Class serviceClass) {
	if (getServiceFactory() == null) {
	    return null;
	}
	return getServiceFactory().getService(serviceClass);	
    }
    
    public IForm getForm(String formName) throws ApplicationException{
	if (getFormFactory() == null ) {
	    return null;
	}
	return getFormFactory().getForm(formName);
    }
    
    public IForm getForm(String formName, Object parent) throws ApplicationException{
	if (getFormFactory() == null ) {
	    return null;
	}
	return getFormFactory().getForm(formName, parent);	    
    }
    
 

    public IControl[] getEntityControls() {
	return getForm().createEntityControls();
    }

 
    
    public void addEntityControl(IControl coltrol) {
	
    }
    
    
    public void initEntity(Object entity) {
	if (getModel() == null) {
	    return;
	}
	getModel().setEntity(entity);
	getModel().setEntityId(getEntityId(entity));
    }
    

    
    
    public void init() throws ApplicationException {
	
	configure();
	
	initActions();
	initMenuBar();
	initToolBar();
    }
    
    
    public void initActions() throws ApplicationException {
	initActions(getActions());
	initReportActions(getReportActions());
    }

    public void initActions(List<IAction> actions) throws ApplicationException {
	if (actions == null) {
	    return;
	}
	for (IAction action : actions) {
	    initAction(action);
	}
    }
    
    public void initReportActions(List<IReportAction> actions) throws ApplicationException {
	if (actions == null) {
	    return;
	}
	for (IAction action : actions) {
	    initAction(action);
	}
    }
    
    
    /**
     * Initialize an action.
     * @param action
     * @throws ApplicationException
     */
    protected void initAction(IAction action) throws ApplicationException {
	if (action == null) {
	    return;
	}
	if (action instanceof IAcceptorAction) {
	    initAcceptorAction((IAcceptorAction) action);
	}	
	if (action instanceof IReportAction) {
	    initReportAction((IReportAction) action);
	}
	
    }

    /**
     * Initialize an acceptor action. Set an acceptor of the action.
     * @param action
     * @throws ApplicationException
     */
    protected void initAcceptorAction(IAcceptorAction action) throws ApplicationException {
	if (action == null /*|| action.getAcceptor() != null*/) { // TODO: NULLAcceptor
	    return;
	}
	action.setAcceptor(getForm().getFormAcceptor());
    }
    
    /**
     * Initialize an report action
     * @param action
     * @throws ApplicationException
     */
    protected void initReportAction(IReportAction action) throws ApplicationException {
	if (action == null) {
	    return;
	}
	action.setIgnoreInvalidParameter(true);
    }
    
    
    
    
    
    public void initMenuBar() throws ApplicationException {
	
    }

    public void initToolBar() throws ApplicationException {
	
    }   
    
    
    public void doCreateEntity() throws ApplicationException {
	if (getModel().getEntity() != null && getEntityManager() != null) {
	    Serializable id = getEntityManager().createEntity(getEntityService(), getModel().getEntity());
	    getModel().setEntityId(id);
	}
    }
    
    public void doLoadEntity() throws ApplicationException {
	if (!getModel().hasDataSource()) {
	    return;
	}
	
	
	
	if (getEntityManager() != null) {
	    
	    if (getForm().isCopyMode()) {
		return;
	    }
	    
	    if (getForm().isAddMode()) {
		Object entity = newEntity();
		initEntity(entity);
		return;
            }	    
	    
	    Serializable id = getModel().getEntityId(); 
	    if (id == null) {
		getModel().clearEntity();
		return;
	    }
	    
	    Object entity = getEntityManager().loadEntityById(getEntityService(), id);
	    if (entity == null) {
		getModel().clearEntity();
		return;
	    }
	    initEntity(entity);
	}
    }
    
    public void doStoreEntity() throws ApplicationException {
	if (getModel().getEntity() != null && getEntityManager() != null) {
	    getEntityManager().storeEntity(getEntityService(), getModel().getEntity());
	}
    }

    
    
    public void doCreateData() throws ApplicationException {
	//doCreateEntity();
    }
    
    public void doLoadData() throws ApplicationException {
	//doLoadEntity();
    }
    
    public void doStoreData() throws ApplicationException {
	//doLoadEntity();
    }    


    
    public void updateForm() throws ApplicationException {
	IControl[] controls = getEntityControls();
	if (controls == null) {
	    return;
	}
	for (int i = 0; i < controls.length; i++) {
	   controls[i].updateView(); 
	}
    }
    
    public void updateEntity() throws ApplicationException {
	IControl[] controls = getEntityControls();
	if (controls == null) {
	    return;
	}
	for (int i = 0; i < controls.length; i++) {
	   controls[i].updateModel(); 
	}	
    }
    
    public void updateData() throws ApplicationException {
	updateEntity();
    }
    
     
    public void executeAction(String actionIdentificator) throws ApplicationException {
	viewAction(actionIdentificator);
    }
    
    
    public void doHelpAction() throws ApplicationException {
	HelpSystem.displayHelp();
    }
    
    public void doExitAction() throws ApplicationException {
	viewAction("Exit");
    }
    
    public void doSetupAction() throws ApplicationException {
	viewAction("Setup");
    }
    
    public void doPrintAction() throws ApplicationException {
	//if (!getForm().hasReportActions()) { // // FIX 2010-05-25
	//    return;
	//}
	List<IReportAction> reportActions = getForm().getReportActions(); // FIX 2010-05-25
	if (reportActions == null || reportActions.isEmpty()) {
	    return;
	}
	IReportAction action = null;
	
	// ONE REPORT
	if (isNoDialogWhenOneReport() && reportActions.size() == 1) {
	    action = getReportActions().get(0);
	    performReport(action);
	    return;
	}
	
	action = getSelectedReportAction(reportActions);
	performReport(action);
	
    }
    
    protected abstract IReportAction getSelectedReportAction(List<IReportAction> actions);
    
    protected void performReport(IReportAction action) throws ApplicationException {
	if (action == null || action.getReport() == null) {
	    return;
	}
	action.execute();
    }
    
    protected void viewAction(String actionIdentificator) {
	getForm().getDecorator().setStatusText("" + actionIdentificator + " action executed");
    }



    public IConfigIdentifier getConfigIdentifier() {
	if (configIdentifier == null) {
	    configIdentifier = createDefaultConfigIdentifier();
	}
        return configIdentifier;
    }



    public void setConfigIdentifier(IConfigIdentifier configIdentifier) {
        this.configIdentifier = configIdentifier;
    }


    
    /**
     * Create a default config identifier of form
     * @return
     */
    protected IConfigIdentifier createDefaultConfigIdentifier() {
	return ConfigUtils.createDefaultConfigIdentifier(getFormClass());
    }

    public IConfigIdentifier createConfigIdentifier(Class formClass) {
	return ConfigUtils.createDefaultConfigIdentifier(formClass);
    }


    public Association getAssociation() {
	if (association == null) {
	    association = createAssociation();
	}
        return association;
    }



    public void setAssociation(Association association) {
        this.association = association;
    }
    
    public Association createAssociationByBeanClass(Class clazz) {
	return AssociationManager.createAssociationByBeanClass(clazz);
    }

    public Association createAssociation(Class clazz) {
	return AssociationManager.getAssociationByElementClass(clazz);
    }
    
    protected Association createAssociation() {
	IForm form = getForm();
	if (form == null) {
	    return null;
	}
	IFormModel model = form.getModel();
	if (model == null) {
	    return null;
	}
	if (!model.isAutoConfigureAssociation() ) {
	    return null;
	}
	Class formClass = form.getClass();
	return createAssociation(formClass);
    }
    
    public void configure() {
	configureModel();
	configureForm();
    }
    
    public void configureModel() {
	configureModel(getModel());
    }
    
    
    protected void configureModel(IFormModel model) {
	if (model == null) {
	    return;
	}
	Association association = getAssociation();
	if (association == null) {
	    return;
	}
	if (model.isAutoConfigureEntity() && model.getEntityClass() == null) {
	    model.setEntityClass(association.getBeanClass());
	}
	
	// Set entity service class if form has data source mode
	if (model.isAutoConfigureEntityService() && model.hasDataSource() && model.getEntityServiceClass() == null) {
	    Class serviceClass = association.getElementByType(getServiceType());
	    if (serviceClass != null) {
		model.setEntityServiceClass(serviceClass);
		return;
	    }
	    String serviceClassName = model.getEntityServiceName();
	    if (serviceClassName != null) { // Service was configured before
		return;
	    }
	    // Configure service class name by bean
	    String beanClassName = association.getBeanClassName();
	    Class beanClass = association.getBeanClass(); // Bean class has priority than bean class name
	    if (beanClass != null) {
		beanClassName = beanClass.getName();
	    }
	    serviceClassName = AssociationManager.getInstance().getAssociationCreator().createElementClassName(beanClassName, getServiceType());
	    model.setEntityServiceName(serviceClassName);
	    
	}
    }
    
    
    public Class getServiceType() {
	if (Environment.getServiceFactory() == null) {
	    return null;
	}
	return Environment.getServiceFactory().getServiceType();
    }
    
    public Class getListFormType() {
	if (Environment.getFormFactory() == null || Environment.getFormFactory().getListFormType() == null) {
	    return IListForm.class;
	}
	return Environment.getFormFactory().getListFormType();
    }
    
    public Class getEditFormType() {
	if (Environment.getFormFactory() == null || Environment.getFormFactory().getEditFormType() == null) {
	    return IEditForm.class;
	}
	return Environment.getFormFactory().getEditFormType();
    }
    
    
    public Object getEntityService() {
	Object service = getModel().getEntityService();
	if (service != null) {
	    return service;
	}
	Class serviceClass = getModel().getEntityServiceClass();
	if (serviceClass == null) {
	    String serviceClassName = getModel().getEntityServiceName();
	    if (serviceClassName == null) {
		return null;
	    }
	    // Get service by class name
	    service = getService(serviceClassName);
	    if (service == null) {
		return null;
	    }
	    getModel().setEntityService(service);
	    return service;
	}
	
	// Get service by class
	service = getService(serviceClass);
	if (service == null) {
	    return null;
	}
	getModel().setEntityService(service);
	return service;
    }   
    
    
  
    
    // -----------------------------------------------------------------------------------------------------------------------------------
    //
    // Entity methods. Methods use entity manager. You can overwrite this methods. 
    //
    // -----------------------------------------------------------------------------------------------------------------------------------
    
    public Serializable getEntityId(Object entity) {
	if (getEntityManager() == null) {
	    return null;
	}
	return getEntityManager().getEntityId(entity);
    }
    
    
    public Object loadEntityById(Serializable id) throws ApplicationException {
	if (getEntityManager() == null) {
	    return null;
	}
	Object service = getEntityService();
	if (service == null) {
	    return null;
	}
	return getEntityManager().loadEntityById(service, id);
    }
    
    
    public Object loadHeaderById(Serializable id) throws ApplicationException {
	if (getEntityManager() == null) {
	    return null;
	}
	Object service = getEntityService();
	if (service == null) {
	    return null;
	}
	return getEntityManager().loadHeaderById(service, id);
    }
    
    public void removeEntityById(Serializable id) throws ApplicationException {
	if (getEntityManager() == null) {
	    return;
	}
	Object service = getEntityService();
	if (service == null) {
	    return;
	}
	getEntityManager().removeEntityById(service, id);
    }    
  
    public Serializable createEntity(Object entity) throws ApplicationException {
	if (getEntityManager() == null) {
	    return null;
	}
	Object service = getEntityService();
	if (service == null) {
	    return null;
	}
	return getEntityManager().createEntity(service, entity);
    }
    
    public Object newEntity() throws ApplicationException {
	if (getEntityManager() == null) {
	    return null;
	}
	return getEntityManager().newEntity(getModel().getEntityClass());
    }
    
    
    
    public DateFormat getDateFormat() {
	if (dateFormat == null) {
	    dateFormat = createDateFormat();
	}
	return dateFormat;
    }

    public DateFormat getDateTimeFormat() {
	if (dateTimeFormat == null) {
	    dateTimeFormat = createDateTimeFormat();
	}
	return dateTimeFormat;
    }

    public DateFormat getTimeFormat() {
	if (timeFormat == null) {
	    timeFormat = createTimeFormat();
	}
	return timeFormat;
    }

    public NumberFormat getNumberFormat() {
	if (numberFormat == null) {
	    numberFormat = createNumberFormat();
	}
	return numberFormat;
    }
    
    public NumberFormat getIntegerFormat() {
	if (integerFormat == null) {
	    integerFormat = createIntegerFormat();
	}
	return integerFormat;
    }
    
    public NumberFormat getCurrencyFormat() {
	if (currencyFormat == null) {
	    currencyFormat = createCurrencyFormat();
	}
	return currencyFormat;
    }
    
    public NumberFormat getPercentFormat() {
	if (percentFormat == null) {
	    percentFormat = createPercentFormat();
	}
	return percentFormat;
    }    
    
    public NumberFormat getQuantityFormat() {
	if (quantityFormat == null) {
	    quantityFormat = createQuantityFormat();
	}
	return quantityFormat;
    }  
    
    public NumberFormat getCoefficientFormat() {
	if (coefficientFormat == null) {
	    coefficientFormat = createCoefficientFormat();
	}
	return coefficientFormat;
    }  
    
    protected DateFormat createDateFormat() {
	return PlatformEnvironment.getDateFormat();
    }

    protected DateFormat createDateTimeFormat() {
	return PlatformEnvironment.getDateTimeFormat();
    }

    protected DateFormat createTimeFormat() {
	return PlatformEnvironment.getTimeFormat();
    }

    protected NumberFormat createNumberFormat() {
	return PlatformEnvironment.getNumberFormat();
    }

    protected NumberFormat createIntegerFormat() {
	return PlatformEnvironment.getIntegerFormat();
    }

    protected NumberFormat createCurrencyFormat() {
	return PlatformEnvironment.getCurrencyFormat();
    }    

    protected NumberFormat createPercentFormat() {
	return PlatformEnvironment.getPercentFormat();
    }    

    protected NumberFormat createQuantityFormat() {
	return PlatformEnvironment.getQuantityFormat();
    }    

    protected NumberFormat createCoefficientFormat() {
	return PlatformEnvironment.getCoefficientFormat();
    }    

    
//    protected DecimalFormat createDecimalFormat(String pattern) {
//	DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
//	DecimalFormat format = new DecimalFormat(pattern, symbols);
//	return format;
//    }
    
    //------------------------------------------------------------------------------------------------------------------------------------
    //
    // Configuration Management
    //
    //------------------------------------------------------------------------------------------------------------------------------------
    
    public List<IAction> getActions() {
        return actions;
    }

    public Map<IAction, IActionDescriptor> getActionDescriptorMap() {
        return actionDescriptorMap;
    }
    
    public IActionDescriptor getActionDescriptor(IAction action) {
        return action == null ? null : actionDescriptorMap.get(action);
    }


    public void addAction(IAction action) {
	if (action == null) {
	    return;
	}
	getActions().add(action);
    }

    public void addActionDescriptor(IActionDescriptor actionDescriptor) {
	if (actionDescriptor == null || actionDescriptor.getAction() == null) {
	    return;
	}
	getActions().add(actionDescriptor.getAction());
	getActionDescriptorMap().put(actionDescriptor.getAction(), actionDescriptor);
    }

    
    
    public List<IReportAction> getReportActions() {
        return reportActions;
    }
    
    public boolean hasReportActions() {
	return reportActions != null && reportActions.size() > 0;
    }

    public void addReportAction(IReportAction  action) {
	if (action == null || /*!action.isEnabled() ||*/ !isSupportReportAction(action)) {
	    return;
	}
	getReportActions().add(action);
    }


    ////
    
    public List<IReportAction> getProviderReportActions(IEntityProvider provider) {
	return getProviderReportActionMap().get(provider);
    }

    public void addProviderReportActions(IEntityProvider provider, List<IReportAction> actions) {
	getProviderReportActionMap().put(provider, actions);
    }

    public Map<IEntityProvider, List<IReportAction>> getProviderReportActionMap() {
        return providerReportActionMap;
    }

    ////
    
    public FormConfigurer getFormConfigurer() {
	return (FormConfigurer) ConfigurerManager.getConfigurer(FormConfigurer.NAME);
    }

	
    public IFormConfig getFormConfig(IConfigIdentifier configIdentifier) {
	FormConfigurer formConfigurer = getFormConfigurer();
	if (formConfigurer == null) {
	    return null;
	}
	return (IFormConfig) formConfigurer.getObjectByName(configIdentifier.getConfigName());
    }
    
    public void configureForm() {
	configureForm(getForm());
    }

    /**
     * Configure form
     * @param form
     */
    protected void configureForm(IForm form) {
	if (form == null) {
	    return;
	}
	IFormConfig formConfig = getFormConfig(form.getConfigIdentifier());
	if (formConfig == null) {
	    return;
	}
	configureReports(form, formConfig);
	configureActions(form, formConfig);
    }
	
    /**
     * Configure reports
     * @param form
     * @param formConfig
     */
    protected void configureReports(IForm form, IFormConfig formConfig) {
	List<IReportAction> actions = getReportActions(formConfig);
	if (actions == null || actions.isEmpty()) {
	    return;
	}
	for (IReportAction action: actions) {
	    form.addReportAction(action);
	}
    }


    /**
     * Return report actions of form
     */
    public List<IReportAction> getReportActions(IFormConfig formConfig) {
	if (formConfig == null) {
	    return Collections.<IReportAction>emptyList();
	}
	List<IReportDescriptorConfig> reportDescriptors = formConfig.getReportDescriptors();
	if (reportDescriptors == null) {
	    return Collections.<IReportAction>emptyList();
	}
	List<IReportAction> actions = new ArrayList<IReportAction>();
	for(IReportDescriptorConfig reportDescriptor: reportDescriptors) {
	    actions.add(getReportActionByName(reportDescriptor.getRef()));
	}
	return actions;
    }
    
    /**
     * Configure actions
     * @param form
     * @param formConfig
     */
    protected void configureActions(IForm form, IFormConfig formConfig) {
	List<IActionDescriptorConfig> actionDescriptors = formConfig.getActionDescriptors();
	if (actionDescriptors == null) {
	    return;
	}
	for(IActionDescriptorConfig actionDescriptor: actionDescriptors) {
	    IAction a =  getActionByName(actionDescriptor.getRef());
	    ActionDescriptor ai = new ActionDescriptor();
	    ai.setAction(a);
	    form.addActionDescriptor(ai);
	}
    }
    
    //--------------------------------------------------------------------------------------------------------------
    

    /**
     * Returns the report by name
     */
    public IReport getReportByName(String name) {
	if (getReportFactory() == null) {
	    return null;
	}
    	return getReportFactory().getReportByName(name);
    }
	
    /**
     * Returns the report action by name
     * @param id
     * @return
     */
    public IReportAction getReportActionByName(String name) {
	if (getReportFactory() == null) {
	    return null;
	}
    	return getReportFactory().getReportActionByName(name);
    }
	
	
    /**
     * Returns the action by name
     * @param id
     * @return
     */
    public IAction getActionByName(String name) {
	if (getActionFactory() == null) {
	    return null;
	}
    	return getActionFactory().getActionByName(name);
    }
	
    protected boolean isSupportReportAction(IReportAction action) {
	return getForm().isSupportReportAction(action);
    }



    public boolean isNoDialogWhenOneReport() {
        return noDialogWhenOneReport;
    }



    public void setNoDialogWhenOneReport(boolean noDialogWhenOneReport) {
        this.noDialogWhenOneReport = noDialogWhenOneReport;
    }
    

}
