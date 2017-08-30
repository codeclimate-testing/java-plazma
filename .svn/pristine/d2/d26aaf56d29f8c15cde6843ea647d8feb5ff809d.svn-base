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

package org.plazmaforge.framework.util;

import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.plazmaforge.framework.core.exception.ApplicationException;

public class CloneUtils {

    
    
    public static Object cloneObject(Object originalObject) throws ApplicationException {
	if (originalObject == null) {
	    return null;
	}
	if (!(originalObject instanceof Serializable)) {
	    return null;
	}
	try {
	    
	    
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ObjectOutputStream oos = new ObjectOutputStream(baos);  
	    oos.writeObject(originalObject);
	    oos.close();
	    
	    byte[] data = baos.toByteArray();
	    
	    ByteArrayInputStream bais = new ByteArrayInputStream(data);
	    ObjectInputStream ois = new ObjectInputStream(bais); 
	    Object cloneObject = ois.readObject();
	    
	    return cloneObject;
	} catch (IOException ex) {
	    throw new ApplicationException(ex);
	    
	} catch (ClassNotFoundException ex) {
	    throw new ApplicationException(ex);
	}
    }
    
    
    public static Object copyObject(Object originalObject, CopyReseter reseter, boolean isRecreateCollection) throws ApplicationException {
	Object copyObject = cloneObject(originalObject);
	if (copyObject == null) {
	    return null;
	}
	
	// Reset object because copy is not clone
	if (reseter != null) {
	    reseter.resetObject(copyObject);
	}
	
	// Recreate collection because type of original collection can be bad
	if (isRecreateCollection) {
	    recreateCollections(copyObject, reseter);
	}
	
	return copyObject;
    }
    
    
    public static void recreateCollections(Object obj, CopyReseter reseter) throws ApplicationException {
	if (obj == null) {
	    return;
	}
	PropertyDescriptor[] props = ClassUtilsExt.getBeanCollectionProperties(obj.getClass());
	for (int i = 0; i < props.length; i++) {

	    PropertyDescriptor desc = props[i];
	    Class type = desc.getPropertyType();
	    Method readMethod = desc.getReadMethod();
	    Method writeMethod = desc.getWriteMethod();

	    if (readMethod == null || writeMethod == null) {
		continue;
	    }

	    Object value = ClassUtilsExt.getBeanValue(readMethod, obj);
	    if (!(value instanceof Collection)) {
		continue;
	    }

	    Collection collection = (Collection) value;

	    resetCollection(collection, reseter);
	    Object cloneCollection = cloneCollection(collection, type);
	    ClassUtilsExt.setBeanValue(writeMethod, obj, cloneCollection);

	}

    }
    
    
    public static void resetCollection(Collection collection, CopyReseter reseter) {
	if (collection == null || reseter == null) {
	    return;
	}
	Iterator itr = collection.iterator();
	while (itr.hasNext()) {
	    reseter.resetObject(itr.next());
	}
    }
    
    public static Collection cloneCollection(Collection collection, Class type) throws ApplicationException {
	if (collection == null) {
	    return null;
	}
	if (collection instanceof List ) {
	    
	    if (type.isInterface()) {
		return cloneList((List) collection);
	    }
	    return (Collection) ClassUtilsExt.getClassInstance(type);
	}
	
	// TODO: STUB
	// Must add Set
	return collection;
    }
    
    public static List cloneList(List list) {
	if (list == null) {
	    return null;
	}
	List newList = new ArrayList();
	newList.addAll(list);
	return newList;
    }
    
    
    public static interface CopyReseter {
	
	void resetObject(Object obj);
    }

}
