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
import org.plazmaforge.framework.client.swing.actions.Command;
import org.plazmaforge.framework.client.swing.dialogs.ChooseActionDialog;
import org.plazmaforge.framework.client.swing.forms.actions.list.AddAction;
import org.plazmaforge.framework.client.swing.forms.actions.list.AddCycleAction;
import org.plazmaforge.framework.client.swing.forms.actions.list.ChooseAction;
import org.plazmaforge.framework.client.swing.forms.actions.list.DeleteAction;
import org.plazmaforge.framework.client.swing.forms.actions.list.EditAction;
import org.plazmaforge.framework.client.swing.forms.actions.list.FilterAction;
import org.plazmaforge.framework.client.swing.forms.actions.list.FindAction;
import org.plazmaforge.framework.client.swing.forms.actions.list.IntervalAction;
import org.plazmaforge.framework.client.swing.forms.actions.list.ListFormAction;
import org.plazmaforge.framework.client.swing.forms.actions.list.PrintAction;
import org.plazmaforge.framework.client.swing.forms.actions.list.RefreshAction;
import org.plazmaforge.framework.client.swing.forms.actions.list.SetupAction;
import org.plazmaforge.framework.client.swing.forms.actions.list.SortAction;
import org.plazmaforge.framework.client.swing.gui.table.AbstractStateTableModel;
import org.plazmaforge.framework.client.swing.gui.table.ButtonTableHeader;
import org.plazmaforge.framework.client.swing.gui.table.ColumnParameter;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.client.swing.gui.table.ObjectTableModel;
import org.plazmaforge.framework.client.swing.gui.table.StateTableModel;
import org.plazmaforge.framework.client.swing.gui.table.XAbstractTableModel;
import org.plazmaforge.framework.client.swing.report.jasperreports.actions.ReportAction;
import org.plazmaforge.framework.client.swing.report.jasperreports.actions.TableReportAction;
import org.plazmaforge.framework.core.DefaultAcceptor;
import org.plazmaforge.framework.core.IAcceptor;
import org.plazmaforge.framework.core.data.Item;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.report.IReport;
import org.plazmaforge.framework.resources.Resources;
import org.plazmaforge.framework.resources.SimpleResources;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

/**
 * @author Oleh Hapon Date: 13.8.2003 Time: 14:42:28 $Id: ListForm.java,v 1.4 2010/12/05 07:52:08 ohapon Exp $
 */
public abstract class ListForm extends Form {

    private static final Logger logger = Logger.getLogger(ListForm.class);

    private static final String LOAD_MESSAGE_ERROR = "Loading data error";

    private static final String ENTER_MESSAGE_ERROR = "Enter error";

    protected ListFormAction refreshAction;

    protected ListFormAction chooseAction;

    protected ListFormAction addAction;

    protected ListFormAction delAction;

    protected ListFormAction editAction;

    protected ListFormAction addCycleAction;

    protected ListFormAction printAction;

    protected ListFormAction sortAction;

    protected ListFormAction findAction;

    protected ListFormAction filterAction;

    protected ListFormAction intervalAction;

    protected ListFormAction setupAction;

    /**
     * Primary table
     */
    protected JTable table;

    protected ColumnProperty[] columns;

    private Object selectedID;

    private ChooseActionDialog reportDialog;

    private List availableReportActions = new ArrayList();

    private ListableMode listableMode;

    private boolean multiEntity;

    private boolean printTableReport;

    private boolean intervalActionVisible;

    private TableFindDialog findDialog;

    private TableFilterDialog filterDialog;

    private TableSortDialog sortDialog;

    private boolean center;

    public ListForm(JDesktopPane desktop, Resources resources) {
	initialize(desktop, ListableMode.LIST, ShellType.INTERNAL_FRAME,
		resources);
    }

    public ListForm(JDesktopPane desktop, String resourceName) {
	initialize(desktop, ListableMode.LIST, ShellType.INTERNAL_FRAME,
		new SimpleResources(resourceName));
    }

    public ListForm(JDesktopPane desktop) {
	initialize(desktop, ListableMode.LIST, ShellType.INTERNAL_FRAME, null);
    }

    public ListForm(Window owner, Resources resources) {
	this.modal = true;
	initialize(owner, ListableMode.CHOOSE, ShellType.DIALOG, resources);
	// init(owner, ListableMode.CHOOSE, ShellType.MODAL_INTERNAL_FRAME,
        // resources);
    }

    public ListForm(Window owner, String resourceName) {
	this.modal = true;
	initialize(owner, ListableMode.CHOOSE, ShellType.DIALOG,
		new SimpleResources(resourceName));
	// init(owner, ListableMode.CHOOSE, ShellType.MODAL_INTERNAL_FRAME, new
        // SimpleResources(resourceName));
    }

    private void initialize(Container owner, int mode, int type) {
	this.owner = owner;
	this.setListableMode(mode);
	this.shellType = createShellType(type);

    }

    private void initialize(Container owner, int mode, int type,
	    Resources resources) {
	initialize(owner, mode, type);
	this.resources = resources;
    }

    // TODO: PUBLIC USED
    public void initWindow(Window window) {
	this.modal = true;
	initialize(window, ListableMode.CHOOSE, ShellType.DIALOG);
	// init(window, ListableMode.CHOOSE, ShellType.MODAL_INTERNAL_FRAME);
    }

    public void doRun() throws ApplicationException {
	init();
	if (!isLoadData()) {
	    doLoadData();
	}
	beforeShow();
	doShow();
	afterShow();
    }

    public void doShow() {
	// getListableMode().prepareListableShow();
	prepareListableShow();
	setSelectedRowByID(selectedID);
	if (isCenter() && (shell instanceof Window)) {
	    ((Window) shell).setLocationRelativeTo(null);
	}
	shell.setVisible(true);

	// if ((this.isModal()) && (shell instanceof XInternalFrame)) {
	// ((XInternalFrame)shell).startModal();
	// }
    }

    protected void prepareListableShow() {
	getListableMode().prepareListableShow();
    }

    protected void initActions() throws ApplicationException {
	refreshAction = createRefreshAction();
	// chooseAction = createChooseAction();
	addAction = createAddAction();
	delAction = createDelAction();
	editAction = createEditAction();
	// addCycleAction = createAddCycleAction();
	printAction = createPrintAction();
	sortAction = createSortAction();
	findAction = createFindAction();
	filterAction = createFilterAction();
	intervalAction = createIntervalAction();
	setupAction = createSetupAction();

	if (isReadOnly()) {
	    initModifyDisabled();
	}
    }

    protected ListFormAction createRefreshAction() {
	ListFormAction a = new RefreshAction(this, getResources());
	a.setActionCommand(createRefreshCommand());
	return a;
    }

    protected ListFormAction createChooseAction() {
	ListFormAction a = new ChooseAction(this, getResources());
	a.setActionCommand(createChooseCommand());
	return a;
    }

    protected ListFormAction createAddAction() {
	ListFormAction a = new AddAction(this, getResources());
	a.setActionCommand(createAddCommand());
	return a;
    }

    protected ListFormAction createDelAction() {
	ListFormAction a = new DeleteAction(this, getResources());
	a.setActionCommand(createDelCommand());
	return a;
    }

    protected ListFormAction createEditAction() {
	ListFormAction a = new EditAction(this, getResources());
	a.setActionCommand(createEditCommand());
	return a;
    }

    protected ListFormAction createAddCycleAction() {
	ListFormAction a = new AddCycleAction(this, getResources());
	a.setActionCommand(createAddCycleCommand());
	a.setEnabled(false);
	return a;
    }

    protected ListFormAction createPrintAction() {
	ListFormAction a = new PrintAction(this, getResources());
	a.setActionCommand(createPrintCommand());
	return a;
    }

    protected ListFormAction createSortAction() {
	ListFormAction a = new SortAction(this, getResources());
	a.setActionCommand(createSortCommand());
	return a;
    }

    protected ListFormAction createFindAction() {
	ListFormAction a = new FindAction(this, getResources());
	a.setActionCommand(createFindCommand());
	return a;
    }

    protected ListFormAction createFilterAction() {
	ListFormAction a = new FilterAction(this, getResources());
	a.setActionCommand(createFilterCommand());
	return a;
    }

    protected ListFormAction createIntervalAction() {
	ListFormAction a = new IntervalAction(this, getResources());
	a.setActionCommand(createIntervalCommand());
	return a;
    }

    protected ListFormAction createSetupAction() {
	ListFormAction a = new SetupAction(this, getResources());
	a.setActionCommand(createSetupCommand());
	return a;
    }

    protected Command createRefreshCommand() {
	return null;
    }

    protected Command createChooseCommand() {
	return null;
    }

    protected Command createAddCommand() {
	return null;
    }

    protected Command createDelCommand() {
	return null;
    }

    protected Command createEditCommand() {
	return null;
    }

    protected Command createAddCycleCommand() {
	return null;
    }

    protected Command createPrintCommand() {
	return null;
    }

    protected Command createSortCommand() {
	return null;
    }

    protected Command createFindCommand() {
	return null;
    }

    protected Command createFilterCommand() {
	return null;
    }

    protected Command createIntervalCommand() {
	return null;
    }

    protected Command createSetupCommand() {
	return null;
    }

    public void doChooseCommand() throws ApplicationException {
	if (getListableMode().getMode() != ListableMode.CHOOSE) {
	    return;
	}
	getShell().setVisible(false);
    }

    public void doDelCommand() throws ApplicationException {
	int index = getSelectedRow();
	if (index < 0)
	    return;
	if (confirmYesNo(getResourceString("message.delete.record")) != JOptionPane.YES_OPTION) {
	    return;
	}
	if (delCommand()) {
	    XAbstractTableModel model = (XAbstractTableModel) getTable()
		    .getModel();
	    model.removeRow(index);
	}
    }

    protected boolean delCommand() throws ApplicationException {
	Object ID = getOwnerID();
	if (ID == null) {
	    return false;
	}
	delCommand(ID);
	return true;
    }

    protected abstract void delCommand(Object value)
	    throws ApplicationException;

    protected EditForm getEditForm(int mode) throws ApplicationException {
	if (isMultiEntity()) {
	    return getEntityEditForm(mode);
	}
	return getEditForm();
    }

    protected EditForm getEditForm() throws ApplicationException {
	return null;
    }

    protected Object getTransferObject() {
	// TODO: ID or Real Object
	Object ID = getOwnerID();
	return ID;
    }

    public void doEditCommand(int mode) throws ApplicationException {
	Object data = null;
	if (mode == EditableMode.EDIT) {
	    data = getTransferObject();
	    if (data == null) {
		return;
	    }
	}
	EditForm edit = getEditForm(mode);
	if (edit == null) {
	    return;
	}
	edit.initEditableMode(mode);
	edit.setTransferObject(data);

	beforeEditForm(edit);
	edit.doRun();
	afterEditForm(edit);

	doRefreshRow(edit.isModifyData(), edit.getTransferObject(), mode);

    }

    protected void beforeEditForm(EditForm editForm)
	    throws ApplicationException {

    }

    protected void afterEditForm(EditForm editForm) throws ApplicationException {

    }

    public void doRefreshRow(boolean isModifyData, Object ID, int mode)
	    throws ApplicationException {
	if (isModifyData) {
	    if (mode == EditableMode.EDIT || mode == EditableMode.ADD) {
		doRefreshRow(ID, mode);
	    } else {
		doRefreshData();
	    }
	}
    }

    public void doRefreshRow(Object ID, int mode) throws ApplicationException {
	processLoadRow(ID, mode);
	setLoadData(true);
	setModifyData(false);
    }

    // TODO: Must use thread
    public void processLoadRow(Object ID, int mode) throws ApplicationException {
	if (mode == EditableMode.EDIT) {
	    this.loadRow(ID);
	} else {
	    this.addRow(ID);
	}

    }

    public void doRefreshData() throws ApplicationException {
	super.doRefreshData();
	tableScrollPane.requestFocus();
	table.requestFocus();
	int i = table.getSelectionModel().getMinSelectionIndex();
	if (i < 0) {
	    return;
	}
	table.getSelectionModel().setSelectionInterval(i, i);
    }

    public void doPrintCommand() throws ApplicationException {
	try {
	    if (getAvailableReportActions() == null
		    || getAvailableReportActions().size() == 0) {
		doTableReport();
	    } else {
		doReportDialog();
	    }
	} catch (Exception e) {
	    throw new ApplicationException(e);
	}
    }

    public List getAvailableReportActions() {
	return availableReportActions;
    }

    protected void doTableReport() throws ApplicationException {
	if (!isPrintTableReport()) {
	    return;
	}
	ReportAction action = getTableReportAction();
	if (action == null) {
	    return;
	}
	action.perform(new ActionEvent(this, 0, ""));
    }

    protected void doReportDialog() throws ApplicationException {
	ChooseActionDialog dialog = getReportDialog();
	dialog.setLocationRelativeTo(null);
	if (dialog.showDialog() != JOptionPane.OK_OPTION) {
	    return;
	}
	ReportAction action = (ReportAction) dialog.getSelectedAction();
	if (action == null) {
	    return;
	}
	IReport report = action.getReport();
	if (report == null) {
	    return;
	}
	action.actionPerformed(new ActionEvent(this, 0, ""));
    }

    protected ChooseActionDialog getReportDialog() {
	if (reportDialog == null) {
	    reportDialog = new ChooseActionDialog(this.getParentFrame(),
		    getAvailableReportActions());
	}
	return reportDialog;
    }

    public void doSortCommand() throws ApplicationException {
	if (sortDialog == null) {
	    sortDialog = new TableSortDialog(this.getParentFrame(), getTable());
	}
	sortDialog.initData();
	if (sortDialog.showDialog() != JOptionPane.OK_OPTION) {
	    return;
	}

	List sortParameters = sortDialog.getSelectItems();

	AbstractStateTableModel model = (AbstractStateTableModel) getTable()
		.getModel();
	model.sort(sortParameters);
	model.fireTableDataChanged();

	// HARD CODE
	if (getTable().getTableHeader() instanceof ButtonTableHeader) {
	    ((ButtonTableHeader) getTable().getTableHeader()).initSortColumn();
	}

	getTable().repaint();
    }

    public void doFindCommand() throws ApplicationException {
	if (findDialog == null) {
	    findDialog = new TableFindDialog(this.getParentFrame(), getTable());
	}
	findDialog.showDialog();
	if (findDialog.showDialog() != JOptionPane.OK_OPTION) {
	    return;
	}
	if (findDialog.getFindRow() < 0) {
	    return;
	}
	setSelectedRow(findDialog.getFindRow());
    }

    public void doFilterCommand() throws ApplicationException {
	if (filterDialog == null) {
	    filterDialog = new TableFilterDialog(this.getParentFrame(),
		    getTable());
	}
	if (filterDialog.showDialog() != JOptionPane.OK_OPTION) {
	    return;
	}
	List criteria = filterDialog.getCriteria();
	AbstractStateTableModel model = (AbstractStateTableModel) getTable()
		.getModel();
	if (criteria == null) {
	    return;
	}
	if (criteria.size() == 0) {
	    model.clearCriteria();
	    model.fireTableDataChanged();
	    return;
	}

	model.clearCriteria();
	for (int i = 0; i < criteria.size(); i++) {
	    model.addCriteria((ColumnParameter) criteria.get(i));
	}
	model.fireTableDataChanged();
    }

    public void doIntervalCommand() throws ApplicationException {
	// Not implemented
    }

    private PreferencesDialog preferencesDialog;

    public void doSetupCommand() throws ApplicationException {
	if (preferencesDialog == null) {
	    preferencesDialog = new PreferencesDialog(this.getParentFrame(),
		    this);
	}
	preferencesDialog.showDialog();
    }

    public int getSelectedRow() {
	if (table == null) {
	    return -1;
	}
	return table.getSelectedRow();
    }

    public Object getRowID() {
	int row = getSelectedRow();
	return getRowID(row);
    }

    public Object getRowID(int row) {
	if (row < 0 || row > table.getRowCount() - 1) {
	    return null;
	}
	Object obj = ((StateTableModel) table.getModel()).getRowID(row);
	return obj;
    }

    protected Object getOwnerID() {
	// TODO: ID or OwnerID for Ownerable Object
	return getRowID();
    }

    public void setSelectedRow(int row) {
	table.getSelectionModel().clearSelection();
	if (row < 0 || row > table.getRowCount() - 1) {
	    if (table.getRowCount() == 0) {
		row = -1;
	    } else {
		row = 0;
	    }
	}
	if (row < 0) {
	    return;
	}
	table.getSelectionModel().setSelectionInterval(row, row);
	Rectangle rect = table.getCellRect(row, 0, true);
	tableScrollPane.getViewport().setViewPosition(new Point(0, 0));
	tableScrollPane.getViewport().scrollRectToVisible(rect);
    }

    public void setSelectedRowByID(Object ID) {
	if (ID == null) {
	    return;
	}
	TableModel m = table.getModel();
	if (!(m instanceof StateTableModel)) {
	    return;
	}
	StateTableModel model = (StateTableModel) table.getModel();
	int count = model.getRowCount();
	int row = -1;
	for (int i = 0; i < count; i++) {
	    if (ID.equals(model.getRowID(i))) {
		row = i;
		break;
	    }
	}
	setSelectedRow(row);
    }

    public Object getSelectedID() {
	return selectedID;
    }

    public void setSelectedID(Object selectedID) {
	this.selectedID = selectedID;
    }

    public JTable getTable() {
	return table;
    }

    protected void initToolBar(JToolBar toolBar) {

	// Initialize default tool bar
	addToolBarAction(toolBar, refreshAction);
	addToolBarAction(toolBar, chooseAction);
	addToolBarAction(toolBar, addAction);
	addToolBarAction(toolBar, delAction);
	addToolBarAction(toolBar, editAction);
	addToolBarAction(toolBar, addCycleAction);
	addToolBarAction(toolBar, printAction);
	addToolBarAction(toolBar, sortAction);
	addToolBarAction(toolBar, findAction);
	addToolBarAction(toolBar, filterAction);

	if (isIntervalActionVisible()) {
	    addToolBarAction(toolBar, intervalAction);
	}

	addToolBarAction(toolBar, setupAction);

	// Initialize custom tool bar
	initCustomToolBar(toolBar);
    }

    protected void addToolBarAction(JToolBar toolBar, ListFormAction action) {
	if (toolBar == null || action == null) {
	    return;
	}
	toolBar.add(action);
    }

    protected void initMenuBar(JMenuBar menuBar) {

    }

    private JScrollPane tableScrollPane;

    protected void initComponents() throws ApplicationException {
	table = createTable();
	tableScrollPane = new JScrollPane(table);
	add(tableScrollPane);
    }

    protected abstract TableModel createTableModel()
	    throws ApplicationException;

    protected ObjectTableModel createObjectTableModel(Class klass)
	    throws ApplicationException {
	return createObjectTableModel(klass, columns);
    }

    protected JTable createTable() throws ApplicationException {
	TableModel model = createTableModel();
	JTable table = createTable(model);

	// Key Listener
	this.registerKeyEnter(table);
	this.registerKeyInsert(table);
	this.registerKeyDelete(table);
	this.registerKeyRefresh(table);
	this.registerKeyFind(table);
	this.registerKeyPrint(table);

	// Mouse Listener
	table.addMouseListener(new MouseListener() {

	    public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
		    enter();
		}
	    }

	    public void mousePressed(MouseEvent e) {

	    }

	    public void mouseReleased(MouseEvent e) {

	    }

	    public void mouseEntered(MouseEvent e) {

	    }

	    public void mouseExited(MouseEvent e) {

	    }

	});
	return table;
    }

    protected void initObjectTableModel(Class klass)
	    throws ApplicationException {
	table.setModel(createObjectTableModel(klass));
    }

    protected void refreshTableModel(List list) throws ApplicationException {
	if (!(table.getModel() instanceof AbstractStateTableModel))
	    return;
	AbstractStateTableModel model = (AbstractStateTableModel) table
		.getModel();
	model.addData(list);
    }

    protected StateTableModel getTableModel() {
	return (StateTableModel) table.getModel();
    }

    protected void refreshTableModel() throws ApplicationException {
	processLoadData();
    }

    protected void processLoadData() throws ApplicationException {
	RunnableLoadData runner = new RunnableLoadData();
	runner.start();
    }

    class RunnableLoadData extends Thread {

	Cursor cursor = null;

	public void run() {

	    try {
		SwingUtilities.invokeAndWait(new Runnable() {
		    public void run() {
			cursor = getCursor();
			setCursor(new Cursor(Cursor.WAIT_CURSOR));
			if (refreshAction != null) {
			    refreshAction.setEnabled(false);
			}
		    }
		});
		loadData();
	    } catch (Exception e) {
		logger.error(LOAD_MESSAGE_ERROR, e);
	    } finally {
		try {
		    SwingUtilities.invokeAndWait(new Runnable() {
			public void run() {
			    if (refreshAction != null) {
				refreshAction.setEnabled(true);
			    }
			    setCursor(cursor);
			}
		    });
		} catch (Exception e) {
		    logger.error("Refresh error", e);
		}

	    }

	}
    }

    public Object showList() throws ApplicationException {
	doRun();
	Object value = getSelectedItem();
	if (value != null) {
	    return value;
	}
	return getSelectedObject();
    }

    public Item getSelectedItem() {
	return null;
    }

    public Object getSelectedObject() {
	int row = getSelectedRow();
	if (row < 0) {
	    return null;
	}
	TableModel m = table.getModel();
	if (m instanceof AbstractStateTableModel) {
	    return ((AbstractStateTableModel) m).getRowObject(row);
	} else {
	    return m.getValueAt(row, 0);
	}
    }

    protected class ListAcceptor extends DefaultAcceptor {

	public Map<String, Object> readParameters() throws ApplicationException {
	    Object ID = getRowID();
	    if (ID == null) {
		return null;
	    }
	    getParameters().put(IAcceptor.ID, ID);
	    return getParameters();
	}
    }

    protected TableReportAction tableReportAction;

    protected TableReportAction createTableReportAction() {
	return new TableReportAction(new TableAcceptor());
    }

    protected TableReportAction getTableReportAction() {
	if (tableReportAction == null) {
	    tableReportAction = createTableReportAction();
	}
	return tableReportAction;
    }

    protected class TableAcceptor extends DefaultAcceptor {

	public Map<String, Object> readParameters() throws ApplicationException {
	    if (getTable() == null) {
		return null;
	    }
	    getParameters().put(IReport.TITLE, getTitle());
	    getParameters().put(IReport.TABLE, getTable());
	    return getParameters();
	}
    }

    protected ListAcceptor listAcceptor;

    protected ListAcceptor createListAcceptor() {
	return new ListAcceptor();
    }

    protected ListAcceptor getListAcceptor() {
	if (listAcceptor == null) {
	    listAcceptor = createListAcceptor();
	}
	return listAcceptor;
    }

    protected ListableMode getListableMode() {
	if (listableMode == null) {
	    listableMode = createListableMode(ListableMode.LIST);
	}
	return listableMode;
    }

    // Initialize Listable Mode
    public void initListableMode(int mode) {
	setListableMode(mode);
    }

    private void setListableMode(int mode) {
	if (listableMode == null || listableMode.getMode() != mode) {
	    listableMode = createListableMode(mode);
	}
    }

    private ListableMode createListableMode(int mode) {
	if (mode == ListableMode.LIST) {
	    return new ListMode();
	} else if (mode == ListableMode.CHOOSE) {
	    return new ChooseMode();
	} else {
	    throw new IllegalArgumentException("Invalid Listable Mode argument");
	}

    }

    /***********************************************************************
     * LISTABLE MODE DEFINITION
     **********************************************************************/

    protected void setEnabledAction(Action action, boolean flag) {
	if (action == null) {
	    return;
	}
	action.setEnabled(flag);
    }

    /*
         * List Mode
         */
    class ListMode extends ListableMode {

	public int getMode() {
	    return LIST;
	}

	public void prepareListableShow() {
	    setEnabledAction(chooseAction, false);
	    setEnabledAction(printAction, true);
	    // addCycleAction.setEnabled(true);
	}

	public void enter() throws ApplicationException {
	    doAction(editAction);
	}
    }

    /*
         * Choose Mode
         */
    class ChooseMode extends ListableMode {

	public int getMode() {
	    return CHOOSE;
	}

	public void prepareListableShow() {
	    setEnabledAction(chooseAction, true);
	    setEnabledAction(printAction, false);
	    // addCycleAction.setEnabled(false);
	}

	public void enter() throws ApplicationException {
	    if (chooseAction == null) {
		doChooseCommand();
	    } else {
		doAction(chooseAction);
	    }
	}

    }

    protected void enter() {
	try {
	    // getListableMode().enter();
	    performEnter();
	} catch (ApplicationException ex) {
	    logger.error(ENTER_MESSAGE_ERROR, ex);
	    applicationError(ex);
	} catch (Throwable ex) {
	    logger.error(ENTER_MESSAGE_ERROR, ex);
	    systemError(ex);
	}
    }

    protected void performEnter() throws ApplicationException {
	getListableMode().enter();
    }

    private void registerKeyEnter(JComponent comp) {
	comp.registerKeyboardAction(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		enter();
	    }
	}, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
		JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void registerKeyInsert(JComponent comp) {
	comp.registerKeyboardAction(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		doAction(addAction);
	    }
	}, KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, 0),
		JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void registerKeyDelete(JComponent comp) {
	comp.registerKeyboardAction(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		doAction(delAction);
	    }
	}, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0),
		JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void registerKeyRefresh(JComponent comp) {
	comp.registerKeyboardAction(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		doAction(refreshAction);
	    }
	}, KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0),
		JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void registerKeyFind(JComponent comp) {
	comp.registerKeyboardAction(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		doAction(findAction);
	    }
	}, KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK),
		JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void registerKeyPrint(JComponent comp) {
	comp.registerKeyboardAction(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		doAction(printAction);
	    }
	}, KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK),
		JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    protected void registerKeyEsc(JComponent comp) {
	if (getShellType() instanceof InternalFrameShellType)
	    return;
	super.registerKeyEsc(comp);
    }

    protected void initModifyActionOnlyEdit() {
	setEnabledAction(addAction, false);
	setEnabledAction(delAction, false);
	setEnabledAction(addCycleAction, false);
    }

    protected void initModifyDisabled() {
	setEnabledAction(editAction, false);
	initModifyActionOnlyEdit();
    }

    protected boolean isMultiEntity() {
	if (multiEntity) {
	    return true;
	}
	return getEntityTypes().size() > 0;
    }

    public void setMultiEntity(boolean multiEntity) {
	this.multiEntity = multiEntity;
    }

    protected void loadRow(Object ID) throws ApplicationException {
	Object newObj = findObject(ID);
	int index = this.getSelectedRow();
	Object oldObj = this.getTableModel().getRowObject(index);
	int r = this.getTableModel().indexOfRow(oldObj);
	this.getTableModel().setRow(r, newObj);
    }

    protected Object findObject(Object ID) throws ApplicationException {
	return null;
    }

    protected void addRow(Object ID) throws ApplicationException {
	Object obj = findObject(ID);
	this.getTableModel().addRow(obj);
    }

    public boolean isPrintTableReport() {
	return printTableReport;
    }

    public void setPrintTableReport(boolean printTableReport) {
	this.printTableReport = printTableReport;
    }

    public void addReportAction(ReportAction action) {
	addReportAction(action, true, getListAcceptor());
    }

    protected void addReportAction(ReportAction action,
	    boolean isIgnoreInvalidParameter) {
	addReportAction(action, isIgnoreInvalidParameter, getListAcceptor());
    }

    protected void addReportAction(ReportAction action,
	    boolean isIgnoreInvalidParameter, IAcceptor acceptor) {
	if (action == null || !action.isEnabled()
		|| !isSupportReportAction(action)) {
	    return;
	}
	if (acceptor != null) {
	    action.setAcceptor(acceptor);
	}
	action.setIgnoreInvalidParameter(isIgnoreInvalidParameter);
	availableReportActions.add(action);
    }

    protected boolean isSupportReportAction(ReportAction action) {
	return true;
    }

    protected IAcceptor getFormAcceptor() {
	return getListAcceptor();
    }

    public boolean isIntervalActionVisible() {
	return intervalActionVisible;
    }

    public void setIntervalActionVisible(boolean intervalActionVisible) {
	this.intervalActionVisible = intervalActionVisible;
    }

    public boolean isCenter() {
	return center;
    }

    public void setCenter(boolean center) {
	this.center = center;
    }

}
