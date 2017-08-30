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

import java.util.List;


import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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
import org.plazmaforge.framework.client.swt.SWTUtils;

/** 
 * @author Oleh Hapon
 *
 */

public class ColumnSettingDialog<T, C, R>  extends Dialog {
    
    private Table table;
    
    private Object result;
    
    private ISWTTableView<T, C, R> view;
    
    private Shell shell;
    
    public ColumnSettingDialog (Shell parent, int style) {
	super (parent, style);
    }
    
    public ColumnSettingDialog (Shell parent) {
	this (parent, 0); // your default style bits go here (not the Shell's style bits)
    }
    
    public Object open () {
	
	setText(Messages.getString("ColumnSettingDialog.setting")); //$NON-NLS-1$
	
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
	content.setLayout(new FillLayout());
	content.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

	
	
	// -----------------------------------------------------
	// Content begin
	// -----------------------------------------------------
	table = new Table(content, SWT.BORDER | SWT.CHECK);
	table.setLinesVisible(true);
	table.setHeaderVisible(true);

	TableColumn newColumnTableColumn = new TableColumn(table, SWT.NONE);
	newColumnTableColumn.setWidth(310);
	newColumnTableColumn.setText(Messages.getString("ColumnSettingDialog.columns")); //$NON-NLS-1$
	
	initTable();
	// -----------------------------------------------------
	// Content end
	// -----------------------------------------------------
	
	
	
	// -----------------------------------------------------
	// ToolBar begin
	// -----------------------------------------------------
	toolBar = new Composite(composite, SWT.NONE);
	toolBar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
	gridLayout = new GridLayout();
	gridLayout.numColumns = 3;
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
	okButton.setText(Messages.getString("ColumnSettingDialog.ok")); //$NON-NLS-1$

	
	// Reset 
	Button resetButton = new Button(toolBar, SWT.NONE);
	resetButton.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		    doResetAction();
		}
	});
	resetButton.setLayoutData(new GridData(100, SWT.DEFAULT));
	resetButton.setText(Messages.getString("ColumnSettingDialog.reset")); //$NON-NLS-1$ //$NON-NLS-1$
	
	
	// Cancel
	Button cancelButton = new Button(toolBar, SWT.NONE);
	cancelButton.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		    doCancelAction();
		}
	});
	cancelButton.setLayoutData(new GridData(100, SWT.DEFAULT));
	cancelButton.setText(Messages.getString("ColumnSettingDialog.cancel")); //$NON-NLS-1$
	// -----------------------------------------------------
	// ToolBar end
	// -----------------------------------------------------
	

	shell.setSize(400, 300);
	SWTUtils.centerWindow(shell);
	//shell.pack();
	
	shell.open();
	Display display = parent.getDisplay();
	while (!shell.isDisposed()) {
	    if (!display.readAndDispatch()) display.sleep();
	}
	return result;
    }
    
    protected void doOkAction() {
	TableItem[] items = table.getItems();
	if (items == null || items.length == 0) {
	    close();
	    return;
	}
	List<ColumnSetting<T, C, R>> settings = view.getAvailableColumnSettings();
	if (settings == null || settings.size() == 0) {
	    close();
	    return;
	}
	
	if (!isChecked(items)) {
	    MessageDialog.openWarning(null, "Warning", "No columns");
	    return;
	}
	for (int i = 0; i < settings.size(); i++) {
	    boolean b = items[i].getChecked();
	    ColumnSetting<T, C, R> c = settings.get(i);
	    if (b != c.isVisible(view)) {
		c.setVisible(view, b);
	    }
	}
	close();
    }
    
    protected void doResetAction() {
	view.resetColumnSettings();
	close();
    }
    
    protected void doCancelAction() {
	close();
    }

    protected boolean isChecked(TableItem[] items) {
	if (items == null) {
	    return false;
	}
	for (int i = 0; i < items.length; i++) {
	    if (items[i].getChecked()) {
		return true;
	    }
	}
	return false;
    }
    
    protected void close() {
	shell.dispose();
    }
    public void setView(ISWTTableView<T, C, R> view) {
        this.view = view;
    }

    
    protected void initTable() {
	if (view == null) {
	    return;
	}
	List<ColumnSetting<T, C, R>> settings = view.getAvailableColumnSettings();
	
	if (settings.size() == 0) {
	    return;
	}
	table.setItemCount(settings.size());
	int index = -1; 
	for (ColumnSetting<T, C, R> c : settings) {
	    TableItem item = table.getItem(++index);
	    item.setText(0, view.getColumnText(c.getColumn()));
	    if (c.isVisible(view)) {
		item.setChecked(true);
	    }
	}
    }
}
