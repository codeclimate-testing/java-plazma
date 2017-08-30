/*
 * Copyright (C) 2012-2013 Oleh Hapon ohapon@users.sourceforge.net
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

package org.plazmaforge.framework.core.data.presenter;

import java.util.Date;
//import java.util.Calendar;
//import java.util.GregorianCalendar;

import org.plazmaforge.framework.util.StringUtils;

public class TimePresenter extends DatePresenter {

    public static String DEFAULT_TIME_DELIM = ":";
    
    
    @Override
    public Object toValue(String str) {
	if (str == null) {
	    return null;
	}
	// TODO: Simple parser
	String[] array = StringUtils.split(str, DEFAULT_TIME_DELIM, true);
	if (array == null || array.length < 5) {
	    return null;
	}
	int hours = intValue(array[0]);
	int minutes = intValue(array[2]);
	int seconds = intValue(array[4]);
	return new Date(0, 0, 0, hours, minutes, seconds);
	
	//return new GregorianCalendar(0, 0, 0, hours, minutes, seconds).getTime();
    }
    
    
    @Override
    public String toString(Object value) {
	
	if (value == null) {
	    return null;
	}
	
	//TODO: Simple formatter
	Date date = toDate(value);

	//Calendar calendar = Calendar.getInstance();
	//calendar.setTime(date);
	
	//int hours = calendar.get(Calendar.HOUR_OF_DAY);
	//int minutes = calendar.get(Calendar.MINUTE);
	//int seconds = calendar.get(Calendar.SECOND);	
	
	int hours = date.getHours();
	int minutes = date.getMinutes();
	int seconds = date.getSeconds();	
	
	// HH:mm:ss
	return "" + toString2(hours) + ":" + toString2(minutes)+ ":" + toString2(seconds);
    }
    
}
