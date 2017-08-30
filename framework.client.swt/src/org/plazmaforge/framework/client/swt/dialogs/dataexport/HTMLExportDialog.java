package org.plazmaforge.framework.client.swt.dialogs.dataexport;



import org.eclipse.swt.widgets.Shell;

/**
 * Dialog for obtaining HTML export options.
 * 
 * 
 */
public class HTMLExportDialog extends AbstractExportDialog {

	private static final String[] FILTER = { "*.html", "*.htm" };

	private static final int FLAGS = FMT_ENCODING | FMT_NULL | OPT_HDR | PATTERN_DATE | PATTERN_TIME | PATTERN_NUMBER;

	public HTMLExportDialog(Shell parentShell) {
		super(parentShell);
	}

	public String[] getFileFilter() {
		return FILTER;
	}

	public int getFlags() {
		return FLAGS;
	}

	public String getMessage() {
		return Messages.getString("ExportDialog.html.message");
	}

	public String getTitle() {
		return Messages.getString("ExportDialog.html.title");
	}
	protected boolean isCheckFile() {
		return true;
	}


}
