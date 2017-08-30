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

package org.plazmaforge.framework.datawarehouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.StringUtils;
import org.plazmaforge.framework.util.ValueConverter;

public class TransferTriggerAdapter implements ITransferTrigger {

    private Connection connection;
    
    protected ResultSet rs;
    
    private ValueConverter converter;
    
    
    public void init() throws ApplicationException, SQLException {
	
    }
    
    public void dispose() throws ApplicationException, SQLException{
	
    }

    
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void doBeforeInsert(TransferEvent event) throws ApplicationException, SQLException {
    }

    public void doAfterInsert(TransferEvent event) throws ApplicationException, SQLException {
    }

    public void doBeforeUpdate(TransferEvent event) throws ApplicationException, SQLException {
    }

    public void doAfterUpdate(TransferEvent event) throws ApplicationException, SQLException {
    }

    public void doBeforeDelete(TransferEvent event) throws ApplicationException, SQLException {
    }

    public void doAfterDelete(TransferEvent event) throws ApplicationException, SQLException {
    }

    protected Object getValue(TransferEvent event, int columnIndex) {
	if (event == null) {
	    return null;
	}
	return getValue(event.row, columnIndex);
    }

    protected String getStringValue(TransferEvent event, int columnIndex) {
	return (String) getValue(event, columnIndex);
    }

    protected Object getValue(Object[] row, int columnIndex) {
	if (row == null || columnIndex < 0) {
	    return null;
	}
	return row[columnIndex];
    }

    protected String getStringValue(Object[] row, int columnIndex) {
	return (String) getValue(row, columnIndex);
    }

    protected Object getLookupId(PreparedStatement lookupStm, Object[] row, int columnIndex, Map<String, Object> map, Integer defLookupId) throws SQLException {
	Object lookupId = defLookupId; // Default Id
	String lookupValue = getStringValue(row, columnIndex);
	if (StringUtils.isEmpty(lookupValue)) {
	    return lookupId;
	}
	lookupId = map.get(lookupValue);
	if (lookupId != null) {
	    return lookupId;
	}
	lookupStm.setObject(1, lookupValue);
	close(rs);
	rs = lookupStm.executeQuery();
	if (rs.next()) {
	    lookupId = rs.getObject(1);
	    map.put(lookupValue, lookupId);
	} else {
	    // TODO
	    lookupId = defLookupId;
	}
	return lookupId;
    }

    protected void close(ResultSet rs) {
	if (rs == null) {
	    return;
	}
	try {
	    rs.close();
	} catch (SQLException ex) {
	    //
	}
    }
    
    protected void close(Statement stm) {
	if (stm == null) {
	    return;
	}
	try {
	    stm.close();
	} catch (SQLException ex) {
	    //
	}
    }
    
    public ValueConverter getConverter() {
	if (converter == null) {
	    converter = new ValueConverter();
	}
        return converter;
    }

}
