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

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;


import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
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
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.plazmaforge.framework.client.swt.SWTUtils;

/** 
 * @author Oleh Hapon
 *
 */

public class FilterDialog<T, C, R> extends Dialog {
    
    
    Object result;
    
    private ISWTTableView<T, C, R> view;
    
    private Shell shell;
    
    private List<FilterPanel<T, C, R>> filterPanels = new ArrayList<FilterPanel<T, C, R>>();
    
    private FilterPanel<T, C, R> filterPanel;
    
    private int filterType; 
    
    // STUB
    private DateFormat dateFormat;
    
    public FilterDialog (Shell parent, int style) {
	super (parent, style);
	setText(Messages.getString("FilterDialog.title")); //$NON-NLS-1$
    }
    
    public FilterDialog (Shell parent) {
	this (parent, 0);
    }
    
    public Object open () {
	
	
	
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
	
	createContent(composite);
	
	
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
	okButton.setText(Messages.getString("FilterDialog.ok")); //$NON-NLS-1$

	Button cancelButton = new Button(toolBar, SWT.NONE);
	cancelButton.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		    doCancelAction();
		}
	});
	cancelButton.setLayoutData(new GridData(100, SWT.DEFAULT));
	cancelButton.setText(Messages.getString("FilterDialog.cancel")); //$NON-NLS-1$
	// -----------------------------------------------------
	// ToolBar end
	// -----------------------------------------------------
	

	//shell.setSize(800, 800);
	shell.pack();
	SWTUtils.centerWindow(shell);
	
	shell.open();
	Display display = parent.getDisplay();
	while (!shell.isDisposed()) {
	    if (!display.readAndDispatch()) display.sleep();
	}
	return result;
    }
    
    
    public int getFilterType() {
        return filterType;
    }

    public void setFilterType(int filterType) {
        this.filterType = filterType;
    }

    protected void createContent(Composite parent) {
	// --------------------------------------
	// Content begin
	// --------------------------------------
	
	if (getFilterType() == 0) {
	    createTabFolder(parent);
	} else {
	    createFilterContent(parent, getFilterType());
	}
	
	// -----------------------------------------------------
	// Content end
	// -----------------------------------------------------
	
    }
    
    protected void createTabFolder(Composite parent) {
	TabFolder tabFolder = new TabFolder(parent, SWT.NONE);
    	tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    	
    	final TabItem simpleTabItem = new TabItem(tabFolder, SWT.NONE);
    	simpleTabItem.setText(Messages.getString("FilterDialog.simple"));
    	simpleTabItem.setControl(createFilterContent(tabFolder, FilterPanel.SIMPLE_TYPE));
    	
    	final TabItem advancedTabItem = new TabItem(tabFolder, SWT.NONE);
    	advancedTabItem.setText(Messages.getString("FilterDialog.advanced"));
    	advancedTabItem.setControl(createFilterContent(tabFolder, FilterPanel.ADVANCED_TYPE));
    	
    	// by default Simple Panel 
    	filterPanel = filterPanels.get(0);
    	
    	tabFolder.addSelectionListener(new SelectionAdapter() {
    	    public void widgetSelected(SelectionEvent e) {
    		if (e.item == simpleTabItem) {
    		    filterPanel = filterPanels.get(0);
    		} else if (e.item == advancedTabItem) {
    		    filterPanel = filterPanels.get(1);
    		} else {
    		    filterPanel = null;
    		}
    	    }
    	});
    }
    
    
    protected Composite createFilterContent(Composite parent, int type) {
	Composite content = new Composite(parent, SWT.NONE);
	content.setLayout(new FillLayout());
	content.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	
	ScrolledComposite scrolledComposite = new ScrolledComposite(content, SWT.V_SCROLL | SWT.BORDER);
	scrolledComposite.setExpandHorizontal(true);
	scrolledComposite.setExpandVertical(true);
	
	//scrolledComposite.setLayout(new FillLayout());
	
	filterPanel = createFilterPanel(scrolledComposite, type);
	filterPanels.add(filterPanel);
	
	scrolledComposite.setContent(filterPanel);
	scrolledComposite.setMinSize(filterPanel.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	return content;
    }
    
    protected FilterPanel<T, C, R> newFilterPanel(Composite parent, int type) {
	FilterPanel<T, C, R> filterPanel = null;
	if (type == FilterPanel.SIMPLE_TYPE) {
	    filterPanel = new SimpleFilterPanel<T, C, R>(this, parent);
	} else if (type == FilterPanel.ADVANCED_TYPE) {
	    filterPanel = new AdvancedFilterPanel<T, C, R>(this, parent);
	}
	return filterPanel;
    }
    
    protected FilterPanel<T, C, R> createFilterPanel(Composite parent, int type) {
	FilterPanel<T, C, R> filterPanel = newFilterPanel(parent, type);
	if (filterPanel == null) {
	    return null;
	}
	filterPanel.setDateFormat(getDateFormat());
	filterPanel.createContent();
	return filterPanel;
    }
    
    protected void doOkAction() {
	processOkAction();
	close();
    }
    
    protected void doCancelAction() {
	processCancelAction();
	close();
    }

    protected void close() {
	shell.dispose();
    }
    public void setView(ISWTTableView<T, C, R> view) {
        this.view = view;
    }

    
    public ISWTTableView<T, C, R> getView() {
        return view;
    }

    protected void processOkAction() {
	List<TableFilterItem<C>> items = filterPanel.getFilterItems();
	view.getTableFilter().setItems(items);
	view.refilter();
    }
    
    protected void processCancelAction() {
	
    }
    
    
    protected Composite getFilterPanel() {
        return filterPanel;
    }

    protected Shell getShell() {
        return shell;
    }

    protected List<TableFilterItem<C>> getFilterItems() {
	return filterPanel.getFilterItems();
    }
    
    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }
}

