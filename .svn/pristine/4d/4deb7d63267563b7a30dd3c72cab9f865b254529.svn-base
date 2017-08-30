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
 * $Id: CarInsurerPaintTypePrice.java,v 1.2 2010/04/28 06:22:48 ohapon Exp $
 */
public class CarInsurerPaintTypePrice extends CarInsurerContractItem {

    private CarPaintType carPaintType;
    
    private CarPaintMark carPaintMark;
    
    private float price;

    public CarPaintMark getCarPaintMark() {
        return carPaintMark;
    }

    public void setCarPaintMark(CarPaintMark carPaintMark) {
        this.carPaintMark = carPaintMark;
    }
    
    public String getCarPaintMarkName() {
        return carPaintMark == null ? null : carPaintMark.getName();
    }
    
    

    public CarPaintType getCarPaintType() {
        return carPaintType;
    }

    public String getCarPaintTypeName() {
        return carPaintType == null ? null : carPaintType.getName();
    }

    
    public void setCarPaintType(CarPaintType carPaintType) {
        this.carPaintType = carPaintType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public boolean isAccept(CarPaintType carPaintType, CarPaintMark carPaintMark) {
	if (carPaintType == null || carPaintMark == null) {
	    return false;
	}
	
	if (this.carPaintType == null || this.carPaintMark == null) {
	    return false;
	}
	
	Integer thisTypeId = this.carPaintType.getId();
	Integer thisMarkId = this.carPaintMark.getId();
	if (thisTypeId == null || thisMarkId == null) {
	    return false;
	}
	
	return thisTypeId.equals(carPaintType.getId()) && thisMarkId.equals(carPaintMark.getId()); 
    }
    
}
