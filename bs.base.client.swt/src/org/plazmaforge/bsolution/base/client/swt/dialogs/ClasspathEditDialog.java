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
 * Created on 17.02.2008
 *
 */

package org.plazmaforge.bsolution.base.client.swt.dialogs;

import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/** 
 * @author Oleh Hapon
 * $Id: ClasspathEditDialog.java,v 1.3 2010/07/06 14:36:25 ohapon Exp $
 */

public class ClasspathEditDialog extends Dialog {

    private Text propertyField;
    
    private String element;
    
    private List<String> data;
    
    private String mode;
    
    public ClasspathEditDialog(Shell parentShell, String mode, String element) {
	super(parentShell);
	if (element == null) {
	    throw new IllegalArgumentException("Classpath is null");
	}
	this.mode = mode;
	this.element = element;
    }
    
    
    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }


    protected Control createDialogArea(Composite parent) {

        Composite parentComposite = (Composite) super.createDialogArea(parent);
        Composite composite = new Composite(parentComposite, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        composite.setLayout(layout);
        
        GridData gridData = null;
        Label nameLabel = new Label(composite, SWT.NONE);
        nameLabel.setText("Classpath");
        propertyField = new Text(composite, SWT.BORDER);
        gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
        gridData.widthHint = 300;
        propertyField.setLayoutData(gridData);
        
        
        updateControls();
        
        return parentComposite;
    }
    
    protected void updateControls() {
	propertyField.setText(element);
    }
    
    protected void updateData() {
	element = propertyField.getText();
    }
    
    protected void okPressed() {
	if (!isValid()) {
	    return;
	}
	updateData();
	if ("ADD".equals(mode)) {
	    getData().add(element);
	}
	super.okPressed();
    }

    protected boolean isValid() {
	StringBuffer buf = null;
	String text = propertyField.getText();
	if (text.trim().length() == 0) {
	    if (buf == null) {
		buf = new StringBuffer();
	    }
	    buf.append("Classpath is empty.");
	}
	
	String error = null;
	if (buf != null) {
	    error = buf.toString().trim(); 
	}
	if (error == null || error.length() == 0) {
	    return true;
	}
	MessageDialog.openError(getShell(), "Error", error);
	return false;
    }
    
}
