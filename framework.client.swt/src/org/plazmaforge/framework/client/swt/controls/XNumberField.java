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

import java.math.BigDecimal;
import java.math.BigInteger;


import org.eclipse.swt.widgets.Composite;
import org.plazmaforge.framework.platform.PlatformEnvironment;

/** 
 * @author Oleh Hapon
 *
 */

public class XNumberField extends XFormattedField {

    public XNumberField(Composite parent, int style) {
	super(parent, style);
    }

    
    public XNumberField(Composite parent) {
	super(parent);
    }

    protected String getDefaultPattern() {
	return getAdaptPattern(PlatformEnvironment.getNumberPattern(), true);
    }
    
    protected ITextFormatter createFormatter(String pattern) {
	NumberFormatter formatter = new NumberFormatter(pattern);
	formatter.setDecimalSeparatorAlwaysShown(false);
	formatter.setFixedLengths(true, true);
	return formatter;
    }
    
    public void setValue(Byte value) {
	setValueClass(Byte.class);
	super.setValue(value);
    }

    public void setValue(Short value) {
	setValueClass(Short.class);
	super.setValue(value);
    }
    
    public void setValue(Integer value) {
	setValueClass(Integer.class);
	super.setValue(value);
    }
    
    public void setValue(Long value) {
	setValueClass(Long.class);
	super.setValue(value);
    }
    
    public void setValue(Float value) {
	setValueClass(Float.class);
	super.setValue(value);
    }    
    
    public void setValue(Double value) {
	setValueClass(Double.class);
	super.setValue(value);
    }
    
    public void setValue(BigInteger value) {
	setValueClass(BigInteger.class);
	super.setValue(value);
    }
    
    public void setValue(BigDecimal value) {
	setValueClass(BigDecimal.class);
	super.setValue(value);
    }
    
    public void setValue(Object value) {
	if (value != null && !(value instanceof Number)) {
	    throw new IllegalArgumentException("Value must be Number");
	}
	super.setValue(value);
    }
 
    public Number getNumberValue() {
	Object value = getValue();
	if (value == null) {
	    return null;
	}
	if (value instanceof Number) {
	    return (Number) value;
	}
	return null;
    }
    

    public byte byteValue() {
	Number value = getNumberValue();
	if (value == null) {
	    return 0;
	}
	return value.byteValue();
    }

    public int intValue() {
	Number value = getNumberValue();
	if (value == null) {
	    return 0;
	}
	return value.intValue();
    }
    
    public float floatValue() {
	Number value = getNumberValue();
	if (value == null) {
	    return 0f;
	}
	return value.floatValue();
    }
    
    public double doubleValue() {
	Number value = getNumberValue();
	if (value == null) {
	    return 0d;
	}
	return value.doubleValue();
    }
    
    protected String getAdaptPattern(String pattern, boolean isExtend) {
	if (pattern == null) {
	    return null;
	}
	String newPattern = pattern.trim();
	if (newPattern.length() < 2) {
	    return newPattern;
	}
	if (newPattern.startsWith("-")) {
	    return newPattern;
	}
	if (!isExtend) {
	    return "-" + newPattern;
	}
	
	// Extend
	int digitCount = 0;
	boolean isGroup = false;
	for (int i = 0 ; i < newPattern.length(); i++) {
	    char ch = newPattern.charAt(i);
	    if (ch ==  '.') {
		break;
	    }
	    if (ch ==  ',') {
		isGroup = true;
	    }
	    if (ch ==  '#' || ch ==  '0') {
		digitCount++;
	    }

	}
	// TODO: STUB
	int okSize = 7;
	if (digitCount >= okSize) {
	    return "-" + newPattern;
	}
	StringBuffer preffix = new StringBuffer();
	int restSize = okSize - digitCount;
	// 1 and 4
	for (int i = 0; i < restSize; i++) {
	    if (isGroup && (i == 1 || i == 4)) {
		preffix.append(",");
	    }
	    preffix.append("#");
	}
	newPattern = "-" + preffix.toString() + newPattern;
	return newPattern;
    }
}
