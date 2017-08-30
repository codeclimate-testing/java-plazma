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


import org.apache.log4j.Logger;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.ClassUtilsExt;

/** 
 * @author Oleh Hapon
 *
 */

public class ComponentController {

    protected final Logger logger = Logger.getLogger(getClass());
    
    /**
     * The control.
     */
    private Object control;
    
    private ComponentModel model;
    
    
    public ComponentController(Object control) {
	super();
	this.control = control;
    }

    
    public void configure() {
	//initValueClass();
    }
    
    public void initValueClass() {
	if (getValueClass() != null) {
	    return;
	}
	try {
	    Class klass = ClassUtilsExt.getBeanPropertyType(getEntityClass(), getValueProperty());
	    initValueClass(klass);
	} catch (Exception ex) {
	    logger.error(ex);
	}
    }
    
    
    public Object getControl() {
        return control;
    }
    

    public Object getProperty(String name) throws ApplicationException {
	if (getControl() == null) {
	    return null;
	}
	return ClassUtilsExt.getBeanValue(getControlClass(), name, getControl());
    }

    public void setProperty(String name, Object value) throws ApplicationException {
	if (getControl() == null) {
	    return;
	}
	ClassUtilsExt.setBeanValue(getControlClass(), name, getControl(), value);
    }

    public void updateView() {
	Class controlClass = null;
	String controlProperty = null;
	try {
	    controlClass = getControlClass();
	    controlProperty = getControlProperty();
	    ClassUtilsExt.setBeanValue(controlClass, controlProperty, getControl(), getEntityValue());
	} catch (Exception ex) {
	    logger.error(ex + " (ControlClass=" + controlClass + ", ControlProperty="  + controlProperty + ")");
	}
    }
    
    public void updateModel() {
	//if (isReadOnly()) {
	//    return;
	//}
	Class entityClass = null;
	String valueProperty = null;
	try {
	    
	    entityClass = getEntityClass();
	    valueProperty = getValueProperty();
	    ClassUtilsExt.setBeanValue(entityClass, valueProperty, getEntity(), getControlValue());
	} catch (Exception ex) {
	    logger.error(ex + " (EntityClass=" + entityClass + ", ValueProperty="  + valueProperty + ")");
	}	
    }
    
    protected Object getEntityValue() throws Exception {
	if (getModel() == null || getEntityClass() == null || getEntity() == null) {
	    return null;
	}
	
	if (getValueClass() == null) {
	    initValueClass();
	}
	Object value = ClassUtilsExt.getBeanValue(getEntityClass(), getValueProperty(), getEntity());
	
	return value;
    }
    
    protected void initValueClass(Class valueClass) {
	try {
	    ClassUtilsExt.setBeanValue(getControlClass(), "valueClass", getControl(), valueClass);
	} catch (Exception ex) {
	    logger.error(ex);
	}
	
    }
    
    protected Object getControlValue() throws ApplicationException {
	return ClassUtilsExt.getBeanValue(getControlClass(), getControlProperty(), getControl());
    }
    
   
    
    public ComponentModel getModel() {
        return model;
    }

    public void setModel(ComponentModel model) {
        this.model = model;
    }    

    
    
    
    public void setValueClass(Class valueClass) {
	getModel().setValueClass(valueClass);
    }

    public Class getValueClass() {
	return getModel().getValueClass();
    }
    
    
    public void setValueProperty(String valueProperty) {
	getModel().setValueProperty(valueProperty);
    }
    
    public String getValueProperty() {
	return getModel().getValueProperty();
    }
    
    

    public void setControlProperty(String controlProperty) {
	getModel().setControlProperty(controlProperty);
    }

    protected String getControlProperty() {
	String prop = getModel().getControlProperty();
	if (prop != null) {
	    return prop;
	}
	return "value";
    }


    
    public void setEntity(Object entity) {
	getModel().setEntity(entity);
    }
    
    public Object getEntity() {
	return getModel().getEntity();
    }

    public void setEntityClass(Class entityClass) {
	getModel().setEntityClass(entityClass);
    }
    
    public Class getEntityClass() {
	return getModel().getEntityClass();
    }    

    
    public Class getControlClass() {
	return getControl().getClass();
    }    

    public boolean isReadOnly() {
        return getModel().isReadOnly();
    }

    public void setReadOnly(boolean readOnly) {
	getModel().setReadOnly(readOnly);
    }
    
}
