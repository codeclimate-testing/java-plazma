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
package org.plazmaforge.bsolution.contact.common.beans.formatter;

import java.util.Locale;

import org.plazmaforge.bsolution.contact.common.beans.Address;
import org.plazmaforge.framework.core.LocaleManager;
import org.plazmaforge.framework.ext.model.Dictionary;
import org.plazmaforge.framework.util.StringUtils;


public abstract class AbstractContactFormatter implements ContactFormatter {

    protected final String EMPTY_STRING = "";

    protected final String BLANK_STRING = " ";

    protected final String POINT_STRING = ".";
    
    private String addressVariant;

    /**
     * Accept formatter by Locale
     */
    public boolean accept(Locale locale) {
	if (locale == null) {
	    return false;
	}
	String language = locale.getLanguage();
	if (language == null) {
	    return false;
	}
	String[] languages = this.getLanguages();
	if (languages == null) {
	    return false;
	}
	for (int i = 0; i < languages.length; i++) {
	    if (language.equals(languages[i])) {
		return true;
	    }
	}
	return false;
    }

    /**
     * Supported languages
     * 
     * @return
     */
    public abstract String[] getLanguages();

    protected String getEmptyString() {
	return EMPTY_STRING;
    }

    protected boolean isEmpty(String str) {
	return StringUtils.isEmpty(str);
    }

    protected String getPrefix(boolean isStartString) {
	return getPrefix(isStartString, BLANK_STRING);
    }

    protected String getPrefix(boolean isStartString, String prefix) {
	return (isStartString ? prefix : EMPTY_STRING);
    }

    protected void addString(StringBuffer buf, String str,
	    boolean isStartString, String prefix) {
	buf.append(getPrefix(isStartString, prefix) + str.trim());
    }

    protected void addString(StringBuffer buf, String str, boolean isStartString) {
	addString(buf, str, isStartString, BLANK_STRING);
    }

    protected String getDictionaryName(Dictionary dictionary) {
	return dictionary == null ? null : dictionary.getName();
    }

    protected String getDictionaryFullName(Dictionary dictionary) {
	return dictionary == null ? null : dictionary.getFullName();
    }

    /**
     * Make type string. In default mode isPostType = false Example: ap. 2
     * First token is "ap." (type), second token is "2" (str)
     * 
     * @param type
     * @param str
     * @param separator
     * @return
     */
    protected String getTypeString(String type, String str, String separator) {
	return getTypeString(type, str, separator, false);
    }

    /**
     * Make type string 
     * Example 1: West Avenu (isPostType = true) 
     * Example 2: ap. 127 (isPostType = false)
     * 
     * @param type
     * @param str
     * @param separator
     * @param isPostType
     * @return
     */
    protected String getTypeString(String type, String str, String separator,
	    boolean isPostType) {
	if (isEmpty(str)) {
	    return EMPTY_STRING;
	}
	String typeName = null;
	if (!isEmpty(type)) {
	    typeName = type.trim() + separator;
	}
	String resultStr = str.trim();
	return typeName == null ? resultStr : typeString(typeName, resultStr,
		isPostType);
    }

    /**
     * Make type string
     * 
     * @param type
     * @param str
     * @return
     */
    protected String getTypeString(String type, String str) {
	return getTypeString(type, str, POINT_STRING);
    }

    /**
     * Make string
     * 
     * @param type
     * @param str
     * @param isPostType
     * @return
     */
    private String typeString(String type, String str, boolean isPostType) {
	return isPostType ? (str + BLANK_STRING + type)
		: (type + BLANK_STRING + str);
    }
    
    
    
    public boolean isComplexAddressVariant(Address address) {
	if (addressVariant != null && LocaleManager.isValidAddressVariant(addressVariant)) {
	    return LocaleManager.isComplexAddressVariant(addressVariant);
	}
	if (address!= null && LocaleManager.isValidAddressVariant(address.getAddressVariant())) {
	    return LocaleManager.isComplexAddressVariant(address.getAddressVariant());
	}
	return LocaleManager.isComplexAddressVariant();
    }

    public boolean isSimpleAddressVariant(Address address) {
	return !isComplexAddressVariant(address);
    }

    public String getAddressVariant() {
        return addressVariant;
    }

    public void setAddressVariant(String addressVariant) {
        this.addressVariant = addressVariant;
    }
    
    //public abstract String formatLocalityAddress(String localityTypeName, String localityName, String addressString);
    
   
}
