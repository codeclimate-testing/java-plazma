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

package org.plazmaforge.framework.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.plazmaforge.framework.util.DBUtils;



public class AbstractSQLExecutor implements SQLExecutor {

    /** Connection * */
    protected Connection connection;

    /** SQL Builder * */
    private SQLBuilder builder;

    /**
     * Set <code>Connection</code>
     */
    public void setConnection(Connection connection) throws SQLException {
	this.connection = connection;
	builder = new SQLBuilder();
	builder.init(connection);
    }

    /**
     * Get <ciode>SQLBuilder</code>
     * 
     * @return
     */
    protected SQLBuilder getBuilder() {
	if (builder == null) {
	    builder = new SQLBuilder();
	}
	return builder;
    }

    public void close(Statement stm) {
	DBUtils.close(stm);
    }

    public void close(ResultSet rs) {
	DBUtils.close(rs);
    }

    /**
     * Create statement
     * 
     * @return
     * @throws SQLException
     */
    protected Statement createStatement() throws SQLException {
	return connection.createStatement();
    }

    protected PreparedStatement prepareStatement(String sql) throws SQLException {
	return connection.prepareStatement(sql);
    }

    protected int nextValue(Connection cn, String sequenceName) throws SQLException {
	return getBuilder().nextValue(cn, sequenceName);
    }

    protected int nextValueByTable(Connection cn, String tableName, String columnName)  throws SQLException {
	return getBuilder().nextValueByTable(cn, tableName, columnName);
    }

    /**
     * Get SQL Next Value Function
     * 
     * @return
     */
    protected String getNextValueSQL(String sequenceName) {
	return getBuilder().getNextValueSQL(sequenceName);
    }

    protected String getIfNullInt(String fieldName) {
	return getBuilder().getIfNullInt(fieldName);
    }

    protected String getIfNullDouble(String fieldName) {
	return getBuilder().getIfNullDouble(fieldName);
    }

    protected String getIfNullString(String fieldName) {
	return getBuilder().getIfNullString(fieldName);
    }

    protected String getAddOprInt(String fieldName1, String fieldName2) {
	return getBuilder().getAddOprInt(fieldName1, fieldName2);
    }

    protected String getAddOprDouble(String fieldName1, String fieldName2) {
	return getBuilder().getAddOprDouble(fieldName1, fieldName2);
    }

    protected String getIfNull(String fieldName, String nullValue) {
	return getBuilder().getIfNull(fieldName, nullValue);
    }

}
