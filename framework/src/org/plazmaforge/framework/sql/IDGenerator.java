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

package org.plazmaforge.framework.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.plazmaforge.framework.sql.dialect.Dialect;
import org.plazmaforge.framework.sql.dialect.DialectFactory;
import org.plazmaforge.framework.util.DBUtils;


/**
 * ID Generator (Primary Key)
 * 
 * @author ohapon
 *
 */
public class IDGenerator {

    public static String INCREMENT_STRATEGY = "INCREMENT";
    
    public static String SEQUENCE_STRATEGY = "SEQUENCE";

    public static String UUID_STRATEGY = "UUID";

    /**
     * Name of table
     */
    private String tableName;
    
    /**
     * Name of PK column
     */
    private String columnName;
    
    /**
     * Name of sequence (only for SEQUENCE strategy)
     */
    private String sequenceName;
    
    /**
     * Current value of PK
     */
    private Object value;
    
    /**
     * Generate PK Strategy
     */
    private String strategy = INCREMENT_STRATEGY;
    
    
    ////
    private boolean isFirstCall = true; 
    
    
    private PreparedStatement selectStm;
    
    private Dialect dialect;
    
    /**
     * Initialize generator
     */
    public void init() {
	value = null;
    }

    /**
     * Initialize first call
     * @param connection
     * @throws SQLException
     */
    protected void initFirstCall(Connection connection) throws SQLException {
	
	
	if (INCREMENT_STRATEGY.equals(strategy)) {
	
	    // INCREMENT
	    String sql = getMaxValueSQL(tableName, columnName);
	    selectStm = connection.prepareStatement(sql);
	    value = getValue(selectStm);
	} else if (SEQUENCE_STRATEGY.equals(strategy)) {
	    
	    // SEQUENCE
	    String sql = getNextValueSQL(connection, sequenceName);
	    selectStm = connection.prepareStatement(sql);
	}
	
	
    }
    
    /**
     * Dispose generator (close resources)
     */
    public void dispose() {
	value = null;
	DBUtils.close(selectStm);
    }

    /**
     * Generate ID value
     * @param connection
     * @return
     * @throws SQLException
     */
    public Object generateId(Connection connection) throws SQLException {
	
	// Initialize first call
	if (isFirstCall) {
	    isFirstCall = false;
	    initFirstCall(connection);
	}
	
	if (INCREMENT_STRATEGY.equals(strategy)) {
	    if (value != null && value instanceof Number) {
		int incrementValue = ((Number) value).intValue();
		incrementValue++;
		value = incrementValue;
	    }
	} else if (SEQUENCE_STRATEGY.equals(strategy)) {
	    value = getValue(selectStm);
	} else if (UUID_STRATEGY.equals(strategy)) {
	    //TODO
	}
	
	return value;
    }
    
    
    
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getSequenceName() {
        return sequenceName;
    }

    public void setSequenceName(String sequenceName) {
        this.sequenceName = sequenceName;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    
    
    /**
     * Return MAX value SQL by table and column
     */
    private String getMaxValueSQL(String tableName, String columnName) {
	return "SELECT MAX(" + columnName + ") FROM " + tableName;
    }
    
    /**
     * Return next value SQL by sequence 
     * @param connection
     * @param sequenceName
     * @return
     */
    private String getNextValueSQL(Connection connection, String sequenceName) throws SQLException {
	if (dialect == null) {
	    dialect = getDialect(connection);
	}
	if (dialect == null) {
	    throw new SQLException("SQL Dialect is null");
	}
	return dialect.getSequenceNextValString(sequenceName);
    }

    
    /**
     * Get value
     * @param stm
     * @return
     * @throws SQLException
     */
    private Object getValue(PreparedStatement stm) throws SQLException {
	ResultSet rs = null;
	try {
	    rs = stm.executeQuery();
	    if (rs.next()) {
		return rs.getObject(1);
	    }
	} finally {
	    DBUtils.close(rs);
	}
	return null;
    }
    
    /**
     * Return true if strategy is SQL strategy (increment, sequence...)
     * @return
     */
    private boolean isSQLStrategy() {
	return (INCREMENT_STRATEGY.equals(strategy) || SEQUENCE_STRATEGY.equals(strategy));
    }

    private Dialect getDialect(Connection connection) throws SQLException {
	return DialectFactory.getDialect(connection);
    }
}
