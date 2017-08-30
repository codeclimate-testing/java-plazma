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
 * Created on 16.02.2008
 *
 */

package org.plazmaforge.bsolution.base.client.swt.dialogs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.plazmaforge.framework.core.exception.ApplicationException;


/** 
 * @author Oleh Hapon
 * $Id: PropertyManager.java,v 1.4 2010/12/05 07:57:20 ohapon Exp $
 */

public class PropertyManager {

    private String fileName;
    
    private Properties properties;
    
    

    public PropertyManager() {
	super();
    }
    
    
    public PropertyManager(String fileName) {
	this(fileName, false);
    }
    
    public PropertyManager(String fileName, boolean forceCreateFile) {
	super();
	this.fileName = fileName;
	if (fileName != null && forceCreateFile) {
	    File file = new File(fileName);
	    if (!file.exists()) {
		try {
		    file.createNewFile();
		} catch (Exception ex) {
		    ex.printStackTrace();
		}
		
	    }
	}
    }



    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public void load() throws ApplicationException {
	try {
	    getProperties().load(new FileInputStream(getFileName()));
	} catch (Exception e) {
	    throw new ApplicationException(e);
	}
    }

    public void store() throws ApplicationException {
	try {
	    getProperties().store(new FileOutputStream(getFileName()), "");
	} catch (Exception e) {
	    throw new ApplicationException(e);
	}
    }
    
    public Properties getProperties() {
	if (properties == null) {
	    properties = createProperties();
	}
        return properties;
    }
    
    public Properties createProperties() {
	return new Properties();
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
    
    public void setProperty(String key, String value) {
	getProperties().setProperty(key, value);
    }
    
    public String getProperty(String key) {
	return getProperties().getProperty(key);
    }
    
    public List<PropertyElement> getPropertyList() {
	List<PropertyElement> list = new ArrayList<PropertyElement>();
	Properties properties = getProperties();
	Set keySet = properties.keySet();
	if (keySet == null || keySet.isEmpty()) {
	    return list;
	}
	Iterator itr = keySet.iterator();
	PropertyElement element = null;
	while (itr.hasNext()) {
	    String key = (String) itr.next();
	    String value = properties.getProperty(key);
	    element = new PropertyElement(key, value); 
	    list.add(element);
	}
	return list;
    }
    
}
