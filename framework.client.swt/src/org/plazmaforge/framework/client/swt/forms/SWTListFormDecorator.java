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

package org.plazmaforge.framework.client.swt.forms;




import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.ControlContribution;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.Tree;
import org.plazmaforge.framework.client.forms.IForm;
import org.plazmaforge.framework.client.forms.IFormConstants;
import org.plazmaforge.framework.client.forms.IListForm;
import org.plazmaforge.framework.client.forms.IListFormDecorator;
import org.plazmaforge.framework.client.swt.controls.ToolButton;
import org.plazmaforge.framework.client.swt.views.ColumnSetting;
import org.plazmaforge.framework.client.swt.views.ISWTTableView;
import org.plazmaforge.framework.client.swt.views.TableFilterItem;
import org.plazmaforge.framework.client.views.ITableView;
import org.plazmaforge.framework.core.data.Pager;
import org.plazmaforge.framework.core.criteria.ICriteria;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.ObjectCreator;
import org.plazmaforge.framework.util.StringUtils;
import org.plazmaforge.framework.util.SystemInfo;
import org.plazmaforge.framework.util.ObjectCreator.ObjectValue;



/** 
 * @author Oleh Hapon
 *
 */

public class SWTListFormDecorator extends AbstractFormDecorator implements ISWTListFormDecorator, IListFormDecorator, IFormConstants  {
    
    private Composite content;
    private Composite statusBar;
    
    
    private Label statusLabel;
    private Composite statusToolPanel;
    private Label statusToolLabel;
    private Composite statusSummaryPanel;
    private Label statusSummaryLabel;

    private String exportAsMessage;
  


    public SWTListFormDecorator(Composite parent) {
	this(parent, SWT.NONE);
    }    
    
    public SWTListFormDecorator(Composite parent, int style) {
	super(parent, style);
	initialize();
    }

    private void initialize() {
    	
    	GridLayout gridLayout;
    	Composite composite;
    	FillLayout fillLayout;
    	
    	GridData gridData;

    	gridLayout = new GridLayout();
    	gridLayout.verticalSpacing = 0;
    	gridLayout.marginHeight = 0;
    	gridLayout.marginWidth = 0;
    	setLayout(gridLayout);

    	composite = new Composite(this, SWT.NONE);
    	
  
    	fillLayout = new FillLayout();
    	fillLayout.type = org.eclipse.swt.SWT.HORIZONTAL;
    	
    	initFillLayout(fillLayout);
    	
    	composite.setLayout(fillLayout);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	composite.setLayoutData(gridData);
    	
    	coolBar = createCoolBar(composite);
    	
 	content = new Composite(this, SWT.BORDER);
    	content.setLayout(new FillLayout());
    	content.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true)); 
    	

    	statusBar = new Composite(this, SWT.BORDER);
    	gridLayout = new GridLayout();
    	gridLayout.marginHeight = 0;
    	gridLayout.marginWidth = 0;
    	gridLayout.numColumns = 3;
    	statusBar.setLayout(gridLayout);
    	statusBar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    	
    	createStatusToolPanel(statusBar);
    	createStatusLabel(statusBar);
    	createStatusSummaryPanel(statusBar);
    	
    	this.setSize(new Point(307, 290));
    	
	addTraverseListener(new TraverseListener() {
	    public void keyTraversed(TraverseEvent e) {
		if (e.keyCode == SWT.F1) {
		    doAction(HELP_ACTION);
		} else if (e.keyCode == SWT.ESC) {
		    //doAction(CANCEL_ACTION);
		    //getForm()
		    if (getListForm() != null && (getListForm().isChooseState() || isModal())) {
			// doAction(CLOSE_ACTION);
		    } else {
			e.doit = false;
		    }
		    
		} else if (e.keyCode == SWT.CR && e.stateMask == SWT.CTRL) {
		    doAction(SAVE_ACTION);
		}

      	    }
    	});    	
    }
    protected void registerGlobalActions() {
	
	super.registerGlobalActions();
	
	registerGlobalAction(TREE_ADD_ACTION, Messages.getString("Form.add"), ADD_ITEM_IMAGE);
	registerGlobalAction(TREE_EDIT_ACTION, Messages.getString("Form.edit"), EDIT_ITEM_IMAGE);
	registerGlobalAction(TREE_DEL_ACTION, Messages.getString("Form.delete"), DELETE_ITEM_IMAGE);
	
	registerGlobalAction(SORT_ACTION, Messages.getString("Form.sort"), SORT_IMAGE);
    	registerGlobalAction(FIND_ACTION, Messages.getString("Form.find"), FIND_IMAGE);
    	registerGlobalAction(FAST_FILTER_ACTION, Messages.getString("Form.fast.filter"), (Image) null);
    	registerGlobalAction(FILTER_ACTION, Messages.getString("Form.filter"), FILTER_IMAGE);
    	//registerGlobalAction(ADVANCED_FILTER_ACTION, Messages.getString("Form.advanced.filter"), ADVANCED_FILTER_IMAGE);
    	registerGlobalAction(CLEAR_FILTER_ACTION, Messages.getString("Form.clear.filter"), CLEAR_FILTER_IMAGE);
    	registerGlobalAction(PERIOD_FILTER_ACTION, Messages.getString("Form.date.period"), PERIOD_FILTER_IMAGE);
    	
    	
    	registerGlobalAction(FIRST_PAGE_ACTION, Messages.getString("Form.firstPage"), FIRST_PAGE_IMAGE);
    	registerGlobalAction(PREV_PAGE_ACTION, Messages.getString("Form.prevPage"), PREV_PAGE_IMAGE);
    	registerGlobalAction(NEXT_PAGE_ACTION, Messages.getString("Form.nextPage"), NEXT_PAGE_IMAGE);
    	registerGlobalAction(LAST_PAGE_ACTION, Messages.getString("Form.lastPage"), LAST_PAGE_IMAGE);
    	
    	
    }
    
    protected ToolBar createToolBar(CoolBar parent) {
    	
    	toolBarManager = newToolBarManager();
    	
    	coolBarManager.add(toolBarManager);
    	
    	addAction(toolBarManager, REFRESH_ACTION);
    	
    	//////// DATA MANAGE ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    	
    	addAction(toolBarManager, ADD_ACTION);
    	addAction(toolBarManager, EDIT_ACTION);
    	if (isSupportCopyMode()) {
    	    addAction(toolBarManager, COPY_ACTION);
    	}
    	addAction(toolBarManager, DEL_ACTION);
    	
    	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    	
    	addAction(toolBarManager, SORT_ACTION);
    	if (!isQuickSearchMode()) {
    	    addAction(toolBarManager, FIND_ACTION);
    	}
    	
    	addAction(toolBarManager, FILTER_ACTION);
    	//addAction(toolBarManager, ADVANCED_FILTER_ACTION);
    	addAction(toolBarManager, CLEAR_FILTER_ACTION);
    	if (isSupportPeriodFilter()) { // Period filter
    	    addAction(toolBarManager, PERIOD_FILTER_ACTION);
    	}
    	
    	addAction(toolBarManager, PRINT_ACTION);
    	addAction(toolBarManager, EXPORT_ACTION);


    	/////////// PAGE NAVIGATION ////////////////////////////////////////////////////////////////////////////////////////////////////
    	
    	if (isPagingMode()) {
    	    addAction(toolBarManager, FIRST_PAGE_ACTION);
    	    addAction(toolBarManager, PREV_PAGE_ACTION);
    	    addAction(toolBarManager, NEXT_PAGE_ACTION);
    	    addAction(toolBarManager, LAST_PAGE_ACTION);
    	}
    	
    	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   	

    	addAction(toolBarManager, SETUP_ACTION);
    	addAction(toolBarManager, HELP_ACTION);
    	
    	///////////////////////////// SET ENABLE MODE /////////////////////////////////////////
    	
    	setEnabled(getGlobalAction(ADD_ACTION), getListForm().isSupportAddMode());
    	setEnabled(getGlobalAction(EDIT_ACTION), getListForm().isSupportEditMode());
    	setEnabled(getGlobalAction(DEL_ACTION), getListForm().isSupportDelMode());
    	
    	coolBarManager.update(true);
    	
    	return null;
    }
    
    
    protected void initForm() throws ApplicationException {
	if (getForm() == null) {
	    return;
	}

	String title = getForm().getTitle();
	if (title != null) {
	    setTitle(title);
	}
	getForm().init();
	
	initTable();
	initTree();
    }
    
    protected void initActions() throws ApplicationException {
	super.initActions();
	// Stub
    }
 
    protected void initToolBar() throws ApplicationException {
	createToolBar(coolBar);
    }
    
    protected void initContextMenu() throws ApplicationException {
	Table table = getTable();
	if (table == null) {
	    return;
	}
	Menu menu = createTableContextMenu(table);
	table.setMenu(menu);
	getListForm().getView().initContextMenu();
	
	Tree tree = getTree();
	if (tree == null) {
	    return;
	}
	menu = createTreeContextMenu(table);
	tree.setMenu(menu);
    } 
    
    protected Menu createTableContextMenu(Control parent) {
	MenuManager menuManager = new MenuManager();
	Menu menu = menuManager.createContextMenu(parent);
	addAction(menuManager, ADD_ACTION);
	if (isSupportCopyMode()) {
	    addAction(menuManager, COPY_ACTION);
	}
	addAction(menuManager, EDIT_ACTION);
	addAction(menuManager, DEL_ACTION);
	menuManager.add(new Separator());
	addAction(menuManager, SORT_ACTION);
	if (!isQuickSearchMode()) {
	    addAction(menuManager, FIND_ACTION);
	}
	menuManager.add(new Separator());
	addAction(menuManager, FAST_FILTER_ACTION);
	addAction(menuManager, FILTER_ACTION);
	//addAction(menuManager, ADVANCED_FILTER_ACTION);
	addAction(menuManager, CLEAR_FILTER_ACTION);
	
	if (isSupportPeriodFilter()) {
	    menuManager.add(new Separator());
	    addAction(menuManager, PERIOD_FILTER_ACTION);
	}
	menuManager.add(new Separator());
	addAction(menuManager, PRINT_ACTION);
	menuManager.add(new Separator());
	addAction(menuManager, EXPORT_ACTION);
	menuManager.add(new Separator());
	addAction(menuManager, SETUP_ACTION);
	
	if (dropDownAction != null) {
	    menuManager.add(new Separator());
	    menuManager.add(dropDownAction);
	}
	
	return menu;
    }

    protected Menu createTreeContextMenu(Control parent) {
	MenuManager menuManager = new MenuManager();
	Menu menu = menuManager.createContextMenu(parent);
	
	addAction(menuManager, TREE_ADD_ACTION);
	addAction(menuManager, TREE_EDIT_ACTION);
	addAction(menuManager, TREE_DEL_ACTION);
	
	menuManager.add(new Separator());
	addAction(menuManager, PRINT_ACTION);
	menuManager.add(new Separator());
	addAction(menuManager, EXPORT_ACTION);
	menuManager.add(new Separator());
	addAction(menuManager, SETUP_ACTION);
	
	if (dropDownAction != null) {
	    menuManager.add(new Separator());
	    menuManager.add(dropDownAction);
	}
	return menu;
    }
    
    private ToolButton treeToolButton;
    
    protected Composite createStatusToolPanel(Composite parent) {
    	statusToolPanel = new Composite(statusBar, SWT.NONE);
    	GridData gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
	statusToolPanel.setLayoutData(gridData);
    	GridLayout gridLayout = new GridLayout();
    	gridLayout.marginHeight = 0;
    	gridLayout.numColumns = 2;
    	statusToolPanel.setLayout(gridLayout);
    	
    	gridData = new GridData(SWT.CENTER, SWT.FILL, false, false);
    	treeToolButton = new ToolButton(statusToolPanel, SWT.FLAT);
    	treeToolButton.setImage(TREE_IMAGE); //$NON-NLS-1$
    	treeToolButton.setLayoutData(gridData);
    	treeToolButton.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		    doTreeToolButtonSelect();
		}
	});
    	
    	setToolButtonVisible(false);
    	
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	statusToolLabel = new Label(statusToolPanel, SWT.NONE);
	statusToolLabel.setLayoutData(gridData);
    	statusToolLabel.setText("");
    	
    	statusToolPanel.layout();
    	
    	return statusToolPanel;
    }
    
    protected void setToolButtonVisible(boolean visible) {
	if (treeToolButton == null) {
	    return;
	}
	treeToolButton.setVisible(visible);
	((GridData)treeToolButton.getLayoutData()).exclude = !visible;
    }

    protected Control createStatusLabel(Composite parent) {
	statusLabel = new Label(statusBar, SWT.NONE);
    	statusLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    	statusLabel.setText("View");
    	return statusLabel;
    }
    
    protected Composite createStatusSummaryPanel(Composite parent) {
    	statusSummaryPanel = new Composite(statusBar, SWT.NONE);
	statusSummaryPanel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	GridLayout gridLayout = new GridLayout();
    	gridLayout.marginHeight = 0;
    	statusSummaryPanel.setLayout(gridLayout);
    	
    	statusSummaryLabel = new Label(statusSummaryPanel, SWT.NONE);
	statusSummaryLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	statusSummaryLabel.setText("     ");

   	return statusSummaryPanel;
    }

    protected void doTreeToolButtonSelect() {
	Tree tree = getTree();
	if (tree == null) {
	    return;
	}
	boolean visible = tree.getVisible();
	tree.setVisible(!visible);
	tree.getParent().layout();
    }
    
    
    public void setStatusSummaryText(String text) {
	if (statusSummaryLabel == null) {
	     return;
	}
	statusSummaryLabel.setText(text == null ? "" : text);
	statusSummaryLabel.getParent().getParent().layout();
    }


    public void updateState() {
	updatePagingState();
	updateDataState();
    }

    public void updatePagingState() {
	if (!isPagingMode()) {
	    return;
	}
	Pager pager = getListForm().getPager();
	if (pager == null || pager.isDisablePager()) {
	    setDisabledPagingTool();
	    return;
	}

	setEnabled(getGlobalAction(FIRST_PAGE_ACTION), pager.isEnableFirstPage());
	setEnabled(getGlobalAction(PREV_PAGE_ACTION), pager.isEnablePrevPage());
	setEnabled(getGlobalAction(NEXT_PAGE_ACTION), pager.isEnableNextPage());
	setEnabled(getGlobalAction(LAST_PAGE_ACTION), pager.isEnableLastPage());
    }
    
    public void updateDataState() {
	super.updateDataState();
	updateTableState();
    }

    public void updateTableState() {
	// TODO
    }
    
    
    protected void setDisabledPagingTool() {
	setEnabled(getGlobalAction(FIRST_PAGE_ACTION), false);
	setEnabled(getGlobalAction(PREV_PAGE_ACTION), false);
	setEnabled(getGlobalAction(NEXT_PAGE_ACTION), false);
	setEnabled(getGlobalAction(LAST_PAGE_ACTION), false);
    }
    
    
    protected void initFillLayout(FillLayout fillLayout) {
	if (fillLayout == null) {
	    return;
	}
	if (SystemInfo.isWindows) {
	    return;
	}
	fillLayout.marginHeight = 0;
    }
    
    public Composite getContent() {
        return content;
    }


    public Composite getStatusBar() {
        return statusBar;
    }

    public CoolBar getCoolBar() {
        return coolBar;
    }
    
    protected Table getTable() {
	IListForm form = getListForm();
	if (form == null) {
	    return null;
	}
	if (!(form.getTable() instanceof Table)) {
	    return null;
	}
	return (Table) form.getTable();
    }
    
    protected Tree getTree() {
	IListForm form = getListForm();
	if (form == null) {
	    return null;
	}
	if (!(form.getTree() instanceof Tree)) {
	    return null;
	}
	return (Tree) form.getTree();
    }
    
    protected void initTable() {
	Table table = getTable();
	initTable(table);
    }
    
    protected void initTable(Table table) {
    }
    
    
    private boolean isInitTree;
    
    protected void initTree() {
	Tree tree = getTree();
	initTree(tree);
    }
    
    protected void initTree(Tree tree) {
	if (tree == null || isInitTree) {
	    return;
	}
	isInitTree = true;
	setToolButtonVisible(true);
    }

    
    
    protected String getExportAsMessage() {
	if (exportAsMessage == null) {
	    exportAsMessage = Messages.getString("Form.exportas");
	}
	return exportAsMessage;
    }
    
    protected String getExportTextByType(String exportType) {
	return getExportAsMessage() + " " + exportType;
    }
    
    protected void doExportActionByType(String type) {
	doAction(EXPORT_ACTION + "." + type);
    }

    
    
    protected String getDecoratorTitle() {
	return Messages.getString("Form.title");
    }
 
    public void setStatusText(String text) {
	if (statusLabel == null) {
	     return;
	}
	statusLabel.setText(text);
	statusBar.layout();
    }
    
    public String getStatusText() {
	if (statusLabel == null) {
	    return ""; 
	}
	return statusLabel.getText();
    }
    
 
    protected void checkFormClass(IForm form) {
	if (form != null && !(form instanceof IListForm)) {
	    throw new IllegalArgumentException("Form must be IListForm");
	}
    }
    
    protected IListForm getListForm() {
	return (IListForm) getForm();
    }
    
    public void open() {
	resize();
	if (isModal()) {
	    center();
	}
	
	// SPECIAL FOR ECLIPSE RCP :)
	getParent().getParent().layout();
	
	super.open();
	setFormFocus();
	
	// disable: 2008-09-04
	// SPECIAL FOR ECLIPSE RCP :)
	//getParent().getParent().layout();
    }
    
    
  
    public boolean isSupportPeriodFilter() {
	IListForm listForm = getListForm();
	if (listForm == null) {
	    return false;
	}
	return listForm.isSupportPeriodFilter();
    }

    public boolean isSupportCopyMode() {
	IListForm listForm = getListForm();
	if (listForm == null) {
	    return false;
	}
	return listForm.isSupportCopyMode();
    }
    
    
    public boolean isPagingMode() {
	IListForm listForm = getListForm();
	if (listForm == null) {
	    return false;
	}
	return listForm.isPagingMode();
    }


    public void initExtToolBar() throws ApplicationException {
	initQuickSearchToolBar();
	super.initExtToolBar();
    }

    private Combo searchColumsCombo;
    
    private Text searchColumsText;
    
    private List<ColumnSetting> searchColumns = new ArrayList<ColumnSetting>(); 
    
    protected void initQuickSearchToolBar() throws ApplicationException {
	if (!isQuickSearchMode()) {
	    return;
	}
	extToolBarManager = new ToolBarManager(SWT.FLAT | SWT.WRAP);
	extToolBarManager.add(new QuickSearchContribution("QuickSearch"));
	
	
	// JFace Action
	org.eclipse.jface.action.Action action = new org.eclipse.jface.action.Action() {
	    public void run() {
		doQuickSearch();
	    }
	};
	action.setImageDescriptor(getImageDescriptor(FIND_IMAGE));
	action.setToolTipText(Messages.getString("Form.find"));
	
	extToolBarManager.add(action);
	coolBarManager.add(extToolBarManager);
	
    }
    
    
    protected void populateQuickSerachColums() {
	searchColumns.clear();
	if (searchColumsCombo == null) {
	    return;
	}
	searchColumsCombo.deselectAll();
	

	ISWTTableView tableView = getTableView();
	List<ColumnSetting> columns = tableView.getAvailableColumnSettings();
	if (columns == null || columns.isEmpty()) {
	    return;
	}
	for (ColumnSetting cs : columns) {
	    Object c = cs.getColumn();
	    if (c == null ||!(c instanceof TableColumn)) {
		continue;
	    }
	    TableColumn tableColumn = (TableColumn) c;
	    String text = tableColumn.getText();
	    if (StringUtils.isEmpty(text)) {
		continue;
	    }
	    searchColumsCombo.add(text);
	    searchColumns.add(cs);
	}
	if (searchColumsCombo.getItemCount()> 0) {
	    searchColumsCombo.select(0);
	}
	
	
    }
    
    protected ISWTTableView getTableView() {
	IListForm listForm = getListForm();
	ITableView view  = listForm.getView();
	if (view == null || !(view instanceof ISWTTableView)) {
	    return null;
	}
	ISWTTableView tableView = (ISWTTableView) view;
	tableView = (ISWTTableView) view;
	return tableView;
    }
    
    
    protected void doQuickSearch() {
	ISWTTableView tableView = getTableView();
	if (tableView == null) {
	    return;
	}
	List<TableFilterItem<TableColumn>> items = new ArrayList<TableFilterItem<TableColumn>>();
	if (searchColumsCombo != null && searchColumsText != null) {
	    int index = searchColumsCombo.getSelectionIndex();
	    if (index >= 0) {
		String valueString = searchColumsText.getText();
		valueString = valueString.trim();
		if (valueString.length() > 0) {
		    TableFilterItem<TableColumn> item = new TableFilterItem<TableColumn>();
		    ColumnSetting cs = searchColumns.get(index);
		    item.setColumn((TableColumn) cs.getColumn());
		    
		    int columnIndex = tableView.getColumnIndex(cs);
		    Class valueClass = tableView.getTableProvider().getColumnClass(columnIndex);
		    String field = tableView.getTableProvider().getColumnPropertyName(columnIndex);
		    
		    item.setColumnIndex(columnIndex);
		    item.setValueClass(valueClass);
		    item.setField(field);
		    
		    if (valueClass != null && valueClass.equals(String.class)){
			item.setClause(ICriteria.LIKE);
		    }
		    item.setValueString(valueString);
		    item.setValue(getValue(valueString, valueClass));
		    
		    items.add(item);
		}
	    }
	}
	tableView.getTableFilter().setItems(items);
	tableView.refilter();
    }
    
    protected Object getValue(String str, Class klass) {
	ObjectValue objectValue = getObjectCreator().createObjectValueByString(klass, str);
	if (objectValue == null) {
	    return null;
	}
	return objectValue.getValue();
    }
    
    protected ObjectCreator getObjectCreator() {
	return ((AbstractForm) getForm()).getObjectCreator();
    }
    
    public boolean isQuickSearchMode() {
	return true;
    }
    
    protected Control createQuickSearchPanel(Composite parent) {
	Composite panel = new Composite(parent, SWT.NULL);
	
	GridLayout layout = new GridLayout();
	layout.numColumns = 3;
	layout.verticalSpacing = 0;
	layout.marginHeight = 0;
	layout.marginWidth = 0;
	layout.marginTop = 0; // 0!!!
	layout.marginBottom = 0;
	layout.marginRight = 0;
	layout.horizontalSpacing = 5;
	layout.verticalSpacing = 0;

	panel.setLayout(layout);
	
	GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true); //SWT.FILL, SWT.CENTER, true, false
	gridData.verticalIndent = 0;
	gridData.horizontalIndent = 0;
	panel.setLayoutData(gridData);

	gridData = new GridData();
	gridData.horizontalAlignment = SWT.RIGHT;
	gridData.verticalAlignment = SWT.CENTER;
	gridData.grabExcessHorizontalSpace = false;
	gridData.grabExcessVerticalSpace = false;
	Label label = new Label(panel, SWT.NONE);
	label.setLayoutData(gridData);
	label.setText(Messages.getString("Form.search") + ":");

	
	gridData = new GridData();
	gridData.horizontalAlignment = SWT.RIGHT;
	gridData.verticalAlignment = SWT.CENTER;
	gridData.grabExcessHorizontalSpace = false;
	gridData.grabExcessVerticalSpace = false;
	gridData.widthHint = 120;
	searchColumsCombo = new Combo(panel, SWT.READ_ONLY);
	searchColumsCombo.setLayoutData(gridData);
	
	
	gridData = new GridData();
	gridData.horizontalAlignment = SWT.RIGHT;
	gridData.verticalAlignment = SWT.CENTER;
	gridData.grabExcessHorizontalSpace = false;
	gridData.grabExcessVerticalSpace = false;
	gridData.widthHint = 120;
	searchColumsText = new Text(panel, SWT.BORDER);
	searchColumsText.setLayoutData(gridData);
	searchColumsText.addKeyListener(new KeyAdapter() {
	    public void keyReleased(KeyEvent e) {
		if (SWT.CR == e.character) {
		    doQuickSearch();
		}
	    }
	});
	
	populateQuickSerachColums();
	
	return panel;
    }
    
    class QuickSearchContribution extends ControlContribution {

	public QuickSearchContribution(String id) {
	    super(id);
	}
	
	protected Control createControl(Composite parent) {
	    return createQuickSearchPanel(parent);
	}
    }

}
