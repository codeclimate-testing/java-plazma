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
 * Created on 17.12.2007
 *
 */

package org.plazmaforge.framework.client.swt.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

/** 
 * @author Oleh Hapon
 * $Id: AbstractJFaceDialog.java,v 1.2 2010/04/28 06:36:49 ohapon Exp $
 */

public abstract class AbstractJFaceDialog extends Dialog {

    /** Pack mode flag. If flag is true then we use parent.pack(); **/
    private boolean packMode = true;
    
    /** Cancel mode flag. If flag is true then add CANCEL button **/
    private boolean cancelMode = true;
    
    public AbstractJFaceDialog(IShellProvider parentShell) {
	super(parentShell);
    }

    public AbstractJFaceDialog(Shell parentShell) {
	super(parentShell);
    }
    
    protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
        if (isCancelMode()) {
            createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
        }
    }

    public void create() {
	super.create();
	initData();
    }
    
    protected void okPressed() {
	populateData();
	super.okPressed();
    }
    
    protected void initData() {
	// Initialize fields data
    }
    
    protected void populateData() {
	// Populate data
    }
    
    public boolean isPackMode() {
        return packMode;
    }

    public void setPackMode(boolean packMode) {
        this.packMode = packMode;
    }

    public boolean isCancelMode() {
        return cancelMode;
    }

    public void setCancelMode(boolean cancelMode) {
        this.cancelMode = cancelMode;
    }    
    

}
