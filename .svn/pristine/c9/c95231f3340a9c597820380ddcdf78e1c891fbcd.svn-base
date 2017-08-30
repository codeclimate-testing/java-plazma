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

import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 *
 */

public interface IControl {
    
    public static String REQUIRED_MARKER = "*";
    
    public static String REQUIRED_MARKER_STRING = " " + REQUIRED_MARKER;
    
    void init();
    
    void setProperty(String name, Object value) throws ApplicationException;
    
    Object getProperty(String name) throws ApplicationException; 
    
    
    void setEntity(Object entity);
    
    Object getEntity();
    
    
    
    void setEntityClass(Class entityClass);
    
    Class getEntityClass(); 
    
    
    
    
    void setValueProperty(String valueProperty);
    
    String getValueProperty();
    
    
    
    void setValueClass(Class valueClass);
    
    Class getValueClass();
    
    
    void setValue(Object value);
    
    Object getValue();
    
    
    
    void setControlProperty(String controlProperty);
    
    String getControlProperty();
    
    
    void updateView();
    
    void updateModel();
    
    void resetValue();
    
    boolean isModify();
    
    void resetModify();
    
    boolean isAnotherDataSource();
    
    boolean isRequired();
    
    void setRequired(boolean required);
    
    void setValuePropertyDescription(String description);
    
    String getValuePropertyDescription();
}
