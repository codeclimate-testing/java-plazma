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

package org.plazmaforge.framework.client.swing.controls;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.text.DefaultFormatterFactory;

import org.plazmaforge.framework.core.SystemEnvironment;
import org.plazmaforge.framework.util.DateUtils;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * @author Oleh Hapon Date: 15.03.2004 Time: 10:36:14 $Id: XDateField.java,v 1.4 2010/12/05 07:52:09 ohapon Exp $
 */
public class XDateField extends JFormattedTextField {

    private DateFormat dateFormat;

    public XDateField() {
	init(null);
    }

    private void init(String datePattern) {
	initDatePattern(datePattern);
	// setFocusLostBehavior(JFormattedTextField.COMMIT);
    }

    private void initDatePattern(String datePattern) {

	if (datePattern == null) {
	    datePattern = getDefaultDatePattern();
	}
	try {
	    String maskPattern = DateUtils.getDateMaskPattern(datePattern);
	    dateFormat = new SimpleDateFormat(datePattern);
	    // DateMaskFormatter editFormatter = new
                // DateMaskFormatter(maskPattern);
	    MaskFormatter editFormatter = new MaskFormatter(maskPattern);
	    setFormatterFactory(new DefaultFormatterFactory(editFormatter));
	    setColumns(maskPattern.length());
	    // PlatformSystem.out.println(datePattern +"--x--" +
                // maskPattern);

	} catch (ParseException ex) {
	    ex.printStackTrace();
	}
    }

    private DateFormat getDateFormat() {
	return dateFormat;
    }

    private String getDefaultDatePattern() {
	return SystemEnvironment.getNormalizeDatePattern();
    }

    private final String EMPTY_VAL = null;

    public void setDate(Date date) {
	if (date == null) {
	    setValue(EMPTY_VAL);
	} else {
	    setValue(getDateFormat().format(date));
	}
    }

    public Date getDate() {
	Object val = null;
	Date date = null;
	try {
	    commitEdit();
	    val = getValue();
	    if (val == null)
		return null;
	    date = getDateFormat().parse((String) val);
	} catch (ParseException e) {
	    //
	}
	return date;
    }

    /*
         * private class DateMaskFormatter extends MaskFormatter {
         * 
         * 
         * public DateMaskFormatter() { super(); }
         * 
         * public DateMaskFormatter(String mask) throws ParseException {
         * super(mask); }
         * 
         * public String valueToString(Object value) throws ParseException { try {
         * Date date = (Date) value; return super.valueToString(date == null ?
         * null : dateFormat.format(date));
         *  } catch (Exception ex) { PlatformSystem.err.print("FORMAT OH");
         * ex.printStackTrace(); throw new ParseException(ex.getMessage(), 0); }
         *  }
         * 
         * public Object stringToValue(String value) throws ParseException { try {
         * return value == null ? null : dateFormat.parse(value); }catch
         * (Exception ex) { //PlatformSystem.err.print("PARSE OH " + value +
         * ((value == null)? "" : value.getClass().toString()));
         * //ex.printStackTrace(); //throw new ParseException(ex.getMessage(),
         * 0); return null; }
         *  } }
         * 
         * 
         * public void setDate(Date date) { setValue(date); }
         * 
         * public Date getDate() { return (Date) getValue(); }
         * 
         * public void setValue(Object value) { if ((value != null) && !(value
         * instanceof Date)) { throw new IllegalArgumentException("Value must be
         * Date type"); } super.setValue(value); }
         * 
         * public Object getValue() { try { commitEdit(); } catch
         * (ParseException e) { // } return super.getValue(); }
         */

}
