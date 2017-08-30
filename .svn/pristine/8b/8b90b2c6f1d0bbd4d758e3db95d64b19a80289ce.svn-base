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


package org.plazmaforge.framework.client.swt.controls;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;


import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.plazmaforge.framework.client.Environment;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.Toolkit;
import org.plazmaforge.framework.client.forms.IEditForm;
import org.plazmaforge.framework.client.forms.IEditFormInitializer;
import org.plazmaforge.framework.client.forms.IForm;
import org.plazmaforge.framework.client.forms.IListForm;
import org.plazmaforge.framework.client.forms.IListFormInitializer;
import org.plazmaforge.framework.client.models.DataFilter;
import org.plazmaforge.framework.client.models.FormEvent;
import org.plazmaforge.framework.client.models.FormListener;
import org.plazmaforge.framework.client.models.LoadEvent;
import org.plazmaforge.framework.client.models.UpdateEvent;
import org.plazmaforge.framework.client.models.ValueChangeEvent;
import org.plazmaforge.framework.client.models.ValueChangeListener;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.association.Association;
import org.plazmaforge.framework.ext.association.AssociationManager;

/** 
 * @author Oleh Hapon
 *
 */

public class XComboEdit extends Combo  {


    public static final String SERVICE_CLASS = "SERVICE_CLASS";
    
    public static final String LIST_FORM_CLASS = "LIST_FORM_CLASS";
    
    public static final String EDIT_FORM_CLASS = "EDIT_FORM_CLASS";
    

    protected static final Image VIEW_IMAGE = getResourceImage(XComboEdit.class, "/org/plazmaforge/framework/client/images/eclipse/combo_edit/compare_m_4.gif");
    
    protected static final Image EDIT_IMAGE = getResourceImage(XComboEdit.class, "/org/plazmaforge/framework/client/images/eclipse/combo_edit/edittsk_tsk_h.gif");
    
    protected static final Image DELETE_IMAGE = getResourceImage(XComboEdit.class, "/org/plazmaforge/framework/client/images/eclipse/combo_edit/close_view_m.gif");
    
    protected static final Image ADD_IMAGE = getResourceImage(XComboEdit.class, "/org/plazmaforge/framework/client/images/eclipse/combo_edit/edittsk_tsk_h_new.gif");
    

    /**
     * Control to view an entity
     */
    protected ToolButton  viewControl;
    
    /**
     * Control to edit an entity
     */
    protected ToolButton editControl;

    /**
     * Control to add an entity
     */
    protected ToolButton addControl;
    
    /**
     * Control to delete an entity
     */
    protected ToolButton deleteControl;
    
    
    
    
    
    private boolean supportService = true;
    
    private boolean flatData;
    
    private int modifyMode = PWT.EDIT_MODE;
    

    /** List form event marker **/
    private final String LIST_FORM_EVENT = "LIST_FORM";

    /** Edit form event marker **/
    private final String EDIT_FORM_EVENT = "EDIT_FORM";

    /** Delete event marker **/
    private final String DELETE_EVENT = "DELETE";
    
    
    
    private boolean isConfigure;
    
    private Association association;
    

    private IListFormInitializer listFormInitializer;
    
    private IEditFormInitializer editFormInitializer;
    
    
    
    public XComboEdit(Composite parent, int style) {
	super(parent, style);
    }


    public XComboEdit(Composite parent, int style, int toolStyle) {
	super(parent, style, toolStyle);
	
    }

    public void init() {
	super.init();
	configure();
	loadData();
    }

    /**
     * Return true if the component has control to view an entity
     * @return
     */
    protected boolean hasViewControl() {
	return (getToolStyle() & PWT.VIEW_BUTTON) != 0;
    }
    
    /**
     * Return true if the component has control to edit an entity
     * @return
     */
    protected boolean hasEditControl() {
	return ((getToolStyle() & PWT.EDIT_BUTTON) != 0);
    }
    
    /**
     * Return true if the component has control to delete an entity 
     * @return
     */
    protected boolean hasDeleteControl() {
	return (getToolStyle() & PWT.DELETE_BUTTON) != 0;
    }
    
    /**
     * Return true if the component has control to add an entity
     * @return
     */
    protected boolean hasAddControl() {
	return (getToolStyle() & PWT.ADD_BUTTON) != 0;
    }
    
    
    
    
    
    /**
     * Return true if the component has any control to manage an antity
     * @return
     */
    protected boolean hasExToolControl() {
	return (hasViewControl() || hasEditControl() || hasAddControl() || hasDeleteControl());
    }
    
    /**
     * Create ToolBar
     */
    protected  void createToolBar() {

	
	super.createToolBar();
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// VIEW CONTROL
	//
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	if (hasViewControl()) {
	    
	    // FIX 2010-04-01
	    viewControl = createToolControl(this, VIEW_IMAGE);
	    viewControl.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		    handleViewControlEvent();
		}
	    });
	    
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// EDIT CONTROL
	//
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	if (hasEditControl()) {
	    
	    // FIX 2010-04-01
	    editControl = createToolControl(this, EDIT_IMAGE);
	    editControl.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		    handleEditControlEvent();
		}
		
	    });
	    
	    addValueChangeListener(new ValueChangeListener() {
		public void valueChange(ValueChangeEvent evt) {
		    setEditControlMode();
		}
	    });
	}
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// ADD CONTROL
	//
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////

	if (hasAddControl() && !hasEditControl()) {
	    
	    // FIX 2010-04-01
	    addControl = createToolControl(this, ADD_IMAGE);
	    addControl.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		    handleAddControlEvent();
		}
		
	    });
	    
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// DELETE CONTROL
	//
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////

	if (hasDeleteControl()) {
	    
	    // FIX 2010-04-01
	    deleteControl = createToolControl(this, DELETE_IMAGE);
	    deleteControl.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		    handleDeleteControlEvent();
		}
	    });
	    
	}
	

	
    }
    
    protected ToolButton createToolControl(Composite parent, Image image) {
	ToolButton toolControl = new ToolButton(parent, SWT.NONE);
	if (image != null) {
	    setToolControlImage(toolControl, image); 
	}
	return toolControl;
    }
    
    /**
     * Handle view control event
     *
     */
    protected void handleViewControlEvent() {
	executeProcess(new Runnable() {
            public void run() {
        	processViewControlEvent();
            }
	});
    }
    
    protected void processViewControlEvent() {
	
	try {
	    
	    Class listFormClass = (Class) getModel().getProperty(LIST_FORM_CLASS);
	    if (listFormClass == null) {
		logger.warn("List form class not found");
		return;
	    }
		
	    // Create and open list form
	    // Form has modal and choose state
	    IListForm listForm = Toolkit.getListForm(null, listFormClass, true);
	    
	    listForm.setParentEntityId(getParentEntityId());
	    listForm.setParentEntity(getParentEntity());
	    
	    
	    //FIX: 2009-02-02
	    //listForm.setFormHolder(this); 
	    listForm.addFormListener(new XFormListener());
	    
	    listForm.setChooseState(true); // Set special state when the form will auto close after choose a record (row)
	    
	    
	    if (getListFormInitializer() != null) {
		getListFormInitializer().initListForm(listForm);
	    }

	    
	    Toolkit.openForm(null, listForm);
	    Object value = getValue(); 
	    if (value != null) {
		listForm.setPositionByEntity(value);
	    }
	    
	} catch (Exception ex) {
	    logger.error(ex);
	}
	
    }    
    
    /**
     * Handle edit control event
     *
     */
    protected void handleEditControlEvent() {
	executeProcess(new Runnable() {
            public void run() {
        	processEditControlEvent();
            }
	});
    }
    
    protected void executeProcess(final Runnable process) {
	BusyIndicator.showWhile(Display.getCurrent(), process);
    }
    
    
    protected void processEditControlEvent() {
	try {
	    
	    Class editFormClass = (Class) getModel().getProperty(EDIT_FORM_CLASS);
	    if (editFormClass == null) {
		return;
	    }

	    
	    // Create and open edit form
	    IEditForm editForm = (IEditForm) Toolkit.getForm(null, editFormClass, PWT.EDIT_FORM);
	    
	    
	    //FIX: 2009-02-02
	    //editForm.setFormHolder(this);
	    editForm.addFormListener(new XFormListener());
	    
	    
	    Serializable entityId = null;
	    Object value = getValue();
	    if (value != null) {
		entityId = Environment.getEntityManager().getEntityId(value);
	    }
	    
	    // Analyze edit mode
	    // If value is null then we set edit mode to ADD_MODE
	    
	    if (isValueAddMode()) {
		editForm.setMode(PWT.ADD_MODE);
	    } else {
		editForm.setMode(PWT.EDIT_MODE);
		
	    }
	    
	    editForm.setEntityId(entityId);
	    
	    if (getEditFormInitializer() != null) {
		getEditFormInitializer().initEditForm(editForm);
	    }

	    Toolkit.openForm(null, editForm);
	} catch (Exception ex) {
	    logger.error(ex);
	}
		
    }
    
    
    
    /**
     * Handle add control event
     *
     */
    protected void handleAddControlEvent() {
	executeProcess(new Runnable() {
            public void run() {
        	processAddControlEvent();
            }
	});
    }

    protected void processAddControlEvent() {
	
	try {
	    
	    Class editFormClass = (Class) getModel().getProperty(EDIT_FORM_CLASS);
	    if (editFormClass == null) {
		return;
	    }	    
	    
	    // Create and open edit form
	    // Form has modal and choose state
	    IEditForm editForm = (IEditForm) Toolkit.getForm(null, editFormClass, PWT.EDIT_FORM);
	    
	    //FIX: 2009-02-02
	    //editForm.setFormHolder(this);
	    editForm.addFormListener(new XFormListener());
	    
	    Serializable entityId = null;
	    editForm.setMode(PWT.ADD_MODE);
	    editForm.setEntityId(entityId);
	    
	    if (getEditFormInitializer() != null) {
		getEditFormInitializer().initEditForm(editForm);
	    }
	    
	    Toolkit.openForm(null, editForm);
	} catch (Exception ex) {
	    logger.error(ex);
	}
	
    }
    /**
     * Handle delete control event  
     *
     */
    protected void handleDeleteControlEvent() {
	setValue(null);
	setModify(true);
	notifyUpdateListener(new UpdateEvent(DELETE_EVENT));
    }
    
    
    
    

    
    /**
     * Configure this component.
     *
     */
    protected void configure() {

	if (isConfigure) {
	    return;
	}

	getController().initValueClass();

	if (getValueClass() == null) {
	    return;
	}
	isConfigure = true;
	Association association = getAssociation();
	if (association == null) {
	    return;
	}

	configureService(association);

	configureListForm(association);

	configureEditForm(association);

    }
    
    /**
         * Configure the service class. If the service class is not null then
         * return.
         * 
         * @param association
         */
    protected void configureService(Association association) {
	if (!hasSupportService() || service != null || getServiceClass() != null || Environment.getServiceFactory() == null) {
	    return;
	}
	configureModelProperty(SERVICE_CLASS, association, getServiceType());
    }
    
    /**
     * Configure the list form class.
     * If the list form class is not null then return.
     * @param association
     */
    protected void configureListForm(Association association) {
	if (!hasViewControl() || getListFormClass() != null) {
	    return;
	}
	configureModelProperty(LIST_FORM_CLASS, association, getListFormType());
    }
    
    /**
     * Configure the edit form class.
     * If the edit form class is not null then return. 
     * @param association
     */
    protected void configureEditForm(Association association) {
	if ((!hasEditControl() && !hasAddControl()) || getEditFormClass() != null) {
	    return;
	}
	configureModelProperty(EDIT_FORM_CLASS, association, getEditFormType());
    }
    
    /**
     * Return Service type
     * @return
     */
    protected Class getServiceType() {
	return Environment.getServiceFactory().getServiceType();
    }
    
    /**
     * Return ListForm type
     * @return
     */
    protected Class getListFormType() {
	if (Environment.getFormFactory() == null || Environment.getFormFactory().getListFormType() == null) {
	    return IListForm.class;
	}
	return Environment.getFormFactory().getListFormType();
    }
    
    /**
     * Return EditForm type
     * @return
     */
    protected Class getEditFormType() {
	if (Environment.getFormFactory() == null || Environment.getFormFactory().getEditFormType() == null) {
	    return IEditForm.class;
	}
	return Environment.getFormFactory().getEditFormType();
    }
    
    
    
    protected void configureModelProperty(String property, Association association, Class type) {
	try {
	    getModel().setProperty(property, association.getElementByType(type));
	} catch (Exception ex) {
	    logger.error(ex);
	}
    }
    
    
    public boolean hasSupportService() {
        return supportService;
    }


    public void setSupportService(boolean useService) {
        this.supportService = useService;
    }

    

    public boolean isFlatData() {
        return flatData;
    }


    public void setFlatData(boolean flatData) {
        this.flatData = flatData;
    }


    public void setServiceClass(Class entityClass) {
	getModel().setProperty(SERVICE_CLASS, entityClass);
    }
    
    public Class getServiceClass() {
	return (Class) getModel().getProperty(SERVICE_CLASS);
    }    
    
    public void setListFormClass(Class entityClass) {
	getModel().setProperty(LIST_FORM_CLASS, entityClass);
    }
    
    public Class getListFormClass() {
	return (Class) getModel().getProperty(LIST_FORM_CLASS);
    }     
    
    public void setEditFormClass(Class entityClass) {
	getModel().setProperty(EDIT_FORM_CLASS, entityClass);
    } 
    
    public Class getEditFormClass() {
	return (Class) getModel().getProperty(EDIT_FORM_CLASS);
    }     
    
    
    
    
    
    
    protected Association getAssociation() {
	if (association == null) {
	    association = createAssociation(getAssociationValueClass());
	}
	return association;
    }
    
    protected Association createAssociation(Class beanClass) {
	return AssociationManager.createAssociationByBeanClass(beanClass);
    }   
    
    /**
     * Load data by service 
     *
     */
    protected void loadData() {
	try {
	    if (!hasSupportService()) {
		return;
	    }
	    if (!hasPopupControl()) {
		return;
	    }
	    
	    List dataList = getDataListByService();
	    dataList = getFilterList(dataList);
	    
	    if (isFlatData()) {
		// TODO
		// Do nothing
	    } else {
		setDataList(dataList);
	    }
	    
	} catch (Exception ex) {
	    logger.error(ex);
	} finally {
	    notifyLoadListener(new LoadEvent("LOAD_DATA"));
	}
	
    }
    
    protected List getFilterList(List list) {
	if  (list == null || !hasDataFilters()) {
	    return list;
	}
	List result = new ArrayList();
	List<DataFilter> filters = getDataFilters();
	for (Object data: list) {
	    for (DataFilter f: filters) {
		if (f.isFilter(data) ) {
		    result.add(data);
		}
	    }
	}
	return result;
    }
    
    /**
     * Return entity service 
     * @return
     */
    public Object getService() {
	
	// Own service has high priority
	if (service != null) {
	    return service;
	}
	
	// Get service class
	Class serviceClass = getServiceClass();
	if (serviceClass == null) {
	    return null;
	}
	if (Environment.getServiceFactory() == null){
	    return null;
	}
	return Environment.getServiceFactory().getService(serviceClass);
    }
    
    /**
     * Get data list by service
     * @return
     * @throws ApplicationException
     */
    protected List getDataListByService() throws ApplicationException {
	Object service = getService();
	
	if (service == null ) {
	    return null;
	}
	if (service instanceof IDataListProvider) {
	    return ((IDataListProvider) service).getDataList();
	}
	if (Environment.getEntityManager() == null) {
	    return null;
	}
	List dataList = Environment.getEntityManager().findAll(service);
	return dataList;
    }
    
    
    private Object service;
    
    public void setService(Object service) {
	this.service = service;
    }
    
    
    /**
     * Run before open form
     * @param form
     * @throws ApplicationException
     */
    public void beforeForm(IForm form)  throws ApplicationException {}

    
    /**
     * Run after close form
     * @param form
     * @throws ApplicationException
     */
    public void afterForm(IForm form)  throws ApplicationException {
	if (form == null) {
	    return;
	}
	if (form instanceof IListForm) {
	    IListForm listForm = (IListForm) form;
	    Object entity = listForm.getEntity();
	    String eventType = LIST_FORM_EVENT;
	    if (listForm.isModify()) {
		setModify(true);
		updateList();	// !!! UPDATE LIST !!!
		Event ne = new Event();
		ne.data = eventType;
		notifyListeners(SWT.Modify, ne);
	    }
	    if (entity != null) {
		setValue(entity); // !!! SET VALUE !!!
		Event ne = new Event();
		ne.data = eventType;
		notifyListeners(SWT.Selection, ne);
		notifyUpdateListener(new UpdateEvent(eventType));
	    }
	    
	} else  if (form instanceof IEditForm) {
	    IEditForm editForm = (IEditForm) form;
	    Object entity = editForm.getEntity();
	    String eventType = EDIT_FORM_EVENT;
	    if (editForm.isModify()) {
		setModify(true);
		updateList();		// !!! UPDATE LIST !!!
		setValue(entity); 	// !!! SET VALUE !!!
		notifyUpdateListener(new UpdateEvent(eventType));
	    }
	}
    }
  
    
    private class XFormListener implements FormListener {
	
	public void openForm(FormEvent event) throws ApplicationException{
	    
	}
	    
	public void closeForm(FormEvent event) throws ApplicationException {
	    afterForm(event.getForm());
	}
	    
	public  void disposeForm(FormEvent event) throws ApplicationException {
	    
	}
	    
	
	public void updateForm(FormEvent event) throws ApplicationException {
	    
	}
    }
    
    /**
     * Returns true if <code>EventObject</code> is marked by LIST_FROM
     * @param event
     * @return 
     */
    public boolean isListFormEvent(EventObject event) {
	if (event == null) {
	    return false;
	}
	return LIST_FORM_EVENT.equals(event.getSource() /*event.data*/);
    }

    /**
     * Update list
     * 
     */
    protected void updateList() {
	if (!hasPopupControl()) {
	    return;
	}
	loadData();
	
    }
    
    /**
     * Handle key released event
     */
    protected void handleKeyReleased(KeyEvent e) {

	// DELETE
	if (e.keyCode == SWT.DEL && hasDeleteControl() && !getEditable()) {
	    handleDeleteControlEvent();
	    return;
	}
	
	
	// ENTER + SHIFT
	if (e.keyCode == SWT.CR && e.stateMask == SWT.SHIFT && hasEditControl()) {
	    handleEditControlEvent();
	    return;
	}
	
	// (DOWN or UP) + CTRL
	if ((e.keyCode == SWT.ARROW_DOWN || e.keyCode == SWT.ARROW_RIGHT) && e.stateMask == SWT.CTRL && hasViewControl()) {
	    handleViewControlEvent();
	    return;
	}
	
	super.handleKeyReleased(e);
    }

 

    protected boolean pushButton() {
	if (super.pushButton()) {
	    return true;
	}
	if (hasViewControl()) {
	    handleViewControlEvent();
	    return true;
	}
	return false;
    }    
    
    
    
    public Object getValue() {
	if (hasPopupControl()) {
	    return super.getValue();
	}
	return getModelValue();
    }
    
    
    public void setValue(Object value) {
	if (hasPopupControl()) {
	    super.setValue(value);
	}
	setModelValue(value);	
    }
    
    
    protected void setEditControlMode() {
	if (!hasEditControl()) {
	    return;
	}
	
	int mode = isValueAddMode() ? PWT.ADD_MODE : PWT.EDIT_MODE;
	if (mode == modifyMode) {
	    return;
	}
	modifyMode = mode;
	if (mode == PWT.ADD_MODE) {
	    setToolControlImage(editControl, ADD_IMAGE); 
	} else {
	    setToolControlImage(editControl, EDIT_IMAGE);
	}
	
    }
    
    /**
     * Return true if value is empty (value is null or id of value is null)
     * @return
     */
    protected boolean isValueAddMode() {
	Object value = getValue();
	if (value == null) {
	    return true;
	}
	Object entityId = Environment.getEntityManager().getEntityId(value);
	if (entityId == null) {
	    return true;
	}
	return false;
    }

    

    public IListFormInitializer getListFormInitializer() {
        return listFormInitializer;
    }


    public void setListFormInitializer(IListFormInitializer listFormInitializer) {
        this.listFormInitializer = listFormInitializer;
    }


    public IEditFormInitializer getEditFormInitializer() {
        return editFormInitializer;
    }


    public void setEditFormInitializer(IEditFormInitializer editFormInitializer) {
        this.editFormInitializer = editFormInitializer;
    }
    

    protected Control[] getToolButtons() {
	Control[] buttons = new Control[5];
	buttons[0] = popupControl;
	buttons[1] = viewControl;
	buttons[2] = editControl;
	buttons[3] = addControl;
	buttons[4] = deleteControl;
	return buttons;	    
    }

    
}
