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
 * Created on 27.03.2008
 *
 */

package org.plazmaforge.framework.report.data;

import java.io.Serializable;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/** 
 * @author Oleh Hapon
 * $Id: DataService.java,v 1.2 2010/04/28 06:34:33 ohapon Exp $
 */

public class DataService {
    
    private static String ID_PARAMETER = "ID";
    
    private static String CONNECTION_PARAMETER = "REPORT_CONNECTION";
    
    
    
    private static Map<Object, ReportContext> contextMap = new HashMap<Object, ReportContext>();
    
    private static String idParameter = ID_PARAMETER;
    
    private static String connectionParameter = CONNECTION_PARAMETER;
    
    private static EntityLoader entityLoader;

    /**
     * Return value by complex name. (Entity.Attribute)
     * For example MyEntity.Attribute1, MyEntity.Attribute2...  
     * @param parameters
     * @param complexName
     * @return
     */
    public static Object getValue(Map parameters, String complexName) {
	return getValue(parameters, complexName, null);
    }

    /**
     * Return value by complex name and id. (Entity.Attribute)
     * For example MyEntity.Attribute1, MyEntity.Attribute2...  
     * @param parameters
     * @param complexName
     * @param id
     * @return
     */
    public static Object getValue(Map parameters, String complexName, Serializable id) {
	if (parameters == null || complexName == null) {
	    return null;
	}
	complexName = complexName.trim();
	int len = complexName.length(); 
	if (len == 0) {
	    return null;
	}
	int index = complexName.indexOf(".");
	if (index < 1 || index == len - 1) {
	    return null;
	}
	String entityName = complexName.substring(0, index); 
	String entityAttribute = complexName.substring(index + 1);
	return getValue(parameters, entityName, entityAttribute, id);
    }
    
    /**
     * Return value by entity name and attribute name.
     * @param parameters
     * @param entityName
     * @param entityAttribute
     * @return
     */
    public static Object getValue(Map parameters, String entityName, String entityAttribute) {
	return getValue(parameters, entityName, entityAttribute, null);
    }
    
    /**
     * Return value by entity name, attribute name, id
     * @param parameters
     * @param entityName
     * @param entityAttribute
     * @param id
     * @return
     */
    public static Object getValue(Map parameters, String entityName, String entityAttribute, Serializable id) {
	if (parameters == null || entityName == null || entityAttribute == null) {
	    return null;
	}
	Object obj = null;
	if (id == null) {
	    obj = parameters.get(getIdParameter());
	    if (obj == null || (!(obj instanceof Serializable))) {
		return null;
	    }
	    id = (Serializable) obj;
	}
	obj = parameters.get(getConnectionParameter());
	if (obj == null || (!(obj instanceof Connection))) {
	    return null;
	}
	Connection cn = (Connection) obj;
	Object key = System.identityHashCode(parameters); //parameters.hashCode();
	// We have problems with using hashCode()
	
	ReportContext reportContext = getReportContext(key);
	
	DataEntity entity = getEntity(cn, reportContext, entityName, id);
	if (entity == null) {
	    return null;
	}

	return entity.getValue(entityAttribute);
    }
    
    private static ReportContext getReportContext(Object key) {
	ReportContext reportContext = (ReportContext) contextMap.get(key);
	if (reportContext == null) {
	    reportContext = new ReportContext();
	    contextMap.put(key, reportContext);
	}
	return reportContext;
    }
    

    private static DataEntity getEntity(Connection cn, ReportContext reportContext, String entityName, Serializable id) {
	entityName = entityName.toUpperCase().trim(); //
	DataEntity entity = reportContext.getEntity(entityName, id);
	if (entity == null) {
	    entity = loadEntity(cn, entityName, id);
	}
	return entity;
	
    }
    
    private static DataEntity loadEntity(Connection cn, String entityName, Serializable id) {
	if (entityLoader == null) {
	    entityLoader = new EntityLoaderImpl();
	}
	try {
	    return entityLoader.loadEntity(cn, entityName, id);
	} catch (Throwable ex) {
	    ex.printStackTrace();
	}
	return null;
    }

    
    public static void setConnectionParameter(String connectionParameter) {
        DataService.connectionParameter = connectionParameter;
    }

    public static void setIdParameter(String idParameter) {
        DataService.idParameter = idParameter;
    }

    public static String getConnectionParameter() {
        return connectionParameter;
    }

    public static String getIdParameter() {
        return idParameter;
    }

    public static void setEntityLoader(EntityLoader entityLoader) {
        DataService.entityLoader = entityLoader;
    }
    
    
}
