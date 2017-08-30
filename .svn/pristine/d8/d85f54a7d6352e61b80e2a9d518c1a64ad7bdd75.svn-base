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
 * Created on 23.08.2007
 *
 */

package org.plazmaforge.framework.core;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.plazmaforge.framework.util.FormatUtils;


/**
 * Configure display formats
 */
/** 
 * @author Oleh Hapon
 * $Id: SystemFormat.java,v 1.1 2010/12/05 07:51:25 ohapon Exp $
 */

public class SystemFormat implements Serializable {

    private String datePattern;
    
    private String dateTimePattern;
    
    private String timePattern;
    
    
    private String numberPattern;
    
    private String integerPattern;
    
    private String currencyPattern;
    
    private String percentPattern;
    
    private String quantityPattern;
    
    private String coefficientPattern;
    
    
    

    public String getCoefficientPattern() {
	if (coefficientPattern == null) {
	    coefficientPattern = getDefaultCoefficientPattern();
	}
        return coefficientPattern;
    }

    public void setCoefficientPattern(String coefficientPattern) {
        this.coefficientPattern = coefficientPattern;
    }

    public String getCurrencyPattern() {
	if (currencyPattern == null) {
	    currencyPattern = getDefaultCurrencyPattern();
	}
        return currencyPattern;
    }

    public void setCurrencyPattern(String currencyPattern) {
        this.currencyPattern = currencyPattern;
    }

    public String getDatePattern() {
	if (datePattern == null) {
	    datePattern = getDefaultDatePattern();
	}
        return datePattern;
    }

    public void setDatePattern(String datePattern) {
	FormatUtils.validateDatePattern(datePattern);
        this.datePattern = datePattern;
    }

    public String getDateTimePattern() {
	if (dateTimePattern == null) {
	    dateTimePattern = getDefaultDateTimePattern();
	}
        return dateTimePattern;
    }

    public void setDateTimePattern(String dateTimePattern) {
        this.dateTimePattern = dateTimePattern;
    }

    public String getIntegerPattern() {
	if (integerPattern == null) {
	    integerPattern = getDefaultIntegerPattern();
	}
        return integerPattern;
    }

    public void setIntegerPattern(String integerPattern) {
        this.integerPattern = integerPattern;
    }

    public String getNumberPattern() {
	if (numberPattern == null) {
	    numberPattern = getDefaultNumberPattern();
	}
        return numberPattern;
    }

    public void setNumberPattern(String numberPattern) {
        this.numberPattern = numberPattern;
    }

    public String getPercentPattern() {
	if (percentPattern == null) {
	    percentPattern = getDefaultPercentPattern();
	}
        return percentPattern;
    }

    public void setPercentPattern(String percentPattern) {
        this.percentPattern = percentPattern;
    }

    public String getQuantityPattern() {
	if (quantityPattern == null) {
	    quantityPattern = getDefaultQuantityPattern();
	}
        return quantityPattern;
    }

    public void setQuantityPattern(String quantityPattern) {
        this.quantityPattern = quantityPattern;
    }

    public String getTimePattern() {
	if (timePattern == null) {
	    timePattern = getDefaultTimePattern();
	}
        return timePattern;
    }

    public void setTimePattern(String timePattern) {
	FormatUtils.validateTimePattern(timePattern);
        this.timePattern = timePattern;
    }
    
    
    ////

    public SimpleDateFormat getDefaultDateFormat() {
	return (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.SHORT);
    }
    
    public SimpleDateFormat getDefaultTimeFormat() {
	return (SimpleDateFormat) DateFormat.getTimeInstance(DateFormat.MEDIUM);
    }

    public SimpleDateFormat getDefaultDateTimeFormat() {
	return (SimpleDateFormat) DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM);
    }

    ////
    
    public String getDefaultDatePattern() {
	SimpleDateFormat dateFormat = getDefaultDateFormat();
	return FormatUtils.normalizeYear(dateFormat.toPattern());
    }

    public String getDefaultTimePattern() {
	SimpleDateFormat timeFormat = getDefaultTimeFormat();
	return timeFormat.toPattern();

	//return "hh:mm:ss";
	//return FormatUtils.getDefaultTimePattern();
    }

    ////
    
    public String getDefaultNumberPattern() {
	return getDefaultNumberFormat().toPattern();
    }
    
    public DecimalFormat getDefaultNumberFormat() {
	return (DecimalFormat) NumberFormat.getNumberInstance();
    }

    public String getDefaultDateTimePattern() {
	//return "" + getDatePattern() + " " + getTimePattern();
	return getDefaultDateTimeFormat().toPattern();
    }
    

    public String getDefaultCurrencyPattern() {
	//return "#,##0.00";
	return FormatUtils.getDefaultCurrencyPattern();
    }

    public String getDefaultPercentPattern() {
	//return "#0.00";
	//return "#,##0.00";
	return FormatUtils.getDefaultPercentPattern();
    }

    public String getDefaultQuantityPattern() {
	//return "#0.000";
	//return "#,##0.000";
	return FormatUtils.getDefaultQuantityPattern();
    }

    public String getDefaultCoefficientPattern() {
	//return "#0.000";
	//return "#,##0.000";
	return FormatUtils.getDefaultCoefficientPattern();
    }

    public String getDefaultIntegerPattern() {
	//return "#,##0";
	return FormatUtils.getDefaultIntegerPattern();
    }

    ////
    
    protected DecimalFormat createDecimalFormat(String pattern) {
	DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
	DecimalFormat format = new DecimalFormat(pattern, symbols);
	return format;
    }
    
    ////
    
    public DateFormat createSimpleDateFormat(String pattern) {
	return new SimpleDateFormat(pattern);
    }
    
    ////
    
    public DateFormat getDateFormat() {
	return createSimpleDateFormat(getDatePattern());
    }

    public DateFormat getDateTimeFormat() {
	return createSimpleDateFormat(getDateTimePattern());
    }

    public DateFormat getTimeFormat() {
	return createSimpleDateFormat(getTimePattern());
    }

    public NumberFormat getNumberFormat() {
	return createDecimalFormat(getNumberPattern());
    }

    ////
    
    public NumberFormat getCurrencyFormat() {
	return createDecimalFormat(getCurrencyPattern());
    }
    
    public NumberFormat getPercentFormat() {
	return createDecimalFormat(getPercentPattern());
    }    
    
    public NumberFormat getQuantityFormat() {
	return createDecimalFormat(getQuantityPattern());
    }  
    
    public NumberFormat getCoefficientFormat() {
	return createDecimalFormat(getCoefficientPattern());
    }

    public NumberFormat getIntegerFormat() {
	return createDecimalFormat(getIntegerPattern());
    }

    
}
