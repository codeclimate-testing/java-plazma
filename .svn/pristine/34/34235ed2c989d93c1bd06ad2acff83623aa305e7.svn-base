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

package org.plazmaforge.framework.client.swt.controls;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Layout;

/** 
 * @author Oleh Hapon
 * $Id: XCheckBox.java,v 1.2 2010/04/28 06:36:48 ohapon Exp $
 */

public class XCheckBox extends AbstractControl<Button> {

    /**
     * The Control
     */
    private Button button;
    
     

     public XCheckBox(Composite parent) {
	super(parent, SWT.NONE);
	initialize(SWT.NONE);
    }
    
    public XCheckBox(Composite parent, int style) {
	super(parent, style);
	initialize(style);
    }
    
    private void initialize(int style) {
	button = new Button(this, SWT.CHECK);
	super.setLayout(new FillLayout());
	//getModel().setValueClass(Boolean.class);
	button.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		setModify(true);
	    }
	});
    }
    
    public void setLayout (Layout layout) {
	checkWidget ();
    }
    
    
    public Button getUIControl() {
	return button;
    }

  
      
    public void setText(String text) {
	button.setText(text);
    }
    
    public String getText() {
	return button.getText();
    }
    
    public boolean booleanValue() {
	return button.getSelection();
    }

    public Object getValue() {
	return Boolean.valueOf(booleanValue());
    }

  
    public void setValue(Object value) {
	
	super.setValue(value);
	
	if (value == null) {
	    button.setSelection(false);
	    return;
	}
	//if (!(value instanceof Boolean)) {
	//    throw new IllegalArgumentException("Value must be Boolean");
	//}
	button.setSelection((Boolean) value);
    }
    
    public boolean getSelection() {
	return button.getSelection();
    }
    
    public void setSelection(boolean selected) {
	setValue(selected);
    }
    
    public void setValueClass(Class valueClass) {
	if (valueClass != null && !(valueClass.isAssignableFrom(Boolean.class) || valueClass.isAssignableFrom(Boolean.TYPE))) {
	    throw new IllegalArgumentException("Class must be Boolean");
	}
	getModel().setValueClass(valueClass);
    }
    

    public void addSelectionListener(SelectionListener listener) {
	button.addSelectionListener(listener);
    }
    
    
    /*
    public boolean isModify() {
	return !equalsModelAndValue();
    }
    */

    @Override
    public void setEnabled(boolean enabled) {
	super.setEnabled(enabled);
	if (button != null) {
	    button.setEnabled(enabled);
	}
    }
}
