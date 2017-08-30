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

/* 
 * Created on 15.08.2007
 *
 */

package org.plazmaforge.bsolution.base.client.swt.forms.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.plazmaforge.framework.client.Environment;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.Toolkit;
import org.plazmaforge.framework.client.controls.IControl;
import org.plazmaforge.framework.client.forms.IListForm;
import org.plazmaforge.framework.client.models.UpdateEvent;
import org.plazmaforge.framework.client.models.UpdateListener;
import org.plazmaforge.framework.client.swt.controls.XCheckBox;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.controls.XIntegerField;
import org.plazmaforge.framework.client.swt.controls.XNumberField;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.ext.association.Association;
import org.plazmaforge.framework.ext.association.AssociationManager;
import org.plazmaforge.framework.ext.model.DataType;
import org.plazmaforge.framework.ext.model.IStringPresentation;
import org.plazmaforge.framework.ext.service.Service;
import org.plazmaforge.framework.ext.service.ServiceFactory;


/** 
 * @author Oleh Hapon
 * $Id: DataTypeController.java,v 1.6 2010/06/21 07:36:20 ohapon Exp $
 */

public class DataTypeController {

    private XTextField stringValueField;

    private XIntegerField integerValueField;

    private XNumberField floatValueField;

    private XDateCombo dateValueField;

    private XDateCombo dateTimeValueField;

    private XCheckBox booleanValueField;

    private EntityField entityValueField;
    
    

    private List<Composite> controlList;

    private Map<String, Composite> controlMap;

    private DataType dataType;
    
    
    public DataTypeController(Composite parent) {

	// STRING
	stringValueField = new XTextField(parent, SWT.BORDER);
	
	// INTEGER
	integerValueField = new XIntegerField(parent, SWT.BORDER);
	integerValueField.setValueClass(Integer.class);
	
	// FLOAT
	floatValueField = new XNumberField(parent, SWT.BORDER);
	floatValueField.setValueClass(Float.class);
	
	// DATE
	dateValueField = new XDateCombo(parent, SWT.BORDER);
	
	// DATETIME
	dateTimeValueField = new XDateCombo(parent, SWT.BORDER);
	
	// BOOLEAN
	booleanValueField = new XCheckBox(parent, SWT.NONE);
	
	// DICTIONARY, DOCUMENT, PROJECT, TASK ...
	entityValueField = new EntityField(parent, SWT.NONE);
	 
	controlList = new ArrayList<Composite>();
	controlList.add(stringValueField);
	controlList.add(integerValueField);
	controlList.add(floatValueField);
	controlList.add(dateValueField);
	controlList.add(dateTimeValueField);
	controlList.add(booleanValueField);
	controlList.add(entityValueField);

	controlMap = new HashMap<String, Composite>();
	controlMap.put(DataType.STRING_TYPE, stringValueField);
	controlMap.put(DataType.INTEGER_TYPE, integerValueField);
	controlMap.put(DataType.FLOAT_TYPE, floatValueField);
	controlMap.put(DataType.DATE_TYPE, dateValueField);
	controlMap.put(DataType.DATETIME_TYPE, dateTimeValueField);
	controlMap.put(DataType.BOOLEAN_TYPE, booleanValueField);
	controlMap.put(DataType.REFERENCE_TYPE, entityValueField);

	initControls();
    }
    
    protected void initControls() {
	for (Composite control : controlList){
	    initControl(control);
	}
    }
    
    protected void initControl(Composite control) {
	GridData gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	gridData.widthHint = 250;
	control.setLayoutData(gridData);
    }
    
    
    public List<Composite> getControls() {
	return controlList;
    }

    public Composite getControl() {
	return getControlByDataType(getDataType());
    }

    public Composite getControlByDataType(DataType dataType) {
	if (dataType == null) {
	    return null;
	}
	String key = dataType.getId();
	if (key != null) {
	    key = key.trim();
	}
	return controlMap.get(key);
    }

    public void invisibleControls() {
	for (Composite control : controlList){
	    setControlVisible(control, false);
	}
    }

    public void setDataType(DataType dataType) {
	this.dataType = dataType;
	invisibleControls();
	Composite control = getControlByDataType(dataType);
	if (control == null) {
	    return;
	}
	setControlVisible(control, true);
    }
    
    protected void setControlVisible(Composite control, boolean visible) {
	control.setVisible(visible);
	GridData gd = (GridData) control.getLayoutData();
	gd.exclude = !visible;
    }

    public DataType getDataType() {
	return this.dataType;
    }

    
    ////
    
    public Object getValue() {
	Composite control = getControl();
	if (control == null) {
	    return null;
	}
	
	if (control instanceof IControl) {
	    return ((IControl) control).getValue();
	} else if (control instanceof EntityField) {
	    return ((EntityField) control).getValue();
	}
	
	return null;
	
    }

    public void setValue(Object value) {
	Composite control = getControl();
	if (control == null) {
	    return;
	}
	if (value == null) {
	    return; // TODO: Must be reset
	}
	
	if (control instanceof IControl) {
	    ((IControl) control).setValue(value);
	} else if (control instanceof EntityField) {
	    ((EntityField) control).setValue(value);
	}
    }
    
    ////
    
    public IEntityConfig getEntity() {
	Composite control = getControl();
	if (control == null) {
	    return null;
	}
	
	if (control instanceof EntityField) {
	    return ((EntityField) control).getEntity();
	}
	
	return null;
	
    }

    
    public void setEntity(IEntityConfig entity) {
	Composite control = getControl();
	if (control == null) {
	    return;
	}
	
	if (control instanceof EntityField) {
	    ((EntityField) control).setEntity(entity);
	}
    }    
    
    class EntityField extends Composite {

	private List<IEntityConfig> entities;

	private String entityId;
	
	private Association association;
	
	
	private XComboEdit entityField;
	 
	private XComboEdit valueField;
	

	public EntityField(Composite arg0, int arg1) {
	    super(arg0, arg1);
	    
	    GridLayout gridLayout = new GridLayout();
	    gridLayout.marginBottom = 0;
	    gridLayout.marginTop = 0;
	    gridLayout.marginLeft = 0;
	    gridLayout.marginRight = 0;
	    gridLayout.marginWidth = 0;
	    
	    gridLayout.numColumns = 1;
	    setLayout(gridLayout);
	    
	    GridData gridData = null;
		
	    entityField = new XComboEdit(this, SWT.BORDER);
	    gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
	    entityField.setLayoutData(gridData);
	    
	    valueField = new XComboEdit(this, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	    gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
	    valueField.setLayoutData(gridData);

	    loadEntities();
	    
	    initEntityField();
	    initValueField();

	}
	
	protected void loadEntities() {
	    entities = Toolkit.getEntityConfigListByTypeAndForm("DICTIONARY");
	}
	
	protected IEntityConfig getEntityById(String entityId) {
	    if (entityId == null) {
		return null;
	    }
	    if (entities == null || entities.isEmpty()) {
		return null;
	    }
	    for (IEntityConfig e: entities) {
		if (entityId.equals(getEntityId(e))) {
		    return e;
		}
	    }
	    return null;
	}
	
	protected void initEntityField() {
	    
	    entityField.setDataList(entities);
	    entityField.addUpdateListener(new UpdateListener() {
		 public void update(UpdateEvent evt) {
		     IEntityConfig entity = (IEntityConfig) entityField.getValue();
		     updateEntity(entity);
		 }
	    });
	}
	
	protected void initValueField() {
	    valueField.setDisplayValueProperty(IStringPresentation.STRING_PRESENTATION_PROPERTY);
	}
	
	protected Association getAssociationByEntity(IEntityConfig entity) {
	    if (entity == null) {
		return null;
	    }
	    try {
		return AssociationManager.getAssociationByEntity(entity);
	    } catch (Exception ex) {
		ex.printStackTrace();
	    }
	    return null;
	}
	
	
	protected Class getAssociationElementByType(Association association, Class type) {
	    if (association == null || type == null) {
		return null;
	    }
	    return association.getElementByType(type);
	}

	
	protected Object getService() {
	    Class serviceClass = getAssociationElementByType(association, Service.class);
	    if (serviceClass == null) {
		return null;
	    }
	    return ServiceFactory.getService(serviceClass);
	}
	
	protected Object loadObjectById(Serializable id) {
	    if (id == null) {
		return null;
	    }
	    Object service = getService();
	    if (service == null) {
		return null;
	    }
	    try {
		return Environment.getEntityManager().loadEntityById(service, id);
	    } catch (Exception ex) {
		ex.printStackTrace();
	    }
	    return null;
	}
	
	protected void updateEntity(IEntityConfig entity) {
	    association = getAssociationByEntity(entity);
	    Class listFormClass = getAssociationElementByType(association, IListForm.class);
	    valueField.setListFormClass(listFormClass);
	    
	}

	protected String getEntityId(IEntityConfig entity) {
	    return entity == null ? null :  entity.getConfigId();
	}
	
	////
	
	public void setEntityId(String entityId) {
	    IEntityConfig entity = getEntityById(entityId);
	    entityField.setValue(entity);
	    updateEntity(entity);
	}
	
	public String getEntityId() {
	    IEntityConfig entity = (IEntityConfig) entityField.getValue();
	    return getEntityId(entity);
	}
	
	////
	
	public void setEntity(IEntityConfig entity) {
	    entityField.setValue(entity);
	    updateEntity(entity);
	}
	
	public IEntityConfig getEntity() {
	    return (IEntityConfig) entityField.getValue();
	}
	
	////

	
	public void setValue(Object value) {
	    Serializable recordId = (Serializable) value;
	    Object obj = loadObjectById(recordId);
	    valueField.setValue(obj);
	}
	
	public Object getValue() {
	    return valueField.getValue();
	}
	
    }
    
}
