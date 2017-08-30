package org.plazmaforge.framework.client.swt.dialogs.dataimport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.plazmaforge.framework.client.swt.dialogs.AbstractConvertDialog;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.datawarehouse.FieldMapping;
import org.plazmaforge.framework.datawarehouse.ITransferService;
import org.plazmaforge.framework.datawarehouse.TransferInfo;
import org.plazmaforge.framework.datawarehouse.convert.IConfigurer;
import org.plazmaforge.framework.datawarehouse.convert.dataimport.IDataSetImporter;
import org.plazmaforge.framework.datawarehouse.convert.dataimport.IImporter;


public abstract class AbstractImportDialog extends AbstractConvertDialog {

    protected Combo tableSelectionControl;
    
    protected ColumnMappingPanel columnMappingPanel;
    
    ////
    
    private String tableName;
    
    private List<FieldMapping> columnMappings;
   
    private Map<String, IDataSetImporter> importerMap = new HashMap<String, IDataSetImporter>(); 
   
    protected String[][] tableNames;
    
    public AbstractImportDialog(Shell parentShell) {
	super(parentShell);
    }

    
    protected void populateData() {
	super.populateData();
	//tableName = getSelectionTableName(); // REFACTORED 2010-05-18
	columnMappings = getSelectionColumnMappings();
    }

    protected void populateConfigurer() {
	super.populateConfigurer();
	getConfigurer().getProperty(IConfigurer.TABLE_NAME, getTableName());
	getConfigurer().getProperty(IConfigurer.COLUMN_MAPPINGS, getColumnMappings());
	getConfigurer().getProperty(IConfigurer.TRANSFER_ACTION, getTransferAction());
	getConfigurer().getProperty(IConfigurer.TRANSFER_CLEAR_TABLE, isClearTableOption());
	getConfigurer().getProperty(IConfigurer.TRANSFER_AUTOINCREMENT_PK, isAutoincrementPkOption());
    }

    
    protected void createSelectionTableOptions(Composite parent) {
	Group group = new Group(parent, SWT.SHADOW_ETCHED_IN);
	group.setText(Messages.getString("ImportDialog.group.table"));
	initPanelLayoutData(group);
	group.setLayout(new GridLayout(1, false));
	tableSelectionControl = new Combo(group, SWT.BORDER | SWT.READ_ONLY);
	tableSelectionControl.setVisibleItemCount(10);
	tableSelectionControl.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
	
	ITransferService service = getTransferService();
	if (service == null) {
	    return;
	}
	try {
	    tableNames = service.getTableNames();
	    if (tableNames == null) {
		return;
	    }
	    int size = tableNames.length;
	    String name = null;
	    String displayName = null;
	    for (int i = 0; i < size; i++) {
		name = tableNames[i][0];
		displayName = tableNames[i][1];
		tableSelectionControl.add(displayName == null ? name : displayName);
	    }
	} catch (Exception ex) {
	    logger.error("Loading tables error", ex);
	}
	
	tableSelectionControl.addSelectionListener(new SelectionListener() {
	    
	    public void widgetSelected(SelectionEvent selectionevent) {
		doSelectTable();
	    }

	    public void widgetDefaultSelected(SelectionEvent selectionevent) {
		
	    }
	    
	});
    }
    
    protected void doSelectTable() {
	try {
	    validate();
	    if (columnMappingPanel == null) {
		return;
	    }
	    String tableName = getSelectionTableName();
	    columnMappingPanel.setTableName(tableName);
	    if (!isCustomMode()) {
		return;
	    }
	    IDataSetImporter importer = getDataSetImporter(tableName);
	    columnMappingPanel.setDataSetImporter(importer);
	    columnMappingPanel.updateState();
	    
	} catch (Exception ex) {
	    logger.error("Selecte table error", ex);
	}
    }
    
    protected IDataSetImporter getDataSetImporter(String tableName) throws ApplicationException {
	IDataSetImporter importer = importerMap.get(tableName);
	if (importer != null) {
	    return importer;
	}
	ITransferService service = getTransferService();
	if (service == null) {
	    return null;
	}
	return service.getDataSetImporter(tableName);
    }
    
    protected void createColumnMappingOptions(Composite parent) {
	Group group = new Group(parent, SWT.SHADOW_ETCHED_IN);
	group.setText(Messages.getString("ImportDialog.column.mapping"));
	initPanelLayoutData(group);
	group.setLayout(new FillLayout());
	
	columnMappingPanel = new ColumnMappingPanel(group, SWT.NONE, getTransferService(), getSourceService());
	columnMappingPanel.setValidator(createValidator());
	columnMappingPanel.setTableName(getTableName());
	columnMappingPanel.setCustomMode(isCustomMode());
	
	if (!isEmpty(columnMappingPanel.getTableName())) {
	    columnMappingPanel.doLoadTargetColumns();
	}
	
    }

    public void setCustomMode(boolean customMode) {
	super.setCustomMode(customMode);
	if (columnMappingPanel == null) {
	    return;
	}
	columnMappingPanel.setCustomMode(isCustomMode());
    }
    
    public String getTableName() {
        return tableName;
    }

    public List<FieldMapping> getColumnMappings() {
        return columnMappings;
    }

    /////
    
    protected String getSelectionTableName() {
	if (tableSelectionControl == null) {
	    return null;
	}
	int index = tableSelectionControl.getSelectionIndex();
	if (index < 0) {
	    return null;
	}
	return tableNames[index][0];
	//return tableSelectionControl.getItem(index);
    }

    protected List<FieldMapping> getSelectionColumnMappings() {
	if (columnMappingPanel == null) {
	    return null;
	}
	return columnMappingPanel.getColumnMappings();
    }

    protected String getTransferAction() {
	return (columnMappingPanel == null) ? null : columnMappingPanel.getTransferAction();
    }

    protected String getTransferActionName() {
	return (columnMappingPanel == null) ? null : columnMappingPanel.getTransferActionName();
    }

    public boolean isClearTableOption(){
	return (columnMappingPanel == null) ? false : columnMappingPanel.isClearTableOption();
    }
    
    public boolean isAutoincrementPkOption(){
	return (columnMappingPanel == null) ? false : columnMappingPanel.isAutoincrementPkOption();
    }
    
    ////
    
    protected String getLastLoadFileName() {
	return columnMappingPanel == null ? null : columnMappingPanel.getLastLoadFileName();
    }

    protected String getLastLoadTableName() {
	return columnMappingPanel == null ? null : columnMappingPanel.getLastLoadTableName();
    }

    ////
    
    public IImporter createLocalImporter() throws ApplicationException {
	return null;
    }

    /**
     * Initialize Importer by this dialog
     * @param importer
     * @throws ApplicationException
     */
    public void initImporter(final IImporter importer) throws ApplicationException {
	initConverter(importer);
    }
    
    
    protected boolean isValid() {
	
	
	
	if (!super.isValid()) {
	    return false;
	}

	// If we use tableSelectionControl then validate
	if (tableSelectionControl != null) {
	    String tableName = getSelectionTableName();
	    if (isEmpty(tableName)) {
		setErrorMessage(getTableErrorMessage());
		return false;
	    }
	}
	
	return isValidMapping();
    }
    
    protected boolean isValidMapping() {
	List<FieldMapping> mapping = getSelectionColumnMappings();
	if (isEmpty(mapping) || !FieldMapping.isValid(mapping)) {
	    setErrorMessage(getMappingEmptyErrorMessage());
	    return false;
	}
	
	// Check sync file name
	String fileName = nullIfEmpty(getSelectionFileName());
	String lastFileName = nullIfEmpty(getLastLoadFileName());
	if (!equalsTrueIfNull(fileName, lastFileName, true)) {
	    setErrorMessage(getMappingSyncFileErrorMessage());
	    return false;
	}

	// If we don't use tableSelectionControl then don't validate
	if (tableSelectionControl == null) {
	    return true;
	}
	
	// Check sync table name
	String tableName = nullIfEmpty(getSelectionTableName());
	String lastTableName = nullIfEmpty(getLastLoadTableName());
	if (!equalsTrueIfNull(tableName, lastTableName, true)) {
	    setErrorMessage(getMappingSyncTableErrorMessage());
	    return false;
	}

	String transferAction = getTransferAction();
	if (TransferInfo.isKeyActionType(transferAction)) {
	    if (!TransferInfo.hasKeys(mapping)) {
		setErrorMessage(Messages.getString("ImportDialog.error.mapping.nokeys") + ": '"+ getTransferActionName() + "'");
		return false;
	    }
	}
	return true;
    }

    ////
    
    protected String getColumnHeadersMessage() {
	return Messages.getString("ImportDialog.options.hdr");
    }
    
    protected String getGroupFileSystemMessage() {
	return Messages.getString("ImportDialog.group.file");
    }

    ////
    
    protected String getTableErrorMessage() {
	return Messages.getString("ImportDialog.error.table");
    }
    
    protected String getMappingEmptyErrorMessage() {
	return Messages.getString("ImportDialog.error.mapping.empty");
    }
    
    protected String getMappingSyncFileErrorMessage() {
	return Messages.getString("ImportDialog.error.mapping.sync.file");
    }
    
    protected String getMappingSyncTableErrorMessage() {
	return Messages.getString("ImportDialog.error.mapping.sync.table");
    }


    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    
    
}
