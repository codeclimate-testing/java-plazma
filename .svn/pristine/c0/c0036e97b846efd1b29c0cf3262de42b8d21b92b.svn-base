package org.plazmaforge.framework.client.swt.dialogs.dataimport;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

public class DatabaseXMLImportDialog extends XMLImportDialog {

    public DatabaseXMLImportDialog(Shell parentShell) {
	super(parentShell);
    }

    protected void createDetailOptions(Composite parent) {
	createSelectionTableOptions(parent);
	createColumnMappingOptions(parent);
    }
    
    protected void populateData() {
	super.populateData();
	setTableName(getSelectionTableName());
    }
    
}
