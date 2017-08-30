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
package org.plazmaforge.bsolution.contact.common.beans;

/**
 * @author Oleh Hapon Date: 2/7/2003 Time: 13:02:42
 */
public class Phone extends AbstractContactableItem implements ContactableItem {

    private PhoneType phoneType;

    private String phoneCode;

    private String phoneNumber;

    private String phoneString;
    
    private String phoneCompile;

    public String getPhoneCode() {
	return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
	this.phoneCode = phoneCode;
    }

    public String getPhoneNumber() {
	return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
    }

    public String getPhoneString() {
	return phoneString;
    }

    public void setPhoneString(String phoneString) {
	this.phoneString = phoneString;
	this.phoneCompile = toDigits(phoneString); // TODO: STUB
    }

    public String getPhoneCompile() {
        return phoneCompile;
    }

    public void setPhoneCompile(String phoneCompile) {
        this.phoneCompile = phoneCompile;
    }

    public String getPhoneTypeName() {
	return getPhoneType() == null ? null : getPhoneType().getName();
    }

    public PhoneType getPhoneType() {
	return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
	this.phoneType = phoneType;
    }
    
    private String toDigits(String str) {
	if (str == null) {
	    return null;
	}
	str = str.trim();
	if (str.isEmpty()) {
	    return null;
	}
	StringBuffer buf = new StringBuffer();
	char[] array = str.toCharArray();
	for (char ch : array) {
	    if (Character.isDigit(ch)) {
		buf.append(ch);
	    }
	}
	if (buf.length() == 0){
	    return null;
	}
	return buf.toString();
    }
}
