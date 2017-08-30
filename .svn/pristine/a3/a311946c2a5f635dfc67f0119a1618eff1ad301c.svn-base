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

import org.plazmaforge.framework.util.StringUtils;

public class JRStr {

    public static String nullIfEmpty(String str) {
	return StringUtils.nullIfEmpty(str);
    }
    
    public static String emptyIfNull(String str) {
	return StringUtils.emptyIfNull(str);
    }
    
    public static String strIfNull(String str, String s) {
	return StringUtils.strIfNull(str, s);
    }
    
    /**
     * Return sub string
     * @param str
     * @param startIndex (start from 1)
     * @param length
     * @return
     */
    public static String substr(String str, int startIndex, int length) {
	if (str == null || startIndex < 1 || length < 0) {
	    return null;
	}
	int l = str.length();
	if (l == 0) {
	    return null;
	}
	if (startIndex > l) {
	    return null;
	}
	if (length > l) {
	    length = l;
	}
	startIndex--;
	return length == 0 ? str.substring(startIndex) : str.substring(startIndex, startIndex + length);
    }
    
    /**
     * Return sub string
     * @param str
     * @param startIndex (start from 1)
     * @return
     */
    public static String substr(String str, int startIndex) {
	 return substr(str, startIndex, 0);
    }
    
    
    /**
     * Return char by index
     * @param str
     * @param index (start from 1)
     * @return
     */
    public static String charAt(String str, int index) {
	return substr(str, index, 1);
    }
    
    public static String left(String str, int length) {
	return substr(str, 1, length);
    }

    public static String right(String str, int length) {
	if (str == null || length <= 0) {
	    return null;
	}
	int l = str.length();
	if (l == 0) {
	    return null;
	}
	int startIndex = length > l ? 1 : l - length + 1;
	return substr(str, startIndex, length);
    }

    public static String upper(String str) {
	if (str == null) {
	    return null;
	}
	return str.toUpperCase();
    }
    
    public static String lower(String str) {
	if (str == null) {
	    return null;
	}
	return str.toLowerCase();
    }
    
    public static int length(String str) {
	return (str == null) ? 0 : str.length();
    }

    public static String trim(String str) {
	return (str == null) ? null : str.trim();
    }

    
    
    public static String replace(String str, String s1, String s2) {
	return StringUtils.replaceAll(str, s1, s2);
    }
    
    public static String lpad(String str, int len, String pad) {
	return StringUtils.lpad(str, len);
    }
    
    public static String rpad(String str, int len, String pad) {
	return StringUtils.rpad(str, len);
    }
    
    
  
}
