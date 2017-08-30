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
import java.text.Format;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.Toolkit;
import org.plazmaforge.framework.client.forms.AbstractEntityProvider;
import org.plazmaforge.framework.client.forms.IEditForm;
import org.plazmaforge.framework.client.forms.IFormConstants;
import org.plazmaforge.framework.client.models.IDataModel;
import org.plazmaforge.framework.client.swt.controls.ITableProvider;
import org.plazmaforge.framework.client.swt.controls.TableProvider;
import org.plazmaforge.framework.client.swt.views.ISWTTableView;
import org.plazmaforge.framework.client.swt.views.ITableCellRenderer;
import org.plazmaforge.framework.client.swt.views.SWTTableViewHolder;
import org.plazmaforge.framework.client.swt.views.TableViewFactory;
import org.plazmaforge.framework.client.views.IView;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.ClassUtilsExt;



/** 
 * @author Oleh Hapon
 *
 */

public class TableEntityProvider<T> extends AbstractEntityProvider implements SWTTableViewHolder, IFormConstants {

    /** Name of list property. For example, property is 'elements', but we use method 'getElements' to get list of elements **/
    private String listProperty;
    
    
    
    /** Name of 'Add' method. For example: 'addElement' **/
    private String addMethod;
    
    /** Class of parameter of 'Add' method. If the class is null we use getEntityClass() **/
    private Class addMethodParameterType;

    
    
    /** Name of 'Remove' method. For example: 'removeElement' **/
    private String removeMethod;
    
    /** Class of parameter of 'Remove' method. If the class is null we use getEntityClass() **/
    private Class removeMethodParameterType;

    
    
    private String parentProperty;
    
    private boolean forceRefreshAll;
    
    
    /** If true the we only set DELETED flag without real remove entity **/
    private boolean softRemoveMode = false;
    
    
    public boolean isForceRefreshAll() {
        return forceRefreshAll;
    }


    public void setForceRefreshAll(boolean forceRefreshAll) {
        this.forceRefreshAll = forceRefreshAll;
    }

    
    /**
     * Initialize 
     */
    public void init() {
	initTable();
    }

    protected void initTable() {
	bindTable();
	if (getTable() == null) {
	    return;
	}
	getTableView().setTable(getTable());
	
	getTableView().addKeyListener(new KeyAdapter() {
		public void keyPressed(KeyEvent e) {
		    if (SWT.INSERT == e.keyCode) {
			doAction(ITEM_ADD_ACTION);
		    } else if (SWT.CR == e.keyCode) {
			doAction(ITEM_EDIT_ACTION);
		    }if (SWT.DEL == e.keyCode) {
			doAction(ITEM_DEL_ACTION);
		    } 
		}
	});
 	
	getTableView().addMouseListener(new MouseAdapter() {
		public void mouseDoubleClick(MouseEvent e) {
		    doAction(ITEM_EDIT_ACTION);
		}
	});
	
	initColumns();
    }
    
    public void initColumns() {
	getTableView().initCellRenderers(getEntityClass());
    }
   
   
    protected void doAction(String action) {
	if (getFormHolder() == null) {
	    return;
	}
	getFormHolder().doAction(action);
    }
    
    protected T getTable() {
	return null;
    }
    
    protected void bindTable() {
	
    }

    public ISWTTableView getTableView() {
	return (ISWTTableView) getView();
    }

    public void updateView() throws ApplicationException {
	getTableView().updateTable(loadDataList());
    }

    public void refreshView() throws ApplicationException {
	getTableView().refreshTable();
    }
    
    protected List loadDataList() throws ApplicationException {
	return loadDataList(getParentEntity());
    }
    
    protected List loadDataList(Object parentEntity) throws ApplicationException {
	return (List) getListValue();
    }
  
    protected void initTableProvider(ITableProvider tableProvider) {
	if (tableProvider == null) {
	    return;
	}
	tableProvider.setEntityClass(getEntityClass());
    }
    
    public IView getView() {
	if (super.getView() == null) {

	    // JFACE View
	    ISWTTableView tableView =  TableViewFactory.getView(TableViewFactory.JFACE_VIEW);
	    //tableView.setTableProvider(createTableProvider());
	    initTableProvider(tableView.getTableProvider());
	    tableView.setViewHolder(this);
	    tableView.setDataModel(createDataModel());
	    
	    tableView.setForceRefreshAll(isForceRefreshAll());
	    
	    
	    setView(tableView);
	}
	return super.getView();
    }
    
    protected IDataModel createDataModel() {
	return new IDataModel() {
	    
	    private List dataList = new ArrayList();
	    
	    public void setDataList(List dataList) {
		this.dataList = dataList;
	    }
	    
	    public List getDataList() {
		return dataList;
	    }
	};
	
    }
    
    
    public IEditForm getEditForm() {
	if (super.getEditForm() != null && super.getEditForm().isDisposed()) {
	    super.setEditForm(null);
	}
	if (super.getEditForm() == null && this.getEntityFormClass() != null) {
	   super.setEditForm(createEditForm(this.getEntityFormClass())); 
	}
        return super.getEditForm();
    }
    
    public void mapRow(Object row, Object entity) {
	// do nothing
    }
    
    
    public void updateTableState() {
	// STUB
    }
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // BIND COLUMNS
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    protected void bindColumn(int index, String propertyName) {
	getTableProvider().bindColumn(index, propertyName);
    }
    

    protected void bindColumn(int index, String propertyName, Class valueClass) {
	getTableProvider().bindColumn(index, propertyName, valueClass, null);
    }

    protected void bindColumn(int index, String propertyName, Format valueFormat) {
	getTableProvider().bindColumn(index, propertyName, null, valueFormat);
    }
    
    protected void bindColumn(int index, String propertyName, Class valueClass, Format valueFormat) {
	getTableProvider().bindColumn(index, propertyName, valueClass, valueFormat);
    }
    
    
    
    
    
    public void addCellRenderer(int column, ITableCellRenderer r) {
	ISWTTableView tableView = getTableView();
	if (tableView == null) {
	    return;
	}
	tableView.addCellRenderer(column, r);
    }

    protected ITableProvider getTableProvider() {
	return getTableView().getTableProvider();
    }
    
    public String getListProperty() {
        return listProperty;
    }

    public void setListProperty(String listProperty) {
        this.listProperty = listProperty;
    }

    
    public String getAddMethod() {
        return addMethod;
    }

    public void setAddMethod(String addMethod) {
        this.addMethod = addMethod;
    }

    public void setAddMethod(String addMethod, Class addMethodParameterType) {
	setAddMethod(addMethod);
	setAddMethodParameterType(addMethodParameterType);
    }
    
    public Class getAddMethodParameterType() {
	if (addMethodParameterType == null) {
	    addMethodParameterType = getEntityClass();
	}
        return addMethodParameterType;
    }

    public void setAddMethodParameterType(Class addMethodParameterType) {
        this.addMethodParameterType = addMethodParameterType;
    }
    

    ////
    
    public String getRemoveMethod() {
        return removeMethod;
    }

    public void setRemoveMethod(String removeMethod) {
        this.removeMethod = removeMethod;
    }

    public Class getRemoveMethodParameterType() {
	if (removeMethodParameterType == null) {
	    removeMethodParameterType = getEntityClass();
	}
        return removeMethodParameterType;
    }

    public void setRemoveMethodParameterType(Class removeMethodParameterType) {
        this.removeMethodParameterType = removeMethodParameterType;
    }
    
    ////

    public String getParentProperty() {
        return parentProperty;
    }

    public void setParentProperty(String parentProperty) {
        this.parentProperty = parentProperty;
    }

    protected List getDataList() throws ApplicationException {
	return (List) getListValue();
    }
    
    protected Object getListValue() throws ApplicationException {
	return ClassUtilsExt.getBeanValue(getParentEntityClass(), getListProperty(), getParentEntity());
    }
    
    public Serializable createEntity(Object entity) throws ApplicationException {
	super.createEntity(entity);
	if (entity == null || getEntityClass() == null) {
	    return null;
	}
	addEntityToModel(entity);
	return null; // [NULL]. Return null id
    }
    
    public void removeEntity(Object entity) throws ApplicationException {
	// By default if (removeMethod == null) we set 'deleted' flag only.
	super.removeEntity(entity);
	if (getRemoveMethod() == null) {
	    if (isSoftRemoveMode()) {
		return;
	    }
	    removeEntityFromList(entity);
	} else {
	    removeEntityFromParent(entity);
	}
	
    }
    
    
    protected void addEntityToModel(Object entity) throws ApplicationException {
	if (getAddMethod() == null) {
	    addEntityToList(entity);
	} else {
	    addEntityToParent(entity);
	}
    }
    
    protected void addEntityToList(Object entity) throws ApplicationException {
	List dataList = getDataList();
	if (dataList == null) {
	    return;
	}
	dataList.add(entity);
    }
    
    
    protected void removeEntityFromList(Object entity) throws ApplicationException {
	List dataList = getDataList();
	if (dataList == null) {
	    return;
	}
	dataList.remove(entity);
    }

    /**
     * Add an entity to a parent object
     * @param entity
     * @throws ApplicationException
     */
    protected void addEntityToParent(Object entity) throws ApplicationException {
	ClassUtilsExt.invoke(getParentEntityClass(), getAddMethod(), getAddMethodParameterType(), getParentEntity(), entity);
    }

    /**
     * Remove an entity from a parent object
     * @param entity
     * @throws ApplicationException
     */
    protected void removeEntityFromParent(Object entity) throws ApplicationException {
	ClassUtilsExt.invoke(getParentEntityClass(), getRemoveMethod(), getRemoveMethodParameterType(), getParentEntity(), entity);
    }

    
    protected IEditForm createEditForm(Class formClass) {
	if (formClass == null) {
	    return null;
	}
	try {
	    return (IEditForm) Toolkit.getForm(null, formClass, PWT.EDIT_FORM);	    
	} catch (Exception ex) {
	    return null;
	}
    }    
    
    public Object getSelectedEntity() {
	return this.getTableView().getSelectedEntity();
    }
    
    public Serializable getSelectedEntityId() {
	return this.getTableView().getSelectedEntityId();
    }


    public boolean isSoftRemoveMode() {
        return softRemoveMode;
    }


    public void setSoftRemoveMode(boolean softRemoveMode) {
        this.softRemoveMode = softRemoveMode;
    }    
    

    
}
