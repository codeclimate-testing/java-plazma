package org.plazmaforge.framework.client.swt.dialogs.dataexport;



import org.eclipse.swt.widgets.Shell;

/**
 * Dialog for obtaining XLS export options.
 * 
 * 
 */
public class XLSExportDialog extends AbstractExportDialog {

	private static final String[] FILTER = { "*.xls" };

	private static final int FLAGS = OPT_HDR | PATTERN_DATE | PATTERN_TIME | PATTERN_NUMBER;

	public XLSExportDialog(Shell parentShell) {
		super(parentShell);
	}

	public String[] getFileFilter() {
		return FILTER;
	}

	public int getFlags() {
		return FLAGS;
	}

	public String getMessage() {
		return Messages.getString("ExportDialog.xls.message");
	}

	public String getTitle() {
		return Messages.getString("ExportDialog.xls.title");
	}

	protected boolean isCheckFile() {
		return true;
	}

}
