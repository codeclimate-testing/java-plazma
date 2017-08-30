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

package org.plazmaforge.bsolution.base.client.swt.dialogs;


import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

public class TransferTypeDialog extends TrayDialog {

    public static int CUSTOM_TYPE = 1;
    
    public static int STANDARD_TYPE = 2;
    
    private int tranferType;
    
    private boolean isOk;

    
    public TransferTypeDialog(IShellProvider parentShell) {
	super(parentShell);
    }

    public TransferTypeDialog(Shell shell) {
	super(shell);
    }

    protected void configureShell(Shell newShell) {
	super.configureShell(newShell);
	newShell.setText(Messages.getString("TransferTypeDialog.title")); //$NON-NLS-1$
    }
    
    protected Control createDialogArea(Composite parent) {
        Composite contents = (Composite) super.createDialogArea(parent);
        createSelector(contents);
        return contents;
    }
    
    protected void createSelector(Composite parent) {
	
	Group group = new Group(parent, 0);
	group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	GridLayout layout = new GridLayout(1, false);
	layout.marginWidth = 0;
	layout.marginHeight = 0;
	layout.marginLeft = 0;
	layout.marginRight = 0;
	layout.horizontalSpacing = 0;
	layout.verticalSpacing = 0;
	    
	group.setLayout(layout);
	
	createTypeButton(group, "CUSTOM", Messages.getString("TransferTypeDialog.custom"));
	createTypeButton(group, null, Messages.getString("TransferTypeDialog.standard"));
	
	tranferType = CUSTOM_TYPE; // by default
	
    }
    
    protected Button createTypeButton(Composite parent, String id, String text) {
	final Button button = new Button(parent, SWT.RADIO);
	if (id != null) {
	    button.setData(id);
	    button.addSelectionListener(new SelectionAdapter(){
		public void widgetSelected(SelectionEvent e) {
		    handleButonSelected(button);
		}
	    });
	}
	button.setText(text);
	return button;
    }
    
    protected void handleButonSelected(Button button) {
	if ("CUSTOM".equals(button.getData()) && button.getSelection() ) {
	    tranferType = CUSTOM_TYPE;
	} else {
	    tranferType = STANDARD_TYPE;
	}
    }
    
   
    
    public int getSelectionType() {
        return isOk ? tranferType : 0;
    }

  
    protected void okPressed() {
	isOk = true;
	super.okPressed();
    }
}
