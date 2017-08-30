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
import java.util.List;


import org.apache.log4j.Logger;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.plazmaforge.framework.client.controls.ComponentController;
import org.plazmaforge.framework.client.controls.ComponentModel;
import org.plazmaforge.framework.client.models.LoadEvent;
import org.plazmaforge.framework.client.models.LoadListener;
import org.plazmaforge.framework.client.models.UpdateEvent;
import org.plazmaforge.framework.client.models.UpdateListener;
import org.plazmaforge.framework.client.models.ValueChangeEvent;
import org.plazmaforge.framework.client.models.ValueChangeListener;
import org.plazmaforge.framework.client.swt.SWTResourceManager;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 *
 */

public abstract class AbstractControl<C> extends Composite implements ISWTControl {

    protected final Logger logger = Logger.getLogger(getClass());
    
    
    /**
     * The controller
     */
    private ComponentController controller;
    
    /**
     * The model
     */
    //private ComponentModel model;
    
    
    private boolean anotherDataSource;
    
    public AbstractControl(Composite parent, int style) {
	super(parent, style);
	
    }
 
    /**
     * Initialize the control
     *
     */
    public void init() {
	
    }

    /**
     * Get the controller
     * @return
     */
    protected ComponentController getController() {
	if (controller == null) {
	    controller = createController();
	}
	return controller;
    }
    
    /**
     * Create the controller
     * @return
     */
    protected ComponentController createController() {
	ComponentController controller = new ComponentController(this);
	controller.setModel(createModel());
	//controller.setModel(getModel());
	return controller;
    }
    
    /**
     * Get the model
     * @return
     */
    protected ComponentModel getModel() {
	return getController().getModel();
	
//	if (model == null) {
//	    model = createModel();
//	}
//	return model;
    }
    
    /**
     * Create the model
     * @return
     */
    protected ComponentModel createModel() {
	return new ComponentModel();
    }
    
    
    
    
    public Object getModelValue() {
	return getModel().getValue();
    }
    
 
    public void setModelValue(Object value) {
	getModel().setValue(value);
    }
    
    
    
    
    public Object getValue() {
	return getModelValue();
    }
    
 
    public void setValue(Object value) {
	setModelValue(value);
    }
    
    
    
    
    
    public void setValueClass(Class valueClass) {
	getModel().setValueClass(valueClass);
    }
    
    public Class getValueClass() {
	return getModel().getValueClass();
    }

    public void setAssociationValueClass(Class valueClass) {
	getModel().setAssociationValueClass(valueClass);
    }
    
    public Class getAssociationValueClass() {
	return getModel().getAssociationValueClass();
    }
    
    public Object getEntity() {
        return getModel().getEntity();
    }

    public void setEntity(Object entity) {
	getModel().setEntity(entity);
    }

    public Class getEntityClass() {
        return getModel().getEntityClass();
    }

    public void setEntityClass(Class entityClass) {
	getModel().setEntityClass(entityClass);
    }
    
    
    public Object getParentEntity() {
        return getModel().getParentEntity();
    }

    public void setParentEntity(Object parentEntity) {
	getModel().setParentEntity(parentEntity);
    }
    
    
    
    public Serializable getParentEntityId() {
        return getModel().getParentEntityId();
    }

    public void setParentEntityId(Serializable parentEntityId) {
	getModel().setParentEntityId(parentEntityId);
    }    
    
    public String getValueProperty() {
        return getModel().getValueProperty();
    }

    public void setValueProperty(String valueProperty) {
	getModel().setValueProperty(valueProperty);
    }

    
    public String getKeyValueProperty() {
        return getModel().getKeyValueProperty();
    }

    public void setKeyValueProperty(String keyValueProperty) {
	getModel().setKeyValueProperty(keyValueProperty);
    }
    
    
    public String getDisplayValueProperty() {
        return getModel().getDisplayValueProperty();
    }

    public void setDisplayValueProperty(String displayValueProperty) {
	getModel().setDisplayValueProperty(displayValueProperty);
    }    
    
    public String getControlProperty() {
        return getModel().getControlProperty();
    }

    public void setControlProperty(String controlProperty) {
	getModel().setControlProperty(controlProperty);
    }
    
    
    public void setProperty(String name, Object value) throws ApplicationException{
	getController().setProperty(name, value);
    }
    
    public Object getProperty(String name) throws ApplicationException {
        return getController().getProperty(name);
    }
    
    public void updateView() {
	getController().updateView();
    }
    
    public void updateModel() {
	getController().updateModel();
    }

       
    public boolean setFocus() {
	checkWidget();
	if (getUIControl() == null) {
	    return false;
	}
        return getUIControl().setFocus();
    }
    
    
    public void setDataList(List dataList) {
	getModel().setDataList(dataList);
    }
    
    public List getDataList() {
	return getModel().getDataList();
    }
    
    
    public boolean isModify() {
	return getModel().isModify();
    }
    
    public void setModify(boolean modify) {
	getModel().setModify(modify);
    }
    
    public void resetModify() {
	getModel().resetModify();
    }
    
    public void resetValue() {
	getModel().resetValue();
    }

    /*
    protected boolean equalsModelAndValue() {
	return getModel().equalsValues(getModel().getValue(), getValue());
    }
    */
    
    public void commit() {
	if (!getModel().isStartEdit()) {
	    return;
	}
	getModel().setValue(getValue());
	getModel().endEdit();
    }

    public boolean isAnotherDataSource() {
        return anotherDataSource;
    }

    public void setAnotherDataSource(boolean anotherDataSource) {
        this.anotherDataSource = anotherDataSource;
    }
    
    public String getValuePropertyDescription() {
        return getModel().getValuePropertyDescription();
    }

    public void setValuePropertyDescription(String valuePropertyDescription) {
	getModel().setValuePropertyDescription(valuePropertyDescription);
    } 

    public boolean isRequired() {
        return getModel().isRequired();
    }

    public void setRequired(boolean required) {
        getModel().setRequired(required);
    }   
    
    public boolean isReadOnly() {
        return getModel().isReadOnly();
    }

    public void setReadOnly(boolean readOnly) {
	getModel().setReadOnly(readOnly);
    }
    
    protected int getFixHeight() {
	// STUB !!!;
	return 15;
    }
    
    
    //// Send when value was changed (invoke setValue())
    
    public void addValueChangeListener(ValueChangeListener listener) {
	getModel().addValueChangeListener(listener);
    }
    
    public void removeValueChangeListener(ValueChangeListener listener) {
	getModel().removeValueChangeListener(listener);
    }

    public void notifyValueChangeListener(ValueChangeEvent event) {
	getModel().notifyValueChangeListeners(event);
    }

    //// Send when control changed value (important for Combo control: select[list], select[list-form], edit[edit-form], delete[delete button])
    
    public void addUpdateListener(UpdateListener listener) {
	getModel().addUpdateListener(listener);
    }
    
    public void removeUpdateListener(UpdateListener listener) {
	getModel().removeUpdateListener(listener);
    }

    public void notifyUpdateListener(UpdateEvent event) {
	getModel().notifyUpdateListeners(event);
    }

    //// Send when data list was loaded (invoke loadData()). But it is not setDataList method 
    
    public void addLoadListener(LoadListener listener) {
	getModel().addLoadListener(listener);
    }
    
    public void removeLoadListener(LoadListener listener) {
	getModel().removeLoadListener(listener);
    }
    
    public void notifyLoadListener(LoadEvent event) {
	getModel().notifyLoadListeners(event);
    }
    
    ////
    
    protected Image getImage(String path) {
	return SWTResourceManager.getImage(getClass(), path);
    }
    
    protected static Image getResourceImage(Class<?> clazz, String path) {
	return SWTResourceManager.getImage(clazz, path);
    }
    
    public void setEnabled (boolean enabled) {
	super.setEnabled(enabled);
	setReadOnly(!enabled);
    }

}
