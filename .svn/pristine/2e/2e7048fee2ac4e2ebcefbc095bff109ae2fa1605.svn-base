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

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JRFormat {

    
    public static String formatDate(Date date, String pattern) {
	if (date == null || pattern == null) {
	    return null;
	}
	SimpleDateFormat f = new SimpleDateFormat(pattern);
	return f.format(date);
    }
    
    public static String formatNumber(Number number, String pattern) {
	if (number == null || pattern == null) {
	    return null;
	}
	DecimalFormat f = new DecimalFormat(pattern);
	return f.format(number);
    }

}
