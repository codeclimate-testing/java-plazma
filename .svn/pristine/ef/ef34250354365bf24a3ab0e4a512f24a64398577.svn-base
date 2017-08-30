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
import org.eclipse.swt.widgets.Text;

/** 
 * @author Oleh Hapon
 *
 */

public class XFormattedField extends AbstractTextControl {

     
    public XFormattedField(Composite parent) {
	this(parent, SWT.BORDER);
    }
    
    public XFormattedField(Composite parent, int style) {
	super(parent, style);
	initialize(style);
    }
    
    
    
    private void initialize(int style) {
	GridLayout layout = new GridLayout();
	layout.horizontalSpacing = layout.marginWidth = layout.marginHeight = 0;
	layout.marginBottom = 1; //1;
	layout.marginTop = 1; //1;
	super.setLayout(layout);
	
	text = new Text(this, SWT.NONE | SWT.RIGHT);
	
	initFocusListener();
	initModifyListener();
	
	GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, true);
	text.setLayoutData(gridData);
	ITextFormatter formatter = createFormatter();
	if (formatter != null) {
	    setFormatter(formatter);
	}
	
	super.setBackground(text.getBackground());
    }
    
    
    public void setLayout (Layout layout) {
	checkWidget ();
    }
    
    
    

    /**
     * Returns the current value of the widget.<p>
     * 
     * The returned value is provided by the formatter and is of the type managed
     * bu the formatter. For exemple a <code>DateFormatter</code> will return a
     * <code>Date</code> value.<br>
     * If no formatter is associated, the <code>String</code> contained in the
     * <code>Text</code> widget is returned.
     * 
     * @return Current value
     */
    public Object getValue() {
	return getFormatterValue();
    }

    // override
    // we replace null to getText()
    protected Object getFormatterValue() {
	return (getFormatter() != null ? getFormatter().getValue() : this.getText());
    }
    
    
    /**
     * Returns <code>true</code> if the current value is valid, else <code>false</code>.
     * 
     * @return <code>true</code> if valid.
     */
    public boolean isValid() {
      return getFormatter() != null ? getFormatter().isValid() : true;
    }


    /**
     * Sets a new value.<p>
     * 
     * If no formatter is currently associated to he widget, a new one is created
     * by the factory based on the value's class.<br>
     * If the value is incompatible with the formatter, an <code>IllegalArgumentException</code>
     * is returned.
     * 
     * @param value new value
     */
    public void setValue(Object value) {
	getModel().setValue(value);
	AbstractTextFormatter.setValue(text, value);
    }
    
    protected ITextFormatter createFormatter() {
	return createFormatter("-#,###,##0.00");
    }
    
    protected ITextFormatter createFormatter(String pattern) {
	NumberFormatter formatter = new NumberFormatter(pattern);
	formatter.setDecimalSeparatorAlwaysShown(false);
	formatter.setFixedLengths(true, true);
	return formatter;
    }
    
    
    public void setValueClass(Class valueClass) {
	if (getFormatter() != null && getFormatter().getValueClass() == null) {
	    getFormatter().setValueClass(valueClass);
	    getModel().setValueClass(valueClass);
	}
	
    }
    
    public Class getValueClass() {
	return getFormatter() == null ? null : getFormatter().getValueClass();
    }

   
}
