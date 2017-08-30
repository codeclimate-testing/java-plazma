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

import java.text.Format;


import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;

/** 
 * @author Oleh Hapon
 *
 */

public interface ITableProvider<R> {
    
    /** Set entity class to presentation info **/
    void setEntityClass(Class entityClass);
    
    /** Return entity class **/
    Class getEntityClass();
    
    //
    
    void bindColumn(int index, String propertyName);
    
    void bindColumn(int index, String propertyName, Class valueClass);

    void bindColumn(int index, String propertyName, Format valueFormat);
    
    void bindColumn(int index, String propertyName, Class valueClass, Format valueFormat);
    
    
    void bindColumn(int index, ILabelProvider labelProvider);
    
    void bindColumn(int index, IValueProvider valueProvider);
    
    void bindColumn(int index, Class valueClass, IValueProvider valueProvider);
    
    //
    
    void bindColumn(String propertyName);
    
    void bindColumn(String propertyName, Class valueClass);

    void bindColumn(String propertyName, Format valueFormat);
    
    void bindColumn(String propertyName, Class valueClass, Format valueFormat);
    
    
    
    void bindColumn(ILabelProvider labelProvider);
    
    void bindColumn(IValueProvider valueProvider);
    
    void bindColumn(Class valueClass, IValueProvider valueProvider);
    
    //
    
    
    
    boolean isValid();

    // Only for non JFace variant
    void mapRow(R row, Object entity);
    
    
    String getCellText(R row, int columnIndex, Object entity);
    
    Image getCellImage(R row, int columnIndex, Object entity);
    
    Object getCellValue(R row, int columnIndex, Object entity);
    
    
    
    /** Return format by index of column **/
    Format getColumnFormat(int index);
    
    /** Return class by index of column **/
    Class getColumnClass(int index);
    
    /** Return property name by index of column **/
    String getColumnPropertyName(int index);
    
    
    String[] getColumnPropertyNames();
    
    
    int indexOfRow(R row);
    
    
    
    int getColumnCount();
    
    
    /** Return image to presentation boolean values **/
    Image getBooleanImage();

    /** Set image to presentation boolean values **/
    void setBooleanImage(Image booleanImage);
    
}
