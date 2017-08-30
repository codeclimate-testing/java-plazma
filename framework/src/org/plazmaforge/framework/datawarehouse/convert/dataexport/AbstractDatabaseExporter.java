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
 * Created on 12.02.2008
 *
 */

package org.plazmaforge.framework.datawarehouse.convert.dataexport;

import java.io.File;
import java.util.Date;

import org.plazmaforge.framework.core.datastorage.DSDataSet;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.datawarehouse.ITransferService;
import org.plazmaforge.framework.datawarehouse.convert.IConfigurer;


/** 
 * @author Oleh Hapon
 * $Id: AbstractDatabaseExporter.java,v 1.10 2010/12/05 07:51:24 ohapon Exp $
 */

public abstract class AbstractDatabaseExporter extends AbstractExporter {

    private String[] tableNames;

    private String directoryName;
    
   
    
    
    public String[] getTableNames() {
	if (tableNames == null) {
	    tableNames = getStringArrayConfigProperty(IConfigurer.TABLE_NAMES);
	}		
        return tableNames;
    }

    public void setTableNames(String[] tableNames) {
        this.tableNames = tableNames;
    }

    public String getDirectoryName() {
	if (directoryName == null) {
	    directoryName = getStringConfigProperty(IConfigurer.DIRECTORY_NAME);
	}
        return directoryName;
    }

    public void setDirectoryName(String dirName) {
        this.directoryName = dirName;
    }
    
    public void execute() throws ApplicationException {
	if (!isValid()) {
	    return;
	}
	init();

	try {
	    ITransferService service = getTransferService();
	    if (service == null) {
		throw new ApplicationException("TransferService is empty");
	    }
	    String outputDirectory = generateDatabaseDirectoryName();

	    File file = new File(outputDirectory);

	    /*
	    if (file.exists()) {
		// overwrite existing files
		file.delete();
	    }
	    */
	    
	    file.mkdirs();

	    String[] tableNames = getTableNames();
	    int count = tableNames.length;
	    
	    AbstractExporter dataSetExporter =  createDataSetExporter();
	    initDataSetExporter(dataSetExporter);
	    
	    boolean firstTable = true;
	    for (String tableName : tableNames) {
		DSDataSet dataSet = service.loadDataSet(tableName);
		if (dataSet == null) {
		    throw new ApplicationException("DataSet of the '" + tableName + "' is empty");
		}
		String fileName = generateDataSetFileName(outputDirectory, tableName);
		
		dataSetExporter.setDataSet(dataSet);
		dataSetExporter.setDataSetName(tableName);
		dataSetExporter.setFileName(fileName);
		dataSetExporter.execute();
		
		// We calculate row only for first table
		if (firstTable) {
		    firstTable = false;
		    countDataRow(dataSetExporter.getTransferResult().getDataRowCount());
		}
		
		
		countDataSet();
	    }
	    
	    
	    
	    

	} catch (Exception ex) {
	    throw new ApplicationException(ex);
	}

    }
    
    protected boolean isValid() {
	String directoryName = getDirectoryName();
	String[] tableName = getTableNames();
	if (directoryName == null || tableName == null || tableName.length == 0) {
	    return false;
	}
	return true;
    }

    protected String generateDatabaseDirectoryName() {
	return getDirectoryName() + File.separator  + "plazma-db-" + new Date().getTime();
    }

    protected abstract String generateDataSetFileName(String outputDirectory, String tableName);
    
    protected abstract AbstractExporter createDataSetExporter();
    
    protected void initDataSetExporter(AbstractExporter exporter) {
	exporter.setProperties(this);
    }

}
