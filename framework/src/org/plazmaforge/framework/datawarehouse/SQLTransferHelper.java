package org.plazmaforge.framework.datawarehouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.framework.sql.IDGenerator;
import org.plazmaforge.framework.sql.JDBCEnvironment;
import org.plazmaforge.framework.util.ValueConverter;
import org.plazmaforge.framework.util.StringUtils;
import org.plazmaforge.framework.core.datastorage.DSArrayDataSet;
import org.plazmaforge.framework.core.datastorage.DSDataSet;
import org.plazmaforge.framework.core.datastorage.DSField;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.core.type.TypeUtils;

public class SQLTransferHelper {

    
    private static SQLTransferHelper instance;
    
    
    private ValueConverter converter;
    
    public static SQLTransferHelper getInstance() {
	if (instance == null) {
	    instance = new SQLTransferHelper(); 
	}
        return instance;
    }


    public DSDataSet getDataSet(ResultSet rs) throws SQLException {
	return  getDataSet(rs, null);
    }
    
    
    public DSDataSet getDataSet(ResultSet rs, int[] indexes) throws SQLException {
	if (rs == null) {
	    return null;
	}
	DSArrayDataSet dataSet = null;
	try {
	    ResultSetMetaData rsmd = rs.getMetaData();
	    int columnCount = rsmd.getColumnCount();
	    
	    dataSet = new DSArrayDataSet();
	    //dataSet.setName(tableName);
	    int[] columnIndexes = indexes;
	    if (columnIndexes == null || columnIndexes.length == 0) {
		columnIndexes = new int[columnCount];
		for (int i = 0; i < columnCount; i++) {
		    columnIndexes[i] = i + 1;
		}
	    } else {
		columnCount = columnIndexes.length; 
	    }
	    
	    
	    List<DSField> columns = new ArrayList<DSField>();
	    for (int i = 0 ; i < columnCount; i++) {
		int columnIndex =  columnIndexes[i]; //i + 1;
		
		int jdbcType = rsmd.getColumnType(columnIndex);
		String jdbcTypeName = JDBCEnvironment.getJdbcTypeName(jdbcType);
		String columnName = rsmd.getColumnName(columnIndex);
		String columnClassName = rsmd.getColumnClassName(columnIndex);
		String type = TypeUtils.getType(columnClassName);
		int displaySize = rsmd.getColumnDisplaySize(columnIndex);
		int precision = rsmd.getPrecision(columnIndex);
		int scale = rsmd.getScale(columnIndex);

		DSField column = new DSField();
		column.setName(columnName);
		column.setCaption(columnName);
		
		if (JDBCEnvironment.isNumberType(jdbcType)) {
		    column.setAlign(DSField.RIGHT_ALIGN);
		}
		
		column.setNativeTypeCode(jdbcType);
		column.setNativeType(jdbcTypeName);
		column.setDataType(type);
		column.setSize(displaySize);
		column.setScale(scale);
		
		columns.add(column);
	    }
	    
	    dataSet.setFields(columns);
	    
	    List<Object[]> rows = new ArrayList<Object[]>();
	    while (rs.next()){
		Object values[] = new Object[columnCount];
		    for (int i = 0; i < columnCount; i++) {
			int columnIndex =  columnIndexes[i]; //i + 1;
			// TODO: Use RowReader
			Object val = rs.getObject(columnIndex);
			values[i] = val;
		    }
		    rows.add(values);
	    }
	    dataSet.setData(rows);
	    return dataSet;
	} finally {
	    close(rs); 
	}	
    }
    
    public DSDataSet loadDataSet(Connection connection, String tableName) throws SQLException {
	return loadDataSet(connection, tableName, 0);
    }
	
    public DSDataSet loadDataSet(Connection connection, String tableName, int maxRows) throws SQLException {
	Statement stm = null;
	ResultSet rs = null;
	try {
	    stm = connection.createStatement();
	    if (maxRows > 0) {
		stm.setMaxRows(maxRows);
	    }
	    rs = stm.executeQuery("SELECT * FROM " + tableName);
	    DSDataSet ds = getDataSet(rs);
	    ds.setName(tableName);
	    return ds;
	} finally {
	    close(rs);
	}
    }
    
    public int getTableRowsCount(Connection connection, String tableName) throws SQLException {
	Statement stm = null;
	ResultSet rs = null;
	try {
	    stm = connection.createStatement();
	    rs = stm.executeQuery("SELECT COUNT(*) FROM " + tableName);
	    if (!rs.next()) {
		return 0;
	    }
	    return rs.getInt(1);
	} finally {
	    close(rs);
	}
    }
    
    public DSDataSet getColumnsDataSet(Connection connection, String catalog, String schema, String table) throws SQLException {
	return getColumnsDataSet(connection, catalog, schema, table, null);
    }
    
    public DSDataSet getColumnsDataSet(Connection connection, String catalog, String schema, String table, int[] indexes) throws SQLException {
	return getDataSet(getColumnsResultSet(connection, catalog, schema, table), indexes);
    }
    
    public ResultSet getColumnsResultSet(Connection connection, String catalog, String schema, String table) throws SQLException {
	return connection.getMetaData().getColumns(catalog, schema, table, "%");
    }
    
    ////

    public DSDataSet getPrimaryKeysDataSet(Connection connection, String catalog, String schema, String table) throws SQLException {
	return getDataSet(getPrimaryKeysResultSet(connection, catalog, schema, table));
    }

    public ResultSet getPrimaryKeysResultSet(Connection connection, String catalog, String schema, String table) throws SQLException {
	return connection.getMetaData().getPrimaryKeys(catalog, schema, table);
    }

    ////
    
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
    
    public void insertDataSet(Connection connection, DSDataSet dataSet, String tableName, List<FieldMapping> columnMapping) throws ApplicationException, SQLException {
	
	TransferInfo transferInfo = new TransferInfo();
	transferInfo.setAction(TransferInfo.INSERT_ACTION);
	transferInfo.setTableName(tableName);
	transferInfo.setMapping(columnMapping);
	
	updateTable(connection, dataSet, transferInfo);
    }
    
    public TransferResult updateTable(Connection connection, DSDataSet dataSet, TransferInfo transferInfo) throws ApplicationException, SQLException {
	
	if (transferInfo == null ) {
	    throw new ApplicationException("TransferInfo is empty");
	}
	
	String tableName = transferInfo.getTableName();
	String sequenceName = transferInfo.getSequanceName(); // only for sequance strategy generate PK 
	String action = transferInfo.getAction();
	boolean clearTable = transferInfo.isClearTable();
	boolean autoPrimaryKey = transferInfo.isAutoPrimaryKey();
	boolean hasPrimaryKeys = false;
	boolean hasOnlyOnePrimaryKey = false;
	
	PreparedStatement insertStm = null;
	PreparedStatement updateStm = null;
	PreparedStatement deleteStm = null;
	PreparedStatement selectStm = null;
	
	ResultSet rs = null;
	
		
	int insertCount = 0;
	int updateCount = 0;
	int deleteCount = 0;

	TransferResult result = new TransferResult();
	
	IDGenerator idGenerator = new IDGenerator(); // ONLY FOR AUTO GENERATE PRIMARY KEY MODE
	idGenerator.setTableName(tableName);
	idGenerator.setSequenceName(sequenceName);
	idGenerator.setStrategy(transferInfo.getIdGenerateStrategy());

	ITransferTrigger transferTrigger = transferInfo.getTrigger();
	TransferEvent transferEvent = null;
	if (transferTrigger != null) {
	    transferTrigger.setConnection(connection);
	    transferTrigger.init();
	    transferEvent = new TransferEvent();
	    transferEvent.dataSet = dataSet;
	}
	     
		
	// DEBUG /////////////////////////////////////////////////////
	//autoPrimaryKey = true;
	//transferInfo.getColumnMapping().get(0).setKey(true);
	//action = TransferInfo.UPDATE_ACTION;
	//////////////////////////////////////////////////////////////
	
	try {
	    List<FieldMapping> inputMapping = transferInfo.getMapping();
	    List<FieldMapping> normalizeMapping = normalizeMapping(dataSet, tableName, inputMapping, action, clearTable);
	    if (normalizeMapping == null || normalizeMapping.isEmpty()) {
		// TODO: Warning
		result.setErrorMessage("Column mapping is empty");
		return result;
	    }
	    
	  
	    
	    // CHECK: INVALID COLUMN LINK
	    Integer[] indexes = getIndexesOfSourceColumns(dataSet, normalizeMapping);
	    if (indexes == null || indexes.length == 0) {
		// TODO: Exception
		result.setErrorMessage("Internal error");
		return result;
	    }
	    
	    List<FieldMapping> keyMapping = TransferInfo.getKeyMapping(normalizeMapping);
	    
	    // CHECK: KEY COLUMNS
	    validateActionByKeyColumns(action, keyMapping);
		
	    int normalizeColumnCount = normalizeMapping.size();
	    int keyColumnCount = keyMapping == null ? 0 : keyMapping.size();
	    
	    // CHECK: ALL NORMALIZE COLUMNS ARE KEYS
	    if (TransferInfo.isKeyActionType(action) && !TransferInfo.DELETE_ACTION.equals(action)) {
		if (keyColumnCount == normalizeColumnCount && transferInfo.isSupportsUpdate()) {
		    throw new ApplicationException("All input columns are keys");
		}
	    }

	    //List<IDataSetRow> rows = dataSet.getRows();
	    //int rowCount = rows.size();
	    //result.setDataRowCount(rowCount);
	    
	    if (dataSet.isEmpty()) {
		result.setEmptyData(true);
		return result;
	    }
	    
	    List<DSField> primaryKeys = getPrimaryKeys(inputMapping); // Use first mapping for PRIMARY KEYS
	    int primaryKeyCount = primaryKeys == null ? 0 : primaryKeys.size();
	    hasPrimaryKeys = primaryKeyCount > 0;
	    hasOnlyOnePrimaryKey = primaryKeyCount == 1;
	    
	    String sql = null;
	    
	    // Special mapping for INSERT action type
	    List<FieldMapping> insertMapping = normalizeMapping;
	    
	    // Special mapping for UPDATE action type WITHOUT KEY columns
	    List<FieldMapping> updateMapping = TransferInfo.getUpdateMapping(normalizeMapping); 
	    
	    int insertColumnCount = insertMapping == null ? 0 : insertMapping.size();
	    int updateColumnCount = updateMapping == null ? 0 : updateMapping.size();
	    
	    
	    Integer[] insertIndexes = indexes;
	    Integer[] updateIndexes = getIndexesOfSourceColumns(dataSet, updateMapping);
	    Integer[] keyIndexes = null;
	    if (keyMapping != null) {
		keyIndexes = getIndexesOfSourceColumns(dataSet, keyMapping);
	    }
	    Object value = null;
	    
	    
	    
	    FieldMapping pkColumnMapping = null;
	    ///////////////////////////////////////////////////////////////////////
	
	    if (TransferInfo.isInsertActionType(action) && autoPrimaryKey && hasOnlyOnePrimaryKey) {
		DSField pk = primaryKeys.get(0);

		// TODO: Must implement for Long type too
		if (TransferInfo.isAutoIncrementPK(pk.getDataType())) {
		    
		    //ID GENERATOR
		    String pkColumnName = pk.getName();
		    idGenerator.setColumnName(pkColumnName);
		    idGenerator.init();
		    
		    
		    insertMapping = new ArrayList<FieldMapping>();
		    
		    
		    // Find PK in normalizeMapping
		    // If we not mapping PK column with SOURCE column then after normalize PK column will remove 
		    
		    for (FieldMapping cm : normalizeMapping) {

			if (pkColumnName.equals(cm.getTargetFieldName())) {
			    pkColumnMapping = cm;
			    break;
			}
		    }

		    // If PK column not found (may be PK column was remove after normalize) then add PK column to insert mapping list
		    if (pkColumnMapping == null) {
			pkColumnMapping = new FieldMapping();
			pkColumnMapping.setTargetField(pk);
			insertMapping.add(pkColumnMapping);
		    }
		    
		    // Create single value storage 
		    if (transferEvent != null) {
			transferEvent.pkValues = new Object[1]; 
		    }
		    
		    insertMapping.addAll(normalizeMapping);
		    insertColumnCount = insertMapping.size();
		    insertIndexes = getIndexesOfSourceColumns(dataSet, insertMapping);
		}
	    }

	    // /////////////////////////////////////////////////////////////////////

	    boolean isInsertAction = TransferInfo.INSERT_ACTION.equals(action); // ONLY INSERT
	    boolean isInsertActionType = TransferInfo.isInsertActionType(action);
	    boolean isUpdateActionType = TransferInfo.isUpdateActionType(action);
	    
	    boolean supportClearTable = isInsertAction; // ONLY INSERT SUPPORTS 'Clear Table' MODE
	    boolean supportInsert = isInsertActionType && transferInfo.isSupportsInsert();
	    boolean supportUpdate = isUpdateActionType && transferInfo.isSupportsUpdate();
	    boolean ignoreFoundRow = isInsertAction;

	    // /////////////////////////////////////////////////////////////////////
		
	    if (TransferInfo.INSERT_ACTION.equals(action) 
		    || TransferInfo.UPDATE_ACTION.equals(action) 
		    || TransferInfo.UPDATE_INSERT_ACTION.equals(action)) {
		
		
		
		///////////////////////////////////////////////////////////////////////
		// CLEAR TABLE
		///////////////////////////////////////////////////////////////////////
		if (supportClearTable && clearTable) {
		    sql = createDeleteSQL(tableName);
		    deleteStm = connection.prepareStatement(sql);
		    deleteCount += deleteStm.executeUpdate();
		}
		
		if (supportInsert) {
		    sql = createInsertSQL(tableName, insertMapping);
		    if (sql == null) {
			throw new ApplicationException("INSERT SQL is null");
		    }
		    insertStm = connection.prepareStatement(sql);
		}
		if (supportUpdate) {
		    sql = createUpdateSQL(tableName, updateMapping, keyMapping);
		    if (sql == null) {
			throw new ApplicationException("UPDATE SQL is null");
		    }
		    updateStm = connection.prepareStatement(sql);
		}
		
		if (keyColumnCount > 0) {
		    sql = createSelectKeySQL(tableName, keyMapping);
		    if (sql == null) {
			throw new ApplicationException("SELECT KEYS SQL is null");
		    }
		    selectStm = connection.prepareStatement(sql);
		}
		
		
		FieldMapping cm = null;
		boolean foundRow = false;
		int rowIndex = -1;
		while (dataSet.next()) {
		    
		    rowIndex++;
		    Object[] row = dataSet.getRecord();
		
		    foundRow = false;
		    
		    // FIND ROW BY UNIQUE KEYS
		    if (keyColumnCount > 0) {
			
			// SET KEYS FOR SELECT
			for (int columnIndex = 0; columnIndex < keyColumnCount; columnIndex++) {
			    cm = keyMapping.get(columnIndex);
			    value = getRowValue(cm, row, keyIndexes, columnIndex);
			    selectStm.setObject(columnIndex + 1, value);
			}
			
			close(rs);
			rs = selectStm.executeQuery();
			foundRow = rs.next();
		    }
		    
			
		    if (foundRow) {
			
			if (ignoreFoundRow) {
			    continue;
			}
			
			if (supportUpdate) {
			    
			    // SET VALUES FOR UPDATE
			    for (int columnIndex = 0; columnIndex < updateColumnCount; columnIndex++) {
				cm = updateMapping.get(columnIndex);
				value = getRowValue(cm, row, updateIndexes, columnIndex);
				updateStm.setObject(columnIndex + 1, value);
			    }

			    // SET KEYS FOR UPDATE
			    for (int columnIndex = 0; columnIndex < keyColumnCount; columnIndex++) {
				cm = keyMapping.get(columnIndex);
				value = getRowValue(cm, row, keyIndexes, columnIndex);
				updateStm.setObject(updateColumnCount + columnIndex + 1, value);
			    }

			}
			

			// UPDATE COMMAND
			// //////////////////////////////////////////////////////
			if (transferTrigger != null) {
			    transferEvent.row = row;
			    transferTrigger.doBeforeUpdate(transferEvent);
			}
			
			if (supportUpdate) {
			    updateCount += updateStm.executeUpdate();
			}
			
			if (transferTrigger != null) {
			    transferTrigger.doAfterUpdate(transferEvent);
			}
			/////////////////////////////////////////////////////////////////////////
			
		    } else  {
			
			if (supportInsert) {
			    
			    // SET VALUES FOR INSERT
			    for (int columnIndex = 0; columnIndex < insertColumnCount; columnIndex++) {
				cm = insertMapping.get(columnIndex);
				if (cm == pkColumnMapping) {

				    // ID GENERATOR
				    value = idGenerator.generateId(connection);

				    // Store NEW generate PK value to
				    // TransferEvent
				    if (transferEvent != null && transferEvent.pkValues != null && transferEvent.pkValues.length > 0) {
					transferEvent.pkValues[0] = value;
				    }

				} else {
				    value = getRowValue(cm, row, insertIndexes, columnIndex);
				}
				insertStm.setObject(columnIndex + 1, value);
			    }
			}
			
			
			// INSERT COMMAND //////////////////////////////////////////////////////
			if (transferTrigger != null) {
			    transferEvent.row = row;
			    transferTrigger.doBeforeInsert(transferEvent);
			}
			
			if (supportInsert) {
			    insertCount += insertStm.executeUpdate();
			}
			
			
			if (transferTrigger != null) {
			    transferTrigger.doAfterInsert(transferEvent);
			}
			
			/////////////////////////////////////////////////////////////////////////
			
		    }
		}
		
		result.setDataRowCount(rowIndex > 0 ? rowIndex + 1 : 0);
		
	    } else if (TransferInfo.SYNC_ACTION.equals(action)) {
		
		// TODO: DO SYNC ACTION
		
	    } else if (TransferInfo.DELETE_ACTION.equals(action)) {
		
		// TODO: DO DELETE ACTION
		
	    }
	    
	    
	    
	    //
	    // TODO: LogInfo
	    // 
	    
	    
	} finally {
	    
	    if (idGenerator != null) {
		idGenerator.dispose();
	    }
	    if (transferTrigger != null) {
		transferTrigger.dispose();
	    }
	    
	    close(rs);
	    close(insertStm);
	    close(updateStm);
	    close(deleteStm);
	    close(selectStm);
	}
	
	result.setInsertRowCount(insertCount);
	result.setUpdateRowCount(updateCount);
	result.setDeleteRowCount(deleteCount);
	return result;
    }
  
    private void validateActionByKeyColumns(String action, List<FieldMapping> keyColumnMapping) throws ApplicationException {
	if (action == null || keyColumnMapping != null) {
	    return;
	}
	
	// Analyze: if keyColumnMapping == null
	
	if (TransferInfo.UPDATE_ACTION.equals(action)) {
	    throw new ApplicationException("Must set keys for UPDATE action");
	} else if (TransferInfo.UPDATE_INSERT_ACTION.equals(action)) {
	    throw new ApplicationException("Must set keys for UPDATE or INSERT actions");
	} else if (TransferInfo.SYNC_ACTION.equals(action)) {
	    throw new ApplicationException("Must set keys for UPDATE or INSERT actions");
	} else if (TransferInfo.DELETE_ACTION.equals(action)) {
	    throw new ApplicationException("Must set keys for DELETE action");
	} 
    }
  
    private Object getValue(PreparedStatement stm) throws SQLException {
	ResultSet rs = null;
	try {
	    rs = stm.executeQuery();
	    if (rs.next()) {
		return rs.getObject(1);
	    }
	} finally {
	    close(rs);
	}
	return null;
    }
    
    private Object getRowValue(FieldMapping cm, Object[] row, int columnIndex) throws ApplicationException {
	if (columnIndex < 0) {
	    return null;
	}
	Object value = row[columnIndex];
	String type = cm.getTargetFieldType();
	if (type != null && value instanceof String) {
	    value = getConverter().convert((String) value, type);
	}
	return value;
    }
    
    private Object getRowValue(FieldMapping cm, Object[] row, Integer[] indexes, int columnIndex) throws ApplicationException {
	if (cm.isFieldResultType()) {
	    return getRowValue(cm, row, indexes[columnIndex]);
	}
	if (cm.isValueResultType()) {
	    return cm.getValue();
	}
	if (cm.isExpressionResultType()) {
	    // TODO
	    IExpressionCalculator calculator = cm.getExpressionCalculator();
	    if (calculator == null) {
		return null;
	    }
	    calculator.setRow(row);
	    return calculator.getValue(cm.getExpression());
	}
	return null;
    }
    
    private String createInsertSQL(String tableName, List<FieldMapping> columnMapping) {
	if (columnMapping == null) {
	    return null;
	}
	
	StringBuffer buf = new StringBuffer("INSERT INTO " + tableName + " (");
	FieldMapping cm = null;
	
	int columnCount = columnMapping.size();
	for (int i = 0; i < columnCount; i++) {
	    if (i > 0) {
		buf.append(", ");
	    }
	    cm = columnMapping.get(i);
	    buf.append(cm.getTargetFieldName());
	}
	buf.append(") VALUES (");
	
	for (int i = 0; i < columnCount; i++) {
	    if (i > 0) {
		buf.append(", ");
	    }
	    buf.append("?");
	}
	buf.append(")");
	return buf.toString();
    }
    
    private String createUpdateSQL(String tableName, List<FieldMapping> columnMapping, List<FieldMapping> keyColumnMapping) {
	
	if (columnMapping == null || keyColumnMapping == null || columnMapping.isEmpty() || keyColumnMapping.isEmpty()) {
	    return null;
	}
	
	StringBuffer buf = new StringBuffer("UPDATE " + tableName + " SET ");
	FieldMapping cm = null;
	
	int columnCount = columnMapping.size();
	for (int i = 0; i < columnCount; i++) {
	    if (i > 0) {
		buf.append(", ");
	    }
	    cm = columnMapping.get(i);
	    buf.append(cm.getTargetFieldName());
	    buf.append(" = ?");
	}
	
	buf.append(" WHERE ");

	columnCount = keyColumnMapping.size();
	for (int i = 0; i < columnCount; i++) {
	    if (i > 0) {
		buf.append(" AND ");
	    }
	    cm = keyColumnMapping.get(i);
	    buf.append(cm.getTargetFieldName());
	    buf.append(" = ?");
	}

	return buf.toString();
    }
    
    private String createSelectKeySQL(String tableName, List<FieldMapping> keyColumnMapping) {
	
	if (keyColumnMapping == null) {
	    return null;
	}
	
	StringBuffer buf = new StringBuffer("SELECT ");
	FieldMapping cm = null;
	
	int columnCount = keyColumnMapping.size();
	for (int i = 0; i < columnCount; i++) {
	    if (i > 0) {
		buf.append(", ");
	    }
	    cm = keyColumnMapping.get(i);
	    buf.append(cm.getTargetFieldName());
	}
	
	buf.append(" FROM " + tableName + " WHERE ");

	columnCount = keyColumnMapping.size();
	for (int i = 0; i < columnCount; i++) {
	    if (i > 0) {
		buf.append(" AND ");
	    }
	    cm = keyColumnMapping.get(i);
	    buf.append(cm.getTargetFieldName());
	    buf.append(" = ?");
	}

	return buf.toString();
    }
    
    
    private String createDeleteSQL(String tableName) {
	return "DELETE FROM " + tableName;
    }

    private String createMaxValueSQL(String tableName, String columnName) {
	return "SELECT MAX(" + columnName + ") FROM " + tableName;
    }
    
    private Integer[] getIndexesOfSourceColumns(DSDataSet dataSet, List<FieldMapping> mapping) {
	if (dataSet == null || mapping == null || mapping.isEmpty()) {
	    return null;
	}
	int count = mapping.size();
	Integer[] indexes = new Integer[count];
	String columnName = null;
	for (int i = 0; i < count; i++) {
	    FieldMapping cm = mapping.get(i);
	    columnName = cm.getSourceFieldName();
	    int index = getIndexOfColumn(dataSet, columnName);
	    //if (index < 0) {
		//return null;
	    //}
	    indexes[i] = index;
	}
	return indexes;
    }
    
    private int getIndexOfColumn(DSDataSet dataSet, String columnName) {
	if (columnName == null) {
	    return -1;
	}
	List<DSField> columns = dataSet.getFields();
	if (columns == null || columns.isEmpty()) {
	    return -1;
	}
	int count = columns.size();
	DSField column = null;
	for (int i = 0; i < count; i++) {
	    column = columns.get(i);
	    if (columnName.equals(column.getName())) {
		return i;
	    }
	}
	return -1;
    }


    public ValueConverter getConverter() {
	if (converter == null) {
	    converter = new ValueConverter();
	}
        return converter;
    }
    

    protected boolean isEmpty(String str) {
	return StringUtils.isEmpty(str);
    }
    
       
    protected List<FieldMapping> normalizeMapping(DSDataSet dataSet, String tableName, List<FieldMapping> mapping, String action, boolean isClearTable) throws ApplicationException {
	
	// CHECK: EMPTY TABLE NAME
	if (isEmpty(tableName)) {
	    throw new ApplicationException("Table Name is empty");
	}

	// CHECK: EMPTY MAPPING
	if (mapping == null || mapping.isEmpty()) {
	    throw new ApplicationException("Mapping is empty");
	}

	// CHECK: EMPTY MAPPING AFTER NORMALIZE
	List<FieldMapping> normalizeMapping = FieldMapping.normalizeMapping(mapping);
	if (normalizeMapping == null ||normalizeMapping.isEmpty()) {
	    throw new ApplicationException("Mapping is empty");
	}

	// CHECK: EMPTY SOURCE DATASET
	if (dataSet.isEmpty()) {
	    // Warning
	    return null;
	}
	
	return normalizeMapping;
    }
    
    
    private List<DSField> getPrimaryKeys(List<FieldMapping> columnMapping) {
	if (columnMapping == null || columnMapping.isEmpty()){
	    return null;
	}
	List<DSField> keys = new ArrayList<DSField>();
	for (FieldMapping cm : columnMapping) {
	    if (cm.getTargetField() == null) {
		continue;
	    }
	    if (cm.getTargetField().isPrimaryKey()) {
		keys.add(cm.getTargetField());
	    }
	}
	return keys.isEmpty() ? null : keys;
    }
}
