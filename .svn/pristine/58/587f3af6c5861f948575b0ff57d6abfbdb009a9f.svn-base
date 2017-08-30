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
 * Created on 01.04.2007
 *
 */

package org.plazmaforge.framework.client.swt.dialogs;


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
import org.plazmaforge.framework.client.swt.SWTUtils;

/** 
 * @author Oleh Hapon
 * $Id: AbstractDialog.java,v 1.3 2010/04/28 06:36:49 ohapon Exp $
 */

public abstract class AbstractDialog extends Dialog {

    
    private int result;
    
    private Shell shell;
    
    private boolean packMode = true;
    
    private boolean cancelMode = true;
    
    
    public AbstractDialog (Shell parent, int style) {
	super (parent, style);
	initialize();
	
    }
    
    public AbstractDialog (Shell parent) {
	this (parent, 0);
    }
    
    private void initialize() {
	setText(Messages.getString("AbstractDialog.title")); //$NON-NLS-1$
    }

    public int open() {
	
	result = SWT.CANCEL;
	
	Shell parent = getParent();
	this.shell = createShell(parent);
	
	initShell();

	Composite mainPanel = createMainPanel(shell);
	Composite contentPanel = createContentPanel(mainPanel);
	
	createContent(contentPanel);

	createToolBarPanel(mainPanel);

	shell.setSize(400, 300);
	
	if (isPackMode()) {
	    shell.pack();	    
	}
	
	SWTUtils.centerWindow(shell);
	
	shell.open();
	Display display = parent.getDisplay();
	while (!shell.isDisposed()) {
	    if (!display.readAndDispatch()) display.sleep();
	}
	return result;
    }
    
    protected void doOkAction() {
	result = SWT.OK;
	performOkAction();
	close();
    }
    
    protected void doCancelAction() {
	result = SWT.CANCEL;
	performCancelAction();
	close();
    }

    protected void performOkAction() {
	// OK
    }
    
    protected void performCancelAction() {
	// CANCEL
    }
    
    protected void close() {
	shell.dispose();
    }
    
    
    protected Shell createShell(Shell parent) {
	return new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
    }
    
    protected void initShell() {
	shell.setLayout(new FillLayout());
	shell.setText(getText());
    }
    
    protected Composite createMainPanel(Composite parent) {
	Composite composite = new Composite(parent, SWT.NONE);
	composite.setLayout(new GridLayout());
	return composite;
    }
    
    protected Composite createContentPanel(Composite parent) {
	Composite composite = new Composite(parent, SWT.NONE);
	return composite;
    }
    
    protected Composite createToolBarPanel(Composite parent) {
	GridLayout gridLayout;
	GridData gridData;	
	Composite toolBar = new Composite(parent, SWT.NONE);
	toolBar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
	gridLayout = new GridLayout();
	gridLayout.numColumns = isCancelMode() ? 2 : 1;
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
	okButton.setText(Messages.getString("AbstractDialog.ok")); //$NON-NLS-1$

	// TODO: Hack. Bad code. Must use JFace dialog.  :(
	if (!isCancelMode()) {
	    return toolBar;
	}
	
	Button cancelButton = new Button(toolBar, SWT.NONE);
	cancelButton.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		    doCancelAction();
		}
	});
	cancelButton.setLayoutData(new GridData(100, SWT.DEFAULT));
	cancelButton.setText(Messages.getString("AbstractDialog.cancel")); //$NON-NLS-1$
	
	
	return toolBar;
    }
    
    
    protected abstract void createContent(Composite parent);
    
    
    public boolean isPackMode() {
        return packMode;
    }

    public void setPackMode(boolean packMode) {
        this.packMode = packMode;
    }

   
    protected void setResult(int result) {
	this.result = result;
    }

    public boolean isCancelMode() {
        return cancelMode;
    }

    public void setCancelMode(boolean cancelMode) {
        this.cancelMode = cancelMode;
    }

    
}
