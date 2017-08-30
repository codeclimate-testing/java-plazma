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

package org.plazmaforge.framework.datawarehouse.convert.dataexport;

import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.framework.core.datastorage.DSDataSet;
import org.plazmaforge.framework.core.datastorage.DSField;
import org.plazmaforge.framework.core.type.TypeUtils;
import org.plazmaforge.framework.datawarehouse.FieldMapping;
import org.plazmaforge.framework.datawarehouse.IExpressionCalculator;
import org.plazmaforge.framework.datawarehouse.ITransferService;
import org.plazmaforge.framework.datawarehouse.TransferInfo;
import org.plazmaforge.framework.datawarehouse.TransferResult;
import org.plazmaforge.framework.datawarehouse.convert.dataimport.IImporter;

public class AbstractDataSetImporter {

    /**
     * Transfer Service (only for base mode)
     */
    private ITransferService transferService;
    
    /**
     * DataSet (only for transfer mode)
     */
    private DSDataSet dataSet;
    
    /**
     * TransferInfo (only for transfer mode)
     */
    private TransferInfo transferInfo;
    
    /**
     * TransferResult (only for transfer mode)
     */
    private TransferResult transferResult;
    
    
    private boolean enableClearTable;
    
    private boolean enableAutoPrimaryKey;
    
    private boolean clearTable;
    
    private boolean autoPrimaryKey;
    
    
    
    public ITransferService getTransferService() {
        return transferService;
    }

    public void setTransferService(ITransferService transferService) {
        this.transferService = transferService;
    }

    public AbstractDataSetImporter() {
	enableClearTable = true;
	enableAutoPrimaryKey = true;
    }

    public AbstractDataSetImporter(ITransferService transferService) {
	this.transferService = transferService;
    }
    
    protected ITransferService getTransferService(IImporter importer) {
	return transferService == null ? importer.getTransferService() : transferService;
    }

    public DSDataSet getDataSet() {
        return dataSet;
    }

    public void setDataSet(DSDataSet dataSet) {
        this.dataSet = dataSet;
    }

    public TransferInfo getTransferInfo() {
        return transferInfo;
    }

    public void setTransferInfo(TransferInfo transferInfo) {
        this.transferInfo = transferInfo;
    }

    public TransferResult getTransferResult() {
        return transferResult;
    }

    public void setTransferResult(TransferResult transferResult) {
        this.transferResult = transferResult;
    }
    
    ////
    
    protected boolean existsColumn(String[] columns, String columnName) {
	if (columnName == null) {
	    return false;
	}
	if (columns == null || columns.length == 0) {
	    return false;
	}
	for (String c : columns) {
	    if (columnName.equals(c)) {
		return true;
	    }
	}
	return false; 
    }
    
    protected boolean existsColumn(List<FieldMapping> columns, String columnName) {
	FieldMapping cm = getColumnMapping(columns, columnName);
	return cm != null;
    }

    protected FieldMapping getColumnMapping(List<FieldMapping> columns, String columnName) {
	if (columnName == null) {
	    return null;
	}
	if (columns == null || columns.isEmpty()) {
	    return null;
	}
	String c = null;
	for (FieldMapping cm : columns) {
	    c = cm.getTargetFieldName();
	    if (columnName.equals(c)) {
		return cm;
	    }
	}
	return null;
    }

    
    protected int getColumnIndex(DSDataSet dataSet, List<FieldMapping> inputMapping, String targetColumnName) {
	if (dataSet == null || inputMapping == null || targetColumnName == null) {
	    return -1;
	}
	String sourceColumnName = null;
	for (FieldMapping cm : inputMapping) {
	    if (targetColumnName.equals(cm.getTargetFieldName())) {
		sourceColumnName = cm.getSourceFieldName();
		break;
	    }
	}
	if (sourceColumnName == null) {
	    return -1;
	}
	List<DSField> columns = dataSet.getFields();
	if (columns == null) {
	    return -1;
	}
	int count = columns.size();
	for (int i = 0; i < count; i++) {
	    DSField column = columns.get(i);
	    if (sourceColumnName.equals(column.getName())) {
		return i;
	    }
	}
	return -1;
    }
    
    
    protected List<FieldMapping> getTransformColumnMapping(List<FieldMapping> inputMapping) {
	List<FieldMapping> columnMapping = new ArrayList<FieldMapping>();
	if (inputMapping == null) {
	    return columnMapping;
	}
	String columnName = null;
	for (FieldMapping cm : inputMapping) {
	    columnName = cm.getTargetFieldName();
	    
	    // Use only base column
	    if (!isBaseColumn(columnName)) {
		continue;
	    }
	    FieldMapping m = (FieldMapping) cm.clone();
	    m.setKey(isKeyColumn(columnName));
	    columnMapping.add(m);
	}
	return columnMapping;
    }
    
    protected boolean isBaseColumn(String columnName) {
	return existsColumn(getBaseColumns(), columnName);
    }

    protected boolean isKeyColumn(String columnName) {
	return existsColumn(getKeyColumns(), columnName);
    }
    
    protected String[] getBaseColumns() {
	return null; 
    }

    protected String[] getKeyColumns() {
	return null; 
    }
    
    
    protected FieldMapping addPrimaryKeyColumnMappingIfNeed(List<FieldMapping> columnMapping, String columnName, Class columnClass) {
	FieldMapping pkColumnMapping = null;
	pkColumnMapping = getColumnMapping(columnMapping, columnName);
	if (pkColumnMapping != null) {
	    return pkColumnMapping;
	}    
	pkColumnMapping = createPrimaryKeyColumnMapping(columnName, columnClass);
	columnMapping.add(pkColumnMapping);
	return pkColumnMapping;
    }

    protected FieldMapping addColumnMappingIfNeed(List<FieldMapping> columnMapping, String columnName, Class columnClass) {
	FieldMapping pkColumnMapping = null;
	pkColumnMapping = getColumnMapping(columnMapping, columnName);
	if (pkColumnMapping != null) {
	    return pkColumnMapping;
	}  
	pkColumnMapping = createColumnMapping(columnName, columnClass);
	columnMapping.add(pkColumnMapping);
	return pkColumnMapping;
    }

    protected FieldMapping addValueColumnMappingIfNeed(List<FieldMapping> columnMapping, String columnName, Class columnClass, Object value) {
	FieldMapping cm = addColumnMappingIfNeed(columnMapping, columnName, columnClass);
	cm.setResultType(FieldMapping.VALUE_RESULT_TYPE);
	cm.setValue(value);
	return cm;
    }
    
    protected FieldMapping addExpressionColumnMappingIfNeed(List<FieldMapping> columnMapping, String columnName, Class columnClass, String expression, IExpressionCalculator expressionCalculator) {
	FieldMapping cm = addColumnMappingIfNeed(columnMapping, columnName, columnClass);
	cm.setResultType(FieldMapping.EXPRESSION_RESULT_TYPE);
	cm.setValue(expression);
	cm.setExpressionCalculator(expressionCalculator);
	return cm;
    }
    
    protected FieldMapping createPrimaryKeyColumnMapping(String columnName, Class columnClass) {
	
	FieldMapping pkColumnMapping = createColumnMapping(columnName, columnClass);
	DSField column = (DSField) pkColumnMapping.getTargetField();
	column.setPrimaryKey(true);
	
	return pkColumnMapping;

    }
    
    protected FieldMapping createColumnMapping(String columnName, Class columnClass) {
	
	FieldMapping columnMapping = new FieldMapping();

	DSField column = new DSField();
	column.setName(columnName);
	column.setDataType(TypeUtils.getType(columnClass));
	columnMapping.setTargetField(column);

	return columnMapping;

    }


    public boolean isEnableClearTable() {
        return enableClearTable;
    }

    public void setEnableClearTable(boolean enableClearTable) {
        this.enableClearTable = enableClearTable;
    }

    public boolean isEnableAutoPrimaryKey() {
        return enableAutoPrimaryKey;
    }

    public void setEnableAutoPrimaryKey(boolean enableAutoPrimaryKey) {
        this.enableAutoPrimaryKey = enableAutoPrimaryKey;
    }

    public boolean isClearTable() {
        return clearTable;
    }

    public void setClearTable(boolean clearTable) {
        this.clearTable = clearTable;
    }

    public boolean isAutoPrimaryKey() {
        return autoPrimaryKey;
    }

    public void setAutoPrimaryKey(boolean autoPrimaryKey) {
        this.autoPrimaryKey = autoPrimaryKey;
    }
    
    
}
