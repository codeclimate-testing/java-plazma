package org.plazmaforge.framework.client.swt.dialogs.dataexport;



import org.eclipse.swt.widgets.Shell;

/**
 * Dialog for obtaining CSV export options.
 * 
 * 
 */
public class CSVExportDialog extends AbstractExportDialog {

	private static final String[] FILTER = { "*.csv", "*.txt" };

	private static final int FLAGS = FMT_ENCODING | FMT_DELIM | FMT_NULL | OPT_HDR | OPT_QUOTE | OPT_TRIM | PATTERN_DATE | PATTERN_TIME | PATTERN_NUMBER;

	public CSVExportDialog(Shell parentShell) {
		super(parentShell);
	}

	public String[] getFileFilter() {
		return FILTER;
	}

	public int getFlags() {
		return FLAGS;

	}

	public String getMessage() {
		return Messages.getString("ExportDialog.csv.message");
	}

	public String getTitle() {
		return Messages.getString("ExportDialog.csv.title");
	}
	
	protected boolean isCheckFile() {
		return true;
	}

}
