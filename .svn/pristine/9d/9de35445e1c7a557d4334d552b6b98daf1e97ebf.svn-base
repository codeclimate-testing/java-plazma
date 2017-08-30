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

package net.sf.jasperreports.engine;

import java.util.Date;

import org.plazmaforge.framework.util.DateUtils;

public class JRDate {

    public static Date date(int year, int month, int day) {
	return DateUtils.getDate(year, month, day);
    }   

    public static int year(Date date) {
	return DateUtils.getYear(date);
    }
    
    
    /**
     * Return month (1..12) by date 
     * @param date
     * @return
     */
    public static int month(Date date) {
	return DateUtils.getMonth(date);
    }

    /**
     * Return day of month by date 
     * @param date
     * @return
     */
    public static int day(Date date) {
	return DateUtils.getDay(date);
    }
    
    
    public static long daysBetween(Date date1, Date date2) {
	return DateUtils.getDaysBetween(date1, date2);
    }   

    public Date min(Date date1, Date date2) {
	return DateUtils.min(date1, date2);
    }   

    public Date max(Date date1, Date date2) {
	return DateUtils.max(date1, date2);	
    }
    
    public static Date firstDateOfMonth(int year, int month) {
	return DateUtils.getFirstDateOfMonth(year, month);
    }
    
    public static Date lastDateOfMonth(int year, int month) {
	return DateUtils.getLastDateOfMonth(year, month);
    }
    
    public static Date firstDateOfMonth(Date date) {
	return DateUtils.getFirstDateOfMonth(date);
    }
    
    public static Date lastDateOfMonth(Date date) {
	return DateUtils.getLastDateOfMonth(date);
    }

}
