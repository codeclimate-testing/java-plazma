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

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.plazmaforge.bsolution.contact.common.beans.Address;
import org.plazmaforge.bsolution.contact.common.beans.Phone;
import org.plazmaforge.bsolution.contact.common.beans.StreetType;
import org.plazmaforge.bsolution.contact.common.beans.formatter.support.en.ENAddressFormatter;
import org.plazmaforge.bsolution.contact.common.beans.formatter.support.en.ENPhoneFormatter;
import org.plazmaforge.bsolution.contact.common.beans.formatter.support.xu.XUAddressFormatter;
import org.plazmaforge.bsolution.contact.common.beans.formatter.support.xu.XUPhoneFormatter;


public class ContactFormatterFactory {

    private static ContactFormatterFactory instance;

    /** List of address formatrer */
    private List addressFormatters = new ArrayList();

    /** List of phone formatter */
    private List phoneFormatters = new ArrayList();

    public static ContactFormatterFactory getInstance() {
	if (instance == null) {
	    instance = new ContactFormatterFactory();

	    instance.addressFormatters.add(new ENAddressFormatter());
	    instance.addressFormatters.add(new XUAddressFormatter());

	    instance.phoneFormatters.add(new ENPhoneFormatter());
	    instance.phoneFormatters.add(new XUPhoneFormatter());

	}
	return instance;
    }

    public void addAddresFormatter(AddressFormatter formatter) {
	addressFormatters.add(formatter);
    }

    public AddressFormatter getDefaultAddressFormatter() {
	return (AddressFormatter) addressFormatters.get(0);
    }

    public List getAddressFormatterList() {
	return addressFormatters;
    }

    public static AddressFormatter getAddressFormatter() {
	AddressFormatter formatter = (AddressFormatter) getContactFormatter(getInstance()
		.getAddressFormatterList());
	return formatter == null ? getInstance().getDefaultAddressFormatter()
		: formatter;
    }

    public void addPhoneFormatter(PhoneFormatter formatter) {
	phoneFormatters.add(formatter);
    }

    public PhoneFormatter getDefaultPhoneFormatter() {
	return (PhoneFormatter) phoneFormatters.get(0);
    }

    public List getPhoneFormatterList() {
	return phoneFormatters;
    }

    public static PhoneFormatter getPhoneFormatter() {
	PhoneFormatter formatter = (PhoneFormatter) getContactFormatter(getInstance()
		.getPhoneFormatterList());
	return formatter == null ? getInstance().getDefaultPhoneFormatter()
		: formatter;
    }

    private static ContactFormatter getContactFormatter(List list) {
	Locale locale = Locale.getDefault();
	for (int i = 0; i < list.size(); i++) {
	    ContactFormatter formatter = (ContactFormatter) list.get(i);
	    if (formatter.accept(locale)) {
		return formatter;
	    }
	}
	return null;
    }

    public static void main(String[] args) {

	Address add = new Address();
	StreetType t = new StreetType();
	t.setName("st");
	add.setStreetType(t);
	add.setStreet("Malvin");
	add.setHouseNum("11");
	add.setApartNum("789");

	System.out.println(ContactFormatterFactory.getAddressFormatter().formatFullAddress(add));

	Phone phone = new Phone();
	phone.setPhoneCode("044");
	phone.setPhoneNumber("452-45-63");

	System.out.println(ContactFormatterFactory.getPhoneFormatter().format(phone));
    }

}
