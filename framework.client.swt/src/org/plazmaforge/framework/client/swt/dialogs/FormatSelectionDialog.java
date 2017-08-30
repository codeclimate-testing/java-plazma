package org.plazmaforge.framework.client.swt.dialogs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.framework.client.swt.SWTResourceManager;
import org.plazmaforge.framework.core.FileFormat;


public class FormatSelectionDialog extends TrayDialog {

    public static final Image FORMAT_TXT_IMAGE = getResourceImage("/org/plazmaforge/framework/client/images/format/format-txt.gif");
    
    public static final Image FORMAT_CSV_IMAGE = getResourceImage("/org/plazmaforge/framework/client/images/format/format-csv.gif");
    
    public static final Image FORMAT_XML_IMAGE = getResourceImage("/org/plazmaforge/framework/client/images/format/format-xml.gif");
    
    public static final Image FORMAT_HTML_IMAGE = getResourceImage("/org/plazmaforge/framework/client/images/format/format-html.gif");
    
    public static final Image FORMAT_XLS_IMAGE = getResourceImage("/org/plazmaforge/framework/client/images/format/format-xls.gif");
    
    public static final Image FORMAT_RTF_IMAGE = getResourceImage("/org/plazmaforge/framework/client/images/format/format-rtf.gif");
    
    public static final Image FORMAT_PDF_IMAGE = getResourceImage("/org/plazmaforge/framework/client/images/format/format-pdf.gif");
    

    private static final String[] ID_DELIMITERS = new String[] {"-", "_", ".", ":"};
    
    
    private String title = Messages.getString("FormatSelectionDialog.title");
    private String message = Messages.getString("FormatSelectionDialog.title");

    private Object result[];
    private Object[] elements;
    private LabelProvider labelProvider;

    private TableViewer tableViewer;
    
    private static Map<String, Image> formatImages;
    
    static {
	formatImages = new HashMap<String, Image>();
	formatImages.put(FileFormat.TXT, FORMAT_TXT_IMAGE);
	formatImages.put(FileFormat.CSV, FORMAT_CSV_IMAGE);
	formatImages.put(FileFormat.XML, FORMAT_XML_IMAGE);	
	formatImages.put(FileFormat.HTML, FORMAT_HTML_IMAGE);
	formatImages.put(FileFormat.XLS, FORMAT_XLS_IMAGE);
	formatImages.put(FileFormat.RTF, FORMAT_RTF_IMAGE);
	formatImages.put(FileFormat.PDF, FORMAT_PDF_IMAGE);
    }
    
    
    public FormatSelectionDialog(Shell parent) {
	super(parent);
    }

    public FormatSelectionDialog(IShellProvider parentShell) {
	super(parentShell);
    }
    
    
    protected void configureShell(Shell shell)  {
        super.configureShell(shell);
        if(title != null) {
            shell.setText(title);
        }
            
    }

    protected void createButtonsForButtonBar(Composite parent) {
	createButton(parent, 0, IDialogConstants.OK_LABEL, true);
	createButton(parent, 1, IDialogConstants.CANCEL_LABEL, false);
    }

    protected Label createMessageArea(Composite composite) {
	Label label = new Label(composite, 0);
	if (message != null) {
	    label.setText(message);
	}
	label.setFont(composite.getFont());
	return label;
    }    
    
    protected Control createDialogArea(Composite parent) {
        Composite contents = (Composite) super.createDialogArea(parent);
        createMessageArea(contents);
        createSelector(contents);
        return contents;
    }
    
    protected void createSelector(Composite parent) {
	
	Composite composite = new Composite(parent, 0);
	GridLayout layout = new GridLayout(1, false);
	//layout.marginBottom = 0;
	layout.marginWidth = 0;
	layout.marginHeight = 0;
	layout.marginLeft = 0;
	//layout.marginTop = 0;
	layout.marginRight = 0;
	//layout.marginBottom = 0;
	layout.horizontalSpacing = 0;
	layout.verticalSpacing = 0;
	    
	composite.setLayout(layout);
	GridData griddata = new GridData(GridData.FILL, GridData.FILL, true, true);
	composite.setLayoutData(griddata);
	
	Table table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
	griddata = new GridData(GridData.FILL, GridData.FILL, true, true);
	griddata.heightHint = 200; //300;
	//griddata.widthHint = 200;
	table.setLayoutData(griddata);
	
	
	TableColumn formatColumn = new TableColumn(table, SWT.NONE);
	formatColumn.setText("Format");
	formatColumn.setWidth(70);
	
	TableColumn typeColumn = new TableColumn(table, SWT.NONE);
	typeColumn.setText("Description");
	typeColumn.setWidth(200);
	
	table.setHeaderVisible(false);
	table.setLinesVisible(false);

	table.addSelectionListener(new SelectionAdapter( ){
	    public void widgetDefaultSelected(SelectionEvent e) {
		okPressed();
	    }
	});
	
	tableViewer = new TableViewer(table);
	tableViewer.setContentProvider(new IStructuredContentProvider() {

	    public Object[] getElements(Object obj) {
		return (Object[]) obj;
	    }

	    public void dispose() {
	    }

	    public void inputChanged(Viewer viewer, Object obj, Object obj1) {
	    }

	});
	if (getLabelProvider() != null) {
	    tableViewer.setLabelProvider(getLabelProvider());
	}
	tableViewer.setInput(getElements());
    }
    
    protected void doSelection() {
	Object[] selectionElements = getSelectionElements();
	setResult(selectionElements);
    }
    
    protected boolean isResizable() {
        return true;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public Object[] getResult() {
	if (result == null) {
	    return new Object[0];
	}
        return result;
    }

    
    protected void setResult(Object[] result) {
        this.result = result;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setElements(List elements) {
	if (elements == null) {
	    this.elements = null;
	    return;
	}
        this.elements = elements.toArray();
    }
    
    public void setElements(Object[] elements) {
	this.elements = elements;
    }

    public Object[] getElements() {
	if (elements == null) {
	    elements = new Object[0];
	}
        return elements;
    }
    
    protected void okPressed() {
	doSelection();
	super.okPressed();
    }

    
    //////////////////////////////////////////////////////////////////////////////////////

    protected LabelProvider getLabelProvider() {
	if (labelProvider == null) {
	    labelProvider = createLabelProvider();
	}
        return labelProvider;
    }

    public void setLabelProvider(LabelProvider labelProvider) {
        this.labelProvider = labelProvider;
    }


    protected LabelProvider createLabelProvider() {
	return new FormatLabelProvider();
    }


    protected Object[] getSelectionElements() {
	StructuredSelection selection = (StructuredSelection) tableViewer.getSelection();
	if (selection == null || selection.isEmpty()) {
	    return null;
	}
	return selection.toArray();
    }
   
    class FormatLabelProvider extends LabelProvider implements ITableLabelProvider {
	
	public String getColumnText(Object element, int columnIndex) {
	    FileFormat format = (FileFormat) element;
	    if (columnIndex == 0) {
		return format.getName(); 
	    } else if (columnIndex == 1) {
		return format.getDescription();
	    }
	    return null;
	}

	public Image getColumnImage(Object element, int columnIndex) {
	    if (columnIndex == 0) {
		return getImage(element);
	    }
	    return null; 
	    
	}
	
	 public Image getImage(Object element) {
	     FileFormat format = (FileFormat) element;
	     return getFormatImage(format);   
	 }

	 
    }    
    
    private Image getFormatImage(FileFormat format) {
	if (format == null) {
	    return null;
	}
	String id = format.getId();
	if (id == null) {
	    return null;
	}
	Image image = formatImages.get(id);
	if (image != null) {
	    return image;
	}
	id = id.toUpperCase();
	image = formatImages.get(id);
	if (image != null) {
	    return image;
	}
	int index = 0;
	for (String d : ID_DELIMITERS) {
	    index = id.indexOf(d);
	    if (index <= 0) {
		continue;
	    }
	    image = formatImages.get(id.substring(0, index));
	    if (image != null) {
		return image;
	    }
	}
	return null;
    }
    
    public static Image getImage(Class klass, String path) {
	return SWTResourceManager.getImage(klass, path);
    }
    
    
    public static Image getResourceImage(String path) {
	return getImage(FormatSelectionDialog.class, path);
    }



}
