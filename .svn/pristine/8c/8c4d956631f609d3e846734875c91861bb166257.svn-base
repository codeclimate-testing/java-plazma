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
 * $Id: CarInsurerConsumablesPrice.java,v 1.2 2010/04/28 06:22:48 ohapon Exp $
 */
public class CarInsurerConsumablesPrice extends CarInsurerContractItem {

    private CarClass carClass;
    
    private CarPaintDetailType carPaintDetailType;
    
    private CarDamageLevel carDamageLevel;
    
    private float price;
    
    private float percent;
    
    private int valueType;

    public CarClass getCarClass() {
        return carClass;
    }

    public void setCarClass(CarClass carClass) {
        this.carClass = carClass;
    }
    
    public String getCarClassName() {
        return carClass == null ? null : carClass.getName();
    }

    
    

    public CarDamageLevel getCarDamageLevel() {
        return carDamageLevel;
    }

    public void setCarDamageLevel(CarDamageLevel carDamageLevel) {
        this.carDamageLevel = carDamageLevel;
    }
    
    public String getCarDamageLevelName() {
        return carDamageLevel == null ? null : carDamageLevel.getName();
    }

    
    

    public CarPaintDetailType getCarPaintDetailType() {
        return carPaintDetailType;
    }

    public void setCarPaintDetailType(CarPaintDetailType carPaintDetailType) {
        this.carPaintDetailType = carPaintDetailType;
    }

    public String getCarPaintDetailTypeName() {
        return carPaintDetailType == null ? null : carPaintDetailType.getName();
    }

    
    
    

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getValueType() {
        return valueType;
    }

    public void setValueType(int valueType) {
        this.valueType = valueType;
    }
    
    public boolean isBaseType() {
	if (carPaintDetailType == null) {
	    return false;
	}
	return carPaintDetailType.isBaseType();
    }
    
    public boolean isAccept(CarClass carClass, CarPaintDetailType carPaintDetailType, CarDamageLevel carDamageLevel)  {
	if (carClass == null || carPaintDetailType == null || carDamageLevel == null) {
	    return false;
	}
	if (this.carClass == null || this.carPaintDetailType == null || this.carDamageLevel == null) {
	    return false;
	}
	Integer thisClassId = this.carClass.getId();
	Integer thisTypeId = this.carPaintDetailType.getId();
	Integer thisLevelId = this.carDamageLevel.getId();
	if (thisClassId == null || thisTypeId == null || thisLevelId == null) {
	    return false;
	}
	
	return thisClassId.equals(carClass.getId()) && thisTypeId.equals(carPaintDetailType.getId()) && thisLevelId.equals(carDamageLevel.getId());
    }
}
