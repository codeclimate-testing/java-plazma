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

package org.plazmaforge.framework.datawarehouse.convert.dataimport;

import java.util.List;

import org.plazmaforge.framework.core.datastorage.DSDataSet;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.datawarehouse.FieldMapping;
import org.plazmaforge.framework.datawarehouse.ITransferService;
import org.plazmaforge.framework.datawarehouse.TransferInfo;
import org.plazmaforge.framework.datawarehouse.TransferResult;
import org.plazmaforge.framework.datawarehouse.convert.IConfigurer;
import org.plazmaforge.framework.datawarehouse.convert.dataexport.AbstractDataSetImporter;

public class DBTableImporter extends AbstractDataSetImporter implements IDataSetImporter {
    
    public DBTableImporter() {
	super();
    }
    
    public DBTableImporter(ITransferService databaseService) {
	super(databaseService);
    }

    public void importDataSet(IImporter importer) throws ApplicationException {
	DSDataSet dataSet = importer.getDataSet();
	IConfigurer configurer = importer.getConfigurer();
	String tableName = (String) configurer.getProperty(IConfigurer.TABLE_NAME);
	String action = (String) configurer.getProperty(IConfigurer.TRANSFER_ACTION);
	boolean isClearTable = (Boolean) configurer.getProperty(IConfigurer.TRANSFER_CLEAR_TABLE);
	boolean isAutoincrementPk = (Boolean) configurer.getProperty(IConfigurer.TRANSFER_AUTOINCREMENT_PK);
	
	List<FieldMapping> mapping = (List<FieldMapping>) configurer.getProperty(IConfigurer.COLUMN_MAPPINGS);
	
	TransferInfo transferInfo = new TransferInfo();
	transferInfo.setTableName(tableName);
	transferInfo.setMapping(mapping);
	transferInfo.setAction(action);
	transferInfo.setClearTable(isClearTable);
	transferInfo.setAutoPrimaryKey(isAutoincrementPk);
	TransferResult transferResult = getTransferService(importer).updateTable(dataSet, transferInfo);  
	importer.setTransferResult(transferResult);
    }

  
}
