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

/* 
 * Created on 15.02.2008
 *
 */

package org.plazmaforge.bsolution.base.client.swt.dialogs;



import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

/** 
 * @author Oleh Hapon
 * $Id: TableItemPanel.java,v 1.3 2010/07/06 14:45:29 ohapon Exp $
 */

public abstract class TableItemPanel extends ItemPanel {

    public static final String ADD = "ADD";
    
    public static final String EDIT = "EDIT";
    
    public static final String REMOVE = "REMOVE";
    
    
    private TableViewer viewer;
    
    
     
    
    
    
    public TableItemPanel(Composite parent, String title) {
	super(parent, title);
    }

    protected Composite createTableContent(Composite parent) {
	Composite content = createContent(parent);
	GridLayout layout = new GridLayout();
	layout.numColumns = 2;
	layout.horizontalSpacing = 0;
	layout.verticalSpacing = 0;

	content.setLayout(layout);

	createTable(content);
	createToolBar(content);

	return content;
    }

    protected Table createTable(Composite parent) {
	viewer = createTableViewer(parent);
	Table table = viewer.getTable();
	table.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
	return table;
    }

    protected Composite createToolBar(Composite parent) {
	Composite toolBar = new Composite(parent, SWT.NONE);
	toolBar.setLayoutData(new GridData(GridData.FILL, GridData.FILL, false,	true));
	GridLayout layout = new GridLayout();
	toolBar.setLayout(layout);

	Button addButton = createButton(toolBar, Messages.getString("TableItemPanel.add"));
	addButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
        	doAction(ADD);
            }
	});    
	Button editButton = createButton(toolBar, Messages.getString("TableItemPanel.edit"));
	editButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
        	doAction(EDIT);
            }
	});    

	Button removeButton = createButton(toolBar, Messages.getString("TableItemPanel.remove"));
	removeButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
        	doAction(REMOVE);
            }
	});    

	return toolBar;
    }

    protected abstract TableViewer createTableViewer(Composite parent);
    
      
    protected void doAction(String actionId) {
	if (ADD.equals(actionId)) {
	    doAddAction();
	} else if (EDIT.equals(actionId)) {
	    doEditAction();
	} else if (REMOVE.equals(actionId)) {
	    doRemoveAction();
	}
    }

    protected void doAddAction() {
	Object element = createElement();
	openEditDialog(ADD, element);
        refresh();
    }

    protected void doEditAction() {
	Object element = getSelectionFirstElement();
	if (element == null) {
	    return;
	}
	openEditDialog(EDIT, element);
        refresh();
    }

    protected void doRemoveAction() {
	Object element = getSelectionFirstElement();
	if (element == null) {
	    return;
	}

        boolean confirm = MessageDialog.openConfirm(getShell(), "Confirm", Messages.getString("TableItemPanel.confirm.remove") + " '" + element.toString() + "' ?");
        if (confirm) {
            removeElement();
            refresh();
            //selectFirstElement();
        }	
    }

    protected void createContent() {
	createTableContent(this);
    }
    
    

    public TableViewer getViewer() {
        return viewer;
    }
    
    
    protected StructuredSelection getSelection() {
	return (StructuredSelection) getViewer().getSelection();
    }

    protected Object getSelectionFirstElement() {
	return getSelection().getFirstElement();
    }
    
    protected void openEditDialog(String mode, Object element) {
	if (element == null) {
	    return;
	}
    }
    
    protected Object createElement() {
	return null;
    }
    
    protected void removeElement() {
	//
    }
    
    protected void refresh() {
	getViewer().refresh();
    }
}
