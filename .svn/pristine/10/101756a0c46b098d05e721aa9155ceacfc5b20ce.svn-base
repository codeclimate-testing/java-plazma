

package org.plazmaforge.framework.client.swt.dialogs.dataexport;

import org.eclipse.swt.widgets.Shell;


public class SQLExportDialog extends AbstractExportDialog {

	private static final String[] FILTER = { "*.sql", "*.txt" };

	private static final int FLAGS = FMT_ENCODING | PATTERN_DATE | PATTERN_TIME;
	
	public SQLExportDialog(Shell parentShell) {
		super(parentShell);
	}

	public String[] getFileFilter() {
		return FILTER;
	}

	public int getFlags() {
		return FLAGS;

	}

	public String getMessage() {
		return Messages.getString("ExportDialog.sql.message");
	}

	public String getTitle() {
		return Messages.getString("ExportDialog.sql.title");
	}
	
	protected boolean isCheckFile() {
		return true;
	}


}

