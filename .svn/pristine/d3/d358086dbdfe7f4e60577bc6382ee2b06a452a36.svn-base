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

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IElementComparer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Tree;
import org.plazmaforge.framework.action.IProcess;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.Toolkit;
import org.plazmaforge.framework.client.forms.FormEnvironment;
import org.plazmaforge.framework.client.forms.IEditForm;
import org.plazmaforge.framework.client.forms.IEntityProvider;
import org.plazmaforge.framework.client.forms.IForm;
import org.plazmaforge.framework.client.forms.IFormController;
import org.plazmaforge.framework.client.forms.IFormDecorator;
import org.plazmaforge.framework.client.forms.IListForm;
import org.plazmaforge.framework.client.forms.IListFormController;
import org.plazmaforge.framework.client.forms.IListFormDecorator;
import org.plazmaforge.framework.client.models.FormEvent;
import org.plazmaforge.framework.client.models.FormListener;
import org.plazmaforge.framework.client.models.IObjectStore;
import org.plazmaforge.framework.client.swt.app.SWTProcessRunner;
import org.plazmaforge.framework.client.swt.controls.ITableProvider;
import org.plazmaforge.framework.client.swt.controls.IValueProvider;
import org.plazmaforge.framework.client.swt.dialogs.FormatSelectionDialog;
import org.plazmaforge.framework.client.swt.dialogs.dataexport.AbstractExportDialog;
import org.plazmaforge.framework.client.swt.dialogs.dataexport.ExportDialogFactory;
import org.plazmaforge.framework.client.swt.views.ExtPeriodDialog;
import org.plazmaforge.framework.client.swt.views.ISWTTableView;
import org.plazmaforge.framework.client.swt.views.ITableCellRenderer;
import org.plazmaforge.framework.client.swt.views.SWTTableViewHolder;
import org.plazmaforge.framework.client.swt.views.TableViewFactory;
import org.plazmaforge.framework.client.views.ITableView;
import org.plazmaforge.framework.config.object.IEntityConfigurable;
import org.plazmaforge.framework.core.FileFormat;
import org.plazmaforge.framework.core.FileFormatFactory;
import org.plazmaforge.framework.core.criteria.CriteriaImpl;
import org.plazmaforge.framework.core.criteria.ICriteria;
import org.plazmaforge.framework.core.data.Pager;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.datawarehouse.convert.dataexport.ExportFactory;
import org.plazmaforge.framework.datawarehouse.convert.dataexport.IExporter;
import org.plazmaforge.framework.ext.association.Association;
import org.plazmaforge.framework.ext.model.IEntityObject;
import org.plazmaforge.framework.ext.service.EntityService;
import org.plazmaforge.framework.core.data.DataList;
import org.plazmaforge.framework.core.datastorage.DSDataSet;
import org.plazmaforge.framework.util.ClassUtilsExt;
import org.plazmaforge.framework.util.CloneUtils;

/**
 * @author Oleh Hapon
 * $Id: AbstractListForm.java,v 1.56 2010/12/05 07:52:26 ohapon Exp $
 */

public abstract class AbstractListForm extends AbstractForm implements IListForm/* <Table> */, SWTTableViewHolder {

    
    
    

    public static final String GROUPS_MESSAGE = Messages.getString("Form.groups"); //$NON-NLS-1$

    public static final String CATEGORIES_MESSAGE = Messages.getString("Form.categories"); //$NON-NLS-1$
    
    
    public static final String STATUS_PAGE_MESSAGE = Messages.getString("Form.status.page"); //$NON-NLS-1$
    
    public static final String STATUS_OF_MESSAGE = Messages.getString("Form.status.of"); //$NON-NLS-1$
    
    public static final String STATUS_ROWS_MESSAGE = Messages.getString("Form.status.rows"); //$NON-NLS-1$
    
    public static final String STATUS_ROWS_FROM_MESSAGE = Messages.getString("Form.status.rows.from"); //$NON-NLS-1$
    
    public static final String STATUS_ROWS_TO_MESSAGE = Messages.getString("Form.status.rows.to"); //$NON-NLS-1$
    
    public static final Image FOLDER_IMAGE = getResourceImage(AbstractListForm.class, "/org/plazmaforge/framework/client/images/eclipse/folder/fldr_obj.gif");
    
    

    private NumberFormat itemIndexFormat;
    
    
    

    /**
     * View of the form
     */
    private ISWTTableView view;

    
    /**
     * The Edit Form
     */
    private IEditForm editForm;
    

    /**
     * True if the form has 'CHOOSE' state
     */
    private boolean chooseState;

    
    private int preMode;

    /**
     * True if the form supports period filter
     */
    private boolean supportPeriodFilter = false;

    /**
     * Start date of period filter
     */
    private Date startDate;

    /**
     * End date of period filter
     */
    private Date endDate;
    
    
    private boolean resetPeriodFilter;
    

    /**
     * Map of variables 
     */
    private Map<String, Object> aggregateVariableMap;


    /**
     * Data criteria
     */
    private ICriteria criteria;
    
    /**
     * Criteria mode (Client Mode, Server Mode)
     * Client Mode: Use filter and sorter at Client
     * Server Mode: Use filter and sorter at Server  
     */
    private int criteriaMode = ITableView.CLIENT_CRITERIA_MODE;
    
    
    /**
     * True if the form supports paging mode
     */
    private boolean supportPaging;
    
    /**
     * True if the form uses mode
     */
    private boolean pagingMode;
    

    /**
     * Pager
     */
    private Pager pager;

    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // 
    // TREE BLOCK
    //
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    private Class treeEntityClass;
    
    private Class treeServiceClass;
    
    private Class treeEditFormClass;

    
    private TreeViewer treeViewer;
    
    private boolean isVisibleTreeRoot = true;    

    
    /** Map of element id and children **/
    private Map<Object, List> dataMap;
    
    /** Set true if the tree has more levels **/
    private boolean isTreeMoreLevel;
    
    
    
    private String treeItemIdProperty = "id";

    private String treeItemNameProperty = "name";

    private String treeItemRefIdProperty;

    private String treeItemParentIdProperty;
    
    private boolean supportUpdateTree = true; // Flag for update tree. If true then update tree in method updateForm()
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static final String[] EXPORT_TYPES = {FileFormat.CSV,  FileFormat.XML, FileFormat.XLS, FileFormat.RTF, FileFormat.HTML};

  
    
    
    
    
    
    public AbstractListForm(Composite parent, int style) {
	super(parent, style);
	
	setAutoConfigProvidersForm(true); // FOR ENTITY PROVIDERS (FORM)
	setAutoConfigProvidersService(true); // FOR ENTITY PROVIDERS (SERVICE)
	setFlexiblePagingMode();
    }

    protected void checkDecorator(IFormDecorator decorator) {
	if (decorator == null) {
	    return;
	}
	if (!(decorator instanceof IListFormDecorator)) {
	    throw new IllegalArgumentException("Decorator must be IListFormDecorator");
	}
    }

    protected IFormController createController() {
	SWTListFormController controller = new SWTListFormController();
	controller.setForm(this);
	return controller;
    }

    protected IListFormController getListFormController() {
	return (IListFormController) getController();
    }

    public void doRemoveEntity() throws ApplicationException {

    }

    public void doFindEntity() throws ApplicationException {

    }

    public void doLoadRow() throws ApplicationException {

    }

    /**
         * Remove the current row of table.
         */
    public void doRemoveRow() throws ApplicationException {
	if (isReadOnly()) {
	    return;
	}

	if (!isSupportDelMode()) {
	    return;
	}
	
	if (!isSelected()) {
	    return;
	}

	Serializable id = getSelectedEntityId();
	removeEntityById(id);


	//
	// Set modify flag of list form
	setModify(true);

	//removeEntityFromView();
	doRefreshAfterRemoveData();

    }
    
    protected void doRefreshAfterRemoveData() throws ApplicationException {
	if (isClientCriteriaMode()) {
	    removeEntityFromView();
	} else {
	    doLiteRefreshAction();
	}
	
	// FIRE UPDATE DATA
	fireUpdateData();
    }


    protected void removeEntity() throws ApplicationException {
	Serializable id = getSelectedEntityId();
	if (id == null) {
	    return;
	}
	removeEntityById(id);
    }

    protected boolean forwardAction(String actionId) throws ApplicationException {
	
	if (actionId == null) {
	    return false;
	}

	if (super.forwardAction(actionId)) {
	    return true;
	}
	
	if (ENTER_ACTION.equals(actionId)) {
	    doEnterAction();
	} else if (REFRESH_ACTION.equals(actionId)) {
	    doRefreshAction();
	} else if (CHOOSE_ACTION.equals(actionId)) {
	    doChooseAction();
	} else if (ADD_ACTION.equals(actionId)) {
	    doAddAction();
	} else if (COPY_ACTION.equals(actionId)) {
	    doCopyAction();
	} else if (DEL_ACTION.equals(actionId)) {
	    doDelAction();
	} else if (EDIT_ACTION.equals(actionId)) {
	    doEditAction();
	} else if (ADD_CYCLE_ACTION.equals(actionId)) {
	    doAddCycleAction();
	} else if (PRINT_ACTION.equals(actionId)) {
	    doPrintAction();
	} else if (SORT_ACTION.equals(actionId)) {
	    doSortAction();
	} else if (FIND_ACTION.equals(actionId)) {
	    doFindAction();
	} else if (FILTER_ACTION.equals(actionId)) {
	    doFilterAction();
	} else if (INTERNAL_FILTER_ACTION.equals(actionId)) {
	    doInternalFilterAction();
	} else if (FAST_FILTER_ACTION.equals(actionId)) {
	    doFastFilterAction();
	} else if (ADVANCED_FILTER_ACTION.equals(actionId)) {
	    doAdvancedFilterAction();
	} else if (CLEAR_FILTER_ACTION.equals(actionId)) {
	    doClearFilterAction();
	} else if (PERIOD_FILTER_ACTION.equals(actionId)) {
	    doPeriodFilterAction();

	} else if (INFO_ACTION.equals(actionId)) {
	    doInfoAction();
	} else if (RESET_ACTION.equals(actionId)) {
	    doResetAction();
	} else if (CLEAR_ACTION.equals(actionId)) {
	    doClearAction();

	} else if (ADD_BY_COPY_ACTION.equals(actionId)) {
	    doAddByCopyAction();
	} else if (ADD_BY_OBJECT_ACTION.equals(actionId)) {
	    doAddByObjectAction();
	} else if (ADD_OTHER_OBJECTS_ACTION.equals(actionId)) {
	    doAddOtherObjectsAction();

	} else if (FIRST_PAGE_ACTION.equals(actionId)) {
	    doFirstPageAction();
	} else if (PREV_PAGE_ACTION.equals(actionId)) {
	    doPrevPageAction();
	} else if (NEXT_PAGE_ACTION.equals(actionId)) {
	    doNextPageAction();
	} else if (LAST_PAGE_ACTION.equals(actionId)) {
	    doLastPageAction();	    
	    
	} else if (EXPORT_ACTION.equals(actionId)) {
	    doExportAction();
	} else if (TREE_ENTER_ACTION.equals(actionId)) {
	    doTreeEnterAction();
	    
	} else if (TREE_ADD_ACTION.equals(actionId)) {
	    doTreeAddAction();
	} else if (TREE_DEL_ACTION.equals(actionId)) {
	    doTreeDelAction();
	} else if (TREE_EDIT_ACTION.equals(actionId)) {
	    doTreeEditAction();
	    
	    
	    
	    
	} else {
	    return false;
	}
	
	
	
	return true;
    }

    public void doSetupAction() throws ApplicationException {
	getView().openColumnSettingDialog(getShell());
    }

    public void doEnterAction() throws ApplicationException {
	if (isChooseState()) {
	    doChooseAction();
	} else {
	    doEditAction();
	}
    }

    public void doRefreshAction() throws ApplicationException {
	doLoadData();
    }

    public void doChooseAction() throws ApplicationException {
	if (!isChooseState()) {
	    return;
	}
	doChooseData();
	close();
    }

    public void doChooseData() throws ApplicationException {
	setEntityId(getSelectedEntityId());
	setEntity(getSelectedEntity());
	fireUpdateForm();
    }

    
 

    
    private EntityReseter entityReseter;
    
    protected EntityReseter getEntityReseter() {
	if (entityReseter == null) {
	    entityReseter = new EntityReseter(); 
	}
	return entityReseter;
    }
    
    /**
     * The special reseter for reset attributes of clone entity.
     * For example: reset ID (null) 
     */
    private class EntityReseter implements CloneUtils.CopyReseter {
	
	public void resetObject(Object obj) {
	    if (obj == null) {
		return;
	    }
	    if (obj instanceof IEntityObject) {
		IEntityObject entity = (IEntityObject) obj;
		entity.setCreated();
		entity.setId(null);
	    }
	    
	}
    }
    
    
    
    public void doAddAction() throws ApplicationException {

	if (isReadOnly()) {
	    return;
	}

	if (!isSupportAddMode()) {
	    return;
	}

	preMode = PWT.ADD_MODE;

	setEntityId(null);

	//////////////////////////////////////////
	
	openEditForm(PWT.ADD_MODE, null, null);
	
	//////////////////////////////////////////
	
    }
    
    public void doCopyAction() throws ApplicationException {

	if (isReadOnly()) {
	    return;
	}

	if (!isSupportCopyMode()) {
	    return;
	}
	
	if (!isSelected()) {
	    openNotSelecetdRowsDialog();
	    return;
	}

	preMode = PWT.COPY_MODE;

	Serializable selectedId = getSelectedEntityId(); // Get entity id
	if (selectedId == null) {
	    return;
	}

	Object selectedEntity =  loadEntityDetailsById(selectedId);
	
	if (selectedEntity == null) {
	    return;
	}
	
	Object newEntity = copyEntity(selectedEntity);
	if (newEntity == null) {
	    return;
	}
	
	setEntityId(null);

	//////////////////////////////////////////
	
	openEditForm(PWT.EDIT_MODE, null, newEntity);
	
	//////////////////////////////////////////

    }    
    
    /**
     * Copy entity
     * @param originalEntity
     * @return
     * @throws ApplicationException
     */
    protected Object copyEntity(Object originalEntity) throws ApplicationException {
	if (originalEntity == null) {
	    return null;
	}
	Object copyEntity = CloneUtils.copyObject(originalEntity, getEntityReseter(), true);
	if (copyEntity == null) {
	    return null;
	}
	initCopyEntity(copyEntity);
	
	return copyEntity;
    }
    
    protected void initCopyEntity(Object entity) throws ApplicationException {
	
    }
    

    public void doEditAction() throws ApplicationException {
	if (isReadOnly()) {
	    return;
	}

	if (!isSupportEditMode()) {
	    return;
	}

	if (!isSelected()) {
	    openNotSelecetdRowsDialog();
	    return;
	}
	
	preMode = PWT.EDIT_MODE;

	Serializable id = getSelectedEntityId(); // Get entity id
	if (id == null) {
	    return;
	}

	// /
	if (!isSupportSelectedEntityEditMode()) {
	    return;
	}
	// /

	setEntityId(id);
	Object entity = getSelectedEntity();
	
	//////////////////////////////////////////
	
	openEditForm(PWT.EDIT_MODE, id, entity);
	
	//////////////////////////////////////////
	
    }

    
    public void openEditForm(int mode, Serializable id, Object entity) throws ApplicationException {
	
	IEditForm form = getEditForm(mode);
	if (form == null) {
	    return;
	}
	form.setMode(mode);
	initEditForm(form);

	//
	// Special mode for parent and children edit from
	// You must move this code to parent form
	//
	initEditFormParent(form);

	form.setEntityId(id);
	
	form.addFormListener(new SimpleFormListener());
	
	form.setParentForm(this);

	// Only for EDIT_MODE
	form.setForwardId(mode == PWT.EDIT_MODE ? id : null);
	form.setForwardEntity(mode == PWT.EDIT_MODE ? entity : null);

	form.setCategoryEntity(getSelectedCategoryEntity());
	
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

	//form.setMode(mode);
	Toolkit.openForm(this, form);
    }
    
    
    protected boolean isSupportSelectedEntityEditMode() {
	return isSupportEntityEditMode(getSelectedEntity());
    }

    protected boolean isSupportEntityEditMode(Object entity) {
	return true;
    }

    protected void initEditForm(IEditForm form) throws ApplicationException {
    }

    protected void initEditFormParent(IEditForm form)
	    throws ApplicationException {
	if (form == null) {
	    return;
	}
	// Send parent entity to the edit form
	form.setParentEntityId(getParentEntityId());
	form.setParentEntity(getParentEntity());

	// //
	form.setCurrentEntityProvider(getCurrentEntityProvider());
    }

    public void doAddCycleAction() throws ApplicationException {
	if (isReadOnly()) {
	    return;
	}

	if (!isSupportAddMode()) {
	    return;
	}

	getListFormController().doAddCycleAction();
    }

    public void doDelAction() throws ApplicationException {
	if (isReadOnly()) {
	    return;
	}

	if (!isSupportDelMode()) {
	    return;
	}

	if (!isSelected()) {
	    openNotSelecetdRowsDialog();
	    return;
	}
	
	// FIX 27-10-2010
	//int index = getSelectionIndex();
	//if (index < 0) {
	//    return;
	//}
	
	if (!isSupportSelectedEntityDelMode()) {
	    return;
	}
	

	if (!isConfirmDeleteEntity()) {
	    return;
	}
	
	doRemoveRow();
    }

  
    
    protected boolean isSupportSelectedEntityDelMode() {
	return isSupportEntityDelMode(getSelectedEntity());
    }

    protected boolean isSupportEntityDelMode(Object entity) {
	return true;
    }


    public void doSortAction() throws ApplicationException {
	getView().openSortDialog(getShell());
    }

    public void doFindAction() throws ApplicationException {
	getView().openFindDialog(getShell(), getDateFormat());
    }

    public void doFastFilterAction() throws ApplicationException {
	view.doFastFilter(menuX, menuY);
    }

    public void doFilterAction() throws ApplicationException {
	getView().openFilterDialog(getShell(), getDateFormat());
    }

    public void doAdvancedFilterAction() throws ApplicationException {
	getView().openAdvancedFilterDialog(getShell(), getDateFormat());
    }

    public void doClearFilterAction() throws ApplicationException {
	view.getTableFilter().setItems(null);
	
	// RESET FILTER
	if (getCriteria() != null && getCriteria().getFilterSet() != null) {
	     getCriteria().getFilterSet().reset();
	}
	
	view.refresh();
	doRefreshAction();
    }

    public void doPeriodFilterAction() throws ApplicationException {
	if (!isSupportPeriodFilter()) {
	    return;
	}
	ExtPeriodDialog dialog = new ExtPeriodDialog(getShell());
	dialog.setAllButonMode(true);
	dialog.setResetButonMode(true);

	if (dialog.open() == Window.OK) {
	    setResetPeriodFilter(dialog.isResetFilter());
	    doPeriodFilter(dialog.getStartDate(), dialog.getEndDate());
	}
    }

    public void doPeriodFilter(Date startDate, Date endDate) throws ApplicationException {
	if (!isSupportPeriodFilter()) {
	    return;
	}
	setStartDate(startDate);
	setEndDate(endDate);

	doRefreshAction();
    }

    private boolean isStartInternalFilter;
    
    private boolean processingInternalFilter;

    public void doInternalFilterAction() throws ApplicationException {
	
	if (processingInternalFilter) {
	    processingInternalFilter = false;
	    return;
	}

	Node node = getSelectedTreeNode();
	if (node == null) {
	    return;
	}
	
	List ids = getTreeNodeIdList(node);
	
//	if (ids == null) {
//	    return;
//	}
	
	if (ids == null && !isStartInternalFilter) {
	    isStartInternalFilter = true;
	    return;
	}
	isStartInternalFilter = true;
	
	view.doInternalFilter(getTreeItemRefIdProperty(), ids);
    }

    
    
    protected Serializable getSelectedTreeEntityId() {
	Object entity = getSelectedTreeEntity();
	if (entity == null) {
	    return null;
	}
	return this.getTreeItemId(entity);
    }
    
    
    public void doInfoAction() throws ApplicationException {

    }

    public void doResetAction() throws ApplicationException {

    }

    public void doClearAction() throws ApplicationException {

    }

    /**
     * Add new object by copy selected object
     * @throws ApplicationException
     */
    public void doAddByCopyAction() throws ApplicationException {

    }

    /**
     * Add new object by other object
     * @throws ApplicationException
     */
    public void doAddByObjectAction() throws ApplicationException {

    }

    /**
     * Add new objects to other storage by selected object 
     * @throws ApplicationException
     */
    public void doAddOtherObjectsAction() throws ApplicationException {

    }

    protected boolean isSupportAddByObjectAction() {
	return false;
    }
    
    protected boolean isSupportAddOtherObjectsAction() {
	return false;
    }
    
    
    
    // Paging
    protected boolean isValidPagingMode() {
	return isPagingMode() && getPager() != null && !getPager().isDisablePager();
    }
    
    public void doFirstPageAction() throws ApplicationException {
	if (!isValidPagingMode() || !getPager().isEnableFirstPage()) {
	    return;
	}
	doNewPage(getPager().firstPage());
    }

    public void doPrevPageAction() throws ApplicationException {
	if (!isValidPagingMode() || !getPager().isEnablePrevPage()) {
	    return;
	}
	doNewPage(getPager().prevPage());
    }
    
    public void doNextPageAction() throws ApplicationException {
	if (!isValidPagingMode() || !getPager().isEnableNextPage()) {
	    return;
	}
	doNewPage(getPager().nextPage());
    }
    
    public void doLastPageAction() throws ApplicationException {
	if (!isValidPagingMode() || !getPager().isEnableLastPage()) {
	    return;
	}
	doNewPage(getPager().lastPage());
    }

    protected void doNewPage(boolean isWork) throws ApplicationException {
	if (!isWork) {
	    return;
	}
	getPager().setNavigationState(true); // !!!
	doLiteRefreshAction();
    }
    
    
    protected String openSelectionFormatDialog(String[] types) {
	
	FileFormat[] formats = FileFormatFactory.getFormats(types);
	if (formats == null | formats.length == 0) {
	    return null;
	}
	
	FormatSelectionDialog dialog = new FormatSelectionDialog(getShell());
	dialog.setElements(formats);
	dialog.open();
	
	
	Object result[] = dialog.getResult();
        if(result == null || result.length == 0) {
            return null;
        }
        
        String format = ((FileFormat) result[0]).getId();
        if (format == null) {
            return null;
        }
        return format;
    }

    public void doExportAction() throws ApplicationException {
	doExportAction(openSelectionFormatDialog(EXPORT_TYPES));
    }
    
    public void doExportAction(String type) throws ApplicationException {
	final IExporter exporter = ExportFactory.getExporter(type);
	if (exporter == null) {
	    return;
	}

	final AbstractExportDialog dialog = (AbstractExportDialog) ExportDialogFactory.getExportDialog(type, getShell());
	if (dialog.open() != Window.OK) {
	    return;
	}

	
	dialog.initExporter(exporter);
	
	BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
	    public void run() {
		try {
			final List exportDataList = loadExportDataList();
			final IObjectStore store = new IObjectStore() {
			    public int size() {
				return exportDataList.size();
			    }
				
			    public Object getObject(int index) {
				return exportDataList.get(index);
			    }
			};
			DSDataSet dataSet = getView().createDataSet(store);
			if (dataSet == null) {
			    return;
			}
			exporter.setDataSet(dataSet);
		} catch (ApplicationException ex ) {
		    MessageDialog.openError(getShell(), "Fetch export data error", ex.getMessage());
		}
	    }
	});

	IProcess process = new IProcess() {
	    public void run() throws ApplicationException {
		exporter.execute();
	    }
	};
	try {
	    SWTProcessRunner runner = new SWTProcessRunner();
	    runner.setResultDialog(true);
	    runner.setResultMessage("Export is successful");
	    runner.setShell(getShell());
	    runner.run(process);
	} catch (final Exception ex) {
	    getShell().getDisplay().asyncExec(new Runnable() {
		public void run() {
		    MessageDialog.openError(getShell(), "Export Error", ex.getMessage());
		}
	    });
	}
    }

    /**
         * Run before open form
         */
    public void openForm(IForm form) throws ApplicationException {

    }

    /**
         * Run after close form
         */
    public void closeForm(IForm form) throws ApplicationException {
	// If forceUpdate = true the form was updated before.
	if (form == null || isForceUpdate()) {
	    return;
	}
	if (form == editForm) {
	    updateByEditForm();
	}
    }

   
    protected void updateByEditForm() throws ApplicationException {

	if (editForm == null) {
	    return;
	}
	
	if (!editForm.isModify()) {
	    if (!isForceUpdate()) editForm = null;
	    return;
	}
	
	// Set modify flag of list form
	setModify(true);

	if (editForm.isAddMode()) {
	    // Change entity id if add mode
	    if (editForm.hasDataSource()) {
		// Get entity id from edit form
		// Set entity id of this form
		setEntityId(editForm.getEntityId());
	    } else {
		// Create entity in data source because edit form
		// doesn't have data source
		// Set entity id of this form
		setEntityId(createEntity(editForm.getEntity()));
	    }

	    // Set add mode of this form.
	    // doLoadEntity method will reset this mode.
	    setMode(PWT.ADD_MODE);

	    // Reload the entity from data source
	    // because we created new entity in data source
	    // and data source can change entity.
	    // doLoadEntity();
	    doRefreshAfterModifyData();
	} else if (editForm.isEditMode()) {

	    // Set edit mode of this form.
	    // doLoadEntity method will reset this mode.
	    setMode(PWT.EDIT_MODE);

	    // Reload the entity from data source
	    // because edit form stored (changed) the entity to data source.
	    // doLoadEntity();
	    doRefreshAfterModifyData();
	}

	if (!isForceUpdate()) editForm = null;
    }
    
    protected void doRefreshAfterModifyData() throws ApplicationException {
	
	if (isClientCriteriaMode()) {
	    doLoadEntity();
	} else {
	    doLiteRefreshAction();
	}
	
	// FIRE UPDATE DATA
	fireUpdateData();

    }
    
    
    
    /**
     * Update <code>Table</code>
     */
    protected void updateTable(List dataList) {
	getView().updateTable(dataList);
    }

    protected void updateTable() {
	getView().updateTable();
    }

    protected void updateTable(int index) {
	getView().updateTable(index);
    }

    public void setPosition(int index) {
	getView().setPosition(index);
    }

    public void setPositionByEntityId(Serializable id) {

    }

    public Serializable getEditFormEntityId() {
	return getSelectedEntityId();
    }

    public void setPositionByEntity(Object entity) {
	getView().setPositionByEntity(entity);
    }

    
    
    
    ////////////////////////////////////////////////////////////
    //
    // SELECTOR
    //
    ////////////////////////////////////////////////////////////
    
    public Serializable getSelectedEntityId() {
	if (getEntitySelector() != null) {
	    return getEntitySelector().getSelectedEntityId();
	}
	return getView().getSelectedEntityId();
    }

    public boolean isSelected() {
	if (getEntitySelector() != null) {
	    return getEntitySelector().isSelected();
	}
	return getView().getSelectedRow() != null;
    }


    public Object getSelectedEntity() {
	if (getEntitySelector() != null) {
	    return getEntitySelector().getSelectedEntity();
	}
	return getView().getSelectedEntity();
    }

    /*
    public Object getSelectedRow() {
	return getView().getSelectedRow();
    }
    
    public int getSelectionIndex() {
	return getView().getSelectionIndex();
    }
    */
    
    ////////////////////////////////////////////////////////////
    
    
    
    

    public List getDataList() {
	return getModel().getDataList();
    }

    public void setDataList(List dataList) {
	updateTable(dataList);
    }

    public void init() throws ApplicationException {
	super.init();
	initPaging();
	
	// Load data from source
	doLoadData();

    }

    protected void initPaging() {
	// Now clinetCriteria mode don't support paging
	if (!isPagingMode() || isClientCriteriaMode()) {
	    return;
	}
	
	// Initialize pager
	pager = new Pager();
	pager.setRowLimit(100);
	
	// Initialize criteria
	criteria = new CriteriaImpl();
	prepareCriteria(criteria);
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
    
    protected void processLoadData() throws ApplicationException{
	super.doLoadData();
    }

    protected void initControls() throws ApplicationException {
	initTable();
	initTree();
    }

    public void initTable() throws ApplicationException {

	// Bind table columns
	bindTable();

	Object table = getTable();
	if (table == null) {
	    return;
	}

	// Initialize Table View
	getView().setTable(table);

	getView().addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		handleTableWidgetSelected(e);
	    }
	});

	getView().addKeyListener(new KeyAdapter() {
	    public void keyReleased(KeyEvent e) {
		handleTableKeyPressed(e);
	    }
	});

	getView().addMouseListener(new MouseAdapter() {
	    public void mouseDoubleClick(MouseEvent e) {
		handleTableMouseDoubleClick(e);
	    }

	    public void mouseDown(MouseEvent e) {
		handleTableMouseDown(e);
	    }
	});

	getView().initCellRenderers(getEntityClass());
    }

    protected void handleTableWidgetSelected(SelectionEvent e) {
	updateTableState();
    }

    protected void handleTableKeyPressed(KeyEvent e) {

	// CTRL
	if (e.stateMask == SWT.CTRL) {
	    if (SWT.INSERT == e.keyCode) {
		doAction(ADD_BY_COPY_ACTION); // CTRL + INSERT
	    } else if (102 == e.keyCode) {
		doAction(FIND_ACTION); // CTRL + F
	    } else if (105 == e.keyCode) {
		doAction(INFO_ACTION); // CTRL + I
	    } else if (108 == e.keyCode) {
		doAction(CLEAR_ACTION); // CTRL + L
	    } else if (112 == e.keyCode) {
		doAction(PRINT_ACTION); // CTRL + P
	    } else if (114 == e.keyCode) {
		doAction(RESET_ACTION); // CTRL + R
	    }
	    return;
	}

	// ALT
	if (e.stateMask == SWT.ALT) {
	    if (SWT.INSERT == e.keyCode) {
		doAction(ADD_BY_OBJECT_ACTION); // ALT + INSERT
	    }
	    return;
	}

	// SHIFT
	if (e.stateMask == SWT.SHIFT) {
	    if (SWT.INSERT == e.keyCode) {
		doAction(ADD_OTHER_OBJECTS_ACTION); // SHIFT + INSERT
	    }
	    return;
	}

	if (SWT.F5 == e.keyCode) {
	    doAction(REFRESH_ACTION);
	} else if (SWT.INSERT == e.keyCode) {
	    doAction(ADD_ACTION);
	} else if (SWT.CR == e.keyCode) {
	    doAction(ENTER_ACTION);
	}
	if (SWT.DEL == e.keyCode) {
	    doAction(DEL_ACTION);
	}
    }

    protected void handleTableMouseDoubleClick(MouseEvent e) {
	doAction(ENTER_ACTION);
    }

    protected void handleTableMouseDown(MouseEvent e) {
	mouseX = e.x;
	mouseY = e.y;

	menuX = mouseX;
	menuY = mouseY;
    }

    
    /////////////////////////////////////////////////////////////////
    
    protected void handleTreeWidgetSelected(SelectionEvent e) {
	doAction(INTERNAL_FILTER_ACTION);
    }
    
    protected void handleTreeKeyPressed(KeyEvent e) {
	// CTRL
	if (e.stateMask == SWT.CTRL) {
	    if (SWT.INSERT == e.keyCode) {
		//doAction(ADD_BY_COPY_ACTION); // CTRL + INSERT
	    }
	    return;
	}

	if (SWT.INSERT == e.keyCode) {
	    doAction(TREE_ADD_ACTION);
	} else if (SWT.CR == e.keyCode) {
	    doAction(TREE_ENTER_ACTION);
	}
	if (SWT.DEL == e.keyCode) {
	    doAction(TREE_DEL_ACTION);
	}

    }
    
    protected void handleTreeMouseDoubleClick(MouseEvent e) {
	
    }
    
    protected void handleTreeMouseDown(MouseEvent e) {
	
    }
    
    
    private int mouseX;

    private int mouseY;

    private int menuX;

    private int menuY;

    public int getMouseX() {
	return mouseX;
    }

    public int getMouseY() {
	return mouseY;
    }

    public int getMenuX() {
	return menuX;
    }

    public int getMenuY() {
	return menuY;
    }

    public void mapRow(Object row, Object entity) {
	// do nothing
    }

    public void updateTableState() {
	updateStatusText();
	if (getDecorator() == null) {
	    return;
	}
	getDecorator().updateDataState();
    }

    protected void updateStatusText() {
	setStatusText(getIndicatorString());
    }

    /*protected String generateStatusString() {
	if (isPagingMode()) {
	    return 
	}
    }*/
    
    protected String getIndicatorString() {
	int index = getView().getSelectionIndex() + 1;
	int count = getView().getRowCount();
	
	
	if (isValidPagingMode()) {
	    int currPage = getPager().getCurrentPageIndex();
	    int pageCount = getPager().getPageCount();
	    int prevPage = currPage - 1;
	    if (prevPage < 0) {
		prevPage = 0;
	    } else {
		prevPage++;
	    }
	    int totalIndex = prevPage * getPager().getRowLimit() + index;
	    int totalCount = getPager().getTotalRowCount();

	    int rowCount = getPager().getRowCount();
	    int fromRow = getPager().getFromRow();

	    currPage++; // because start with 1
	    fromRow++; // because start with 1
	    
	    int toRow = fromRow + rowCount - 1;		

	    /*
	    return  getPositionString(index, count) 
	    + ", [" + getPositionString(totalIndex, totalCount) + "], " 
	    + STATUS_PAGE_MESSAGE + " " + currPage + " " + STATUS_PAGE_OF_MESSAGE + " " + pageCount 
	    + ", " + STATUS_ROWS_FROM_MESSAGE + " " + fromRow + " " + STATUS_ROWS_TO_MESSAGE + " " + (fromRow + rowCount - 1);
	    */

	    
	    return  STATUS_PAGE_MESSAGE + " " + currPage + " " + STATUS_OF_MESSAGE + " " + pageCount 
	    + ", " + getFromToString(fromRow, toRow, totalCount);
	    
	    // TODO: totalCount is not correct

	    
	}
	return getPositionString(index, count);
    }

    protected String getPositionString(int index, int count) {
	if (index < 1) {
	    return count == 0 ? NO_DATA_MESSAGE : getItemIndexFormat().format(
		    count);
	}
	return ""
		+ getItemIndexFormat().format(index)
		+ " / "
		+ (count == 0 ? NO_DATA_MESSAGE : getItemIndexFormat().format(
			count));
    }

    protected String getFromToString(int from, int to, int count) {
	if (from <=0 || to <= 0 || count <=0) {
	    return NO_DATA_MESSAGE;
	}
	return STATUS_ROWS_MESSAGE + " " + from + "-" + to + " " + STATUS_OF_MESSAGE + " " + count;
    }
    
    public void doLoadEntity() throws ApplicationException {

	Object entity = loadEntity();

	if (entity == null) {
	    return;
	}

	if (isAddMode()) {
	    resetMode();
	    addEntityToView(entity);
	} else if (isEditMode()) {
	    resetMode();
	    setEntityToView(entity);
	}
    }
    
    protected void addEntity(Object entity) throws ApplicationException {
	
    }

    public Object loadEntity() throws ApplicationException {
	Serializable id = getEntityId();
	Object entity = loadEntityById(id);
	return entity;
    }

    protected void doLoadEntity(int index, Serializable id) throws ApplicationException {
	Object entity = loadEntityById(id);
	if (entity == null) {
	    return;
	}
	setEntityToView(entity);
	//getView().setEntity(entity);
    }

    // Override
    protected Object loadEntityById(Serializable id) throws ApplicationException {
	return getController().loadHeaderById(id);
    }

    // Full load entity
    protected Object loadEntityDetailsById(Serializable id) throws ApplicationException {
	return super.loadEntityById(id);
    }

    
    protected IEditForm getEditForm() {
	return editForm;
    }

    protected boolean isForceEditFormDisposed() {
	return true;
    }

    protected void disposeEditForm() {
	if (editForm.isDisposed()) {
	    editForm = null;
	    return;
	}
	if (isForceEditFormDisposed()) {
	    editForm.dispose();
	    editForm = null;
	}
    }


    /**
     * Get form by mode (ADD, EDIT, COPY)
     */
    protected IEditForm getEditForm(int mode) {
	if (editForm != null) {
	    disposeEditForm();
	}
	if (editForm == null) {
	    editForm = createEditForm(mode);
	}
	return editForm;
    }
    
    
    /**
         * Remove entity by Id from data source
         * 
         * @param id
         * @throws ApplicationException
         */
    protected void removeEntityById(Serializable id) throws ApplicationException {
	if (hasEntityProviders()) {
	    IEntityProvider entityProvider = getSelectedEntityProvider();
	    if (entityProvider == null) {
		return;
	    }
	    entityProvider.removeEntityById(id);
	    return;
	}
	super.removeEntityById(id);
    }

 

    /**
     * Register the entity type
     */
    public void registerEntityProvider(Object key, IEntityProvider entityProvider) {
	super.registerEntityProvider(key, entityProvider);
	setMultiForm(true);
    }

 
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // BIND METHODS
    //
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    protected void bindColumn(int index, String propertyName) {
	getTableProvider().bindColumn(index, propertyName);
    }

    protected void bindColumn(int index, String propertyName, Class valueClass) {
	getTableProvider().bindColumn(index, propertyName, valueClass, null);
    }

    protected void bindColumn(int index, String propertyName,  java.text.Format valueFormat) {
	getTableProvider().bindColumn(index, propertyName, null, valueFormat);
    }

    protected void bindColumn(int index, String propertyName, Class valueClass, java.text.Format valueFormat) {
	getTableProvider().bindColumn(index, propertyName, valueClass, valueFormat);
    }

    protected void bindColumn(int index, ILabelProvider labelProvider) {
	getTableProvider().bindColumn(index, labelProvider);
    }

    protected void bindColumn(int index, Class valueClass, IValueProvider valueProvider) {
	getTableProvider().bindColumn(index, valueClass, valueProvider);
    }

    protected void bindColumn(int index, IValueProvider valueProvider) {
	getTableProvider().bindColumn(index, valueProvider);
    }

    ////

    protected void bindColumn(String propertyName) {
	getTableProvider().bindColumn(propertyName);
    }

    protected void bindColumn(String propertyName, Class valueClass) {
	getTableProvider().bindColumn(propertyName, valueClass, null);
    }

    protected void bindColumn(String propertyName, java.text.Format valueFormat) {
	getTableProvider().bindColumn(propertyName, null, valueFormat);
    }

    protected void bindColumn(String propertyName, Class valueClass, java.text.Format valueFormat) {
	getTableProvider().bindColumn(propertyName, valueClass, valueFormat);
    }

    protected void bindColumn(ILabelProvider labelProvider) {
	getTableProvider().bindColumn(labelProvider);
    }

    protected void bindColumn(IValueProvider valueProvider) {
	getTableProvider().bindColumn(valueProvider);
    }

    protected void bindColumn(Class valueClass, IValueProvider valueProvider) {
	getTableProvider().bindColumn(valueClass, valueProvider);
    }
    ////

    protected ITableProvider getTableProvider() {
	return getView().getTableProvider();
    }
    
    
    protected void initTableProvider(ITableProvider tableProvider) {
	if (tableProvider == null) {
	    return;
	}
	tableProvider.setEntityClass(getModel().getEntityClass());
    }
    
    
    

    protected NumberFormat getItemIndexFormat() {
	if (itemIndexFormat == null) {
	    DecimalFormatSymbols dfs = new DecimalFormatSymbols();
	    dfs.setGroupingSeparator(' ');
	    itemIndexFormat = new DecimalFormat("#,###", dfs);
	}
	return itemIndexFormat;
    }

    public boolean isChooseState() {
	return chooseState;
    }

    public void setChooseState(boolean chooseMode) {
	this.chooseState = chooseMode;
    }

    public ISWTTableView getView() {
	if (view == null) {
	    view = createView(); 
	}
	return view;
    }
    
    protected ISWTTableView createView() {
	ISWTTableView view = TableViewFactory.getView(getViewType());
	initTableProvider(view.getTableProvider());
	view.setViewHolder(this);
	view.setDataModel(getModel());
	view.setCriteriaMode(getCriteriaMode());
	return view;
    }
    
    protected String getViewType() {
	return TableViewFactory.JFACE_VIEW;
    }

    // -----------------------------------------------------------------------------------------------------------------------------------
    //
    // Overwrite methods.
    //
    // -----------------------------------------------------------------------------------------------------------------------------------

    /**
     * Bind table.
     * We can override the method to binding table in own child form.
     */
    protected void bindTable() {

    }

   
    /**
     * Load data from data source
     */
    protected void loadData() throws ApplicationException {
	List dataList = null;
	if (criteria == null) {
	    dataList = loadDataList();
	} else {
	    prepareCriteria(criteria);
	    dataList = loadDataList(criteria);
	    preparePager(dataList);
	}
	updateTable(dataList);
    }

    /**
     * Load data list for export (ALL data - no paging)
     * @return
     * @throws ApplicationException
     */
    protected List loadExportDataList() throws ApplicationException {
	List exportDataList = null;
	if (criteria == null) {
	    exportDataList = loadDataList();
	} else {
	    ICriteria exportCriteria = new CriteriaImpl();
	    exportCriteria.setFilterSet(criteria.getFilterSet());
	    exportCriteria.setSorterSet(criteria.getSorterSet());
	    exportDataList = loadDataList(exportCriteria);
	}
	return exportDataList;
    }
    
    
    
    
    protected void prepareCriteria(ICriteria criteria) {
	if (criteria == null || pager == null) {
	    return;
	}
	
	if (!pager.isNavigationState() && criteria.hasFilter()) {
	    pager.setFromRow(Pager.START_ROW_INDEX);
	}
	pager.setNavigationState(false);
	
	criteria.setFrom(pager.getFromRow());
	criteria.setSize(pager.getRowLimit());
    }
    
    protected void preparePager(List list) {
	if (pager == null) {
	    return;
	}
	if (list == null) {
	    return; // TODO
	}
	
	if (list instanceof DataList){
	    DataList pl = (DataList) list;
	    pager.setTotalRowCount(pl.total()); // If need get total row count
	    pager.setRowCount(pl.size());
	    pager.recalculate();
	} else {
	    // TODO: pager invalid
	}
	
	getDecorator().updateState();
    }
    
    /**
     * Load data list from data source
     * 
     * @return List of data
     * @throws ApplicationException
     */
    protected List loadDataList() throws ApplicationException {
	return getListFormController().loadDataList();
    }

    
    /**
     * Load data list by criteria from data source
     * @param criteria
     * @return
     * @throws ApplicationException
     */
    protected List loadDataList(ICriteria criteria) throws ApplicationException {
	return getListFormController().loadDataList(criteria);
    }
    
    
    
    /*
    protected List loadDataList() throws ApplicationException {
	if (serviceCriteria == null) {
	    return getListFormController().loadDataList();
	}
	return getListFormController().loadDataList(serviceCriteria);
    }
    */

    
 

    public void addCellRenderer(int column, ITableCellRenderer r) {
	if (view == null) {
	    return;
	}
	view.addCellRenderer(column, r);
    }

    public boolean setFocus() {
	boolean b = super.setFocus();
	if (getView() == null) {
	    return b;
	}
	return getView().setTableFocus();
    }

    public boolean setTableFocus() {
	return getView().setTableFocus();
    }

    @Override
    protected Object getSelectedEntityProviderKey() {
	return getSelectedEntityConfigurableProviderKey();
    }

    protected Object getSelectedEntityConfigurableProviderKey() {
	if (!hasEntityProviders()) {
	    return null;
	}
	Object entity = getSelectedEntity();
	if (entity == null) {
	    return null;
	}
	if (!(entity instanceof IEntityConfigurable)) {
	    return null;
	}
	String entityID = ((IEntityConfigurable) entity).getEntityConfigId();
	return entityID;
    }

    public boolean isSupportPeriodFilter() {
	return supportPeriodFilter;
    }

    public void setSupportPeriodFilter(boolean supportPeriodFilter) {
	this.supportPeriodFilter = supportPeriodFilter;
    }

    protected Date getEndDate() {
	return endDate;
    }

    protected void setEndDate(Date endDate) {
	this.endDate = endDate;
    }

    protected Date getStartDate() {
	return startDate;
    }

    protected void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    public void afterChangeModel() {
	calculateAggregateVariables();
    }

    protected void setAggregateVariable(String name, Object value) {
	getAggregateVariableMap().put(name, value);
    }

    protected Object getAggregateVariable(String name) {
	return getAggregateVariableMap().get(name);
    }

    protected Map<String, Object> getAggregateVariableMap() {
	if (aggregateVariableMap == null) {
	    aggregateVariableMap = new HashMap<String, Object>();
	}
	return aggregateVariableMap;
    }

    protected boolean isEmptyAggregateVariables() {
	return aggregateVariableMap == null || aggregateVariableMap.size() == 0;
    }

    protected void calculateAggregateVariables() {
	initAggregateVariables();
	if (isEmptyAggregateVariables()) {
	    return;
	}
	int entityCount = getView().getEntityCount();

	for (int i = 0; i < entityCount; i++) {
	    Object entity = getView().getEntityByIndex(i);
	    try {
		calculateAggregateVariablesByEntity(entity);
	    } catch (Exception ex) {
		ex.printStackTrace();
	    }

	}
	outputAggregateVariables();
    }

    protected Object getEntityValue(String propertyName, Object entity) throws ApplicationException {
	return ClassUtilsExt.getBeanValue(getEntityClass(), propertyName, entity);
    }

    protected void outputAggregateVariables() {
	getDecorator().setStatusSummaryText(getAggregateVariablesText());
    }

    protected String getAggregateVariablesLabel() {
	return Messages.getString("Form.total.label") + ": "; //$NON-NLS-1$
    }

    protected void calculateVariableSum(String varName, Object entity) throws ApplicationException {
	Double value = (Double) getEntityValue(varName, entity);
	double var = (Double) getAggregateVariable(varName);
	var += value;
	setAggregateVariable(varName, var);
    }

    // //

    protected void initAggregateVariables() {
	// STUB
    }

    protected void calculateAggregateVariablesByEntity(Object entity) throws ApplicationException {
	// STUB
    }

    protected String getAggregateVariablesText() {
	return ""; // STUB
    }

    public void loadPreferences(Properties preferences) throws ApplicationException {
	getView().loadPreferences(preferences);
    }

    public void storePreferences() throws ApplicationException {
	preferences = new Properties();
	super.storePreferences();
    }

    public void storePreferences(Properties preferences) throws ApplicationException {
	getView().storePreferences(preferences);
    }


    // // TODO: STUB BLOCK ////

    public Tree getTree() {
	return null;
    }

    public boolean isTreeView() {
	return getTree() != null;
    }

    //TODO: STUB
    private EntityService treeService;
    
    protected EntityService getTreeService() {
	if (treeService != null){
	    return treeService;
	}
	Class klass = getTreeServiceClass();
	if (klass == null) {
	    return null;
	}
	treeService = (EntityService) getService(klass);
	return treeService;
    }

    
    
    
    protected Class getTreeServiceClass() {
	return treeServiceClass;
    }

    protected void setTreeServiceClass(Class treeServiceClass) {
        this.treeServiceClass = treeServiceClass;
    }

    
    protected Class getTreeEntityClass() {
	return treeEntityClass;
    }

    public void setTreeEntityClass(Class treeEntityClass) {
        this.treeEntityClass = treeEntityClass;
    }

    
    
    
    
    protected Class getTreeEditFormClass() {
	if (treeEditFormClass == null) {
	    if (getTreeEntityClass() != null) {
		treeEditFormClass = createEditFormClass(getTreeEntityClass()); 
	    }
	}
	return treeEditFormClass;
    }

    
    protected void setTreeEditFormClass(Class treeEditFormClass) {
	this.treeEditFormClass = treeEditFormClass;
    }
    
    

    
    protected Object getSelectedCategoryEntity() {
	return getSelectedTreeEntity();
    }
    
    
    protected TreeViewer getTreeViewer() {
	return treeViewer;
    }
    
    protected Object getSelectedTreeEntity() {
	Node node = getSelectedTreeNode();
	if (node == null) {
	    return null;
	}
	return node.getData();
    }
    
    
    
    protected Node getSelectedTreeNode() {
	IStructuredSelection selection = getTreeSelection();
	if (selection == null) {
	    return null;
	}
	return getTreeNode(selection.getFirstElement());
    }
    
    public IStructuredSelection getTreeSelection() {

	TreeViewer treeViewer = getTreeViewer();
	if (treeViewer == null) {
	    return null;
	}
	return (IStructuredSelection) treeViewer.getSelection();
    }

    
    protected void initTree() throws ApplicationException {
	Tree tree = getTree();
	if (tree == null) {
	    return;
	}
	
	
	treeViewer = new TreeViewer(tree);
	treeViewer.setContentProvider(new TreeContentProvider());
	treeViewer.setLabelProvider(new TreeLabelProvider());
	
	// -1 - Auto expand all levels
	// 0  - No auto expand
	// 1  - Auto expand top-level, but not their children 
	// 2  - Auto expand top-level, and their children, but not grandchildren 
	treeViewer.setAutoExpandLevel(2 /*TreeViewer.ALL_LEVELS*/);
	
	treeViewer.setComparer(new TreeElementComparer());
	
	tree.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent event) {
		handleTreeWidgetSelected(event);
	    }
	});

	
	tree.addKeyListener(new KeyAdapter() {
	    public void keyReleased(KeyEvent e) {
		handleTreeKeyPressed(e);
	    }
	});

	tree.addMouseListener(new MouseAdapter() {
	    public void mouseDoubleClick(MouseEvent e) {
		handleTreeMouseDoubleClick(e);
	    }

	    public void mouseDown(MouseEvent e) {
		handleTreeMouseDown(e);
	    }
	});

    }

     
    protected void updateTree() throws ApplicationException {
	if (treeViewer == null) {
	    return;
	}
	
	List elements = loadTreeList();
	
	Node root = new Node();
	root.setData(getTreeRootName());
	
	//root.setData(GROUPS_MESSAGE);
	//root.setImage(FOLDER_IMAGE);

	
	populateTree(elements, root);
	
	
	Node inputNode = root;
	if (isVisibleTreeRoot) {
	    Node virtualRoot = new Node();
	    virtualRoot.setData("Root");
	    virtualRoot.addChild(root);
	    
	    inputNode = virtualRoot;
	}
	
	treeViewer.setInput(inputNode);

    }
    
    protected List loadTreeList() throws ApplicationException {
	EntityService service = getTreeService();
	if (service == null) {
	    return null;
	}
	return service.findAll();
    }
    
    
    /**
     * Populate the tree 
     * @param elements
     * @param root
     */
    protected void populateTree(List elements, Node root) {
	isTreeMoreLevel = false;
	if (elements == null || elements.size() == 0) {
	    return;
	}
	
	// Get parent property for tree nodes
	String parentIdProperty = getTreeItemParentIdProperty();
	if (parentIdProperty == null) {
	    // If parent property is empty populate top level of the tree 
	    populateTreeNode(elements, root);
	    return;
	}
	
	//
	HashMap<Object, List> map = new HashMap<Object, List>();

	for (int i = 0; i < elements.size(); i++) {
	    Object element = elements.get(i);
	    Object parentId = getTreeItemParentId(element);
	    
	    if (parentId == null) {
		// Add element of top level
		addNode(root, element);
		continue;
	    }
	    
	    isTreeMoreLevel = true;
	    List list = map.get(parentId);
	    if (list == null) {
		list = new ArrayList();
		map.put(parentId, list);
	    }
	    list.add(element);
	    
	}
	
	if (!isTreeMoreLevel) {
	    dataMap = null;
	    return;
	}
	dataMap = map;
    }

    /**
     * Populate the tree node
     * @param elements
     * @param parent
     */
    protected void populateTreeNode(List elements, Node parent) {
	if (elements == null || elements.size() == 0) {
	    return;
	}
	for (int i = 0; i < elements.size(); i++) {
	    Object element = elements.get(i);
	    addNode(parent, element);
	}
    }
    /**
     * Create an node by element and add the node to the parent node 
     * @param parent
     * @param element
     */
    protected void addNode(Node parent, Object element) {
	Node node = new Node();
	node.setData(element);
	parent.addChild(node);
	// node.setImage(FOLDER_IMAGE);
	// Serializable id = getTreeItemId(element);
    }



    protected Serializable getTreeItemId(Object element) {
	try {
	    if (element == null) {
		return null;
	    }
	    Serializable value = (Serializable) ClassUtilsExt.getBeanValue(element.getClass(), getTreeItemIdProperty(), element);
	    return value;
	} catch (Exception ex) {
	    return null;
	}
    }

    protected String getTreeItemText(Object element) {
	try {
	    if (element == null) {
		return "";
	    }
	    // If element is string (not bean) then return string presentation
	    if (element instanceof String) {
		return (String) element;
	    }
	    Object value = ClassUtilsExt.getBeanValue(element.getClass(), getTreeItemNameProperty(), element);
	    if (value == null) {
		value = element.toString();
	    }
	    return value.toString();
	} catch (Exception ex) {
	    return element.toString();
	}
    }
    
    protected Object getTreeItemParentId(Object element) {
	try {
	    if (element == null) {
		return null;
	    }
	    Object value = ClassUtilsExt.getBeanValue(element.getClass(), getTreeItemParentIdProperty(), element);
	    return value;
	} catch (Exception ex) {
	    return null;
	}
    }


    protected String getTreeItemIdProperty() {
	return treeItemIdProperty;
    }

    protected void getTreeItemIdProperty(String treeItemIdProperty) {
	this.treeItemIdProperty = treeItemIdProperty;
    }
    
    
    protected String getTreeItemNameProperty() {
	return treeItemNameProperty;
    }

    protected void setTreeItemNameProperty(String treeItemNameProperty) {
	this.treeItemNameProperty = treeItemNameProperty;
    }

    
    protected String getTreeItemRefIdProperty() {
	return treeItemRefIdProperty;
    }
    
    protected void setTreeItemRefIdProperty(String treeItemRefIdProperty) {
	this.treeItemRefIdProperty = treeItemRefIdProperty;
    }

    
    protected String getTreeItemParentIdProperty() {
	return treeItemParentIdProperty;
    }
    
    protected void setTreeItemParentIdProperty(String treeItemParentIdProperty) {
	this.treeItemParentIdProperty = treeItemParentIdProperty;
    }
    
    

    protected Image getTreeFolderImage() {
	return FOLDER_IMAGE;
    }

    protected String getTreeRootName() {
	return getTreeGroupsText();
    }

    protected String getTreeGroupsText() {
	return GROUPS_MESSAGE;
    }

    protected String getTreeCategoriesText() {
	return CATEGORIES_MESSAGE;
    }

    public void updateForm() throws ApplicationException {
	super.updateForm();
	
	if (supportUpdateTree) {
	    updateTree();
	}
	
    }
    
    ////

    /**
     * Wrapper for data object.
     * An node has parent and children.
     */
    protected class Node {
	
	/** Data object **/
	private Object data;
	
	/** Parent **/
	private Node parent;
	
	/** Children **/
	private List<Node> children;
	
	private boolean loadChildren;
	
	

	public boolean isLoadChildren() {
	    return loadChildren;
	}

	public void setLoadChildren(boolean loadChildren) {
	    this.loadChildren = loadChildren;
	}

	public List<Node> getChildren() {
	    if (children == null) {
		children = new ArrayList<Node>();
	    }
	    return children;
	}

	public void setChildren(List<Node> children) {
	    this.children = children;
	}
	
	public void addChild(Node child) {
	    getChildren().add(child);
	}


	public boolean hasChildren() {
	    return children == null ? false: !children.isEmpty();
	}
	
	public Object getData() {
	    return data;
	}

	public void setData(Object data) {
	    this.data = data;
	}

	public Node getParent() {
	    return parent;
	}

	public void setParent(Node parent) {
	    this.parent = parent;
	}
	
	
	
	
    }
    
    protected class TreeContentProvider implements ITreeContentProvider {

	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
	}

	public void dispose() {
	}

	public Object[] getElements(Object parent) {
	    return getChildren(parent);
	}

	public Object getParent(Object child) {
	    Node node = getTreeNode(child);
	    if (node == null) {
		return null;
	    }
	    return node.getParent();
	}

	public Object[] getChildren(Object parent) {
	    Node node = getTreeNode(parent);
	    if (node == null) {
		return new Object[0];
	    }
	    return node.getChildren().toArray();
	}

	public boolean hasChildren(Object parent) {
	    Node node = getTreeNode(parent);
	    if (node == null) {
		return false;
	    }
	    
	    //
	    if (!isTreeMoreLevel) {
		return node.hasChildren();
	    }

	    if (node.isLoadChildren()) {
		return node.hasChildren();
	    }

	    node.setLoadChildren(true);

	    List children = getTreeNodeChildren(node);

	    if (children == null || children.isEmpty()) {
		return node.hasChildren();
	    }
	    populateTreeNode(children, node);
	    //
	    
	    return true;

	}

    }
    
    protected boolean hasNodeChildren(Node node) {
	if (node == null) {
	    return false;
	}

	//
	if (!isTreeMoreLevel) {
	    return node.hasChildren();
	}

	if (node.isLoadChildren()) {
	    return node.hasChildren();
	}

	node.setLoadChildren(true);

	List children = getTreeNodeChildren(node);

	if (children == null || children.isEmpty()) {
	    return node.hasChildren();
	}
	populateTreeNode(children, node);
	//

	return true;
    }
    
    protected class TreeLabelProvider extends LabelProvider {
	
	  public String getText(Object obj) {
	      Node node = getTreeNode(obj);
	      if (node == null) {
		  return "";
	      }
	      Object data = node.getData();
	      if (data == null) {
		  return "";
	      }
	      String text = getTreeItemText(data);
	      return text == null ? "" : text;
	    }

	    public Image getImage(Object obj) {
		return FOLDER_IMAGE;
	    }
    }
    
    protected Node getTreeNode(Object obj) {
	if (obj == null) {
	    return null;
	}
	if (obj instanceof Node) {
	    return (Node) obj;
	}
	return null;
    }
    
    protected Object getTreeNodeData(Object obj) {
	Node node = getTreeNode(obj);
	if (node == null) {
	    return null;
	}
	return node.getData();
    }
    
    protected List getTreeNodeChildren(Node node) {
	if (dataMap == null || dataMap.isEmpty()) {
	    return null;
	}
	Object element = node.getData();
	if (element == null) {
	    return null;
	}
	Object id = getTreeItemId(element);
	if (id == null) {
	    return null;
	}
	List children = dataMap.get(id);
	if (children == null || children.isEmpty()) {
	    return null;
	}
	return children;
    }
    
    protected List getTreeNodeIdList(Node node) {
	if (node == null) {
	    return null;
	}
	List ids = new ArrayList();
	populateIdList(ids, node);
	return ids.isEmpty() ? null : ids;
    }
    
    protected void populateIdList(List ids, Node node) {
	if (ids == null || node == null) {
	    return;
	}
	Object element = node.getData();
	if (element == null) {
	    return;
	}
	Object id = getTreeItemId(element);
	if (id == null) {
	    return;
	}
	ids.add(id);
	boolean hasChildren = hasNodeChildren(node);
	if (!hasChildren) {
	    return;
	}
	List<Node> children = node.getChildren();
	if (children == null) { // ????
	    return;
	}
	for (Node child : children) {
	    populateIdList(ids, child);
	}
	
    }
    
    
    //////
    
    
    protected void removeEntityFromView() {
	getView().removeEntity();
    }
    
    protected void addEntityToView(Object entity) {
	getView().addEntity(entity);
    }

    protected void setEntityToView(Object entity) {
	getView().setEntity(entity);
    }


    //////////////////////////////////////////////////////
    
    public void doTreeEnterAction() throws ApplicationException {
	doTreeEditAction();
    }
    
    
    public void doTreeAddAction() throws ApplicationException {
	if (isReadOnly()) {
	    return;
	}

	if (!isSupportEditMode()) {
	    return;
	}
	

	IEditForm form = createTreeEditForm();
	if (form == null) {
	    return;
	}
	form.setMode(PWT.ADD_MODE);
	initTreeEditForm(form);

	form.setEntityId(null);
	
	form.addFormListener(new TreeFormListener());
	form.setParentForm(this);

	Toolkit.openForm(this, form);
	
    }
    
    public void doTreeDelAction() throws ApplicationException {
	
	if (isReadOnly()) {
	    return;
	}

	if (!isSupportEditMode()) {
	    return;
	}
	
	// Special check id because we can't delete element without id (id = null)
	// For example root element is not entity and has not id.
	Object treeEntity = getSelectedTreeEntity();
	if (treeEntity == null) {
	    return;
	}
	
	Serializable id = getTreeItemId(treeEntity);
	if (id == null) {
	    return;
	}
	
	if (!isConfirmDeleteEntity()) {
	    return;
	}

	
	
	if (!isTableChildrenEmpty()) {
	    openMessageDialog("Can't remove the item. The item has children");
	    return;
	}
	
	EntityService service = getTreeService();
	if (service == null) {
	    return;
	}
	
	service.remove(treeEntity);

	updateSelectedTreeItem();
	
	
    }
    
    protected void updateSelectedTreeItem() {
	// TODO
	// Must change update
	// Very hard update (performance)
	
	try {
	     processingInternalFilter = true;
	     // updateTree();
	     doAction(REFRESH_ACTION);
	} finally {
	     processingInternalFilter = false;
	}
    }
    
    public void doTreeEditAction() throws ApplicationException {
	if (isReadOnly()) {
	    return;
	}

	if (!isSupportEditMode()) {
	    return;
	}
	
	Serializable id = getSelectedTreeEntityId();
	if (id == null) {
	    return;
	}

	IEditForm form = createTreeEditForm();
	if (form == null) {
	    return;
	}
	form.setMode(PWT.EDIT_MODE);
	initTreeEditForm(form);

	form.setEntityId(id);
	
	form.setParentForm(this);
	form.addFormListener(new TreeFormListener());

	Toolkit.openForm(this, form);

    }

    
    
    protected IEditForm createTreeEditForm() {
	Class formClass = getTreeEditFormClass();
	return createEditForm(formClass);
    }

    protected void initTreeEditForm(IEditForm form) throws ApplicationException {
	
    }
    
     
    protected Class createEditFormClass(Class entityClass) {
	Association association = getController().createAssociationByBeanClass(entityClass);
	if (association == null) {
	    return null;
	}
	Class editFormClass = association.getElementByType(getController().getEditFormType());
	return editFormClass;
    }

    
    protected boolean isTableChildrenEmpty() {
	Table table = (Table) getTable();
	if (table == null) {
	    return true;
	}
	return table.getItemCount() == 0;
    }
    
    
    /**
     * Tree Element Comparer by id
     * Use to selection elements 
     */
    class TreeElementComparer implements IElementComparer {
	
	public boolean equals(Object o1, Object o2) {
	    if (o1 == null || o2 == null) {
		return false;
	    }
	    Object d1 = getTreeNodeData(o1);
	    Object d2 = getTreeNodeData(o2);
	    
	    if (d1 == null || d2 == null) {
		return false;
	    }
	    
	    
	    Object id1 = getTreeItemId(d1);
	    Object id2 = getTreeItemId(d2);
	    if (id1 == null || id2 == null) {
		return false;
	    }
	    return id1.equals(id2);
	}
	
	public int hashCode(Object o) {
	    if (o == null) {
		return 0;
	    }
	    Object d = getTreeNodeData(o);
	    if (d == null) {
		return 0;
	    }
	    
	    Object id = getTreeItemId(d);
	    if (id == null) {
		return 0;
	    }
	    return id.hashCode();
	}
    }


    
    ////////////////////////////////////////////////////////////////////////////////////////////////
    
    public class SimpleFormListener implements FormListener {
	
	public void openForm(FormEvent event) throws ApplicationException {
	    
	}
	    
	public void closeForm(FormEvent event) throws ApplicationException {
	    //handleCloseForm(event.getForm()); // 2010-04-17
	    if (!isForceUpdate()) {
		updateByEditForm();
	    }
	}
	    
	public  void disposeForm(FormEvent event) throws ApplicationException {
	    
	}
	    
	
	public void updateForm(FormEvent event) throws ApplicationException {
	    if (isForceUpdate()) {
		updateByEditForm();
	    }
	}
    }
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////
    
    private class TreeFormListener implements FormListener {
	
	public void openForm(FormEvent event) throws ApplicationException{
	    
	}
	    
	public void closeForm(FormEvent event) throws ApplicationException {
	    if (!isForceUpdate()) {
		updateTreeByForm(event.getForm());
	    }
	}
	    
	public  void disposeForm(FormEvent event) throws ApplicationException {
	    
	}
	
	public void updateForm(FormEvent event) throws ApplicationException {
	    if (isForceUpdate()) {
		updateTreeByForm(event.getForm());
	    }
	}
    }
    
    protected void updateTreeByForm(IForm form) throws ApplicationException {

	if (form == null || !form.isModify()) {
	    return;
	}

	if (treeViewer == null) {
	    return;
	}

	if (form.isAddMode()) {

	    // Update only tree
	    updateTree();

	    // Selection new element
	    // treeViewer.setSelection(selection);
	    return;
	}

	ISelection selection = treeViewer.getSelection();

	updateSelectedTreeItem();

	if (selection == null || selection.isEmpty()) {
	    return;
	}

	treeViewer.setSelection(selection);

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////

    
    
    public void forceLoadDataByCriteria(ICriteria criteria) throws ApplicationException {
	setCriteria(criteria);
	doLiteRefreshAction();
    }

    public void doLiteRefreshAction()  throws ApplicationException {
	boolean b = supportUpdateTree;
	try {
	    supportUpdateTree = false; // Disable update tree
	    doRefreshAction();
	} finally {
	    supportUpdateTree = b;
	}
    }
    
    
    public ICriteria getCriteria() {
        return criteria;
    }

    public void setCriteria(ICriteria criteria) {
        this.criteria = criteria;
    }
    
    
    public void setClientCriteriaMode() {
	criteriaMode = ITableView.CLIENT_CRITERIA_MODE;
    }

    public void setServerCriteriaMode() {
	criteriaMode = ITableView.SERVER_CRITERIA_MODE;
    }
    
    public int getCriteriaMode() {
	// If form doesn't have data source then return client criteria
	if (!hasDataSource()) {
	    return ITableView.CLIENT_CRITERIA_MODE;
	}
        return criteriaMode;
    }
    
    public boolean isClientCriteriaMode() {
	return getCriteriaMode() == ITableView.CLIENT_CRITERIA_MODE;
    }

    public boolean isServerCriteriaMode() {
	return getCriteriaMode() == ITableView.SERVER_CRITERIA_MODE;
    }

    

    public boolean isSupportPaging() {
        return supportPaging;
    }

    public void setSupportPaging(boolean supportPaging) {
        this.supportPaging = supportPaging;
    }

    public final boolean isPagingMode() {
	if (!supportPaging || !FormEnvironment.isPagination() || !hasDataSource() ) {
	    return false;
	}
        return pagingMode;
    }

    public final void setPagingMode(boolean pagingMode) {
        this.pagingMode = pagingMode;
    }

    public Pager getPager() {
        return pager;
    }
    

    public void setFlexiblePagingMode() {
	if (!FormEnvironment.isPagination() ) {
	    return;
	}
	setSupportPaging(true);
	setPagingMode(true);
	setServerCriteriaMode();
    }
    
    public void setDisablePagingMode() {
	setSupportPaging(false);
	setPagingMode(false);
	setClientCriteriaMode();
    }

    public void handleModifyPreferences(Properties preferences) {
	super.handleModifyPreferences(preferences);
	// TODO: If set pagination mode then refresh with pagination mode
    }
    
    protected List getEmptyDataList() {
	return Collections.EMPTY_LIST;
    }

    public boolean isResetPeriodFilter() {
        return resetPeriodFilter;
    }

    public void setResetPeriodFilter(boolean resetPeriodFilter) {
        this.resetPeriodFilter = resetPeriodFilter;
    }
    
    
}
