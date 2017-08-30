package org.plazmaforge.bsolution.base.server.services;

import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.bsolution.base.common.services.TransferSourceService;
import org.plazmaforge.framework.core.data.TransferSource;
import org.plazmaforge.framework.core.data.TransferSourceAttribute;
import org.plazmaforge.framework.core.datastorage.DSArrayDataSet;
import org.plazmaforge.framework.core.datastorage.DSDataSet;
import org.plazmaforge.framework.core.datastorage.DSField;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.datawarehouse.FieldMapping;
import org.plazmaforge.framework.datawarehouse.ITransferService;
import org.plazmaforge.framework.datawarehouse.TransferEnvironment;
import org.plazmaforge.framework.datawarehouse.TransferInfo;
import org.plazmaforge.framework.datawarehouse.TransferResult;
import org.plazmaforge.framework.datawarehouse.convert.dataimport.IDataSetImporter;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.sql.JDBCEnvironment;
import org.plazmaforge.framework.util.ClassUtilsExt;
import org.plazmaforge.framework.util.StringUtils;

public class CustomTransferServiceImpl extends TransferSourceServiceImpl implements TransferSourceService, ITransferService {

    public String[][] getTableNames() throws ApplicationException {
	
	List<TransferSource> sources = findAll();
	int size = sources.size();
	String[][] names = new String[size][2];
	for (int i =0 ; i < size; i++) {
	    TransferSource source = sources.get(i);
	    names[i][0] = source.getCode();
	    names[i][1] = source.getName();
	}
	return names;
    }

    public DSDataSet getColumnsDataSet(String tableName) throws ApplicationException {

	// Load source with attributes
	TransferSource source = getTransferSource(tableName);
	
	DSArrayDataSet dataSet = new DSArrayDataSet();
	int columnCount = 22;
	List<DSField> columns = new ArrayList<DSField>();
	
	columns.add(createColumn("TABLE_CAT"));
	columns.add(createColumn("TABLE_SCHEM"));
	columns.add(createColumn("TABLE_NAME"));
	columns.add(createColumn("COLUMN_NAME"));
	columns.add(createColumn("DATA_TYPE"));
	columns.add(createColumn("TYPE_NAME"));
	columns.add(createColumn("COLUMN_SIZE"));
	columns.add(createColumn("BUFFER_LENGTH"));
	columns.add(createColumn("DECIMAL_DIGITS"));
	columns.add(createColumn("NUM_PREC_RADIX"));
	columns.add(createColumn("NULLABLE"));
	columns.add(createColumn("REMARKS"));
	columns.add(createColumn("COLUMN_DEF"));
	columns.add(createColumn("SQL_DATA_TYPE"));
	columns.add(createColumn("SQL_DATETIME_SUB"));
	columns.add(createColumn("CHAR_OCTET_LENGTH"));
	columns.add(createColumn("ORDINAL_POSITION"));
	columns.add(createColumn("IS_NULLABLE"));
	columns.add(createColumn("SCOPE_CATLOG"));
	columns.add(createColumn("SCOPE_SCHEMA"));
	columns.add(createColumn("SCOPE_TABLE"));
	columns.add(createColumn("SOURCE_DATA_TYPE"));


	dataSet.setFields(columns);
	
	
	List<Object[]> rows = new ArrayList<Object[]>();

	List<TransferSourceAttribute> attributes = source.getAttributes();
	Object[] values = null;
	for (TransferSourceAttribute attr: attributes) {
	    values = new Object[columnCount];
	    values[3] = attr.getCode(); // TODO use CODE | NAME
	    values[4] = JDBCEnvironment.getJdbcType(attr.getSqlType());
	    values[5] = attr.getSqlType();
	    values[11] = attr.getName();
	    
	    rows.add(values);
	}
	
	dataSet.setData(rows);
	
	return dataSet;
	
	
    }
    
    

    public DSDataSet getPrimaryKeysDataSet(String tableName) throws ApplicationException {
	
	// Load source with attributes
	TransferSource source = getTransferSource(tableName);
	
	DSArrayDataSet dataSet = new DSArrayDataSet();
	int columnCount = 6;
	List<DSField> columns = new ArrayList<DSField>();
	
	columns.add(createColumn("TABLE_CAT"));
	columns.add(createColumn("TABLE_SCHEM"));
	columns.add(createColumn("TABLE_NAME"));
	columns.add(createColumn("COLUMN_NAME"));
	columns.add(createColumn("KEY_SEQ"));
	columns.add(createColumn("PK_NAME"));
	
	    
	dataSet.setFields(columns);
	
	
	List<Object[]> rows = new ArrayList<Object[]>();

	List<TransferSourceAttribute> attributes = source.getAttributes();
	Object[] values = null;
	short index = 0;
	for (TransferSourceAttribute attr: attributes) {
	    if (!isPrimaryKey(attr)) {
		continue;
	    }
	    index++;
	    values = new Object[columnCount];
	    values[3] = attr.getCode(); // TODO use CODE | NAME
	    values[4] = index;
	    values[5] = "PK_" + tableName;
	    
	    rows.add(values);
	}
	dataSet.setData(rows);
	return dataSet;
    }


    public void insertDataSet(DSDataSet dataSet, String tableName, List<FieldMapping> mapping) throws ApplicationException {
	// TODO Auto-generated method stub
    }

    public DSDataSet loadDataSet(String tableName) throws ApplicationException {
	// TODO Auto-generated method stub
	return null;
    }

    public TransferResult updateTable(DSDataSet dataSet, TransferInfo transferInfo) throws ApplicationException {
	
	String tableName = transferInfo.getTableName();
	
	// Load source
	TransferSource source = getTransferSource(tableName);

	String importerClassName = source.getImporterClassName();
	IDataSetImporter importer = createDataSetImporter(importerClassName);
	importer.setDataSet(dataSet);
	importer.setTransferInfo(transferInfo);
	importer.setTransferService(TransferEnvironment.getTransferService());
	importer.importDataSet(null);
	return importer.getTransferResult();
    }

    public IDataSetImporter getDataSetImporter(String tableName)  throws ApplicationException {
	
	// Load source
	TransferSource source = getTransferSource(tableName);
	String importerClassName = source.getImporterClassName();

	return createDataSetImporter(importerClassName);
    }

    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Helper methods
    //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    private TransferSource getTransferSource(String tableName) throws ApplicationException {
	Criteria criteria = new Criteria();
	criteria.addFilter("code", tableName);
	return getEntityManager().load(TransferSource.class, criteria);
    }
    
    private DSField createColumn(String columnName) {
	DSField column = new DSField();
	column.setName(columnName);
	column.setCaption(columnName);
	return column;
    }
    
    private boolean isPrimaryKey(TransferSourceAttribute attr) {
	if (attr == null) {
	    return false;
	}
	return "ID".equals(attr.getCode()); // TODO: Must use IS_PRIMARY_KEY column
    }

    private IDataSetImporter createDataSetImporter(String importerClassName) throws ApplicationException {
	if (StringUtils.isEmpty(importerClassName)) {
	    throw new ApplicationException("Importer class is empty");
	}
	IDataSetImporter importer = (IDataSetImporter) ClassUtilsExt.getClassInstance(importerClassName);
	return importer;
    }

}
