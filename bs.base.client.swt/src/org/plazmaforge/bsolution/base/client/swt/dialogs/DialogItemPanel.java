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

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/** 
 * @author Oleh Hapon
 * $Id: DialogItemPanel.java,v 1.4 2010/07/06 14:35:42 ohapon Exp $
 */

public class DialogItemPanel extends ItemPanel {

    public DialogItemPanel(Composite parent, String title) {
	super(parent, title);
    }

    protected Text addTextField(Composite parent, String labelText) {
	return addTextField(parent, labelText, 0);
    }
    
    protected Text addTextField(Composite parent, String labelText, int width) {
	Label label = new Label(parent, SWT.NONE);
	label.setText(labelText);
	Text field = new Text(parent, SWT.BORDER);
	GridData gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	if (width > 0) {
	    gridData.widthHint = width;
	}
	field.setLayoutData(gridData);
	return field;
    }
    
    protected Combo addComboField(Composite parent, String labelText) {
	return addComboField(parent, labelText, 0);
    }
    
    protected Combo addComboField(Composite parent, String labelText, int width) {
	Label label = new Label(parent, SWT.NONE);
	label.setText(labelText);
	Combo field = new Combo(parent, SWT.BORDER | SWT.READ_ONLY);
	GridData gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	if (width > 0) {
	    gridData.widthHint = width;
	}
	field.setLayoutData(gridData);
	return field;
    }
    
    protected void populateComboField(Combo field, Object[] array) {
	if (field == null || array == null) {
	    return;
	}
	for (int i= 0; i < array.length ; i++) {
	    field.add("" + array[i]);
	}
    }
    
    
    protected int indexOf(Object obj, Object[] array) {
	if (obj == null || array == null) {
	    return -1;
	}
	for (int i = 0; i < array.length; i++) {
	    if (obj.equals(array[i])) {
		return i;
	    }
	}
	return -1;
    }
    
    
}
