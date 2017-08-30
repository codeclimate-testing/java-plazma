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

package org.plazmaforge.bsolution.carservice.common.beans;

/**
 * 
 * @author Oleh Hapon
 * $Id: CarInsurerServPrice.java,v 1.2 2010/04/28 06:22:48 ohapon Exp $
 */
public class CarInsurerServPrice extends CarInsurerContractItem {

    private CarAge carAge;
    
    private CarServType carServType;

    private float price;

    
    public CarAge getCarAge() {
        return carAge;
    }

    public void setCarAge(CarAge carAge) {
        this.carAge = carAge;
    }

    public String getCarAgeName() {
        return carAge == null ? null : carAge.getName();
    }

    
    public CarServType getCarServType() {
        return carServType;
    }

    public void setCarServType(CarServType carServType) {
        this.carServType = carServType;
    }
    
    public String getCarServTypeName() {
        return carServType == null ? null : carServType.getName();
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isAgeInRange(int age, CarServType carServType) {
	if (this.carAge == null) {
	    return false;
	}
	boolean isRange = this.carAge.isAgeInRange(age);
	if (!isRange) {
	    return false;
	}
	
	if (this.carServType == null || carServType == null) {
	    return isRange;
	}
	Integer thisId = this.carServType.getId();
	Integer castId = carServType.getId();
	if (thisId == null && castId == null) {
	    return isRange;
	}
	if (thisId == null || castId == null) {
	    return false;
	}
	
	return thisId.equals(castId);
    }

    
}
