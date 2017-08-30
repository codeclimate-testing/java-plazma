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
package org.plazmaforge.bsolution.contact.common.beans.formatter.support.en;

import org.plazmaforge.bsolution.contact.common.beans.Phone;
import org.plazmaforge.bsolution.contact.common.beans.formatter.PhoneFormatValidator;
import org.plazmaforge.bsolution.contact.common.beans.formatter.PhoneFormatter;


public class ENPhoneFormatter extends ENAbstractContactFormatter implements
	PhoneFormatter {

    private PhoneFormatValidator validator = new PhoneFormatValidator();

    /**
     * Format address string
     * 
     * @param address
     * @return
     */
    public String format(Phone phone) {
	if (!validator.isValid(phone)) {
	    return getEmptyString();
	}
	StringBuffer buf = new StringBuffer();
	String phoneCode = phone.getPhoneCode();
	if (!isEmpty(phoneCode)) {
	    buf.append(phoneCode);
	    buf.append(" ");
	}
	buf.append(phone.getPhoneNumber());
	return buf.toString();
    }

    public String format(String phoneCode, String phoneNumber) {
	Phone phone = new Phone();
	phone.setPhoneCode(phoneCode);
	phone.setPhoneNumber(phoneNumber);
	return format(phone);
    }

}
