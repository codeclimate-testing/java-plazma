/*
 * Copyright (C) 2005-2010 Oleh Hapon ohapon@users.sourceforge.net
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA.
 * 
 * Oleh Hapon
 * Kyiv, UKRAINE
 * ohapon@users.sourceforge.net
 */

package org.plazmaforge.framework.client.swing.forms;

import javax.swing.*;
import javax.swing.table.TableModel;


import org.apache.log4j.Logger;
import org.plazmaforge.framework.client.swing.actions.AcceptorAction;
import org.plazmaforge.framework.client.swing.dialogs.ChooseDialog;
import org.plazmaforge.framework.client.swing.gui.GUIUtilities;
import org.plazmaforge.framework.client.swing.gui.StatusBar;
import org.plazmaforge.framework.client.swing.gui.XInternalFrame;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.client.swing.gui.table.ObjectTableModel;
import org.plazmaforge.framework.client.swing.message.Message;
import org.plazmaforge.framework.client.swing.report.jasperreports.actions.ReportAction;
import org.plazmaforge.framework.config.ConfigUtils;
import org.plazmaforge.framework.config.object.IConfigIdentifier;
import org.plazmaforge.framework.config.object.IConfigIdentifierHolder;
import org.plazmaforge.framework.core.IAcceptor;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.resources.LibraryResources;
import org.plazmaforge.framework.resources.Resources;
import org.plazmaforge.framework.util.ValidationUtils;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

/**
 * @author Oleh Hapon Date: 13.8.2003 Time: 13:38:05 $Id: Form.java,v 1.4 2010/12/05 07:52:08 ohapon Exp $
 */

/**
 * Abstract Form
 */
public abstract class Form extends JPanel implements FormConstants,
	ActionListener, ITYPEFactory, IConfigIdentifierHolder {

    protected final Logger logger = Logger.getLogger(getClass());

    // Tools
    protected JMenuBar menuBar;

    protected JToolBar toolBar;

    protected JComponent statusBar;

    protected boolean modal;

    /**
     * Root Frame (JFrame, JDialog, JDesktopPane)
     */
    protected Container owner;

    /**
     * Shell view (JFrame, JDialog, JInternalFrame)
     */
    protected Container shell;

    protected ShellType shellType;

    protected Resources resources;

    protected String title;

    private boolean loadData;

    private boolean modifyData;

    private boolean isInit = false;

    // Factory
    private ITYPEFactory typeFactory = new TYPEFactoryImpl();

    private Map entityTypes = new HashMap();

    private EntityType nullEntityType = new NULLEntityType();

    private ChooseDialog entityDialog;

    /** Config identifier * */
    private IConfigIdentifier configIdentifier;

    private List customMenuActions = new ArrayList();

    private List customToolBarActions = new ArrayList();

    /** Read Only * */
    private boolean readOnly;

    public Form(Resources resources) {
	this.resources = resources;
    }

    public Form() {

    }

    /**
     * Configure form
     * 
     */
    protected void configure() {

    }

    public void initWindow(Window window) {
	this.owner = window;
	modal = true;
    }

    protected final void init() throws ApplicationException {
	if (isInit) {
	    return;
	}
	isInit = true;

	// Configure form
	configure();

	// Initialize form
	initAll();
    }

    protected void initAll() throws ApplicationException {
	initActions();
	initForm();
	initComponents();
	initShell();
	initLocale();
    }

    protected void initForm() throws ApplicationException {
	setLayout(new BorderLayout());
    }

    protected void initActions() throws ApplicationException {
    }

    protected void initComponents() throws ApplicationException {
    }

    protected void initShell() throws ApplicationException {
	shell = createShell();
	menuBar = createMenuBar();
	toolBar = createToolBar();
	statusBar = createStatusBar();

	setShellMenuBar(menuBar);
	Container c = getContentPane();

	c.setLayout(new BorderLayout());
	if (toolBar != null) {
	    c.add(toolBar, BorderLayout.NORTH);
	}

	c.add(this, BorderLayout.CENTER);

	if (statusBar != null) {
	    c.add(statusBar, BorderLayout.SOUTH);
	}
    }

    protected void initLocale() throws ApplicationException {
    }

    protected JToolBar createToolBar() {
	JToolBar toolBar = FormUtilities.createToolBar();
	initToolBar(toolBar);
	return toolBar;
    }

    protected abstract void initToolBar(JToolBar tollBar);

    protected abstract void initMenuBar(JMenuBar menuBar);

    protected JMenuBar createMenuBar() {
	JMenuBar menuBar = new JMenuBar();
	initMenuBar(menuBar);
	return menuBar;
    }

    protected JComponent createStatusBar() {
	StatusBar p = new StatusBar();
	return p;
    }

    public Container getShell() {
	return shell;
    }

    public JMenuBar getMenuBar() {
	return menuBar;
    }

    public JToolBar getToolBar() {
	return toolBar;
    }

    public Window getShellWindow() {
	if (!(shell instanceof Window)) {
	    return null;
	}
	return (Window) shell;
    }

    public abstract void doShow();

    public boolean isModal() {
	return modal;
    }

    public void setModal(boolean modal) {
	this.modal = modal;
    }

    public void doRun() throws ApplicationException {
	init();
	doLoadData();
	beforeShow();
	doShow();
	afterShow();
    }

    public void doLoadData() throws ApplicationException {
	loadData();
	setLoadData(true);
	setModifyData(false);
    }

    public void doRefreshData() throws ApplicationException {
	processLoadData();
	setLoadData(true);
	setModifyData(false);
    }

    protected void processLoadData() throws ApplicationException {
    }

    protected abstract void loadData() throws ApplicationException;

    protected void beforeShow() throws ApplicationException {
    }

    protected void afterShow() throws ApplicationException {
    }

    protected void doAction(Action a) {
	if ((a == null) || (!a.isEnabled())) {
	    return;
	}
	a.actionPerformed(new ActionEvent(this, 0, ""));
    }

    protected void doAction(ActionEvent e) {
    }

    protected void doCmd(String cmd) throws ApplicationException {
    }

    public void actionPerformed(ActionEvent e) {
	try {
	    doAction(e);
	} catch (Exception ex) {
	    logger.error("Action performed error", ex);
	}
    }

    public Resources getResources() {
	if (resources == null) {
	    resources = LibraryResources.getInstance();
	}
	return resources;
    }

    public String getResourceString(String key) {
	return resources.getString(key);
    }

    public String getString(String key) {
	return resources.getString(this.getClass().getName()
		+ Resources.CLASS_NAME_PREFIX + key);
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public boolean isLoadData() {
	return loadData;
    }

    public void setLoadData(boolean loadData) {
	this.loadData = loadData;
    }

    public boolean isModifyData() {
	return modifyData;
    }

    public void setModifyData(boolean modifyData) {
	this.modifyData = modifyData;
    }

    protected JTabbedPane createTabbedPane(int height) {
	return FormUtilities.createTabbedPane(super.getPreferredSize().width,
		height);
    }

    protected JTabbedPane createTabbedPane(int width, int height) {
	return FormUtilities.createTabbedPane(width, height);
    }

    protected JTabbedPane createTabbedPane() {
	return createTabbedPane(0);
    }

    protected void appendTitle(String str) {
	appendTitle(str, TITLE_SEPARATOR);
    }

    protected void appendTitle(String str, String separator) {
	String title = getTitle();
	setShellTitle((title == null ? "" : title) + separator + " "
		+ (str == null ? MODIFY_LABEL : str));
    }

    /*
         * protected void updateTitle() { String title = getShellTitle(); if
         * ((!isModifyData()) && (title.endsWith(MODIFY_LABEL))) {
         * setShellTitle(title.substring(0, title.length())); } else if
         * (isModifyData() && (!title.endsWith(MODIFY_LABEL))) {
         * setShellTitle(title + MODIFY_LABEL); } }
         */

    protected JInternalFrame createInternalFrame(JDesktopPane desktop) {
	JInternalFrame frame = new XInternalFrame("", true, true, true, true);
	frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	if (title != null)
	    frame.setTitle(title);
	frame.setFrameIcon(LibraryResources.getInstance().createIcon(
		"olmari/plazma.gif"));
	if (desktop != null) {
	    desktop.add(frame);
	}
	return frame;
    }

    protected JInternalFrame createModalInternalFrame() {
	JInternalFrame frame = new XInternalFrame("", true, true, true, true);
	frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	if (title != null)
	    frame.setTitle(title);
	return frame;
    }

    protected JDialog createDialog(Window owner) {
	final JDialog dialog;
	if (owner == null) {
	    dialog = new JDialog();
	} else {
	    if (owner instanceof JFrame) {
		dialog = new JDialog((JFrame) owner, modal);
	    } else if (owner instanceof JDialog) {
		dialog = new JDialog((JDialog) owner, modal);
	    } else {
		dialog = new JDialog();
	    }
	}
	dialog.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	if (title != null)
	    dialog.setTitle(title);
	dialog.setResizable(true);

	dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
	dialog.addWindowListener(new WindowListener() {

	    public void windowOpened(WindowEvent e) {
	    }

	    public void windowClosing(WindowEvent e) {
		close();
	    }

	    public void windowClosed(WindowEvent e) {
	    }

	    public void windowIconified(WindowEvent e) {
	    }

	    public void windowDeiconified(WindowEvent e) {
	    }

	    public void windowActivated(WindowEvent e) {
	    }

	    public void windowDeactivated(WindowEvent e) {
	    }

	});
	return dialog;
    }

    protected JDialog createDialog() {
	return createDialog(null);
    }

    protected JFrame createFrame() {
	JFrame frame = new JFrame();
	frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	if (title != null)
	    frame.setTitle(title);
	return frame;
    }

    protected ShellType createShellType(int type) {
	if (type == ShellType.INTERNAL_FRAME) {
	    return new InternalFrameShellType();
	} else if (type == ShellType.FRAME) {
	    return new FrameShellType();
	} else if (type == ShellType.DIALOG) {
	    return new DialogShellType();
	} else if (type == ShellType.MODAL_INTERNAL_FRAME) {
	    return new ModalInternalFrameShellType();
	} else {
	    throw new IllegalArgumentException("Invalid ShellType argument");
	}
    }

    protected ShellType getShellType() {
	if (shellType == null) {
	    shellType = new DialogShellType();
	}
	return shellType;
    }

    /***********************************************************************
     * Shell Class Definition
     **********************************************************************/

    /*
         * FRAME
         */
    class FrameShellType extends ShellType {

	public int getType() {
	    return FRAME;
	}

	public Container createShell() {
	    return createFrame();
	}

	public Container getContentPane() {
	    return ((JFrame) shell).getContentPane();
	}

	public void setShellMenuBar(JMenuBar m) {
	    ((JFrame) shell).setJMenuBar(m);
	}

	public void setShellTitle(String title) {
	    ((JFrame) shell).setTitle(title);
	}

	public String getShellTitle() {
	    return ((JFrame) shell).getTitle();
	}

	public void close() {
	    JFrame frame = (JFrame) shell;
	    if (frame == null)
		return;
	    int operation = frame.getDefaultCloseOperation();
	    if (operation == JDialog.DISPOSE_ON_CLOSE) {
		frame.dispose();
	    } else if (operation == JDialog.HIDE_ON_CLOSE) {
		frame.hide();
	    }
	}
    }

    /*
     * INTERNAL FRAME
     */
    class InternalFrameShellType extends ShellType {

	public int getType() {
	    return INTERNAL_FRAME;
	}

	public Container createShell() {
	    return createInternalFrame((JDesktopPane) owner);
	}

	public Container getContentPane() {
	    return ((JInternalFrame) shell).getContentPane();
	}

	public void setShellMenuBar(JMenuBar m) {
	    ((JInternalFrame) shell).setJMenuBar(m);
	}

	public void setShellTitle(String title) {
	    ((JInternalFrame) shell).setTitle(title);
	}

	public String getShellTitle() {
	    return ((JInternalFrame) shell).getTitle();
	}

	public void close() {
	    JInternalFrame frame = (JInternalFrame) shell;
	    if (frame == null)
		return;
	    int operation = frame.getDefaultCloseOperation();
	    if (operation == JDialog.DISPOSE_ON_CLOSE) {
		frame.dispose();
	    } else if (operation == JDialog.HIDE_ON_CLOSE) {
		frame.hide();
	    }
	}

    }

    /*
     * INTERNAL FRAME
     */
    class ModalInternalFrameShellType extends ShellType {

	public int getType() {
	    return MODAL_INTERNAL_FRAME;
	}

	public Container createShell() {
	    return createModalInternalFrame();
	}

	public Container getContentPane() {
	    return ((XInternalFrame) shell).getContentPane();
	}

	public void setShellMenuBar(JMenuBar m) {
	    ((XInternalFrame) shell).setJMenuBar(m);
	}

	public void setShellTitle(String title) {
	    ((XInternalFrame) shell).setTitle(title);
	}

	public String getShellTitle() {
	    return ((XInternalFrame) shell).getTitle();
	}

	public void close() {
	    XInternalFrame frame = (XInternalFrame) shell;
	    if (frame == null)
		return;
	    int operation = frame.getDefaultCloseOperation();
	    if (operation == JDialog.DISPOSE_ON_CLOSE) {
		frame.dispose();
	    } else if (operation == JDialog.HIDE_ON_CLOSE) {
		frame.hide();
	    }
	}

    }

    /*
     * DIALOG
     */
    class DialogShellType extends ShellType {

	public int getType() {
	    return DIALOG;
	}

	public Container createShell() {
	    return createDialog((Window) owner);
	}

	public Container getContentPane() {
	    return ((JDialog) shell).getContentPane();
	}

	public void setShellMenuBar(JMenuBar m) {
	    ((JDialog) shell).setJMenuBar(m);
	}

	public void setShellTitle(String title) {
	    ((JDialog) shell).setTitle(title);
	}

	public String getShellTitle() {
	    return ((JDialog) shell).getTitle();
	}

	public void close() {
	    JDialog dialog = (JDialog) shell;
	    if (dialog == null)
		return;
	    int operation = dialog.getDefaultCloseOperation();
	    if (operation == JDialog.DISPOSE_ON_CLOSE) {
		dialog.dispose();
	    } else if (operation == JDialog.HIDE_ON_CLOSE) {
		dialog.hide();
	    }
	}
    }

    protected Container createShell() {
	return getShellType().createShell();
    }

    protected Container getContentPane() {
	return getShellType().getContentPane();
    }

    protected void setShellMenuBar(JMenuBar m) {
	if ((m == null) || (m.getMenuCount() == 0)) {
	    return;
	}
	getShellType().setShellMenuBar(m);
    }

    protected void setShellTitle(String title) {
	if (title == null)
	    title = "";
	getShellType().setShellTitle(title);
    }

    protected String getShellTitle() {
	return getShellType().getShellTitle();
    }

    // --------------
    protected ObjectTableModel createObjectTableModel(Class klass,
	    ColumnProperty[] columns) throws ApplicationException {
	return FormUtilities.createObjectTableModel(klass, columns);
    }

    protected ObjectTableModel createObjectTableModel(Class klass, List columns)
	    throws ApplicationException {
	return FormUtilities.createObjectTableModel(klass, columns);
    }

    protected JTable createTable(TableModel model) throws ApplicationException {
	JTable table = FormUtilities.createTable(model);
	registerKeyEsc(table);
	return table;
    }

    public void close() {
	getShellType().close();
    }

    protected void registerKeyEsc(JComponent comp) {
	comp.registerKeyboardAction(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		close();
	    }
	}, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
		JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    protected Frame getParentFrame() {
	return GUIUtilities.getParentFrame(this);
    }

    protected int confirmYesNo(Object message) {
	return Message.confirmYesNo(getParentFrame(), message);
    }

    protected void applicationError(Exception exception) {
	Message.applicationError(getParentFrame(), exception);
    }

    protected void applicationError(Object message) {
	Message.applicationError(getParentFrame(), message);
    }

    
    protected void systemError(Exception exception) {
	Message.systemError(getParentFrame(), exception);
    }
    
    protected void systemError(Object message) {
	Message.systemError(getParentFrame(), message);
    }
    
    

    public EntityType getTYPE(Class klass) {
	return typeFactory.getTYPE(klass);
    }

    // ---------------------------------------------------------
    protected void registerEntityTypes() {
	// TODO: MUST OVERRIDE
    }

    protected void registerEntityType(Object key, EntityType type) {
	this.getEntityTypes().put(key, type);
    }

    protected void clearEntityTypes() {
	entityTypes.clear();
    }

    protected Map getEntityTypes() {
	return entityTypes;
    }

    protected EntityType getEntityType() {
	// TODO: MUST OVERRIDE
	return getNULLEntityType();
    }

    protected EntityType getEntityType(Object key) {
	EntityType type = getInnerEntityType(key);
	if (type == null) {
	    return getNULLEntityType();
	}
	return type;
    }

    protected EntityType getInnerEntityType(Object key) {
	return (EntityType) getEntityTypes().get(key);
    }

    protected EntityType getNULLEntityType() {
	return nullEntityType;
    }

    protected EditForm getEntityEditForm(int mode) throws ApplicationException {
	if (mode == EditableMode.ADD || mode == EditableMode.ADD_CYCLE) {
	    ChooseDialog dialog = getEntityDialog();
	    if (dialog == null)
		return null;
	    if (dialog.showDialog() != JOptionPane.OK_OPTION) {
		return null;
	    }
	    return getEditFormByEntityType(getDialogEntityType(dialog
		    .getSelectedValue()));
	}
	return getEditFormByEntityType(getEntityType());
    }

    protected EditForm getEditFormByEntityType(EntityType entityType)
	    throws ApplicationException {
	if (entityType == null) {
	    return null;
	}
	return entityType.getEditForm();
    }

    protected ChooseDialog createEntityDialog() {
	List entities = new ArrayList();
	Iterator keys = getEntityTypes().keySet().iterator();
	while (keys.hasNext()) {
	    entities.add(getEntityView(keys.next()));
	}
	return new ChooseDialog(this.getParentFrame(), entities);
    }

    protected Object getEntityView(Object key) {
	// TODO: MUST OWERRIDE:
	return key;
    }

    protected ChooseDialog getEntityDialog() {
	if (entityDialog == null) {
	    entityDialog = createEntityDialog();
	}
	return entityDialog;
    }

    protected EntityType getDialogEntityType(Object selectedValue) {
	// TODO: MUST OVERRIDE
	return getNULLEntityType();
    }
    
    
    
    ///---

    protected void addError(StringBuffer buf, String arg1, String arg2,
	    String separator) {
	addError(buf, arg1 + separator + arg2);
    }

    protected void addError(StringBuffer buf, String arg1, String arg2) {
	addError(buf, arg1, arg2, " ");
    }

    protected void addError(StringBuffer buf, String error) {
	buf.append(error + "\n");
    }

    protected void validateRequiredField(StringBuffer buf, String fieldValue,
	    String fieldName) {
	validateField(buf, ValidationUtils.isValidRequired(fieldValue),
		fieldName, getRequiredResourceString());
    }

    protected void validateRequiredField(StringBuffer buf, Object fieldValue,
	    String fieldName) {
	validateField(buf, ValidationUtils.isValidRequired(fieldValue),
		fieldName, getRequiredResourceString());
    }

    protected void validateRequiredField(StringBuffer buf, boolean isValid,
	    String fieldName) {
	validateField(buf, isValid, fieldName, getRequiredResourceString());
    }

    protected void validateField(StringBuffer buf, boolean isValid,
	    String fieldName, String errorMessage) {
	if (isValid) {
	    return;
	}
	addError(buf, getFieldResourceString() + " [" + fieldName + "] ",
		errorMessage);
    }

    protected void checkError(StringBuffer buf) throws ApplicationException {
	checkError(buf, 0);
    }

    protected void checkError(StringBuffer buf, int specialCharCount)
	    throws ApplicationException {
	String error = buf.toString();
	if (error.length() > specialCharCount) {
	    throw new ApplicationException(error);
	}
    }

    protected String getFieldResourceString() {
	return getResourceString("valid.field");
    }

    protected String getRequiredResourceString() {
	return getResourceString("valid.required");
    }
    
    ///---
    
    
    

    public IConfigIdentifier getConfigIdentifier() {
	if (configIdentifier == null) {
	    configIdentifier = createDefaultConfigIdentifier();
	}
	return configIdentifier;
    }

    public void setConfigIdentifier(IConfigIdentifier configIdentifier) {
	this.configIdentifier = configIdentifier;
    }

    protected IConfigIdentifier createDefaultConfigIdentifier() {
	return ConfigUtils.createDefaultConfigIdentifier(this.getClass());
    }

    public void addReportAction(ReportAction action) {
	// Stub
    }

    public void addAction(Action action) {
	initCustomActionState(action);
	customToolBarActions.add(action);
    }

    protected List getCustomMenuActions() {
	return customMenuActions;
    }

    protected List getCustomToolBarActions() {
	return customToolBarActions;
    }

    protected void initCustomMenu(JMenuBar menuBar) {
	// Stub
    }

    protected void initCustomToolBar(JToolBar toolBar) {
	if (toolBar == null) {
	    return;
	}
	List actions = this.getCustomToolBarActions();
	if (actions == null) {
	    return;
	}
	Action action = null;
	for (int i = 0; i < actions.size(); i++) {
	    action = (Action) actions.get(i);
	    initCustomActionState(action);
	    if (action instanceof AcceptorAction) {
		initAcceptorAction((AcceptorAction) action);
	    }
	    toolBar.add(action);
	}
    }

    protected void initCustomActionState(Action action) {

    }

    protected void initAcceptorAction(AcceptorAction acceptorAction) {
	if (acceptorAction.getAcceptor() != null) {
	    return;
	}
	acceptorAction.setAcceptor(getFormAcceptor());
    }

    protected abstract IAcceptor getFormAcceptor();

    public boolean isReadOnly() {
	return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
	this.readOnly = readOnly;
    }
}
