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

package org.plazmaforge.bsolution.pim.client.swt.forms;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.plazmaforge.bsolution.base.CalendarEnvironment;
import org.plazmaforge.bsolution.base.SessionContext;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.base.client.swt.forms.IMyForm;
import org.plazmaforge.bsolution.base.client.swt.forms.common.CalendarHelper;
import org.plazmaforge.bsolution.base.client.swt.forms.common.CalendarSource;
import org.plazmaforge.bsolution.base.common.services.CalendarService;
import org.plazmaforge.bsolution.pim.common.beans.PIMAppointment;
import org.plazmaforge.bsolution.pim.common.beans.PIMEvent;
import org.plazmaforge.bsolution.project.common.beans.Task;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.Toolkit;
import org.plazmaforge.framework.client.forms.IEditForm;
import org.plazmaforge.framework.client.forms.IEntityProvider;
import org.plazmaforge.framework.client.forms.IForm;
import org.plazmaforge.framework.client.forms.IFormController;
import org.plazmaforge.framework.client.models.FormAdapter;
import org.plazmaforge.framework.client.models.FormEvent;
import org.plazmaforge.framework.client.swt.controls.IOzCalendarSource;
import org.plazmaforge.framework.client.swt.controls.OzCalendar;
import org.plazmaforge.framework.client.swt.controls.OzCalendarEvent;
import org.plazmaforge.framework.client.swt.controls.OzCalendar.IOzCalendarMenuBuilder;
import org.plazmaforge.framework.client.swt.controls.OzCalendar.OzCalendarAdapter;
import org.plazmaforge.framework.client.swt.forms.AbstractForm;
import org.plazmaforge.framework.client.swt.forms.IEntitySelector;
import org.plazmaforge.framework.client.swt.forms.SWTFormController;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.platform.EntityEnvironment;


public class PIMCalendarForm extends AbstractForm implements IMyForm {

    /** Organization ID **/
    private Integer organizationId;

    private OzCalendar ozCalendar;
    
    private IEntitySelector calendarSelector;
    
    
    public PIMCalendarForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }

    private void initialize() {
	
	
	
	setTitle(Messages.getString("PIMCalendarForm.title")); //$NON-NLS-1$
	GridLayout gridLayout = new GridLayout();
	setLayout(gridLayout);
	
	ozCalendar = new OzCalendar(this, SWT.NONE);
	ozCalendar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	ozCalendar.addCalendarListener(new OzCalendarAdapter() {
    	    public void eventDoubleClicked(OzCalendarEvent event) {
    		doEditEvent();
    	    }
    	});
	ozCalendar.setMenuBuilder(new IOzCalendarMenuBuilder() {
	    public void buildMenu(OzCalendarEvent event, Menu menu) {
		buildCalendarMenu(event, menu);
	    }
	});

	calendarSelector = CalendarHelper.createEntitySelector(ozCalendar);
	

	setAutoConfigureAssociation(false);
	setAutoConfigProvidersForm(true); // FOR ENTITY PROVIDERS (FORM)
	setAutoConfigProvidersService(true); // FOR ENTITY PROVIDERS (SERVICE)

	registerEntityProvider(Task.CLASS_ID, Task.class);
	registerEntityProvider(PIMAppointment.CLASS_ID, PIMAppointment.class);
	registerEntityProvider(PIMEvent.CLASS_ID, PIMEvent.class);
	
	setMultiForm(true);
    }
    
    protected IFormController createController() {
	SWTFormController controller = new SWTFormController();
	controller.setForm(this);
	return controller;
    }
    
    public void updateForm() throws ApplicationException {
	super.updateForm();
	getParent().layout(); // SPECIAL FOR ECLIPSE RCP and single windows :)
    }
    
    protected void updateTitle(String title) {
	if (isMyFormMode()) {
	    getDecorator().setTitle(Messages.getString("MyPIMCalendarForm.title"));
	    return;
	}
	super.updateTitle(title);
    }
    
    public void init() throws ApplicationException {
	super.init();
	
	// Load data from source
	doLoadData();

    }

    protected void loadData() throws ApplicationException {
	updateCalendar();
    }
      
    /////////////////////////////////////////////////////////////////////////

    private boolean dirtyCalendar = true;
    
    private boolean initCalendarSources = false;
    
    private CalendarService calendarService;
    
    public CalendarService getCalendarService() {
	if (calendarService == null) {
	    calendarService = CalendarEnvironment.getInstance().getCalendarService();
	}
	return calendarService;
    }
   
    protected void updateCalendar() throws ApplicationException {
	if (ozCalendar == null || !dirtyCalendar) {
	    return;
	}
	dirtyCalendar = false;
	if (!initCalendarSources) {
	    initCalendarSources = true;
	    Map<String, Object> parameters = new HashMap<String, Object>();
	    populateMyFormCriteria(parameters);

	    IOzCalendarSource[] sources = CalendarSource.getCalendarSources(getCalendarService(), parameters);
	    ozCalendar.setSources(sources);
	} else {
	    ozCalendar.update();
	}
    }
    
    //////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Populate parameters special for <code>IMyForm</code>
     */
    protected void populateMyFormCriteria(Map<String, Object> parameters) {
	if (parameters == null) {
	    return;
	}
	parameters.put("ORGANIZATION_ID", getOrganizationId());
	parameters.put("RESPONSIBLE_ID", getResponsibleId());
    }
    
    //////////////////////////////////////////////////////////////////////////////////////
    
    
    
    public Integer getOrganizationId() {
	if (organizationId == null) {
	    return getContextOrganizationId();
	}
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getResponsibleId() {
	return getContextResponsibleId();
    }
    
    //////////////////////////////////////////////////////////////////////////////////////    
    
    protected SessionContext getEnterpriseContext() {
	return SessionEnvironment.getContext();
    }

    public Integer getContextOrganizationId() {
	return EnterpriseEnvironment.getOrganizationId(getEnterpriseContext());
    }

    public Integer getContextUserId() {
	return EnterpriseEnvironment.getUserId(getEnterpriseContext());
    }
    
    public Integer getContextResponsibleId() {
	return EnterpriseEnvironment.getResponsibleId(getEnterpriseContext());
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////
    
    
    protected void doEditEvent() {
	try {
	    doEditAction();
	} catch (ApplicationException ex) {
	    openErrorDialog(ex);
	}
    }
    
    protected void fireUpdateData() throws ApplicationException {
	super.fireUpdateData();
	
	//TODO: Must update only one event
	dirtyCalendar = true;
	updateCalendar();
    }

    public class UpdateCalendarListener extends FormAdapter {
	
	public void updateForm(FormEvent event) throws ApplicationException {
	    IForm form = event.getForm();
	    if (form == null) {
		return;
	    }
	    if (!form.isModify()) {
		return;
	    }
	    
	    //TODO: Must update only one event
	    dirtyCalendar = true;
	    updateCalendar();
	}
    }
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////

    protected boolean forwardAction(String actionId) throws ApplicationException {
	
	if (super.forwardAction(actionId)) {
	    return true;
	}
	if (ENTER_ACTION.equals(actionId)) {
	    doEnterAction();
	} else if (ADD_ACTION.equals(actionId)) {
	    doAddAction();
	} else if (DEL_ACTION.equals(actionId)) {
	    doDelAction();
	} else if (EDIT_ACTION.equals(actionId)) {
	    doEditAction();
	} else {
	    return false;
	}
	
	return true;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public void doEnterAction() throws ApplicationException {
	doEnterAction();
    }
	
    public void doAddAction() throws ApplicationException {

	setEntityId(null);

	//////////////////////////////////////////
	
	openEditForm(PWT.ADD_MODE, null, null);
	
	//////////////////////////////////////////
	
    }
    
    public void doEditAction() throws ApplicationException {
	Serializable id = getSelectedEntityId(); // Get entity id
	if (id == null) {
	    return;
	}
	setEntityId(id);
	
	//////////////////////////////////////////
	
	openEditForm(PWT.EDIT_MODE, id, null);
	
	//////////////////////////////////////////
	
    }
    
    public void doDelAction() throws ApplicationException {
	if (!isConfirmDeleteEntity()) {
	    return;
	}
	Serializable id = getSelectedEntityId();
	removeEntityById(id);
	fireUpdateData();
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////
    
    public void openEditForm(int mode, Serializable id, Object entity) throws ApplicationException {
	
	//IEditForm form = getEditForm(mode); // DISABLE
	IEditForm form = createEditForm(mode);
	if (form == null) {
	    return;
	}
	form.setMode(mode);
	initEditForm(form); // DISABLE

	//
	// Special mode for parent and children edit from
	// You must move this code to parent form
	//
	//initEditFormParent(form); // DISABLE

	form.setEntityId(id);
	
	//form.addFormListener(new SimpleFormListener()); // DISASBLE
	form.addFormListener(new UpdateCalendarListener());
	
	form.setParentForm(this);

	// Only for EDIT_MODE
	form.setForwardId(mode == PWT.EDIT_MODE ? id : null);
	form.setForwardEntity(mode == PWT.EDIT_MODE ? entity : null);

	//form.setCategoryEntity(getSelectedCategoryEntity()); // DISABLE
	
	// 
	// Set entity to form is optional mode !!! 
	//
	// If the edit form doesn't have data source
	// or the edit form doesn't use entity service
	// or the edit form has COPY_MODE
	// then you have to set entity of the edit form.
	//
	if (mode == PWT.COPY_MODE || !form.hasDataSource()) {
	    form.setEntity(entity);
	}

	
	Toolkit.openForm(this, form);
    }
    

    protected void buildCalendarMenu(OzCalendarEvent event, Menu menu) {
	CalendarHelper.buildCalendarMenu(event, menu, getDecorator());
    }

    protected void initEditForm(IEditForm form) {
	CalendarHelper.initCalendarEditForm(ozCalendar, form, getDecorator());
    }

   
    /////////////////////////////////////////////////////////////////////////////////////////////
    
    protected void removeEntityById(Serializable id) throws ApplicationException {
	IEntityProvider entityProvider = getSelectedEntityProvider();
	if (entityProvider == null) {
	    return;
	}
	entityProvider.removeEntityById(id);
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public Serializable getSelectedEntityId() {
	return calendarSelector.getSelectedEntityId();
    }

    public boolean isSelected() {
	return calendarSelector.isSelected();
    }


    public Object getSelectedEntity() {
	return calendarSelector.getSelectedEntity();
    }
    
    ////
    
    public String getSelectedEventType() {
	return ozCalendar.getSelectedEvent() == null ? null : ozCalendar.getSelectedEvent().getType();
    }

    @Override
    protected Object getSelectedEntityProviderKey() {
	return getSelectedEventType();
    }
    
    //////////////////////////////////////////////////////////////////////////////////
    
    
    protected Object getEntityProviderView(Object key) {
	return EntityEnvironment.getEntityById((String) key);
    }
    
    protected Object getEntityProviderKey(Object view) {
	return getEntityConfigId(view);
    } 
}
