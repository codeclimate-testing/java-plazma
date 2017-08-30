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

package org.plazmaforge.framework.client.controls;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.plazmaforge.framework.client.models.IDataModel;
import org.plazmaforge.framework.client.models.LoadEvent;
import org.plazmaforge.framework.client.models.LoadListener;
import org.plazmaforge.framework.client.models.UpdateEvent;
import org.plazmaforge.framework.client.models.UpdateListener;
import org.plazmaforge.framework.client.models.ValueChangeEvent;
import org.plazmaforge.framework.client.models.ValueChangeListener;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.ClassUtilsExt;
import org.plazmaforge.framework.util.StringUtils;


/** 
 * @author Oleh Hapon
 *
 */

public class ComponentModel implements IDataModel {
    
    

    private static int REQUIRED_MARKER_STRING_LEN = IControl.REQUIRED_MARKER_STRING == null ? 0: IControl.REQUIRED_MARKER_STRING.length();
    
    /**
     * The entity have value.
     */
    private Object entity;
    
    
    private Class entityClass;
     
    
    
    
    /**
     * The name of value property (property: country, method: get/setCountry)
     */
    private String valueProperty;
    
    
    /**
     * The name of key value property (property: id, method: get/setId)
     */
    private String keyValueProperty;
    

    /**
     * The name of display value property (property: name, method: get/setName)
     */
    private String displayValueProperty;
    
    
    /**
     * The name of parent key value property (property: parentId, method: get/setParentId)
     */
    private String parentKeyValueProperty;
    
    
    
    
    /**
     * The name of control property (property: text, method: get/setText)
     */
    private String controlProperty;
    
    
    
    
    /**
     * The class of value
     */
    private Class valueClass;
    

    /**
     * The class of key value
     */
    private Class keyValueClass;
    

    /**
     * The class of display value
     */
    private Class displayValueClass;
    
    /**
     * The class of association. Use for create corresponding classes: forms, actions, services.
     */
    private Class associationValueClass;   
    
    
    /**
     * The name of value class
     */
    private String valueClassName;    
    
    
    /**
     * The edit value
     */
    private Object value;
    
    
    /**
     * The old value
     */
    private Object oldValue;
    
    
    
    private Serializable parentEntityId;
    
    private Object parentEntity;
    
    
    /**
     * The data list of values
     */
    private List dataList = new ArrayList();
    
    
    /**
     * The data map of key/display values
     */
    private Map dataMap = new LinkedHashMap();
    
    
    private Map refMap = new HashMap();
    
    private boolean initValueState;
    
    
    private boolean startEdit;
    
    private Boolean modify;


    private String nullTextValue = DEFAULT_NULL_TEXT_VALUE;
    
    private Map propertyMap = new HashMap();
    
    
    private String valuePropertyDescription;
    
    private boolean required;
    
    private boolean readOnly;
    
    private List<ValueChangeListener> valueChangeListeners = new ArrayList<ValueChangeListener>();
    
    private List<UpdateListener> updateListeners = new ArrayList<UpdateListener>();
    
    private List<LoadListener> loadListeners = new ArrayList<LoadListener>();
    
    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
	boolean isInit = initValueState;
	Object oldValue = this.value;
	eventValue(value);
        this.value = value;
	ValueChangeEvent event = new ValueChangeEvent(this, "value", oldValue, value);
	event.isInitValueState = isInit;
	notifyValueChangeListeners(event);
    }

    
    public Object getOldValue() {
        return oldValue;
    }

    public void setOldValue(Object oldValue) {
        this.oldValue = oldValue;
    }

    public Class getValueClass() {
        return valueClass;
    }

    public void setValueClass(Class valueClass) {
        this.valueClass = valueClass;
    }
    
    public Class getKeyValueClass() {
        return keyValueClass;
    }

    public void setKeyValueClass(Class keyValueClass) {
        this.keyValueClass = keyValueClass;
    }
    
    public Class getDisplayValueClass() {
        return displayValueClass;
    }

    public void setDisplayValueClass(Class displayValueClass) {
        this.displayValueClass = displayValueClass;
    }

    
    public String getValueClassName() {
        return valueClassName;
    }

    public void setValueClassName(String valueClassName) {
        this.valueClassName = valueClassName;
    }

    
    

    
    
    public String getKeyValueProperty() {
	if (keyValueProperty == null) {
	    keyValueProperty = DEFAULT_KEY_PROPERTY;
	}
        return keyValueProperty;
    }

    public void setKeyValueProperty(String keyValueProperty) {
        this.keyValueProperty = keyValueProperty;
    }
    
    public String getDisplayValueProperty() {
	if (displayValueProperty == null) {
	    displayValueProperty = DEFAULT_DISPLAY_PROPERTY;
	}
        return displayValueProperty;
    }

    public void setDisplayValueProperty(String displayValueProperty) {
        this.displayValueProperty = displayValueProperty;
    }

    public String getValueProperty() {
        return valueProperty;
    }

    public void setValueProperty(String valueProperty) {
        this.valueProperty = valueProperty;
    }

    public String getParentKeyValueProperty() {
	if (parentKeyValueProperty == null) {
	    return parentKeyValueProperty = DEFAULT_PARENT_KEY_PROPERTY;
	}
        return parentKeyValueProperty;
    }

    public void setParentKeyValueProperty(String parentKeyValueProperty) {
        this.parentKeyValueProperty = parentKeyValueProperty;
    }

    public Object getEntity() {
        return entity;
    }

    public void setEntity(Object entity) {
        this.entity = entity;
    }


    public Class getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class entityClass) {
        this.entityClass = entityClass;
    }
    

    public Object getParentEntity() {
        return parentEntity;
    }

    public void setParentEntity(Object parentEntity) {
        this.parentEntity = parentEntity;
    }

    
    public Serializable getParentEntityId() {
        return parentEntityId;
    }

    public void setParentEntityId(Serializable parentEntityId) {
        this.parentEntityId = parentEntityId;
    }

    public String getControlProperty() {
        return controlProperty;
    }

    public void setControlProperty(String controlProperty) {
        this.controlProperty = controlProperty;
    }
    
    
    public boolean isEmptyDataList() {
	return dataList == null || dataList.size() == 0;
    }
    
    public List getDataList() {
        return dataList;
    }

    public void setDataList(List dataList) {
        this.dataList = dataList;
    }
    
    public void addDataValue(Object value) {
	if (dataList == null) {
	    dataList = new ArrayList();
	}
	dataList.add(value);
    }
    
    public void addDataValue(int index, Object value) {
	if (dataList == null) {
	    dataList = new ArrayList();
	}
	dataList.add(index, value);
    }
    
    public boolean isEmptyDataMap() {
	return dataMap == null || dataMap.size() == 0;
    }   
    
    public Map getDataMap() {
        return dataMap;
    }

    
    public void addDataValue(Object keyValue, Object displayValue) {
	addDataValue(keyValue);
	if (dataMap == null) {
	    dataMap = new LinkedHashMap();
	}
	dataMap.put(keyValue, displayValue);
    }    
    
    public void addDataValue(int index, Object keyValue, Object displayValue) {
	addDataValue(value, index);
	if (dataMap == null) {
	    dataMap = new LinkedHashMap();
	}
	dataMap.put(keyValue, displayValue);
    }
    
    public void setDataMap(Map dataMap) {
        this.dataMap = dataMap;
        if (dataMap == null) {
            return;
        }
        boolean isEmtyDataList = isEmptyDataList();
        Set keys = dataMap.keySet();
        for (Object key : keys) {
            if (isEmtyDataList || (!isEmtyDataList && indexOfDataValue(key) < 0)) {
        	Object displayValue = dataMap.get(key);
        	if (displayValue != null) {
        	    addDataValue(displayValue);
        	}
            }
        }
    }
    
    public int indexOfDataValue(Object value) {
	if (value == null || dataList == null) {
	    return -1;
	}
	int size = dataList.size();
	for (int i = 0; i < size; i++) {
	    Object dataValue = dataList.get(i);
	    if (dataValue == null) {
		continue;
	    }
	    if (value.equals(dataValue)) {
		return i;
	    }
	}
	return -1;
    }

    
    public Object getDataValue(int index) {
	if (dataList == null) {
	    return null;
	}
	if (index < 0 || index >= dataList.size()) {
	    return null;
	}
	return dataList.get(index);
    }

    public void addValue(Object value) {
	addDataValue(value);
    }
    
    public void addValue(Object keyValue, Object displayValue) {
	addDataValue(keyValue, displayValue);
    }  
    
    
    public void addValue(int index, Object value) {
	addDataValue(index, value);
    }
    
    public void addValue(int index, Object keyValue, Object displayValue) {
	addDataValue(index, keyValue, displayValue);
    }      
    
    public Object getValue(int index) {
	return getDataValue(index);
    }

    public Object getKeyValue(int index) {
	return getDataValue(index);
    }

    public Object getDisplayValue(int index) {
	Object keyValue = getKeyValue(index);
	return getDisplayValue(keyValue);
    }
    
    public Object getDisplayValue(Object keyValue) {
	if (keyValue == null) {
	    return null;
	}
	if (!isEmptyDataMap()) {
	    return dataMap.get(keyValue);
	}
	try {
	    Object displayValue = ClassUtilsExt.getBeanValue(keyValue.getClass(), getDisplayValueProperty(), keyValue);
	    return displayValue;
	} catch (ApplicationException ex) {
	    //
	}
	return null;
    }
    
    public String getDisplayText(Object value) {
	if (value == null) {
	    return getNullTextValue();
	}
	Object displayValue = getDisplayValue(value);
	if (displayValue != null) {
	    return displayValue.toString();
	}

	if (isSimpleDisplayValue()) {
	    return value.toString(); 
	}
	return getNullTextValue();
    }
    
    protected boolean isSimpleDisplayValue() {
	return isEmptyDataMap() && displayValueProperty == null;
    }
    
    public String getFormatText(Object value) {
	if (value == null) {
	    return getNullTextValue();
	}
	return value.toString();
    }
    
    public Object getObjectKeyValue(Object value) {
	if (value == null) {
	    return null;
	}	
	try {
	    Object keyValue = ClassUtilsExt.getBeanValue(value.getClass(), getKeyValueProperty(), value);
	    return keyValue;
	} catch (ApplicationException ex) {
	    //
	}
	return null;
    }
    
    
    public Object getObjectDisplayValue(Object value) {
	if (value == null) {
	    return null;
	}
	try {
	    Object displayValue = ClassUtilsExt.getBeanValue(value.getClass(), getDisplayValueProperty(), value);
	    return displayValue;
	} catch (ApplicationException ex) {
	    //
	}
	return null;
    }
    
    public Object getObjectParentKeyValue(Object value) {
	if (value == null) {
	    return null;
	}	
	try {
	    Object keyValue = ClassUtilsExt.getBeanValue(value.getClass(), getParentKeyValueProperty(), value);
	    return keyValue;
	} catch (ApplicationException ex) {
	    //
	}
	return null;
    }
    
    
    public void removeAllValues() {
	if (dataList != null) {
	    dataList.clear();
	}
	if (dataMap != null) {
	    dataMap.clear();
	}
    }
    
    public void removeValue(int index) {
	if (!isEmptyDataMap()) {
	    Object keyValue = getKeyValue(index);
	    if (keyValue != null) {
		dataMap.remove(keyValue);
	    }
	}
	if (!isEmptyDataList()) {
	    dataList.remove(index);
	}
    }
    
    
    public boolean equalsValues(Object value1, Object value2) {
	Object v1 = normalizeValue(value1);
	Object v2 = normalizeValue(value2);
	
	if (v1 == null && v2 == null) {
	    return true;
	}
	if (v1 == null || v2 == null) {
	    return false;
	}
	return v1.equals(v2);
	
    }
    
    protected Object normalizeValue(Object value) {
	if (value == null) {
	    return value;
	}
	if (value instanceof String) {
	    String stringValue = (String) value;
	    if ("".equals(stringValue)) {
		return null;
	    } else {
		return value;
	    }
	}
	return value;
    }
    
    public final boolean isModify() {
	// STUB
	if (modify != null) {
	    return modify;
	}
	//return equalsValues(getOldValue(), getValue());
	return false;
    }
    
    public final void setModify(boolean modify) {
	this.modify = modify;
    }
    
    public void resetModify() {
	this.modify = null;
    }

    public boolean isInitValueState() {
        return initValueState;
    }

    /*
    public void setInitValueState(boolean initValueState) {
        this.initValueState = initValueState;
    }
    */
    
    protected void eventValue(Object newValue) {

	
	if (initValueState) {
	    setOldValue(getValue());
	} else {
	    setOldValue(newValue);
	    initValueState = true;
	}
	startEdit();
    }
    
    protected void initValue(Object newValue) {
	setOldValue(newValue);
	setValue(newValue);
    }    
    
    public void resetValue() {
	Object defaultValue = createDefaultValue();
	initValue(defaultValue);
	initValueState = false;
    }
    
    protected Object createDefaultValue() {
	return null;
    }
    
    public void setProperty(Object key, Object value) {
	propertyMap.put(key, value);
    }
    
    public Object getProperty(Object key) {
	return propertyMap.get(key);
    }

    public Class getAssociationValueClass() {
	if (associationValueClass == null) {
	    return this.getValueClass();
	}
        return associationValueClass;
    }

    public void setAssociationValueClass(Class associationValueClass) {
        this.associationValueClass = associationValueClass;
    }

    public boolean isStartEdit() {
        return startEdit;
    }

    public void startEdit() {
        this.startEdit = true;
    }
    
    public void endEdit() {
        this.startEdit = false;
    }
    
    public void setRefValue(Object keyValue, Object refValue) {
	refMap.put(keyValue, refValue);
    }
    
    
    public Object getRefValue(Object keyValue) {
	if (refMap.isEmpty()) {
	    return keyValue;
	}
	return refMap.get(keyValue);
    }
    
    public String getNullTextValue() {
        return nullTextValue;
    }

    public void setNullTextValue(String nullTextValue) {
        this.nullTextValue = nullTextValue;
    }
 
    
    
    

    public String getValuePropertyDescription() {
	if (StringUtils.isEmpty(valuePropertyDescription)) {
	    return getValueProperty();
	}
        return valuePropertyDescription;
    }

    public void setValuePropertyDescription(String valuePropertyDescription) {
	if (valuePropertyDescription == null) {
	    this.valuePropertyDescription = null;
	    return;
	}
	// Clear string: delete special marker (*)
	if (isRequired() && valuePropertyDescription.endsWith(IControl.REQUIRED_MARKER_STRING)) {
	    this.valuePropertyDescription = valuePropertyDescription.substring(0, valuePropertyDescription.length() - REQUIRED_MARKER_STRING_LEN);
	    return;
	}
        this.valuePropertyDescription = valuePropertyDescription;
    }
    

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }    
    
    
    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public void addValueChangeListener(ValueChangeListener listener) {
	this.valueChangeListeners.add(listener);
    }
    
    public void removeValueChangeListener(ValueChangeListener listener) {
	this.valueChangeListeners.remove(listener);
    }

    public void notifyValueChangeListeners(ValueChangeEvent event) {
	for (ValueChangeListener listener : valueChangeListeners) {
	    listener.valueChange(event);
	}
    }

    ////
    
    
    public void addUpdateListener(UpdateListener listener) {
	this.updateListeners.add(listener);
    }
    
    public void removeUpdateListener(UpdateListener listener) {
	this.updateListeners.remove(listener);
    }

    public void notifyUpdateListeners(UpdateEvent event) {
	for (UpdateListener listener : updateListeners) {
	    listener.update(event);
	}
    }

    ////
    
    public void addLoadListener(LoadListener listener) {
	this.loadListeners.add(listener);
    }
    
    public void removeLoadListener(LoadListener listener) {
	this.loadListeners.remove(listener);
    }

    public void notifyLoadListeners(LoadEvent event) {
	for (LoadListener listener : loadListeners) {
	    listener.load(event);
	}
    }
    
    public void sortByParent(List dataList){
	if (dataList == null || dataList.isEmpty()) {
	    return;
	}
	String parentKeyValueProperty = getParentKeyValueProperty();
	if (StringUtils.isEmpty(parentKeyValueProperty)) {
	    return;
	}
	try {
	    Object value = dataList.get(0);
	    if (value != null) {
		// Get method. If error then return
		ClassUtilsExt.getBeanReadMethod(value.getClass(), parentKeyValueProperty);
	    }
	} catch (Exception ex) {
	    return;
	}
	Collections.sort(dataList, new ParentComparator());
    }
    
    private class ParentComparator implements Comparator {
	
	public int compare(Object o1, Object o2) {
	    if (o1 == null && o2 == null) {
		return 0;
	    }
	    if (o1 == null) {
		return -1;
	    }
	    if (o2 == null) {
		return 1;
	    }

	    Object p1 = getObjectParentKeyValue(o1);
	    Object p2 = getObjectParentKeyValue(o2);
	    if (p1 == null && p2 == null) {
		return 0;
	    }
	    if (p1 == null) {
		return -1;
	    }
	    if (p2 == null) {
		return 1;
	    }
	    if (p1 instanceof Comparable) {
		return ((Comparable) p1).compareTo(p2);
	    } else if (p2 instanceof Comparable) {
		return ((Comparable) p2).compareTo(p1);
	    }
	    return 0;
	}
	
	public boolean equals(Object obj) {
	    if (obj == null) {
		return false;
	    }
	    if (this == obj) {
		return true;
	    }
	    if (obj.getClass() != ParentComparator.class) {
		return false;
	    }
	    return true;
	}
    }
    
}
