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
 * Created on 22.04.2006
 *
 */

package org.plazmaforge.framework.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.plazmaforge.framework.sql.dialect.Dialect;
import org.plazmaforge.framework.sql.dialect.DialectFactory;
import org.plazmaforge.framework.util.DBUtils;



/**
 * <code>SQL Builder</code>
 * 
 * @author hapon
 * 
 */
public class SQLBuilder {


    private Dialect dialect;
    
    public void init(Connection cn) throws SQLException {
	dialect = getDialect(cn);
    }
    
    public void setDialect(Dialect dialect) {
        this.dialect = dialect;
    }
    
    public Dialect getDialect() {
        return dialect;
    }

    public Dialect getDialect(boolean check) {
	if (check && dialect == null) {
	    throw new RuntimeException("SQL Dialect is null");
	}
        return dialect;
    }
    
    protected Dialect getDialect(Connection cn) throws SQLException {
	if (dialect == null) {
	    dialect = DialectFactory.getDialect(cn);
	    if (dialect == null) {
		throw new SQLException("SQL Dialect is null");
	    }
	}
	return dialect;
    }
    
    protected int nextValueByTable(Connection cn, String tableName, String columnName) throws SQLException {
	String sql = getMaxValueSQL(tableName, columnName);
	PreparedStatement selectStm = null;
	try {
	    selectStm = cn.prepareStatement(sql);
	    Object value = getValue(selectStm);
	    if (value != null && value instanceof Number) {
		int incrementValue = ((Number) value).intValue();
		incrementValue++;
		return incrementValue;
	    }
	} finally {
	    DBUtils.close(selectStm);
	}
	return 0;
    }

    protected int nextValue(Connection cn, String sequenceName) throws SQLException {
	String sql = getNextValueSQL(cn, sequenceName);
	PreparedStatement selectStm = null;
	try {
	    selectStm = cn.prepareStatement(sql);
	    Object value = getValue(selectStm);
	    if (value != null && value instanceof Number) {
		int intValue = ((Number) value).intValue();
		return intValue;
	    }
	} finally {
	    DBUtils.close(selectStm);
	}
	return 0;
    }

    protected String getNextValueSQL(String sequenceName) {
	return getDialect(true).getSequenceNextValString(sequenceName);
    }

    protected String getIfNullInt(String fieldName) {
	return getIfNull(fieldName, "0");
    }

    protected String getIfNullDouble(String fieldName) {
	return getIfNull(fieldName, "0.0");
    }

    protected String getIfNullString(String fieldName) {
	return getIfNull(fieldName, "''");
    }

    protected String getAddOprInt(String fieldName1, String fieldName2) {
	return getIfNullInt(fieldName1) + " + " + getIfNullInt(fieldName2);
    }

    protected String getAddOprDouble(String fieldName1, String fieldName2) {
	return getIfNullDouble(fieldName1) + " + " + getIfNullDouble(fieldName2);
    }

    /**
     * Get SQL IFNUL Function
     * 
     * @param fieldName
     * @param nullValue
     * @return
     */
    protected String getIfNull(String fieldName, String nullValue) {
	// TODO: Stub for Firebird. Must use DAOEnvironment
	return " COALESCE(" + fieldName + ", " + nullValue + ")";
    }

    /**
     * Return MAX value SQL by table and column
     */
    protected String getMaxValueSQL(String tableName, String columnName) {
	return "SELECT MAX(" + columnName + ") FROM " + tableName;
    }
    
    /**
     * Return next value SQL by sequence 
     * @param connection
     * @param sequenceName
     * @return
     */
    protected String getNextValueSQL(Connection connection, String sequenceName) throws SQLException {
	if (dialect == null) {
	    dialect = getDialect(connection);
	}
	
	return dialect.getSequenceNextValString(sequenceName);
    }

    protected Object getValue(PreparedStatement stm) throws SQLException {
	ResultSet rs = null;
	try {
	    rs = stm.executeQuery();
	    if (rs.next()) {
		return rs.getObject(1);
	    }
	} finally {
	    if (rs != null) {
		rs.close();
	    }
	}
	return null;
    }
    
}
