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

package org.plazmaforge.framework.client.swt.forms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.plazmaforge.framework.action.IAction;
import org.plazmaforge.framework.action.IActionDescriptor;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.Toolkit;
import org.plazmaforge.framework.client.controls.IControl;
import org.plazmaforge.framework.client.forms.DefaultEntityProvider;
import org.plazmaforge.framework.client.forms.FormModel;
import org.plazmaforge.framework.client.forms.IEditForm;
import org.plazmaforge.framework.client.forms.IEntityProvider;
import org.plazmaforge.framework.client.forms.IForm;
import org.plazmaforge.framework.client.forms.IFormController;
import org.plazmaforge.framework.client.forms.IFormDecorator;
import org.plazmaforge.framework.client.forms.IFormModel;
import org.plazmaforge.framework.client.forms.IListForm;
import org.plazmaforge.framework.client.models.FormEvent;
import org.plazmaforge.framework.client.models.FormListener;
import org.plazmaforge.framework.client.swt.SWTEnvironment;
import org.plazmaforge.framework.client.swt.SWTResourceManager;
import org.plazmaforge.framework.client.swt.SWTUtils;
import org.plazmaforge.framework.client.swt.app.PreferencesListener;
import org.plazmaforge.framework.client.swt.app.SWTApplication;
import org.plazmaforge.framework.client.swt.dialogs.ChooseDialog;
import org.plazmaforge.framework.client.swt.dialogs.ResultDialog;
import org.plazmaforge.framework.config.object.IConfigIdentifier;
import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.config.object.IFormConfig;
import org.plazmaforge.framework.core.DefaultAcceptor;
import org.plazmaforge.framework.core.IAcceptor;
import org.plazmaforge.framework.core.exception.AccessDeniedException;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.association.Association;
import org.plazmaforge.framework.ext.association.AssociationManager;
import org.plazmaforge.framework.report.IReportAction;
import org.plazmaforge.framework.util.ErrorTranslator;
import org.plazmaforge.framework.util.ObjectCreator;
import org.plazmaforge.framework.util.StringUtils;
import org.plazmaforge.framework.util.SystemUtils;
import org.plazmaforge.framework.util.ValidationUtils;


/**
 * @author Oleh Hapon 
 */

public abstract class AbstractForm extends Composite implements IForm {

    
    public static final String NO_DATA_MESSAGE = Messages.getString("Form.nodata"); //$NON-NLS-1$
    
    public static final String NO_REPORTS_MESSAGE = Messages.getString("Form.noreports"); //$NON-NLS-1$
    
    public static final String ROW_NOT_SELECTED_MESSAGE = Messages.getString("Form.row.notselected"); //$NON-NLS-1$
    
    
    protected final Logger logger = Logger.getLogger(getClass());
    
    
    

    /**
     * Identifier of the form
     */
    private Serializable identifier;

    /**
     * Decorator of the form
     */
    private IFormDecorator decorator;

    /**
     * Controller of the form
     */
    private IFormController controller;

    /**
     * Model of the form
     */
    private IFormModel model;
    
    /**
     * Title of the form
     */
    private String formTitle;

    /**
     * Status text of the form
     */
    private String formStatusText;

    /**
     * Map of the entity providers 
     */
    private Map<Object, IEntityProvider> entityProviderMap = new HashMap<Object, IEntityProvider>();
    
    /**
     * Current entity provider
     */
    private IEntityProvider currentEntityProvider;

    /**
     * True if the form supports 'MULTI FORM' mode
     * We can use it with entity providers
     */
    private boolean multiForm;
    
    /**
     * True if entity providers will configure form 
     */
    private boolean autoConfigProvidersForm = true;
    
    /**
     * True if entity providers will configure service
     */
    private boolean autoConfigProvidersService;
    
    /**
     * Acceptor of the form
     */
    private IAcceptor formAcceptor;

    
    private ItemToolBar itemToolBar;

    /**
     *  Id of previous form, action
     */
    private Serializable forwardId;

    /** 
     * Entity of previous form, action and etc.
     * Forward entity is not parent entity.
     */
    private Object forwardEntity;

    /**
     * Special category entity
     * For example, we can use the category entity in tree.
     */
    private Object categoryEntity;
    

    private boolean supportParentEntity;

    //

    private boolean supportAddMode = true;

    private boolean supportEditMode = true;

    private boolean supportDelMode = true;

    private boolean supportCopyMode = false;

    //

    private boolean supportPreferencesMode = true;

    private boolean autoSendFocusOut = false;

    //


    /**
     * From arguments
     */
    private List<String> arguments;

    /**
     * Parent form (optional)
     */
    private IForm parentForm;

    /**
     * Form preferences
     */
    protected Properties preferences;

    /**
     * File name of preferences
     */
    protected String preferencesFileName;

    /**
     * True if preferences was modified
     */
    protected boolean modifyPreferences;

    /**
     * Preferences listeners
     */
    private PreferencesListener preferencesListener;
    
    /**
     * True if form has 'CANCEL' state
     */
    protected boolean cancelState;

    /**
     * Form Listeners: openForm, closeForm, updateForm, disposeForm
     */
    private List<FormListener> formListeners = new ArrayList<FormListener>();

    /**
     * If true then force update after modify data (doCreateData(), doStoreData(), doChooseData)
     */
    private boolean forceUpdate = true;
    
    
    
    private Map<String, Long> eventTimeMap = new HashMap<String, Long>();
    
    private IEntitySelector entitySelector;
    
    
    private ObjectCreator objectCreator;
    
    
    
    public AbstractForm(Composite parent, int style) {
	super(parent, style);
	if (parent instanceof IFormDecorator) {
	    setDecorator((IFormDecorator) parent);
	    ((IFormDecorator) parent).setForm(this);
	}
	//addPreferencesListener(); // TODO
    }

    public void setParentForm(IForm parentForm) {
	this.parentForm = parentForm;
    }
    
    
    public IForm getParentForm() {
	return parentForm;
    }
    

    public boolean isModify() {
	return getModel().isModify();
    }

    public void setModify(boolean modify) {
	getModel().setModify(modify);
    }

    public void setEntityId(Serializable entityId) {
	getModel().setEntityId(entityId);
    }

    public Serializable getEntityId() {
	return getModel().getEntityId();
    }

    public Serializable getSelectedEntityId() {
	return getEntityId();
    }

    public Object getSelectedEntity() {
	return getEntity();
    }

    public void setParentEntityId(Serializable parentEntityId) {
	getModel().setParentEntityId(parentEntityId);
    }

    public Serializable getParentEntityId() {
	return getModel().getParentEntityId();
    }

    public void setEntityClass(Class entityClass) {
	getModel().setEntityClass(entityClass);
    }

    public Class getEntityClass() {
	return getModel().getEntityClass();
    }

    public void setEntityServiceClass(Class entityServiceClass) {
	getModel().setEntityServiceClass(entityServiceClass);
    }

    public Class getEntityServiceClass() {
	return getModel().getEntityServiceClass();
    }

    public void setEntityCode(String entityCode) {
	getModel().setEntityCode(entityCode);
    }

    public String getEntityCode() {
	return getModel().getEntityCode();
    }

    public void setReadOnly(boolean readOnly) {
	getModel().setReadOnly(readOnly);
    }

    public void setEntity(Object entity) {
	getModel().setEntity(entity);
    }

    public Object getEntity() {
	return getModel().getEntity();
    }

    public void setParentEntity(Object parentEntity) {
	getModel().setParentEntity(parentEntity);
    }

    public Object getParentEntity() {
	return getModel().getParentEntity();
    }

    public Object getEntityService() {
	return getController().getEntityService();
    }

    public Object getService(Class serviceClass) {
	return getController().getService(serviceClass);
    }

    public boolean isReadOnly() {
	return getModel().isReadOnly();
    }

    public IFormDecorator getDecorator() {
	return decorator;
    }

    public void setDecorator(IFormDecorator decorator) {
	checkDecorator(decorator);
	this.decorator = decorator;
	if (decorator != null) {
	    decorator.setForm(this);
	}
    }

    protected void checkDecorator(IFormDecorator decorator) {

    }

    public IFormController getController() {
	if (controller == null) {
	    controller = createController();
	}
	return controller;
    }

    protected abstract IFormController createController();

    public IFormModel getModel() {
	if (model == null) {
	    model = createModel();
	}
	return model;
    }

    protected IFormModel createModel() {
	IFormModel model = new FormModel();
	model.setDataSourceSupport(true);
	return model;
    }

    public void setTitle(String title) {
	formTitle = title;
	if (getDecorator() == null) {
	    // formTitle = title;
	    return;
	}
	getDecorator().setTitle(title);
    }

    public String getTitle() {
	if (formTitle != null) {
	    return formTitle;
	}
	if (getDecorator() == null) {
	    return null;
	    // return formTitle;
	}
	return getDecorator().getTitle();
    }

    protected String getFormTitle() {
	return formTitle;
    }

    protected void setFormTitle(String formTitle) {
	this.formTitle = formTitle;
    }

    protected String getFirstTitle() {
	if (formTitle == null && getDecorator() != null) {
	    formTitle = getDecorator().getTitle();
	}
	return formTitle;
    }

    protected void updateTitle(String title) {
	if (getDecorator() == null) {
	    return;
	}
	if (isEmpty(title)) {
	    return;
	}
	String titleString = "";
	String firstTitle = getFirstTitle();
	if (!isEmpty(firstTitle)) {
	    titleString = firstTitle.trim() + ": ";
	}
	titleString += title.trim();
	getDecorator().setTitle(titleString);
    }

    protected String getTitleString() {
	return null;
    }

    public void setStatusText(String text) {
	if (getDecorator() == null) {
	    formStatusText = text;
	    return;
	}
	getDecorator().setStatusText(text);
    }

    public String getStatusText() {
	if (formStatusText != null) {
	    return formStatusText;
	}
	if (getDecorator() == null) {
	    return null;
	}
	return getDecorator().getStatusText();
    }

    public IControl[] createEntityControls() {
	return null;
    }

    public void updateForm() throws ApplicationException {
	beforeUpdateForm();
	getController().updateForm();
	afterUpdateForm();
    }

    protected void beforeUpdateForm() throws ApplicationException {
    }

    protected void afterUpdateForm() throws ApplicationException {
	updateTitle(getTitleString());
    }

    public void updateEntity() throws ApplicationException {
	beforeUpdateEntity();
	getController().updateEntity();
	afterUpdateEntity();
    }

    protected void beforeUpdateEntity() throws ApplicationException {
    }

    protected void afterUpdateEntity() throws ApplicationException {
    }

    public void updateData() throws ApplicationException {
	beforeUpdateData(); // BEFORE

	validateControls();
	getController().updateData();
	validateData();

	afterUpdateData(); // AFTER
    }

    protected void validateControls() throws ApplicationException {
    }

    protected void validateData() throws ApplicationException {
    }

    protected void beforeUpdateData() throws ApplicationException {
    }

    protected void afterUpdateData() throws ApplicationException {
    }

    /**
     * General initialize the form
     */
    public void init() throws ApplicationException {

	formTitle = null;
	formStatusText = null;

	configure();

	// Initialize form
	initActions();
	initMenuBar();
	initToolBar();

	// Initialize entity providers
	initEntityProviders();

	initControls();

	loadPreferences();
	this.modifyPreferences = true;
    }

    protected void initControls() throws ApplicationException {

    }

    /**
     * General configure the form
     */
    protected void configure() {
	configureModel();
	configureForm();
    }

    protected void configureModel() {
	getController().configureModel();
    }

    protected void configureForm() {
	getController().configureForm();
    }

    public void initActions() throws ApplicationException {
	getController().initActions();
    }

    public void initMenuBar() throws ApplicationException {
	getController().initMenuBar();
    }

    public void initToolBar() throws ApplicationException {
	getController().initToolBar();
    }

    public void updateMode() throws ApplicationException {
	if (getDecorator() == null) {
	    return;
	}
	getDecorator().updateMode();
    }

    /**
     * Initialize entity providers
     */
    protected void initEntityProviders() {
	if (entityProviderMap == null) {
	    return;
	}
	for (IEntityProvider provider : entityProviderMap.values()) {
	    initEntityProvider(provider);
	}
    }

    /**
     * Initialize the entity provider
     * 
     * @param provider
     */
    protected void initEntityProvider(IEntityProvider provider) {
	provider.init();

	provider.setFormHolder(this);
	provider.setEntityManager(getController().getEntityManager());
	provider.setServiceFactory(getController().getServiceFactory());

	Association association = getAssociationByEntityProvider(provider);
	if (association == null) {
	    return;
	}
	provider.setAssociation(association);
	
	initEntityProvider(provider, association);

	if (provider instanceof TableEntityProvider) {
	    initTableEntityProvider((TableEntityProvider) provider);
	}
    }

    protected void initTableEntityProvider(TableEntityProvider provider) {
	Table table = (Table) provider.getTable(); // TODO: STUB
	initItemTable(table);
    }

    protected void initItemTable(Table table) {
	if (table == null) {
	    return;
	}
	if (itemToolBar == null) {
	    return;
	}
	itemToolBar.initTable(table);
    }

    protected Association getAssociationByEntityProvider(IEntityProvider provider) {
	if (provider == null) {
	    return null;
	}
	Association association = null;

	// By code
	String code = provider.getEntityCode();
	if (code != null) {
	    association = AssociationManager.getAssociation(code);
	    if (association != null) {
		return association;
	    }
	}

	// By class
	if (provider.getEntityClass() == null) {
	    return null;
	}
	association = AssociationManager.createAssociationByBeanClass(provider.getEntityClass());

	return association;
    }

    /**
     * Initialize the entity provider by association
     * 
     * @param provider
     * @param association
     */
    protected void initEntityProvider(IEntityProvider provider, Association association) {
	if (association == null) {
	    return;
	}
	if (isAutoConfigProvidersForm()) {
	    initEntityProviderForm(provider, association); // INIT FORM
	}
	if (isAutoConfigProvidersService()) {
	    initEntityProviderService(provider, association); // INIT SERVICE
	}
    }

    /**
     * Initialize the form of entity provider
     * 
     * @param provider
     * @param association
     */
    protected void initEntityProviderForm(IEntityProvider provider, Association association) {
	if (!provider.isSupportEditForm() || provider.getEntityFormClass() != null) {
	    return;
	}
	Class editFormType = getController().getEditFormType();
	provider.setEntityFormClass(getAssociationElement(association,	editFormType));
    }

    /**
     * Initialize the service of entity provider
     * 
     * @param provider
     * @param association
     */
    protected void initEntityProviderService(IEntityProvider provider, Association association) {
	if (provider.getEntityServiceClass() != null) {
	    return;
	}
	Class serviceType = getController().getServiceType();
	provider.setEntityServiceClass(getAssociationElement(association, serviceType));
    }

    protected Class getAssociationElement(IEntityProvider provider, Class type) {
	try {
	    Association association = provider.getAssociation();
	    if (association == null) {
		return null;
	    }
	    return association.getElementByType(type);
	} catch (Throwable ex) {
	    logger.error(ex);
	    return null;
	}
    }

    protected Class getAssociationElement(Association association, Class type) {
	try {
	    return association.getElementByType(type);
	} catch (Throwable ex) {
	    logger.error(ex);
	    return null;
	}
    }

    protected Class getClassByEntityCode(String code) {
	if (code == null) {
	    return null;
	}
	Association association = AssociationManager.getAssociation(code);
	if (association == null) {
	    return null;
	}
	return association.getBeanClass();
    }

    protected Class getServiceClassByEntityCode(String code) {
	if (code == null) {
	    return null;
	}
	return getServiceClassByAssociation(AssociationManager.getAssociation(code));
    }

    protected Class getServiceClassByAssociation(Association association) {
	Class serviceType = getController().getServiceType();
	return association.getElementByType(serviceType);
    }

    protected void updateEntityProviderViews() throws ApplicationException {
	if (entityProviderMap == null) {
	    return;
	}
	Object parentEntity = getModel().getEntity();
	for (IEntityProvider provider : entityProviderMap.values()) {
	    provider.setParentEntity(parentEntity);
	    provider.updateView();
	}
    }

    public void doCreateEntity() throws ApplicationException {
	getController().doCreateEntity();
    }

    public void doLoadEntity() throws ApplicationException {
	getController().doLoadEntity();
    }

    public void doStoreEntity() throws ApplicationException {
	getController().doStoreEntity();
    }

    public void doCreateData() throws ApplicationException {
	beforeCreateData(); // BEFORE
	createData();
	fireUpdateData();
	fireUpdateForm();   // FIX: 2009-02-03
	afterCreateData();  // AFTER
    }

    public void doLoadData() throws ApplicationException {
	beforeLoadData(); // BEFORE
	loadData();
	fireLoadData();
	updateForm();     // REFACTORED: 2011-03-13 
	afterLoadData();  // AFTER
    }

    public void doStoreData() throws ApplicationException {
	beforeStoreData(); // BEFORE
	storeData();
	fireUpdateData();
	fireUpdateForm();  // FIX: 2009-02-03
	afterStoreData();  // AFTER
    }

    protected void beforeCreateData() throws ApplicationException {
    }

    protected void afterCreateData() throws ApplicationException {
    }

    protected void beforeLoadData() throws ApplicationException {
    }

    protected void afterLoadData() throws ApplicationException {
    }

    protected void beforeStoreData() throws ApplicationException {
    }

    protected void afterStoreData() throws ApplicationException {
    }

    protected void createData() throws ApplicationException {
	getController().doCreateData();
    }

    protected void loadData() throws ApplicationException {
	getController().doLoadData();
    }

    protected void storeData() throws ApplicationException {
	getController().doStoreData();
    }

    public void doAction(final String actionId) {

	BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
	    public void run() {

		try {
		    executeAction(actionId);
		} catch (ApplicationException ex) {
		    handleApplicationError(ex);
		} catch (Throwable ex) {
		    handleSystemError(ex);
		}

	    }
	});

    }
    
    protected Throwable getErrorCause(Throwable t) {
	return ErrorTranslator.getCause(t);
    }

    protected void handleApplicationError(Throwable ex) {
	Throwable t = getErrorCause(ex);
	logError(t);
	openApplicationErrorDialog(t);
	setFocus();
    }

    protected void handleSystemError(Throwable ex) {
	Throwable t = getErrorCause(ex);
	logError(t);
	openSystemErrorDialog(t);
	setFocus();
    }
    
    
    public void executeAction(String actionId) throws ApplicationException {
	if (forwardAction(actionId)) {
	    return;
	}
	getController().executeAction(actionId);
    }

    protected boolean forwardAction(String actionId) throws ApplicationException {
	if (HELP_ACTION.equals(actionId)) {
	    doHelpAction();
	} else if (EXIT_ACTION.equals(actionId)) {
	    doExitAction();
	} else if (SETUP_ACTION.equals(actionId)) {
	    doSetupAction();
	} else if (PRINT_ACTION.equals(actionId)) {
	    doPrintAction();
	} else {
	    return false;
	}
	return true;
    }

    public void doHelpAction() throws ApplicationException {
	getController().doHelpAction();
    }

    public void doExitAction() throws ApplicationException {
	getController().doExitAction();
    }

    public void doSetupAction() throws ApplicationException {
	getController().doSetupAction();
    }

    public void doPrintAction() throws ApplicationException {
	if (!hasReportActions()) {
	    openMessageDialog("Info", NO_REPORTS_MESSAGE);
	    return;
	}
	getController().doPrintAction();
    }

    public void setMode(int mode) {
	getModel().setMode(mode);
    }

    public int getMode() {
	return getModel().getMode();
    }
    
    public boolean isNewMode() {
	return isAddMode() || isCopyMode();
    }


    public boolean isEditMode() {
	return getModel().isEditMode();
    }

    public boolean isAddMode() {
	return getModel().isAddMode();
    }

    public boolean isCopyMode() {
	return getModel().isCopyMode();
    }

    public boolean isViewMode() {
	return getModel().isViewMode();
    }

    public void setEditMode() {
	getModel().setEditMode();
    }

    public void setAddMode() {
	getModel().setAddMode();
    }

    public void setViewMode() {
	getModel().setViewMode();
    }

    protected void setDataSourceSupport(boolean isSupport) {
	getModel().setDataSourceSupport(isSupport);
    }

    public boolean hasDataSource() {
	return getModel().hasDataSource();
    }

    public void setChildFormMode(boolean isChildFormMode) {
	setDataSourceSupport(!isChildFormMode);
    }

    public boolean isChildFormMode() {
	return !getModel().hasDataSource();
    }

    public int getWidth() {
	return getSize().x;
    }

    public int getHeight() {
	return getSize().y;
    }

    public IConfigIdentifier getConfigIdentifier() {
	return getController().getConfigIdentifier();
    }

    public void setConfigIdentifier(IConfigIdentifier configIdentifier) {
	getController().setConfigIdentifier(configIdentifier);
    }

    public IConfigIdentifier createConfigIdentifier(Class formClass) {
	return getController().createConfigIdentifier(formClass);
    }
    
    public Association getAssociation() {
	return getController().getAssociation();
    }

    /**
     * General close the form.
     * 
     * @throws ApplicationException
     */
    public void close() throws ApplicationException {

	storePreferences();

	beforeClose();

	if (!cancelState) {
	    // FIRE CLOSE FORM
	    fireCloseForm();
	    removeAllFormListener();
	}

	disposeAll();

	afterClose();
    }

    protected void beforeClose() throws ApplicationException {
	// STUB
    }

    protected void afterClose() throws ApplicationException {
	// STUB
    }

    /**
     * Dispose all. Dispose this object and decorator.
     * 
     */
    protected void disposeAll() {
	dispose();
	getDecorator().close();
    }

    public void sendMessage(String msg) {
	if ("CLOSE".equals(msg)) {
	    try {
		doCloseAction();
	    } catch (Exception ex) {
		logger.error(ex);
	    }
	}

    }

    public void doCloseAction() throws ApplicationException {
	close();
    }

    public void dispose() {
	try {
	    // May be it FORCE fire closing form...
	    // FIRE CLOSE FORM
	    fireCloseForm();
	    removeAllFormListener();
	    //removePreferencesListener(); // TODO
	   
	} catch (Exception ex) {
	    logger.error(ex);
	}

	super.dispose();
    }

    protected void addPreferencesListener() {
	if (preferencesListener == null) {
	    preferencesListener = new FormPreferencesListener();
	}
	SWTApplication app = SWTEnvironment.getApplication();
	if (app != null) {
	    app.addPreferencesListener(preferencesListener);
	}
    }

    protected void removePreferencesListener() {
	if (preferencesListener == null) {
	    return;
	}
	SWTApplication app = SWTEnvironment.getApplication();
	if (app != null) {
	    app.removePreferencesListener(preferencesListener);
	}
    }

    /**
     * Run after open form
     */
    public void openForm(IForm form) throws ApplicationException {
    }

    /**
     * Run after close form
     */
    public void closeForm(IForm form) throws ApplicationException {

    }

    public void updateForm(IForm form) throws ApplicationException {
	
    }

    
    public boolean hasEntityProviders() {
	return entityProviderMap != null && entityProviderMap.size() > 0;
    }

    protected Map<Object, IEntityProvider> getEntityProviderMap() {
	return entityProviderMap;
    }

    /**
     * Register entity provider
     * 
     * @param key - special identifier (code, id and etc.)
     * @param entityProvider
     */
    public void registerEntityProvider(Object key, IEntityProvider entityProvider) {
	entityProviderMap.put(key, entityProvider);
    }

    /**
     * Register entity provider
     * @param key
     * @param entityClass
     */
    public void registerEntityProvider(Object key, Class entityClass) {
	IEntityProvider entityProvider = new DefaultEntityProvider(entityClass);
	registerEntityProvider(key, entityProvider);
    }


    /**
     * Register entity provider
     * @param entityCode
     */
    public void registerEntityProvider(String entityCode) {
	IEntityProvider entityProvider = new DefaultEntityProvider();
	entityProvider.setEntityCode(entityCode);
	registerEntityProvider(entityCode, entityProvider);
    }

    /**
     * Return the entity provider by key
     * 
     * @param key
     * @return
     */
    protected IEntityProvider getEntityProvider(Object key) {
	return entityProviderMap.get(key);
    }

    /**
     * Return the selected (current) entity provider
     * 
     * @return
     */
    protected IEntityProvider getSelectedEntityProvider() {
	return getEntityProvider(getSelectedEntityProviderKey());
    }

    /**
     * Return the selected entity provider key. 
     * You have to replace this method
     * 
     * @return
     */
    protected Object getSelectedEntityProviderKey() {
	return null;
    }

    /**
     * Choose class of the EditForm
     * @return
     */
    protected Class getChooseEditFormClass() {

	List entities = getEntityProviderViews();
	Object selectedItem = getChooseObject(entities);
	if (selectedItem == null) {
	    return null;
	}
	Object key = getEntityProviderKey(selectedItem);
	IEntityProvider type = getEntityProviderMap().get(key);
	setCurrentEntityProvider(type);
	if (type == null) {
	    return null;
	}
	return type.getEntityFormClass();
    }

    protected List getEntityProviderViews() {
	List entities = new ArrayList();
	Iterator keys = getEntityProviderMap().keySet().iterator();
	while (keys.hasNext()) {
	    Object key = keys.next();
	    if (!isAssignEntityProviderKey(key)) {
		continue;
	    }
	    entities.add(getEntityProviderView(key));
	}
	return entities;
    }

    protected boolean isAssignEntityProviderKey(Object key) {
	return true;
    }

    /**
     * Return entity view by key
     * For example: key = 'SALE_ORDER', view = 'Sale Order'
     * @param key
     * @return
     */
    protected Object getEntityProviderView(Object key) {
	return key;
    }

    /**
     * Return entity key by view
     * For example: view = 'Sale Order', key = 'SALE_ORDER' 
     * @param view
     * @return
     */
    protected Object getEntityProviderKey(Object view) {
	return view;
    }
    
    
    
    protected Object getEntityProviderKeyByEntityClass(Class entityClass) {
	if (entityClass == null) {
	    return null;
	}
	if (entityProviderMap == null) {
	    return null;
	}
	Set<Map.Entry<Object, IEntityProvider>> set = entityProviderMap.entrySet();
	for (Map.Entry<Object, IEntityProvider> entry : set) {
	    Object key = entry.getKey();
	    IEntityProvider provider = entry.getValue();
	    Class klass = provider.getEntityClass();
	    if (klass == null) {
		continue;
	    }
	    if (klass.isAssignableFrom(entityClass)) {
		return key;
	    }
	}
	return null;
    }

    protected IEntityProvider getEntityProviderByEntityClass(Class entityClass) {
	if (entityClass == null) {
	    return null;
	}
	if (entityProviderMap == null) {
	    return null;
	}
	Set<Map.Entry<Object, IEntityProvider>> set = entityProviderMap.entrySet();
	for (Map.Entry<Object, IEntityProvider> entry : set) {
	    Object key = entry.getKey();
	    IEntityProvider provider = entry.getValue();
	    Class klass = provider.getEntityClass();
	    if (klass == null) {
		continue;
	    }
	    if (klass.isAssignableFrom(entityClass)) {
		return provider;
	    }
	}
	return null;
    }

    protected Object getEntityProviderKeyByEntity(Object entityObject) {
	if (entityObject == null) {
	    return null;
	}
	return getEntityProviderKeyByEntityClass(entityObject.getClass());
    }

    protected IEntityProvider getEntityProviderByEntity(Object entityObject) {
	if (entityObject == null) {
	    return null;
	}
	return getEntityProviderByEntityClass(entityObject.getClass());
    }

    protected void refreshEntityProviderViewByItem(Object item)
	    throws ApplicationException {
	if (item == null) {
	    return;
	}
	IEntityProvider entityProvider = getEntityProviderByEntity(item);

	if (entityProvider == null) {
	    return;
	}

	entityProvider.refreshView();
    }

    protected void refreshEntityProviderViewByItemAndClass(Object item,
	    Class klass) throws ApplicationException {
	if (item == null) {
	    return;
	}
	if (klass == null) {
	    return;
	}
	refreshEntityProviderViewByItem(item);
    }

    
    /**
     * Create form by mode
     */
    protected IEditForm createEditForm(int mode) {
	setCurrentEntityProvider(null);
	Class formClass = getEntityEditFormClass();
	if (isMultiForm() && hasEntityProviders()) {
	    if (mode == PWT.ADD_MODE) {
		formClass = getChooseEditFormClass();
	    } else {
		IEntityProvider entityProvider = getSelectedEntityProvider();
		setCurrentEntityProvider(entityProvider);

		if (entityProvider == null) {
		    return null;
		}
		formClass = entityProvider.getEntityFormClass();
	    }
	}
	return createEditForm(formClass);
    }
    
    /**
     * Create edit form by class
     * @param formClass
     * @return
     */
    protected IEditForm createEditForm(Class formClass) {
	if (formClass == null) {
	    return null;
	}
	try {
	    IEditForm editForm = (IEditForm) Toolkit.getForm(null, formClass, PWT.EDIT_FORM);
	    return editForm;
	} catch (Exception ex) {
	    return null;
	}
    }
    
    public boolean isMultiForm() {
	return multiForm;
    }

    public void setMultiForm(boolean multiForm) {
	this.multiForm = multiForm;
    }
    
    ////
    
    public Class getEntityEditFormClass() {
	return getModel().getEntityFormClass();
    }

    public void setEntityEditFormClass(Class formClass) {
	getModel().setEntityFormClass(formClass);
    }


    // -----------------------------------------------------------------------------------------------------------------------------------
    //
    // Entity methods. Methods use entity manager. 
    // You can overwrite this methods.
    //
    // -----------------------------------------------------------------------------------------------------------------------------------

    /**
     * Get entity id
     * 
     * @param entity
     * @return entity id
     */
    public Serializable getEntityId(Object entity) {
	return getController().getEntityId(entity);
    }

    /**
     * Load entity by id from data source
     * 
     * @param id
     * @return entity
     * @throws ApplicationException
     */
    protected Object loadEntityById(Serializable id) throws ApplicationException {
	return getController().loadEntityById(id);
    }

    /**
     * Remove entity by Id from data source
     * 
     * @param id
     * @throws ApplicationException
     */
    protected void removeEntityById(Serializable id) throws ApplicationException {
	getController().removeEntityById(id);
    }

    /**
     * Create entity in data source
     * 
     * @param entity
     * @return entity id
     * @throws ApplicationException
     */
    protected Serializable createEntity(Object entity) throws ApplicationException {
	return getController().createEntity(entity);
    }

    /**
     * Create new instance entity
     * 
     * @return
     * @throws ApplicationException
     */
    protected Object newEntity() throws ApplicationException {
	return getController().newEntity();
    }

    protected void initData() throws ApplicationException {

    }

    public DateFormat getDateFormat() {
	return getController().getDateFormat();
    }

    public DateFormat getDateTimeFormat() {
	return getController().getDateTimeFormat();
    }

    public DateFormat getTimeFormat() {
	return getController().getTimeFormat();
    }

    public NumberFormat getNumberFormat() {
	return getController().getNumberFormat();
    }

    public NumberFormat getIntegerFormat() {
	return getController().getIntegerFormat();
    }

    public NumberFormat getCurrencyFormat() {
	return getController().getCurrencyFormat();
    }

    public NumberFormat getPercentFormat() {
	return getController().getPercentFormat();
    }

    public NumberFormat getQuantityFormat() {
	return getController().getQuantityFormat();
    }

    public NumberFormat getCoefficientFormat() {
	return getController().getCoefficientFormat();
    }

    public String formatCurrency(double number) {
	return getCurrencyFormat().format(number);
    }

    protected void resetMode() {
	setMode(PWT.VIEW_MODE);
    }

    public void addAction(IAction action) {
	getController().addAction(action);
    }

    public void addActionDescriptor(IActionDescriptor actionItem) {
	getController().addActionDescriptor(actionItem);
    }
    
    public IActionDescriptor getActionDescriptor(IAction action) {
	return getController().getActionDescriptor(action);
    }

    public Map<IAction, IActionDescriptor> getActionDescriptorMap() {
	return getController().getActionDescriptorMap();
    }
    
    
    
    public void addReportAction(IReportAction action) {
	getController().addReportAction(action);
    }

    public List<IAction> getActions() {
	return getController().getActions();
    }

    public List<IReportAction> getReportActions() {
	return getController().getReportActions();
    }

    public boolean hasReportActions() {
	return getController().hasReportActions();
    }

    public int getActionCount() {
	return getListSize(getActions());
    }

    public int getReportCount() {
	return getListSize(getReportActions());
    }

    protected boolean isEmpty(String str) {
	return StringUtils.isEmpty(str);
    }
    
    protected boolean isEmpty(Collection collection) {
	return SystemUtils.isEmpty(collection);
    }

    protected int getListSize(List list) {
	return SystemUtils.getListSize(list);
    }

    public IAcceptor getFormAcceptor() {
	if (formAcceptor == null) {
	    formAcceptor = new FormAcceptor();
	}
	return formAcceptor;
    }

    public boolean isSupportReportAction(IReportAction action) {
	return true;
    }

    /**
     * The Form acceptor
     * 
     */
    protected class FormAcceptor extends DefaultAcceptor {

	public Map<String, Object> readParameters() throws ApplicationException {
	    Serializable id = getSelectedEntityId();
	    Object entity = getSelectedEntity();
	    if (id == null) {
		return null;
	    }
	    getParameters().put(IAcceptor.ID, id);
	    getParameters().put(IAcceptor.ENTITY, entity);
	    return getParameters();
	}
    }

    public ItemToolBar getItemToolBar() {
	return itemToolBar;
    }

    public void setItemToolBar(ItemToolBar itemToolBar) {
	this.itemToolBar = itemToolBar;
    }

    // ------------------------------------------------------------------------------------------------------------------------------------
    //
    // Validation Management
    //
    // ------------------------------------------------------------------------------------------------------------------------------------

    // /---

    protected void addError(StringBuffer buf, String arg1, String arg2,
	    String separator) {
	addError(buf, arg1 + separator + arg2);
    }

    protected void addError(StringBuffer buf, String arg1, String arg2) {
	addError(buf, arg1, arg2, " ");
    }

    protected void addError(StringBuffer buf, String error) {
	buf.append(error + "\n");
    }

    protected void validateRequiredField(StringBuffer buf, String fieldValue,
	    String fieldName) {
	validateField(buf, ValidationUtils.isValidRequired(fieldValue),
		fieldName, getRequiredResourceString());
    }

    protected void validateRequiredField(StringBuffer buf, Object fieldValue,
	    String fieldName) {
	validateField(buf, ValidationUtils.isValidRequired(fieldValue),
		fieldName, getRequiredResourceString());
    }

    protected void validateRequiredField(StringBuffer buf, boolean isValid, String fieldName) {
	validateField(buf, isValid, fieldName, getRequiredResourceString());
    }

    // General method
    protected void validateField(StringBuffer buf, boolean isValid, String fieldName, String errorMessage) {
	if (isValid) {
	    return;
	}
	addFieldError(buf, fieldName, errorMessage);
    }
    
    protected void addFieldError(StringBuffer buf, String fieldName, String errorMessage) {
	addError(buf, getFieldResourceString() + " [" + fieldName + "] ", errorMessage);
    }
    
    protected void addRequiredFieldError(StringBuffer buf, String fieldName) {
	addFieldError(buf, fieldName, getRequiredResourceString());
    }

    protected void checkError(StringBuffer buf) throws ApplicationException {
	checkError(buf, 0);
    }

    protected void checkError(StringBuffer buf, int specialCharCount)
	    throws ApplicationException {
	String error = buf.toString();
	if (error.length() > specialCharCount) {
	    throw new ApplicationException(error);
	}
    }

    protected String getFieldResourceString() {
	return Messages.getString("Form.valid.field"); //$NON-NLS-1$
    }

    protected String getRequiredResourceString() {
	return Messages.getString("Form.valid.required"); //$NON-NLS-1$
    }

    protected String getNameResourceString() {
	return Messages.getString("Form.name"); //$NON-NLS-1$
    }

    // /---

    public Serializable getForwardId() {
	return forwardId;
    }

    public void setForwardId(Serializable forwardId) {
	this.forwardId = forwardId;
    }

    public Object getForwardEntity() {
	return forwardEntity;
    }

    public void setForwardEntity(Object forwardEntity) {
	this.forwardEntity = forwardEntity;
    }

    public Object getCategoryEntity() {
	return categoryEntity;
    }

    public void setCategoryEntity(Object categoryEntity) {
	this.categoryEntity = categoryEntity;
    }

    // /---

    public boolean isSupportAddMode() {
	return supportAddMode;
    }

    public void setSupportAddMode(boolean supportAddMode) {
	this.supportAddMode = supportAddMode;
    }

    public boolean isSupportDelMode() {
	return supportDelMode;
    }

    public void setSupportDelMode(boolean supportDelMode) {
	this.supportDelMode = supportDelMode;
    }

    public boolean isSupportEditMode() {
	return supportEditMode;
    }

    public void setSupportEditMode(boolean supportEditMode) {
	this.supportEditMode = supportEditMode;
    }

    public boolean isSupportCopyMode() {
	return supportCopyMode;
    }

    public void setSupportCopyMode(boolean supportCopyMode) {
	this.supportCopyMode = supportCopyMode;
    }

    // /

    public void setSupportOnlyEditMode() {
	setSupportAddMode(false);
	setSupportDelMode(false);
	setSupportEditMode(true);
    }

    public Image getImage(String path) {
	return getResourceImage(getClass(), path);
    }

    public static Image getResourceImage(Class klass, String path) {
	return SWTResourceManager.getImage(klass, path);
    }

    public boolean isAutoSendFocusOut() {
	return autoSendFocusOut;
    }

    public void setAutoSendFocusOut(boolean autoSendFocusOut) {
	this.autoSendFocusOut = autoSendFocusOut;
    }

    public IEntityProvider getCurrentEntityProvider() {
	return currentEntityProvider;
    }

    public void setCurrentEntityProvider(IEntityProvider currentEntityProvider) {
	this.currentEntityProvider = currentEntityProvider;
    }

    // //----

    public Serializable getIdentifier() {
	return identifier;
    }

    public void setIdentifier(Serializable identifier) {
	this.identifier = identifier;
    }

    public List<String> getArguments() {
	return arguments;
    }

    public void setArguments(List<String> arguments) {
	this.arguments = arguments;
    }

    public String getArgument() {
	if (!hasArguments()) {
	    return null;
	}
	return arguments.get(0);
    }

    public boolean hasArguments() {
	return arguments != null && !arguments.isEmpty();
    }
    
    public boolean hasArgument(String name) {
	if (name == null) {
	    return false;
	}
	name = name.trim();
	if (name.length() == 0) {
	    return false;
	}
	if (!hasArguments()) {
	    return false;
	}
	for (String argument : arguments) {
	    if (name.equals(argument)) {
		return true;
	    }
	}
	return true;
    }
    
    // //

    protected List getChooseObjectList(List inputList) {
	if (inputList == null || inputList.size() == 0) {
	    return null;
	}
	ChooseDialog dialog = new ChooseDialog(getShell());
	dialog.setCheckMode(true);
	dialog.setList(inputList);
	dialog.open();
	List outputList = dialog.getSelectedItems();
	if (outputList == null || outputList.size() == 0) {
	    return null;
	}
	return outputList;
    }

    protected Object getChooseObject(List inputList) {
	if (inputList == null || inputList.size() == 0) {
	    return null;
	}
	ChooseDialog dialog = new ChooseDialog(getShell());
	dialog.setList(inputList);
	dialog.open();
	return dialog.getSelectedItem();
    }

    protected void openResultDialog(List result) {
	if (result == null || result.size() == 0) {
	    return;
	}
	ChooseDialog dialog = new ChooseDialog(getShell());
	dialog.setCancelMode(false); // Disable cancel button
	// dialog.setText("Result"); // JFace
	dialog.setList(result);
	dialog.open();
    }

    protected void openPropertiesDialog(List result) {
	if (result == null || result.size() == 0) {
	    return;
	}
	ResultDialog dialog = new ResultDialog(getShell());
	dialog.setCancelMode(false); // Disable cancel button
	// dialog.setText("Result"); // JFace
	dialog.setList(result);
	dialog.open();
    }

    protected String[] createStringRow(String label, String value) {
	String[] row = new String[2];
	row[0] = label;
	row[1] = value;
	return row;
    }

    public void logError(Object e) {
	if (e instanceof AccessDeniedException) {
	    logger.error("AccessDenied: " + ((AccessDeniedException) e).getMessage());
	    return;
	}
	logger.error(e);
    }

    public void logWarn(Object e) {
	logger.warn(e);
    }

    public void logInfo(Object e) {
	logger.info(e);
    }

    // ----------------------------------------------------------------------------------------------------------
    //
    // Display ERROR methods
    //
    // ----------------------------------------------------------------------------------------------------------

    protected void openApplicationErrorDialog(Throwable e) {
	Toolkit.openApplicationErrorDialog(e);
    }

    protected void openSystemErrorDialog(Throwable e) {
	Toolkit.openSystemErrorDialog(e);
    }

    protected void openErrorDialog(String title, Throwable e) {
	Toolkit.openErrorDialog(title, e);
    }

    protected void openErrorDialog(String title, String message) {
	Toolkit.openErrorDialog(title, message);
    }

    public void openErrorDialog(Throwable e) {
	Toolkit.openErrorDialog(e);
    }

    // ----------------------------------------------------------------------------------------------------------
    //
    // Display MESSAGE methods
    //
    // ----------------------------------------------------------------------------------------------------------

    public void openMessageDialog(String title, String message) {
	Toolkit.openMessageDialog(title, message);
    }

    public void openMessageDialog(String message) {
	Toolkit.openMessageDialog("Message", message);
    }

    public boolean openConfirmYesNoDialog(String title, String message) {
	return Toolkit.openConfirmYesNoDialog(title, message);
    }

    public boolean openConfirmYesNoDialog(String message) {
	return Toolkit.openConfirmYesNoDialog("Question", message);
    }

    // /---
    
    public void openNotSelecetdRowsDialog() {
	openMessageDialog(ROW_NOT_SELECTED_MESSAGE);
    }
    
    
    protected boolean isConfirmDeleteEntity() {
	return openConfirmYesNoDialog(Messages.getString("Form.confirm.delete.title"), Messages.getString("Form.confirm.delete.question"));
    }
    

    public String getPreferencesFileName() {
	if (preferencesFileName == null) {
	    String folderName = System.getProperty("user.dir") + "/.settings";
	    File folder = new File(folderName);
	    if (!folder.exists()) {
		folder.mkdir();
	    }
	    preferencesFileName = folderName + "/" + getClass().getName() + ".prefs";
	}
	return preferencesFileName;
    }

    public void loadPreferences() throws ApplicationException {
	if (!isSupportPreferencesMode()) {
	    return;
	}

	preferences = new Properties();
	try {

	    String fileName = getPreferencesFileName();
	    File file = new File(fileName);
	    if (file.exists()) {
		FileInputStream fis = new FileInputStream(file);
		preferences.load(fis);
		fis.close();

		loadPreferences(preferences);
	    }
	    initDefaultPreferences();
	} catch (Exception ex) {
	    throw new ApplicationException(ex);
	}
    }

    protected void loadPreferences(Properties preferences) throws ApplicationException {
    }

    public void storePreferences() throws ApplicationException {
	if (!isSupportPreferencesMode()) {
	    return;
	}

	if (preferences == null || !modifyPreferences) {
	    return;
	}
	try {
	    storePreferences(preferences);
	    String fileName = getPreferencesFileName();
	    FileOutputStream fos = new FileOutputStream(fileName);
	    preferences.store(fos, "Plazma Preferences");
	    fos.flush();
	    fos.close();

	} catch (Exception ex) {
	    throw new ApplicationException(ex);
	}
    }

    protected void storePreferences(Properties preferences)
	    throws ApplicationException {
    }

    protected void initDefaultPreferences() {
	if (preferences == null) {
	    return;
	}
	// TODO:
	// setDefaultPreference("test.property", "true");
    }

    public void setPreference(String name, String value) {
	preferences.put(name, value);
	modifyPreferences = true;
    }

    public boolean isPreference(String name) {
	return preferences.get(name) != null;
    }

    public boolean getPreferenceBoolean(String name) {
	return "true".equals(preferences.get(name));
    }

    public void setDefaultPreference(String name, String value) {
	if (!isPreference(name)) {
	    setPreference(name, value);
	}

    }

    public boolean isSupportPreferencesMode() {
	return supportPreferencesMode;
    }

    public void setSupportPreferencesMode(boolean supportPreferencesMode) {
	this.supportPreferencesMode = supportPreferencesMode;
    }

    protected void openWarningDialog(String title, String message) {
	MessageDialog.openWarning(getShell(), title, message);
    }

    protected DecimalFormat createDecimalFormat(String pattern) {
	DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
	DecimalFormat format = new DecimalFormat(pattern, symbols);
	return format;
    }

    protected Object getEntityConfigId(Object obj) {
	return ((IEntityConfig) obj).getConfigId();
    }

    public boolean isSupportParentEntity() {
	return supportParentEntity;
    }

    public void setSupportParentEntity(boolean supportParentEntity) {
	this.supportParentEntity = supportParentEntity;
    }

    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Form Events
    //
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void addFormListener(FormListener listener) {
	formListeners.add(listener);
    }

    public void removeFormListener(FormListener listener) {
	formListeners.remove(listener);
    }

    // ///

    protected void removeAllFormListener() {
	formListeners.clear();
    }

    protected boolean isEmptyFormListeners() {
	return formListeners == null || formListeners.isEmpty();
    }

    // //

    protected FormEvent createFormEvent() {
	return new FormEvent(this);
    }

    // FIRE OPEN FORM
    protected void fireOpenForm() throws ApplicationException {
	if (isEmptyFormListeners()) {
	    return;
	}
	for (FormListener listener : formListeners) {
	    listener.openForm(createFormEvent());
	}
    }

    // FIRE CLOSE FORM
    protected void fireCloseForm() throws ApplicationException {
	if (isEmptyFormListeners()) {
	    return;
	}
	for (FormListener listener : formListeners) {
	    listener.closeForm(createFormEvent());
	}
    }

    // FIRE DISPOSE FORM
    protected void fireDisposeForm() throws ApplicationException {
	if (isEmptyFormListeners()) {
	    return;
	}
	for (FormListener listener : formListeners) {
	    listener.disposeForm(createFormEvent());
	}
    }

    // FIRE UPDATE FORM
    protected void fireUpdateForm() throws ApplicationException {
	if (isEmptyFormListeners()) {
	    return;
	}
	for (FormListener listener : formListeners) {
	    listener.updateForm(createFormEvent());
	}
    }

    public boolean isForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(boolean forceUpdate) {
        this.forceUpdate = forceUpdate;
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////
    
    public void handleOpenForm(IForm form) throws ApplicationException {
	openForm(form);
    }
    
    public void handleCloseForm(IForm form) throws ApplicationException {
	closeForm(form);
    }
    
    public void handleDisposeForm(IForm form) throws ApplicationException {
	
    }
    
    public void handleUpdateForm(IForm form) throws ApplicationException {
	updateForm(form);
    }
  
    ////
    
    class FormPreferencesListener implements PreferencesListener {
	
	 public void loadPreferences(Properties preferences) {
	     handleLoadPreferences(preferences);
	 }
	    
	 public void storePreferences(Properties preferences) {
	     handleStorePreferences(preferences);
	 }
	    
	 public void modifyPreferences(Properties preferences) {
	     handleModifyPreferences(preferences);
	 }
    }
    
    ////
    
    public void handleLoadPreferences(Properties preferences) {
	
    }
    
    public void handleStorePreferences(Properties preferences) {
	
    }

    public void handleModifyPreferences(Properties preferences) {
	
    }

    public boolean isDoubleEvent(String eventName) {
	return isDoubleEvent(eventName, 0);
    }
    
    public boolean isDoubleEvent(String eventName, int delay) {
	
	Long time = eventTimeMap.get(eventName);
	if (time == null) {
	    time = new Long(0);
	    
	}
	Long curTime = System.currentTimeMillis();
	eventTimeMap.put(eventName, curTime);
	if (delay <= 0) {
	    delay = 1000;
	}
	if (curTime - time < delay) {
	    return true;
	}
	
	return false;
	
    }

    
    ////
    
    /**
     * Return modal list form for choose entities
     */
    protected IListForm getChooseListForm(Class listFormClass, FormListener listener) throws ApplicationException {
	IListForm listForm = Toolkit.getListForm(null, listFormClass, true);
	if (listener != null) {
	    listForm.addFormListener(listener);
	}
	listForm.setChooseState(true);
	return listForm;
    }

    protected void setVisibleControl(Control control, boolean visible) {
	SWTUtils.setVisible(control, visible);
    }
    

    /////
    protected List<IReportAction> getSelectedEntityProviderReportActions() {
	IEntityProvider provider = getSelectedEntityProvider();
	return getReportActions(provider);
    }
    
    protected List<IReportAction> getReportActions(IEntityProvider provider) {
	if (provider == null) {
	    return Collections.<IReportAction>emptyList();
	}
	List<IReportAction> reportActions = getController().getProviderReportActions(provider);
	if (reportActions == null) {
	    reportActions = createReportActions(provider);
	    if (reportActions == null) {
		reportActions = new ArrayList<IReportAction>(); 
	    }
	    getController().addProviderReportActions(provider, reportActions);
	}
	return reportActions;
    }
    
    protected List<IReportAction> createReportActions(IEntityProvider provider) {
	Class listFormClass = getAssociationElement(provider, getController().getListFormType());
	IConfigIdentifier configIdentifier = createConfigIdentifier(listFormClass);
	IFormConfig formConfig = getController().getFormConfig(configIdentifier);
	List<IReportAction> reportActions = getController().getReportActions(formConfig);
	if (reportActions == null) {
	    reportActions = new ArrayList<IReportAction>(); 
	} else {
	    try {
		getController().initReportActions(reportActions);
	    } catch (ApplicationException ex) {
		logError(ex);
	    }
	    
	}
	return reportActions;

    }


    protected boolean isMyFormMode() {
	return hasArgument("MY_FORM"); 
    }
    
    protected boolean equals(Object obj1, Object obj2) {
	return SystemUtils.equals(obj1, obj2);
    }
    
    
    ///////////////////////////////////////////////////////////////////////////

    protected void fireLoadData() throws ApplicationException {
	
    }

    protected void fireUpdateData() throws ApplicationException {
	
    }

    ///////////////////////////////////////////////////////////////////////////

    
    public IEntitySelector getEntitySelector() {
        return entitySelector;
    }

    public void setEntitySelector(IEntitySelector entitySelector) {
        this.entitySelector = entitySelector;
    }

    ////
    
    public boolean isAutoConfigureAssociation() {
	return getModel().isAutoConfigureAssociation();
    }

    public void setAutoConfigureAssociation(boolean autoConfigureAssociation) {
	getModel().setAutoConfigureAssociation(autoConfigureAssociation);
    }
    
    ////
    
    public boolean isAutoConfigProvidersForm() {
        return autoConfigProvidersForm;
    }

    public void setAutoConfigProvidersForm(boolean autoConfigProvidersForm) {
        this.autoConfigProvidersForm = autoConfigProvidersForm;
    }

    public boolean isAutoConfigProvidersService() {
        return autoConfigProvidersService;
    }

    public void setAutoConfigProvidersService(boolean autoConfigProvidersService) {
        this.autoConfigProvidersService = autoConfigProvidersService;
    }


    ////
    
    public ObjectCreator getObjectCreator() {
	if (objectCreator == null) {
	    objectCreator = new ObjectCreator();
	    if (getDateFormat() != null) {
		objectCreator.setDateFormat(getDateFormat());
	    }
	}
	return objectCreator;
    }

    
}
