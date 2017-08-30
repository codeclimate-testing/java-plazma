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

package org.plazmaforge.bsolution.goods.server.services;

import java.util.List;

import org.plazmaforge.framework.core.datastorage.DSDataSet;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.datawarehouse.FieldMapping;
import org.plazmaforge.framework.datawarehouse.TransferInfo;
import org.plazmaforge.framework.datawarehouse.TransferResult;
import org.plazmaforge.framework.datawarehouse.convert.dataexport.AbstractDataSetImporter;
import org.plazmaforge.framework.datawarehouse.convert.dataimport.IDataSetImporter;
import org.plazmaforge.framework.datawarehouse.convert.dataimport.IImporter;

public class GoodsGroupImporter extends AbstractDataSetImporter implements IDataSetImporter {

    private static String PRODUCT_GROUP = "PRODUCT_GROUP";
    
    private static String ID = "ID";
    
    private static String PRODUCT_SECTION_ID = "PRODUCT_SECTION_ID";
    
    
    public GoodsGroupImporter() {
	super();
	setEnableClearTable(false);
	setEnableAutoPrimaryKey(false);
	setAutoPrimaryKey(true);
    }
    
    public void importDataSet(IImporter importer) throws ApplicationException {
	
	DSDataSet dataSet = getDataSet();
	
	TransferInfo transferInfo = getTransferInfo();
	transferInfo.setTableName(PRODUCT_GROUP);
	transferInfo.setClearTable(false);
	transferInfo.setAutoPrimaryKey(true);
	
	List<FieldMapping> columnMapping = transferInfo.getMapping();
	addPrimaryKeyColumnMappingIfNeed(columnMapping, ID, Integer.class);
	addValueColumnMappingIfNeed(columnMapping, PRODUCT_SECTION_ID, Integer.class, 1);
	
	TransferResult transferResult = getTransferService().updateTable(dataSet, transferInfo);
	setTransferResult(transferResult);
    }

}
