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
package org.plazmaforge.framework.client.swing.gui.table;


import java.beans.PropertyDescriptor;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.IntrospectionException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.ClassUtilsExt;



/**
 * @author Oleh Hapon
 * Date: 8.10.2003
 * Time: 14:27:53
 */
public class ObjectTableModel extends AbstractStateTableModel {

    private Method[] objectMethods;

    private Map methodsMap;


    public Object getValueAt(int row, int col) {
        Object record = getRowObject(row);
        if (record == null) return null;
        return getFieldValue(record, col);
    }



    protected Object getFieldValue(Object record, int col) {
        Object value = null;
        try {
            value = objectMethods[col].invoke(record,null);
        } catch (Exception ex) {
            return null;
        }
        return value;
    }

    public void createObjectProperties(Class klass) throws ApplicationException {
        try {
            BeanInfo info = Introspector.getBeanInfo(klass);
            PropertyDescriptor[] objectProperties = info.getPropertyDescriptors();

            ArrayList methods = new ArrayList();
            methodsMap = new HashMap();
            for(int j = 0; j < columns.length; j++) {
                String name = columns[j].getFieldName();
                Method method = null;
                for(int i = 0; i < objectProperties.length; i++) {
                    if (name.equals(objectProperties[i].getName())) {
                        PropertyDescriptor d = objectProperties[i];
                        method = d.getReadMethod();
                        break;
                    }
                }
                methods.add(method);
                //methodsMap.put(name, method);
            }
            objectMethods = (Method[]) methods.toArray(new Method[0]);

            for(int i = 0; i < objectProperties.length; i++) {
                PropertyDescriptor d = objectProperties[i];
                methodsMap.put(d.getName(), d.getReadMethod());
            }

        } catch (IntrospectionException ex) {
            if (columns != null) {
                objectMethods = new Method[columns.length];
            }
            throw new ApplicationException(ex);
        }
    }

    public void createObjectProperties(String className) throws ApplicationException  {
        try {
            Class klass = ClassUtilsExt.forName(className);
            createObjectProperties(klass);
        } catch (ClassNotFoundException ex) {
            throw new ApplicationException(ex);
        }
    }

    public void createObjectProperties(Object obj) throws ApplicationException {
        createObjectProperties(obj.getClass());
    }

    protected Object getFindValue(ColumnParameter parameter, Object data) {
        if (parameter == null || data == null) {
            return null;
        }
        String fieldName = parameter.getColumnName();
        if (fieldName == null) {
            return null;
        }
        Method method = (Method) methodsMap.get(fieldName);
        if (method == null) {
            return null;
        }
        try {
            return method.invoke(data, null);
        } catch (Exception ex) {
            //
        }
        return null;

    }


}
