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
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
//import org.eclipse.swt.internal.win32.OS;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Spinner;
import org.plazmaforge.framework.client.Environment;

/** 
 * @author Oleh Hapon
 *
 */

public class XSpinnerField extends AbstractControl<Spinner> implements ISWTControl {
    

    /**
     * The Control
     */
    private Spinner spinner;
    
    
    public XSpinnerField(Composite parent) {
	this(parent, SWT.BORDER);
    }
    
    public XSpinnerField(Composite parent, int style) {
	super(parent, style);
	initialize(style);
    }
    
    
    
    private void initialize(int style) {
	spinner = new Spinner(this, SWT.NONE | SWT.RIGHT);
	spinner.setMaximum(Integer.MAX_VALUE);
	spinner.addFocusListener(new FocusAdapter() {
	    public void focusGained(FocusEvent e) {
		if (Environment.isSelectValueWhenFocus()) {
		    selectAll();
                }
            }
	});
	spinner.addModifyListener(new ModifyListener() {
	    public void modifyText(ModifyEvent e) {
		setModify(true);
	    }
	});
	
	super.setLayout(new FillLayout());
	getModel().setValueClass(Integer.class);
	
    }
    
    public void selectAll () {
	checkWidget();
	// TODO Must implement
	//OS.SendMessage (handle, OS.EM_SETSEL, 0, -1);
    }    
    
    public Spinner getUIControl() {
	return spinner;
    }

    
    
    public void setLayout (Layout layout) {
	checkWidget ();
    }
    
    
    

    /**
     * Returns the current value of the widget.<p>
     * 
     * @return Current value
     */
    public Object getValue() {
	return new Integer(spinner.getSelection());
    }

     
 
    /**
     * Sets a new value.<p>
     * 
     * @param value new value
     */
    public void setValue(Object value) {
	
	super.setValue(value);
	
	if (value == null) {
	    spinner.setSelection(0);
	    return;
	}
	if (!(value instanceof Integer)) {
	    throw new IllegalArgumentException("Value must be Integer");
	}
	spinner.setSelection((Integer) value);
    }
    
    
    public void setValueClass(Class valueClass) {
	// Not execute
    }
    
    /*
    public boolean isModify() {
	return !equalsModelAndValue();
    } 
    */
    
}
