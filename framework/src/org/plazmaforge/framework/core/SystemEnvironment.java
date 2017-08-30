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
 * Created on 27.07.2005
 *
 */
package org.plazmaforge.framework.core;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.MissingResourceException;

import org.plazmaforge.framework.resources.LibraryResources;
import org.plazmaforge.framework.util.FormatUtils;


/**
 * @author Oleh Hapon
 */

public class SystemEnvironment {
	
    public static final String DEFAULT_CODEPAGE = "ISO-8859-1";

    public static final String DEFAULT_DOCUMENT_NUMBER_SYMBOL = "#";

    private static String documentNumberSymbol = DEFAULT_DOCUMENT_NUMBER_SYMBOL;

    private static String defaultCodepage = DEFAULT_CODEPAGE;

    private static String codepage = DEFAULT_CODEPAGE;

    private static SystemEnvironment ourInstance;

    //
    
    private SystemFormat systemFormat;
    
    
    public synchronized static SystemEnvironment getInstance() {
	if (ourInstance == null) {
	    ourInstance = new SystemEnvironment();
	}
	return ourInstance;
    }

    static {
	setDocumentNumberSymbol(getNullString("document.number.symbol"));
	setCodepage(System.getProperty("file.encoding"));
    }

    private static String getNullString(String key) {
	try {
	    return LibraryResources.getInstance().getString(key);
	} catch (MissingResourceException ex) {
	    return null;
	}
    }

    private SystemEnvironment() {

    }
    
    

    public SystemFormat getSystemFormat() {
	if (systemFormat == null) {
	    systemFormat = new SystemFormat();
	}
        return systemFormat;
    }

    public void setSystemFormat(SystemFormat systemFormat) {
        this.systemFormat = systemFormat;
    }

    public static String getDocumentNumberSymbol() {
	return documentNumberSymbol;
    }

    public static void setDocumentNumberSymbol(String documentNumberSymbol) {
	if (documentNumberSymbol == null) {
	    SystemEnvironment.documentNumberSymbol = DEFAULT_DOCUMENT_NUMBER_SYMBOL;
	    return;
	}
	SystemEnvironment.documentNumberSymbol = documentNumberSymbol;
    }

    public static String getCodepage() {
	return codepage;
    }

    public static void setCodepage(String codepage) {
	if (codepage == null) {
	    codepage = DEFAULT_CODEPAGE;
	}
	SystemEnvironment.codepage = codepage;
    }

    public static String getDefaultCodepage() {
	return defaultCodepage;
    }

    // Number Format

    public static NumberFormat getNumberFormat() {
	//return NumberFormat.getNumberInstance();
	return getInstance().getSystemFormat().getNumberFormat();
    }

    public static NumberFormat getIntegerFormat() {
	//return NumberFormat.getNumberInstance();
	return getInstance().getSystemFormat().getIntegerFormat();
    }

    
    // Number Patter

    public static String getNumberPattern() {
	//return ((DecimalFormat) getNumberFormat()).toPattern();
	return getInstance().getSystemFormat().getNumberPattern();
    }

    // Date Format

    public static DateFormat getDateFormat() {
	return getInstance().getSystemFormat().getDateFormat();
    }

    public static DateFormat getDateFormat(int dateStyle) {
	return DateFormat.getDateInstance(dateStyle);
    }

    public static DateFormat getDateFormat(int dateStyle, Locale locale) {
	return DateFormat.getDateInstance(dateStyle, locale);
    }

    // Date Pattern

    public static String getDatePattern() {
	return getInstance().getSystemFormat().getDatePattern();
    }

    public static String getNormalizeDatePattern() {
	return FormatUtils.normalizeDayAndMonth(getDatePattern());
    }

    public static String getDatePattern(int dateStyle) {
	return getDatePattern(dateStyle, Locale.getDefault());
    }

    public static String getDatePattern(int dateStyle, Locale locale) {
	return ((SimpleDateFormat) getDateFormat(dateStyle, locale)).toPattern();
    }

    // Date Time Format
    
    public static DateFormat getDateTimeFormat() {
	return getInstance().getSystemFormat().getDateTimeFormat();
    }


    public static DateFormat getDateTimeFormat(int dateStyle, int timeStyle) {
	return DateFormat.getDateTimeInstance(dateStyle, timeStyle);
    }

    public static DateFormat getDateTimeFormat(int dateStyle, int timeStyle, Locale locale) {
	return DateFormat.getDateTimeInstance(dateStyle, timeStyle, locale);
    }

    // Date Time Pattern
    
    public static String getDateTimePattern() {
	return getInstance().getSystemFormat().getDateTimePattern();
    }
    
    public static String getDateTimePattern(int dateStyle, int timeStyle) {
	return getDateTimePattern(dateStyle, timeStyle, Locale.getDefault());
    }

    public static String getDateTimePattern(int dateStyle, int timeStyle, Locale locale) {
	return ((SimpleDateFormat) getDateTimeFormat(dateStyle, timeStyle, locale)).toPattern();
    }

    
    // Time Format
    
    public static DateFormat getTimeFormat() {
	return getInstance().getSystemFormat().getTimeFormat();
    }


    // Time Pattern
    
    public static String getTimePattern() {
	return getInstance().getSystemFormat().getTimePattern();
    }
    
    // Document Date Format

    public static DateFormat getDocumentDateFormat() {
	return getDateFormat();
    }


    public static void main(String[] args) {
	System.out.println(((SimpleDateFormat) getDateFormat()).toPattern());
	System.out.println(getDateFormat().format(new Date()));
	System.out.println(FormatUtils.normalizeYear(((SimpleDateFormat) getDateFormat()).toPattern()));
    }

    public static String getTrueFalseString(boolean value) {
	return value ? getTrueString() : getFalseString();
    }

    public static String getYesNoString(boolean value) {
	return value ? getYesString() : getNoString();
    }

    public static String getTrueString() {
	return getNullString("message.true");
    }

    public static String getFalseString() {
	return getNullString("message.false");
    }

    public static String getYesString() {
	return getNullString("message.yes");
    }

    public static String getNoString() {
	return getNullString("message.no");
    }

    ////
    
    public static NumberFormat getCurrencyFormat() {
	return getInstance().getSystemFormat().getCurrencyFormat();
    }
    
    public static NumberFormat getPercentFormat() {
	return getInstance().getSystemFormat().getPercentFormat();
    }

    public static NumberFormat getQuantityFormat() {
	return getInstance().getSystemFormat().getQuantityFormat();
    }

    public static NumberFormat getCoefficientFormat() {
	return getInstance().getSystemFormat().getCoefficientFormat();
    }

    ////
    
    public static String getCurrencyPattern() {
	return getInstance().getSystemFormat().getCurrencyPattern();
    }
    
    public static String getPercentPattern() {
	return getInstance().getSystemFormat().getPercentPattern();
    }

    public static String getQuantityPattern() {
	return getInstance().getSystemFormat().getQuantityPattern();
    }

    public static String getCoefficientPattern() {
	return getInstance().getSystemFormat().getCoefficientPattern();
    }
}
