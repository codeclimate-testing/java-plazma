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

import org.plazmaforge.bsolution.partner.common.beans.IPartnerTitle;
import org.plazmaforge.bsolution.partner.common.beans.PartnerHeader;
import org.plazmaforge.framework.ext.model.Dictionary;

/**
 * 
 * @author Oleh Hapon
 * $Id: Car.java,v 1.2 2010/04/28 06:22:48 ohapon Exp $
 */
public class Car extends Dictionary {
    

    private static final String CAR_NAME_SEPARATOR = "/";
	
    
    /** Partner (Owner) **/
    private IPartnerTitle partner;


    
    /** Registration number **/
    private String regNumber;
    
    /** Number of chassis **/
    private String chassisNumber;

    /** Engine Volume (cm3) **/
    private float engineVolume;
    
    
    /** Car Mark **/
    private CarMark  carMark;
    
    /** Car Model **/
    private CarModel  carModel;

    /** Car Class **/
    private CarClass carClass;
    
    
    /** Year of manufacture **/ 
    private int manufactureYear;
    
    

    public IPartnerTitle getPartner() {
        return partner;
    }

    public void setPartner(IPartnerTitle partner) {
        this.partner = partner;
    }
    
    public String getPartnerName() {
        return partner == null ? null : partner.getName();
    }
    
    public String getOwnerName() {
        return getPartnerName();
    }
    

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }
    
    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public float getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(float engineVolume) {
        this.engineVolume = engineVolume;
    }

    public CarMark getCarMark() {
        return carMark;
    }

    public void setCarMark(CarMark carMark) {
        this.carMark = carMark;
    }

    public String getCarMarkName() {
        return carMark == null ? null : carMark.getName();
    }
    
    public String getCarMarkNameTrim() {
	String str = getCarMarkName();
	return str == null ? null : str.trim();
    }
    
    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public String getCarModelName() {
        return carModel == null ? null : carModel.getName();
    }

    public CarClass getCarClass() {
        return carClass;
    }

    public void setCarClass(CarClass carClass) {
        this.carClass = carClass;
    }

    public String getCarClassName() {
        return carClass == null ? null : carClass.getName();
    }
    
    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    
    public String getName() {
	String carMarkName = getCarMarkNameTrim();
	if (carMarkName == null || carMarkName.length() == 0) {
	    return getCarModelName();
	}
	String carModelName = getCarModelName();
	if (carModelName == null) {
	    return carMarkName; 
	}
	return carMarkName + " " + CAR_NAME_SEPARATOR + " " + carModelName;
    }

}
