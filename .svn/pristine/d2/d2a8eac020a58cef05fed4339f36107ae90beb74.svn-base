package org.plazmaforge.framework.client.swt.dialogs.dataexport;




import java.io.File;
import java.text.MessageFormat;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.plazmaforge.framework.client.swt.dialogs.AbstractConvertDialog;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.datawarehouse.convert.IConfigurer;
import org.plazmaforge.framework.datawarehouse.convert.dataexport.IExporter;


/**
 * Abstract base dialog for obtaining data export options.
 * 
 * 
 */
public abstract class AbstractExportDialog extends AbstractConvertDialog {


    protected TablesSelectionPanel tablesSelectionPanel;
    
    private String[] tableNames;
    
    public AbstractExportDialog(Shell parentShell) {
	super(parentShell);
    }

	
    protected void populateData() {
	super.populateData();
	tableNames = getSelectionTableNames();
    }
    
    protected void populateTablesSelectionConfigurer() {
	getConfigurer().getProperty(IConfigurer.TABLE_NAMES, getTableNames());
	getConfigurer().getProperty(IConfigurer.DIRECTORY_NAME, getFileName()); // ONLY FOR DATABASE EXPORT
    }

    
    protected void createTablesSelectionOptions(Composite parent) {
	Group group = new Group(parent, SWT.SHADOW_ETCHED_IN);
	initPanelLayoutData(group);
	group.setLayout(new FillLayout());
	
	tablesSelectionPanel = new TablesSelectionPanel(group, SWT.NONE, getTransferService());
	tablesSelectionPanel.setValidator(createValidator());
    }
    
    
    /**
     * Initialize Exporter by this dialog
     * @param exporter
     * @throws ApplicationException
     */
    public void initExporter(final IExporter exporter) throws ApplicationException {
	initConverter(exporter);
    }
    
    

    ////
    
    public String[] getTableNames() {
        return tableNames;
    }


    protected String[] getSelectionTableNames() {
	if (tablesSelectionPanel == null) {
	    return null;
	}
	return tablesSelectionPanel.getTableNames();
    }

    protected boolean isValidTableNames() {
	String[] tableNames = getSelectionTableNames();
	if (isEmptyAll(tableNames)) {
	    setErrorMessage(getTablesErrorMessage());
	    return false;
	}
	return true;
    }

    protected String getGroupFileMessage() {
	return Messages.getString("ExportDialog.group.file");
    }

    protected String getGroupDirectoryMessage() {
	return Messages.getString("ExportDialog.group.directory");
    }
    
    ////
    
    protected String getTablesErrorMessage() {
	return Messages.getString("ExportDialog.error.tables");
    }

    protected boolean isConfirmReplaceIfExists() {
	return isConfirmReplaceIfExists(getFileName());
    }
    
    protected boolean isConfirmReplaceIfExists(String fileName) {
	if (isEmpty(fileName)) {
	    return true;
	}
	File file =  new File(fileName);
	if (!file.exists()) {
	    return true;
	}
	return MessageDialog.openConfirm(getShell(), "Confirm", MessageFormat.format(Messages.getString("ExportDialog.confirm.replace.file"), new Object[] {file.getAbsolutePath()}));
	//return MessageDialog.openConfirm(getShell(), "Confirm", "File '" + file.getAbsolutePath() + "' exists. Are you sure you want to replace the file?");
    }
    
    protected boolean isCheckFile() {
	return false;
    }
    
    protected boolean isCheckData() {
	if (isCheckFile()) {
	    if (!isConfirmReplaceIfExists()) {
		return false;
	    }
	}
	return true;
    }
    
 
}