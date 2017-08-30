package org.plazmaforge.framework.client.swt.dialogs.dataimport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.framework.client.swt.SWTResourceManager;
import org.plazmaforge.framework.client.swt.dialogs.IValidator;
import org.plazmaforge.framework.core.datastorage.DSDataSet;
import org.plazmaforge.framework.core.datastorage.DSField;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.core.exception.DSException;
import org.plazmaforge.framework.core.type.TypeUtils;
import org.plazmaforge.framework.datawarehouse.FieldMapping;
import org.plazmaforge.framework.datawarehouse.ITransferService;
import org.plazmaforge.framework.datawarehouse.TransferInfo;
import org.plazmaforge.framework.datawarehouse.convert.ISourceService;
import org.plazmaforge.framework.datawarehouse.convert.dataimport.IDataSetImporter;
import org.plazmaforge.framework.sql.JDBCEnvironment;
import org.plazmaforge.framework.util.ErrorUtils;
import org.plazmaforge.framework.util.StringUtils;

public class ColumnMappingPanel extends Composite {

    public static final String TARGET_COLUMN = "TARGET_COLUMN";

    public static final String KEY = "KEY";
    
    public static final String TYPE = "TYPE";

    public static final String SOURCE_COLUMN = "SOURCE_COLUMN";
    
    
    public static final String[] TABLE_COLUMNS = {KEY, TARGET_COLUMN,  TYPE, SOURCE_COLUMN};
    
    public static final String[] TRANSFER_ACTIONS = {TransferInfo.INSERT_ACTION, TransferInfo.UPDATE_ACTION, TransferInfo.UPDATE_INSERT_ACTION};
    
    protected final Logger logger = Logger.getLogger(getClass());
    
    
    private static final int LOAD_SOURCE_COLUMNS = 1;
    
    private static final int LOAD_TARGET_COLUMNS = 2;
    
    
    
    private TableViewer mappingViewer;
    
    private Button loadTargetColumnsButton;
   
    private Button loadSourceColumnsButton;
    
    
    private Combo actionCombo; 
    
    private Button clearTableOption;
    
    private Button autoincrementPkOption;
    

    private ITransferService transferService;
    
    private ISourceService sourceService;
    
    private IValidator validator;
    
    
    
    private String tableName;
    
    private List<FieldMapping> columnMappings = new ArrayList<FieldMapping>();
    
    private String[] sourceColumns;
    
    private ComboBoxCellEditor sourceColumnEditor;
    
    ////
    
    private String lastLoadTableName;
    
    private String lastLoadFileName;
    
    
    private boolean hasPrimaryKeys;
    
    private boolean hasOnlyOnePrimaryKey;
    
    private boolean hasAutoIncrementPrimaryKey;
    
    ////
    
    private IDataSetImporter dataSetImporter;
    
    private boolean customMode;
    
    
    public ColumnMappingPanel(Composite parent, int style, ITransferService transferService, ISourceService sourceService) {
	super(parent, style);
	
	this.transferService = transferService;
	this.sourceService = sourceService;
	
	///
	
	GridLayout gridlayout = new GridLayout(1, false);
        setLayout(gridlayout);
        
        createManagerButtonBar(this);
        
        mappingViewer = createTable(this); //$NON-NLS-1$
        mappingViewer.setInput(columnMappings);
        
        updateState();
        validate();
    }
    
    public void doLoadTargetColumns() {
        try {
            

            hasPrimaryKeys = false;
            hasOnlyOnePrimaryKey = false;
            int primaryKeysCount = 0;
            
            DSDataSet columnsDataSet = loadTableColumnsDataSet();
            DSDataSet primaryKeysDataSet = loadTablePrimaryKeysDataSet();

            // RESET ALL TARGET COLUMNS
            resetAllTargetColumns();

            if (columnsDataSet == null) {
        	removeAllAfterEmptySourceColumns();
        	mappingViewer.refresh();
        	return;
            }
            
            /*
       	     *
       	     *	<LI><B>TABLE_CAT</B> String => table catalog (may be <code>null</code>)
       	     *	<LI><B>TABLE_SCHEM</B> String => table schema (may be <code>null</code>)
       	     *	<LI><B>TABLE_NAME</B> String => table name
       	     *	<LI><B>COLUMN_NAME</B> String => column name
       	     *	<LI><B>DATA_TYPE</B> int => SQL type from java.sql.Types
       	     *	<LI><B>TYPE_NAME</B> String => Data source dependent type name,
       	     *  for a UDT the type name is fully qualified
       	     *	<LI><B>COLUMN_SIZE</B> int => column size.  
       	     *	<LI><B>BUFFER_LENGTH</B> is not used.
       	     *	<LI><B>DECIMAL_DIGITS</B> int => the number of fractional digits. Null is returned for data types where 
       	     * DECIMAL_DIGITS is not applicable.
       	     *	<LI><B>NUM_PREC_RADIX</B> int => Radix (typically either 10 or 2)
       	     *	<LI><B>NULLABLE</B> int => is NULL allowed.
       	     *      <UL>
       	     *      <LI> columnNoNulls - might not allow <code>NULL</code> values
       	     *      <LI> columnNullable - definitely allows <code>NULL</code> values
       	     *      <LI> columnNullableUnknown - nullability unknown
       	     *      </UL>
       	     *	<LI><B>REMARKS</B> String => comment describing column (may be <code>null</code>)
       	     * 	<LI><B>COLUMN_DEF</B> String => default value for the column, which should be interpreted as a string when the value is enclosed in single quotes (may be <code>null</code>)
       	     */
        	     
        	     
            int mappingCount = columnMappings.size();
            int columnIndex = -1;
            FieldMapping columnMapping = null;
            
            //List<IDataSetRow> rows = columnsDataSet.getRows();
            while (columnsDataSet.next()) {
        	Object[] row = columnsDataSet.getRecord();
        	columnIndex++;
        	Object columnNameObj = row[3]; 
        	Object dataTypeObj = row[4];
        	Object columnTypeObj = row[5];
        	
        	String columnName = columnNameObj == null ? null : columnNameObj.toString();
        	Integer dataType = dataTypeObj == null ? null : new Integer(dataTypeObj.toString());
        	String columnType = columnTypeObj == null ? null : columnTypeObj.toString();;
        	
        	if (columnIndex > mappingCount - 1) {
        	    columnMapping = new FieldMapping();
        	    columnMappings.add(columnMapping);
        	} else {
        	    columnMapping = columnMappings.get(columnIndex);
        	}
        	
        	DSField targetColumn = new DSField();
        	if (dataType != null){
        	    String type = TypeUtils.getType(JDBCEnvironment.getClass(dataType));
        	    targetColumn.setDataType(type);
        	}
        	targetColumn.setDataType(columnType);
        	
        	targetColumn.setName(columnName);
        	if (isCustomMode()){
        	    Object displayNameObj = row[11];
        	    targetColumn.setCaption(displayNameObj == null ? null : (String) displayNameObj);
        	}
        	
        	boolean isPrimaryKey = isPrimaryKey(columnName, primaryKeysDataSet);
        	if (isPrimaryKey) {
        	    if (primaryKeysCount == 0) {
        		hasAutoIncrementPrimaryKey = TransferInfo.isAutoIncrementPK(targetColumn.getDataType());
        	    }
        	    primaryKeysCount++; 
        	}
        	targetColumn.setPrimaryKey(isPrimaryKey);
        	columnMapping.setTargetField(targetColumn);
        	
            }
            hasPrimaryKeys = primaryKeysCount > 0;
            hasOnlyOnePrimaryKey = primaryKeysCount == 1;
            
            removeAllAfterEmptyTargetColumns();
            
            mappingViewer.refresh();
            
        } catch (Throwable ex) {
            handleError("Loading Table Columns Error", ex);
        } finally {
            updateState();
            validate();
        }
        
    }
    
    public void internalUpdateState() {
	
	String action = getTransferAction();
	
	// We can clear table only for INSERT action
	clearTableOption.setEnabled(TransferInfo.INSERT_ACTION.equals(action));
	
	// We can generate PK only for INSERT action type
	if (!TransferInfo.isInsertActionType(action)) {
	    autoincrementPkOption.setEnabled(false);
	    return;
	}
	
	autoincrementPkOption.setEnabled(hasOnlyOnePrimaryKey && hasAutoIncrementPrimaryKey);
	
    }
    
    public void updateState() {
	
	internalUpdateState();
	
	if (dataSetImporter == null) {
	    return;
	}
	
	if (clearTableOption.getEnabled() && !dataSetImporter.isEnableClearTable()) {
	    clearTableOption.setEnabled(false);
	    clearTableOption.setSelection(dataSetImporter.isClearTable());
	}

	if (autoincrementPkOption.getEnabled() && !dataSetImporter.isEnableAutoPrimaryKey()) {
	    autoincrementPkOption.setEnabled(false);
	    autoincrementPkOption.setSelection(dataSetImporter.isAutoPrimaryKey());
	}

    }
    
    
    private boolean isPrimaryKey(String columnName, DSDataSet primaryKeysDataSet) throws DSException {
	if (columnName == null || primaryKeysDataSet == null) {
	    return false;
	}
	if (primaryKeysDataSet.isEmpty()) {
	    return false;
	}
	while (primaryKeysDataSet.next()) {
	    Object[] row = primaryKeysDataSet.getRecord();
	    String pkColumnName = row[3].toString();
	    if (columnName.equals(pkColumnName)) {
		return true;
	    }
	}
	return false;
    }
    
    public void doLoadSourceColumns() {

	try {


	    sourceColumns = loadSourceColumnsArray();
	    sourceColumnEditor.setItems(getSourceColumnsItems());

	    // RESET ALL SOURCE COLUMNS
	    resetAllSourceColumns();

	    if (sourceColumns == null || sourceColumns.length == 0) {
		removeAllAfterEmptyTargetColumns();
		mappingViewer.refresh();
		return;
	    }
	    boolean expand = isEmptyAllTargetColumns();
	    int mappingCount = columnMappings.size();
	    FieldMapping columnMapping = null;
	    for (int columnIndex = 0; columnIndex < sourceColumns.length; columnIndex++) {
		String columnName = sourceColumns[columnIndex];
		if (columnIndex > mappingCount - 1) {
		    if (!expand) {
			break;
		    }
		    columnMapping = new FieldMapping();
		    columnMappings.add(columnMapping);
		} else {
		    columnMapping = columnMappings.get(columnIndex);
		}
		DSField sourceColumn = new DSField();
		sourceColumn.setName(columnName);
		columnMapping.setSourceField(sourceColumn);

	    }

	    mappingViewer.refresh();

	} catch (Throwable ex) {
	    handleError("Loading Source Columns Error", ex);
	} finally {
	    validate();
	}

    }
    
    protected String[] getSourceColumnsItems() {
	List<String> items = new ArrayList<String>();
	items.add("");
	if (sourceColumns != null && sourceColumns.length > 0) {
	    for (String c : sourceColumns) {
		items.add(c);
	    }
	}
	return (String[]) items.toArray(new String[0]);
    }
    
    protected String[] loadSourceColumnsArray() throws ApplicationException {
	String[] sourceColumns = null;
	ISourceService service = getSourceService();
	if (service == null) {
	    throw new ApplicationException("SourceService is null");
	}
	String fileName = service.getFileName();
	sourceColumns = service.getSourceColumns();

	// STORE SUCCES LOADING FILE NAME
	lastLoadFileName = fileName;

	if (sourceColumns == null || sourceColumns.length == 0) {
	    return null;
	}
	return sourceColumns;
    }
    
    protected boolean isEmptyColumnMannings() {
	return columnMappings == null || columnMappings.isEmpty();
    }
    
    protected boolean isEmptyAllTargetColumns() {
	if (isEmptyColumnMannings()) {
	    return true;
	}
	for (FieldMapping columnMapping : columnMappings) {
	    if (columnMapping.getTargetField() != null) {
		return false;
	    }
	}
	return true;
    }
    
    protected void resetAllTargetColumns() {
	if (isEmptyColumnMannings()) {
	    return;
	}
	for (FieldMapping columnMapping : columnMappings) {
	    columnMapping.setTargetField(null);
	}
    }
    
    protected void resetAllSourceColumns() {
	if (isEmptyColumnMannings()) {
	    return;
	}
	for (FieldMapping columnMapping : columnMappings) {
	    columnMapping.setSourceField(null);
	}
    }
    
    protected void removeAllAfterEmptyTargetColumns() {
	if (isEmptyColumnMannings()) {
	    return;
	}
	int size = columnMappings.size();
	int index = -1;
	for (int i = size -1; i >= 0; i--) {
	    FieldMapping cm = columnMappings.get(i);
	    if (cm.getTargetField() == null) {
		index = i;
	    }
	}
	removeFromIndex(index);
    }
    
    protected void removeAllAfterEmptySourceColumns() {
	if (isEmptyColumnMannings()) {
	    return;
	}
	int size = columnMappings.size();
	int index = -1;
	for (int i = size -1; i >= 0; i--) {
	    FieldMapping cm = columnMappings.get(i);
	    if (cm.getSourceField() == null) {
		index = i;
	    }
	}
	removeFromIndex(index);
    }
    
    
    protected void removeFromIndex(int index) {
	if (isEmptyColumnMannings()) {
	    return;
	}
	if (index < 0) {
	    return;
	}
	Iterator<FieldMapping> itr = columnMappings.iterator();
	int i = -1;
	while (itr.hasNext()) {
	    i++;
	    itr.next();
	    if (i >= index) {
		itr.remove();
	    }
	}
    }
    
    protected DSDataSet loadTableColumnsDataSet() throws ApplicationException {
	ITransferService service = getTransferService();
	if (service == null) {
	    throw new ApplicationException("DatabaseService is null");
	}
	String tableName = getTableName();

	if (StringUtils.isEmpty(tableName)) {
	    return null;
	}
	DSDataSet columnsDataSet = service.getColumnsDataSet(tableName);

	// STORE SUCCES LOADING TABLE NAME
	lastLoadTableName = tableName;

	if (columnsDataSet == null) {
	    return null;
	}
	if (columnsDataSet.isEmpty()) {
	    return null;
	}

	return columnsDataSet;
    }
    
    protected DSDataSet loadTablePrimaryKeysDataSet() throws ApplicationException {
	ITransferService service = getTransferService();
	if (service == null) {
	    throw new ApplicationException("DatabaseService is null");
	}
	String tableName = getTableName();

	if (StringUtils.isEmpty(tableName)) {
	    return null;
	}
	DSDataSet primaryKeysDataSet = service.getPrimaryKeysDataSet(tableName);

	if (primaryKeysDataSet == null) {
	    return null;
	}
	if (primaryKeysDataSet.isEmpty()) {
	    return null;
	}

	return primaryKeysDataSet;
    }
    
    private void createManagerButtonBar(Composite parent)  {
        Composite composite = new Composite(parent, 0);
        GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 4;
        composite.setLayout(gridLayout);
        
        //composite.setLayout(new FillLayout(SWT.HORIZONTAL));

        loadTargetColumnsButton = new Button(composite, SWT.NONE);
        loadTargetColumnsButton.setLayoutData(new GridData(SWT.FILL, SWT.NONE, false, false));
        loadTargetColumnsButton.setText(Messages.getString("ColumnMappingPanel.load.target.columns")); //$NON-NLS-1$
        loadTargetColumnsButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
        	doAction(LOAD_TARGET_COLUMNS);
            }
        });

        
        loadSourceColumnsButton = new Button(composite, SWT.NONE);
        loadSourceColumnsButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
        loadSourceColumnsButton.setText(Messages.getString("ColumnMappingPanel.load.source.columns")); //$NON-NLS-1$
        loadSourceColumnsButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
        	doAction(LOAD_SOURCE_COLUMNS);
            }
        });
        
        Label actionLabel = new Label(composite, SWT.NONE);
        GridData gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
        gridData.horizontalIndent = 10;
        actionLabel.setLayoutData(gridData);
        actionLabel.setText(Messages.getString("ColumnMappingPanel.action"));
        
        actionCombo = new Combo(composite, SWT.BORDER | SWT.READ_ONLY);
        actionCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
        
        actionCombo.add(Messages.getString("ColumnMappingPanel.action.insert"));
        actionCombo.add(Messages.getString("ColumnMappingPanel.action.update"));
        actionCombo.add(Messages.getString("ColumnMappingPanel.action.update.or.insert"));
        
        actionCombo.select(0);
        
        actionCombo.addSelectionListener(new SelectionListener() {
	    public void widgetSelected(SelectionEvent selectionevent) {
		updateState();
		validate();
	    }

	    public void widgetDefaultSelected(SelectionEvent selectionevent) {
		
	    }
	});
        
        clearTableOption = new Button(composite, SWT.CHECK);
        clearTableOption.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
        clearTableOption.setText(Messages.getString("ColumnMappingPanel.clearTable"));
        
        autoincrementPkOption = new Button(composite, SWT.CHECK);
        autoincrementPkOption.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
        autoincrementPkOption.setText(Messages.getString("ColumnMappingPanel.autoincrementPk"));

      
    }
    
    private TableViewer createTable(Composite parent) {
	Composite composite1 = new Composite(parent, 0);
	composite1.setLayout(new GridLayout(1, false));
	GridData gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
	composite1.setLayoutData(gridData);
	
	//Table table = new Table(composite1, SWT.BORDER | SWT.FULL_SELECTION);
	//gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
	//gridData.heightHint = 150; //300;
	//table.setLayoutData(gridData);
	
	CheckboxTableViewer tableviewer = CheckboxTableViewer.newCheckList(composite1, SWT.BORDER | SWT.FULL_SELECTION);
	tableviewer.addCheckStateListener(new ICheckStateListener() {

	    public void checkStateChanged(CheckStateChangedEvent event) {
		FieldMapping cm = (FieldMapping) event.getElement();
		cm.setKey(event.getChecked());
		validate();
		
	    }
	    
	});

	Table table = tableviewer.getTable();
	gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
	gridData.heightHint = 150; //300;
	table.setLayoutData(gridData);

	TableColumn keyColumn = new TableColumn(table, SWT.NONE);
	keyColumn.setText(Messages.getString("ColumnMappingPanel.key.column"));
	keyColumn.setWidth(50);

	
	TableColumn targetColumn = new TableColumn(table, SWT.NONE);
	targetColumn.setText(Messages.getString("ColumnMappingPanel.target.column"));
	targetColumn.setWidth(200);
	
	
	TableColumn typeColumn = new TableColumn(table, SWT.NONE);
	typeColumn.setText(Messages.getString("ColumnMappingPanel.type.column"));
	typeColumn.setWidth(150);
	
	TableColumn sourceColumn = new TableColumn(table, SWT.NONE);
	sourceColumn.setText(Messages.getString("ColumnMappingPanel.source.column"));
	sourceColumn.setWidth(200);
	
	table.setHeaderVisible(true);
	table.setLinesVisible(true);
	
	//TableViewer tableviewer = new TableViewer(table);
	//TableViewer tableviewer = new CheckboxTableViewer(table);
	
	
	tableviewer.setContentProvider(new IStructuredContentProvider() {

	    public Object[] getElements(Object obj) {
		if (obj instanceof Collection)
		    return ((Collection) obj).toArray();
		else
		    return null;
	    }

	    public void dispose() {
	    }

	    public void inputChanged(Viewer viewer, Object obj, Object obj1) {
	    }

	});
	tableviewer.setLabelProvider(new TableLabelProvider());

	tableviewer.addDoubleClickListener(new IDoubleClickListener() {

	    public void doubleClick(DoubleClickEvent doubleclickevent) {
		IStructuredSelection selection = (IStructuredSelection) doubleclickevent.getSelection();

		 Object  element  = selection.getFirstElement();
		 if (element == null) {
		     return;
		 }
		 

		 //TODO
	    }

	});
	//tableviewer.setSorter(new TableSorter());
	
	
	 // Create the cell editors
	CellEditor[] editors = new CellEditor[4];
	sourceColumnEditor = new ComboBoxCellEditor(table, getSourceColumnsItems(), SWT.READ_ONLY);
	editors[0] = null;
	editors[1] = null;
	editors[2] = null; // new CheckboxCellEditor(table); 
	editors[3] = sourceColumnEditor;

	// Set the editors, cell modifier, and column properties
	tableviewer.setColumnProperties(TABLE_COLUMNS);
	tableviewer.setCellModifier(new MappingCellModifier(tableviewer));
	tableviewer.setCellEditors(editors);

	return tableviewer;
    }
    
    class TableLabelProvider extends LabelProvider implements ITableLabelProvider {
	
	public String getColumnText(Object element, int columnIndex) {
	    FieldMapping cm = (FieldMapping) element;
	    if (columnIndex == 0) {
		return null;
	    } else if (columnIndex == 1) {
		return getTargetColumnName(cm);
		//return Boolean.toString(cm.isKey());
	    } else if (columnIndex == 2) {
		return getTargetColumnType(cm);
	    } else if (columnIndex == 3) {
		return getSourceColumnName(cm);
	    }
	    return null;
	}

	public Image getColumnImage(Object element, int columnIndex) {
	    if (columnIndex == 0) {
		return getImage(element);
	    }
	    return null; 
	    
	}
	
	 public Image getImage(Object obj) {
	     return getResourceImage("/org/plazmaforge/framework/client/images/eclipse/rdb/table.gif");   
	 }

	 
    }
    
    protected String getTargetColumnName(FieldMapping cm) {
	if (cm == null || cm.getTargetField() == null) {
	    return "";
	}
	String str = cm.getTargetField().getDisplayName();
	return (str == null) ? "" : str;
    }

    protected String getTargetColumnType(FieldMapping cm) {
	if (cm == null || cm.getTargetField() == null || cm.getTargetField().getDataType() == null) {
	    return "";
	}
	String str = cm.getTargetField().getDataType();
	return (str == null) ? "" : str;
    }

    protected String getSourceColumnName(FieldMapping cm) {
	if (cm == null || cm.getSourceField() == null) {
	    return "";
	}
	String str = cm.getSourceField().getDisplayName();
	return (str == null) ? "" : str;
    }
    
   
    protected void doAction(int action) {
	if (action == LOAD_SOURCE_COLUMNS) {
	    doLoadSourceColumns();
	} else if (action == LOAD_TARGET_COLUMNS) {
	    doLoadTargetColumns();
	}
    }
    

    ////
    
    public Image getResourceImage(String path) {
	return SWTResourceManager.getImage(getClass(), path);
    }


    public ITransferService getTransferService() {
        return transferService;
    }
    

    public void setTransferService(ITransferService databaseService) {
        this.transferService = databaseService;
    }

    
    public ISourceService getSourceService() {
        return sourceService;
    }

    public void setSourceService(ISourceService sourceService) {
        this.sourceService = sourceService;
    }

    
    
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<FieldMapping> getColumnMappings() {
        return columnMappings;
    }

    

    ////
    
    class MappingCellModifier implements ICellModifier {

	private Viewer viewer;

	public MappingCellModifier(Viewer viewer) {
	    this.viewer = viewer;
	}

	public boolean canModify(Object element, String property) {
	    return SOURCE_COLUMN.equals(property) || KEY.equals(property);
	}

	public Object getValue(Object element, String property) {
	    FieldMapping cm = (FieldMapping) element;
	    if (SOURCE_COLUMN.equals(property)) {
		String name = getSourceColumnName(cm);
		if (name == null) {
		    name = "";
		}
		int index = indexOfItem(name);
		// Fixed index because index must be in range 0..n
		//if (index < 0) {
		//    index = 0;
		//}
		return index;
	    } //else if (KEY.equals(property)) {
//		return Boolean.valueOf(cm.isKey());
//	    }
	    return null;
	}

	  public void modify(Object element, String property, Object value) {
	      
	    if (element instanceof Item) {
		element = ((Item) element).getData();
	    }
	      

	    FieldMapping cm = (FieldMapping) element;
	    if (SOURCE_COLUMN.equals(property)) {
		DSField sourceColumn = (DSField) cm.getSourceField();
		if (sourceColumn == null) {
		    sourceColumn = new DSField();
		    cm.setSourceField(sourceColumn);
		}
		Integer index = (Integer) value;
		String name = null;
		if (index != null) {
		    name = getItem(index);
		}
		sourceColumn.setName(name);

		// Force the viewer to refresh
		viewer.refresh();
		validate();

	    } //else if (KEY.equals(property)) {
//		cm.setKey((Boolean) value);
//		
//		// Force the viewer to refresh
//		viewer.refresh();
//	    }
	    
	  }
	}

    private int indexOfItem(String name) {
	return indexOf(sourceColumnEditor.getItems(), name); 
    }
    
    private String getItem(int index) {
	if (index < 0) {
	    return null;
	}
	String[] items = sourceColumnEditor.getItems();
	if (index > items.length - 1) {
	    return null;
	}
	return items[index];
    }
    
    
    private int indexOf(String[] array, String str) {
	if (str == null || array == null || array.length == 0) {
	    return -1;
	}
	for (int i = 0 ; i < array.length; i++) {
	    if (str.equals(array[i])) {
		return i;
	    }
	}
	return -1;
    }

    public String getLastLoadTableName() {
        return lastLoadTableName;
    }

    public String getLastLoadFileName() {
        return lastLoadFileName;
    }


    protected void validate() {
	if (getValidator() == null) {
	    return;
	}
	getValidator().validate();
    }

    public IValidator getValidator() {
        return validator;
    }

    public void setValidator(IValidator validator) {
        this.validator = validator;
    }
    
    protected void handleError(String title, Throwable ex) {
	logger.error(title, ex);
	openErrorDialog(title, ex);
    }
    protected void openErrorDialog(String title, Throwable ex) {
	MessageDialog.openError(getShell(), title, ErrorUtils.getMessage(ex));
    }
    
    public String getTransferAction() {
	int index = actionCombo.getSelectionIndex();
	if (index < 0) {
	    index = 0;
	}
	return TRANSFER_ACTIONS[index];
    }
    
    public String getTransferActionName() {
	return actionCombo.getText();
    }
    
    public boolean isClearTableOption(){
	return clearTableOption.isEnabled() && clearTableOption.getSelection();
    }
    
    public boolean isAutoincrementPkOption(){
	return autoincrementPkOption.isEnabled() && autoincrementPkOption.getSelection();
    }

    public IDataSetImporter getDataSetImporter() {
        return dataSetImporter;
    }

    public void setDataSetImporter(IDataSetImporter dataSetImporter) {
        this.dataSetImporter = dataSetImporter;
    }

    public boolean isCustomMode() {
        return customMode;
    }

    public void setCustomMode(boolean customMode) {
        this.customMode = customMode;
    }


    
    
}
