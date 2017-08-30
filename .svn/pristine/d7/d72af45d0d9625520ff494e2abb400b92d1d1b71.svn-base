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

import org.plazmaforge.bsolution.base.common.beans.Country;
import org.plazmaforge.framework.ext.model.Dictionary;

/**
 * @author Oleh Hapon Date: 08.10.2003 Time: 17:15:43
 */
public class Locality extends Dictionary {

    public static final String CLASS_ID = "LOCALITY";

    private LocalityType localityType;

    private Country country;

    private Region region;

    private District district;

    public Locality() {

    }

    public Locality(Integer id) {
	this.setId(id);
    }

    public Region getRegion() {
	return region;
    }

    public void setRegion(Region region) {
	this.region = region;
    }

    public String getRegionName() {
	return getRegion() == null ? null : getRegion().getName();
    }

    public Country getCountry() {
	return country;
    }

    public void setCountry(Country country) {
	this.country = country;
    }

    public String getCountryName() {
	return getCountry() == null ? null : getCountry().getName();
    }

    public LocalityType getLocalityType() {
	return localityType;
    }

    public void setLocalityType(LocalityType localityType) {
	this.localityType = localityType;
    }

    public String getLocalityTypeName() {
	return getLocalityType() == null ? null : getLocalityType().getName();
    }

    public String getLocalityTypeFullName() {
	return getLocalityType() == null ? null : getLocalityType().getFullName();
    }

    public District getDistrict() {
	return district;
    }

    public void setDistrict(District rayon) {
	this.district = rayon;
    }

    public String getDistrictName() {
	return getDistrict() == null ? null : getDistrict().getName();
    }

}
