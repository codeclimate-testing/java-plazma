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

import org.plazmaforge.bsolution.contact.common.beans.Address;
import org.plazmaforge.bsolution.contact.common.beans.ApartmentType;
import org.plazmaforge.bsolution.contact.common.beans.City;
import org.plazmaforge.bsolution.contact.common.beans.Locality;
import org.plazmaforge.bsolution.contact.common.beans.StreetType;
import org.plazmaforge.bsolution.contact.common.beans.formatter.AddressFormatValidator;
import org.plazmaforge.bsolution.contact.common.beans.formatter.AddressFormatter;
import org.plazmaforge.framework.core.LocaleConstants;


public class ENAddressFormatter extends ENAbstractContactFormatter implements AddressFormatter {

    private AddressFormatValidator validator = new AddressFormatValidator();


    public String formatAddress(Address address) {
	if (!validator.isValid(address)) {
	    return getEmptyString();
	}
	StringBuffer buf = new StringBuffer();
	addAddress(buf, address, false);	
	
	return buf.toString();
    }
    
    public String formatFullAddress(Address address) {
	if (!validator.isValid(address)) {
	    return getEmptyString();
	}
	StringBuffer buf = new StringBuffer();
	boolean isStartString = false;
	
	isStartString = addAddress(buf, address, isStartString);	
	isStartString = addCityAndLocality(buf, address, isStartString);
	
	return buf.toString();
    }
    
    
    public String formatLocalityAddress(Address address) {
	return formatLocalityAddress(address.getLocalityTypeName(), address.getLocalityName(), address.getAddressString());
    }
    
    
    protected boolean addCityAndLocality(StringBuffer buf, Address address, boolean isStartString) {
	boolean isAdd = isStartString;

	
	String localityName = getLocalityString(address.getLocality());
	if (!isEmpty(localityName)) {
	    addString(buf, localityName, isAdd, ", ");
	    isAdd = true;
	}
	
	String cityName = getLocalityString(address.getCity());
	if (!isEmpty(cityName)) {
	    addString(buf, cityName, isAdd, ", ");
	    isAdd = true;
	}
	
	return isAdd;
    }
    
    protected boolean addLocality(StringBuffer buf, Address address, boolean isStartString) {
	boolean isAdd = isStartString;

	
	String localityName = getLocalityString(address.getLocality());
	if (!isEmpty(localityName)) {
	    addString(buf, localityName, isAdd, ", ");
	    isAdd = true;
	}
	
	return isAdd;
    }
    
    protected boolean addAddress(StringBuffer buf, Address address, boolean isStartString) {
	boolean isAdd = isStartString;
	
	// SIMPLE ADDRESS
	if (isSimpleAddressVariant(address)) {
	    String addressString = address.getAddressString();
	    if (!isEmpty(addressString)) {
		addString(buf, addressString, isAdd, ", ");
		isAdd = true;
		return isAdd;
	    }
	}
	
	// COMPLEX ADDRESS
	String houseNum = address.getHouseNum();
	if (!isEmpty(houseNum)) {
	    buf.append(address.getHouseNum());
	    isAdd = true;
	}

	String streetName = getStreetString(address.getStreetType(), address
		.getStreet());
	if (!isEmpty(streetName)) {
	    addString(buf, streetName, isAdd, ", ");
	    isAdd = true;
	}

	String apartNum = getApartmentString(address.getApartmentType(),
		address.getApartNum());
	if (!isEmpty(apartNum)) {
	    addString(buf, apartNum, isAdd, ", ");
	    isAdd = true;
	}	
	
	
	return isAdd;
    }
        

    private String getLocalityString(Locality locality) {
	if (locality == null) {
	    return EMPTY_STRING;
	}
	return getDictionaryName(locality);
    }

    private String getStreetString(StreetType streetType, String street) {
	return getTypeString(getDictionaryFullName(streetType), street, "",
		true);
    }

    private String getApartmentString(ApartmentType apartmentType,
	    String apartmentNum) {
	return getTypeString(getDictionaryName(apartmentType), apartmentNum, "");
    }

    
    
    // -----------------------------------------------------------------------------------------------------------------
    // Format methods
    // -----------------------------------------------------------------------------------------------------------------

    public String formatAddress(City city, Locality locality, StreetType streetType,
	    String street, String houseNum, String caseNum,
	    ApartmentType apartmentType, String apartNum) {

	Address address = new Address(city, locality, streetType, street, houseNum, caseNum, apartmentType, apartNum);
	return formatAddress(address);
    }
    
    public String formatFullAddress(City city, Locality locality, StreetType streetType,
	    String street, String houseNum, String caseNum,
	    ApartmentType apartmentType, String apartNum) {

	Address address = new Address(city, locality, streetType, street, houseNum, caseNum, apartmentType, apartNum);
	return formatFullAddress(address);
    }
    
  
    
    public String format(int type, City city, Locality locality, StreetType streetType,
	    String street, String houseNum, String caseNum,
	    ApartmentType apartmentType, String apartNum) {
	if (LocaleConstants.DEFAULT_ADDRES_TYPE == type) {
	    return formatAddress(city, locality, streetType, street, houseNum, caseNum, apartmentType, apartNum);
	}
	return formatFullAddress(city, locality, streetType, street, houseNum, caseNum, apartmentType, apartNum);
    }

    
    public String format(int type, Address address) {
	if (LocaleConstants.DEFAULT_ADDRES_TYPE == type) {
	    return formatAddress(address);
	}
	return formatFullAddress(address);

    }
    
    public String formatLocalityAddress(String localityTypeName, String localityName, String addressString) {
	if (isEmpty(localityName)) {
	    return addressString;
	}
	String localityString = getTypeString(localityTypeName, localityName);
	return localityString + ", " + addressString;
    }
    
}
