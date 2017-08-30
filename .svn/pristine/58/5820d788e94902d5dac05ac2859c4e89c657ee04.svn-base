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


import java.util.ArrayList;
import java.util.List;


import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.Toolkit;
import org.plazmaforge.framework.client.controls.IControl;
import org.plazmaforge.framework.client.forms.IEditForm;
import org.plazmaforge.framework.client.forms.IEditFormController;
import org.plazmaforge.framework.client.forms.IEditFormDecorator;
import org.plazmaforge.framework.client.forms.IEntityProvider;
import org.plazmaforge.framework.client.forms.IForm;
import org.plazmaforge.framework.client.forms.IFormController;
import org.plazmaforge.framework.client.forms.IFormDecorator;
import org.plazmaforge.framework.client.forms.IListForm;
import org.plazmaforge.framework.client.models.FormEvent;
import org.plazmaforge.framework.client.models.FormListener;
import org.plazmaforge.framework.client.swt.SWTResourceManager;
import org.plazmaforge.framework.client.swt.controls.AbstractControl;
import org.plazmaforge.framework.client.swt.controls.AbstractTextControl;
import org.plazmaforge.framework.client.swt.controls.ISWTTextControl;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 *
 */

public abstract class AbstractEditForm extends AbstractForm implements IEditForm {

 

    
    private List<IControl> editControls = new ArrayList<IControl>();

    
    public AbstractEditForm(Composite parent, int style) {
	super(parent, style);
	
	setSupportPreferencesMode(false); 
	
	setAutoConfigProvidersForm(true); // FOR ENTITY PROVIDERS (INIT FORM)
	setAutoConfigProvidersService(false); // FOR ENTITY PROVIDERS (NO INIT SERVICE) 

    }
    
    public void init() throws ApplicationException {
	super.init();
	
	// Load data from source
	doLoadData();
    }
    
    public void doLoadData() throws ApplicationException {
	
	BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
            public void run() {
        	try {
        	    processLoadData();
        	} catch (ApplicationException ex) {
        	    handleApplicationError(ex);
        	} catch (Throwable ex) {
        	    handleSystemError(ex);
        	}
            }
	});

    }
    
    /**
     * Load data from data source
     */
    protected void loadData() throws ApplicationException {
	super.loadData();
	
	if (isAddMode()) {
	    newData();
	}
    }
    
    protected void newData() throws ApplicationException {
	if (getEntity() == null) {
	    Object newEntity = newEntity();
	    setEntity(newEntity);
	}
	initData();
    }
    
    protected void processLoadData() throws ApplicationException{
	super.doLoadData();
    }
    
    
    public void updateForm() throws ApplicationException {
	super.updateForm();
	resetControlsModify();
	updateEntityProviderViews(); //REFACTORED: 2011-03-13
    }
    
    protected void initControls() {
	bindControls();
	if (editControls == null) {
	    return;
	}
	for (IControl control : editControls) {
	    
            // Control uses a different data source
	    if (!control.isAnotherDataSource()) {
		control.setEntityClass(getEntityClass());
	    }
	    
	    control.init();
	}
    }
    
    /**
     * Bind Controls.
     * We can override the method to binding controls in own form
     * For example:
     * 
     * protected void bindControls() {
     *     bindControl(myControl, "myAttribute");
     * }
     *     
     */
    protected void bindControls() {
	
    }
    
    public IControl[] createEntityControls() {
	IControl[] controls = editControls.toArray(new IControl[0]);
	for (int i = 0; i < controls.length; i++) {
	    // Control uses a different data source
	    if (controls[i].isAnotherDataSource()) {
		continue;
	    }
	    controls[i].setEntity(getEntity());
	    controls[i].setEntityClass(getEntityClass()); // TODO: ???
	}
	return controls;
    }
    
    protected void checkDecorator(IFormDecorator decorator) {
	if (decorator == null) {
	    return;
	}
	if (!(decorator instanceof IEditFormDecorator)) {
	    throw new IllegalArgumentException("Decorator must be IEditFormDecorator");
	}
    }    
 

    protected  IFormController createController() {
	SWTEditFormController controller = new SWTEditFormController();
	controller.setForm(this);
	return controller;
    }
    
    protected IEditFormController getEditFormController() {
	return (IEditFormController) getController();
    }
    
    
    protected boolean forwardAction(String actionId) throws ApplicationException {
	if (super.forwardAction(actionId)) {
	    return true;
	}
	if (OK_ACTION.equals(actionId)) {
	    doOkAction();
	} else if (SAVE_ACTION.equals(actionId)) {
	    doSaveAction();
	} else if (CANCEL_ACTION.equals(actionId)) {
	    doCancelAction();
	    
	} else if (ITEM_ADD_ACTION.equals(actionId)) {
	    doItemAddAction();
	} else if (ITEM_DEL_ACTION.equals(actionId)) {
	    doItemDelAction();
	} else if (ITEM_EDIT_ACTION.equals(actionId)) {
	    doItemEditAction();
	    
	} else {
	    return false;
	}
	return true;
    }
    
    public void doOkAction() throws ApplicationException {
	doSaveAction();
	close();
    }
    
    private boolean save;
    
    private boolean startAddMode;
    
    public void doSaveAction() throws ApplicationException {
	
	// Reset cancel state
	cancelState = false;
	
	setModify(true);
	doSaveData();
	
	setModify(false);
	resetControlsModify();
	
	if (isAddMode() || isCopyMode()) {
	    startAddMode = true;
	    setEditMode();
	}
	
	updateMode();
	save = true;
    }
    
    protected boolean isSave() {
	return save;
    }
    
    protected boolean isStartAddMode() {
	return startAddMode;
    }
    
    
    protected void beforeClose() throws ApplicationException {
	if (isSave()) {
	    setModify(true); 
	}
	if (isStartAddMode()) {
	    setAddMode();
	}
    }

    public void doSaveData() throws ApplicationException {
	
	// If add mode and entity is not init
	if (isAddMode() && getEntity() == null) {
	    Object newEntity = newEntity();
	    setEntity(newEntity);
	    initData();
	}
	
	updateData();
	
	beforeSave();

	if (isAddMode() || isCopyMode()) {
	    doCreateData();
	} else {
	    doStoreData();
	}
	
	afterSave();
	
	//close();
    }
    
    protected void beforeSave() throws ApplicationException {
	
    }
    
    protected void afterSave() throws ApplicationException {
	
    }
    
    public void doCancelAction() throws ApplicationException {
	
	// Set cancel state
	cancelState = true;
	
	checkModify();
	if (!isModify()) {
	    doCancelData(); 
	    return;
	}
	MessageBox mb = new MessageBox(getShell(), SWT.ICON_QUESTION | SWT.YES | SWT.NO | SWT.CANCEL);
	mb.setText(Messages.getString("Form.confirm.cancel.title")); //$NON-NLS-1$
	mb.setMessage(Messages.getString("Form.confirm.cancel.question")); //$NON-NLS-1$
	int result = mb.open();
	if (result == SWT.YES) {
	    doOkAction();
	    //doSaveData(); 
	} else if (result == SWT.NO) {
	    setModify(false);
	    doCancelData();
	}
    }
    
    public void doCloseAction() throws ApplicationException {

	doCancelAction();
    }
    

     

    protected void doItemAddListForm(Class listFormClass) {
	try {
	    IListForm listForm = getChooseListForm(listFormClass, new ItemFormListener());
	    listForm.setMode(PWT.ADD_MODE); // ???
	    listForm.setParentForm(this);
	    Toolkit.openForm(null, listForm);
	} catch (Throwable ex) {
	    logger.error(ex);
	}
    }

    
    public void doItemAddAction()  throws ApplicationException {
	
	//if (isReadOnly()) {
	//    return;
	//}
	int mode = PWT.ADD_MODE;
	
	IEntityProvider itemProvider = getSelectedItemProvider();
	if (itemProvider == null) {
	    return;
	}	
	itemProvider.setMode(mode);
	
	IEditForm form = itemProvider.getEditForm();
	if (form == null) {
	    return;
	}
	
	//
	// Special mode for parent and children edit from
	// You must move this code to parent form
	//
	form.setParentEntityId(getEntityId());
	form.setParentEntity(getEntity());
	
	
	//form.setEntityId(id);
	
	form.setParentForm(this);
	form.addFormListener(new ItemFormListener());
	
        //
	// Special mode.
	//
	// If the edit form doesn't have data source 
	// or the edit form doesn't use entity service
	// then you have to create entity and set entity of the edit form.
	//
	if (!form.hasDataSource()) {
	    Object entity = itemProvider.newEntity(); // Create new instance entity
	    form.setEntity(entity);
        }	
	
	
	form.setMode(mode);
   	Toolkit.openForm(this, form);
	
    }
    
    public void doItemDelAction()  throws ApplicationException {
	if (isReadOnly()) {
	    return;
	}
	
	IEntityProvider itemProvider = getSelectedItemProvider();
	if (itemProvider == null) {
	    return;
	}
        Object entity = itemProvider.getSelectedEntity();
	if (entity == null) {
	    return;
	}
	if (isConfirmDeleteEntity()) {
      	    doRemoveItem(entity);
	}	
    }
    
    public void doItemEditAction()  throws ApplicationException {
	//if (isReadOnly()) {
	//    return;
	//}
	int mode = PWT.EDIT_MODE;
	IEntityProvider itemProvider = getSelectedItemProvider();
	if (itemProvider == null) {
	    return;
	}
	itemProvider.setMode(mode);

	IEditForm form = itemProvider.getEditForm();
	if (form == null) {
	    return;
	}
	
	//
	// Special mode for parent and children edit form
	// You must move this code to parent form
	//
	form.setParentEntityId(getEntityId());
	form.setParentEntity(getEntity());
	//
	
	//form.setEntityId(id);
	
	form.setParentForm(this);
	form.addFormListener(new ItemFormListener());
	
        //
	// Special mode.
	//
	// If the edit form doesn't have data source 
	// or the edit form doesn't use entity service
	// then you have to create entity and set entity of the edit form.
	//
	if (!form.hasDataSource()) {
	    Object entity = itemProvider.getSelectedEntity();
	    if (entity == null) {
		return;
	    }
	    form.setEntity(entity);
        }	
	
	
	form.setMode(mode);
	Toolkit.openForm(this, form);	
    }
    
    protected Object getSelectedItemEntity() {
	return getSelectedEntityProvider();
    }
    
    
    
    protected IEntityProvider getSelectedItemProvider() {
	return getSelectedEntityProvider();
    }
    
    public void doCancelData() throws ApplicationException {
	close();
    }
    
    protected void checkModify() {
	
	if (isModify()) {
	    return;
	}
	
	//setModify(false); 
	
	
	if (isControlsEmpty()) {
	   return;
	}
	for(IControl control : editControls) {
	   if (control.isModify()) {
	       setModify(true);
	       return;
	   }
	}
	
    }

    protected boolean isControlsEmpty() {
	return editControls == null || editControls.size() == 0;
    }
    
    protected void resetControlsModify() {
	if (isControlsEmpty()) {
	    return;
	}
	for (IControl control : editControls) {
	    control.resetModify();
	}
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // BIND CONTROLS
    //
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    protected void bindControl(IControl control, String valueProperty) {
	if (control == null) {
	    logger.warn("Control is null (valueProperty = " + valueProperty + ")");
	    return;
	}
	
	control.setValueProperty(valueProperty);
	editControls.add(control);
    }
    
    protected void bindControl(IControl control, String valueProperty, Class valueClass) {
	if (control == null) {
	    logger.warn("Control is null (valueProperty = " + valueProperty + ", valueClass = " + valueClass + ")");
	    return;
	}
	control.setValueProperty(valueProperty);
	control.setValueClass(valueClass);
	editControls.add(control);
    }
    
    protected void bindControl(IControl control, String valueProperty, String controlProperty) {
	if (control == null) {
	    logger.warn("Control is null (valueProperty = " + valueProperty + ", controlProperty = " + controlProperty + ")");
	    return;
	}
	control.setValueProperty(valueProperty);
	control.setControlProperty(controlProperty);
	editControls.add(control);
    }
    
    //--
    
    protected void bindControl(IControl control, String valueProperty, String valuePropertyDescription, int validationType) {
	bindControl(control, valueProperty);
	if (control == null) {
	    return;
	}
	if ((validationType & REQUIRED) != 0) {
	    control.setRequired(true);
	}	
        control.setValuePropertyDescription(valuePropertyDescription);
	
    }
    
    protected void bindControl(IControl control, String valueProperty, Label label, int validationType) {
	bindControl(control, valueProperty, label == null ? null : label.getText(), validationType);
    }
    
    protected void bindControl(IControl control, String valueProperty, Class valueClass, Label label, int validationType) {
	bindControl(control, valueProperty, valueClass, label == null ? null : label.getText(), validationType);
    }
    
    protected void bindControl(IControl control, String valueProperty, Class valueClass, String valuePropertyDescription, int validationType) {
	bindControl(control, valueProperty, valueClass);
	if (control == null) {
	    return;
	}
	if ((validationType & REQUIRED) != 0) {
	    control.setRequired(true);
	}
	control.setValuePropertyDescription(valuePropertyDescription);
    }
    
    
    
    
    
    
    
    public void closeForm(IForm form) throws ApplicationException {
	
	// If forceUpdate = true the form was updated before.
	if (form == null || isForceUpdate()) {
	    return;
	}
	updateForm(form);
    }
    

    public void updateForm(IForm form) throws ApplicationException {
	if (form == null) {
	    return;
	}
	if (form instanceof IEditForm) {
	    
	    // Edit form for entity
	    updateByEditForm((IEditForm) form);
	    
	    
	} else if (form instanceof IListForm) {
	    
	    // List form for adding entity
	    // We use list form in choose mode
	    // Before using list form you have to set ADD_MODE of the form
	    updateByListForm((IListForm) form);
	}
    }
    
    
    /**
     * Update this form by EditForm
     * @param editForm
     * @throws ApplicationException
     */
    protected void updateByEditForm(IEditForm editForm) throws ApplicationException {
	if (!editForm.isModify()) {
	    // editForm = null;
	    return;
	}

	Object itemEntity = getItemEntityFromEditForm(editForm);
	doUpdateItem(itemEntity, editForm.getMode());

    }

    
    /**
     * Update this form by ListForm
     * @param listForm
     * @throws ApplicationException
     */
    protected void updateByListForm(IListForm listForm) throws ApplicationException {
	
	// ONLY FOR ADD OR COPY MODE 
	if (! (listForm.isAddMode() || listForm.isCopyMode())) {
	    return;
	}
	
	Object itemEntity = getItemEntityFromListForm(listForm);
	doUpdateItem(itemEntity, listForm.getMode());
    }
    
    protected Object getItemEntityFromEditForm(IEditForm editForm) {
	return editForm.getEntity();
    }


    /**
     * Update item.
     * Create or store the item entity and load data. 
     * @param itemEntity
     * @param mode
     * @throws ApplicationException
     */
    protected void doUpdateItem(Object itemEntity, int mode) throws ApplicationException {
	
	if (itemEntity == null) {
	    return;
	}
	
	setModify(true);

	// Get previous mode
	int prevMode = getMode();
	
	try {
	    boolean isChangeMode = (mode == PWT.ADD_MODE || mode == PWT.COPY_MODE || mode == PWT.EDIT_MODE);
	    if (isChangeMode) {
		setMode(mode);
		if (mode == PWT.ADD_MODE || mode == PWT.COPY_MODE) {
		    doCreateItem(itemEntity);
		} else {
		    doStoreItem(itemEntity);
		}
	    }
	    doLoadItem(itemEntity);
	} finally {
	    // Restore mode
	    setMode(prevMode);
	}
    }
    
    protected Object getItemEntityFromListForm(IListForm listForm) {
	return listForm.getEntity();
    }

    
    
    
    
    // MODIFY ITEM EVENT METHODS
    protected void beforeModifyItem(Object item) throws ApplicationException {}

    protected void afterModifyItem(Object item) throws ApplicationException {}
    
    
    
    
    public void doCreateItem(Object item) throws ApplicationException {
	beforeModifyItem(item); // BEFORE
	beforeCreateItem(item); // BEFORE
	
	getSelectedItemProvider().createEntity(item);
	
	afterCreateItem(item); // AFTER
	afterModifyItem(item); // AFTER
    }
    
    // CREATE ITEM EVENT METHODS
    protected void beforeCreateItem(Object item) throws ApplicationException {}

    protected void afterCreateItem(Object item) throws ApplicationException {}
    
    
    
    
    public void doStoreItem(Object item) throws ApplicationException {
	beforeModifyItem(item); // BEFORE
	beforeStoreItem(item); // BEFORE
	
	getSelectedItemProvider().storeEntity(item);
	
	afterStoreItem(item); // AFTER
	afterModifyItem(item); // AFTER
    }    
    
    // STORE ITEM EVENT METHODS
    protected void beforeStoreItem(Object item) throws ApplicationException {}

    protected void afterStoreItem(Object item) throws ApplicationException {}
    
    
    
    public void doRemoveItem(Object item) throws ApplicationException {
	beforeModifyItem(item); // BEFORE
	beforeRemoveItem(item); // BEFORE
	
        getSelectedItemProvider().removeEntity(item);
        getSelectedItemProvider().getView().removeEntity();

	afterRemoveItem(item); // AFTER
	afterModifyItem(item); // AFTER
	
	setModify(true);
    }
    
    // REMOVE ITEM EVENT METHODS
    protected void beforeRemoveItem(Object item) throws ApplicationException {}

    protected void afterRemoveItem(Object item) throws ApplicationException {}
    
    
    
    
    public void doLoadItem(Object item) throws ApplicationException {
	beforeLoadItem(item);
	
	if (isAddMode()) {
	    getSelectedItemProvider().getView().addEntity(item);
	} else if (isEditMode()) {
	    getSelectedItemProvider().getView().setEntity(item);
	}
	
	afterLoadItem(item);
    }
    
    // LOAD ITEM EVENT METHODS
    protected void beforeLoadItem(Object item) throws ApplicationException {}

    protected void afterLoadItem(Object item) throws ApplicationException {}
    
    
    protected void validateControls() throws ApplicationException {
	super.validateControls();
	StringBuffer buf = new StringBuffer();
	validateControls(buf);
	checkError(buf);
    }
    
    protected void validateControls(StringBuffer buf) throws ApplicationException {
	if (editControls == null || editControls.size() == 0) {
	    return;
	}
	for (IControl control : editControls) {
	    if (control.isRequired()) {
		validateRequiredField(buf, control.getValue(), control.getValuePropertyDescription());
	    }
	}
    }
    
    protected void initNoEditableField(AbstractTextControl field) {
	if (field == null) {
	    return;
	}
	field.setEditable(false);
    	field.setBackground(getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
    }
    
    protected void initDisableField(AbstractControl field) {
	if (field == null) {
	    return;
	}
	field.setEnabled(false);
    	field.setBackground(getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
    }
    protected Color getSystemColor(int color) {
	return SWTResourceManager.getColor(color);
    }
    
    protected void beforeUpdateData() throws ApplicationException {
	super.beforeUpdateData();
	
	if (isAutoSendFocusOut()) {
	    sendTextControlsFocusOut();
	}
    }

    protected void sendTextControlsFocusOut() throws ApplicationException {
	Control[] controls = getChildren();
	for (Control c :controls) {
	    if (c instanceof ISWTTextControl) {
		ISWTTextControl textControl = (ISWTTextControl) c;
		Event event = new Event();
		textControl.notifyTextListeners(SWT.FocusOut, event);
	    }
	}
    }
    
    protected void setRequiredLabel(Label label) {
	if (label == null) {
	    return;
	}
	String text = label.getText().trim();
	if (text.endsWith(IControl.REQUIRED_MARKER_STRING)) {
	    return;
	}
	label.setText(text + IControl.REQUIRED_MARKER_STRING);
    }

    
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Special listener for the Item forms
    // - Use EditForm to modify items
    // - Use ListForm to add new items 
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public class ItemFormListener implements FormListener {
	
	public void openForm(FormEvent event) throws ApplicationException {
	    
	}
	    
	public void closeForm(FormEvent event) throws ApplicationException {
//	    handleCloseForm(event.getForm()); // 2010-04-17
	    if (!isForceUpdate()) {
		handleUpdateForm(event.getForm());
	    }
	}
	    
	public  void disposeForm(FormEvent event) throws ApplicationException {
	    
	}
	    
	
	public void updateForm(FormEvent event) throws ApplicationException {
	    if (isForceUpdate()) {
		handleUpdateForm(event.getForm());
	    }
	}
    }
    
    

    
}
    
