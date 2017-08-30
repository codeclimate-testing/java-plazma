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

import org.plazmaforge.bsolution.contact.common.beans.Address;
import org.plazmaforge.bsolution.contact.common.beans.ApartmentType;
import org.plazmaforge.bsolution.contact.common.beans.City;
import org.plazmaforge.bsolution.contact.common.beans.Locality;
import org.plazmaforge.bsolution.contact.common.beans.StreetType;

/**
 * Address formatter interface
 * 
 * @author hapon
 * 
 */
public interface AddressFormatter extends ContactFormatter {

     
    
    /**
     * Format address string
     * 
     * @param address
     * @return
     */
    String formatAddress(Address address);
    
    String formatFullAddress(Address address);
    
    String formatLocalityAddress(Address address);
    
    String format(int type, Address address);
    
    

    /**
     * Format addres string by parameters
     * 
     * @param city
     * @param locality
     * @param streetType
     * @param street
     * @param houseNum
     * @param caseNum
     * @param apartNum
     * @return
     */
    String formatAddress(City city, Locality locality, StreetType streetType,
	    String street, String houseNum, String caseNum,
	    ApartmentType apartmentType, String apartNum);
    
    String formatFullAddress(City city, Locality locality, StreetType streetType,
	    String street, String houseNum, String caseNum,
	    ApartmentType apartmentType, String apartNum);
    
    String formatLocalityAddress(String localityTypeName, String localityName, String addressString);
    
    String format(int type, City city, Locality locality, StreetType streetType,
	    String street, String houseNum, String caseNum,
	    ApartmentType apartmentType, String apartNum);
    
    
    
    boolean isSimpleAddressVariant(Address address);
    
    boolean isComplexAddressVariant(Address address);
}
