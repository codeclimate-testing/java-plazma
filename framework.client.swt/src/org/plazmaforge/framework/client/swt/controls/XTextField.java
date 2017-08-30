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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Layout;


/** 
 * @author Oleh Hapon
 *
 */

public class XTextField extends AbstractTextControl implements ISWTTextControl {

     
   
    public XTextField(Composite parent) {
	this(parent, SWT.BORDER);
    }
    
    public XTextField(Composite parent, int style) {
	super(parent, style);
	initialize(style);
    }
    
    
    
    private void initialize(int style) {
	
	int textStyle = SWT.NONE;
	if ((style & SWT.MULTI) != 0) {
	    textStyle = SWT.MULTI;
	}
	
	GridLayout layout = new GridLayout();
	layout.horizontalSpacing = layout.marginWidth = layout.marginHeight = 0;
	layout.marginBottom = 1; //1;
	layout.marginTop = 1; //1;
	super.setLayout(layout);
	
	
	createTextControl(textStyle);
	
	GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
	//gridData.verticalIndent = 0;
	text.setLayoutData(gridData);
	
	getModel().setValueClass(String.class);
	
	super.setBackground(text.getBackground());
	
	setTextLimit(255);
    }
    
    public void setLayout (Layout layout) {
	checkWidget ();
    }
    
    

    /**
     * Returns the current value of the widget.<p>
     * <code>Text</code> widget is returned.
     * 
     * @return Current value
     */
    public Object getValue() {
	//return text.getText();
	return getText();
    }

     
 
    /**
     * Sets a new value.<p>
     * 
     * @param value new value
     */
    public void setValue(Object value) {
	
	super.setValue(value);
	
	if (value == null) {
	    //text.setText(null);
	    setText(null);
	    return;
	}
	if (!(value instanceof String)) {
	    throw new IllegalArgumentException("Value must be String");
	}
	//text.setText((String) value);
	setText((String) value);
    }
    
    
    public void setValueClass(Class valueClass) {
	// Not execute
    }
    
    /*
    public boolean isModify() {
	return !equalsModelAndValue();
    }
    */

    
    public void setEditable(boolean editable) {
	super.setEditable(editable);
	setReadOnly(!editable);
    } 
    
 
}
