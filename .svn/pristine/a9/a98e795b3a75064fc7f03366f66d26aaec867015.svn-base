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

package org.plazmaforge.framework.client.swt.views;

import java.util.ArrayList;
import java.util.List;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.plazmaforge.framework.client.swt.SWTResourceManager;
import org.plazmaforge.framework.client.swt.SWTUtils;
import org.plazmaforge.framework.client.swt.TableUtils;



/** 
 * @author Oleh Hapon
 *
 */

public class SortDialog<T, C, R> extends Dialog {

    private static String DOWN_IMAGE_PATH = "/org/plazmaforge/framework/resources/images/eclipse/next_nav.gif";
    
    private static String UP_IMAGE_PATH = "/org/plazmaforge/framework/resources/images/eclipse/prev_nav.gif";
    
    private Table inputTable;   
    
    private Table outputTable;

    
    private int result;
    
    private ISWTTableView<T, C, R> view;
    
    private Shell shell;

    private int imageColumn = 0;
    
    private int textColumn = 1;

    
    public SortDialog (Shell parent, int style) {
	super (parent, style);
    }
    
    public SortDialog (Shell parent) {
	this (parent, 0); // your default style bits go here (not the Shell's style bits)
    }
    
    public int open () {
	
	result = 0;
	
	setText(Messages.getString("SortDialog.title")); //$NON-NLS-1$
	
	Composite composite;
	Composite toolBar;
	
	
	GridLayout gridLayout;
	GridData gridData;

	
	Shell parent = getParent();
	Shell shell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
	this.shell = shell;
	shell.setLayout(new FillLayout());
	shell.setText(getText());

	composite = new Composite(shell, SWT.NONE);
	composite.setLayout(new GridLayout());

	Composite content = new Composite(composite, SWT.NONE);
	GridLayout gridLayout_1 = new GridLayout();
	gridLayout_1.numColumns = 3;
	content.setLayout(gridLayout_1);
	content.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

	
	
	// -----------------------------------------------------
	// Content begin
	// -----------------------------------------------------
	inputTable = new Table(content, SWT.FULL_SELECTION | SWT.BORDER);
	inputTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
	inputTable.setLinesVisible(true);
	inputTable.setHeaderVisible(true);
	inputTable.addMouseListener(new MouseAdapter() {
		public void mouseDoubleClick(MouseEvent e) {
		    doAddAction();
		}
	});
	

	TableColumn marginTableColumn = new TableColumn(inputTable, SWT.NONE);
	marginTableColumn.setWidth(20);
	marginTableColumn.setResizable(false);
	
	TableColumn textTableColumn = new TableColumn(inputTable, SWT.NONE);
	textTableColumn.setWidth(300);
	textTableColumn.setResizable(false);
	textTableColumn.setText(Messages.getString("SortDialog.input.columns")); //$NON-NLS-1$

	Composite composite_1 = new Composite(content, SWT.NONE);
	composite_1.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false));
	composite_1.setLayout(new GridLayout());

	Button addButton = new Button(composite_1, SWT.NONE);
	addButton.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		    doAddAction();
		}
	});
	addButton.setLayoutData(new GridData(30, SWT.DEFAULT));
	addButton.setText(">");

	Button removeButton = new Button(composite_1, SWT.NONE);
	removeButton.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		    doRemoveAction();
		}
	});
	removeButton.setLayoutData(new GridData(30, SWT.DEFAULT));
	removeButton.setText("<");

	Button addAllButton = new Button(composite_1, SWT.NONE);
	addAllButton.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		    doAddAllAction();
		}
	});
	addAllButton.setLayoutData(new GridData(30, SWT.DEFAULT));
	addAllButton.setText(">>");

	Button removeAllButton = new Button(composite_1, SWT.NONE);
	removeAllButton.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		    doRemoveAllAction();
		}
	});
	removeAllButton.setLayoutData(new GridData(30, SWT.DEFAULT));
	removeAllButton.setText("<<");

	outputTable = new Table(content, SWT.FULL_SELECTION | SWT.BORDER);
	outputTable.setLinesVisible(true);
	outputTable.setHeaderVisible(true);
	outputTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	outputTable.addMouseListener(new MouseAdapter() {
		public void mouseDoubleClick(MouseEvent e) {
		    int column = TableUtils.getMouseEventColumn(e);
		    if (column == 1) {
			doRemoveAction();
		    }
		}
		
		public void mouseDown(MouseEvent e) {
		    int column = TableUtils.getMouseEventColumn(e);
		    if (column == 0) {
			doChangeDirectionAction();
		    }
		}
	});
	

	marginTableColumn = new TableColumn(outputTable, SWT.NONE);
	marginTableColumn.setWidth(20);
	marginTableColumn.setResizable(false);
	
	textTableColumn = new TableColumn(outputTable, SWT.NONE);
	textTableColumn.setWidth(300);
	textTableColumn.setResizable(false);
	textTableColumn.setText(Messages.getString("SortDialog.output.columns")); //$NON-NLS-1$
	
	initInputTable();
	initOutputTable();
	// -----------------------------------------------------
	// Content end
	// -----------------------------------------------------
	
	
	
	// -----------------------------------------------------
	// ToolBar begin
	// -----------------------------------------------------
	toolBar = new Composite(composite, SWT.NONE);
	toolBar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
	gridLayout = new GridLayout();
	gridLayout.numColumns = 2;
	toolBar.setLayout(gridLayout);

	Button okButton = new Button(toolBar, SWT.NONE);
	okButton.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		    doOkAction();
		}
	});
	gridData = new GridData(SWT.RIGHT, SWT.CENTER, true, false);
	gridData.widthHint = 100;
	okButton.setLayoutData(gridData);
	okButton.setText(Messages.getString("SortDialog.ok")); //$NON-NLS-1$

	Button cancelButton = new Button(toolBar, SWT.NONE);
	cancelButton.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		    doCancelAction();
		}
	});
	cancelButton.setLayoutData(new GridData(100, SWT.DEFAULT));
	cancelButton.setText(Messages.getString("SortDialog.cancel")); //$NON-NLS-1$
	// -----------------------------------------------------
	// ToolBar end
	// -----------------------------------------------------
	

	shell.setSize(700, 400);
	SWTUtils.centerWindow(shell);
	//shell.pack();
	
	shell.open();
	Display display = parent.getDisplay();
	while (!shell.isDisposed()) {
	    if (!display.readAndDispatch()) display.sleep();
	}
	return result;
    }
    
    
    /**
     * Add sort column.
     * 
     */
    protected void doAddAction() {
	int index = inputTable.getSelectionIndex();
	if (index < 0) {
	    return;
	}
	TableItem oldItem = inputTable.getItem(index);
	TableSorterItem<C> data = (TableSorterItem<C>) oldItem.getData();
	data.setDown(true); // Set flag by default
	inputTable.remove(index);
	
	int count = outputTable.getItemCount() + 1;
	outputTable.setItemCount(count);
	TableItem newItem = outputTable.getItem(count - 1);
	initItem(newItem, data, true);
    }
    
    /**
     * Remove sort column.
     *
     */
    protected void doRemoveAction() {
	int index = outputTable.getSelectionIndex();
	if (index < 0) {
	    return;
	}
	TableItem oldItem = outputTable.getItem(index);
	TableSorterItem data = (TableSorterItem) oldItem.getData();
	data.setDown(true); // Set flag by default
	outputTable.remove(index);
	
	int count = inputTable.getItemCount() + 1;
	inputTable.setItemCount(count);
	TableItem newItem = inputTable.getItem(count - 1);
	initItem(newItem, data, false);
    }
   
    protected void doAddAllAction() {
	if (inputTable.getItemCount() == 0) {
	    return;
	}
	List<TableSorterItem> dataList = getDataList(inputTable);
	inputTable.removeAll();
	
	int oldCount = outputTable.getItemCount();
	int deltaCount = dataList.size(); 
	int newCount = oldCount + deltaCount;
	outputTable.setItemCount(newCount);
	for (int i = 0; i < deltaCount; i++) {
	    TableSorterItem data = dataList.get(i);
	    data.setDown(true);
	    TableItem newItem = outputTable.getItem(oldCount + i);
	    initItem(newItem, data, true);
	}
    }

    protected void doRemoveAllAction() {
	if (outputTable.getItemCount() == 0) {
	    return;
	}
	List<TableSorterItem> dataList = getDataList(outputTable);
	outputTable.removeAll();
	
	int oldCount = inputTable.getItemCount();
	int deltaCount = dataList.size(); 
	int newCount = oldCount + deltaCount;
	inputTable.setItemCount(newCount);
	for (int i = 0; i < deltaCount; i++) {
	    TableSorterItem data = dataList.get(i);
	    data.setDown(true);
	    TableItem newItem = inputTable.getItem(oldCount + i);
	    initItem(newItem, data, false);
	}
    }   

    
    public List<TableSorterItem> getDataList() {
	return getDataList(outputTable);
    }
    
    
    protected List<TableSorterItem> getDataList(Table table) {
	List<TableSorterItem> list = new ArrayList<TableSorterItem>();
	TableItem[] items = table.getItems();
	for (TableItem item : items) {
	    list.add((TableSorterItem) item.getData());
	}
	return list;
    }
   
    protected void doChangeDirectionAction() {
	int index = outputTable.getSelectionIndex();
	if (index < 0) {
	    return;
	}
	TableItem item = outputTable.getItem(index);
	TableSorterItem data = (TableSorterItem) item.getData();
	data.setDown(!data.isDown());
	initImage(item, data.isDown());
    }
    
    protected void doOkAction() {
	result = SWT.OK;
	
	TableSorter sorter = view.getTableSorter();
	List<TableSorterItem> items = getDataList();
	
	if (!sorter.equals(items)) {
	    sorter.setItems(items);
	}
	view.initSortColumn();
	view.resort();
	
	close();
    }
    
    protected void doCancelAction() {
	close();
    }

    protected void close() {
	shell.dispose();
    }
    public void setView(ISWTTableView<T, C, R> view) {
        this.view = view;
    }

    
    protected void initInputTable() {
	if (view == null) {
	    return;
	}
	List<ColumnSetting<T, C, R>> settings = view.getUnSortColumnSettings();
	
	if (settings.size() == 0) {
	    return;
	}
	inputTable.setItemCount(settings.size());
	int index = -1; 
	for (ColumnSetting<T, C, R> c : settings) {
	    C column = c.getColumn();
	    TableSorterItem<C> data = new TableSorterItem<C>(column);
	    TableItem item = inputTable.getItem(++index);
	    
	    initItem(item, data, false);
	    
	}
    }
    
    protected void initOutputTable() {
	if (view == null) {
	    return;
	}
	TableSorter<T, C, R> sorter = view.getTableSorter();
	List<TableSorterItem<C>> items = sorter.getItems();
	
	if (items.size() == 0) {
	    return;
	}
	outputTable.setItemCount(items.size());
	int index = -1; 
	for (TableSorterItem<C> i : items) {
	    C column = i.getColumn();
	    TableSorterItem<C> data = new TableSorterItem<C>(column, i.isDown());	    
	    TableItem item = outputTable.getItem(++index);
	    
	    initItem(item, data, true);
	    
	}
    }
    
    protected void initItem(TableItem item, TableSorterItem<C> data) {
	initItem(item, data, true);
    }
    
    protected void initItem(TableItem item, TableSorterItem<C> data, boolean isOut) {
	item.setText(textColumn, view.getColumnText(data.getColumn()));
	item.setData(data);
	if (!isOut) {
	    return;
	}
	initImage(item, data.isDown());
    }
    
    protected void initImage(TableItem item, boolean isDown) {
	item.setImage(imageColumn, getImage(isDown));
    }
    
    protected Image getImage(boolean isDown) {
	return isDown ? getImage(UP_IMAGE_PATH) : getImage(DOWN_IMAGE_PATH); // Inverse
    }
    
    protected Image getImage(String path) {
	return SWTResourceManager.getImage(SortDialog.class, path);
    }
}
