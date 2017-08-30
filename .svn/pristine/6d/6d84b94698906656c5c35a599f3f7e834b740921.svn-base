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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.plazmaforge.framework.core.exception.ApplicationException;



/** 
 * @author Oleh Hapon
 * $Id: EntityLoaderImpl.java,v 1.3 2010/12/05 07:51:32 ohapon Exp $
 */

public class EntityLoaderImpl implements EntityLoader {

  
    private static String STRING_TYPE = "STRING";

    private static String INTEGER_TYPE = "INTEGER";

    private static String FLOAT_TYPE = "FLOAT";

    private static String DATE_TYPE = "DATE";

    private static String DATETIME_TYPE = "DATETIME";

    private static String BOOLEAN_TYPE = "BOOLEAN";

    private static String DICTIONARY_TYPE = "DICTIONARY";
   
    private static String DEFAULT_QUERY = "SELECT "
	    + " A.NAME,"
	    + " A.DATA_TYPE_ID,"
	    + " V.STRING_VALUE,"
	    + " V.INTEGER_VALUE,"
	    + " V.FLOAT_VALUE,"
	    + " V.DATE_VALUE"
	    + " FROM SYS_ENTITY_ATTR A"
	    + " INNER JOIN SYS_ENTITY_ATTR_VALUE V ON A.ID = A.ATTR_ID"
	    + " WHERE A.ENTITY_ID = ? AND V.OWNER_ID = ?";
    
    
    private String query;
    
    public String getQuery() {
	if (query == null) {
	    query = DEFAULT_QUERY;
	}
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public DataEntity loadEntity(Connection cn, String entityName, Serializable id) throws ApplicationException {
	if (cn == null || entityName == null || id == null || (!(id instanceof Integer))) {
	    return null;
	}
	DataEntity entity = new DataEntity();
	entity.setId(id);
	entity.setName(entityName);
	entity.setStatus("Created");
	
	String query = getQuery();
	
	PreparedStatement stm = null;
	ResultSet rs = null;
	try {
	    stm = cn.prepareStatement(query);
	    stm.setString(1, entityName);
	    stm.setInt(2, ((Integer) id).intValue());
	    
	    rs = stm.executeQuery();
	    while (rs.next()) {
		String name = rs.getString(1);
		String dataType = rs.getString(2);
		dataType = dataType == null ? null : dataType.trim();
		
		int index = 0;
		Object value = null;
		
		
		if (INTEGER_TYPE.equals(dataType)) {
		    index = 4;
		    value = rs.getInt(index);
		} else if (FLOAT_TYPE.equals(dataType)) {
		    index = 5;
		    value = rs.getFloat(index);
		} else if (DATE_TYPE.equals(dataType)) {
		    index = 6;
		    value = rs.getDate(index);
		} else if (BOOLEAN_TYPE.equals(dataType)) {
		    // Emulate boolean type.
		    // Get integer and convert it to boolean.
		    index = 4;
		    Integer integerValue = rs.getInt(index);
		    value = integerValue.intValue() == 1 ? Boolean.TRUE : Boolean.FALSE;
		} else {
		    index = 3;
		    value = rs.getString(index);
		}
		
		DataAttribute attribute = new DataAttribute();
		attribute.setName(name);
		attribute.setValue(value);
		entity.addAttribute(attribute);
		
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	} finally {
	    if (rs != null) {
		try {
		    rs.close();
		} catch (SQLException ex) {
		    
		}
	    }
	    if (stm != null) {
		try {
		    stm.close();
		} catch (SQLException ex) {
		    
		}
	    }
	    
	}
	return entity;
    }
    
  
}
