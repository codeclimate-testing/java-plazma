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
package org.plazmaforge.bs.contact.shared.entities;

import org.plazmaforge.bs.base.shared.entities.Country;
import org.plazmaforge.framework.ext.model.Dictionary;


/**
 * 
 * @author ohapon
 *
 */
public class Locality extends Dictionary {

    private static final long serialVersionUID = -3688073807908469913L;
    

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
	return region == null ? null : region.getName();
    }

    public Country getCountry() {
	return country;
    }

    public void setCountry(Country country) {
	this.country = country;
    }

    public String getCountryName() {
	return country == null ? null : country.getName();
    }

    public LocalityType getLocalityType() {
	return localityType;
    }

    public void setLocalityType(LocalityType localityType) {
	this.localityType = localityType;
    }

    public String getLocalityTypeName() {
	return localityType == null ? null : localityType.getName();
    }

    public String getLocalityTypeFullName() {
	return localityType == null ? null : localityType.getFullName();
    }

    public District getDistrict() {
	return district;
    }

    public void setDistrict(District district) {
	this.district = district;
    }

    public String getDistrictName() {
	return district == null ? null : district.getName();
    }

}
