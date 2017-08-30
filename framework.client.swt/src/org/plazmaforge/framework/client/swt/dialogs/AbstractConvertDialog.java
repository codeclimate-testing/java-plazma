package org.plazmaforge.framework.client.swt.dialogs;

import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;

import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.plazmaforge.framework.client.swt.SWTResourceManager;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.datawarehouse.TransferEnvironment;
import org.plazmaforge.framework.datawarehouse.ITransferService;
import org.plazmaforge.framework.datawarehouse.convert.Configurer;
import org.plazmaforge.framework.datawarehouse.convert.IConfigurer;
import org.plazmaforge.framework.datawarehouse.convert.IConverter;
import org.plazmaforge.framework.datawarehouse.convert.ISourceService;
import org.plazmaforge.framework.util.FormatUtils;
import org.plazmaforge.framework.util.StringUtils;
import org.plazmaforge.framework.util.SystemUtils;


public abstract class AbstractConvertDialog extends TitleAreaDialog {

    
    protected final Logger logger = Logger.getLogger(getClass());
    
    
    
    public final static String NULL_VALUE = "NULL";

    /**
     * Flag indicating consumer wants to obtain character set.
     */

    public static final int FMT_ENCODING = 1 << 0;

    /**
     * Flag indicating consumer wants to obtain field delimiter.
     */

    public static final int FMT_DELIM = 1 << 1;

    /**
     * Flag indicating consumer wants to obtain null value string.
     */

    public static final int FMT_NULL = 1 << 2;

    /**
     * Flag indicating consumer wants to know whether to export column headers.
     */

    public static final int OPT_HDR = 1 << 3;

    /**
     * Flag indicating consumer wants to know whether to quote string values.
     */

    public static final int OPT_QUOTE = 1 << 4;

    /**
     * Flag indicating consumer wants to know whether to right-trim values.
     */

    public static final int OPT_TRIM = 1 << 5;
    
    
    
    public static final int PATTERN_DATE = 1 << 6;
    
    
    public static final int PATTERN_TIME = 1 << 7;
    
    
    public static final int PATTERN_NUMBER = 1 << 8;
    
    

    
    public static final String[] DELIMS = { ";", "|", "\\t [TAB]", "," };
    

    private Combo encodingControl;

    private Combo fieldDelimiterControl;

    private Text nullValueControl;

    private Button includeHeadersControl;

    private Button quoteTextControl;

    private Button trimControl;

    /** File or directory name **/
    protected Text fileSystemControl;
	
	
    private Combo datePatternControl;
    
    private Combo timePatternControl;
    
    private Combo numberPatternControl;
    
    
    
	
    private String encoding;
    
    private String fieldDelimiter;
    
    private String nullValue;

    private boolean includeHeaders;
    
    private boolean quoteText;

    private boolean trim;

    private String fileName;
    
    
    private String datePattern;
    
    private String timePattern;
    
    private String numberPattern;
    
    ////
    
    
    
    private ITransferService transferService;
    
    private ISourceService sourceService;
    
    private IConfigurer configurer;

    
    private boolean customMode;
    
    
    public AbstractConvertDialog(Shell parentShell) {
	super(parentShell);
    }
    
    
    /**
     * Get dialog's title. It must be translated already.
     * 
     * @return Translated title.
     */
    public abstract String getTitle();

    /**
     * Get dialog's message. It must be translated already.
     * 
     * @return Translated message.
     */

    public abstract String getMessage();

    /**
     * Get dialog's file filter when choosing input file.
     * 
     * @return List of file patterns (already containing '*').
     */

    public abstract String[] getFileFilter();

    /**
     * Get dialog's flags. Read: what to ask for. Choosing a filename cannot be
     * turned off.
     * 
     * @return Flags.
     */

    public abstract int getFlags();
    
    
    protected Control createContents(Composite parent) {
	Control contents = super.createContents(parent);
	setTitle(getTitle());
	setMessage(getMessage());
	// setTitleImage(image.createImage());
	return contents;
    }

    protected Control createDialogArea(Composite parent) {
	Composite comp = new Composite(parent, SWT.NONE);
	comp.setLayout(new GridLayout());
	comp.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));

	createOptions(comp);

	comp.pack();
	validate();
	return comp;
    }

    protected void createOptions(Composite parent) {
	createGeneralOptions(parent);
	createSpecialOptions(parent);
	createFileSystemOptions(parent);
	createDetailOptions(parent);
    }

    protected void initPanelLayoutData(Composite panel) {
	panel.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
    }
    
    protected void createGeneralOptions(Composite parent) {

	int flags = getFlags();
	if ((flags & FMT_ENCODING) == 0 && (flags & FMT_DELIM) == 0 && (flags & FMT_NULL) == 0
		&& (flags & PATTERN_DATE) == 0 && (flags & PATTERN_TIME) == 0 && (flags & PATTERN_NUMBER) == 0) {
	    return;
	}

	String columnSeparator = ";"; // LOAD PREFERENCES
	Label l = null;

	Group fmtGroup = new Group(parent, SWT.SHADOW_ETCHED_IN);
	initPanelLayoutData(fmtGroup);
	fmtGroup.setText(Messages.getString("ConvertDialog.group.format"));
	fmtGroup.setLayout(new GridLayout(2, false));
	int i = 0, def = 0;
	int FIELD_WIDTH = 150;
	GridData gridData = null;
	if ((flags & FMT_ENCODING) != 0) {
	    l = new Label(fmtGroup, SWT.NONE);
	    l.setText(Messages.getString("ConvertDialog.format.encoding"));
	    encodingControl = new Combo(fmtGroup, SWT.READ_ONLY);
	    gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	    gridData.widthHint = FIELD_WIDTH;
	    encodingControl.setLayoutData(gridData);
	    encodingControl.setVisibleItemCount(10);
	    String currentEncoding = System.getProperty("file.encoding"); // "utf-8"
	    if (currentEncoding != null) {
		currentEncoding = currentEncoding.toLowerCase();
	    }
	    def = -1;
	    SortedMap m = Charset.availableCharsets();
	    for (Iterator it = m.keySet().iterator(); it.hasNext(); i++) {
		Charset cs = (Charset) m.get(it.next());
		encodingControl.add(cs.displayName());

		if (equals(cs, currentEncoding)) {
		    def = i;
		}

	    }
	    if (def > 0) {
		encodingControl.select(def);
	    }

	}

	if ((flags & FMT_DELIM) != 0) {
	    l = new Label(fmtGroup, SWT.NONE);
	    l.setText(Messages.getString("ConvertDialog.format.delim"));
	    fieldDelimiterControl = new Combo(fmtGroup, SWT.BORDER);
	    gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	    gridData.widthHint = FIELD_WIDTH;
	    fieldDelimiterControl.setLayoutData(gridData);
	    for (i = 0, def = 0; i < DELIMS.length; i++) {
		fieldDelimiterControl.add(DELIMS[i]);
		if (DELIMS[i].toLowerCase().equals(columnSeparator))
		    def = i;
	    }
	    fieldDelimiterControl.select(def);
	}

	if ((flags & FMT_NULL) != 0) {
	    l = new Label(fmtGroup, SWT.NONE);
	    l.setText(Messages.getString("ConvertDialog.format.null"));
	    nullValueControl = new Text(fmtGroup, SWT.BORDER);
	    gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	    gridData.widthHint = FIELD_WIDTH;
	    nullValueControl.setLayoutData(gridData);
	    nullValueControl.setText(NULL_VALUE);
	}

	////
	
	if ((flags & PATTERN_DATE) != 0) {
	    l = new Label(fmtGroup, SWT.NONE);
	    l.setText(Messages.getString("ConvertDialog.pattern.date"));
	    datePatternControl = new Combo(fmtGroup, SWT.BORDER);
	    gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	    gridData.widthHint = FIELD_WIDTH;
	    datePatternControl.setLayoutData(gridData);
	    
	    populate(datePatternControl, FormatUtils.getDatePatterns());
	    datePatternControl.select(0);
	    
	}
	
	if ((flags & PATTERN_TIME) != 0) {
	    l = new Label(fmtGroup, SWT.NONE);
	    l.setText(Messages.getString("ConvertDialog.pattern.time"));
	    timePatternControl = new Combo(fmtGroup, SWT.BORDER);
	    gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	    gridData.widthHint = FIELD_WIDTH;
	    timePatternControl.setLayoutData(gridData);
	    
	    populate(timePatternControl, FormatUtils.getTimePatterns());
	    timePatternControl.select(0);
	    
	}
	
	if ((flags & PATTERN_NUMBER) != 0) {
	    l = new Label(fmtGroup, SWT.NONE);
	    l.setText(Messages.getString("ConvertDialog.pattern.number"));
	    numberPatternControl = new Combo(fmtGroup, SWT.BORDER);
	    gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	    gridData.widthHint = FIELD_WIDTH;
	    numberPatternControl.setLayoutData(gridData);
	    
	    populate(numberPatternControl, FormatUtils.getNumberPatterns());
	    numberPatternControl.select(0);
	    
	}
	
	
    }

    protected boolean equals(Charset cs, String name) {
	if (cs == null || name == null) {
	    return false;
	}
	if (cs.displayName().equals(name)) {
	    return true;
	}
	Set<String> aliases = cs.aliases();
	if (aliases == null) {
	    return false;
	}
	for (String a : aliases) {
	    if (a.equals(name)) {
		return true;
	    }
	}
	return false;
    }
	
    protected void createSpecialOptions(Composite parent) {
	int flags = getFlags();
	if ((flags & OPT_HDR) == 0 && (flags & OPT_QUOTE) == 0	&& (flags & OPT_TRIM) == 0) {
	    return;
	}
	boolean isIncludeHeaders = false; // LOAD PREFERENCES

	Group optionsGroup = new Group(parent, SWT.SHADOW_ETCHED_IN);
	initPanelLayoutData(optionsGroup);
	optionsGroup.setText(Messages.getString("ConvertDialog.group.options"));
	optionsGroup.setLayout(new GridLayout(1, true));

	if ((flags & OPT_HDR) != 0) {
	    includeHeadersControl = new Button(optionsGroup, SWT.CHECK);
	    includeHeadersControl.setText(getColumnHeadersMessage());
	    includeHeadersControl.setSelection(isIncludeHeaders);
	}
	if ((flags & OPT_QUOTE) != 0) {
	    quoteTextControl = new Button(optionsGroup, SWT.CHECK);
	    quoteTextControl.setText(Messages.getString("ConvertDialog.options.quote"));
	}
	if ((flags & OPT_TRIM) != 0) {
	    trimControl = new Button(optionsGroup, SWT.CHECK);
	    trimControl.setText(Messages.getString("ConvertDialog.options.trim"));
	}
    }

    protected void createFileSystemOptions(Composite parent) {
	Group fileGroup = new Group(parent, SWT.SHADOW_ETCHED_IN);
	initPanelLayoutData(fileGroup);
	fileGroup.setText(getGroupFileSystemMessage());
	fileGroup.setLayout(new GridLayout(2, false));

	fileSystemControl = new Text(fileGroup, SWT.BORDER | SWT.FILL | SWT.SINGLE);
	fileSystemControl.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
	fileSystemControl.addKeyListener(new KeyListener() {

	    public void keyPressed(KeyEvent e) {
		validate();
	    }

	    public void keyReleased(KeyEvent e) {
		validate();
	    }
	});
	Button choose = new Button(fileGroup, SWT.NONE);
	choose.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
	choose.setText(Messages.getString("ConvertDialog.file.choose"));
	choose.addSelectionListener(new SelectionListener() {

	    public void widgetDefaultSelected(SelectionEvent e) {
	    }

	    public void widgetSelected(SelectionEvent e) {
		chooseFileSystemElement();
	    }
	});

    }

    protected void createDetailOptions(Composite parent) {
	//
    }

    protected Control createButtonBar(Composite parent) {
	Control c = super.createButtonBar(parent);
	validate();
	return c;
    }

    protected void validate() {
	boolean isValid = isValid();
	if (isValid) {
	    setErrorMessage(null); 
	}
	Button ok = getButton(IDialogConstants.OK_ID);
	if (ok != null) {
	    ok.setEnabled(isValid);
	}
    }
    
    protected boolean isValid() {
	String filename = fileSystemControl.getText();
	if (isEmpty(filename)) {
	    setErrorMessage(getFileSystemErrorMessage());
	    return false;
	}
	return true;
    }

    protected String getColumnHeadersMessage() {
	return Messages.getString("ConvertDialog.options.hdr");
    }
    
    protected String getFileSystemErrorMessage() {
	return getFileErrorMessage(); // File by default
    }

    protected void chooseFileSystemElement() {
	chooseFile(); // File by default
    }

    protected void okPressed() {

	populateData();
	if (!isCheckData()) {
	    return;
	}
	populateConfigurer();

	super.okPressed();
    }

    protected boolean isCheckData() {
	return true;
    }
    
    protected String getSelectionFileName() {
	return fileSystemControl != null ? fileSystemControl.getText() : null;
    }
    
    
    protected void populateConfigurer() {
	//
    }

    /**
     * Return chosen character set. The underlying list is obtained from
     * Character set, i.e. it's valid.
     * 
     * @return Character set or <tt>null</tt> if not requested.
     */
    public String getEncoding() {
	return encoding;
    }

    /**
     * Return chosen delimiter.
     * 
     * @return Delimiter or <tt>null</tt> if not requested.
     */
    public String getFieldDelimiter() {
	if (fieldDelimiter == null) {
	    return null;
	}
	if (fieldDelimiter.toLowerCase().startsWith("\\t")) {
	    return "\t";
	}
	return fieldDelimiter;
    }

    /**
     * Return whether to include column headers.
     * 
     * @return Whether to include column headers or <tt>false</tt> if not
     *         requested.
     */
    public boolean isIncludeHeaders() {
	return includeHeaders;
    }

    /**
     * Return whether to quote text values.
     * 
     * @return Whether to quote text values or <tt>false</tt> if not requested.
     */
    public boolean isQuoteText() {
	return quoteText;
    }

    /**
     * Return whether to right-trim spaces.
     * 
     * @return Whether to right-trim spaces or <tt>false</tt> if not requested.
     */
    public boolean isTrim() {
	return trim;
    }

    /**
     * Return chosen filename.
     * 
     * @return fileName
     */
    public String getFileName() {
	return fileName;
    }

    /**
     * Return chosen null value replacement string.
     * 
     * @return String or <tt>null</tt> if not requested.
     */
    public String getNullValue() {
	return nullValue;
    }

    public Image getResourceImage(String path) {
	return SWTResourceManager.getImage(getClass(), path);
    }

    public ITransferService getTransferService() {
	if (transferService == null) {
	    transferService = createTransferService();
	}
	return transferService;
    }

    public void setTransferService(ITransferService transferService) {
	this.transferService = transferService;
    }

    protected ITransferService createTransferService() {
	try {
	    return TransferEnvironment.getTransferService();
	} catch (Throwable ex) {
	    logger.error("Creation TransferService Error", ex);
	}
        return null;
    }

    
    public ISourceService getSourceService() {
	if (sourceService == null) {
	    sourceService = createSourceService();
	}
        return sourceService;
    }


    public void setSourceService(ISourceService sourceService) {
        this.sourceService = sourceService;
    }

    protected ISourceService createSourceService() {
        return null;
    }

    
    ////

    protected void chooseFile() {
	FileDialog dialog = createFileDialog(SWT.SAVE);
	updateFileSystemControl(dialog.open());
    }



    protected void chooseDirectory() {
	DirectoryDialog dialog = createDirectoryDialog(SWT.SAVE);
	updateFileSystemControl(dialog.open());
    }

    protected void updateFileSystemControl(String text) {
	if (!isEmpty(text)) {
	    fileSystemControl.setText(text);
	    afterUpdateFileSystemControl();
	}
	validate();
    }
    
    protected void afterUpdateFileSystemControl() {}

    protected FileDialog createFileDialog(int style) {
	FileDialog fileDialog = new FileDialog(getShell(), style);
	fileDialog.setFilterExtensions(getFileFilter());
	return fileDialog;
    }

    protected DirectoryDialog createDirectoryDialog(int style) {
	DirectoryDialog dialog = new DirectoryDialog(getShell(), style);
	return dialog;
    }

    protected String getFileErrorMessage() {
	return Messages.getString("ConvertDialog.error.file");
    }

    protected String getDirectoryErrorMessage() {
	return Messages.getString("ConvertDialog.error.directory");
    }
    
    protected String getGroupFileSystemMessage() {
	return getGroupFileMessage();
    }
    
    protected String getGroupFileMessage() {
	return Messages.getString("ConvertDialog.group.file");
    }

    protected String getGroupDirectoryMessage() {
	return Messages.getString("ConvertDialog.group.directory");
    }

    public IConfigurer getConfigurer() {
	if (configurer == null){
	    configurer = new Configurer();
	}
        return configurer;
    }


    public void setConfigurer(IConfigurer configurer) {
        this.configurer = configurer;
    }

    protected void populateData() {
	encoding = encodingControl != null ? encodingControl.getText() : null;
	fieldDelimiter = fieldDelimiterControl != null ? fieldDelimiterControl.getText() : null;
	includeHeaders = includeHeadersControl != null	&& includeHeadersControl.getSelection();
	quoteText = quoteTextControl != null && quoteTextControl.getSelection();
	trim = trimControl != null && trimControl.getSelection();
	fileName = fileSystemControl != null ? fileSystemControl.getText() : null;
	nullValue = nullValueControl != null ? nullValueControl.getText() : null;
	
	////
	
	datePattern = datePatternControl != null ? datePatternControl.getText() : null;
	timePattern = timePatternControl != null ? timePatternControl.getText() : null;
	numberPattern = numberPatternControl != null ? numberPatternControl.getText() : null;
    }

    
    /**
     * Initialize converter by this dialog
     * @param converter
     * @throws ApplicationException
     */
    public void initConverter(IConverter converter) throws ApplicationException {
	converter.setConfigurer(getConfigurer());
	
	converter.setEncoding(getEncoding());
	converter.setFieldDelimiter(getFieldDelimiter());
	converter.setIncludeHeaders(isIncludeHeaders());
	converter.setTrim(isTrim());
	converter.setQuoteText(isQuoteText());
	converter.setNullValue(getNullValue());
	
	if (!isEmpty(getDatePattern())) {
	    converter.setDatePattern(getDatePattern());
	}
	if (!isEmpty(getTimePattern())) {
	    converter.setTimePattern(getTimePattern());
	}
	if (!isEmpty(getNumberPattern())) {
	    converter.setNumberPattern(getNumberPattern());
	}
	
	////
	converter.setFileName(getFileName());

    }

    protected boolean isEmpty(String str) {
	return StringUtils.isEmpty(str);
    }
    
    protected boolean isEmpty(String[] array) {
	return StringUtils.isEmpty(array);
    }

    protected boolean isEmptyAll(String[] array) {
	return StringUtils.isEmpty(array);
    }

    protected boolean isEmpty(Collection collection) {
	return SystemUtils.isEmpty(collection);
    }
    
    protected String nullIfEmpty(String str) {
	return StringUtils.nullIfEmpty(str);
    }
    

    protected boolean equalsTrueIfNull(String s1, String s2, boolean trim) {
	if (s1 == null && s2 == null) {
	    return true;
	}
	if (s1 == null || s2 == null) {
	    return false;
	}
	if (trim) {
	    return s1.trim().equals(s2.trim());
	}
	return s1.equals(s2);
    }

    protected IValidator createValidator() {
	IValidator validator = new IValidator() {

	    public void validate() {
		AbstractConvertDialog.this.validate();
	    }
	    
	};
	return validator;
    }


    public String getDatePattern() {
        return datePattern;
    }


    public String getTimePattern() {
        return timePattern;
    }


    public String getNumberPattern() {
        return numberPattern;
    }
    
    ////

    protected void populate(Combo combo, String[] values) {
	if (combo == null || values == null || values.length == 0) {
	    return;
	}
	for (String value: values) {
	    combo.add(value);
	}
    }


    public boolean isCustomMode() {
        return customMode;
    }


    public void setCustomMode(boolean customMode) {
        this.customMode = customMode;
    }
    
    
    
}
