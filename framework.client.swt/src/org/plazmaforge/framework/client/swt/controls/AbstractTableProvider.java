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

import java.lang.reflect.Method;
import java.text.Format;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.plazmaforge.framework.client.swt.SWTResourceManager;
import org.plazmaforge.framework.util.ClassUtilsExt;


public abstract class AbstractTableProvider<R> implements ITableProvider<R> {

    
    public static final String EMPTY_STRING = "";
    
    private List<ColumnConfig> columns = new ArrayList<ColumnConfig>();
    
    private Class entityClass;
    
    private boolean invalidate = true;
    
    private boolean valid;
    
    private Image booleanImage;
    
    
    protected class ColumnConfig {
	
	int index;
	
	String propertyName;
	
	Class valueClass;
	
	Method method;
	
	Format valueFormat;
	
	ILabelProvider labelProvider;
	
	IValueProvider valueProvider;
	
	boolean valid;
	
	boolean invalidate = true;
	
	
	boolean hasText = true;
	
	boolean hasImage;
	
	
	public boolean isValid() {
	    if (invalidate) {
		invalidate = false;
		
		
		// If we use label provider we ignore property name, entity class, method, value class and etc. 
		if (labelProvider != null || valueProvider != null) {
		    valid = true;
		    return valid;
		}
		
		
		valid = false;
		
		if (propertyName != null && entityClass != null) {
		    String name = propertyName.trim();
		    int lenght = name.length();
		    if (lenght > 0) {
			
			try {
			    method = ClassUtilsExt.getBeanReadMethod(entityClass, propertyName);
			    if (valueClass == null) {
				valueClass = method.getReturnType(); 
			    }
			    valid = true;
			} catch (Exception ex) {
			    //
			}
		    }
		}
		
	    }
	    return valid;
	}
	

    }
    
    protected ColumnConfig getColumnConfig(int index) {
	for (ColumnConfig c : columns) {
	    if (c == null) {
		continue;
	    }
	    if (c.index == index) {
		return c;
	    }
	}
	return null;
    }
    
    public boolean isValid() {
	if (invalidate) {
	    invalidate = false;
	    valid = false;
	    if (columns != null && columns.size() > 0 && entityClass != null) {
		valid = true;
	    }
	}
	return valid;
    }
    
    public Class getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class entityClass) {
        this.entityClass = entityClass;
    }
    
    
    

    public void bindColumn(int index, String propertyName) {
	bindColumn(index, propertyName, null, null);
    }
    
    public void bindColumn(int index, String propertyName, Class valueClass) {
	bindColumn(index, propertyName, valueClass, null);
    }

    public void bindColumn(int index, String propertyName, Format valueFormat) {
	bindColumn(index, propertyName, null, valueFormat);
    }
    
    public void bindColumn(int index, String propertyName, Class valueClass, Format valueFormat) {
	ColumnConfig config = new ColumnConfig();
	config.index = index;
	config.propertyName = propertyName;
	config.valueClass = valueClass;
	config.valueFormat = valueFormat;
	addColumnConfig(config);
	invalidate = true;
    }
    
    
    public void bindColumn(int index, ILabelProvider labelProvider) {
	ColumnConfig config = new ColumnConfig();
	config.index = index;
	config.labelProvider = labelProvider;
	addColumnConfig(config);
	invalidate = true;
    }

    
    public void bindColumn(int index, Class valueClass, IValueProvider valueProvider) {
	ColumnConfig config = new ColumnConfig();
	config.index = index;
	config.valueClass = valueClass;
	config.valueProvider = valueProvider;
	addColumnConfig(config);
	invalidate = true;
    }

    public void bindColumn(int index, IValueProvider valueProvider) {
	bindColumn(index, null, valueProvider);
    }
    
    //
    
    public void bindColumn(String propertyName) {
	bindColumn(-1, propertyName);
    }
    
    public void bindColumn(String propertyName, Class valueClass) {
	bindColumn(-1, propertyName, valueClass);
    }

    public void bindColumn(String propertyName, Format valueFormat) {
	bindColumn(-1, propertyName, valueFormat);
    }
    
    public void bindColumn(String propertyName, Class valueClass, Format valueFormat) {
	bindColumn(-1, propertyName, valueClass, valueFormat);
    }
    
    
    public void bindColumn(ILabelProvider labelProvider) {
	bindColumn(-1, labelProvider);
    }
  

    public void bindColumn(IValueProvider valueProvider) {
	bindColumn(-1, valueProvider);
    }

    public void bindColumn(Class valueClass, IValueProvider valueProvider) {
	bindColumn(-1, valueClass, valueProvider);
    }
    
    
    protected void addColumnConfig(ColumnConfig config) {
	if (config == null) {
	    return;
	}
	int index = config.index;
	if (index < 0) {
	    config.index = columns.size();
	    columns.add(config);
	    return;
	} else if (index < columns.size()) {
	    columns.set(index, config);
	    return;
	} else {
	    for (int i = columns.size(); i < index + 1; i++) {
		if (i == index) {
		    columns.add(config);
		} else {
		    columns.add(null);
		}
	    }
	}
    }
    
    protected boolean isExpression(String value) {
	if (value == null) {
	    return false;
	}
	return value.startsWith("${");
    }
    
    ////
    
    
    public Format getColumnFormat(int index) {
	ColumnConfig column = getColumnConfig(index);
	if (column == null) {
	    return null;
	}
	return column.valueFormat;
    }
    
    public Class getColumnClass(int index) {
	ColumnConfig column = getColumnConfig(index);
	if (column == null) {
	    return null;
	}
	return column.valueClass;
    }

    public String getColumnPropertyName(int index) {
	ColumnConfig column = getColumnConfig(index);
	if (column == null) {
	    return null;
	}
	return column.propertyName;
    }

    public String[] getColumnPropertyNames() {
	List<String> names = new ArrayList<String>();
	for (ColumnConfig c : columns) {
	    if (c == null) {
		continue;
	    }
	    names.add(c.propertyName);
	}
	return names.toArray(new String[0]);
    }

    public int getColumnCount() {
	return columns == null ? 0 : columns.size();
    }
    
    public Image getBooleanImage() {
	if (booleanImage == null) {
	    booleanImage = SWTResourceManager.getImage(this.getClass(), "/org/plazmaforge/framework/client/images/eclipse/task/showcomplete_tsk_m.gif");
	}
	return booleanImage;
    }

    public void setBooleanImage(Image booleanImage) {
        this.booleanImage = booleanImage;
    }

    public List<ColumnConfig> getColumns() {
        return columns;
    }
    
    ////
    
    public Object getValue(ColumnConfig column, Object entity) {
	try {
	    if (column.valueProvider != null) {
		return column.valueProvider.getValue(entity);
	    }
	    return ClassUtilsExt.getBeanValue(column.method, entity);
	} catch (Exception ex) {
	    
	}
	return null;
    }
    
    ////
    
    protected String getExpressionValue(R row, ColumnConfig column, Object entity) {
	if (row == null) {
	    return EMPTY_STRING;
	}
	String exp = column.propertyName;
	if ("${rowIndex}".equals(exp)) {
	    return String.valueOf(indexOfRow(row));
	} else if ("${rowNumber}".equals(exp)) {
	    return String.valueOf(indexOfRow(row) + 1);
	} else if ("${columnIndex}".equals(exp)) {
	    return String.valueOf(column.index);
	} else if ("${columnNumber}".equals(exp)) {
	    return String.valueOf(column.index + 1);
	}
	return EMPTY_STRING;
    }

    //TODO: You must use getCellValue method
    public String getCellText(R row, int columnIndex, Object entity) {
	ColumnConfig c = getColumnConfig(columnIndex);
	if (c == null) {
	    return null;
	}
	return getCellText(row, c, entity);
    }

    
    public String getCellText(R row, ColumnConfig column, Object entity) {
	
	
	// Use label provider
	if (column.labelProvider != null) {
	    return column.labelProvider.getText(entity);
	}
	

	// Use value provider
	if (column.valueProvider != null) {
	    try {
		//----------------------------------------------------
		// STUB
		// RETURN IF BOOLEAN VALUE
		if (ClassUtilsExt.isBoolean(column.valueClass)) {
		   return EMPTY_STRING; 
		}	
		//----------------------------------------------------
		
		Object value = column.valueProvider.getValue(entity);
		if (value == null) {
		    return EMPTY_STRING;
		}
		return value.toString();
	    } catch (Exception ex) {
		return EMPTY_STRING;
	    }
	}

	if (isExpression(column.propertyName)) {
	    return getExpressionValue(row, column, entity);
	}
	
	if (!isValid(entity, getEntityClass(), column)) {
	    return EMPTY_STRING;
	}
	
	//----------------------------------------------------
	// STUB
	// RETURN IF BOOLEAN VALUE
	if (ClassUtilsExt.isBoolean(column.valueClass)) {
	   return EMPTY_STRING; 
	}	
	//----------------------------------------------------

	try {
	    Object value = getValue(column, entity);
	    if (value == null) {
		return EMPTY_STRING;
	    }
	    if (column.valueFormat != null) {
		String textValue = column.valueFormat.format(value);
		return textValue;
	    }
	    return value.toString();
	} catch (Exception ex) {
	    
	}
	return EMPTY_STRING;
    }
    
    
    public Object getCellValue(R row, int index, Object entity) {
	ColumnConfig c = getColumnConfig(index);
	if (c == null) {
	    return null;
	}
	return getCellValue(row, c, entity);
    }
    
    public Object getCellValue(R row, ColumnConfig column, Object entity) {
	if (isExpression(column.propertyName)) {
	    return getExpressionValue(row, column, entity);
	}
	
	if (!isValid(entity, getEntityClass(), column)) {
	    return null;
	}
	return getValue(column, entity);
    }
    

    ////
    
    public Image getCellImage(R row, int index, Object entity) {
	ColumnConfig c = getColumnConfig(index);
	if (c == null) {
	    return null;
	}
	return getCellImage(row, c, entity);
    }
    
    public Image getCellImage(R row, ColumnConfig column, Object entity) {
	
	// Use label provider
	if (column.labelProvider != null) {
	    return column.labelProvider.getImage(entity);
	}

	
	if ( !isValid(entity, column) && column.valueProvider == null) {
	    return null;
	}
	
	Class valueClass = column.valueClass;
	if (valueClass == null) {
	    return null;
	}
	
	// STUB
	if (row == null) {
	    return null;
	}
	
	if (!ClassUtilsExt.isBoolean(valueClass)) {
	   return null; 
	}
	
	// Analyze boolean value
	Object value = getValue(column, entity);
	boolean booleanValue = false;
	if (value != null) {
	    booleanValue = Boolean.valueOf(value.toString()); 
	}
	
	// If boolean value is false then return
	if (!booleanValue) {
	    setRowDataImage(row, column.index, null);
	    return null;
	}
	
	// Auto creating image for boolean value
	Image image = getBooleanImage();
	setRowDataImage(row, column.index, image);
	
	// Return null because image is storeged to item data for using late
	return null;
	
	
	//return image;
	//return getTrImage(tableItem, image); 
    }
    
    ////

    protected abstract void setRowText(R row, int columnIndex, String text);
    
    protected abstract void setRowImage(R row, int columnIndex, Image image);
    
    protected abstract void setRowDataImage(R row, int columnIndex, Image image);
    
    ////
    
    protected boolean isValid(Object entity, Class entityClass, ColumnConfig column) {
	if (entity == null || getEntityClass() == null || !column.isValid() || column.method == null) {
	    return false;
	}
	return true;
    }
    
    protected boolean isValid(Object entity, ColumnConfig column) {
	if (entity == null || !column.isValid() || column.method == null) {
	    return false;
	}
	return true;
    }
   
    
    ////
    
    
    // Only for non JFace variant
    public void mapRow(R row, Object entity) {
	
	if (row == null || entity == null || getColumns() == null) {
	    return;
	}
	int count = getColumns().size();
	ColumnConfig column = null;
	int index = -1;
	for (int i = 0; i < count; i++) {
	    column = getColumns().get(i);
	    if (column == null) {
		continue;
	    }
	    
	    column.isValid();
	    
	    index = column.index;
	    Class valueClass = column.valueClass;
	    
	    //TODO: STUB
	    if (ClassUtilsExt.isBoolean(valueClass)) {
		setRowImage(row, index, getCellImage(row, column, entity));
		continue;
	    }
	    
	    if (column.hasText) {
		setRowText(row, index, getCellText(row, column, entity));
	    }
	    if (column.hasImage) {
		setRowImage(row, index, getCellImage(row, column, entity));
	    }
	}
    }


}
