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
 * @author Oleh Hapon Date: 2/7/2003 Time: 12:41:21
 */
public class Address extends AbstractContactableItem implements ContactableItem {

    private String zipCode;

    private String street;

    private String houseNum;

    private String caseNum;

    private String apartNum;

    private String addressString;

    private AddressType addressType;

    private StreetType streetType;

    private Locality city;

    private Locality locality;

    private ApartmentType apartmentType;
    
    
    private String fullAddressString;
    
    private String localityAddressString;
    
    
    
    private String addressVariant;
    
    

    public Address() {
	super();
    }

    public Address(City city, Locality locality, StreetType streetType, String street, String houseNum, String caseNum, ApartmentType apartmentType, String apartNum) {
	setCity(city);
	setLocality(locality);
	setStreetType(streetType);
	setStreet(street);
	setHouseNum(houseNum);
	setCaseNum(caseNum);
	setApartmentType(apartmentType);
	setApartNum(apartNum);
    }
    
    public String getZipCode() {
	return zipCode;
    }

    public void setZipCode(String zipCode) {
	this.zipCode = zipCode;
    }

    public String getStreet() {
	return street;
    }

    public void setStreet(String street) {
	this.street = street;
    }

    public String getHouseNum() {
	return houseNum;
    }

    public void setHouseNum(String houseNum) {
	this.houseNum = houseNum;
    }

    public String getCaseNum() {
	return caseNum;
    }

    public void setCaseNum(String caseNum) {
	this.caseNum = caseNum;
    }

    public String getApartNum() {
	return apartNum;
    }

    public void setApartNum(String apartNum) {
	this.apartNum = apartNum;
    }

    public String getAddressString() {
	return addressString;
    }

    public void setAddressString(String addressString) {
	this.addressString = addressString;
    }

    public String getStreetTypeName() {
	return getStreetType() == null ? null : getStreetType().getName();
    }

    public String getLocalityName() {
	return getLocality() == null ? null : getLocality().getName();
    }
    
    public String getLocalityTypeName() {
	return getLocalityType() == null ? null : getLocalityType().getName();
    }

    public LocalityType getLocalityType() {
	return locality == null ? null : locality.getLocalityType();
    }


    public AddressType getAddressType() {
	return addressType;
    }

    public void setAddressType(AddressType addressType) {
	this.addressType = addressType;
    }

    public String getAddressTypeName() {
	return getAddressType() == null ? null : getAddressType().getName();
    }

    public StreetType getStreetType() {
	return streetType;
    }

    public void setStreetType(StreetType streetType) {
	this.streetType = streetType;
    }

    public Locality getCity() {
	return city;
    }

    public void setCity(Locality city) {
	this.city = city;
    }

    public Locality getLocality() {
	return locality;
    }
    
    

    public void setLocality(Locality localityDetails) {
	this.locality = localityDetails;
    }

    public ApartmentType getApartmentType() {
	return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
	this.apartmentType = apartmentType;
    }

    public String getFullAddressString() {
        return fullAddressString;
    }

    public void setFullAddressString(String fullAddressString) {
        this.fullAddressString = fullAddressString;
    }

    public String getAddressVariant() {
        return addressVariant;
    }

    public void setAddressVariant(String addressVariant) {
        this.addressVariant = addressVariant;
    }

    public String getLocalityAddressString() {
        return localityAddressString;
    }

    public void setLocalityAddressString(String localityAddressString) {
        this.localityAddressString = localityAddressString;
    }

    
    
}
