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

package org.plazmaforge.framework.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.beanutils.locale.LocaleConvertUtilsBean;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.core.type.TypeUtils;
import org.plazmaforge.framework.core.type.Types;

public class ValueConverter {

    ////
    
    private Locale locale;
    
    private TimeZone timeZone;

    ////

    private String datePattern;
    
    private String numberPattern;

    ////
    
    private DateFormat dateFormat;
    
    private NumberFormat numberFormat;

    private LocaleConvertUtilsBean convertBean;
    
    
    public DateFormat getDateFormat() {
	if (dateFormat == null) {
	    dateFormat = new SimpleDateFormat(getDatePattern());
	}
	return dateFormat;
    }

    public NumberFormat getNumberFormat() {
	if (numberFormat == null) {
	    numberFormat = new DecimalFormat(getNumberPattern());
	}
	return numberFormat;
    }
    
    

    
    /**
     * Convert string value to concrete type object
     * @param value
     * @param type
     * @return
     * @throws ApplicationException
     */
    public Object convert(String value, String type) throws ApplicationException {

	try {

	    // oha
	    if (value == null) {
		return null;
	    }
	    
	    //oha
	    if (type == null) {
		return value;
	    }

	    if (type.equals(Types.StringType)) {
		return value;
	    }

	    value = value.trim();

	    if (value.length() == 0) {
		return null;
	    }

	    if (type.equals(Types.BooleanType)) {
		return value.equalsIgnoreCase("true") ? Boolean.TRUE : Boolean.FALSE;

	    } else if (type.equals(Types.ByteType)) {
		return new Byte((getNumberFormat().parse(value)).byteValue());

	    } else if (type.equals(Types.IntegerType)) {
		return new Integer((getNumberFormat().parse(value)).intValue());

	    } else if (type.equals(Types.LongType)) {
		return new Long((getNumberFormat().parse(value)).longValue());

	    } else if (type.equals(Types.ShortType)) {
		return new Short((getNumberFormat().parse(value)).shortValue());

	    } else if (type.equals(Types.DoubleType)) {
		return new Double((getNumberFormat().parse(value)).doubleValue());

	    } else if (type.equals(Types.FloatType)) {
		return new Float((getNumberFormat().parse(value)).floatValue());

	    } else if (type.equals(Types.BigDecimalType)) {
		return new BigDecimal((getNumberFormat().parse(value)).toString());

	    } else if (type.equals(Types.BigIntegerType)) {
		return new BigInteger(String.valueOf(getNumberFormat().parse(value).longValue()));

	    } else if (type.equals(Types.NumberType)) {
		return getNumberFormat().parse(value);

	    } else if (type.equals(Types.DateType)) {
		return getDateFormat().parse(value);

	    } else if (type.equals(Types.TimestampType)) {
		return new java.sql.Timestamp(getDateFormat().parse(value).getTime());

	    } else if (type.equals(Types.TimeType)) {
		return new java.sql.Time(getDateFormat().parse(value).getTime());

	    } else if (type.equals(Types.ObjectType)){
		return value;
	    } else
		throw new ApplicationException("Value of type '" + type + "' can not be converted");

	} catch (ParseException ex) {
	    throw new ApplicationException(ex);
	}

    }
    
    public Object convert(String value, Class valueClass) throws ApplicationException {
	return convert(value, TypeUtils.getType(valueClass));
	
/*	try {

	    // oha
	    if (value == null) {
		return null;
	    }
	    
	    //oha
	    if (valueClass == null) {
		return value;
	    }

	    if (valueClass.equals(String.class)) {
		return value;
	    }

	    value = value.trim();

	    if (value.length() == 0) {
		return null;
	    }

	    if (valueClass.equals(Boolean.class)) {
		return value.equalsIgnoreCase("true") ? Boolean.TRUE : Boolean.FALSE;

	    } else if (valueClass.equals(Byte.class)) {
		return new Byte((getNumberFormat().parse(value)).byteValue());

	    } else if (valueClass.equals(Integer.class)) {
		return new Integer((getNumberFormat().parse(value)).intValue());

	    } else if (valueClass.equals(Long.class)) {
		return new Long((getNumberFormat().parse(value)).longValue());

	    } else if (valueClass.equals(Short.class)) {
		return new Short((getNumberFormat().parse(value)).shortValue());

	    } else if (valueClass.equals(Double.class)) {
		return new Double((getNumberFormat().parse(value)).doubleValue());

	    } else if (valueClass.equals(Float.class)) {
		return new Float((getNumberFormat().parse(value)).floatValue());

	    } else if (valueClass.equals(BigDecimal.class)) {
		return new BigDecimal((getNumberFormat().parse(value)).toString());

	    } else if (valueClass.equals(BigInteger.class)) {
		return new BigInteger(String.valueOf(getNumberFormat().parse(value).longValue()));

	    } else if (valueClass.equals(java.lang.Number.class)) {
		return getNumberFormat().parse(value);

	    } else if (valueClass.equals(java.util.Date.class)) {
		return getDateFormat().parse(value);

	    } else if (valueClass.equals(java.sql.Timestamp.class)) {
		return new java.sql.Timestamp(getDateFormat().parse(value).getTime());

	    } else if (valueClass.equals(java.sql.Time.class)) {
		return new java.sql.Time(getDateFormat().parse(value).getTime());

	    } else if (valueClass.equals(Object.class)){
		return value;
	    } else
		throw new ApplicationException("Value of class '" + valueClass.getName() + "' can not be converted");

	} catch (ParseException ex) {
	    throw new ApplicationException(ex);
	}
*/
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public Locale getLocale() {
	if (locale == null) {
	    locale = Locale.getDefault();
	}
        return locale;
    }

    public TimeZone getTimeZone() {
	if (timeZone == null) {
	    timeZone = TimeZone.getDefault();
	}
        return timeZone;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        resetConvertBean();
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
        resetConvertBean();
    }
    
    ////
    
    //// XML Import
    protected LocaleConvertUtilsBean getConvertBean() {
	if (convertBean == null) {
	    convertBean = new LocaleConvertUtilsBean();
	    convertBean.setDefaultLocale(getLocale());
	    convertBean.deregister();
	    // convertBean.lookup();
	    convertBean.register(new TZDateLocaleConverter(getTimeZone()), Date.class, getLocale());
	}
	return convertBean;
    }
    
    //// XML Import
    public Object convertByLocale(String value, Class valueClass) {
	if (String.class.equals(valueClass)) {
	    return value;
	} else if (Number.class.isAssignableFrom(valueClass)) {
	    return getConvertBean().convert(value.trim(), valueClass, getLocale(), getNumberPattern());
	} else if (Date.class.isAssignableFrom(valueClass)) {
	    return getConvertBean().convert(value.trim(), valueClass, getLocale(), getDatePattern());
	} else if (Boolean.class.equals(valueClass)) {
	    return Boolean.valueOf(value);
	}
	return null;
    }

    //// XML Import
    public Object convertNumber(Number value, String type) throws ApplicationException {
	if (Types.ByteType.equals(type)) {
	    return new Byte(value.byteValue());
	} else if (Types.ShortType.equals(Short.class)) {
	    return new Short(value.shortValue());
	} else if (Types.IntegerType.equals(Integer.class)) {
	    return new Integer(value.intValue());
	} else if (Types.LongType.equals(Long.class)) {
	    return new Long(value.longValue());
	} else if (Types.FloatType.equals(Float.class)) {
	    return new Float(value.floatValue());
	} else if (Types.DoubleType.equals(Double.class)) {
	    return new Double(value.doubleValue());
	} else if (Types.BigIntegerType.equals(BigInteger.class)) {
	    return BigInteger.valueOf(value.longValue());
	} else if (Types.BigDecimalType.equals(BigDecimal.class)) {
	    return new BigDecimal(Double.toString(value.doubleValue()));
	} else {
	    throw new ApplicationException("Unknown number class " + type);
	}
    }

    public Object convertNumber(Number value, Class valueClass) throws ApplicationException {
	return convertNumber(value, TypeUtils.getType(valueClass));
	
//  	if (valueClass.equals(Byte.class)) {
//  	    return new Byte(value.byteValue());
//  	} else if (valueClass.equals(Short.class)) {
//  	    return new Short(value.shortValue());
//  	} else if (valueClass.equals(Integer.class)) {
//  	    return new Integer(value.intValue());
//  	} else if (valueClass.equals(Long.class)) {
//  	    return new Long(value.longValue());
//  	} else if (valueClass.equals(Float.class)) {
//  	    return new Float(value.floatValue());
//  	} else if (valueClass.equals(Double.class)) {
//  	    return new Double(value.doubleValue());
//  	} else if (valueClass.equals(BigInteger.class)) {
//  	    return BigInteger.valueOf(value.longValue());
//  	} else if (valueClass.equals(BigDecimal.class)) {
//  	    return new BigDecimal(Double.toString(value.doubleValue()));
//  	} else {
//  	    throw new ApplicationException("Unknown number class " + valueClass.getName());
//  	}
    }
    
    
    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
        //resetConvertBean();
    }

    public void setNumberPattern(String numberPattern) {
        this.numberPattern = numberPattern;
        //resetConvertBean();
    }


    public String getDatePattern() {
	if (datePattern == null) {
	    datePattern = new SimpleDateFormat().toPattern();
	}
        return datePattern;
    }


    public String getNumberPattern() {
	if (numberPattern == null) {
	    numberPattern = new DecimalFormat().toPattern();
	}
        return numberPattern;
    }        

    protected void resetConvertBean() {
	this.convertBean = null;
    }
    ////
    
    
}
