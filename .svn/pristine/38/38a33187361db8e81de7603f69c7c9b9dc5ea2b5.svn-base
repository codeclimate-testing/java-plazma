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


/** 
 * @author Oleh Hapon
 *
 */

public class ControlProxy extends ComponentController implements IControl {

    private boolean anotherDataSource;
    
    public ControlProxy(Object control) {
	super(control);
    }
    
    public void init() {
	
    }
    
    
    public void setControlProperty(String controlProperty) {
	getModel().setControlProperty(controlProperty);
    }
    
    public String getControlProperty() {
	return getModel().getControlProperty();
    }
    
    
    
    public void setValue(Object value) {
	getModel().setValue(value);
    }
    
    public Object getValue() {
	return getModel().getValue();
    }
    

    public void resetValue() {
	getModel().resetValue();
    }
    
    public boolean isModify() {
	return getModel().isModify();
    }
    
    public void resetModify() {
	getModel().resetModify();
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
}
