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
 * Created on 15.09.2007
 *
 */

package org.plazmaforge.framework.datawarehouse;

import java.util.List;

import org.plazmaforge.framework.core.datastorage.DSDataSet;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.datawarehouse.convert.dataimport.IDataSetImporter;


/** 
 * @author Oleh Hapon
 * $Id: IDatabaseService.java,v 1.6 2010/12/05 07:51:30 ohapon Exp $
 */

public interface ITransferService {
    
    
    
    /**
     * Return array of tables
     * @return
     * @throws ApplicationException
     */
    String[][] getTableNames() throws ApplicationException;
    
    /**
     * Load {@link DSDataSet} by table name
     * @param tableName
     * @return
     * @throws ApplicationException
     */
    DSDataSet loadDataSet(String tableName) throws ApplicationException;
    
    
    
    /**
     * Insert to Table from DataSet
     * @param dataSet
     * @param tableName
     * @param mapping
     * @throws ApplicationException
     */
    void insertDataSet(DSDataSet dataSet, String tableName, List<FieldMapping> mapping) throws ApplicationException;

    /**
     * Update Table by DataSet
     * @param dataSet
     * @param transferInfo
     * @return transferResult
     * @throws ApplicationException
     */
    TransferResult updateTable(DSDataSet dataSet, TransferInfo transferInfo) throws ApplicationException;

    
    /**
     * Return {@link DSDataSet} of columns of the table by table name
     * @param tableName
     * @return
     * @throws ApplicationException
     */
    DSDataSet getColumnsDataSet(String tableName) throws ApplicationException;
    
    
    /**
     * Return {@link DSDataSet} of primary keys of the table by table name
     * @param tableName
     * @return
     * @throws ApplicationException
     */
    DSDataSet getPrimaryKeysDataSet(String tableName) throws ApplicationException;
    
  
    /**
     * Return {@link IDataSetImporter} by table name
     * @param tableName
     * @return
     * @throws ApplicationException
     */
    IDataSetImporter getDataSetImporter(String tableName)  throws ApplicationException;
    
}
