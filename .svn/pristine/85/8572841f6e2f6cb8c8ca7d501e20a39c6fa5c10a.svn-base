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
 * Created on 16.09.2007
 *
 */

package org.plazmaforge.bsolution.base.server.services;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.plazmaforge.bsolution.base.common.services.TransferService;
import org.plazmaforge.framework.core.datastorage.DSDataSet;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.datawarehouse.FieldMapping;
import org.plazmaforge.framework.datawarehouse.SQLTransferHelper;
import org.plazmaforge.framework.datawarehouse.TransferInfo;
import org.plazmaforge.framework.datawarehouse.TransferResult;
import org.plazmaforge.framework.datawarehouse.convert.dataimport.IDataSetImporter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/** 
 * @author Oleh Hapon
 */

public class TransferServiceImpl extends JdbcDaoSupport implements TransferService {

   
    public String[][] getTableNames(String catalog, String schemaPattern, String tableNamePattern, String types[]) throws ApplicationException {
	
	ResultSet rs = null;
	try {
	    DatabaseMetaData md = getDatabaseMetaData();
	    rs = md.getTables(catalog, schemaPattern, tableNamePattern, types);
	    List<String> tables = new ArrayList<String>();
	    while (rs.next()) {
		String name = rs.getString(3);
		tables.add(name);
	    }
	    int size = tables.size();
	    String[][] names = new String[size][2];
	    for (int i = 0; i < size; i++) {
		names[i][0] = tables.get(i);
	    }
	    return names;
	} catch (SQLException ex) {
	    throw new ApplicationException(ex);
	} finally {
	    close(rs);
	}
    }
    
    public String[][] getTableNames()  throws ApplicationException {
	return getTableNames(null, null, null, new String[] {"TABLE"});
    }
    
    public DSDataSet loadDataSet(String tableName) throws ApplicationException {
	try {
	    return SQLTransferHelper.getInstance().loadDataSet(getConnection(), tableName);
	} catch (Exception ex) {
	    throw new ApplicationException(ex);
	}
    }
    
    public void insertDataSet(DSDataSet dataSet, String tableName, List<FieldMapping> mapping) throws ApplicationException {
	try {
	    SQLTransferHelper.getInstance().insertDataSet(getConnection(), dataSet, tableName, mapping);
	} catch (Exception ex) {
	    throw new ApplicationException(ex);
	}
    }
    
    public TransferResult updateTable(DSDataSet dataSet, TransferInfo transferInfo) throws ApplicationException {
	try {
	    return SQLTransferHelper.getInstance().updateTable(getConnection(), dataSet, transferInfo);
	} catch (Exception ex) {
	    throw new ApplicationException(ex);
	}
    }
    
    protected  DatabaseMetaData getDatabaseMetaData() throws SQLException {
	return getConnection().getMetaData();
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
    
    public DSDataSet getColumnsDataSet(String tableName) throws ApplicationException {
	try {
	    return SQLTransferHelper.getInstance().getColumnsDataSet(getConnection(), null, null, tableName);
	} catch (Exception ex) {
	    throw new ApplicationException(ex);
	}
    }

    
    public DSDataSet getPrimaryKeysDataSet(String tableName) throws ApplicationException {
	try {
	    return SQLTransferHelper.getInstance().getPrimaryKeysDataSet(getConnection(), null, null, tableName);
	} catch (Exception ex) {
	    throw new ApplicationException(ex);
	}
    }
    
    public IDataSetImporter getDataSetImporter(String tableName)  throws ApplicationException {
	return null;
    }
}
