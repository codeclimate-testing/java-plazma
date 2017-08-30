

package org.plazmaforge.framework.client.swt.dialogs.dataexport;


import org.eclipse.swt.widgets.Shell;


public class XMLExportDialog extends AbstractExportDialog {

	private static final String[] FILTER = { "*.xml"};

	private static final int FLAGS = FMT_ENCODING | FMT_NULL | OPT_HDR | PATTERN_DATE | PATTERN_TIME | PATTERN_NUMBER;

	public XMLExportDialog(Shell parentShell) {
		super(parentShell);
	}

	public String[] getFileFilter() {
		return FILTER;
	}

	public int getFlags() {
		return FLAGS;

	}

	public String getMessage() {
		return Messages.getString("ExportDialog.xml.message");
	}

	public String getTitle() {
		return Messages.getString("ExportDialog.xml.title");
	}
	
	protected boolean isCheckFile() {
		return true;
	}


}

