package org.plazmaforge.framework.client.swt.dialogs.dataimport;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;
import org.plazmaforge.framework.core.FileFormat;

public class ImportDialogFactory {

    private ImportDialogFactory() {

    }

    /**
     * Return <code>Dialog</code> to configure import by format 
     * @param format
     * @param shell
     * @return
     */
    public static Dialog getImportDialog(String format, Shell shell) {
	if (FileFormat.XML.equals(format)) {
	    return new XMLImportDialog(shell);
	} else if (FileFormat.CSV.equals(format)) {
	    return new CSVImportDialog(shell);
	} else if (FileFormat.DATABASE_XML.equals(format)) {
	    return new DatabaseXMLImportDialog(shell);
	} else if (FileFormat.DATABASE_CSV.equals(format)) {
	    return new DatabaseCSVImportDialog(shell);
	} 
 	
	return null;
    }
}
