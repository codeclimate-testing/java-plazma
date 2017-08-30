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
 * Created on 20.06.2004
 *
 */
package org.plazmaforge.framework.util;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.plazmaforge.framework.core.SystemEnvironment;
import org.plazmaforge.framework.resources.LibraryResources;


/**
 * 
 * Special date utilities.
 * Use only Gregorian calendar (number of month) 
 * 
 * @author Oleh Hapon 
 * $Id: DateUtils.java,v 1.12 2010/12/05 07:51:28 ohapon Exp $
 */



public class DateUtils {

    public static final String PERIOD_SEPARATOR = "-";
    
    public static final long ONE_HOUR = 60 * 60 * 1000L;

    /**
     * Return name of month
     * @param gregorian month
     * @return
     */
    public static String getMonthName(int month) {
	return getMonthName(month, (String) null);
    }

    /**
     * Return name of month by language
     * @param gregorian month (1..12)
     * @param language
     * @return
     */
    public static String getMonthName(int month, String language) {
	return getMonthName(month, getLocaleByLanguage(language));
    }

    /**
     * Return name of month by locale
     * @param gregorian month (1..12)
     * @param locale
     * @return
     */
    public static String getMonthName(int month, Locale locale) {
	if (month < 1 || month > 12) {
	    throw new IllegalArgumentException("Month must be in range 1 and 12");
	}
	String key = "month-" + digitStr(month);
	String value = getResourceString(key);
	if (value == null) {
	    value = getDateFormatSymbols(locale).getMonths()[month - 1];
	}
	return value;
    }

    /**
     * Return 'move' name of month
     * @param gregorian month (1..12)
     * @return
     */
    public static String getMonthMoveName(int month) {
	return getMonthMoveName(month, (String) null);
    }

    /**
     * Return 'move' name of month by language
     * @param gregorian month (1..12)
     * @param language
     * @return
     */
    public static String getMonthMoveName(int month, String language) {
	return getMonthMoveName(month, getLocaleByLanguage(language));
    }

    /**
     * Return 'move' name of month by locale
     * @param gregorian month (1..12)
     * @param locale
     * @return
     */
    public static String getMonthMoveName(int month, Locale locale) {
	if (month < 1 || month > 12) {
	    throw new IllegalArgumentException("Month number must be in range 1 and 12");
	}
	String key = ("month-" + digitStr(month)) + "-move";
	String value = getResourceString(key, null, locale);
	if (value == null) {
	    value = getDateFormatSymbols(locale).getMonths()[month - 1];
	}
	return value;
    }

    ////
    
    public static String getPeriodName(Date start, Date end) {

	if (start == null || end == null) {
	    return "";
	}
	
	Calendar calendarStart = Calendar.getInstance();
	calendarStart.setTime(start);

	Calendar calendarEnd = Calendar.getInstance();
	calendarEnd.setTime(end);

	int startDay = calendarStart.get(Calendar.DAY_OF_MONTH);
	int startMonth = calendarStart.get(Calendar.MONTH);
	int startYear = calendarStart.get(Calendar.YEAR);

	int endDay = calendarEnd.get(Calendar.DAY_OF_MONTH);
	int endMonth = calendarEnd.get(Calendar.MONTH);
	int endYear = calendarEnd.get(Calendar.YEAR);
	
	int gregorianStartMonth = startMonth + 1;
	int gregorianEndMonth = endMonth + 1;

	if (startYear == endYear && startMonth == endMonth && startDay == 1) {

	    Calendar calendarBegin = Calendar.getInstance();
	    calendarBegin.setTimeInMillis(0);
	    calendarBegin.set(endMonth == Calendar.DECEMBER ? endYear + 1
		    : endYear, (endMonth == Calendar.DECEMBER) ? 0
		    : endMonth + 1, 1, 0, 0, 0);

	    calendarEnd.add(Calendar.DAY_OF_MONTH, 1);
	    
	    int day1 = calendarBegin.get(Calendar.DAY_OF_MONTH);
	    int day2 = calendarEnd.get(Calendar.DAY_OF_MONTH);
	    
	    if (day1 == day2) {
		return getMonthName(gregorianStartMonth) + " " + startYear;
	    }
	}
	return getDateString(startDay, gregorianStartMonth, startYear) + " " + PERIOD_SEPARATOR + " " + getDateString(endDay, gregorianEndMonth, endYear);

    }

    /**
     * Return string presentation of date
     * @param day
     * @param gregorian month (1..12)
     * @param year
     * @param language
     * @return
     */
    public static String getDateString(int day, int month, int year, String language) {
	return digitStr(day) + " " + getMonthMoveName(month, language) + " " + year;
    }

    /**
     * Return string presentation of date
     * @param day
     * @param gregorian month (1..12)
     * @param year
     * @return
     */
    public static String getDateString(int day, int month, int year) {
	return getDateString(day, month, year, null);
    }

    public static String getDateString(Date date, String language) {
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(date);
	int day = calendar.get(Calendar.DAY_OF_MONTH);
	int month = calendar.get(Calendar.MONTH);
	int year = calendar.get(Calendar.YEAR);
	int gregorianMonth = month + 1;
	return getDateString(day, gregorianMonth, year, language);
    }

    public static String getDateString(Date date) {
	return getDateString(date, null);
    }

    private static String digitStr(int d) {
	return (d < 10 ? "0" : "") + d;
    }


    private static String getResourceString(String key) {
	return getResourceString(key, null, null);
    }

    private static String getResourceString(String key, String defaultValue) {
	return getResourceString(key, defaultValue, null);
    }

    private static String getResourceString(String key, String defaultValue, Locale locale) {
	String value = getResourceString(key, locale);
	if (value == null) {
	    value = defaultValue;
	}
	return value;
    }

    private static String getResourceString(String key, Locale locale) {
	try {
	    return getBundle(LibraryResources.CALENDAR_RESOURCE_NAME, locale)
		    .getString(key);
	} catch (MissingResourceException ex) {
	    return null;
	}
    }

    private static ResourceBundle getBundle(String resourceName, Locale locale) {
	if (locale == null) {
	    locale = getLocaleByLanguage(Locale.getDefault().getLanguage());

	}
	return ResourceBundle.getBundle(resourceName, locale);
    }

    private static Locale getLocaleByLanguage(String language) {
	if (language == null) {
	    return Locale.getDefault();
	}
	return new Locale(language, "", "");
    }

    private static DateFormatSymbols getDateFormatSymbols(Locale locale) {
	return new DateFormatSymbols(locale);
    }

    public static String getDateMaskPattern(String datePattern) {
	return DateMaskCreator.getDateMaskPattern(datePattern);
    }

    
    public static String formatDate(Date date, String pattern) {
	if (date == null)
	    return "";
	if (pattern == null) {
	    return SystemEnvironment.getDateFormat().format(date);
	}
	return new SimpleDateFormat(pattern).format(date);
    }

    public static String formatDate(Date date) {
	return formatDate(date, null);
    }

    /**
     * Return number of quarter by gregorian month
     * @param gregorian month (1..12)
     * @return
     */
    public static int getQuarterByMonth(int month) {
	if (month < 1 || month > 12) {
	    throw new IllegalArgumentException("Month must be in range 1 and 12");
	}
	return (int) Math.ceil((float) month / 3);
    }
    
    /**
     * Return first gregorian month by quarter
     * @param quarter
     * @return gregorian month
     */
    public static int getFirstMonthByQuarter(int quarter) {
	if (quarter < 1 || quarter > 4) {
	    throw new IllegalArgumentException("Month must be in range 1 and 4");
	}
	return (quarter - 1) * 3 + 1;
    }

    /**
     * return list (3 elements) of gregorian month by quarter
     * @param quarter
     * @return gregorian month
     */
    public static int[] getMonthListByQuarter(int quarter) {
	int firstMonth = getFirstMonthByQuarter(quarter);
	int[] month = new int[3];
	month[0] = firstMonth;
	month[1] = ++firstMonth;
	month[2] = ++firstMonth;
	return month;
    }
    
    public static void populateMonthListByQuarter(int quarter, int[] array) {
	if (array == null) {
	    throw new IllegalArgumentException("Array must be not null");
	}
	if (array.length < 3) {
	    throw new IllegalArgumentException("Size of the array must be >= 3");
	}
	int[] monthList  = getMonthListByQuarter(quarter);
	array[0] = monthList[0];
	array[1] = monthList[1];
	array[2] = monthList[2];
    }
    
    public static void populateMonthListByQuarter(int quarter, Integer[] array) {
	if (array == null) {
	    throw new IllegalArgumentException("Array must be not null");
	}
	if (array.length < 3) {
	    throw new IllegalArgumentException("Size of the array must be >= 3");
	}
	int[] monthList  = getMonthListByQuarter(quarter);
	array[0] = monthList[0];
	array[1] = monthList[1];
	array[2] = monthList[2];
    }
    


    /**
     * Get date by year, month, day 
     * @param year
     * @param month (1..12)
     * @param day
     * @return
     */
    public static Date getDate(int year, int month, int day) {
	Calendar c = Calendar.getInstance();
	c.set(year, month - 1 , day, 0, 0, 0);
	c.set(Calendar.MILLISECOND, 0);
	return c.getTime();
    }   

    public static long getDaysBetween(Date date1, Date date2) {
	return ((date2.getTime() - date1.getTime() + ONE_HOUR) / (ONE_HOUR * 24));
    }   

    public static Date min(Date date1, Date date2) {
	if (date1 == null || date2 == null) {
	    return null;
	}
	if (date1.getTime() < date2.getTime()) {
	    return date1;
	}
	return date2;
    }   

    public static Date max(Date date1, Date date2) {
	if (date1 == null || date2 == null) {
	    return null;
	}
	if (date1.getTime() > date2.getTime()) {
	    return date1;
	}
	return date2;
    }   
    
    public static Date getPrevDay(Date date) {
	if (date == null) {
	    return null;
	}
	Calendar calendar = getCalendar(date);
	calendar.setTime(date);
	calendar.add(Calendar.DAY_OF_MONTH, -1);
	return calendar.getTime();
    }

    public static Date getNextDay(Date date) {
	if (date == null) {
	    return null;
	}
	Calendar calendar = getCalendar(date);
	calendar.add(Calendar.DAY_OF_MONTH, 1);
	return calendar.getTime();
    }
    
    /**
     * Get first date of month
     * @param year
     * @param month (1..12)
     * @return
     */
    public static Date getFirstDateOfMonth(int year, int month) {
	return getDate(year, month, 1);
    }

    public static Date getFirstDateOfMonth(Date date) {
	Calendar calendar = getCalendar(date);
	int year = calendar.get(Calendar.YEAR);
	int month = calendar.get(Calendar.DAY_OF_MONTH);
	return getFirstDateOfMonth(year, month);
    }

    /**
     * Get last date of month
     * @param year
     * @param month (1..12)
     * @return
     */
    public static Date getLastDateOfMonth(int year, int month) {
	if (month == 12) {
	    year = year + 1;
	    month = 1;
	} else {
	    month++;
	}
	return getPrevDay(getDate(year, month, 1));
    }
    
    public static Date getLastDateOfMonth(Date date) {
	Calendar calendar = getCalendar(date);
	int year = calendar.get(Calendar.YEAR);
	int month = calendar.get(Calendar.DAY_OF_MONTH);
	return getLastDateOfMonth(year, month);
    }
    
    /**
     * Get last day of month
     * @param year
     * @param month (1..12)
     * @return
     */
    public static int getLastDayOfMonth(int year, int month) {
	Date date = getLastDateOfMonth(year, month);
	if (date == null) {
	    return 0;
	}
	return getDay(date);
	
    }	
    
    public static int getLastDayOfMonth(Date date) {
	Calendar calendar = getCalendar(date);
	int year = calendar.get(Calendar.YEAR);
	int month = calendar.get(Calendar.DAY_OF_MONTH);
	return getLastDayOfMonth(year, month);
    }
    
    public static boolean isBetween(Date d, Date date1, Date date2) {
	if (d == null) {
	    return false;
	}
	long t = d.getTime();
	if (date1 == null) {
	    return t <= date2.getTime();
	}
	if (date2 == null) {
	    return t >= date1.getTime();
	}
	return  t >= date1.getTime() && t <= date2.getTime(); 
    }

    /**
     * Return year (yyyy) by date
     * @param date
     * @return
     */
    public static int getYear(Date date) {
	return getCalendar(date).get(Calendar.YEAR);
    }
    
    
    /**
     * Return month (1..12) by date 
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
	return getCalendar(date).get(Calendar.MONTH) + 1;
    }

    /**
     * Return day of month by date 
     * @param date
     * @return
     */
    public static int getDay(Date date) {
	return getCalendar(date).get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Return Calendar by Date
     * @param date
     * @return
     */
    public static Calendar getCalendar(Date date) {
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(date);
	return calendar;
    }
    
    public static Date getTruncDate(Date date) {
	if (date == null) {
	    return null;
	}
	Calendar calendar = getCalendar(date);
	calendar.set(Calendar.HOUR_OF_DAY, 0);
	calendar.set(Calendar.MINUTE, 0);
	calendar.set(Calendar.SECOND, 0);
	calendar.set(Calendar.MILLISECOND, 0);
	return calendar.getTime();
    }

}
